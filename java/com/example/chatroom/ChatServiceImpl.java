package com.example.chatroom;

import com.example.chatroom.grpc.proto.ChatServiceGrpc;
import com.example.chatroom.grpc.proto.ClientInfo;
import com.example.chatroom.grpc.proto.ErrorInfo;
import com.example.chatroom.grpc.proto.Message;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    @Override
    public void register(ClientInfo request, StreamObserver<Message> responseObserver) {
        PushToClientUtil.clientCache.registerToServer(request, responseObserver);
    }

    @Override
    public void send(Message request, StreamObserver<ErrorInfo> responseObserver) {

        String contentLine = request.getClientId() + " say: " + request.getContent();

        Message msg = Message.newBuilder()
                .setContent(contentLine)
                .build();
        PushToClientUtil.pushMessage(msg);

        responseObserver.onNext(ErrorInfo.newBuilder().setSuccessful(true).build());
        responseObserver.onCompleted();
    }


    //
//    @Override
//    public void send(ChatRequest request, StreamObserver<ChatResponse> responseObserver) {
//
//        String contentLine = request.getName() + " say: " + request.getContent();
//
//        ChatResponse chatResponse = ChatResponse.newBuilder()
//                .setContent(contentLine)
//                .build();
//
//        responseObserver.onNext(chatResponse);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public StreamObserver<ChatStreamRequest> sendToClient(StreamObserver<ChatStreamResponse> responseObserver) {
//
//        return new StreamObserver<ChatStreamRequest>() {
//            @Override
//            public void onNext(ChatStreamRequest chatStreamRequest) {
//                chatStreamRequest.getContent();
//
//                ChatStreamResponse chatStreamResponse = ChatStreamResponse.newBuilder()
//                        .setContent(chatStreamRequest.getContent())
//                        .build();
//                responseObserver.onNext(chatStreamResponse);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {}
//
//            @Override
//            public void onCompleted() {}
//        };
//    }
}
