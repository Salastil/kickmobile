package expo.modules.updates.loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.util.UriUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.manifest.EmbeddedManifestUtils;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoaderFiles.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J%\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0016J%\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lexpo/modules/updates/loader/LoaderFiles;", "", "<init>", "()V", "fileExists", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "updateDirectory", "Ljava/io/File;", "relativePath", "", "readEmbeddedUpdate", "Lexpo/modules/updates/manifest/Update;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "copyAssetAndGetHash", "", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/updates/db/entity/AssetEntity;", FirebaseAnalytics.Param.DESTINATION, "copyContextAssetAndGetHash", "copyContextAssetAndGetHash$expo_updates_release", "copyResourceAndGetHash", "copyResourceAndGetHash$expo_updates_release", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class LoaderFiles {
    private static final String TAG = "LoaderFiles";

    public final boolean fileExists(Context context, File updateDirectory, String relativePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (relativePath == null) {
            return false;
        }
        if (AndroidResourceAssetUtils.INSTANCE.isAndroidAssetOrResourceExisted(context, relativePath)) {
            return true;
        }
        return new File(updateDirectory, relativePath).exists();
    }

    public final Update readEmbeddedUpdate(Context context, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(context, configuration);
    }

    public final byte[] copyAssetAndGetHash(AssetEntity asset, File destination, Context context) throws NoSuchAlgorithmException, IOException {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(context, "context");
        if (asset.getEmbeddedAssetFilename() != null) {
            return copyContextAssetAndGetHash$expo_updates_release(asset, destination, context);
        }
        if (asset.getResourcesFilename() != null && asset.getResourcesFolder() != null) {
            return copyResourceAndGetHash$expo_updates_release(asset, destination, context);
        }
        throw new AssertionError("Failed to copy embedded asset " + asset.getKey() + " from APK assets or resources because not enough information was provided.");
    }

    public final byte[] copyContextAssetAndGetHash$expo_updates_release(AssetEntity asset, File destination, Context context) throws Exception {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            AssetManager assets = context.getAssets();
            String embeddedAssetFilename = asset.getEmbeddedAssetFilename();
            Intrinsics.checkNotNull(embeddedAssetFilename);
            InputStream inputStreamOpen = assets.open(embeddedAssetFilename);
            try {
                InputStream inputStream = inputStreamOpen;
                UpdatesUtils updatesUtils = UpdatesUtils.INSTANCE;
                Intrinsics.checkNotNull(inputStream);
                byte[] bArrVerifySHA256AndWriteToFile = updatesUtils.verifySHA256AndWriteToFile(inputStream, destination, null);
                CloseableKt.closeFinally(inputStreamOpen, null);
                return bArrVerifySHA256AndWriteToFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to copy asset " + asset.getEmbeddedAssetFilename(), e);
            throw e;
        }
    }

    public final byte[] copyResourceAndGetHash$expo_updates_release(AssetEntity asset, File destination, Context context) throws Exception {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(context.getResources().getIdentifier(asset.getResourcesFilename(), asset.getResourcesFolder(), context.getPackageName()));
            try {
                InputStream inputStream = inputStreamOpenRawResource;
                UpdatesUtils updatesUtils = UpdatesUtils.INSTANCE;
                Intrinsics.checkNotNull(inputStream);
                byte[] bArrVerifySHA256AndWriteToFile = updatesUtils.verifySHA256AndWriteToFile(inputStream, destination, null);
                CloseableKt.closeFinally(inputStreamOpenRawResource, null);
                return bArrVerifySHA256AndWriteToFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpenRawResource, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to copy resource asset " + asset.getResourcesFolder() + DomExceptionUtils.SEPARATOR + asset.getEmbeddedAssetFilename(), e);
            throw e;
        }
    }
}
