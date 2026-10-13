package com.datadog.android.log.internal.logger;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.core.sampling.RateBasedSampler;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.log.internal.LogsFeature;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogLogHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\b\u0000\u0018\u0000 =2\u00020\u0001:\u0001=Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014Jt\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u00032\b\u0010+\u001a\u0004\u0018\u00010\u00032\b\u0010,\u001a\u0004\u0018\u00010\u00032\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010/0.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u0003012\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u000204H\u0002J`\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u0001062\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010/0.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u0003012\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u000204H\u0002Ji\u00107\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u00032\b\u0010+\u001a\u0004\u0018\u00010\u00032\b\u00108\u001a\u0004\u0018\u00010\u00032\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010/0.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u0003012\b\u00103\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0002\u00109JU\u00107\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u0001062\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010/0.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u0003012\b\u00103\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\u0011H\u0002J\b\u0010<\u001a\u00020\u0011H\u0002R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000e\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\r\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006>"}, d2 = {"Lcom/datadog/android/log/internal/logger/DatadogLogHandler;", "Lcom/datadog/android/log/internal/logger/LogHandler;", "loggerName", "", "logGenerator", "Lcom/datadog/android/log/internal/domain/LogGenerator;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "Lcom/datadog/android/log/model/LogEvent;", "attachNetworkInfo", "", "bundleWithTraces", "bundleWithRum", "sampler", "Lcom/datadog/android/core/sampling/Sampler;", "", "minLogPriority", "", "(Ljava/lang/String;Lcom/datadog/android/log/internal/domain/LogGenerator;Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/api/storage/DataWriter;ZZZLcom/datadog/android/core/sampling/Sampler;I)V", "getAttachNetworkInfo$dd_sdk_android_logs_release", "()Z", "getBundleWithRum$dd_sdk_android_logs_release", "getBundleWithTraces$dd_sdk_android_logs_release", "getLogGenerator$dd_sdk_android_logs_release", "()Lcom/datadog/android/log/internal/domain/LogGenerator;", "getLoggerName$dd_sdk_android_logs_release", "()Ljava/lang/String;", "getMinLogPriority$dd_sdk_android_logs_release", "()I", "getSampler$dd_sdk_android_logs_release", "()Lcom/datadog/android/core/sampling/Sampler;", "getSdkCore$dd_sdk_android_logs_release", "()Lcom/datadog/android/api/feature/FeatureSdkCore;", "getWriter$dd_sdk_android_logs_release", "()Lcom/datadog/android/api/storage/DataWriter;", "createLog", FirebaseAnalytics.Param.LEVEL, "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "message", "errorKind", "errorMessage", "errorStack", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "tags", "", "threadName", "timestamp", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "handleLog", "errorStacktrace", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", "logLogsFeatureIsNotRegistered", "logRumFeatureIsNotRegistered", "Companion", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogLogHandler implements LogHandler {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final float DEFAULT_SAMPLE_RATE = 100.0f;

    @Deprecated
    public static final String LOGS_FEATURE_NOT_REGISTERED = "Requested to write log, but Logs feature is not registered.";

    @Deprecated
    public static final String RUM_FEATURE_NOT_REGISTERED = "Requested to forward error log to RUM, but RUM feature is not registered.";
    private final boolean attachNetworkInfo;
    private final boolean bundleWithRum;
    private final boolean bundleWithTraces;
    private final LogGenerator logGenerator;
    private final String loggerName;
    private final int minLogPriority;
    private final Sampler<Unit> sampler;
    private final FeatureSdkCore sdkCore;
    private final DataWriter<LogEvent> writer;

    public DatadogLogHandler(String loggerName, LogGenerator logGenerator, FeatureSdkCore sdkCore, DataWriter<LogEvent> writer, boolean z, boolean z2, boolean z3, Sampler<Unit> sampler, int i) {
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(logGenerator, "logGenerator");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(sampler, "sampler");
        this.loggerName = loggerName;
        this.logGenerator = logGenerator;
        this.sdkCore = sdkCore;
        this.writer = writer;
        this.attachNetworkInfo = z;
        this.bundleWithTraces = z2;
        this.bundleWithRum = z3;
        this.sampler = sampler;
        this.minLogPriority = i;
    }

    /* JADX INFO: renamed from: getLoggerName$dd_sdk_android_logs_release, reason: from getter */
    public final String getLoggerName() {
        return this.loggerName;
    }

    /* JADX INFO: renamed from: getLogGenerator$dd_sdk_android_logs_release, reason: from getter */
    public final LogGenerator getLogGenerator() {
        return this.logGenerator;
    }

    /* JADX INFO: renamed from: getSdkCore$dd_sdk_android_logs_release, reason: from getter */
    public final FeatureSdkCore getSdkCore() {
        return this.sdkCore;
    }

    public final DataWriter<LogEvent> getWriter$dd_sdk_android_logs_release() {
        return this.writer;
    }

    /* JADX INFO: renamed from: getAttachNetworkInfo$dd_sdk_android_logs_release, reason: from getter */
    public final boolean getAttachNetworkInfo() {
        return this.attachNetworkInfo;
    }

    /* JADX INFO: renamed from: getBundleWithTraces$dd_sdk_android_logs_release, reason: from getter */
    public final boolean getBundleWithTraces() {
        return this.bundleWithTraces;
    }

    /* JADX INFO: renamed from: getBundleWithRum$dd_sdk_android_logs_release, reason: from getter */
    public final boolean getBundleWithRum() {
        return this.bundleWithRum;
    }

    public /* synthetic */ DatadogLogHandler(String str, LogGenerator logGenerator, FeatureSdkCore featureSdkCore, DataWriter dataWriter, boolean z, boolean z2, boolean z3, RateBasedSampler rateBasedSampler, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, logGenerator, featureSdkCore, dataWriter, z, (i2 & 32) != 0 ? true : z2, (i2 & 64) != 0 ? true : z3, (i2 & 128) != 0 ? new RateBasedSampler(100.0f) : rateBasedSampler, (i2 & 256) != 0 ? -1 : i);
    }

    public final Sampler<Unit> getSampler$dd_sdk_android_logs_release() {
        return this.sampler;
    }

    /* JADX INFO: renamed from: getMinLogPriority$dd_sdk_android_logs_release, reason: from getter */
    public final int getMinLogPriority() {
        return this.minLogPriority;
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(final int level, final String message, final Throwable throwable, Map<String, ? extends Object> attributes, final Set<String> tags, Long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (level < this.minLogPriority) {
            return;
        }
        final long jLongValue = timestamp != null ? timestamp.longValue() : this.sdkCore.getTimeProvider().getDeviceTimestampMillis();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        FeatureScope feature = this.sdkCore.getFeature("logs");
        if (feature != null) {
            linkedHashMap.putAll(MapsKt.toMutableMap(((LogsFeature) feature.unwrap()).getAttributes$dd_sdk_android_logs_release()));
        }
        linkedHashMap.putAll(attributes);
        if (this.sampler.sample(Unit.INSTANCE)) {
            if (feature != null) {
                final String name = Thread.currentThread().getName();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (this.bundleWithRum) {
                    linkedHashSet.add("rum");
                }
                if (this.bundleWithTraces) {
                    linkedHashSet.add("tracing");
                }
                feature.withWriteContext(linkedHashSet, new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
                        invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
                        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
                        DatadogLogHandler datadogLogHandler = DatadogLogHandler.this;
                        int i = level;
                        String str = message;
                        Throwable th = throwable;
                        Map<String, Object> map = linkedHashMap;
                        Set<String> set = tags;
                        String threadName = name;
                        Intrinsics.checkNotNullExpressionValue(threadName, "threadName");
                        final LogEvent logEventCreateLog = datadogLogHandler.createLog(i, datadogContext, str, th, map, set, threadName, jLongValue);
                        if (logEventCreateLog != null) {
                            final DatadogLogHandler datadogLogHandler2 = DatadogLogHandler.this;
                            writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                                    invoke2(eventBatchWriter);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(EventBatchWriter it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    datadogLogHandler2.getWriter$dd_sdk_android_logs_release().write(it, logEventCreateLog, EventType.DEFAULT);
                                }
                            });
                        }
                    }
                });
            } else {
                logLogsFeatureIsNotRegistered();
            }
        }
        if (level >= 6) {
            FeatureScope feature2 = this.sdkCore.getFeature("rum");
            if (feature2 != null) {
                feature2.sendEvent(MapsKt.mapOf(TuplesKt.to("type", RumFeature.LOGGER_ERROR_BUS_MESSAGE_TYPE), TuplesKt.to("message", message), TuplesKt.to(RumFeature.EVENT_THROWABLE_PROPERTY, throwable), TuplesKt.to(RumFeature.EVENT_ATTRIBUTES_PROPERTY, linkedHashMap)));
            } else {
                logRumFeatureIsNotRegistered();
            }
        }
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(final int level, final String message, final String errorKind, final String errorMessage, final String errorStacktrace, Map<String, ? extends Object> attributes, final Set<String> tags, Long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (level < this.minLogPriority) {
            return;
        }
        final long jLongValue = timestamp != null ? timestamp.longValue() : this.sdkCore.getTimeProvider().getDeviceTimestampMillis();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        FeatureScope feature = this.sdkCore.getFeature("logs");
        if (feature != null) {
            linkedHashMap.putAll(MapsKt.toMutableMap(((LogsFeature) feature.unwrap()).getAttributes$dd_sdk_android_logs_release()));
        }
        linkedHashMap.putAll(attributes);
        if (this.sampler.sample(Unit.INSTANCE)) {
            if (feature != null) {
                final String name = Thread.currentThread().getName();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (this.bundleWithRum) {
                    linkedHashSet.add("rum");
                }
                if (this.bundleWithTraces) {
                    linkedHashSet.add("tracing");
                }
                feature.withWriteContext(linkedHashSet, new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
                        invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
                        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
                        DatadogLogHandler datadogLogHandler = DatadogLogHandler.this;
                        int i = level;
                        String str = message;
                        String str2 = errorKind;
                        String str3 = errorMessage;
                        String str4 = errorStacktrace;
                        Map<String, Object> map = linkedHashMap;
                        Set<String> set = tags;
                        String threadName = name;
                        Intrinsics.checkNotNullExpressionValue(threadName, "threadName");
                        final LogEvent logEventCreateLog = datadogLogHandler.createLog(i, datadogContext, str, str2, str3, str4, map, set, threadName, jLongValue);
                        if (logEventCreateLog != null) {
                            final DatadogLogHandler datadogLogHandler2 = DatadogLogHandler.this;
                            writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                                    invoke2(eventBatchWriter);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(EventBatchWriter it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    datadogLogHandler2.getWriter$dd_sdk_android_logs_release().write(it, logEventCreateLog, EventType.DEFAULT);
                                }
                            });
                        }
                    }
                });
            } else {
                logLogsFeatureIsNotRegistered();
            }
        }
        if (level >= 6) {
            FeatureScope feature2 = this.sdkCore.getFeature("rum");
            if (feature2 != null) {
                feature2.sendEvent(MapsKt.mapOf(TuplesKt.to("type", RumFeature.LOGGER_ERROR_WITH_STACK_TRACE_MESSAGE_TYPE), TuplesKt.to("message", message), TuplesKt.to("stacktrace", errorStacktrace), TuplesKt.to(RumFeature.EVENT_ATTRIBUTES_PROPERTY, linkedHashMap)));
            } else {
                logRumFeatureIsNotRegistered();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LogEvent createLog(int level, DatadogContext datadogContext, String message, Throwable throwable, Map<String, ? extends Object> attributes, Set<String> tags, String threadName, long timestamp) {
        return LogGenerator.DefaultImpls.generateLog$default(this.logGenerator, level, message, throwable, attributes, tags, timestamp, threadName, datadogContext, this.attachNetworkInfo, this.loggerName, this.bundleWithTraces, this.bundleWithRum, null, null, null, null, 61440, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LogEvent createLog(int level, DatadogContext datadogContext, String message, String errorKind, String errorMessage, String errorStack, Map<String, ? extends Object> attributes, Set<String> tags, String threadName, long timestamp) {
        return LogGenerator.DefaultImpls.generateLog$default(this.logGenerator, level, message, errorKind, errorMessage, errorStack, attributes, tags, timestamp, threadName, datadogContext, this.attachNetworkInfo, this.loggerName, this.bundleWithTraces, this.bundleWithRum, null, null, null, 114688, null);
    }

    private final void logLogsFeatureIsNotRegistered() {
        InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.logLogsFeatureIsNotRegistered.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return DatadogLogHandler.LOGS_FEATURE_NOT_REGISTERED;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private final void logRumFeatureIsNotRegistered() {
        InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.logRumFeatureIsNotRegistered.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return DatadogLogHandler.RUM_FEATURE_NOT_REGISTERED;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    /* JADX INFO: compiled from: DatadogLogHandler.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/datadog/android/log/internal/logger/DatadogLogHandler$Companion;", "", "()V", "DEFAULT_SAMPLE_RATE", "", "LOGS_FEATURE_NOT_REGISTERED", "", "RUM_FEATURE_NOT_REGISTERED", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
