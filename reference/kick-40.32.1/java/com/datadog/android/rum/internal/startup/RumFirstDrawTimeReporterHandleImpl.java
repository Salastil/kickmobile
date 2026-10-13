package com.datadog.android.rum.internal.startup;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.utils.window.RumWindowCallbackListener;
import com.datadog.android.rum.internal.utils.window.RumWindowCallbacksRegistry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumFirstDrawTimeReporterHandleImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B;\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporterHandleImpl;", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Handle;", "Lcom/datadog/android/rum/internal/utils/window/RumWindowCallbackListener;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "callback", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Callback;", "activity", "Landroid/app/Activity;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "timeProviderNs", "Lkotlin/Function0;", "", "windowCallbacksRegistry", "Lcom/datadog/android/rum/internal/utils/window/RumWindowCallbacksRegistry;", "handler", "Landroid/os/Handler;", "(Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Callback;Landroid/app/Activity;Lcom/datadog/android/api/InternalLogger;Lkotlin/jvm/functions/Function0;Lcom/datadog/android/rum/internal/utils/window/RumWindowCallbacksRegistry;Landroid/os/Handler;)V", "isCancelled", "", "onDrawInvoked", "getDecorView", "Landroid/view/View;", "onContentChanged", "", "onDecorViewReady", "decorView", "onDraw", "onFirstDraw", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "registerOnDrawListener", "removeOnDrawListener", "reportFirstFrame", "unsubscribe", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumFirstDrawTimeReporterHandleImpl implements RumFirstDrawTimeReporter.Handle, RumWindowCallbackListener, View.OnAttachStateChangeListener, ViewTreeObserver.OnDrawListener {
    private final Activity activity;
    private final RumFirstDrawTimeReporter.Callback callback;
    private final Handler handler;
    private final InternalLogger internalLogger;
    private boolean isCancelled;
    private boolean onDrawInvoked;
    private final Function0<Long> timeProviderNs;
    private final RumWindowCallbacksRegistry windowCallbacksRegistry;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
    }

    public RumFirstDrawTimeReporterHandleImpl(RumFirstDrawTimeReporter.Callback callback, Activity activity, InternalLogger internalLogger, Function0<Long> timeProviderNs, RumWindowCallbacksRegistry windowCallbacksRegistry, Handler handler) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(timeProviderNs, "timeProviderNs");
        Intrinsics.checkNotNullParameter(windowCallbacksRegistry, "windowCallbacksRegistry");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.callback = callback;
        this.activity = activity;
        this.internalLogger = internalLogger;
        this.timeProviderNs = timeProviderNs;
        this.windowCallbacksRegistry = windowCallbacksRegistry;
        this.handler = handler;
        View viewPeekDecorView = activity.getWindow().peekDecorView();
        if (viewPeekDecorView == null) {
            windowCallbacksRegistry.addListener(activity, this);
        } else {
            onDecorViewReady(viewPeekDecorView);
        }
    }

    @Override // com.datadog.android.rum.internal.startup.RumFirstDrawTimeReporter.Handle
    public void unsubscribe() {
        if (this.isCancelled) {
            return;
        }
        this.isCancelled = true;
        this.windowCallbacksRegistry.removeListener(this.activity, this);
        View viewPeekDecorView = this.activity.getWindow().peekDecorView();
        if (viewPeekDecorView != null) {
            viewPeekDecorView.removeOnAttachStateChangeListener(this);
            removeOnDrawListener(viewPeekDecorView);
        }
    }

    @Override // com.datadog.android.rum.internal.utils.window.RumWindowCallbackListener
    public void onContentChanged() {
        this.windowCallbacksRegistry.removeListener(this.activity, this);
        onDecorViewReady(getDecorView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportFirstFrame() {
        if (this.isCancelled) {
            return;
        }
        this.callback.onFirstFrameDrawn(this.timeProviderNs.invoke().longValue());
    }

    private final void onDecorViewReady(View decorView) {
        if (this.isCancelled) {
            return;
        }
        if (decorView.isAttachedToWindow()) {
            registerOnDrawListener(decorView);
        } else {
            decorView.addOnAttachStateChangeListener(this);
        }
    }

    private final void registerOnDrawListener(View decorView) {
        if (!this.isCancelled && decorView.getViewTreeObserver().isAlive()) {
            try {
                decorView.getViewTreeObserver().addOnDrawListener(this);
            } catch (IllegalStateException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.startup.RumFirstDrawTimeReporterHandleImpl.registerOnDrawListener.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "RumFirstDrawTimeReporterImpl unable to add onDrawListener onto viewTreeObserver";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    private final void onFirstDraw() {
        Runnable runnable = new Runnable() { // from class: com.datadog.android.rum.internal.startup.RumFirstDrawTimeReporterHandleImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.reportFirstFrame();
            }
        };
        Handler handler = this.handler;
        Message messageObtain = Message.obtain(handler, runnable);
        messageObtain.setAsynchronous(true);
        handler.sendMessageAtFrontOfQueue(messageObtain);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        View decorView = getDecorView();
        registerOnDrawListener(decorView);
        decorView.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        if (this.onDrawInvoked) {
            return;
        }
        this.onDrawInvoked = true;
        onFirstDraw();
        final View decorView = getDecorView();
        this.handler.post(new Runnable() { // from class: com.datadog.android.rum.internal.startup.RumFirstDrawTimeReporterHandleImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.removeOnDrawListener(decorView);
            }
        });
    }

    private final View getDecorView() {
        View decorView = this.activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        return decorView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeOnDrawListener(View decorView) {
        if (decorView.getViewTreeObserver().isAlive()) {
            try {
                decorView.getViewTreeObserver().removeOnDrawListener(this);
            } catch (IllegalStateException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.startup.RumFirstDrawTimeReporterHandleImpl.removeOnDrawListener.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "RumTTIDReporterImpl unable to remove onDrawListener from viewTreeObserver";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }
}
