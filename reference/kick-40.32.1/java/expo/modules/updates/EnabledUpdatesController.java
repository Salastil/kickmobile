package expo.modules.updates;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.ReactHost;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.easclient.EASClientID;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.events.IUpdatesEventManager;
import expo.modules.updates.events.UpdatesEventManager;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.logging.UpdatesLogReader;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.EmbeddedManifestUtils;
import expo.modules.updates.manifest.EmbeddedUpdate;
import expo.modules.updates.procedures.CheckForUpdateProcedure;
import expo.modules.updates.procedures.FetchUpdateProcedure;
import expo.modules.updates.procedures.RelaunchProcedure;
import expo.modules.updates.procedures.StartupProcedure;
import expo.modules.updates.reloadscreen.ReloadScreenManager;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.selectionpolicy.SelectionPolicyFactory;
import expo.modules.updates.statemachine.UpdatesStateMachine;
import expo.modules.updates.statemachine.UpdatesStateValue;
import expo.modules.updatesinterface.UpdatesInterface;
import expo.modules.updatesinterface.UpdatesNativeInterfaceStateContext;
import expo.modules.updatesinterface.UpdatesStateChangeListener;
import expo.modules.updatesinterface.UpdatesStateChangeSubscription;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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

/* JADX INFO: compiled from: EnabledUpdatesController.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u0002:\u0002\u0095\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u00109\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\b\u0010W\u001a\u00020&H\u0016J\u0010\u0010X\u001a\u00020&2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020]H\u0016J\u0014\u0010^\u001a\u00020&2\n\u0010_\u001a\u00060`j\u0002`aH\u0016J\b\u0010c\u001a\u00020&H\u0016J\u0018\u0010d\u001a\u00020&2\u0006\u0010e\u001a\u00020;2\u0006\u0010f\u001a\u00020gH\u0002J\n\u0010h\u001a\u0004\u0018\u00010EH\u0002J\b\u0010i\u001a\u00020jH\u0016J\u000e\u0010k\u001a\u00020&H\u0096@¢\u0006\u0002\u0010lJ\u000e\u0010m\u001a\u00020nH\u0096@¢\u0006\u0002\u0010lJ\u000e\u0010o\u001a\u00020pH\u0096@¢\u0006\u0002\u0010lJ\u000e\u0010q\u001a\u00020rH\u0096@¢\u0006\u0002\u0010lJ \u0010s\u001a\u00020&2\u0006\u0010t\u001a\u0002052\b\u0010u\u001a\u0004\u0018\u000105H\u0096@¢\u0006\u0002\u0010vJ\b\u0010w\u001a\u00020&H\u0016J\u0012\u0010x\u001a\u00020&2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J\u001e\u0010{\u001a\u00020&2\u0014\u0010|\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0018\u00010OH\u0016J\u0013\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u000206H\u0016J\u0010\u0010\u008f\u0001\u001a\u00020&2\u0007\u0010\u0090\u0001\u001a\u000205J\u0010\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0000¢\u0006\u0003\b\u0093\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R \u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u0012\u0010@\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\"\u0010N\u001a\u0010\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u000205\u0018\u00010O8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u00108R\u0016\u0010R\u001a\u0004\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010U\u001a\u0004\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010b\u001a\u00020;X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bb\u0010MR\u0016\u0010}\u001a\u0004\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b~\u0010TR\u0019\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R#\u0010|\u001a\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0018\u00010O8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u00108R\u001a\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001a\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u0087\u0001R\u0018\u0010\u008a\u0001\u001a\u0004\u0018\u0001058VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010TR\u0016\u0010\u0094\u0001\u001a\u00020;X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010M¨\u0006\u0096\u0001"}, d2 = {"Lexpo/modules/updates/EnabledUpdatesController;", "Lexpo/modules/updates/IUpdatesController;", "Lexpo/modules/updatesinterface/UpdatesInterface;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "updatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "updatesDirectory", "Ljava/io/File;", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Ljava/io/File;)V", "getUpdatesDirectory", "()Ljava/io/File;", "weakActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "eventManager", "Lexpo/modules/updates/events/IUpdatesEventManager;", "getEventManager", "()Lexpo/modules/updates/events/IUpdatesEventManager;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "getSelectionPolicy", "()Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "controllerScope", "Lkotlinx/coroutines/CoroutineScope;", "stateMachine", "Lexpo/modules/updates/statemachine/UpdatesStateMachine;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "getFileDownloader", "()Lexpo/modules/updates/loader/FileDownloader;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "startupFinishedDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "startupFinishedMutex", "Lkotlinx/coroutines/sync/Mutex;", "reloadScreenManager", "Lexpo/modules/updates/reloadscreen/ReloadScreenManager;", "getReloadScreenManager", "()Lexpo/modules/updates/reloadscreen/ReloadScreenManager;", "reactHost", "Lcom/facebook/react/ReactHost;", "getReactHost", "()Ljava/lang/ref/WeakReference;", "setReactHost", "(Ljava/lang/ref/WeakReference;)V", "stateChangeListenerMap", "", "", "Lexpo/modules/updatesinterface/UpdatesStateChangeListener;", "getStateChangeListenerMap$expo_updates_release", "()Ljava/util/Map;", "purgeUpdatesLogsOlderThanOneDay", "isStarted", "", "isStartupFinished", "startupStartTimeMillis", "", "Ljava/lang/Long;", "startupEndTimeMillis", "onStartupProcedureFinished", "startupProcedure", "Lexpo/modules/updates/procedures/StartupProcedure;", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "getLaunchedUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "launchDuration", "Lkotlin/time/Duration;", "getLaunchDuration-FghU774", "()Lkotlin/time/Duration;", "isUsingEmbeddedAssets", "()Z", "localAssetFiles", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "getLocalAssetFiles", "launchAssetFile", "getLaunchAssetFile", "()Ljava/lang/String;", "bundleAssetName", "getBundleAssetName", "onEventListenerStartObserving", "onDidCreateDevSupportManager", "devSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "onDidCreateReactInstance", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "onReactInstanceException", NotificationsService.EXCEPTION_KEY, "Ljava/lang/Exception;", "Lkotlin/Exception;", "isActiveController", ViewProps.START, "relaunchReactApplication", "shouldRunReaper", "callback", "Lexpo/modules/updates/launcher/Launcher$LauncherCallback;", "getEmbeddedUpdate", "getConstantsForModule", "Lexpo/modules/updates/IUpdatesController$UpdatesModuleConstants;", "relaunchReactApplicationForModule", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkForUpdate", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "fetchUpdate", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "getExtraParams", "Landroid/os/Bundle;", "setExtraParam", "key", "value", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "setUpdateURLAndRequestHeadersOverride", "configOverride", "Lexpo/modules/updates/UpdatesConfigurationOverride;", "setUpdateRequestHeadersOverride", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, "getRuntimeVersion", UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, "Landroid/net/Uri;", "getUpdateUrl", "()Landroid/net/Uri;", "getRequestHeaders", "launchedUpdateId", "Ljava/util/UUID;", "getLaunchedUpdateId", "()Ljava/util/UUID;", "embeddedUpdateId", "getEmbeddedUpdateId", "launchAssetPath", "getLaunchAssetPath", "subscribeToUpdatesStateChanges", "Lexpo/modules/updatesinterface/UpdatesStateChangeSubscription;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unsubscribeFromUpdatesStateChanges", "subscriptionId", "getNativeInterfaceContext", "Lexpo/modules/updatesinterface/UpdatesNativeInterfaceStateContext;", "getNativeInterfaceContext$expo_updates_release", "isEnabled", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnabledUpdatesController implements IUpdatesController, UpdatesInterface {
    private static final String TAG = "EnabledUpdatesController";
    private final Context context;
    private final CoroutineScope controllerScope;
    private final UpdatesDatabase database;
    private final IUpdatesEventManager eventManager;
    private final boolean isActiveController;
    private final boolean isEnabled;
    private boolean isStarted;
    private boolean isStartupFinished;
    private final UpdatesLogger logger;
    private WeakReference<ReactHost> reactHost;
    private final ReloadScreenManager reloadScreenManager;
    private Long startupEndTimeMillis;
    private final CompletableDeferred<Unit> startupFinishedDeferred;
    private final Mutex startupFinishedMutex;
    private final StartupProcedure startupProcedure;
    private Long startupStartTimeMillis;
    private final Map<String, UpdatesStateChangeListener> stateChangeListenerMap;
    private final UpdatesStateMachine stateMachine;
    private UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;
    private WeakReference<Activity> weakActivity;

    public EnabledUpdatesController(Context context, UpdatesConfiguration updatesConfiguration, File updatesDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        this.context = context;
        this.updatesConfiguration = updatesConfiguration;
        this.updatesDirectory = updatesDirectory;
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        UpdatesLogger updatesLogger = new UpdatesLogger(filesDir);
        this.logger = updatesLogger;
        this.eventManager = new UpdatesEventManager(updatesLogger);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        this.controllerScope = CoroutineScope;
        this.stateMachine = new UpdatesStateMachine(updatesLogger, getEventManager(), CollectionsKt.toSet(UpdatesStateValue.getEntries()), CoroutineScope);
        UpdatesDatabase companion = UpdatesDatabase.INSTANCE.getInstance(context, Dispatchers.getIO());
        this.database = companion;
        this.startupFinishedDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.startupFinishedMutex = MutexKt.Mutex$default(false, 1, null);
        this.reloadScreenManager = new ReloadScreenManager();
        this.reactHost = new WeakReference<>(null);
        this.stateChangeListenerMap = new LinkedHashMap();
        this.startupProcedure = new StartupProcedure(context, this.updatesConfiguration, companion, getUpdatesDirectory(), getFileDownloader(), getSelectionPolicy(), updatesLogger, new StartupProcedure.StartupProcedureCallback() { // from class: expo.modules.updates.EnabledUpdatesController$startupProcedure$1
            @Override // expo.modules.updates.procedures.StartupProcedure.StartupProcedureCallback
            public void onFinished() {
                this.this$0.onStartupProcedureFinished();
            }

            @Override // expo.modules.updates.procedures.StartupProcedure.StartupProcedureCallback
            public void onRequestRelaunch(boolean shouldRunReaper, Launcher.LauncherCallback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                this.this$0.relaunchReactApplication(shouldRunReaper, callback);
            }
        }, CoroutineScope);
        this.isActiveController = true;
        this.isEnabled = true;
    }

    @Override // expo.modules.updates.IUpdatesController
    public File getUpdatesDirectory() {
        return this.updatesDirectory;
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesEventManager getEventManager() {
        return this.eventManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectionPolicy getSelectionPolicy() {
        return SelectionPolicyFactory.createFilterAwarePolicy(this.updatesConfiguration.getRuntimeVersion(), this.updatesConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileDownloader getFileDownloader() {
        File filesDir = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        String string = new EASClientID(this.context).getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new FileDownloader(filesDir, string, this.updatesConfiguration, this.logger, this.database);
    }

    @Override // expo.modules.updates.IUpdatesController
    public ReloadScreenManager getReloadScreenManager() {
        return this.reloadScreenManager;
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

    public final Map<String, UpdatesStateChangeListener> getStateChangeListenerMap$expo_updates_release() {
        return this.stateChangeListenerMap;
    }

    private final void purgeUpdatesLogsOlderThanOneDay() {
        File filesDir = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        UpdatesLogReader.purgeLogEntries$default(new UpdatesLogReader(filesDir), null, new Function1() { // from class: expo.modules.updates.EnabledUpdatesController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnabledUpdatesController.purgeUpdatesLogsOlderThanOneDay$lambda$0((Exception) obj);
            }
        }, 1, null);
    }

    static final Unit purgeUpdatesLogsOlderThanOneDay$lambda$0(Exception exc) {
        if (exc != null) {
            Log.e("expo-updates", "UpdatesLogReader: error in purgeLogEntries", exc);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: expo.modules.updates.EnabledUpdatesController$onStartupProcedureFinished$1, reason: invalid class name */
    /* JADX INFO: compiled from: EnabledUpdatesController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.EnabledUpdatesController$onStartupProcedureFinished$1", f = "EnabledUpdatesController.kt", i = {0, 0}, l = {387}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {388}, s = {"L$0", "I$0"}, v = 2)
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
            return EnabledUpdatesController.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            EnabledUpdatesController enabledUpdatesController;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = EnabledUpdatesController.this.startupFinishedMutex;
                EnabledUpdatesController enabledUpdatesController2 = EnabledUpdatesController.this;
                this.L$0 = mutex2;
                this.L$1 = enabledUpdatesController2;
                this.I$0 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                enabledUpdatesController = enabledUpdatesController2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                enabledUpdatesController = (EnabledUpdatesController) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                if (!enabledUpdatesController.startupFinishedDeferred.isCompleted()) {
                    enabledUpdatesController.startupFinishedDeferred.complete(Unit.INSTANCE);
                }
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onStartupProcedureFinished() {
        BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new AnonymousClass1(null), 3, null);
        this.isStartupFinished = true;
        this.startupEndTimeMillis = Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdateEntity getLaunchedUpdate() {
        return this.startupProcedure.getLaunchedUpdate();
    }

    /* JADX INFO: renamed from: getLaunchDuration-FghU774, reason: not valid java name */
    private final Duration m12137getLaunchDurationFghU774() {
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

    private final boolean isUsingEmbeddedAssets() {
        return this.startupProcedure.isUsingEmbeddedAssets();
    }

    private final Map<AssetEntity, String> getLocalAssetFiles() {
        return this.startupProcedure.getLocalAssetFiles();
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getLaunchAssetFile() throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new EnabledUpdatesController$launchAssetFile$1(this, null), 1, null);
        return this.startupProcedure.getLaunchAssetFile();
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getBundleAssetName() {
        return this.startupProcedure.getBundleAssetName();
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onEventListenerStartObserving() {
        this.stateMachine.sendContextToJS();
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.startupProcedure.onDidCreateDevSupportManager(devSupportManager);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateReactInstance(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.weakActivity = new WeakReference<>(reactContext.getCurrentActivity());
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onReactInstanceException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.startupProcedure.onReactInstanceException(exception);
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
        purgeUpdatesLogsOlderThanOneDay();
        this.stateMachine.queueExecution(this.startupProcedure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void relaunchReactApplication(boolean shouldRunReaper, Launcher.LauncherCallback callback) {
        this.stateMachine.queueExecution(new RelaunchProcedure(this.context, this.weakActivity, this.updatesConfiguration, this.logger, this.database, getUpdatesDirectory(), getFileDownloader(), getSelectionPolicy(), new Function0() { // from class: expo.modules.updates.EnabledUpdatesController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnabledUpdatesController.relaunchReactApplication$lambda$0(this.f$0);
            }
        }, new Function1() { // from class: expo.modules.updates.EnabledUpdatesController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnabledUpdatesController.relaunchReactApplication$lambda$1(this.f$0, (Launcher) obj);
            }
        }, shouldRunReaper, getReloadScreenManager(), callback, this.controllerScope));
    }

    static final Launcher relaunchReactApplication$lambda$0(EnabledUpdatesController enabledUpdatesController) {
        Launcher launcher = enabledUpdatesController.startupProcedure.getLauncher();
        Intrinsics.checkNotNull(launcher);
        return launcher;
    }

    static final Unit relaunchReactApplication$lambda$1(EnabledUpdatesController enabledUpdatesController, Launcher currentLauncher) {
        Intrinsics.checkNotNullParameter(currentLauncher, "currentLauncher");
        enabledUpdatesController.startupProcedure.setLauncher(currentLauncher);
        return Unit.INSTANCE;
    }

    private final UpdateEntity getEmbeddedUpdate() {
        EmbeddedUpdate embeddedUpdate = EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(this.context, this.updatesConfiguration);
        if (embeddedUpdate != null) {
            return embeddedUpdate.getUpdateEntity();
        }
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesController.UpdatesModuleConstants getConstantsForModule() {
        return new IUpdatesController.UpdatesModuleConstants(getLaunchedUpdate(), m12137getLaunchDurationFghU774(), getEmbeddedUpdate(), this.startupProcedure.getEmergencyLaunchException(), true, isUsingEmbeddedAssets(), this.updatesConfiguration.getRuntimeVersionRaw(), this.updatesConfiguration.getCheckOnLaunch(), this.updatesConfiguration.getRequestHeaders(), getLocalAssetFiles(), false, this.stateMachine.getContext(), null);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void shutdown() {
        CoroutineScopeKt.cancel$default(this.controllerScope, null, 1, null);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateURLAndRequestHeadersOverride(UpdatesConfigurationOverride configOverride) throws CodedException {
        if (!this.updatesConfiguration.getDisableAntiBrickingMeasures()) {
            throw new CodedException("ERR_UPDATES_RUNTIME_OVERRIDE", "Must set disableAntiBrickingMeasures configuration to use updates overriding", null);
        }
        UpdatesConfigurationOverride.INSTANCE.save$expo_updates_release(this.context, configOverride);
        this.updatesConfiguration = UpdatesConfiguration.INSTANCE.create(this.context, this.updatesConfiguration, configOverride);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateRequestHeadersOverride(Map<String, String> requestHeaders) throws CodedException {
        if (!UpdatesConfiguration.INSTANCE.isValidRequestHeadersOverride$expo_updates_release(this.updatesConfiguration.getOriginalEmbeddedRequestHeaders(), requestHeaders)) {
            throw new CodedException("ERR_UPDATES_RUNTIME_OVERRIDE", "Invalid update requestHeaders override: " + requestHeaders + ". Override keys must be declared in `updates.requestHeaders` in your app config at build time. Add the key to `updates.requestHeaders` and rebuild the app.", null);
        }
        this.updatesConfiguration = UpdatesConfiguration.INSTANCE.create(this.context, this.updatesConfiguration, UpdatesConfigurationOverride.INSTANCE.saveRequestHeaders$expo_updates_release(this.context, requestHeaders));
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public String getRuntimeVersion() {
        return this.updatesConfiguration.getRuntimeVersionRaw();
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public Uri getUpdateUrl() {
        return this.updatesConfiguration.getUpdateUrl();
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public Map<String, String> getRequestHeaders() {
        return this.updatesConfiguration.getRequestHeaders();
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public UUID getLaunchedUpdateId() {
        UpdateEntity launchedUpdate = this.startupProcedure.getLaunchedUpdate();
        if (launchedUpdate != null) {
            return launchedUpdate.getId();
        }
        return null;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public UUID getEmbeddedUpdateId() {
        UpdateEntity embeddedUpdate = getEmbeddedUpdate();
        if (embeddedUpdate != null) {
            return embeddedUpdate.getId();
        }
        return null;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public String getLaunchAssetPath() {
        return this.startupProcedure.getLaunchAssetFile();
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public UpdatesStateChangeSubscription subscribeToUpdatesStateChanges(UpdatesStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.stateChangeListenerMap.put(string, listener);
        return new EnabledUpdatesStateChangeSubscription(string);
    }

    public final void unsubscribeFromUpdatesStateChanges(String subscriptionId) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        if (this.stateChangeListenerMap.containsKey(subscriptionId)) {
            this.stateChangeListenerMap.remove(subscriptionId);
        }
    }

    public final UpdatesNativeInterfaceStateContext getNativeInterfaceContext$expo_updates_release() {
        return this.stateMachine.getContext().getNativeInterfaceContext();
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public boolean getIsEnabled() {
        return this.isEnabled;
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object relaunchReactApplicationForModule(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (getLaunchedUpdate() != null) {
            relaunchReactApplication(true, new Launcher.LauncherCallback() { // from class: expo.modules.updates.EnabledUpdatesController$relaunchReactApplicationForModule$2$2
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
            });
        } else {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(new CodedException() { // from class: expo.modules.updates.EnabledUpdatesController$relaunchReactApplicationForModule$2$1
            })));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object checkForUpdate(Continuation<? super IUpdatesController.CheckForUpdateResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        this.stateMachine.queueExecution(new CheckForUpdateProcedure(this.context, this.updatesConfiguration, this.database, this.logger, getFileDownloader(), getSelectionPolicy(), getLaunchedUpdate(), new Function1<IUpdatesController.CheckForUpdateResult, Unit>() { // from class: expo.modules.updates.EnabledUpdatesController$checkForUpdate$2$procedure$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IUpdatesController.CheckForUpdateResult checkForUpdateResult) {
                invoke2(checkForUpdateResult);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IUpdatesController.CheckForUpdateResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuation<IUpdatesController.CheckForUpdateResult> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m12684constructorimpl(it));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object fetchUpdate(Continuation<? super IUpdatesController.FetchUpdateResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        this.stateMachine.queueExecution(new FetchUpdateProcedure(this.context, this.updatesConfiguration, this.logger, this.database, getUpdatesDirectory(), getFileDownloader(), getSelectionPolicy(), getLaunchedUpdate(), this.controllerScope, new Function1<IUpdatesController.FetchUpdateResult, Unit>() { // from class: expo.modules.updates.EnabledUpdatesController$fetchUpdate$2$procedure$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IUpdatesController.FetchUpdateResult fetchUpdateResult) {
                invoke2(fetchUpdateResult);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IUpdatesController.FetchUpdateResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuation<IUpdatesController.FetchUpdateResult> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m12684constructorimpl(it));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object getExtraParams(Continuation<? super Bundle> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new EnabledUpdatesController$getExtraParams$2$1(this, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object setExtraParam(String str, String str2, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new EnabledUpdatesController$setExtraParam$2$1(this, str, str2, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
