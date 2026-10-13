package org.h.s;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import io.mobileshield.sdk.Priority;
import io.mobileshield.sdk.logger.LocalLogger;
import java.net.URL;
import java.util.HashMap;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f590a;
    public String b;
    public n c;
    public q d;
    public u4 e;
    public z4 f;
    public w4 g;
    public Context h;
    public Handler i;
    public final Priority j;
    public String k;
    public long l;

    public x4(String str, Context context, f4 callback, Priority priority) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.b = str;
        this.c = callback;
        this.j = priority;
        this.h = context;
        f();
        this.e = new u4();
        this.d = new q();
        this.i = new Handler(Looper.getMainLooper());
        c();
    }

    public static boolean d() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public final n a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final void c() {
        if (!d()) {
            Runnable runnable = new Runnable() { // from class: org.h.s.x4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    x4.a(this.f$0);
                }
            };
            Priority priority = this.j;
            if (priority != Priority.MEDIUM && priority != Priority.HIGH) {
                Handler handler = this.i;
                if (handler != null) {
                    handler.post(runnable);
                    return;
                }
                return;
            }
            Handler handler2 = this.i;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            Handler handler3 = this.i;
            if (handler3 != null) {
                handler3.postAtFrontOfQueue(runnable);
                return;
            }
            return;
        }
        try {
            LocalLogger.log(16, 22901L, "start processing");
            Context context = this.h;
            Intrinsics.checkNotNull(context);
            this.f590a = new WebView(context);
            if (y1.i == null) {
                y1.i = new y1(Dispatchers.getIO(), new t1());
            }
            y1 y1Var = y1.i;
            Intrinsics.checkNotNull(y1Var);
            r4 r4Var = r4.INTERROGATION;
            y1Var.a(r4Var, "create_webview");
            WebView webView = this.f590a;
            WebSettings settings = webView != null ? webView.getSettings() : null;
            if (settings != null) {
                settings.setCacheMode(2);
            }
            if (settings != null) {
                settings.setJavaScriptEnabled(true);
            }
            WebView webView2 = this.f590a;
            if (webView2 != null) {
                webView2.setWillNotDraw(true);
            }
            WebView webView3 = this.f590a;
            if (webView3 != null) {
                q qVar = this.d;
                Intrinsics.checkNotNull(qVar);
                webView3.setWebViewClient(qVar);
            }
            WebView webView4 = this.f590a;
            if (webView4 != null) {
                webView4.setVisibility(8);
            }
            WebView webView5 = this.f590a;
            if (webView5 != null) {
                webView5.setWebChromeClient(this.e);
            }
            WebView webView6 = this.f590a;
            if (webView6 != null) {
                webView6.loadUrl("about:blank");
            }
            if (y1.i == null) {
                y1.i = new y1(Dispatchers.getIO(), new t1());
            }
            y1 y1Var2 = y1.i;
            Intrinsics.checkNotNull(y1Var2);
            y1Var2.a(r4Var, "load_webview_ab");
        } catch (Exception e) {
            w0 exceptionLog = w0.R;
            Intrinsics.checkNotNullParameter(e, "<this>");
            Intrinsics.checkNotNullParameter(exceptionLog, "exceptionLog");
            s3 s3Var = f1.f506a;
            f1.a(exceptionLog, y.a(e));
        }
    }

    public final HashMap e() {
        HashMap map = new HashMap();
        map.put("x-kpsdk-v", t4.a());
        map.put("x-kpsdk-dv", o0.a(this.h));
        map.put("x-kpsdk-h", g0.f510a);
        String str = o0.b;
        if (str != null) {
            map.put("x-kpsdk-r", str);
        }
        return map;
    }

    public final synchronized void f() {
        Context context;
        if (this.j != Priority.HIGH && (context = this.h) != null) {
            WebSettings.getDefaultUserAgent(context);
        }
    }

    public final void g() {
        this.k = null;
        this.l = 0L;
    }

    public final void a(final URL url) {
        q qVar;
        if (!d()) {
            Runnable runnable = new Runnable() { // from class: org.h.s.x4$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    x4.a(this.f$0, url);
                }
            };
            Priority priority = this.j;
            if (priority != Priority.MEDIUM && priority != Priority.HIGH) {
                Handler handler = this.i;
                if (handler != null) {
                    handler.post(runnable);
                    return;
                }
                return;
            }
            Handler handler2 = this.i;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            Handler handler3 = this.i;
            if (handler3 != null) {
                handler3.postAtFrontOfQueue(runnable);
                return;
            }
            return;
        }
        try {
            u1 u1Var = y1.h;
            y1 y1VarA = u1Var.a();
            r4 r4Var = r4.INTERROGATION;
            y1VarA.a(r4Var, "start_process_webview");
            if (this.f590a == null) {
                c();
            }
            WebView currentWebView = this.f590a;
            Intrinsics.checkNotNull(currentWebView);
            WebSettings settings = currentWebView.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
            settings.setUserAgentString(this.b);
            LocalLogger.log(8, 22704L, settings.getUserAgentString());
            LocalLogger.log(8, 22701L, url.toString());
            if (this.d == null) {
                LocalLogger.log(2, 22705L, "");
                this.d = new q();
            }
            n nVar = this.c;
            if (nVar != null && (qVar = this.d) != null) {
                String host = url.getHost();
                Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
                qVar.a(nVar, host);
            }
            currentWebView.removeJavascriptInterface("localJS");
            if (this.g == null) {
                w4 w4Var = new w4(this, url);
                this.g = w4Var;
                this.f = new z4(w4Var);
            }
            z4 z4Var = this.f;
            if (z4Var != null) {
                currentWebView.addJavascriptInterface(z4Var, "localJS");
                Intrinsics.checkNotNullParameter(currentWebView, "currentWebView");
                Intrinsics.checkNotNullParameter(url, "url");
                if (WebViewFeature.isFeatureSupported(WebViewFeature.DOCUMENT_START_SCRIPT)) {
                    q.d = true;
                    WebViewCompat.addDocumentStartJavaScript(currentWebView, p.a(), SetsKt.setOf(url.toString()));
                }
                s3 s3Var = f1.f506a;
                f1.a(w0.I, url.getHost());
                currentWebView.loadUrl(url.toString() + "/149e9513-01fa-4fb0-aad4-566afd725d1b/2d206a39-8ed7-437e-a3be-862e0f06eea3/fp", e());
                u1Var.a().a(r4Var, "load_webview_fp");
            }
        } catch (Exception e) {
            y.a(e, w0.S);
            n nVar2 = this.c;
            if (nVar2 != null) {
                String host2 = url.getHost();
                Intrinsics.checkNotNullExpressionValue(host2, "getHost(...)");
                String string = url.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                ((f4) nVar2).a(host2, string, "set up exception", 3);
            }
        }
    }

    public static final void a(x4 this$0, URL url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        this$0.a(url);
    }

    public static final void a(x4 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
    }
}
