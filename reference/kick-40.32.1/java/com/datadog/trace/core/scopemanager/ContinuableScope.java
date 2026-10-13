package com.datadog.trace.core.scopemanager;

import com.datadog.trace.api.Stateful;
import com.datadog.trace.api.scopemanager.ExtendedScopeListener;
import com.datadog.trace.api.scopemanager.ScopeListener;
import com.datadog.trace.bootstrap.instrumentation.api.AgentScope;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.AttachableWrapper;
import com.datadog.trace.bootstrap.instrumentation.api.ScopeSource;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.relocate.api.RatelimitedLogger;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes6.dex */
class ContinuableScope implements AgentScope, AttachableWrapper {
    private static final AtomicReferenceFieldUpdater<ContinuableScope, Object> WRAPPER_FIELD_UPDATER = AtomicReferenceFieldUpdater.newUpdater(ContinuableScope.class, Object.class, "wrapper");
    private final byte flags;
    private boolean isAsyncPropagating;
    private final Logger log;
    private final RatelimitedLogger ratelimitedLogger;
    private short referenceCount = 1;
    private final ContinuableScopeManager scopeManager;
    private final Stateful scopeState;
    final AgentSpan span;
    private volatile Object wrapper;

    ContinuableScope(ContinuableScopeManager continuableScopeManager, AgentSpan agentSpan, byte b, boolean z, Stateful stateful, Logger logger, RatelimitedLogger ratelimitedLogger) {
        this.scopeManager = continuableScopeManager;
        this.span = agentSpan;
        this.flags = b;
        this.isAsyncPropagating = z;
        this.scopeState = stateful;
        this.log = logger;
        this.ratelimitedLogger = ratelimitedLogger;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope, com.datadog.trace.context.TraceScope, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ScopeStack scopeStack = this.scopeManager.scopeStack();
        if (!scopeStack.checkTop(this) && !scopeStack.checkOverdueScopes(this)) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Tried to close {} scope when not on top.  Current top: {}", this, scopeStack.top);
            }
            byte bSource = source();
            this.scopeManager.healthMetrics.onScopeCloseError(bSource);
            if (bSource == ScopeSource.MANUAL.id() && this.scopeManager.strictMode) {
                throw new RuntimeException("Tried to close scope when not on top");
            }
        }
        boolean zDecrementReferences = decrementReferences();
        this.scopeManager.healthMetrics.onCloseScope();
        if (!zDecrementReferences) {
            cleanup(scopeStack);
        }
        this.scopeState.close();
    }

    void cleanup(ScopeStack scopeStack) {
        scopeStack.cleanup();
    }

    final void onProperClose() {
        Iterator<ScopeListener> it = this.scopeManager.scopeListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().afterScopeClosed();
            } catch (Exception e) {
                this.log.debug("ScopeListener threw exception in close()", (Throwable) e);
            }
        }
        Iterator<ExtendedScopeListener> it2 = this.scopeManager.extendedScopeListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().afterScopeClosed();
            } catch (Exception e2) {
                this.log.debug("ScopeListener threw exception in close()", (Throwable) e2);
            }
        }
    }

    final void incrementReferences() {
        this.referenceCount = (short) (this.referenceCount + 1);
    }

    final boolean decrementReferences() {
        short s = (short) (this.referenceCount - 1);
        this.referenceCount = s;
        return s > 0;
    }

    final void clearReferences() {
        this.referenceCount = (short) 0;
    }

    final boolean alive() {
        return this.referenceCount > 0;
    }

    @Override // com.datadog.trace.context.TraceScope
    public final boolean isAsyncPropagating() {
        return this.isAsyncPropagating;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope
    public final AgentSpan span() {
        return this.span;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope, com.datadog.trace.context.TraceScope
    public final void setAsyncPropagation(boolean z) {
        this.isAsyncPropagating = z;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope, com.datadog.trace.context.TraceScope
    public final AbstractContinuation capture() {
        if (this.isAsyncPropagating) {
            return new SingleContinuation(this.scopeManager, this.span, source(), this.log).register();
        }
        return null;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope, com.datadog.trace.context.TraceScope
    public final AbstractContinuation captureConcurrent() {
        if (this.isAsyncPropagating) {
            return new ConcurrentContinuation(this.scopeManager, this.span, source(), this.log).register();
        }
        return null;
    }

    public final String toString() {
        return super.toString() + "->" + this.span;
    }

    public final void beforeActivated() {
        try {
            this.scopeState.activate(this.span.context());
        } catch (Throwable th) {
            this.ratelimitedLogger.warn("ScopeState {} threw exception in beforeActivated()", this.scopeState.getClass(), th);
        }
    }

    public final void afterActivated() {
        Iterator<ScopeListener> it = this.scopeManager.scopeListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().afterScopeActivated();
            } catch (Throwable th) {
                this.log.debug("ScopeListener threw exception in afterActivated()", th);
            }
        }
        Iterator<ExtendedScopeListener> it2 = this.scopeManager.extendedScopeListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().afterScopeActivated(this.span.getTraceId(), this.span.mo11181getLocalRootSpan().getSpanId(), this.span.context().getSpanId(), this.span.traceConfig());
            } catch (Throwable th2) {
                this.log.debug("ExtendedScopeListener threw exception in afterActivated()", th2);
            }
        }
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScope
    public byte source() {
        return (byte) (this.flags & 127);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AttachableWrapper
    public void attachWrapper(Object obj) {
        WRAPPER_FIELD_UPDATER.set(this, obj);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AttachableWrapper
    public Object getWrapper() {
        return WRAPPER_FIELD_UPDATER.get(this);
    }
}
