package expo.modules.updates.launcher;

import android.content.Context;
import android.net.Uri;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.cast.MediaError;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.dao.AssetDao;
import expo.modules.updates.db.dao.UpdateDao;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.LoaderFiles;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.EmbeddedManifestUtils;
import expo.modules.updates.manifest.EmbeddedUpdate;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.eac.EACTags;
import org.json.JSONObject;

/* JADX INFO: compiled from: DatabaseLauncher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0086@¢\u0006\u0002\u00100J\u0018\u00101\u001a\u0004\u0018\u00010\u00172\u0006\u0010.\u001a\u00020/H\u0086@¢\u0006\u0002\u00100J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b0!H\u0002J2\u00103\u001a\u0004\u0018\u00010\u00072\u0006\u00104\u001a\u00020\"2\u0006\u0010.\u001a\u00020/2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H\u0087@¢\u0006\u0002\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR:\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b\u0018\u00010!2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b\u0018\u00010!@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\n\u0018\u00010)j\u0004\u0018\u0001`*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lexpo/modules/updates/launcher/DatabaseLauncher;", "Lexpo/modules/updates/launcher/Launcher;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "updatesDirectory", "Ljava/io/File;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "shouldCopyEmbeddedAssets", "", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Ljava/io/File;Lexpo/modules/updates/loader/FileDownloader;Lexpo/modules/updates/selectionpolicy/SelectionPolicy;Lexpo/modules/updates/logging/UpdatesLogger;Lkotlinx/coroutines/CoroutineScope;Z)V", "loaderFiles", "Lexpo/modules/updates/loader/LoaderFiles;", "value", "Lexpo/modules/updates/db/entity/UpdateEntity;", "launchedUpdate", "getLaunchedUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "", "launchAssetFile", "getLaunchAssetFile", "()Ljava/lang/String;", "bundleAssetName", "getBundleAssetName", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "localAssetFiles", "getLocalAssetFiles", "()Ljava/util/Map;", "isUsingEmbeddedAssets", "()Z", "launchAssetException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "hasLaunched", "launch", "", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "(Lexpo/modules/updates/db/UpdatesDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLaunchableUpdate", "embeddedAssetFileMap", "ensureAssetExists", UriUtil.LOCAL_ASSET_SCHEME, "embeddedUpdate", "Lexpo/modules/updates/manifest/EmbeddedUpdate;", "extraHeaders", "Lorg/json/JSONObject;", "(Lexpo/modules/updates/db/entity/AssetEntity;Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/manifest/EmbeddedUpdate;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatabaseLauncher implements Launcher {
    private static final String TAG = "DatabaseLauncher";
    private String bundleAssetName;
    private final UpdatesConfiguration configuration;
    private final Context context;
    private final FileDownloader fileDownloader;
    private boolean hasLaunched;
    private Exception launchAssetException;
    private String launchAssetFile;
    private UpdateEntity launchedUpdate;
    private final LoaderFiles loaderFiles;
    private Map<AssetEntity, String> localAssetFiles;
    private final UpdatesLogger logger;
    private final CoroutineScope scope;
    private final SelectionPolicy selectionPolicy;
    private final boolean shouldCopyEmbeddedAssets;
    private final File updatesDirectory;

    /* JADX INFO: renamed from: expo.modules.updates.launcher.DatabaseLauncher$ensureAssetExists$1, reason: invalid class name */
    /* JADX INFO: compiled from: DatabaseLauncher.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.launcher.DatabaseLauncher", f = "DatabaseLauncher.kt", i = {0, 0, 0, 0, 0, 0}, l = {GlobalMediaRouter.CallbackHandler.MSG_ROUTE_REMOVED}, m = "ensureAssetExists", n = {UriUtil.LOCAL_ASSET_SCHEME, "database", "embeddedUpdate", "extraHeaders", "assetFile", "assetFileExists"}, nl = {GlobalMediaRouter.CallbackHandler.MSG_ROUTE_DISCONNECTED}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return DatabaseLauncher.this.ensureAssetExists(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.launcher.DatabaseLauncher$launch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DatabaseLauncher.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.launcher.DatabaseLauncher", f = "DatabaseLauncher.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID, MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE, 139}, m = "launch", n = {"database", "database", "launchAsset", "embeddedUpdate", "extraHeaders", "embeddedLaunchAsset", "database", "launchAsset", "embeddedUpdate", "extraHeaders", "embeddedLaunchAsset", "launchAssetFile", "assetEntities", "$this$launch_u24lambda_u242", "downloadJobs", "$i$a$-apply-DatabaseLauncher$launch$2"}, nl = {78, 111, 291}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "I$0"}, v = 2)
    static final class C09301 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C09301(Continuation<? super C09301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatabaseLauncher.this.launch(null, this);
        }
    }

    public DatabaseLauncher(Context context, UpdatesConfiguration configuration, File updatesDirectory, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger logger, CoroutineScope scope, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.context = context;
        this.configuration = configuration;
        this.updatesDirectory = updatesDirectory;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.logger = logger;
        this.scope = scope;
        this.shouldCopyEmbeddedAssets = z;
        this.loaderFiles = new LoaderFiles();
    }

    public /* synthetic */ DatabaseLauncher(Context context, UpdatesConfiguration updatesConfiguration, File file, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger updatesLogger, CoroutineScope coroutineScope, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, updatesConfiguration, file, fileDownloader, selectionPolicy, updatesLogger, coroutineScope, (i & 128) != 0 ? false : z);
    }

    @Override // expo.modules.updates.launcher.Launcher
    public UpdateEntity getLaunchedUpdate() {
        return this.launchedUpdate;
    }

    @Override // expo.modules.updates.launcher.Launcher
    public String getLaunchAssetFile() {
        return this.launchAssetFile;
    }

    @Override // expo.modules.updates.launcher.Launcher
    public String getBundleAssetName() {
        return this.bundleAssetName;
    }

    @Override // expo.modules.updates.launcher.Launcher
    /* JADX INFO: renamed from: getLocalAssetFiles */
    public Map<AssetEntity, String> mo12144getLocalAssetFiles() {
        return this.localAssetFiles;
    }

    @Override // expo.modules.updates.launcher.Launcher
    public boolean isUsingEmbeddedAssets() {
        return mo12144getLocalAssetFiles() == null;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0270 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0256 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x018a  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:79:0x024e  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:83:0x025c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0281  */
    /* JADX WARN: Code duplicated, block: B:91:0x0286  */
    public final Object launch(UpdatesDatabase updatesDatabase, Continuation<? super Unit> continuation) throws Exception {
        C09301 c09301;
        Object obj;
        UpdatesDatabase updatesDatabase2;
        DatabaseLauncher databaseLauncher;
        AssetEntity assetEntityLoadLaunchAssetForUpdate;
        String str;
        JSONObject jSONObject;
        Object obj2;
        EmbeddedUpdate embeddedUpdate;
        UpdatesDatabase updatesDatabase3;
        List<AssetEntity> assetEntityList;
        Object next;
        String embeddedAssetFilename;
        Exception exc;
        Map<AssetEntity, String> mapEmbeddedAssetFileMap;
        ArrayList arrayList;
        Map<AssetEntity, String> map;
        Map<AssetEntity, String> map2;
        String relativePath;
        AssetEntity assetEntity;
        File file;
        DatabaseLauncher databaseLauncher2 = this;
        if (continuation instanceof C09301) {
            c09301 = (C09301) continuation;
            if ((c09301.label & Integer.MIN_VALUE) != 0) {
                c09301.label -= Integer.MIN_VALUE;
            } else {
                c09301 = databaseLauncher2.new C09301(continuation);
            }
        } else {
            c09301 = databaseLauncher2.new C09301(continuation);
        }
        C09301 c09302 = c09301;
        Object objAwaitAll = c09302.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09302.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitAll);
            if (databaseLauncher2.hasLaunched) {
                throw new AssertionError("DatabaseLauncher has already started. Create a new instance in order to launch a new version.");
            }
            databaseLauncher2.hasLaunched = true;
            c09302.L$0 = updatesDatabase;
            c09302.L$1 = databaseLauncher2;
            c09302.label = 1;
            Object launchableUpdate = databaseLauncher2.getLaunchableUpdate(updatesDatabase, c09302);
            if (launchableUpdate != coroutine_suspended) {
                obj = launchableUpdate;
                updatesDatabase2 = updatesDatabase;
                databaseLauncher = databaseLauncher2;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            databaseLauncher = (DatabaseLauncher) c09302.L$1;
            UpdatesDatabase updatesDatabase4 = (UpdatesDatabase) c09302.L$0;
            ResultKt.throwOnFailure(objAwaitAll);
            obj = objAwaitAll;
            updatesDatabase2 = updatesDatabase4;
        } else {
            if (i == 2) {
                String str2 = (String) c09302.L$4;
                JSONObject jSONObject2 = (JSONObject) c09302.L$3;
                embeddedUpdate = (EmbeddedUpdate) c09302.L$2;
                AssetEntity assetEntity2 = (AssetEntity) c09302.L$1;
                UpdatesDatabase updatesDatabase5 = (UpdatesDatabase) c09302.L$0;
                ResultKt.throwOnFailure(objAwaitAll);
                jSONObject = jSONObject2;
                updatesDatabase3 = updatesDatabase5;
                c09302 = c09302;
                str = str2;
                obj2 = objAwaitAll;
                assetEntityLoadLaunchAssetForUpdate = assetEntity2;
                if (obj2 != null) {
                    databaseLauncher2.launchAssetFile = obj2.toString();
                    AssetDao assetDao = updatesDatabase3.assetDao();
                    UpdateEntity launchedUpdate = databaseLauncher2.getLaunchedUpdate();
                    Intrinsics.checkNotNull(launchedUpdate);
                    List<AssetEntity> listLoadAssetsForUpdate = assetDao.loadAssetsForUpdate(launchedUpdate.getId());
                    mapEmbeddedAssetFileMap = databaseLauncher2.embeddedAssetFileMap();
                    arrayList = new ArrayList();
                    for (AssetEntity assetEntity3 : listLoadAssetsForUpdate) {
                        if (assetEntity3.getId() != assetEntityLoadLaunchAssetForUpdate.getId() && (relativePath = assetEntity3.getRelativePath()) != null) {
                            if (!AndroidResourceAssetUtils.INSTANCE.isAndroidResourceAsset(relativePath)) {
                                CoroutineScope coroutineScope = databaseLauncher2.scope;
                                databaseLauncher2 = this;
                                Boxing.boxBoolean(arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new DatabaseLauncher$launch$2$job$1(this, assetEntity3, updatesDatabase3, embeddedUpdate, jSONObject, null), 3, null)));
                            } else {
                                mapEmbeddedAssetFileMap.put(assetEntity3, relativePath);
                            }
                        }
                    }
                    c09302.L$0 = SpillingKt.nullOutSpilledVariable(updatesDatabase3);
                    c09302.L$1 = SpillingKt.nullOutSpilledVariable(assetEntityLoadLaunchAssetForUpdate);
                    c09302.L$2 = SpillingKt.nullOutSpilledVariable(embeddedUpdate);
                    c09302.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                    c09302.L$4 = SpillingKt.nullOutSpilledVariable(str);
                    c09302.L$5 = SpillingKt.nullOutSpilledVariable(obj2);
                    c09302.L$6 = SpillingKt.nullOutSpilledVariable(listLoadAssetsForUpdate);
                    c09302.L$7 = mapEmbeddedAssetFileMap;
                    c09302.L$8 = mapEmbeddedAssetFileMap;
                    c09302.L$9 = SpillingKt.nullOutSpilledVariable(arrayList);
                    c09302.L$10 = databaseLauncher2;
                    c09302.I$0 = 0;
                    c09302.label = 3;
                    objAwaitAll = AwaitKt.awaitAll(arrayList, c09302);
                    if (objAwaitAll != coroutine_suspended) {
                        map = mapEmbeddedAssetFileMap;
                        map2 = map;
                    }
                    return coroutine_suspended;
                }
                exc = databaseLauncher2.launchAssetException;
                if (exc == null) {
                    exc = new Exception("Launch asset file was null after download attempt");
                }
                throw exc;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c09302.I$0;
            databaseLauncher2 = (DatabaseLauncher) c09302.L$10;
            map = (Map) c09302.L$8;
            map2 = (Map) c09302.L$7;
            Object obj3 = c09302.L$5;
            ResultKt.throwOnFailure(objAwaitAll);
        }
        for (Pair pair : (Iterable) objAwaitAll) {
            assetEntity = (AssetEntity) pair.component1();
            file = (File) pair.component2();
            if (file != null) {
                map.put(assetEntity, Uri.fromFile(file).toString());
            }
        }
        databaseLauncher2.localAssetFiles = map2;
        return Unit.INSTANCE;
        databaseLauncher.launchedUpdate = (UpdateEntity) obj;
        if (databaseLauncher2.getLaunchedUpdate() == null) {
            throw new Exception("No launchable update was found. If this is a generic app, ensure expo-updates is configured correctly.");
        }
        UpdateDao updateDao = updatesDatabase2.updateDao();
        UpdateEntity launchedUpdate2 = databaseLauncher2.getLaunchedUpdate();
        Intrinsics.checkNotNull(launchedUpdate2);
        updateDao.markUpdateAccessed(launchedUpdate2);
        UpdateEntity launchedUpdate3 = databaseLauncher2.getLaunchedUpdate();
        Intrinsics.checkNotNull(launchedUpdate3);
        if (launchedUpdate3.getStatus() == UpdateStatus.DEVELOPMENT) {
            return Unit.INSTANCE;
        }
        UpdateDao updateDao2 = updatesDatabase2.updateDao();
        UpdateEntity launchedUpdate4 = databaseLauncher2.getLaunchedUpdate();
        Intrinsics.checkNotNull(launchedUpdate4);
        assetEntityLoadLaunchAssetForUpdate = updateDao2.loadLaunchAssetForUpdate(launchedUpdate4.getId());
        if (assetEntityLoadLaunchAssetForUpdate == null) {
            UpdateEntity launchedUpdate5 = databaseLauncher2.getLaunchedUpdate();
            Intrinsics.checkNotNull(launchedUpdate5);
            throw new Exception("Launch asset not found for update. The update row has no launch asset; an interrupted registration in an older version of expo-updates can leave an update in this state, and it is replaced once a newer update is downloaded. Debug info: " + launchedUpdate5.debugInfo());
        }
        if (assetEntityLoadLaunchAssetForUpdate.getRelativePath() == null) {
            UpdateEntity launchedUpdate6 = databaseLauncher2.getLaunchedUpdate();
            Intrinsics.checkNotNull(launchedUpdate6);
            throw new Exception("Launch asset relative path should not be null. Debug info: " + launchedUpdate6.debugInfo());
        }
        EmbeddedUpdate embeddedUpdate2 = EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(databaseLauncher2.context, databaseLauncher2.configuration);
        str = null;
        JSONObject extraHeadersForRemoteAssetRequest = FileDownloader.INSTANCE.getExtraHeadersForRemoteAssetRequest(databaseLauncher2.getLaunchedUpdate(), embeddedUpdate2 != null ? embeddedUpdate2.getUpdateEntity() : null, null);
        if (!databaseLauncher2.shouldCopyEmbeddedAssets && embeddedUpdate2 != null && (assetEntityList = embeddedUpdate2.getAssetEntityList()) != null) {
            Iterator<T> it = assetEntityList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((AssetEntity) next).getKey(), assetEntityLoadLaunchAssetForUpdate.getKey()));
            AssetEntity assetEntity4 = (AssetEntity) next;
            if (assetEntity4 != null && (embeddedAssetFilename = assetEntity4.getEmbeddedAssetFilename()) != null) {
                str = "assets://" + embeddedAssetFilename;
            }
        }
        if (str == null) {
            c09302.L$0 = updatesDatabase2;
            c09302.L$1 = assetEntityLoadLaunchAssetForUpdate;
            c09302.L$2 = embeddedUpdate2;
            c09302.L$3 = extraHeadersForRemoteAssetRequest;
            c09302.L$4 = SpillingKt.nullOutSpilledVariable(str);
            c09302.label = 2;
            Object objEnsureAssetExists = databaseLauncher2.ensureAssetExists(assetEntityLoadLaunchAssetForUpdate, updatesDatabase2, embeddedUpdate2, extraHeadersForRemoteAssetRequest, c09302);
            if (objEnsureAssetExists != coroutine_suspended) {
                jSONObject = extraHeadersForRemoteAssetRequest;
                obj2 = objEnsureAssetExists;
            }
            return coroutine_suspended;
        }
        jSONObject = extraHeadersForRemoteAssetRequest;
        obj2 = str;
        embeddedUpdate = embeddedUpdate2;
        updatesDatabase3 = updatesDatabase2;
        if (obj2 != null) {
            databaseLauncher2.launchAssetFile = obj2.toString();
            AssetDao assetDao2 = updatesDatabase3.assetDao();
            UpdateEntity launchedUpdate7 = databaseLauncher2.getLaunchedUpdate();
            Intrinsics.checkNotNull(launchedUpdate7);
            List<AssetEntity> listLoadAssetsForUpdate2 = assetDao2.loadAssetsForUpdate(launchedUpdate7.getId());
            mapEmbeddedAssetFileMap = databaseLauncher2.embeddedAssetFileMap();
            arrayList = new ArrayList();
            while (r16.hasNext()) {
                if (assetEntity3.getId() != assetEntityLoadLaunchAssetForUpdate.getId()) {
                    if (!AndroidResourceAssetUtils.INSTANCE.isAndroidResourceAsset(relativePath)) {
                        CoroutineScope coroutineScope2 = databaseLauncher2.scope;
                        databaseLauncher2 = this;
                        Boxing.boxBoolean(arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, new DatabaseLauncher$launch$2$job$1(this, assetEntity3, updatesDatabase3, embeddedUpdate, jSONObject, null), 3, null)));
                    } else {
                        mapEmbeddedAssetFileMap.put(assetEntity3, relativePath);
                    }
                }
            }
            c09302.L$0 = SpillingKt.nullOutSpilledVariable(updatesDatabase3);
            c09302.L$1 = SpillingKt.nullOutSpilledVariable(assetEntityLoadLaunchAssetForUpdate);
            c09302.L$2 = SpillingKt.nullOutSpilledVariable(embeddedUpdate);
            c09302.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
            c09302.L$4 = SpillingKt.nullOutSpilledVariable(str);
            c09302.L$5 = SpillingKt.nullOutSpilledVariable(obj2);
            c09302.L$6 = SpillingKt.nullOutSpilledVariable(listLoadAssetsForUpdate2);
            c09302.L$7 = mapEmbeddedAssetFileMap;
            c09302.L$8 = mapEmbeddedAssetFileMap;
            c09302.L$9 = SpillingKt.nullOutSpilledVariable(arrayList);
            c09302.L$10 = databaseLauncher2;
            c09302.I$0 = 0;
            c09302.label = 3;
            objAwaitAll = AwaitKt.awaitAll(arrayList, c09302);
            if (objAwaitAll != coroutine_suspended) {
                map = mapEmbeddedAssetFileMap;
                map2 = map;
                while (r2.hasNext()) {
                    assetEntity = (AssetEntity) pair.component1();
                    file = (File) pair.component2();
                    if (file != null) {
                        map.put(assetEntity, Uri.fromFile(file).toString());
                    }
                }
                databaseLauncher2.localAssetFiles = map2;
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        exc = databaseLauncher2.launchAssetException;
        if (exc == null) {
            exc = new Exception("Launch asset file was null after download attempt");
        }
        throw exc;
    }

    public final Object getLaunchableUpdate(UpdatesDatabase updatesDatabase, Continuation<? super UpdateEntity> continuation) {
        UpdateEntity updateEntity;
        UpdateEntity updateEntity2;
        List<UpdateEntity> listLoadLaunchableUpdatesForScope = updatesDatabase.updateDao().loadLaunchableUpdatesForScope(this.configuration.getScopeKey());
        EmbeddedUpdate originalEmbeddedUpdate = EmbeddedManifestUtils.INSTANCE.getOriginalEmbeddedUpdate(this.context, this.configuration);
        ArrayList arrayList = new ArrayList();
        for (UpdateEntity updateEntity3 : listLoadLaunchableUpdatesForScope) {
            if (updateEntity3.getStatus() == UpdateStatus.EMBEDDED) {
                if (!Intrinsics.areEqual((originalEmbeddedUpdate == null || (updateEntity2 = originalEmbeddedUpdate.getUpdateEntity()) == null) ? null : updateEntity2.getId(), updateEntity3.getId())) {
                }
            }
            if (!this.configuration.getHasEmbeddedUpdate()) {
                if (Intrinsics.areEqual((originalEmbeddedUpdate == null || (updateEntity = originalEmbeddedUpdate.getUpdateEntity()) == null) ? null : updateEntity.getId(), updateEntity3.getId())) {
                }
            }
            if (updateEntity3.getStatus() != UpdateStatus.DEVELOPMENT && updatesDatabase.updateDao().loadLaunchAssetForUpdate(updateEntity3.getId()) == null) {
                UpdatesLogger.warn$default(this.logger, "Skipping launchable update with no launch asset. Debug info: " + updateEntity3.debugInfo(), null, 2, null);
            } else {
                arrayList.add(updateEntity3);
            }
        }
        return this.selectionPolicy.selectUpdateToLaunch(arrayList, ManifestMetadata.INSTANCE.getManifestFilters(updatesDatabase, this.configuration));
    }

    private final Map<AssetEntity, String> embeddedAssetFileMap() throws NoSuchAlgorithmException, IOException {
        List<AssetEntity> listEmptyList;
        EmbeddedUpdate embeddedUpdate = EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(this.context, this.configuration);
        if (embeddedUpdate == null || (listEmptyList = embeddedUpdate.getAssetEntityList()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        UpdatesLogger.info$default(this.logger, "embeddedAssetFileMap: embeddedAssets count = " + listEmptyList.size(), null, 2, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AssetEntity assetEntity : listEmptyList) {
            if (!assetEntity.getIsLaunchAsset()) {
                if (!this.shouldCopyEmbeddedAssets) {
                    String strCreateEmbeddedFilenameForAsset = AndroidResourceAssetUtils.INSTANCE.createEmbeddedFilenameForAsset(assetEntity);
                    if (strCreateEmbeddedFilenameForAsset != null) {
                        assetEntity.setRelativePath(strCreateEmbeddedFilenameForAsset);
                        linkedHashMap.put(assetEntity, strCreateEmbeddedFilenameForAsset);
                        UpdatesLogger.info$default(this.logger, "embeddedAssetFileMap: " + assetEntity.getKey() + WebViewLogEventConsumer.DDTAGS_SEPARATOR + assetEntity.getType() + " => " + linkedHashMap.get(assetEntity), null, 2, null);
                    } else {
                        Exception exc = new Exception("Missing embedded asset");
                        this.logger.error("embeddedAssetFileMap: no file for " + assetEntity.getKey() + WebViewLogEventConsumer.DDTAGS_SEPARATOR + assetEntity.getType(), exc, UpdatesErrorCode.AssetsFailedToLoad);
                    }
                } else {
                    String strCreateFilenameForAsset = UpdatesUtils.INSTANCE.createFilenameForAsset(assetEntity);
                    assetEntity.setRelativePath(strCreateFilenameForAsset);
                    File file = new File(this.updatesDirectory, strCreateFilenameForAsset);
                    if (!file.exists()) {
                        this.loaderFiles.copyAssetAndGetHash(assetEntity, file, this.context);
                    }
                    if (file.exists()) {
                        linkedHashMap.put(assetEntity, Uri.fromFile(file).toString());
                        UpdatesLogger.info$default(this.logger, "embeddedAssetFileMap: " + assetEntity.getKey() + WebViewLogEventConsumer.DDTAGS_SEPARATOR + assetEntity.getType() + " => " + linkedHashMap.get(assetEntity), null, 2, null);
                    } else {
                        Exception exc2 = new Exception("Missing embedded asset");
                        this.logger.error("embeddedAssetFileMap: no file for " + assetEntity.getKey() + WebViewLogEventConsumer.DDTAGS_SEPARATOR + assetEntity.getType(), exc2, UpdatesErrorCode.AssetsFailedToLoad);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x012d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v5 */
    public final Object ensureAssetExists(AssetEntity assetEntity, UpdatesDatabase updatesDatabase, EmbeddedUpdate embeddedUpdate, JSONObject jSONObject, Continuation<? super File> continuation) {
        AnonymousClass1 anonymousClass1;
        AssetEntity assetEntity2;
        UpdatesDatabase updatesDatabase2;
        AssetEntity next;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objDownloadAsset$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        File file = null;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadAsset$default);
            File file2 = this.updatesDirectory;
            String relativePath = assetEntity.getRelativePath();
            if (relativePath == null) {
                relativePath = "";
            }
            File file3 = new File(file2, relativePath);
            ?? Exists = file3.exists();
            if (Exists == 0 && embeddedUpdate != null) {
                Iterator<AssetEntity> it = embeddedUpdate.getAssetEntityList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.getKey() != null && Intrinsics.areEqual(next.getKey(), assetEntity.getKey())) {
                        break;
                    }
                }
                if (next != null) {
                    try {
                        if (Arrays.equals(this.loaderFiles.copyAssetAndGetHash(next, file3, this.context), assetEntity.getHash())) {
                            Exists = 1;
                        }
                    } catch (Exception e) {
                        this.logger.error("Failed to copy matching embedded asset", e, UpdatesErrorCode.AssetsFailedToLoad);
                    }
                }
            }
            if (Exists != 0) {
                return file3;
            }
            try {
                FileDownloader fileDownloader = this.fileDownloader;
                File file4 = this.updatesDirectory;
                UpdateEntity launchedUpdate = getLaunchedUpdate();
                anonymousClass2.L$0 = assetEntity;
                updatesDatabase2 = updatesDatabase;
                anonymousClass2.L$1 = updatesDatabase2;
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(embeddedUpdate);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(file3);
                anonymousClass2.I$0 = Exists;
                anonymousClass2.label = 1;
                objDownloadAsset$default = FileDownloader.downloadAsset$default(fileDownloader, assetEntity, file4, jSONObject, launchedUpdate, null, null, null, anonymousClass2, 96, null);
                if (objDownloadAsset$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                assetEntity2 = assetEntity;
            } catch (Exception e2) {
                e = e2;
                assetEntity2 = assetEntity;
                this.logger.error("Failed to load asset from disk or network", e, UpdatesErrorCode.AssetsFailedToLoad);
                if (assetEntity2.getIsLaunchAsset()) {
                    this.launchAssetException = e;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass2.I$0;
            UpdatesDatabase updatesDatabase3 = (UpdatesDatabase) anonymousClass2.L$1;
            assetEntity2 = (AssetEntity) anonymousClass2.L$0;
            try {
                ResultKt.throwOnFailure(objDownloadAsset$default);
                updatesDatabase2 = updatesDatabase3;
            } catch (Exception e3) {
                e = e3;
                this.logger.error("Failed to load asset from disk or network", e, UpdatesErrorCode.AssetsFailedToLoad);
                if (assetEntity2.getIsLaunchAsset()) {
                    this.launchAssetException = e;
                }
            }
        }
        FileDownloader.AssetDownloadResult assetDownloadResult = (FileDownloader.AssetDownloadResult) objDownloadAsset$default;
        updatesDatabase2.assetDao().updateAsset(assetDownloadResult.getAssetEntity());
        File file5 = this.updatesDirectory;
        String relativePath2 = assetDownloadResult.getAssetEntity().getRelativePath();
        Intrinsics.checkNotNull(relativePath2);
        File file6 = new File(file5, relativePath2);
        if (file6.exists()) {
            file = file6;
        }
        return file;
    }
}
