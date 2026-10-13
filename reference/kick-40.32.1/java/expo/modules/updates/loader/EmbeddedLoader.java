package expo.modules.updates.loader;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: EmbeddedLoader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 BM\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0094@¢\u0006\u0002\u0010\u0017J:\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0094@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lexpo/modules/updates/loader/EmbeddedLoader;", "Lexpo/modules/updates/loader/Loader;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "updatesDirectory", "Ljava/io/File;", "loaderFiles", "Lexpo/modules/updates/loader/LoaderFiles;", "shouldCopyEmbeddedAssets", "", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Ljava/io/File;Lexpo/modules/updates/loader/LoaderFiles;ZLkotlinx/coroutines/CoroutineScope;)V", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Ljava/io/File;Lkotlinx/coroutines/CoroutineScope;)V", "loadRemoteUpdate", "Lexpo/modules/updates/loader/UpdateResponse;", "(Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/UpdatesConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAsset", "Lexpo/modules/updates/loader/FileDownloader$AssetDownloadResult;", "assetEntity", "Lexpo/modules/updates/db/entity/AssetEntity;", "requestedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "embeddedUpdate", "(Lexpo/modules/updates/db/entity/AssetEntity;Ljava/io/File;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/db/entity/UpdateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmbeddedLoader extends Loader {
    public static final String BARE_BUNDLE_FILENAME = "index.android.bundle";
    public static final String BUNDLE_FILENAME = "app.bundle";
    private final UpdatesConfiguration configuration;
    private final LoaderFiles loaderFiles;
    private final boolean shouldCopyEmbeddedAssets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddedLoader(Context context, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database, File updatesDirectory, LoaderFiles loaderFiles, boolean z, CoroutineScope scope) {
        super(context, configuration, logger, database, updatesDirectory, loaderFiles, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(loaderFiles, "loaderFiles");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.configuration = configuration;
        this.loaderFiles = loaderFiles;
        this.shouldCopyEmbeddedAssets = z;
    }

    public /* synthetic */ EmbeddedLoader(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, File file, LoaderFiles loaderFiles, boolean z, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, updatesConfiguration, updatesLogger, updatesDatabase, file, loaderFiles, (i & 64) != 0 ? false : z, (i & 128) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    public /* synthetic */ EmbeddedLoader(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, File file, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, updatesConfiguration, updatesLogger, updatesDatabase, file, (i & 32) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmbeddedLoader(Context context, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database, File updatesDirectory, CoroutineScope scope) {
        this(context, configuration, logger, database, updatesDirectory, new LoaderFiles(), false, scope, 64, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    @Override // expo.modules.updates.loader.Loader
    protected Object loadRemoteUpdate(UpdatesDatabase updatesDatabase, UpdatesConfiguration updatesConfiguration, Continuation<? super UpdateResponse> continuation) throws Exception {
        Update embeddedUpdate = this.loaderFiles.readEmbeddedUpdate(getContext(), this.configuration);
        if (embeddedUpdate != null) {
            return new UpdateResponse(null, new UpdateResponsePart.ManifestUpdateResponsePart(embeddedUpdate), null);
        }
        throw new Exception("Embedded manifest is null");
    }

    @Override // expo.modules.updates.loader.Loader
    protected Object loadAsset(AssetEntity assetEntity, File file, UpdatesConfiguration updatesConfiguration, UpdateEntity updateEntity, UpdateEntity updateEntity2, Continuation<? super FileDownloader.AssetDownloadResult> continuation) {
        String resourcesFilename;
        if (!this.shouldCopyEmbeddedAssets) {
            assetEntity.setDownloadTime(new Date());
            assetEntity.setRelativePath(AndroidResourceAssetUtils.INSTANCE.createEmbeddedFilenameForAsset(assetEntity));
            return new FileDownloader.AssetDownloadResult(assetEntity, true);
        }
        String strCreateFilenameForAsset = UpdatesUtils.INSTANCE.createFilenameForAsset(assetEntity);
        File file2 = new File(file, strCreateFilenameForAsset);
        if (this.loaderFiles.fileExists(getContext(), file, strCreateFilenameForAsset)) {
            assetEntity.setRelativePath(strCreateFilenameForAsset);
            return new FileDownloader.AssetDownloadResult(assetEntity, false);
        }
        try {
            assetEntity.setHash(this.loaderFiles.copyAssetAndGetHash(assetEntity, file2, getContext()));
            assetEntity.setDownloadTime(new Date());
            assetEntity.setRelativePath(strCreateFilenameForAsset);
            return new FileDownloader.AssetDownloadResult(assetEntity, true);
        } catch (FileNotFoundException unused) {
            if (assetEntity.getEmbeddedAssetFilename() != null) {
                resourcesFilename = assetEntity.getEmbeddedAssetFilename();
            } else {
                resourcesFilename = assetEntity.getResourcesFilename();
            }
            throw new AssertionError("APK bundle must contain the expected embedded asset " + resourcesFilename);
        }
    }
}
