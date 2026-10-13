package androidx.metrics.performance;

import android.view.Choreographer;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStatsApi16Impl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007*\u0001\u001c\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J%\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0010¢\u0006\u0002\b'J\r\u0010(\u001a\u00020$H\u0000¢\u0006\u0002\b)J\u0010\u0010*\u001a\u00020$2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006+"}, d2 = {"Landroidx/metrics/performance/JankStatsApi16Impl;", "Landroidx/metrics/performance/JankStatsBaseImpl;", "jankStats", "Landroidx/metrics/performance/JankStats;", "view", "Landroid/view/View;", "<init>", "(Landroidx/metrics/performance/JankStats;Landroid/view/View;)V", "decorViewRef", "Ljava/lang/ref/WeakReference;", "getDecorViewRef$metrics_performance_release", "()Ljava/lang/ref/WeakReference;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "metricsStateHolder", "Landroidx/metrics/performance/PerformanceMetricsState$Holder;", "getMetricsStateHolder", "()Landroidx/metrics/performance/PerformanceMetricsState$Holder;", "stateInfo", "", "Landroidx/metrics/performance/StateInfo;", "getStateInfo", "()Ljava/util/List;", "frameData", "Landroidx/metrics/performance/FrameData;", "onFrameListenerDelegate", "androidx/metrics/performance/JankStatsApi16Impl$onFrameListenerDelegate$1", "Landroidx/metrics/performance/JankStatsApi16Impl$onFrameListenerDelegate$1;", "setupFrameTimer", "", "enable", "", "getFrameData", "startTime", "", "uiDuration", "expectedDuration", "getFrameData$metrics_performance_release", "getFrameStartTime", "getFrameStartTime$metrics_performance_release", "getExpectedFrameDuration", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class JankStatsApi16Impl extends JankStatsBaseImpl {
    private final Choreographer choreographer;
    private final WeakReference<View> decorViewRef;
    private final FrameData frameData;
    private final PerformanceMetricsState.Holder metricsStateHolder;
    private final JankStatsApi16Impl$onFrameListenerDelegate$1 onFrameListenerDelegate;
    private final List<StateInfo> stateInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r9v3, types: [androidx.metrics.performance.JankStatsApi16Impl$onFrameListenerDelegate$1] */
    public JankStatsApi16Impl(final JankStats jankStats, View view) {
        super(jankStats);
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        Intrinsics.checkNotNullParameter(view, "view");
        this.decorViewRef = new WeakReference<>(view);
        Choreographer choreographer = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(choreographer, "getInstance(...)");
        this.choreographer = choreographer;
        this.metricsStateHolder = PerformanceMetricsState.INSTANCE.getHolderForHierarchy(view);
        ArrayList arrayList = new ArrayList();
        this.stateInfo = arrayList;
        this.frameData = new FrameData(0L, 0L, false, arrayList);
        this.onFrameListenerDelegate = new OnFrameListenerDelegate() { // from class: androidx.metrics.performance.JankStatsApi16Impl$onFrameListenerDelegate$1
            @Override // androidx.metrics.performance.OnFrameListenerDelegate
            public void onFrame(long startTime, long uiDuration, long expectedDuration) {
                JankStats jankStats2 = jankStats;
                jankStats2.logFrameData$metrics_performance_release(this.getFrameData$metrics_performance_release(startTime, uiDuration, (long) (expectedDuration * jankStats2.getJankHeuristicMultiplier())));
            }
        };
    }

    public final WeakReference<View> getDecorViewRef$metrics_performance_release() {
        return this.decorViewRef;
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public final PerformanceMetricsState.Holder getMetricsStateHolder() {
        return this.metricsStateHolder;
    }

    public final List<StateInfo> getStateInfo() {
        return this.stateInfo;
    }

    @Override // androidx.metrics.performance.JankStatsBaseImpl
    public void setupFrameTimer(final boolean enable) {
        final View view = this.decorViewRef.get();
        if (view != null) {
            view.post(new Runnable() { // from class: androidx.metrics.performance.JankStatsApi16Impl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    JankStatsApi16Impl.setupFrameTimer$lambda$0(enable, view, this);
                }
            });
        }
    }

    static final void setupFrameTimer$lambda$0(boolean z, View view, JankStatsApi16Impl jankStatsApi16Impl) {
        if (z) {
            DelegatingOnPreDrawListener.INSTANCE.addDelegateToDecorView(view, jankStatsApi16Impl.choreographer, jankStatsApi16Impl.onFrameListenerDelegate);
        } else {
            DelegatingOnPreDrawListener.INSTANCE.removeDelegateFromDecorView(view, jankStatsApi16Impl.onFrameListenerDelegate);
        }
    }

    public FrameData getFrameData$metrics_performance_release(long startTime, long uiDuration, long expectedDuration) {
        long j;
        PerformanceMetricsState state = this.metricsStateHolder.getState();
        if (state != null) {
            j = startTime;
            state.getIntervalStates$metrics_performance_release(j, startTime + uiDuration, this.stateInfo);
        } else {
            j = startTime;
        }
        this.frameData.update$metrics_performance_release(j, uiDuration, uiDuration > expectedDuration);
        return this.frameData;
    }

    public final long getFrameStartTime$metrics_performance_release() throws IllegalAccessException {
        Object obj = DelegatingOnPreDrawListener.INSTANCE.getChoreographerLastFrameTimeField().get(this.choreographer);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) obj).longValue();
    }

    public final long getExpectedFrameDuration(View view) {
        return DelegatingOnPreDrawListener.INSTANCE.getExpectedFrameDuration(view);
    }
}
