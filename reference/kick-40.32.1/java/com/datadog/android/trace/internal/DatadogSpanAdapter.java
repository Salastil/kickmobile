package com.datadog.android.trace.internal;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.trace.DatadogTraceId;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.SamplerConstants;
import com.datadog.trace.core.DDSpan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogSpanAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0004\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u001d\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000202H\u0016J\b\u0010;\u001a\u000202H\u0016J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020\nH\u0016J\u0014\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010@\u001a\u0002022\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020>0BH\u0016J\u0010\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020\u0018H\u0016J\u0010\u0010E\u001a\u0002022\u0006\u0010D\u001a\u00020\u0018H\u0016J\u0010\u0010F\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0012\u0010G\u001a\u0002022\b\u0010D\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020%H\u0016J\u001c\u0010J\u001a\u0002022\b\u0010?\u001a\u0004\u0018\u00010\u00182\b\u0010\r\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010J\u001a\u0002022\b\u0010?\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010J\u001a\u0002022\b\u0010?\u001a\u0004\u0018\u00010\u00182\b\u0010\r\u001a\u0004\u0018\u00010KH\u0016J\u001c\u0010J\u001a\u0002022\b\u0010?\u001a\u0004\u0018\u00010\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u0018H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R(\u0010!\u001a\u0004\u0018\u00010\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u0016\u0010$\u001a\u0004\u0018\u00010%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R$\u0010(\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\fR\u0014\u0010-\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006L"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogSpanAdapter;", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "delegate", "Lcom/datadog/trace/bootstrap/instrumentation/api/AgentSpan;", "spanLogger", "Lcom/datadog/android/trace/internal/DatadogSpanLogger;", "(Lcom/datadog/trace/bootstrap/instrumentation/api/AgentSpan;Lcom/datadog/android/trace/internal/DatadogSpanLogger;)V", "getDelegate$dd_sdk_android_trace_release", "()Lcom/datadog/trace/bootstrap/instrumentation/api/AgentSpan;", "durationNano", "", "getDurationNano", "()J", "value", "", "isError", "()Ljava/lang/Boolean;", "setError", "(Ljava/lang/Boolean;)V", "isRootSpan", "()Z", "localRootSpan", "getLocalRootSpan", "()Lcom/datadog/android/trace/api/span/DatadogSpan;", "", "operationName", "getOperationName", "()Ljava/lang/String;", "setOperationName", "(Ljava/lang/String;)V", "parentSpanId", "getParentSpanId", "()Ljava/lang/Long;", "resourceName", "getResourceName", "setResourceName", "samplingPriority", "", "getSamplingPriority", "()Ljava/lang/Integer;", "serviceName", "getServiceName", "setServiceName", "startTimeNanos", "getStartTimeNanos", "traceId", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "getTraceId", "()Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "addThrowable", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "errorPriority", "", "addThrowable$dd_sdk_android_trace_release", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/trace/internal/DatadogSpanContextAdapter;", SamplerConstants.DROP, "finish", "finishMicros", "getTag", "", "tag", "logAttributes", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "logErrorMessage", "message", "logMessage", "logThrowable", "setErrorMessage", "setMetric", "key", "setTag", "", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogSpanAdapter implements DatadogSpan {
    private final AgentSpan delegate;
    private final DatadogSpanLogger spanLogger;

    public DatadogSpanAdapter(AgentSpan delegate, DatadogSpanLogger spanLogger) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(spanLogger, "spanLogger");
        this.delegate = delegate;
        this.spanLogger = spanLogger;
    }

    /* JADX INFO: renamed from: getDelegate$dd_sdk_android_trace_release, reason: from getter */
    public final AgentSpan getDelegate() {
        return this.delegate;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    /* JADX INFO: renamed from: isRootSpan */
    public boolean getIsRootSpan() {
        AgentSpan agentSpan = this.delegate;
        return (agentSpan instanceof DDSpan) && ((DDSpan) agentSpan).isRootSpan();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public DatadogTraceId getTraceId() {
        DDTraceId traceId = this.delegate.getTraceId();
        Intrinsics.checkNotNullExpressionValue(traceId, "delegate.traceId");
        return new DatadogTraceIdAdapter(traceId);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public Long getParentSpanId() {
        AgentSpan agentSpan = this.delegate;
        DDSpan dDSpan = agentSpan instanceof DDSpan ? (DDSpan) agentSpan : null;
        if (dDSpan != null) {
            return Long.valueOf(dDSpan.getParentId());
        }
        return null;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public Integer getSamplingPriority() {
        return this.delegate.getTraceSamplingPriority();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public long getDurationNano() {
        return this.delegate.getDurationNano();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public long getStartTimeNanos() {
        return this.delegate.getStartTime();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public DatadogSpan getLocalRootSpan() {
        AgentSpan agentSpanMo11181getLocalRootSpan = this.delegate.mo11181getLocalRootSpan();
        return agentSpanMo11181getLocalRootSpan != null ? new DatadogSpanAdapter(agentSpanMo11181getLocalRootSpan, this.spanLogger) : null;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    /* JADX INFO: renamed from: isError */
    public Boolean getIsError() {
        return Boolean.valueOf(this.delegate.isError());
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setError(Boolean bool) {
        if (bool == null) {
            return;
        }
        this.delegate.setError(bool.booleanValue());
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public String getResourceName() {
        CharSequence resourceName = this.delegate.getResourceName();
        if (resourceName != null) {
            return resourceName.toString();
        }
        return null;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setResourceName(String str) {
        this.delegate.setResourceName((CharSequence) str);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public String getServiceName() {
        String serviceName = this.delegate.getServiceName();
        Intrinsics.checkNotNullExpressionValue(serviceName, "delegate.serviceName");
        return serviceName;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setServiceName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.delegate.setServiceName(value);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public String getOperationName() {
        return this.delegate.getOperationName().toString();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setOperationName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.delegate.setOperationName(value);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void drop() {
        this.delegate.drop();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void finish() {
        this.delegate.finish();
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void finish(long finishMicros) {
        this.delegate.finish(finishMicros);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public DatadogSpanContextAdapter context() {
        AgentSpan.Context context = this.delegate.context();
        Intrinsics.checkNotNullExpressionValue(context, "delegate.context()");
        return new DatadogSpanContextAdapter(context);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setTag(String tag, String value) {
        this.delegate.mo11194setTag(tag, value);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setTag(String tag, boolean value) {
        this.delegate.mo11195setTag(tag, value);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setTag(String tag, Number value) {
        this.delegate.mo11192setTag(tag, value);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setTag(String tag, Object value) {
        this.delegate.mo11193setTag(tag, value);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public Object getTag(String tag) {
        return this.delegate.getTag(tag);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setMetric(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.delegate.mo11185setMetric((CharSequence) key, value);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setErrorMessage(String message) {
        this.delegate.mo11182setErrorMessage(message);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void addThrowable(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.delegate.mo11180addThrowable(throwable);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void logThrowable(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.spanLogger.log(throwable, this);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void logErrorMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.spanLogger.logErrorMessage(message, this);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void logMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.spanLogger.log(message, this);
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void logAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.spanLogger.log(attributes, this);
    }

    public final void addThrowable$dd_sdk_android_trace_release(Throwable throwable, byte errorPriority) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.delegate.addThrowable(throwable, errorPriority);
    }
}
