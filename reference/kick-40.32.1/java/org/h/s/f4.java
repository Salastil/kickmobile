package org.h.s;

import android.content.Context;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.logger.LocalLogger;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes11.dex */
public final class f4 implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i4 f508a;

    public f4(i4 i4Var) {
        this.f508a = i4Var;
    }

    public final void a(u newDomainData) {
        Intrinsics.checkNotNullParameter(newDomainData, "fingerprint");
        s3 s3Var = f1.f506a;
        f1.a(w0.E, null);
        this.f508a.a(newDomainData);
        LocalLogger.log(8, 22303L, newDomainData.f576a);
        i4 i4Var = this.f508a;
        TimeUnit timeUnit = k4.f532a;
        i4Var.a(newDomainData, k4.a(i4Var.h()), k4.f532a);
        this.f508a.c();
        this.f508a.k.b();
        this.f508a.k();
        i4 i4Var2 = this.f508a;
        q1 q1Var = i4Var2.h.f542a;
        Context context = i4Var2.f523a;
        p1 p1Var = (p1) q1Var;
        p1Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(newDomainData, "newDomainData");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(p1Var.c), null, null, new o1(p1Var, context, newDomainData, null), 3, null);
    }

    public final void a(String domain, String fullurl, String msg, int i) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(fullurl, "fullurl");
        Intrinsics.checkNotNullParameter(msg, "msg");
        a4 a4VarB = this.f508a.g().b();
        a4 a4Var = a4.SLEEP;
        if (a4VarB == a4Var) {
            return;
        }
        x4 x4VarI = this.f508a.i();
        if (x4VarI != null) {
            x4VarI.g();
        }
        s3 s3Var = f1.f506a;
        f1.a(w0.F, domain + " - " + msg);
        u uVarH = this.f508a.h();
        if (uVarH == null || !Intrinsics.areEqual(uVarH.b(), domain)) {
            LocalLogger.log(2, 22320L, domain);
            String str = this.f508a.b;
            Intrinsics.checkNotNull(str);
            uVarH = new u(domain, str, (m) null, (Config) null, false, (String) null, 124);
        }
        String str2 = this.f508a.b;
        if (str2 != null && str2.length() != 0) {
            String str3 = this.f508a.b;
            Intrinsics.checkNotNull(str3);
            uVarH.a(str3);
        }
        uVarH.d();
        this.f508a.a(new u3(a4Var, i));
        i4 i4Var = this.f508a;
        i4Var.a(uVarH, i4Var.g.a(), k4.f532a);
    }

    public final void a(HashMap headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f508a.a((String) headers.get("x-kpsdk-h"), (String) headers.get("x-kpsdk-fc"));
    }
}
