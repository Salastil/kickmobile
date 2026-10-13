package com.amazonaws.ivs.net;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
class NativeWriteCallback implements WriteCallback {
    private final long ptr;

    private native void onBuffer(long j, ByteBuffer byteBuffer, int i);

    public NativeWriteCallback(long j) {
        this.ptr = j;
    }

    @Override // com.amazonaws.ivs.net.WriteCallback
    public void onBuffer(ByteBuffer byteBuffer, int i) {
        onBuffer(this.ptr, byteBuffer, i);
    }

    @Override // com.amazonaws.ivs.net.WriteCallback
    public void onError(Exception exc) {
        exc.printStackTrace();
    }
}
