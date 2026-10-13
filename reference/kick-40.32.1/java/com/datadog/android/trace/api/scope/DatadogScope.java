package com.datadog.android.trace.api.scope;

import java.io.Closeable;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatadogScope.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/datadog/android/trace/api/scope/DatadogScope;", "Ljava/io/Closeable;", "close", "", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DatadogScope extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
