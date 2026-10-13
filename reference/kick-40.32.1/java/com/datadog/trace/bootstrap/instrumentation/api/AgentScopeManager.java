package com.datadog.trace.bootstrap.instrumentation.api;

/* JADX INFO: loaded from: classes6.dex */
public interface AgentScopeManager {
    AgentScope activate(AgentSpan agentSpan, ScopeSource scopeSource);

    AgentScope activate(AgentSpan agentSpan, ScopeSource scopeSource, boolean z);

    AgentScope activateNext(AgentSpan agentSpan);

    AgentScope active();

    AgentSpan activeSpan();

    AgentScope.Continuation captureSpan(AgentSpan agentSpan);

    void closePrevious(boolean z);
}
