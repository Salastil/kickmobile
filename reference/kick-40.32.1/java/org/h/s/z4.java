package org.h.s;

import android.webkit.JavascriptInterface;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v4 f596a;

    public z4(w4 w4Var) {
        this.f596a = w4Var;
    }

    @JavascriptInterface
    public final void failedToLoad() {
        v4 v4Var = this.f596a;
        if (v4Var != null) {
            w4 w4Var = (w4) v4Var;
            s3 s3Var = f1.f506a;
            f1.a(w0.K, null);
            n nVar = w4Var.b.c;
            if (nVar != null) {
                String host = w4Var.f583a.getHost();
                Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
                String string = w4Var.f583a.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                ((f4) nVar).a(host, string, "failed to load", 3);
            }
            if (y1.i == null) {
                y1.i = new y1(Dispatchers.getIO(), new t1());
            }
            y1 y1Var = y1.i;
            Intrinsics.checkNotNull(y1Var);
            y1Var.a(r4.INTERROGATION, "handle_interrogation_response");
        }
    }

    @JavascriptInterface
    public final void pMessage(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        LocalLogger.log(8, 22800L, text);
        v4 v4Var = this.f596a;
        if (v4Var != null) {
            v4Var.a(text);
        }
    }
}
