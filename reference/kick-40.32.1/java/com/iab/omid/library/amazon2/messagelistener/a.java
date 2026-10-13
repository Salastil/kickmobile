package com.iab.omid.library.amazon2.messagelistener;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iab.omid.library.amazon2.utils.d;
import com.iab.omid.library.amazon2.utils.g;
import com.iab.omid.library.amazon2.utils.i;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class a {
    private static final i c = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebView f200a;
    private final b b;

    /* JADX INFO: renamed from: com.iab.omid.library.amazon2.messagelistener.a$a, reason: collision with other inner class name */
    class C0146a implements WebViewCompat.WebMessageListener {
        C0146a() {
        }

        @Override // androidx.webkit.WebViewCompat.WebMessageListener
        public void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
            a.this.a(webMessageCompat.getData());
        }
    }

    public a(WebView webView, b bVar) {
        g.a(webView, "WebView is null");
        this.f200a = webView;
        this.b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b.onMessageReceived(jSONObject.getString(FirebaseAnalytics.Param.METHOD), jSONObject.getJSONObject("data"));
        } catch (JSONException e) {
            d.a("Error parsing JS message", e);
        }
    }

    public void a() {
        try {
            if (!WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
                this.b.onWebMessageListenerUnsupported();
                return;
            }
            try {
                b();
                c.a(this.f200a, this.b.getListenerName(), new HashSet(Arrays.asList("*")), new C0146a());
                return;
            } catch (Exception e) {
                d.a("Error adding WebView listener", e);
            }
        } catch (NoClassDefFoundError unused) {
        }
        this.b.onWebMessageListenerUnsupported();
    }

    public void b() {
        c.a(this.f200a, this.b.getListenerName());
    }
}
