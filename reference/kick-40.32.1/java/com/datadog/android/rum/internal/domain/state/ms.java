package com.datadog.android.rum.internal.domain.state;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.datadog.android.rum.internal.domain.state.SlowFrameRecord, reason: from toString */
/* JADX INFO: compiled from: SlowFrameRecord.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/domain/state/SlowFrameRecord;", "", "startTimestampNs", "", "durationNs", "(JJ)V", "getDurationNs", "()J", "setDurationNs", "(J)V", "getStartTimestampNs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ms {
    private static final double NS_IN_MS = 1000000.0d;
    private long durationNs;
    private final long startTimestampNs;

    public static /* synthetic */ ms copy$default(ms msVar, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = msVar.startTimestampNs;
        }
        if ((i & 2) != 0) {
            j2 = msVar.durationNs;
        }
        return msVar.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getStartTimestampNs() {
        return this.startTimestampNs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDurationNs() {
        return this.durationNs;
    }

    public final ms copy(long startTimestampNs, long durationNs) {
        return new ms(startTimestampNs, durationNs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ms)) {
            return false;
        }
        ms msVar = (ms) other;
        return this.startTimestampNs == msVar.startTimestampNs && this.durationNs == msVar.durationNs;
    }

    public int hashCode() {
        return (Long.hashCode(this.startTimestampNs) * 31) + Long.hashCode(this.durationNs);
    }

    public ms(long j, long j2) {
        this.startTimestampNs = j;
        this.durationNs = j2;
    }

    public final long getStartTimestampNs() {
        return this.startTimestampNs;
    }

    public final long getDurationNs() {
        return this.durationNs;
    }

    public final void setDurationNs(long j) {
        this.durationNs = j;
    }

    public String toString() {
        return (this.durationNs / NS_IN_MS) + "ms";
    }
}
