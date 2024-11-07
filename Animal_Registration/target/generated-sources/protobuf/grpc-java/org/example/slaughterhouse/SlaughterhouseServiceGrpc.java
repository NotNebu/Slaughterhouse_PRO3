package org.example.slaughterhouse;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: SlaugterhouseServiceProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SlaughterhouseServiceGrpc {

  private SlaughterhouseServiceGrpc() {}

  public static final String SERVICE_NAME = "SlaughterhouseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.slaughterhouse.SlaughterServiceProto.ProductRequest,
      org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse> getGetAnimalsForProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnimalsForProduct",
      requestType = org.example.slaughterhouse.SlaughterServiceProto.ProductRequest.class,
      responseType = org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.slaughterhouse.SlaughterServiceProto.ProductRequest,
      org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse> getGetAnimalsForProductMethod() {
    io.grpc.MethodDescriptor<org.example.slaughterhouse.SlaughterServiceProto.ProductRequest, org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse> getGetAnimalsForProductMethod;
    if ((getGetAnimalsForProductMethod = SlaughterhouseServiceGrpc.getGetAnimalsForProductMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetAnimalsForProductMethod = SlaughterhouseServiceGrpc.getGetAnimalsForProductMethod) == null) {
          SlaughterhouseServiceGrpc.getGetAnimalsForProductMethod = getGetAnimalsForProductMethod =
              io.grpc.MethodDescriptor.<org.example.slaughterhouse.SlaughterServiceProto.ProductRequest, org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnimalsForProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.slaughterhouse.SlaughterServiceProto.ProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("GetAnimalsForProduct"))
              .build();
        }
      }
    }
    return getGetAnimalsForProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest,
      org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse> getGetProductsForAnimalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProductsForAnimal",
      requestType = org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest.class,
      responseType = org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest,
      org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse> getGetProductsForAnimalMethod() {
    io.grpc.MethodDescriptor<org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest, org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse> getGetProductsForAnimalMethod;
    if ((getGetProductsForAnimalMethod = SlaughterhouseServiceGrpc.getGetProductsForAnimalMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetProductsForAnimalMethod = SlaughterhouseServiceGrpc.getGetProductsForAnimalMethod) == null) {
          SlaughterhouseServiceGrpc.getGetProductsForAnimalMethod = getGetProductsForAnimalMethod =
              io.grpc.MethodDescriptor.<org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest, org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProductsForAnimal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("GetProductsForAnimal"))
              .build();
        }
      }
    }
    return getGetProductsForAnimalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SlaughterhouseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub>() {
        @java.lang.Override
        public SlaughterhouseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SlaughterhouseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub>() {
        @java.lang.Override
        public SlaughterhouseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceBlockingStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SlaughterhouseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub>() {
        @java.lang.Override
        public SlaughterhouseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceFutureStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SlaughterhouseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAnimalsForProduct(org.example.slaughterhouse.SlaughterServiceProto.ProductRequest request,
        io.grpc.stub.StreamObserver<org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalsForProductMethod(), responseObserver);
    }

    /**
     */
    public void getProductsForAnimal(org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest request,
        io.grpc.stub.StreamObserver<org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductsForAnimalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAnimalsForProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.slaughterhouse.SlaughterServiceProto.ProductRequest,
                org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse>(
                  this, METHODID_GET_ANIMALS_FOR_PRODUCT)))
          .addMethod(
            getGetProductsForAnimalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest,
                org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse>(
                  this, METHODID_GET_PRODUCTS_FOR_ANIMAL)))
          .build();
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceStub extends io.grpc.stub.AbstractAsyncStub<SlaughterhouseServiceStub> {
    private SlaughterhouseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAnimalsForProduct(org.example.slaughterhouse.SlaughterServiceProto.ProductRequest request,
        io.grpc.stub.StreamObserver<org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnimalsForProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProductsForAnimal(org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest request,
        io.grpc.stub.StreamObserver<org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductsForAnimalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SlaughterhouseServiceBlockingStub> {
    private SlaughterhouseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse getAnimalsForProduct(org.example.slaughterhouse.SlaughterServiceProto.ProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnimalsForProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse getProductsForAnimal(org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductsForAnimalMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SlaughterhouseServiceFutureStub> {
    private SlaughterhouseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse> getAnimalsForProduct(
        org.example.slaughterhouse.SlaughterServiceProto.ProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnimalsForProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse> getProductsForAnimal(
        org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductsForAnimalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ANIMALS_FOR_PRODUCT = 0;
  private static final int METHODID_GET_PRODUCTS_FOR_ANIMAL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SlaughterhouseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SlaughterhouseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANIMALS_FOR_PRODUCT:
          serviceImpl.getAnimalsForProduct((org.example.slaughterhouse.SlaughterServiceProto.ProductRequest) request,
              (io.grpc.stub.StreamObserver<org.example.slaughterhouse.SlaughterServiceProto.AnimalListResponse>) responseObserver);
          break;
        case METHODID_GET_PRODUCTS_FOR_ANIMAL:
          serviceImpl.getProductsForAnimal((org.example.slaughterhouse.SlaughterServiceProto.AnimalRequest) request,
              (io.grpc.stub.StreamObserver<org.example.slaughterhouse.SlaughterServiceProto.ProductListResponse>) responseObserver);
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

  private static abstract class SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SlaughterhouseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.slaughterhouse.SlaughterServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SlaughterhouseService");
    }
  }

  private static final class SlaughterhouseServiceFileDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier {
    SlaughterhouseServiceFileDescriptorSupplier() {}
  }

  private static final class SlaughterhouseServiceMethodDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SlaughterhouseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SlaughterhouseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SlaughterhouseServiceFileDescriptorSupplier())
              .addMethod(getGetAnimalsForProductMethod())
              .addMethod(getGetProductsForAnimalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
