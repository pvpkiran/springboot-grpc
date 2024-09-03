package in.phani.grpc.hello;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String response = "Hello " + request.getName() + ". You are " + request.getAge() + " years old.";
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(response)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
