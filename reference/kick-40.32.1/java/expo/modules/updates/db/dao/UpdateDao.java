package expo.modules.updates.db.dao;

import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateDao.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H%J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\rH%J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\rH%J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH%J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH%J\u001e\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0014\u001a\u00020\nH%J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001a\u00020\nH'J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u0014\u001a\u00020\nH'J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H'J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0006H'J\u0016\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\bJ\u0018\u0010#\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\bH'J\u0016\u0010$\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u0018\u0010'\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H'J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00062\u0006\u0010)\u001a\u00020*H\u0017J\u000e\u0010(\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0006J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010-\u001a\u00020&H%J\u000e\u0010.\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0006J\u0010\u0010/\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH%J\u000e\u00100\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0006J\u0010\u00101\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH'J\u0014\u0010\u0015\u001a\u00020\u00122\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005J\u0016\u00103\u001a\u00020\u00122\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'¨\u00065"}, d2 = {"Lexpo/modules/updates/db/dao/UpdateDao;", "", "<init>", "()V", "loadLaunchableUpdatesForProjectWithStatuses", "", "Lexpo/modules/updates/db/entity/UpdateEntity;", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, "", "statuses", "Lexpo/modules/updates/db/enums/UpdateStatus;", "loadUpdatesWithId", "id", "Ljava/util/UUID;", "loadLaunchAssetForUpdateInternal", "Lexpo/modules/updates/db/entity/AssetEntity;", "updateId", "keepUpdate", "", "markUpdateWithStatus", "status", "markUpdatesWithMissingAssets", "missingAssetIds", "", "loadAllUpdates", "loadLaunchableUpdatesForScope", "loadAllUpdatesWithStatus", "loadAllUpdateIdsWithStatus", "loadRecentUpdateIdsWithFailedLaunch", "loadUpdateWithId", "loadLaunchAssetForUpdate", "insertUpdate", "update", "setUpdateScopeKey", "newScopeKey", "_setUpdateScopeKeyInternal", "setUpdateCommitTime", "commitTime", "Ljava/util/Date;", "setUpdateCommitTimeInternal", "markUpdateFinished", "hasSkippedEmbeddedAssets", "", "markUpdateAccessed", "markUpdateAccessedInternal", "lastAccessed", "incrementSuccessfulLaunchCount", "incrementSuccessfulLaunchCountInternal", "incrementFailedLaunchCount", "incrementFailedLaunchCountInternal", "missingAssets", "deleteUpdates", "updates", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class UpdateDao {
    public abstract void _setUpdateScopeKeyInternal(UUID id, String newScopeKey);

    public abstract void deleteUpdates(List<UpdateEntity> updates);

    public abstract void incrementFailedLaunchCountInternal(UUID id);

    protected abstract void incrementSuccessfulLaunchCountInternal(UUID id);

    public abstract void insertUpdate(UpdateEntity update);

    protected abstract void keepUpdate(UUID id);

    public abstract List<UUID> loadAllUpdateIdsWithStatus(UpdateStatus status);

    public abstract List<UpdateEntity> loadAllUpdates();

    public abstract List<UpdateEntity> loadAllUpdatesWithStatus(UpdateStatus status);

    protected abstract AssetEntity loadLaunchAssetForUpdateInternal(UUID updateId);

    protected abstract List<UpdateEntity> loadLaunchableUpdatesForProjectWithStatuses(String scopeKey, List<? extends UpdateStatus> statuses);

    public abstract List<UUID> loadRecentUpdateIdsWithFailedLaunch();

    protected abstract List<UpdateEntity> loadUpdatesWithId(UUID id);

    protected abstract void markUpdateAccessedInternal(UUID id, Date lastAccessed);

    protected abstract void markUpdateWithStatus(UpdateStatus status, UUID id);

    protected abstract void markUpdatesWithMissingAssets(List<Long> missingAssetIds, UpdateStatus status);

    public abstract void setUpdateCommitTimeInternal(UUID id, Date commitTime);

    public final List<UpdateEntity> loadLaunchableUpdatesForScope(String scopeKey) {
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        return loadLaunchableUpdatesForProjectWithStatuses(scopeKey, CollectionsKt.listOf((Object[]) new UpdateStatus[]{UpdateStatus.READY, UpdateStatus.EMBEDDED, UpdateStatus.DEVELOPMENT}));
    }

    public final UpdateEntity loadUpdateWithId(UUID id) {
        Intrinsics.checkNotNullParameter(id, "id");
        List<UpdateEntity> listLoadUpdatesWithId = loadUpdatesWithId(id);
        if (listLoadUpdatesWithId.isEmpty()) {
            return null;
        }
        return listLoadUpdatesWithId.get(0);
    }

    public final AssetEntity loadLaunchAssetForUpdate(UUID updateId) {
        Intrinsics.checkNotNullParameter(updateId, "updateId");
        AssetEntity assetEntityLoadLaunchAssetForUpdateInternal = loadLaunchAssetForUpdateInternal(updateId);
        if (assetEntityLoadLaunchAssetForUpdateInternal == null) {
            return null;
        }
        assetEntityLoadLaunchAssetForUpdateInternal.setLaunchAsset(true);
        return assetEntityLoadLaunchAssetForUpdateInternal;
    }

    public final void setUpdateScopeKey(UpdateEntity update, String newScopeKey) {
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(newScopeKey, "newScopeKey");
        update.setScopeKey(newScopeKey);
        _setUpdateScopeKeyInternal(update.getId(), newScopeKey);
    }

    public final void setUpdateCommitTime(UpdateEntity update, Date commitTime) {
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(commitTime, "commitTime");
        update.setCommitTime(commitTime);
        setUpdateCommitTimeInternal(update.getId(), commitTime);
    }

    public void markUpdateFinished(UpdateEntity update, boolean hasSkippedEmbeddedAssets) {
        Intrinsics.checkNotNullParameter(update, "update");
        UpdateStatus updateStatus = UpdateStatus.READY;
        if (update.getStatus() == UpdateStatus.DEVELOPMENT) {
            updateStatus = UpdateStatus.DEVELOPMENT;
        } else if (hasSkippedEmbeddedAssets) {
            updateStatus = UpdateStatus.EMBEDDED;
        }
        markUpdateWithStatus(updateStatus, update.getId());
        keepUpdate(update.getId());
    }

    public final void markUpdateFinished(UpdateEntity update) {
        Intrinsics.checkNotNullParameter(update, "update");
        markUpdateFinished(update, false);
    }

    public final void markUpdateAccessed(UpdateEntity update) {
        Intrinsics.checkNotNullParameter(update, "update");
        Date date = new Date();
        update.setLastAccessed(date);
        markUpdateAccessedInternal(update.getId(), date);
    }

    public final void incrementSuccessfulLaunchCount(UpdateEntity update) {
        Intrinsics.checkNotNullParameter(update, "update");
        update.setSuccessfulLaunchCount(update.getSuccessfulLaunchCount() + 1);
        incrementSuccessfulLaunchCountInternal(update.getId());
    }

    public final void incrementFailedLaunchCount(UpdateEntity update) {
        Intrinsics.checkNotNullParameter(update, "update");
        update.setFailedLaunchCount(update.getFailedLaunchCount() + 1);
        incrementFailedLaunchCountInternal(update.getId());
    }

    public final void markUpdatesWithMissingAssets(List<AssetEntity> missingAssets) {
        Intrinsics.checkNotNullParameter(missingAssets, "missingAssets");
        ArrayList arrayList = new ArrayList();
        Iterator<AssetEntity> it = missingAssets.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getId()));
        }
        markUpdatesWithMissingAssets(arrayList, UpdateStatus.PENDING);
    }
}
