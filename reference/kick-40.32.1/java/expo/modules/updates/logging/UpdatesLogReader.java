package expo.modules.updates.logging;

import expo.modules.core.logging.PersistentFileLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdatesLogReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2)\u0010\n\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\fj\u0004\u0018\u0001`\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\tJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\tH\u0002R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lexpo/modules/updates/logging/UpdatesLogReader;", "", "filesDirectory", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "purgeLogEntries", "", "olderThan", "Ljava/util/Date;", "completionHandler", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/ParameterName;", "name", "_", "Lkotlin/Exception;", "getLogEntries", "", "", "newerThan", "persistentLog", "Lexpo/modules/core/logging/PersistentFileLog;", "isEntryStringLaterThanTimestamp", "", "entryString", "timestamp", "", "epochFromDateOrOneDayAgo", "date", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesLogReader {
    private static final long ONE_DAY_MILLISECONDS = 86400000;
    private final PersistentFileLog persistentLog;

    public UpdatesLogReader(File filesDirectory) {
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        this.persistentLog = new PersistentFileLog(UpdatesLogger.EXPO_UPDATES_LOGGING_TAG, filesDirectory);
    }

    public static /* synthetic */ void purgeLogEntries$default(UpdatesLogReader updatesLogReader, Date date, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            date = new Date(new Date().getTime() - 86400000);
        }
        updatesLogReader.purgeLogEntries(date, function1);
    }

    public final void purgeLogEntries(Date olderThan, Function1<? super Exception, Unit> completionHandler) {
        Intrinsics.checkNotNullParameter(olderThan, "olderThan");
        Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
        final long jEpochFromDateOrOneDayAgo = epochFromDateOrOneDayAgo(olderThan);
        this.persistentLog.purgeEntriesNotMatchingFilter(new Function1() { // from class: expo.modules.updates.logging.UpdatesLogReader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UpdatesLogReader.purgeLogEntries$lambda$0(this.f$0, jEpochFromDateOrOneDayAgo, (String) obj));
            }
        }, completionHandler);
    }

    static final boolean purgeLogEntries$lambda$0(UpdatesLogReader updatesLogReader, long j, String entryString) {
        Intrinsics.checkNotNullParameter(entryString, "entryString");
        return updatesLogReader.isEntryStringLaterThanTimestamp(entryString, j);
    }

    public final List<String> getLogEntries(Date newerThan) {
        Intrinsics.checkNotNullParameter(newerThan, "newerThan");
        long jEpochFromDateOrOneDayAgo = epochFromDateOrOneDayAgo(newerThan);
        List<String> entries = this.persistentLog.readEntries();
        ArrayList arrayList = new ArrayList();
        for (Object obj : entries) {
            if (isEntryStringLaterThanTimestamp((String) obj, jEpochFromDateOrOneDayAgo)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean isEntryStringLaterThanTimestamp(String entryString, long timestamp) {
        Long timestamp2 = UpdatesLogEntry.INSTANCE.getTimestamp(entryString);
        return timestamp2 != null && timestamp2.longValue() >= timestamp;
    }

    private final long epochFromDateOrOneDayAgo(Date date) {
        return Long.max(date.getTime(), new Date().getTime() - 86400000);
    }
}
