package com.datadog.android.trace.api.tracer;

import com.datadog.android.trace.TracingHeaderType;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatadogTracerBuilder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tH&J\u0012\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H&J\u0016\u0010\u0015\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/trace/api/tracer/DatadogTracerBuilder;", "", "build", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "setBundleWithRumEnabled", "enabled", "", "setTraceRateLimit", "traceRateLimit", "", "withPartialFlushMinSpans", "partialFlushMinSpans", "withSampleRate", "sampleRate", "", "withServiceName", "serviceName", "", "withTag", "key", "value", "withTracingHeadersTypes", "tracingHeadersTypes", "", "Lcom/datadog/android/trace/TracingHeaderType;", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DatadogTracerBuilder {
    DatadogTracer build();

    DatadogTracerBuilder setBundleWithRumEnabled(boolean enabled);

    DatadogTracerBuilder setTraceRateLimit(int traceRateLimit);

    DatadogTracerBuilder withPartialFlushMinSpans(int partialFlushMinSpans);

    DatadogTracerBuilder withSampleRate(double sampleRate);

    DatadogTracerBuilder withServiceName(String serviceName);

    DatadogTracerBuilder withTag(String key, String value);

    DatadogTracerBuilder withTracingHeadersTypes(Set<? extends TracingHeaderType> tracingHeadersTypes);
}
