package Slaughterhouse;

import Slaughterhouse.Service.SlaughterhouseService;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class gRPCServer {
    public static void main(String[] args) throws IOException {
        io.grpc.Server server = ServerBuilder
                .forPort(9090)
                .addService(new SlaughterhouseService())
                .build();

        server.start();
        System.out.println("Server started");

        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            System.err.println("Server interrupted: " + e.getMessage());
        }
    }
}
