package com.datadog.android.core.internal.utils;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.UploadWorker;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkManagerUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a \u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"CANCEL_ERROR_MESSAGE", "", "DELAY_MS", "", "SETUP_ERROR_MESSAGE", "TAG_DATADOG_UPLOAD", "UPLOAD_WORKER_NAME", "UPLOAD_WORKER_WAS_SCHEDULED", "cancelUploadWorker", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "instanceName", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "triggerUploadWorker", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WorkManagerUtilsKt {
    public static final String CANCEL_ERROR_MESSAGE = "Error cancelling the UploadWorker";
    public static final long DELAY_MS = 5000;
    public static final String SETUP_ERROR_MESSAGE = "Error while trying to setup the UploadWorker";
    public static final String TAG_DATADOG_UPLOAD = "DatadogBackgroundUpload";
    public static final String UPLOAD_WORKER_NAME = "DatadogUploadWorker";
    public static final String UPLOAD_WORKER_WAS_SCHEDULED = "UploadWorker was scheduled.";

    public static final void cancelUploadWorker(Context context, String instanceName, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            WorkManager workManager = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
            workManager.cancelAllWorkByTag("DatadogBackgroundUpload/" + instanceName);
        } catch (IllegalStateException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.WorkManagerUtilsKt.cancelUploadWorker.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WorkManagerUtilsKt.CANCEL_ERROR_MESSAGE;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    public static final void triggerUploadWorker(Context context, String instanceName, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            WorkManager workManager = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
            OneTimeWorkRequest.Builder initialDelay = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) UploadWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.NOT_ROAMING).build()).addTag("DatadogBackgroundUpload/" + instanceName).setInitialDelay(5000L, TimeUnit.MILLISECONDS);
            Data dataBuild = new Data.Builder().putString(UploadWorker.DATADOG_INSTANCE_NAME, instanceName).build();
            Intrinsics.checkNotNullExpressionValue(dataBuild, "Builder().putString(Uplo…ME, instanceName).build()");
            workManager.enqueueUniqueWork(UPLOAD_WORKER_NAME, ExistingWorkPolicy.REPLACE, initialDelay.setInputData(dataBuild).build());
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.WorkManagerUtilsKt.triggerUploadWorker.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WorkManagerUtilsKt.UPLOAD_WORKER_WAS_SCHEDULED;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } catch (Exception e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.WorkManagerUtilsKt.triggerUploadWorker.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WorkManagerUtilsKt.SETUP_ERROR_MESSAGE;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }
}
