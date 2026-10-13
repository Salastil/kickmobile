package com.swmansion.gesturehandler.react;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import com.swmansion.gesturehandler.core.OnJSResponderCancelListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNGestureHandlerRootHelper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/bridge/ReactContext;", "wrappedView", "Landroid/view/ViewGroup;", "moduleId", "", "<init>", "(Lcom/facebook/react/bridge/ReactContext;Landroid/view/ViewGroup;I)V", "orchestrator", "Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "getOrchestrator", "()Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "jsGestureHandler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "rootView", "getRootView", "()Landroid/view/ViewGroup;", "shouldIntercept", "", "wasIntercepting", "passingTouch", "tearDown", "", "requestDisallowInterceptTouchEvent", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "activateNativeHandlers", "view", "Landroid/view/View;", "recordHandlerIfNotPresent", "handler", "RootViewGestureHandler", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNGestureHandlerRootHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float MIN_ALPHA_FOR_TOUCH = 0.1f;
    private final ReactContext context;
    private final GestureHandler jsGestureHandler;
    private final int moduleId;
    private final GestureHandlerOrchestrator orchestrator;
    private boolean passingTouch;
    private final ViewGroup rootView;
    private boolean shouldIntercept;
    private boolean wasIntercepting;

    public RNGestureHandlerRootHelper(ReactContext context, ViewGroup wrappedView, int i) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wrappedView, "wrappedView");
        this.context = context;
        this.moduleId = i;
        RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(Integer.valueOf(i));
        if (rNGestureHandlerRegistry == null) {
            throw new Exception("Tried to access a non-existent registry");
        }
        UiThreadUtil.assertOnUiThread();
        int id = wrappedView.getId();
        NativeModule nativeModule = context.getNativeModule((Class<NativeModule>) RNGestureHandlerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        ViewGroup viewGroupFindRootViewTag = INSTANCE.findRootViewTag(wrappedView);
        this.rootView = viewGroupFindRootViewTag;
        Log.i(ReactConstants.TAG, "[GESTURE HANDLER] Initialize gesture handler for root view " + viewGroupFindRootViewTag);
        GestureHandlerOrchestrator gestureHandlerOrchestrator = new GestureHandlerOrchestrator(wrappedView, rNGestureHandlerRegistry, new RNViewConfigurationHelper(), viewGroupFindRootViewTag, new OnJSResponderCancelListener() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper$onJSResponderCancelListener$1
            @Override // com.swmansion.gesturehandler.core.OnJSResponderCancelListener
            public void onCancelJSResponderRequested(GestureHandler handler) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (this.this$0.getRootView() instanceof RootView) {
                    RootView rootView = (RootView) this.this$0.getRootView();
                    ViewGroup rootView2 = this.this$0.getRootView();
                    Intrinsics.checkNotNull(motionEventObtain);
                    rootView.onChildStartedNativeGesture(rootView2, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        });
        gestureHandlerOrchestrator.setMinimumAlphaForTraversal(0.1f);
        this.orchestrator = gestureHandlerOrchestrator;
        RootViewGestureHandler rootViewGestureHandler = new RootViewGestureHandler(-id);
        this.jsGestureHandler = rootViewGestureHandler;
        rNGestureHandlerRegistry.registerHandler(rootViewGestureHandler);
        RNGestureHandlerRegistry.attachHandlerToView$default(rNGestureHandlerRegistry, rootViewGestureHandler.getTag(), id, 0, null, 8, null);
        ((RNGestureHandlerModule) nativeModule).registerRootHelper(this);
    }

    public final GestureHandlerOrchestrator getOrchestrator() {
        return this.orchestrator;
    }

    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final void tearDown() throws Exception {
        RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(Integer.valueOf(this.moduleId));
        if (rNGestureHandlerRegistry == null) {
            throw new Exception("Tried to access a non-existent registry");
        }
        Log.i(ReactConstants.TAG, "[GESTURE HANDLER] Tearing down gesture handler registered for root view " + this.rootView);
        ReactContext reactContext = this.context;
        Intrinsics.checkNotNull(reactContext, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        NativeModule nativeModule = ((ThemedReactContext) reactContext).getReactApplicationContext().getNativeModule((Class<NativeModule>) RNGestureHandlerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        GestureHandler gestureHandler = this.jsGestureHandler;
        Intrinsics.checkNotNull(gestureHandler);
        rNGestureHandlerRegistry.dropHandler(gestureHandler.getTag());
        ((RNGestureHandlerModule) nativeModule).unregisterRootHelper(this);
    }

    /* JADX INFO: compiled from: RNGestureHandlerRootHelper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\nH\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper$RootViewGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handlerTag", "", "<init>", "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;I)V", "isContinuous", "", "()Z", "handleEvent", "", "event", "Landroid/view/MotionEvent;", "onHandle", "sourceEvent", "onHandleHover", "onCancel", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class RootViewGestureHandler extends GestureHandler {
        private final boolean isContinuous = true;

        public RootViewGestureHandler(int i) {
            setTag(i);
            setCancelsJSResponder(false);
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler
        /* JADX INFO: renamed from: isContinuous, reason: from getter */
        public boolean getIsContinuous() {
            return this.isContinuous;
        }

        private final void handleEvent(MotionEvent event) {
            GestureHandlerOrchestrator orchestrator;
            if (getState() == 0 && (!RNGestureHandlerRootHelper.this.shouldIntercept || (orchestrator = getOrchestrator()) == null || !orchestrator.isAnyHandlerActive())) {
                begin();
                RNGestureHandlerRootHelper.this.shouldIntercept = false;
            }
            if (event.getActionMasked() == 1 || event.getActionMasked() == 10) {
                end();
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler
        protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
            handleEvent(event);
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler
        protected void onHandleHover(MotionEvent event, MotionEvent sourceEvent) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
            handleEvent(event);
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler
        protected void onCancel() {
            RNGestureHandlerRootHelper.this.shouldIntercept = true;
        }
    }

    public final void requestDisallowInterceptTouchEvent() {
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        if (gestureHandlerOrchestrator == null || this.passingTouch) {
            return;
        }
        gestureHandlerOrchestrator.cancelAllLegacyHandlers();
    }

    public final boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.passingTouch = true;
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        Intrinsics.checkNotNull(gestureHandlerOrchestrator);
        gestureHandlerOrchestrator.onTouchEvent(event);
        this.passingTouch = false;
        if (this.shouldIntercept && !this.wasIntercepting) {
            GestureHandlerOrchestrator gestureHandlerOrchestrator2 = this.orchestrator;
            Intrinsics.checkNotNull(gestureHandlerOrchestrator2);
            gestureHandlerOrchestrator2.cancelTouchesInInterceptedViews(event);
        }
        boolean z = this.shouldIntercept;
        this.wasIntercepting = z;
        return z;
    }

    public final void activateNativeHandlers(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        if (gestureHandlerOrchestrator != null) {
            gestureHandlerOrchestrator.activateNativeHandlersForView(view);
        }
    }

    public final void recordHandlerIfNotPresent(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        if (gestureHandlerOrchestrator != null) {
            gestureHandlerOrchestrator.recordHandlerIfNotPresent(handler, null);
        }
    }

    /* JADX INFO: compiled from: RNGestureHandlerRootHelper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper$Companion;", "", "<init>", "()V", "MIN_ALPHA_FOR_TOUCH", "", "findRootViewTag", "Landroid/view/ViewGroup;", "viewGroup", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewGroup findRootViewTag(ViewGroup viewGroup) {
            UiThreadUtil.assertOnUiThread();
            ViewGroup parent = viewGroup;
            while (parent != null && !(parent instanceof RootView)) {
                parent = parent.getParent();
            }
            if (parent == null) {
                throw new IllegalStateException(("View " + viewGroup + " has not been mounted under ReactRootView").toString());
            }
            return (ViewGroup) parent;
        }
    }
}
