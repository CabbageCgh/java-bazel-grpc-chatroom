package com.example.chatroom;

import com.example.chatroom.grpc.proto.Message;
import io.grpc.stub.StreamObserver;

import java.util.Collection;

public class PushToClientUtil {

    public volatile static IClientCache<Message> clientCache = new DefaultClientCache<>();

    public static void pushMessage(Message msg) {
        Collection<StreamObserver<Message>> observers = clientCache.getObservers();

        observers.forEach(observer -> {
            observer.onNext(msg);
        });
    }

}
