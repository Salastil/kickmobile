package com.facebook.react;

import android.app.Application;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.internal.ChoreographerProvider;
import expo.modules.updates.loader.EmbeddedLoader;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeHost.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "This class is part of Legacy Architecture and will be removed in a future release")
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 12\u00020\u0001:\u00011B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0003H\u0004J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\n\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020&H\u0014J\n\u0010'\u001a\u0004\u0018\u00010&H\u0014J\n\u0010(\u001a\u0004\u0018\u00010&H\u0014J\b\u0010)\u001a\u00020\fH&J\n\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H$J\n\u0010/\u001a\u0004\u0018\u000100H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u00062"}, d2 = {"Lcom/facebook/react/ReactNativeHost;", "", "mApplication", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "mReactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "reactInstanceManager", "getReactInstanceManager", "()Lcom/facebook/react/ReactInstanceManager;", "hasInstance", "", "clear", "", "createReactInstanceManager", "getBaseReactInstanceManagerBuilder", "Lcom/facebook/react/ReactInstanceManagerBuilder;", "getRedBoxHandler", "Lcom/facebook/react/devsupport/interfaces/RedBoxHandler;", "getJSExceptionHandler", "Lcom/facebook/react/bridge/JSExceptionHandler;", "getJavaScriptExecutorFactory", "Lcom/facebook/react/bridge/JavaScriptExecutorFactory;", "getReactPackageTurboModuleManagerDelegateBuilder", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "getApplication", "getUIManagerProvider", "Lcom/facebook/react/bridge/UIManagerProvider;", "getShouldRequireActivity", "getLazyViewManagersEnabled", "getSurfaceDelegateFactory", "Lcom/facebook/react/common/SurfaceDelegateFactory;", "getDevLoadingViewManager", "Lcom/facebook/react/devsupport/interfaces/DevLoadingViewManager;", "getPausedInDebuggerOverlayManager", "Lcom/facebook/react/devsupport/interfaces/PausedInDebuggerOverlayManager;", "getJSMainModuleName", "", "getJSBundleFile", "getBundleAssetName", "getUseDeveloperSupport", "getDevSupportManagerFactory", "Lcom/facebook/react/devsupport/DevSupportManagerFactory;", "getPackages", "", "Lcom/facebook/react/ReactPackage;", "getChoreographerProvider", "Lcom/facebook/react/internal/ChoreographerProvider;", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ReactNativeHost {
    private static final Companion Companion = new Companion(null);
    private final Application mApplication;
    private ReactInstanceManager mReactInstanceManager;

    static final SurfaceDelegate getSurfaceDelegateFactory$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return null;
    }

    static final UIManager getUIManagerProvider$lambda$0(ReactApplicationContext it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return null;
    }

    protected ChoreographerProvider getChoreographerProvider() {
        return null;
    }

    protected DevLoadingViewManager getDevLoadingViewManager() {
        return null;
    }

    protected DevSupportManagerFactory getDevSupportManagerFactory() {
        return null;
    }

    protected String getJSBundleFile() {
        return null;
    }

    protected JSExceptionHandler getJSExceptionHandler() {
        return null;
    }

    protected JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return null;
    }

    public boolean getLazyViewManagersEnabled() {
        return false;
    }

    protected abstract List<ReactPackage> getPackages();

    protected PausedInDebuggerOverlayManager getPausedInDebuggerOverlayManager() {
        return null;
    }

    protected ReactPackageTurboModuleManagerDelegate.Builder getReactPackageTurboModuleManagerDelegateBuilder() {
        return null;
    }

    protected RedBoxHandler getRedBoxHandler() {
        return null;
    }

    public boolean getShouldRequireActivity() {
        return true;
    }

    public abstract boolean getUseDeveloperSupport();

    protected ReactNativeHost(Application mApplication) {
        Intrinsics.checkNotNullParameter(mApplication, "mApplication");
        this.mApplication = mApplication;
    }

    public synchronized ReactInstanceManager getReactInstanceManager() {
        ReactInstanceManager reactInstanceManager;
        if (this.mReactInstanceManager == null) {
            ReactMarker.logMarker(ReactMarkerConstants.INIT_REACT_RUNTIME_START);
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);
            this.mReactInstanceManager = createReactInstanceManager();
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_END);
        }
        reactInstanceManager = this.mReactInstanceManager;
        Intrinsics.checkNotNull(reactInstanceManager);
        return reactInstanceManager;
    }

    public synchronized boolean hasInstance() {
        return this.mReactInstanceManager != null;
    }

    public synchronized void clear() {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            reactInstanceManager.invalidate();
        }
        this.mReactInstanceManager = null;
    }

    protected ReactInstanceManager createReactInstanceManager() {
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
        ReactInstanceManagerBuilder baseReactInstanceManagerBuilder = getBaseReactInstanceManagerBuilder();
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
        return baseReactInstanceManagerBuilder.build();
    }

    protected ReactInstanceManagerBuilder getBaseReactInstanceManagerBuilder() {
        ReactInstanceManagerBuilder pausedInDebuggerOverlayManager = ReactInstanceManager.builder().setApplication(this.mApplication).setJSMainModulePath(getJSMainModuleName()).setUseDeveloperSupport(getUseDeveloperSupport()).setDevSupportManagerFactory(getDevSupportManagerFactory()).setDevLoadingViewManager(getDevLoadingViewManager()).setRequireActivity(getShouldRequireActivity()).setSurfaceDelegateFactory(getSurfaceDelegateFactory()).setJSExceptionHandler(getJSExceptionHandler()).setLazyViewManagersEnabled(getLazyViewManagersEnabled()).setRedBoxHandler(getRedBoxHandler()).setJavaScriptExecutorFactory(getJavaScriptExecutorFactory()).setUIManagerProvider(getUIManagerProvider()).setInitialLifecycleState(LifecycleState.BEFORE_CREATE).setReactPackageTurboModuleManagerDelegateBuilder(getReactPackageTurboModuleManagerDelegateBuilder()).setChoreographerProvider(getChoreographerProvider()).setPausedInDebuggerOverlayManager(getPausedInDebuggerOverlayManager());
        Iterator<ReactPackage> it = getPackages().iterator();
        while (it.hasNext()) {
            pausedInDebuggerOverlayManager.addPackage(it.next());
        }
        String jSBundleFile = getJSBundleFile();
        if (jSBundleFile != null) {
            pausedInDebuggerOverlayManager.setJSBundleFile(jSBundleFile);
            return pausedInDebuggerOverlayManager;
        }
        pausedInDebuggerOverlayManager.setBundleAssetName((String) Assertions.assertNotNull(getBundleAssetName()));
        return pausedInDebuggerOverlayManager;
    }

    /* JADX INFO: renamed from: getApplication, reason: from getter */
    protected final Application getMApplication() {
        return this.mApplication;
    }

    protected UIManagerProvider getUIManagerProvider() {
        return new UIManagerProvider() { // from class: com.facebook.react.ReactNativeHost$$ExternalSyntheticLambda0
            @Override // com.facebook.react.bridge.UIManagerProvider
            public final UIManager createUIManager(ReactApplicationContext reactApplicationContext) {
                return ReactNativeHost.getUIManagerProvider$lambda$0(reactApplicationContext);
            }
        };
    }

    public SurfaceDelegateFactory getSurfaceDelegateFactory() {
        return new SurfaceDelegateFactory() { // from class: com.facebook.react.ReactNativeHost$$ExternalSyntheticLambda1
            @Override // com.facebook.react.common.SurfaceDelegateFactory
            public final SurfaceDelegate createSurfaceDelegate(String str) {
                return ReactNativeHost.getSurfaceDelegateFactory$lambda$1(str);
            }
        };
    }

    protected String getJSMainModuleName() {
        return "index.android";
    }

    protected String getBundleAssetName() {
        return EmbeddedLoader.BARE_BUNDLE_FILENAME;
    }

    /* JADX INFO: compiled from: ReactNativeHost.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/facebook/react/ReactNativeHost$Companion;", "", "<init>", "()V", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("ReactNativeHost", LegacyArchitectureLogLevel.ERROR);
    }
}
