package expo.modules.kotlin.views;

import android.view.ViewTreeObserver;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import expo.modules.kotlin.jni.fabric.NativeStatePropsGetter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShadowNodeProxy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u001f\u0010\u001b\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0012J+\u0010!\u001a\u00020\u00122!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0002J\b\u0010#\u001a\u00020\u0012H\u0002R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lexpo/modules/kotlin/views/ShadowNodeProxy;", "", "expoView", "Lexpo/modules/kotlin/views/ExpoView;", "<init>", "(Lexpo/modules/kotlin/views/ExpoView;)V", "weakExpoView", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakExpoView", "()Ljava/lang/ref/WeakReference;", "stateUpdater", "Lexpo/modules/kotlin/jni/fabric/NativeStatePropsGetter;", "pendingFlush", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "stateWrapper", "", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "flushRunnable", "Ljava/lang/Runnable;", "setViewSize", ViewProps.WIDTH, "", ViewProps.HEIGHT, "setStyleSize", "(Ljava/lang/Double;Ljava/lang/Double;)V", "setContentOrigin", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "clearContentOrigin", "scheduleFlush", "flush", "drainPendingFlush", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ShadowNodeProxy {
    public static final int $stable = 8;
    private final Runnable flushRunnable;
    private Function1<Object, Unit> pendingFlush;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    private final NativeStatePropsGetter stateUpdater;
    private final WeakReference<ExpoView> weakExpoView;

    public ShadowNodeProxy(ExpoView expoView) {
        Intrinsics.checkNotNullParameter(expoView, "expoView");
        this.weakExpoView = new WeakReference<>(expoView);
        this.stateUpdater = new NativeStatePropsGetter();
        this.flushRunnable = new Runnable() { // from class: expo.modules.kotlin.views.ShadowNodeProxy$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.drainPendingFlush();
            }
        };
    }

    public final WeakReference<ExpoView> getWeakExpoView() {
        return this.weakExpoView;
    }

    public final void setViewSize(final double width, final double height) {
        scheduleFlush(new Function1() { // from class: expo.modules.kotlin.views.ShadowNodeProxy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ShadowNodeProxy.setViewSize$lambda$0(this.f$0, width, height, obj);
            }
        });
    }

    static final Unit setViewSize$lambda$0(ShadowNodeProxy shadowNodeProxy, double d, double d2, Object stateWrapper) {
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        shadowNodeProxy.stateUpdater.updateViewSizeImmediate(stateWrapper, d, d2);
        return Unit.INSTANCE;
    }

    public final void setStyleSize(final Double width, final Double height) {
        scheduleFlush(new Function1() { // from class: expo.modules.kotlin.views.ShadowNodeProxy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ShadowNodeProxy.setStyleSize$lambda$0(this.f$0, width, height, obj);
            }
        });
    }

    static final Unit setStyleSize$lambda$0(ShadowNodeProxy shadowNodeProxy, Double d, Double d2, Object stateWrapper) {
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        shadowNodeProxy.stateUpdater.updateStyleSizeImmediate(stateWrapper, d != null ? d.doubleValue() : Double.NaN, d2 != null ? d2.doubleValue() : Double.NaN);
        return Unit.INSTANCE;
    }

    public final void setContentOrigin(double x, double y) {
        ExpoView expoView = this.weakExpoView.get();
        if (expoView == null) {
            return;
        }
        this.stateUpdater.setContentOrigin(expoView.getId(), x, y);
    }

    public final void clearContentOrigin() {
        ExpoView expoView = this.weakExpoView.get();
        if (expoView == null) {
            return;
        }
        this.stateUpdater.clearContentOrigin(expoView.getId());
    }

    private final void scheduleFlush(Function1<Object, Unit> flush) {
        this.pendingFlush = flush;
        ExpoView expoView = this.weakExpoView.get();
        if (expoView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = expoView.getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            viewTreeObserver = null;
        }
        if (viewTreeObserver != null) {
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
            if (onPreDrawListener != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            }
            ViewTreeObserver.OnPreDrawListener onPreDrawListener2 = new ViewTreeObserver.OnPreDrawListener() { // from class: expo.modules.kotlin.views.ShadowNodeProxy$scheduleFlush$listener$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    ViewTreeObserver viewTreeObserver2;
                    this.this$0.preDrawListener = null;
                    ExpoView expoView2 = this.this$0.getWeakExpoView().get();
                    if (expoView2 != null && (viewTreeObserver2 = expoView2.getViewTreeObserver()) != null) {
                        ViewTreeObserver viewTreeObserver3 = viewTreeObserver2.isAlive() ? viewTreeObserver2 : null;
                        if (viewTreeObserver3 != null) {
                            viewTreeObserver3.removeOnPreDrawListener(this);
                        }
                    }
                    this.this$0.drainPendingFlush();
                    return true;
                }
            };
            this.preDrawListener = onPreDrawListener2;
            viewTreeObserver.addOnPreDrawListener(onPreDrawListener2);
        }
        expoView.removeCallbacks(this.flushRunnable);
        expoView.post(this.flushRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drainPendingFlush() {
        StateWrapper stateWrapper;
        Function1<Object, Unit> function1 = this.pendingFlush;
        if (function1 == null) {
            return;
        }
        this.pendingFlush = null;
        ExpoView expoView = this.weakExpoView.get();
        if (expoView == null || (stateWrapper = expoView.getStateWrapper()) == null) {
            return;
        }
        function1.invoke(stateWrapper);
    }
}
