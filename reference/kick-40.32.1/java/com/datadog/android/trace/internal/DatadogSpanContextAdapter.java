package com.datadog.android.trace.internal;

import com.datadog.android.trace.api.span.DatadogSpanContext;
import com.datadog.android.trace.api.trace.DatadogTraceId;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.AgentTrace;
import com.datadog.trace.core.DDSpanContext;
import com.datadog.trace.core.PendingTrace;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogSpanContextAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\r\u0010%\u001a\u00020\u001eH\u0000¢\u0006\u0002\b&R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogSpanContextAdapter;", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "delegate", "Lcom/datadog/trace/bootstrap/instrumentation/api/AgentSpan$Context;", "(Lcom/datadog/trace/bootstrap/instrumentation/api/AgentSpan$Context;)V", "ddSpanContext", "Lcom/datadog/trace/core/DDSpanContext;", "getDdSpanContext", "()Lcom/datadog/trace/core/DDSpanContext;", "getDelegate$dd_sdk_android_trace_release", "()Lcom/datadog/trace/bootstrap/instrumentation/api/AgentSpan$Context;", "samplingPriority", "", "getSamplingPriority", "()I", "spanId", "", "getSpanId", "()J", "tags", "", "", "", "getTags", "()Ljava/util/Map;", "traceId", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "getTraceId", "()Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "setMetric", "", "key", "", "value", "", "setSamplingPriority", "", "setTracingSamplingPriorityIfNecessary", "setTracingSamplingPriorityIfNecessary$dd_sdk_android_trace_release", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogSpanContextAdapter implements DatadogSpanContext {
    private final AgentSpan.Context delegate;

    public DatadogSpanContextAdapter(AgentSpan.Context delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: renamed from: getDelegate$dd_sdk_android_trace_release, reason: from getter */
    public final AgentSpan.Context getDelegate() {
        return this.delegate;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public long getSpanId() {
        return this.delegate.getSpanId();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public int getSamplingPriority() {
        return this.delegate.getTraceSamplingPriority();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public Map<String, Object> getTags() {
        DDSpanContext ddSpanContext = getDdSpanContext();
        Map<String, Object> tags = ddSpanContext != null ? ddSpanContext.getTags() : null;
        return tags == null ? MapsKt.emptyMap() : tags;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public DatadogTraceId getTraceId() {
        DDTraceId traceId = this.delegate.getTraceId();
        Intrinsics.checkNotNullExpressionValue(traceId, "delegate.traceId");
        return new DatadogTraceIdAdapter(traceId);
    }

    private final DDSpanContext getDdSpanContext() {
        AgentSpan.Context context = this.delegate;
        if (context instanceof DDSpanContext) {
            return (DDSpanContext) context;
        }
        return null;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public boolean setSamplingPriority(int samplingPriority) {
        DDSpanContext ddSpanContext = getDdSpanContext();
        if (ddSpanContext != null) {
            return ddSpanContext.setSamplingPriority(samplingPriority, 0);
        }
        return false;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpanContext
    public void setMetric(CharSequence key, double value) {
        DDSpanContext ddSpanContext = getDdSpanContext();
        if (ddSpanContext != null) {
            ddSpanContext.setMetric(key, Double.valueOf(value));
        }
    }

    public final void setTracingSamplingPriorityIfNecessary$dd_sdk_android_trace_release() {
        AgentTrace trace = this.delegate.getTrace();
        PendingTrace pendingTrace = trace instanceof PendingTrace ? (PendingTrace) trace : null;
        if (pendingTrace != null) {
            pendingTrace.setSamplingPriorityIfNecessary();
        }
    }
}
