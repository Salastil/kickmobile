package com.amazonaws.ivs.net;

/* JADX INFO: loaded from: classes5.dex */
class NativeResponseCallback implements ResponseCallback {
    private final long ptr;

    private native void onError(long j, Exception exc);

    private native void onResponse(long j, Response response);

    public NativeResponseCallback(long j) {
        this.ptr = j;
    }

    @Override // com.amazonaws.ivs.net.ResponseCallback
    public void onResponse(Response response) {
        onResponse(this.ptr, response);
    }

    @Override // com.amazonaws.ivs.net.ResponseCallback
    public void onError(Exception exc) {
        onError(this.ptr, exc);
    }
}
