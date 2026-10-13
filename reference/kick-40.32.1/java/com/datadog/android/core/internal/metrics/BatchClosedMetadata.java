package com.datadog.android.core.internal.metrics;

import kotlin.Metadata;

/* JADX INFO: compiled from: BatchClosedMetadata.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\nJ\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/core/internal/metrics/BatchClosedMetadata;", "", "lastTimeWasUsedInMs", "", "eventsCount", "(JJ)V", "getEventsCount$dd_sdk_android_core_release", "()J", "getLastTimeWasUsedInMs$dd_sdk_android_core_release", "component1", "component1$dd_sdk_android_core_release", "component2", "component2$dd_sdk_android_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BatchClosedMetadata {
    private final long eventsCount;
    private final long lastTimeWasUsedInMs;

    public static /* synthetic */ BatchClosedMetadata copy$default(BatchClosedMetadata batchClosedMetadata, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = batchClosedMetadata.lastTimeWasUsedInMs;
        }
        if ((i & 2) != 0) {
            j2 = batchClosedMetadata.eventsCount;
        }
        return batchClosedMetadata.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_core_release, reason: from getter */
    public final long getLastTimeWasUsedInMs() {
        return this.lastTimeWasUsedInMs;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_core_release, reason: from getter */
    public final long getEventsCount() {
        return this.eventsCount;
    }

    public final BatchClosedMetadata copy(long lastTimeWasUsedInMs, long eventsCount) {
        return new BatchClosedMetadata(lastTimeWasUsedInMs, eventsCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchClosedMetadata)) {
            return false;
        }
        BatchClosedMetadata batchClosedMetadata = (BatchClosedMetadata) other;
        return this.lastTimeWasUsedInMs == batchClosedMetadata.lastTimeWasUsedInMs && this.eventsCount == batchClosedMetadata.eventsCount;
    }

    public int hashCode() {
        return (Long.hashCode(this.lastTimeWasUsedInMs) * 31) + Long.hashCode(this.eventsCount);
    }

    public String toString() {
        return "BatchClosedMetadata(lastTimeWasUsedInMs=" + this.lastTimeWasUsedInMs + ", eventsCount=" + this.eventsCount + ")";
    }

    public BatchClosedMetadata(long j, long j2) {
        this.lastTimeWasUsedInMs = j;
        this.eventsCount = j2;
    }

    public final long getLastTimeWasUsedInMs$dd_sdk_android_core_release() {
        return this.lastTimeWasUsedInMs;
    }

    public final long getEventsCount$dd_sdk_android_core_release() {
        return this.eventsCount;
    }
}
