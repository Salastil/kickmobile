package io.github.expo.modules.v2.logging;

import android.util.Log;
import com.datadog.android.rum.internal.RumFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformLogger.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/github/expo/modules/v2/logging/AndroidLogger;", "Lio/github/expo/modules/v2/logging/Logger;", "<init>", "()V", "TAG", "", "warn", "", "message", RumFeature.EVENT_THROWABLE_PROPERTY, "", "error", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidLogger implements Logger {
    public static final AndroidLogger INSTANCE = new AndroidLogger();
    private static final String TAG = "ExpoModulesV2";

    private AndroidLogger() {
    }

    @Override // io.github.expo.modules.v2.logging.Logger
    public void warn(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.w(TAG, message, throwable);
    }

    @Override // io.github.expo.modules.v2.logging.Logger
    public void error(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.e(TAG, message, throwable);
    }
}
