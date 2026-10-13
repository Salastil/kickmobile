package com.pusher.client.connection.impl;

import com.pusher.client.connection.Connection;

/* JADX INFO: loaded from: classes8.dex */
public interface InternalConnection extends Connection {
    void disconnect();

    void sendMessage(String str);
}
