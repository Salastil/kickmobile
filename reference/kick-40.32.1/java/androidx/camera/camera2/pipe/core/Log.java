package androidx.camera.camera2.pipe.core;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.RumFeature;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.instance.InstanceFactory;

/* JADX INFO: compiled from: Log.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0016\u001a\u00020\u00172\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0086\bø\u0001\u0000J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0086\bø\u0001\u0000J\u001c\u0010\u001c\u001a\u00020\u00172\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0086\bø\u0001\u0000J$\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0086\bø\u0001\u0000J\u001c\u0010\u001d\u001a\u00020\u00172\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0086\bø\u0001\u0000J$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0086\bø\u0001\u0000J\u001c\u0010\u001e\u001a\u00020\u00172\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0086\bø\u0001\u0000J$\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0086\bø\u0001\u0000J/\u0010\u001f\u001a\u0002H \"\u0004\b\u0000\u0010 2\u0006\u0010\u0018\u001a\u00020\u00052\u000e\b\u0004\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2 = {"Landroidx/camera/camera2/pipe/core/Log;", "", "<init>", "()V", "TAG", "", "LOG_LEVEL_DEBUG", "", "LOG_LEVEL_INFO", "LOG_LEVEL_WARN", "LOG_LEVEL_ERROR", "LOG_LEVEL", "DEBUG_LOGGABLE", "", "getDEBUG_LOGGABLE", "()Z", "INFO_LOGGABLE", "getINFO_LOGGABLE", "WARN_LOGGABLE", "getWARN_LOGGABLE", "ERROR_LOGGABLE", "getERROR_LOGGABLE", "debug", "", NotificationCompat.CATEGORY_MESSAGE, "Lkotlin/Function0;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "info", "warn", "error", "rethrowExceptionAfterLogging", ExifInterface.GPS_DIRECTION_TRUE, "block", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "readStackTrace", "limit", "MonitoredLogMessages", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Log {
    private static final int LOG_LEVEL = 1;
    private static final int LOG_LEVEL_DEBUG = 1;
    private static final int LOG_LEVEL_ERROR = 4;
    private static final int LOG_LEVEL_INFO = 2;
    private static final int LOG_LEVEL_WARN = 3;
    public static final String TAG = "CXCP";
    public static final Log INSTANCE = new Log();
    private static final boolean DEBUG_LOGGABLE = true;
    private static final boolean INFO_LOGGABLE = true;
    private static final boolean WARN_LOGGABLE = true;
    private static final boolean ERROR_LOGGABLE = true;

    private Log() {
    }

    public final boolean getDEBUG_LOGGABLE() {
        return DEBUG_LOGGABLE;
    }

    public final boolean getINFO_LOGGABLE() {
        return INFO_LOGGABLE;
    }

    public final boolean getWARN_LOGGABLE() {
        return WARN_LOGGABLE;
    }

    public final boolean getERROR_LOGGABLE() {
        return ERROR_LOGGABLE;
    }

    public final void debug(Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getDEBUG_LOGGABLE()) {
            android.util.Log.d(TAG, msg.invoke());
        }
    }

    public final void debug(Throwable throwable, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getDEBUG_LOGGABLE()) {
            android.util.Log.d(TAG, msg.invoke(), throwable);
        }
    }

    public final void info(Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getINFO_LOGGABLE()) {
            android.util.Log.i(TAG, msg.invoke());
        }
    }

    public final void info(Throwable throwable, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getINFO_LOGGABLE()) {
            android.util.Log.i(TAG, msg.invoke(), throwable);
        }
    }

    public final void warn(Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getWARN_LOGGABLE()) {
            android.util.Log.w(TAG, msg.invoke());
        }
    }

    public final void warn(Throwable throwable, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getWARN_LOGGABLE()) {
            android.util.Log.w(TAG, msg.invoke(), throwable);
        }
    }

    public final void error(Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getERROR_LOGGABLE()) {
            android.util.Log.e(TAG, msg.invoke());
        }
    }

    public final void error(Throwable throwable, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getERROR_LOGGABLE()) {
            android.util.Log.e(TAG, msg.invoke(), throwable);
        }
    }

    public final <T> T rethrowExceptionAfterLogging(String msg, Function0<? extends T> block) throws Exception {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke();
        } catch (Exception e) {
            Exception exc = e;
            if (getERROR_LOGGABLE()) {
                android.util.Log.e(TAG, msg, exc);
            }
            throw e;
        }
    }

    public static /* synthetic */ String readStackTrace$default(Log log, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 4;
        }
        return log.readStackTrace(i);
    }

    public final String readStackTrace(int limit) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        return CollectionsKt.joinToString$default(ArraysKt.drop(stackTrace, 3), "\t", InstanceFactory.ERROR_SEPARATOR, null, limit, null, null, 52, null);
    }

    /* JADX INFO: compiled from: Log.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/pipe/core/Log$MonitoredLogMessages;", "", "<init>", "()V", "REPEATING_REQUEST_STARTED_TIMEOUT", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MonitoredLogMessages {
        public static final MonitoredLogMessages INSTANCE = new MonitoredLogMessages();
        public static final String REPEATING_REQUEST_STARTED_TIMEOUT = "awaitStarted on last repeating request timed out";

        private MonitoredLogMessages() {
        }
    }
}
