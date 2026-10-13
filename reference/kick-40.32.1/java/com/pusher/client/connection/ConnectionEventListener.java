package com.pusher.client.connection;

/* JADX INFO: loaded from: classes8.dex */
public interface ConnectionEventListener {
    void onConnectionStateChange(ConnectionStateChange connectionStateChange);

    void onError(String str, String str2, Exception exc);
}
