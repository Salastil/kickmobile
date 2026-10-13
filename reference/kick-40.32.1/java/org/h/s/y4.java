package org.h.s;

import android.os.Handler;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class y4 {
    public static final void b(final x4 x4Var) {
        if (x4Var.f590a != null) {
            if (x4.d()) {
                WebView webView = x4Var.f590a;
                if (webView != null) {
                    webView.loadUrl("about:blank");
                    return;
                }
                return;
            }
            Handler handler = x4Var.i;
            if (handler != null) {
                handler.postAtFrontOfQueue(new Runnable() { // from class: org.h.s.y4$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        y4.c(x4Var);
                    }
                });
            }
        }
    }

    public static final void c(x4 this_clearWebView) {
        Intrinsics.checkNotNullParameter(this_clearWebView, "$this_clearWebView");
        b(this_clearWebView);
    }

    public static final void d(final x4 x4Var) {
        if (x4Var.f590a != null) {
            if (x4.d()) {
                WebView webView = x4Var.f590a;
                if (webView != null) {
                    webView.destroy();
                }
                x4Var.f590a = null;
                return;
            }
            Handler handler = x4Var.i;
            if (handler != null) {
                handler.postAtFrontOfQueue(new Runnable() { // from class: org.h.s.y4$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        y4.e(x4Var);
                    }
                });
            }
        }
    }

    public static final void e(x4 this_destroyWebView) {
        Intrinsics.checkNotNullParameter(this_destroyWebView, "$this_destroyWebView");
        d(this_destroyWebView);
    }
}
