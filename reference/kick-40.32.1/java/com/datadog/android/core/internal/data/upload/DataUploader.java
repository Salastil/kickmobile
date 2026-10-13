package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.persistence.BatchId;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: DataUploader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/DataUploader;", "", "upload", "Lcom/datadog/android/core/internal/data/upload/UploadStatus;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/api/context/DatadogContext;", "batch", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMeta", "", "batchId", "Lcom/datadog/android/core/internal/persistence/BatchId;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DataUploader {
    UploadStatus upload(DatadogContext context, List<RawBatchEvent> batch, byte[] batchMeta, BatchId batchId);

    /* JADX INFO: compiled from: DataUploader.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ UploadStatus upload$default(DataUploader dataUploader, DatadogContext datadogContext, List list, byte[] bArr, BatchId batchId, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upload");
            }
            if ((i & 8) != 0) {
                batchId = null;
            }
            return dataUploader.upload(datadogContext, list, bArr, batchId);
        }
    }
}
