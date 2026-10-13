package androidx.metrics.performance;

import android.os.Build;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStats.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Landroidx/metrics/performance/JankStats;", "", "window", "Landroid/view/Window;", "frameListener", "Landroidx/metrics/performance/JankStats$OnFrameListener;", "<init>", "(Landroid/view/Window;Landroidx/metrics/performance/JankStats$OnFrameListener;)V", "holder", "Landroidx/metrics/performance/PerformanceMetricsState$Holder;", "implementation", "Landroidx/metrics/performance/JankStatsBaseImpl;", "getImplementation$metrics_performance_release", "()Landroidx/metrics/performance/JankStatsBaseImpl;", "value", "", "isTrackingEnabled", "()Z", "setTrackingEnabled", "(Z)V", "", "jankHeuristicMultiplier", "getJankHeuristicMultiplier", "()F", "setJankHeuristicMultiplier", "(F)V", "logFrameData", "", "volatileFrameData", "Landroidx/metrics/performance/FrameData;", "logFrameData$metrics_performance_release", "Companion", "OnFrameListener", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JankStats {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final OnFrameListener frameListener;
    private final PerformanceMetricsState.Holder holder;
    private final JankStatsBaseImpl implementation;
    private boolean isTrackingEnabled;
    private float jankHeuristicMultiplier;

    /* JADX INFO: compiled from: JankStats.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/metrics/performance/JankStats$OnFrameListener;", "", "onFrame", "", "volatileFrameData", "Landroidx/metrics/performance/FrameData;", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnFrameListener {
        void onFrame(FrameData volatileFrameData);
    }

    public /* synthetic */ JankStats(Window window, OnFrameListener onFrameListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(window, onFrameListener);
    }

    @JvmStatic
    public static final JankStats createAndTrack(Window window, OnFrameListener onFrameListener) {
        return INSTANCE.createAndTrack(window, onFrameListener);
    }

    private JankStats(Window window, OnFrameListener onFrameListener) {
        JankStatsApi24Impl jankStatsApi24Impl;
        this.frameListener = onFrameListener;
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            throw new IllegalStateException("window.peekDecorView() is null: JankStats can only be created with a Window that has a non-null DecorView");
        }
        this.holder = PerformanceMetricsState.INSTANCE.create$metrics_performance_release(viewPeekDecorView);
        if (Build.VERSION.SDK_INT >= 31) {
            jankStatsApi24Impl = new JankStatsApi31Impl(this, viewPeekDecorView, window);
        } else if (Build.VERSION.SDK_INT >= 26) {
            jankStatsApi24Impl = new JankStatsApi26Impl(this, viewPeekDecorView, window);
        } else {
            jankStatsApi24Impl = new JankStatsApi24Impl(this, viewPeekDecorView, window);
        }
        this.implementation = jankStatsApi24Impl;
        ((JankStatsApi16Impl) jankStatsApi24Impl).setupFrameTimer(true);
        this.isTrackingEnabled = true;
        this.jankHeuristicMultiplier = 2.0f;
    }

    /* JADX INFO: renamed from: getImplementation$metrics_performance_release, reason: from getter */
    public final JankStatsBaseImpl getImplementation() {
        return this.implementation;
    }

    /* JADX INFO: renamed from: isTrackingEnabled, reason: from getter */
    public final boolean getIsTrackingEnabled() {
        return this.isTrackingEnabled;
    }

    public final void setTrackingEnabled(boolean z) {
        if (z != this.isTrackingEnabled) {
            this.implementation.setupFrameTimer(z);
            this.isTrackingEnabled = z;
        }
    }

    public final float getJankHeuristicMultiplier() {
        return this.jankHeuristicMultiplier;
    }

    public final void setJankHeuristicMultiplier(float f) {
        JankStatsBaseImpl.INSTANCE.setFrameDuration(-1L);
        this.jankHeuristicMultiplier = f;
    }

    public final void logFrameData$metrics_performance_release(FrameData volatileFrameData) {
        Intrinsics.checkNotNullParameter(volatileFrameData, "volatileFrameData");
        this.frameListener.onFrame(volatileFrameData);
    }

    /* JADX INFO: compiled from: JankStats.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/metrics/performance/JankStats$Companion;", "", "<init>", "()V", "createAndTrack", "Landroidx/metrics/performance/JankStats;", "window", "Landroid/view/Window;", "frameListener", "Landroidx/metrics/performance/JankStats$OnFrameListener;", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final JankStats createAndTrack(Window window, OnFrameListener frameListener) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(frameListener, "frameListener");
            return new JankStats(window, frameListener, null);
        }
    }
}
