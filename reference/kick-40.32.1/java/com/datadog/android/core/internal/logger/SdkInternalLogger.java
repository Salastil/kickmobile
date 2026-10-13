package com.datadog.android.core.internal.logger;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.BuildConfig;
import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.DatadogCore;
import com.datadog.android.core.internal.metrics.MethodCalledTelemetry;
import com.datadog.android.core.metrics.PerformanceMetric;
import com.datadog.android.core.metrics.TelemetryMetricType;
import com.datadog.android.core.sampling.RateBasedSampler;
import com.datadog.android.internal.attributes.LocalAttribute;
import com.datadog.android.internal.attributes.LocalAttributeKt;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.internal.time.DefaultTimeProvider;
import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkInternalLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 <2\u00020\u0001:\u0001<B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\bJP\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001fH\u0016JV\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\"2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001fH\u0016J\u001e\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0005H\u0016JC\u0010(\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f2\u0006\u0010$\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u0010*J0\u0010+\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\b\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002JH\u0010-\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\b\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001fH\u0002J0\u0010.\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\b\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010/\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%JF\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\b\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J*\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u0002072\u0006\u0010$\u001a\u00020%2\u0006\u00108\u001a\u00020\u000eH\u0016J\f\u00109\u001a\u00020:*\u00020\u0016H\u0002J\f\u0010;\u001a\u00020\u000e*\u00020\u000eH\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006="}, d2 = {"Lcom/datadog/android/core/internal/logger/SdkInternalLogger;", "Lcom/datadog/android/api/InternalLogger;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "userLogHandlerFactory", "Lkotlin/Function0;", "Lcom/datadog/android/core/internal/logger/LogcatLogHandler;", "maintainerLogHandlerFactory", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "maintainerLogger", "getMaintainerLogger$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/logger/LogcatLogHandler;", "onlyOnceMaintainerMessages", "", "", "onlyOnceTelemetryMessages", "onlyOnceUserMessages", "userLogger", "getUserLogger$dd_sdk_android_core_release", "log", "", FirebaseAnalytics.Param.LEVEL, "Lcom/datadog/android/api/InternalLogger$Level;", TypedValues.Attributes.S_TARGET, "Lcom/datadog/android/api/InternalLogger$Target;", "messageBuilder", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onlyOnce", "", "additionalProperties", "", "", "targets", "", "logApiUsage", "samplingRate", "", "apiUsageEventBuilder", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "logMetric", "creationSampleRate", "(Lkotlin/jvm/functions/Function0;Ljava/util/Map;FLjava/lang/Float;)V", "logToMaintainer", "error", "logToTelemetry", "logToUser", "sample", "sendToLogHandler", "handler", "knownSingleMessages", "startPerformanceMeasure", "Lcom/datadog/android/core/metrics/PerformanceMetric;", "callerClass", "metric", "Lcom/datadog/android/core/metrics/TelemetryMetricType;", "operationName", "toLogLevel", "", "withSdkName", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SdkInternalLogger implements InternalLogger {
    public static final String DEV_LOG_TAG = "Datadog";
    public static final String SDK_LOG_TAG = "DD_LOG";
    private final LogcatLogHandler maintainerLogger;
    private final Set<String> onlyOnceMaintainerMessages;
    private final Set<String> onlyOnceTelemetryMessages;
    private final Set<String> onlyOnceUserMessages;
    private final FeatureSdkCore sdkCore;
    private final LogcatLogHandler userLogger;

    /* JADX INFO: compiled from: SdkInternalLogger.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[InternalLogger.Target.values().length];
            try {
                iArr[InternalLogger.Target.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InternalLogger.Target.MAINTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InternalLogger.Target.TELEMETRY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TelemetryMetricType.values().length];
            try {
                iArr2[TelemetryMetricType.MethodCalled.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[InternalLogger.Level.values().length];
            try {
                iArr3[InternalLogger.Level.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[InternalLogger.Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[InternalLogger.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[InternalLogger.Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[InternalLogger.Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public SdkInternalLogger(FeatureSdkCore featureSdkCore, Function0<LogcatLogHandler> userLogHandlerFactory, Function0<LogcatLogHandler> maintainerLogHandlerFactory) {
        Intrinsics.checkNotNullParameter(userLogHandlerFactory, "userLogHandlerFactory");
        Intrinsics.checkNotNullParameter(maintainerLogHandlerFactory, "maintainerLogHandlerFactory");
        this.sdkCore = featureSdkCore;
        this.userLogger = userLogHandlerFactory.invoke();
        this.maintainerLogger = maintainerLogHandlerFactory.invoke();
        this.onlyOnceUserMessages = new LinkedHashSet();
        this.onlyOnceMaintainerMessages = new LinkedHashSet();
        this.onlyOnceTelemetryMessages = new LinkedHashSet();
    }

    public /* synthetic */ SdkInternalLogger(FeatureSdkCore featureSdkCore, AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, (i & 2) != 0 ? new Function0<LogcatLogHandler>() { // from class: com.datadog.android.core.internal.logger.SdkInternalLogger.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LogcatLogHandler invoke() {
                return new LogcatLogHandler(SdkInternalLogger.DEV_LOG_TAG, new Function1<Integer, Boolean>() { // from class: com.datadog.android.core.internal.logger.SdkInternalLogger.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Boolean invoke(int i2) {
                        return Boolean.valueOf(i2 >= Datadog.getVerbosity());
                    }
                });
            }
        } : anonymousClass1, (i & 4) != 0 ? new Function0<LogcatLogHandler>() { // from class: com.datadog.android.core.internal.logger.SdkInternalLogger.2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final LogcatLogHandler invoke() {
                Boolean LOGCAT_ENABLED = BuildConfig.LOGCAT_ENABLED;
                Intrinsics.checkNotNullExpressionValue(LOGCAT_ENABLED, "LOGCAT_ENABLED");
                Function1 function1 = null;
                Object[] objArr = 0;
                if (LOGCAT_ENABLED.booleanValue()) {
                    return new LogcatLogHandler(SdkInternalLogger.SDK_LOG_TAG, function1, 2, objArr == true ? 1 : 0);
                }
                return null;
            }
        } : anonymousClass2);
    }

    /* JADX INFO: renamed from: getUserLogger$dd_sdk_android_core_release, reason: from getter */
    public final LogcatLogHandler getUserLogger() {
        return this.userLogger;
    }

    /* JADX INFO: renamed from: getMaintainerLogger$dd_sdk_android_core_release, reason: from getter */
    public final LogcatLogHandler getMaintainerLogger() {
        return this.maintainerLogger;
    }

    @Override // com.datadog.android.api.InternalLogger
    public void log(InternalLogger.Level level, InternalLogger.Target target, Function0<String> messageBuilder, Throwable throwable, boolean onlyOnce, Map<String, ? extends Object> additionalProperties) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        int i = WhenMappings.$EnumSwitchMapping$0[target.ordinal()];
        if (i == 1) {
            logToUser(level, messageBuilder, throwable, onlyOnce);
        } else if (i == 2) {
            logToMaintainer(level, messageBuilder, throwable, onlyOnce);
        } else {
            if (i != 3) {
                return;
            }
            logToTelemetry(level, messageBuilder, throwable, onlyOnce, additionalProperties);
        }
    }

    @Override // com.datadog.android.api.InternalLogger
    public void log(InternalLogger.Level level, List<? extends InternalLogger.Target> targets, Function0<String> messageBuilder, Throwable throwable, boolean onlyOnce, Map<String, ? extends Object> additionalProperties) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(targets, "targets");
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        Iterator<T> it = targets.iterator();
        while (it.hasNext()) {
            log(level, (InternalLogger.Target) it.next(), messageBuilder, throwable, onlyOnce, additionalProperties);
        }
    }

    @Override // com.datadog.android.api.InternalLogger
    public void logMetric(Function0<String> messageBuilder, Map<String, ? extends Object> additionalProperties, float samplingRate, Float creationSampleRate) {
        FeatureSdkCore featureSdkCore;
        FeatureScope feature;
        CoreFeature coreFeature$dd_sdk_android_core_release;
        Float metricTelemetrySampleRateBypass$dd_sdk_android_core_release;
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
        FeatureSdkCore featureSdkCore2 = this.sdkCore;
        DatadogCore datadogCore = featureSdkCore2 instanceof DatadogCore ? (DatadogCore) featureSdkCore2 : null;
        if (datadogCore != null && (coreFeature$dd_sdk_android_core_release = datadogCore.getCoreFeature$dd_sdk_android_core_release()) != null && (metricTelemetrySampleRateBypass$dd_sdk_android_core_release = coreFeature$dd_sdk_android_core_release.getMetricTelemetrySampleRateBypass()) != null) {
            samplingRate = metricTelemetrySampleRateBypass$dd_sdk_android_core_release.floatValue();
        }
        if (!sample(samplingRate) || (featureSdkCore = this.sdkCore) == null || (feature = featureSdkCore.getFeature("rum")) == null) {
            return;
        }
        feature.sendEvent(new InternalTelemetryEvent.Metric(messageBuilder.invoke(), LocalAttributeKt.enrichWithNonNullAttribute(LocalAttributeKt.enrichWithNonNullAttribute(MapsKt.toMutableMap(additionalProperties), LocalAttribute.Key.CREATION_SAMPLING_RATE, creationSampleRate), LocalAttribute.Key.REPORTING_SAMPLING_RATE, Float.valueOf(samplingRate))));
    }

    @Override // com.datadog.android.api.InternalLogger
    public PerformanceMetric startPerformanceMeasure(String callerClass, TelemetryMetricType metric, float samplingRate, String operationName) {
        DefaultTimeProvider defaultTimeProvider;
        Intrinsics.checkNotNullParameter(callerClass, "callerClass");
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        if (!sample(samplingRate)) {
            return null;
        }
        if (WhenMappings.$EnumSwitchMapping$1[metric.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        SdkInternalLogger sdkInternalLogger = this;
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (featureSdkCore == null || (defaultTimeProvider = featureSdkCore.getTimeProvider()) == null) {
            defaultTimeProvider = new DefaultTimeProvider();
        }
        return new MethodCalledTelemetry(sdkInternalLogger, operationName, callerClass, samplingRate, defaultTimeProvider);
    }

    @Override // com.datadog.android.api.InternalLogger
    public void logApiUsage(float samplingRate, Function0<? extends InternalTelemetryEvent.ApiUsage> apiUsageEventBuilder) {
        FeatureSdkCore featureSdkCore;
        FeatureScope feature;
        Intrinsics.checkNotNullParameter(apiUsageEventBuilder, "apiUsageEventBuilder");
        if (!sample(samplingRate) || (featureSdkCore = this.sdkCore) == null || (feature = featureSdkCore.getFeature("rum")) == null) {
            return;
        }
        InternalTelemetryEvent.ApiUsage apiUsageInvoke = apiUsageEventBuilder.invoke();
        LocalAttributeKt.enrichWithNonNullAttribute(apiUsageInvoke.getAdditionalProperties(), LocalAttribute.Key.REPORTING_SAMPLING_RATE, Float.valueOf(samplingRate));
        feature.sendEvent(apiUsageInvoke);
    }

    public final boolean sample(float samplingRate) {
        return new RateBasedSampler(samplingRate).sample(Unit.INSTANCE);
    }

    private final void logToUser(InternalLogger.Level level, Function0<String> messageBuilder, Throwable error, boolean onlyOnce) {
        sendToLogHandler(this.userLogger, level, messageBuilder, error, onlyOnce, this.onlyOnceUserMessages);
    }

    private final void logToMaintainer(InternalLogger.Level level, Function0<String> messageBuilder, Throwable error, boolean onlyOnce) {
        LogcatLogHandler logcatLogHandler = this.maintainerLogger;
        if (logcatLogHandler != null) {
            sendToLogHandler(logcatLogHandler, level, messageBuilder, error, onlyOnce, this.onlyOnceMaintainerMessages);
        }
    }

    private final void sendToLogHandler(LogcatLogHandler handler, InternalLogger.Level level, Function0<String> messageBuilder, Throwable error, boolean onlyOnce, Set<String> knownSingleMessages) {
        if (handler.canLog(toLogLevel(level))) {
            String strWithSdkName = withSdkName(messageBuilder.invoke());
            if (onlyOnce) {
                if (knownSingleMessages.contains(strWithSdkName)) {
                    return;
                } else {
                    knownSingleMessages.add(strWithSdkName);
                }
            }
            handler.log(toLogLevel(level), strWithSdkName, error);
        }
    }

    private final void logToTelemetry(InternalLogger.Level level, Function0<String> messageBuilder, Throwable error, boolean onlyOnce, Map<String, ? extends Object> additionalProperties) {
        FeatureScope feature;
        InternalTelemetryEvent.Log.Error error2;
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (featureSdkCore == null || (feature = featureSdkCore.getFeature("rum")) == null) {
            return;
        }
        String strInvoke = messageBuilder.invoke();
        if (onlyOnce) {
            if (this.onlyOnceTelemetryMessages.contains(strInvoke)) {
                return;
            } else {
                this.onlyOnceTelemetryMessages.add(strInvoke);
            }
        }
        if (level == InternalLogger.Level.ERROR || level == InternalLogger.Level.WARN || error != null) {
            error2 = new InternalTelemetryEvent.Log.Error(strInvoke, additionalProperties, error, null, null, 24, null);
        } else {
            error2 = new InternalTelemetryEvent.Log.Debug(strInvoke, additionalProperties);
        }
        feature.sendEvent(error2);
    }

    private final int toLogLevel(InternalLogger.Level level) {
        int i = WhenMappings.$EnumSwitchMapping$2[level.ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (i == 5) {
            return 6;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String withSdkName(String str) {
        FeatureSdkCore featureSdkCore = this.sdkCore;
        String name = featureSdkCore != null ? featureSdkCore.getName() : null;
        if (name == null) {
            return str;
        }
        return "[" + name + "]: " + str;
    }
}
