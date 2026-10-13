package com.datadog.android.core.internal.metrics;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.metrics.MethodCallSamplingRate;
import com.datadog.android.core.metrics.PerformanceMetric;
import com.datadog.android.internal.time.TimeProvider;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MethodCalledTelemetry.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/core/internal/metrics/MethodCalledTelemetry;", "Lcom/datadog/android/core/metrics/PerformanceMetric;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "operationName", "", "callerClass", "creationSampleRate", "", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "(Lcom/datadog/android/api/InternalLogger;Ljava/lang/String;Ljava/lang/String;FLcom/datadog/android/internal/time/TimeProvider;)V", "getCallerClass$dd_sdk_android_core_release", "()Ljava/lang/String;", "getCreationSampleRate$dd_sdk_android_core_release", "()F", "getInternalLogger$dd_sdk_android_core_release", "()Lcom/datadog/android/api/InternalLogger;", "getOperationName$dd_sdk_android_core_release", "startTime", "", "getStartTime$dd_sdk_android_core_release", "()J", "getTimeProvider$dd_sdk_android_core_release", "()Lcom/datadog/android/internal/time/TimeProvider;", "stopAndSend", "", "isSuccessful", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MethodCalledTelemetry implements PerformanceMetric {
    public static final String CALLER_CLASS = "caller_class";
    public static final String EXECUTION_TIME = "execution_time";
    public static final String IS_SUCCESSFUL = "is_successful";
    public static final String METHOD_CALLED_METRIC_NAME = "[Mobile Metric] Method Called";
    public static final String METRIC_TYPE_VALUE = "method called";
    public static final String OPERATION_NAME = "operation_name";
    private final String callerClass;
    private final float creationSampleRate;
    private final InternalLogger internalLogger;
    private final String operationName;
    private final long startTime;
    private final TimeProvider timeProvider;

    public MethodCalledTelemetry(InternalLogger internalLogger, String operationName, String callerClass, float f, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(callerClass, "callerClass");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.internalLogger = internalLogger;
        this.operationName = operationName;
        this.callerClass = callerClass;
        this.creationSampleRate = f;
        this.timeProvider = timeProvider;
        this.startTime = timeProvider.getDeviceElapsedTimeNanos();
    }

    /* JADX INFO: renamed from: getInternalLogger$dd_sdk_android_core_release, reason: from getter */
    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    /* JADX INFO: renamed from: getOperationName$dd_sdk_android_core_release, reason: from getter */
    public final String getOperationName() {
        return this.operationName;
    }

    /* JADX INFO: renamed from: getCallerClass$dd_sdk_android_core_release, reason: from getter */
    public final String getCallerClass() {
        return this.callerClass;
    }

    /* JADX INFO: renamed from: getCreationSampleRate$dd_sdk_android_core_release, reason: from getter */
    public final float getCreationSampleRate() {
        return this.creationSampleRate;
    }

    /* JADX INFO: renamed from: getTimeProvider$dd_sdk_android_core_release, reason: from getter */
    public final TimeProvider getTimeProvider() {
        return this.timeProvider;
    }

    /* JADX INFO: renamed from: getStartTime$dd_sdk_android_core_release, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @Override // com.datadog.android.core.metrics.PerformanceMetric
    public void stopAndSend(boolean isSuccessful) {
        long deviceElapsedTimeNanos = this.timeProvider.getDeviceElapsedTimeNanos() - this.startTime;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EXECUTION_TIME, Long.valueOf(deviceElapsedTimeNanos));
        linkedHashMap.put(OPERATION_NAME, this.operationName);
        linkedHashMap.put(CALLER_CLASS, this.callerClass);
        linkedHashMap.put(IS_SUCCESSFUL, Boolean.valueOf(isSuccessful));
        linkedHashMap.put("metric_type", METRIC_TYPE_VALUE);
        this.internalLogger.logMetric(new Function0<String>() { // from class: com.datadog.android.core.internal.metrics.MethodCalledTelemetry.stopAndSend.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return MethodCalledTelemetry.METHOD_CALLED_METRIC_NAME;
            }
        }, linkedHashMap, MethodCallSamplingRate.ALL.getRate(), Float.valueOf(this.creationSampleRate));
    }
}
