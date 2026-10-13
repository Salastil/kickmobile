package com.swmansion.reanimated;

import android.os.SystemClock;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.swmansion.reanimated.nativeProxy.NoopEventHandler;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NodesManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001JB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010(\u001a\u0004\u0018\u00010'J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020\tJ\u0006\u0010-\u001a\u00020*J\u0006\u0010.\u001a\u00020*J\b\u0010/\u001a\u00020*H\u0002J\u0006\u00100\u001a\u00020*J\r\u00101\u001a\u00020*H\u0000¢\u0006\u0002\b2J\r\u00103\u001a\u00020*H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020\tH\u0000¢\u0006\u0002\b6J\u0010\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u0007H\u0002J\u000e\u00109\u001a\u00020*2\u0006\u00107\u001a\u00020\u001cJ\u0014\u0010:\u001a\u00020*2\n\u0010;\u001a\u0006\u0012\u0002\b\u00030<H\u0016J\u0014\u0010=\u001a\u00020*2\n\u0010;\u001a\u0006\u0012\u0002\b\u00030<H\u0002J\u0010\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u001fH\u0002J\u0006\u0010?\u001a\u00020\u0013J\u000e\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020\u0019J\u0016\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ\u0016\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/swmansion/reanimated/NodesManager;", "Lcom/facebook/react/uimanager/events/EventDispatcherListener;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mFirstUptime", "", "mSlowAnimationsEnabled", "", "mAnimationsDragFactor", "", "mEventEmitter", "Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "mReactChoreographer", "Lcom/facebook/react/modules/core/ReactChoreographer;", "mChoreographerCallback", "Lcom/facebook/react/uimanager/GuardedFrameCallback;", "mCustomEventNamesResolver", "Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;", "getMCustomEventNamesResolver", "()Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;", "mCallbackPosted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mCustomEventHandler", "Lcom/facebook/react/uimanager/events/RCTModernEventEmitter;", "mFrameCallbacks", "", "Lcom/swmansion/reanimated/NodesManager$OnAnimationFrame;", "mEventQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/swmansion/reanimated/CopiedEvent;", "lastFrameTimeMs", "", "mFabricUIManager", "Lcom/facebook/react/fabric/FabricUIManager;", "mDrawPassDetector", "Lcom/swmansion/reanimated/DrawPassDetector;", "mNativeProxy", "Lcom/swmansion/reanimated/NativeProxy;", "getNativeProxy", "invalidate", "", "onHostPause", "isAnimationRunning", "onHostResume", "startUpdatingOnAnimationFrame", "stopUpdatingOnAnimationFrame", "performOperations", "performNonLayoutOperations", "performNonLayoutOperations$react_native_reanimated_release", "performOperationsRespectingDrawPass", "performOperationsRespectingDrawPass$react_native_reanimated_release", "isInDrawPass", "isInDrawPass$react_native_reanimated_release", "onAnimationFrame", "frameTimeNanos", "postOnAnimation", "onEventDispatch", "event", "Lcom/facebook/react/uimanager/events/Event;", "handleEvent", "copiedEvent", "getEventNameResolver", "registerEventHandler", "handler", "sendEvent", "name", "", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lcom/facebook/react/bridge/WritableMap;", "enableSlowAnimations", "slowAnimationsEnabled", "animationsDragFactor", "OnAnimationFrame", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NodesManager implements EventDispatcherListener {
    private double lastFrameTimeMs;
    private int mAnimationsDragFactor;
    private final AtomicBoolean mCallbackPosted;
    private final GuardedFrameCallback mChoreographerCallback;
    private RCTModernEventEmitter mCustomEventHandler;
    private final UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
    private final DrawPassDetector mDrawPassDetector;
    private final DeviceEventManagerModule.RCTDeviceEventEmitter mEventEmitter;
    private final ConcurrentLinkedQueue<CopiedEvent> mEventQueue;
    private FabricUIManager mFabricUIManager;
    private long mFirstUptime;
    private List<OnAnimationFrame> mFrameCallbacks;
    private NativeProxy mNativeProxy;
    private final ReactChoreographer mReactChoreographer;
    private boolean mSlowAnimationsEnabled;

    /* JADX INFO: compiled from: NodesManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/swmansion/reanimated/NodesManager$OnAnimationFrame;", "", "onAnimationFrame", "", "timestampMs", "", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface OnAnimationFrame {
        void onAnimationFrame(double timestampMs);
    }

    public NodesManager(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFirstUptime = SystemClock.uptimeMillis();
        JavaScriptModule jSModule = context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        Intrinsics.checkNotNullExpressionValue(jSModule, "getJSModule(...)");
        this.mEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) jSModule;
        this.mCallbackPosted = new AtomicBoolean();
        this.mCustomEventHandler = new NoopEventHandler();
        this.mFrameCallbacks = new ArrayList();
        this.mEventQueue = new ConcurrentLinkedQueue<>();
        context.assertOnJSQueueThread();
        final UIManager uIManager = UIManagerHelper.getUIManager(context, 2);
        this.mCustomEventNamesResolver = new UIManagerModule.CustomEventNamesResolver() { // from class: com.swmansion.reanimated.NodesManager.1
            @Override // com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver
            public String resolveCustomEventName(String eventName) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                UIManager uIManager2 = uIManager;
                Intrinsics.checkNotNull(uIManager2);
                return uIManager2.resolveCustomDirectEventName(eventName);
            }
        };
        this.mDrawPassDetector = new DrawPassDetector(context);
        this.mReactChoreographer = ReactChoreographer.INSTANCE.getInstance();
        this.mChoreographerCallback = new GuardedFrameCallback(context, this) { // from class: com.swmansion.reanimated.NodesManager.2
            final /* synthetic */ NodesManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context);
                this.this$0 = this;
            }

            @Override // com.facebook.react.uimanager.GuardedFrameCallback
            protected void doFrameGuarded(long frameTimeNanos) {
                this.this$0.onAnimationFrame(frameTimeNanos);
            }
        };
        this.mNativeProxy = new NativeProxy(context, this);
        Intrinsics.checkNotNull(uIManager, "null cannot be cast to non-null type com.facebook.react.fabric.FabricUIManager");
        FabricUIManager fabricUIManager = (FabricUIManager) uIManager;
        this.mFabricUIManager = fabricUIManager;
        fabricUIManager.getEventDispatcher().addListener(this);
    }

    public final UIManagerModule.CustomEventNamesResolver getMCustomEventNamesResolver() {
        return this.mCustomEventNamesResolver;
    }

    /* JADX INFO: renamed from: getNativeProxy, reason: from getter */
    public final NativeProxy getMNativeProxy() {
        return this.mNativeProxy;
    }

    public final void invalidate() {
        NativeProxy nativeProxy = this.mNativeProxy;
        if (nativeProxy != null) {
            nativeProxy.invalidate();
            this.mNativeProxy = null;
        }
        this.mDrawPassDetector.invalidate();
        this.mFabricUIManager.getEventDispatcher().removeListener(this);
    }

    public final void onHostPause() {
        if (this.mCallbackPosted.get()) {
            stopUpdatingOnAnimationFrame();
            this.mCallbackPosted.set(true);
        }
    }

    public final boolean isAnimationRunning() {
        return this.mCallbackPosted.get();
    }

    public final void onHostResume() {
        if (this.mCallbackPosted.getAndSet(false)) {
            startUpdatingOnAnimationFrame();
        }
    }

    public final void startUpdatingOnAnimationFrame() {
        if (this.mCallbackPosted.getAndSet(true)) {
            return;
        }
        this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
    }

    private final void stopUpdatingOnAnimationFrame() {
        if (this.mCallbackPosted.getAndSet(false)) {
            this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    public final void performOperations() {
        UiThreadUtil.assertOnUiThread();
        NativeProxy nativeProxy = this.mNativeProxy;
        if (nativeProxy != null) {
            nativeProxy.performOperations();
        }
    }

    public final void performNonLayoutOperations$react_native_reanimated_release() {
        UiThreadUtil.assertOnUiThread();
        NativeProxy nativeProxy = this.mNativeProxy;
        if (nativeProxy != null) {
            nativeProxy.performNonLayoutOperations();
        }
    }

    public final void performOperationsRespectingDrawPass$react_native_reanimated_release() {
        this.mDrawPassDetector.initialize();
        if (isInDrawPass$react_native_reanimated_release()) {
            performNonLayoutOperations$react_native_reanimated_release();
            startUpdatingOnAnimationFrame();
        } else {
            performOperations();
        }
    }

    public final boolean isInDrawPass$react_native_reanimated_release() {
        return this.mDrawPassDetector.getMIsInDrawPass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnimationFrame(long frameTimeNanos) {
        UiThreadUtil.assertOnUiThread();
        this.mDrawPassDetector.initialize();
        double d = frameTimeNanos / 1000000.0d;
        if (this.mSlowAnimationsEnabled) {
            long j = this.mFirstUptime;
            d = ((d - j) / ((double) this.mAnimationsDragFactor)) + j;
        }
        if (d > this.lastFrameTimeMs) {
            this.lastFrameTimeMs = d;
            while (!this.mEventQueue.isEmpty()) {
                CopiedEvent copiedEventPoll = this.mEventQueue.poll();
                Intrinsics.checkNotNull(copiedEventPoll);
                handleEvent(copiedEventPoll);
            }
            if (!this.mFrameCallbacks.isEmpty()) {
                List<OnAnimationFrame> list = this.mFrameCallbacks;
                this.mFrameCallbacks = new ArrayList(list.size());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).onAnimationFrame(d);
                }
            }
            performOperations();
        }
        this.mCallbackPosted.set(false);
        if (this.mFrameCallbacks.isEmpty() && this.mEventQueue.isEmpty()) {
            return;
        }
        startUpdatingOnAnimationFrame();
    }

    public final void postOnAnimation(OnAnimationFrame onAnimationFrame) {
        Intrinsics.checkNotNullParameter(onAnimationFrame, "onAnimationFrame");
        this.mFrameCallbacks.add(onAnimationFrame);
        startUpdatingOnAnimationFrame();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public void onEventDispatch(Event<?> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mNativeProxy == null) {
            return;
        }
        if (UiThreadUtil.isOnUiThread()) {
            this.mDrawPassDetector.initialize();
            handleEvent(event);
            performOperationsRespectingDrawPass$react_native_reanimated_release();
            return;
        }
        String strResolveCustomEventName = this.mCustomEventNamesResolver.resolveCustomEventName(event.internal_getEventNameCompat());
        if (strResolveCustomEventName == null) {
            return;
        }
        int viewTag = event.getViewTag();
        NativeProxy nativeProxy = this.mNativeProxy;
        Intrinsics.checkNotNull(nativeProxy);
        if (nativeProxy.isAnyHandlerWaitingForEvent(strResolveCustomEventName, viewTag)) {
            this.mEventQueue.offer(new CopiedEvent(event));
        }
        startUpdatingOnAnimationFrame();
    }

    private final void handleEvent(Event<?> event) {
        event.dispatchModern(this.mCustomEventHandler);
    }

    private final void handleEvent(CopiedEvent copiedEvent) {
        this.mCustomEventHandler.receiveEvent(copiedEvent.getSurfaceId(), copiedEvent.getTargetTag(), copiedEvent.getEventName(), copiedEvent.getCanCoalesceEvent(), copiedEvent.getCustomCoalesceKey(), copiedEvent.getPayload(), copiedEvent.getCategory());
    }

    /* JADX INFO: renamed from: getEventNameResolver, reason: from getter */
    public final UIManagerModule.CustomEventNamesResolver getMCustomEventNamesResolver() {
        return this.mCustomEventNamesResolver;
    }

    public final void registerEventHandler(RCTModernEventEmitter handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.mCustomEventHandler = handler;
    }

    public final void sendEvent(String name, WritableMap body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        this.mEventEmitter.emit(name, body);
    }

    public final void enableSlowAnimations(boolean slowAnimationsEnabled, int animationsDragFactor) {
        this.mSlowAnimationsEnabled = slowAnimationsEnabled;
        this.mAnimationsDragFactor = animationsDragFactor;
        if (slowAnimationsEnabled) {
            this.mFirstUptime = SystemClock.uptimeMillis();
        }
    }
}
