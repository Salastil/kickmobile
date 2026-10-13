package com.datadog.android.core.internal.metrics;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.configuration.DataUploadConfiguration;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.advanced.FeatureFileOrchestrator;
import com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.privacy.TrackingConsent;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BatchMetricsDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J(\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010%\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u001b\u0010'\u001a\u0004\u0018\u00010(*\u00020\u001a2\u0006\u0010)\u001a\u00020\nH\u0002¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u0004\u0018\u00010\u0004*\u00020\u001aH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/datadog/android/core/internal/metrics/BatchMetricsDispatcher;", "Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;", "Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor$Callback;", "featureName", "", "uploadConfiguration", "Lcom/datadog/android/core/internal/configuration/DataUploadConfiguration;", "filePersistenceConfig", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "(Ljava/lang/String;Lcom/datadog/android/core/internal/configuration/DataUploadConfiguration;Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/internal/time/TimeProvider;)V", "isInBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "trackName", "onPaused", "", "onResumed", "onStarted", "onStopped", "resolveBatchClosedMetricAttributes", "", "", "file", "Ljava/io/File;", "batchMetadata", "Lcom/datadog/android/core/internal/metrics/BatchClosedMetadata;", "resolveBatchDeletedMetricAttributes", "deletionReason", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "numPendingBatches", "", "resolveTrackName", "sendBatchClosedMetric", "batchFile", "sendBatchDeletedMetric", "removalReason", "nameAsTimestampSafe", "", "logger", "(Ljava/io/File;Lcom/datadog/android/api/InternalLogger;)Ljava/lang/Long;", "resolveFileOriginAsConsent", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BatchMetricsDispatcher implements MetricsDispatcher, ProcessLifecycleMonitor.Callback {
    public static final String BATCH_AGE_KEY = "batch_age";
    public static final String BATCH_CLOSED_MESSAGE = "[Mobile Metric] Batch Closed";
    public static final String BATCH_CLOSED_TYPE_VALUE = "batch closed";
    public static final String BATCH_DELETED_MESSAGE = "[Mobile Metric] Batch Deleted";
    public static final String BATCH_DELETED_TYPE_VALUE = "batch deleted";
    public static final String BATCH_DURATION_KEY = "batch_duration";
    public static final String BATCH_EVENTS_COUNT_KEY = "batch_events_count";
    public static final String BATCH_REMOVAL_KEY = "batch_removal_reason";
    public static final String BATCH_SIZE_KEY = "batch_size";
    public static final String FILE_NAME = "filename";
    public static final String IN_BACKGROUND_KEY = "in_background";
    public static final String LOGS_TRACK_NAME = "logs";
    public static final String PENDING_BATCHES = "pending_batches";
    public static final String RUM_TRACK_NAME = "rum";
    public static final String SR_RESOURCES_TRACK_NAME = "sr-resources";
    public static final String SR_TRACK_NAME = "sr";
    public static final String THREAD_NAME = "thread";
    public static final String TRACE_TRACK_NAME = "trace";
    public static final String TRACKING_CONSENT_KEY = "consent";
    public static final String TRACK_KEY = "track";
    public static final String TYPE_KEY = "metric_type";
    public static final String UPLOADER_DELAY_KEY = "uploader_delay";
    public static final String UPLOADER_DELAY_MAX_KEY = "max";
    public static final String UPLOADER_DELAY_MIN_KEY = "min";
    public static final String UPLOADER_WINDOW_KEY = "uploader_window";
    public static final String WRONG_FILE_NAME_MESSAGE_FORMAT = "Unable to parse the file name as a timestamp: %s";
    private final FilePersistenceConfig filePersistenceConfig;
    private final InternalLogger internalLogger;
    private final AtomicBoolean isInBackground;
    private final TimeProvider timeProvider;
    private final String trackName;
    private final DataUploadConfiguration uploadConfiguration;

    @Override // com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onStarted() {
    }

    @Override // com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onStopped() {
    }

    public BatchMetricsDispatcher(String featureName, DataUploadConfiguration dataUploadConfiguration, FilePersistenceConfig filePersistenceConfig, InternalLogger internalLogger, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.uploadConfiguration = dataUploadConfiguration;
        this.filePersistenceConfig = filePersistenceConfig;
        this.internalLogger = internalLogger;
        this.timeProvider = timeProvider;
        this.trackName = resolveTrackName(featureName);
        this.isInBackground = new AtomicBoolean(true);
    }

    @Override // com.datadog.android.core.internal.metrics.MetricsDispatcher
    public void sendBatchDeletedMetric(File batchFile, RemovalReason removalReason, int numPendingBatches) {
        Map<String, Object> mapResolveBatchDeletedMetricAttributes;
        Intrinsics.checkNotNullParameter(batchFile, "batchFile");
        Intrinsics.checkNotNullParameter(removalReason, "removalReason");
        if (!removalReason.includeInMetrics$dd_sdk_android_core_release() || this.trackName == null || (mapResolveBatchDeletedMetricAttributes = resolveBatchDeletedMetricAttributes(batchFile, removalReason, numPendingBatches)) == null) {
            return;
        }
        InternalLogger.DefaultImpls.logMetric$default(this.internalLogger, new Function0<String>() { // from class: com.datadog.android.core.internal.metrics.BatchMetricsDispatcher$sendBatchDeletedMetric$1$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return BatchMetricsDispatcher.BATCH_DELETED_MESSAGE;
            }
        }, mapResolveBatchDeletedMetricAttributes, 1.5f, null, 8, null);
    }

    @Override // com.datadog.android.core.internal.metrics.MetricsDispatcher
    public void sendBatchClosedMetric(File batchFile, BatchClosedMetadata batchMetadata) {
        Map<String, Object> mapResolveBatchClosedMetricAttributes;
        Intrinsics.checkNotNullParameter(batchFile, "batchFile");
        Intrinsics.checkNotNullParameter(batchMetadata, "batchMetadata");
        if (this.trackName == null || !FileExtKt.existsSafe(batchFile, this.internalLogger) || (mapResolveBatchClosedMetricAttributes = resolveBatchClosedMetricAttributes(batchFile, batchMetadata)) == null) {
            return;
        }
        InternalLogger.DefaultImpls.logMetric$default(this.internalLogger, new Function0<String>() { // from class: com.datadog.android.core.internal.metrics.BatchMetricsDispatcher$sendBatchClosedMetric$1$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return BatchMetricsDispatcher.BATCH_CLOSED_MESSAGE;
            }
        }, mapResolveBatchClosedMetricAttributes, 1.5f, null, 8, null);
    }

    @Override // com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onResumed() {
        this.isInBackground.set(false);
    }

    @Override // com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onPaused() {
        this.isInBackground.set(true);
    }

    private final Map<String, Object> resolveBatchDeletedMetricAttributes(File file, RemovalReason deletionReason, int numPendingBatches) {
        Long lNameAsTimestampSafe = nameAsTimestampSafe(file, this.internalLogger);
        if (lNameAsTimestampSafe == null) {
            return null;
        }
        long deviceTimestampMillis = this.timeProvider.getDeviceTimestampMillis() - lNameAsTimestampSafe.longValue();
        if (deviceTimestampMillis < 0) {
            return null;
        }
        Pair[] pairArr = new Pair[11];
        pairArr[0] = TuplesKt.to("track", this.trackName);
        pairArr[1] = TuplesKt.to("metric_type", BATCH_DELETED_TYPE_VALUE);
        pairArr[2] = TuplesKt.to(BATCH_AGE_KEY, Long.valueOf(deviceTimestampMillis));
        Pair[] pairArr2 = new Pair[2];
        DataUploadConfiguration dataUploadConfiguration = this.uploadConfiguration;
        pairArr2[0] = TuplesKt.to(UPLOADER_DELAY_MIN_KEY, dataUploadConfiguration != null ? Long.valueOf(dataUploadConfiguration.getMinDelayMs()) : null);
        DataUploadConfiguration dataUploadConfiguration2 = this.uploadConfiguration;
        pairArr2[1] = TuplesKt.to(UPLOADER_DELAY_MAX_KEY, dataUploadConfiguration2 != null ? Long.valueOf(dataUploadConfiguration2.getMaxDelayMs()) : null);
        pairArr[3] = TuplesKt.to(UPLOADER_DELAY_KEY, MapsKt.mapOf(pairArr2));
        pairArr[4] = TuplesKt.to(UPLOADER_WINDOW_KEY, Long.valueOf(this.filePersistenceConfig.getRecentDelayMs()));
        pairArr[5] = TuplesKt.to(BATCH_REMOVAL_KEY, deletionReason.toString());
        pairArr[6] = TuplesKt.to(IN_BACKGROUND_KEY, Boolean.valueOf(this.isInBackground.get()));
        pairArr[7] = TuplesKt.to(TRACKING_CONSENT_KEY, resolveFileOriginAsConsent(file));
        pairArr[8] = TuplesKt.to("filename", file.getName());
        pairArr[9] = TuplesKt.to(PENDING_BATCHES, Integer.valueOf(numPendingBatches));
        pairArr[10] = TuplesKt.to(THREAD_NAME, Thread.currentThread().getName());
        return MapsKt.mapOf(pairArr);
    }

    private final Map<String, Object> resolveBatchClosedMetricAttributes(File file, BatchClosedMetadata batchMetadata) {
        Long lNameAsTimestampSafe = nameAsTimestampSafe(file, this.internalLogger);
        if (lNameAsTimestampSafe == null) {
            return null;
        }
        long lastTimeWasUsedInMs$dd_sdk_android_core_release = batchMetadata.getLastTimeWasUsedInMs$dd_sdk_android_core_release() - lNameAsTimestampSafe.longValue();
        if (lastTimeWasUsedInMs$dd_sdk_android_core_release < 0) {
            return null;
        }
        return MapsKt.mapOf(TuplesKt.to("track", this.trackName), TuplesKt.to("metric_type", BATCH_CLOSED_TYPE_VALUE), TuplesKt.to(BATCH_DURATION_KEY, Long.valueOf(lastTimeWasUsedInMs$dd_sdk_android_core_release)), TuplesKt.to(UPLOADER_WINDOW_KEY, Long.valueOf(this.filePersistenceConfig.getRecentDelayMs())), TuplesKt.to(BATCH_SIZE_KEY, Long.valueOf(FileExtKt.lengthSafe(file, this.internalLogger))), TuplesKt.to(BATCH_EVENTS_COUNT_KEY, Long.valueOf(batchMetadata.getEventsCount$dd_sdk_android_core_release())), TuplesKt.to(TRACKING_CONSENT_KEY, resolveFileOriginAsConsent(file)), TuplesKt.to("filename", file.getName()), TuplesKt.to(THREAD_NAME, Thread.currentThread().getName()));
    }

    private final Long nameAsTimestampSafe(final File file, InternalLogger internalLogger) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.name");
        Long longOrNull = StringsKt.toLongOrNull(name);
        if (longOrNull == null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.metrics.BatchMetricsDispatcher.nameAsTimestampSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.ENGLISH, BatchMetricsDispatcher.WRONG_FILE_NAME_MESSAGE_FORMAT, Arrays.copyOf(new Object[]{file.getName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return longOrNull;
    }

    private final String resolveTrackName(String featureName) {
        switch (featureName) {
            case "tracing":
                return "trace";
            case "rum":
                return "rum";
            case "logs":
                return "logs";
            case "session-replay":
                return SR_TRACK_NAME;
            case "session-replay-resources":
                return SR_RESOURCES_TRACK_NAME;
            default:
                return null;
        }
    }

    private final String resolveFileOriginAsConsent(File file) {
        File parentFile = file.getParentFile();
        String name = parentFile != null ? parentFile.getName() : null;
        if (name == null) {
            return null;
        }
        String str = name;
        if (FeatureFileOrchestrator.INSTANCE.getIS_PENDING_DIR_REG_EX$dd_sdk_android_core_release().matches(str)) {
            String string = TrackingConsent.PENDING.toString();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = string.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        if (!FeatureFileOrchestrator.INSTANCE.getIS_GRANTED_DIR_REG_EX$dd_sdk_android_core_release().matches(str)) {
            return null;
        }
        String string2 = TrackingConsent.GRANTED.toString();
        Locale US2 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US2, "US");
        String lowerCase2 = string2.toLowerCase(US2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return lowerCase2;
    }
}
