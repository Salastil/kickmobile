package io.mobileshield.sdk.logger;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/mobileshield/sdk/logger/LocalLogger;", "", "()V", "handler", "Lio/mobileshield/sdk/logger/LoggerHandler;", FirebaseAnalytics.Param.LEVEL, "", "init", "", "log", "code", "", "extraMessage", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocalLogger {
    private static LoggerHandler handler;
    public static final LocalLogger INSTANCE = new LocalLogger();
    private static int level = 16;

    private LocalLogger() {
    }

    @JvmStatic
    public static final void init(LoggerHandler handler2, int level2) {
        handler = handler2;
        level = level2;
    }

    @JvmStatic
    public static final void log(int i, long j) {
        log$default(i, j, null, 4, null);
    }

    public static /* synthetic */ void log$default(int i, long j, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        log(i, j, str);
    }

    @JvmStatic
    public static final void log(int level2, long code, String extraMessage) {
        LoggerHandler loggerHandler;
        if (level < level2 || (loggerHandler = handler) == null) {
            return;
        }
        loggerHandler.log(new LogEvent(System.currentTimeMillis(), level2, code, extraMessage));
    }
}
