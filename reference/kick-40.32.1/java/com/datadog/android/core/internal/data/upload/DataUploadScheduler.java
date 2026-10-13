package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.UploadSchedulerStrategy;
import com.datadog.android.core.internal.ContextProvider;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.persistence.Storage;
import com.datadog.android.core.internal.system.SystemInfoProvider;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataUploadScheduler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/DataUploadScheduler;", "Lcom/datadog/android/core/internal/data/upload/UploadScheduler;", "featureName", "", "storage", "Lcom/datadog/android/core/internal/persistence/Storage;", "dataUploader", "Lcom/datadog/android/core/internal/data/upload/DataUploader;", "contextProvider", "Lcom/datadog/android/core/internal/ContextProvider;", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "systemInfoProvider", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "uploadSchedulerStrategy", "Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "maxBatchesPerJob", "", "scheduledThreadPoolExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/lang/String;Lcom/datadog/android/core/internal/persistence/Storage;Lcom/datadog/android/core/internal/data/upload/DataUploader;Lcom/datadog/android/core/internal/ContextProvider;Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;Lcom/datadog/android/core/internal/system/SystemInfoProvider;Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;ILjava/util/concurrent/ScheduledThreadPoolExecutor;Lcom/datadog/android/api/InternalLogger;)V", "runnable", "Lcom/datadog/android/core/internal/data/upload/DataUploadRunnable;", "getRunnable$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/data/upload/DataUploadRunnable;", "startScheduling", "", "stopScheduling", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataUploadScheduler implements UploadScheduler {
    private final String featureName;
    private final InternalLogger internalLogger;
    private final DataUploadRunnable runnable;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    public DataUploadScheduler(String featureName, Storage storage, DataUploader dataUploader, ContextProvider contextProvider, NetworkInfoProvider networkInfoProvider, SystemInfoProvider systemInfoProvider, UploadSchedulerStrategy uploadSchedulerStrategy, int i, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(dataUploader, "dataUploader");
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(systemInfoProvider, "systemInfoProvider");
        Intrinsics.checkNotNullParameter(uploadSchedulerStrategy, "uploadSchedulerStrategy");
        Intrinsics.checkNotNullParameter(scheduledThreadPoolExecutor, "scheduledThreadPoolExecutor");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.featureName = featureName;
        this.scheduledThreadPoolExecutor = scheduledThreadPoolExecutor;
        this.internalLogger = internalLogger;
        this.runnable = new DataUploadRunnable(featureName, scheduledThreadPoolExecutor, storage, dataUploader, contextProvider, networkInfoProvider, systemInfoProvider, uploadSchedulerStrategy, i, internalLogger, null, 1024, null);
    }

    /* JADX INFO: renamed from: getRunnable$dd_sdk_android_core_release, reason: from getter */
    public final DataUploadRunnable getRunnable() {
        return this.runnable;
    }

    @Override // com.datadog.android.core.internal.data.upload.UploadScheduler
    public void startScheduling() {
        ConcurrencyExtKt.executeSafe(this.scheduledThreadPoolExecutor, this.featureName + ": data upload", this.internalLogger, this.runnable);
    }

    @Override // com.datadog.android.core.internal.data.upload.UploadScheduler
    public void stopScheduling() {
        this.scheduledThreadPoolExecutor.remove(this.runnable);
    }
}
