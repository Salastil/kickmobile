package com.datadog.android.trace.api.trace;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

/* JADX INFO: compiled from: NoOpDatadogTraceId.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/datadog/android/trace/api/trace/NoOpDatadogTraceId;", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "()V", "toHexString", "", "toHexStringPadded", ContentDisposition.Parameters.Size, "", "toLong", "", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDatadogTraceId implements DatadogTraceId {
    @Override // com.datadog.android.trace.api.trace.DatadogTraceId
    public long toLong() {
        return 0L;
    }

    @Override // com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexStringPadded(int size) {
        return "";
    }

    @Override // com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexString() {
        return "";
    }
}
