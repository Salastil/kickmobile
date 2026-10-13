package expo.modules.updates;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.ReactHost;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.events.IUpdatesEventManager;
import expo.modules.updates.events.UpdatesEventManager;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.launcher.NoDatabaseLauncher;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.procedures.RecreateReactContextProcedure;
import expo.modules.updates.reloadscreen.ReloadScreenManager;
import expo.modules.updates.statemachine.UpdatesStateMachine;
import expo.modules.updates.statemachine.UpdatesStateValue;
import expo.modules.updatesinterface.UpdatesInterface;
import expo.modules.updatesinterface.UpdatesStateChangeListener;
import expo.modules.updatesinterface.UpdatesStateChangeSubscription;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: DisabledUpdatesController.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0002lmB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010>\u001a\u00020+H\u0016J\u0010\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020\u0006H\u0016J\b\u0010I\u001a\u00020+H\u0016J\b\u0010J\u001a\u00020KH\u0016J\u000e\u0010L\u001a\u00020+H\u0096@¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u00020OH\u0096@¢\u0006\u0002\u0010MJ\u000e\u0010P\u001a\u00020QH\u0096@¢\u0006\u0002\u0010MJ\u000e\u0010R\u001a\u00020SH\u0096@¢\u0006\u0002\u0010MJ \u0010T\u001a\u00020+2\u0006\u0010U\u001a\u00020/2\b\u0010V\u001a\u0004\u0018\u00010/H\u0096@¢\u0006\u0002\u0010WJ\u0012\u0010X\u001a\u00020+2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u001e\u0010[\u001a\u00020+2\u0014\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0018\u00010]H\u0016J\b\u0010^\u001a\u00020+H\u0002J\b\u0010_\u001a\u00020+H\u0016J\u0010\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\u0004\u0018\u00010/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00102\u001a\u0004\u0018\u00010/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00101R\u0016\u00104\u001a\u0004\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R \u00108\u001a\b\u0012\u0004\u0012\u0002090\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010G\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0016\u0010`\u001a\u0004\u0018\u00010/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u00101R\u0016\u0010b\u001a\u0004\u0018\u00010cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\"\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0018\u00010]X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010g¨\u0006n"}, d2 = {"Lexpo/modules/updates/DisabledUpdatesController;", "Lexpo/modules/updates/IUpdatesController;", "Lexpo/modules/updatesinterface/UpdatesInterface;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "fatalException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Landroid/content/Context;Ljava/lang/Exception;)V", "weakActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "controllerScope", "Lkotlinx/coroutines/CoroutineScope;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "eventManager", "Lexpo/modules/updates/events/IUpdatesEventManager;", "getEventManager", "()Lexpo/modules/updates/events/IUpdatesEventManager;", "stateMachine", "Lexpo/modules/updates/statemachine/UpdatesStateMachine;", "isStarted", "", "startupStartTimeMillis", "", "Ljava/lang/Long;", "startupEndTimeMillis", "launchDuration", "Lkotlin/time/Duration;", "getLaunchDuration-FghU774", "()Lkotlin/time/Duration;", "launcher", "Lexpo/modules/updates/launcher/Launcher;", "updatesDirectory", "Ljava/io/File;", "getUpdatesDirectory", "()Ljava/io/File;", "setUpdatesDirectory", "(Ljava/io/File;)V", "loaderTaskFinishedDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "loaderTaskFinishedMutex", "Lkotlinx/coroutines/sync/Mutex;", "launchAssetFile", "", "getLaunchAssetFile", "()Ljava/lang/String;", "bundleAssetName", "getBundleAssetName", "reloadScreenManager", "Lexpo/modules/updates/reloadscreen/ReloadScreenManager;", "getReloadScreenManager", "()Lexpo/modules/updates/reloadscreen/ReloadScreenManager;", "reactHost", "Lcom/facebook/react/ReactHost;", "getReactHost", "()Ljava/lang/ref/WeakReference;", "setReactHost", "(Ljava/lang/ref/WeakReference;)V", "onEventListenerStartObserving", "onDidCreateDevSupportManager", "devSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "onDidCreateReactInstance", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "onReactInstanceException", NotificationsService.EXCEPTION_KEY, "isActiveController", "()Z", ViewProps.START, "getConstantsForModule", "Lexpo/modules/updates/IUpdatesController$UpdatesModuleConstants;", "relaunchReactApplicationForModule", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkForUpdate", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "fetchUpdate", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "getExtraParams", "Landroid/os/Bundle;", "setExtraParam", "key", "value", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUpdateURLAndRequestHeadersOverride", "configOverride", "Lexpo/modules/updates/UpdatesConfigurationOverride;", "setUpdateRequestHeadersOverride", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "", "notifyController", "shutdown", UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, "getRuntimeVersion", UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, "Landroid/net/Uri;", "getUpdateUrl", "()Landroid/net/Uri;", "getRequestHeaders", "()Ljava/util/Map;", "subscribeToUpdatesStateChanges", "Lexpo/modules/updatesinterface/UpdatesStateChangeSubscription;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lexpo/modules/updatesinterface/UpdatesStateChangeListener;", "UpdatesDisabledException", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DisabledUpdatesController implements IUpdatesController, UpdatesInterface {
    private static final String TAG = "DisabledUpdatesController";
    private final Context context;
    private final CoroutineScope controllerScope;
    private final IUpdatesEventManager eventManager;
    private final Exception fatalException;
    private final boolean isActiveController;
    private boolean isStarted;
    private Launcher launcher;
    private final CompletableDeferred<Unit> loaderTaskFinishedDeferred;
    private final Mutex loaderTaskFinishedMutex;
    private final UpdatesLogger logger;
    private WeakReference<ReactHost> reactHost;
    private final Map<String, String> requestHeaders;
    private final String runtimeVersion;
    private Long startupEndTimeMillis;
    private Long startupStartTimeMillis;
    private final UpdatesStateMachine stateMachine;
    private final Uri updateUrl;
    private File updatesDirectory;
    private WeakReference<Activity> weakActivity;

    @Override // expo.modules.updates.IUpdatesController
    public ReloadScreenManager getReloadScreenManager() {
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onReactInstanceException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
    }

    public DisabledUpdatesController(Context context, Exception exc) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.fatalException = exc;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        this.controllerScope = CoroutineScope;
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        UpdatesLogger updatesLogger = new UpdatesLogger(filesDir);
        this.logger = updatesLogger;
        this.eventManager = new UpdatesEventManager(updatesLogger);
        this.stateMachine = new UpdatesStateMachine(updatesLogger, getEventManager(), SetsKt.setOf((Object[]) new UpdatesStateValue[]{UpdatesStateValue.Idle, UpdatesStateValue.Restarting}), CoroutineScope);
        this.loaderTaskFinishedDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.loaderTaskFinishedMutex = MutexKt.Mutex$default(false, 1, null);
        this.reactHost = new WeakReference<>(null);
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public /* bridge */ UUID getEmbeddedUpdateId() {
        return super.getEmbeddedUpdateId();
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public /* bridge */ String getLaunchAssetPath() {
        return super.getLaunchAssetPath();
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public /* bridge */ UUID getLaunchedUpdateId() {
        return super.getLaunchedUpdateId();
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    /* JADX INFO: renamed from: isEnabled */
    public /* bridge */ boolean getIsEnabled() {
        return super.getIsEnabled();
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesEventManager getEventManager() {
        return this.eventManager;
    }

    /* JADX INFO: renamed from: getLaunchDuration-FghU774, reason: not valid java name */
    private final Duration m12136getLaunchDurationFghU774() {
        Long l = this.startupStartTimeMillis;
        if (l != null) {
            long jLongValue = l.longValue();
            Long l2 = this.startupEndTimeMillis;
            if (l2 != null) {
                return Duration.m14062boximpl(DurationKt.toDuration(l2.longValue() - jLongValue, DurationUnit.MILLISECONDS));
            }
        }
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public File getUpdatesDirectory() {
        return this.updatesDirectory;
    }

    public void setUpdatesDirectory(File file) {
        this.updatesDirectory = file;
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getLaunchAssetFile() throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new DisabledUpdatesController$launchAssetFile$1(this, null), 1, null);
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchAssetFile();
        }
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getBundleAssetName() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getBundleAssetName();
        }
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public WeakReference<ReactHost> getReactHost() {
        return this.reactHost;
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setReactHost(WeakReference<ReactHost> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.reactHost = weakReference;
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onEventListenerStartObserving() {
        this.stateMachine.sendContextToJS();
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateReactInstance(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.weakActivity = new WeakReference<>(reactContext.getCurrentActivity());
    }

    @Override // expo.modules.updates.IUpdatesController
    /* JADX INFO: renamed from: isActiveController, reason: from getter */
    public boolean getIsActiveController() {
        return this.isActiveController;
    }

    @Override // expo.modules.updates.IUpdatesController
    public synchronized void start() {
        if (this.isStarted) {
            return;
        }
        this.isStarted = true;
        this.startupStartTimeMillis = Long.valueOf(System.currentTimeMillis());
        this.launcher = new NoDatabaseLauncher(this.context, this.logger, this.fatalException, this.controllerScope);
        this.startupEndTimeMillis = Long.valueOf(System.currentTimeMillis());
        notifyController();
    }

    /* JADX INFO: compiled from: DisabledUpdatesController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/updates/DisabledUpdatesController$UpdatesDisabledException;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", "<init>", "(Ljava/lang/String;)V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class UpdatesDisabledException extends CodedException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdatesDisabledException(String message) {
            super(message, null, 2, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesController.UpdatesModuleConstants getConstantsForModule() {
        UpdateEntity launchedUpdate;
        Map<AssetEntity, String> mapMo12144getLocalAssetFiles;
        Launcher launcher = this.launcher;
        if (launcher != null) {
            launchedUpdate = launcher.getLaunchedUpdate();
            mapMo12144getLocalAssetFiles = null;
        } else {
            launchedUpdate = null;
            mapMo12144getLocalAssetFiles = null;
        }
        Duration durationM12136getLaunchDurationFghU774 = m12136getLaunchDurationFghU774();
        Exception exc = this.fatalException;
        Launcher launcher2 = this.launcher;
        boolean zIsUsingEmbeddedAssets = launcher2 != null ? launcher2.getIsUsingEmbeddedAssets() : false;
        UpdatesConfiguration.CheckAutomaticallyConfiguration checkAutomaticallyConfiguration = UpdatesConfiguration.CheckAutomaticallyConfiguration.NEVER;
        Map mapEmptyMap = MapsKt.emptyMap();
        Launcher launcher3 = this.launcher;
        if (launcher3 != null) {
            mapMo12144getLocalAssetFiles = launcher3.mo12144getLocalAssetFiles();
        }
        return new IUpdatesController.UpdatesModuleConstants(launchedUpdate, durationM12136getLaunchDurationFghU774, null, exc, false, zIsUsingEmbeddedAssets, null, checkAutomaticallyConfiguration, mapEmptyMap, mapMo12144getLocalAssetFiles, false, this.stateMachine.getContext(), null);
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object checkForUpdate(Continuation<? super IUpdatesController.CheckForUpdateResult> continuation) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.checkForUpdateAsync() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object fetchUpdate(Continuation<? super IUpdatesController.FetchUpdateResult> continuation) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.fetchUpdateAsync() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object getExtraParams(Continuation<? super Bundle> continuation) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.getExtraParamsAsync() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object setExtraParam(String str, String str2, Continuation<? super Unit> continuation) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.setExtraParamAsync() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateURLAndRequestHeadersOverride(UpdatesConfigurationOverride configOverride) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.setUpdateURLAndRequestHeadersOverride() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateRequestHeadersOverride(Map<String, String> requestHeaders) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.setUpdateRequestHeadersOverride() is not supported when expo-updates is not enabled.");
    }

    /* JADX INFO: renamed from: expo.modules.updates.DisabledUpdatesController$notifyController$1, reason: invalid class name */
    /* JADX INFO: compiled from: DisabledUpdatesController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.DisabledUpdatesController$notifyController$1", f = "DisabledUpdatesController.kt", i = {0, 0}, l = {224}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {225}, s = {"L$0", "I$0"}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DisabledUpdatesController.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            DisabledUpdatesController disabledUpdatesController;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = DisabledUpdatesController.this.loaderTaskFinishedMutex;
                DisabledUpdatesController disabledUpdatesController2 = DisabledUpdatesController.this;
                this.L$0 = mutex2;
                this.L$1 = disabledUpdatesController2;
                this.I$0 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                disabledUpdatesController = disabledUpdatesController2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                disabledUpdatesController = (DisabledUpdatesController) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                if (!disabledUpdatesController.loaderTaskFinishedDeferred.isCompleted()) {
                    if (disabledUpdatesController.launcher != null) {
                        disabledUpdatesController.loaderTaskFinishedDeferred.complete(Unit.INSTANCE);
                    } else {
                        throw new AssertionError("UpdatesController.notifyController was called with a null launcher, which is an error. This method should only be called when an update is ready to launch.");
                    }
                }
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    private final synchronized void notifyController() {
        BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void shutdown() {
        CoroutineScopeKt.cancel$default(this.controllerScope, null, 1, null);
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public String getRuntimeVersion() {
        return this.runtimeVersion;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public Uri getUpdateUrl() {
        return this.updateUrl;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public UpdatesStateChangeSubscription subscribeToUpdatesStateChanges(UpdatesStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new DisabledUpdatesStateChangeSubscription();
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object relaunchReactApplicationForModule(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        this.stateMachine.queueExecution(new RecreateReactContextProcedure(this.context, this.weakActivity, new Launcher.LauncherCallback() { // from class: expo.modules.updates.DisabledUpdatesController$relaunchReactApplicationForModule$2$procedure$1
            @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
            public void onFailure(Exception e) {
                UnexpectedException unexpectedException;
                Intrinsics.checkNotNullParameter(e, "e");
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                Exception exc = e;
                if (exc instanceof CodedException) {
                    unexpectedException = (CodedException) exc;
                } else if (exc instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) exc;
                    unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                } else {
                    unexpectedException = new UnexpectedException(exc);
                }
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(unexpectedException)));
            }

            @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
            public void onSuccess() {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m12684constructorimpl(Unit.INSTANCE));
            }
        }, this.controllerScope));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
