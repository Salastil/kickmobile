package com.datadog.trace.core.scopemanager;

import com.datadog.trace.api.Stateful;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.relocate.api.RatelimitedLogger;

/* JADX INFO: loaded from: classes6.dex */
final class ContinuingScope extends ContinuableScope {
    private final AbstractContinuation continuation;

    ContinuingScope(ContinuableScopeManager continuableScopeManager, AgentSpan agentSpan, byte b, boolean z, AbstractContinuation abstractContinuation, Stateful stateful, Logger logger, RatelimitedLogger ratelimitedLogger) {
        super(continuableScopeManager, agentSpan, b, z, stateful, logger, ratelimitedLogger);
        this.continuation = abstractContinuation;
    }

    @Override // com.datadog.trace.core.scopemanager.ContinuableScope
    void cleanup(ScopeStack scopeStack) {
        super.cleanup(scopeStack);
        this.continuation.cancelFromContinuedScopeClose();
    }
}
