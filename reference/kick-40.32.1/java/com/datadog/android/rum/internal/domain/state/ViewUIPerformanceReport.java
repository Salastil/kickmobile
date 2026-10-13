package com.datadog.android.rum.internal.domain.state;

import com.datadog.android.internal.collections.EvictingQueue;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUIPerformanceReport.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007BG\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006#"}, d2 = {"Lcom/datadog/android/rum/internal/domain/state/ViewUIPerformanceReport;", "", "viewStartedTimeStamp", "", "maxSize", "", "minimumViewLifetimeThresholdNs", "(JIJ)V", "slowFramesRecords", "Lcom/datadog/android/internal/collections/EvictingQueue;", "Lcom/datadog/android/rum/internal/domain/state/SlowFrameRecord;", "totalFramesDurationNs", "slowFramesDurationNs", "freezeFramesDuration", "minViewLifetimeThresholdNs", "(JLcom/datadog/android/internal/collections/EvictingQueue;JJJJ)V", "getFreezeFramesDuration", "()J", "setFreezeFramesDuration", "(J)V", "lastSlowFrameRecord", "getLastSlowFrameRecord", "()Lcom/datadog/android/rum/internal/domain/state/SlowFrameRecord;", "getMinViewLifetimeThresholdNs", "getSlowFramesDurationNs", "setSlowFramesDurationNs", "getSlowFramesRecords", "()Lcom/datadog/android/internal/collections/EvictingQueue;", "getTotalFramesDurationNs", "setTotalFramesDurationNs", "getViewStartedTimeStamp", "snapshot", "Lcom/datadog/android/rum/internal/domain/state/ViewUIPerformanceReport$Snapshot;", "Companion", "Snapshot", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewUIPerformanceReport {
    private static final int MILLISECONDS_IN_SECOND = 1000;
    private static final int SECONDS_IN_HOUR = 3600;
    private volatile long freezeFramesDuration;
    private final long minViewLifetimeThresholdNs;
    private volatile long slowFramesDurationNs;
    private final EvictingQueue<ms> slowFramesRecords;
    private volatile long totalFramesDurationNs;
    private final long viewStartedTimeStamp;

    private ViewUIPerformanceReport(long j, EvictingQueue<ms> evictingQueue, long j2, long j3, long j4, long j5) {
        this.viewStartedTimeStamp = j;
        this.slowFramesRecords = evictingQueue;
        this.totalFramesDurationNs = j2;
        this.slowFramesDurationNs = j3;
        this.freezeFramesDuration = j4;
        this.minViewLifetimeThresholdNs = j5;
    }

    /* synthetic */ ViewUIPerformanceReport(long j, EvictingQueue evictingQueue, long j2, long j3, long j4, long j5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, evictingQueue, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? 0L : j3, (i & 16) != 0 ? 0L : j4, (i & 32) != 0 ? 0L : j5);
    }

    public final long getViewStartedTimeStamp() {
        return this.viewStartedTimeStamp;
    }

    public final EvictingQueue<ms> getSlowFramesRecords() {
        return this.slowFramesRecords;
    }

    public final long getTotalFramesDurationNs() {
        return this.totalFramesDurationNs;
    }

    public final void setTotalFramesDurationNs(long j) {
        this.totalFramesDurationNs = j;
    }

    public final long getSlowFramesDurationNs() {
        return this.slowFramesDurationNs;
    }

    public final void setSlowFramesDurationNs(long j) {
        this.slowFramesDurationNs = j;
    }

    public final long getFreezeFramesDuration() {
        return this.freezeFramesDuration;
    }

    public final void setFreezeFramesDuration(long j) {
        this.freezeFramesDuration = j;
    }

    public final long getMinViewLifetimeThresholdNs() {
        return this.minViewLifetimeThresholdNs;
    }

    public ViewUIPerformanceReport(long j, int i, long j2) {
        this(j, new EvictingQueue(i, new ConcurrentLinkedDeque()), 0L, 0L, 0L, j2, 28, null);
    }

    public final ms getLastSlowFrameRecord() {
        return this.slowFramesRecords.lastOrNull();
    }

    public final Snapshot snapshot() {
        return new Snapshot(this.viewStartedTimeStamp, CollectionsKt.toList(this.slowFramesRecords), this.totalFramesDurationNs, this.slowFramesDurationNs, this.freezeFramesDuration, this.minViewLifetimeThresholdNs);
    }

    /* JADX INFO: compiled from: ViewUIPerformanceReport.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JK\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006&"}, d2 = {"Lcom/datadog/android/rum/internal/domain/state/ViewUIPerformanceReport$Snapshot;", "", "viewStartedTimeStamp", "", "slowFramesRecords", "", "Lcom/datadog/android/rum/internal/domain/state/SlowFrameRecord;", "totalFramesDurationNs", "slowFramesDurationNs", "freezeFramesDuration", "minViewLifetimeThresholdNs", "(JLjava/util/List;JJJJ)V", "getFreezeFramesDuration", "()J", "getMinViewLifetimeThresholdNs", "getSlowFramesDurationNs", "getSlowFramesRecords", "()Ljava/util/List;", "getTotalFramesDurationNs", "getViewStartedTimeStamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "freezeFramesRate", "", "viewEndedTimeStamp", "hashCode", "", "slowFramesRate", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Snapshot {
        private final long freezeFramesDuration;
        private final long minViewLifetimeThresholdNs;
        private final long slowFramesDurationNs;
        private final List<ms> slowFramesRecords;
        private final long totalFramesDurationNs;
        private final long viewStartedTimeStamp;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Snapshot copy$default(Snapshot snapshot, long j, List list, long j2, long j3, long j4, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                j = snapshot.viewStartedTimeStamp;
            }
            long j6 = j;
            if ((i & 2) != 0) {
                list = snapshot.slowFramesRecords;
            }
            return snapshot.copy(j6, list, (i & 4) != 0 ? snapshot.totalFramesDurationNs : j2, (i & 8) != 0 ? snapshot.slowFramesDurationNs : j3, (i & 16) != 0 ? snapshot.freezeFramesDuration : j4, (i & 32) != 0 ? snapshot.minViewLifetimeThresholdNs : j5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getViewStartedTimeStamp() {
            return this.viewStartedTimeStamp;
        }

        public final List<ms> component2() {
            return this.slowFramesRecords;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getTotalFramesDurationNs() {
            return this.totalFramesDurationNs;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getSlowFramesDurationNs() {
            return this.slowFramesDurationNs;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getFreezeFramesDuration() {
            return this.freezeFramesDuration;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getMinViewLifetimeThresholdNs() {
            return this.minViewLifetimeThresholdNs;
        }

        public final Snapshot copy(long viewStartedTimeStamp, List<ms> slowFramesRecords, long totalFramesDurationNs, long slowFramesDurationNs, long freezeFramesDuration, long minViewLifetimeThresholdNs) {
            Intrinsics.checkNotNullParameter(slowFramesRecords, "slowFramesRecords");
            return new Snapshot(viewStartedTimeStamp, slowFramesRecords, totalFramesDurationNs, slowFramesDurationNs, freezeFramesDuration, minViewLifetimeThresholdNs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return this.viewStartedTimeStamp == snapshot.viewStartedTimeStamp && Intrinsics.areEqual(this.slowFramesRecords, snapshot.slowFramesRecords) && this.totalFramesDurationNs == snapshot.totalFramesDurationNs && this.slowFramesDurationNs == snapshot.slowFramesDurationNs && this.freezeFramesDuration == snapshot.freezeFramesDuration && this.minViewLifetimeThresholdNs == snapshot.minViewLifetimeThresholdNs;
        }

        public int hashCode() {
            return (((((((((Long.hashCode(this.viewStartedTimeStamp) * 31) + this.slowFramesRecords.hashCode()) * 31) + Long.hashCode(this.totalFramesDurationNs)) * 31) + Long.hashCode(this.slowFramesDurationNs)) * 31) + Long.hashCode(this.freezeFramesDuration)) * 31) + Long.hashCode(this.minViewLifetimeThresholdNs);
        }

        public String toString() {
            return "Snapshot(viewStartedTimeStamp=" + this.viewStartedTimeStamp + ", slowFramesRecords=" + this.slowFramesRecords + ", totalFramesDurationNs=" + this.totalFramesDurationNs + ", slowFramesDurationNs=" + this.slowFramesDurationNs + ", freezeFramesDuration=" + this.freezeFramesDuration + ", minViewLifetimeThresholdNs=" + this.minViewLifetimeThresholdNs + ")";
        }

        public Snapshot(long j, List<ms> slowFramesRecords, long j2, long j3, long j4, long j5) {
            Intrinsics.checkNotNullParameter(slowFramesRecords, "slowFramesRecords");
            this.viewStartedTimeStamp = j;
            this.slowFramesRecords = slowFramesRecords;
            this.totalFramesDurationNs = j2;
            this.slowFramesDurationNs = j3;
            this.freezeFramesDuration = j4;
            this.minViewLifetimeThresholdNs = j5;
        }

        public final long getViewStartedTimeStamp() {
            return this.viewStartedTimeStamp;
        }

        public final List<ms> getSlowFramesRecords() {
            return this.slowFramesRecords;
        }

        public final long getTotalFramesDurationNs() {
            return this.totalFramesDurationNs;
        }

        public final long getSlowFramesDurationNs() {
            return this.slowFramesDurationNs;
        }

        public final long getFreezeFramesDuration() {
            return this.freezeFramesDuration;
        }

        public final long getMinViewLifetimeThresholdNs() {
            return this.minViewLifetimeThresholdNs;
        }

        public final double slowFramesRate(long viewEndedTimeStamp) {
            if (viewEndedTimeStamp - this.viewStartedTimeStamp <= this.minViewLifetimeThresholdNs) {
                return 0.0d;
            }
            long j = this.totalFramesDurationNs;
            if (j > 0.0d) {
                return (this.slowFramesDurationNs / j) * 1000.0d;
            }
            return 0.0d;
        }

        public final double freezeFramesRate(long viewEndedTimeStamp) {
            long j = this.viewStartedTimeStamp;
            if (viewEndedTimeStamp - j <= this.minViewLifetimeThresholdNs) {
                return 0.0d;
            }
            return Math.max(0.0d, (this.freezeFramesDuration / (viewEndedTimeStamp - j)) * 3600.0d);
        }
    }
}
