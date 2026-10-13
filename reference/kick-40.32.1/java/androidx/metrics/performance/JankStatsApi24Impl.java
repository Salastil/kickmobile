package androidx.metrics.performance;

import android.view.FrameMetrics;
import android.view.View;
import android.view.Window;
import com.datadog.android.trace.internal.domain.event.SpanEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStatsApi24Impl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0010¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0010¢\u0006\u0002\b!J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001eH\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/metrics/performance/JankStatsApi24Impl;", "Landroidx/metrics/performance/JankStatsApi16Impl;", "jankStats", "Landroidx/metrics/performance/JankStats;", "view", "Landroid/view/View;", "window", "Landroid/view/Window;", "<init>", "(Landroidx/metrics/performance/JankStats;Landroid/view/View;Landroid/view/Window;)V", "prevStart", "", "getPrevStart", "()J", "setPrevStart", "(J)V", "listenerAddedTime", "getListenerAddedTime", "setListenerAddedTime", "prevEnd", "getPrevEnd", "setPrevEnd", "frameData", "Landroidx/metrics/performance/FrameDataApi24;", "frameMetricsAvailableListenerDelegate", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "getFrameData", "startTime", "expectedDuration", "frameMetrics", "Landroid/view/FrameMetrics;", "getFrameData$metrics_performance_release", "getFrameStartTime", "getFrameStartTime$metrics_performance_release", "getExpectedFrameDuration", SpanEventSerializer.METRICS_KEY_PREFIX, "setupFrameTimer", "", "enable", "", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class JankStatsApi24Impl extends JankStatsApi16Impl {
    private final FrameDataApi24 frameData;
    private final Window.OnFrameMetricsAvailableListener frameMetricsAvailableListenerDelegate;
    private long listenerAddedTime;
    private long prevEnd;
    private long prevStart;
    private final Window window;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JankStatsApi24Impl(final JankStats jankStats, View view, Window window) {
        super(jankStats, view);
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(window, "window");
        this.window = window;
        this.frameData = new FrameDataApi24(0L, 0L, 0L, false, getStateInfo());
        this.frameMetricsAvailableListenerDelegate = new Window.OnFrameMetricsAvailableListener() { // from class: androidx.metrics.performance.JankStatsApi24Impl$$ExternalSyntheticLambda1
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public final void onFrameMetricsAvailable(Window window2, FrameMetrics frameMetrics, int i) {
                JankStatsApi24Impl.frameMetricsAvailableListenerDelegate$lambda$0(this.f$0, jankStats, window2, frameMetrics, i);
            }
        };
    }

    public final long getPrevStart() {
        return this.prevStart;
    }

    public final void setPrevStart(long j) {
        this.prevStart = j;
    }

    public final long getListenerAddedTime() {
        return this.listenerAddedTime;
    }

    public final void setListenerAddedTime(long j) {
        this.listenerAddedTime = j;
    }

    public final long getPrevEnd() {
        return this.prevEnd;
    }

    public final void setPrevEnd(long j) {
        this.prevEnd = j;
    }

    static final void frameMetricsAvailableListenerDelegate$lambda$0(JankStatsApi24Impl jankStatsApi24Impl, JankStats jankStats, Window window, FrameMetrics frameMetrics, int i) {
        Intrinsics.checkNotNull(frameMetrics);
        long jMax = Math.max(jankStatsApi24Impl.getFrameStartTime$metrics_performance_release(frameMetrics), jankStatsApi24Impl.prevEnd);
        if (jMax < jankStatsApi24Impl.listenerAddedTime || jMax == jankStatsApi24Impl.prevStart) {
            return;
        }
        jankStats.logFrameData$metrics_performance_release(jankStatsApi24Impl.getFrameData$metrics_performance_release(jMax, (long) (jankStatsApi24Impl.getExpectedFrameDuration(frameMetrics) * jankStats.getJankHeuristicMultiplier()), frameMetrics));
        jankStatsApi24Impl.prevStart = jMax;
    }

    public FrameDataApi24 getFrameData$metrics_performance_release(long startTime, long expectedDuration, FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        long metric = frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
        this.prevEnd = startTime + metric;
        PerformanceMetricsState state = getMetricsStateHolder().getState();
        if (state != null) {
            state.getIntervalStates$metrics_performance_release(startTime, this.prevEnd, getStateInfo());
        }
        this.frameData.update$metrics_performance_release(startTime, metric, frameMetrics.getMetric(8), metric > expectedDuration);
        return this.frameData;
    }

    public long getFrameStartTime$metrics_performance_release(FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        return getFrameStartTime$metrics_performance_release();
    }

    public long getExpectedFrameDuration(FrameMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return getExpectedFrameDuration(getDecorViewRef$metrics_performance_release().get());
    }

    @Override // androidx.metrics.performance.JankStatsApi16Impl, androidx.metrics.performance.JankStatsBaseImpl
    public void setupFrameTimer(final boolean enable) {
        this.window.getDecorView().post(new Runnable() { // from class: androidx.metrics.performance.JankStatsApi24Impl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                JankStatsApi24Impl.setupFrameTimer$lambda$1(enable, this);
            }
        });
    }

    static final void setupFrameTimer$lambda$1(boolean z, JankStatsApi24Impl jankStatsApi24Impl) {
        if (z) {
            if (jankStatsApi24Impl.listenerAddedTime == 0 && DelegatingFrameMetricsListener.INSTANCE.addDelegateToWindow(jankStatsApi24Impl.window, jankStatsApi24Impl.frameMetricsAvailableListenerDelegate)) {
                jankStatsApi24Impl.listenerAddedTime = System.nanoTime();
                return;
            }
            return;
        }
        DelegatingFrameMetricsListener.INSTANCE.removeDelegateFromWindow(jankStatsApi24Impl.window, jankStatsApi24Impl.frameMetricsAvailableListenerDelegate);
        jankStatsApi24Impl.listenerAddedTime = 0L;
    }
}
