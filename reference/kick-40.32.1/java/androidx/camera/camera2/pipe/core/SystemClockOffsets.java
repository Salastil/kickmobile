package androidx.camera.camera2.pipe.core;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemClockOffsets.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/core/SystemClockOffsets;", "", "realtimeNsToUtcMs", "", "realtimeNsToMonotonicNs", "<init>", "(JJ)V", "getRealtimeNsToUtcMs", "()J", "getRealtimeNsToMonotonicNs", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemClockOffsets {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MEASUREMENT_ITERATIONS = 3;
    private static final long NS_PER_MS = 1000000;
    private static final long NS_PER_MS_X_2 = 2000000;
    private final long realtimeNsToMonotonicNs;
    private final long realtimeNsToUtcMs;

    public /* synthetic */ SystemClockOffsets(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @JvmStatic
    public static final SystemClockOffsets estimate() {
        return INSTANCE.estimate();
    }

    @JvmStatic
    private static final long estimateRealtimeNsToMonotonicNs() {
        return INSTANCE.estimateRealtimeNsToMonotonicNs();
    }

    @JvmStatic
    private static final long estimateRealtimeNsToUtcMs() {
        return INSTANCE.estimateRealtimeNsToUtcMs();
    }

    @JvmStatic
    public static final SystemClockOffsets fixed(long j, long j2) {
        return INSTANCE.fixed(j, j2);
    }

    @JvmStatic
    public static final long monotonicMsToRealtimeMs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.monotonicMsToRealtimeMs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long monotonicMsToRealtimeNs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.monotonicMsToRealtimeNs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long monotonicMsToUtcMs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.monotonicMsToUtcMs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long monotonicNsToRealtimeMs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.monotonicNsToRealtimeMs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long monotonicNsToRealtimeNs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.monotonicNsToRealtimeNs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long monotonicNsToUtcMs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.monotonicNsToUtcMs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long realtimeMsToMonotonicMs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.realtimeMsToMonotonicMs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long realtimeMsToMonotonicNs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.realtimeMsToMonotonicNs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long realtimeMsToUtcMs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.realtimeMsToUtcMs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long realtimeNsToMonotonicMs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.realtimeNsToMonotonicMs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long realtimeNsToMonotonicNs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.realtimeNsToMonotonicNs(systemClockOffsets, j);
    }

    @JvmStatic
    public static final long realtimeNsToUtcMs(SystemClockOffsets systemClockOffsets, long j) {
        return INSTANCE.realtimeNsToUtcMs(systemClockOffsets, j);
    }

    private SystemClockOffsets(long j, long j2) {
        this.realtimeNsToUtcMs = j;
        this.realtimeNsToMonotonicNs = j2;
    }

    /* JADX INFO: compiled from: SystemClockOffsets.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J\b\u0010\u000e\u001a\u00020\u0005H\u0003J\b\u0010\u000f\u001a\u00020\u0005H\u0003J\u0014\u0010\r\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0014\u0010\u0011\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0014\u0010\f\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0014\u0010\u0012\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\u0014\u0010\u0014\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\u0014\u0010\u0015\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\u0014\u0010\u0016\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0014\u0010\u0018\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0014\u0010\u0019\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u0014\u0010\u001a\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0005H\u0007J\u0014\u0010\u001c\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0005H\u0007J\u0014\u0010\u001d\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/camera/camera2/pipe/core/SystemClockOffsets$Companion;", "", "<init>", "()V", "NS_PER_MS", "", "NS_PER_MS_X_2", "MEASUREMENT_ITERATIONS", "", "estimate", "Landroidx/camera/camera2/pipe/core/SystemClockOffsets;", "fixed", "realtimeNsToUtcMs", "realtimeNsToMonotonicNs", "estimateRealtimeNsToUtcMs", "estimateRealtimeNsToMonotonicNs", "realtimeNs", "realtimeNsToMonotonicMs", "realtimeMsToMonotonicNs", "realtimeMs", "realtimeMsToMonotonicMs", "realtimeMsToUtcMs", "monotonicNsToRealtimeNs", "monotonicNs", "monotonicNsToRealtimeMs", "monotonicNsToUtcMs", "monotonicMsToRealtimeNs", "monotonicMs", "monotonicMsToRealtimeMs", "monotonicMsToUtcMs", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SystemClockOffsets estimate() {
            return new SystemClockOffsets(estimateRealtimeNsToUtcMs(), estimateRealtimeNsToMonotonicNs(), null);
        }

        @JvmStatic
        public final SystemClockOffsets fixed(long realtimeNsToUtcMs, long realtimeNsToMonotonicNs) {
            return new SystemClockOffsets(realtimeNsToUtcMs, realtimeNsToMonotonicNs, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long estimateRealtimeNsToUtcMs() {
            long j = Long.MAX_VALUE;
            long j2 = 0;
            for (int i = 0; i < 3; i++) {
                long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtimeNanos2 = SystemClock.elapsedRealtimeNanos();
                long j3 = jElapsedRealtimeNanos2 - jElapsedRealtimeNanos;
                if (j3 < j) {
                    j2 = ((jElapsedRealtimeNanos + jElapsedRealtimeNanos2) / SystemClockOffsets.NS_PER_MS_X_2) - jCurrentTimeMillis;
                    j = j3;
                }
            }
            return j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long estimateRealtimeNsToMonotonicNs() {
            long j = Long.MAX_VALUE;
            long j2 = 0;
            for (int i = 0; i < 3; i++) {
                long jNanoTime = System.nanoTime();
                long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                long jNanoTime2 = System.nanoTime();
                long j3 = jNanoTime2 - jNanoTime;
                if (j3 < j) {
                    j2 = jElapsedRealtimeNanos - ((jNanoTime + jNanoTime2) / 2);
                    j = j3;
                }
            }
            return j2;
        }

        @JvmStatic
        public final long realtimeNsToMonotonicNs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return j - systemClockOffsets.getRealtimeNsToMonotonicNs();
        }

        @JvmStatic
        public final long realtimeNsToMonotonicMs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return realtimeNsToMonotonicNs(systemClockOffsets, j) / 1000000;
        }

        @JvmStatic
        public final long realtimeNsToUtcMs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return (j / 1000000) - systemClockOffsets.getRealtimeNsToUtcMs();
        }

        @JvmStatic
        public final long realtimeMsToMonotonicNs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return (j * 1000000) - systemClockOffsets.getRealtimeNsToMonotonicNs();
        }

        @JvmStatic
        public final long realtimeMsToMonotonicMs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return realtimeMsToMonotonicNs(systemClockOffsets, j) / 1000000;
        }

        @JvmStatic
        public final long realtimeMsToUtcMs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return j - systemClockOffsets.getRealtimeNsToUtcMs();
        }

        @JvmStatic
        public final long monotonicNsToRealtimeNs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return systemClockOffsets.getRealtimeNsToMonotonicNs() + j;
        }

        @JvmStatic
        public final long monotonicNsToRealtimeMs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return monotonicNsToRealtimeNs(systemClockOffsets, j) / 1000000;
        }

        @JvmStatic
        public final long monotonicNsToUtcMs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return realtimeNsToUtcMs(systemClockOffsets, monotonicNsToRealtimeNs(systemClockOffsets, j));
        }

        @JvmStatic
        public final long monotonicMsToRealtimeNs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return systemClockOffsets.getRealtimeNsToMonotonicNs() + (j * 1000000);
        }

        @JvmStatic
        public final long monotonicMsToRealtimeMs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return monotonicMsToRealtimeNs(systemClockOffsets, j) / 1000000;
        }

        @JvmStatic
        public final long monotonicMsToUtcMs(SystemClockOffsets systemClockOffsets, long j) {
            Intrinsics.checkNotNullParameter(systemClockOffsets, "<this>");
            return realtimeNsToUtcMs(systemClockOffsets, monotonicMsToRealtimeNs(systemClockOffsets, j));
        }
    }

    public final long getRealtimeNsToMonotonicNs() {
        return this.realtimeNsToMonotonicNs;
    }

    public final long getRealtimeNsToUtcMs() {
        return this.realtimeNsToUtcMs;
    }
}
