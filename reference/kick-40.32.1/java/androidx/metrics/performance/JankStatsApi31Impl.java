package androidx.metrics.performance;

import android.view.FrameMetrics;
import android.view.View;
import android.view.Window;
import com.datadog.android.trace.internal.domain.event.SpanEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStatsApi31Impl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Landroidx/metrics/performance/JankStatsApi31Impl;", "Landroidx/metrics/performance/JankStatsApi26Impl;", "jankStats", "Landroidx/metrics/performance/JankStats;", "view", "Landroid/view/View;", "window", "Landroid/view/Window;", "<init>", "(Landroidx/metrics/performance/JankStats;Landroid/view/View;Landroid/view/Window;)V", "frameData", "Landroidx/metrics/performance/FrameDataApi31;", "getFrameData", "()Landroidx/metrics/performance/FrameDataApi31;", "startTime", "", "expectedDuration", "frameMetrics", "Landroid/view/FrameMetrics;", "getFrameData$metrics_performance_release", "getExpectedFrameDuration", SpanEventSerializer.METRICS_KEY_PREFIX, "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JankStatsApi31Impl extends JankStatsApi26Impl {
    private final FrameDataApi31 frameData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JankStatsApi31Impl(JankStats jankStats, View view, Window window) {
        super(jankStats, view, window);
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(window, "window");
        this.frameData = new FrameDataApi31(0L, 0L, 0L, 0L, 0L, false, getStateInfo());
    }

    public final FrameDataApi31 getFrameData() {
        return this.frameData;
    }

    @Override // androidx.metrics.performance.JankStatsApi24Impl
    public FrameDataApi31 getFrameData$metrics_performance_release(long startTime, long expectedDuration, FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        long metric = frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
        setPrevEnd(startTime + metric);
        PerformanceMetricsState state = getMetricsStateHolder().getState();
        if (state != null) {
            state.getIntervalStates$metrics_performance_release(startTime, getPrevEnd(), getStateInfo());
        }
        boolean z = metric > expectedDuration;
        long metric2 = frameMetrics.getMetric(8);
        this.frameData.update$metrics_performance_release(startTime, metric, (metric2 - frameMetrics.getMetric(12)) + frameMetrics.getMetric(7), metric2, metric2 - frameMetrics.getMetric(13), z);
        return this.frameData;
    }

    @Override // androidx.metrics.performance.JankStatsApi24Impl
    public long getExpectedFrameDuration(FrameMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return metrics.getMetric(13);
    }
}
