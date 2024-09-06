package in.phani.client;

import in.phani.grpc.book.BookManagementServiceGrpc;
import in.phani.grpc.book.UserRequest;
import in.phani.grpc.hello.HelloRequest;
import in.phani.grpc.hello.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GrpcClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Bean
    ApplicationRunner clientRunner(
            @GrpcClient("helloService") HelloServiceGrpc.HelloServiceBlockingStub helloStub,
            @GrpcClient("bookService") BookManagementServiceGrpc.BookManagementServiceBlockingStub booksStub
    ) {
        return args ->  {
            System.out.println(
                    helloStub.sayHello(HelloRequest.newBuilder()
                            .setAge(12)
                            .setName("Batman")
                            .build()));

            System.out.println(booksStub.getUsersWithBookDetails(UserRequest.newBuilder()
                            .addAllIds(List.of(1, 2, 3))
                    .build()));
        };
    }
}
