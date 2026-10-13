package com.amazonaws.ivs.net;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
class InputStreamConsumer implements StreamConsumer {
    public static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Provider provider;
    private final Request request;

    interface Provider {
        InputStream getInputStream(int i) throws IOException;
    }

    InputStreamConsumer(Request request, Provider provider) {
        this.request = request;
        this.provider = provider;
    }

    @Override // com.amazonaws.ivs.net.StreamConsumer
    public void consume(ReadCallback readCallback) {
        synchronized (this.request.lock()) {
            if (this.request.isCancelled()) {
                return;
            }
            int timeout = readCallback.getTimeout();
            try {
                InputStream inputStream = this.provider.getInputStream(timeout);
                try {
                    byte[] bArr = new byte[16384];
                    boolean z = false;
                    while (!z && !this.request.isCancelled()) {
                        int i = inputStream.read(bArr);
                        int iMax = Math.max(0, i);
                        z = i == -1;
                        synchronized (this.request.lock()) {
                            try {
                                if (!this.request.isCancelled()) {
                                    readCallback.onData(bArr, iMax, z);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    e = null;
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
            }
            if (e != null) {
                synchronized (this.request.lock()) {
                    if (!this.request.isCancelled()) {
                        readCallback.onError(e);
                    }
                }
            }
        }
    }
}
