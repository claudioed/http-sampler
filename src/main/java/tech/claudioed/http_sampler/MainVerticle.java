package tech.claudioed.http_sampler;

import api.analytics.ingester.Ingester.ApiCall;
import api.analytics.ingester.Ingester.ApiCall.Builder;
import api.analytics.ingester.Ingester.Header;
import api.analytics.ingester.VertxCollectGrpc;
import api.analytics.ingester.VertxCollectGrpc.CollectVertxStub;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import io.grpc.ManagedChannel;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.healthchecks.HealthCheckHandler;
import io.vertx.ext.web.Router;
import io.vertx.grpc.VertxChannelBuilder;
import io.vertx.micrometer.PrometheusScrapingHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class MainVerticle extends AbstractVerticle {

  List<String> regions = new ArrayList<>(){{
    add("us-east-1");
    add("us-east-2");
    add("us-west-1");
    add("us-west-2");
    add("ca-central-1");
    add("eu-west-1");
    add("eu-central-1");
    add("eu-west-2");
    add("eu-west-3");
    add("eu-north-1");
    add("sa-east-1");
  }};

  List<String> zones = new ArrayList<>(){{
    add("us-east-1a");
    add("us-east-1b");
    add("us-west-2a");
    add("us-west-2b");
    add("us-west-2c");
    add("us-west-1a");
    add("us-west-1b");
    add("sa-east-1a");
    add("sa-east-2a");
    add("sa-east-2c");
  }};

  List<String> status = new ArrayList<>(){{
    add("200");
    add("201");
    add("204");
    add("400");
    add("401");
    add("403");
    add("404");
    add("500");
    add("501");
    add("503");
  }};

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    String ingesterUrl = System.getenv("INGESTER_URL");

    if (ingesterUrl == null || "".equalsIgnoreCase(ingesterUrl)){
      ingesterUrl = "localhost";
    }

    ManagedChannel channel = VertxChannelBuilder
      .forAddress(vertx, ingesterUrl, Integer.parseInt(System.getenv("INGESTER_PORT")))
      .usePlaintext()
      .build();

    System.out.println("Ingester URL " + ingesterUrl);

    CollectVertxStub collectVertxStub = VertxCollectGrpc.newVertxStub(channel);

    HttpServer server = vertx.createHttpServer();

    HealthCheckHandler healthCheckHandler = HealthCheckHandler.create(vertx);

    Router router = Router.router(vertx);

    router.get("/health").handler(healthCheckHandler);
    router.route("/metrics").handler(PrometheusScrapingHandler.create());
    router.get("/trace").handler(ctx -> {

      Faker faker = new Faker();

      Builder apiBuilder = ApiCall.newBuilder();

      apiBuilder.setStartTime(Timestamp.newBuilder().build());

      apiBuilder.setTenantId(faker.pokemon().name());

      Map<String, Value> requestBody  = new HashMap<>() {{
        Name name = faker.name();
        put("firstName", Value.newBuilder().setStringValue(name.firstName()).build());
        put("lastName", Value.newBuilder().setStringValue(name.lastName()).build());
        put("fullName", Value.newBuilder().setStringValue(name.fullName()).build());
      }};

      Map<String, Value> metadata  = new HashMap<>() {{
        put("application", Value.newBuilder().setStringValue(faker.app().name()).build());
      }};

      apiBuilder.setRequestBody(Struct.newBuilder().putAllFields(requestBody));
      apiBuilder.setMetadata(Struct.newBuilder().putAllFields(metadata));
      apiBuilder.setZone(this.zones.get(ThreadLocalRandom.current().nextInt(this.zones.size()) % this.zones.size()));
      apiBuilder.setRegion(this.regions.get(ThreadLocalRandom.current().nextInt(this.regions.size()) % this.regions.size()));
      apiBuilder.addTags(faker.hipster().word());

      ctx.request().headers().entries().forEach(element -> {
        apiBuilder.addRequestHeaders(Header.newBuilder().setHeader(element.getKey()).setValue(element.getValue()).build());
      });

      ctx.request().headers().add("application","http-sampler");
      ctx.request().headers().add("country",faker.country().name());

      ctx.request().headers().entries().forEach(element -> {
        apiBuilder.addResponseHeaders(Header.newBuilder().setHeader(element.getKey()).setValue(element.getValue()).build());
      });

      apiBuilder.setApi(faker.commerce().department()).setPath(ctx.request().path())
        .setResponseCode(this.status.get(ThreadLocalRandom.current().nextInt(this.status.size()) % this.status.size())).build();

      apiBuilder.setEndTime(Timestamp.newBuilder().build());

      collectVertxStub.compute(apiBuilder.build()).onSuccess(handler ->{
        ctx.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!");
      }).onFailure(handler ->{
        System.err.println(handler.getCause());
      });
    });

    server.requestHandler(router).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });

  }
}
