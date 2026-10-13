package expo.modules.updates.db.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.datadog.trace.api.DDTags;
import com.datadog.trace.bootstrap.instrumentation.api.SamplerConstants;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.Converters;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpdateDao_Impl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0016\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020)H\u0014J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0016J$\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010/\u001a\u00020&2\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0\u001aH\u0014J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020 H\u0014J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020 0\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020 0\u001aH\u0016J\u001e\u00109\u001a\u00020\u00162\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u001a2\u0006\u0010\"\u001a\u00020#H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lexpo/modules/updates/db/dao/UpdateDao_Impl;", "Lexpo/modules/updates/db/dao/UpdateDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfUpdateEntity", "Landroidx/room/EntityInsertionAdapter;", "Lexpo/modules/updates/db/entity/UpdateEntity;", "__converters", "Lexpo/modules/updates/db/Converters;", "__deletionAdapterOfUpdateEntity", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "__preparedStmtOfKeepUpdate", "Landroidx/room/SharedSQLiteStatement;", "__preparedStmtOfMarkUpdateWithStatus", "__preparedStmtOf_setUpdateScopeKeyInternal", "__preparedStmtOfSetUpdateCommitTimeInternal", "__preparedStmtOfMarkUpdateAccessedInternal", "__preparedStmtOfIncrementSuccessfulLaunchCountInternal", "__preparedStmtOfIncrementFailedLaunchCountInternal", "insertUpdate", "", "update", "deleteUpdates", "updates", "", "markUpdateFinished", "hasSkippedEmbeddedAssets", "", "keepUpdate", "id", "Ljava/util/UUID;", "markUpdateWithStatus", "status", "Lexpo/modules/updates/db/enums/UpdateStatus;", "_setUpdateScopeKeyInternal", "newScopeKey", "", "setUpdateCommitTimeInternal", "commitTime", "Ljava/util/Date;", "markUpdateAccessedInternal", "lastAccessed", "incrementSuccessfulLaunchCountInternal", "incrementFailedLaunchCountInternal", "loadLaunchableUpdatesForProjectWithStatuses", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, "statuses", "loadUpdatesWithId", "loadLaunchAssetForUpdateInternal", "Lexpo/modules/updates/db/entity/AssetEntity;", "updateId", "loadAllUpdates", "loadAllUpdatesWithStatus", "loadAllUpdateIdsWithStatus", "loadRecentUpdateIdsWithFailedLaunch", "markUpdatesWithMissingAssets", "missingAssetIds", "", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdateDao_Impl extends UpdateDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Converters __converters;
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<UpdateEntity> __deletionAdapterOfUpdateEntity;
    private final EntityInsertionAdapter<UpdateEntity> __insertionAdapterOfUpdateEntity;
    private final SharedSQLiteStatement __preparedStmtOfIncrementFailedLaunchCountInternal;
    private final SharedSQLiteStatement __preparedStmtOfIncrementSuccessfulLaunchCountInternal;
    private final SharedSQLiteStatement __preparedStmtOfKeepUpdate;
    private final SharedSQLiteStatement __preparedStmtOfMarkUpdateAccessedInternal;
    private final SharedSQLiteStatement __preparedStmtOfMarkUpdateWithStatus;
    private final SharedSQLiteStatement __preparedStmtOfSetUpdateCommitTimeInternal;
    private final SharedSQLiteStatement __preparedStmtOf_setUpdateScopeKeyInternal;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public UpdateDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__converters = new Converters();
        this.__db = __db;
        this.__insertionAdapterOfUpdateEntity = new EntityInsertionAdapter<UpdateEntity>(__db) { // from class: expo.modules.updates.db.dao.UpdateDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `updates` (`id`,`commit_time`,`runtime_version`,`scope_key`,`manifest`,`url`,`headers`,`launch_asset_id`,`status`,`keep`,`last_accessed`,`successful_launch_count`,`failed_launch_count`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, UpdateEntity entity) throws JSONException {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindBlob(1, this.__converters.uuidToBytes(entity.getId()));
                Long lDateToLong = this.__converters.dateToLong(entity.getCommitTime());
                if (lDateToLong == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindLong(2, lDateToLong.longValue());
                }
                statement.bindString(3, entity.getRuntimeVersion());
                statement.bindString(4, entity.getScopeKey());
                String strJsonObjectToString = this.__converters.jsonObjectToString(entity.getManifest());
                if (strJsonObjectToString == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, strJsonObjectToString);
                }
                String strUriToString = this.__converters.uriToString(entity.getUrl());
                if (strUriToString == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, strUriToString);
                }
                String strStringStringMapToString = this.__converters.stringStringMapToString(entity.getRequestHeaders());
                if (strStringStringMapToString == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, strStringStringMapToString);
                }
                Long launchAssetId = entity.getLaunchAssetId();
                if (launchAssetId == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindLong(8, launchAssetId.longValue());
                }
                statement.bindLong(9, this.__converters.statusToInt(entity.getStatus()));
                statement.bindLong(10, entity.getKeep() ? 1L : 0L);
                Long lDateToLong2 = this.__converters.dateToLong(entity.getLastAccessed());
                if (lDateToLong2 == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindLong(11, lDateToLong2.longValue());
                }
                statement.bindLong(12, entity.getSuccessfulLaunchCount());
                statement.bindLong(13, entity.getFailedLaunchCount());
            }
        };
        this.__deletionAdapterOfUpdateEntity = new EntityDeletionOrUpdateAdapter<UpdateEntity>(__db) { // from class: expo.modules.updates.db.dao.UpdateDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `updates` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement statement, UpdateEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindBlob(1, this.__converters.uuidToBytes(entity.getId()));
            }
        };
        this.__preparedStmtOfKeepUpdate = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.UpdateDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE updates SET keep = 1 WHERE id = ?;";
            }
        };
        this.__preparedStmtOfMarkUpdateWithStatus = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.UpdateDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE updates SET status = ? WHERE id = ?;";
            }
        };
        this.__preparedStmtOf_setUpdateScopeKeyInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.UpdateDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE updates SET scope_key = ? WHERE id = ?;";
            }
        };
        this.__preparedStmtOfSetUpdateCommitTimeInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.UpdateDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE updates SET commit_time = ? WHERE id = ?;";
            }
        };
        this.__preparedStmtOfMarkUpdateAccessedInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.UpdateDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE updates SET last_accessed = ? WHERE id = ?;";
            }
        };
        this.__preparedStmtOfIncrementSuccessfulLaunchCountInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.UpdateDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE updates SET successful_launch_count = successful_launch_count + 1 WHERE id = ?;";
            }
        };
        this.__preparedStmtOfIncrementFailedLaunchCountInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.UpdateDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE updates SET failed_launch_count = failed_launch_count + 1 WHERE id = ?;";
            }
        };
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    public void insertUpdate(UpdateEntity update) {
        Intrinsics.checkNotNullParameter(update, "update");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfUpdateEntity.insert(update);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    public void deleteUpdates(List<UpdateEntity> updates) {
        Intrinsics.checkNotNullParameter(updates, "updates");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfUpdateEntity.handleMultiple(updates);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    public void markUpdateFinished(UpdateEntity update, boolean hasSkippedEmbeddedAssets) {
        Intrinsics.checkNotNullParameter(update, "update");
        this.__db.beginTransaction();
        try {
            super.markUpdateFinished(update, hasSkippedEmbeddedAssets);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    protected void keepUpdate(UUID id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfKeepUpdate.acquire();
        supportSQLiteStatementAcquire.bindBlob(1, this.__converters.uuidToBytes(id));
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfKeepUpdate.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfKeepUpdate.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    protected void markUpdateWithStatus(UpdateStatus status, UUID id) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(id, "id");
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfMarkUpdateWithStatus.acquire();
        supportSQLiteStatementAcquire.bindLong(1, this.__converters.statusToInt(status));
        supportSQLiteStatementAcquire.bindBlob(2, this.__converters.uuidToBytes(id));
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfMarkUpdateWithStatus.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfMarkUpdateWithStatus.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    public void _setUpdateScopeKeyInternal(UUID id, String newScopeKey) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(newScopeKey, "newScopeKey");
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOf_setUpdateScopeKeyInternal.acquire();
        supportSQLiteStatementAcquire.bindString(1, newScopeKey);
        supportSQLiteStatementAcquire.bindBlob(2, this.__converters.uuidToBytes(id));
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOf_setUpdateScopeKeyInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOf_setUpdateScopeKeyInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    public void setUpdateCommitTimeInternal(UUID id, Date commitTime) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(commitTime, "commitTime");
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetUpdateCommitTimeInternal.acquire();
        Long lDateToLong = this.__converters.dateToLong(commitTime);
        if (lDateToLong == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindLong(1, lDateToLong.longValue());
        }
        supportSQLiteStatementAcquire.bindBlob(2, this.__converters.uuidToBytes(id));
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfSetUpdateCommitTimeInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfSetUpdateCommitTimeInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    protected void markUpdateAccessedInternal(UUID id, Date lastAccessed) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lastAccessed, "lastAccessed");
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfMarkUpdateAccessedInternal.acquire();
        Long lDateToLong = this.__converters.dateToLong(lastAccessed);
        if (lDateToLong == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindLong(1, lDateToLong.longValue());
        }
        supportSQLiteStatementAcquire.bindBlob(2, this.__converters.uuidToBytes(id));
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfMarkUpdateAccessedInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfMarkUpdateAccessedInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    protected void incrementSuccessfulLaunchCountInternal(UUID id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfIncrementSuccessfulLaunchCountInternal.acquire();
        supportSQLiteStatementAcquire.bindBlob(1, this.__converters.uuidToBytes(id));
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfIncrementSuccessfulLaunchCountInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfIncrementSuccessfulLaunchCountInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    public void incrementFailedLaunchCountInternal(UUID id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfIncrementFailedLaunchCountInternal.acquire();
        supportSQLiteStatementAcquire.bindBlob(1, this.__converters.uuidToBytes(id));
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfIncrementFailedLaunchCountInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfIncrementFailedLaunchCountInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    protected List<UpdateEntity> loadLaunchableUpdatesForProjectWithStatuses(String scopeKey, List<? extends UpdateStatus> statuses) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        UpdateDao_Impl updateDao_Impl = this;
        String str = "getString(...)";
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(statuses, "statuses");
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM updates WHERE scope_key = ");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" AND (successful_launch_count > 0 OR failed_launch_count < 1) AND status IN (");
        int size = statuses.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(");");
        String string = sbNewStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire(string, size + 1);
        roomSQLiteQueryAcquire.bindString(1, scopeKey);
        Iterator<? extends UpdateStatus> it = statuses.iterator();
        int i = 2;
        while (it.hasNext()) {
            roomSQLiteQueryAcquire.bindLong(i, updateDao_Impl.__converters.statusToInt(it.next()));
            i++;
        }
        updateDao_Impl.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(updateDao_Impl.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "commit_time");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DDTags.RUNTIME_VERSION_TAG);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scope_key");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "manifest");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ImagesContract.URL);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "launch_asset_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SamplerConstants.KEEP);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_accessed");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "successful_launch_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failed_launch_count");
                int i2 = columnIndexOrThrow12;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = cursorQuery.getBlob(columnIndexOrThrow);
                    int i3 = columnIndexOrThrow;
                    Intrinsics.checkNotNullExpressionValue(blob, "getBlob(...)");
                    UUID uuidBytesToUuid = updateDao_Impl.__converters.bytesToUuid(blob);
                    Date dateLongToDate = updateDao_Impl.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2)));
                    if (dateLongToDate == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                    }
                    String string2 = cursorQuery.getString(columnIndexOrThrow3);
                    Intrinsics.checkNotNullExpressionValue(string2, str);
                    String string3 = cursorQuery.getString(columnIndexOrThrow4);
                    Intrinsics.checkNotNullExpressionValue(string3, str);
                    JSONObject jSONObjectStringToJsonObject = updateDao_Impl.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    if (jSONObjectStringToJsonObject == null) {
                        throw new IllegalStateException("Expected NON-NULL 'org.json.JSONObject', but it was NULL.".toString());
                    }
                    UpdateEntity updateEntity = new UpdateEntity(uuidBytesToUuid, dateLongToDate, string2, string3, jSONObjectStringToJsonObject, updateDao_Impl.__converters.stringToUri(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)), updateDao_Impl.__converters.stringToStringStringMap(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7)));
                    if (cursorQuery.isNull(columnIndexOrThrow8)) {
                        updateEntity.setLaunchAssetId(null);
                    } else {
                        updateEntity.setLaunchAssetId(Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8)));
                    }
                    updateEntity.setStatus(updateDao_Impl.__converters.intToStatus(cursorQuery.getInt(columnIndexOrThrow9)));
                    updateEntity.setKeep(cursorQuery.getInt(columnIndexOrThrow10) != 0);
                    Date dateLongToDate2 = updateDao_Impl.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)));
                    if (dateLongToDate2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                    }
                    updateEntity.setLastAccessed(dateLongToDate2);
                    int i4 = i2;
                    updateEntity.setSuccessfulLaunchCount(cursorQuery.getInt(i4));
                    int i5 = columnIndexOrThrow13;
                    updateEntity.setFailedLaunchCount(cursorQuery.getInt(i5));
                    arrayList.add(updateEntity);
                    updateDao_Impl = this;
                    i2 = i4;
                    columnIndexOrThrow13 = i5;
                    columnIndexOrThrow = i3;
                    str = str;
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

    @Override // expo.modules.updates.db.dao.UpdateDao
    protected List<UpdateEntity> loadUpdatesWithId(UUID id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        UpdateDao_Impl updateDao_Impl = this;
        String str = "getString(...)";
        Intrinsics.checkNotNullParameter(id, "id");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM updates WHERE id = ?;", 1);
        roomSQLiteQueryAcquire.bindBlob(1, updateDao_Impl.__converters.uuidToBytes(id));
        updateDao_Impl.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(updateDao_Impl.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "commit_time");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DDTags.RUNTIME_VERSION_TAG);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scope_key");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "manifest");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ImagesContract.URL);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "launch_asset_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SamplerConstants.KEEP);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_accessed");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "successful_launch_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failed_launch_count");
                int i = columnIndexOrThrow12;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = cursorQuery.getBlob(columnIndexOrThrow);
                    int i2 = columnIndexOrThrow;
                    Intrinsics.checkNotNullExpressionValue(blob, "getBlob(...)");
                    UUID uuidBytesToUuid = updateDao_Impl.__converters.bytesToUuid(blob);
                    Date dateLongToDate = updateDao_Impl.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2)));
                    if (dateLongToDate == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                    }
                    String string = cursorQuery.getString(columnIndexOrThrow3);
                    Intrinsics.checkNotNullExpressionValue(string, str);
                    String string2 = cursorQuery.getString(columnIndexOrThrow4);
                    Intrinsics.checkNotNullExpressionValue(string2, str);
                    JSONObject jSONObjectStringToJsonObject = updateDao_Impl.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    if (jSONObjectStringToJsonObject == null) {
                        throw new IllegalStateException("Expected NON-NULL 'org.json.JSONObject', but it was NULL.".toString());
                    }
                    UpdateEntity updateEntity = new UpdateEntity(uuidBytesToUuid, dateLongToDate, string, string2, jSONObjectStringToJsonObject, updateDao_Impl.__converters.stringToUri(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)), updateDao_Impl.__converters.stringToStringStringMap(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7)));
                    if (cursorQuery.isNull(columnIndexOrThrow8)) {
                        updateEntity.setLaunchAssetId(null);
                    } else {
                        updateEntity.setLaunchAssetId(Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8)));
                    }
                    updateEntity.setStatus(updateDao_Impl.__converters.intToStatus(cursorQuery.getInt(columnIndexOrThrow9)));
                    updateEntity.setKeep(cursorQuery.getInt(columnIndexOrThrow10) != 0);
                    Date dateLongToDate2 = updateDao_Impl.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)));
                    if (dateLongToDate2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                    }
                    updateEntity.setLastAccessed(dateLongToDate2);
                    int i3 = i;
                    updateEntity.setSuccessfulLaunchCount(cursorQuery.getInt(i3));
                    int i4 = columnIndexOrThrow13;
                    updateEntity.setFailedLaunchCount(cursorQuery.getInt(i4));
                    arrayList.add(updateEntity);
                    updateDao_Impl = this;
                    i = i3;
                    columnIndexOrThrow13 = i4;
                    columnIndexOrThrow = i2;
                    str = str;
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

    @Override // expo.modules.updates.db.dao.UpdateDao
    protected AssetEntity loadLaunchAssetForUpdateInternal(UUID updateId) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        AssetEntity assetEntity;
        Intrinsics.checkNotNullParameter(updateId, "updateId");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT assets.* FROM assets INNER JOIN updates ON updates.launch_asset_id = assets.id WHERE updates.id = ?;", 1);
        roomSQLiteQueryAcquire.bindBlob(1, this.__converters.uuidToBytes(updateId));
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
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "marked_for_deletion");
            if (cursorQuery.moveToFirst()) {
                roomSQLiteQuery = roomSQLiteQueryAcquire;
                try {
                    AssetEntity assetEntity2 = new AssetEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    assetEntity2.setId(cursorQuery.getLong(columnIndexOrThrow3));
                    assetEntity2.setUrl(this.__converters.stringToUri(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4)));
                    assetEntity2.setHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5)));
                    assetEntity2.setExtraRequestHeaders(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)));
                    assetEntity2.setMetadata(this.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7)));
                    assetEntity2.setDownloadTime(this.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow8) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8))));
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        assetEntity2.setRelativePath(null);
                    } else {
                        assetEntity2.setRelativePath(cursorQuery.getString(columnIndexOrThrow9));
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        assetEntity2.setHash(null);
                    } else {
                        assetEntity2.setHash(cursorQuery.getBlob(columnIndexOrThrow10));
                    }
                    assetEntity2.setHashType(this.__converters.intToHashType(cursorQuery.getInt(columnIndexOrThrow11)));
                    if (cursorQuery.isNull(columnIndexOrThrow12)) {
                        assetEntity2.setExpectedHash(null);
                    } else {
                        assetEntity2.setExpectedHash(cursorQuery.getString(columnIndexOrThrow12));
                    }
                    assetEntity2.setMarkedForDeletion(cursorQuery.getInt(columnIndexOrThrow13) != 0);
                    assetEntity = assetEntity2;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } else {
                roomSQLiteQuery = roomSQLiteQueryAcquire;
                assetEntity = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return assetEntity;
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    public List<UpdateEntity> loadAllUpdates() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        UpdateDao_Impl updateDao_Impl = this;
        String str = "getString(...)";
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM updates;", 0);
        updateDao_Impl.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(updateDao_Impl.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "commit_time");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DDTags.RUNTIME_VERSION_TAG);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scope_key");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "manifest");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ImagesContract.URL);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "launch_asset_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SamplerConstants.KEEP);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_accessed");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "successful_launch_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failed_launch_count");
                int i = columnIndexOrThrow12;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = cursorQuery.getBlob(columnIndexOrThrow);
                    int i2 = columnIndexOrThrow;
                    Intrinsics.checkNotNullExpressionValue(blob, "getBlob(...)");
                    UUID uuidBytesToUuid = updateDao_Impl.__converters.bytesToUuid(blob);
                    Date dateLongToDate = updateDao_Impl.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2)));
                    if (dateLongToDate == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                    }
                    String string = cursorQuery.getString(columnIndexOrThrow3);
                    Intrinsics.checkNotNullExpressionValue(string, str);
                    String string2 = cursorQuery.getString(columnIndexOrThrow4);
                    Intrinsics.checkNotNullExpressionValue(string2, str);
                    JSONObject jSONObjectStringToJsonObject = updateDao_Impl.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    if (jSONObjectStringToJsonObject == null) {
                        throw new IllegalStateException("Expected NON-NULL 'org.json.JSONObject', but it was NULL.".toString());
                    }
                    UpdateEntity updateEntity = new UpdateEntity(uuidBytesToUuid, dateLongToDate, string, string2, jSONObjectStringToJsonObject, updateDao_Impl.__converters.stringToUri(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)), updateDao_Impl.__converters.stringToStringStringMap(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7)));
                    if (cursorQuery.isNull(columnIndexOrThrow8)) {
                        updateEntity.setLaunchAssetId(null);
                    } else {
                        updateEntity.setLaunchAssetId(Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8)));
                    }
                    updateEntity.setStatus(updateDao_Impl.__converters.intToStatus(cursorQuery.getInt(columnIndexOrThrow9)));
                    updateEntity.setKeep(cursorQuery.getInt(columnIndexOrThrow10) != 0);
                    Date dateLongToDate2 = updateDao_Impl.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)));
                    if (dateLongToDate2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                    }
                    updateEntity.setLastAccessed(dateLongToDate2);
                    int i3 = i;
                    updateEntity.setSuccessfulLaunchCount(cursorQuery.getInt(i3));
                    int i4 = columnIndexOrThrow13;
                    updateEntity.setFailedLaunchCount(cursorQuery.getInt(i4));
                    arrayList.add(updateEntity);
                    updateDao_Impl = this;
                    i = i3;
                    columnIndexOrThrow13 = i4;
                    columnIndexOrThrow = i2;
                    str = str;
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

    @Override // expo.modules.updates.db.dao.UpdateDao
    public List<UpdateEntity> loadAllUpdatesWithStatus(UpdateStatus status) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        UpdateDao_Impl updateDao_Impl = this;
        String str = "getString(...)";
        Intrinsics.checkNotNullParameter(status, "status");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM updates WHERE status = ?;", 1);
        roomSQLiteQueryAcquire.bindLong(1, updateDao_Impl.__converters.statusToInt(status));
        updateDao_Impl.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(updateDao_Impl.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "commit_time");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DDTags.RUNTIME_VERSION_TAG);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scope_key");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "manifest");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ImagesContract.URL);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "launch_asset_id");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SamplerConstants.KEEP);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_accessed");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "successful_launch_count");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failed_launch_count");
                int i = columnIndexOrThrow12;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = cursorQuery.getBlob(columnIndexOrThrow);
                    int i2 = columnIndexOrThrow;
                    Intrinsics.checkNotNullExpressionValue(blob, "getBlob(...)");
                    UUID uuidBytesToUuid = updateDao_Impl.__converters.bytesToUuid(blob);
                    Date dateLongToDate = updateDao_Impl.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow2) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow2)));
                    if (dateLongToDate == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                    }
                    String string = cursorQuery.getString(columnIndexOrThrow3);
                    Intrinsics.checkNotNullExpressionValue(string, str);
                    String string2 = cursorQuery.getString(columnIndexOrThrow4);
                    Intrinsics.checkNotNullExpressionValue(string2, str);
                    JSONObject jSONObjectStringToJsonObject = updateDao_Impl.__converters.stringToJsonObject(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    if (jSONObjectStringToJsonObject == null) {
                        throw new IllegalStateException("Expected NON-NULL 'org.json.JSONObject', but it was NULL.".toString());
                    }
                    UpdateEntity updateEntity = new UpdateEntity(uuidBytesToUuid, dateLongToDate, string, string2, jSONObjectStringToJsonObject, updateDao_Impl.__converters.stringToUri(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6)), updateDao_Impl.__converters.stringToStringStringMap(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7)));
                    if (cursorQuery.isNull(columnIndexOrThrow8)) {
                        updateEntity.setLaunchAssetId(null);
                    } else {
                        updateEntity.setLaunchAssetId(Long.valueOf(cursorQuery.getLong(columnIndexOrThrow8)));
                    }
                    updateEntity.setStatus(updateDao_Impl.__converters.intToStatus(cursorQuery.getInt(columnIndexOrThrow9)));
                    updateEntity.setKeep(cursorQuery.getInt(columnIndexOrThrow10) != 0);
                    Date dateLongToDate2 = updateDao_Impl.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow11) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow11)));
                    if (dateLongToDate2 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                    }
                    updateEntity.setLastAccessed(dateLongToDate2);
                    int i3 = i;
                    updateEntity.setSuccessfulLaunchCount(cursorQuery.getInt(i3));
                    int i4 = columnIndexOrThrow13;
                    updateEntity.setFailedLaunchCount(cursorQuery.getInt(i4));
                    arrayList.add(updateEntity);
                    updateDao_Impl = this;
                    i = i3;
                    columnIndexOrThrow13 = i4;
                    columnIndexOrThrow = i2;
                    str = str;
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

    @Override // expo.modules.updates.db.dao.UpdateDao
    public List<UUID> loadAllUpdateIdsWithStatus(UpdateStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT id FROM updates WHERE status = ?;", 1);
        roomSQLiteQueryAcquire.bindLong(1, this.__converters.statusToInt(status));
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                byte[] blob = cursorQuery.getBlob(0);
                Intrinsics.checkNotNullExpressionValue(blob, "getBlob(...)");
                arrayList.add(this.__converters.bytesToUuid(blob));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    public List<UUID> loadRecentUpdateIdsWithFailedLaunch() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT id FROM updates WHERE failed_launch_count > 0 ORDER BY commit_time DESC LIMIT 5;", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                byte[] blob = cursorQuery.getBlob(0);
                Intrinsics.checkNotNullExpressionValue(blob, "getBlob(...)");
                arrayList.add(this.__converters.bytesToUuid(blob));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // expo.modules.updates.db.dao.UpdateDao
    protected void markUpdatesWithMissingAssets(List<Long> missingAssetIds, UpdateStatus status) {
        Intrinsics.checkNotNullParameter(missingAssetIds, "missingAssetIds");
        Intrinsics.checkNotNullParameter(status, "status");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE updates SET status = ");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" WHERE id IN (SELECT DISTINCT update_id FROM updates_assets WHERE asset_id IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, missingAssetIds.size());
        sbNewStringBuilder.append("));");
        String string = sbNewStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(string);
        supportSQLiteStatementCompileStatement.bindLong(1, this.__converters.statusToInt(status));
        Iterator<Long> it = missingAssetIds.iterator();
        int i = 2;
        while (it.hasNext()) {
            supportSQLiteStatementCompileStatement.bindLong(i, it.next().longValue());
            i++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    /* JADX INFO: compiled from: UpdateDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/db/dao/UpdateDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
