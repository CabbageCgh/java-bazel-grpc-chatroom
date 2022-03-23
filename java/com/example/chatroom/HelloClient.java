package com.example.chatroom;

import com.example.chatroom.grpc.proto.ChatServiceGrpc;
import com.example.chatroom.grpc.proto.ClientInfo;
import com.example.chatroom.grpc.proto.ErrorInfo;
import com.example.chatroom.grpc.proto.Message;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class HelloClient {

    public static void main(String[] args) throws IOException {

        String id = UUID.randomUUID().toString();
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 5000)
                .usePlaintext()
                .build();

        ChatServiceGrpc.ChatServiceStub stub = ChatServiceGrpc.newStub(managedChannel);
        ClientInfo clientInfo = ClientInfo.newBuilder().setClientId(id).build();
        stub.register(clientInfo, new StreamObserver<Message>() {
            @Override
            public void onNext(Message msg) {
                System.out.println(msg.getContent());
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        });

        ChatServiceGrpc.ChatServiceBlockingStub stubBlocking = ChatServiceGrpc.newBlockingStub(managedChannel);
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputArray = reader.readLine();

            Message msg = Message.newBuilder()
                    .setClientId(id)
                    .setContent(inputArray)
                    .build();

            ErrorInfo errorInfo = stubBlocking.send(msg);
            if (!errorInfo.getSuccessful()) {
                System.out.println("error :" + errorInfo.getMessage());
            }
        }
    }

}
