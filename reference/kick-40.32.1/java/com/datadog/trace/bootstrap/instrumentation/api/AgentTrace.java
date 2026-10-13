package com.datadog.trace.bootstrap.instrumentation.api;

/* JADX INFO: loaded from: classes6.dex */
public interface AgentTrace {
    void cancelContinuation(AgentScope.Continuation continuation);

    void registerContinuation(AgentScope.Continuation continuation);
}
