package com.iab.omid.library.amazon2.publisher;

import android.webkit.WebView;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.iab.omid.library.amazon2.adsession.AdEvents;
import com.iab.omid.library.amazon2.adsession.AdSessionConfiguration;
import com.iab.omid.library.amazon2.adsession.AdSessionContext;
import com.iab.omid.library.amazon2.adsession.ErrorType;
import com.iab.omid.library.amazon2.adsession.VerificationScriptResource;
import com.iab.omid.library.amazon2.adsession.media.MediaEvents;
import com.iab.omid.library.amazon2.internal.g;
import com.iab.omid.library.amazon2.internal.h;
import com.iab.omid.library.amazon2.utils.c;
import com.iab.omid.library.amazon2.utils.d;
import com.iab.omid.library.amazon2.utils.f;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f205a;
    private com.iab.omid.library.amazon2.weakreference.b b;
    private AdEvents c;
    private MediaEvents d;
    private a e;
    private long f;

    enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        a();
        this.f205a = str;
        this.b = new com.iab.omid.library.amazon2.weakreference.b(null);
    }

    private JSONArray a(List<com.iab.omid.library.amazon2.attestation.b> list) {
        JSONArray jSONArray = new JSONArray();
        for (com.iab.omid.library.amazon2.attestation.b bVar : list) {
            Iterator<String> it = bVar.c().iterator();
            while (it.hasNext()) {
                jSONArray.put(a(bVar, it.next()));
            }
        }
        return jSONArray;
    }

    private JSONObject a(com.iab.omid.library.amazon2.attestation.b bVar, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mechanism", bVar.a());
        jSONObject.put("executionEnvironment", bVar.b().toString());
        jSONObject.put("version", str);
        return jSONObject;
    }

    private JSONObject a(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "supportedAttestationMechanisms", jSONArray);
        return jSONObject;
    }

    private void a(JSONObject jSONObject) {
        h.a().b(getWebView(), jSONObject);
    }

    public void a() {
        this.f = f.b();
        this.e = a.AD_STATE_IDLE;
    }

    public void a(float f) {
        h.a().a(getWebView(), this.f205a, f);
    }

    void a(WebView webView) {
        this.b = new com.iab.omid.library.amazon2.weakreference.b(webView);
    }

    public void a(AdEvents adEvents) {
        this.c = adEvents;
    }

    public void a(AdSessionConfiguration adSessionConfiguration) {
        h.a().a(getWebView(), this.f205a, adSessionConfiguration.toJsonObject());
    }

    public void a(ErrorType errorType, String str) {
        h.a().a(getWebView(), this.f205a, errorType, str);
    }

    public void a(com.iab.omid.library.amazon2.adsession.a aVar, AdSessionContext adSessionContext) {
        a(aVar, adSessionContext, null);
    }

    protected void a(com.iab.omid.library.amazon2.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String strC = aVar.c();
        JSONObject jSONObject2 = new JSONObject();
        c.a(jSONObject2, "environment", SessionEndedMetric.PROCESS_TYPE_VALUE);
        c.a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        c.a(jSONObject2, "deviceInfo", com.iab.omid.library.amazon2.utils.b.d());
        c.a(jSONObject2, "deviceCategory", com.iab.omid.library.amazon2.utils.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        c.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.a(jSONObject3, "partnerName", adSessionContext.getPartner().getName());
        c.a(jSONObject3, "partnerVersion", adSessionContext.getPartner().getVersion());
        c.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.a(jSONObject4, "libraryVersion", "1.6.4-Amazon2");
        c.a(jSONObject4, "appId", g.b().a().getApplicationContext().getPackageName());
        c.a(jSONObject2, SessionEndedMetric.PROCESS_TYPE_VALUE, jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            c.a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            c.a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        if (adSessionContext.getUniversalAdId() != null) {
            c.a(jSONObject2, "universalAdId", adSessionContext.getUniversalAdId());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource verificationScriptResource : adSessionContext.getVerificationScriptResources()) {
            c.a(jSONObject5, verificationScriptResource.getVendorKey(), verificationScriptResource.getVerificationParameters());
        }
        h.a().a(getWebView(), strC, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(MediaEvents mediaEvents) {
        this.d = mediaEvents;
    }

    public void a(String str) {
        a(str, (JSONObject) null);
    }

    public void a(String str, long j) {
        if (j >= this.f) {
            a aVar = this.e;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.e = aVar2;
                h.a().b(getWebView(), this.f205a, str);
            }
        }
    }

    public void a(String str, JSONObject jSONObject) {
        h.a().a(getWebView(), this.f205a, str, jSONObject);
    }

    public void a(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        h.a().a(getWebView(), jSONObject);
    }

    public void a(boolean z) {
        if (e()) {
            h.a().c(getWebView(), this.f205a, z ? "foregrounded" : "backgrounded");
        }
    }

    public void b() {
        this.b.clear();
    }

    public void b(String str, long j) {
        if (j >= this.f) {
            this.e = a.AD_STATE_VISIBLE;
            h.a().b(getWebView(), this.f205a, str);
        }
    }

    public void b(List<com.iab.omid.library.amazon2.attestation.b> list) {
        try {
            a(a(a(list)));
        } catch (JSONException e) {
            d.a("Error creating JSON object publishSupportedAttestationMechanisms", e);
        }
    }

    public void b(JSONObject jSONObject) {
        h.a().b(getWebView(), this.f205a, jSONObject);
    }

    public void b(boolean z) {
        if (e()) {
            h.a().a(getWebView(), this.f205a, z ? "locked" : "unlocked");
        }
    }

    public AdEvents c() {
        return this.c;
    }

    public MediaEvents d() {
        return this.d;
    }

    public boolean e() {
        return this.b.get() != null;
    }

    public void f() {
        h.a().a(getWebView(), this.f205a);
    }

    public void g() {
        h.a().b(getWebView(), this.f205a);
    }

    public WebView getWebView() {
        return this.b.get();
    }

    public void h() {
        b((JSONObject) null);
    }

    public void i() {
    }
}
