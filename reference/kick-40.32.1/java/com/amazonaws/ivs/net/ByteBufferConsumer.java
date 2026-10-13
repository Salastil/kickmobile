package com.amazonaws.ivs.net;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
class ByteBufferConsumer implements StreamConsumer {
    public static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Provider provider;
    private final Request request;

    interface Provider {
        int writeTo(ByteBuffer byteBuffer) throws IOException;
    }

    public ByteBufferConsumer(Request request, Provider provider) {
        this.request = request;
        this.provider = provider;
    }

    @Override // com.amazonaws.ivs.net.StreamConsumer
    public void consume(ReadCallback readCallback) {
        synchronized (this.request.lock()) {
            if (this.request.isCancelled()) {
                return;
            }
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(16384);
            boolean z = false;
            while (!z) {
                try {
                    byteBufferAllocateDirect.clear();
                    z = this.provider.writeTo(byteBufferAllocateDirect) == -1;
                    byteBufferAllocateDirect.flip();
                    synchronized (this.request.lock()) {
                        if (this.request.isCancelled()) {
                            return;
                        } else {
                            readCallback.onData(byteBufferAllocateDirect, z);
                        }
                    }
                } catch (IOException e) {
                    synchronized (this.request.lock()) {
                        if (!this.request.isCancelled()) {
                            readCallback.onError(e);
                        }
                        return;
                    }
                }
            }
        }
    }
}
