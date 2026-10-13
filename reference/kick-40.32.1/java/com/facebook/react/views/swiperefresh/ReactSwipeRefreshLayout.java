package com.facebook.react.views.swiperefresh;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.HasChildPressedStateDelay;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactSwipeRefreshLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000bJ0\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006+"}, d2 = {"Lcom/facebook/react/views/swiperefresh/ReactSwipeRefreshLayout;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "Lcom/facebook/react/uimanager/HasChildPressedStateDelay;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "<init>", "(Lcom/facebook/react/bridge/ReactContext;)V", "didLayout", "", "refreshing", "progressViewOffset", "", "touchSlop", "", "prevTouchX", "intercepted", "nativeGestureStarted", "hasChildPressedStateDelay", "getHasChildPressedStateDelay", "()Ljava/lang/Boolean;", "setHasChildPressedStateDelay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setRefreshing", "", "setProgressViewOffset", "offset", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "canChildScrollUp", "requestDisallowInterceptTouchEvent", "disallowIntercept", "shouldDelayChildPressedState", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "shouldInterceptTouchEvent", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ReactSwipeRefreshLayout extends SwipeRefreshLayout implements HasChildPressedStateDelay {
    private static final Companion Companion = new Companion(null);
    private static final float DEFAULT_CIRCLE_TARGET = 64.0f;
    private boolean didLayout;
    private Boolean hasChildPressedStateDelay;
    private boolean intercepted;
    private boolean nativeGestureStarted;
    private float prevTouchX;
    private float progressViewOffset;
    private boolean refreshing;
    private final int touchSlop;

    /* JADX WARN: Illegal instructions before constructor call */
    public ReactSwipeRefreshLayout(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ReactContext reactContext2 = reactContext;
        super(reactContext2);
        this.touchSlop = ViewConfiguration.get(reactContext2).getScaledTouchSlop();
    }

    @Override // com.facebook.react.uimanager.HasChildPressedStateDelay
    public Boolean getHasChildPressedStateDelay() {
        return this.hasChildPressedStateDelay;
    }

    @Override // com.facebook.react.uimanager.HasChildPressedStateDelay
    public void setHasChildPressedStateDelay(Boolean bool) {
        this.hasChildPressedStateDelay = bool;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public void setRefreshing(boolean refreshing) {
        this.refreshing = refreshing;
        if (this.didLayout) {
            super.setRefreshing(refreshing);
        }
    }

    public final void setProgressViewOffset(float offset) {
        this.progressViewOffset = offset;
        if (this.didLayout) {
            int progressCircleDiameter = getProgressCircleDiameter();
            setProgressViewOffset(false, Math.round(PixelUtil.toPixelFromDIP(offset)) - progressCircleDiameter, Math.round(PixelUtil.toPixelFromDIP(offset + DEFAULT_CIRCLE_TARGET)) - progressCircleDiameter);
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.didLayout) {
            return;
        }
        this.didLayout = true;
        setProgressViewOffset(this.progressViewOffset);
        setRefreshing(this.refreshing);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        View childAt = getChildAt(0);
        return childAt != null ? childAt.canScrollVertically(-1) : super.canChildScrollUp();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        Boolean hasChildPressedStateDelay = getHasChildPressedStateDelay();
        return hasChildPressedStateDelay != null ? hasChildPressedStateDelay.booleanValue() : super.shouldDelayChildPressedState();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!shouldInterceptTouchEvent(ev) || !super.onInterceptTouchEvent(ev)) {
            return false;
        }
        NativeGestureUtil.notifyNativeGestureStarted(this, ev);
        this.nativeGestureStarted = true;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getActionMasked() == 1 && this.nativeGestureStarted) {
            NativeGestureUtil.notifyNativeGestureEnded(this, ev);
            this.nativeGestureStarted = false;
        }
        return super.onTouchEvent(ev);
    }

    private final boolean shouldInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == 0) {
            this.prevTouchX = ev.getX();
            this.intercepted = false;
        } else if (action == 2) {
            float fAbs = Math.abs(ev.getX() - this.prevTouchX);
            if (this.intercepted || fAbs > this.touchSlop) {
                this.intercepted = true;
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: ReactSwipeRefreshLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/views/swiperefresh/ReactSwipeRefreshLayout$Companion;", "", "<init>", "()V", "DEFAULT_CIRCLE_TARGET", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
