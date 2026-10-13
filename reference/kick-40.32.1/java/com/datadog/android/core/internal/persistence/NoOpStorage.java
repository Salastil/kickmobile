package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.internal.metrics.RemovalReason;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J,\u0010\f\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\r\u0012\u0004\u0012\u00020\u00040\rj\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/core/internal/persistence/NoOpStorage;", "Lcom/datadog/android/core/internal/persistence/Storage;", "()V", "confirmBatchRead", "", "batchId", "Lcom/datadog/android/core/internal/persistence/BatchId;", "removalReason", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "deleteBatch", "", "dropAll", "getEventWriteScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "readNextBatch", "Lcom/datadog/android/core/internal/persistence/BatchData;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpStorage implements Storage {
    @Override // com.datadog.android.core.internal.persistence.Storage
    public void confirmBatchRead(BatchId batchId, RemovalReason removalReason, boolean deleteBatch) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(removalReason, "removalReason");
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void dropAll() {
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public BatchData readNextBatch() {
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public Function1<Function1<? super EventBatchWriter, Unit>, Unit> getEventWriteScope(DatadogContext datadogContext) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        return new Function1<Function1<? super EventBatchWriter, ? extends Unit>, Unit>() { // from class: com.datadog.android.core.internal.persistence.NoOpStorage.getEventWriteScope.1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super EventBatchWriter, Unit> it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super EventBatchWriter, ? extends Unit> function1) {
                invoke2((Function1<? super EventBatchWriter, Unit>) function1);
                return Unit.INSTANCE;
            }
        };
    }
}
