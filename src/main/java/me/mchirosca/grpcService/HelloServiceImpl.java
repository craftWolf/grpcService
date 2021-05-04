package me.mchirosca.grpcService;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(
            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {


        String responseString = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .append(" ")
                .append(request.getEmail())
                .append(" ")
                .append(request.getAddress())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setSuccess(true)
                .setMessage(responseString)
                .build();

        System.out.println("HERE ****************** " + responseString);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
