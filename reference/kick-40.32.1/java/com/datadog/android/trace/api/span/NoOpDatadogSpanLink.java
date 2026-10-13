package com.datadog.android.trace.api.span;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.trace.api.trace.DatadogTraceId;
import com.datadog.android.trace.api.trace.NoOpDatadogTraceId;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: NoOpDatadogSpanLink.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/trace/api/span/NoOpDatadogSpanLink;", "Lcom/datadog/android/trace/api/span/DatadogSpanLink;", "()V", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "getAttributes", "()Ljava/util/Map;", "sampled", "", "getSampled", "()Z", "spanId", "", "getSpanId", "()J", "traceId", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "getTraceId", "()Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "traceStrace", "getTraceStrace", "()Ljava/lang/String;", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDatadogSpanLink implements DatadogSpanLink {
    private final Map<String, String> attributes;
    private final boolean sampled;
    private final long spanId;
    private final DatadogTraceId traceId = new NoOpDatadogTraceId();
    private final String traceStrace = "";

    @Override // com.datadog.android.trace.api.span.DatadogSpanLink
    public long getSpanId() {
        return this.spanId;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanLink
    public boolean getSampled() {
        return this.sampled;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanLink
    public DatadogTraceId getTraceId() {
        return this.traceId;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanLink
    public String getTraceStrace() {
        return this.traceStrace;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanLink
    public Map<String, String> getAttributes() {
        return this.attributes;
    }
}
