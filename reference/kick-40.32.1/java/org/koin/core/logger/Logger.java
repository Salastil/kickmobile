package org.koin.core.logger;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u000b\u001a\u00060\fj\u0002`\rH&J\u0012\u0010\u000e\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rJ\u0012\u0010\u000f\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rJ\u0012\u0010\u0010\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rJ\u0012\u0010\u0011\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rJ\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0086\bJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0016H\u0086\bø\u0001\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"Lorg/koin/core/logger/Logger;", "", FirebaseAnalytics.Param.LEVEL, "Lorg/koin/core/logger/Level;", "<init>", "(Lorg/koin/core/logger/Level;)V", "getLevel", "()Lorg/koin/core/logger/Level;", "setLevel", "display", "", NotificationCompat.CATEGORY_MESSAGE, "", "Lorg/koin/core/logger/MESSAGE;", "debug", "info", "warn", "error", "isAt", "", "lvl", "log", "Lkotlin/Function0;", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Logger {
    private Level level;

    /* JADX WARN: Multi-variable type inference failed */
    public Logger() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public abstract void display(Level level, String msg);

    public Logger(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.level = level;
    }

    public /* synthetic */ Logger(Level level, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Level.INFO : level);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void setLevel(Level level) {
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        this.level = level;
    }

    public final void debug(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        log(Level.DEBUG, msg);
    }

    public final void info(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        log(Level.INFO, msg);
    }

    public final void warn(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        log(Level.WARNING, msg);
    }

    public final void error(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        log(Level.ERROR, msg);
    }

    public final boolean isAt(Level lvl) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        return getLevel().compareTo(lvl) <= 0;
    }

    public final void log(Level lvl, String msg) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getLevel().compareTo(lvl) <= 0) {
            display(lvl, msg);
        }
    }

    public final void log(Level lvl, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getLevel().compareTo(lvl) <= 0) {
            display(lvl, msg.invoke());
        }
    }
}
