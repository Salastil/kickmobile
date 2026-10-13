package com.datadog.trace.context;

import java.io.Closeable;

/* JADX INFO: loaded from: classes6.dex */
public interface TraceScope extends Closeable {

    public interface Continuation {
        TraceScope activate();

        void cancel();
    }

    Continuation capture();

    Continuation captureConcurrent();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean isAsyncPropagating();

    void setAsyncPropagation(boolean z);
}
