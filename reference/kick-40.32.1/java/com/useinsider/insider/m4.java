package com.useinsider.insider;

import android.content.Context;
import expo.modules.notifications.service.NotificationsService;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f392a = (ExecutorService) b5.c.a();
    private final Context b;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f393a;
        final /* synthetic */ MessageCenterData b;

        a(JSONObject jSONObject, MessageCenterData messageCenterData) {
            this.f393a = jSONObject;
            this.b = messageCenterData;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strA = w4.a(w3.MESSAGE_CENTER.b(), this.f393a, m4.this.b, false, l4.MESSAGE_CENTER).a();
                if (strA == null || strA.length() == 0) {
                    strA = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                }
                this.b.loadMessageCenterData(new JSONArray(strA));
                f3.b("message_center", "Message center data received.", this.f393a, "RequestUtils-getMessageCenterData");
                Debugger.putLog(DebuggingTag.getMessageCenterDataResponse, 4, strA);
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f394a;
        final /* synthetic */ x4 b;

        b(JSONObject jSONObject, x4 x4Var) {
            this.f394a = jSONObject;
            this.b = x4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int iB = w4.a(w3.SESSION_STOP.b(), this.f394a, m4.this.b, true, l4.FLUSH).b();
                x4 x4Var = this.b;
                if (x4Var != null) {
                    if (iB == 1000) {
                        x4Var.d();
                        return;
                    }
                    boolean zA = w4.a(iB);
                    x4 x4Var2 = this.b;
                    if (zA) {
                        x4Var2.a();
                    } else {
                        x4Var2.c();
                    }
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f395a;
        final /* synthetic */ n b;

        c(JSONObject jSONObject, n nVar) {
            this.f395a = jSONObject;
            this.b = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.a(w4.a(w3.IDENTITY.b(), this.f395a, m4.this.b, false, l4.IDENTITY).a());
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f396a;

        d(JSONObject jSONObject) {
            this.f396a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                w4.a(w3.GDPR_CONSENT_SET.b(), this.f396a, m4.this.b, true, l4.GDPR_SET);
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InsiderUser f397a;

        e(InsiderUser insiderUser) {
            this.f397a = insiderUser;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("partner", com.useinsider.insider.e.b);
                jSONObject.put("insider_id", this.f397a.getInsiderID());
                jSONObject.put("udid", w4.k(m4.this.b));
                String strA = w4.a(w3.AMPLIFICATION.b(), jSONObject, m4.this.b, false, l4.AMPLIFICATION).a();
                if (strA != null && strA.length() != 0) {
                    JSONArray jSONArray = new JSONArray(strA);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        w4.a(m4.this.b, (Map) w4.a((JSONObject) jSONArray.get(i)), true);
                        Thread.sleep(1000L);
                    }
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONArray f398a;

        f(JSONArray jSONArray) {
            this.f398a = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Debugger.putLog(DebuggingTag.insiderLogService, 4, this.f398a.toString());
                w4.a("https://mobile.useinsider.com/api/logging/sdk/v2", new JSONObject().put("partner_name", com.useinsider.insider.e.b).put("logs", this.f398a), m4.this.b, false, l4.LOGGING);
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    m4(Context context) {
        this.b = context;
    }

    void b(JSONObject jSONObject) {
        w4.a(w3.SESSION_STOP.b(), jSONObject, this.b, true, l4.STOP);
    }

    void c(final JSONObject jSONObject, final x4 x4Var) {
        this.f392a.execute(new Runnable() { // from class: com.useinsider.insider.m4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(jSONObject, x4Var);
            }
        });
    }

    void a(JSONObject jSONObject, MessageCenterData messageCenterData) {
        this.f392a.execute(new a(jSONObject, messageCenterData));
    }

    void a(JSONObject jSONObject, x4 x4Var) {
        this.f392a.execute(new b(jSONObject, x4Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(JSONObject jSONObject, x4 x4Var) {
        b(jSONObject);
        if (x4Var != null) {
            x4Var.b();
        }
    }

    void a(InsiderUser insiderUser, JSONObject jSONObject, n nVar) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("partner", com.useinsider.insider.e.b);
            if (w4.h(insiderUser.getInsiderID())) {
                jSONObject2.put("insider_id", insiderUser.getInsiderID());
            }
            jSONObject2.put(NotificationsService.IDENTIFIERS_KEY, jSONObject);
            jSONObject2.put("platform", GetDeviceInfoUseCaseKt.PLATFORM);
            Debugger.b(DebuggingTag.insiderIdentifierRequestJSON, 4, jSONObject2);
            this.f392a.execute(new c(jSONObject2, nVar));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void a(JSONObject jSONObject) {
        this.f392a.execute(new d(jSONObject));
    }

    void a(InsiderUser insiderUser) {
        this.f392a.execute(new e(insiderUser));
    }

    void a(String str, JSONArray jSONArray) {
        this.f392a.execute(new f(jSONArray));
    }
}
