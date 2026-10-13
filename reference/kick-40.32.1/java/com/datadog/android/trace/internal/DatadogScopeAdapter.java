package com.datadog.android.trace.internal;

import com.datadog.android.trace.api.scope.DatadogScope;
import com.datadog.trace.bootstrap.instrumentation.api.AgentScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogScopeAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogScopeAdapter;", "Lcom/datadog/android/trace/api/scope/DatadogScope;", "delegate", "Lcom/datadog/trace/bootstrap/instrumentation/api/AgentScope;", "(Lcom/datadog/trace/bootstrap/instrumentation/api/AgentScope;)V", "getDelegate$dd_sdk_android_trace_release", "()Lcom/datadog/trace/bootstrap/instrumentation/api/AgentScope;", "close", "", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogScopeAdapter implements DatadogScope {
    private final AgentScope delegate;

    public DatadogScopeAdapter(AgentScope delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: getDelegate$dd_sdk_android_trace_release, reason: from getter */
    public final AgentScope getDelegate() {
        return this.delegate;
    }

    @Override // com.datadog.android.trace.api.scope.DatadogScope, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }
}
