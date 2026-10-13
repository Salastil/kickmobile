package com.datadog.android.trace.api.span;

import com.datadog.android.trace.api.trace.DatadogTraceId;
import com.datadog.android.trace.api.trace.NoOpDatadogTraceId;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: NoOpDatadogSpanContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/trace/api/span/NoOpDatadogSpanContext;", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "()V", "samplingPriority", "", "getSamplingPriority", "()I", "spanId", "", "getSpanId", "()J", "tags", "", "", "", "getTags", "()Ljava/util/Map;", "traceId", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "getTraceId", "()Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "setMetric", "", "key", "", "value", "", "setSamplingPriority", "", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDatadogSpanContext implements DatadogSpanContext {
    private final int samplingPriority;
    private final long spanId;
    private final DatadogTraceId traceId = new NoOpDatadogTraceId();
    private final Map<String, Object> tags = MapsKt.emptyMap();

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public void setMetric(CharSequence key, double value) {
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public boolean setSamplingPriority(int samplingPriority) {
        return false;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public DatadogTraceId getTraceId() {
        return this.traceId;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public long getSpanId() {
        return this.spanId;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public int getSamplingPriority() {
        return this.samplingPriority;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public Map<String, Object> getTags() {
        return this.tags;
    }
}
