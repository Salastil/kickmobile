package expo.modules.updates.db;

import android.util.Log;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Reaper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lexpo/modules/updates/db/Reaper;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "reapUnusedUpdates", "", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "updatesDirectory", "Ljava/io/File;", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Reaper {
    public static final Reaper INSTANCE = new Reaper();
    private static final String TAG = "Reaper";

    private Reaper() {
    }

    @JvmStatic
    public static final void reapUnusedUpdates(UpdatesConfiguration configuration, UpdatesDatabase database, File updatesDirectory, UpdateEntity launchedUpdate, SelectionPolicy selectionPolicy) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        if (launchedUpdate == null) {
            Log.d(TAG, "Tried to reap while no update was launched; aborting");
            return;
        }
        database.updateDao().deleteUpdates(selectionPolicy.selectUpdatesToDelete(database.updateDao().loadAllUpdates(), launchedUpdate, ManifestMetadata.INSTANCE.getManifestFilters(database, configuration)));
        List<AssetEntity> listDeleteUnusedAssets = database.assetDao().deleteUnusedAssets();
        ArrayList<AssetEntity> arrayList = new ArrayList();
        for (AssetEntity assetEntity : listDeleteUnusedAssets) {
            if (!assetEntity.getMarkedForDeletion()) {
                Log.e(TAG, "Tried to delete asset with URL " + assetEntity.getUrl() + " but it was not marked for deletion");
            } else {
                String relativePath = assetEntity.getRelativePath();
                if (relativePath != null && !AndroidResourceAssetUtils.INSTANCE.isAndroidResourceAsset(relativePath)) {
                    if (!UpdatesUtils.INSTANCE.isSafeFilename(relativePath)) {
                        Log.e(TAG, "Refusing to delete asset with URL " + assetEntity.getUrl() + " at unsafe path " + relativePath);
                    } else {
                        File file = new File(updatesDirectory, relativePath);
                        try {
                            if (file.exists() && !file.delete()) {
                                Log.e(TAG, "Failed to delete asset with URL " + assetEntity.getUrl() + " at path " + file);
                                arrayList.add(assetEntity);
                            }
                        } catch (Exception e) {
                            Log.e(TAG, "Failed to delete asset with URL " + assetEntity.getUrl() + " at path " + file, e);
                            arrayList.add(assetEntity);
                        }
                    }
                }
            }
        }
        for (AssetEntity assetEntity2 : arrayList) {
            File file2 = new File(updatesDirectory, assetEntity2.getRelativePath());
            try {
                if (file2.exists() && !file2.delete()) {
                    Log.e(TAG, "Retried and failed again deleting asset with URL " + assetEntity2.getUrl() + " at path " + file2);
                }
            } catch (Exception e2) {
                Log.e(TAG, "Retried and failed again deleting asset with URL " + assetEntity2.getUrl() + " at path " + file2, e2);
            }
        }
    }
}
