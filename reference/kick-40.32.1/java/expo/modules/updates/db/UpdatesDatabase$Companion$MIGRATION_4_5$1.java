package expo.modules.updates.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.datadog.trace.api.DDSpanTypes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdatesDatabase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"expo/modules/updates/db/UpdatesDatabase$Companion$MIGRATION_4_5$1", "Landroidx/room/migration/Migration;", "migrate", "", DDSpanTypes.COUCHBASE, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesDatabase$Companion$MIGRATION_4_5$1 extends Migration {
    UpdatesDatabase$Companion$MIGRATION_4_5$1() {
        super(4, 5);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        UpdatesDatabase.INSTANCE.runInTransactionWithForeignKeysOff(db, new Function1() { // from class: expo.modules.updates.db.UpdatesDatabase$Companion$MIGRATION_4_5$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdatesDatabase$Companion$MIGRATION_4_5$1.migrate$lambda$0((SupportSQLiteDatabase) obj);
            }
        });
    }

    static final Unit migrate$lambda$0(SupportSQLiteDatabase runInTransactionWithForeignKeysOff) {
        Intrinsics.checkNotNullParameter(runInTransactionWithForeignKeysOff, "$this$runInTransactionWithForeignKeysOff");
        runInTransactionWithForeignKeysOff.execSQL("CREATE TABLE `new_assets` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url` TEXT, `key` TEXT, `headers` TEXT, `type` TEXT NOT NULL, `metadata` TEXT, `download_time` INTEGER, `relative_path` TEXT, `hash` BLOB, `hash_type` INTEGER NOT NULL, `marked_for_deletion` INTEGER NOT NULL)");
        runInTransactionWithForeignKeysOff.execSQL("INSERT INTO `new_assets` (`id`, `url`, `key`, `headers`, `type`, `metadata`, `download_time`, `relative_path`, `hash`, `hash_type`, `marked_for_deletion`) SELECT `id`, `url`, `key`, `headers`, `type`, `metadata`, `download_time`, `relative_path`, `hash`, `hash_type`, `marked_for_deletion` FROM `assets`");
        runInTransactionWithForeignKeysOff.execSQL("DROP TABLE `assets`");
        runInTransactionWithForeignKeysOff.execSQL("ALTER TABLE `new_assets` RENAME TO `assets`");
        runInTransactionWithForeignKeysOff.execSQL("CREATE UNIQUE INDEX `index_assets_key` ON `assets` (`key`)");
        return Unit.INSTANCE;
    }
}
