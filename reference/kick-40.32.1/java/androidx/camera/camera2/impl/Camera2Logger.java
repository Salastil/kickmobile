package androidx.camera.camera2.impl;

import android.os.Build;
import android.util.Log;
import androidx.camera.core.Logger;
import androidx.core.app.NotificationCompat;
import com.datadog.android.rum.internal.RumFeature;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2Logger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u001c\u0010\u000b\u001a\u00020\f2\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000J\u001c\u0010\u0011\u001a\u00020\f2\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000J$\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000J\u001c\u0010\u0012\u001a\u00020\f2\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000J$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000J\u001c\u0010\u0013\u001a\u00020\f2\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000J$\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000J\u001c\u0010\u0014\u001a\u00020\f2\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000J$\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Landroidx/camera/camera2/impl/Camera2Logger;", "", "<init>", "()V", "TAG", "", "MAX_TAG_LENGTH", "", "TRUNCATED_TAG", "truncateTag", "tag", "verbose", "", NotificationCompat.CATEGORY_MESSAGE, "Lkotlin/Function0;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "debug", "info", "warn", "error", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2Logger {
    public static final Camera2Logger INSTANCE;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG = "CXCP";
    private static final String TRUNCATED_TAG;

    private Camera2Logger() {
    }

    static {
        Camera2Logger camera2Logger = new Camera2Logger();
        INSTANCE = camera2Logger;
        TRUNCATED_TAG = camera2Logger.truncateTag("CXCP");
    }

    private final String truncateTag(String tag) {
        if (Build.VERSION.SDK_INT > 25 || 23 >= tag.length()) {
            return tag;
        }
        String strSubstring = tag.substring(0, 23);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final void verbose(Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isVerboseEnabled("CXCP")) {
            Log.v(TRUNCATED_TAG, msg.invoke());
        }
    }

    public final void verbose(Throwable throwable, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isVerboseEnabled("CXCP")) {
            Log.v(TRUNCATED_TAG, msg.invoke(), throwable);
        }
    }

    public final void debug(Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isDebugEnabled("CXCP")) {
            Log.d(TRUNCATED_TAG, msg.invoke());
        }
    }

    public final void debug(Throwable throwable, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isDebugEnabled("CXCP")) {
            Log.d(TRUNCATED_TAG, msg.invoke(), throwable);
        }
    }

    public final void info(Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isInfoEnabled("CXCP")) {
            Log.i(TRUNCATED_TAG, msg.invoke());
        }
    }

    public final void info(Throwable throwable, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isInfoEnabled("CXCP")) {
            Log.i(TRUNCATED_TAG, msg.invoke(), throwable);
        }
    }

    public final void warn(Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isWarnEnabled("CXCP")) {
            Log.w(TRUNCATED_TAG, msg.invoke());
        }
    }

    public final void warn(Throwable throwable, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isWarnEnabled("CXCP")) {
            Log.w(TRUNCATED_TAG, msg.invoke(), throwable);
        }
    }

    public final void error(Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isErrorEnabled("CXCP")) {
            Log.e(TRUNCATED_TAG, msg.invoke());
        }
    }

    public final void error(Throwable throwable, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Logger.isErrorEnabled("CXCP")) {
            Log.e(TRUNCATED_TAG, msg.invoke(), throwable);
        }
    }
}
