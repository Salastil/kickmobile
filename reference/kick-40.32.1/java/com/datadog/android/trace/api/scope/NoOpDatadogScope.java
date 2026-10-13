package com.datadog.android.trace.api.scope;

import kotlin.Metadata;

/* JADX INFO: compiled from: NoOpDatadogScope.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/trace/api/scope/NoOpDatadogScope;", "Lcom/datadog/android/trace/api/scope/DatadogScope;", "()V", "close", "", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDatadogScope implements DatadogScope {
    @Override // com.datadog.android.trace.api.scope.DatadogScope, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
