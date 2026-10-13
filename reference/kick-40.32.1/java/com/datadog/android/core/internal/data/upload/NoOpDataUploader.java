package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.persistence.BatchId;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpDataUploader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/NoOpDataUploader;", "Lcom/datadog/android/core/internal/data/upload/DataUploader;", "()V", "upload", "Lcom/datadog/android/core/internal/data/upload/UploadStatus;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/api/context/DatadogContext;", "batch", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMeta", "", "batchId", "Lcom/datadog/android/core/internal/persistence/BatchId;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDataUploader implements DataUploader {
    @Override // com.datadog.android.core.internal.data.upload.DataUploader
    public UploadStatus upload(DatadogContext context, List<RawBatchEvent> batch, byte[] batchMeta, BatchId batchId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(batch, "batch");
        return UploadStatus.UnknownStatus.INSTANCE;
    }
}
