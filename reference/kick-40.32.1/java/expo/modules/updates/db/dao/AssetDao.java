package expo.modules.updates.db.dao;

import com.facebook.common.util.UriUtil;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateAssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: AssetDao.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H%J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH%J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH%J\b\u0010\u0010\u001a\u00020\tH%J\b\u0010\u0011\u001a\u00020\tH%J\b\u0010\u0012\u001a\u00020\tH%J\b\u0010\u0013\u001a\u00020\tH%J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H%J\b\u0010\u0016\u001a\u00020\tH%J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H%J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H'J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u001c\u001a\u00020\u000fH'J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0007H'J\u001e\u0010\u001e\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010 \u001a\u00020!H\u0017J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0016\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007J \u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0017J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0017J\u0015\u0010*\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b-¨\u0006."}, d2 = {"Lexpo/modules/updates/db/dao/AssetDao;", "", "<init>", "()V", "insertAssetInternal", "", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/updates/db/entity/AssetEntity;", "insertUpdateAssetInternal", "", "updateAsset", "Lexpo/modules/updates/db/entity/UpdateAssetEntity;", "setUpdateLaunchAssetInternal", "assetId", "updateId", "Ljava/util/UUID;", "markAllAssetsForDeletionInternal", "unMarkUsedAssetsFromDeletionInternal", "unMarkUsedLaunchAssetsFromDeletionInternal", "unMarkDuplicateUsedAssetsFromDeletionInternal", "loadAssetsMarkedForDeletionInternal", "", "deleteAssetsMarkedForDeletionInternal", "loadAssetWithKeyInternal", "key", "", "loadAllAssets", "loadAssetsForUpdate", "id", "assetEntity", "insertAssets", "assets", "update", "Lexpo/modules/updates/db/entity/UpdateEntity;", "loadAssetWithKey", "mergeAndUpdateAsset", "existingEntity", "newEntity", "addExistingAssetToUpdate", "", "isLaunchAsset", "deleteUnusedAssets", "insertAssetForTest", "insertAssetForTest$expo_updates_release", "insertUpdateAssetForTest", "insertUpdateAssetForTest$expo_updates_release", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AssetDao {
    protected abstract void deleteAssetsMarkedForDeletionInternal();

    protected abstract long insertAssetInternal(AssetEntity asset);

    protected abstract void insertUpdateAssetInternal(UpdateAssetEntity updateAsset);

    public abstract List<AssetEntity> loadAllAssets();

    protected abstract List<AssetEntity> loadAssetWithKeyInternal(String key);

    public abstract List<AssetEntity> loadAssetsForUpdate(UUID id);

    protected abstract List<AssetEntity> loadAssetsMarkedForDeletionInternal();

    protected abstract void markAllAssetsForDeletionInternal();

    protected abstract void setUpdateLaunchAssetInternal(long assetId, UUID updateId);

    protected abstract void unMarkDuplicateUsedAssetsFromDeletionInternal();

    protected abstract void unMarkUsedAssetsFromDeletionInternal();

    protected abstract void unMarkUsedLaunchAssetsFromDeletionInternal();

    public abstract void updateAsset(AssetEntity assetEntity);

    public void insertAssets(List<AssetEntity> assets, UpdateEntity update) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(update, "update");
        for (AssetEntity assetEntity : assets) {
            if (!addExistingAssetToUpdate(update, assetEntity, assetEntity.getIsLaunchAsset())) {
                long jInsertAssetInternal = insertAssetInternal(assetEntity);
                insertUpdateAssetInternal(new UpdateAssetEntity(update.getId(), jInsertAssetInternal));
                if (assetEntity.getIsLaunchAsset()) {
                    setUpdateLaunchAssetInternal(jInsertAssetInternal, update.getId());
                }
            }
        }
    }

    public final AssetEntity loadAssetWithKey(String key) {
        AssetEntity assetEntity = (AssetEntity) CollectionsKt.firstOrNull((List) loadAssetWithKeyInternal(key));
        if (assetEntity == null) {
            return null;
        }
        String relativePath = assetEntity.getRelativePath();
        if (relativePath != null) {
            AndroidResourceAssetUtils.AndroidResourceAsset androidResponseAssetFromPath = AndroidResourceAssetUtils.INSTANCE.parseAndroidResponseAssetFromPath(relativePath);
            String strComponent1 = androidResponseAssetFromPath.getEmbeddedAssetFilename();
            String strComponent2 = androidResponseAssetFromPath.getResourcesFolder();
            String strComponent3 = androidResponseAssetFromPath.getResourceFilename();
            assetEntity.setEmbeddedAssetFilename(strComponent1);
            assetEntity.setResourcesFolder(strComponent2);
            assetEntity.setResourcesFilename(strComponent3);
        }
        return assetEntity;
    }

    public final void mergeAndUpdateAsset(AssetEntity existingEntity, AssetEntity newEntity) {
        boolean z;
        Intrinsics.checkNotNullParameter(existingEntity, "existingEntity");
        Intrinsics.checkNotNullParameter(newEntity, "newEntity");
        boolean z2 = true;
        if (newEntity.getUrl() == null || (existingEntity.getUrl() != null && Intrinsics.areEqual(newEntity.getUrl(), existingEntity.getUrl()))) {
            z = false;
        } else {
            existingEntity.setUrl(newEntity.getUrl());
            z = true;
        }
        JSONObject extraRequestHeaders = newEntity.getExtraRequestHeaders();
        if (extraRequestHeaders == null || (existingEntity.getExtraRequestHeaders() != null && Intrinsics.areEqual(extraRequestHeaders, existingEntity.getExtraRequestHeaders()))) {
            z2 = z;
        } else {
            existingEntity.setExtraRequestHeaders(newEntity.getExtraRequestHeaders());
        }
        if (z2) {
            updateAsset(existingEntity);
        }
        existingEntity.setLaunchAsset(newEntity.getIsLaunchAsset());
        String embeddedAssetFilename = newEntity.getEmbeddedAssetFilename();
        if (embeddedAssetFilename != null) {
            existingEntity.setEmbeddedAssetFilename(embeddedAssetFilename);
        }
        String resourcesFilename = newEntity.getResourcesFilename();
        if (resourcesFilename != null) {
            existingEntity.setResourcesFilename(resourcesFilename);
        }
        String resourcesFolder = newEntity.getResourcesFolder();
        if (resourcesFolder != null) {
            existingEntity.setResourcesFolder(resourcesFolder);
        }
        Float scale = newEntity.getScale();
        if (scale != null) {
            existingEntity.setScale(Float.valueOf(scale.floatValue()));
        }
        Float[] scales = newEntity.getScales();
        if (scales != null) {
            existingEntity.setScales(scales);
        }
    }

    public boolean addExistingAssetToUpdate(UpdateEntity update, AssetEntity asset, boolean isLaunchAsset) {
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(asset, "asset");
        AssetEntity assetEntityLoadAssetWithKey = loadAssetWithKey(asset.getKey());
        if (assetEntityLoadAssetWithKey == null) {
            return false;
        }
        long id = assetEntityLoadAssetWithKey.getId();
        insertUpdateAssetInternal(new UpdateAssetEntity(update.getId(), id));
        if (!isLaunchAsset) {
            return true;
        }
        setUpdateLaunchAssetInternal(id, update.getId());
        return true;
    }

    public List<AssetEntity> deleteUnusedAssets() {
        markAllAssetsForDeletionInternal();
        unMarkUsedAssetsFromDeletionInternal();
        unMarkUsedLaunchAssetsFromDeletionInternal();
        unMarkDuplicateUsedAssetsFromDeletionInternal();
        List<AssetEntity> listLoadAssetsMarkedForDeletionInternal = loadAssetsMarkedForDeletionInternal();
        deleteAssetsMarkedForDeletionInternal();
        return listLoadAssetsMarkedForDeletionInternal;
    }

    public final long insertAssetForTest$expo_updates_release(AssetEntity asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        return insertAssetInternal(asset);
    }

    public final void insertUpdateAssetForTest$expo_updates_release(UpdateAssetEntity updateAsset) {
        Intrinsics.checkNotNullParameter(updateAsset, "updateAsset");
        insertUpdateAssetInternal(updateAsset);
    }
}
