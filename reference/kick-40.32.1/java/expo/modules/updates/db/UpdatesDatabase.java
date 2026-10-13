package expo.modules.updates.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.updates.db.dao.AssetDao;
import expo.modules.updates.db.dao.JSONDataDao;
import expo.modules.updates.db.dao.UpdateDao;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: UpdatesDatabase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lexpo/modules/updates/db/UpdatesDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "updateDao", "Lexpo/modules/updates/db/dao/UpdateDao;", "assetDao", "Lexpo/modules/updates/db/dao/AssetDao;", "jsonDataDao", "Lexpo/modules/updates/db/dao/JSONDataDao;", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class UpdatesDatabase extends RoomDatabase {
    private static final String DB_NAME = "updates.db";
    private static volatile UpdatesDatabase INSTANCE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Migration MIGRATION_4_5 = new UpdatesDatabase$Companion$MIGRATION_4_5$1();
    private static final Migration MIGRATION_5_6 = new UpdatesDatabase$Companion$MIGRATION_5_6$1();
    private static final Migration MIGRATION_6_7 = new UpdatesDatabase$Companion$MIGRATION_6_7$1();
    private static final Migration MIGRATION_7_8 = new UpdatesDatabase$Companion$MIGRATION_7_8$1();
    private static final Migration MIGRATION_8_9 = new UpdatesDatabase$Companion$MIGRATION_8_9$1();
    private static final Migration MIGRATION_9_10 = new UpdatesDatabase$Companion$MIGRATION_9_10$1();
    private static final Migration MIGRATION_10_11 = new UpdatesDatabase$Companion$MIGRATION_10_11$1();
    private static final Migration MIGRATION_11_12 = new UpdatesDatabase$Companion$MIGRATION_11_12$1();
    private static final Migration MIGRATION_12_13 = new UpdatesDatabase$Companion$MIGRATION_12_13$1();

    public abstract AssetDao assetDao();

    public abstract JSONDataDao jsonDataDao();

    public abstract UpdateDao updateDao();

    /* JADX INFO: compiled from: UpdatesDatabase.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ%\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0012H\u0002J%\u0010\u0013\u001a\u00020\u000e*\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u001e\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010 \u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\"\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010$\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010&\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006("}, d2 = {"Lexpo/modules/updates/db/UpdatesDatabase$Companion;", "", "<init>", "()V", "DB_NAME", "", "INSTANCE", "Lexpo/modules/updates/db/UpdatesDatabase;", "getInstance", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "runInTransaction", "", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "runInTransactionWithForeignKeysOff", "MIGRATION_4_5", "Landroidx/room/migration/Migration;", "getMIGRATION_4_5", "()Landroidx/room/migration/Migration;", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "MIGRATION_8_9", "getMIGRATION_8_9", "MIGRATION_9_10", "getMIGRATION_9_10", "MIGRATION_10_11", "getMIGRATION_10_11", "MIGRATION_11_12", "getMIGRATION_11_12", "MIGRATION_12_13", "getMIGRATION_12_13", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdatesDatabase getInstance(Context context, CoroutineDispatcher dispatcher) {
            UpdatesDatabase updatesDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            UpdatesDatabase updatesDatabase2 = UpdatesDatabase.INSTANCE;
            if (updatesDatabase2 != null) {
                return updatesDatabase2;
            }
            synchronized (this) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                RoomDatabase.Builder builderDatabaseBuilder = Room.databaseBuilder(applicationContext, UpdatesDatabase.class, UpdatesDatabase.DB_NAME);
                if (dispatcher != null) {
                    builderDatabaseBuilder.setQueryExecutor(ExecutorsKt.asExecutor(dispatcher));
                }
                updatesDatabase = (UpdatesDatabase) builderDatabaseBuilder.addMigrations(UpdatesDatabase.INSTANCE.getMIGRATION_4_5(), UpdatesDatabase.INSTANCE.getMIGRATION_5_6(), UpdatesDatabase.INSTANCE.getMIGRATION_6_7(), UpdatesDatabase.INSTANCE.getMIGRATION_7_8(), UpdatesDatabase.INSTANCE.getMIGRATION_8_9(), UpdatesDatabase.INSTANCE.getMIGRATION_9_10(), UpdatesDatabase.INSTANCE.getMIGRATION_10_11(), UpdatesDatabase.INSTANCE.getMIGRATION_11_12(), UpdatesDatabase.INSTANCE.getMIGRATION_12_13()).fallbackToDestructiveMigration().build();
                Companion companion = UpdatesDatabase.INSTANCE;
                UpdatesDatabase.INSTANCE = updatesDatabase;
            }
            return updatesDatabase;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runInTransaction(SupportSQLiteDatabase supportSQLiteDatabase, Function1<? super SupportSQLiteDatabase, Unit> function1) {
            supportSQLiteDatabase.beginTransaction();
            try {
                function1.invoke(supportSQLiteDatabase);
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runInTransactionWithForeignKeysOff(SupportSQLiteDatabase supportSQLiteDatabase, Function1<? super SupportSQLiteDatabase, Unit> function1) {
            try {
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys=OFF");
                runInTransaction(supportSQLiteDatabase, function1);
            } finally {
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys=ON");
            }
        }

        public final Migration getMIGRATION_4_5() {
            return UpdatesDatabase.MIGRATION_4_5;
        }

        public final Migration getMIGRATION_5_6() {
            return UpdatesDatabase.MIGRATION_5_6;
        }

        public final Migration getMIGRATION_6_7() {
            return UpdatesDatabase.MIGRATION_6_7;
        }

        public final Migration getMIGRATION_7_8() {
            return UpdatesDatabase.MIGRATION_7_8;
        }

        public final Migration getMIGRATION_8_9() {
            return UpdatesDatabase.MIGRATION_8_9;
        }

        public final Migration getMIGRATION_9_10() {
            return UpdatesDatabase.MIGRATION_9_10;
        }

        public final Migration getMIGRATION_10_11() {
            return UpdatesDatabase.MIGRATION_10_11;
        }

        public final Migration getMIGRATION_11_12() {
            return UpdatesDatabase.MIGRATION_11_12;
        }

        public final Migration getMIGRATION_12_13() {
            return UpdatesDatabase.MIGRATION_12_13;
        }
    }
}
