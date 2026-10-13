package expo.modules.updates.loader;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.dao.UpdateDao;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.EmbeddedManifestUtils;
import expo.modules.updates.manifest.EmbeddedUpdate;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RemoteLoader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"BU\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015BM\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0094@¢\u0006\u0002\u0010\u001aJ:\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0094@¢\u0006\u0002\u0010!R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lexpo/modules/updates/loader/RemoteLoader;", "Lexpo/modules/updates/loader/Loader;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "mFileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "updatesDirectory", "Ljava/io/File;", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "loaderFiles", "Lexpo/modules/updates/loader/LoaderFiles;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/loader/FileDownloader;Ljava/io/File;Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/loader/LoaderFiles;Lkotlinx/coroutines/CoroutineScope;)V", "fileDownloader", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/loader/FileDownloader;Ljava/io/File;Lexpo/modules/updates/db/entity/UpdateEntity;Lkotlinx/coroutines/CoroutineScope;)V", "loadRemoteUpdate", "Lexpo/modules/updates/loader/UpdateResponse;", "(Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/UpdatesConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAsset", "Lexpo/modules/updates/loader/FileDownloader$AssetDownloadResult;", "assetEntity", "Lexpo/modules/updates/db/entity/AssetEntity;", "requestedUpdate", "embeddedUpdate", "(Lexpo/modules/updates/db/entity/AssetEntity;Ljava/io/File;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/db/entity/UpdateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RemoteLoader extends Loader {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "RemoteLoader";
    private final UpdateEntity launchedUpdate;
    private final LoaderFiles loaderFiles;
    private final FileDownloader mFileDownloader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteLoader(Context context, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database, FileDownloader mFileDownloader, File updatesDirectory, UpdateEntity updateEntity, LoaderFiles loaderFiles, CoroutineScope scope) {
        super(context, configuration, logger, database, updatesDirectory, loaderFiles, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(mFileDownloader, "mFileDownloader");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(loaderFiles, "loaderFiles");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.mFileDownloader = mFileDownloader;
        this.launchedUpdate = updateEntity;
        this.loaderFiles = loaderFiles;
    }

    public /* synthetic */ RemoteLoader(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, FileDownloader fileDownloader, File file, UpdateEntity updateEntity, LoaderFiles loaderFiles, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, updatesConfiguration, updatesLogger, updatesDatabase, fileDownloader, file, updateEntity, loaderFiles, (i & 256) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    public /* synthetic */ RemoteLoader(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, FileDownloader fileDownloader, File file, UpdateEntity updateEntity, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, updatesConfiguration, updatesLogger, updatesDatabase, fileDownloader, file, updateEntity, (i & 128) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RemoteLoader(Context context, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database, FileDownloader fileDownloader, File updatesDirectory, UpdateEntity updateEntity, CoroutineScope scope) {
        this(context, configuration, logger, database, fileDownloader, updatesDirectory, updateEntity, new LoaderFiles(), scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    @Override // expo.modules.updates.loader.Loader
    protected Object loadRemoteUpdate(UpdatesDatabase updatesDatabase, UpdatesConfiguration updatesConfiguration, Continuation<? super UpdateResponse> continuation) {
        Update embeddedUpdate = this.loaderFiles.readEmbeddedUpdate(getContext(), updatesConfiguration);
        return this.mFileDownloader.downloadRemoteUpdate(FileDownloader.INSTANCE.getExtraHeadersForRemoteUpdateRequest(updatesDatabase, updatesConfiguration, this.launchedUpdate, embeddedUpdate != null ? embeddedUpdate.getUpdateEntity() : null), continuation);
    }

    @Override // expo.modules.updates.loader.Loader
    protected Object loadAsset(final AssetEntity assetEntity, File file, final UpdatesConfiguration updatesConfiguration, UpdateEntity updateEntity, UpdateEntity updateEntity2, Continuation<? super FileDownloader.AssetDownloadResult> continuation) throws JSONException {
        return this.mFileDownloader.downloadAsset(assetEntity, file, FileDownloader.INSTANCE.getExtraHeadersForRemoteAssetRequest(this.launchedUpdate, updateEntity2, updateEntity), this.launchedUpdate, updateEntity, new Function1() { // from class: expo.modules.updates.loader.RemoteLoader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RemoteLoader.loadAsset$lambda$0(this.f$0, assetEntity, ((Double) obj).doubleValue());
            }
        }, new Function2() { // from class: expo.modules.updates.loader.RemoteLoader$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return RemoteLoader.loadAsset$lambda$1(this.f$0, updatesConfiguration, (AssetEntity) obj, (File) obj2);
            }
        }, continuation);
    }

    static final Unit loadAsset$lambda$1(RemoteLoader remoteLoader, UpdatesConfiguration updatesConfiguration, AssetEntity launchAsset, File destination) throws IOException {
        List<AssetEntity> assetEntityList;
        Object next;
        Intrinsics.checkNotNullParameter(launchAsset, "launchAsset");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Update embeddedUpdate = remoteLoader.loaderFiles.readEmbeddedUpdate(remoteLoader.getContext(), updatesConfiguration);
        if (embeddedUpdate != null && (assetEntityList = embeddedUpdate.getAssetEntityList()) != null) {
            Iterator<T> it = assetEntityList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((AssetEntity) next).getKey(), launchAsset.getKey()));
            AssetEntity assetEntity = (AssetEntity) next;
            if (assetEntity != null) {
                String embeddedAssetFilename = assetEntity.getEmbeddedAssetFilename();
                if (embeddedAssetFilename == null) {
                    throw new IOException("Embedded launch asset " + launchAsset.getKey() + " has no APK asset filename");
                }
                InputStream inputStreamOpen = remoteLoader.getContext().getAssets().open(embeddedAssetFilename);
                try {
                    InputStream inputStream = inputStreamOpen;
                    FileOutputStream fileOutputStream = new FileOutputStream(destination);
                    try {
                        Intrinsics.checkNotNull(inputStream);
                        ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStreamOpen, null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(inputStreamOpen, th3);
                        throw th4;
                    }
                }
            }
        }
        throw new IOException("No embedded asset matches launch asset " + launchAsset.getKey());
    }

    static final Unit loadAsset$lambda$0(RemoteLoader remoteLoader, AssetEntity assetEntity, double d) {
        remoteLoader.assetLoadProgressListener(assetEntity, d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: RemoteLoader.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019JP\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lexpo/modules/updates/loader/RemoteLoader$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "processSuccessLoaderResult", "Lexpo/modules/updates/loader/ProcessSuccessLoaderResult;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "directory", "Ljava/io/File;", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "loaderResult", "Lexpo/modules/updates/loader/Loader$LoaderResult;", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/selectionpolicy/SelectionPolicy;Ljava/io/File;Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/loader/Loader$LoaderResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRollBackToEmbeddedDirective", "", "updateDirective", "Lexpo/modules/updates/loader/UpdateDirective$RollBackToEmbeddedUpdateDirective;", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/selectionpolicy/SelectionPolicy;Ljava/io/File;Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/loader/UpdateDirective$RollBackToEmbeddedUpdateDirective;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object processSuccessLoaderResult(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, SelectionPolicy selectionPolicy, File file, UpdateEntity updateEntity, Loader.LoaderResult loaderResult, Continuation<? super ProcessSuccessLoaderResult> continuation) {
            RemoteLoader$Companion$processSuccessLoaderResult$1 remoteLoader$Companion$processSuccessLoaderResult$1;
            if (continuation instanceof RemoteLoader$Companion$processSuccessLoaderResult$1) {
                remoteLoader$Companion$processSuccessLoaderResult$1 = (RemoteLoader$Companion$processSuccessLoaderResult$1) continuation;
                if ((remoteLoader$Companion$processSuccessLoaderResult$1.label & Integer.MIN_VALUE) != 0) {
                    remoteLoader$Companion$processSuccessLoaderResult$1.label -= Integer.MIN_VALUE;
                } else {
                    remoteLoader$Companion$processSuccessLoaderResult$1 = new RemoteLoader$Companion$processSuccessLoaderResult$1(this, continuation);
                }
            } else {
                remoteLoader$Companion$processSuccessLoaderResult$1 = new RemoteLoader$Companion$processSuccessLoaderResult$1(this, continuation);
            }
            RemoteLoader$Companion$processSuccessLoaderResult$1 remoteLoader$Companion$processSuccessLoaderResult$2 = remoteLoader$Companion$processSuccessLoaderResult$1;
            Object objProcessRollBackToEmbeddedDirective = remoteLoader$Companion$processSuccessLoaderResult$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = remoteLoader$Companion$processSuccessLoaderResult$2.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objProcessRollBackToEmbeddedDirective);
                UpdateEntity updateEntity2 = loaderResult.getUpdateEntity();
                UpdateDirective updateDirective = loaderResult.getUpdateDirective();
                if (updateDirective != null && (updateDirective instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective)) {
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$0 = SpillingKt.nullOutSpilledVariable(context);
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$1 = SpillingKt.nullOutSpilledVariable(updatesConfiguration);
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$2 = SpillingKt.nullOutSpilledVariable(updatesLogger);
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$3 = SpillingKt.nullOutSpilledVariable(updatesDatabase);
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$4 = SpillingKt.nullOutSpilledVariable(selectionPolicy);
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$5 = SpillingKt.nullOutSpilledVariable(file);
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$6 = SpillingKt.nullOutSpilledVariable(updateEntity);
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$7 = SpillingKt.nullOutSpilledVariable(loaderResult);
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$8 = SpillingKt.nullOutSpilledVariable(updateEntity2);
                    remoteLoader$Companion$processSuccessLoaderResult$2.L$9 = SpillingKt.nullOutSpilledVariable(updateDirective);
                    remoteLoader$Companion$processSuccessLoaderResult$2.label = 1;
                    objProcessRollBackToEmbeddedDirective = processRollBackToEmbeddedDirective(context, updatesConfiguration, updatesLogger, updatesDatabase, selectionPolicy, file, updateEntity, (UpdateDirective.RollBackToEmbeddedUpdateDirective) updateDirective, remoteLoader$Companion$processSuccessLoaderResult$2);
                    if (objProcessRollBackToEmbeddedDirective == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return new ProcessSuccessLoaderResult(updateEntity2, false);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objProcessRollBackToEmbeddedDirective);
            }
            return new ProcessSuccessLoaderResult(null, ((Boolean) objProcessRollBackToEmbeddedDirective).booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:7:0x001c  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        public final Object processRollBackToEmbeddedDirective(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, SelectionPolicy selectionPolicy, File file, UpdateEntity updateEntity, UpdateDirective.RollBackToEmbeddedUpdateDirective rollBackToEmbeddedUpdateDirective, Continuation<? super Boolean> continuation) {
            RemoteLoader$Companion$processRollBackToEmbeddedDirective$1 remoteLoader$Companion$processRollBackToEmbeddedDirective$1;
            UpdatesLogger updatesLogger2;
            UpdatesDatabase updatesDatabase2;
            UpdateDirective.RollBackToEmbeddedUpdateDirective rollBackToEmbeddedUpdateDirective2 = rollBackToEmbeddedUpdateDirective;
            if (continuation instanceof RemoteLoader$Companion$processRollBackToEmbeddedDirective$1) {
                remoteLoader$Companion$processRollBackToEmbeddedDirective$1 = (RemoteLoader$Companion$processRollBackToEmbeddedDirective$1) continuation;
                int i = remoteLoader$Companion$processRollBackToEmbeddedDirective$1.label & Integer.MIN_VALUE;
                if (i != 0) {
                    remoteLoader$Companion$processRollBackToEmbeddedDirective$1.label -= Integer.MIN_VALUE;
                    updatesLogger2 = i;
                } else {
                    Companion companion = this;
                    remoteLoader$Companion$processRollBackToEmbeddedDirective$1 = new RemoteLoader$Companion$processRollBackToEmbeddedDirective$1(companion, continuation);
                    updatesLogger2 = companion;
                }
            } else {
                Companion companion2 = this;
                remoteLoader$Companion$processRollBackToEmbeddedDirective$1 = new RemoteLoader$Companion$processRollBackToEmbeddedDirective$1(companion2, continuation);
                updatesLogger2 = companion2;
            }
            RemoteLoader$Companion$processRollBackToEmbeddedDirective$1 remoteLoader$Companion$processRollBackToEmbeddedDirective$2 = remoteLoader$Companion$processRollBackToEmbeddedDirective$1;
            Object objLoad = remoteLoader$Companion$processRollBackToEmbeddedDirective$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = remoteLoader$Companion$processRollBackToEmbeddedDirective$2.label;
            boolean z = false;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objLoad);
                    if (!updatesConfiguration.getHasEmbeddedUpdate()) {
                        return Boxing.boxBoolean(false);
                    }
                    EmbeddedUpdate embeddedUpdate = EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(context, updatesConfiguration);
                    Intrinsics.checkNotNull(embeddedUpdate);
                    UpdateEntity updateEntity2 = embeddedUpdate.getUpdateEntity();
                    JSONObject manifestFilters = ManifestMetadata.INSTANCE.getManifestFilters(updatesDatabase, updatesConfiguration);
                    if (!selectionPolicy.shouldLoadRollBackToEmbeddedDirective(rollBackToEmbeddedUpdateDirective2, updateEntity2, updateEntity, manifestFilters)) {
                        return Boxing.boxBoolean(false);
                    }
                    updateEntity2.setCommitTime(rollBackToEmbeddedUpdateDirective2.getCommitTime());
                    try {
                        EmbeddedLoader embeddedLoader = new EmbeddedLoader(context, updatesConfiguration, updatesLogger, updatesDatabase, file, (CoroutineScope) null, 32, (DefaultConstructorMarker) null);
                        Function1<? super UpdateResponse, Loader.OnUpdateResponseLoadedResult> function1 = new Function1() { // from class: expo.modules.updates.loader.RemoteLoader$Companion$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RemoteLoader.Companion.processRollBackToEmbeddedDirective$lambda$0((UpdateResponse) obj);
                            }
                        };
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$0 = SpillingKt.nullOutSpilledVariable(context);
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$1 = SpillingKt.nullOutSpilledVariable(updatesConfiguration);
                        UpdatesLogger updatesLogger3 = updatesLogger;
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$2 = updatesLogger3;
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$3 = updatesDatabase;
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$4 = SpillingKt.nullOutSpilledVariable(selectionPolicy);
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$5 = SpillingKt.nullOutSpilledVariable(file);
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$6 = SpillingKt.nullOutSpilledVariable(updateEntity);
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$7 = rollBackToEmbeddedUpdateDirective2;
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$8 = SpillingKt.nullOutSpilledVariable(updateEntity2);
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$9 = SpillingKt.nullOutSpilledVariable(manifestFilters);
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$10 = SpillingKt.nullOutSpilledVariable(embeddedLoader);
                        remoteLoader$Companion$processRollBackToEmbeddedDirective$2.label = 1;
                        objLoad = embeddedLoader.load(function1, remoteLoader$Companion$processRollBackToEmbeddedDirective$2);
                        if (objLoad == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        updatesDatabase2 = updatesDatabase;
                        updatesLogger2 = updatesLogger3;
                    } catch (Exception e) {
                        e = e;
                        updatesLogger2 = updatesLogger;
                        updatesLogger2.error("Embedded update erroneously null when applying roll back to embedded directive", e, UpdatesErrorCode.UpdateFailedToLoad);
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    UpdateDirective.RollBackToEmbeddedUpdateDirective rollBackToEmbeddedUpdateDirective3 = (UpdateDirective.RollBackToEmbeddedUpdateDirective) remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$7;
                    updatesDatabase2 = (UpdatesDatabase) remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$3;
                    UpdatesLogger updatesLogger4 = (UpdatesLogger) remoteLoader$Companion$processRollBackToEmbeddedDirective$2.L$2;
                    ResultKt.throwOnFailure(objLoad);
                    rollBackToEmbeddedUpdateDirective2 = rollBackToEmbeddedUpdateDirective3;
                    updatesLogger2 = updatesLogger4;
                }
                UpdateEntity updateEntity3 = ((Loader.LoaderResult) objLoad).getUpdateEntity();
                UpdateDao updateDao = updatesDatabase2.updateDao();
                Intrinsics.checkNotNull(updateEntity3);
                updateDao.setUpdateCommitTime(updateEntity3, rollBackToEmbeddedUpdateDirective2.getCommitTime());
                z = true;
            } catch (Exception e2) {
                e = e2;
            }
            return Boxing.boxBoolean(z);
        }

        static final Loader.OnUpdateResponseLoadedResult processRollBackToEmbeddedDirective$lambda$0(UpdateResponse it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Loader.OnUpdateResponseLoadedResult(true);
        }
    }
}
