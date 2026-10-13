package com.facebook.react.runtime;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.logging.FLog;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSKeyDispatcher;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.WindowUtilKt;
import com.facebook.systrace.Systrace;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactSurfaceView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0001AB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013H\u0014J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0011H\u0016J\u001a\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020'H\u0014J\u0018\u00100\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020'2\u0006\u00101\u001a\u00020\u0011H\u0014J\u0010\u00102\u001a\u00020\u001a2\u0006\u0010/\u001a\u000203H\u0014J\u001c\u00104\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u00010%2\b\u00106\u001a\u0004\u0018\u00010%H\u0016J\"\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00132\b\u0010:\u001a\u0004\u0018\u00010;H\u0014J\b\u0010<\u001a\u00020\u0011H\u0016J\b\u0010=\u001a\u00020\u0011H\u0016J\n\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006B"}, d2 = {"Lcom/facebook/react/runtime/ReactSurfaceView;", "Lcom/facebook/react/ReactRootView;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "surface", "Lcom/facebook/react/runtime/ReactSurfaceImpl;", "<init>", "(Landroid/content/Context;Lcom/facebook/react/runtime/ReactSurfaceImpl;)V", "getSurface$ReactAndroid", "()Lcom/facebook/react/runtime/ReactSurfaceImpl;", "jsTouchDispatcher", "Lcom/facebook/react/uimanager/JSTouchDispatcher;", "jsPointerDispatcher", "Lcom/facebook/react/uimanager/JSPointerDispatcher;", "jsKeyDispatcher", "Lcom/facebook/react/uimanager/JSKeyDispatcher;", "wasMeasured", "", "widthMeasureSpec", "", "heightMeasureSpec", "viewportOffset", "Landroid/graphics/Point;", "getViewportOffset", "()Landroid/graphics/Point;", "onMeasure", "", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "requestDisallowInterceptTouchEvent", "disallowIntercept", "onChildStartedNativeGesture", "childView", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "onChildEndedNativeGesture", "handleException", "t", "", "getJSModuleName", "", "dispatchJSTouchEvent", "event", "dispatchJSPointerEvent", "isCapture", "dispatchJSKeyEvent", "Landroid/view/KeyEvent;", "requestChildFocus", "child", "focused", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "hasActiveReactContext", "hasActiveReactInstance", "getCurrentReactContext", "Lcom/facebook/react/bridge/ReactContext;", "isViewAttachedToReactInstance", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReactSurfaceView extends ReactRootView {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "ReactSurfaceView";
    private int heightMeasureSpec;
    private JSKeyDispatcher jsKeyDispatcher;
    private JSPointerDispatcher jsPointerDispatcher;
    private final JSTouchDispatcher jsTouchDispatcher;
    private final ReactSurfaceImpl surface;
    private boolean wasMeasured;
    private int widthMeasureSpec;

    /* JADX INFO: renamed from: getSurface$ReactAndroid, reason: from getter */
    public final ReactSurfaceImpl getSurface() {
        return this.surface;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactSurfaceView(Context context, ReactSurfaceImpl surface) {
        super(context);
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.surface = surface;
        ReactSurfaceView reactSurfaceView = this;
        this.jsTouchDispatcher = new JSTouchDispatcher(reactSurfaceView);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.jsPointerDispatcher = new JSPointerDispatcher(reactSurfaceView);
        }
        if (ReactNativeFeatureFlags.enableKeyEvents()) {
            this.jsKeyDispatcher = new JSKeyDispatcher();
        }
    }

    private final Point getViewportOffset() {
        WindowInsetsCompat rootWindowInsets;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        if (!WindowUtilKt.isEdgeToEdgeFeatureFlagOn() && (rootWindowInsets = ViewCompat.getRootWindowInsets(this)) != null) {
            Insets insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout());
            Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
            iArr[0] = iArr[0] - insets.left;
            iArr[1] = iArr[1] - insets.top;
        }
        return new Point(iArr[0], iArr[1]);
    }

    @Override // com.facebook.react.ReactRootView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size;
        int size2;
        Systrace.beginSection(0L, "ReactSurfaceView.onMeasure");
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                iMax = Math.max(iMax, childAt.getLeft() + childAt.getMeasuredWidth() + childAt.getPaddingLeft() + childAt.getPaddingRight());
            }
            size = iMax;
        } else {
            size = View.MeasureSpec.getSize(widthMeasureSpec);
        }
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int childCount2 = getChildCount();
            int iMax2 = 0;
            for (int i2 = 0; i2 < childCount2; i2++) {
                View childAt2 = getChildAt(i2);
                iMax2 = Math.max(iMax2, childAt2.getTop() + childAt2.getMeasuredHeight() + childAt2.getPaddingTop() + childAt2.getPaddingBottom());
            }
            size2 = iMax2;
        } else {
            size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        }
        setMeasuredDimension(size, size2);
        this.wasMeasured = true;
        this.widthMeasureSpec = widthMeasureSpec;
        this.heightMeasureSpec = heightMeasureSpec;
        Point viewportOffset = getViewportOffset();
        this.surface.updateLayoutSpecs$ReactAndroid(widthMeasureSpec, heightMeasureSpec, viewportOffset.x, viewportOffset.y);
        Systrace.endSection(0L);
    }

    @Override // com.facebook.react.ReactRootView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.wasMeasured && changed) {
            Point viewportOffset = getViewportOffset();
            this.surface.updateLayoutSpecs$ReactAndroid(this.widthMeasureSpec, this.heightMeasureSpec, viewportOffset.x, viewportOffset.y);
        }
    }

    @Override // com.facebook.react.ReactRootView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    @Override // com.facebook.react.ReactRootView, com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(View childView, MotionEvent ev) {
        JSPointerDispatcher jSPointerDispatcher;
        Intrinsics.checkNotNullParameter(ev, "ev");
        EventDispatcher eventDispatcher$ReactAndroid = this.surface.getEventDispatcher$ReactAndroid();
        if (eventDispatcher$ReactAndroid == null) {
            return;
        }
        JSTouchDispatcher jSTouchDispatcher = this.jsTouchDispatcher;
        ReactHostImpl reactHost$ReactAndroid = this.surface.getReactHost$ReactAndroid();
        jSTouchDispatcher.onChildStartedNativeGesture(ev, eventDispatcher$ReactAndroid, reactHost$ReactAndroid != null ? reactHost$ReactAndroid.getCurrentReactContext() : null);
        if (childView == null || (jSPointerDispatcher = this.jsPointerDispatcher) == null) {
            return;
        }
        jSPointerDispatcher.onChildStartedNativeGesture(childView, ev, eventDispatcher$ReactAndroid);
    }

    @Override // com.facebook.react.ReactRootView, com.facebook.react.uimanager.RootView
    public void onChildEndedNativeGesture(View childView, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(ev, "ev");
        EventDispatcher eventDispatcher$ReactAndroid = this.surface.getEventDispatcher$ReactAndroid();
        if (eventDispatcher$ReactAndroid == null) {
            return;
        }
        this.jsTouchDispatcher.onChildEndedNativeGesture(ev, eventDispatcher$ReactAndroid);
        JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
        if (jSPointerDispatcher != null) {
            jSPointerDispatcher.onChildEndedNativeGesture();
        }
    }

    @Override // com.facebook.react.ReactRootView, com.facebook.react.uimanager.RootView
    public void handleException(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        String string = Objects.toString(t.getMessage(), "");
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        IllegalViewOperationException illegalViewOperationException = new IllegalViewOperationException(string, this, t);
        ReactHostImpl reactHost$ReactAndroid = this.surface.getReactHost$ReactAndroid();
        if (reactHost$ReactAndroid == null) {
            throw illegalViewOperationException;
        }
        reactHost$ReactAndroid.handleHostException$ReactAndroid(illegalViewOperationException);
    }

    @Override // com.facebook.react.ReactRootView, com.facebook.react.uimanager.ReactRoot
    public String getJSModuleName() {
        return this.surface.getModuleName();
    }

    @Override // com.facebook.react.ReactRootView
    protected void dispatchJSTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher$ReactAndroid = this.surface.getEventDispatcher$ReactAndroid();
        if (eventDispatcher$ReactAndroid != null) {
            JSTouchDispatcher jSTouchDispatcher = this.jsTouchDispatcher;
            ReactHostImpl reactHost$ReactAndroid = this.surface.getReactHost$ReactAndroid();
            jSTouchDispatcher.handleTouchEvent(event, eventDispatcher$ReactAndroid, reactHost$ReactAndroid != null ? reactHost$ReactAndroid.getCurrentReactContext() : null);
            return;
        }
        FLog.w(TAG, "Unable to dispatch touch events to JS as the React instance has not been attached");
    }

    @Override // com.facebook.react.ReactRootView
    protected void dispatchJSPointerEvent(MotionEvent event, boolean isCapture) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.jsPointerDispatcher == null) {
            if (ReactFeatureFlags.dispatchPointerEvents) {
                FLog.w(TAG, "Unable to dispatch pointer events to JS before the dispatcher is available");
                return;
            }
            return;
        }
        EventDispatcher eventDispatcher$ReactAndroid = this.surface.getEventDispatcher$ReactAndroid();
        if (eventDispatcher$ReactAndroid != null) {
            JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.handleMotionEvent(event, eventDispatcher$ReactAndroid, isCapture);
                return;
            }
            return;
        }
        FLog.w(TAG, "Unable to dispatch pointer events to JS as the React instance has not been attached");
    }

    @Override // com.facebook.react.ReactRootView
    protected void dispatchJSKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.jsKeyDispatcher == null) {
            if (ReactNativeFeatureFlags.enableKeyEvents()) {
                FLog.w(TAG, "Unable to dispatch key events to JS before the dispatcher is available");
                return;
            }
            return;
        }
        EventDispatcher eventDispatcher$ReactAndroid = this.surface.getEventDispatcher$ReactAndroid();
        if (eventDispatcher$ReactAndroid != null) {
            JSKeyDispatcher jSKeyDispatcher = this.jsKeyDispatcher;
            if (jSKeyDispatcher != null) {
                jSKeyDispatcher.handleKeyEvent(event, eventDispatcher$ReactAndroid, this.surface.getSurfaceID());
                return;
            }
            return;
        }
        FLog.w(TAG, "Unable to dispatch key events to JS as the React instance has not been attached");
    }

    @Override // com.facebook.react.ReactRootView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        JSKeyDispatcher jSKeyDispatcher;
        super.requestChildFocus(child, focused);
        if (ReactNativeFeatureFlags.enableKeyEvents()) {
            Integer numValueOf = focused != null ? Integer.valueOf(focused.getId()) : null;
            if (numValueOf == null || (jSKeyDispatcher = this.jsKeyDispatcher) == null) {
                return;
            }
            jSKeyDispatcher.setFocusedView(numValueOf.intValue());
        }
    }

    @Override // com.facebook.react.ReactRootView, android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        JSKeyDispatcher jSKeyDispatcher;
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (ReactNativeFeatureFlags.enableKeyEvents()) {
            if (gainFocus) {
                View focusedChild = getFocusedChild();
                Integer numValueOf = focusedChild != null ? Integer.valueOf(focusedChild.getId()) : null;
                if (numValueOf == null || (jSKeyDispatcher = this.jsKeyDispatcher) == null) {
                    return;
                }
                jSKeyDispatcher.setFocusedView(numValueOf.intValue());
                return;
            }
            JSKeyDispatcher jSKeyDispatcher2 = this.jsKeyDispatcher;
            if (jSKeyDispatcher2 != null) {
                jSKeyDispatcher2.clearFocus();
            }
        }
    }

    @Override // com.facebook.react.ReactRootView
    public boolean hasActiveReactContext() {
        if (!this.surface.isAttached$ReactAndroid()) {
            return false;
        }
        ReactHostImpl reactHost$ReactAndroid = this.surface.getReactHost$ReactAndroid();
        return (reactHost$ReactAndroid != null ? reactHost$ReactAndroid.getCurrentReactContext() : null) != null;
    }

    @Override // com.facebook.react.ReactRootView
    public boolean hasActiveReactInstance() {
        ReactHostImpl reactHost$ReactAndroid;
        return this.surface.isAttached$ReactAndroid() && (reactHost$ReactAndroid = this.surface.getReactHost$ReactAndroid()) != null && reactHost$ReactAndroid.isInstanceInitialized$ReactAndroid();
    }

    @Override // com.facebook.react.ReactRootView
    public ReactContext getCurrentReactContext() {
        ReactHostImpl reactHost$ReactAndroid;
        if (!this.surface.isAttached$ReactAndroid() || (reactHost$ReactAndroid = this.surface.getReactHost$ReactAndroid()) == null) {
            return null;
        }
        return reactHost$ReactAndroid.getCurrentReactContext();
    }

    @Override // com.facebook.react.ReactRootView
    public boolean isViewAttachedToReactInstance() {
        return this.surface.isAttached$ReactAndroid();
    }

    /* JADX INFO: compiled from: ReactSurfaceView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/runtime/ReactSurfaceView$Companion;", "", "<init>", "()V", "TAG", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
