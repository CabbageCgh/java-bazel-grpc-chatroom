package com.example.chatroom;

import com.example.chatroom.grpc.proto.ClientInfo;
import io.grpc.stub.StreamObserver;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultClientCache<T> implements IClientCache<T> {

    private final ConcurrentHashMap<String, StreamObserver<T>> cache = new ConcurrentHashMap<>();

    @Override
    public void registerToServer(ClientInfo clientInfo, StreamObserver<T> observer) {
        cache.put(clientInfo.getClientId(), observer);
        System.out.println("clientId=" + clientInfo.getClientId() + " Already registered.");
    }

    @Override
    public StreamObserver<T> getObserver(String clientId) {
        return cache.get(clientId);
    }

    @Override
    public Collection<StreamObserver<T>> getObservers() {
        return cache.values();
    }
}
