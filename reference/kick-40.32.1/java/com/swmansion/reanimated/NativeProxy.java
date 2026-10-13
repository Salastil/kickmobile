package com.swmansion.reanimated;

import android.content.ContentResolver;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.soloader.SoLoader;
import com.swmansion.common.GestureHandlerStateManager;
import com.swmansion.reanimated.css.CSSPlatformTransitionsManager;
import com.swmansion.reanimated.keyboard.KeyboardAnimationManager;
import com.swmansion.reanimated.keyboard.KeyboardWorkletWrapper;
import com.swmansion.reanimated.nativeProxy.AnimationFrameCallback;
import com.swmansion.reanimated.nativeProxy.EventHandler;
import com.swmansion.reanimated.nativeProxy.PseudoSelectorCallback;
import com.swmansion.reanimated.nativeProxy.SensorSetter;
import com.swmansion.reanimated.nativeProxy.SynchronousPropsBufferParser;
import com.swmansion.reanimated.pseudoSelectors.ExtraWindowObserverBridge;
import com.swmansion.reanimated.pseudoSelectors.PseudoSelectorManager;
import com.swmansion.reanimated.sensor.ReanimatedSensorContainer;
import com.swmansion.reanimated.sensor.ReanimatedSensorType;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NativeProxy.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u0088\u00012\u00020\u0001:\u0002\u0088\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u00102\u001a\u0002002\u0006\u00103\u001a\u00020 2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000eH\u0082 J\u0019\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020$H\u0086 J\t\u0010:\u001a\u00020;H\u0086 J\t\u0010<\u001a\u00020;H\u0086 J\t\u0010=\u001a\u00020;H\u0086 J\t\u0010>\u001a\u00020;H\u0082 J\t\u0010?\u001a\u00020;H\u0086 J\b\u0010@\u001a\u000200H\u0004J\u0006\u0010A\u001a\u00020;J\b\u0010B\u001a\u00020;H\u0002J\b\u0010C\u001a\u00020;H\u0002J \u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020HH\u0007J\u0018\u0010I\u001a\u00020;2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020$H\u0007J\u0010\u0010J\u001a\u00020;2\u0006\u0010G\u001a\u00020KH\u0007J\b\u0010L\u001a\u00020&H\u0007J\b\u0010M\u001a\u00020;H\u0004J\u0010\u0010N\u001a\u00020\"2\u0006\u0010O\u001a\u00020PH\u0007J\u0018\u0010\\\u001a\u00020;2\u0006\u0010]\u001a\u00020P2\u0006\u0010^\u001a\u00020_H\u0007J(\u0010`\u001a\u00020;2\u0006\u0010a\u001a\u00020$2\u0006\u0010b\u001a\u00020$2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020dH\u0007J\u0010\u0010f\u001a\u00020;2\u0006\u0010a\u001a\u00020$H\u0007JH\u0010g\u001a\u00020\"2\u0006\u0010h\u001a\u00020$2\u0006\u0010i\u001a\u00020$2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020k2\u0006\u0010m\u001a\u00020k2\u0006\u0010n\u001a\u00020k2\u0006\u0010a\u001a\u00020$2\u0006\u0010o\u001a\u00020\"H\u0007J\u0018\u0010p\u001a\u00020;2\u0006\u0010h\u001a\u00020$2\u0006\u0010i\u001a\u00020$H\u0007J\u0018\u0010q\u001a\u00020;2\u0006\u0010r\u001a\u00020$2\u0006\u0010s\u001a\u00020$H\u0007J\b\u0010t\u001a\u00020 H\u0007J\u0010\u0010u\u001a\u00020;2\u0006\u0010v\u001a\u00020wH\u0007J \u0010x\u001a\u00020$2\u0006\u0010y\u001a\u00020$2\u0006\u0010z\u001a\u00020$2\u0006\u0010{\u001a\u00020|H\u0007J\u0010\u0010}\u001a\u00020;2\u0006\u0010~\u001a\u00020$H\u0007J$\u0010\u007f\u001a\u00020$2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\"2\u0007\u0010\u0083\u0001\u001a\u00020\"H\u0007J\u0012\u0010\u0084\u0001\u001a\u00020;2\u0007\u0010\u0085\u0001\u001a\u00020$H\u0007J\t\u0010\u0086\u0001\u001a\u00020\"H\u0007J\t\u0010\u0087\u0001\u001a\u00020;H\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082D¢\u0006\u0002\n\u0000R$\u0010%\u001a\u0004\u0018\u00010&@\u0005X\u0084\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\u0002008\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b1\u0010(R\u001b\u0010Q\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bR\u0010SR#\u0010V\u001a\n X*\u0004\u0018\u00010W0W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010U\u001a\u0004\bY\u0010Z¨\u0006\u0089\u0001"}, d2 = {"Lcom/swmansion/reanimated/NativeProxy;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/bridge/ReactApplicationContext;", "nodesManager", "Lcom/swmansion/reanimated/NodesManager;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/swmansion/reanimated/NodesManager;)V", "mNodesManager", "getMNodesManager", "()Lcom/swmansion/reanimated/NodesManager;", "setMNodesManager", "(Lcom/swmansion/reanimated/NodesManager;)V", "mFabricUIManager", "Lcom/facebook/react/fabric/FabricUIManager;", "getMFabricUIManager", "()Lcom/facebook/react/fabric/FabricUIManager;", "mContext", "Ljava/lang/ref/WeakReference;", "getMContext", "()Ljava/lang/ref/WeakReference;", "reanimatedSensorContainer", "Lcom/swmansion/reanimated/sensor/ReanimatedSensorContainer;", "gestureHandlerStateManager", "Lcom/swmansion/common/GestureHandlerStateManager;", "keyboardAnimationManager", "Lcom/swmansion/reanimated/keyboard/KeyboardAnimationManager;", "pseudoSelectorManager", "Lcom/swmansion/reanimated/pseudoSelectors/PseudoSelectorManager;", "cssPlatformTransitionsManager", "Lcom/swmansion/reanimated/css/CSSPlatformTransitionsManager;", "firstUptime", "", "slowAnimationsEnabled", "", "animationsDragFactor", "", "cppVersion", "", "getCppVersion$annotations", "()V", "getCppVersion", "()Ljava/lang/String;", "setCppVersion", "(Ljava/lang/String;)V", "mInvalidated", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mHybridData", "Lcom/facebook/jni/HybridData;", "getMHybridData$annotations", "initHybrid", "jsContext", "jsCallInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "fabricUIManager", "isAnyHandlerWaitingForEvent", "eventName", "emitterReactTag", "performOperations", "", "performNonLayoutOperations", "installJSIBindings", "invalidateCpp", "toggleSlowAnimationsOnUIRuntime", "getHybridData", "invalidate", "toggleSlowAnimations", "addDevMenuOption", "attachPseudoSelector", "tag", "selector", "callback", "Lcom/swmansion/reanimated/nativeProxy/PseudoSelectorCallback;", "detachPseudoSelector", "requestRender", "Lcom/swmansion/reanimated/nativeProxy/AnimationFrameCallback;", "getReanimatedJavaVersion", "checkCppVersion", "preserveMountedTags", "tags", "", "mountingManager", "getMountingManager", "()Ljava/lang/Object;", "mountingManager$delegate", "Lkotlin/Lazy;", "updatePropsSynchronouslyMethod", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getUpdatePropsSynchronouslyMethod", "()Ljava/lang/reflect/Method;", "updatePropsSynchronouslyMethod$delegate", "synchronouslyUpdateUIProps", "intBuffer", "doubleBuffer", "", "cssDefineEasing", "easingId", "easingType", "easingPointsX", "", "easingPointsY", "cssUndefineEasing", "cssAnimateTransition", "viewTag", "propertyId", "fromValue", "", "toValue", "durationMs", "startTimestampMs", "persistent", "cssRemoveTransition", "setGestureState", "handlerTag", "newState", "getAnimationTimestamp", "registerEventHandler", "handler", "Lcom/swmansion/reanimated/nativeProxy/EventHandler;", "registerSensor", "sensorType", "interval", "setter", "Lcom/swmansion/reanimated/nativeProxy/SensorSetter;", "unregisterSensor", "sensorId", "subscribeForKeyboardEvents", "keyboardWorkletWrapper", "Lcom/swmansion/reanimated/keyboard/KeyboardWorkletWrapper;", "isStatusBarTranslucent", "isNavigationBarTranslucent", "unsubscribeFromKeyboardEvents", "listenerId", "getIsReducedMotion", "maybeFlushUIUpdatesQueue", "Companion", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class NativeProxy {
    private final int animationsDragFactor;
    private String cppVersion;
    private final CSSPlatformTransitionsManager cssPlatformTransitionsManager;
    private long firstUptime;
    private final GestureHandlerStateManager gestureHandlerStateManager;
    private final KeyboardAnimationManager keyboardAnimationManager;
    private final WeakReference<ReactApplicationContext> mContext;
    private final FabricUIManager mFabricUIManager;
    private final HybridData mHybridData;
    private final AtomicBoolean mInvalidated;
    private NodesManager mNodesManager;

    /* JADX INFO: renamed from: mountingManager$delegate, reason: from kotlin metadata */
    private final Lazy mountingManager;
    private final PseudoSelectorManager pseudoSelectorManager;
    private final ReanimatedSensorContainer reanimatedSensorContainer;
    private boolean slowAnimationsEnabled;

    /* JADX INFO: renamed from: updatePropsSynchronouslyMethod$delegate, reason: from kotlin metadata */
    private final Lazy updatePropsSynchronouslyMethod;

    protected static /* synthetic */ void getCppVersion$annotations() {
    }

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    private final native HybridData initHybrid(long jsContext, CallInvokerHolderImpl jsCallInvokerHolder, FabricUIManager fabricUIManager);

    private final native void invalidateCpp();

    public final native void installJSIBindings();

    public final native boolean isAnyHandlerWaitingForEvent(String eventName, int emitterReactTag);

    public final native void performNonLayoutOperations();

    public final native void performOperations();

    public final native void toggleSlowAnimationsOnUIRuntime();

    static {
        SoLoader.loadLibrary("reanimated");
    }

    protected final NodesManager getMNodesManager() {
        return this.mNodesManager;
    }

    protected final void setMNodesManager(NodesManager nodesManager) {
        this.mNodesManager = nodesManager;
    }

    protected final FabricUIManager getMFabricUIManager() {
        return this.mFabricUIManager;
    }

    protected final WeakReference<ReactApplicationContext> getMContext() {
        return this.mContext;
    }

    protected final String getCppVersion() {
        return this.cppVersion;
    }

    protected final void setCppVersion(String str) {
        this.cppVersion = str;
    }

    public NativeProxy(ReactApplicationContext context, NodesManager nodesManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nodesManager, "nodesManager");
        this.firstUptime = SystemClock.uptimeMillis();
        this.animationsDragFactor = 10;
        this.mInvalidated = new AtomicBoolean(false);
        this.mountingManager = LazyKt.lazy(new Function0() { // from class: com.swmansion.reanimated.NativeProxy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NativeProxy.mountingManager_delegate$lambda$0(this.f$0);
            }
        });
        this.updatePropsSynchronouslyMethod = LazyKt.lazy(new Function0() { // from class: com.swmansion.reanimated.NativeProxy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NativeProxy.updatePropsSynchronouslyMethod_delegate$lambda$0(this.f$0);
            }
        });
        context.assertOnJSQueueThread();
        WeakReference<ReactApplicationContext> weakReference = new WeakReference<>(context);
        this.mContext = weakReference;
        this.reanimatedSensorContainer = new ReanimatedSensorContainer(weakReference);
        this.keyboardAnimationManager = new KeyboardAnimationManager(weakReference);
        addDevMenuOption();
        GestureHandlerStateManager gestureHandlerStateManager = null;
        try {
            Class<?> cls = Class.forName("com.swmansion.gesturehandler.react.RNGestureHandlerModule");
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<com.facebook.react.bridge.NativeModule>");
            gestureHandlerStateManager = (GestureHandlerStateManager) context.getNativeModule(cls);
        } catch (ClassCastException | ClassNotFoundException unused) {
        }
        this.gestureHandlerStateManager = gestureHandlerStateManager;
        this.mNodesManager = nodesManager;
        UIManager uIManager = UIManagerHelper.getUIManager(context, 2);
        Intrinsics.checkNotNull(uIManager, "null cannot be cast to non-null type com.facebook.react.fabric.FabricUIManager");
        FabricUIManager fabricUIManager = (FabricUIManager) uIManager;
        this.mFabricUIManager = fabricUIManager;
        this.pseudoSelectorManager = new PseudoSelectorManager(fabricUIManager, this.mContext);
        this.cssPlatformTransitionsManager = new CSSPlatformTransitionsManager(fabricUIManager, this.mContext, new AnonymousClass1(this));
        CallInvokerHolder jSCallInvokerHolder = context.getJSCallInvokerHolder();
        Intrinsics.checkNotNull(jSCallInvokerHolder, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
        JavaScriptContextHolder javaScriptContextHolder = context.getJavaScriptContextHolder();
        Intrinsics.checkNotNull(javaScriptContextHolder);
        this.mHybridData = initHybrid(javaScriptContextHolder.getContext(), (CallInvokerHolderImpl) jSCallInvokerHolder, fabricUIManager);
    }

    /* JADX INFO: renamed from: com.swmansion.reanimated.NativeProxy$1, reason: invalid class name */
    /* JADX INFO: compiled from: NativeProxy.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        AnonymousClass1(Object obj) {
            super(0, obj, NativeProxy.class, "getAnimationTimestamp", "getAnimationTimestamp()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(((NativeProxy) this.receiver).getAnimationTimestamp());
        }
    }

    /* JADX INFO: renamed from: getHybridData, reason: from getter */
    protected final HybridData getMHybridData() {
        return this.mHybridData;
    }

    public final void invalidate() {
        if (this.mInvalidated.getAndSet(true)) {
            return;
        }
        this.pseudoSelectorManager.invalidate();
        this.cssPlatformTransitionsManager.invalidate();
        if (this.mHybridData.isValid()) {
            invalidateCpp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleSlowAnimations() {
        boolean z = this.slowAnimationsEnabled;
        this.slowAnimationsEnabled = !z;
        if (!z) {
            this.firstUptime = SystemClock.uptimeMillis();
        }
        NodesManager nodesManager = this.mNodesManager;
        Intrinsics.checkNotNull(nodesManager);
        nodesManager.enableSlowAnimations(this.slowAnimationsEnabled, this.animationsDragFactor);
        this.cssPlatformTransitionsManager.enableSlowAnimations(this.slowAnimationsEnabled, this.animationsDragFactor);
        toggleSlowAnimationsOnUIRuntime();
    }

    private final void addDevMenuOption() {
        ReactApplicationContext reactApplicationContext = this.mContext.get();
        Intrinsics.checkNotNull(reactApplicationContext);
        DevMenuUtils.addDevMenuOption(reactApplicationContext, new DevOptionHandler() { // from class: com.swmansion.reanimated.NativeProxy$$ExternalSyntheticLambda3
            @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
            public final void onOptionSelected() {
                this.f$0.toggleSlowAnimations();
            }
        });
    }

    public final void attachPseudoSelector(int tag, int selector, PseudoSelectorCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.pseudoSelectorManager.attach(tag, selector, callback);
    }

    public final void detachPseudoSelector(int tag, int selector) {
        this.pseudoSelectorManager.detach(tag, selector);
    }

    public final void requestRender(AnimationFrameCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        UiThreadUtil.assertOnUiThread();
        NodesManager nodesManager = this.mNodesManager;
        Intrinsics.checkNotNull(nodesManager);
        nodesManager.postOnAnimation(callback);
    }

    public final String getReanimatedJavaVersion() {
        return BuildConfig.REANIMATED_VERSION_JAVA;
    }

    protected final void checkCppVersion() {
        if (this.cppVersion == null) {
            throw new RuntimeException("[Reanimated] Java side failed to resolve C++ code version. See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#java-side-failed-to-resolve-c-code-version for more information.");
        }
        String reanimatedJavaVersion = getReanimatedJavaVersion();
        if (Intrinsics.areEqual(this.cppVersion, reanimatedJavaVersion)) {
            return;
        }
        throw new RuntimeException("[Reanimated] Mismatch between Java code version and C++ code version (" + reanimatedJavaVersion + " vs. " + this.cppVersion + " respectively). See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#mismatch-between-java-code-version-and-c-code-version for more information.");
    }

    public final boolean preserveMountedTags(int[] tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (!UiThreadUtil.isOnUiThread()) {
            return false;
        }
        int length = tags.length;
        for (int i = 0; i < length; i++) {
            try {
                if (this.mFabricUIManager.resolveView(tags[i]) == null) {
                    tags[i] = -1;
                }
            } catch (IllegalViewOperationException unused) {
                tags[i] = -1;
            }
        }
        return true;
    }

    private final Object getMountingManager() {
        Object value = this.mountingManager.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return value;
    }

    static final Object mountingManager_delegate$lambda$0(NativeProxy nativeProxy) throws NoSuchFieldException {
        Field declaredField = FabricUIManager.class.getDeclaredField("mMountingManager");
        declaredField.setAccessible(true);
        return declaredField.get(nativeProxy.mFabricUIManager);
    }

    private final Method getUpdatePropsSynchronouslyMethod() {
        return (Method) this.updatePropsSynchronouslyMethod.getValue();
    }

    static final Method updatePropsSynchronouslyMethod_delegate$lambda$0(NativeProxy nativeProxy) {
        Method[] methods = nativeProxy.getMountingManager().getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "getMethods(...)");
        for (Method method : methods) {
            String name = method.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (StringsKt.startsWith$default(name, "updatePropsSynchronously", false, 2, (Object) null) && method.getParameterTypes().length == 2) {
                method.setAccessible(true);
                return method;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public final void synchronouslyUpdateUIProps(int[] intBuffer, double[] doubleBuffer) {
        Intrinsics.checkNotNullParameter(intBuffer, "intBuffer");
        Intrinsics.checkNotNullParameter(doubleBuffer, "doubleBuffer");
        this.cssPlatformTransitionsManager.onPropsWrittenSynchronously();
        SynchronousPropsBufferParser.INSTANCE.parse(intBuffer, doubleBuffer, new Function2() { // from class: com.swmansion.reanimated.NativeProxy$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NativeProxy.synchronouslyUpdateUIProps$lambda$0(this.f$0, ((Integer) obj).intValue(), (JavaOnlyMap) obj2);
            }
        });
    }

    static final Unit synchronouslyUpdateUIProps$lambda$0(NativeProxy nativeProxy, int i, JavaOnlyMap props) {
        Intrinsics.checkNotNullParameter(props, "props");
        try {
            nativeProxy.getUpdatePropsSynchronouslyMethod().invoke(nativeProxy.getMountingManager(), Integer.valueOf(i), props);
        } catch (Exception e) {
            Log.w(ExtraWindowObserverBridge.TAG, "synchronouslyUpdateUIProps failed for tag " + i, e);
        }
        return Unit.INSTANCE;
    }

    public final void cssDefineEasing(int easingId, int easingType, float[] easingPointsX, float[] easingPointsY) {
        Intrinsics.checkNotNullParameter(easingPointsX, "easingPointsX");
        Intrinsics.checkNotNullParameter(easingPointsY, "easingPointsY");
        this.cssPlatformTransitionsManager.defineEasing(easingId, easingType, easingPointsX, easingPointsY);
    }

    public final void cssUndefineEasing(int easingId) {
        this.cssPlatformTransitionsManager.undefineEasing(easingId);
    }

    public final boolean cssAnimateTransition(int viewTag, int propertyId, double fromValue, double toValue, double durationMs, double startTimestampMs, int easingId, boolean persistent) {
        return this.cssPlatformTransitionsManager.animateTransition(viewTag, propertyId, fromValue, toValue, durationMs, startTimestampMs, easingId, persistent);
    }

    public final void cssRemoveTransition(int viewTag, int propertyId) {
        this.cssPlatformTransitionsManager.removeTransition(viewTag, propertyId);
    }

    public final void setGestureState(int handlerTag, int newState) {
        GestureHandlerStateManager gestureHandlerStateManager = this.gestureHandlerStateManager;
        if (gestureHandlerStateManager != null) {
            gestureHandlerStateManager.setGestureHandlerState(handlerTag, newState);
        }
    }

    public final long getAnimationTimestamp() {
        if (this.slowAnimationsEnabled) {
            return this.firstUptime + ((SystemClock.uptimeMillis() - this.firstUptime) / ((long) this.animationsDragFactor));
        }
        return SystemClock.uptimeMillis();
    }

    public final void registerEventHandler(EventHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        NodesManager nodesManager = this.mNodesManager;
        Intrinsics.checkNotNull(nodesManager);
        handler.setMCustomEventNamesResolver(nodesManager.getMCustomEventNamesResolver());
        handler.setInDrawPassProvider$react_native_reanimated_release(new Function0() { // from class: com.swmansion.reanimated.NativeProxy$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NativeProxy.registerEventHandler$lambda$0(this.f$0));
            }
        });
        NodesManager nodesManager2 = this.mNodesManager;
        Intrinsics.checkNotNull(nodesManager2);
        nodesManager2.registerEventHandler(handler);
    }

    static final boolean registerEventHandler$lambda$0(NativeProxy nativeProxy) {
        NodesManager nodesManager = nativeProxy.mNodesManager;
        Intrinsics.checkNotNull(nodesManager);
        return nodesManager.isInDrawPass$react_native_reanimated_release();
    }

    public final int registerSensor(int sensorType, int interval, SensorSetter setter) {
        Intrinsics.checkNotNullParameter(setter, "setter");
        return this.reanimatedSensorContainer.registerSensor(ReanimatedSensorType.INSTANCE.getInstanceById(sensorType), interval, setter);
    }

    public final void unregisterSensor(int sensorId) {
        this.reanimatedSensorContainer.unregisterSensor(sensorId);
    }

    public final int subscribeForKeyboardEvents(KeyboardWorkletWrapper keyboardWorkletWrapper, boolean isStatusBarTranslucent, boolean isNavigationBarTranslucent) {
        Intrinsics.checkNotNullParameter(keyboardWorkletWrapper, "keyboardWorkletWrapper");
        return this.keyboardAnimationManager.subscribeForKeyboardUpdates(keyboardWorkletWrapper, isStatusBarTranslucent, isNavigationBarTranslucent);
    }

    public final void unsubscribeFromKeyboardEvents(int listenerId) {
        this.keyboardAnimationManager.unsubscribeFromKeyboardUpdates(listenerId);
    }

    public final boolean getIsReducedMotion() {
        ReactApplicationContext reactApplicationContext = this.mContext.get();
        Intrinsics.checkNotNull(reactApplicationContext);
        ContentResolver contentResolver = reactApplicationContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        String string = Settings.Global.getString(contentResolver, "transition_animation_scale");
        return (string != null ? Float.parseFloat(string) : 1.0f) == 0.0f;
    }

    public final void maybeFlushUIUpdatesQueue() {
        UiThreadUtil.assertOnUiThread();
        NodesManager nodesManager = this.mNodesManager;
        Intrinsics.checkNotNull(nodesManager);
        if (nodesManager.isAnimationRunning()) {
            return;
        }
        NodesManager nodesManager2 = this.mNodesManager;
        Intrinsics.checkNotNull(nodesManager2);
        nodesManager2.performOperationsRespectingDrawPass$react_native_reanimated_release();
    }
}
