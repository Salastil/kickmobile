package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.configuration.UploadSchedulerStrategy;
import com.datadog.android.core.internal.ContextProvider;
import com.datadog.android.core.internal.metrics.BenchmarkUploads;
import com.datadog.android.core.internal.metrics.RemovalReason;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.persistence.BatchData;
import com.datadog.android.core.internal.persistence.BatchId;
import com.datadog.android.core.internal.persistence.Storage;
import com.datadog.android.core.internal.system.SystemInfo;
import com.datadog.android.core.internal.system.SystemInfoProvider;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataUploadRunnable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0003J\u0012\u0010(\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0003J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020-H\u0017J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/DataUploadRunnable;", "Lcom/datadog/android/core/internal/data/upload/UploadRunnable;", "featureName", "", "threadPoolExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "storage", "Lcom/datadog/android/core/internal/persistence/Storage;", "dataUploader", "Lcom/datadog/android/core/internal/data/upload/DataUploader;", "contextProvider", "Lcom/datadog/android/core/internal/ContextProvider;", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "systemInfoProvider", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "uploadSchedulerStrategy", "Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "maxBatchesPerJob", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "benchmarkUploads", "Lcom/datadog/android/core/internal/metrics/BenchmarkUploads;", "(Ljava/lang/String;Ljava/util/concurrent/ScheduledThreadPoolExecutor;Lcom/datadog/android/core/internal/persistence/Storage;Lcom/datadog/android/core/internal/data/upload/DataUploader;Lcom/datadog/android/core/internal/ContextProvider;Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;Lcom/datadog/android/core/internal/system/SystemInfoProvider;Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;ILcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/metrics/BenchmarkUploads;)V", "getMaxBatchesPerJob$dd_sdk_android_core_release", "()I", "getUploadSchedulerStrategy$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "consumeBatch", "Lcom/datadog/android/core/internal/data/upload/UploadStatus;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/api/context/DatadogContext;", "batchId", "Lcom/datadog/android/core/internal/persistence/BatchId;", "batch", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMeta", "", "handleNextBatch", "isNetworkAvailable", "", "isSystemReady", "run", "", "scheduleNextUpload", "delayMs", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataUploadRunnable implements UploadRunnable {
    public static final int LOW_BATTERY_THRESHOLD = 10;
    private final BenchmarkUploads benchmarkUploads;
    private final ContextProvider contextProvider;
    private final DataUploader dataUploader;
    private final String featureName;
    private final InternalLogger internalLogger;
    private final int maxBatchesPerJob;
    private final NetworkInfoProvider networkInfoProvider;
    private final Storage storage;
    private final SystemInfoProvider systemInfoProvider;
    private final ScheduledThreadPoolExecutor threadPoolExecutor;
    private final UploadSchedulerStrategy uploadSchedulerStrategy;

    public DataUploadRunnable(String featureName, ScheduledThreadPoolExecutor threadPoolExecutor, Storage storage, DataUploader dataUploader, ContextProvider contextProvider, NetworkInfoProvider networkInfoProvider, SystemInfoProvider systemInfoProvider, UploadSchedulerStrategy uploadSchedulerStrategy, int i, InternalLogger internalLogger, BenchmarkUploads benchmarkUploads) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "threadPoolExecutor");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(dataUploader, "dataUploader");
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(systemInfoProvider, "systemInfoProvider");
        Intrinsics.checkNotNullParameter(uploadSchedulerStrategy, "uploadSchedulerStrategy");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(benchmarkUploads, "benchmarkUploads");
        this.featureName = featureName;
        this.threadPoolExecutor = threadPoolExecutor;
        this.storage = storage;
        this.dataUploader = dataUploader;
        this.contextProvider = contextProvider;
        this.networkInfoProvider = networkInfoProvider;
        this.systemInfoProvider = systemInfoProvider;
        this.uploadSchedulerStrategy = uploadSchedulerStrategy;
        this.maxBatchesPerJob = i;
        this.internalLogger = internalLogger;
        this.benchmarkUploads = benchmarkUploads;
    }

    /* JADX INFO: renamed from: getUploadSchedulerStrategy$dd_sdk_android_core_release, reason: from getter */
    public final UploadSchedulerStrategy getUploadSchedulerStrategy() {
        return this.uploadSchedulerStrategy;
    }

    /* JADX INFO: renamed from: getMaxBatchesPerJob$dd_sdk_android_core_release, reason: from getter */
    public final int getMaxBatchesPerJob() {
        return this.maxBatchesPerJob;
    }

    public /* synthetic */ DataUploadRunnable(String str, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, Storage storage, DataUploader dataUploader, ContextProvider contextProvider, NetworkInfoProvider networkInfoProvider, SystemInfoProvider systemInfoProvider, UploadSchedulerStrategy uploadSchedulerStrategy, int i, InternalLogger internalLogger, BenchmarkUploads benchmarkUploads, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, scheduledThreadPoolExecutor, storage, dataUploader, contextProvider, networkInfoProvider, systemInfoProvider, uploadSchedulerStrategy, i, internalLogger, (i2 & 1024) != 0 ? new BenchmarkUploads(null, 1, null) : benchmarkUploads);
    }

    @Override // java.lang.Runnable
    public void run() {
        UploadStatus uploadStatusHandleNextBatch;
        int i = 0;
        if (isNetworkAvailable() && isSystemReady()) {
            DatadogContext context = this.contextProvider.getContext(SetsKt.emptySet());
            int i2 = this.maxBatchesPerJob;
            do {
                this.benchmarkUploads.incrementBenchmarkUploadsCount$dd_sdk_android_core_release(this.featureName);
                i2--;
                uploadStatusHandleNextBatch = handleNextBatch(context);
                if (uploadStatusHandleNextBatch != null) {
                    i++;
                }
                if (i2 <= 0) {
                    break;
                }
            } while (uploadStatusHandleNextBatch instanceof UploadStatus.Success);
        } else {
            uploadStatusHandleNextBatch = null;
        }
        scheduleNextUpload(this.uploadSchedulerStrategy.getMsDelayUntilNextUpload(this.featureName, i, uploadStatusHandleNextBatch != null ? Integer.valueOf(uploadStatusHandleNextBatch.getCode()) : null, uploadStatusHandleNextBatch != null ? uploadStatusHandleNextBatch.getThrowable() : null));
    }

    private final UploadStatus handleNextBatch(DatadogContext context) {
        BatchData nextBatch = this.storage.readNextBatch();
        if (nextBatch != null) {
            return consumeBatch(context, nextBatch.getId(), nextBatch.getData(), nextBatch.getMetadata());
        }
        return null;
    }

    private final boolean isNetworkAvailable() {
        return this.networkInfoProvider.getLastNetworkInfo().getConnectivity() != NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED;
    }

    private final boolean isSystemReady() {
        SystemInfo systemInfo = this.systemInfoProvider.getSystemInfo();
        return (systemInfo.getBatteryFullOrCharging() || systemInfo.getOnExternalPowerSource() || systemInfo.getBatteryLevel() > 10) && !systemInfo.getPowerSaveMode();
    }

    private final void scheduleNextUpload(long delayMs) {
        DataUploadRunnable dataUploadRunnable = this;
        this.threadPoolExecutor.remove(dataUploadRunnable);
        ConcurrencyExtKt.scheduleSafe(this.threadPoolExecutor, this.featureName + ": data upload", delayMs, TimeUnit.MILLISECONDS, this.internalLogger, dataUploadRunnable);
    }

    private final UploadStatus consumeBatch(DatadogContext context, BatchId batchId, List<RawBatchEvent> batch, byte[] batchMeta) {
        RemovalReason.IntakeCode intakeCode;
        UploadStatus uploadStatusUpload = this.dataUploader.upload(context, batch, batchMeta, batchId);
        if (uploadStatusUpload instanceof UploadStatus.Success) {
            Iterator<T> it = batch.iterator();
            int length = 0;
            while (it.hasNext()) {
                length += ((RawBatchEvent) it.next()).getData().length;
            }
            this.benchmarkUploads.sendBenchmarkBytesUploaded$dd_sdk_android_core_release(this.featureName, length);
        }
        if (uploadStatusUpload instanceof UploadStatus.RequestCreationError) {
            intakeCode = RemovalReason.Invalid.INSTANCE;
        } else {
            intakeCode = new RemovalReason.IntakeCode(uploadStatusUpload.getCode());
        }
        this.storage.confirmBatchRead(batchId, intakeCode, !uploadStatusUpload.getShouldRetry());
        return uploadStatusUpload;
    }
}
