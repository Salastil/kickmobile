package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.storage.RawBatchEvent;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatchData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/core/internal/persistence/BatchData;", "", "id", "Lcom/datadog/android/core/internal/persistence/BatchId;", "data", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "metadata", "", "(Lcom/datadog/android/core/internal/persistence/BatchId;Ljava/util/List;[B)V", "getData", "()Ljava/util/List;", "getId", "()Lcom/datadog/android/core/internal/persistence/BatchId;", "getMetadata", "()[B", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BatchData {
    private final List<RawBatchEvent> data;
    private final BatchId id;
    private final byte[] metadata;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchData copy$default(BatchData batchData, BatchId batchId, List list, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            batchId = batchData.id;
        }
        if ((i & 2) != 0) {
            list = batchData.data;
        }
        if ((i & 4) != 0) {
            bArr = batchData.metadata;
        }
        return batchData.copy(batchId, list, bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BatchId getId() {
        return this.id;
    }

    public final List<RawBatchEvent> component2() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final byte[] getMetadata() {
        return this.metadata;
    }

    public final BatchData copy(BatchId id, List<RawBatchEvent> data, byte[] metadata) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(data, "data");
        return new BatchData(id, data, metadata);
    }

    public String toString() {
        return "BatchData(id=" + this.id + ", data=" + this.data + ", metadata=" + Arrays.toString(this.metadata) + ")";
    }

    public BatchData(BatchId id, List<RawBatchEvent> data, byte[] bArr) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(data, "data");
        this.id = id;
        this.data = data;
        this.metadata = bArr;
    }

    public /* synthetic */ BatchData(BatchId batchId, List list, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(batchId, list, (i & 4) != 0 ? null : bArr);
    }

    public final BatchId getId() {
        return this.id;
    }

    public final List<RawBatchEvent> getData() {
        return this.data;
    }

    public final byte[] getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.datadog.android.core.internal.persistence.BatchData");
        BatchData batchData = (BatchData) other;
        if (!Intrinsics.areEqual(this.id, batchData.id) || !Intrinsics.areEqual(this.data, batchData.data)) {
            return false;
        }
        byte[] bArr = this.metadata;
        if (bArr != null) {
            byte[] bArr2 = batchData.metadata;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (batchData.metadata != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.data.hashCode()) * 31;
        byte[] bArr = this.metadata;
        return iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }
}
