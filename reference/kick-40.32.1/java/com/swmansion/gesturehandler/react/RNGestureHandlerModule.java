package com.swmansion.gesturehandler.react;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.interfaces.BindingsInstallerHolder;
import com.facebook.react.turbomodule.core.interfaces.TurboModuleWithJSIBindings;
import com.facebook.soloader.SoLoader;
import com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.react.events.RNGestureHandlerEventDispatcher;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNGestureHandlerModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@ReactModule(name = "RNGestureHandlerModule")
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J*\u0010\u001c\u001a\u00020\u001d\"\b\b\u0000\u0010\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010$\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020#H\u0017J \u0010'\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0017J\u0018\u0010*\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020#H\u0017J\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020#H\u0017J\u0018\u0010,\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020#H\u0017J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0017J\b\u0010/\u001a\u00020\u001dH\u0017J\b\u00100\u001a\u00020\u0015H\u0017J\u0018\u00101\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0007J\u0018\u00103\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0002J\t\u00104\u001a\u00020\u0011H\u0082 J\t\u00105\u001a\u000206H\u0082 J\t\u00107\u001a\u00020\u0015H\u0082 J\t\u00108\u001a\u00020\u001dH\u0082 J\b\u00109\u001a\u000206H\u0016J\b\u0010:\u001a\u00020\u001dH\u0016J\u000e\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u000fJ\u000e\u0010=\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006?"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule;", "Lcom/swmansion/gesturehandler/NativeRNGestureHandlerModuleSpec;", "Lcom/facebook/react/turbomodule/core/interfaces/TurboModuleWithJSIBindings;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "moduleId", "", "eventDispatcher", "Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerEventDispatcher;", "interactionManager", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager;", "roots", "", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;", "mHybridData", "Lcom/facebook/jni/HybridData;", "getMHybridData$annotations", "()V", "uiRuntimeDecorated", "", "registry", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "getRegistry", "()Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "getName", "", "createGestureHandlerHelper", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handlerName", "handlerTag", "config", "Lcom/facebook/react/bridge/ReadableMap;", "createGestureHandler", "handlerTagDouble", "", "attachGestureHandler", "viewTagDouble", "actionTypeDouble", "setGestureHandlerConfig", "updateGestureHandlerConfig", "configureRelations", "relations", "dropGestureHandler", "flushOperations", "installUIRuntimeBindings", "setGestureHandlerState", "newState", "setGestureStateSync", "initHybrid", "getBindingsInstallerCxx", "Lcom/facebook/react/turbomodule/core/interfaces/BindingsInstallerHolder;", "installUIRuntimeBindingsNative", "invalidateNative", "getBindingsInstaller", "invalidate", "registerRootHelper", CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID, "unregisterRootHelper", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNGestureHandlerModule extends NativeRNGestureHandlerModuleSpec implements TurboModuleWithJSIBindings {
    public static final String NAME = "RNGestureHandlerModule";
    private static int nextModuleId;
    private final RNGestureHandlerEventDispatcher eventDispatcher;
    private final RNGestureHandlerInteractionManager interactionManager;
    private HybridData mHybridData;
    private final int moduleId;
    private final List<RNGestureHandlerRootHelper> roots;
    private boolean uiRuntimeDecorated;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Integer, RNGestureHandlerRegistry> registries = new LinkedHashMap();
    private static final Map<Integer, WeakReference<RNGestureHandlerModule>> modules = new ConcurrentHashMap();

    private final native BindingsInstallerHolder getBindingsInstallerCxx();

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    private final native HybridData initHybrid();

    private final native boolean installUIRuntimeBindingsNative();

    private final native void invalidateNative();

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void flushOperations() {
    }

    public RNGestureHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        int i = nextModuleId;
        nextModuleId = i + 1;
        this.moduleId = i;
        ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "getReactApplicationContext(...)");
        this.eventDispatcher = new RNGestureHandlerEventDispatcher(reactApplicationContext2);
        this.interactionManager = new RNGestureHandlerInteractionManager();
        this.roots = new ArrayList();
        this.mHybridData = initHybrid();
        registries.put(Integer.valueOf(i), new RNGestureHandlerRegistry());
        modules.put(Integer.valueOf(i), new WeakReference<>(this));
    }

    private final RNGestureHandlerRegistry getRegistry() {
        RNGestureHandlerRegistry rNGestureHandlerRegistry = registries.get(Integer.valueOf(this.moduleId));
        Intrinsics.checkNotNull(rNGestureHandlerRegistry);
        return rNGestureHandlerRegistry;
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNGestureHandlerModule";
    }

    private final <T extends GestureHandler> void createGestureHandlerHelper(String handlerName, int handlerTag, ReadableMap config) {
        if (getRegistry().getHandler(handlerTag) != null) {
            throw new IllegalStateException("Handler with tag " + handlerTag + " already exists. Please ensure that no Gesture instance is used across multiple GestureDetectors.");
        }
        GestureHandler.Factory<GestureHandler> factoryFindFactoryForName = RNGestureHandlerFactoryUtil.INSTANCE.findFactoryForName(handlerName);
        if (factoryFindFactoryForName == null) {
            throw new JSApplicationIllegalArgumentException("Invalid handler name " + handlerName);
        }
        GestureHandler gestureHandlerCreate = factoryFindFactoryForName.create(getReactApplicationContext(), handlerTag);
        gestureHandlerCreate.setOnTouchEventListener(this.eventDispatcher);
        getRegistry().registerHandler(gestureHandlerCreate);
        this.interactionManager.configureInteractions(gestureHandlerCreate, config);
        factoryFindFactoryForName.setConfig(gestureHandlerCreate, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void createGestureHandler(String handlerName, double handlerTagDouble, ReadableMap config) {
        Intrinsics.checkNotNullParameter(handlerName, "handlerName");
        Intrinsics.checkNotNullParameter(config, "config");
        createGestureHandlerHelper(handlerName, (int) handlerTagDouble, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void attachGestureHandler(double handlerTagDouble, double viewTagDouble, double actionTypeDouble) {
        int i = (int) handlerTagDouble;
        if (RNGestureHandlerRegistry.attachHandlerToView$default(getRegistry(), i, (int) viewTagDouble, (int) actionTypeDouble, null, 8, null)) {
            return;
        }
        throw new JSApplicationIllegalArgumentException("Handler with tag " + i + " does not exists");
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void setGestureHandlerConfig(double handlerTagDouble, ReadableMap config) {
        GestureHandler.Factory<GestureHandler> factoryFindFactoryForHandler;
        Intrinsics.checkNotNullParameter(config, "config");
        GestureHandler handler = getRegistry().getHandler((int) handlerTagDouble);
        if (handler == null || (factoryFindFactoryForHandler = RNGestureHandlerFactoryUtil.INSTANCE.findFactoryForHandler(handler)) == null) {
            return;
        }
        factoryFindFactoryForHandler.setConfig(handler, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void updateGestureHandlerConfig(double handlerTagDouble, ReadableMap config) {
        GestureHandler.Factory<GestureHandler> factoryFindFactoryForHandler;
        Intrinsics.checkNotNullParameter(config, "config");
        GestureHandler handler = getRegistry().getHandler((int) handlerTagDouble);
        if (handler == null || (factoryFindFactoryForHandler = RNGestureHandlerFactoryUtil.INSTANCE.findFactoryForHandler(handler)) == null) {
            return;
        }
        factoryFindFactoryForHandler.updateConfig(handler, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void configureRelations(double handlerTagDouble, ReadableMap relations) {
        Intrinsics.checkNotNullParameter(relations, "relations");
        int i = (int) handlerTagDouble;
        GestureHandler handler = getRegistry().getHandler(i);
        if (handler == null) {
            return;
        }
        this.interactionManager.dropRelationsForHandlerWithTag(i);
        this.interactionManager.configureInteractions(handler, relations);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void dropGestureHandler(double handlerTagDouble) {
        int i = (int) handlerTagDouble;
        this.interactionManager.dropRelationsForHandlerWithTag(i);
        getRegistry().dropHandler(i);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public boolean installUIRuntimeBindings() {
        if (!this.uiRuntimeDecorated) {
            this.uiRuntimeDecorated = installUIRuntimeBindingsNative();
        }
        return this.uiRuntimeDecorated;
    }

    public final void setGestureHandlerState(final int handlerTag, final int newState) {
        if (UiThreadUtil.isOnUiThread()) {
            setGestureStateSync(handlerTag, newState);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerModule$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.setGestureStateSync(handlerTag, newState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setGestureStateSync(int handlerTag, int newState) {
        UiThreadUtil.assertOnUiThread();
        GestureHandler handler = getRegistry().getHandler(handlerTag);
        if (handler != null) {
            if (newState == 4) {
                if (handler.getState() != 2) {
                    return;
                } else {
                    handler.recordHandlerIfNotPresent();
                }
            }
            if (newState == 1) {
                handler.fail();
                return;
            }
            if (newState == 2) {
                handler.begin();
                return;
            }
            if (newState == 3) {
                handler.cancel();
            } else if (newState == 4) {
                handler.activate(true);
            } else {
                if (newState != 5) {
                    return;
                }
                handler.end();
            }
        }
    }

    @Override // com.facebook.react.turbomodule.core.interfaces.TurboModuleWithJSIBindings
    public BindingsInstallerHolder getBindingsInstaller() {
        return getBindingsInstallerCxx();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        getRegistry().dropAllHandlers();
        this.interactionManager.reset();
        synchronized (this.roots) {
            while (!this.roots.isEmpty()) {
                this.roots.size();
                this.roots.get(0).tearDown();
                this.roots.size();
            }
            Unit unit = Unit.INSTANCE;
        }
        registries.remove(Integer.valueOf(this.moduleId));
        modules.remove(Integer.valueOf(this.moduleId));
        invalidateNative();
        super.invalidate();
    }

    public final void registerRootHelper(RNGestureHandlerRootHelper root) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.roots) {
            this.roots.contains(root);
            this.roots.add(root);
        }
    }

    public final void unregisterRootHelper(RNGestureHandlerRootHelper root) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.roots) {
            this.roots.remove(root);
        }
    }

    /* JADX INFO: compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$Companion;", "", "<init>", "()V", "NAME", "", "nextModuleId", "", "registries", "", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "getRegistries", "()Ljava/util/Map;", "modules", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule;", "getModule", "moduleId", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<Integer, RNGestureHandlerRegistry> getRegistries() {
            return RNGestureHandlerModule.registries;
        }

        public final RNGestureHandlerModule getModule(int moduleId) {
            WeakReference weakReference = (WeakReference) RNGestureHandlerModule.modules.get(Integer.valueOf(moduleId));
            RNGestureHandlerModule rNGestureHandlerModule = weakReference != null ? (RNGestureHandlerModule) weakReference.get() : null;
            if (rNGestureHandlerModule == null) {
                RNGestureHandlerModule.modules.remove(Integer.valueOf(moduleId));
                getRegistries().remove(Integer.valueOf(moduleId));
            }
            return rNGestureHandlerModule;
        }
    }

    static {
        SoLoader.loadLibrary("gesturehandler");
    }
}
