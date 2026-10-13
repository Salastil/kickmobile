package com.datadog.android.trace.api.span;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.api.trace.DatadogTraceId;
import com.datadog.android.trace.api.trace.NoOpDatadogTraceId;
import com.datadog.trace.bootstrap.instrumentation.api.SamplerConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpDatadogSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u0004\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020.H\u0016J\b\u00104\u001a\u00020.H\u0016J\u0010\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u0004H\u0016J\u0014\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u00109\u001a\u00020.2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u0002070;H\u0016J\u0010\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\u0013H\u0016J\u0010\u0010>\u001a\u00020.2\u0006\u0010=\u001a\u00020\u0013H\u0016J\u0010\u0010?\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0012\u0010@\u001a\u00020.2\b\u0010=\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010A\u001a\u00020.2\u0006\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020 H\u0016J\u001c\u0010D\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u00010\u00132\b\u0010C\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010D\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u00010\u00132\u0006\u0010C\u001a\u00020\bH\u0016J\u001c\u0010D\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u00010\u00132\b\u0010C\u001a\u0004\u0018\u00010EH\u0016J\u001c\u0010D\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u00010\u00132\b\u0010C\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u0018\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u0014\u0010'\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0014\u0010)\u001a\u00020*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006F"}, d2 = {"Lcom/datadog/android/trace/api/span/NoOpDatadogSpan;", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "()V", "durationNano", "", "getDurationNano", "()J", "isError", "", "()Ljava/lang/Boolean;", "setError", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isRootSpan", "()Z", "localRootSpan", "getLocalRootSpan", "()Lcom/datadog/android/trace/api/span/DatadogSpan;", "operationName", "", "getOperationName", "()Ljava/lang/String;", "setOperationName", "(Ljava/lang/String;)V", "parentSpanId", "getParentSpanId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "resourceName", "getResourceName", "setResourceName", "samplingPriority", "", "getSamplingPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "serviceName", "getServiceName", "setServiceName", "startTimeNanos", "getStartTimeNanos", "traceId", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "getTraceId", "()Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "addThrowable", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", SamplerConstants.DROP, "finish", "finishMicros", "getTag", "", "tag", "logAttributes", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "logErrorMessage", "message", "logMessage", "logThrowable", "setErrorMessage", "setMetric", "key", "value", "setTag", "", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDatadogSpan implements DatadogSpan {
    private final long durationNano;
    private Boolean isError;
    private final boolean isRootSpan;
    private final DatadogSpan localRootSpan;
    private final Long parentSpanId;
    private String resourceName;
    private final Integer samplingPriority;
    private final long startTimeNanos;
    private final DatadogTraceId traceId = new NoOpDatadogTraceId();
    private String serviceName = "";
    private String operationName = "";

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void addThrowable(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void drop() {
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void finish() {
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void finish(long finishMicros) {
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public Object getTag(String tag) {
        return null;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void logAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void logErrorMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void logMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void logThrowable(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setErrorMessage(String message) {
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setMetric(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setTag(String tag, Number value) {
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setTag(String tag, Object value) {
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setTag(String tag, String value) {
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setTag(String tag, boolean value) {
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    /* JADX INFO: renamed from: isError, reason: from getter */
    public Boolean getIsError() {
        return this.isError;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setError(Boolean bool) {
        this.isError = bool;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    /* JADX INFO: renamed from: isRootSpan, reason: from getter */
    public boolean getIsRootSpan() {
        return this.isRootSpan;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public Integer getSamplingPriority() {
        return this.samplingPriority;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public DatadogTraceId getTraceId() {
        return this.traceId;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public Long getParentSpanId() {
        return this.parentSpanId;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public String getResourceName() {
        return this.resourceName;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setResourceName(String str) {
        this.resourceName = str;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public String getServiceName() {
        return this.serviceName;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setServiceName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serviceName = str;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public String getOperationName() {
        return this.operationName;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public void setOperationName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.operationName = str;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public long getDurationNano() {
        return this.durationNano;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public long getStartTimeNanos() {
        return this.startTimeNanos;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public DatadogSpan getLocalRootSpan() {
        return this.localRootSpan;
    }

    @Override // com.datadog.android.trace.api.span.DatadogSpan
    public DatadogSpanContext context() {
        return new NoOpDatadogSpanContext();
    }
}
