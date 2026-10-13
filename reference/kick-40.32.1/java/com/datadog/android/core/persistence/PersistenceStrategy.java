package com.datadog.android.core.persistence;

import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import expo.modules.notifications.service.NotificationsService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PersistenceStrategy.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\u0015\u0016J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0000H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH'J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0014H'¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/core/persistence/PersistenceStrategy;", "", "currentMetadata", "", "dropAll", "", "lockAndReadNext", "Lcom/datadog/android/core/persistence/PersistenceStrategy$Batch;", "migrateData", "targetStrategy", "unlockAndDelete", "batchId", "", "unlockAndKeep", "write", "", "event", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMetadata", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "Batch", "Factory", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PersistenceStrategy {

    /* JADX INFO: compiled from: PersistenceStrategy.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;", "", "create", "Lcom/datadog/android/core/persistence/PersistenceStrategy;", NotificationsService.IDENTIFIER_KEY, "", "maxItemsPerBatch", "", "maxBatchSize", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Factory {
        PersistenceStrategy create(String identifier, int maxItemsPerBatch, long maxBatchSize);
    }

    byte[] currentMetadata();

    void dropAll();

    Batch lockAndReadNext();

    void migrateData(PersistenceStrategy targetStrategy);

    void unlockAndDelete(String batchId);

    void unlockAndKeep(String batchId);

    boolean write(RawBatchEvent event, byte[] batchMetadata, EventType eventType);

    /* JADX INFO: compiled from: PersistenceStrategy.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/core/persistence/PersistenceStrategy$Batch;", "", "batchId", "", "metadata", "", "events", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "(Ljava/lang/String;[BLjava/util/List;)V", "getBatchId", "()Ljava/lang/String;", "getEvents", "()Ljava/util/List;", "getMetadata", "()[B", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Batch {
        private final String batchId;
        private final List<RawBatchEvent> events;
        private final byte[] metadata;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Batch copy$default(Batch batch, String str, byte[] bArr, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = batch.batchId;
            }
            if ((i & 2) != 0) {
                bArr = batch.metadata;
            }
            if ((i & 4) != 0) {
                list = batch.events;
            }
            return batch.copy(str, bArr, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBatchId() {
            return this.batchId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final byte[] getMetadata() {
            return this.metadata;
        }

        public final List<RawBatchEvent> component3() {
            return this.events;
        }

        public final Batch copy(String batchId, byte[] metadata, List<RawBatchEvent> events) {
            Intrinsics.checkNotNullParameter(batchId, "batchId");
            Intrinsics.checkNotNullParameter(events, "events");
            return new Batch(batchId, metadata, events);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Batch)) {
                return false;
            }
            Batch batch = (Batch) other;
            return Intrinsics.areEqual(this.batchId, batch.batchId) && Intrinsics.areEqual(this.metadata, batch.metadata) && Intrinsics.areEqual(this.events, batch.events);
        }

        public int hashCode() {
            int iHashCode = this.batchId.hashCode() * 31;
            byte[] bArr = this.metadata;
            return ((iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31) + this.events.hashCode();
        }

        public String toString() {
            return "Batch(batchId=" + this.batchId + ", metadata=" + Arrays.toString(this.metadata) + ", events=" + this.events + ")";
        }

        public Batch(String batchId, byte[] bArr, List<RawBatchEvent> events) {
            Intrinsics.checkNotNullParameter(batchId, "batchId");
            Intrinsics.checkNotNullParameter(events, "events");
            this.batchId = batchId;
            this.metadata = bArr;
            this.events = events;
        }

        public final String getBatchId() {
            return this.batchId;
        }

        public final byte[] getMetadata() {
            return this.metadata;
        }

        public /* synthetic */ Batch(String str, byte[] bArr, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? new ArrayList() : arrayList);
        }

        public final List<RawBatchEvent> getEvents() {
            return this.events;
        }
    }
}
