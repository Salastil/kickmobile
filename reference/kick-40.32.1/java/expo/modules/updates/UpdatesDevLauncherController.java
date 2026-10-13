package expo.modules.updates;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.ReactHost;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.easclient.EASClientID;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.updates.db.Reaper;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.events.NoOpUpdatesEventManager;
import expo.modules.updates.launcher.DatabaseLauncher;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.Loader;
import expo.modules.updates.loader.RemoteLoader;
import expo.modules.updates.loader.UpdateDirective;
import expo.modules.updates.loader.UpdateResponse;
import expo.modules.updates.loader.UpdateResponsePart;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.reloadscreen.ReloadScreenManager;
import expo.modules.updates.selectionpolicy.LauncherSelectionPolicyDevelopmentClient;
import expo.modules.updates.selectionpolicy.LauncherSelectionPolicySingleUpdate;
import expo.modules.updates.selectionpolicy.LoaderSelectionPolicyDevelopmentClient;
import expo.modules.updates.selectionpolicy.ReaperSelectionPolicyDevelopmentClient;
import expo.modules.updates.selectionpolicy.ReaperSelectionPolicyFilterAware;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.statemachine.UpdatesStateContext;
import expo.modules.updatesinterface.UpdatesDevLauncherInterface;
import expo.modules.updatesinterface.UpdatesInterfaceCallbacks;
import expo.modules.updatesinterface.UpdatesStateChangeListener;
import expo.modules.updatesinterface.UpdatesStateChangeSubscription;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpdatesDevLauncherController.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0087\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010+\u001a\u00020,2\b\u0010(\u001a\u0004\u0018\u00010&H\u0002J\b\u0010-\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020,2\u0006\u0010(\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020,H\u0016J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020\nH\u0016J\b\u0010I\u001a\u00020,H\u0016J\b\u0010V\u001a\u00020,H\u0016J\u0010\u0010W\u001a\u00020,2\u0006\u0010U\u001a\u00020GH\u0016J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0016J4\u0010d\u001a\u00020,2\"\u0010e\u001a\u001e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020g0fj\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020g`h2\u0006\u0010i\u001a\u00020jH\u0016J,\u0010k\u001a\u00020G2\"\u0010e\u001a\u001e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020g0fj\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020g`hH\u0016J,\u0010l\u001a\u00020\u00062\"\u0010e\u001a\u001e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020g0fj\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020g`hH\u0002J\b\u0010m\u001a\u00020,H\u0002J.\u0010n\u001a\u00020,2\u0006\u0010o\u001a\u00020K2\u0006\u0010e\u001a\u00020\u00062\u0006\u0010p\u001a\u00020q2\u0006\u0010i\u001a\u00020jH\u0082@¢\u0006\u0002\u0010rJ\b\u0010s\u001a\u00020,H\u0002J\b\u0010t\u001a\u00020uH\u0016J\u000e\u0010v\u001a\u00020,H\u0096@¢\u0006\u0002\u0010wJ\u000e\u0010x\u001a\u00020yH\u0096@¢\u0006\u0002\u0010wJ\u000e\u0010z\u001a\u00020{H\u0096@¢\u0006\u0002\u0010wJ\u000e\u0010|\u001a\u00020}H\u0096@¢\u0006\u0002\u0010wJ\"\u0010~\u001a\u00020,2\u0006\u0010\u007f\u001a\u0002002\t\u0010\u0080\u0001\u001a\u0004\u0018\u000100H\u0096@¢\u0006\u0003\u0010\u0081\u0001J\u0015\u0010\u0082\u0001\u001a\u00020,2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\u001f\u0010\u0085\u0001\u001a\u00020,2\u0014\u0010^\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000200\u0018\u00010OH\u0016J\t\u0010\u0086\u0001\u001a\u00020,H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u0004\u0018\u0001008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00102R\u0014\u00105\u001a\u000206X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R \u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR\u0014\u0010F\u001a\u00020GX\u0096D¢\u0006\b\n\u0000\u001a\u0004\bF\u0010HR\u0013\u0010J\u001a\u0004\u0018\u00010K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\"\u0010N\u001a\u0010\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u000200\u0018\u00010O8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0012\u0010S\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0004\n\u0002\u0010TR\u0014\u0010U\u001a\u00020G8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010HR\u0016\u0010X\u001a\u0004\u0018\u0001008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u00102R\u0016\u0010Z\u001a\u0004\u0018\u00010[8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\"\u0010^\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000200\u0018\u00010O8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010R¨\u0006\u0088\u0001"}, d2 = {"Lexpo/modules/updates/UpdatesDevLauncherController;", "Lexpo/modules/updates/IUpdatesController;", "Lexpo/modules/updatesinterface/UpdatesDevLauncherInterface;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "initialUpdatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "updatesDirectory", "Ljava/io/File;", "updatesDirectoryException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Ljava/io/File;Ljava/lang/Exception;)V", "getUpdatesDirectory", "()Ljava/io/File;", "eventManager", "Lexpo/modules/updates/events/NoOpUpdatesEventManager;", "getEventManager", "()Lexpo/modules/updates/events/NoOpUpdatesEventManager;", "updatesInterfaceCallbacks", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/updatesinterface/UpdatesInterfaceCallbacks;", "getUpdatesInterfaceCallbacks", "()Ljava/lang/ref/WeakReference;", "setUpdatesInterfaceCallbacks", "(Ljava/lang/ref/WeakReference;)V", "launcher", "Lexpo/modules/updates/launcher/Launcher;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "previousUpdatesConfiguration", "updatesConfiguration", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "controllerScope", "Lkotlinx/coroutines/CoroutineScope;", "mSelectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "defaultSelectionPolicy", "selectionPolicy", "getSelectionPolicy", "()Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "setNextSelectionPolicy", "", "resetSelectionPolicyToDefault", "setDefaultSelectionPolicy", "launchAssetFile", "", "getLaunchAssetFile", "()Ljava/lang/String;", "bundleAssetName", "getBundleAssetName", "reloadScreenManager", "Lexpo/modules/updates/reloadscreen/ReloadScreenManager;", "getReloadScreenManager", "()Lexpo/modules/updates/reloadscreen/ReloadScreenManager;", "reactHost", "Lcom/facebook/react/ReactHost;", "getReactHost", "setReactHost", "onEventListenerStartObserving", "onDidCreateDevSupportManager", "devSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "onDidCreateReactInstance", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "onReactInstanceException", NotificationsService.EXCEPTION_KEY, "isActiveController", "", "()Z", ViewProps.START, "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "getLaunchedUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "localAssetFiles", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "getLocalAssetFiles", "()Ljava/util/Map;", "_isUsingEmbeddedAssetsOverride", "Ljava/lang/Boolean;", "isUsingEmbeddedAssets", "reset", "setIsUsingEmbeddedAssets", UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, "getRuntimeVersion", UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, "Landroid/net/Uri;", "getUpdateUrl", "()Landroid/net/Uri;", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "getRequestHeaders", "subscribeToUpdatesStateChanges", "Lexpo/modules/updatesinterface/UpdatesStateChangeSubscription;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lexpo/modules/updatesinterface/UpdatesStateChangeListener;", "fetchUpdateWithConfiguration", "configuration", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "callback", "Lexpo/modules/updatesinterface/UpdatesDevLauncherInterface$UpdateCallback;", "isValidUpdatesConfiguration", "createUpdatesConfiguration", "setDevelopmentSelectionPolicy", "launchUpdate", "update", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "(Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/loader/FileDownloader;Lexpo/modules/updatesinterface/UpdatesDevLauncherInterface$UpdateCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runReaper", "getConstantsForModule", "Lexpo/modules/updates/IUpdatesController$UpdatesModuleConstants;", "relaunchReactApplicationForModule", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkForUpdate", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "fetchUpdate", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "getExtraParams", "Landroid/os/Bundle;", "setExtraParam", "key", "value", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUpdateURLAndRequestHeadersOverride", "configOverride", "Lexpo/modules/updates/UpdatesConfigurationOverride;", "setUpdateRequestHeadersOverride", "shutdown", "NotAvailableInDevClientException", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesDevLauncherController implements IUpdatesController, UpdatesDevLauncherInterface {
    private Boolean _isUsingEmbeddedAssetsOverride;
    private final Context context;
    private final CoroutineScope controllerScope;
    private final UpdatesDatabase database;
    private SelectionPolicy defaultSelectionPolicy;
    private final NoOpUpdatesEventManager eventManager;
    private final boolean isActiveController;
    private Launcher launcher;
    private final UpdatesLogger logger;
    private SelectionPolicy mSelectionPolicy;
    private UpdatesConfiguration previousUpdatesConfiguration;
    private WeakReference<ReactHost> reactHost;
    private final ReloadScreenManager reloadScreenManager;
    private UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;
    private final Exception updatesDirectoryException;
    private WeakReference<UpdatesInterfaceCallbacks> updatesInterfaceCallbacks;

    /* JADX INFO: compiled from: UpdatesDevLauncherController.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpdatesConfigurationValidationResult.values().length];
            try {
                iArr[UpdatesConfigurationValidationResult.VALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_NOT_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_MISSING_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_MISSING_RUNTIME_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.UpdatesDevLauncherController$launchUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UpdatesDevLauncherController.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.UpdatesDevLauncherController", f = "UpdatesDevLauncherController.kt", i = {0, 0, 0, 0, 0, 0}, l = {TypedValues.Attributes.TYPE_EASING}, m = "launchUpdate", n = {"update", "configuration", "fileDownloader", "callback", "currentSelectionPolicy", "launcher"}, nl = {TypedValues.Attributes.TYPE_PIVOT_TARGET}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C09281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C09281(Continuation<? super C09281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdatesDevLauncherController.this.launchUpdate(null, null, null, null, this);
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateReactInstance(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onEventListenerStartObserving() {
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onReactInstanceException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void start() {
    }

    public UpdatesDevLauncherController(Context context, UpdatesConfiguration updatesConfiguration, File file, Exception exc) {
        String runtimeVersion;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.updatesDirectory = file;
        this.updatesDirectoryException = exc;
        this.eventManager = new NoOpUpdatesEventManager();
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        this.logger = new UpdatesLogger(filesDir);
        this.updatesConfiguration = updatesConfiguration;
        this.database = UpdatesDatabase.INSTANCE.getInstance(context, Dispatchers.getIO());
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i = 1;
        this.controllerScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        this.defaultSelectionPolicy = new SelectionPolicy(new LauncherSelectionPolicyDevelopmentClient((updatesConfiguration == null || (runtimeVersion = updatesConfiguration.getRuntimeVersion()) == null) ? "1" : runtimeVersion, updatesConfiguration), new LoaderSelectionPolicyDevelopmentClient(updatesConfiguration), new ReaperSelectionPolicyFilterAware(0, i, defaultConstructorMarker));
        this.reloadScreenManager = new ReloadScreenManager();
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
    public File getUpdatesDirectory() {
        return this.updatesDirectory;
    }

    @Override // expo.modules.updates.IUpdatesController
    public NoOpUpdatesEventManager getEventManager() {
        return this.eventManager;
    }

    @Override // expo.modules.updatesinterface.UpdatesDevLauncherInterface
    public WeakReference<UpdatesInterfaceCallbacks> getUpdatesInterfaceCallbacks() {
        return this.updatesInterfaceCallbacks;
    }

    @Override // expo.modules.updatesinterface.UpdatesDevLauncherInterface
    public void setUpdatesInterfaceCallbacks(WeakReference<UpdatesInterfaceCallbacks> weakReference) {
        this.updatesInterfaceCallbacks = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectionPolicy getSelectionPolicy() {
        SelectionPolicy selectionPolicy = this.mSelectionPolicy;
        return selectionPolicy == null ? this.defaultSelectionPolicy : selectionPolicy;
    }

    private final void setNextSelectionPolicy(SelectionPolicy selectionPolicy) {
        this.mSelectionPolicy = selectionPolicy;
    }

    private final void resetSelectionPolicyToDefault() {
        this.mSelectionPolicy = null;
    }

    private final void setDefaultSelectionPolicy(SelectionPolicy selectionPolicy) {
        this.defaultSelectionPolicy = selectionPolicy;
    }

    @Override // expo.modules.updates.IUpdatesController
    public synchronized String getLaunchAssetFile() {
        UpdatesLogger.warn$default(this.logger, "launchAssetFile should not be called from expo-dev-client build, except for Detox testing", null, 2, null);
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getBundleAssetName() throws Exception {
        throw new Exception("IUpdatesController.bundleAssetName should not be called in dev client");
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

    @Override // expo.modules.updates.IUpdatesController
    /* JADX INFO: renamed from: isActiveController, reason: from getter */
    public boolean getIsActiveController() {
        return this.isActiveController;
    }

    public final UpdateEntity getLaunchedUpdate() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchedUpdate();
        }
        return null;
    }

    private final Map<AssetEntity, String> getLocalAssetFiles() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.mo12144getLocalAssetFiles();
        }
        return null;
    }

    private final boolean isUsingEmbeddedAssets() {
        Boolean bool = this._isUsingEmbeddedAssetsOverride;
        if (bool != null) {
            return bool.booleanValue();
        }
        Launcher launcher = this.launcher;
        Boolean boolValueOf = launcher != null ? Boolean.valueOf(launcher.getIsUsingEmbeddedAssets()) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    @Override // expo.modules.updatesinterface.UpdatesDevLauncherInterface
    public void reset() {
        this.launcher = null;
        this._isUsingEmbeddedAssetsOverride = null;
    }

    @Override // expo.modules.updatesinterface.UpdatesDevLauncherInterface
    public void setIsUsingEmbeddedAssets(boolean isUsingEmbeddedAssets) {
        this._isUsingEmbeddedAssetsOverride = Boolean.valueOf(isUsingEmbeddedAssets);
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public String getRuntimeVersion() {
        UpdatesConfiguration updatesConfiguration = this.updatesConfiguration;
        if (updatesConfiguration != null) {
            return updatesConfiguration.getRuntimeVersion();
        }
        return null;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public Uri getUpdateUrl() {
        UpdatesConfiguration updatesConfiguration = this.updatesConfiguration;
        if (updatesConfiguration != null) {
            return updatesConfiguration.getUpdateUrl();
        }
        return null;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public Map<String, String> getRequestHeaders() {
        UpdatesConfiguration updatesConfiguration = this.updatesConfiguration;
        if (updatesConfiguration != null) {
            return updatesConfiguration.getRequestHeaders();
        }
        return null;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public UpdatesStateChangeSubscription subscribeToUpdatesStateChanges(UpdatesStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new DisabledUpdatesStateChangeSubscription();
    }

    @Override // expo.modules.updatesinterface.UpdatesDevLauncherInterface
    public void fetchUpdateWithConfiguration(HashMap<String, Object> configuration, UpdatesDevLauncherInterface.UpdateCallback callback) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            UpdatesConfiguration updatesConfigurationCreateUpdatesConfiguration = createUpdatesConfiguration(configuration);
            if (getUpdatesDirectory() == null) {
                throw new IllegalStateException("Check failed.");
            }
            this.previousUpdatesConfiguration = this.updatesConfiguration;
            this.updatesConfiguration = updatesConfigurationCreateUpdatesConfiguration;
            setDevelopmentSelectionPolicy();
            File filesDir = this.context.getFilesDir();
            Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
            String string = new EASClientID(this.context).getUuid().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            UpdatesConfiguration updatesConfiguration = this.updatesConfiguration;
            Intrinsics.checkNotNull(updatesConfiguration);
            FileDownloader fileDownloader = new FileDownloader(filesDir, string, updatesConfiguration, this.logger, this.database);
            Context context = this.context;
            UpdatesConfiguration updatesConfiguration2 = this.updatesConfiguration;
            Intrinsics.checkNotNull(updatesConfiguration2);
            BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new AnonymousClass1(new RemoteLoader(context, updatesConfiguration2, this.logger, this.database, fileDownloader, getUpdatesDirectory(), null, this.controllerScope), callback, this, fileDownloader, null), 3, null);
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.UpdatesDevLauncherController$fetchUpdateWithConfiguration$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdatesDevLauncherController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.UpdatesDevLauncherController$fetchUpdateWithConfiguration$1", f = "UpdatesDevLauncherController.kt", i = {0, 0, 1, 1, 1}, l = {JfifUtil.MARKER_RST0, 229}, m = "invokeSuspend", n = {"$this$launch", "progressJob", "$this$launch", "progressJob", "loaderResult"}, nl = {225, 237}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UpdatesDevLauncherInterface.UpdateCallback $callback;
        final /* synthetic */ FileDownloader $fileDownloader;
        final /* synthetic */ RemoteLoader $loader;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ UpdatesDevLauncherController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RemoteLoader remoteLoader, UpdatesDevLauncherInterface.UpdateCallback updateCallback, UpdatesDevLauncherController updatesDevLauncherController, FileDownloader fileDownloader, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$loader = remoteLoader;
            this.$callback = updateCallback;
            this.this$0 = updatesDevLauncherController;
            this.$fileDownloader = fileDownloader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$loader, this.$callback, this.this$0, this.$fileDownloader, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r2v9, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r3v0, types: [int] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ?? r2;
            ?? r3;
            Job jobLaunch$default;
            Object objLoad;
            ?? r4 = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r5 = this.label;
            try {
                if (r5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(r4, null, null, new UpdatesDevLauncherController$fetchUpdateWithConfiguration$1$progressJob$1(this.$loader, this.$callback, null), 3, null);
                    RemoteLoader remoteLoader = this.$loader;
                    final UpdatesDevLauncherInterface.UpdateCallback updateCallback = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(r4);
                    this.L$1 = jobLaunch$default;
                    this.label = 1;
                    objLoad = remoteLoader.load(new Function1() { // from class: expo.modules.updates.UpdatesDevLauncherController$fetchUpdateWithConfiguration$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return UpdatesDevLauncherController.AnonymousClass1.invokeSuspend$lambda$0(updateCallback, (UpdateResponse) obj2);
                        }
                    }, this);
                    if (objLoad == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                try {
                    if (r5 == 1) {
                        jobLaunch$default = (Job) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        objLoad = obj;
                    } else {
                        if (r5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r2 = (Job) this.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            r3 = r2;
                        } catch (CancellationException e) {
                            throw e;
                        } catch (Exception e2) {
                            e = e2;
                            UpdatesDevLauncherController updatesDevLauncherController = this.this$0;
                            updatesDevLauncherController.updatesConfiguration = updatesDevLauncherController.previousUpdatesConfiguration;
                            this.$callback.onFailure(e);
                            r3 = r2;
                        }
                    }
                    Job.DefaultImpls.cancel$default((Job) r3, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    Job.DefaultImpls.cancel$default((Job) r4, (CancellationException) null, 1, (Object) null);
                    throw th;
                }
                Loader.LoaderResult loaderResult = (Loader.LoaderResult) objLoad;
                if (loaderResult.getUpdateEntity() == null) {
                    this.$callback.onSuccess(null);
                    Unit unit = Unit.INSTANCE;
                    Job.DefaultImpls.cancel$default(jobLaunch$default, (CancellationException) null, 1, (Object) null);
                    return unit;
                }
                UpdatesDevLauncherController updatesDevLauncherController2 = this.this$0;
                UpdateEntity updateEntity = loaderResult.getUpdateEntity();
                UpdatesConfiguration updatesConfiguration = this.this$0.updatesConfiguration;
                Intrinsics.checkNotNull(updatesConfiguration);
                this.L$0 = SpillingKt.nullOutSpilledVariable(r4);
                this.L$1 = jobLaunch$default;
                this.L$2 = SpillingKt.nullOutSpilledVariable(loaderResult);
                this.label = 2;
                if (updatesDevLauncherController2.launchUpdate(updateEntity, updatesConfiguration, this.$fileDownloader, this.$callback, this) != coroutine_suspended) {
                    r3 = jobLaunch$default;
                    Job.DefaultImpls.cancel$default((Job) r3, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (CancellationException e3) {
                throw e3;
            } catch (Exception e4) {
                e = e4;
                r2 = r5;
            } catch (Throwable th2) {
                th = th2;
                r4 = r5;
            }
        }

        static final Loader.OnUpdateResponseLoadedResult invokeSuspend$lambda$0(UpdatesDevLauncherInterface.UpdateCallback updateCallback, UpdateResponse updateResponse) {
            Update update;
            UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart = updateResponse.getDirectiveUpdateResponsePart();
            UpdateDirective updateDirective = directiveUpdateResponsePart != null ? directiveUpdateResponsePart.getUpdateDirective() : null;
            if (updateDirective != null) {
                if ((updateDirective instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective) || (updateDirective instanceof UpdateDirective.NoUpdateAvailableUpdateDirective)) {
                    return new Loader.OnUpdateResponseLoadedResult(false);
                }
                throw new NoWhenBranchMatchedException();
            }
            UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart = updateResponse.getManifestUpdateResponsePart();
            if (manifestUpdateResponsePart == null || (update = manifestUpdateResponsePart.getUpdate()) == null) {
                return new Loader.OnUpdateResponseLoadedResult(false);
            }
            return new Loader.OnUpdateResponseLoadedResult(updateCallback.onManifestLoaded(update.getManifest().getRawJson()));
        }
    }

    @Override // expo.modules.updatesinterface.UpdatesDevLauncherInterface
    public boolean isValidUpdatesConfiguration(HashMap<String, Object> configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        try {
            createUpdatesConfiguration(configuration);
            return true;
        } catch (Exception e) {
            this.logger.error("Invalid updates configuration", e, UpdatesErrorCode.InitializationError);
            return false;
        }
    }

    private final UpdatesConfiguration createUpdatesConfiguration(HashMap<String, Object> configuration) throws Exception {
        if (getUpdatesDirectory() == null) {
            Exception exc = this.updatesDirectoryException;
            Intrinsics.checkNotNull(exc);
            throw exc;
        }
        HashMap<String, Object> map = configuration;
        int i = WhenMappings.$EnumSwitchMapping$0[UpdatesConfiguration.INSTANCE.getUpdatesConfigurationValidationResult(this.context, map).ordinal()];
        if (i == 1) {
            return new UpdatesConfiguration(this.context, map);
        }
        if (i == 2) {
            throw new Exception("Failed to load update: UpdatesConfiguration object is not enabled");
        }
        if (i == 3) {
            throw new Exception("Failed to load update: UpdatesConfiguration object must include a valid update URL");
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new Exception("Failed to load update: UpdatesConfiguration object must include a valid runtime version");
    }

    private final void setDevelopmentSelectionPolicy() {
        resetSelectionPolicyToDefault();
        SelectionPolicy selectionPolicy = getSelectionPolicy();
        setDefaultSelectionPolicy(new SelectionPolicy(selectionPolicy.getLauncherSelectionPolicy(), selectionPolicy.getLoaderSelectionPolicy(), new ReaperSelectionPolicyDevelopmentClient(0, 1, null)));
        resetSelectionPolicyToDefault();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object launchUpdate(UpdateEntity updateEntity, UpdatesConfiguration updatesConfiguration, FileDownloader fileDownloader, UpdatesDevLauncherInterface.UpdateCallback updateCallback, Continuation<? super Unit> continuation) {
        C09281 c09281;
        UpdatesDevLauncherInterface.UpdateCallback updateCallback2;
        UpdatesDevLauncherInterface.UpdateCallback updateCallback3;
        final DatabaseLauncher databaseLauncher;
        if (continuation instanceof C09281) {
            c09281 = (C09281) continuation;
            if ((c09281.label & Integer.MIN_VALUE) != 0) {
                c09281.label -= Integer.MIN_VALUE;
            } else {
                c09281 = new C09281(continuation);
            }
        } else {
            c09281 = new C09281(continuation);
        }
        Object obj = c09281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09281.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SelectionPolicy selectionPolicy = getSelectionPolicy();
                setNextSelectionPolicy(new SelectionPolicy(new LauncherSelectionPolicySingleUpdate(updateEntity.getId()), selectionPolicy.getLoaderSelectionPolicy(), selectionPolicy.getReaperSelectionPolicy()));
                Context context = this.context;
                File updatesDirectory = getUpdatesDirectory();
                Intrinsics.checkNotNull(updatesDirectory);
                DatabaseLauncher databaseLauncher2 = new DatabaseLauncher(context, updatesConfiguration, updatesDirectory, fileDownloader, getSelectionPolicy(), this.logger, this.controllerScope, false, 128, null);
                try {
                    UpdatesDatabase updatesDatabase = this.database;
                    c09281.L$0 = SpillingKt.nullOutSpilledVariable(updateEntity);
                    c09281.L$1 = SpillingKt.nullOutSpilledVariable(updatesConfiguration);
                    c09281.L$2 = SpillingKt.nullOutSpilledVariable(fileDownloader);
                    updateCallback2 = updateCallback;
                    try {
                        c09281.L$3 = updateCallback2;
                        c09281.L$4 = SpillingKt.nullOutSpilledVariable(selectionPolicy);
                        c09281.L$5 = databaseLauncher2;
                        c09281.label = 1;
                        if (databaseLauncher2.launch(updatesDatabase, c09281) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        updateCallback3 = updateCallback2;
                        databaseLauncher = databaseLauncher2;
                    } catch (Exception e) {
                        e = e;
                        this.updatesConfiguration = this.previousUpdatesConfiguration;
                        updateCallback2.onFailure(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    updateCallback2 = updateCallback;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                databaseLauncher = (DatabaseLauncher) c09281.L$5;
                updateCallback3 = (UpdatesDevLauncherInterface.UpdateCallback) c09281.L$3;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e3) {
                    e = e3;
                    updateCallback2 = updateCallback3;
                    this.updatesConfiguration = this.previousUpdatesConfiguration;
                    updateCallback2.onFailure(e);
                }
            }
            this.launcher = databaseLauncher;
            updateCallback3.onSuccess(new UpdatesDevLauncherInterface.Update() { // from class: expo.modules.updates.UpdatesDevLauncherController.launchUpdate.2
                @Override // expo.modules.updatesinterface.UpdatesDevLauncherInterface.Update
                public JSONObject getManifest() {
                    UpdateEntity launchedUpdate = databaseLauncher.getLaunchedUpdate();
                    Intrinsics.checkNotNull(launchedUpdate);
                    return launchedUpdate.getManifest();
                }

                @Override // expo.modules.updatesinterface.UpdatesDevLauncherInterface.Update
                public String getLaunchAssetPath() {
                    String launchAssetFile = databaseLauncher.getLaunchAssetFile();
                    Intrinsics.checkNotNull(launchAssetFile);
                    return launchAssetFile;
                }
            });
            runReaper();
            return Unit.INSTANCE;
        } catch (CancellationException e4) {
            throw e4;
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.UpdatesDevLauncherController$runReaper$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UpdatesDevLauncherController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.UpdatesDevLauncherController$runReaper$1", f = "UpdatesDevLauncherController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C09291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09291(Continuation<? super C09291> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UpdatesDevLauncherController.this.new C09291(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UpdatesConfiguration updatesConfiguration = UpdatesDevLauncherController.this.updatesConfiguration;
                if (updatesConfiguration != null) {
                    UpdatesDevLauncherController updatesDevLauncherController = UpdatesDevLauncherController.this;
                    Reaper.reapUnusedUpdates(updatesConfiguration, updatesDevLauncherController.database, updatesDevLauncherController.getUpdatesDirectory(), updatesDevLauncherController.getLaunchedUpdate(), updatesDevLauncherController.getSelectionPolicy());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void runReaper() {
        BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new C09291(null), 3, null);
    }

    /* JADX INFO: compiled from: UpdatesDevLauncherController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/updates/UpdatesDevLauncherController$NotAvailableInDevClientException;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", "<init>", "(Ljava/lang/String;)V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class NotAvailableInDevClientException extends CodedException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotAvailableInDevClientException(String message) {
            super(message, null, 2, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesController.UpdatesModuleConstants getConstantsForModule() {
        String runtimeVersionRaw;
        UpdatesConfiguration.CheckAutomaticallyConfiguration checkOnLaunch;
        Map<String, String> mapEmptyMap;
        UpdateEntity launchedUpdate = getLaunchedUpdate();
        Exception exc = this.updatesDirectoryException;
        boolean zIsUsingEmbeddedAssets = isUsingEmbeddedAssets();
        UpdatesConfiguration updatesConfiguration = this.updatesConfiguration;
        if (updatesConfiguration == null || (runtimeVersionRaw = updatesConfiguration.getRuntimeVersionRaw()) == null) {
            runtimeVersionRaw = "1";
        }
        String str = runtimeVersionRaw;
        UpdatesConfiguration updatesConfiguration2 = this.updatesConfiguration;
        if (updatesConfiguration2 == null || (checkOnLaunch = updatesConfiguration2.getCheckOnLaunch()) == null) {
            checkOnLaunch = UpdatesConfiguration.CheckAutomaticallyConfiguration.ALWAYS;
        }
        UpdatesConfiguration.CheckAutomaticallyConfiguration checkAutomaticallyConfiguration = checkOnLaunch;
        UpdatesConfiguration updatesConfiguration3 = this.updatesConfiguration;
        if (updatesConfiguration3 == null || (mapEmptyMap = updatesConfiguration3.getRequestHeaders()) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        return new IUpdatesController.UpdatesModuleConstants(launchedUpdate, null, null, exc, true, zIsUsingEmbeddedAssets, str, checkAutomaticallyConfiguration, mapEmptyMap, getLocalAssetFiles(), true, new UpdatesStateContext(false, false, false, false, false, false, 0, null, null, null, null, null, 0.0d, null, null, null, 65535, null), null);
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object checkForUpdate(Continuation<? super IUpdatesController.CheckForUpdateResult> continuation) throws NotAvailableInDevClientException {
        throw new NotAvailableInDevClientException("Updates.checkForUpdateAsync() is not supported in development builds.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object fetchUpdate(Continuation<? super IUpdatesController.FetchUpdateResult> continuation) throws NotAvailableInDevClientException {
        throw new NotAvailableInDevClientException("Updates.fetchUpdateAsync() is not supported in development builds.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object getExtraParams(Continuation<? super Bundle> continuation) throws NotAvailableInDevClientException {
        throw new NotAvailableInDevClientException("Updates.getExtraParamsAsync() is not supported in development builds.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object setExtraParam(String str, String str2, Continuation<? super Unit> continuation) throws NotAvailableInDevClientException {
        throw new NotAvailableInDevClientException("Updates.setExtraParamAsync() is not supported in development builds.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateURLAndRequestHeadersOverride(UpdatesConfigurationOverride configOverride) throws NotAvailableInDevClientException {
        throw new NotAvailableInDevClientException("Updates.setUpdateURLAndRequestHeadersOverride() is not supported in development builds.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateRequestHeadersOverride(Map<String, String> requestHeaders) throws NotAvailableInDevClientException {
        throw new NotAvailableInDevClientException("Updates.setUpdateRequestHeadersOverride() is not supported in development builds.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void shutdown() {
        CoroutineScopeKt.cancel$default(this.controllerScope, null, 1, null);
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object relaunchReactApplicationForModule(Continuation<? super Unit> continuation) {
        UpdatesInterfaceCallbacks updatesInterfaceCallbacks;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        WeakReference<UpdatesInterfaceCallbacks> updatesInterfaceCallbacks2 = getUpdatesInterfaceCallbacks();
        if (updatesInterfaceCallbacks2 != null && (updatesInterfaceCallbacks = updatesInterfaceCallbacks2.get()) != null) {
            updatesInterfaceCallbacks.onRequestRelaunch();
        }
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuationImpl2.resumeWith(Result.m12684constructorimpl(Unit.INSTANCE));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
