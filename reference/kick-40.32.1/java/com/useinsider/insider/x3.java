package com.useinsider.insider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.billingclient.api.BillingClient;
import com.google.android.gms.cast.HlsSegmentFormat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class x3 extends WebView {
    private static volatile WebChromeClient i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f444a;
    private boolean b;
    private volatile boolean c;
    private float d;
    private float e;
    private float[] f;
    private Path g;
    private RectF h;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    interface a {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f445a;
        private final k b;
        private final String c;
        private final a d;
        private final x3 e;
        private final JSONObject f;

        /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ WebView f446a;

            a(WebView webView) {
                this.f446a = webView;
            }

            @Override // java.lang.Runnable
            public void run() {
                x3 x3Var = b.this.e;
                WebView webView = this.f446a;
                x3Var.a(webView, ViewCompat.isAttachedToWindow(webView));
            }
        }

        b(x3 x3Var, String str, k kVar, String str2, a aVar, JSONObject jSONObject) {
            this.e = x3Var;
            this.f445a = str;
            this.b = kVar;
            this.c = str2;
            this.d = aVar;
            this.f = jSONObject;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.e.c) {
                f3.b(BillingClient.ProductType.INAPP, "onPageFinished called but templateLoadFailed = true, skipping INAPP_SEEN callback", this.c, "InsiderView-onPageFinished");
                return;
            }
            webView.setLayerType(2, null);
            this.d.b();
            this.e.a(this.c);
            f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.TEMPLATE_REQUEST_SUCCESSFULLY_COMPLETED.b(), this.c, "InsiderCore-browse");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.e.c = true;
            this.e.a(webView, ViewCompat.isAttachedToWindow(webView));
            p.f411a = false;
            super.onReceivedError(webView, i, str, str2);
            f3.b(BillingClient.ProductType.INAPP, "onReceivedError - Cleared InApp state. Error: " + i + ", " + str, this.c, "InsiderView-onReceivedError");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            String string = webResourceRequest.getUrl().toString();
            f3.b(BillingClient.ProductType.INAPP, "onReceivedHttpError called - URL: " + string + ", Status: " + (webResourceResponse != null ? webResourceResponse.getStatusCode() : 0), this.c, "InsiderView-onReceivedHttpError");
            if (this.f445a.equals(string)) {
                f3.b(BillingClient.ProductType.INAPP, "Removing WebView due to HTTP error on template URL", this.c, "InsiderView-onReceivedHttpError");
                this.e.c = true;
                this.e.a(webView, webView.isAttachedToWindow());
                p.f411a = false;
                f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.TEMPLATE_REQUEST_FAILED.b(), this.c, "InsiderView-onReceivedHttpError");
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) throws Throwable {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            String string = webResourceRequest.getUrl().toString();
            String str = this.f445a;
            if (str == null || !string.equalsIgnoreCase(str)) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    String strValueOf = String.valueOf(w4.b());
                    String string2 = p0.a(strValueOf, new JSONObject().put("version", "16.0.7-nh"), true).getString("payload");
                    String strA = x3.a(strValueOf, this.f);
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(string).openConnection();
                    try {
                        try {
                            httpURLConnection2.setRequestMethod("POST");
                            httpURLConnection2.setRequestProperty("x-sdk-version", string2);
                            httpURLConnection2.setRequestProperty(HlsSegmentFormat.TS, strValueOf);
                            httpURLConnection2.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                            httpURLConnection2.setConnectTimeout(10000);
                            httpURLConnection2.setReadTimeout(10000);
                            httpURLConnection2.setDoOutput(true);
                            OutputStream outputStream = httpURLConnection2.getOutputStream();
                            try {
                                outputStream.write(strA.getBytes(StandardCharsets.UTF_8));
                                outputStream.close();
                                int responseCode = httpURLConnection2.getResponseCode();
                                if (responseCode < 200 || responseCode >= 300) {
                                    f3.b(BillingClient.ProductType.INAPP, "Template request failed with response code: " + responseCode + " - cleaning up InApp state", this.c, "InsiderView-shouldInterceptRequest");
                                    a(webView);
                                    WebResourceResponse webResourceResponse = new WebResourceResponse("text/html", "UTF-8", responseCode, "Error", null, new ByteArrayInputStream(new byte[0]));
                                    httpURLConnection2.disconnect();
                                    return webResourceResponse;
                                }
                                InputStream inputStream = httpURLConnection2.getInputStream();
                                String strA2 = a(inputStream);
                                inputStream.close();
                                String headerField = httpURLConnection2.getHeaderField(HlsSegmentFormat.TS);
                                if (headerField != null) {
                                    strValueOf = headerField;
                                }
                                if (!strA2.trim().startsWith("<")) {
                                    try {
                                        String strA3 = p0.a(strA2, strValueOf);
                                        if (strA3 == null || strA3.isEmpty()) {
                                            f3.b(BillingClient.ProductType.INAPP, "Template decryption returned null or empty", this.c, "InsiderView-shouldInterceptRequest");
                                        } else {
                                            strA2 = strA3;
                                        }
                                    } catch (Exception e) {
                                        f3.b(BillingClient.ProductType.INAPP, "Template decryption failed, using cleartext: " + e.getMessage(), this.c, "InsiderView-shouldInterceptRequest");
                                    }
                                }
                                if (!strA2.trim().isEmpty()) {
                                    WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(strA2.getBytes(StandardCharsets.UTF_8)));
                                    httpURLConnection2.disconnect();
                                    return webResourceResponse2;
                                }
                                f3.b(BillingClient.ProductType.INAPP, "Template content is empty after decryption - cleaning up InApp state", this.c, "InsiderView-shouldInterceptRequest");
                                a(webView);
                                WebResourceResponse webResourceResponse3 = new WebResourceResponse("text/html", "UTF-8", 204, "No Content", null, new ByteArrayInputStream(new byte[0]));
                                httpURLConnection2.disconnect();
                                return webResourceResponse3;
                            } catch (Throwable th) {
                                if (outputStream == null) {
                                    throw th;
                                }
                                try {
                                    outputStream.close();
                                    throw th;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                    throw th;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            httpURLConnection = httpURLConnection2;
                            Insider.Instance.putException(e);
                            f3.b(BillingClient.ProductType.INAPP, "Template obfuscation error: " + e.getMessage() + " - cleaning up InApp state", this.c, "InsiderView-shouldInterceptRequest");
                            a(webView);
                            WebResourceResponse webResourceResponse4 = new WebResourceResponse("text/html", "UTF-8", 500, "Internal Error", null, new ByteArrayInputStream(new byte[0]));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return webResourceResponse4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            boolean zStartsWith = str.startsWith("insiderurl");
            k kVar = this.b;
            if (zStartsWith) {
                kVar.a(5, 9, str);
                return true;
            }
            kVar.a(6, 3, str);
            return true;
        }

        private String a(InputStream inputStream) {
            Scanner scannerUseDelimiter = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
            return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
        }

        private void a(WebView webView) {
            this.e.c = true;
            p.f411a = false;
            webView.post(new a(webView));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            this.e.c = true;
            this.e.a(webView, webView.isAttachedToWindow());
            p.f411a = false;
            f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.TEMPLATE_REQUEST_FAILED.b(), this.c, "InsiderView-onReceivedError");
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    public x3(Context context) {
        super(context);
        this.b = false;
        this.c = false;
        c();
    }

    private void b(String str, k kVar, String str2, JSONObject jSONObject) {
        setLayerType(2, null);
        setBackgroundColor(0);
        getSettings().setJavaScriptEnabled(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setWebChromeClient(b());
        setWebViewClient(new b(this, str, kVar, str2, this.f444a, jSONObject));
        loadUrl(str);
    }

    private void c() {
        try {
            ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.useinsider.insider.x3$$ExternalSyntheticLambda1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return x3.a(view, windowInsetsCompat);
                }
            });
            setOverScrollMode(2);
            setScrollbarFadingEnabled(true);
            setFitsSystemWindows(false);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        try {
            this.f444a.a();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        try {
            if (getContentHeight() <= 0 || this.b) {
                return;
            }
            this.b = true;
            postDelayed(new Runnable() { // from class: com.useinsider.insider.x3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d();
                }
            }, 100L);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            WebView.class.getMethod("onPause", null).invoke(this, null);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            this.g.setFillType(Path.FillType.INVERSE_WINDING);
            this.g.addRoundRect(this.h, this.f, Path.Direction.CW);
            canvas.drawPath(this.g, a());
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        try {
            this.d = i2;
            this.e = i3;
            this.g = new Path();
            this.h = new RectF(0.0f, getScrollY(), this.d, getScrollY() + this.e);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPadding(insets.left, insets.top, insets.right, 0);
        return new WindowInsetsCompat.Builder(windowInsetsCompat).setInsets(WindowInsetsCompat.Type.ime(), Insets.NONE).build();
    }

    public void a(float[] fArr) {
        this.f = fArr;
    }

    private Paint a() {
        Paint paint = new Paint();
        try {
            paint.setColor(0);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            return paint;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return paint;
        }
    }

    private static WebChromeClient b() {
        if (i == null) {
            i = new WebChromeClient();
        }
        return i;
    }

    public void a(String str, k kVar, String str2, JSONObject jSONObject) {
        try {
            b(str, kVar, str2, jSONObject);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static String a(String str, JSONObject jSONObject) {
        try {
            return p0.a(str, jSONObject, true).toString();
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return new JSONObject().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WebView webView, boolean z) {
        if (webView == null || webView.getVisibility() != 0) {
            return;
        }
        webView.setVisibility(8);
        if (z) {
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.removeAllViews();
        }
        webView.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            final JSONObject jSONObjectPut = new JSONObject().put("type", InsiderCallbackType.INAPP_SEEN.ordinal()).put("data", new JSONObject(str));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.useinsider.insider.x3$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    x3.a(jSONObjectPut);
                }
            }, 200L);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(JSONObject jSONObject) {
        if (e.z || p.f411a) {
            Insider.Instance.performInsiderCallback(jSONObject, InsiderCallbackType.INAPP_SEEN);
        }
    }

    public void a(a aVar) {
        this.f444a = aVar;
    }
}
