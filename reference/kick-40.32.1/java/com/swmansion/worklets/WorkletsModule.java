package com.swmansion.worklets;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.soloader.SoLoader;
import com.swmansion.worklets.networking.Networking;
import com.swmansion.worklets.runloop.AnimationFrameCallback;
import com.swmansion.worklets.runloop.AnimationFrameQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkletsModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@ReactModule(name = "WorkletsModule", needsEagerInit = true)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0004J)\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0011H\u0082 J\t\u0010\u001e\u001a\u00020\u001fH\u0082 J\t\u0010 \u001a\u00020\u001fH\u0082 J\t\u0010!\u001a\u00020\u001fH\u0082 J\u0011\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0013H\u0082 J\b\u0010$\u001a\u00020\u0013H\u0017J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0017J\b\u0010&\u001a\u00020\u0013H\u0017J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020\u0013H\u0007J\b\u0010+\u001a\u00020,H\u0007J\u0006\u0010-\u001a\u00020\u001fJ\b\u0010.\u001a\u00020\u0013H\u0017J\b\u0010/\u001a\u00020\u001fH\u0016J\b\u00100\u001a\u00020\u001fH\u0016J\t\u00101\u001a\u00020\u001fH\u0082 J\t\u00102\u001a\u00020\u001fH\u0082 J\b\u00103\u001a\u00020\u001fH\u0016J\b\u00104\u001a\u00020\u001fH\u0016J\b\u00105\u001a\u00020\u001fH\u0016J\b\u00106\u001a\u00020\u001fH\u0002R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/swmansion/worklets/WorkletsModule;", "Lcom/swmansion/worklets/NativeWorkletsModuleSpec;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "getMHybridData$annotations", "()V", "getHybridData", "mAndroidUIScheduler", "Lcom/swmansion/worklets/AndroidUIScheduler;", "mAnimationFrameQueue", "Lcom/swmansion/worklets/runloop/AnimationFrameQueue;", "mNetworking", "Lcom/swmansion/worklets/networking/Networking;", "mSlowAnimationsEnabled", "", "mInvalidationLock", "", "mInvalidated", "initHybrid", "jsContext", "", "jsCallInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "androidUIScheduler", "networking", "prepareProxyCpp", "", "beginBundleModeAOTCpp", "prepareBundleModeAOTCpp", "installTurboModuleCpp", "bundleModeEnabled", "prepareBundleMode", "installTurboModule", ViewProps.START, "requestAnimationFrame", "animationFrameCallback", "Lcom/swmansion/worklets/runloop/AnimationFrameCallback;", "isOnJSQueueThread", "createScriptBufferWrapper", "Lcom/swmansion/worklets/ScriptBufferWrapper;", "toggleSlowAnimations", "toggleSlowAnimationsOnUIRuntime", "initialize", "invalidate", "invalidateCpp", "startCpp", "onHostResume", "onHostPause", "onHostDestroy", "createHybrid", "Companion", "react-native-worklets_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WorkletsModule extends NativeWorkletsModuleSpec implements LifecycleEventListener {
    public static final String NAME = "WorkletsModule";
    private final AndroidUIScheduler mAndroidUIScheduler;
    private final AnimationFrameQueue mAnimationFrameQueue;
    private HybridData mHybridData;
    private boolean mInvalidated;
    private final Object mInvalidationLock;
    private final Networking mNetworking;
    private boolean mSlowAnimationsEnabled;

    private final native void beginBundleModeAOTCpp();

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    private final native HybridData initHybrid(long jsContext, CallInvokerHolderImpl jsCallInvokerHolder, AndroidUIScheduler androidUIScheduler, Networking networking);

    private final native void installTurboModuleCpp(boolean bundleModeEnabled);

    private final native void invalidateCpp();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void prepareBundleModeAOTCpp();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void prepareProxyCpp();

    private final native void startCpp();

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkletsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.mAndroidUIScheduler = new AndroidUIScheduler(reactContext);
        this.mAnimationFrameQueue = new AnimationFrameQueue(reactContext);
        this.mNetworking = new Networking();
        this.mInvalidationLock = new Object();
    }

    static {
        SoLoader.loadLibrary("worklets");
    }

    /* JADX INFO: renamed from: getHybridData, reason: from getter */
    protected final HybridData getMHybridData() {
        return this.mHybridData;
    }

    @Override // com.swmansion.worklets.NativeWorkletsModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean prepareBundleMode() {
        getReactApplicationContext().assertOnJSQueueThread();
        beginBundleModeAOTCpp();
        new Thread(new Runnable() { // from class: com.swmansion.worklets.WorkletsModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.prepareBundleModeAOTCpp();
            }
        }, "WorkletsBundleModePrepare").start();
        return true;
    }

    @Override // com.swmansion.worklets.NativeWorkletsModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean installTurboModule(boolean bundleModeEnabled) {
        getReactApplicationContext().assertOnJSQueueThread();
        installTurboModuleCpp(bundleModeEnabled);
        return true;
    }

    @Override // com.swmansion.worklets.NativeWorkletsModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean start() {
        getReactApplicationContext().assertOnJSQueueThread();
        startCpp();
        return true;
    }

    public final void requestAnimationFrame(AnimationFrameCallback animationFrameCallback) {
        Intrinsics.checkNotNullParameter(animationFrameCallback, "animationFrameCallback");
        this.mAnimationFrameQueue.requestAnimationFrame(animationFrameCallback);
    }

    public final boolean isOnJSQueueThread() {
        return getReactApplicationContext().isOnJSQueueThread();
    }

    public final ScriptBufferWrapper createScriptBufferWrapper() {
        String sourceURL = getReactApplicationContext().getSourceURL();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return new ScriptBufferWrapper(sourceURL, reactApplicationContext);
    }

    public final void toggleSlowAnimations() {
        boolean z = !this.mSlowAnimationsEnabled;
        this.mSlowAnimationsEnabled = z;
        this.mAnimationFrameQueue.enableSlowAnimations(z, 10);
    }

    @Override // com.swmansion.worklets.NativeWorkletsModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean toggleSlowAnimationsOnUIRuntime() {
        toggleSlowAnimations();
        return this.mSlowAnimationsEnabled;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        createHybrid();
        new Thread(new Runnable() { // from class: com.swmansion.worklets.WorkletsModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.prepareProxyCpp();
            }
        }, "WorkletsProxyPrepare").start();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        synchronized (this.mInvalidationLock) {
            if (this.mInvalidated) {
                return;
            }
            this.mInvalidated = true;
            getReactApplicationContext().removeLifecycleEventListener(this);
            Unit unit = Unit.INSTANCE;
            this.mAnimationFrameQueue.invalidate();
            HybridData hybridData = this.mHybridData;
            if (hybridData != null) {
                Intrinsics.checkNotNull(hybridData);
                if (hybridData.isValid()) {
                    invalidateCpp();
                }
            }
            this.mAndroidUIScheduler.deactivate();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        synchronized (this.mInvalidationLock) {
            if (this.mInvalidated) {
                return;
            }
            this.mAnimationFrameQueue.resume();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        synchronized (this.mInvalidationLock) {
            if (this.mInvalidated) {
                return;
            }
            this.mAnimationFrameQueue.pause();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void createHybrid() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
        if (javaScriptContextHolder == null) {
            throw new IllegalStateException("[Worklets] JavaScript context is not available yet.".toString());
        }
        long context = javaScriptContextHolder.getContext();
        CallInvokerHolder jSCallInvokerHolder = reactApplicationContext.getJSCallInvokerHolder();
        Intrinsics.checkNotNull(jSCallInvokerHolder, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
        this.mHybridData = initHybrid(context, (CallInvokerHolderImpl) jSCallInvokerHolder, this.mAndroidUIScheduler, this.mNetworking);
    }
}
