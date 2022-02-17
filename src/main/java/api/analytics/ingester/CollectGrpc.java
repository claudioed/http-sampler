package api.analytics.ingester;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.2)",
    comments = "Source: ingester.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CollectGrpc {

  private CollectGrpc() {}

  public static final String SERVICE_NAME = "api.analytics.ingester.Collect";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<api.analytics.ingester.Ingester.ApiCall,
      api.analytics.ingester.Ingester.DataCollected> getComputeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Compute",
      requestType = api.analytics.ingester.Ingester.ApiCall.class,
      responseType = api.analytics.ingester.Ingester.DataCollected.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<api.analytics.ingester.Ingester.ApiCall,
      api.analytics.ingester.Ingester.DataCollected> getComputeMethod() {
    io.grpc.MethodDescriptor<api.analytics.ingester.Ingester.ApiCall, api.analytics.ingester.Ingester.DataCollected> getComputeMethod;
    if ((getComputeMethod = CollectGrpc.getComputeMethod) == null) {
      synchronized (CollectGrpc.class) {
        if ((getComputeMethod = CollectGrpc.getComputeMethod) == null) {
          CollectGrpc.getComputeMethod = getComputeMethod =
              io.grpc.MethodDescriptor.<api.analytics.ingester.Ingester.ApiCall, api.analytics.ingester.Ingester.DataCollected>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Compute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  api.analytics.ingester.Ingester.ApiCall.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  api.analytics.ingester.Ingester.DataCollected.getDefaultInstance()))
              .setSchemaDescriptor(new CollectMethodDescriptorSupplier("Compute"))
              .build();
        }
      }
    }
    return getComputeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CollectStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CollectStub>() {
        @java.lang.Override
        public CollectStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CollectStub(channel, callOptions);
        }
      };
    return CollectStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CollectBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CollectBlockingStub>() {
        @java.lang.Override
        public CollectBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CollectBlockingStub(channel, callOptions);
        }
      };
    return CollectBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CollectFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CollectFutureStub>() {
        @java.lang.Override
        public CollectFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CollectFutureStub(channel, callOptions);
        }
      };
    return CollectFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CollectImplBase implements io.grpc.BindableService {

    /**
     */
    public void compute(api.analytics.ingester.Ingester.ApiCall request,
        io.grpc.stub.StreamObserver<api.analytics.ingester.Ingester.DataCollected> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComputeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getComputeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                api.analytics.ingester.Ingester.ApiCall,
                api.analytics.ingester.Ingester.DataCollected>(
                  this, METHODID_COMPUTE)))
          .build();
    }
  }

  /**
   */
  public static final class CollectStub extends io.grpc.stub.AbstractAsyncStub<CollectStub> {
    private CollectStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectStub(channel, callOptions);
    }

    /**
     */
    public void compute(api.analytics.ingester.Ingester.ApiCall request,
        io.grpc.stub.StreamObserver<api.analytics.ingester.Ingester.DataCollected> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CollectBlockingStub extends io.grpc.stub.AbstractBlockingStub<CollectBlockingStub> {
    private CollectBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectBlockingStub(channel, callOptions);
    }

    /**
     */
    public api.analytics.ingester.Ingester.DataCollected compute(api.analytics.ingester.Ingester.ApiCall request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CollectFutureStub extends io.grpc.stub.AbstractFutureStub<CollectFutureStub> {
    private CollectFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<api.analytics.ingester.Ingester.DataCollected> compute(
        api.analytics.ingester.Ingester.ApiCall request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPUTE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CollectImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CollectImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPUTE:
          serviceImpl.compute((api.analytics.ingester.Ingester.ApiCall) request,
              (io.grpc.stub.StreamObserver<api.analytics.ingester.Ingester.DataCollected>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CollectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CollectBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return api.analytics.ingester.Ingester.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Collect");
    }
  }

  private static final class CollectFileDescriptorSupplier
      extends CollectBaseDescriptorSupplier {
    CollectFileDescriptorSupplier() {}
  }

  private static final class CollectMethodDescriptorSupplier
      extends CollectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CollectMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CollectGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CollectFileDescriptorSupplier())
              .addMethod(getComputeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
