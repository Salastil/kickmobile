package expo.modules.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNHostView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0014J0\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(H\u0014J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0016J\u001d\u00103\u001a\u00020&2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&05H\u0082\bJ\u0010\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u000202H\u0016J\u0010\u00108\u001a\u00020\u00122\u0006\u00107\u001a\u000202H\u0017J\u0010\u00109\u001a\u00020\u00122\u0006\u00107\u001a\u000202H\u0016J\u0010\u0010:\u001a\u00020\u00122\u0006\u00107\u001a\u000202H\u0016J\u001a\u0010;\u001a\u00020&2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010>\u001a\u00020&2\u0006\u0010<\u001a\u00020=2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020\u0012H\u0016J \u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020(H\u0016J \u0010H\u001a\u00020&2\u0006\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020(H\u0016J(\u0010I\u001a\u00020&2\u0006\u0010F\u001a\u00020=2\u0006\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020\u000fH\u0016J0\u0010M\u001a\u00020&2\u0006\u0010F\u001a\u00020=2\u0006\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020(H\u0016J \u0010R\u001a\u00020\u00122\u0006\u0010F\u001a\u00020=2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020TH\u0016J(\u0010V\u001a\u00020\u00122\u0006\u0010F\u001a\u00020=2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\u0006\u0010L\u001a\u00020\u0012H\u0016J\u0010\u0010W\u001a\u00020&2\u0006\u0010F\u001a\u00020=H\u0016J\b\u0010X\u001a\u00020&H\u0002J\u0010\u0010Y\u001a\u00020&2\u0006\u0010Z\u001a\u00020\u0012H\u0016J\b\u0010[\u001a\u00020\u0012H\u0016J\u0010\u0010\\\u001a\u00020\u00122\u0006\u0010G\u001a\u00020(H\u0016J\u0018\u0010\\\u001a\u00020\u00122\u0006\u0010G\u001a\u00020(2\u0006\u0010]\u001a\u00020(H\u0016J\b\u0010^\u001a\u00020&H\u0016J\u0010\u0010^\u001a\u00020&2\u0006\u0010]\u001a\u00020(H\u0016J\b\u0010_\u001a\u00020\u0012H\u0016J\u0010\u0010_\u001a\u00020\u00122\u0006\u0010]\u001a\u00020(H\u0016J2\u0010`\u001a\u00020\u00122\u0006\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020(2\b\u0010a\u001a\u0004\u0018\u00010\u000fH\u0016J:\u0010`\u001a\u00020\u00122\u0006\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020(2\b\u0010a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020(H\u0016JB\u0010`\u001a\u00020&2\u0006\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020(2\b\u0010a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020(2\u0006\u0010L\u001a\u00020\u000fH\u0016J,\u0010b\u001a\u00020\u00122\u0006\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020(2\b\u0010L\u001a\u0004\u0018\u00010\u000f2\b\u0010a\u001a\u0004\u0018\u00010\u000fH\u0016J4\u0010b\u001a\u00020\u00122\u0006\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020(2\b\u0010L\u001a\u0004\u0018\u00010\u000f2\b\u0010a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020(H\u0016J \u0010c\u001a\u00020\u00122\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\u0006\u0010L\u001a\u00020\u0012H\u0016J\u0018\u0010d\u001a\u00020\u00122\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020TH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006e"}, d2 = {"Lexpo/modules/ui/TouchDispatchingRootViewGroup;", "Landroid/widget/FrameLayout;", "Lcom/facebook/react/uimanager/RootView;", "Landroidx/core/view/NestedScrollingChild3;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "jsTouchDispatcher", "Lcom/facebook/react/uimanager/JSTouchDispatcher;", "jsPointerDispatcher", "Lcom/facebook/react/uimanager/JSPointerDispatcher;", "childHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "gestureStartLocation", "", "currentLocation", "trackingGestureOffset", "", "sheetMovingOnLastDragFrame", "forwardedDisallowIntercept", "flingHandledThisGesture", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "getEventDispatcher", "()Lcom/facebook/react/uimanager/events/EventDispatcher;", "setEventDispatcher", "(Lcom/facebook/react/uimanager/events/EventDispatcher;)V", "dispatchesTouchesToJS", "getDispatchesTouchesToJS", "()Z", "setDispatchesTouchesToJS", "(Z)V", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "notifyAncestorRootViews", "block", "Lkotlin/Function1;", "onInterceptTouchEvent", "event", "onTouchEvent", "onInterceptHoverEvent", "onHoverEvent", "onChildStartedNativeGesture", "childView", "Landroid/view/View;", "onChildEndedNativeGesture", "handleException", "t", "", "requestDisallowInterceptTouchEvent", "disallowIntercept", "onStartNestedScroll", "child", TypedValues.Attributes.S_TARGET, "axes", "onNestedScrollAccepted", "onNestedPreScroll", "dx", "dy", "consumed", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedPreFling", "velocityX", "", "velocityY", "onNestedFling", "onStopNestedScroll", "settleSheetIfNoFling", "setNestedScrollingEnabled", "enabled", "isNestedScrollingEnabled", "startNestedScroll", "type", "stopNestedScroll", "hasNestedScrollingParent", "dispatchNestedScroll", "offsetInWindow", "dispatchNestedPreScroll", "dispatchNestedFling", "dispatchNestedPreFling", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class TouchDispatchingRootViewGroup extends FrameLayout implements RootView, NestedScrollingChild3 {
    private final NestedScrollingChildHelper childHelper;
    private final int[] currentLocation;
    private boolean dispatchesTouchesToJS;
    private EventDispatcher eventDispatcher;
    private boolean flingHandledThisGesture;
    private boolean forwardedDisallowIntercept;
    private final int[] gestureStartLocation;
    private JSPointerDispatcher jsPointerDispatcher;
    private final JSTouchDispatcher jsTouchDispatcher;
    private boolean sheetMovingOnLastDragFrame;
    private boolean trackingGestureOffset;

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View child, View target, int axes) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        return (axes & 2) != 0;
    }

    @Override // com.facebook.react.uimanager.RootView
    @Deprecated(message = "Use onChildStartedNativeGesture with a childView parameter.", replaceWith = @ReplaceWith(expression = "onChildStartedNativeGesture", imports = {}))
    public void onChildStartedNativeGesture(MotionEvent motionEvent) {
        super.onChildStartedNativeGesture(motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchDispatchingRootViewGroup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        TouchDispatchingRootViewGroup touchDispatchingRootViewGroup = this;
        this.jsTouchDispatcher = new JSTouchDispatcher(touchDispatchingRootViewGroup);
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        this.childHelper = nestedScrollingChildHelper;
        this.gestureStartLocation = new int[2];
        this.currentLocation = new int[2];
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.jsPointerDispatcher = new JSPointerDispatcher(touchDispatchingRootViewGroup);
        }
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
    }

    public final EventDispatcher getEventDispatcher() {
        return this.eventDispatcher;
    }

    public final void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public final boolean getDispatchesTouchesToJS() {
        return this.dispatchesTouchesToJS;
    }

    public final void setDispatchesTouchesToJS(boolean z) {
        this.dispatchesTouchesToJS = z;
    }

    private final ThemedReactContext getReactContext() {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        return (ThemedReactContext) context;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean zDispatchTouchEvent;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getActionMasked() == 3 && !this.dispatchesTouchesToJS) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                RootView rootView = parent instanceof RootView ? (RootView) parent : null;
                if (rootView != null) {
                    rootView.onChildStartedNativeGesture(null, ev);
                }
            }
        }
        if (ev.getActionMasked() == 0) {
            if (this.dispatchesTouchesToJS) {
                for (ViewParent parent2 = getParent(); parent2 != null; parent2 = parent2.getParent()) {
                    RootView rootView2 = parent2 instanceof RootView ? (RootView) parent2 : null;
                    if (rootView2 != null) {
                        rootView2.onChildStartedNativeGesture(this, ev);
                    }
                }
            }
            getLocationInWindow(this.gestureStartLocation);
            this.trackingGestureOffset = true;
            this.sheetMovingOnLastDragFrame = false;
            this.flingHandledThisGesture = false;
            this.forwardedDisallowIntercept = false;
        }
        if (this.trackingGestureOffset && hasNestedScrollingParent()) {
            getLocationInWindow(this.currentLocation);
            int i = this.currentLocation[1] - this.gestureStartLocation[1];
            if (i != 0) {
                float f = i;
                ev.offsetLocation(0.0f, f);
                zDispatchTouchEvent = super.dispatchTouchEvent(ev);
                ev.offsetLocation(0.0f, -f);
            } else {
                zDispatchTouchEvent = super.dispatchTouchEvent(ev);
            }
        } else {
            zDispatchTouchEvent = super.dispatchTouchEvent(ev);
        }
        if (ev.getActionMasked() == 1 || ev.getActionMasked() == 3) {
            this.trackingGestureOffset = false;
            if (this.dispatchesTouchesToJS) {
                for (ViewParent parent3 = getParent(); parent3 != null; parent3 = parent3.getParent()) {
                    RootView rootView3 = parent3 instanceof RootView ? (RootView) parent3 : null;
                    if (rootView3 != null) {
                        rootView3.onChildEndedNativeGesture(this, ev);
                    }
                }
            }
        }
        return zDispatchTouchEvent;
    }

    private final void notifyAncestorRootViews(Function1<? super RootView, Unit> block) {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            RootView rootView = parent instanceof RootView ? (RootView) parent : null;
            if (rootView != null) {
                block.invoke(rootView);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        EventDispatcher eventDispatcher;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.dispatchesTouchesToJS && (eventDispatcher = this.eventDispatcher) != null) {
            this.jsTouchDispatcher.handleTouchEvent(event, eventDispatcher, getReactContext());
            JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.handleMotionEvent(event, eventDispatcher, true);
            }
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        EventDispatcher eventDispatcher;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.dispatchesTouchesToJS && (eventDispatcher = this.eventDispatcher) != null) {
            this.jsTouchDispatcher.handleTouchEvent(event, eventDispatcher, getReactContext());
            JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.handleMotionEvent(event, eventDispatcher, false);
            }
        }
        super.onTouchEvent(event);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent event) {
        EventDispatcher eventDispatcher;
        JSPointerDispatcher jSPointerDispatcher;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.dispatchesTouchesToJS && (eventDispatcher = this.eventDispatcher) != null && (jSPointerDispatcher = this.jsPointerDispatcher) != null) {
            jSPointerDispatcher.handleMotionEvent(event, eventDispatcher, true);
        }
        return super.onInterceptHoverEvent(event);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        EventDispatcher eventDispatcher;
        JSPointerDispatcher jSPointerDispatcher;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.dispatchesTouchesToJS && (eventDispatcher = this.eventDispatcher) != null && (jSPointerDispatcher = this.jsPointerDispatcher) != null) {
            jSPointerDispatcher.handleMotionEvent(event, eventDispatcher, false);
        }
        return super.onHoverEvent(event);
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(View childView, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.dispatchesTouchesToJS) {
            EventDispatcher eventDispatcher = this.eventDispatcher;
            if (eventDispatcher != null) {
                this.jsTouchDispatcher.onChildStartedNativeGesture(ev, eventDispatcher, getReactContext());
                JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
                if (jSPointerDispatcher != null) {
                    jSPointerDispatcher.onChildStartedNativeGesture(childView, ev, eventDispatcher);
                    return;
                }
                return;
            }
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            RootView rootView = parent instanceof RootView ? (RootView) parent : null;
            if (rootView != null) {
                rootView.onChildStartedNativeGesture(childView, ev);
            }
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildEndedNativeGesture(View childView, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.dispatchesTouchesToJS) {
            EventDispatcher eventDispatcher = this.eventDispatcher;
            if (eventDispatcher != null) {
                this.jsTouchDispatcher.onChildEndedNativeGesture(ev, eventDispatcher);
            }
            JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.onChildEndedNativeGesture();
                return;
            }
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            RootView rootView = parent instanceof RootView ? (RootView) parent : null;
            if (rootView != null) {
                rootView.onChildEndedNativeGesture(childView, ev);
            }
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void handleException(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        getReactContext().getReactApplicationContext().handleException(new RuntimeException(t));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept || !this.forwardedDisallowIntercept) {
            this.forwardedDisallowIntercept = disallowIntercept;
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(disallowIntercept);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View child, View target, int axes) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onNestedScrollAccepted(child, target, axes);
        startNestedScroll(axes);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        dispatchNestedPreScroll(dx, dy, consumed, null);
        this.sheetMovingOnLastDragFrame = consumed[1] != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        int[] iArr = new int[2];
        dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, null, 0, iArr);
        if (iArr[1] != 0) {
            this.sheetMovingOnLastDragFrame = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.flingHandledThisGesture = true;
        return dispatchNestedPreFling(velocityX, velocityY) || (this.sheetMovingOnLastDragFrame && velocityY > 0.0f);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        return dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        settleSheetIfNoFling();
        super.onStopNestedScroll(target);
        stopNestedScroll();
    }

    private final void settleSheetIfNoFling() {
        if (!this.sheetMovingOnLastDragFrame || this.flingHandledThisGesture) {
            return;
        }
        this.flingHandledThisGesture = true;
        dispatchNestedFling(0.0f, 0.0f, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean enabled) {
        this.childHelper.setNestedScrollingEnabled(enabled);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.childHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int axes) {
        return this.childHelper.startNestedScroll(axes);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int axes, int type) {
        return this.childHelper.startNestedScroll(axes, type);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.childHelper.stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int type) {
        this.childHelper.stopNestedScroll(type);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.childHelper.hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int type) {
        return this.childHelper.hasNestedScrollingParent(type);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.childHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        return this.childHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        this.childHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return this.childHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return this.childHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.childHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.childHelper.dispatchNestedPreFling(velocityX, velocityY);
    }
}
