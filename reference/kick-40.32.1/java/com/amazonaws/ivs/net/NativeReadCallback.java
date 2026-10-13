package com.amazonaws.ivs.net;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
class NativeReadCallback implements ReadCallback {
    private final long ptr;

    private native int getTimeout(long j);

    private native void onDataArray(long j, byte[] bArr, int i, boolean z);

    private native void onDataBuffer(long j, ByteBuffer byteBuffer, int i, boolean z);

    private native void onError(long j, Exception exc);

    public NativeReadCallback(long j) {
        this.ptr = j;
    }

    @Override // com.amazonaws.ivs.net.ReadCallback
    public void onData(ByteBuffer byteBuffer, boolean z) {
        onDataBuffer(this.ptr, byteBuffer, byteBuffer.remaining(), z);
    }

    @Override // com.amazonaws.ivs.net.ReadCallback
    public void onData(byte[] bArr, int i, boolean z) {
        onDataArray(this.ptr, bArr, i, z);
    }

    @Override // com.amazonaws.ivs.net.ReadCallback
    public void onError(Exception exc) {
        onError(this.ptr, exc);
    }

    @Override // com.amazonaws.ivs.net.ReadCallback
    public int getTimeout() {
        return getTimeout(this.ptr);
    }
}
