package com.amazonaws.ivs.net;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpClient {
    String description();

    void execute(Request request, ResponseCallback responseCallback);

    void release();
}
