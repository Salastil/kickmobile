package expo.modules.updates.procedures;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.core.logging.LoggerUtilsKt;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.BuildData;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.errorrecovery.ErrorRecovery;
import expo.modules.updates.errorrecovery.ErrorRecoveryDelegate;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.launcher.NoDatabaseLauncher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.LoaderTask;
import expo.modules.updates.loader.RemoteLoader;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.statemachine.UpdatesStateEvent;
import expo.modules.updates.statemachine.UpdatesStateValue;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;

/* JADX INFO: compiled from: StartupProcedure.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001IBQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010>\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020\"H\u0002J\u000e\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020CJ\u0012\u0010D\u001a\u00020\"2\n\u0010E\u001a\u000603j\u0002`4J\u0010\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020;H\u0002J\b\u0010H\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010#\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b$\u0010\u0019R\u0013\u0010%\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b&\u0010\u0019R\u001f\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0017\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b,\u0010.R\u0013\u0010/\u001a\u0004\u0018\u0001008F¢\u0006\u0006\u001a\u0004\b1\u00102R.\u00105\u001a\n\u0018\u000103j\u0004\u0018\u0001`42\u000e\u0010\u001c\u001a\n\u0018\u000103j\u0004\u0018\u0001`4@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lexpo/modules/updates/procedures/StartupProcedure;", "Lexpo/modules/updates/procedures/StateMachineProcedure;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "updatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "updatesDirectory", "Ljava/io/File;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "callback", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback;", "procedureScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/db/UpdatesDatabase;Ljava/io/File;Lexpo/modules/updates/loader/FileDownloader;Lexpo/modules/updates/selectionpolicy/SelectionPolicy;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback;Lkotlinx/coroutines/CoroutineScope;)V", "loggerTimerLabel", "", "getLoggerTimerLabel", "()Ljava/lang/String;", "procedureContext", "Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "value", "Lexpo/modules/updates/launcher/Launcher;", "launcher", "getLauncher", "()Lexpo/modules/updates/launcher/Launcher;", "setLauncher", "", "launchAssetFile", "getLaunchAssetFile", "bundleAssetName", "getBundleAssetName", "localAssetFiles", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "getLocalAssetFiles", "()Ljava/util/Map;", "isUsingEmbeddedAssets", "", "()Z", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "getLaunchedUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "emergencyLaunchException", "getEmergencyLaunchException", "()Ljava/lang/Exception;", "errorRecovery", "Lexpo/modules/updates/errorrecovery/ErrorRecovery;", "remoteLoadStatus", "Lexpo/modules/updates/errorrecovery/ErrorRecoveryDelegate$RemoteLoadStatus;", "loaderTask", "Lexpo/modules/updates/loader/LoaderTask;", "run", "(Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyController", "onDidCreateDevSupportManager", "devSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "onReactInstanceException", NotificationsService.EXCEPTION_KEY, "setRemoteLoadStatus", "status", "initializeErrorRecovery", "StartupProcedureCallback", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StartupProcedure extends StateMachineProcedure {
    private final StartupProcedureCallback callback;
    private final Context context;
    private final UpdatesDatabase database;
    private Exception emergencyLaunchException;
    private final ErrorRecovery errorRecovery;
    private final FileDownloader fileDownloader;
    private Launcher launcher;
    private final LoaderTask loaderTask;
    private final UpdatesLogger logger;
    private final String loggerTimerLabel;
    private StateMachineProcedure.ProcedureContext procedureContext;
    private final CoroutineScope procedureScope;
    private ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus;
    private final SelectionPolicy selectionPolicy;
    private final UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;

    /* JADX INFO: compiled from: StartupProcedure.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback;", "", "onFinished", "", "onRequestRelaunch", "shouldRunReaper", "", "callback", "Lexpo/modules/updates/launcher/Launcher$LauncherCallback;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface StartupProcedureCallback {
        void onFinished();

        void onRequestRelaunch(boolean shouldRunReaper, Launcher.LauncherCallback callback);
    }

    public StartupProcedure(Context context, UpdatesConfiguration updatesConfiguration, UpdatesDatabase database, File updatesDirectory, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger logger, StartupProcedureCallback callback, CoroutineScope procedureScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(procedureScope, "procedureScope");
        this.context = context;
        this.updatesConfiguration = updatesConfiguration;
        this.database = database;
        this.updatesDirectory = updatesDirectory;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.logger = logger;
        this.callback = callback;
        this.procedureScope = procedureScope;
        this.loggerTimerLabel = "timer-startup";
        this.errorRecovery = new ErrorRecovery(logger);
        this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
        this.loaderTask = new LoaderTask(context, updatesConfiguration, database, updatesDirectory, fileDownloader, selectionPolicy, logger, new LoaderTask.LoaderTaskCallback() { // from class: expo.modules.updates.procedures.StartupProcedure$loaderTask$1

            /* JADX INFO: compiled from: StartupProcedure.kt */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;

                static {
                    int[] iArr = new int[UpdatesStateValue.values().length];
                    try {
                        iArr[UpdatesStateValue.Idle.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[UpdatesStateValue.Checking.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[LoaderTask.RemoteUpdateStatus.values().length];
                    try {
                        iArr2[LoaderTask.RemoteUpdateStatus.ERROR.ordinal()] = 1;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr2[LoaderTask.RemoteUpdateStatus.UPDATE_AVAILABLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr2[LoaderTask.RemoteUpdateStatus.NO_UPDATE_AVAILABLE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                }
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public boolean onCachedUpdateLoaded(UpdateEntity update) {
                Intrinsics.checkNotNullParameter(update, "update");
                return true;
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onFailure(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.logger.error("UpdatesController loaderTask onFailure", e, UpdatesErrorCode.None);
                this.this$0.launcher = new NoDatabaseLauncher(this.this$0.context, this.this$0.logger, e, this.this$0.procedureScope);
                this.this$0.emergencyLaunchException = e;
                this.this$0.notifyController();
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onSuccess(Launcher launcher, boolean isUpToDate) {
                Intrinsics.checkNotNullParameter(launcher, "launcher");
                if (this.this$0.remoteLoadStatus == ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADING && isUpToDate) {
                    this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
                }
                this.this$0.launcher = launcher;
                this.this$0.notifyController();
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onFinishedAllLoading() {
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                StateMachineProcedure.ProcedureContext procedureContext2 = null;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.EndStartup());
                StateMachineProcedure.ProcedureContext procedureContext3 = this.this$0.procedureContext;
                if (procedureContext3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                } else {
                    procedureContext2 = procedureContext3;
                }
                procedureContext2.onComplete();
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteCheckForUpdateStarted() {
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.Check());
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteCheckForUpdateFinished(LoaderTask.RemoteCheckResult result) {
                UpdatesStateEvent.CheckCompleteWithRollback checkCompleteWithRollback;
                Intrinsics.checkNotNullParameter(result, "result");
                if (result instanceof LoaderTask.RemoteCheckResult.NoUpdateAvailable) {
                    checkCompleteWithRollback = new UpdatesStateEvent.CheckCompleteUnavailable();
                } else if (result instanceof LoaderTask.RemoteCheckResult.UpdateAvailable) {
                    checkCompleteWithRollback = new UpdatesStateEvent.CheckCompleteWithUpdate(((LoaderTask.RemoteCheckResult.UpdateAvailable) result).getManifest());
                } else {
                    if (!(result instanceof LoaderTask.RemoteCheckResult.RollBackToEmbedded)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    checkCompleteWithRollback = new UpdatesStateEvent.CheckCompleteWithRollback(((LoaderTask.RemoteCheckResult.RollBackToEmbedded) result).getCommitTime());
                }
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(checkCompleteWithRollback);
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateManifestResponseUpdateLoaded(Update update) {
                Intrinsics.checkNotNullParameter(update, "update");
                this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADING;
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateLoadStarted() {
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.Download());
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateAssetLoaded(AssetEntity asset, int successfulAssetCount, int failedAssetCount, int totalAssetCount) {
                Intrinsics.checkNotNullParameter(asset, "asset");
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("assetInfo", MapsKt.mapOf(TuplesKt.to("name", asset.getEmbeddedAssetFilename()), TuplesKt.to("successfulAssetCount", Integer.valueOf(successfulAssetCount)), TuplesKt.to("failedAssetCount", Integer.valueOf(failedAssetCount)), TuplesKt.to("totalAssetCount", Integer.valueOf(totalAssetCount)))));
                this.this$0.logger.info("AppController appLoaderTask didLoadAsset: " + mapMapOf, UpdatesErrorCode.None, null, asset.getExpectedHash());
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateProgressChanged(double progress) {
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.DownloadProgress(progress));
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateFinished(LoaderTask.RemoteUpdateStatus status, UpdateEntity update, Exception exception) {
                Intrinsics.checkNotNullParameter(status, "status");
                int i = WhenMappings.$EnumSwitchMapping$1[status.ordinal()];
                StateMachineProcedure.ProcedureContext procedureContext = null;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
                        this.this$0.logger.info("UpdatesController onBackgroundUpdateFinished: No update available", UpdatesErrorCode.NoUpdatesAvailable);
                        StateMachineProcedure.ProcedureContext procedureContext2 = this.this$0.procedureContext;
                        if (procedureContext2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                            procedureContext2 = null;
                        }
                        if (procedureContext2.getCurrentState() == UpdatesStateValue.Downloading) {
                            StateMachineProcedure.ProcedureContext procedureContext3 = this.this$0.procedureContext;
                            if (procedureContext3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                            } else {
                                procedureContext = procedureContext3;
                            }
                            procedureContext.processStateEvent(new UpdatesStateEvent.DownloadCompleteUnavailable());
                        }
                    } else {
                        if (update == null) {
                            throw new AssertionError("Background update with error status must have a nonnull update object");
                        }
                        this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADED;
                        this.this$0.logger.info("UpdatesController onBackgroundUpdateFinished: Update available", UpdatesErrorCode.None);
                        StateMachineProcedure.ProcedureContext procedureContext4 = this.this$0.procedureContext;
                        if (procedureContext4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext = procedureContext4;
                        }
                        procedureContext.processStateEvent(new UpdatesStateEvent.DownloadCompleteWithUpdate(update.getManifest()));
                    }
                } else if (exception != null) {
                    this.this$0.logger.error("UpdatesController onBackgroundUpdateFinished", exception, UpdatesErrorCode.Unknown);
                    this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
                    StateMachineProcedure.ProcedureContext procedureContext5 = this.this$0.procedureContext;
                    if (procedureContext5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        procedureContext5 = null;
                    }
                    int i2 = WhenMappings.$EnumSwitchMapping$0[procedureContext5.getCurrentState().ordinal()];
                    if (i2 == 1) {
                        StateMachineProcedure.ProcedureContext procedureContext6 = this.this$0.procedureContext;
                        if (procedureContext6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                            procedureContext6 = null;
                        }
                        procedureContext6.processStateEvent(new UpdatesStateEvent.Download());
                        StateMachineProcedure.ProcedureContext procedureContext7 = this.this$0.procedureContext;
                        if (procedureContext7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext = procedureContext7;
                        }
                        procedureContext.processStateEvent(new UpdatesStateEvent.DownloadError(LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(exception)));
                    } else {
                        StartupProcedure startupProcedure = this.this$0;
                        if (i2 != 2) {
                            StateMachineProcedure.ProcedureContext procedureContext8 = startupProcedure.procedureContext;
                            if (procedureContext8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                            } else {
                                procedureContext = procedureContext8;
                            }
                            procedureContext.processStateEvent(new UpdatesStateEvent.DownloadError(LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(exception)));
                        } else {
                            StateMachineProcedure.ProcedureContext procedureContext9 = startupProcedure.procedureContext;
                            if (procedureContext9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                            } else {
                                procedureContext = procedureContext9;
                            }
                            procedureContext.processStateEvent(new UpdatesStateEvent.CheckError(LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(exception)));
                        }
                    }
                } else {
                    throw new AssertionError("Background update with error status must have a nonnull exception object");
                }
                this.this$0.errorRecovery.notifyNewRemoteLoadStatus(this.this$0.remoteLoadStatus);
            }
        }, procedureScope);
    }

    public /* synthetic */ StartupProcedure(Context context, UpdatesConfiguration updatesConfiguration, UpdatesDatabase updatesDatabase, File file, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger updatesLogger, StartupProcedureCallback startupProcedureCallback, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, updatesConfiguration, updatesDatabase, file, fileDownloader, selectionPolicy, updatesLogger, startupProcedureCallback, (i & 256) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : coroutineScope);
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public String getLoggerTimerLabel() {
        return this.loggerTimerLabel;
    }

    public final Launcher getLauncher() {
        return this.launcher;
    }

    public final void setLauncher(Launcher launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        this.launcher = launcher;
    }

    public final String getLaunchAssetFile() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchAssetFile();
        }
        return null;
    }

    public final String getBundleAssetName() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getBundleAssetName();
        }
        return null;
    }

    public final Map<AssetEntity, String> getLocalAssetFiles() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.mo12144getLocalAssetFiles();
        }
        return null;
    }

    public final boolean isUsingEmbeddedAssets() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.isUsingEmbeddedAssets();
        }
        return false;
    }

    public final UpdateEntity getLaunchedUpdate() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchedUpdate();
        }
        return null;
    }

    public final Exception getEmergencyLaunchException() {
        return this.emergencyLaunchException;
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public Object run(StateMachineProcedure.ProcedureContext procedureContext, Continuation<? super Unit> continuation) throws JSONException {
        this.procedureContext = procedureContext;
        procedureContext.processStateEvent(new UpdatesStateEvent.StartStartup());
        if (!this.updatesConfiguration.getHasUpdatesOverride()) {
            BuildData.INSTANCE.ensureBuildDataIsConsistent(this.updatesConfiguration, this.database);
        }
        initializeErrorRecovery();
        Object objStart = this.loaderTask.start(continuation);
        return objStart == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStart : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void notifyController() {
        if (this.launcher == null) {
            throw new AssertionError("UpdatesController.notifyController was called with a null launcher, which is an error. This method should only be called when an update is ready to launch.");
        }
        this.callback.onFinished();
    }

    public final void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        if (this.emergencyLaunchException != null) {
            return;
        }
        this.errorRecovery.startMonitoring(devSupportManager);
    }

    public final void onReactInstanceException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.errorRecovery.onReactInstanceException$expo_updates_release(exception);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemoteLoadStatus(ErrorRecoveryDelegate.RemoteLoadStatus status) {
        this.remoteLoadStatus = status;
        this.errorRecovery.notifyNewRemoteLoadStatus(status);
    }

    private final void initializeErrorRecovery() {
        this.errorRecovery.initialize(new ErrorRecoveryDelegate() { // from class: expo.modules.updates.procedures.StartupProcedure.initializeErrorRecovery.1
            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void loadRemoteUpdate() {
                if (StartupProcedure.this.loaderTask.getIsRunning()) {
                    return;
                }
                StartupProcedure.this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADING;
                BuildersKt__Builders_commonKt.launch$default(StartupProcedure.this.procedureScope, null, null, new StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1(new RemoteLoader(StartupProcedure.this.context, StartupProcedure.this.updatesConfiguration, StartupProcedure.this.logger, StartupProcedure.this.database, StartupProcedure.this.fileDownloader, StartupProcedure.this.updatesDirectory, StartupProcedure.this.getLaunchedUpdate(), StartupProcedure.this.procedureScope), StartupProcedure.this, null), 3, null);
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void relaunch(Launcher.LauncherCallback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                StartupProcedure.this.callback.onRequestRelaunch(false, callback);
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void throwException(Exception exception) throws Exception {
                Intrinsics.checkNotNullParameter(exception, "exception");
                throw exception;
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void markFailedLaunchForLaunchedUpdate() {
                if (StartupProcedure.this.getEmergencyLaunchException() != null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(StartupProcedure.this.procedureScope, null, null, new StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1(StartupProcedure.this, null), 3, null);
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void markSuccessfulLaunchForLaunchedUpdate() {
                if (StartupProcedure.this.getEmergencyLaunchException() != null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(StartupProcedure.this.procedureScope, null, null, new StartupProcedure$initializeErrorRecovery$1$markSuccessfulLaunchForLaunchedUpdate$1(StartupProcedure.this, null), 3, null);
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public ErrorRecoveryDelegate.RemoteLoadStatus getRemoteLoadStatus() {
                return StartupProcedure.this.remoteLoadStatus;
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public UpdatesConfiguration.CheckAutomaticallyConfiguration getCheckAutomaticallyConfiguration() {
                return StartupProcedure.this.updatesConfiguration.getCheckOnLaunch();
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public int getLaunchedUpdateSuccessfulLaunchCount() {
                UpdateEntity launchedUpdate = StartupProcedure.this.getLaunchedUpdate();
                if (launchedUpdate != null) {
                    return launchedUpdate.getSuccessfulLaunchCount();
                }
                return 0;
            }
        });
    }
}
