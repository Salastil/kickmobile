package com.iab.omid.library.amazon2.publisher;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.amazon2.adsession.AdSessionContext;
import com.iab.omid.library.amazon2.adsession.VerificationScriptResource;
import com.iab.omid.library.amazon2.internal.g;
import com.iab.omid.library.amazon2.internal.h;
import com.iab.omid.library.amazon2.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class b extends AdSessionStatePublisher {
    private WebView g;
    private Long h;
    private final Map<String, VerificationScriptResource> i;
    private final String j;

    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return b.this.a(webView, renderProcessGoneDetail);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return com.iab.omid.library.amazon2.webviewclient.a.a(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return com.iab.omid.library.amazon2.webviewclient.a.a(str);
        }
    }

    /* JADX INFO: renamed from: com.iab.omid.library.amazon2.publisher.b$b, reason: collision with other inner class name */
    class C0148b extends WebViewClient {
        C0148b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return b.this.a(webView, renderProcessGoneDetail);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f209a;

        c() {
            this.f209a = b.this.g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f209a.destroy();
        }
    }

    public b(String str, Map<String, VerificationScriptResource> map, String str2) {
        super(str);
        this.h = null;
        this.i = map;
        this.j = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + " for WebView: " + webView);
        if (getWebView() == webView) {
            Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            a((WebView) null);
        }
        if (webView == null) {
            return true;
        }
        webView.destroy();
        return true;
    }

    private boolean a(boolean z, Context context) {
        return !z && com.iab.omid.library.amazon2.attestation.c.a(context).b();
    }

    private WebViewClient c(boolean z) {
        return z ? k() : j();
    }

    private WebViewClient j() {
        return new C0148b();
    }

    private WebViewClient k() {
        return new a();
    }

    @Override // com.iab.omid.library.amazon2.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.amazon2.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            com.iab.omid.library.amazon2.utils.c.a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }

    @Override // com.iab.omid.library.amazon2.publisher.AdSessionStatePublisher
    public void b() {
        long j;
        super.b();
        if (this.h == null) {
            j = 4000;
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long jB = f.b() - this.h.longValue();
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            j = jB / 1000000;
        }
        new Handler().postDelayed(new c(), Math.max(4000 - j, 2000L));
        this.g = null;
    }

    @Override // com.iab.omid.library.amazon2.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        l();
    }

    void l() {
        Context contextA = g.b().a();
        WebView webView = new WebView(contextA);
        this.g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.g.getSettings().setAllowContentAccess(false);
        this.g.getSettings().setAllowFileAccess(false);
        this.g.setWebViewClient(c(a(com.iab.omid.library.amazon2.attestation.g.a(this.g), contextA)));
        a(this.g);
        h.a().c(this.g, this.j);
        for (String str : this.i.keySet()) {
            h.a().d(this.g, this.i.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.h = Long.valueOf(f.b());
    }
}
