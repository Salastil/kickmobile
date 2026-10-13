package com.datadog.android.core.persistence;

import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpPersistenceStrategy.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/core/persistence/NoOpPersistenceStrategy;", "Lcom/datadog/android/core/persistence/PersistenceStrategy;", "()V", "currentMetadata", "", "dropAll", "", "lockAndReadNext", "Lcom/datadog/android/core/persistence/PersistenceStrategy$Batch;", "migrateData", "targetStrategy", "unlockAndDelete", "batchId", "", "unlockAndKeep", "write", "", "event", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMetadata", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpPersistenceStrategy implements PersistenceStrategy {
    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public byte[] currentMetadata() {
        return null;
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public void dropAll() {
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public PersistenceStrategy.Batch lockAndReadNext() {
        return null;
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public void migrateData(PersistenceStrategy targetStrategy) {
        Intrinsics.checkNotNullParameter(targetStrategy, "targetStrategy");
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public void unlockAndDelete(String batchId) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public void unlockAndKeep(String batchId) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public boolean write(RawBatchEvent event, byte[] batchMetadata, EventType eventType) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return false;
    }
}
