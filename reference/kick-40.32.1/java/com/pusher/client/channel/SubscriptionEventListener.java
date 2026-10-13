package com.pusher.client.channel;

/* JADX INFO: loaded from: classes8.dex */
public interface SubscriptionEventListener {
    default void onError(String str, Exception exc) {
    }

    void onEvent(PusherEvent pusherEvent);
}
