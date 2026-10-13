package com.useinsider.insider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.URLUtil;
import androidx.compose.ui.autofill.AutofillUtils_androidKt;
import androidx.core.util.Supplier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.android.billingclient.api.BillingClient;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import expo.modules.notifications.serverregistration.InstallationId;
import expo.modules.notifications.service.NotificationsService;
import io.ktor.sse.ServerSentEventKt;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class l0 implements LifecycleObserver {
    static final ArrayList B = new ArrayList();
    static Intent C;
    private final w2 A;
    private Context c;
    private volatile Activity d;
    private com.useinsider.insider.s f;
    private volatile g3 g;
    private final Handler h;
    private final ScheduledExecutorService i;
    private final ExecutorService j;
    private m4 k;
    private boolean l;
    private boolean m;
    private boolean n;
    private n3 o;
    private InsiderUser p;
    private d5 q;
    boolean r;
    private volatile long s;
    private volatile Boolean t;
    private volatile int u;
    private volatile z v;
    private final Semaphore w;
    private final AtomicInteger x;
    private boolean y;
    private final LifecycleEventObserver z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f351a = false;
    private ArrayList b = new ArrayList();
    private volatile boolean e = false;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements com.useinsider.insider.q {
        a() {
        }

        @Override // com.useinsider.insider.q
        public void a() {
            g4.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class b implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f353a;

        b(Map map) {
            this.f353a = map;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            g4.a(this.f353a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class c implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f354a;
        final /* synthetic */ Map b;

        c(String[] strArr, Map map) {
            this.f354a = strArr;
            this.b = map;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            g4.a(this.f354a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class d implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsiderProduct f355a;
        final /* synthetic */ Map b;

        d(InsiderProduct insiderProduct, Map map) {
            this.f355a = insiderProduct;
            this.b = map;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            g4.a(this.f355a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class e implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsiderProduct[] f356a;
        final /* synthetic */ Map b;

        e(InsiderProduct[] insiderProductArr, Map map) {
            this.f356a = insiderProductArr;
            this.b = map;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            g4.a(this.f356a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class f implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsiderProduct[] f357a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;

        f(InsiderProduct[] insiderProductArr, String str, Map map) {
            this.f357a = insiderProductArr;
            this.b = str;
            this.c = map;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            g4.a(this.f357a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class g implements LifecycleEventObserver {
        g() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            try {
                if (event == Lifecycle.Event.ON_START) {
                    z zVar = l0.this.v;
                    z zVar2 = z.SessionStarted;
                    if (zVar != zVar2) {
                        l0.this.S();
                    }
                    l0.this.v = zVar2;
                    return;
                }
                if (event == Lifecycle.Event.ON_STOP && com.useinsider.insider.e.w) {
                    f3.b("lifecycle", "App went to background.", "{}", "InsiderCore-onStateChanged");
                    ArrayList arrayList = l0.this.b;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        if (((InsiderEvent) obj).getName().equals("confirmation_page_view")) {
                            f3.b("lifecycle", "Session was stopped while having pending confirmation page view event.", "{}", "InsiderCore-onStateChanged");
                        }
                    }
                    z zVar3 = l0.this.v;
                    z zVar4 = z.SessionStopped;
                    if (zVar3 != zVar4) {
                        l0.this.k();
                    }
                    l0.this.v = zVar4;
                }
            } catch (Exception e) {
                l0.this.a(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class h implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsiderProduct[] f359a;
        final /* synthetic */ Map b;

        h(InsiderProduct[] insiderProductArr, Map map) {
            this.f359a = insiderProductArr;
            this.b = map;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            g4.b(this.f359a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class i implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f360a;
        final /* synthetic */ InsiderIdentifiers b;
        final /* synthetic */ InsiderUser.InsiderIDResult c;

        /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
        class a implements x4 {

            /* JADX INFO: renamed from: com.useinsider.insider.l0$i$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
            class C0154a implements v4 {
                C0154a() {
                }

                @Override // com.useinsider.insider.v4
                public void a() {
                }

                @Override // com.useinsider.insider.v4
                public void b() {
                    i iVar = i.this;
                    InsiderUser.InsiderIDResult insiderIDResult = iVar.c;
                    if (insiderIDResult != null) {
                        insiderIDResult.insiderIDResult(iVar.f360a);
                    }
                }

                @Override // com.useinsider.insider.v4
                public void c() {
                }
            }

            a() {
            }

            @Override // com.useinsider.insider.x4
            public void a() {
            }

            @Override // com.useinsider.insider.x4
            public void b() {
                l0.this.h();
                i iVar = i.this;
                l0.this.a(iVar.f360a, iVar.b);
                l0.this.b(o4.SESSION_START_REQUEST_REASON_INSIDER_ID_CHANGE, new C0154a());
            }

            @Override // com.useinsider.insider.x4
            public void c() {
            }

            @Override // com.useinsider.insider.x4
            public void d() {
            }
        }

        i(String str, InsiderIdentifiers insiderIdentifiers, InsiderUser.InsiderIDResult insiderIDResult) {
            this.f360a = str;
            this.b = insiderIdentifiers;
            this.c = insiderIDResult;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            l0.this.b(p4.SESSION_STOP_REQUEST_REASON_INSIDER_ID_CHANGE, new a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class j implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsiderUser.InsiderIDResult f363a;
        final /* synthetic */ String b;

        /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
        class a implements v4 {
            a() {
            }

            @Override // com.useinsider.insider.v4
            public void a() {
            }

            @Override // com.useinsider.insider.v4
            public void b() {
                j jVar = j.this;
                InsiderUser.InsiderIDResult insiderIDResult = jVar.f363a;
                if (insiderIDResult != null) {
                    insiderIDResult.insiderIDResult(jVar.b);
                }
            }

            @Override // com.useinsider.insider.v4
            public void c() {
            }
        }

        j(InsiderUser.InsiderIDResult insiderIDResult, String str) {
            this.f363a = insiderIDResult;
            this.b = str;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            l0.this.b(o4.SESSION_START_REQUEST_REASON_INSIDER_ID_CHANGE, new a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class k implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f365a;
        final /* synthetic */ InsiderUser.InsiderIDResult b;

        /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
        class a implements x4 {
            a() {
            }

            @Override // com.useinsider.insider.x4
            public void a() {
                l0.this.g.b((ArrayList) null);
            }

            @Override // com.useinsider.insider.x4
            public void b() {
                l0.this.h();
                l0.this.g.b((ArrayList) null);
                l0.this.p.setInsiderID(k.this.f365a);
                l0.this.c(o4.SESSION_START_REQUEST_REASON_LOGOUT);
                k kVar = k.this;
                InsiderUser.InsiderIDResult insiderIDResult = kVar.b;
                if (insiderIDResult != null) {
                    insiderIDResult.insiderIDResult(kVar.f365a);
                }
                f3.b("auth", "Logout and reset Insider ID completed.", "{ 'new_insider_id': '" + k.this.f365a + "' }", "InsiderCore-startSeparationProcess");
            }

            @Override // com.useinsider.insider.x4
            public void c() {
                l0.this.g.b((ArrayList) null);
            }

            @Override // com.useinsider.insider.x4
            public void d() {
                l0.this.g.b((ArrayList) null);
            }
        }

        k(String str, InsiderUser.InsiderIDResult insiderIDResult) {
            this.f365a = str;
            this.b = insiderIDResult;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            boolean zY = l0.this.y();
            l0 l0Var = l0.this;
            if (zY) {
                l0Var.b(p4.SESSION_STOP_REQUEST_REASON_LOGOUT, new a());
                return;
            }
            l0Var.h();
            l0.this.g.b((ArrayList) null);
            l0.this.p.setInsiderID(this.f365a);
            l0.this.c(o4.SESSION_START_REQUEST_REASON_LOGOUT);
            InsiderUser.InsiderIDResult insiderIDResult = this.b;
            if (insiderIDResult != null) {
                insiderIDResult.insiderIDResult(this.f365a);
            }
            f3.b("auth", "Logout and reset Insider ID completed. GDPR false, session stop skipped.", "{ 'new_insider_id': '" + this.f365a + "' }", "InsiderCore-startSeparationProcess");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class l implements com.useinsider.insider.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsiderUser.InsiderIDResult f367a;

        l(InsiderUser.InsiderIDResult insiderIDResult) {
            this.f367a = insiderIDResult;
        }

        @Override // com.useinsider.insider.n
        public void a(String str) {
            if (str == null || str.length() <= 0) {
                l0.this.r().edit().putBoolean(com.useinsider.insider.f.o, true).apply();
                return;
            }
            InsiderUser.InsiderIDResult insiderIDResult = this.f367a;
            if (insiderIDResult != null) {
                insiderIDResult.insiderIDResult(str);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.useinsider.insider.o f368a;
        final /* synthetic */ InsiderEvent b;

        m(com.useinsider.insider.o oVar, InsiderEvent insiderEvent) {
            this.f368a = oVar;
            this.b = insiderEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.d(this.f368a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.useinsider.insider.q f369a;

        n(com.useinsider.insider.q qVar) {
            this.f369a = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (l0.this.d == null) {
                    com.useinsider.insider.q qVar = this.f369a;
                    if (qVar != null) {
                        qVar.a();
                        return;
                    }
                    return;
                }
                if (l0.this.f.c(l0.this.d.getClass().getSimpleName())) {
                    l0.this.a(true, this.f369a);
                    return;
                }
                com.useinsider.insider.q qVar2 = this.f369a;
                if (qVar2 != null) {
                    qVar2.a();
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class o implements com.useinsider.insider.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f370a;

        /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
        class a implements x4 {
            a() {
            }

            @Override // com.useinsider.insider.x4
            public void a() {
            }

            @Override // com.useinsider.insider.x4
            public void b() {
                Debugger.putLog(DebuggingTag.reinitSessionStopCompleted, 4, o.this.f370a);
                l0.this.h();
                com.useinsider.insider.e.z = true;
                o oVar = o.this;
                com.useinsider.insider.e.b = oVar.f370a;
                l0.this.H();
                l0.this.a(o4.SESSION_START_REQUEST_REASON_PARTNER_NAME_CHANGE);
                o oVar2 = o.this;
                l0.this.e(oVar2.f370a);
            }

            @Override // com.useinsider.insider.x4
            public void c() {
            }

            @Override // com.useinsider.insider.x4
            public void d() {
            }
        }

        o(String str) {
            this.f370a = str;
        }

        @Override // com.useinsider.insider.q
        public void a() {
            l0.this.b(p4.SESSION_STOP_REQUEST_REASON_PARTNER_NAME_CHANGE, new a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static /* synthetic */ class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f372a;

        static {
            int[] iArr = new int[n4.values().length];
            f372a = iArr;
            try {
                iArr[n4.GOOGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class q implements com.useinsider.insider.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f373a;
        final /* synthetic */ com.useinsider.insider.n b;

        q(JSONObject jSONObject, com.useinsider.insider.n nVar) {
            this.f373a = jSONObject;
            this.b = nVar;
        }

        @Override // com.useinsider.insider.n
        public void a(String str) {
            if (str != null && !str.isEmpty()) {
                l0.this.r().edit().remove(com.useinsider.insider.f.o).apply();
                l0.this.p.setInsiderID(str);
                l0.this.p.setIdentifiersForStopPayload(l0.this.a(this.f373a));
                l0.this.p.setIdentifiersAsAttributes(w4.a(this.f373a));
            }
            if (!w4.h(str)) {
                f3.b("common", "Received corrupted insider_id from ucd.", "{}", "InsiderCore-refreshIdentity");
            }
            Debugger.putLog(DebuggingTag.refreshIdentity, 4, "Insider ID: " + str);
            this.b.a(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class r implements com.useinsider.insider.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o4 f374a;

        r(o4 o4Var) {
            this.f374a = o4Var;
        }

        @Override // com.useinsider.insider.n
        public void a(String str) {
            l0.this.c(this.f374a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class s implements com.useinsider.insider.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o4 f375a;

        s(o4 o4Var) {
            this.f375a = o4Var;
        }

        @Override // com.useinsider.insider.n
        public void a(String str) {
            l0.this.c(this.f375a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class t implements com.useinsider.insider.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f376a;
        final /* synthetic */ com.useinsider.insider.n b;

        t(JSONObject jSONObject, com.useinsider.insider.n nVar) {
            this.f376a = jSONObject;
            this.b = nVar;
        }

        @Override // com.useinsider.insider.n
        public void a(String str) {
            if (str != null && !str.isEmpty()) {
                l0.this.r().edit().remove(com.useinsider.insider.f.o).apply();
                l0.this.p.setInsiderID(str);
                l0.this.p.setIdentifiersForStopPayload(l0.this.a(this.f376a));
                l0.this.p.setIdentifiersAsAttributes(w4.a(this.f376a));
            }
            this.b.a(str);
            Debugger.putLog(DebuggingTag.refreshIdentity, 4, "New Insider ID: " + str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class u implements com.useinsider.insider.n {
        u() {
        }

        @Override // com.useinsider.insider.n
        public void a(String str) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class v implements x4 {
        v() {
        }

        @Override // com.useinsider.insider.x4
        public void a() {
        }

        @Override // com.useinsider.insider.x4
        public void b() {
            l0.this.j();
        }

        @Override // com.useinsider.insider.x4
        public void c() {
        }

        @Override // com.useinsider.insider.x4
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class w implements x4 {
        w() {
        }

        @Override // com.useinsider.insider.x4
        public void a() {
            l0.this.g.c();
            Debugger.a(DebuggingTag.flushingSuccessfully, 4);
        }

        @Override // com.useinsider.insider.x4
        public void b() {
        }

        @Override // com.useinsider.insider.x4
        public void c() {
            l0.this.g.l();
            Debugger.a(DebuggingTag.flushingFailed, 4);
        }

        @Override // com.useinsider.insider.x4
        public void d() {
            l0.this.g.c();
            Debugger.a(DebuggingTag.flushingFailedAndAddedToSharedPref, 4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class x implements x4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x4 f380a;

        x(x4 x4Var) {
            this.f380a = x4Var;
        }

        @Override // com.useinsider.insider.x4
        public void a() {
        }

        @Override // com.useinsider.insider.x4
        public void b() {
            try {
                x4 x4Var = this.f380a;
                if (x4Var != null) {
                    x4Var.b();
                }
            } catch (Exception e) {
                l0.this.a(e);
            } finally {
                l0.this.w.release();
            }
        }

        @Override // com.useinsider.insider.x4
        public void c() {
        }

        @Override // com.useinsider.insider.x4
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    private class y implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.useinsider.insider.o f381a;
        private final InsiderEvent b;

        y(com.useinsider.insider.o oVar, InsiderEvent insiderEvent) {
            this.f381a = oVar;
            this.b = insiderEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (l0.this.f.b(this.f381a, l0.this.p())) {
                    f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.FREQUENCY_IS_CAPPED.b(), new JSONObject().put("inapp_id", this.f381a.q()).put("variant_id", this.f381a.u()).put("activity_name", l0.this.d.getClass().getSimpleName()), "InsiderCore-Runnable");
                } else {
                    l0.this.d(this.f381a, this.b);
                }
            } catch (Exception e) {
                l0.this.a(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    private enum z {
        Default,
        SessionStarted,
        SessionStopped
    }

    l0(Context context) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.h = handler;
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.i = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        this.j = Executors.newCachedThreadPool();
        this.l = true;
        this.m = true;
        this.n = false;
        this.r = false;
        this.u = 0;
        this.v = z.Default;
        this.w = new Semaphore(1);
        this.x = new AtomicInteger(0);
        this.y = false;
        this.z = new g();
        this.A = new w2() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda13
            @Override // com.useinsider.insider.w2
            public final void a(o oVar) {
                this.f$0.a(oVar);
            }
        };
        try {
            this.c = context;
            this.k = new m4(context);
            this.q = new d5(context);
            this.f = new com.useinsider.insider.s();
            InsiderUser insiderUser = new InsiderUser(context);
            this.p = insiderUser;
            this.g = new g3(context, insiderUser);
            new a5(this.g, this.p, context);
            this.o = new n3();
            P();
            scheduledExecutorServiceNewSingleThreadScheduledExecutor.execute(new Runnable() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.x();
                }
            });
            O();
            handler.post(new Runnable() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.A();
                }
            });
        } catch (Exception e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        ProcessLifecycleOwner.get().getLifecycleRegistry().addObserver(this.z);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ h2 B() {
        return new h2(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        y3 y3VarJ;
        try {
            this.p.fillDeviceAttributes(this.q);
            if (!this.y) {
                R();
            }
            this.g.a(SystemClock.elapsedRealtime());
            com.useinsider.insider.e.i = w4.n(this.c);
            com.useinsider.insider.e.v = false;
            this.u = 0;
            if (!this.e && y()) {
                HashMap mapA = w4.a(new JSONObject(r().getString(com.useinsider.insider.f.p, "{}")));
                if (!mapA.isEmpty() && !Q()) {
                    this.p.setSavedIdentifiersForStopPayload(mapA);
                }
                w4.b(this.c);
                if (!this.y && (y3VarJ = m0.f().j()) != null) {
                    y3VarJ.a(o().getDeviceAttributes());
                }
            }
            f3.b("lifecycle", "startSDKSession", "{}", "InsiderCore-startSDKSession");
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void E() {
        try {
            r().edit().remove("insider_id").apply();
            this.p.setInsiderID(w4.k(this.c));
            Debugger.a(DebuggingTag.removeCachedInsiderID, 4);
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void G() {
        try {
            r().edit().remove(r4.STORED_LATEST_CLICKED_PUSH_INTENT.b()).apply();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void L() {
        try {
            String string = r().getString("saved_gdpr_consent", "");
            r().edit().remove("saved_gdpr_consent").apply();
            JSONObject jSONObjectO = w4.o(string);
            if (jSONObjectO == null) {
                return;
            }
            this.k.a(jSONObjectO);
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void M() {
        try {
            String string = r().getString("saved_mobile_gdpr_consent", "");
            r().edit().remove("saved_mobile_gdpr_consent").apply();
            JSONObject jSONObjectO = w4.o(string);
            if (jSONObjectO == null) {
                return;
            }
            this.k.a(jSONObjectO);
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void N() {
        try {
            com.useinsider.insider.e.r = false;
            com.useinsider.insider.e.s = false;
            com.useinsider.insider.e.t = false;
            com.useinsider.insider.e.u = null;
            com.useinsider.insider.e.w = false;
            com.useinsider.insider.e.y = false;
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void O() {
        try {
            Intent intent = C;
            if (intent != null) {
                a(intent);
                C = null;
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void P() {
        final m0 m0VarF = m0.f();
        Supplier supplier = new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda20
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return new r0();
            }
        };
        m0.b bVar = m0.b.SINGLETON;
        m0VarF.a(supplier, q0.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda25
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return new a0();
            }
        }, com.useinsider.insider.z.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda26
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return new p3();
            }
        }, o3.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda27
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return l0.a(m0VarF);
            }
        }, l3.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return l0.c(m0VarF);
            }
        }, t1.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return l0.d(m0VarF);
            }
        }, t3.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return l0.e(m0VarF);
            }
        }, i0.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda4
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return l0.f(m0VarF);
            }
        }, e0.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda5
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return l0.g(m0VarF);
            }
        }, x2.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda6
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return l0.h(m0VarF);
            }
        }, v2.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda21
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return this.f$0.i(m0VarF);
            }
        }, com.useinsider.insider.h.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda22
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return new o0();
            }
        }, v3.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda23
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return this.f$0.B();
            }
        }, h2.class, bVar);
        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda24
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return l0.b(m0VarF);
            }
        }, InsiderAppCards.class, bVar);
        m0VarF.h().a(this.A);
        this.f.a(m0VarF.l());
        this.f.a(m0VarF.k());
        m0VarF.c();
    }

    private void R() {
        try {
            if (!Q() && w4.h(this.p.getInsiderID())) {
                c(o4.SESSION_START_REQUEST_REASON_SESSION_START);
                return;
            }
            b(o4.SESSION_START_REQUEST_REASON_SESSION_START);
        } catch (Exception e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        try {
            this.i.execute(new Runnable() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.C();
                }
            });
        } catch (Exception e2) {
            a(e2);
        }
    }

    static void W() {
        while (true) {
            ArrayList arrayList = B;
            if (arrayList.isEmpty()) {
                return;
            } else {
                Insider.Instance.tagEvent((String) arrayList.remove(0)).build();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int c(int i2) {
        if (i2 > 0) {
            return i2 - 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences p() {
        return h4.a().e(this.c, "InsiderCache");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences r() {
        return h4.a().e(this.c, "Insider");
    }

    private void s() {
        try {
            if (this.d != null && w4.p(this.c)) {
                if (p.f372a[w4.e(this.d).ordinal()] != 1) {
                    Debugger.a(DebuggingTag.noActiveServiceProvider, 5);
                } else {
                    FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda12
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public final void onComplete(Task task) {
                            this.f$0.a(task);
                        }
                    });
                }
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void u() {
        try {
            JSONObject jSONObject = new JSONObject();
            InsiderCallbackType insiderCallbackType = InsiderCallbackType.SESSION_STARTED;
            jSONObject.put("type", insiderCallbackType.ordinal());
            Insider.Instance.performInsiderCallback(jSONObject, insiderCallbackType);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private synchronized void v() {
        try {
            if (this.d == null) {
                return;
            }
            if (!c(this.d) && !com.useinsider.insider.e.r) {
                h(com.useinsider.insider.f.d).build();
                return;
            }
            B.add(com.useinsider.insider.f.d);
        } catch (Exception e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.useinsider.insider.e.h = r().getBoolean("debug_mode", false);
        e(com.useinsider.insider.e.b);
    }

    void D() {
        if (this.e) {
            return;
        }
        try {
            if (this.d != null) {
                this.f.a(this.d.getClass().getSimpleName(), 9);
                Debugger.a(DebuggingTag.disableBlockedInapp, 4);
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    void F() {
        if (this.e) {
            return;
        }
        try {
            if (this.d == null) {
                return;
            }
            this.f.b(this.d.getClass().getSimpleName());
            Debugger.a(DebuggingTag.removeInappSilently, 4);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void H() {
        try {
            this.g.o();
            E();
            InsiderGeofence.removeGeofences();
            y3 y3VarJ = m0.f().j();
            if (y3VarJ != null) {
                y3VarJ.d();
            }
            r().edit().remove(com.useinsider.insider.f.o).remove(com.useinsider.insider.f.n).remove(com.useinsider.insider.f.t).apply();
            p().edit().remove(com.useinsider.insider.f.r).apply();
            this.f.a();
        } catch (Exception e2) {
            a(e2);
        }
    }

    void I() {
        try {
            this.p.fillDeviceAttributes(this.q);
            R();
            this.y = true;
            if (this.e || !y()) {
                return;
            }
            if (!this.r) {
                s();
            }
            com.useinsider.insider.e.i = w4.n(this.c);
            if (com.useinsider.insider.e.j && com.useinsider.insider.e.i) {
                Debugger.a(DebuggingTag.startTrackingGeofence, 4);
            }
            y3 y3VarJ = m0.f().j();
            if (y3VarJ != null) {
                y3VarJ.a(o().getDeviceAttributes());
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    void J() {
        try {
            this.k.a(this.g.a("gdpr_consent", this.l, this.p.getUDID(), this.p.getInsiderID()));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void K() {
        try {
            this.k.a(this.g.a("mobile_gdpr_consent", this.m, this.p.getUDID(), this.p.getInsiderID()));
        } catch (Exception e2) {
            a(e2);
        }
    }

    boolean Q() {
        try {
            return r().contains(com.useinsider.insider.f.o);
        } catch (Exception e2) {
            a(e2);
            return false;
        }
    }

    void T() {
        try {
            if (this.g != null) {
                if (this.d != null) {
                    this.f.a(this.d.getClass().getSimpleName(), (com.useinsider.insider.q) null);
                }
                b(p4.SESSION_STOP_REQUEST_REASON_SESSION_STOP, new v());
                this.d = null;
                this.h.removeCallbacksAndMessages(null);
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    void U() {
        try {
            if (this.e || !y()) {
                return;
            }
            V();
            this.p.fillDeviceAttributes(this.q);
            this.g.a(this.f.b());
            r().edit().putString(r4.STORED_LATEST_SESSION_DATA.b(), this.g.a(this.p.getInsiderID(), p4.SESSION_STOP_REQUEST_REASON_SESSION_STOP).toString()).apply();
            Debugger.a(DebuggingTag.sessionDataStored, 4);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void V() {
        try {
            if (this.f351a) {
                return;
            }
            this.f351a = true;
            v();
            c();
            this.f351a = false;
        } catch (Exception e2) {
            a(e2);
        }
    }

    void X() {
        try {
            b(new a());
        } catch (Exception e2) {
            a(e2);
        }
    }

    Activity n() {
        return this.d;
    }

    InsiderUser o() {
        return this.p;
    }

    String q() {
        try {
            return this.p.getInsiderID();
        } catch (Exception e2) {
            a(e2);
            return null;
        }
    }

    String t() {
        try {
            return p().getString("insider_recommendation_endpoints", "");
        } catch (Exception e2) {
            a(e2);
            return "";
        }
    }

    void w() {
        try {
            if (d()) {
                InsiderGeofence.initialize(this.c, this.d);
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    boolean y() {
        if (!this.n) {
            this.n = true;
            this.l = e();
            this.m = f();
        }
        return this.l && this.m;
    }

    boolean z() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InsiderAppCards b(m0 m0Var) {
        return new InsiderAppCards(m0Var.g(), com.useinsider.insider.e.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t3 d(m0 m0Var) {
        return new d0(new u3(), m0Var.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i0 e(m0 m0Var) {
        return new j0(m0Var.d(), m0Var.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e0 f(m0 m0Var) {
        return new g0(m0Var.d(), m0Var.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x2 g(m0 m0Var) {
        return new y2(m0Var.l(), m0Var.d(), m0Var.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v2 h(m0 m0Var) {
        return new v2(m0Var.l(), m0Var.k(), m0Var.d(), m0Var.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.useinsider.insider.h i(m0 m0Var) {
        return new com.useinsider.insider.h(this.g, this.c, m0Var.l(), m0Var.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        w4.a(this.c);
        SessionPayloadJobService.a(this.c);
        Debugger.a(DebuggingTag.sessionDataCleared, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            this.y = false;
            this.r = false;
            N();
            G();
            if (this.e || !y()) {
                this.g.d();
                c5.b();
                this.f351a = false;
                if (this.e) {
                    InsiderGeofence.removeGeofences();
                }
                if (com.useinsider.insider.e.j && com.useinsider.insider.e.i && !InsiderGeofence.isGeofenceStarted() && !this.e) {
                    w();
                }
            } else {
                this.t = Boolean.TRUE;
                T();
                this.f351a = false;
            }
            this.f.a();
            m0.f().l().f();
            f3.b("lifecycle", "endSDKSession", "{}", "InsiderCore-endSDKSession");
            if (!this.e) {
                f3.a(this.c);
            }
        } catch (Exception e2) {
            a(e2);
        } finally {
            f3.c();
        }
    }

    private void l() {
        try {
            this.p.fillDeviceAttributes(this.q);
            if (!com.useinsider.insider.e.r || com.useinsider.insider.e.u == null) {
                g();
            }
            this.g.m();
            this.g.a(this.f.b());
            f3.d();
            JSONObject jSONObjectA = this.g.a(this.p.getInsiderID(), p4.SESSION_STOP_REQUEST_REASON_FLUSH);
            jSONObjectA.put("flush_id", f3.b());
            if (!this.g.a(jSONObjectA)) {
                Debugger.b(DebuggingTag.flushingRequestNotSent, 4, jSONObjectA);
                return;
            }
            long j2 = jSONObjectA.getLong("timestamp");
            if (j2 == this.s) {
                f3.a("error", "Multiple sent stop payload.", "{ 'is_stop_life_cycle': '" + this.t + "', 'stop_payload_running_count': '" + this.u + "', 'timestamp': '" + this.s + "' }", "InsiderCore-flushData");
            } else {
                Debugger.b(DebuggingTag.flushingData, 4, jSONObjectA);
                this.g.h();
                this.g.e();
                this.k.a(jSONObjectA, new w());
            }
            this.s = j2;
        } catch (Exception e2) {
            a(e2);
        }
    }

    private Intent m() {
        try {
            String string = r().getString(r4.STORED_LATEST_CLICKED_PUSH_INTENT.b(), "");
            G();
            if (string.isEmpty()) {
                return null;
            }
            return Intent.parseUri(string, 1);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t1 c(m0 m0Var) {
        return new u1(m0Var.l());
    }

    private boolean f() {
        boolean z2 = r().contains("mobile_gdpr_consent") ? r().getBoolean("mobile_gdpr_consent", true) : true;
        if (r().contains("saved_mobile_gdpr_consent")) {
            M();
        }
        f3.b("common", "checkMobileAppAccess", "{ 'mobile_gdpr_status': '" + String.valueOf(z2) + "'}", "InsiderCore-checkMobileAppAccess");
        Debugger.a(DebuggingTag.checkMobileAppAccess, 4, Boolean.valueOf(z2));
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        this.b.clear();
        B.clear();
        this.g.d();
    }

    void d(Activity activity) {
        try {
            a(activity);
            g(activity);
        } catch (Exception e2) {
            a(e2);
        }
    }

    synchronized void e(Activity activity) {
        try {
            boolean z2 = this.d == null;
            this.d = activity;
            if (z2) {
                s();
            }
            f3.b("common", "Current activity is updated.", "{ 'activity_name': '" + activity.getClass().getSimpleName() + "' }", "InsiderCore-setCurrentActivity");
        } catch (Exception e2) {
            a(e2);
        }
    }

    void g(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            String simpleName = activity.getClass().getSimpleName();
            if (!a(simpleName).booleanValue()) {
                com.useinsider.insider.e.w = true;
                if (!this.e && y()) {
                    e(activity);
                    this.f.a(this.d);
                }
            }
            f3.b("common", "Activity started; active activity count incremented.", new JSONObject().put("active_activity_count", this.x.incrementAndGet()).put("activity_name", simpleName), "InsiderCore-tickStart");
        } catch (Exception e2) {
            a(e2);
        }
    }

    void i() {
        try {
            p().edit().remove("insider_recommendation_endpoints").apply();
        } catch (Exception e2) {
            a(e2);
        }
    }

    static boolean c(Activity activity) {
        try {
            return com.useinsider.insider.e.c != null && activity.getClass().equals(com.useinsider.insider.e.c);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    void b(o4 o4Var) {
        try {
            a(new r(o4Var));
        } catch (Exception e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l3 a(m0 m0Var) {
        return new l3(m0Var.b());
    }

    InsiderAppCards a() {
        try {
            return m0.f().a();
        } catch (Exception e2) {
            a(e2);
            return new InsiderAppCards();
        }
    }

    void h(boolean z2) {
        try {
            boolean zY = y();
            if (z2) {
                s();
            }
            this.m = z2;
            r().edit().putBoolean("mobile_gdpr_consent", z2).apply();
            Debugger.a(DebuggingTag.setMobileAppAccess, 4, Boolean.valueOf(z2));
            f3.b("common", "setMobileAppAccess", "{ 'mobile_gdpr_status': '" + String.valueOf(z2) + "'}", "InsiderCore-setMobileAppAccess");
            e(zY);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void i(boolean z2) {
        try {
            p().edit().putBoolean("push_enabled", z2).apply();
        } catch (Exception e2) {
            a(e2);
        }
    }

    void c(o4 o4Var) {
        b(o4Var, (v4) null);
    }

    void d(boolean z2) {
        try {
            com.useinsider.insider.e.l = z2;
            Debugger.a(DebuggingTag.enableLocationCollection, 4, Boolean.valueOf(z2));
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void c(String str) {
        r().edit().remove(com.useinsider.insider.f.o).apply();
        this.p.setInsiderID(str);
    }

    private synchronized void c() {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            a((InsiderEvent) obj);
        }
        this.b.clear();
    }

    InsiderIdentifiers a(JSONObject jSONObject) {
        try {
            InsiderIdentifiers insiderIdentifiers = new InsiderIdentifiers();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                int iHashCode = next.hashCode();
                if (iHashCode != 3240) {
                    if (iHashCode != 3582) {
                        if (iHashCode == 3601339 && next.equals(InstallationId.LEGACY_PREFERENCES_UUID_KEY)) {
                            insiderIdentifiers.addUserID(String.valueOf(jSONObject.get(next)));
                        } else {
                            insiderIdentifiers.addCustomIdentifier(next.replaceFirst("c_", ""), String.valueOf(jSONObject.get(next)));
                        }
                    } else if (next.equals("pn")) {
                        insiderIdentifiers.addPhoneNumber(String.valueOf(jSONObject.get(next)));
                    } else {
                        insiderIdentifiers.addCustomIdentifier(next.replaceFirst("c_", ""), String.valueOf(jSONObject.get(next)));
                    }
                } else if (next.equals("em")) {
                    insiderIdentifiers.addEmail(String.valueOf(jSONObject.get(next)));
                } else {
                    insiderIdentifiers.addCustomIdentifier(next.replaceFirst("c_", ""), String.valueOf(jSONObject.get(next)));
                }
            }
            return insiderIdentifiers;
        } catch (Exception e2) {
            a(e2);
            return new InsiderIdentifiers();
        }
    }

    void d(Map map) {
        try {
            b(new b(map));
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void b(com.useinsider.insider.n nVar) {
        try {
            String string = r().getString(com.useinsider.insider.f.p, "");
            if (string.isEmpty()) {
                nVar.a("");
            } else {
                JSONObject jSONObject = new JSONObject(string);
                this.k.a(this.p, jSONObject, new t(jSONObject, nVar));
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    void c(JSONObject jSONObject) {
        try {
            p().edit().putString("insider_recommendation_endpoints", String.valueOf(jSONObject)).apply();
        } catch (Exception e2) {
            a(e2);
        }
    }

    void c(boolean z2) {
        try {
            com.useinsider.insider.e.k = z2;
            Debugger.a(DebuggingTag.enableIpCollection, 4, Boolean.valueOf(z2));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void f(boolean z2) {
        try {
            boolean zY = y();
            if (z2) {
                s();
            }
            this.l = z2;
            r().edit().putBoolean("gdpr_consent", z2).apply();
            Debugger.a(DebuggingTag.setGDPRConsent, 4, Boolean.valueOf(z2));
            f3.b("common", InsiderHybridMethods.SET_GDPR_CONSENT, "{ 'gdpr_status': '" + String.valueOf(z2) + "'}", "InsiderCore-setGDPRConsent  ");
            e(zY);
        } catch (Exception e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.useinsider.insider.o oVar, InsiderEvent insiderEvent) {
        try {
            if (this.f != null && !this.d.getClass().equals(com.useinsider.insider.e.c)) {
                JSONObject jSONObjectPut = new JSONObject().put("event_name", insiderEvent.getName()).put("event_parameters", w4.g(insiderEvent.getParameters()));
                if (!com.useinsider.insider.e.z && !oVar.o()) {
                    this.g.a(oVar.q(), oVar.u());
                    f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.IN_APP_MESSAGES_DISABLED.b(), jSONObjectPut, "InsiderCore-showInapp");
                }
                this.f.a(oVar, insiderEvent, this.d);
                return;
            }
            if (!this.d.getClass().equals(com.useinsider.insider.e.c) && !this.d.getClass().getName().contains("Inapp")) {
                f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.CURRENT_ACTIVITY_NOT_SUITABLE.b(), new JSONObject().put("event_name", insiderEvent.getName()).put("event_parameters", w4.g(insiderEvent.getParameters())).put("activity_name", this.d.getClass().getSimpleName()), "InsiderCore-showInapp");
                return;
            }
            this.h.postDelayed(new m(oVar, insiderEvent), 1000L);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void c(InsiderProduct insiderProduct, Map map) {
        try {
            b(new d(insiderProduct, map));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void e(Map map) {
        try {
            g5.a(this.g, map);
        } catch (Exception e2) {
            a(e2);
        }
    }

    InsiderEvent h(String str) {
        return new InsiderEvent(str);
    }

    private boolean e() {
        boolean z2 = r().contains("gdpr_consent") ? r().getBoolean("gdpr_consent", true) : true;
        if (r().contains("saved_gdpr_consent")) {
            L();
        }
        f3.b("common", "checkGDPRConsent", "{ 'gdpr_status': '" + String.valueOf(z2) + "'}", "InsiderCore-checkGDPRConsent");
        Debugger.a(DebuggingTag.checkGDPRConsent, 4, Boolean.valueOf(z2));
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final com.useinsider.insider.o oVar, final InsiderEvent insiderEvent) {
        ((Executor) b5.b.a()).execute(new Runnable() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(oVar, insiderEvent);
            }
        });
    }

    private void g() {
        try {
            B.clear();
        } catch (Exception e2) {
            a(e2);
        }
    }

    void c(Typeface typeface) {
        try {
            com.useinsider.insider.e.n = typeface;
            Debugger.putLog(DebuggingTag.setCustomRegularFont, 4, String.valueOf(typeface));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void f(String str) {
        try {
            a(new o(str));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void g(String str) {
        try {
            h();
            com.useinsider.insider.e.z = true;
            com.useinsider.insider.e.b = str;
            H();
            e(str);
            b(o4.SESSION_START_REQUEST_REASON_PARTNER_NAME_CHANGE);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void c(Map map) {
        try {
            t4.a(map);
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void e(boolean z2) {
        try {
            boolean zY = y();
            if (z2 || !zY || m0.f().l().c()) {
                return;
            }
            m0.f().l().d(null);
            v();
            c();
        } catch (Exception e2) {
            a(e2);
        }
    }

    void b(Map map) {
        try {
            this.g.b(map);
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void b() {
        try {
            a(ProcessLifecycleOwner.get().getLifecycleRegistry().getState().isAtLeast(Lifecycle.State.STARTED));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void e(String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return;
                }
                r().edit().putString(com.useinsider.insider.f.n, str).apply();
            } catch (Exception e2) {
                a(e2);
            }
        }
    }

    void g(boolean z2) {
        try {
            p().edit().putBoolean("location_enabled", z2).apply();
        } catch (Exception e2) {
            a(e2);
        }
    }

    void b(final o4 o4Var, final v4 v4Var) {
        try {
            this.i.execute(new Runnable() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(o4Var, v4Var);
                }
            });
        } catch (Exception e2) {
            u();
            a(e2);
        }
    }

    private void a(com.useinsider.insider.n nVar) {
        try {
            String string = r().getString(com.useinsider.insider.f.p, "");
            if (string.isEmpty()) {
                string = "{}";
            }
            JSONObject jSONObject = new JSONObject(string);
            this.k.a(this.p, jSONObject, new q(jSONObject, nVar));
        } catch (Exception e2) {
            a(e2);
        }
    }

    private boolean d() {
        try {
            return w4.o(this.c) && !InsiderGeofence.isGeofenceStarted() && com.useinsider.insider.e.j && !this.e;
        } catch (Exception e2) {
            a(e2);
            return true;
        }
    }

    synchronized void f(Activity activity) {
        try {
            int iUpdateAndGet = this.x.updateAndGet(new IntUnaryOperator() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda9
                @Override // java.util.function.IntUnaryOperator
                public final int applyAsInt(int i2) {
                    return l0.c(i2);
                }
            });
            boolean z2 = iUpdateAndGet <= 0;
            f3.b("common", "Activity stopped; active activity count decremented.", new JSONObject().put("remaining_activity_count", iUpdateAndGet).put("activity_name", activity.getClass().getSimpleName()).put("is_last_activity_stopped", z2).put("is_sdk_frozen", this.e), "InsiderCore-storeSessionDataIfAppropriateAndStartPayloadWorker");
            if (!z2 || this.e) {
                return;
            }
            SessionPayloadJobService.b(activity.getApplicationContext());
            U();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void d(String str) {
        if (str == null) {
            return;
        }
        try {
            String strReplace = str.replace(ServerSentEventKt.SPACE, "");
            if (strReplace != "" && strReplace.length() >= 3) {
                Debugger.putLog(DebuggingTag.getPushToken, 4, str);
                if (str.equals("BLACKLISTED")) {
                    return;
                }
                this.p.setPushToken(str);
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(o4 o4Var) {
        try {
            b(new s(o4Var));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(Intent intent, String... strArr) {
        try {
            this.g.a(intent, strArr);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(boolean z2) {
        try {
            f3.b("common", "SDK initialized while app already foreground; calibrating active activity count.", new JSONObject().put("app_in_foreground", z2), "InsiderCore-calibrateActiveActivityCountForLateInit");
            if (z2) {
                this.x.compareAndSet(0, 1);
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(Activity activity) {
        if (activity != null) {
            try {
                String simpleName = activity.getClass().getSimpleName();
                if (this.e || !y() || a(simpleName).booleanValue() || c(activity)) {
                    return;
                }
                if (!this.f351a) {
                    f3.b("push", "Session start request in progress. Push intent will be processed after session response.", new JSONObject().put("start_request_called", this.y).put("start_request_completed", this.f351a), "InsiderCore-handleLatestPushIntentIfExists");
                } else {
                    b(activity);
                }
            } catch (Exception e2) {
                a(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final o4 o4Var, final v4 v4Var) {
        final JSONObject jSONObjectO;
        try {
            if (o4Var != o4.SESSION_START_REQUEST_REASON_FLUSH) {
                this.g.a(SystemClock.elapsedRealtime());
            }
            String strB = w3.SESSION_START.b();
            if (o4Var == o4.SESSION_START_REQUEST_REASON_PARTNER_NAME_CHANGE) {
                a(1);
            } else {
                w4.u(this.c);
            }
            JSONObject jSONObjectA = w4.a(this.c, o4Var, this.p);
            Debugger.b(DebuggingTag.sessionStartRequest, 4, jSONObjectA);
            jSONObjectO = w4.o(w4.a(strB, jSONObjectA, this.c, false, l4.START).a());
        } catch (Exception e2) {
            a(e2);
            jSONObjectO = null;
        }
        this.h.post(new Runnable() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(jSONObjectO, o4Var, v4Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(JSONObject jSONObject, o4 o4Var, v4 v4Var) {
        try {
            this.f351a = true;
            if (jSONObject == null) {
                Debugger.putLog(DebuggingTag.sessionStartResponseError, 6, String.valueOf(jSONObject));
                if (o4Var != o4.SESSION_START_REQUEST_REASON_FLUSH) {
                    m0.f().l().d(null);
                    v();
                    c();
                    c5.b(this.c);
                } else {
                    m0.f().l().c(null);
                    h(com.useinsider.insider.f.e).build();
                }
                f3.a();
                return;
            }
            Debugger.b(DebuggingTag.sessionStartResponse, 4, jSONObject);
            if (jSONObject.has("sdk_disabled")) {
                this.e = jSONObject.optBoolean("sdk_disabled");
            }
            boolean zY = y();
            boolean zB = b(jSONObject);
            if (o4Var == o4.SESSION_START_REQUEST_REASON_FLUSH) {
                m0.f().l().c(jSONObject);
                h(com.useinsider.insider.f.e).build();
                if (v4Var != null) {
                    v4Var.a();
                    v4Var.b();
                    return;
                }
                return;
            }
            if (zB && !this.e) {
                if (!zY) {
                    y3 y3VarJ = m0.f().j();
                    if (y3VarJ != null) {
                        y3VarJ.a(o().getDeviceAttributes());
                    }
                    HashMap mapA = w4.a(new JSONObject(r().getString(com.useinsider.insider.f.p, "{}")));
                    if (!mapA.isEmpty() && !Q()) {
                        this.p.setSavedIdentifiersForStopPayload(mapA);
                    }
                    w4.b(this.c);
                    if (!this.r) {
                        s();
                    }
                }
                if (jSONObject.has("smart_recommendations")) {
                    RecommendationEngine.c(jSONObject.getJSONObject("smart_recommendations"));
                    c(jSONObject.getJSONObject("smart_recommendations"));
                } else {
                    i();
                }
                if (jSONObject.has("reset_iid")) {
                    if (jSONObject.getBoolean("reset_iid")) {
                        E();
                        if (jSONObject.has("new_id") && jSONObject.getString("new_id").length() > 0) {
                            c(jSONObject.getString("new_id"));
                        }
                        a(new u());
                    } else if (jSONObject.has("new_id") && jSONObject.getString("new_id").length() > 0) {
                        c(jSONObject.getString("new_id"));
                    }
                }
                if (jSONObject.has("amplification") && jSONObject.optBoolean("amplification")) {
                    com.useinsider.insider.u uVar = new com.useinsider.insider.u();
                    if (jSONObject.getBoolean("amplification")) {
                        uVar.a(r(), true);
                        uVar.b(this.c);
                    } else {
                        uVar.a(r(), false);
                        uVar.a(this.c);
                    }
                }
                if (jSONObject.has("is_logging_enabled") && jSONObject.getBoolean("is_logging_enabled")) {
                    f3.f = Boolean.TRUE;
                }
                if (jSONObject.has("log_flush_time_interval") && jSONObject.getInt("log_flush_time_interval") > 0) {
                    f3.g = jSONObject.getInt("log_flush_time_interval");
                }
                if (jSONObject.has("session_id") && jSONObject.getString("session_id").length() > 0) {
                    String string = jSONObject.getString("session_id");
                    f3.c = string;
                    f3.a(string);
                }
                f3.a();
                if (jSONObject.has("data_flushing_time_interval")) {
                    c5.a(this.c, jSONObject.getInt("data_flushing_time_interval"));
                }
                c5.b(this.c);
                this.f.a(r());
                m0.f().l().d(jSONObject);
                v();
                c();
                if (this.d != null) {
                    a(this.d);
                }
                if (com.useinsider.insider.e.j && com.useinsider.insider.e.i) {
                    Debugger.a(DebuggingTag.startTrackingGeofence, 4);
                    w();
                }
                new f3(this.c);
                u();
                if (v4Var != null) {
                    v4Var.a();
                    v4Var.b();
                    return;
                }
                return;
            }
            Debugger.putLog(DebuggingTag.gdprBlockedSessionContinuation, 4, "{ gdpr: " + zB + ", sdk_disabled: " + this.e + " }");
            f3.b("common", "postStartRequest", "{ 'message': 'Session could not be continued due to GDPR consent rejection or SDK being disabled.', 'gdpr_status': '" + zB + "', 'sdk_disabled_status': '" + this.e + "' }", "InsiderCore-postStartRequest");
            if (this.e) {
                InsiderGeofence.removeGeofences();
                G();
            }
            if (v4Var != null) {
                v4Var.a();
                v4Var.b();
            }
        } catch (Exception e2) {
            if (o4Var != o4.SESSION_START_REQUEST_REASON_FLUSH) {
                m0.f().l().d(null);
            } else {
                m0.f().l().c(null);
            }
            u();
            a(e2);
            if (v4Var != null) {
                v4Var.c();
                v4Var.b();
            }
        }
    }

    void b(com.useinsider.insider.q qVar) {
        try {
            if (this.d != null) {
                String simpleName = this.d.getClass().getSimpleName();
                if (this.f.c(simpleName) && this.f.d(simpleName)) {
                    a(true, qVar);
                } else {
                    qVar.a();
                }
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    synchronized void b(p4 p4Var, x4 x4Var) {
        if (p4Var == p4.SESSION_STOP_REQUEST_REASON_FLUSH) {
            l();
        } else {
            a(p4Var, x4Var);
            if (p4Var == p4.SESSION_STOP_REQUEST_REASON_INSIDER_ID_CHANGE || p4Var == p4.SESSION_STOP_REQUEST_REASON_PARTNER_NAME_CHANGE || p4Var == p4.SESSION_STOP_REQUEST_REASON_LOGOUT) {
                f3.c();
            }
        }
        com.useinsider.insider.e.x = p4Var;
    }

    private boolean b(String str, String str2, String[] strArr, String str3, double d2, String str4) {
        return d2 >= 0.0d && str != null && str.length() > 0 && str2 != null && str2.length() > 0 && strArr != null && strArr.length > 0 && str4 != null && str4.length() > 0 && str3 != null && str3.length() > 0;
    }

    void b(InsiderProduct insiderProduct, Map map) {
        try {
            g5.a(this.g, insiderProduct, this.o, map);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void b(String str, Map map) {
        try {
            g5.a(this.g, str, map);
        } catch (Exception e2) {
            a(e2);
        }
    }

    boolean b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(BatchMetricsDispatcher.TRACKING_CONSENT_KEY)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(BatchMetricsDispatcher.TRACKING_CONSENT_KEY);
                    boolean zOptBoolean = jSONObject2.optBoolean("gdpr", false);
                    boolean zOptBoolean2 = jSONObject2.optBoolean("mobile_gdpr", false);
                    this.l = zOptBoolean;
                    this.m = zOptBoolean2;
                    r().edit().putBoolean("gdpr_consent", zOptBoolean).putBoolean("mobile_gdpr_consent", zOptBoolean2).apply();
                    Debugger.putLog(DebuggingTag.saveAndRetrieveGdprStatus, 4, "{ gdpr: " + zOptBoolean + ", mobile_gdpr: " + zOptBoolean2 + " }");
                    f3.b("common", "saveAndRetrieveGdprStatus", "{ 'gdpr': '" + zOptBoolean + "', 'mobile_gdpr': '" + zOptBoolean2 + "' }", "InsiderCore-saveAndRetrieveGdprStatus");
                    return zOptBoolean && zOptBoolean2;
                }
            } catch (Exception e2) {
                a(e2);
                return false;
            }
        }
        this.l = false;
        this.m = false;
        r().edit().putBoolean("gdpr_consent", false).putBoolean("mobile_gdpr_consent", false).apply();
        return false;
    }

    void b(boolean z2) {
        try {
            com.useinsider.insider.e.m = z2;
            Debugger.a(DebuggingTag.enableCarrierCollection, 4, Boolean.valueOf(z2));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void b(Activity activity) {
        try {
            com.useinsider.insider.e.s = true;
            if (!com.useinsider.insider.e.r) {
                W();
            }
            Intent intentM = m();
            if (intentM != null) {
                m0.f().k().a(intentM);
                i3.b(intentM, activity);
                f3.b("push", "Push is handled with InsiderNotificationIntentHandler.", new JSONObject(), "InsiderCore-handleSessionEventsAndPushData");
                return;
            }
            f3.b("push", "Push Intent is null.", new JSONObject(), "InsiderCore-handleSessionEventsAndPushData");
        } catch (Exception e2) {
            a(e2);
        }
    }

    void b(InsiderProduct[] insiderProductArr, Map map) {
        try {
            b(new h(insiderProductArr, map));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void b(final InsiderIdentifiers insiderIdentifiers, final InsiderUser.InsiderIDResult insiderIDResult) {
        this.i.execute(new Runnable() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(insiderIdentifiers, insiderIDResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.useinsider.insider.o oVar, InsiderEvent insiderEvent) {
        if (oVar.w()) {
            this.f.b(this.d.getClass().getSimpleName());
        }
        a(oVar, insiderEvent);
    }

    void b(Typeface typeface) {
        try {
            com.useinsider.insider.e.p = typeface;
            Debugger.putLog(DebuggingTag.setCustomItalicFont, 4, String.valueOf(typeface));
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void b(final String str, final int i2) {
        this.i.execute(new Runnable() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, i2);
            }
        });
    }

    private boolean b(String str) {
        try {
            for (String str2 : new URL(str).getQuery().split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    String str3 = strArrSplit[0];
                    String str4 = strArrSplit[1];
                    if (str3.equals("isIns") && str4.equals("1")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            a(e2);
            return false;
        }
    }

    void b(com.useinsider.insider.o oVar) {
        try {
            this.g.a(oVar);
        } catch (Exception e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i2) {
        try {
            if (h4.a().e(this.c, s4.INSIDER_QUEUE.b()).getAll().keySet().size() > 0) {
                HashMap map = new HashMap();
                map.put("step", Integer.valueOf(i2));
                Debugger.a(DebuggingTag.retriedQueuedRequests, 4, map);
                w4.u(this.c);
                a(i2 + 1);
                return;
            }
            Debugger.a(DebuggingTag.finishedRetriedRequests, 4);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void a(boolean z2, com.useinsider.insider.q qVar) {
        if (this.e) {
            return;
        }
        try {
            if (this.d == null || !z2) {
                return;
            }
            this.f.a(this.d.getClass().getSimpleName(), qVar);
            Debugger.a(DebuggingTag.removeInapp, 4);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(int i2, int i3) {
        if (this.e) {
            return;
        }
        try {
            this.g.a(i2, i3);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(Activity activity, com.useinsider.insider.q qVar) {
        try {
            if (!this.e && activity != null) {
                String simpleName = activity.getClass().getSimpleName();
                if (!a(simpleName).booleanValue()) {
                    f5.b(activity);
                    this.f.b(simpleName, qVar);
                } else {
                    qVar.a();
                }
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(p4 p4Var, x4 x4Var) {
        try {
            c5.b();
            if (!this.w.tryAcquire()) {
                f3.c("warn", "postStopData method is already running, exiting without waiting.", "{}", "InsiderCore-postStopData");
                return;
            }
            this.f351a = false;
            w4.a(this.c);
            this.p.fillDeviceAttributes(this.q);
            this.g.a(this.f.b());
            g();
            this.g.a(this.f.b());
            this.f.c();
            JSONObject jSONObjectA = this.g.a(this.p.getInsiderID(), p4Var);
            long j2 = jSONObjectA.getLong("timestamp");
            if (jSONObjectA.has("custom_events")) {
                jSONObjectA.put("custom_events", a(jSONObjectA.getJSONArray("custom_events")));
            }
            this.g.d();
            if (j2 == this.s) {
                f3.a("error", "Multiple sent stop payload.", "{ 'is_stop_life_cycle': '" + this.t + "', 'stop_payload_running_count': '" + this.u + "', 'timestamp': '" + this.s + "' }", "InsiderCore-postStopData");
            } else {
                Debugger.b(DebuggingTag.sessionStopRequest, 4, jSONObjectA);
                this.k.c(jSONObjectA, new x(x4Var));
            }
            this.s = j2;
            this.t = Boolean.FALSE;
        } catch (Exception e2) {
            a(e2);
        } finally {
            this.w.release();
        }
    }

    private JSONArray a(JSONArray jSONArray) {
        boolean z2;
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String strOptString = jSONObject.optString("event_name");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_params");
                if (w4.e(strOptString)) {
                    f3.a("error", "Event name is empty.", jSONObject, "InsiderCore-filterInvalidEventParams");
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!(jSONObjectOptJSONObject instanceof JSONObject)) {
                    f3.a("error", "Invalid parameters structure.", jSONObject, "InsiderCore-filterInvalidEventParams");
                    z2 = false;
                }
                if (z2) {
                    jSONArray2.put(jSONObject);
                }
            }
            return jSONArray2;
        } catch (Exception e2) {
            a(e2);
            return jSONArray;
        }
    }

    void a(int i2, String str, InsiderProduct insiderProduct, String str2, RecommendationEngine.SmartRecommendation smartRecommendation) {
        try {
            RecommendationEngine.a(this.c, i2, str, str2, insiderProduct, this.o, smartRecommendation);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(int i2, InsiderProduct insiderProduct) {
        try {
            this.o.a(i2, insiderProduct);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(Date date, Date date2, int i2, InsiderIdentifiers insiderIdentifiers, MessageCenterData messageCenterData) {
        if (this.e || this.g == null) {
            return;
        }
        try {
            JSONObject jSONObjectPut = new JSONObject().put(FirebaseAnalytics.Param.START_DATE, date).put(FirebaseAnalytics.Param.END_DATE, date2).put("limit", i2);
            f3.b("message_center", "Message center data requested.", jSONObjectPut, "InsiderCore-getMessageCenterData");
            if (!com.useinsider.insider.e.b.isEmpty() && date != null && date2 != null && !date.equals(date2) && !date2.before(date)) {
                JSONObject jSONObjectA = this.g.a(date.getTime() / 1000, date2.getTime() / 1000, i2, this.p.getUDID(), this.p.getInsiderID(), insiderIdentifiers);
                Debugger.b(DebuggingTag.getMessageCenterData, 4, jSONObjectA);
                this.k.a(jSONObjectA, messageCenterData);
                return;
            }
            f3.a("message_center", "Dates are not valid.", jSONObjectPut, "InsiderCore-getMessageCenterData");
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(String str, InsiderProduct insiderProduct, Map map) {
        String productID;
        if (insiderProduct != null) {
            try {
                productID = insiderProduct.getProductID();
            } catch (Exception e2) {
                f3.b("cart_reminder", "An error occurred while purchasing item.", "{}", "InsiderCore-itemPurchased");
                a(e2);
                return;
            }
        } else {
            productID = "";
        }
        if (insiderProduct != null && insiderProduct.isProductValid()) {
            if (str != null && str.length() != 0) {
                insiderProduct.setSaleID(str);
                this.g.a(insiderProduct);
                this.g.b();
                a(insiderProduct.getProductID(), insiderProduct.getUnitPrice());
                InsiderEvent insiderEventAddParameters = h("confirmation_page_view").addParameters(insiderProduct.getProductSummary());
                if (map != null && !map.isEmpty()) {
                    insiderEventAddParameters.addParameters(map);
                }
                insiderEventAddParameters.build();
                f3.b("cart_reminder", "Confirmation page view event was built.", "{ 'product_id': '" + productID + "', 'sale_id': '" + str + "'}", "InsiderCore-itemPurchased");
                this.o.d(insiderProduct);
                Debugger.a(DebuggingTag.itemPurchased, 4, insiderProduct.getProductSummary());
                return;
            }
            f3.b("cart_reminder", "Sale ID is empty.", "{ 'product_id': '" + productID + "'}", "InsiderCore-itemPurchased");
            return;
        }
        f3.b("cart_reminder", "The product used for the itemPurchased method is invalid.", "{ 'product_id': '" + productID + "'}", "InsiderCore-itemPurchased");
    }

    private void a(String str, double d2) {
        new HashMap().put(FirebaseAnalytics.Param.PRODUCT_ID, str);
    }

    void a(InsiderProduct insiderProduct, Map map) {
        try {
            com.useinsider.insider.d.a(this.g, insiderProduct, this.o, map);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(String str, Map map) {
        try {
            com.useinsider.insider.d.a(this.g, str, map);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(String str, String str2, Map map) {
        try {
            com.useinsider.insider.d.a(this.g, str, str2, map);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(Map map) {
        try {
            com.useinsider.insider.d.a(this.g, map);
        } catch (Exception e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Task task) {
        if (!task.isSuccessful()) {
            HashMap map = new HashMap();
            map.put("message", "FirebaseMessaging: Fetching FCM registration token failed");
            Debugger.a(DebuggingTag.getPushToken, 5, map);
            f3.a("push", "Failed to registered for remote notifications.", "{}", "InsiderCore-getPushToken");
            return;
        }
        String str = (String) task.getResult();
        w4.a(this.p, str, n4.GOOGLE);
        f3.b("push", "Registered for remote notifications.", "{ 'device_token': '" + str + "' }", "InsiderCore-getPushToken");
    }

    void a(CloseButtonPosition closeButtonPosition) {
        try {
            if (closeButtonPosition == null) {
                com.useinsider.insider.e.q = CloseButtonPosition.RIGHT;
            } else {
                com.useinsider.insider.e.q = closeButtonPosition;
            }
            Debugger.putLog(DebuggingTag.setInternalBrowserCloseButtonPosition, 4, closeButtonPosition.name());
        } catch (Exception e2) {
            a(e2);
        }
    }

    InsiderProduct a(String str, String str2, String[] strArr, String str3, double d2, String str4) {
        InsiderProduct insiderProduct = new InsiderProduct("", "", new String[0], "", 0.0d, "", false);
        if (b(str, str2, strArr, str3, d2, str4)) {
            insiderProduct = new InsiderProduct(str, str2, strArr, str3, d2, str4, true);
        }
        Debugger.a(DebuggingTag.createNewProduct, 4, insiderProduct.getProductSummary());
        return insiderProduct;
    }

    void a(String[] strArr, Map map) {
        try {
            b(new c(strArr, map));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(InsiderProduct[] insiderProductArr, Map map) {
        try {
            b(new e(insiderProductArr, map));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(InsiderProduct[] insiderProductArr, String str, Map map) {
        try {
            b(new f(insiderProductArr, str, map));
        } catch (Exception e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final InsiderIdentifiers insiderIdentifiers, final InsiderUser.InsiderIDResult insiderIDResult) {
        try {
            final String insiderID = this.p.getInsiderID();
            final HashMap mapA = w4.a(new JSONObject(r().getString(com.useinsider.insider.f.p, "{}")));
            a(insiderIdentifiers.getIdentifiers(), new InsiderUser.InsiderIDResult() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda16
                @Override // com.useinsider.insider.InsiderUser.InsiderIDResult
                public final void insiderIDResult(String str) {
                    this.f$0.a(insiderID, mapA, insiderIdentifiers, insiderIDResult, str);
                }
            });
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Map map, InsiderIdentifiers insiderIdentifiers, InsiderUser.InsiderIDResult insiderIDResult, String str2) {
        if (!str.equals(str2)) {
            if (y()) {
                this.p.setSavedIdentifiersForStopPayload(map);
                a(new i(str2, insiderIdentifiers, insiderIDResult));
                return;
            } else {
                h();
                a(str2, insiderIdentifiers);
                a(new j(insiderIDResult, str2));
                return;
            }
        }
        a(str2, insiderIdentifiers);
        if (insiderIDResult != null) {
            insiderIDResult.insiderIDResult(str2);
        }
    }

    void a(InsiderIdentifiers[] insiderIdentifiersArr, InsiderUser.InsiderIDResult insiderIDResult) {
        try {
            ArrayList arrayList = new ArrayList();
            Map<String, String> userIdentifiersForStopPayload = this.p.getUserIdentifiersForStopPayload();
            if (userIdentifiersForStopPayload != null && !userIdentifiersForStopPayload.isEmpty()) {
                arrayList.add(new HashMap(userIdentifiersForStopPayload));
            }
            if (insiderIdentifiersArr != null) {
                for (InsiderIdentifiers insiderIdentifiers : insiderIdentifiersArr) {
                    if (insiderIdentifiers != null && insiderIdentifiers.getIdentifiers() != null && !insiderIdentifiers.getIdentifiers().isEmpty()) {
                        arrayList.add(insiderIdentifiers.getIdentifiers());
                    }
                }
            }
            this.g.b(arrayList);
            this.p.logout();
            a(new k(w4.h(), insiderIDResult));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void a(Map map, InsiderUser.InsiderIDResult insiderIDResult) {
        try {
            JSONObject jSONObject = new JSONObject(map);
            r().edit().putString(com.useinsider.insider.f.p, jSONObject.toString()).apply();
            this.k.a(this.p, jSONObject, new l(insiderIDResult));
        } catch (Exception e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, InsiderIdentifiers insiderIdentifiers) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    r().edit().remove(com.useinsider.insider.f.o).apply();
                    this.p.setInsiderID(str);
                    this.p.setUserAttribute("mls", Boolean.TRUE, z3.b);
                    this.p.setIdentifiersForStopPayload(insiderIdentifiers);
                    this.p.setIdentifiersAsAttributes(insiderIdentifiers.getIdentifiers());
                    Debugger.a(DebuggingTag.login, 4);
                    f3.b("auth", "Login Successful", "{ 'insider_id': '" + str + "' }", "InsiderCore-identityRequestSuccessHandler");
                    Debugger.putLog(DebuggingTag.setUserIdentifierSuccess, 4, str);
                }
            } catch (Exception e2) {
                a(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.useinsider.insider.o oVar) {
        m0.f().d().d().thenAccept(new Consumer() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda17
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.c(oVar, (InsiderEvent) obj);
            }
        });
    }

    private void a(com.useinsider.insider.o oVar, InsiderEvent insiderEvent) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("event_name", insiderEvent.getName()).put("event_parameters", w4.g(insiderEvent.getParameters()));
            if (oVar == null) {
                f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.APP_TEMPLATE_NOT_FOUND.b(), jSONObjectPut, "InsiderCore-checkInapp");
                return;
            }
            if (!com.useinsider.insider.e.z && !oVar.o()) {
                this.g.a(oVar.q(), oVar.u());
                f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.IN_APP_MESSAGES_DISABLED.b(), jSONObjectPut, "InsiderCore-checkInapp");
                return;
            }
            if (com.useinsider.insider.p.f411a) {
                f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.OTHER_APP_TEMPLATE_ON_SCREEN.b(), jSONObjectPut, "InsiderCore-checkInapp");
                return;
            }
            com.useinsider.insider.p.f411a = true;
            this.h.postDelayed(new y(oVar, insiderEvent), oVar.s());
            f3.b("info", "App Template has been chosen.", "{ 'variant_id': '" + oVar.u() + "', 'inapp_id': '" + oVar.q() + "' }", "InsiderCore-checkInapp");
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(InsiderEvent insiderEvent) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("event_name", insiderEvent.getName()).put("event_parameters", w4.g(insiderEvent.getParameters()));
            f3.b("event", "The event has been triggered.", jSONObjectPut, "InsiderCore-buildEvent");
            if (!this.f351a) {
                this.b.add(insiderEvent);
                if (insiderEvent.getName().equals("confirmation_page_view")) {
                    f3.b("event", "Confirmation page view event was added to pending events.", jSONObjectPut, "InsiderCore-buildEvent");
                }
                f3.a("event", "SDK is in intermediary state.", jSONObjectPut, "InsiderCore-buildEvent");
                return;
            }
            if (w4.d(insiderEvent.getName()) && !com.useinsider.insider.e.r) {
                this.g.a(insiderEvent);
                m0.f().d().a(insiderEvent);
                if (insiderEvent.getParameters().isEmpty()) {
                    Debugger.a(DebuggingTag.tagEvent, 4, insiderEvent.getEventPayload());
                } else {
                    Debugger.a(DebuggingTag.tagEventWithParameters, 4, insiderEvent.toMapForWizard());
                }
                f3.b("event", "The event has been recorded.", jSONObjectPut, "InsiderCore-buildEvent");
                return;
            }
            f3.a("event", "The event name is not valid or the internal browser is open.", jSONObjectPut.put("isValidEventName", !w4.d(insiderEvent.getName())).put("isInternalBrowserOpen", com.useinsider.insider.e.r), "InsiderCore-buildEvent");
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(ConcurrentHashMap concurrentHashMap) {
        try {
            this.g.a(concurrentHashMap);
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(Typeface typeface) {
        try {
            com.useinsider.insider.e.o = typeface;
            Debugger.putLog(DebuggingTag.setCustomBoldFont, 4, String.valueOf(typeface));
        } catch (Exception e2) {
            a(e2);
        }
    }

    void a(Exception exc) {
        try {
            try {
                this.g.a(exc);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            Debugger.putLog(DebuggingTag.exception, 6, exc.getMessage());
            f3.a(NotificationsService.EXCEPTION_KEY, "Exception captured.", "{ 'error': '" + exc.getMessage() + "' }", "InsiderCore-putException");
        }
    }

    void a(Intent intent) {
        if (intent != null) {
            try {
                if (intent.getData() == null || !URLUtil.isValidUrl(intent.getData().toString())) {
                    return;
                }
                b(intent.getData().toString(), 5);
            } catch (Exception e2) {
                a(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, int i2) {
        HttpURLConnection httpURLConnection = null;
        int i3 = 0;
        while (i3 < i2) {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(AutofillUtils_androidKt.MAX_AUTOFILL_TEXT_LENGTH);
                    httpURLConnection2.setReadTimeout(AutofillUtils_androidKt.MAX_AUTOFILL_TEXT_LENGTH);
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.connect();
                    httpURLConnection2.getInputStream();
                    if (httpURLConnection2.getHeaderField("Location") != null) {
                        str = httpURLConnection2.getHeaderField("Location");
                    }
                    boolean z2 = httpURLConnection2.getResponseCode() == 301 || httpURLConnection2.getResponseCode() == 302;
                    httpURLConnection2.disconnect();
                    if (!z2) {
                        break;
                    }
                    i3++;
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            } catch (Exception unused2) {
            }
        }
        if (URLUtil.isValidUrl(str) && b(str)) {
            this.g.d(str);
            Debugger.putLog(DebuggingTag.universalLinkHasBeenSet, 4, str);
        }
    }

    void a(com.useinsider.insider.q qVar) {
        try {
            this.h.post(new n(qVar));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    Boolean a(String str) {
        return Boolean.valueOf(str != null && (str.equals(com.useinsider.insider.f.h) || str.equals(com.useinsider.insider.f.g)));
    }

    void a(String str, com.useinsider.insider.w wVar) {
        this.g.a(str, wVar);
    }

    private synchronized void a(final int i2) {
        long j2 = ((long) i2) * 2000;
        try {
            if (i2 <= 3) {
                this.i.schedule(new Runnable() { // from class: com.useinsider.insider.l0$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(i2);
                    }
                }, j2, TimeUnit.MILLISECONDS);
            } else {
                Debugger.a(DebuggingTag.finishedRetriedRequests, 4);
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }
}
