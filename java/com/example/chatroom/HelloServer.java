package com.example.chatroom;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class HelloServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(5000)
                .addService(new ChatServiceImpl())
                .build()
                .start();

        server.awaitTermination();
    }
}
