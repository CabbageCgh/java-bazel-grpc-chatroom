package com.example.chatroom;

import com.example.chatroom.grpc.proto.ClientInfo;
import io.grpc.stub.StreamObserver;

import java.util.Collection;

public interface IClientCache<T> {

    void registerToServer(ClientInfo clientInfo, StreamObserver<T> observer);

    StreamObserver<T> getObserver(String clientId);

    Collection<StreamObserver<T>> getObservers();
}
