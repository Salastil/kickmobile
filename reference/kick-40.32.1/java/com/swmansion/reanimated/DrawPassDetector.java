package com.swmansion.reanimated;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DrawPassDetector.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/swmansion/reanimated/DrawPassDetector;", "", "mContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mHandler", "Landroid/os/Handler;", "mClearRunnable", "Ljava/lang/Runnable;", "mIsInDrawPass", "", "mDecorView", "Landroid/view/View;", "mOnDrawListener", "Landroid/view/ViewTreeObserver$OnDrawListener;", "initialize", "", "isInDrawPass", "invalidate", "invalidateOnUiThread", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DrawPassDetector {
    private final Runnable mClearRunnable;
    private final ReactApplicationContext mContext;
    private View mDecorView;
    private final Handler mHandler;
    private boolean mIsInDrawPass;
    private final ViewTreeObserver.OnDrawListener mOnDrawListener;

    public DrawPassDetector(ReactApplicationContext mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mClearRunnable = new Runnable() { // from class: com.swmansion.reanimated.DrawPassDetector$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.mIsInDrawPass = false;
            }
        };
        this.mOnDrawListener = new ViewTreeObserver.OnDrawListener() { // from class: com.swmansion.reanimated.DrawPassDetector$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnDrawListener
            public final void onDraw() {
                DrawPassDetector.mOnDrawListener$lambda$0(this.f$0);
            }
        };
    }

    static final void mOnDrawListener$lambda$0(DrawPassDetector drawPassDetector) {
        drawPassDetector.mIsInDrawPass = true;
        drawPassDetector.mHandler.postAtFrontOfQueue(drawPassDetector.mClearRunnable);
    }

    public final void initialize() {
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        View decorView = currentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        View view = this.mDecorView;
        if (decorView == view) {
            return;
        }
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnDrawListener(this.mOnDrawListener);
            }
            this.mDecorView = null;
        }
        ViewTreeObserver viewTreeObserver2 = decorView.getViewTreeObserver();
        if (viewTreeObserver2.isAlive()) {
            this.mDecorView = decorView;
            viewTreeObserver2.addOnDrawListener(this.mOnDrawListener);
        }
    }

    /* JADX INFO: renamed from: isInDrawPass, reason: from getter */
    public final boolean getMIsInDrawPass() {
        return this.mIsInDrawPass;
    }

    public final void invalidate() {
        if (UiThreadUtil.isOnUiThread()) {
            invalidateOnUiThread();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.swmansion.reanimated.DrawPassDetector$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.invalidateOnUiThread();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOnUiThread() {
        View view = this.mDecorView;
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnDrawListener(this.mOnDrawListener);
            }
            this.mDecorView = null;
        }
        this.mHandler.removeCallbacks(this.mClearRunnable);
        this.mIsInDrawPass = false;
    }
}
