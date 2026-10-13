package com.datadog.trace.core.scopemanager;

import com.datadog.trace.bootstrap.instrumentation.api.ProfilingContextIntegration;
import com.datadog.trace.bootstrap.instrumentation.api.ScopeSource;
import com.datadog.trace.relocate.api.RatelimitedLogger;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes6.dex */
final class ScopeStack {
    volatile ContinuableScope overdueRootScope;
    private final ProfilingContextIntegration profilingContextIntegration;
    private final RatelimitedLogger ratelimitedLogger;
    private final ArrayDeque<ContinuableScope> stack = new ArrayDeque<>();
    ContinuableScope top;

    ScopeStack(ProfilingContextIntegration profilingContextIntegration, RatelimitedLogger ratelimitedLogger) {
        this.profilingContextIntegration = profilingContextIntegration;
        this.ratelimitedLogger = ratelimitedLogger;
    }

    ContinuableScope active() {
        if (this.top != this.overdueRootScope) {
            return this.top;
        }
        return null;
    }

    void cleanup() {
        ContinuableScope continuableScopePoll = this.top;
        boolean z = false;
        while (continuableScopePoll != null && !continuableScopePoll.alive()) {
            continuableScopePoll.onProperClose();
            continuableScopePoll = this.stack.poll();
            z = true;
        }
        if (continuableScopePoll != null && continuableScopePoll == this.overdueRootScope) {
            continuableScopePoll.onProperClose();
            this.overdueRootScope = null;
            this.top = null;
        } else if (z) {
            this.top = continuableScopePoll;
            if (continuableScopePoll != null) {
                continuableScopePoll.beforeActivated();
                continuableScopePoll.afterActivated();
            }
        }
        if (this.top == null) {
            onBecomeEmpty();
        }
    }

    void push(ContinuableScope continuableScope) {
        continuableScope.beforeActivated();
        ContinuableScope continuableScope2 = this.top;
        if (continuableScope2 != null) {
            this.stack.push(continuableScope2);
        } else {
            onBecomeNonEmpty();
        }
        this.top = continuableScope;
        continuableScope.afterActivated();
    }

    boolean checkTop(ContinuableScope continuableScope) {
        return continuableScope.equals(this.top);
    }

    final boolean checkOverdueScopes(ContinuableScope continuableScope) {
        ContinuableScope continuableScope2 = this.top;
        if (continuableScope2 != null && continuableScope2.source() == ScopeSource.ITERATION.id()) {
            this.top.clearReferences();
            this.top.span.finishWithEndToEnd();
            for (ContinuableScope continuableScope3 : this.stack) {
                if (continuableScope3.source() != ScopeSource.ITERATION.id()) {
                    return continuableScope.equals(continuableScope3);
                }
                continuableScope3.clearReferences();
                continuableScope3.span.finishWithEndToEnd();
            }
        }
        return false;
    }

    int depth() {
        if (this.top != null) {
            return this.stack.size() + 1;
        }
        return 0;
    }

    void clear() {
        this.stack.clear();
        this.top = null;
    }

    private void onBecomeNonEmpty() {
        try {
            this.profilingContextIntegration.onAttach();
        } catch (Throwable th) {
            this.ratelimitedLogger.warn("Unexpected profiling exception", th);
        }
    }

    private void onBecomeEmpty() {
        try {
            this.profilingContextIntegration.onDetach();
        } catch (Throwable th) {
            this.ratelimitedLogger.warn("Unexpected profiling exception", th);
        }
    }
}
