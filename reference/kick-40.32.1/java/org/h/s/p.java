package org.h.s;

import android.webkit.WebView;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class p {
    public static String a() {
        LocalLogger.log$default(16, 22409L, null, 4, null);
        return "window.m42 = '" + l.a() + "';";
    }

    public static void a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        webView.evaluateJavascript(a(), null);
    }
}
