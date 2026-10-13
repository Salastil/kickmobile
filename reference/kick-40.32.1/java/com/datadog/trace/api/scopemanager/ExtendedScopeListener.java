package com.datadog.trace.api.scopemanager;

import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.api.TraceConfig;

/* JADX INFO: loaded from: classes6.dex */
public interface ExtendedScopeListener extends ScopeListener {
    void afterScopeActivated(DDTraceId dDTraceId, long j, long j2, TraceConfig traceConfig);

    @Override // com.datadog.trace.api.scopemanager.ScopeListener
    void afterScopeClosed();
}
