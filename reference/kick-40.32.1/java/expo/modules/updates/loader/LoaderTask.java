package expo.modules.updates.loader;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.facebook.common.util.UriUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.MediaError;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.Reaper;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.launcher.DatabaseLauncher;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.ResponseHeaderData;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import java.io.File;
import java.util.Date;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: compiled from: LoaderTask.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 52\u00020\u0001:\u000512345BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010#\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\u0018\u0010'\u001a\u00020$2\u000e\u0010(\u001a\n\u0018\u00010)j\u0004\u0018\u0001`*H\u0002J\b\u0010+\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020$H\u0002J\u000e\u0010.\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\u000e\u0010/\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\b\u00100\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lexpo/modules/updates/loader/LoaderTask;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "directory", "Ljava/io/File;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "callback", "Lexpo/modules/updates/loader/LoaderTask$LoaderTaskCallback;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/db/UpdatesDatabase;Ljava/io/File;Lexpo/modules/updates/loader/FileDownloader;Lexpo/modules/updates/selectionpolicy/SelectionPolicy;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/loader/LoaderTask$LoaderTaskCallback;Lkotlinx/coroutines/CoroutineScope;)V", "value", "", "isRunning", "()Z", "isReadyToLaunch", "timeoutFinished", "hasLaunched", "isUpToDate", "handlerThread", "Landroid/os/HandlerThread;", "candidateLauncher", "Lexpo/modules/updates/launcher/Launcher;", "finalizedLauncher", ViewProps.START, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchRemoteUpdate", "finish", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "maybeFinish", "stopTimer", InstrumentationTags.TIMEOUT, "launchFallbackUpdateFromDisk", "launchRemoteUpdateInBackground", "runReaper", "RemoteUpdateStatus", "RemoteCheckResultNotAvailableReason", "RemoteCheckResult", "LoaderTaskCallback", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LoaderTask {
    private static final String TAG = "LoaderTask";
    private final LoaderTaskCallback callback;
    private Launcher candidateLauncher;
    private final UpdatesConfiguration configuration;
    private final Context context;
    private final UpdatesDatabase database;
    private final File directory;
    private final FileDownloader fileDownloader;
    private Launcher finalizedLauncher;
    private final HandlerThread handlerThread;
    private boolean hasLaunched;
    private boolean isReadyToLaunch;
    private boolean isRunning;
    private boolean isUpToDate;
    private final UpdatesLogger logger;
    private final CoroutineScope scope;
    private final SelectionPolicy selectionPolicy;
    private boolean timeoutFinished;

    /* JADX INFO: compiled from: LoaderTask.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/loader/LoaderTask$RemoteUpdateStatus;", "", "<init>", "(Ljava/lang/String;I)V", MediaError.ERROR_TYPE_ERROR, "NO_UPDATE_AVAILABLE", "UPDATE_AVAILABLE", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum RemoteUpdateStatus {
        ERROR,
        NO_UPDATE_AVAILABLE,
        UPDATE_AVAILABLE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<RemoteUpdateStatus> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.LoaderTask$launchFallbackUpdateFromDisk$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoaderTask.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.LoaderTask", f = "LoaderTask.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4}, l = {294, 304, 312, 314, TypedValues.Attributes.TYPE_EASING}, m = "launchFallbackUpdateFromDisk", n = {"launcher", "embeddedUpdate", "launcher", "embeddedUpdate", "launchableUpdate", "manifestFilters", "embeddedLoader", "launcher", "embeddedUpdate", "launchableUpdate", "manifestFilters", "launcher", "embeddedUpdate", "launchableUpdate", "manifestFilters", "launcher"}, nl = {295, 307, 319, 319, 319}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoaderTask.this.launchFallbackUpdateFromDisk(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.LoaderTask$launchRemoteUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoaderTask.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.LoaderTask", f = "LoaderTask.kt", i = {}, l = {209}, m = "launchRemoteUpdate", n = {}, nl = {210}, s = {}, v = 2)
    static final class C09351 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09351(Continuation<? super C09351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoaderTask.this.launchRemoteUpdate(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.LoaderTask$launchRemoteUpdateInBackground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoaderTask.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.LoaderTask", f = "LoaderTask.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {337, 384, 398}, m = "launchRemoteUpdateInBackground", n = {"remoteLoader", "progressJob", "remoteLoader", "progressJob", "result", "remoteLoader", "progressJob", "result", "processResult", "availableUpdate", "newLauncher"}, nl = {384, 395, 399}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C09361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C09361(Continuation<? super C09361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoaderTask.this.launchRemoteUpdateInBackground(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.LoaderTask$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoaderTask.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.LoaderTask", f = "LoaderTask.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3}, l = {172, WebmConstants.MkvEbmlElement.CUE_TIME, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT, 201}, m = ViewProps.START, n = {"shouldCheckForUpdate", "delay", "shouldCheckForUpdate", "delay", "shouldCheckForUpdate", "delay", "e", "shouldCheckForUpdate", "delay"}, nl = {173, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 188, 203}, s = {"Z$0", "I$0", "Z$0", "I$0", "Z$0", "I$0", "L$0", "Z$0", "I$0"}, v = 2)
    static final class C09371 extends ContinuationImpl {
        int I$0;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C09371(Continuation<? super C09371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoaderTask.this.start(this);
        }
    }

    public LoaderTask(Context context, UpdatesConfiguration configuration, UpdatesDatabase database, File directory, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger logger, LoaderTaskCallback callback, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.context = context;
        this.configuration = configuration;
        this.database = database;
        this.directory = directory;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.logger = logger;
        this.callback = callback;
        this.scope = scope;
        this.handlerThread = new HandlerThread("expo-updates-timer");
    }

    /* JADX INFO: compiled from: LoaderTask.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResultNotAvailableReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO_UPDATE_AVAILABLE_ON_SERVER", "UPDATE_REJECTED_BY_SELECTION_POLICY", "UPDATE_PREVIOUSLY_FAILED", "ROLLBACK_REJECTED_BY_SELECTION_POLICY", "ROLLBACK_NO_EMBEDDED", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum RemoteCheckResultNotAvailableReason {
        NO_UPDATE_AVAILABLE_ON_SERVER("noUpdateAvailableOnServer"),
        UPDATE_REJECTED_BY_SELECTION_POLICY("updateRejectedBySelectionPolicy"),
        UPDATE_PREVIOUSLY_FAILED("updatePreviouslyFailed"),
        ROLLBACK_REJECTED_BY_SELECTION_POLICY("rollbackRejectedBySelectionPolicy"),
        ROLLBACK_NO_EMBEDDED("rollbackNoEmbeddedConfiguration");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        public static EnumEntries<RemoteCheckResultNotAvailableReason> getEntries() {
            return $ENTRIES;
        }

        RemoteCheckResultNotAvailableReason(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: LoaderTask.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult;", "", "status", "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult$Status;", "<init>", "(Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult$Status;)V", "Status", "NoUpdateAvailable", "UpdateAvailable", "RollBackToEmbedded", "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult$NoUpdateAvailable;", "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult$RollBackToEmbedded;", "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult$UpdateAvailable;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class RemoteCheckResult {
        private final Status status;

        /* JADX INFO: compiled from: LoaderTask.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult$Status;", "", "<init>", "(Ljava/lang/String;I)V", "NO_UPDATE_AVAILABLE", "UPDATE_AVAILABLE", "ROLL_BACK_TO_EMBEDDED", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        private enum Status {
            NO_UPDATE_AVAILABLE,
            UPDATE_AVAILABLE,
            ROLL_BACK_TO_EMBEDDED;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<Status> getEntries() {
                return $ENTRIES;
            }
        }

        public /* synthetic */ RemoteCheckResult(Status status, DefaultConstructorMarker defaultConstructorMarker) {
            this(status);
        }

        private RemoteCheckResult(Status status) {
            this.status = status;
        }

        /* JADX INFO: compiled from: LoaderTask.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult$NoUpdateAvailable;", "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult;", "reason", "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResultNotAvailableReason;", "<init>", "(Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResultNotAvailableReason;)V", "getReason", "()Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResultNotAvailableReason;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class NoUpdateAvailable extends RemoteCheckResult {
            private final RemoteCheckResultNotAvailableReason reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NoUpdateAvailable(RemoteCheckResultNotAvailableReason reason) {
                super(Status.NO_UPDATE_AVAILABLE, null);
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }

            public final RemoteCheckResultNotAvailableReason getReason() {
                return this.reason;
            }
        }

        /* JADX INFO: compiled from: LoaderTask.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult$UpdateAvailable;", "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult;", "manifest", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "getManifest", "()Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class UpdateAvailable extends RemoteCheckResult {
            private final JSONObject manifest;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateAvailable(JSONObject manifest) {
                super(Status.UPDATE_AVAILABLE, null);
                Intrinsics.checkNotNullParameter(manifest, "manifest");
                this.manifest = manifest;
            }

            public final JSONObject getManifest() {
                return this.manifest;
            }
        }

        /* JADX INFO: compiled from: LoaderTask.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult$RollBackToEmbedded;", "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult;", "commitTime", "Ljava/util/Date;", "<init>", "(Ljava/util/Date;)V", "getCommitTime", "()Ljava/util/Date;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class RollBackToEmbedded extends RemoteCheckResult {
            private final Date commitTime;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RollBackToEmbedded(Date commitTime) {
                super(Status.ROLL_BACK_TO_EMBEDDED, null);
                Intrinsics.checkNotNullParameter(commitTime, "commitTime");
                this.commitTime = commitTime;
            }

            public final Date getCommitTime() {
                return this.commitTime;
            }
        }
    }

    /* JADX INFO: compiled from: LoaderTask.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J(\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J*\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010$\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H&¨\u0006%À\u0006\u0003"}, d2 = {"Lexpo/modules/updates/loader/LoaderTask$LoaderTaskCallback;", "", "onFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "launcher", "Lexpo/modules/updates/launcher/Launcher;", "isUpToDate", "", "onFinishedAllLoading", "onCachedUpdateLoaded", "update", "Lexpo/modules/updates/db/entity/UpdateEntity;", "onRemoteUpdateManifestResponseUpdateLoaded", "Lexpo/modules/updates/manifest/Update;", "onRemoteCheckForUpdateStarted", "onRemoteCheckForUpdateFinished", "result", "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResult;", "onRemoteUpdateLoadStarted", "onRemoteUpdateAssetLoaded", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/updates/db/entity/AssetEntity;", "successfulAssetCount", "", "failedAssetCount", "totalAssetCount", "onRemoteUpdateProgressChanged", "progress", "", "onRemoteUpdateFinished", "status", "Lexpo/modules/updates/loader/LoaderTask$RemoteUpdateStatus;", NotificationsService.EXCEPTION_KEY, "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface LoaderTaskCallback {
        boolean onCachedUpdateLoaded(UpdateEntity update);

        void onFailure(Exception e);

        void onFinishedAllLoading();

        default void onRemoteCheckForUpdateFinished(RemoteCheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        default void onRemoteCheckForUpdateStarted() {
        }

        default void onRemoteUpdateAssetLoaded(AssetEntity asset, int successfulAssetCount, int failedAssetCount, int totalAssetCount) {
            Intrinsics.checkNotNullParameter(asset, "asset");
        }

        void onRemoteUpdateFinished(RemoteUpdateStatus status, UpdateEntity update, Exception exception);

        default void onRemoteUpdateLoadStarted() {
        }

        void onRemoteUpdateManifestResponseUpdateLoaded(Update update);

        default void onRemoteUpdateProgressChanged(double progress) {
        }

        void onSuccess(Launcher launcher, boolean isUpToDate);

        /* JADX INFO: compiled from: LoaderTask.kt */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onRemoteCheckForUpdateStarted(LoaderTaskCallback loaderTaskCallback) {
                LoaderTaskCallback.super.onRemoteCheckForUpdateStarted();
            }

            @Deprecated
            public static void onRemoteCheckForUpdateFinished(LoaderTaskCallback loaderTaskCallback, RemoteCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                LoaderTaskCallback.super.onRemoteCheckForUpdateFinished(result);
            }

            @Deprecated
            public static void onRemoteUpdateLoadStarted(LoaderTaskCallback loaderTaskCallback) {
                LoaderTaskCallback.super.onRemoteUpdateLoadStarted();
            }

            @Deprecated
            public static void onRemoteUpdateAssetLoaded(LoaderTaskCallback loaderTaskCallback, AssetEntity asset, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(asset, "asset");
                LoaderTaskCallback.super.onRemoteUpdateAssetLoaded(asset, i, i2, i3);
            }

            @Deprecated
            public static void onRemoteUpdateProgressChanged(LoaderTaskCallback loaderTaskCallback, double d) {
                LoaderTaskCallback.super.onRemoteUpdateProgressChanged(d);
            }
        }
    }

    /* JADX INFO: renamed from: isRunning, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b6 A[Catch: Exception -> 0x0103, CancellationException -> 0x012e, TryCatch #3 {CancellationException -> 0x012e, blocks: (B:18:0x0049, B:23:0x0058, B:35:0x00ab, B:37:0x00b6, B:39:0x00ca, B:42:0x00dd, B:44:0x00e5, B:46:0x00e8, B:49:0x00f5, B:51:0x0101, B:52:0x0102, B:32:0x009d), top: B:72:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ca A[Catch: Exception -> 0x0103, CancellationException -> 0x012e, TryCatch #3 {CancellationException -> 0x012e, blocks: (B:18:0x0049, B:23:0x0058, B:35:0x00ab, B:37:0x00b6, B:39:0x00ca, B:42:0x00dd, B:44:0x00e5, B:46:0x00e8, B:49:0x00f5, B:51:0x0101, B:52:0x0102, B:32:0x009d), top: B:72:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e8 A[Catch: Exception -> 0x0103, CancellationException -> 0x012e, TryCatch #3 {CancellationException -> 0x012e, blocks: (B:18:0x0049, B:23:0x0058, B:35:0x00ab, B:37:0x00b6, B:39:0x00ca, B:42:0x00dd, B:44:0x00e5, B:46:0x00e8, B:49:0x00f5, B:51:0x0101, B:52:0x0102, B:32:0x009d), top: B:72:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f5 A[Catch: Exception -> 0x0103, CancellationException -> 0x012e, TryCatch #3 {CancellationException -> 0x012e, blocks: (B:18:0x0049, B:23:0x0058, B:35:0x00ab, B:37:0x00b6, B:39:0x00ca, B:42:0x00dd, B:44:0x00e5, B:46:0x00e8, B:49:0x00f5, B:51:0x0101, B:52:0x0102, B:32:0x009d), top: B:72:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0106  */
    /* JADX WARN: Code duplicated, block: B:56:0x0111  */
    /* JADX WARN: Code duplicated, block: B:59:0x0120  */
    /* JADX WARN: Code duplicated, block: B:66:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object start(Continuation<? super Unit> continuation) {
        C09371 c09371;
        boolean zShouldCheckForUpdateOnLaunch;
        int launchWaitMs;
        Launcher launcher;
        LoaderTaskCallback loaderTaskCallback;
        UpdateEntity launchedUpdate;
        Exception exc;
        if (continuation instanceof C09371) {
            c09371 = (C09371) continuation;
            if ((c09371.label & Integer.MIN_VALUE) != 0) {
                c09371.label -= Integer.MIN_VALUE;
            } else {
                c09371 = new C09371(continuation);
            }
        } else {
            c09371 = new C09371(continuation);
        }
        Object obj = c09371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09371.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.isRunning = true;
                zShouldCheckForUpdateOnLaunch = UpdatesUtils.INSTANCE.shouldCheckForUpdateOnLaunch(this.configuration, this.logger, this.context);
                launchWaitMs = this.configuration.getLaunchWaitMs();
                if (launchWaitMs > 0 && zShouldCheckForUpdateOnLaunch) {
                    this.handlerThread.start();
                    Boxing.boxBoolean(new Handler(this.handlerThread.getLooper()).postDelayed(new Runnable() { // from class: expo.modules.updates.loader.LoaderTask$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.timeout();
                        }
                    }, launchWaitMs));
                } else {
                    this.timeoutFinished = true;
                }
                try {
                    c09371.Z$0 = zShouldCheckForUpdateOnLaunch;
                    c09371.I$0 = launchWaitMs;
                    c09371.label = 1;
                    if (launchFallbackUpdateFromDisk(c09371) != coroutine_suspended) {
                        launcher = this.candidateLauncher;
                        Intrinsics.checkNotNull(launcher);
                        if (launcher.getLaunchedUpdate() != null) {
                            loaderTaskCallback = this.callback;
                            Launcher launcher2 = this.candidateLauncher;
                            Intrinsics.checkNotNull(launcher2);
                            launchedUpdate = launcher2.getLaunchedUpdate();
                            Intrinsics.checkNotNull(launchedUpdate);
                            if (!loaderTaskCallback.onCachedUpdateLoaded(launchedUpdate)) {
                                stopTimer();
                                this.candidateLauncher = null;
                                c09371.Z$0 = zShouldCheckForUpdateOnLaunch;
                                c09371.I$0 = launchWaitMs;
                                c09371.label = 2;
                                if (launchRemoteUpdate(c09371) == coroutine_suspended) {
                                }
                            }
                        }
                        synchronized (this) {
                            this.isReadyToLaunch = true;
                            maybeFinish();
                            Unit unit = Unit.INSTANCE;
                            if (zShouldCheckForUpdateOnLaunch) {
                                c09371.Z$0 = zShouldCheckForUpdateOnLaunch;
                                c09371.I$0 = launchWaitMs;
                                c09371.label = 3;
                                if (launchRemoteUpdate(c09371) == coroutine_suspended) {
                                }
                            } else {
                                this.isRunning = false;
                                runReaper();
                                this.callback.onFinishedAllLoading();
                            }
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    if (!zShouldCheckForUpdateOnLaunch) {
                        finish(e);
                        this.isRunning = false;
                        this.callback.onFinishedAllLoading();
                    } else {
                        c09371.L$0 = e;
                        c09371.Z$0 = zShouldCheckForUpdateOnLaunch;
                        c09371.I$0 = launchWaitMs;
                        c09371.label = 4;
                        if (launchRemoteUpdate(c09371) != coroutine_suspended) {
                            exc = e;
                            e = exc;
                        }
                    }
                    this.logger.error("Failed to launch embedded or launchable update", e, UpdatesErrorCode.UpdateFailedToLoad);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                launchWaitMs = c09371.I$0;
                boolean z = c09371.Z$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    zShouldCheckForUpdateOnLaunch = z;
                    launcher = this.candidateLauncher;
                    Intrinsics.checkNotNull(launcher);
                    if (launcher.getLaunchedUpdate() != null) {
                        loaderTaskCallback = this.callback;
                        Launcher launcher3 = this.candidateLauncher;
                        Intrinsics.checkNotNull(launcher3);
                        launchedUpdate = launcher3.getLaunchedUpdate();
                        Intrinsics.checkNotNull(launchedUpdate);
                        if (!loaderTaskCallback.onCachedUpdateLoaded(launchedUpdate)) {
                            stopTimer();
                            this.candidateLauncher = null;
                            c09371.Z$0 = zShouldCheckForUpdateOnLaunch;
                            c09371.I$0 = launchWaitMs;
                            c09371.label = 2;
                            if (launchRemoteUpdate(c09371) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    synchronized (this) {
                        this.isReadyToLaunch = true;
                        maybeFinish();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    if (zShouldCheckForUpdateOnLaunch) {
                        c09371.Z$0 = zShouldCheckForUpdateOnLaunch;
                        c09371.I$0 = launchWaitMs;
                        c09371.label = 3;
                        if (launchRemoteUpdate(c09371) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.isRunning = false;
                        runReaper();
                        this.callback.onFinishedAllLoading();
                    }
                } catch (Exception e2) {
                    e = e2;
                    zShouldCheckForUpdateOnLaunch = z;
                    if (!zShouldCheckForUpdateOnLaunch) {
                        finish(e);
                        this.isRunning = false;
                        this.callback.onFinishedAllLoading();
                    } else {
                        c09371.L$0 = e;
                        c09371.Z$0 = zShouldCheckForUpdateOnLaunch;
                        c09371.I$0 = launchWaitMs;
                        c09371.label = 4;
                        if (launchRemoteUpdate(c09371) != coroutine_suspended) {
                            exc = e;
                            e = exc;
                        }
                    }
                    this.logger.error("Failed to launch embedded or launchable update", e, UpdatesErrorCode.UpdateFailedToLoad);
                    return Unit.INSTANCE;
                }
            } else if (i == 2 || i == 3) {
                launchWaitMs = c09371.I$0;
                boolean z2 = c09371.Z$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e3) {
                    e = e3;
                    zShouldCheckForUpdateOnLaunch = z2;
                    if (!zShouldCheckForUpdateOnLaunch) {
                        finish(e);
                        this.isRunning = false;
                        this.callback.onFinishedAllLoading();
                    } else {
                        c09371.L$0 = e;
                        c09371.Z$0 = zShouldCheckForUpdateOnLaunch;
                        c09371.I$0 = launchWaitMs;
                        c09371.label = 4;
                        if (launchRemoteUpdate(c09371) != coroutine_suspended) {
                            exc = e;
                            e = exc;
                        }
                        return coroutine_suspended;
                    }
                    this.logger.error("Failed to launch embedded or launchable update", e, UpdatesErrorCode.UpdateFailedToLoad);
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c09371.I$0;
                boolean z3 = c09371.Z$0;
                exc = (Exception) c09371.L$0;
                ResultKt.throwOnFailure(obj);
                e = exc;
                this.logger.error("Failed to launch embedded or launchable update", e, UpdatesErrorCode.UpdateFailedToLoad);
            }
            if (!zShouldCheckForUpdateOnLaunch) {
                finish(e);
                this.isRunning = false;
                this.callback.onFinishedAllLoading();
            } else {
                c09371.L$0 = e;
                c09371.Z$0 = zShouldCheckForUpdateOnLaunch;
                c09371.I$0 = launchWaitMs;
                c09371.label = 4;
                if (launchRemoteUpdate(c09371) != coroutine_suspended) {
                    exc = e;
                    e = exc;
                }
                return coroutine_suspended;
            }
            this.logger.error("Failed to launch embedded or launchable update", e, UpdatesErrorCode.UpdateFailedToLoad);
            return Unit.INSTANCE;
        } catch (CancellationException e4) {
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object launchRemoteUpdate(Continuation<? super Unit> continuation) {
        C09351 c09351;
        if (continuation instanceof C09351) {
            c09351 = (C09351) continuation;
            if ((c09351.label & Integer.MIN_VALUE) != 0) {
                c09351.label -= Integer.MIN_VALUE;
            } else {
                c09351 = new C09351(continuation);
            }
        } else {
            c09351 = new C09351(continuation);
        }
        Object obj = c09351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09351.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c09351.label = 1;
                if (launchRemoteUpdateInBackground(c09351) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            synchronized (this) {
                this.isReadyToLaunch = true;
                Unit unit = Unit.INSTANCE;
            }
            finish(null);
            this.isRunning = false;
            runReaper();
            this.callback.onFinishedAllLoading();
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            finish(e2);
            this.isRunning = false;
            runReaper();
            this.callback.onFinishedAllLoading();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002f A[Catch: all -> 0x004f, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0008, B:11:0x0014, B:14:0x001e, B:20:0x003b, B:22:0x003f, B:24:0x0044, B:15:0x002b, B:17:0x002f, B:19:0x0038), top: B:30:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0037  */
    private final synchronized void finish(Exception e) {
        Exception exc;
        if (this.hasLaunched) {
            return;
        }
        this.hasLaunched = true;
        Launcher launcher = this.candidateLauncher;
        this.finalizedLauncher = launcher;
        if (!this.isReadyToLaunch || launcher == null) {
            LoaderTaskCallback loaderTaskCallback = this.callback;
            if (e == null) {
                exc = new Exception("LoaderTask encountered an unexpected error and could not launch an update.");
            } else {
                exc = e;
            }
            loaderTaskCallback.onFailure(exc);
        } else {
            Intrinsics.checkNotNull(launcher);
            if (launcher.getLaunchedUpdate() == null) {
                LoaderTaskCallback loaderTaskCallback2 = this.callback;
                if (e == null) {
                    exc = new Exception("LoaderTask encountered an unexpected error and could not launch an update.");
                } else {
                    exc = e;
                }
                loaderTaskCallback2.onFailure(exc);
            } else {
                LoaderTaskCallback loaderTaskCallback3 = this.callback;
                Launcher launcher2 = this.finalizedLauncher;
                Intrinsics.checkNotNull(launcher2);
                loaderTaskCallback3.onSuccess(launcher2, this.isUpToDate);
            }
        }
        if (!this.timeoutFinished) {
            stopTimer();
        }
        if (e != null) {
            this.logger.error("Unexpected error encountered while loading this app", e, UpdatesErrorCode.Unknown);
        }
    }

    private final synchronized void maybeFinish() {
        if (this.isReadyToLaunch && this.timeoutFinished) {
            finish(null);
        }
    }

    private final synchronized void stopTimer() {
        this.timeoutFinished = true;
        this.handlerThread.quitSafely();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void timeout() {
        if (!this.timeoutFinished) {
            this.timeoutFinished = true;
            maybeFinish();
        }
        stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x013e  */
    /* JADX WARN: Code duplicated, block: B:48:0x017c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0174, code lost:
    
        if (r8.launch(r0, r2) == r3) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x019c, code lost:
    
        if (r5.launch(r0, r2) == r3) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01b0, code lost:
    
        if (r10.launch(r0, r2) == r3) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object launchFallbackUpdateFromDisk(kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.loader.LoaderTask.launchFallbackUpdateFromDisk(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static final Loader.OnUpdateResponseLoadedResult launchFallbackUpdateFromDisk$lambda$0(UpdateResponse updateResponse) {
        Intrinsics.checkNotNullParameter(updateResponse, "<unused var>");
        return new Loader.OnUpdateResponseLoadedResult(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x018c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0193 A[Catch: all -> 0x01b6, TryCatch #3 {, blocks: (B:62:0x018f, B:64:0x0193, B:65:0x019a), top: B:101:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01a1 A[Catch: Exception -> 0x004f, all -> 0x01d7, TRY_ENTER, TryCatch #0 {Exception -> 0x004f, blocks: (B:14:0x004a, B:61:0x018e, B:66:0x019c, B:69:0x01a1, B:70:0x01a9, B:74:0x01b7, B:75:0x01b8, B:57:0x0169), top: B:100:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01a9 A[Catch: Exception -> 0x004f, all -> 0x01d7, TRY_LEAVE, TryCatch #0 {Exception -> 0x004f, blocks: (B:14:0x004a, B:61:0x018e, B:66:0x019c, B:69:0x01a1, B:70:0x01a9, B:74:0x01b7, B:75:0x01b8, B:57:0x0169), top: B:100:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:96:0x01f2 A[Catch: all -> 0x01d7, TryCatch #4 {all -> 0x01d7, blocks: (B:61:0x018e, B:66:0x019c, B:69:0x01a1, B:70:0x01a9, B:74:0x01b7, B:75:0x01b8, B:76:0x01b9, B:77:0x01ca, B:55:0x013a, B:57:0x0169, B:91:0x01db, B:93:0x01e1, B:97:0x0203, B:96:0x01f2, B:36:0x00d7), top: B:100:0x002a }] */
    public final Object launchRemoteUpdateInBackground(Continuation<? super Unit> continuation) throws Throwable {
        C09361 c09361;
        CancellationException cancellationException;
        int i;
        Job job;
        String message;
        Job jobLaunch$default;
        RemoteLoader remoteLoader;
        Loader.LoaderResult loaderResult;
        Job job2;
        RemoteLoader remoteLoader2;
        DatabaseLauncher databaseLauncher;
        UpdateEntity updateEntity;
        LoaderTaskCallback loaderTaskCallback;
        CancellationException cancellationException2;
        UpdateEntity availableUpdate;
        DatabaseLauncher databaseLauncher2;
        UpdatesDatabase updatesDatabase;
        Job job3;
        Job job4;
        Loader.LoaderResult loaderResult2;
        RemoteLoader.Companion companion;
        Context context;
        UpdatesConfiguration updatesConfiguration;
        UpdatesLogger updatesLogger;
        UpdatesDatabase updatesDatabase2;
        SelectionPolicy selectionPolicy;
        File file;
        UpdateEntity launchedUpdate;
        if (continuation instanceof C09361) {
            c09361 = (C09361) continuation;
            if ((c09361.label & Integer.MIN_VALUE) != 0) {
                c09361.label -= Integer.MIN_VALUE;
            } else {
                c09361 = new C09361(continuation);
            }
        } else {
            c09361 = new C09361(continuation);
        }
        C09361 c09362 = c09361;
        Object objProcessSuccessLoaderResult = c09362.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09362.label;
        try {
            try {
                try {
                    try {
                        try {
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(objProcessSuccessLoaderResult);
                                this.callback.onRemoteCheckForUpdateStarted();
                                Context context2 = this.context;
                                UpdatesConfiguration updatesConfiguration2 = this.configuration;
                                UpdatesLogger updatesLogger2 = this.logger;
                                UpdatesDatabase updatesDatabase3 = this.database;
                                FileDownloader fileDownloader = this.fileDownloader;
                                File file2 = this.directory;
                                Launcher launcher = this.candidateLauncher;
                                RemoteLoader remoteLoader3 = new RemoteLoader(context2, updatesConfiguration2, updatesLogger2, updatesDatabase3, fileDownloader, file2, launcher != null ? launcher.getLaunchedUpdate() : null, this.scope);
                                remoteLoader3.setAssetLoadProgressBlock$expo_updates_release(new Function1() { // from class: expo.modules.updates.loader.LoaderTask$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return LoaderTask.launchRemoteUpdateInBackground$lambda$0(this.f$0, ((Double) obj).doubleValue());
                                    }
                                });
                                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LoaderTask$launchRemoteUpdateInBackground$progressJob$1(remoteLoader3, this, null), 3, null);
                                Function1<? super UpdateResponse, Loader.OnUpdateResponseLoadedResult> function1 = new Function1() { // from class: expo.modules.updates.loader.LoaderTask$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return LoaderTask.launchRemoteUpdateInBackground$lambda$1(this.f$0, (UpdateResponse) obj);
                                    }
                                };
                                c09362.L$0 = SpillingKt.nullOutSpilledVariable(remoteLoader3);
                                c09362.L$1 = jobLaunch$default;
                                c09362.label = 1;
                                Object objLoad = remoteLoader3.load(function1, c09362);
                                if (objLoad != coroutine_suspended) {
                                    remoteLoader = remoteLoader3;
                                    objProcessSuccessLoaderResult = objLoad;
                                }
                                return coroutine_suspended;
                            }
                            try {
                                if (i2 == 1) {
                                    jobLaunch$default = (Job) c09362.L$1;
                                    RemoteLoader remoteLoader4 = (RemoteLoader) c09362.L$0;
                                    ResultKt.throwOnFailure(objProcessSuccessLoaderResult);
                                    remoteLoader = remoteLoader4;
                                } else {
                                    if (i2 == 2) {
                                        loaderResult = (Loader.LoaderResult) c09362.L$2;
                                        job2 = (Job) c09362.L$1;
                                        remoteLoader2 = (RemoteLoader) c09362.L$0;
                                        ResultKt.throwOnFailure(objProcessSuccessLoaderResult);
                                        ProcessSuccessLoaderResult processSuccessLoaderResult = (ProcessSuccessLoaderResult) objProcessSuccessLoaderResult;
                                        availableUpdate = processSuccessLoaderResult.getAvailableUpdate();
                                        databaseLauncher2 = new DatabaseLauncher(this.context, this.configuration, this.directory, this.fileDownloader, this.selectionPolicy, this.logger, this.scope, false, 128, null);
                                        updatesDatabase = this.database;
                                        c09362.L$0 = SpillingKt.nullOutSpilledVariable(remoteLoader2);
                                        c09362.L$1 = job2;
                                        c09362.L$2 = SpillingKt.nullOutSpilledVariable(loaderResult);
                                        c09362.L$3 = SpillingKt.nullOutSpilledVariable(processSuccessLoaderResult);
                                        c09362.L$4 = availableUpdate;
                                        c09362.L$5 = databaseLauncher2;
                                        c09362.label = 3;
                                        if (databaseLauncher2.launch(updatesDatabase, c09362) != coroutine_suspended) {
                                            updateEntity = availableUpdate;
                                            databaseLauncher = databaseLauncher2;
                                        }
                                        return coroutine_suspended;
                                    }
                                    if (i2 != 3) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    databaseLauncher = (DatabaseLauncher) c09362.L$5;
                                    updateEntity = (UpdateEntity) c09362.L$4;
                                    job2 = (Job) c09362.L$1;
                                    ResultKt.throwOnFailure(objProcessSuccessLoaderResult);
                                }
                                synchronized (this) {
                                    if (!this.hasLaunched) {
                                        this.candidateLauncher = databaseLauncher;
                                        this.isUpToDate = true;
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                                loaderTaskCallback = this.callback;
                                if (updateEntity == null) {
                                    loaderTaskCallback.onRemoteUpdateFinished(RemoteUpdateStatus.NO_UPDATE_AVAILABLE, null, null);
                                    cancellationException2 = null;
                                } else {
                                    cancellationException2 = null;
                                    loaderTaskCallback.onRemoteUpdateFinished(RemoteUpdateStatus.UPDATE_AVAILABLE, updateEntity, null);
                                }
                                Job.DefaultImpls.cancel$default(job2, cancellationException2, 1, (Object) cancellationException2);
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                th = th;
                                cancellationException = null;
                                i = 1;
                                Job.DefaultImpls.cancel$default(job, cancellationException, i, (Object) cancellationException);
                                throw th;
                            }
                            objProcessSuccessLoaderResult = companion.processSuccessLoaderResult(context, updatesConfiguration, updatesLogger, updatesDatabase2, selectionPolicy, file, launchedUpdate, loaderResult2, c09362);
                            if (objProcessSuccessLoaderResult != coroutine_suspended) {
                                loaderResult = loaderResult2;
                                job2 = job4;
                                remoteLoader2 = remoteLoader;
                                ProcessSuccessLoaderResult processSuccessLoaderResult2 = (ProcessSuccessLoaderResult) objProcessSuccessLoaderResult;
                                availableUpdate = processSuccessLoaderResult2.getAvailableUpdate();
                                databaseLauncher2 = new DatabaseLauncher(this.context, this.configuration, this.directory, this.fileDownloader, this.selectionPolicy, this.logger, this.scope, false, 128, null);
                                updatesDatabase = this.database;
                                c09362.L$0 = SpillingKt.nullOutSpilledVariable(remoteLoader2);
                                c09362.L$1 = job2;
                                c09362.L$2 = SpillingKt.nullOutSpilledVariable(loaderResult);
                                c09362.L$3 = SpillingKt.nullOutSpilledVariable(processSuccessLoaderResult2);
                                c09362.L$4 = availableUpdate;
                                c09362.L$5 = databaseLauncher2;
                                c09362.label = 3;
                                if (databaseLauncher2.launch(updatesDatabase, c09362) != coroutine_suspended) {
                                    updateEntity = availableUpdate;
                                    databaseLauncher = databaseLauncher2;
                                    synchronized (this) {
                                        if (!this.hasLaunched) {
                                            this.candidateLauncher = databaseLauncher;
                                            this.isUpToDate = true;
                                        }
                                        Unit unit2 = Unit.INSTANCE;
                                        loaderTaskCallback = this.callback;
                                        if (updateEntity == null) {
                                            loaderTaskCallback.onRemoteUpdateFinished(RemoteUpdateStatus.NO_UPDATE_AVAILABLE, null, null);
                                            cancellationException2 = null;
                                        } else {
                                            cancellationException2 = null;
                                            loaderTaskCallback.onRemoteUpdateFinished(RemoteUpdateStatus.UPDATE_AVAILABLE, updateEntity, null);
                                        }
                                        Job.DefaultImpls.cancel$default(job2, cancellationException2, 1, (Object) cancellationException2);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                            return coroutine_suspended;
                        } catch (Exception e) {
                            e = e;
                            message = e.getMessage();
                            if (message != null) {
                                this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, null, e);
                                this.logger.error("Failed to download remote update", e, UpdatesErrorCode.UpdateFailedToLoad);
                            } else {
                                this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, null, e);
                                this.logger.error("Failed to download remote update", e, UpdatesErrorCode.UpdateFailedToLoad);
                            }
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            job = job4;
                            i = 1;
                            cancellationException = null;
                            Job.DefaultImpls.cancel$default(job, cancellationException, i, (Object) cancellationException);
                            throw th;
                        }
                        loaderResult2 = (Loader.LoaderResult) objProcessSuccessLoaderResult;
                        companion = RemoteLoader.INSTANCE;
                        context = this.context;
                        updatesConfiguration = this.configuration;
                        updatesLogger = this.logger;
                        updatesDatabase2 = this.database;
                        selectionPolicy = this.selectionPolicy;
                        file = this.directory;
                        Launcher launcher2 = this.candidateLauncher;
                        if (launcher2 != null) {
                            try {
                                launchedUpdate = launcher2.getLaunchedUpdate();
                            } catch (Exception e2) {
                                e = e2;
                                message = e.getMessage();
                                if (message != null || !StringsKt.contains$default((CharSequence) message, (CharSequence) "Loaded new update but it failed to launch", false, 2, (Object) null)) {
                                    this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, null, e);
                                    this.logger.error("Failed to download remote update", e, UpdatesErrorCode.UpdateFailedToLoad);
                                }
                                throw e;
                            } catch (Throwable th3) {
                                th = th3;
                                job = job3;
                                i = 1;
                                cancellationException = null;
                                Job.DefaultImpls.cancel$default(job, cancellationException, i, (Object) cancellationException);
                                throw th;
                            }
                        } else {
                            launchedUpdate = null;
                        }
                        c09362.L$0 = SpillingKt.nullOutSpilledVariable(remoteLoader);
                        c09362.L$1 = job3;
                        c09362.L$2 = SpillingKt.nullOutSpilledVariable(loaderResult2);
                        c09362.label = 2;
                        job4 = job3;
                    } catch (Exception e3) {
                        e = e3;
                        job4 = job3;
                    } catch (Throwable th4) {
                        th = th4;
                        job4 = job3;
                    }
                    job3 = jobLaunch$default;
                } catch (Exception e4) {
                    this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, null, e4);
                    this.logger.error("Loaded new update but it failed to launch", e4, UpdatesErrorCode.UpdateFailedToLoad);
                    throw e4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    static final Unit launchRemoteUpdateInBackground$lambda$0(LoaderTask loaderTask, double d) {
        loaderTask.callback.onRemoteUpdateProgressChanged(d);
        return Unit.INSTANCE;
    }

    static final Loader.OnUpdateResponseLoadedResult launchRemoteUpdateInBackground$lambda$1(LoaderTask loaderTask, UpdateResponse updateResponse) {
        Intrinsics.checkNotNullParameter(updateResponse, "updateResponse");
        UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart = updateResponse.getDirectiveUpdateResponsePart();
        UpdateDirective updateDirective = directiveUpdateResponsePart != null ? directiveUpdateResponsePart.getUpdateDirective() : null;
        if (updateDirective != null) {
            if (updateDirective instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective) {
                loaderTask.isUpToDate = true;
                loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.RollBackToEmbedded(((UpdateDirective.RollBackToEmbeddedUpdateDirective) updateDirective).getCommitTime()));
                return new Loader.OnUpdateResponseLoadedResult(false);
            }
            if (!(updateDirective instanceof UpdateDirective.NoUpdateAvailableUpdateDirective)) {
                throw new NoWhenBranchMatchedException();
            }
            loaderTask.isUpToDate = true;
            loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.NoUpdateAvailable(RemoteCheckResultNotAvailableReason.NO_UPDATE_AVAILABLE_ON_SERVER));
            return new Loader.OnUpdateResponseLoadedResult(false);
        }
        UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart = updateResponse.getManifestUpdateResponsePart();
        Update update = manifestUpdateResponsePart != null ? manifestUpdateResponsePart.getUpdate() : null;
        if (update == null) {
            loaderTask.isUpToDate = true;
            loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.NoUpdateAvailable(RemoteCheckResultNotAvailableReason.NO_UPDATE_AVAILABLE_ON_SERVER));
            return new Loader.OnUpdateResponseLoadedResult(false);
        }
        SelectionPolicy selectionPolicy = loaderTask.selectionPolicy;
        UpdateEntity updateEntity = update.getUpdateEntity();
        Launcher launcher = loaderTask.candidateLauncher;
        UpdateEntity launchedUpdate = launcher != null ? launcher.getLaunchedUpdate() : null;
        ResponseHeaderData responseHeaderData = updateResponse.getResponseHeaderData();
        if (selectionPolicy.shouldLoadNewUpdate(updateEntity, launchedUpdate, responseHeaderData != null ? responseHeaderData.getManifestFilters() : null)) {
            loaderTask.isUpToDate = false;
            loaderTask.callback.onRemoteUpdateManifestResponseUpdateLoaded(update);
            loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.UpdateAvailable(update.getManifest().getRawJson()));
            loaderTask.callback.onRemoteUpdateLoadStarted();
            return new Loader.OnUpdateResponseLoadedResult(true);
        }
        loaderTask.isUpToDate = true;
        loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.NoUpdateAvailable(RemoteCheckResultNotAvailableReason.UPDATE_REJECTED_BY_SELECTION_POLICY));
        return new Loader.OnUpdateResponseLoadedResult(false);
    }

    private final void runReaper() {
        synchronized (this) {
            Launcher launcher = this.finalizedLauncher;
            UpdateEntity launchedUpdate = launcher != null ? launcher.getLaunchedUpdate() : null;
            if (launchedUpdate != null) {
                Reaper.reapUnusedUpdates(this.configuration, this.database, this.directory, launchedUpdate, this.selectionPolicy);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
