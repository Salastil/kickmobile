package com.useinsider.insider;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f450a = new AtomicBoolean(false);
    private final Object b = new Object();
    private Context c;
    private volatile String d;
    private List e;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f451a;

        static {
            int[] iArr = new int[b.values().length];
            f451a = iArr;
            try {
                iArr[b.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f451a[b.FEED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f451a[b.TERMINATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    enum b {
        INIT,
        FEED,
        TERMINATE
    }

    y3(Context context) {
        try {
            this.c = context;
            this.e = new CopyOnWriteArrayList();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            String string = h4.a().e(this.c, "Insider").getString("device_location", "");
            return !string.isEmpty() ? new JSONObject(string) : jSONObject;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return jSONObject;
        }
    }

    private void c() {
        try {
            synchronized (this.b) {
                this.f450a.set(false);
                this.d = null;
                this.e.clear();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    String a() {
        return this.d;
    }

    void d() {
        try {
            synchronized (this.b) {
                if (this.f450a.get()) {
                    a(new JSONObject(), b.TERMINATE, 0);
                    Debugger.putLog(DebuggingTag.terminatedConnection, 4, "");
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(String str) {
        this.d = str;
    }

    void a(Map map) {
        try {
            synchronized (this.b) {
                if (this.f450a.get()) {
                    f3.c("wizard", "Wizard already connected.", "{}", "IntegrationWizard-initConnection");
                    return;
                }
                if (this.d != null && !this.d.isEmpty() && !map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("udid", w4.k(this.c));
                    jSONObject.put("insider_attributes", w4.g(map));
                    a(jSONObject, b.INIT, 0);
                    return;
                }
                f3.c("wizard", "Wizard connection failed.", new JSONObject().put("token", this.d).put("is_empty_device_attributes", map.isEmpty()), "IntegrationWizard-initConnection");
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(DebuggingTag debuggingTag, JSONObject jSONObject) {
        try {
            if (this.d == null) {
                f3.b("wizard", "The wizard connection was not established.", "{}", "IntegrationWizard-initConnection");
                return;
            }
            if (!this.f450a.get()) {
                this.e.add(new AbstractMap.SimpleEntry(debuggingTag, jSONObject));
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FirebaseAnalytics.Param.METHOD, debuggingTag.name());
            jSONObject2.put("data", jSONObject);
            a(jSONObject2, b.FEED, 0);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void a(final JSONObject jSONObject, final b bVar, final int i) {
        try {
            final String strA = a(bVar);
            if (strA != null && !strA.isEmpty()) {
                if (bVar == b.TERMINATE) {
                    c();
                }
                ((ScheduledExecutorService) b5.f317a.a()).execute(new Runnable() { // from class: com.useinsider.insider.y3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(strA, jSONObject, bVar, i);
                    }
                });
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, JSONObject jSONObject, b bVar, int i) {
        try {
            String strA = w4.a(str, jSONObject, this.c, false, l4.WIZARD).a();
            b bVar2 = b.INIT;
            if (bVar == bVar2 && "ok".equals(strA)) {
                this.f450a.set(true);
                a(DebuggingTag.deviceLocation, b());
                this.e.forEach(new Consumer() { // from class: com.useinsider.insider.y3$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f$0.a((Map.Entry) obj);
                    }
                });
                this.e.clear();
                f3.b("common", "Integration Wizard connection established successfully.", "{}", "IntegrationWizard-sendRequest");
                return;
            }
            if (bVar != bVar2 || i >= 3) {
                return;
            }
            a(jSONObject, bVar, i + 1);
            f3.b("common", "Integration Wizard initialization retry.", "{ 'retry_count': " + i + " }", "IntegrationWizard-sendRequest");
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Map.Entry entry) {
        a((DebuggingTag) entry.getKey(), (JSONObject) entry.getValue());
    }

    private static String a(b bVar) {
        try {
            int i = a.f451a[bVar.ordinal()];
            if (i == 1) {
                return w3.WIZARD_INIT.b();
            }
            if (i == 2) {
                return w3.WIZARD_FEED.b();
            }
            if (i != 3) {
                return "";
            }
            return w3.WIZARD_TERMINATE.b();
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return "";
        }
    }
}
