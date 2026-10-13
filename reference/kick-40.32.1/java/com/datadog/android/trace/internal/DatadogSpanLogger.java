package com.datadog.android.trace.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.trace.api.DatadogTracingConstants;
import com.datadog.android.trace.api.span.DatadogSpan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogSpanLogger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t\u0012\u0002\b\u00030\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\f\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\u0013\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogSpanLogger;", "", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;)V", "extractError", "", "map", "", "", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "log", "message", RumFeature.EVENT_THROWABLE_PROPERTY, "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "logErrorMessage", "sendLogEvent", "fields", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogSpanLogger {
    public static final String DEFAULT_EVENT_MESSAGE = "Span event";
    public static final String MISSING_LOG_FEATURE_INFO = "Requested to write span log, but Logs feature is not registered.";
    public static final String TRACE_LOGGER_NAME = "trace";
    private final FeatureSdkCore sdkCore;

    public DatadogSpanLogger(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = sdkCore;
    }

    public final void log(String message, DatadogSpan span) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(span, "span");
        Map<String, ?> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("event", message));
        extractError(mapMutableMapOf, span);
        sendLogEvent(mapMutableMapOf, span);
    }

    public final void logErrorMessage(String message, DatadogSpan span) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(span, "span");
        Map<String, ?> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("message", message), TuplesKt.to("status", 6));
        extractError(mapMutableMapOf, span);
        sendLogEvent(mapMutableMapOf, span);
    }

    public final void log(Throwable throwable, DatadogSpan span) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(span, "span");
        Map<String, ?> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(DatadogTracingConstants.LogAttributes.ERROR_OBJECT, throwable));
        extractError(mapMutableMapOf, span);
        sendLogEvent(mapMutableMapOf, span);
    }

    public final void log(Map<String, ? extends Object> attributes, DatadogSpan span) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(span, "span");
        Map<String, ?> mutableMap = MapsKt.toMutableMap(attributes);
        extractError(mutableMap, span);
        sendLogEvent(mutableMap, span);
    }

    private final void extractError(Map<String, ?> map, DatadogSpan span) {
        String name;
        Class<?> cls;
        String strLoggableStackTrace;
        String string;
        Object objRemove = map.remove(DatadogTracingConstants.LogAttributes.ERROR_OBJECT);
        String message = null;
        Throwable th = objRemove instanceof Throwable ? (Throwable) objRemove : null;
        Object objRemove2 = map.remove("error.kind");
        if (objRemove2 == null || (name = objRemove2.toString()) == null) {
            name = (th == null || (cls = th.getClass()) == null) ? null : cls.getName();
        }
        if (name != null) {
            Object objRemove3 = map.remove("stack");
            Object obj = map.get("message");
            if (objRemove3 == null || (strLoggableStackTrace = objRemove3.toString()) == null) {
                strLoggableStackTrace = th != null ? ThrowableExtKt.loggableStackTrace(th) : null;
            }
            if (obj != null && (string = obj.toString()) != null) {
                message = string;
            } else if (th != null) {
                message = th.getMessage();
            }
            span.setError(true);
            span.setTag("error.type", name);
            span.setTag(DatadogTracingConstants.Tags.KEY_ERROR_MSG, message);
            span.setTag("error.stack", strLoggableStackTrace);
        }
    }

    private final void sendLogEvent(Map<String, Object> fields, DatadogSpan span) {
        String string;
        FeatureScope feature = this.sdkCore.getFeature("logs");
        if (feature == null || fields.isEmpty()) {
            if (feature == null) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.trace.internal.DatadogSpanLogger.sendLogEvent.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return DatadogSpanLogger.MISSING_LOG_FEATURE_INFO;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return;
            }
            return;
        }
        Object objRemove = fields.remove("message");
        if (objRemove == null || (string = objRemove.toString()) == null) {
            string = DEFAULT_EVENT_MESSAGE;
        }
        Object objRemove2 = fields.remove("status");
        if (objRemove2 == null) {
            objRemove2 = 2;
        }
        Object objRemove3 = fields.remove(DatadogTracingConstants.LogAttributes.TIMESTAMP_MS);
        Long l = objRemove3 instanceof Long ? (Long) objRemove3 : null;
        long jLongValue = l != null ? l.longValue() : this.sdkCore.getTimeProvider().getDeviceTimestampMillis();
        fields.put(LogAttributes.DD_TRACE_ID, span.context().getTraceId().toHexString());
        fields.put(LogAttributes.DD_SPAN_ID, String.valueOf(span.context().getSpanId()));
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("type", "span_log");
        mapCreateMapBuilder.put("loggerName", "trace");
        mapCreateMapBuilder.put("message", string);
        mapCreateMapBuilder.put(RumFeature.EVENT_ATTRIBUTES_PROPERTY, fields);
        mapCreateMapBuilder.put("timestamp", Long.valueOf(jLongValue));
        mapCreateMapBuilder.put("logStatus", objRemove2);
        feature.sendEvent(MapsKt.build(mapCreateMapBuilder));
    }
}
