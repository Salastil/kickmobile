package com.datadog.android.core;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.NoOpInternalSdkCore;
import com.datadog.android.core.internal.SdkFeature;
import com.datadog.android.core.internal.data.upload.DataUploader;
import com.datadog.android.core.internal.data.upload.UploadStatus;
import com.datadog.android.core.internal.metrics.RemovalReason;
import com.datadog.android.core.internal.persistence.BatchData;
import com.datadog.android.core.internal.persistence.BatchId;
import com.datadog.android.core.internal.persistence.Storage;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadWorker.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0017¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/core/UploadWorker;", "Landroidx/work/Worker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "Companion", "UploadNextBatchTask", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UploadWorker extends Worker {
    public static final String DATADOG_INSTANCE_NAME = "_dd.sdk.instanceName";
    public static final String MESSAGE_NOT_INITIALIZED = "Datadog has not been initialized.";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        SdkCore datadog = Datadog.getInstance(getInputData().getString(DATADOG_INSTANCE_NAME));
        InternalSdkCore internalSdkCore = datadog instanceof InternalSdkCore ? (InternalSdkCore) datadog : null;
        if (internalSdkCore == null || (internalSdkCore instanceof NoOpInternalSdkCore)) {
            InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.UploadWorker.doWork.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return UploadWorker.MESSAGE_NOT_INITIALIZED;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(resultSuccess, "success()");
            return resultSuccess;
        }
        List<FeatureScope> allFeatures = internalSdkCore.getAllFeatures();
        ArrayList arrayList = new ArrayList();
        for (FeatureScope featureScope : allFeatures) {
            SdkFeature sdkFeature = featureScope instanceof SdkFeature ? (SdkFeature) featureScope : null;
            if (sdkFeature != null) {
                arrayList.add(sdkFeature);
            }
        }
        List listShuffled = CollectionsKt.shuffled(arrayList);
        LinkedList linkedList = new LinkedList();
        Iterator it = listShuffled.iterator();
        while (it.hasNext()) {
            linkedList.offer(new UploadNextBatchTask(linkedList, internalSdkCore, (SdkFeature) it.next()));
        }
        while (!linkedList.isEmpty()) {
            UploadNextBatchTask uploadNextBatchTask = (UploadNextBatchTask) linkedList.poll();
            if (uploadNextBatchTask != null) {
                uploadNextBatchTask.run();
            }
        }
        ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess2, "success()");
        return resultSuccess2;
    }

    /* JADX INFO: compiled from: UploadWorker.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/core/UploadWorker$UploadNextBatchTask;", "Ljava/lang/Runnable;", "taskQueue", "Ljava/util/Queue;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "feature", "Lcom/datadog/android/core/internal/SdkFeature;", "(Ljava/util/Queue;Lcom/datadog/android/core/InternalSdkCore;Lcom/datadog/android/core/internal/SdkFeature;)V", "consumeBatch", "Lcom/datadog/android/core/internal/data/upload/UploadStatus;", "batchId", "Lcom/datadog/android/core/internal/persistence/BatchId;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/api/context/DatadogContext;", "batch", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMeta", "", "uploader", "Lcom/datadog/android/core/internal/data/upload/DataUploader;", "run", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UploadNextBatchTask implements Runnable {
        private final SdkFeature feature;
        private final InternalSdkCore sdkCore;
        private final Queue<UploadNextBatchTask> taskQueue;

        public UploadNextBatchTask(Queue<UploadNextBatchTask> taskQueue, InternalSdkCore sdkCore, SdkFeature feature) {
            Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            Intrinsics.checkNotNullParameter(feature, "feature");
            this.taskQueue = taskQueue;
            this.sdkCore = sdkCore;
            this.feature = feature;
        }

        @Override // java.lang.Runnable
        public void run() {
            DatadogContext datadogContext$default = InternalSdkCore.DefaultImpls.getDatadogContext$default(this.sdkCore, null, 1, null);
            if (datadogContext$default == null) {
                return;
            }
            Storage storage$dd_sdk_android_core_release = this.feature.getStorage();
            DataUploader uploader$dd_sdk_android_core_release = this.feature.getUploader();
            BatchData nextBatch = storage$dd_sdk_android_core_release.readNextBatch();
            if (nextBatch != null) {
                UploadStatus uploadStatusConsumeBatch = consumeBatch(nextBatch.getId(), datadogContext$default, nextBatch.getData(), nextBatch.getMetadata(), uploader$dd_sdk_android_core_release);
                storage$dd_sdk_android_core_release.confirmBatchRead(nextBatch.getId(), new RemovalReason.IntakeCode(uploadStatusConsumeBatch.getCode()), true ^ uploadStatusConsumeBatch.getShouldRetry());
                if (uploadStatusConsumeBatch instanceof UploadStatus.Success) {
                    Queue<UploadNextBatchTask> queue = this.taskQueue;
                    queue.offer(new UploadNextBatchTask(queue, this.sdkCore, this.feature));
                }
            }
        }

        private final UploadStatus consumeBatch(BatchId batchId, DatadogContext context, List<RawBatchEvent> batch, byte[] batchMeta, DataUploader uploader) {
            return uploader.upload(context, batch, batchMeta, batchId);
        }
    }
}
