package com.datadog.trace.bootstrap.instrumentation.api;

import com.datadog.trace.context.TraceScope;
import java.io.Closeable;

/* JADX INFO: loaded from: classes6.dex */
public interface AgentScope extends TraceScope, Closeable {

    public interface Continuation extends TraceScope.Continuation {
        @Override // com.datadog.trace.context.TraceScope.Continuation
        AgentScope activate();

        AgentSpan getSpan();
    }

    @Override // com.datadog.trace.context.TraceScope
    Continuation capture();

    @Override // com.datadog.trace.context.TraceScope
    Continuation captureConcurrent();

    @Override // com.datadog.trace.context.TraceScope, java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // com.datadog.trace.context.TraceScope
    void setAsyncPropagation(boolean z);

    byte source();

    AgentSpan span();
}
