package com.datadog.trace.core.scopemanager;

import com.datadog.trace.bootstrap.instrumentation.api.AgentScope;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.logger.Logger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes6.dex */
final class ConcurrentContinuation extends AbstractContinuation {
    private static final int BARRIER = -536870912;
    private static final int CLOSED = -1073741824;
    private static final AtomicIntegerFieldUpdater<ConcurrentContinuation> COUNT = AtomicIntegerFieldUpdater.newUpdater(ConcurrentContinuation.class, "count");
    private static final int START = 1;
    private volatile int count;

    public ConcurrentContinuation(ContinuableScopeManager continuableScopeManager, AgentSpan agentSpan, byte b, Logger logger) {
        super(continuableScopeManager, agentSpan, b, logger);
        this.count = 1;
    }

    private boolean tryActivate() {
        AtomicIntegerFieldUpdater<ConcurrentContinuation> atomicIntegerFieldUpdater = COUNT;
        int iIncrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
        if (iIncrementAndGet < 1) {
            atomicIntegerFieldUpdater.decrementAndGet(this);
        }
        return iIncrementAndGet > 1;
    }

    private boolean tryClose() {
        AtomicIntegerFieldUpdater<ConcurrentContinuation> atomicIntegerFieldUpdater = COUNT;
        if (atomicIntegerFieldUpdater.get(this) < BARRIER) {
            return false;
        }
        int iDecrementAndGet = atomicIntegerFieldUpdater.decrementAndGet(this);
        while (iDecrementAndGet < 1 && iDecrementAndGet > BARRIER) {
            AtomicIntegerFieldUpdater<ConcurrentContinuation> atomicIntegerFieldUpdater2 = COUNT;
            if (atomicIntegerFieldUpdater2.compareAndSet(this, iDecrementAndGet, CLOSED)) {
                return true;
            }
            iDecrementAndGet = atomicIntegerFieldUpdater2.get(this);
        }
        return false;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope.Continuation, com.datadog.trace.context.TraceScope.Continuation
    public AgentScope activate() {
        if (tryActivate()) {
            return this.scopeManager.continueSpan(this, this.spanUnderScope, this.source);
        }
        return null;
    }

    @Override // com.datadog.trace.context.TraceScope.Continuation
    public void cancel() {
        if (tryClose()) {
            this.trace.cancelContinuation(this);
        }
        this.logger.debug("t_id={} -> canceling continuation {}", this.spanUnderScope.getTraceId(), this);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope.Continuation
    public AgentSpan getSpan() {
        return this.spanUnderScope;
    }

    @Override // com.datadog.trace.core.scopemanager.AbstractContinuation
    void cancelFromContinuedScopeClose() {
        cancel();
    }

    public String toString() {
        int i = COUNT.get(this);
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "(" + (i < BARRIER ? "CANCELED" : String.valueOf(i)) + ")->" + this.spanUnderScope;
    }
}
