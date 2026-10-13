package com.datadog.reactnative;

import android.view.Choreographer;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameRateProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/datadog/reactnative/FpsFrameCallback;", "Landroid/view/Choreographer$FrameCallback;", "reactFrameRateCallback", "Lkotlin/Function1;", "", "", "jsThreadExecutor", "Lcom/datadog/reactnative/JsThreadExecutor;", "<init>", "(Lkotlin/jvm/functions/Function1;Lcom/datadog/reactnative/JsThreadExecutor;)V", "choreographer", "Landroid/view/Choreographer;", "lastFrameTime", "", "doFrame", "time", ViewProps.START, "stop", "reset", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FpsFrameCallback implements Choreographer.FrameCallback {
    private Choreographer choreographer;
    private final JsThreadExecutor jsThreadExecutor;
    private long lastFrameTime;
    private final Function1<Double, Unit> reactFrameRateCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public FpsFrameCallback(Function1<? super Double, Unit> reactFrameRateCallback, JsThreadExecutor jsThreadExecutor) {
        Intrinsics.checkNotNullParameter(reactFrameRateCallback, "reactFrameRateCallback");
        Intrinsics.checkNotNullParameter(jsThreadExecutor, "jsThreadExecutor");
        this.reactFrameRateCallback = reactFrameRateCallback;
        this.jsThreadExecutor = jsThreadExecutor;
        this.lastFrameTime = -1L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long time) {
        long j = this.lastFrameTime;
        if (j != -1) {
            this.reactFrameRateCallback.invoke(Double.valueOf(time - j));
        }
        this.lastFrameTime = time;
        Choreographer choreographer = this.choreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(this);
        }
    }

    public final void start() {
        this.jsThreadExecutor.runOnJsThread(new Runnable() { // from class: com.datadog.reactnative.FpsFrameCallback$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FpsFrameCallback.start$lambda$0(this.f$0);
            }
        });
    }

    static final void start$lambda$0(FpsFrameCallback fpsFrameCallback) {
        try {
            Choreographer choreographer = Choreographer.getInstance();
            choreographer.removeFrameCallback(fpsFrameCallback);
            fpsFrameCallback.choreographer = choreographer;
            choreographer.postFrameCallback(fpsFrameCallback);
        } catch (IllegalStateException unused) {
        }
    }

    public final void stop() {
        this.jsThreadExecutor.runOnJsThread(new Runnable() { // from class: com.datadog.reactnative.FpsFrameCallback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FpsFrameCallback.stop$lambda$0(this.f$0);
            }
        });
    }

    static final void stop$lambda$0(FpsFrameCallback fpsFrameCallback) {
        Choreographer choreographer = fpsFrameCallback.choreographer;
        if (choreographer != null) {
            choreographer.removeFrameCallback(fpsFrameCallback);
        }
    }

    public final void reset() {
        this.lastFrameTime = -1L;
    }
}
