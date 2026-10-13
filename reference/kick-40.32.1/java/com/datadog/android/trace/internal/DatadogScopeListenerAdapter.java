package com.datadog.android.trace.internal;

import com.datadog.android.trace.api.scope.DatadogScopeListener;
import com.datadog.trace.api.scopemanager.ScopeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogScopeListenerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogScopeListenerAdapter;", "Lcom/datadog/trace/api/scopemanager/ScopeListener;", "delegate", "Lcom/datadog/android/trace/api/scope/DatadogScopeListener;", "(Lcom/datadog/android/trace/api/scope/DatadogScopeListener;)V", "getDelegate$dd_sdk_android_trace_release", "()Lcom/datadog/android/trace/api/scope/DatadogScopeListener;", "afterScopeActivated", "", "afterScopeClosed", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogScopeListenerAdapter implements ScopeListener {
    private final DatadogScopeListener delegate;

    public DatadogScopeListenerAdapter(DatadogScopeListener delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: getDelegate$dd_sdk_android_trace_release, reason: from getter */
    public final DatadogScopeListener getDelegate() {
        return this.delegate;
    }

    @Override // com.datadog.trace.api.scopemanager.ScopeListener
    public void afterScopeClosed() {
        this.delegate.afterScopeClosed();
    }

    @Override // com.datadog.trace.api.scopemanager.ScopeListener
    public void afterScopeActivated() {
        this.delegate.afterScopeActivated();
    }
}
