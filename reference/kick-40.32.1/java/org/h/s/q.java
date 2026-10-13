package org.h.s;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import io.ktor.sse.ServerSentEventKt;
import io.mobileshield.sdk.logger.LocalLogger;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Dispatchers;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes11.dex */
public final class q extends WebViewClient {
    public static boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f557a;
    public n b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public final void a(n callback, String domain) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(domain, "domain");
        this.b = callback;
        this.f557a = domain;
        this.c.set(false);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        String strA = a2.a(url);
        if (strA != null) {
            y1.h.a().a(r4.INTERROGATION, "load_resource_" + strA);
            s3 s3Var = f1.f506a;
            f1.a(w0.Q, strA);
        }
        super.onLoadResource(view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        s3 s3Var = f1.f506a;
        w0 w0Var = w0.P;
        String url2 = webView.getUrl();
        f1.a(w0Var, t4.a(url2 != null ? StringsKt.substringAfterLast$default(url2, DomExceptionUtils.SEPARATOR, (String) null, 2, (Object) null) : null));
        if (!Intrinsics.areEqual(url, "about:blank") && !this.c.get()) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            webView.loadUrl("javascript:(function()\n    {\n        if (!window.KPSDK) {\n            localJS.failedToLoad();\n        } else if (window.KPSDK.message) {\n            localJS.pMessage(window.KPSDK.message);\n        } else {\n            window.addEventListener('message', function(evt) { localJS.pMessage(evt.data); });\n        }\n    }\n)()");
            if (y1.i == null) {
                y1.i = new y1(Dispatchers.getIO(), new t1());
            }
            y1 y1Var = y1.i;
            Intrinsics.checkNotNull(y1Var);
            y1Var.a(r4.INTERROGATION, "load_webview_js");
            f1.a(w0.N, null);
        }
        super.onPageFinished(webView, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView view, String url, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        s3 s3Var = f1.f506a;
        f1.a(w0.O, t4.a(url));
        if (!d) {
            p.a(view);
        }
        super.onPageStarted(view, url, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(view, "view");
        s3 s3Var = f1.f506a;
        f1.a(w0.M, "(Deprecated) " + i + ": " + t4.a(str) + ". Failing url " + t4.a(str2));
        if (this.c.get()) {
            return;
        }
        this.c.set(true);
        n nVar = this.b;
        String str3 = null;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            nVar = null;
        }
        String str4 = this.f557a;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("domain");
        } else {
            str3 = str4;
        }
        ((f4) nVar).a(str3, t4.a(str2), " Description - " + t4.a(str), i);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView view, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        int statusCode;
        Map<String, String> responseHeaders;
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        String str2 = null;
        if (webResourceResponse != null && (responseHeaders = webResourceResponse.getResponseHeaders()) != null && (str = responseHeaders.get("x-kpsdk-h")) != null) {
            HashMap map = new HashMap();
            map.put("x-kpsdk-h", str);
            Map<String, String> responseHeaders2 = webResourceResponse.getResponseHeaders();
            map.put("x-kpsdk-fc", t4.a(responseHeaders2 != null ? responseHeaders2.get("x-kpsdk-fc") : null));
            n nVar = this.b;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                nVar = null;
            }
            ((f4) nVar).a(map);
        }
        if (o0.a()) {
            statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
        } else {
            statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : 429;
        }
        String url = view.getUrl();
        if (url == null) {
            url = "<NO_URL>";
        }
        if (o0.a() || statusCode != 429) {
            s3 s3Var = f1.f506a;
            f1.a(w0.L, url + " (" + statusCode + ") " + (webResourceResponse != null ? webResourceResponse.getReasonPhrase() : null) + ")");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder(" ViewURL = ");
            sb2.append(url);
            sb.append(sb2.toString());
            StringBuilder sb3 = new StringBuilder(" - Error code = ");
            sb3.append(statusCode);
            sb.append(sb3.toString());
            String reasonPhrase = webResourceResponse != null ? webResourceResponse.getReasonPhrase() : null;
            if (reasonPhrase == null) {
                reasonPhrase = "NO DESCRIPTION";
            }
            sb.append(" - Description = " + reasonPhrase);
            if (StringsKt.contains$default((CharSequence) url, (CharSequence) "about:blank", false, 2, (Object) null) || this.c.get()) {
                return;
            }
            this.c.set(true);
            n nVar2 = this.b;
            if (nVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                nVar2 = null;
            }
            String str3 = this.f557a;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("domain");
            } else {
                str2 = str3;
            }
            ((f4) nVar2).a(str2, url, t4.a(sb.toString()), statusCode);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        String str = request.getRequestHeaders().get("x-kpsdk-h");
        if (str != null) {
            HashMap map = new HashMap();
            map.put("x-kpsdk-h", str);
            map.put("x-kpsdk-fc", StringsKt.replace$default(t4.a(request.getRequestHeaders().get("x-kpsdk-fc")), ServerSentEventKt.SPACE, Marker.ANY_NON_NULL_MARKER, false, 4, (Object) null));
            n nVar = this.b;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                nVar = null;
            }
            ((f4) nVar).a(map);
        }
        String path = request.getUrl().getPath();
        if (path != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = path.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "/favicon.ico", false, 2, (Object) null)) {
                try {
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    byte[] bytes = "".getBytes(UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    return new WebResourceResponse("text", "UTF-8", new ByteArrayInputStream(bytes));
                } catch (Exception e) {
                    LocalLogger.log(2, 22900L, e.getLocalizedMessage());
                }
            }
        }
        return super.shouldInterceptRequest(view, request);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        LocalLogger.log(16, 22401L, t4.a(url));
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, WebResourceRequest request, WebResourceError webResourceError) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        int errorCode = webResourceError != null ? webResourceError.getErrorCode() : 0;
        String url = view.getUrl();
        String str = "<NO_URL>";
        if (url == null) {
            url = "<NO_URL>";
        }
        Uri url2 = request.getUrl();
        if (url2 != null && (string = url2.toString()) != null) {
            str = string;
        }
        s3 s3Var = f1.f506a;
        f1.a(w0.M, errorCode + ": " + url);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder(" ViewURL = ");
        sb2.append(url);
        sb.append(sb2.toString());
        sb.append(" - URL = " + str);
        sb.append(" - Error code = " + (webResourceError != null ? Integer.valueOf(webResourceError.getErrorCode()) : " NO ERROR CODE"));
        String str2 = null;
        CharSequence description = webResourceError != null ? webResourceError.getDescription() : null;
        if (description == null) {
            description = " NO DESCRIPTION";
        }
        sb.append(" - Description = " + ((Object) description));
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "about:blank", false, 2, (Object) null)) {
            LocalLogger.log(2, 22402L, t4.a(sb.toString()));
            return;
        }
        if (this.c.get()) {
            return;
        }
        this.c.set(true);
        n nVar = this.b;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            nVar = null;
        }
        String str3 = this.f557a;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("domain");
        } else {
            str2 = str3;
        }
        ((f4) nVar).a(str2, url, t4.a(sb.toString()), errorCode);
    }
}
