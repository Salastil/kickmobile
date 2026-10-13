package androidx.metrics.performance;

import android.view.FrameMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStatsInternalsForTesting.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/metrics/performance/JankStatsInternalsForTesting;", "", "jankStats", "Landroidx/metrics/performance/JankStats;", "<init>", "(Landroidx/metrics/performance/JankStats;)V", "getJankStats", "()Landroidx/metrics/performance/JankStats;", "impl", "Landroidx/metrics/performance/JankStatsBaseImpl;", "removeStateNow", "", "performanceMetricsState", "Landroidx/metrics/performance/PerformanceMetricsState;", "stateName", "", "getFrameData", "Landroidx/metrics/performance/FrameData;", "frameMetrics", "Landroid/view/FrameMetrics;", "logFrameData", "frameData", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JankStatsInternalsForTesting {
    private final JankStatsBaseImpl impl;
    private final JankStats jankStats;

    public JankStatsInternalsForTesting(JankStats jankStats) {
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        this.jankStats = jankStats;
        this.impl = jankStats.getImplementation();
    }

    public final JankStats getJankStats() {
        return this.jankStats;
    }

    public final void removeStateNow(PerformanceMetricsState performanceMetricsState, String stateName) {
        Intrinsics.checkNotNullParameter(performanceMetricsState, "performanceMetricsState");
        Intrinsics.checkNotNullParameter(stateName, "stateName");
        performanceMetricsState.removeStateNow$metrics_performance_release(stateName);
    }

    public final FrameData getFrameData() {
        JankStatsBaseImpl jankStatsBaseImpl = this.impl;
        if (jankStatsBaseImpl instanceof JankStatsApi16Impl) {
            return ((JankStatsApi16Impl) jankStatsBaseImpl).getFrameData$metrics_performance_release(0L, 0L, 0L);
        }
        return null;
    }

    public final FrameData getFrameData(FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        JankStatsBaseImpl jankStatsBaseImpl = this.impl;
        if (jankStatsBaseImpl instanceof JankStatsApi24Impl) {
            return ((JankStatsApi24Impl) jankStatsBaseImpl).getFrameData$metrics_performance_release(0L, 0L, frameMetrics);
        }
        return null;
    }

    public final void logFrameData(FrameData frameData) {
        Intrinsics.checkNotNullParameter(frameData, "frameData");
        this.jankStats.logFrameData$metrics_performance_release(frameData);
    }
}
