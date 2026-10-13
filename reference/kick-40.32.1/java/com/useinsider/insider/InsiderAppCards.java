package com.useinsider.insider;

import android.os.Handler;
import android.os.Looper;
import com.datadog.android.internal.network.HttpSpec;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class InsiderAppCards {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f297a;
    private final String b;
    private final k2 c;
    private final k2 d;
    private final k2 e;
    private final ScheduledExecutorService f;
    private final Handler g;
    private final Set h;
    private final Set i;
    private final Set j;

    InsiderAppCards() {
        this.f297a = false;
        this.g = new Handler(Looper.getMainLooper());
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppCardsCampaignsCallback appCardsCampaignsCallback) {
        appCardsCampaignsCallback.onComplete(null, AppCardsException.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppCardsCampaignsCallback appCardsCampaignsCallback) {
        appCardsCampaignsCallback.onComplete(null, new AppCardsException(AppCardsException.AppCardsExceptionCode.PARSE_ERROR, "Server returned an unexpected response format."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(JSONObject jSONObject) {
        f3.b("app_cards", "Get campaigns request is sending.", jSONObject, "InsiderAppCards-getCampaigns");
        Debugger.putLog(DebuggingTag.appCardsGetCampaigns, 4, jSONObject.toString());
    }

    public void click(InsiderAppCard insiderAppCard) {
        if (!this.f297a || insiderAppCard == null) {
            return;
        }
        if (insiderAppCard.getAction() != null) {
            insiderAppCard.getAction().runAction();
        }
        Insider.Instance.logAppCard(insiderAppCard.getId(), new w().a(new w.b(w.b.a.CLICK, w4.b())));
    }

    public void clickButton(InsiderAppCardButton insiderAppCardButton) {
        if (!this.f297a || insiderAppCardButton == null) {
            return;
        }
        if (insiderAppCardButton.getAction() != null) {
            insiderAppCardButton.getAction().runAction();
        }
        Insider.Instance.logAppCard(insiderAppCardButton.a(), new w().a(new w.a(insiderAppCardButton.getId(), w4.b())));
    }

    public void delete(String[] strArr, final AppCardsDeleteCallback appCardsDeleteCallback) {
        int i;
        if (appCardsDeleteCallback == null) {
            return;
        }
        if (!this.f297a) {
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.a(appCardsDeleteCallback);
                }
            });
            return;
        }
        if (strArr == null || strArr.length == 0) {
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.b(appCardsDeleteCallback);
                }
            });
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.j) {
            for (String str : strArr) {
                if (str != null && !str.trim().isEmpty() && !this.j.contains(str)) {
                    arrayList.add(str);
                }
            }
            this.j.addAll(arrayList);
        }
        if (arrayList.isEmpty()) {
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    appCardsDeleteCallback.onComplete(null);
                }
            });
            return;
        }
        final String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
        try {
            final JSONObject jSONObjectPut = new JSONObject().put("items", new JSONArray(strArr2));
            m2 m2VarA = new c2(this.b).b("/api/v1/psinoza/delete").a("X-Timezone", TimeZone.getDefault().getID()).c(HttpSpec.Method.PATCH).a();
            this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.a(jSONObjectPut);
                }
            });
            this.e.a(m2VarA, jSONObjectPut, new k2.a() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda24
                @Override // com.useinsider.insider.k2.a
                public final void a(m2 m2Var, Object obj, Exception exc) {
                    this.f$0.a(strArr2, appCardsDeleteCallback, jSONObjectPut, m2Var, obj, exc);
                }
            });
        } catch (Exception e) {
            synchronized (this.j) {
                for (String str2 : strArr2) {
                    this.j.remove(str2);
                }
                this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda25
                    @Override // java.lang.Runnable
                    public final void run() {
                        InsiderAppCards.b(appCardsDeleteCallback, e);
                    }
                });
            }
        }
    }

    public void getCampaigns(final AppCardsCampaignsCallback appCardsCampaignsCallback) {
        if (appCardsCampaignsCallback == null) {
            return;
        }
        if (!this.f297a) {
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.a(appCardsCampaignsCallback);
                }
            });
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            Insider insider = Insider.Instance;
            final JSONObject jSONObjectPut = jSONObject.put("insider_id", insider.getCurrentUser().getInsiderID()).put("udid", insider.getCurrentUser().getUDID());
            c2 c2VarA = new c2(this.b).b("/api/v1/psinoza/messages").a("X-Timezone", TimeZone.getDefault().getID());
            this.c.a(new b2(new b2.a() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda28
                @Override // com.useinsider.insider.b2.a
                public final d4 a(JSONObject jSONObject2) {
                    return new InsiderAppCardCampaignsResponse(jSONObject2);
                }
            }));
            m2 m2VarA = c2VarA.a();
            this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.d(jSONObjectPut);
                }
            });
            this.c.a(m2VarA, jSONObjectPut, new k2.a() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda30
                @Override // com.useinsider.insider.k2.a
                public final void a(m2 m2Var, Object obj, Exception exc) {
                    this.f$0.a(jSONObjectPut, appCardsCampaignsCallback, m2Var, obj, exc);
                }
            });
        } catch (Exception e) {
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.b(appCardsCampaignsCallback, e);
                }
            });
        }
    }

    public void markAsRead(String[] strArr, AppCardsMarkAsReadCallback appCardsMarkAsReadCallback) {
        a(strArr, this.h, true, appCardsMarkAsReadCallback);
    }

    public void markAsUnread(String[] strArr, AppCardsMarkAsReadCallback appCardsMarkAsReadCallback) {
        a(strArr, this.i, false, appCardsMarkAsReadCallback);
    }

    public void view(InsiderAppCard insiderAppCard) {
        if (!this.f297a || insiderAppCard == null) {
            return;
        }
        Insider.Instance.logAppCard(insiderAppCard.getId(), new w().a(new w.b(w.b.a.VIEW, w4.b())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final JSONObject jSONObject, final AppCardsCampaignsCallback appCardsCampaignsCallback, m2 m2Var, Object obj, final Exception exc) {
        if (exc != null) {
            this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    f3.b("app_cards", "Get campaigns request failed.", jSONObject, "InsiderAppCards-getCampaigns");
                }
            });
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.a(appCardsCampaignsCallback, exc);
                }
            });
        } else if (!(obj instanceof InsiderAppCardCampaignsResponse)) {
            this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    f3.b("app_cards", "An unexpected response was returned for the Get campaigns response.", jSONObject, "InsiderAppCards-getCampaigns");
                }
            });
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.b(appCardsCampaignsCallback);
                }
            });
        } else {
            final InsiderAppCardCampaignsResponse insiderAppCardCampaignsResponse = (InsiderAppCardCampaignsResponse) obj;
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    appCardsCampaignsCallback.onComplete(insiderAppCardCampaignsResponse, null);
                }
            });
            this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.a(insiderAppCardCampaignsResponse);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppCardsCampaignsCallback appCardsCampaignsCallback, Exception exc) {
        appCardsCampaignsCallback.onComplete(null, AppCardsException.a(exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppCardsMarkAsReadCallback appCardsMarkAsReadCallback) {
        appCardsMarkAsReadCallback.onComplete(new AppCardsException(AppCardsException.AppCardsExceptionCode.INVALID_PARAMETER, "App card IDs must not be null or empty."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(JSONObject jSONObject) {
        f3.b("app_cards", "Successfully received Delete cards response.", jSONObject, "InsiderAppCards-delete");
        Debugger.putLog(DebuggingTag.appCardsDeleteResponse, 4, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, JSONObject jSONObject, String str2, DebuggingTag debuggingTag) {
        f3.b("app_cards", "Successfully received Mark as " + str + " response.", jSONObject, str2);
        Debugger.putLog(debuggingTag, 4, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppCardsMarkAsReadCallback appCardsMarkAsReadCallback, Exception exc) {
        appCardsMarkAsReadCallback.onComplete(AppCardsException.a(exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppCardsDeleteCallback appCardsDeleteCallback) {
        appCardsDeleteCallback.onComplete(new AppCardsException(AppCardsException.AppCardsExceptionCode.INVALID_PARAMETER, "App card IDs must not be null or empty."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppCardsDeleteCallback appCardsDeleteCallback, Exception exc) {
        appCardsDeleteCallback.onComplete(AppCardsException.a(exc));
    }

    InsiderAppCards(j2 j2Var, String str) {
        this.f297a = true;
        this.c = new k2(j2Var);
        this.d = new k2(j2Var);
        this.e = new k2(j2Var);
        this.b = str;
        this.f = (ScheduledExecutorService) b5.f317a.a();
        this.g = new Handler(Looper.getMainLooper());
        this.h = new HashSet();
        this.i = new HashSet();
        this.j = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppCardsCampaignsCallback appCardsCampaignsCallback, Exception exc) {
        appCardsCampaignsCallback.onComplete(null, AppCardsException.a(exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(InsiderAppCardCampaignsResponse insiderAppCardCampaignsResponse) {
        JSONObject jSONObject = insiderAppCardCampaignsResponse.toJSONObject();
        f3.b("app_cards", "Successfully received campaigns response.", jSONObject, "InsiderAppCards-getCampaigns");
        Debugger.putLog(DebuggingTag.appCardsGetCampaignsResponse, 4, jSONObject.toString());
    }

    private void a(String[] strArr, final Set set, boolean z, final AppCardsMarkAsReadCallback appCardsMarkAsReadCallback) {
        int i;
        String str;
        final DebuggingTag debuggingTag;
        DebuggingTag debuggingTag2;
        if (appCardsMarkAsReadCallback == null) {
            return;
        }
        if (!this.f297a) {
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.a(appCardsMarkAsReadCallback);
                }
            });
            return;
        }
        if (strArr != null && strArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            synchronized (set) {
                for (String str2 : strArr) {
                    if (str2 != null && !str2.trim().isEmpty() && !set.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                set.addAll(arrayList);
            }
            if (arrayList.isEmpty()) {
                this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda18
                    @Override // java.lang.Runnable
                    public final void run() {
                        appCardsMarkAsReadCallback.onComplete(null);
                    }
                });
                return;
            }
            final String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
            if (z) {
                str = "/api/v1/psinoza/read";
            } else {
                str = "/api/v1/psinoza/unread";
            }
            if (z) {
                debuggingTag = DebuggingTag.appCardsMarkAsRead;
            } else {
                debuggingTag = DebuggingTag.appCardsMarkAsUnRead;
            }
            if (z) {
                debuggingTag2 = DebuggingTag.appCardsMarkAsReadResponse;
            } else {
                debuggingTag2 = DebuggingTag.appCardsMarkAsUnReadResponse;
            }
            final DebuggingTag debuggingTag3 = debuggingTag2;
            final String str3 = z ? "read" : "unread";
            final String strConcat = "InsiderAppCards-markAs".concat(z ? "Read" : "UnRead");
            try {
                final JSONObject jSONObjectPut = new JSONObject().put("items", new JSONArray(strArr2));
                m2 m2VarA = new c2(this.b).b(str).a("X-Timezone", TimeZone.getDefault().getID()).c(HttpSpec.Method.PATCH).a();
                this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        InsiderAppCards.a(str3, jSONObjectPut, strConcat, debuggingTag);
                    }
                });
                this.d.a(m2VarA, jSONObjectPut, new k2.a() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda20
                    @Override // com.useinsider.insider.k2.a
                    public final void a(m2 m2Var, Object obj, Exception exc) {
                        this.f$0.a(set, strArr2, str3, jSONObjectPut, strConcat, appCardsMarkAsReadCallback, debuggingTag3, m2Var, obj, exc);
                    }
                });
                return;
            } catch (Exception e) {
                synchronized (set) {
                    for (String str4 : strArr2) {
                        set.remove(str4);
                    }
                    this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda21
                        @Override // java.lang.Runnable
                        public final void run() {
                            InsiderAppCards.b(appCardsMarkAsReadCallback, e);
                        }
                    });
                    return;
                }
            }
        }
        this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                InsiderAppCards.b(appCardsMarkAsReadCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppCardsMarkAsReadCallback appCardsMarkAsReadCallback) {
        appCardsMarkAsReadCallback.onComplete(AppCardsException.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, JSONObject jSONObject, String str2, DebuggingTag debuggingTag) {
        f3.b("app_cards", "Mark as " + str + " request is sending.", jSONObject, str2);
        Debugger.putLog(debuggingTag, 4, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Set set, String[] strArr, final String str, final JSONObject jSONObject, final String str2, final AppCardsMarkAsReadCallback appCardsMarkAsReadCallback, final DebuggingTag debuggingTag, m2 m2Var, Object obj, final Exception exc) {
        synchronized (set) {
            for (String str3 : strArr) {
                set.remove(str3);
            }
        }
        if (exc != null) {
            this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.a(str, jSONObject, str2);
                }
            });
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.a(appCardsMarkAsReadCallback, exc);
                }
            });
        } else {
            this.g.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    appCardsMarkAsReadCallback.onComplete(null);
                }
            });
            this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.b(str, jSONObject, str2, debuggingTag);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, JSONObject jSONObject, String str2) {
        f3.b("app_cards", "Mark as " + str + " request failed.", jSONObject, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppCardsMarkAsReadCallback appCardsMarkAsReadCallback, Exception exc) {
        appCardsMarkAsReadCallback.onComplete(AppCardsException.a(exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppCardsDeleteCallback appCardsDeleteCallback) {
        appCardsDeleteCallback.onComplete(AppCardsException.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(JSONObject jSONObject) {
        f3.b("app_cards", "Delete cards request is sending.", jSONObject, "InsiderAppCards-delete");
        Debugger.putLog(DebuggingTag.appCardsDelete, 4, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String[] strArr, final AppCardsDeleteCallback appCardsDeleteCallback, final JSONObject jSONObject, m2 m2Var, Object obj, final Exception exc) {
        synchronized (this.j) {
            for (String str : strArr) {
                this.j.remove(str);
            }
        }
        Handler handler = this.g;
        if (exc != null) {
            handler.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.a(appCardsDeleteCallback, exc);
                }
            });
            this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    f3.b("app_cards", "Delete cards request failed.", jSONObject, "InsiderAppCards-delete");
                }
            });
        } else {
            handler.post(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    appCardsDeleteCallback.onComplete(null);
                }
            });
            this.f.execute(new Runnable() { // from class: com.useinsider.insider.InsiderAppCards$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    InsiderAppCards.c(jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppCardsDeleteCallback appCardsDeleteCallback, Exception exc) {
        appCardsDeleteCallback.onComplete(AppCardsException.a(exc));
    }
}
