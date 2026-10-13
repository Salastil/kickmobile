package com.amazonaws.ivs.net;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
interface WriteCallback {
    void onBuffer(ByteBuffer byteBuffer, int i);

    void onError(Exception exc);
}
