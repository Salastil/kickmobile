package com.amazonaws.ivs.net;

/* JADX INFO: loaded from: classes5.dex */
public interface ResponseCallback {
    void onError(Exception exc);

    void onResponse(Response response);
}
