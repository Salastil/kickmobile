package com.datadog.trace.core.scopemanager;

import com.datadog.trace.bootstrap.instrumentation.api.AgentScope;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.logger.Logger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes6.dex */
final class SingleContinuation extends AbstractContinuation {
    private static final AtomicIntegerFieldUpdater<SingleContinuation> USED = AtomicIntegerFieldUpdater.newUpdater(SingleContinuation.class, "used");
    private volatile int used;

    SingleContinuation(ContinuableScopeManager continuableScopeManager, AgentSpan agentSpan, byte b, Logger logger) {
        super(continuableScopeManager, agentSpan, b, logger);
        this.used = 0;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope.Continuation, com.datadog.trace.context.TraceScope.Continuation
    public AgentScope activate() {
        if (USED.compareAndSet(this, 0, 1)) {
            return this.scopeManager.continueSpan(this, this.spanUnderScope, this.source);
        }
        this.logger.debug("Failed to activate continuation. Reusing a continuation not allowed. Spans may be reported separately.");
        return this.scopeManager.continueSpan(null, this.spanUnderScope, this.source);
    }

    @Override // com.datadog.trace.context.TraceScope.Continuation
    public void cancel() {
        if (USED.compareAndSet(this, 0, 1)) {
            this.trace.cancelContinuation(this);
        } else {
            this.logger.debug("Failed to close continuation {}. Already used.", this);
        }
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope.Continuation
    public AgentSpan getSpan() {
        return this.spanUnderScope;
    }

    @Override // com.datadog.trace.core.scopemanager.AbstractContinuation
    void cancelFromContinuedScopeClose() {
        this.trace.cancelContinuation(this);
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "->" + this.spanUnderScope;
    }
}
