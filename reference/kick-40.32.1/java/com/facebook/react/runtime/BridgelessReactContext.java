package com.facebook.react.runtime;

import android.content.Context;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.JavaScriptModuleRegistry;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.interop.InteropModuleRegistry;
import com.facebook.react.common.annotations.FrameworkAPI;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlags;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherProvider;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BridgelessReactContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001HB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017J\b\u0010\u001d\u001a\u00020\u001eH\u0017J\b\u0010\u001f\u001a\u00020 H\u0017J\b\u0010!\u001a\u00020 H\u0017J\b\u0010\"\u001a\u00020 H\u0017J\b\u0010#\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J \u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0016J'\u0010,\u001a\u0004\u0018\u0001H-\"\b\b\u0000\u0010-*\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H-00H\u0016¢\u0006\u0002\u00101J\u001a\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u000105H\u0016J \u00106\u001a\u00020 \"\b\b\u0000\u0010-*\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u0002H-00H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u0002070:H\u0016J'\u0010;\u001a\u0004\u0018\u0001H-\"\b\b\u0000\u0010-*\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u0002H-00H\u0016¢\u0006\u0002\u0010<J\u0012\u0010;\u001a\u0004\u0018\u0001072\u0006\u0010=\u001a\u00020\u000bH\u0016J\n\u0010>\u001a\u0004\u0018\u00010?H\u0017J\u0014\u0010@\u001a\u00020\u00192\n\u0010A\u001a\u00060Bj\u0002`CH\u0016J\n\u0010D\u001a\u0004\u0018\u00010EH\u0016J\n\u0010F\u001a\u0004\u0018\u00010GH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006I"}, d2 = {"Lcom/facebook/react/runtime/BridgelessReactContext;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "Lcom/facebook/react/uimanager/events/EventDispatcherProvider;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "reactHost", "Lcom/facebook/react/runtime/ReactHostImpl;", "<init>", "(Landroid/content/Context;Lcom/facebook/react/runtime/ReactHostImpl;)V", "sourceURLRef", "Ljava/util/concurrent/atomic/AtomicReference;", "", "TAG", "devSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "getDevSupportManager", "()Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "defaultHardwareBackBtnHandler", "Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;", "getDefaultHardwareBackBtnHandler", "()Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;", "getEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "getSourceURL", "setSourceURL", "", "sourceURL", "getFabricUIManager", "Lcom/facebook/react/bridge/UIManager;", "getCatalystInstance", "Lcom/facebook/react/bridge/CatalystInstance;", "hasActiveCatalystInstance", "", "isBridgeless", "hasCatalystInstance", "hasActiveReactInstance", "hasReactInstance", "destroy", "registerSegment", "segmentId", "", "path", "callback", "Lcom/facebook/react/bridge/Callback;", "getJSModule", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/react/bridge/JavaScriptModule;", "jsInterface", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/facebook/react/bridge/JavaScriptModule;", "emitDeviceEvent", "eventName", "args", "", "hasNativeModule", "Lcom/facebook/react/bridge/NativeModule;", "nativeModuleInterface", "getNativeModules", "", "getNativeModule", "(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;", "name", "getJavaScriptContextHolder", "Lcom/facebook/react/bridge/JavaScriptContextHolder;", "handleException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getJSCallInvokerHolder", "Lcom/facebook/react/turbomodule/core/interfaces/CallInvokerHolder;", "getRuntimeExecutor", "Lcom/facebook/react/bridge/RuntimeExecutor;", "BridgelessJSModuleInvocationHandler", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BridgelessReactContext extends ReactApplicationContext implements EventDispatcherProvider {
    private final String TAG;
    private final ReactHostImpl reactHost;
    private final AtomicReference<String> sourceURLRef;

    @Override // com.facebook.react.bridge.ReactContext
    public void destroy() {
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated(message = "This API has been deprecated due to naming consideration, please use hasReactInstance() instead")
    public boolean hasCatalystInstance() {
        return false;
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated(message = "DO NOT USE, this method will be removed in the near future.")
    public boolean isBridgeless() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BridgelessReactContext(Context context, ReactHostImpl reactHost) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reactHost, "reactHost");
        this.reactHost = reactHost;
        this.sourceURLRef = new AtomicReference<>();
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        this.TAG = simpleName;
        if (ReactBuildConfig.UNSTABLE_REMOVE_LEGACY_COMPONENT_INTEROP || !ReactNativeNewArchitectureFeatureFlags.useFabricInterop()) {
            return;
        }
        initializeInteropModules();
    }

    public final DevSupportManager getDevSupportManager() {
        return this.reactHost.getDevSupportManager();
    }

    public final DefaultHardwareBackBtnHandler getDefaultHardwareBackBtnHandler() {
        return this.reactHost.getDefaultBackButtonHandler$ReactAndroid();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherProvider
    public EventDispatcher getEventDispatcher() {
        return this.reactHost.getEventDispatcher$ReactAndroid();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public String getSourceURL() {
        return this.sourceURLRef.get();
    }

    public final void setSourceURL(String sourceURL) {
        this.sourceURLRef.set(sourceURL);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated(message = "This method is deprecated, please use UIManagerHelper.getUIManager() instead.")
    public UIManager getFabricUIManager() {
        return this.reactHost.getUiManager$ReactAndroid();
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated(message = "This method is deprecated in the New Architecture. You should not be invoking directly as we're going to remove it in the future.")
    public CatalystInstance getCatalystInstance() {
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            throw new UnsupportedOperationException("CatalystInstance is not supported when Bridgeless mode is enabled.");
        }
        Log.w(this.TAG, "[WARNING] Bridgeless doesn't support CatalystInstance. Accessing an API that's not part of the new architecture is not encouraged usage.");
        return new BridgelessCatalystInstance(this.reactHost);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated(message = "This API has been deprecated due to naming consideration, please use hasActiveReactInstance() instead")
    public boolean hasActiveCatalystInstance() {
        return hasActiveReactInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasActiveReactInstance() {
        return this.reactHost.isInstanceInitialized$ReactAndroid();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasReactInstance() {
        return this.reactHost.isInstanceInitialized$ReactAndroid();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void registerSegment(int segmentId, String path, Callback callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.reactHost.registerSegment$ReactAndroid(segmentId, path, callback);
    }

    /* JADX INFO: compiled from: BridgelessReactContext.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/runtime/BridgelessReactContext$BridgelessJSModuleInvocationHandler;", "Ljava/lang/reflect/InvocationHandler;", "reactHost", "Lcom/facebook/react/runtime/ReactHostImpl;", "jsModuleInterface", "Ljava/lang/Class;", "Lcom/facebook/react/bridge/JavaScriptModule;", "<init>", "(Lcom/facebook/react/runtime/ReactHostImpl;Ljava/lang/Class;)V", "invoke", "", "proxy", FirebaseAnalytics.Param.METHOD, "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BridgelessJSModuleInvocationHandler implements InvocationHandler {
        private final Class<? extends JavaScriptModule> jsModuleInterface;
        private final ReactHostImpl reactHost;

        public BridgelessJSModuleInvocationHandler(ReactHostImpl reactHost, Class<? extends JavaScriptModule> jsModuleInterface) {
            Intrinsics.checkNotNullParameter(reactHost, "reactHost");
            Intrinsics.checkNotNullParameter(jsModuleInterface, "jsModuleInterface");
            this.reactHost = reactHost;
            this.jsModuleInterface = jsModuleInterface;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] args) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            WritableNativeArray writableNativeArrayFromJavaArgs = args != null ? Arguments.fromJavaArgs(args) : null;
            ReactHostImpl reactHostImpl = this.reactHost;
            String jSModuleName = JavaScriptModuleRegistry.INSTANCE.getJSModuleName(this.jsModuleInterface);
            String name = method.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            reactHostImpl.callFunctionOnModule$ReactAndroid(jSModuleName, name, writableNativeArrayFromJavaArgs);
            return null;
        }
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends JavaScriptModule> T getJSModule(Class<T> jsInterface) {
        T t;
        Intrinsics.checkNotNullParameter(jsInterface, "jsInterface");
        InteropModuleRegistry interopModuleRegistry = this.mInteropModuleRegistry;
        if (interopModuleRegistry != null && (t = (T) interopModuleRegistry.getInteropModule(jsInterface)) != null) {
            if (Intrinsics.areEqual(jsInterface, RCTEventEmitter.class)) {
                ReactSoftExceptionLogger.logSoftException(this.TAG, new IllegalArgumentException("getJSModule(RCTEventEmitter) is not recommended in the new architecture and will stop working with interop disabled. Please use UIManagerHelper.getEventDispatcher instead"));
            }
            return t;
        }
        Object objNewProxyInstance = Proxy.newProxyInstance(jsInterface.getClassLoader(), new Class[]{jsInterface}, new BridgelessJSModuleInvocationHandler(this.reactHost, jsInterface));
        Intrinsics.checkNotNull(objNewProxyInstance, "null cannot be cast to non-null type com.facebook.react.bridge.JavaScriptModule");
        T t2 = (T) objNewProxyInstance;
        if (t2 instanceof JavaScriptModule) {
            return t2;
        }
        return null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void emitDeviceEvent(String eventName, Object args) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.reactHost.callFunctionOnModule$ReactAndroid("RCTDeviceEventEmitter", "emit", Arguments.fromJavaArgs(new Object[]{eventName, args}));
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends NativeModule> boolean hasNativeModule(Class<T> nativeModuleInterface) {
        Intrinsics.checkNotNullParameter(nativeModuleInterface, "nativeModuleInterface");
        return this.reactHost.hasNativeModule$ReactAndroid(nativeModuleInterface);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Collection<NativeModule> getNativeModules() {
        return this.reactHost.getNativeModules$ReactAndroid();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends NativeModule> T getNativeModule(Class<T> nativeModuleInterface) {
        Intrinsics.checkNotNullParameter(nativeModuleInterface, "nativeModuleInterface");
        return (T) this.reactHost.getNativeModule$ReactAndroid(nativeModuleInterface);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public NativeModule getNativeModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.reactHost.getNativeModule$ReactAndroid(name);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @FrameworkAPI
    @UnstableReactNativeAPI
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.reactHost.getJavaScriptContextHolder$ReactAndroid();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void handleException(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.reactHost.handleHostException$ReactAndroid(e);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CallInvokerHolder getJSCallInvokerHolder() {
        return this.reactHost.getJsCallInvokerHolder$ReactAndroid();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public RuntimeExecutor getRuntimeExecutor() {
        return this.reactHost.getRuntimeExecutor$ReactAndroid();
    }
}
