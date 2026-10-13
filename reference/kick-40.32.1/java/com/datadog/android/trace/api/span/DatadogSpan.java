package com.datadog.android.trace.api.span;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.api.trace.DatadogTraceId;
import com.datadog.trace.bootstrap.instrumentation.api.SamplerConstants;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatadogSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u0004\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H&J\b\u0010-\u001a\u00020.H&J\b\u0010/\u001a\u00020*H&J\b\u00100\u001a\u00020*H&J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u0003H&J\u0014\u00102\u001a\u0004\u0018\u00010\u00012\b\u00103\u001a\u0004\u0018\u00010\u0011H&J\u001c\u00104\u001a\u00020*2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000106H&J\u0010\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u0011H&J\u0010\u00109\u001a\u00020*2\u0006\u00108\u001a\u00020\u0011H&J\u0010\u0010:\u001a\u00020*2\u0006\u0010+\u001a\u00020,H&J\u0012\u0010;\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010\u0011H&J\u0018\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u001dH&J\u001c\u0010?\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u00112\b\u0010>\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010?\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u00112\u0006\u0010>\u001a\u00020\u0007H&J\u001c\u0010?\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u00112\b\u0010>\u001a\u0004\u0018\u00010@H&J\u001c\u0010?\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u00112\b\u0010>\u001a\u0004\u0018\u00010\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u00020\u0011X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u0012\u0010#\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0005R\u0012\u0010%\u001a\u00020&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006A"}, d2 = {"Lcom/datadog/android/trace/api/span/DatadogSpan;", "", "durationNano", "", "getDurationNano", "()J", "isError", "", "()Ljava/lang/Boolean;", "setError", "(Ljava/lang/Boolean;)V", "isRootSpan", "()Z", "localRootSpan", "getLocalRootSpan", "()Lcom/datadog/android/trace/api/span/DatadogSpan;", "operationName", "", "getOperationName", "()Ljava/lang/String;", "setOperationName", "(Ljava/lang/String;)V", "parentSpanId", "getParentSpanId", "()Ljava/lang/Long;", "resourceName", "getResourceName", "setResourceName", "samplingPriority", "", "getSamplingPriority", "()Ljava/lang/Integer;", "serviceName", "getServiceName", "setServiceName", "startTimeNanos", "getStartTimeNanos", "traceId", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "getTraceId", "()Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "addThrowable", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", SamplerConstants.DROP, "finish", "finishMicros", "getTag", "tag", "logAttributes", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "logErrorMessage", "message", "logMessage", "logThrowable", "setErrorMessage", "setMetric", "key", "value", "setTag", "", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DatadogSpan {
    void addThrowable(Throwable throwable);

    DatadogSpanContext context();

    void drop();

    void finish();

    void finish(long finishMicros);

    long getDurationNano();

    DatadogSpan getLocalRootSpan();

    String getOperationName();

    Long getParentSpanId();

    String getResourceName();

    Integer getSamplingPriority();

    String getServiceName();

    long getStartTimeNanos();

    Object getTag(String tag);

    DatadogTraceId getTraceId();

    Boolean isError();

    boolean isRootSpan();

    void logAttributes(Map<String, ? extends Object> attributes);

    void logErrorMessage(String message);

    void logMessage(String message);

    void logThrowable(Throwable throwable);

    void setError(Boolean bool);

    void setErrorMessage(String message);

    void setMetric(String key, int value);

    void setOperationName(String str);

    void setResourceName(String str);

    void setServiceName(String str);

    void setTag(String tag, Number value);

    void setTag(String tag, Object value);

    void setTag(String tag, String value);

    void setTag(String tag, boolean value);
}
