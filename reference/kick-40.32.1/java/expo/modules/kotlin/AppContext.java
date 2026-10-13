package expo.modules.kotlin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.network.OkHttpClientProvider;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.core.errors.ContextDestroyedException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.logging.Logger;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.activityresult.ActivityResultsManager;
import expo.modules.kotlin.activityresult.DefaultAppContextActivityResultCaller;
import expo.modules.kotlin.defaultmodules.JSLoggerModule;
import expo.modules.kotlin.defaultmodules.NativeModulesProxyModule;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.KEventEmitterWrapper;
import expo.modules.kotlin.events.KModuleEventEmitterWrapper;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import expo.modules.kotlin.runtime.MainRuntime;
import expo.modules.kotlin.runtime.WorkletRuntime;
import expo.modules.kotlin.services.AppDirectoriesService;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.services.Service;
import expo.modules.kotlin.services.ServicesRegistry;
import expo.modules.kotlin.types.ConverterContext;
import expo.modules.v2.ExpoModulesV2Host;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: AppContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020?H\u0002J\u0006\u0010A\u001a\u00020?J\u0018\u0010B\u001a\u0004\u0018\u0001HC\"\u0006\b\u0000\u0010C\u0018\u0001H\u0086\b¢\u0006\u0002\u0010DJ\u001c\u0010E\u001a\u0004\u0018\u0001HF\"\n\b\u0000\u0010F\u0018\u0001*\u00020GH\u0086\b¢\u0006\u0002\u0010HJ%\u0010E\u001a\u0004\u0018\u0001HF\"\b\b\u0000\u0010F*\u00020G2\f\u0010I\u001a\b\u0012\u0004\u0012\u0002HF0J¢\u0006\u0002\u0010KJ\u0006\u0010k\u001a\u00020lJ\u0010\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010o\u001a\u00020pJ\r\u0010z\u001a\u00020?H\u0000¢\u0006\u0002\b{J\r\u0010|\u001a\u00020?H\u0000¢\u0006\u0002\b}J\r\u0010~\u001a\u00020?H\u0000¢\u0006\u0002\b\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020?H\u0000¢\u0006\u0003\b\u0081\u0001J\u000f\u0010\u0082\u0001\u001a\u00020?H\u0000¢\u0006\u0003\b\u0083\u0001J9\u0010\u0084\u0001\u001a\u00020?2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u0088\u00012\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0000¢\u0006\u0003\b\u008c\u0001J\u001b\u0010\u008d\u0001\u001a\u00020?2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0000¢\u0006\u0003\b\u008f\u0001J\u0013\u0010\u0090\u0001\u001a\u00020?2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010(\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\"\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020;X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010L\u001a\u00020M8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020Q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0011\u0010T\u001a\u00020U8F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0011\u0010X\u001a\u00020U8F¢\u0006\u0006\u001a\u0004\bY\u0010WR\u0013\u0010Z\u001a\u0004\u0018\u00010[8F¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0013\u0010^\u001a\u0004\u0018\u00010_8F¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0013\u0010b\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\bc\u0010\u0015R\u0011\u0010d\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0011\u0010g\u001a\u00020h8F¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0016\u0010q\u001a\u0004\u0018\u00010n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u001d\u0010t\u001a\u0004\u0018\u00010u8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bv\u0010wR\u001a\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0086\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0015\u0010\u0096\u0001\u001a\u00030\u0086\u00018F¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0095\u0001¨\u0006\u0098\u0001"}, d2 = {"Lexpo/modules/kotlin/AppContext;", "Lexpo/modules/kotlin/providers/CurrentActivityProvider;", "Lexpo/modules/kotlin/types/ConverterContext;", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "legacyModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lexpo/modules/kotlin/ModulesProvider;Lexpo/modules/core/ModuleRegistry;Ljava/lang/ref/WeakReference;)V", "getLegacyModuleRegistry", "()Lexpo/modules/core/ModuleRegistry;", "runtime", "Lexpo/modules/kotlin/runtime/MainRuntime;", "getRuntime", "()Lexpo/modules/kotlin/runtime/MainRuntime;", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "uiRuntimeHolder", "Lkotlin/Lazy;", "Lexpo/modules/kotlin/runtime/WorkletRuntime;", "uiRuntime", "getUiRuntime", "()Lexpo/modules/kotlin/runtime/WorkletRuntime;", "reactLifecycleDelegate", "Lexpo/modules/kotlin/ReactLifecycleDelegate;", "hostWasDestroyed", "", "modulesQueueDispatcher", "Lkotlinx/coroutines/android/HandlerDispatcher;", "backgroundCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getBackgroundCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "modulesQueue", "getModulesQueue", "mainQueue", "getMainQueue", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "services", "Lexpo/modules/kotlin/services/ServicesRegistry;", "getServices", "()Lexpo/modules/kotlin/services/ServicesRegistry;", "legacyModulesProxyHolder", "Lexpo/modules/adapters/react/NativeModulesProxy;", "getLegacyModulesProxyHolder$expo_modules_core_release", "()Ljava/lang/ref/WeakReference;", "setLegacyModulesProxyHolder$expo_modules_core_release", "(Ljava/lang/ref/WeakReference;)V", "activityResultsManager", "Lexpo/modules/kotlin/activityresult/ActivityResultsManager;", "appContextActivityResultCaller", "Lexpo/modules/kotlin/activityresult/DefaultAppContextActivityResultCaller;", "getAppContextActivityResultCaller$expo_modules_core_release", "()Lexpo/modules/kotlin/activityresult/DefaultAppContextActivityResultCaller;", "onCreate", "", "registerInlineModulesList", "installJSIInterop", "legacyModule", "Module", "()Ljava/lang/Object;", "service", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/services/Service;", "()Lexpo/modules/kotlin/services/Service;", "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lexpo/modules/kotlin/services/Service;", "filePermission", "Lexpo/modules/kotlin/services/FilePermissionService;", "getFilePermission", "()Lexpo/modules/kotlin/services/FilePermissionService;", "appDirectories", "Lexpo/modules/kotlin/services/AppDirectoriesService;", "getAppDirectories", "()Lexpo/modules/kotlin/services/AppDirectoriesService;", "persistentFilesDirectory", "Ljava/io/File;", "getPersistentFilesDirectory", "()Ljava/io/File;", "cacheDirectory", "getCacheDirectory", "permissions", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissions", "()Lexpo/modules/interfaces/permissions/Permissions;", "activityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "getActivityProvider", "()Lexpo/modules/core/interfaces/ActivityProvider;", "reactContext", "getReactContext", "hasActiveReactInstance", "getHasActiveReactInstance", "()Z", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "createOkHttpClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "eventEmitter", "Lexpo/modules/kotlin/events/EventEmitter;", "module", "Lexpo/modules/kotlin/modules/Module;", "callbackInvoker", "getCallbackInvoker$expo_modules_core_release", "()Lexpo/modules/kotlin/events/EventEmitter;", "jsLogger", "Lexpo/modules/core/logging/Logger;", "getJsLogger", "()Lexpo/modules/core/logging/Logger;", "jsLogger$delegate", "Lkotlin/Lazy;", "onDestroy", "onDestroy$expo_modules_core_release", "onHostResume", "onHostResume$expo_modules_core_release", "onHostPause", "onHostPause$expo_modules_core_release", "onUserLeaveHint", "onUserLeaveHint$expo_modules_core_release", "onHostDestroy", "onHostDestroy$expo_modules_core_release", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onActivityResult$expo_modules_core_release", "onNewIntent", "intent", "onNewIntent$expo_modules_core_release", "executeOnJavaScriptThread", "runnable", "Ljava/lang/Runnable;", "currentActivity", "getCurrentActivity", "()Landroid/app/Activity;", "throwingActivity", "getThrowingActivity", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AppContext implements CurrentActivityProvider, ConverterContext {
    public static final int $stable = 8;
    private final ActivityResultsManager activityResultsManager;
    private final DefaultAppContextActivityResultCaller appContextActivityResultCaller;
    private final CoroutineScope backgroundCoroutineScope;
    private boolean hostWasDestroyed;

    /* JADX INFO: renamed from: jsLogger$delegate, reason: from kotlin metadata */
    private final Lazy jsLogger;
    private final expo.modules.core.ModuleRegistry legacyModuleRegistry;
    private WeakReference<NativeModulesProxy> legacyModulesProxyHolder;
    private final CoroutineScope mainQueue;
    private final CoroutineScope modulesQueue;
    private final HandlerDispatcher modulesQueueDispatcher;
    private final ReactLifecycleDelegate reactLifecycleDelegate;
    private final ModuleRegistry registry;
    private final MainRuntime runtime;
    private final ServicesRegistry services;
    private final Lazy<WorkletRuntime> uiRuntimeHolder;

    public AppContext(ModulesProvider modulesProvider, expo.modules.core.ModuleRegistry legacyModuleRegistry, final WeakReference<ReactApplicationContext> reactContextHolder) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(legacyModuleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.legacyModuleRegistry = legacyModuleRegistry;
        this.runtime = new MainRuntime(this, reactContextHolder);
        this.uiRuntimeHolder = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.uiRuntimeHolder$lambda$0(this.f$0, reactContextHolder);
            }
        });
        ReactLifecycleDelegate reactLifecycleDelegate = new ReactLifecycleDelegate(this);
        this.reactLifecycleDelegate = reactLifecycleDelegate;
        HandlerThread handlerThread = new HandlerThread("expo.modules.AsyncFunctionQueue");
        handlerThread.start();
        HandlerDispatcher handlerDispatcherFrom$default = HandlerDispatcherKt.from$default(new Handler(handlerThread.getLooper()), null, 1, null);
        this.modulesQueueDispatcher = handlerDispatcherFrom$default;
        this.backgroundCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.BackgroundCoroutineScope")));
        this.modulesQueue = CoroutineScopeKt.CoroutineScope(handlerDispatcherFrom$default.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.AsyncFunctionQueue")));
        this.mainQueue = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.MainQueue")));
        ModuleRegistry moduleRegistry = new ModuleRegistry(UtilsKt.weak(this));
        this.registry = moduleRegistry;
        ServicesRegistry servicesRegistry = new ServicesRegistry(UtilsKt.weak(this));
        this.services = servicesRegistry;
        ActivityResultsManager activityResultsManager = new ActivityResultsManager(this);
        this.activityResultsManager = activityResultsManager;
        this.appContextActivityResultCaller = new DefaultAppContextActivityResultCaller(activityResultsManager);
        ReactApplicationContext reactApplicationContext = reactContextHolder.get();
        if (reactApplicationContext == null) {
            throw new IllegalArgumentException("The app context should be created with valid react context.".toString());
        }
        ReactApplicationContext reactApplicationContext2 = reactApplicationContext;
        legacyModuleRegistry.setAppContext(this);
        reactApplicationContext2.addLifecycleEventListener(reactLifecycleDelegate);
        reactApplicationContext2.addActivityEventListener(reactLifecycleDelegate);
        servicesRegistry.register(FilePermissionService.class);
        servicesRegistry.register(AppDirectoriesService.class);
        servicesRegistry.register(modulesProvider.getServices());
        moduleRegistry.register(new NativeModulesProxyModule(), null);
        moduleRegistry.register(new JSLoggerModule(), null);
        moduleRegistry.register(modulesProvider);
        registerInlineModulesList();
        CoreLoggerKt.getLogger().info("✅ AppContext was initialized");
        this.jsLogger = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.jsLogger_delegate$lambda$0(this.f$0);
            }
        });
    }

    @Override // expo.modules.kotlin.types.ConverterContext
    public /* bridge */ void assertMainThread() {
        super.assertMainThread();
    }

    @Override // expo.modules.kotlin.types.ConverterContext
    public /* bridge */ <T extends View> T findView(int i) {
        return (T) super.findView(i);
    }

    public final expo.modules.core.ModuleRegistry getLegacyModuleRegistry() {
        return this.legacyModuleRegistry;
    }

    @Override // expo.modules.kotlin.types.ConverterContext
    public MainRuntime getRuntime() {
        return this.runtime;
    }

    @Override // expo.modules.kotlin.types.ConverterContext
    public Context getApplicationContext() {
        Context reactContext = getReactContext();
        if (reactContext == null) {
            throw new IllegalArgumentException("The app context should be created with valid react context.".toString());
        }
        Context applicationContext = reactContext.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }

    static final WorkletRuntime uiRuntimeHolder$lambda$0(AppContext appContext, WeakReference weakReference) {
        return new WorkletRuntime(appContext, weakReference);
    }

    public final WorkletRuntime getUiRuntime() {
        return this.uiRuntimeHolder.getValue();
    }

    public final CoroutineScope getBackgroundCoroutineScope() {
        return this.backgroundCoroutineScope;
    }

    public final CoroutineScope getModulesQueue() {
        return this.modulesQueue;
    }

    public final CoroutineScope getMainQueue() {
        return this.mainQueue;
    }

    public final ModuleRegistry getRegistry() {
        return this.registry;
    }

    public final ServicesRegistry getServices() {
        return this.services;
    }

    public final WeakReference<NativeModulesProxy> getLegacyModulesProxyHolder$expo_modules_core_release() {
        return this.legacyModulesProxyHolder;
    }

    public final void setLegacyModulesProxyHolder$expo_modules_core_release(WeakReference<NativeModulesProxy> weakReference) {
        this.legacyModulesProxyHolder = weakReference;
    }

    /* JADX INFO: renamed from: getAppContextActivityResultCaller$expo_modules_core_release, reason: from getter */
    public final DefaultAppContextActivityResultCaller getAppContextActivityResultCaller() {
        return this.appContextActivityResultCaller;
    }

    private final void registerInlineModulesList() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        try {
            Object objNewInstance = Class.forName("inline.modules.ExpoInlineModulesList").getConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type expo.modules.kotlin.ModulesProvider");
            this.registry.register((ModulesProvider) objNewInstance);
        } catch (ClassNotFoundException unused) {
        }
    }

    public final void installJSIInterop() {
        getRuntime().install$expo_modules_core_release();
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        if (reactContext != null) {
            ExpoModulesV2Host.INSTANCE.install(reactContext);
        }
    }

    public final /* synthetic */ <Module> Module legacyModule() {
        try {
            expo.modules.core.ModuleRegistry legacyModuleRegistry = getLegacyModuleRegistry();
            Intrinsics.reifiedOperationMarker(4, "Module");
            return (Module) legacyModuleRegistry.getModule(Object.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final /* synthetic */ <T extends Service> T service() {
        Map<Class<? extends Service>, Service> registry = getServices().getRegistry();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Service service = registry.get(Service.class);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) service;
    }

    public final <T extends Service> T service(Class<T> serviceClass) {
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        Service service = this.services.getRegistry().get(serviceClass);
        if (service instanceof Service) {
            return (T) service;
        }
        return null;
    }

    public final File getPersistentFilesDirectory() {
        return getAppDirectories().getPersistentFilesDirectory();
    }

    public final File getCacheDirectory() {
        return getAppDirectories().getCacheDirectory();
    }

    public final Context getReactContext() {
        return getRuntime().getReactContext();
    }

    public final boolean getHasActiveReactInstance() {
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        return reactContext != null && reactContext.hasActiveReactInstance();
    }

    public final OkHttpClient getOkHttpClient() {
        return OkHttpClientProvider.getOkHttpClient();
    }

    public final OkHttpClient.Builder createOkHttpClientBuilder() {
        return OkHttpClientProvider.createClientBuilder();
    }

    public final Logger getJsLogger() {
        return (Logger) this.jsLogger.getValue();
    }

    static final Logger jsLogger_delegate$lambda$0(AppContext appContext) {
        Object next;
        Iterator<T> it = appContext.registry.getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ModuleHolder) next).getModule() instanceof JSLoggerModule));
        ModuleHolder moduleHolder = (ModuleHolder) next;
        Module module = moduleHolder != null ? moduleHolder.getModule() : null;
        if (!(module instanceof JSLoggerModule)) {
            module = null;
        }
        JSLoggerModule jSLoggerModule = (JSLoggerModule) module;
        if (jSLoggerModule != null) {
            return jSLoggerModule.getLogger();
        }
        return null;
    }

    public final void onHostResume$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        if (!(currentActivity instanceof AppCompatActivity)) {
            Activity currentActivity2 = getCurrentActivity();
            throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
        }
        if (this.hostWasDestroyed) {
            this.hostWasDestroyed = false;
            this.registry.registerActivityContracts$expo_modules_core_release();
        }
        this.activityResultsManager.onHostResume((AppCompatActivity) currentActivity);
        this.registry.post(EventName.ACTIVITY_ENTERS_FOREGROUND);
    }

    public final void onHostPause$expo_modules_core_release() {
        this.registry.post(EventName.ACTIVITY_ENTERS_BACKGROUND);
    }

    public final void onUserLeaveHint$expo_modules_core_release() {
        this.registry.post(EventName.ON_USER_LEAVES_ACTIVITY);
    }

    public final void onHostDestroy$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if (!(currentActivity instanceof AppCompatActivity)) {
                Activity currentActivity2 = getCurrentActivity();
                throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
            }
            this.activityResultsManager.onHostDestroy((AppCompatActivity) currentActivity);
        }
        this.registry.post(EventName.ACTIVITY_DESTROYS);
        this.hostWasDestroyed = true;
    }

    public final void onActivityResult$expo_modules_core_release(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityResultsManager.onActivityResult(requestCode, resultCode, data);
        this.registry.post(EventName.ON_ACTIVITY_RESULT, activity, new OnActivityResultPayload(requestCode, resultCode, data));
    }

    public final void onNewIntent$expo_modules_core_release(Intent intent) {
        this.registry.post(EventName.ON_NEW_INTENT, intent);
    }

    @Deprecated(message = "Use RuntimeContext.schedule instead", replaceWith = @ReplaceWith(expression = "runtime.schedule(runnable)", imports = {}))
    public final void executeOnJavaScriptThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        if (reactContext != null) {
            reactContext.runOnJSQueueThread(runnable);
        }
    }

    @Override // expo.modules.kotlin.providers.CurrentActivityProvider
    public Activity getCurrentActivity() {
        Activity currentActivity;
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider != null && (currentActivity = activityProvider.getCurrentActivity()) != null) {
            return currentActivity;
        }
        Context reactContext = getReactContext();
        ReactApplicationContext reactApplicationContext = reactContext instanceof ReactApplicationContext ? (ReactApplicationContext) reactContext : null;
        if (reactApplicationContext != null) {
            return reactApplicationContext.getCurrentActivity();
        }
        return null;
    }

    public final Activity getThrowingActivity() throws Exceptions.MissingActivity {
        Activity currentActivity;
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null) {
            Context reactContext = getReactContext();
            ReactApplicationContext reactApplicationContext = reactContext instanceof ReactApplicationContext ? (ReactApplicationContext) reactContext : null;
            currentActivity = reactApplicationContext != null ? reactApplicationContext.getCurrentActivity() : null;
        }
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    public final void onCreate() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onCreate");
        try {
            getRegistry().postOnCreate();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final FilePermissionService getFilePermission() {
        Service service = getServices().getRegistry().get(FilePermissionService.class);
        if (!(service instanceof FilePermissionService)) {
            service = null;
        }
        FilePermissionService filePermissionService = (FilePermissionService) service;
        if (filePermissionService != null) {
            return filePermissionService;
        }
        throw new IllegalStateException("FilePermissionService is not registered in the ServicesRegistry.");
    }

    private final AppDirectoriesService getAppDirectories() {
        Service service = getServices().getRegistry().get(AppDirectoriesService.class);
        if (!(service instanceof AppDirectoriesService)) {
            service = null;
        }
        AppDirectoriesService appDirectoriesService = (AppDirectoriesService) service;
        if (appDirectoriesService != null) {
            return appDirectoriesService;
        }
        throw new IllegalStateException("AppDirectoriesService is not registered in the ServicesRegistry.");
    }

    public final Permissions getPermissions() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(Permissions.class);
        } catch (Exception unused) {
            module = null;
        }
        return (Permissions) module;
    }

    public final ActivityProvider getActivityProvider() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(ActivityProvider.class);
        } catch (Exception unused) {
            module = null;
        }
        return (ActivityProvider) module;
    }

    public final EventEmitter eventEmitter(Module module) {
        Object module2;
        Intrinsics.checkNotNullParameter(module, "module");
        try {
            module2 = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            module2 = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) module2;
        if (eventEmitter == null) {
            return null;
        }
        ModuleHolder moduleHolder = this.registry.getModuleHolder(module);
        if (moduleHolder != null) {
            return new KModuleEventEmitterWrapper(moduleHolder, eventEmitter, getRuntime().getReactContextHolder());
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(this.registry.getRegistry().keySet(), ", ", null, null, 0, null, null, 62, null);
        throw new IllegalArgumentException(("Cannot create an event emitter for module " + module.getClass() + " that isn't present in the module registry. Available modules: [" + strJoinToString$default + "].").toString());
    }

    public final EventEmitter getCallbackInvoker$expo_modules_core_release() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            module = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) module;
        if (eventEmitter == null) {
            return null;
        }
        return new KEventEmitterWrapper(eventEmitter, getRuntime().getReactContextHolder());
    }

    public final void onDestroy$expo_modules_core_release() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onDestroy");
        try {
            ReactApplicationContext reactContext = getRuntime().getReactContext();
            if (reactContext != null) {
                reactContext.removeLifecycleEventListener(this.reactLifecycleDelegate);
                reactContext.removeActivityEventListener(this.reactLifecycleDelegate);
            }
            ModuleRegistry registry = getRegistry();
            registry.post(EventName.MODULE_DESTROY);
            registry.cleanUp();
            CoroutineScopeKt.cancel(getModulesQueue(), new ContextDestroyedException(null, 1, null));
            CoroutineScopeKt.cancel(getMainQueue(), new ContextDestroyedException(null, 1, null));
            CoroutineScopeKt.cancel(getBackgroundCoroutineScope(), new ContextDestroyedException(null, 1, null));
            ExpoModulesV2Host.INSTANCE.uninstall();
            getRuntime().deallocate$expo_modules_core_release();
            if (this.uiRuntimeHolder.isInitialized()) {
                getUiRuntime().deallocate$expo_modules_core_release();
            }
            CoreLoggerKt.getLogger().info("✅ AppContext was destroyed");
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
