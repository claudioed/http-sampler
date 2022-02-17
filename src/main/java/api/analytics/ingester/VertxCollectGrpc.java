package api.analytics.ingester;

import static api.analytics.ingester.CollectGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by VertxGrpc generator",
comments = "Source: ingester.proto")
public final class VertxCollectGrpc {
    private VertxCollectGrpc() {}

    public static CollectVertxStub newVertxStub(io.grpc.Channel channel) {
        return new CollectVertxStub(channel);
    }

    
    public static final class CollectVertxStub extends io.grpc.stub.AbstractStub<CollectVertxStub> {
        private final io.vertx.core.impl.ContextInternal ctx;
        private CollectGrpc.CollectStub delegateStub;

        private CollectVertxStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = CollectGrpc.newStub(channel);
            this.ctx = (io.vertx.core.impl.ContextInternal) io.vertx.core.Vertx.currentContext();
        }

        private CollectVertxStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = CollectGrpc.newStub(channel).build(channel, callOptions);
            this.ctx = (io.vertx.core.impl.ContextInternal) io.vertx.core.Vertx.currentContext();
        }

        @Override
        protected CollectVertxStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CollectVertxStub(channel, callOptions);
        }

        
        public io.vertx.core.Future<api.analytics.ingester.Ingester.DataCollected> compute(api.analytics.ingester.Ingester.ApiCall request) {
            return io.vertx.grpc.stub.ClientCalls.oneToOne(ctx, request, delegateStub::compute);
        }

    }

    
    public static abstract class CollectVertxImplBase implements io.grpc.BindableService {
        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public CollectVertxImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        
        public io.vertx.core.Future<api.analytics.ingester.Ingester.DataCollected> compute(api.analytics.ingester.Ingester.ApiCall request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            api.analytics.ingester.CollectGrpc.getComputeMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            api.analytics.ingester.Ingester.ApiCall,
                                            api.analytics.ingester.Ingester.DataCollected>(
                                            this, METHODID_COMPUTE, compression)))
                    .build();
        }
    }

    private static final int METHODID_COMPUTE = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final CollectVertxImplBase serviceImpl;
        private final int methodId;
        private final String compression;

        MethodHandlers(CollectVertxImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_COMPUTE:
                    io.vertx.grpc.stub.ServerCalls.oneToOne(
                            (api.analytics.ingester.Ingester.ApiCall) request,
                            (io.grpc.stub.StreamObserver<api.analytics.ingester.Ingester.DataCollected>) responseObserver,
                            compression,
                            serviceImpl::compute);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
