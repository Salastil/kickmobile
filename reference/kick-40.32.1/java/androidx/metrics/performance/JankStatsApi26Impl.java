package androidx.metrics.performance;

import android.view.FrameMetrics;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStatsApi26Impl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0010¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/metrics/performance/JankStatsApi26Impl;", "Landroidx/metrics/performance/JankStatsApi24Impl;", "jankStats", "Landroidx/metrics/performance/JankStats;", "view", "Landroid/view/View;", "window", "Landroid/view/Window;", "<init>", "(Landroidx/metrics/performance/JankStats;Landroid/view/View;Landroid/view/Window;)V", "getFrameStartTime", "", "frameMetrics", "Landroid/view/FrameMetrics;", "getFrameStartTime$metrics_performance_release", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class JankStatsApi26Impl extends JankStatsApi24Impl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JankStatsApi26Impl(JankStats jankStats, View view, Window window) {
        super(jankStats, view, window);
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(window, "window");
    }

    @Override // androidx.metrics.performance.JankStatsApi24Impl
    public long getFrameStartTime$metrics_performance_release(FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        return frameMetrics.getMetric(10);
    }
}
