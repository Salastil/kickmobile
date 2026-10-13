package androidx.metrics.performance;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.FrameMetrics;
import android.view.Window;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStatsApi24Impl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0001H\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0001H\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/metrics/performance/DelegatingFrameMetricsListener;", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "delegates", "", "<init>", "(Ljava/util/List;)V", "getDelegates", "()Ljava/util/List;", "onFrameMetricsAvailable", "", "window", "Landroid/view/Window;", "frameMetrics", "Landroid/view/FrameMetrics;", "dropCount", "", "add", "delegate", "remove", "Companion", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DelegatingFrameMetricsListener implements Window.OnFrameMetricsAvailableListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Handler frameMetricsHandler;
    private final List<Window.OnFrameMetricsAvailableListener> delegates;

    public DelegatingFrameMetricsListener(List<Window.OnFrameMetricsAvailableListener> delegates) {
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.delegates = delegates;
    }

    public final List<Window.OnFrameMetricsAvailableListener> getDelegates() {
        return this.delegates;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int dropCount) {
        synchronized (this) {
            Iterator<Window.OnFrameMetricsAvailableListener> it = this.delegates.iterator();
            while (it.hasNext()) {
                it.next().onFrameMetricsAvailable(window, frameMetrics, dropCount);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void add(Window.OnFrameMetricsAvailableListener delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        synchronized (this) {
            this.delegates.add(delegate);
        }
    }

    public final void remove(Window.OnFrameMetricsAvailableListener delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        synchronized (this) {
            this.delegates.remove(delegate);
        }
    }

    /* JADX INFO: compiled from: JankStatsApi24Impl.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/metrics/performance/DelegatingFrameMetricsListener$Companion;", "", "<init>", "()V", "frameMetricsHandler", "Landroid/os/Handler;", "getFrameMetricsHandler$metrics_performance_release", "()Landroid/os/Handler;", "setFrameMetricsHandler$metrics_performance_release", "(Landroid/os/Handler;)V", "addDelegateToWindow", "", "window", "Landroid/view/Window;", "delegate", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "removeDelegateFromWindow", "", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Handler getFrameMetricsHandler$metrics_performance_release() {
            return DelegatingFrameMetricsListener.frameMetricsHandler;
        }

        public final void setFrameMetricsHandler$metrics_performance_release(Handler handler) {
            DelegatingFrameMetricsListener.frameMetricsHandler = handler;
        }

        public final boolean addDelegateToWindow(Window window, Window.OnFrameMetricsAvailableListener delegate) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            if (!window.getDecorView().isHardwareAccelerated()) {
                return false;
            }
            DelegatingFrameMetricsListener delegatingFrameMetricsListener = (DelegatingFrameMetricsListener) window.getDecorView().getTag(R.id.metricsDelegator);
            if (delegatingFrameMetricsListener == null) {
                DelegatingFrameMetricsListener delegatingFrameMetricsListener2 = new DelegatingFrameMetricsListener(CollectionsKt.mutableListOf(delegate));
                if (getFrameMetricsHandler$metrics_performance_release() == null) {
                    HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                    handlerThread.start();
                    setFrameMetricsHandler$metrics_performance_release(new Handler(handlerThread.getLooper()));
                }
                window.getDecorView().setTag(R.id.metricsDelegator, delegatingFrameMetricsListener2);
                window.addOnFrameMetricsAvailableListener(delegatingFrameMetricsListener2, getFrameMetricsHandler$metrics_performance_release());
                return true;
            }
            delegatingFrameMetricsListener.add(delegate);
            return true;
        }

        public final void removeDelegateFromWindow(Window window, Window.OnFrameMetricsAvailableListener delegate) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            DelegatingFrameMetricsListener delegatingFrameMetricsListener = (DelegatingFrameMetricsListener) window.getDecorView().getTag(R.id.metricsDelegator);
            if (delegatingFrameMetricsListener != null) {
                delegatingFrameMetricsListener.remove(delegate);
                if (delegatingFrameMetricsListener.getDelegates().isEmpty()) {
                    try {
                        window.removeOnFrameMetricsAvailableListener(delegatingFrameMetricsListener);
                    } catch (IllegalArgumentException unused) {
                    }
                    window.getDecorView().setTag(R.id.metricsDelegator, null);
                }
            }
        }
    }
}
