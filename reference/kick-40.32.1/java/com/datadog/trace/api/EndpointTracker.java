package com.datadog.trace.api;

import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;

/* JADX INFO: loaded from: classes6.dex */
public interface EndpointTracker {
    public static final EndpointTracker NO_OP = new EndpointTracker() { // from class: com.datadog.trace.api.EndpointTracker$$ExternalSyntheticLambda0
        @Override // com.datadog.trace.api.EndpointTracker
        public final void endpointWritten(AgentSpan agentSpan) {
            EndpointTracker.lambda$static$0(agentSpan);
        }
    };

    static /* synthetic */ void lambda$static$0(AgentSpan agentSpan) {
    }

    void endpointWritten(AgentSpan agentSpan);
}
