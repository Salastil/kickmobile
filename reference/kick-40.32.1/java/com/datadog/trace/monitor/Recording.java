package com.datadog.trace.monitor;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Recording implements AutoCloseable {
    public abstract void flush();

    public abstract void reset();

    public abstract Recording start();

    public abstract void stop();

    @Override // java.lang.AutoCloseable
    public void close() {
        stop();
    }
}
