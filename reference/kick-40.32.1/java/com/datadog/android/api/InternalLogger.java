package com.datadog.android.api;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.core.internal.logger.SdkInternalLogger;
import com.datadog.android.core.metrics.PerformanceMetric;
import com.datadog.android.core.metrics.TelemetryMetricType;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.internal.RumFeature;
import com.google.android.gms.cast.MediaError;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InternalLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 !2\u00020\u0001:\u0003!\"#JV\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010H&J\\\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010H&J \u0010\u0013\u001a\u00020\u00032\b\b\u0003\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\tH'JG\u0010\u0018\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00102\b\b\u0001\u0010\u0014\u001a\u00020\u00152\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\nH'¨\u0006$"}, d2 = {"Lcom/datadog/android/api/InternalLogger;", "", "log", "", FirebaseAnalytics.Param.LEVEL, "Lcom/datadog/android/api/InternalLogger$Level;", TypedValues.Attributes.S_TARGET, "Lcom/datadog/android/api/InternalLogger$Target;", "messageBuilder", "Lkotlin/Function0;", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onlyOnce", "", "additionalProperties", "", "targets", "", "logApiUsage", "samplingRate", "", "apiUsageEventBuilder", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "logMetric", "creationSampleRate", "(Lkotlin/jvm/functions/Function0;Ljava/util/Map;FLjava/lang/Float;)V", "startPerformanceMeasure", "Lcom/datadog/android/core/metrics/PerformanceMetric;", "callerClass", "metric", "Lcom/datadog/android/core/metrics/TelemetryMetricType;", "operationName", "Companion", "Level", "Target", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface InternalLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: InternalLogger.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/datadog/android/api/InternalLogger$Level;", "", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARN", MediaError.ERROR_TYPE_ERROR, "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    /* JADX INFO: compiled from: InternalLogger.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/api/InternalLogger$Target;", "", "(Ljava/lang/String;I)V", "USER", "MAINTAINER", "TELEMETRY", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Target {
        USER,
        MAINTAINER,
        TELEMETRY
    }

    void log(Level level, Target target, Function0<String> messageBuilder, Throwable throwable, boolean onlyOnce, Map<String, ? extends Object> additionalProperties);

    void log(Level level, List<? extends Target> targets, Function0<String> messageBuilder, Throwable throwable, boolean onlyOnce, Map<String, ? extends Object> additionalProperties);

    void logApiUsage(float samplingRate, Function0<? extends InternalTelemetryEvent.ApiUsage> apiUsageEventBuilder);

    void logMetric(Function0<String> messageBuilder, Map<String, ? extends Object> additionalProperties, float samplingRate, Float creationSampleRate);

    PerformanceMetric startPerformanceMeasure(String callerClass, TelemetryMetricType metric, float samplingRate, String operationName);

    /* JADX INFO: compiled from: InternalLogger.kt */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void log$default(InternalLogger internalLogger, Level level, Target target, Function0 function0, Throwable th, boolean z, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
            }
            if ((i & 8) != 0) {
                th = null;
            }
            if ((i & 16) != 0) {
                z = false;
            }
            if ((i & 32) != 0) {
                map = null;
            }
            internalLogger.log(level, target, (Function0<String>) function0, th, z, (Map<String, ? extends Object>) map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void log$default(InternalLogger internalLogger, Level level, List list, Function0 function0, Throwable th, boolean z, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
            }
            if ((i & 8) != 0) {
                th = null;
            }
            if ((i & 16) != 0) {
                z = false;
            }
            if ((i & 32) != 0) {
                map = null;
            }
            internalLogger.log(level, (List<? extends Target>) list, (Function0<String>) function0, th, z, (Map<String, ? extends Object>) map);
        }

        public static /* synthetic */ void logMetric$default(InternalLogger internalLogger, Function0 function0, Map map, float f, Float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logMetric");
            }
            if ((i & 8) != 0) {
                f2 = null;
            }
            internalLogger.logMetric(function0, map, f, f2);
        }

        public static /* synthetic */ void logApiUsage$default(InternalLogger internalLogger, float f, Function0 function0, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logApiUsage");
            }
            if ((i & 1) != 0) {
                f = 15.0f;
            }
            internalLogger.logApiUsage(f, function0);
        }
    }

    /* JADX INFO: compiled from: InternalLogger.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/api/InternalLogger$Companion;", "", "()V", "DEFAULT_API_USAGE_TELEMETRY_SAMPLING_RATE", "", "UNBOUND", "Lcom/datadog/android/api/InternalLogger;", "getUNBOUND", "()Lcom/datadog/android/api/InternalLogger;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private static final float DEFAULT_API_USAGE_TELEMETRY_SAMPLING_RATE = 15.0f;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final InternalLogger UNBOUND = new SdkInternalLogger(null, null, null, 6, null);

        private Companion() {
        }

        public final InternalLogger getUNBOUND() {
            return UNBOUND;
        }
    }
}
