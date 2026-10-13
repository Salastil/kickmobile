package com.iab.omid.library.amazon2.attestation;

import android.webkit.WebView;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class f implements com.iab.omid.library.amazon2.messagelistener.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.amazon2.messagelistener.a f179a;

    private f(WebView webView) {
        com.iab.omid.library.amazon2.messagelistener.a aVar = new com.iab.omid.library.amazon2.messagelistener.a(webView, this);
        this.f179a = aVar;
        aVar.a();
    }

    public static f a(WebView webView) {
        return new f(webView);
    }

    private void a(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("mechanism");
            String string2 = jSONObject.getString("version");
            Map<String, String> mapB = com.iab.omid.library.amazon2.utils.c.b(jSONObject.getJSONObject("attestationArgs"));
            mapB.put("version", string2);
            e.a(com.iab.omid.library.amazon2.internal.g.b().a().getApplicationContext(), string, new a(mapB));
        } catch (Exception e) {
            com.iab.omid.library.amazon2.utils.d.a("Error processing attestation request", e);
        }
    }

    @Override // com.iab.omid.library.amazon2.messagelistener.b
    public String getListenerName() {
        return "omidJsAttestationListener";
    }

    @Override // com.iab.omid.library.amazon2.messagelistener.b
    public void onMessageReceived(String str, JSONObject jSONObject) {
        if ("attest".equals(str)) {
            a(jSONObject);
            return;
        }
        com.iab.omid.library.amazon2.utils.d.b("Unexpected method in AttestationMessageListener: " + str);
    }

    @Override // com.iab.omid.library.amazon2.messagelistener.b
    public void onWebMessageListenerUnsupported() {
        com.iab.omid.library.amazon2.utils.d.b("The Attestation Webview Listener cannot be supported in this WebView version.");
    }
}
