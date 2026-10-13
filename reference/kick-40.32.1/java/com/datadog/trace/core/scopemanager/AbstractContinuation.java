package com.datadog.trace.core.scopemanager;

import com.datadog.trace.bootstrap.instrumentation.api.AgentScope;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.AgentTrace;
import com.datadog.trace.logger.Logger;

/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractContinuation implements AgentScope.Continuation {
    protected final Logger logger;
    final ContinuableScopeManager scopeManager;
    final byte source;
    final AgentSpan spanUnderScope;
    final AgentTrace trace;

    abstract void cancelFromContinuedScopeClose();

    public AbstractContinuation(ContinuableScopeManager continuableScopeManager, AgentSpan agentSpan, byte b, Logger logger) {
        this.scopeManager = continuableScopeManager;
        this.spanUnderScope = agentSpan;
        this.source = b;
        this.trace = agentSpan.context().getTrace();
        this.logger = logger;
    }

    AbstractContinuation register() {
        this.trace.registerContinuation(this);
        return this;
    }
}
