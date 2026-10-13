package expo.modules.updates.db.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.updates.db.Converters;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateAssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssetDao_Impl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0014J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u001e\u0010\u001d\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\u0006\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u001fH\u0016J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020\u001aH\u0014J\b\u0010+\u001a\u00020\u001aH\u0014J\b\u0010,\u001a\u00020\u001aH\u0014J\b\u0010-\u001a\u00020\u001aH\u0014J\b\u0010.\u001a\u00020\u001aH\u0014J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u001fH\u0014J\u0018\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\b0\u001fH\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\u0006\u00105\u001a\u00020)H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lexpo/modules/updates/db/dao/AssetDao_Impl;", "Lexpo/modules/updates/db/dao/AssetDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfAssetEntity", "Landroidx/room/EntityInsertionAdapter;", "Lexpo/modules/updates/db/entity/AssetEntity;", "__converters", "Lexpo/modules/updates/db/Converters;", "__insertionAdapterOfUpdateAssetEntity", "Lexpo/modules/updates/db/entity/UpdateAssetEntity;", "__updateAdapterOfAssetEntity", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "__preparedStmtOfSetUpdateLaunchAssetInternal", "Landroidx/room/SharedSQLiteStatement;", "__preparedStmtOfMarkAllAssetsForDeletionInternal", "__preparedStmtOfUnMarkUsedAssetsFromDeletionInternal", "__preparedStmtOfUnMarkUsedLaunchAssetsFromDeletionInternal", "__preparedStmtOfUnMarkDuplicateUsedAssetsFromDeletionInternal", "__preparedStmtOfDeleteAssetsMarkedForDeletionInternal", "insertAssetInternal", "", UriUtil.LOCAL_ASSET_SCHEME, "insertUpdateAssetInternal", "", "updateAsset", "assetEntity", "insertAssets", "assets", "", "update", "Lexpo/modules/updates/db/entity/UpdateEntity;", "addExistingAssetToUpdate", "", "isLaunchAsset", "deleteUnusedAssets", "setUpdateLaunchAssetInternal", "assetId", "updateId", "Ljava/util/UUID;", "markAllAssetsForDeletionInternal", "unMarkUsedAssetsFromDeletionInternal", "unMarkUsedLaunchAssetsFromDeletionInternal", "unMarkDuplicateUsedAssetsFromDeletionInternal", "deleteAssetsMarkedForDeletionInternal", "loadAssetsMarkedForDeletionInternal", "loadAssetWithKeyInternal", "key", "", "loadAllAssets", "loadAssetsForUpdate", "id", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AssetDao_Impl extends AssetDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Converters __converters;
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<AssetEntity> __insertionAdapterOfAssetEntity;
    private final EntityInsertionAdapter<UpdateAssetEntity> __insertionAdapterOfUpdateAssetEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAssetsMarkedForDeletionInternal;
    private final SharedSQLiteStatement __preparedStmtOfMarkAllAssetsForDeletionInternal;
    private final SharedSQLiteStatement __preparedStmtOfSetUpdateLaunchAssetInternal;
    private final SharedSQLiteStatement __preparedStmtOfUnMarkDuplicateUsedAssetsFromDeletionInternal;
    private final SharedSQLiteStatement __preparedStmtOfUnMarkUsedAssetsFromDeletionInternal;
    private final SharedSQLiteStatement __preparedStmtOfUnMarkUsedLaunchAssetsFromDeletionInternal;
    private final EntityDeletionOrUpdateAdapter<AssetEntity> __updateAdapterOfAssetEntity;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public AssetDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__converters = new Converters();
        this.__db = __db;
        this.__insertionAdapterOfAssetEntity = new EntityInsertionAdapter<AssetEntity>(__db) { // from class: expo.modules.updates.db.dao.AssetDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `assets` (`key`,`type`,`id`,`url`,`headers`,`extra_request_headers`,`metadata`,`download_time`,`relative_path`,`hash`,`hash_type`,`expected_hash`,`marked_for_deletion`) VALUES (?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, AssetEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String key = entity.getKey();
                if (key == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, key);
                }
                String type = entity.getType();
                if (type == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, type);
                }
                statement.bindLong(3, entity.getId());
                String strUriToString = this.__converters.uriToString(entity.getUrl());
                if (strUriToString == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, strUriToString);
                }
                String strJsonObjectToString = this.__converters.jsonObjectToString(entity.getHeaders());
                if (strJsonObjectToString == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, strJsonObjectToString);
                }
                String strJsonObjectToString2 = this.__converters.jsonObjectToString(entity.getExtraRequestHeaders());
                if (strJsonObjectToString2 == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, strJsonObjectToString2);
                }
                String strJsonObjectToString3 = this.__converters.jsonObjectToString(entity.getMetadata());
                if (strJsonObjectToString3 == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, strJsonObjectToString3);
                }
                Long lDateToLong = this.__converters.dateToLong(entity.getDownloadTime());
                if (lDateToLong == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindLong(8, lDateToLong.longValue());
                }
                String relativePath = entity.getRelativePath();
                if (relativePath == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, relativePath);
                }
                byte[] hash = entity.getHash();
                if (hash == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindBlob(10, hash);
                }
                statement.bindLong(11, this.__converters.hashTypeToInt(entity.getHashType()));
                String expectedHash = entity.getExpectedHash();
                if (expectedHash == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, expectedHash);
                }
                statement.bindLong(13, entity.getMarkedForDeletion() ? 1L : 0L);
            }
        };
        this.__insertionAdapterOfUpdateAssetEntity = new EntityInsertionAdapter<UpdateAssetEntity>(__db) { // from class: expo.modules.updates.db.dao.AssetDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `updates_assets` (`update_id`,`asset_id`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, UpdateAssetEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindBlob(1, this.__converters.uuidToBytes(entity.getUpdateId()));
                statement.bindLong(2, entity.getAssetId());
            }
        };
        this.__updateAdapterOfAssetEntity = new EntityDeletionOrUpdateAdapter<AssetEntity>(__db) { // from class: expo.modules.updates.db.dao.AssetDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `assets` SET `key` = ?,`type` = ?,`id` = ?,`url` = ?,`headers` = ?,`extra_request_headers` = ?,`metadata` = ?,`download_time` = ?,`relative_path` = ?,`hash` = ?,`hash_type` = ?,`expected_hash` = ?,`marked_for_deletion` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement statement, AssetEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                String key = entity.getKey();
                if (key == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, key);
                }
                String type = entity.getType();
                if (type == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, type);
                }
                statement.bindLong(3, entity.getId());
                String strUriToString = this.__converters.uriToString(entity.getUrl());
                if (strUriToString == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, strUriToString);
                }
                String strJsonObjectToString = this.__converters.jsonObjectToString(entity.getHeaders());
                if (strJsonObjectToString == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, strJsonObjectToString);
                }
                String strJsonObjectToString2 = this.__converters.jsonObjectToString(entity.getExtraRequestHeaders());
                if (strJsonObjectToString2 == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, strJsonObjectToString2);
                }
                String strJsonObjectToString3 = this.__converters.jsonObjectToString(entity.getMetadata());
                if (strJsonObjectToString3 == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, strJsonObjectToString3);
                }
                Long lDateToLong = this.__converters.dateToLong(entity.getDownloadTime());
                if (lDateToLong == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindLong(8, lDateToLong.longValue());
                }
                String relativePath = entity.getRelativePath();
                if (relativePath == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, relativePath);
                }
                byte[] hash = entity.getHash();
                if (hash == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindBlob(10, hash);
                }
                statement.bindLong(11, this.__converters.hashTypeToInt(entity.getHashType()));
                String expectedHash = entity.getExpectedHash();
                if (expectedHash == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, expectedHash);
                }
                statement.bindLong(13, entity.getMarkedForDeletion() ? 1L : 0L);
                statement.bindLong(14, entity.getId());
            }
        };
        this.__preparedStmtOfSetUpdateLaunchAssetInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.AssetDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE updates SET launch_asset_id = ? WHERE id = ?;";
            }
        };
        this.__preparedStmtOfMarkAllAssetsForDeletionInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.AssetDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE assets SET marked_for_deletion = 1;";
            }
        };
        this.__preparedStmtOfUnMarkUsedAssetsFromDeletionInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.AssetDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE assets SET marked_for_deletion = 0 WHERE id IN ( SELECT asset_id FROM updates_assets INNER JOIN updates ON updates_assets.update_id = updates.id WHERE updates.keep);";
            }
        };
        this.__preparedStmtOfUnMarkUsedLaunchAssetsFromDeletionInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.AssetDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE assets SET marked_for_deletion = 0 WHERE id IN ( SELECT launch_asset_id FROM updates WHERE updates.keep);";
            }
        };
        this.__preparedStmtOfUnMarkDuplicateUsedAssetsFromDeletionInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.AssetDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE assets SET marked_for_deletion = 0 WHERE relative_path IN ( SELECT relative_path FROM assets WHERE marked_for_deletion = 0);";
            }
        };
        this.__preparedStmtOfDeleteAssetsMarkedForDeletionInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.AssetDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM assets WHERE marked_for_deletion = 1;";
            }
        };
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected long insertAssetInternal(AssetEntity asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfAssetEntity.insertAndReturnId(asset);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected void insertUpdateAssetInternal(UpdateAssetEntity updateAsset) {
        Intrinsics.checkNotNullParameter(updateAsset, "updateAsset");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfUpdateAssetEntity.insert(updateAsset);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    public void updateAsset(AssetEntity assetEntity) {
        Intrinsics.checkNotNullParameter(assetEntity, "assetEntity");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfAssetEntity.handle(assetEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    public void insertAssets(List<AssetEntity> assets, UpdateEntity update) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(update, "update");
        this.__db.beginTransaction();
        try {
            super.insertAssets(assets, update);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    public boolean addExistingAssetToUpdate(UpdateEntity update, AssetEntity asset, boolean isLaunchAsset) {
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(asset, "asset");
        this.__db.beginTransaction();
        try {
            boolean zAddExistingAssetToUpdate = super.addExistingAssetToUpdate(update, asset, isLaunchAsset);
            this.__db.setTransactionSuccessful();
            return zAddExistingAssetToUpdate;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    public List<AssetEntity> deleteUnusedAssets() {
        this.__db.beginTransaction();
        try {
            List<AssetEntity> listDeleteUnusedAssets = super.deleteUnusedAssets();
            this.__db.setTransactionSuccessful();
            return listDeleteUnusedAssets;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected void setUpdateLaunchAssetInternal(long assetId, UUID updateId) {
        Intrinsics.checkNotNullParameter(updateId, "updateId");
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetUpdateLaunchAssetInternal.acquire();
        supportSQLiteStatementAcquire.bindLong(1, assetId);
        supportSQLiteStatementAcquire.bindBlob(2, this.__converters.uuidToBytes(updateId));
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfSetUpdateLaunchAssetInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfSetUpdateLaunchAssetInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected void markAllAssetsForDeletionInternal() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfMarkAllAssetsForDeletionInternal.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfMarkAllAssetsForDeletionInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfMarkAllAssetsForDeletionInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected void unMarkUsedAssetsFromDeletionInternal() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUnMarkUsedAssetsFromDeletionInternal.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfUnMarkUsedAssetsFromDeletionInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfUnMarkUsedAssetsFromDeletionInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected void unMarkUsedLaunchAssetsFromDeletionInternal() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUnMarkUsedLaunchAssetsFromDeletionInternal.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfUnMarkUsedLaunchAssetsFromDeletionInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfUnMarkUsedLaunchAssetsFromDeletionInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected void unMarkDuplicateUsedAssetsFromDeletionInternal() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUnMarkDuplicateUsedAssetsFromDeletionInternal.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfUnMarkDuplicateUsedAssetsFromDeletionInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfUnMarkDuplicateUsedAssetsFromDeletionInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected void deleteAssetsMarkedForDeletionInternal() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAssetsMarkedForDeletionInternal.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteAssetsMarkedForDeletionInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteAssetsMarkedForDeletionInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected List<AssetEntity> loadAssetsMarkedForDeletionInternal() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM assets WHERE marked_for_deletion = 1;", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ImagesContract.URL);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra_request_headers");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "metadata");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "relative_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash_type");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expected_hash");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "marked_for_deletion");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    int i = columnIndexOrThrow2;
                    AssetEntity assetEntity = new AssetEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    assetEntity.setId(cursorQuery.getLong(columnIndexOrThrow3));
                    assetEntity.setUrl(this.__converters.stringToUri(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4)));
                    assetEntity.setHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5)));
                    assetEntity.setExtraRequestHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)));
                    assetEntity.setMetadata(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7)));
                    assetEntity.setDownloadTime(this.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow8) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8))));
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        assetEntity.setRelativePath(null);
                    } else {
                        assetEntity.setRelativePath(cursorQuery.getString(columnIndexOrThrow9));
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        assetEntity.setHash(null);
                    } else {
                        assetEntity.setHash(cursorQuery.getBlob(columnIndexOrThrow10));
                    }
                    assetEntity.setHashType(this.__converters.intToHashType(cursorQuery.getInt(columnIndexOrThrow11)));
                    if (cursorQuery.isNull(columnIndexOrThrow12)) {
                        assetEntity.setExpectedHash(null);
                    } else {
                        assetEntity.setExpectedHash(cursorQuery.getString(columnIndexOrThrow12));
                    }
                    int i2 = columnIndexOrThrow13;
                    assetEntity.setMarkedForDeletion(cursorQuery.getInt(i2) != 0);
                    arrayList.add(assetEntity);
                    columnIndexOrThrow13 = i2;
                    columnIndexOrThrow2 = i;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    protected List<AssetEntity> loadAssetWithKeyInternal(String key) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM assets WHERE `key` = ? LIMIT 1;", 1);
        if (key == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, key);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ImagesContract.URL);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra_request_headers");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "metadata");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "relative_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash_type");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expected_hash");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "marked_for_deletion");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    int i = columnIndexOrThrow2;
                    AssetEntity assetEntity = new AssetEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    ArrayList arrayList2 = arrayList;
                    assetEntity.setId(cursorQuery.getLong(columnIndexOrThrow3));
                    assetEntity.setUrl(this.__converters.stringToUri(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4)));
                    assetEntity.setHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5)));
                    assetEntity.setExtraRequestHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)));
                    assetEntity.setMetadata(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7)));
                    assetEntity.setDownloadTime(this.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow8) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8))));
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        assetEntity.setRelativePath(null);
                    } else {
                        assetEntity.setRelativePath(cursorQuery.getString(columnIndexOrThrow9));
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        assetEntity.setHash(null);
                    } else {
                        assetEntity.setHash(cursorQuery.getBlob(columnIndexOrThrow10));
                    }
                    assetEntity.setHashType(this.__converters.intToHashType(cursorQuery.getInt(columnIndexOrThrow11)));
                    if (cursorQuery.isNull(columnIndexOrThrow12)) {
                        assetEntity.setExpectedHash(null);
                    } else {
                        assetEntity.setExpectedHash(cursorQuery.getString(columnIndexOrThrow12));
                    }
                    int i2 = columnIndexOrThrow13;
                    assetEntity.setMarkedForDeletion(cursorQuery.getInt(i2) != 0);
                    arrayList2.add(assetEntity);
                    columnIndexOrThrow13 = i2;
                    arrayList = arrayList2;
                    columnIndexOrThrow2 = i;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    public List<AssetEntity> loadAllAssets() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM assets;", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ImagesContract.URL);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra_request_headers");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "metadata");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "relative_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash_type");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expected_hash");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "marked_for_deletion");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    int i = columnIndexOrThrow2;
                    AssetEntity assetEntity = new AssetEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    assetEntity.setId(cursorQuery.getLong(columnIndexOrThrow3));
                    assetEntity.setUrl(this.__converters.stringToUri(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4)));
                    assetEntity.setHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5)));
                    assetEntity.setExtraRequestHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)));
                    assetEntity.setMetadata(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7)));
                    assetEntity.setDownloadTime(this.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow8) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8))));
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        assetEntity.setRelativePath(null);
                    } else {
                        assetEntity.setRelativePath(cursorQuery.getString(columnIndexOrThrow9));
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        assetEntity.setHash(null);
                    } else {
                        assetEntity.setHash(cursorQuery.getBlob(columnIndexOrThrow10));
                    }
                    assetEntity.setHashType(this.__converters.intToHashType(cursorQuery.getInt(columnIndexOrThrow11)));
                    if (cursorQuery.isNull(columnIndexOrThrow12)) {
                        assetEntity.setExpectedHash(null);
                    } else {
                        assetEntity.setExpectedHash(cursorQuery.getString(columnIndexOrThrow12));
                    }
                    int i2 = columnIndexOrThrow13;
                    assetEntity.setMarkedForDeletion(cursorQuery.getInt(i2) != 0);
                    arrayList.add(assetEntity);
                    columnIndexOrThrow13 = i2;
                    columnIndexOrThrow2 = i;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // expo.modules.updates.db.dao.AssetDao
    public List<AssetEntity> loadAssetsForUpdate(UUID id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        Intrinsics.checkNotNullParameter(id, "id");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT assets.* FROM assets INNER JOIN updates_assets ON updates_assets.asset_id = assets.id INNER JOIN updates ON updates_assets.update_id = updates.id WHERE updates.id = ?;", 1);
        roomSQLiteQueryAcquire.bindBlob(1, this.__converters.uuidToBytes(id));
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ImagesContract.URL);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra_request_headers");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "metadata");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "download_time");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "relative_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash_type");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expected_hash");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "marked_for_deletion");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    int i = columnIndexOrThrow2;
                    AssetEntity assetEntity = new AssetEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    ArrayList arrayList2 = arrayList;
                    assetEntity.setId(cursorQuery.getLong(columnIndexOrThrow3));
                    assetEntity.setUrl(this.__converters.stringToUri(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4)));
                    assetEntity.setHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5)));
                    assetEntity.setExtraRequestHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)));
                    assetEntity.setMetadata(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7)));
                    assetEntity.setDownloadTime(this.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow8) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8))));
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        assetEntity.setRelativePath(null);
                    } else {
                        assetEntity.setRelativePath(cursorQuery.getString(columnIndexOrThrow9));
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        assetEntity.setHash(null);
                    } else {
                        assetEntity.setHash(cursorQuery.getBlob(columnIndexOrThrow10));
                    }
                    assetEntity.setHashType(this.__converters.intToHashType(cursorQuery.getInt(columnIndexOrThrow11)));
                    if (cursorQuery.isNull(columnIndexOrThrow12)) {
                        assetEntity.setExpectedHash(null);
                    } else {
                        assetEntity.setExpectedHash(cursorQuery.getString(columnIndexOrThrow12));
                    }
                    int i2 = columnIndexOrThrow13;
                    assetEntity.setMarkedForDeletion(cursorQuery.getInt(i2) != 0);
                    arrayList2.add(assetEntity);
                    columnIndexOrThrow13 = i2;
                    arrayList = arrayList2;
                    columnIndexOrThrow2 = i;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    /* JADX INFO: compiled from: AssetDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/db/dao/AssetDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<Class<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
