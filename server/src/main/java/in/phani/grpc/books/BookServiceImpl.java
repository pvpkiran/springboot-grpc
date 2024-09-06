package in.phani.grpc.books;

import in.phani.grpc.book.BookManagementServiceGrpc;
import in.phani.grpc.book.UserDetails;
import in.phani.grpc.book.UserRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@GrpcService
public class BookServiceImpl extends BookManagementServiceGrpc.BookManagementServiceImplBase {
    @Override
    public void getUsersWithBookDetails(UserRequest request, StreamObserver<UserDetails> responseObserver) {
        UserDetails userDetails = UserDetails.newBuilder()
                .setIsMember(true)
                .setRegistrationId(UUID.randomUUID().toString())
                .addAllBooksBorrowed(List.of("Naayi Neralu", "GruhaBanga", "Aavarana"))
                .putAllBooks(Map.of("Naayi Neralu", "01-01.2024","GruhaBanga", "11-06.2024", "Aavarana", "29-10.2024"))
                .build();
        responseObserver.onNext(userDetails);
        responseObserver.onCompleted();
    }
}
