package com.datadog.android.api;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.core.metrics.PerformanceMetric;
import com.datadog.android.core.metrics.TelemetryMetricType;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpInternalLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0016JV\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0016J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nH\u0016JC\u0010\u001a\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u001cJ*\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u000bH\u0016¨\u0006#"}, d2 = {"Lcom/datadog/android/api/NoOpInternalLogger;", "Lcom/datadog/android/api/InternalLogger;", "()V", "log", "", FirebaseAnalytics.Param.LEVEL, "Lcom/datadog/android/api/InternalLogger$Level;", TypedValues.Attributes.S_TARGET, "Lcom/datadog/android/api/InternalLogger$Target;", "messageBuilder", "Lkotlin/Function0;", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onlyOnce", "", "additionalProperties", "", "", "targets", "", "logApiUsage", "samplingRate", "", "apiUsageEventBuilder", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "logMetric", "creationSampleRate", "(Lkotlin/jvm/functions/Function0;Ljava/util/Map;FLjava/lang/Float;)V", "startPerformanceMeasure", "Lcom/datadog/android/core/metrics/PerformanceMetric;", "callerClass", "metric", "Lcom/datadog/android/core/metrics/TelemetryMetricType;", "operationName", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpInternalLogger implements InternalLogger {
    @Override // com.datadog.android.api.InternalLogger
    public void log(InternalLogger.Level level, InternalLogger.Target target, Function0<String> messageBuilder, Throwable throwable, boolean onlyOnce, Map<String, ? extends Object> additionalProperties) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
    }

    @Override // com.datadog.android.api.InternalLogger
    public void log(InternalLogger.Level level, List<? extends InternalLogger.Target> targets, Function0<String> messageBuilder, Throwable throwable, boolean onlyOnce, Map<String, ? extends Object> additionalProperties) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(targets, "targets");
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
    }

    @Override // com.datadog.android.api.InternalLogger
    public void logApiUsage(float samplingRate, Function0<? extends InternalTelemetryEvent.ApiUsage> apiUsageEventBuilder) {
        Intrinsics.checkNotNullParameter(apiUsageEventBuilder, "apiUsageEventBuilder");
    }

    @Override // com.datadog.android.api.InternalLogger
    public void logMetric(Function0<String> messageBuilder, Map<String, ? extends Object> additionalProperties, float samplingRate, Float creationSampleRate) {
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
    }

    @Override // com.datadog.android.api.InternalLogger
    public PerformanceMetric startPerformanceMeasure(String callerClass, TelemetryMetricType metric, float samplingRate, String operationName) {
        Intrinsics.checkNotNullParameter(callerClass, "callerClass");
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        return null;
    }
}
