package in.phani.grpc;

import in.phani.grpc.hello.HelloRequest;
import in.phani.grpc.hello.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrpcClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Bean
    ApplicationRunner clientRunner(@GrpcClient("helloService")HelloServiceGrpc.HelloServiceBlockingStub stub) {
        return args -> System.out.println(stub.sayHello(HelloRequest.newBuilder()
                .setAge(12)
                .setName("Phani")
                .build()));
    }
}
