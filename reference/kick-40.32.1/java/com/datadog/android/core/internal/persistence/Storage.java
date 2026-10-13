package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.internal.metrics.RemovalReason;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\b\u0010\n\u001a\u00020\u0003H'J,\u0010\u000b\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f\u0012\u0004\u0012\u00020\u00030\fj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H'¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/core/internal/persistence/Storage;", "", "confirmBatchRead", "", "batchId", "Lcom/datadog/android/core/internal/persistence/BatchId;", "removalReason", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "deleteBatch", "", "dropAll", "getEventWriteScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "readNextBatch", "Lcom/datadog/android/core/internal/persistence/BatchData;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Storage {
    void confirmBatchRead(BatchId batchId, RemovalReason removalReason, boolean deleteBatch);

    void dropAll();

    Function1<Function1<? super EventBatchWriter, Unit>, Unit> getEventWriteScope(DatadogContext datadogContext);

    BatchData readNextBatch();
}
