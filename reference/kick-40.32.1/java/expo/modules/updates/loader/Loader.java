package expo.modules.updates.loader;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.util.UriUtil;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.dao.AssetDao;
import expo.modules.updates.db.dao.UpdateDao;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.manifest.ResponseHeaderData;
import expo.modules.updates.manifest.Update;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: Loader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 U2\u00020\u0001:\u0005QRSTUBC\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020&J\b\u00105\u001a\u00020)H\u0002J\u001e\u00106\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H¤@¢\u0006\u0002\u00107J:\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u00192\b\u0010<\u001a\u0004\u0018\u00010\u0019H¤@¢\u0006\u0002\u0010=J\"\u0010>\u001a\u00020?2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020A0(H\u0086@¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020)H\u0002J\b\u0010D\u001a\u00020?H\u0002J\u0016\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020GH\u0082@¢\u0006\u0002\u0010HJ\u001e\u0010I\u001a\u00020?2\u0006\u0010F\u001a\u00020G2\u0006\u0010J\u001a\u00020KH\u0082@¢\u0006\u0002\u0010LJ\u001e\u0010M\u001a\u00020N2\u0006\u0010:\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020NH\u0082@¢\u0006\u0002\u0010PR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020&0%X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020#0/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006V"}, d2 = {"Lexpo/modules/updates/loader/Loader;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "updatesDirectory", "Ljava/io/File;", "loaderFiles", "Lexpo/modules/updates/loader/LoaderFiles;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Ljava/io/File;Lexpo/modules/updates/loader/LoaderFiles;Lkotlinx/coroutines/CoroutineScope;)V", "getContext", "()Landroid/content/Context;", "getLogger", "()Lexpo/modules/updates/logging/UpdatesLogger;", "updateResponse", "Lexpo/modules/updates/loader/UpdateResponse;", "updateEntity", "Lexpo/modules/updates/db/entity/UpdateEntity;", "assetTotal", "", "erroredAssetList", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "existingAssetList", "finishedAssetList", "_progressFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lexpo/modules/updates/loader/Loader$AssetLoadProgress;", "assetProgressMap", "", "", "assetLoadProgressBlock", "Lkotlin/Function1;", "", "getAssetLoadProgressBlock$expo_updates_release", "()Lkotlin/jvm/functions/Function1;", "setAssetLoadProgressBlock$expo_updates_release", "(Lkotlin/jvm/functions/Function1;)V", "progressFlow", "Lkotlinx/coroutines/flow/Flow;", "getProgressFlow", "()Lkotlinx/coroutines/flow/Flow;", "assetLoadProgressListener", UriUtil.LOCAL_ASSET_SCHEME, "progress", "notifyAssetLoadProgress", "loadRemoteUpdate", "(Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/UpdatesConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAsset", "Lexpo/modules/updates/loader/FileDownloader$AssetDownloadResult;", "assetEntity", "requestedUpdate", "embeddedUpdate", "(Lexpo/modules/updates/db/entity/AssetEntity;Ljava/io/File;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/db/entity/UpdateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lexpo/modules/updates/loader/Loader$LoaderResult;", "updateResponseDecision", "Lexpo/modules/updates/loader/Loader$OnUpdateResponseLoadedResult;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "finish", "processUpdate", "update", "Lexpo/modules/updates/manifest/Update;", "(Lexpo/modules/updates/manifest/Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAllAssets", "insertUpdateEntityOnFinish", "", "(Lexpo/modules/updates/manifest/Update;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleAssetDownloadCompleted", "Lexpo/modules/updates/loader/Loader$AssetLoadResult;", "result", "(Lexpo/modules/updates/db/entity/AssetEntity;Lexpo/modules/updates/loader/Loader$AssetLoadResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LoaderResult", "OnUpdateResponseLoadedResult", "AssetLoadProgress", "AssetLoadResult", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Loader {
    private static final String TAG = "Loader";
    private final MutableSharedFlow<AssetLoadProgress> _progressFlow;
    private Function1<? super Double, Unit> assetLoadProgressBlock;
    private Map<AssetEntity, Double> assetProgressMap;
    private int assetTotal;
    private final UpdatesConfiguration configuration;
    private final Context context;
    private final UpdatesDatabase database;
    private List<AssetEntity> erroredAssetList;
    private List<AssetEntity> existingAssetList;
    private List<AssetEntity> finishedAssetList;
    private final LoaderFiles loaderFiles;
    private final UpdatesLogger logger;
    private final Flow<AssetLoadProgress> progressFlow;
    private CoroutineScope scope;
    private UpdateEntity updateEntity;
    private UpdateResponse updateResponse;
    private final File updatesDirectory;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Loader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/loader/Loader$AssetLoadResult;", "", "<init>", "(Ljava/lang/String;I)V", "FINISHED", "ALREADY_EXISTS", "ERRORED", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    enum AssetLoadResult {
        FINISHED,
        ALREADY_EXISTS,
        ERRORED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<AssetLoadResult> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: Loader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AssetLoadResult.values().length];
            try {
                iArr[AssetLoadResult.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AssetLoadResult.ALREADY_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AssetLoadResult.ERRORED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.Loader$downloadAllAssets$1, reason: invalid class name */
    /* JADX INFO: compiled from: Loader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.Loader", f = "Loader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {226, 252, 255}, m = "downloadAllAssets", n = {"update", "assetList", "embeddedUpdate", "assetDownloadJobs", "assetEntityCur", "assetEntity", "matchingDbEntry", "insertUpdateEntityOnFinish", "update", "assetList", "embeddedUpdate", "assetDownloadJobs", "insertUpdateEntityOnFinish", "update", "assetList", "embeddedUpdate", "assetDownloadJobs", "insertUpdateEntityOnFinish"}, nl = {227, 254, 281}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Loader.this.downloadAllAssets(null, false, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.Loader$handleAssetDownloadCompleted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Loader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.Loader", f = "Loader.kt", i = {0, 0}, l = {304}, m = "handleAssetDownloadCompleted", n = {"assetEntity", "result"}, nl = {313}, s = {"L$0", "L$1"}, v = 2)
    static final class C09331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09331(Continuation<? super C09331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Loader.this.handleAssetDownloadCompleted(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.Loader$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Loader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.Loader", f = "Loader.kt", i = {0, 1, 1, 1, 1}, l = {98, 106}, m = "load", n = {"updateResponseDecision", "updateResponseDecision", "updateResponse", "update", "onUpdateResponseLoadedResult"}, nl = {99, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C09341 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09341(Continuation<? super C09341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Loader.this.load(null, this);
        }
    }

    protected abstract Object loadAsset(AssetEntity assetEntity, File file, UpdatesConfiguration updatesConfiguration, UpdateEntity updateEntity, UpdateEntity updateEntity2, Continuation<? super FileDownloader.AssetDownloadResult> continuation);

    protected abstract Object loadRemoteUpdate(UpdatesDatabase updatesDatabase, UpdatesConfiguration updatesConfiguration, Continuation<? super UpdateResponse> continuation);

    protected Loader(Context context, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database, File updatesDirectory, LoaderFiles loaderFiles, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(loaderFiles, "loaderFiles");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.context = context;
        this.configuration = configuration;
        this.logger = logger;
        this.database = database;
        this.updatesDirectory = updatesDirectory;
        this.loaderFiles = loaderFiles;
        this.scope = scope;
        List<AssetEntity> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(listSynchronizedList, "synchronizedList(...)");
        this.erroredAssetList = listSynchronizedList;
        List<AssetEntity> listSynchronizedList2 = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(listSynchronizedList2, "synchronizedList(...)");
        this.existingAssetList = listSynchronizedList2;
        List<AssetEntity> listSynchronizedList3 = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(listSynchronizedList3, "synchronizedList(...)");
        this.finishedAssetList = listSynchronizedList3;
        MutableSharedFlow<AssetLoadProgress> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._progressFlow = mutableSharedFlowMutableSharedFlow$default;
        this.assetProgressMap = new ConcurrentHashMap();
        this.progressFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    protected final Context getContext() {
        return this.context;
    }

    protected final UpdatesLogger getLogger() {
        return this.logger;
    }

    public /* synthetic */ Loader(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, File file, LoaderFiles loaderFiles, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, updatesConfiguration, updatesLogger, updatesDatabase, file, loaderFiles, (i & 64) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    public final Function1<Double, Unit> getAssetLoadProgressBlock$expo_updates_release() {
        return this.assetLoadProgressBlock;
    }

    public final void setAssetLoadProgressBlock$expo_updates_release(Function1<? super Double, Unit> function1) {
        this.assetLoadProgressBlock = function1;
    }

    public final Flow<AssetLoadProgress> getProgressFlow() {
        return this.progressFlow;
    }

    /* JADX INFO: compiled from: Loader.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lexpo/modules/updates/loader/Loader$LoaderResult;", "", "updateEntity", "Lexpo/modules/updates/db/entity/UpdateEntity;", "updateDirective", "Lexpo/modules/updates/loader/UpdateDirective;", "<init>", "(Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/loader/UpdateDirective;)V", "getUpdateEntity", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "getUpdateDirective", "()Lexpo/modules/updates/loader/UpdateDirective;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LoaderResult {
        private final UpdateDirective updateDirective;
        private final UpdateEntity updateEntity;

        public static /* synthetic */ LoaderResult copy$default(LoaderResult loaderResult, UpdateEntity updateEntity, UpdateDirective updateDirective, int i, Object obj) {
            if ((i & 1) != 0) {
                updateEntity = loaderResult.updateEntity;
            }
            if ((i & 2) != 0) {
                updateDirective = loaderResult.updateDirective;
            }
            return loaderResult.copy(updateEntity, updateDirective);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final UpdateEntity getUpdateEntity() {
            return this.updateEntity;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final UpdateDirective getUpdateDirective() {
            return this.updateDirective;
        }

        public final LoaderResult copy(UpdateEntity updateEntity, UpdateDirective updateDirective) {
            return new LoaderResult(updateEntity, updateDirective);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoaderResult)) {
                return false;
            }
            LoaderResult loaderResult = (LoaderResult) other;
            return Intrinsics.areEqual(this.updateEntity, loaderResult.updateEntity) && Intrinsics.areEqual(this.updateDirective, loaderResult.updateDirective);
        }

        public int hashCode() {
            UpdateEntity updateEntity = this.updateEntity;
            int iHashCode = (updateEntity == null ? 0 : updateEntity.hashCode()) * 31;
            UpdateDirective updateDirective = this.updateDirective;
            return iHashCode + (updateDirective != null ? updateDirective.hashCode() : 0);
        }

        public String toString() {
            return "LoaderResult(updateEntity=" + this.updateEntity + ", updateDirective=" + this.updateDirective + ")";
        }

        public LoaderResult(UpdateEntity updateEntity, UpdateDirective updateDirective) {
            this.updateEntity = updateEntity;
            this.updateDirective = updateDirective;
        }

        public final UpdateDirective getUpdateDirective() {
            return this.updateDirective;
        }

        public final UpdateEntity getUpdateEntity() {
            return this.updateEntity;
        }
    }

    /* JADX INFO: compiled from: Loader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lexpo/modules/updates/loader/Loader$OnUpdateResponseLoadedResult;", "", "shouldDownloadManifestIfPresentInResponse", "", "<init>", "(Z)V", "getShouldDownloadManifestIfPresentInResponse", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class OnUpdateResponseLoadedResult {
        private final boolean shouldDownloadManifestIfPresentInResponse;

        public static /* synthetic */ OnUpdateResponseLoadedResult copy$default(OnUpdateResponseLoadedResult onUpdateResponseLoadedResult, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = onUpdateResponseLoadedResult.shouldDownloadManifestIfPresentInResponse;
            }
            return onUpdateResponseLoadedResult.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShouldDownloadManifestIfPresentInResponse() {
            return this.shouldDownloadManifestIfPresentInResponse;
        }

        public final OnUpdateResponseLoadedResult copy(boolean shouldDownloadManifestIfPresentInResponse) {
            return new OnUpdateResponseLoadedResult(shouldDownloadManifestIfPresentInResponse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnUpdateResponseLoadedResult) && this.shouldDownloadManifestIfPresentInResponse == ((OnUpdateResponseLoadedResult) other).shouldDownloadManifestIfPresentInResponse;
        }

        public int hashCode() {
            return Boolean.hashCode(this.shouldDownloadManifestIfPresentInResponse);
        }

        public String toString() {
            return "OnUpdateResponseLoadedResult(shouldDownloadManifestIfPresentInResponse=" + this.shouldDownloadManifestIfPresentInResponse + ")";
        }

        public OnUpdateResponseLoadedResult(boolean z) {
            this.shouldDownloadManifestIfPresentInResponse = z;
        }

        public final boolean getShouldDownloadManifestIfPresentInResponse() {
            return this.shouldDownloadManifestIfPresentInResponse;
        }
    }

    /* JADX INFO: compiled from: Loader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lexpo/modules/updates/loader/Loader$AssetLoadProgress;", "", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/updates/db/entity/AssetEntity;", "successfulAssetCount", "", "failedAssetCount", "totalAssetCount", "<init>", "(Lexpo/modules/updates/db/entity/AssetEntity;III)V", "getAsset", "()Lexpo/modules/updates/db/entity/AssetEntity;", "getSuccessfulAssetCount", "()I", "getFailedAssetCount", "getTotalAssetCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AssetLoadProgress {
        private final AssetEntity asset;
        private final int failedAssetCount;
        private final int successfulAssetCount;
        private final int totalAssetCount;

        public static /* synthetic */ AssetLoadProgress copy$default(AssetLoadProgress assetLoadProgress, AssetEntity assetEntity, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                assetEntity = assetLoadProgress.asset;
            }
            if ((i4 & 2) != 0) {
                i = assetLoadProgress.successfulAssetCount;
            }
            if ((i4 & 4) != 0) {
                i2 = assetLoadProgress.failedAssetCount;
            }
            if ((i4 & 8) != 0) {
                i3 = assetLoadProgress.totalAssetCount;
            }
            return assetLoadProgress.copy(assetEntity, i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AssetEntity getAsset() {
            return this.asset;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSuccessfulAssetCount() {
            return this.successfulAssetCount;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFailedAssetCount() {
            return this.failedAssetCount;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getTotalAssetCount() {
            return this.totalAssetCount;
        }

        public final AssetLoadProgress copy(AssetEntity asset, int successfulAssetCount, int failedAssetCount, int totalAssetCount) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            return new AssetLoadProgress(asset, successfulAssetCount, failedAssetCount, totalAssetCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AssetLoadProgress)) {
                return false;
            }
            AssetLoadProgress assetLoadProgress = (AssetLoadProgress) other;
            return Intrinsics.areEqual(this.asset, assetLoadProgress.asset) && this.successfulAssetCount == assetLoadProgress.successfulAssetCount && this.failedAssetCount == assetLoadProgress.failedAssetCount && this.totalAssetCount == assetLoadProgress.totalAssetCount;
        }

        public int hashCode() {
            return (((((this.asset.hashCode() * 31) + Integer.hashCode(this.successfulAssetCount)) * 31) + Integer.hashCode(this.failedAssetCount)) * 31) + Integer.hashCode(this.totalAssetCount);
        }

        public String toString() {
            return "AssetLoadProgress(asset=" + this.asset + ", successfulAssetCount=" + this.successfulAssetCount + ", failedAssetCount=" + this.failedAssetCount + ", totalAssetCount=" + this.totalAssetCount + ")";
        }

        public AssetLoadProgress(AssetEntity asset, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            this.asset = asset;
            this.successfulAssetCount = i;
            this.failedAssetCount = i2;
            this.totalAssetCount = i3;
        }

        public final AssetEntity getAsset() {
            return this.asset;
        }

        public final int getSuccessfulAssetCount() {
            return this.successfulAssetCount;
        }

        public final int getFailedAssetCount() {
            return this.failedAssetCount;
        }

        public final int getTotalAssetCount() {
            return this.totalAssetCount;
        }
    }

    public final void assetLoadProgressListener(AssetEntity asset, double progress) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        this.assetProgressMap.put(asset, Double.valueOf(progress));
        notifyAssetLoadProgress();
    }

    private final void notifyAssetLoadProgress() {
        if (this.assetTotal > 0) {
            double dSumOfDouble = CollectionsKt.sumOfDouble(this.assetProgressMap.values()) / ((double) this.assetTotal);
            Function1<? super Double, Unit> function1 = this.assetLoadProgressBlock;
            if (function1 != null) {
                function1.invoke(Double.valueOf(dSumOfDouble));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object load(Function1<? super UpdateResponse, OnUpdateResponseLoadedResult> function1, Continuation<? super LoaderResult> continuation) throws Exception {
        C09341 c09341;
        if (continuation instanceof C09341) {
            c09341 = (C09341) continuation;
            if ((c09341.label & Integer.MIN_VALUE) != 0) {
                c09341.label -= Integer.MIN_VALUE;
            } else {
                c09341 = new C09341(continuation);
            }
        } else {
            c09341 = new C09341(continuation);
        }
        Object objLoadRemoteUpdate = c09341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09341.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objLoadRemoteUpdate);
                UpdatesDatabase updatesDatabase = this.database;
                UpdatesConfiguration updatesConfiguration = this.configuration;
                c09341.L$0 = function1;
                c09341.label = 1;
                objLoadRemoteUpdate = loadRemoteUpdate(updatesDatabase, updatesConfiguration, c09341);
                if (objLoadRemoteUpdate == coroutine_suspended) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objLoadRemoteUpdate);
                return objLoadRemoteUpdate;
            }
            function1 = (Function1) c09341.L$0;
            ResultKt.throwOnFailure(objLoadRemoteUpdate);
            UpdateResponse updateResponse = (UpdateResponse) objLoadRemoteUpdate;
            this.updateResponse = updateResponse;
            UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart = updateResponse.getManifestUpdateResponsePart();
            Update update = manifestUpdateResponsePart != null ? manifestUpdateResponsePart.getUpdate() : null;
            OnUpdateResponseLoadedResult onUpdateResponseLoadedResultInvoke = function1.invoke(updateResponse);
            if (update != null && onUpdateResponseLoadedResultInvoke.getShouldDownloadManifestIfPresentInResponse()) {
                c09341.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                c09341.L$1 = SpillingKt.nullOutSpilledVariable(updateResponse);
                c09341.L$2 = SpillingKt.nullOutSpilledVariable(update);
                c09341.L$3 = SpillingKt.nullOutSpilledVariable(onUpdateResponseLoadedResultInvoke);
                c09341.label = 2;
                Object objProcessUpdate = processUpdate(update, c09341);
                return objProcessUpdate == coroutine_suspended ? coroutine_suspended : objProcessUpdate;
            }
            this.updateEntity = null;
            return finish();
        } catch (Exception e) {
            this.logger.error("Load error", e, UpdatesErrorCode.UpdateFailedToLoad);
            throw e;
        }
    }

    private final void reset() {
        this.updateResponse = null;
        this.updateEntity = null;
        this.assetTotal = 0;
        List<AssetEntity> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(listSynchronizedList, "synchronizedList(...)");
        this.erroredAssetList = listSynchronizedList;
        List<AssetEntity> listSynchronizedList2 = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(listSynchronizedList2, "synchronizedList(...)");
        this.existingAssetList = listSynchronizedList2;
        List<AssetEntity> listSynchronizedList3 = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(listSynchronizedList3, "synchronizedList(...)");
        this.finishedAssetList = listSynchronizedList3;
        this.assetProgressMap = new ConcurrentHashMap();
        this.assetLoadProgressBlock = null;
    }

    private final LoaderResult finish() {
        UpdateResponse updateResponse = this.updateResponse;
        Intrinsics.checkNotNull(updateResponse);
        ResponseHeaderData responseHeaderData = updateResponse.getResponseHeaderData();
        if (responseHeaderData != null) {
            ManifestMetadata.INSTANCE.saveMetadata(responseHeaderData, this.database, this.configuration);
        }
        UpdateResponse updateResponse2 = this.updateResponse;
        Intrinsics.checkNotNull(updateResponse2);
        UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart = updateResponse2.getDirectiveUpdateResponsePart();
        LoaderResult loaderResult = new LoaderResult(this.updateEntity, directiveUpdateResponsePart != null ? directiveUpdateResponsePart.getUpdateDirective() : null);
        reset();
        return loaderResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processUpdate(Update update, Continuation<? super LoaderResult> continuation) {
        if (update.getIsDevelopmentMode()) {
            UpdateEntity updateEntity = update.getUpdateEntity();
            UpdateDao updateDao = this.database.updateDao();
            Intrinsics.checkNotNull(updateEntity);
            updateDao.insertUpdate(updateEntity);
            this.database.updateDao().markUpdateFinished(updateEntity);
            this.updateEntity = updateEntity;
            return finish();
        }
        UpdateEntity updateEntity2 = update.getUpdateEntity();
        UpdateDao updateDao2 = this.database.updateDao();
        Intrinsics.checkNotNull(updateEntity2);
        UpdateEntity updateEntityLoadUpdateWithId = updateDao2.loadUpdateWithId(updateEntity2.getId());
        if (updateEntityLoadUpdateWithId != null && !Intrinsics.areEqual(updateEntityLoadUpdateWithId.getScopeKey(), updateEntity2.getScopeKey())) {
            UpdatesLogger.warn$default(this.logger, "Loaded an update with the same ID but a different scopeKey than one we already have on disk. This is a server error. Overwriting the scopeKey and loading the existing update.", null, 2, null);
            this.database.updateDao().setUpdateScopeKey(updateEntityLoadUpdateWithId, updateEntity2.getScopeKey());
        }
        if (updateEntityLoadUpdateWithId != null && updateEntityLoadUpdateWithId.getStatus() == UpdateStatus.READY && this.database.updateDao().loadLaunchAssetForUpdate(updateEntityLoadUpdateWithId.getId()) != null) {
            this.updateEntity = updateEntityLoadUpdateWithId;
            return finish();
        }
        boolean z = false;
        if (updateEntityLoadUpdateWithId == null) {
            this.updateEntity = updateEntity2;
            z = updateEntity2.getStatus() == UpdateStatus.EMBEDDED;
            if (!z) {
                UpdateDao updateDao3 = this.database.updateDao();
                UpdateEntity updateEntity3 = this.updateEntity;
                Intrinsics.checkNotNull(updateEntity3);
                updateDao3.insertUpdate(updateEntity3);
            }
        } else {
            this.updateEntity = updateEntityLoadUpdateWithId;
        }
        return downloadAllAssets(update, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:31:0x0114  */
    /* JADX WARN: Code duplicated, block: B:34:0x012d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0179 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, expo.modules.updates.db.entity.AssetEntity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7, types: [T, expo.modules.updates.db.entity.AssetEntity, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0170 -> B:39:0x0174). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object downloadAllAssets(expo.modules.updates.manifest.Update r23, boolean r24, kotlin.coroutines.Continuation<? super expo.modules.updates.loader.Loader.LoaderResult> r25) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.loader.Loader.downloadAllAssets(expo.modules.updates.manifest.Update, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.Loader$downloadAllAssets$2, reason: invalid class name */
    /* JADX INFO: compiled from: Loader.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.Loader$downloadAllAssets$2", f = "Loader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $insertUpdateEntityOnFinish;
        int label;
        final /* synthetic */ Loader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, Loader loader, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$insertUpdateEntityOnFinish = z;
            this.this$0 = loader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$insertUpdateEntityOnFinish, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte[] bArrSha256;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.$insertUpdateEntityOnFinish) {
                UpdateDao updateDao = this.this$0.database.updateDao();
                UpdateEntity updateEntity = this.this$0.updateEntity;
                Intrinsics.checkNotNull(updateEntity);
                updateDao.insertUpdate(updateEntity);
            }
            for (AssetEntity assetEntity : this.this$0.existingAssetList) {
                AssetDao assetDao = this.this$0.database.assetDao();
                UpdateEntity updateEntity2 = this.this$0.updateEntity;
                Intrinsics.checkNotNull(updateEntity2);
                if (!assetDao.addExistingAssetToUpdate(updateEntity2, assetEntity, assetEntity.getIsLaunchAsset())) {
                    try {
                        bArrSha256 = UpdatesUtils.INSTANCE.sha256(new File(this.this$0.updatesDirectory, assetEntity.getRelativePath()));
                    } catch (Exception unused) {
                        bArrSha256 = null;
                    }
                    assetEntity.setDownloadTime(new Date());
                    assetEntity.setHash(bArrSha256);
                    this.this$0.finishedAssetList.add(assetEntity);
                }
            }
            AssetDao assetDao2 = this.this$0.database.assetDao();
            List<AssetEntity> list = this.this$0.finishedAssetList;
            UpdateEntity updateEntity3 = this.this$0.updateEntity;
            Intrinsics.checkNotNull(updateEntity3);
            assetDao2.insertAssets(list, updateEntity3);
            UpdateDao updateDao2 = this.this$0.database.updateDao();
            UpdateEntity updateEntity4 = this.this$0.updateEntity;
            Intrinsics.checkNotNull(updateEntity4);
            updateDao2.markUpdateFinished(updateEntity4);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleAssetDownloadCompleted(AssetEntity assetEntity, AssetLoadResult assetLoadResult, Continuation<? super AssetLoadResult> continuation) {
        C09331 c09331;
        if (continuation instanceof C09331) {
            c09331 = (C09331) continuation;
            if ((c09331.label & Integer.MIN_VALUE) != 0) {
                c09331.label -= Integer.MIN_VALUE;
            } else {
                c09331 = new C09331(continuation);
            }
        } else {
            c09331 = new C09331(continuation);
        }
        Object obj = c09331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09331.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AssetLoadResult assetLoadResult2 = (AssetLoadResult) c09331.L$1;
            ResultKt.throwOnFailure(obj);
            return assetLoadResult2;
        }
        ResultKt.throwOnFailure(obj);
        int i2 = WhenMappings.$EnumSwitchMapping$0[assetLoadResult.ordinal()];
        if (i2 == 1) {
            this.finishedAssetList.add(assetEntity);
        } else if (i2 == 2) {
            this.existingAssetList.add(assetEntity);
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.erroredAssetList.add(assetEntity);
        }
        if (assetLoadResult == AssetLoadResult.FINISHED || assetLoadResult == AssetLoadResult.ALREADY_EXISTS) {
            this.assetProgressMap.put(assetEntity, Boxing.boxDouble(1.0d));
            notifyAssetLoadProgress();
        }
        MutableSharedFlow<AssetLoadProgress> mutableSharedFlow = this._progressFlow;
        AssetLoadProgress assetLoadProgress = new AssetLoadProgress(assetEntity, this.finishedAssetList.size() + this.existingAssetList.size(), this.erroredAssetList.size(), this.assetTotal);
        c09331.L$0 = SpillingKt.nullOutSpilledVariable(assetEntity);
        c09331.L$1 = assetLoadResult;
        c09331.label = 1;
        return mutableSharedFlow.emit(assetLoadProgress, c09331) == coroutine_suspended ? coroutine_suspended : assetLoadResult;
    }
}
