package com.datadog.android.trace.api.tracer;

import com.datadog.android.trace.TracingHeaderType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpDatadogTracerBuilder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0016\u0010\u0016\u001a\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/trace/api/tracer/NoOpDatadogTracerBuilder;", "Lcom/datadog/android/trace/api/tracer/DatadogTracerBuilder;", "()V", "build", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "setBundleWithRumEnabled", "enabled", "", "setTraceRateLimit", "traceRateLimit", "", "withPartialFlushMinSpans", "partialFlushMinSpans", "withSampleRate", "sampleRate", "", "withServiceName", "serviceName", "", "withTag", "key", "value", "withTracingHeadersTypes", "tracingHeadersTypes", "", "Lcom/datadog/android/trace/TracingHeaderType;", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDatadogTracerBuilder implements DatadogTracerBuilder {
    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracer build() {
        return new NoOpDatadogTracer();
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilder withTracingHeadersTypes(Set<? extends TracingHeaderType> tracingHeadersTypes) {
        Intrinsics.checkNotNullParameter(tracingHeadersTypes, "tracingHeadersTypes");
        return new NoOpDatadogTracerBuilder();
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilder withServiceName(String serviceName) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        return new NoOpDatadogTracerBuilder();
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilder withSampleRate(double sampleRate) {
        return new NoOpDatadogTracerBuilder();
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilder withPartialFlushMinSpans(int partialFlushMinSpans) {
        return new NoOpDatadogTracerBuilder();
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilder withTag(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return new NoOpDatadogTracerBuilder();
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilder setBundleWithRumEnabled(boolean enabled) {
        return new NoOpDatadogTracerBuilder();
    }

    @Override // com.datadog.android.trace.api.tracer.DatadogTracerBuilder
    public DatadogTracerBuilder setTraceRateLimit(int traceRateLimit) {
        return new NoOpDatadogTracerBuilder();
    }
}
