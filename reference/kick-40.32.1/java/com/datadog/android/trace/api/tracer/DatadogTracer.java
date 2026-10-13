package com.datadog.android.trace.api.tracer;

import com.datadog.android.trace.api.propagation.DatadogPropagation;
import com.datadog.android.trace.api.propagation.NoOpDatadogPropagation;
import com.datadog.android.trace.api.scope.DatadogScope;
import com.datadog.android.trace.api.scope.DatadogScopeListener;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanBuilder;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatadogTracer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "", "activateSpan", "Lcom/datadog/android/trace/api/scope/DatadogScope;", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "activeSpan", "addScopeListener", "", "scopeListener", "Lcom/datadog/android/trace/api/scope/DatadogScopeListener;", "buildSpan", "Lcom/datadog/android/trace/api/span/DatadogSpanBuilder;", "spanName", "", "instrumentationName", "", "propagate", "Lcom/datadog/android/trace/api/propagation/DatadogPropagation;", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DatadogTracer {
    DatadogScope activateSpan(DatadogSpan span);

    DatadogSpan activeSpan();

    void addScopeListener(DatadogScopeListener scopeListener);

    DatadogSpanBuilder buildSpan(CharSequence spanName);

    DatadogSpanBuilder buildSpan(String instrumentationName, CharSequence spanName);

    DatadogPropagation propagate();

    /* JADX INFO: compiled from: DatadogTracer.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static DatadogPropagation propagate(DatadogTracer datadogTracer) {
            return new NoOpDatadogPropagation();
        }
    }
}
