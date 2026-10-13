package androidx.metrics.performance;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStatsBaseImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0010\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/metrics/performance/JankStatsBaseImpl;", "", "jankStats", "Landroidx/metrics/performance/JankStats;", "<init>", "(Landroidx/metrics/performance/JankStats;)V", "getJankStats", "()Landroidx/metrics/performance/JankStats;", "setupFrameTimer", "", "enable", "", "Companion", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class JankStatsBaseImpl {
    public static final int NANOS_PER_MS = 1000000;
    private final JankStats jankStats;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static long frameDuration = -1;

    public void setupFrameTimer(boolean enable) {
    }

    public JankStatsBaseImpl(JankStats jankStats) {
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        this.jankStats = jankStats;
    }

    public final JankStats getJankStats() {
        return this.jankStats;
    }

    /* JADX INFO: compiled from: JankStatsBaseImpl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/metrics/performance/JankStatsBaseImpl$Companion;", "", "<init>", "()V", "NANOS_PER_MS", "", "frameDuration", "", "getFrameDuration", "()J", "setFrameDuration", "(J)V", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getFrameDuration() {
            return JankStatsBaseImpl.frameDuration;
        }

        public final void setFrameDuration(long j) {
            JankStatsBaseImpl.frameDuration = j;
        }
    }
}
