package com.amazonaws.ivs.net;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
interface ReadCallback {
    int getTimeout();

    void onData(ByteBuffer byteBuffer, boolean z);

    void onData(byte[] bArr, int i, boolean z);

    void onError(Exception exc);
}
