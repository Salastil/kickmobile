package com.amazon.mediatailorsdk.logs;

import android.util.Log;
import com.facebook.common.callercontext.ContextChain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/amazon/mediatailorsdk/logs/AndroidLogger;", "Lcom/amazon/mediatailorsdk/logs/Logger;", "<init>", "()V", "logLevel", "Lcom/amazon/mediatailorsdk/logs/LogLevel;", "setLevel", "", "e", "", "w", "d", ContextChain.TAG_INFRA, "v", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class AndroidLogger implements Logger {
    public static final AndroidLogger INSTANCE = new AndroidLogger();
    private static LogLevel logLevel = LogLevel.WARNING;

    private AndroidLogger() {
    }

    @Override // com.amazon.mediatailorsdk.logs.Logger
    public void setLevel(LogLevel logLevel2) {
        Intrinsics.checkNotNullParameter(logLevel2, "logLevel");
        logLevel = logLevel2;
    }

    @Override // com.amazon.mediatailorsdk.logs.Logger
    public void e(String e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (logLevel.getLevel() >= LogLevel.ERROR.getLevel()) {
            Log.e("MediaTailorSDK", e);
        }
    }

    @Override // com.amazon.mediatailorsdk.logs.Logger
    public void w(String w) {
        Intrinsics.checkNotNullParameter(w, "w");
        if (logLevel.getLevel() >= LogLevel.WARNING.getLevel()) {
            Log.w("MediaTailorSDK", w);
        }
    }

    @Override // com.amazon.mediatailorsdk.logs.Logger
    public void d(String d) {
        Intrinsics.checkNotNullParameter(d, "d");
        if (logLevel.getLevel() >= LogLevel.DEBUG.getLevel()) {
            Log.d("MediaTailorSDK", d);
        }
    }

    @Override // com.amazon.mediatailorsdk.logs.Logger
    public void i(String i) {
        Intrinsics.checkNotNullParameter(i, "i");
        if (logLevel.getLevel() >= LogLevel.INFO.getLevel()) {
            Log.i("MediaTailorSDK", i);
        }
    }

    @Override // com.amazon.mediatailorsdk.logs.Logger
    public void v(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (logLevel.getLevel() >= LogLevel.VERBOSE.getLevel()) {
            Log.v("MediaTailorSDK", v);
        }
    }
}
