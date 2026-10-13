package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.rnscreens.gamma.helpers.UIManagerHelperExtKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetContentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BG\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00126\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010%\u001a\u00020\u000eH\u0014J\b\u0010&\u001a\u00020\u000eH\u0014J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)H\u0016J(\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0014J\b\u00100\u001a\u00020$H\u0016J\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00105\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00107\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0017J\u0010\u0010<\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u001a\u0010>\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010)2\u0006\u0010@\u001a\u00020:H\u0016J\u0018\u0010A\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020:H\u0016J\u0010\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020$H\u0016J\u0010\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020FH\u0016R>\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/facebook/react/uimanager/RootView;", "Lcom/facebook/react/bridge/UIManagerListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "onSizeChangedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", ViewProps.WIDTH, ViewProps.HEIGHT, "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "contentSizeChangeDelegate", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentSizeChangeDelegate;", "getContentSizeChangeDelegate$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentSizeChangeDelegate;", "setContentSizeChangeDelegate$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentSizeChangeDelegate;)V", "themedReactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getThemedReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "jsTouchDispatcher", "Lcom/facebook/react/uimanager/JSTouchDispatcher;", "jsPointerDispatcher", "Lcom/facebook/react/uimanager/JSPointerDispatcher;", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "getEventDispatcher", "()Lcom/facebook/react/uimanager/events/EventDispatcher;", "isWaitingForFabricMount", "", "onAttachedToWindow", "onDetachedFromWindow", "onViewAdded", "child", "Landroid/view/View;", "onViewRemoved", "onSizeChanged", "w", "h", "oldw", "oldh", "onPreDraw", "didDispatchMountItems", "uiManager", "Lcom/facebook/react/bridge/UIManager;", "willDispatchViewUpdates", "willMountItems", "didMountItems", "didScheduleMountItems", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "onInterceptHoverEvent", "onHoverEvent", "onChildStartedNativeGesture", "childView", "ev", "onChildEndedNativeGesture", "requestDisallowInterceptTouchEvent", "disallowIntercept", "handleException", "t", "", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetContentView extends ReactViewGroup implements RootView, UIManagerListener, ViewTreeObserver.OnPreDrawListener {
    private FormSheetContentSizeChangeDelegate contentSizeChangeDelegate;
    private boolean isWaitingForFabricMount;
    private JSPointerDispatcher jsPointerDispatcher;
    private final JSTouchDispatcher jsTouchDispatcher;
    private final Function2<Integer, Integer, Unit> onSizeChangedCallback;

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willDispatchViewUpdates(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FormSheetContentView(Context context, Function2<? super Integer, ? super Integer, Unit> onSizeChangedCallback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onSizeChangedCallback, "onSizeChangedCallback");
        this.onSizeChangedCallback = onSizeChangedCallback;
        FormSheetContentView formSheetContentView = this;
        this.jsTouchDispatcher = new JSTouchDispatcher(formSheetContentView);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.jsPointerDispatcher = new JSPointerDispatcher(formSheetContentView);
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    @Deprecated(message = "Use onChildStartedNativeGesture with a childView parameter.", replaceWith = @ReplaceWith(expression = "onChildStartedNativeGesture", imports = {}))
    public /* bridge */ void onChildStartedNativeGesture(MotionEvent motionEvent) {
        super.onChildStartedNativeGesture(motionEvent);
    }

    /* JADX INFO: renamed from: getContentSizeChangeDelegate$react_native_screens_release, reason: from getter */
    public final FormSheetContentSizeChangeDelegate getContentSizeChangeDelegate() {
        return this.contentSizeChangeDelegate;
    }

    public final void setContentSizeChangeDelegate$react_native_screens_release(FormSheetContentSizeChangeDelegate formSheetContentSizeChangeDelegate) {
        this.contentSizeChangeDelegate = formSheetContentSizeChangeDelegate;
    }

    private final ThemedReactContext getThemedReactContext() {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        return (ThemedReactContext) context;
    }

    private final EventDispatcher getEventDispatcher() {
        return UIManagerHelper.getEventDispatcher(getThemedReactContext(), 2);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        UIManagerHelperExtKt.getFabricUIManagerNotNull(UIManagerHelper.INSTANCE, getThemedReactContext()).addUIManagerEventListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
        UIManagerHelperExtKt.getFabricUIManagerNotNull(UIManagerHelper.INSTANCE, getThemedReactContext()).removeUIManagerEventListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public void onViewAdded(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.onViewAdded(child);
        FormSheetContentSizeChangeProvider formSheetContentSizeChangeProvider = child instanceof FormSheetContentSizeChangeProvider ? (FormSheetContentSizeChangeProvider) child : null;
        if (formSheetContentSizeChangeProvider != null) {
            formSheetContentSizeChangeProvider.setContentSizeChangeDelegate(this.contentSizeChangeDelegate);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public void onViewRemoved(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.onViewRemoved(child);
        FormSheetContentSizeChangeProvider formSheetContentSizeChangeProvider = child instanceof FormSheetContentSizeChangeProvider ? (FormSheetContentSizeChangeProvider) child : null;
        if (formSheetContentSizeChangeProvider != null) {
            formSheetContentSizeChangeProvider.setContentSizeChangeDelegate(null);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w == oldw && h == oldh) {
            return;
        }
        this.isWaitingForFabricMount = true;
        this.onSizeChangedCallback.invoke(Integer.valueOf(w), Integer.valueOf(h));
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        return !this.isWaitingForFabricMount;
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didDispatchMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        this.isWaitingForFabricMount = false;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null) {
            this.jsTouchDispatcher.handleTouchEvent(event, eventDispatcher, getThemedReactContext());
            JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.handleMotionEvent(event, eventDispatcher, true);
            }
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null) {
            this.jsTouchDispatcher.handleTouchEvent(event, eventDispatcher, getThemedReactContext());
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
        JSPointerDispatcher jSPointerDispatcher;
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null && (jSPointerDispatcher = this.jsPointerDispatcher) != null) {
            jSPointerDispatcher.handleMotionEvent(event, eventDispatcher, true);
        }
        return super.onInterceptHoverEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        JSPointerDispatcher jSPointerDispatcher;
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null && (jSPointerDispatcher = this.jsPointerDispatcher) != null) {
            jSPointerDispatcher.handleMotionEvent(event, eventDispatcher, false);
        }
        return super.onHoverEvent(event);
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(View childView, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null) {
            this.jsTouchDispatcher.onChildStartedNativeGesture(ev, eventDispatcher, getThemedReactContext());
            JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.onChildStartedNativeGesture(childView, ev, eventDispatcher);
            }
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildEndedNativeGesture(View childView, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(ev, "ev");
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null) {
            this.jsTouchDispatcher.onChildEndedNativeGesture(ev, eventDispatcher);
        }
        JSPointerDispatcher jSPointerDispatcher = this.jsPointerDispatcher;
        if (jSPointerDispatcher != null) {
            jSPointerDispatcher.onChildEndedNativeGesture();
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void handleException(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        getThemedReactContext().getReactApplicationContext().handleException(new RuntimeException(t));
    }
}
