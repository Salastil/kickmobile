package expo.modules.updates.logging;

import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.core.logging.LogHandler;
import expo.modules.core.logging.LogHandlers;
import expo.modules.core.logging.LogType;
import expo.modules.core.logging.Logger;
import expo.modules.core.logging.LoggerTimer;
import expo.modules.notifications.service.NotificationsService;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdatesLogger.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ,\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ,\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ,\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tJ$\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\b\b\u0002\u0010\n\u001a\u00020\u000bJ8\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tJ$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\b\b\u0002\u0010\n\u001a\u00020\u000bJ8\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0013j\u0002`\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0016JO\u0010\u001c\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010!JC\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010#R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lexpo/modules/updates/logging/UpdatesLogger;", "Lexpo/modules/updates/logging/IUpdatesLogger;", "filesDirectory", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "trace", "", "message", "", "code", "Lexpo/modules/updates/logging/UpdatesErrorCode;", "updateId", "assetId", "debug", "info", "warn", "error", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "fatal", NotificationsService.EXCEPTION_KEY, "startTimer", "Lexpo/modules/core/logging/LoggerTimer;", "label", "logger", "Lexpo/modules/core/logging/Logger;", "logEntryWithCauseExceptionString", FirebaseAnalytics.Param.LEVEL, "Lexpo/modules/core/logging/LogType;", "duration", "", "(Ljava/lang/String;Ljava/lang/Exception;Lexpo/modules/updates/logging/UpdatesErrorCode;Lexpo/modules/core/logging/LogType;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "logEntryString", "(Ljava/lang/String;Lexpo/modules/updates/logging/UpdatesErrorCode;Lexpo/modules/core/logging/LogType;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesLogger implements IUpdatesLogger {
    public static final String EXPO_UPDATES_LOGGING_TAG = "dev.expo.updates";
    public static final int MAX_FRAMES_IN_STACKTRACE = 20;
    private final Logger logger;

    public UpdatesLogger(File filesDirectory) {
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        this.logger = new Logger(CollectionsKt.listOf((Object[]) new LogHandler[]{LogHandlers.INSTANCE.createOSLogHandler(EXPO_UPDATES_LOGGING_TAG), LogHandlers.INSTANCE.createPersistentFileLogHandler(filesDirectory, EXPO_UPDATES_LOGGING_TAG)}));
    }

    public static /* synthetic */ void trace$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.trace(str, updatesErrorCode);
    }

    public final void trace(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        trace(message, code, null, null);
    }

    public static /* synthetic */ void trace$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.trace(str, updatesErrorCode, str2, str3);
    }

    public final void trace(String message, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        this.logger.trace(logEntryString(message, code, LogType.Trace, null, updateId, assetId));
    }

    public static /* synthetic */ void debug$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.debug(str, updatesErrorCode);
    }

    public final void debug(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        debug(message, code, null, null);
    }

    public static /* synthetic */ void debug$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.debug(str, updatesErrorCode, str2, str3);
    }

    public final void debug(String message, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        this.logger.debug(logEntryString(message, code, LogType.Debug, null, updateId, assetId));
    }

    public static /* synthetic */ void info$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.info(str, updatesErrorCode);
    }

    public final void info(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        info(message, code, null, null);
    }

    public static /* synthetic */ void info$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.info(str, updatesErrorCode, str2, str3);
    }

    public final void info(String message, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        this.logger.info(logEntryString(message, code, LogType.Info, null, updateId, assetId));
    }

    public static /* synthetic */ void warn$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.warn(str, updatesErrorCode);
    }

    public final void warn(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        warn(message, code, null, null);
    }

    public static /* synthetic */ void warn$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.warn(str, updatesErrorCode, str2, str3);
    }

    public final void warn(String message, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        Logger.warn$default(this.logger, logEntryString(message, code, LogType.Warn, null, updateId, assetId), null, 2, null);
    }

    public static /* synthetic */ void error$default(UpdatesLogger updatesLogger, String str, Exception exc, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 4) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.error(str, exc, updatesErrorCode);
    }

    public final void error(String message, Exception cause, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(code, "code");
        error(message, cause, code, null, null);
    }

    public static /* synthetic */ void error$default(UpdatesLogger updatesLogger, String str, Exception exc, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.error(str, exc, updatesErrorCode, str2, str3);
    }

    public final void error(String message, Exception cause, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(code, "code");
        Logger.error$default(this.logger, logEntryWithCauseExceptionString(message, cause, code, LogType.Error, null, updateId, assetId), null, 2, null);
    }

    public static /* synthetic */ void fatal$default(UpdatesLogger updatesLogger, String str, Exception exc, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 4) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.fatal(str, exc, updatesErrorCode);
    }

    public final void fatal(String message, Exception cause, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(code, "code");
        fatal(message, cause, code, null, null);
    }

    public static /* synthetic */ void fatal$default(UpdatesLogger updatesLogger, String str, Exception exc, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.fatal(str, exc, updatesErrorCode, str2, str3);
    }

    public final void fatal(String message, Exception exception, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(code, "code");
        Logger.fatal$default(this.logger, logEntryWithCauseExceptionString(message, exception, code, LogType.Fatal, null, updateId, assetId), null, 2, null);
    }

    @Override // expo.modules.updates.logging.IUpdatesLogger
    public LoggerTimer startTimer(final String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        return this.logger.startTimer(new Function1() { // from class: expo.modules.updates.logging.UpdatesLogger$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.logEntryString(label, UpdatesErrorCode.None, LogType.Timer, Long.valueOf(((Long) obj).longValue()), null, null);
            }
        });
    }

    private final String logEntryWithCauseExceptionString(String message, Exception exception, UpdatesErrorCode code, LogType level, Long duration, String updateId, String assetId) {
        long time = new Date().getTime();
        String code2 = code.getCode();
        String type = level.getType();
        StackTraceElement[] stackTrace = exception.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
        List listTake = ArraysKt.take(stackTrace, 20);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTake, 10));
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            String string = ((StackTraceElement) it.next()).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            arrayList.add(string);
        }
        return new UpdatesLogEntry(time, message, code2, type, duration, updateId, assetId, arrayList).asString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String logEntryString(String message, UpdatesErrorCode code, LogType level, Long duration, String updateId, String assetId) {
        return new UpdatesLogEntry(new Date().getTime(), message, code.getCode(), level.getType(), duration, updateId, assetId, null).asString();
    }
}
