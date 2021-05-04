package me.mchirosca.grpcService;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellMethod;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    UserRepository userRepository;

    @Override
    public void add(
            UserRequest request, StreamObserver<UserResponse> responseObserver) {

        UserEntity savedUser = this.userRepository.save(new UserEntity(request.getEmail(),request.getFirstName(), request.getLastName(),request.getAddress()));

        String responseString = new StringBuilder()
                .append("Hello, ")
                .append(savedUser.getFirstName())
                .append(" ")
                .append(savedUser.getLastName())
                .append(" ")
                .append(savedUser.getEmail())
                .append(" ")
                .append(savedUser.getAddress())
                .toString();

        UserResponse response = UserResponse.newBuilder()
                .setSuccess(true)
                .setMessage(responseString)
                .build();

        System.out.println("HERE ****************** " + responseString);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
