package org.h.s;

import io.mobileshield.sdk.config.Config;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class w4 extends v4 {
    public final /* synthetic */ x4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w4(x4 x4Var, URL url) {
        super(url);
        Intrinsics.checkNotNullParameter(url, "url");
        this.b = x4Var;
    }

    @Override // org.h.s.v4
    public final void a(String tokenString) {
        Intrinsics.checkNotNullParameter(tokenString, "tokenString");
        y1.h.a().a(r4.INTERROGATION, "received_js_response");
        y4.b(this.b);
        String host = a().getHost();
        Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
        String strB = this.b.b();
        Intrinsics.checkNotNull(strB);
        u uVar = new u(host, strB, new m(tokenString), (Config) null, true, a().getHost() + "/149e9513-01fa-4fb0-aad4-566afd725d1b/2d206a39-8ed7-437e-a3be-862e0f06eea3/fp", 64);
        uVar.e();
        s3 s3Var = f1.f506a;
        f1.a(w0.J, a() + " - " + uVar);
        n nVarA = this.b.a();
        if (nVarA != null) {
            ((f4) nVarA).a(uVar);
        }
    }
}
