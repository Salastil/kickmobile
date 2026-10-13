package androidx.metrics.performance;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.os.MessageCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStatsApi16Impl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0010\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Landroidx/metrics/performance/DelegatingOnPreDrawListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "decorView", "Landroid/view/View;", "choreographer", "Landroid/view/Choreographer;", "delegates", "", "Landroidx/metrics/performance/OnFrameListenerDelegate;", "<init>", "(Landroid/view/View;Landroid/view/Choreographer;Ljava/util/List;)V", "getChoreographer", "()Landroid/view/Choreographer;", "getDelegates", "()Ljava/util/List;", "decorViewRef", "Ljava/lang/ref/WeakReference;", "getDecorViewRef", "()Ljava/lang/ref/WeakReference;", "metricsStateHolder", "Landroidx/metrics/performance/PerformanceMetricsState$Holder;", "getMetricsStateHolder", "()Landroidx/metrics/performance/PerformanceMetricsState$Holder;", "onPreDraw", "", "add", "", "delegate", "remove", "getFrameStartTime", "", "Companion", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class DelegatingOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Field choreographerLastFrameTimeField;
    private final Choreographer choreographer;
    private final WeakReference<View> decorViewRef;
    private final List<OnFrameListenerDelegate> delegates;
    private final PerformanceMetricsState.Holder metricsStateHolder;

    public DelegatingOnPreDrawListener(View decorView, Choreographer choreographer, List<OnFrameListenerDelegate> delegates) {
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        Intrinsics.checkNotNullParameter(choreographer, "choreographer");
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.choreographer = choreographer;
        this.delegates = delegates;
        this.decorViewRef = new WeakReference<>(decorView);
        this.metricsStateHolder = PerformanceMetricsState.INSTANCE.getHolderForHierarchy(decorView);
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public final List<OnFrameListenerDelegate> getDelegates() {
        return this.delegates;
    }

    public final WeakReference<View> getDecorViewRef() {
        return this.decorViewRef;
    }

    public final PerformanceMetricsState.Holder getMetricsStateHolder() {
        return this.metricsStateHolder;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() throws IllegalAccessException {
        final View view = this.decorViewRef.get();
        if (view != null) {
            final long frameStartTime = getFrameStartTime();
            Handler handler = view.getHandler();
            Message messageObtain = Message.obtain(view.getHandler(), new Runnable() { // from class: androidx.metrics.performance.DelegatingOnPreDrawListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DelegatingOnPreDrawListener.onPreDraw$lambda$4$lambda$3$lambda$1(view, this, frameStartTime);
                }
            });
            MessageCompat.setAsynchronous(messageObtain, true);
            handler.sendMessageAtFrontOfQueue(messageObtain);
        }
        return true;
    }

    static final void onPreDraw$lambda$4$lambda$3$lambda$1(View view, DelegatingOnPreDrawListener delegatingOnPreDrawListener, long j) {
        long jNanoTime = System.nanoTime();
        long expectedFrameDuration = INSTANCE.getExpectedFrameDuration(view);
        synchronized (delegatingOnPreDrawListener) {
            Iterator<OnFrameListenerDelegate> it = delegatingOnPreDrawListener.delegates.iterator();
            while (it.hasNext()) {
                long j2 = j;
                it.next().onFrame(j2, jNanoTime - j, expectedFrameDuration);
                j = j2;
            }
            Unit unit = Unit.INSTANCE;
        }
        PerformanceMetricsState state = delegatingOnPreDrawListener.metricsStateHolder.getState();
        if (state != null) {
            state.cleanupSingleFrameStates$metrics_performance_release();
        }
    }

    public final void add(OnFrameListenerDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        synchronized (this) {
            this.delegates.add(delegate);
        }
    }

    public final void remove(OnFrameListenerDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        synchronized (this) {
            this.delegates.remove(delegate);
        }
    }

    private final long getFrameStartTime() throws IllegalAccessException {
        Object obj = choreographerLastFrameTimeField.get(this.choreographer);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) obj).longValue();
    }

    /* JADX INFO: compiled from: JankStatsApi16Impl.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/metrics/performance/DelegatingOnPreDrawListener$Companion;", "", "<init>", "()V", "addDelegateToDecorView", "", "decorView", "Landroid/view/View;", "choreographer", "Landroid/view/Choreographer;", "delegate", "Landroidx/metrics/performance/OnFrameListenerDelegate;", "removeDelegateFromDecorView", "choreographerLastFrameTimeField", "Ljava/lang/reflect/Field;", "getChoreographerLastFrameTimeField", "()Ljava/lang/reflect/Field;", "getExpectedFrameDuration", "", "view", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void addDelegateToDecorView(View decorView, Choreographer choreographer, OnFrameListenerDelegate delegate) {
            Intrinsics.checkNotNullParameter(decorView, "decorView");
            Intrinsics.checkNotNullParameter(choreographer, "choreographer");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            DelegatingOnPreDrawListener delegatingOnPreDrawListener = (DelegatingOnPreDrawListener) decorView.getTag(R.id.metricsDelegator);
            if (delegatingOnPreDrawListener == null) {
                DelegatingOnPreDrawListener delegatingOnPreDrawListener2 = new DelegatingOnPreDrawListener(decorView, choreographer, CollectionsKt.mutableListOf(delegate));
                decorView.getViewTreeObserver().addOnPreDrawListener(delegatingOnPreDrawListener2);
                decorView.setTag(R.id.metricsDelegator, delegatingOnPreDrawListener2);
                return;
            }
            delegatingOnPreDrawListener.add(delegate);
        }

        public final void removeDelegateFromDecorView(View decorView, OnFrameListenerDelegate delegate) {
            Intrinsics.checkNotNullParameter(decorView, "decorView");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            DelegatingOnPreDrawListener delegatingOnPreDrawListener = (DelegatingOnPreDrawListener) decorView.getTag(R.id.metricsDelegator);
            if (delegatingOnPreDrawListener != null) {
                delegatingOnPreDrawListener.remove(delegate);
                if (delegatingOnPreDrawListener.getDelegates().isEmpty()) {
                    decorView.getViewTreeObserver().removeOnPreDrawListener(delegatingOnPreDrawListener);
                    decorView.setTag(R.id.metricsDelegator, null);
                }
            }
        }

        public final Field getChoreographerLastFrameTimeField() {
            return DelegatingOnPreDrawListener.choreographerLastFrameTimeField;
        }

        public final long getExpectedFrameDuration(View view) {
            if (JankStatsBaseImpl.INSTANCE.getFrameDuration() < 0) {
                Window window = null;
                if ((view != null ? view.getContext() : null) instanceof Activity) {
                    Context context = view.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    window = ((Activity) context).getWindow();
                }
                float f = 60.0f;
                float refreshRate = window != null ? window.getWindowManager().getDefaultDisplay().getRefreshRate() : 60.0f;
                if (refreshRate >= 30.0f && refreshRate <= 200.0f) {
                    f = refreshRate;
                }
                JankStatsBaseImpl.INSTANCE.setFrameDuration((long) ((1000.0f / f) * 1000000.0f));
            }
            return JankStatsBaseImpl.INSTANCE.getFrameDuration();
        }
    }

    static {
        Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
        Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
        choreographerLastFrameTimeField = declaredField;
        declaredField.setAccessible(true);
    }
}
