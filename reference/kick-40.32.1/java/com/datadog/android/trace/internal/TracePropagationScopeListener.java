package com.datadog.android.trace.internal;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.trace.api.scope.DatadogScopeListener;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TracePropagationScopeListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/datadog/android/trace/internal/TracePropagationScopeListener;", "Lcom/datadog/android/trace/api/scope/DatadogScopeListener;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "datadogTracer", "Lcom/datadog/android/trace/api/tracer/DatadogTracer;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/trace/api/tracer/DatadogTracer;)V", "afterScopeActivated", "", "afterScopeClosed", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TracePropagationScopeListener implements DatadogScopeListener {
    private final DatadogTracer datadogTracer;
    private final FeatureSdkCore sdkCore;

    public TracePropagationScopeListener(FeatureSdkCore sdkCore, DatadogTracer datadogTracer) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(datadogTracer, "datadogTracer");
        this.sdkCore = sdkCore;
        this.datadogTracer = datadogTracer;
    }

    @Override // com.datadog.android.trace.api.scope.DatadogScopeListener
    public void afterScopeActivated() {
        DatadogSpan datadogSpanActiveSpan = this.datadogTracer.activeSpan();
        DatadogSpanContext datadogSpanContextContext = datadogSpanActiveSpan != null ? datadogSpanActiveSpan.context() : null;
        if (datadogSpanContextContext != null) {
            FeatureSdkCoreExtKt.addActiveTraceToContext(this.sdkCore, datadogSpanContextContext.getTraceId().toHexString(), String.valueOf(datadogSpanContextContext.getSpanId()));
        }
    }

    @Override // com.datadog.android.trace.api.scope.DatadogScopeListener
    public void afterScopeClosed() {
        FeatureSdkCoreExtKt.removeActiveTraceFromContext(this.sdkCore);
    }
}
