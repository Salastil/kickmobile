package com.datadog.trace.api;

import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;

/* JADX INFO: loaded from: classes6.dex */
public interface EndpointCheckpointer {
    void onRootSpanFinished(AgentSpan agentSpan, EndpointTracker endpointTracker);

    EndpointTracker onRootSpanStarted(AgentSpan agentSpan);
}
