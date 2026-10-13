package com.facebook.react.bridge;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.interop.InteropModuleRegistry;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.FrameworkAPI;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import java.util.Collection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BridgeReactContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 82\u00020\u0001:\u000278B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\b\u0010\r\u001a\u00020\u000bH\u0002J'\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0016¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u0007\"\b\b\u0000\u0010\u000f*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0016J'\u0010\u0019\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0016¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0017J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0017J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u000bH\u0017J\u0014\u0010#\u001a\u00020\u000b2\n\u0010$\u001a\u00060%j\u0002`&H\u0016J\b\u0010'\u001a\u00020\u0007H\u0017J\n\u0010(\u001a\u0004\u0018\u00010)H\u0017J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\n\u0010,\u001a\u0004\u0018\u00010-H\u0017J\n\u0010.\u001a\u0004\u0018\u00010\u001cH\u0016J \u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/react/bridge/BridgeReactContext;", "Lcom/facebook/react/bridge/ReactApplicationContext;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mDestroyed", "", "mCatalystInstance", "Lcom/facebook/react/bridge/CatalystInstance;", "initializeWithInstance", "", "catalystInstance", "raiseCatalystInstanceMissingException", "getJSModule", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/react/bridge/JavaScriptModule;", "jsInterface", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/facebook/react/bridge/JavaScriptModule;", "hasNativeModule", "Lcom/facebook/react/bridge/NativeModule;", "nativeModuleInterface", "getNativeModules", "", "getNativeModule", "(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;", "moduleName", "", "getCatalystInstance", "hasActiveCatalystInstance", "hasActiveReactInstance", "hasCatalystInstance", "hasReactInstance", "destroy", "handleException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isBridgeless", "getJavaScriptContextHolder", "Lcom/facebook/react/bridge/JavaScriptContextHolder;", "getJSCallInvokerHolder", "Lcom/facebook/react/turbomodule/core/interfaces/CallInvokerHolder;", "getFabricUIManager", "Lcom/facebook/react/bridge/UIManager;", "getSourceURL", "registerSegment", "segmentId", "", "path", "callback", "Lcom/facebook/react/bridge/Callback;", "getRuntimeExecutor", "Lcom/facebook/react/bridge/RuntimeExecutor;", "RCTDeviceEventEmitter", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(message = "This class is part of Legacy Architecture and will be removed in a future release", replaceWith = @ReplaceWith(expression = "BridgelessReactContext", imports = {}))
@VisibleForTesting
public class BridgeReactContext extends ReactApplicationContext {
    private static final Companion Companion = new Companion(null);
    private static final String EARLY_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should only happen once initialize() has been called on your native module.";
    private static final String EARLY_NATIVE_MODULE_EXCEPTION_MESSAGE = "Trying to call native module before CatalystInstance has been set!";
    private static final String LATE_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module after the React instance was destroyed.";
    private static final String LATE_NATIVE_MODULE_EXCEPTION_MESSAGE = "Trying to call native module after CatalystInstance has been destroyed!";
    private static final String TAG = "BridgeReactContext";
    private CatalystInstance mCatalystInstance;
    private volatile boolean mDestroyed;

    /* JADX INFO: compiled from: BridgeReactContext.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/bridge/BridgeReactContext$RCTDeviceEventEmitter;", "Lcom/facebook/react/bridge/JavaScriptModule;", "emit", "", "eventName", "", "data", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(String eventName, Object data);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated(message = "DO NOT USE, this method will be removed in the near future.")
    public boolean isBridgeless() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BridgeReactContext(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void initializeWithInstance(CatalystInstance catalystInstance) {
        Intrinsics.checkNotNullParameter(catalystInstance, "catalystInstance");
        if (this.mCatalystInstance != null) {
            throw new IllegalStateException("ReactContext has been already initialized");
        }
        if (this.mDestroyed) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot initialize ReactContext after it has been destroyed."));
        }
        this.mCatalystInstance = catalystInstance;
        initializeMessageQueueThreads(catalystInstance.getReactQueueConfiguration());
        initializeInteropModules();
    }

    private final void raiseCatalystInstanceMissingException() {
        throw new IllegalStateException(this.mDestroyed ? LATE_NATIVE_MODULE_EXCEPTION_MESSAGE : EARLY_NATIVE_MODULE_EXCEPTION_MESSAGE);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends JavaScriptModule> T getJSModule(Class<T> jsInterface) {
        T t;
        Intrinsics.checkNotNullParameter(jsInterface, "jsInterface");
        if (this.mCatalystInstance == null) {
            if (this.mDestroyed) {
                throw new IllegalStateException(LATE_JS_ACCESS_EXCEPTION_MESSAGE);
            }
            throw new IllegalStateException(EARLY_JS_ACCESS_EXCEPTION_MESSAGE);
        }
        InteropModuleRegistry interopModuleRegistry = this.mInteropModuleRegistry;
        if (interopModuleRegistry != null && (t = (T) interopModuleRegistry.getInteropModule(jsInterface)) != null) {
            return t;
        }
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return (T) catalystInstance.getJSModule(jsInterface);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends NativeModule> boolean hasNativeModule(Class<T> nativeModuleInterface) {
        Intrinsics.checkNotNullParameter(nativeModuleInterface, "nativeModuleInterface");
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance == null) {
            raiseCatalystInstanceMissingException();
            throw new IllegalStateException("unreachable".toString());
        }
        return catalystInstance.hasNativeModule(nativeModuleInterface);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Collection<NativeModule> getNativeModules() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance == null) {
            raiseCatalystInstanceMissingException();
            throw new IllegalStateException("unreachable".toString());
        }
        return catalystInstance.getNativeModules();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public <T extends NativeModule> T getNativeModule(Class<T> nativeModuleInterface) {
        Intrinsics.checkNotNullParameter(nativeModuleInterface, "nativeModuleInterface");
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance == null) {
            raiseCatalystInstanceMissingException();
            throw new IllegalStateException("unreachable".toString());
        }
        return (T) catalystInstance.getNativeModule(nativeModuleInterface);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public NativeModule getNativeModule(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance == null) {
            raiseCatalystInstanceMissingException();
            throw new IllegalStateException("unreachable".toString());
        }
        return catalystInstance.getNativeModule(moduleName);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CatalystInstance getCatalystInstance() {
        Object objAssertNotNull = Assertions.assertNotNull(this.mCatalystInstance);
        Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
        return (CatalystInstance) objAssertNotNull;
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated(message = "Use hasActiveReactInstance() instead")
    public boolean hasActiveCatalystInstance() {
        return hasActiveReactInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasActiveReactInstance() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        return (catalystInstance == null || catalystInstance.isDestroyed()) ? false : true;
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated(message = "Use hasReactInstance() instead")
    public boolean hasCatalystInstance() {
        return this.mCatalystInstance != null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasReactInstance() {
        return this.mCatalystInstance != null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void destroy() {
        UiThreadUtil.assertOnUiThread();
        this.mDestroyed = true;
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            catalystInstance.destroy();
        }
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void handleException(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        CatalystInstance catalystInstance = this.mCatalystInstance;
        boolean z = catalystInstance != null;
        boolean z2 = (catalystInstance == null || catalystInstance.isDestroyed()) ? false : true;
        JSExceptionHandler jSExceptionHandler = getJSExceptionHandler();
        if (z2 && jSExceptionHandler != null) {
            jSExceptionHandler.handleException(e);
            return;
        }
        Exception exc = e;
        FLog.e(ReactConstants.TAG, "Unable to handle Exception - catalystInstanceVariableExists: " + z + " - isCatalystInstanceAlive: " + z2 + " - hasExceptionHandler: " + (jSExceptionHandler != null), exc);
        throw new IllegalStateException(exc);
    }

    @Override // com.facebook.react.bridge.ReactContext
    @FrameworkAPI
    @UnstableReactNativeAPI
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getJavaScriptContextHolder();
        }
        return null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CallInvokerHolder getJSCallInvokerHolder() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getJSCallInvokerHolder();
        }
        return null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    @Deprecated(message = "Use UIManagerHelper.getUIManager() instead")
    public UIManager getFabricUIManager() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getFabricUIManager();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.facebook.react.bridge.ReactContext
    public String getSourceURL() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getSourceURL();
        }
        return null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void registerSegment(int segmentId, String path, Callback callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((CatalystInstance) Assertions.assertNotNull(this.mCatalystInstance)).registerSegment(segmentId, path);
        ((Callback) Assertions.assertNotNull(callback)).invoke(new Object[0]);
    }

    /* JADX INFO: compiled from: BridgeReactContext.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/react/bridge/BridgeReactContext$Companion;", "", "<init>", "()V", "TAG", "", "EARLY_JS_ACCESS_EXCEPTION_MESSAGE", "LATE_JS_ACCESS_EXCEPTION_MESSAGE", "EARLY_NATIVE_MODULE_EXCEPTION_MESSAGE", "LATE_NATIVE_MODULE_EXCEPTION_MESSAGE", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture(TAG, LegacyArchitectureLogLevel.ERROR);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public RuntimeExecutor getRuntimeExecutor() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getRuntimeExecutor();
        }
        return null;
    }
}
