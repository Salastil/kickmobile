package expo.modules.updates.db.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.Converters;
import expo.modules.updates.db.entity.JSONDataEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSONDataDao_Impl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0014J \u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J$\u0010\u0016\u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J.\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00140\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\u0016\u0010!\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001eH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lexpo/modules/updates/db/dao/JSONDataDao_Impl;", "Lexpo/modules/updates/db/dao/JSONDataDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertionAdapterOfJSONDataEntity", "Landroidx/room/EntityInsertionAdapter;", "Lexpo/modules/updates/db/entity/JSONDataEntity;", "__converters", "Lexpo/modules/updates/db/Converters;", "__preparedStmtOfDeleteJSONDataForKeyInternal", "Landroidx/room/SharedSQLiteStatement;", "insertJSONDataInternal", "", "jsonDataEntity", "setJSONStringForKey", "key", "Lexpo/modules/updates/db/dao/JSONDataDao$JSONDataKey;", "value", "", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, "setMultipleFields", "fields", "", "updateJSONStringForKey", "updater", "Lkotlin/Function1;", "deleteJSONDataForKeysForAllScopeKeys", UserMetadata.KEYDATA_FILENAME, "", "deleteJSONDataForKeyInternal", "loadJSONDataForKeyInternal", "deleteJSONDataForKeysForAllScopeKeysInternal", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JSONDataDao_Impl extends JSONDataDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Converters __converters;
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<JSONDataEntity> __insertionAdapterOfJSONDataEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteJSONDataForKeyInternal;

    @JvmStatic
    public static final List<Class<?>> getRequiredConverters() {
        return INSTANCE.getRequiredConverters();
    }

    public JSONDataDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__converters = new Converters();
        this.__db = __db;
        this.__insertionAdapterOfJSONDataEntity = new EntityInsertionAdapter<JSONDataEntity>(__db) { // from class: expo.modules.updates.db.dao.JSONDataDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `json_data` (`key`,`value`,`last_updated`,`scope_key`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement statement, JSONDataEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindString(1, entity.getKey());
                statement.bindString(2, entity.getValue());
                Long lDateToLong = this.__converters.dateToLong(entity.getLastUpdated());
                if (lDateToLong == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindLong(3, lDateToLong.longValue());
                }
                statement.bindString(4, entity.getScopeKey());
                statement.bindLong(5, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteJSONDataForKeyInternal = new SharedSQLiteStatement(__db) { // from class: expo.modules.updates.db.dao.JSONDataDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM json_data WHERE `key` = ? AND scope_key = ?;";
            }
        };
    }

    @Override // expo.modules.updates.db.dao.JSONDataDao
    protected void insertJSONDataInternal(JSONDataEntity jsonDataEntity) {
        Intrinsics.checkNotNullParameter(jsonDataEntity, "jsonDataEntity");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfJSONDataEntity.insert(jsonDataEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.JSONDataDao
    public void setJSONStringForKey(JSONDataDao.JSONDataKey key, String value, String scopeKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        this.__db.beginTransaction();
        try {
            super.setJSONStringForKey(key, value, scopeKey);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.JSONDataDao
    public void setMultipleFields(Map<JSONDataDao.JSONDataKey, String> fields, String scopeKey) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        this.__db.beginTransaction();
        try {
            super.setMultipleFields(fields, scopeKey);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.JSONDataDao
    public void updateJSONStringForKey(JSONDataDao.JSONDataKey key, String scopeKey, Function1<? super String, String> updater) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(updater, "updater");
        this.__db.beginTransaction();
        try {
            super.updateJSONStringForKey(key, scopeKey, updater);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.JSONDataDao
    public void deleteJSONDataForKeysForAllScopeKeys(List<? extends JSONDataDao.JSONDataKey> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.__db.beginTransaction();
        try {
            super.deleteJSONDataForKeysForAllScopeKeys(keys);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // expo.modules.updates.db.dao.JSONDataDao
    protected void deleteJSONDataForKeyInternal(String key, String scopeKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteJSONDataForKeyInternal.acquire();
        supportSQLiteStatementAcquire.bindString(1, key);
        supportSQLiteStatementAcquire.bindString(2, scopeKey);
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteJSONDataForKeyInternal.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfDeleteJSONDataForKeyInternal.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // expo.modules.updates.db.dao.JSONDataDao
    protected List<JSONDataEntity> loadJSONDataForKeyInternal(String key, String scopeKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.INSTANCE.acquire("SELECT * FROM json_data WHERE `key` = ? AND scope_key = ? ORDER BY last_updated DESC LIMIT 1;", 2);
        roomSQLiteQueryAcquire.bindString(1, key);
        roomSQLiteQueryAcquire.bindString(2, scopeKey);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "value");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_updated");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scope_key");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(columnIndexOrThrow);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = cursorQuery.getString(columnIndexOrThrow2);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                Date dateLongToDate = this.__converters.longToDate(cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3)));
                if (dateLongToDate == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                String string3 = cursorQuery.getString(columnIndexOrThrow4);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                JSONDataEntity jSONDataEntity = new JSONDataEntity(string, string2, dateLongToDate, string3);
                jSONDataEntity.setId(cursorQuery.getLong(columnIndexOrThrow5));
                arrayList.add(jSONDataEntity);
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

    @Override // expo.modules.updates.db.dao.JSONDataDao
    protected void deleteJSONDataForKeysForAllScopeKeysInternal(List<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM json_data WHERE `key` IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, keys.size());
        sbNewStringBuilder.append(")");
        String string = sbNewStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(string);
        Iterator<String> it = keys.iterator();
        int i = 1;
        while (it.hasNext()) {
            supportSQLiteStatementCompileStatement.bindString(i, it.next());
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

    /* JADX INFO: compiled from: JSONDataDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/db/dao/JSONDataDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Ljava/lang/Class;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
