package com.datadog.android.trace.api.propagation;

import com.datadog.android.api.instrumentation.network.HttpRequestInfoBuilder;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatadogHttpHeadersPropagation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/datadog/android/trace/api/propagation/DatadogHttpHeadersPropagation;", "", "handleNotSampledHeaders", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfoBuilder;", "requestInfoBuilder", "tracer", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "handleSampledHeaders", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DatadogHttpHeadersPropagation {
    HttpRequestInfoBuilder handleNotSampledHeaders(HttpRequestInfoBuilder requestInfoBuilder, DatadogTracer tracer, DatadogSpan span);

    HttpRequestInfoBuilder handleSampledHeaders(HttpRequestInfoBuilder requestInfoBuilder, DatadogTracer tracer, DatadogSpan span);
}
