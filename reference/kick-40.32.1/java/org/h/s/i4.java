package org.h.s;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.view.Display;
import io.ktor.sse.ServerSentEventKt;
import io.mobileshield.sdk.Priority;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.logger.LocalLogger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class i4 implements c4 {
    public static final /* synthetic */ KProperty[] p = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(i4.class, "domainData", "getDomainData()Lio/mobileshield/sdk/data/domain/DomainData;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f523a;
    public String b;
    public Config[] c;
    public final CoroutineDispatcher d;
    public final b4 e;
    public final l2 f;
    public t3 g;
    public final m4 h;
    public final x3 i;
    public x4 j;
    public final c0 k;
    public u3 l;
    public final Priority m;
    public boolean n;
    public final h o;

    public i4(Context context, Priority priority) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.f523a = context;
        this.d = Dispatchers.getIO();
        this.e = new b4();
        c0 c0Var = new c0();
        this.k = c0Var;
        this.l = new u3(a4.NETWORKCHECK, 0);
        this.m = Priority.LOW;
        this.o = i.a();
        this.m = priority;
        e4 e4Var = new e4(this);
        this.i = new x3(new d4(this));
        this.f = new l2(e4Var);
        this.h = new m4(new p1(f()));
        this.g = c0Var.a();
        c0Var.b();
        j();
        y1.h.a().a(r4.INITIALISATION, "sc_construction");
    }

    public final void c() {
        x4 x4Var = this.j;
        if (x4Var != null) {
            Intrinsics.checkNotNull(x4Var);
            x4Var.d = null;
            x4Var.e = null;
            x4Var.c = null;
            x4Var.h = null;
            Handler handler = x4Var.i;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            x4Var.k = null;
            x4Var.l = 0L;
            y4.d(x4Var);
            x4Var.i = null;
            this.j = null;
        }
    }

    public final synchronized x4 d() {
        x4 x4Var;
        Throwable th;
        Context contextCreateWindowContext;
        Object objM12684constructorimpl;
        if (this.j == null) {
            if (!this.n) {
                Context context = this.f523a;
                Intrinsics.checkNotNullParameter(context, "context");
                TimeUnit timeUnit = t4.f575a;
                int i = Build.VERSION.SDK_INT;
                if (i >= 30) {
                    Display display = ((DisplayManager) context.getSystemService(DisplayManager.class)).getDisplay(0);
                    if (i < 31) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            contextCreateWindowContext = context.createDisplayContext(display).createWindowContext(2038, null);
                            Intrinsics.checkNotNullExpressionValue(contextCreateWindowContext, "createWindowContext(...)");
                            try {
                                objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion2 = Result.INSTANCE;
                                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            contextCreateWindowContext = context;
                        }
                        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
                        if (thM12687exceptionOrNullimpl != null) {
                            LocalLogger.log(4, 22332L, thM12687exceptionOrNullimpl.getMessage());
                        } else {
                            context = contextCreateWindowContext;
                        }
                    } else if (!context.isUiContext()) {
                        context = context.createWindowContext(display, 2, null);
                        Intrinsics.checkNotNullExpressionValue(context, "createWindowContext(...)");
                    }
                }
                Intrinsics.checkNotNullParameter(context, "<set-?>");
                this.f523a = context;
                this.n = true;
            }
            this.j = new x4(this.b, this.f523a, new f4(this), this.m);
            y1.h.a().a(r4.INTERROGATION, "create_webview_controller");
        }
        x4Var = this.j;
        Intrinsics.checkNotNull(x4Var);
        return x4Var;
    }

    public final void e() {
        LocalLogger.log(8, 22329L, "Delete data");
        ((p1) this.h.f542a).a((u) null);
        this.i.a();
        a((u) null);
        try {
            Context ctx = this.f523a;
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            LocalLogger.log(8, 22204L, null);
            ctx.deleteFile("a.txt");
        } catch (Exception unused) {
            LocalLogger.log(8, 22330L, "Error deleting data");
        }
    }

    public final Context f() {
        return this.f523a;
    }

    public final u3 g() {
        return this.l;
    }

    public final u h() {
        h hVar = this.o;
        KProperty property = p[0];
        hVar.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        return (u) hVar.f515a.get();
    }

    public final x4 i() {
        return this.j;
    }

    public final void j() {
        if (this.m == Priority.HIGH) {
            u uVarA = this.h.f542a.a();
            if (uVarA == null || m4.a(uVarA)) {
                d();
            }
        }
    }

    public final synchronized void k() {
        a(new u3(a4.DONE, 0));
        l2 l2Var = this.f;
        Context context = this.f523a;
        CoroutineDispatcher dispatcher = Dispatchers.getIO();
        l2Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        if (l2Var.e) {
            if (l2Var.d < 5) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new k2(l2Var, context, null), 3, null);
            } else {
                LocalLogger.log(16, 24003L, "Max attempts reached for network callback");
            }
        }
        y1 y1VarA = y1.h.a();
        r4 type = r4.INTERROGATION;
        y1VarA.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        y1VarA.a(type, "set_to_done");
        if (y1VarA.e.contains(type)) {
            y1VarA.f.remove(type);
        }
        q4 q4Var = (q4) y1VarA.d.remove(type);
        if (q4Var != null) {
            if (q4Var.f == 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                q4Var.f = jCurrentTimeMillis;
                q4Var.g = jCurrentTimeMillis - q4Var.e;
            }
            y1VarA.c.add(q4Var);
        }
    }

    public final void b() {
        u1 u1Var = y1.h;
        y1 y1VarA = u1Var.a();
        r4 r4Var = r4.INTERROGATION;
        y1.a(y1VarA, r4Var);
        s3 s3Var = f1.f506a;
        f1.a(w0.C, this.m.name());
        m4 m4Var = this.h;
        Context context = this.f523a;
        Config[] configArr = this.c;
        Config[] configArr2 = null;
        if (configArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localConfig");
            configArr = null;
        }
        u uVarA = m4Var.a(context, configArr, h());
        f1.a(w0.D, String.valueOf(uVarA == null));
        if (uVarA == null) {
            y1 y1VarA2 = u1Var.a();
            y1VarA2.getClass();
            Intrinsics.checkNotNullParameter("invalidTokenOnLoad", "interrogationStatus");
            q4 q4Var = (q4) y1VarA2.d.get(r4Var);
            z1 z1Var = q4Var != null ? q4Var.j : null;
            if (z1Var != null) {
                z1Var.a("invalidTokenOnLoad");
            }
            this.f.a(this.f523a);
            return;
        }
        y1 y1VarA3 = u1Var.a();
        y1VarA3.getClass();
        Intrinsics.checkNotNullParameter("validTokenOnLoad", "interrogationStatus");
        q4 q4Var2 = (q4) y1VarA3.d.get(r4Var);
        z1 z1Var2 = q4Var2 != null ? q4Var2.j : null;
        if (z1Var2 != null) {
            z1Var2.a("validTokenOnLoad");
        }
        Config[] configArr3 = this.c;
        if (configArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localConfig");
        } else {
            configArr2 = configArr3;
        }
        a(configArr2, uVarA);
    }

    public final void a(u uVar) {
        h hVar = this.o;
        KProperty property = p[0];
        hVar.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        hVar.f515a.set(uVar);
    }

    public final void b(u someDomainData, long j, TimeUnit tUnit) {
        Intrinsics.checkNotNullParameter(someDomainData, "someDomainData");
        Intrinsics.checkNotNullParameter(tUnit, "tUnit");
        LocalLogger.log(16, 22309L, someDomainData.b() + " with expiry " + j + tUnit.name());
        a(someDomainData);
        this.i.a(j, tUnit);
        LocalLogger.log(16, 22316L, someDomainData.b());
    }

    public final void a(String userAgent, Config[] config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        if (config.length == 0) {
            LocalLogger.log(2, 22319L, "Something is wrong with the provided config");
            return;
        }
        this.b = userAgent;
        x4 x4Var = this.j;
        if (x4Var != null) {
            x4Var.b = userAgent;
        }
        this.c = config;
        if (y1.i == null) {
            y1.i = new y1(Dispatchers.getIO(), new t1());
        }
        y1 y1Var = y1.i;
        Intrinsics.checkNotNull(y1Var);
        r4 type = r4.INITIALISATION;
        y1Var.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        y1Var.a(type, "finish_init");
        if (y1Var.e.contains(type)) {
            y1Var.f.remove(type);
        }
        q4 q4Var = (q4) y1Var.d.remove(type);
        if (q4Var != null) {
            if (q4Var.f == 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                q4Var.f = jCurrentTimeMillis;
                q4Var.g = jCurrentTimeMillis - q4Var.e;
            }
            y1Var.c.add(q4Var);
        }
        if (this.m != Priority.LAZY) {
            b();
            return;
        }
        a(new u3(a4.INIT, 0));
        if (a()) {
            this.i.a();
            a((u) null);
        }
    }

    public final void a(Config[] configArr, u uVar) {
        if ((uVar != null ? uVar.a() : null) != null) {
            TimeUnit timeUnit = k4.f532a;
            m mVarA = uVar.a();
            Intrinsics.checkNotNull(mVarA);
            long jA = k4.a(mVarA);
            TimeUnit timeUnit2 = k4.f532a;
            LocalLogger.log(8, 22306L, uVar + " - " + jA + ServerSentEventKt.SPACE + timeUnit2);
            m mVarA2 = uVar.a();
            Intrinsics.checkNotNull(mVarA2);
            b(uVar, k4.a(mVarA2), timeUnit2);
            k();
            return;
        }
        if ((configArr.length == 0) || this.b == null) {
            return;
        }
        Config config = configArr[0];
        String domain = config.getDomain();
        String str = this.b;
        Intrinsics.checkNotNull(str);
        b(new u(domain, str, new m(), config, false, (String) null, 112), 0L, k4.f532a);
    }

    public final void a(u3 state) {
        s3 s3Var = f1.f506a;
        f1.a(w0.H, state.f579a.name());
        this.l = state;
        b4 b4Var = this.e;
        b4Var.getClass();
        Intrinsics.checkNotNullParameter(state, "state");
        if (b4Var.f491a.isEmpty()) {
            return;
        }
        LocalLogger.log(16, 22325L, "");
        Iterator it = CollectionsKt.toList(b4Var.f491a).iterator();
        while (it.hasNext()) {
            ((j4) it.next()).a(state);
        }
    }

    public final void a(String str) {
        try {
            LocalLogger.log(8, 22302L, str);
            URL url = new URL(str);
            x4 x4VarD = d();
            x4VarD.getClass();
            Intrinsics.checkNotNullParameter(url, "url");
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            String str2 = x4VarD.k;
            if (str2 == null || !StringsKt.equals(str2, url.toString(), true) || timeInMillis - x4VarD.l > 18000) {
                x4VarD.k = url.toString();
                x4VarD.l = timeInMillis;
                x4VarD.a(url);
            }
        } catch (MalformedURLException unused) {
            LocalLogger.log(16, 22315L, str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    public final void a(r responseData) {
        Long longOrNull;
        m mVar;
        Long l;
        m mVar2;
        String strA;
        String str;
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        this.h.getClass();
        Intrinsics.checkNotNullParameter(this, "store");
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        u uVarH = h();
        m mVar3 = uVarH != null ? uVarH.c : null;
        if (mVar3 != null) {
            mVar3.h = o0.a(responseData.b, responseData.f563a);
        }
        String input = responseData.c;
        String token = responseData.f563a;
        boolean z = true;
        if (input == null || input.length() == 0 || token == null || token.length() == 0) {
            longOrNull = null;
        } else {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(token, "token");
            List listSplit$default = StringsKt.contains$default((CharSequence) input, (CharSequence) "-", false, 2, (Object) null) ? StringsKt.split$default((CharSequence) input, new String[]{"-"}, false, 0, 6, (Object) null) : null;
            if (listSplit$default != null) {
                String str2 = (String) listSplit$default.get(0);
                String str3 = (String) listSplit$default.get(1);
                if (!Intrinsics.areEqual(str2, "1") || (strA = v.a(str3, token)) == null) {
                    longOrNull = null;
                } else {
                    List listSplit$default2 = StringsKt.contains$default((CharSequence) strA, (CharSequence) ServerSentEventKt.COLON, false, 2, (Object) null) ? StringsKt.split$default((CharSequence) strA, new String[]{ServerSentEventKt.COLON}, false, 0, 6, (Object) null) : null;
                    if (listSplit$default2 == null || (str = (String) CollectionsKt.last(listSplit$default2)) == null) {
                        longOrNull = null;
                    } else {
                        longOrNull = StringsKt.toLongOrNull(str);
                    }
                }
            } else {
                longOrNull = null;
            }
        }
        if (longOrNull != null) {
            long jLongValue = longOrNull.longValue();
            if (uVarH != null && (mVar2 = uVarH.c) != null) {
                mVar2.g = System.currentTimeMillis();
                mVar2.f = jLongValue;
                mVar2.a();
            }
        }
        int i = responseData.d;
        String str4 = o0.b;
        if ((str4 != null || i != 429) && (str4 == null || uVarH == null || (mVar = uVarH.c) == null || (l = mVar.h) == null || l.longValue() != 0)) {
            z = false;
        }
        if (z) {
            LocalLogger.log(8, 22013L, "");
        }
        if (z) {
            u uVarH2 = h();
            if (uVarH2 != null && this.i.c && uVarH2.e) {
                s3 s3Var = f1.f506a;
                f1.a(w0.G, null);
                a(uVarH2, this.g.b, k4.f532a);
                uVarH2.e = false;
                if (this.m != Priority.LAZY) {
                    u uVarH3 = h();
                    if (uVarH3 != null) {
                        if (!uVarH3.e) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.d), null, null, new g4(this, uVarH3, null), 3, null);
                            return;
                        } else {
                            LocalLogger.log(16, 22314L, uVarH3.f576a);
                            return;
                        }
                    }
                    return;
                }
                e();
                a(new u3(a4.INIT, 0));
                return;
            }
            return;
        }
        int i2 = responseData.d;
        String str5 = responseData.f563a;
        if ((o0.b == null && i2 == 429) || str5 == null || str5.length() == 0) {
            return;
        }
        LocalLogger.log(8, 22014L, "");
        String str6 = responseData.f563a;
        u uVarH4 = h();
        if ((uVarH4 != null ? uVarH4.c : null) == null) {
            LocalLogger.log(8, 22311L, "token empty");
            return;
        }
        LocalLogger.log(16, 22308L, str6);
        u uVarH5 = h();
        if (uVarH5 != null) {
            m mVar4 = uVarH5.c;
            if (mVar4 != null) {
                mVar4.a(str6);
            }
            uVarH5.e();
            a(uVarH5, k4.a(uVarH5), k4.f532a);
        }
        m4 m4Var = this.h;
        Context context = this.f523a;
        u newDomainData = h();
        m4Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (newDomainData != null) {
            p1 p1Var = (p1) m4Var.f542a;
            p1Var.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(newDomainData, "newDomainData");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(p1Var.c), null, null, new o1(p1Var, context, newDomainData, null), 3, null);
        }
    }

    public final void a(u uVar, long j, TimeUnit timeUnit) {
        u uVarH = h();
        String strB = uVarH != null ? uVarH.b() : null;
        LocalLogger.log(16, 22310L, strB + " with expiry " + j + timeUnit.name());
        this.i.a();
        a((u) null);
        b(uVar, j, timeUnit);
        u uVarH2 = h();
        LocalLogger.log(16, 22317L, uVarH2 != null ? uVarH2.b() : null);
    }

    public final void a(String hashHeaderValue, String fcDataHeaderValue) {
        String str = g0.f510a;
        g0.c = Long.valueOf(System.currentTimeMillis());
        if (hashHeaderValue == null || hashHeaderValue.length() == 0) {
            return;
        }
        Context context = this.f523a;
        if (fcDataHeaderValue == null) {
            fcDataHeaderValue = "";
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hashHeaderValue, "hashHeaderValue");
        Intrinsics.checkNotNullParameter(fcDataHeaderValue, "fcDataHeaderValue");
        CoroutineDispatcher coroutineDispatcher = k0.f529a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hashHeaderValue, "hashHeaderValue");
        Intrinsics.checkNotNullParameter(fcDataHeaderValue, "fcDataHeaderValue");
        if (hashHeaderValue.length() == 0 || fcDataHeaderValue.length() == 0 || hashHeaderValue.length() < 2) {
            return;
        }
        String strSubstring = hashHeaderValue.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if (!Intrinsics.areEqual(strSubstring, "01") || Intrinsics.areEqual(hashHeaderValue, g0.f510a)) {
            return;
        }
        Intrinsics.checkNotNullParameter(hashHeaderValue, "<set-?>");
        g0.f510a = hashHeaderValue;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(k0.f529a), null, null, new j0(hashHeaderValue, fcDataHeaderValue, context, null), 3, null);
    }
}
