package expo.modules.webview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.core.logging.LogHandlers;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: compiled from: DomWebView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001N\b\u0001\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001SB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206J\r\u00108\u001a\u000206H\u0000¢\u0006\u0002\b9J\u000e\u0010:\u001a\u0002062\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010;\u001a\u0002062\b\u0010<\u001a\u0004\u0018\u00010\u0015J\u0010\u0010=\u001a\u0002062\b\u0010<\u001a\u0004\u0018\u00010\u0015J\u000e\u0010>\u001a\u0002062\u0006\u0010\u0012\u001a\u00020\u0015J\u000e\u0010?\u001a\u0002062\u0006\u0010<\u001a\u00020\u0015J\u000e\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020\u0015J\u000e\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u0015J\u000e\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020FJ\u001c\u0010G\u001a\u00020\u001a2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020\nH\u0003J\r\u0010M\u001a\u00020NH\u0002¢\u0006\u0002\u0010OJ\u001e\u0010P\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010RR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\r\u001a\u00060\u000ej\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010#\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR$\u0010&\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u000e\u0010)\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R!\u00101\u001a\b\u0012\u0004\u0012\u0002020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00100\u001a\u0004\b3\u0010.¨\u0006T"}, d2 = {"Lexpo/modules/webview/DomWebView;", "Lexpo/modules/kotlin/views/ExpoView;", "Landroid/view/View$OnTouchListener;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "webViewId", "", "Lexpo/modules/webview/WebViewId;", "getWebViewId", "()I", "source", "Lexpo/modules/webview/DomWebViewSource;", "injectedJS", "", "injectedJSBeforeContentLoaded", "rncWebViewBridge", "Lexpo/modules/webview/RNCWebViewBridge;", "value", "", "webviewDebuggingEnabled", "getWebviewDebuggingEnabled", "()Z", "setWebviewDebuggingEnabled", "(Z)V", "nestedScrollEnabled", "getNestedScrollEnabled", "setNestedScrollEnabled", "useExpoModulesBridge", "getUseExpoModulesBridge", "setUseExpoModulesBridge", "mediaPlaybackRequiresUserAction", "getMediaPlaybackRequiresUserAction", "setMediaPlaybackRequiresUserAction", "needsResetupScripts", "onMessage", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/webview/OnMessageEvent;", "getOnMessage", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onMessage$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onRenderProcessGone", "Lexpo/modules/webview/OnRenderProcessGoneEvent;", "getOnRenderProcessGone", "onRenderProcessGone$delegate", "reload", "", "forceReload", "onViewDestroys", "onViewDestroys$expo_dom_webview_release", "setSource", "setInjectedJS", "script", "setInjectedJSBeforeContentLoaded", "setInjectedJavaScriptObject", "injectJavaScript", "dispatchMessageEvent", "message", "evalSync", "data", "scrollTo", "param", "Lexpo/modules/webview/ScrollToParam;", "onTouch", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "createWebView", "createWebViewClient", "expo/modules/webview/DomWebView$createWebViewClient$1", "()Lexpo/modules/webview/DomWebView$createWebViewClient$1;", "nativeJsiEvalSync", "deferredId", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "expo-dom-webview_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DomWebView extends ExpoView implements View.OnTouchListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DomWebView.class, "onMessage", "getOnMessage()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(DomWebView.class, "onRenderProcessGone", "getOnRenderProcessGone()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    private static final Logger log = new Logger(CollectionsKt.listOf(LogHandlers.INSTANCE.createOSLogHandler("DomWebView")));
    private String injectedJS;
    private String injectedJSBeforeContentLoaded;
    private boolean needsResetupScripts;
    private boolean nestedScrollEnabled;

    /* JADX INFO: renamed from: onMessage$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMessage;

    /* JADX INFO: renamed from: onRenderProcessGone$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onRenderProcessGone;
    private final RNCWebViewBridge rncWebViewBridge;
    private DomWebViewSource source;
    private boolean useExpoModulesBridge;
    private final WebView webView;
    private final int webViewId;
    private boolean webviewDebuggingEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DomWebView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.webViewId = DomWebViewRegistry.INSTANCE.add(this);
        this.rncWebViewBridge = new RNCWebViewBridge(this);
        this.nestedScrollEnabled = true;
        DomWebView domWebView = this;
        this.onMessage = new ViewEventDelegate(domWebView, null);
        this.onRenderProcessGone = new ViewEventDelegate(domWebView, null);
        WebView webViewCreateWebView = createWebView();
        this.webView = webViewCreateWebView;
        addView(webViewCreateWebView, new ViewGroup.LayoutParams(-1, -1));
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public final int getWebViewId() {
        return this.webViewId;
    }

    public final boolean getWebviewDebuggingEnabled() {
        return this.webviewDebuggingEnabled;
    }

    public final void setWebviewDebuggingEnabled(boolean z) {
        this.webviewDebuggingEnabled = z;
        WebView.setWebContentsDebuggingEnabled(z);
    }

    public final boolean getNestedScrollEnabled() {
        return this.nestedScrollEnabled;
    }

    public final void setNestedScrollEnabled(boolean z) {
        this.nestedScrollEnabled = z;
    }

    public final boolean getUseExpoModulesBridge() {
        return this.useExpoModulesBridge;
    }

    public final void setUseExpoModulesBridge(boolean z) {
        if (this.useExpoModulesBridge == z) {
            return;
        }
        this.useExpoModulesBridge = z;
        this.needsResetupScripts = true;
    }

    public final boolean getMediaPlaybackRequiresUserAction() {
        return this.webView.getSettings().getMediaPlaybackRequiresUserGesture();
    }

    public final void setMediaPlaybackRequiresUserAction(boolean z) {
        this.webView.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    private final ViewEventCallback<OnMessageEvent> getOnMessage() {
        return this.onMessage.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewEventCallback<OnRenderProcessGoneEvent> getOnRenderProcessGone() {
        return this.onRenderProcessGone.getValue(this, $$delegatedProperties[1]);
    }

    public final void reload() {
        DomWebViewSource domWebViewSource = this.source;
        String uri = domWebViewSource != null ? domWebViewSource.getUri() : null;
        if (uri != null && !Intrinsics.areEqual(uri, this.webView.getUrl())) {
            this.needsResetupScripts = false;
            this.webView.loadUrl(uri);
        } else if (this.needsResetupScripts) {
            this.needsResetupScripts = false;
            this.webView.reload();
        }
    }

    public final void forceReload() {
        this.webView.post(new Runnable() { // from class: expo.modules.webview.DomWebView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DomWebView.forceReload$lambda$0(this.f$0);
            }
        });
    }

    static final void forceReload$lambda$0(DomWebView domWebView) {
        String uri;
        if (domWebView.webView.getUrl() != null) {
            domWebView.webView.reload();
            return;
        }
        DomWebViewSource domWebViewSource = domWebView.source;
        if (domWebViewSource == null || (uri = domWebViewSource.getUri()) == null) {
            return;
        }
        domWebView.webView.loadUrl(uri);
    }

    public final void onViewDestroys$expo_dom_webview_release() {
        this.webView.removeJavascriptInterface("ReactNativeWebView");
        this.webView.removeJavascriptInterface("ExpoDomWebViewBridge");
        removeAllViews();
        this.webView.destroy();
        DomWebViewRegistry.INSTANCE.remove(this.webViewId);
    }

    public final void setSource(DomWebViewSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    public final void setInjectedJS(String script) {
        String str;
        String str2 = script;
        if (str2 == null || str2.length() == 0) {
            str = null;
        } else {
            str = "(function() { " + script + "; })();true;";
        }
        this.injectedJS = str;
        this.needsResetupScripts = true;
    }

    public final void setInjectedJSBeforeContentLoaded(String script) {
        String str;
        String str2 = script;
        if (str2 == null || str2.length() == 0) {
            str = null;
        } else {
            str = "(function() { " + script + "; })();true;";
        }
        this.injectedJSBeforeContentLoaded = str;
        this.needsResetupScripts = true;
    }

    public final void setInjectedJavaScriptObject(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.rncWebViewBridge.setInjectedObjectJson(source);
    }

    public final void injectJavaScript(final String script) {
        Intrinsics.checkNotNullParameter(script, "script");
        this.webView.post(new Runnable() { // from class: expo.modules.webview.DomWebView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.webView.evaluateJavascript(script, null);
            }
        });
    }

    public final void dispatchMessageEvent(final String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.webView.post(new Runnable() { // from class: expo.modules.webview.DomWebView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                DomWebView.dispatchMessageEvent$lambda$0(this.f$0, message);
            }
        });
    }

    static final void dispatchMessageEvent$lambda$0(DomWebView domWebView, String str) {
        String title = domWebView.webView.getTitle();
        if (title == null) {
            title = "";
        }
        String url = domWebView.webView.getUrl();
        domWebView.getOnMessage().invoke(new OnMessageEvent(title, url != null ? url : "", str));
    }

    public final String evalSync(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!this.useExpoModulesBridge) {
            return "{\"isPromise\":false,\"value\":null}";
        }
        JSONObject jSONObject = new JSONObject(data);
        return (String) BuildersKt__BuildersKt.runBlocking$default(null, new C09441(jSONObject.getInt("deferredId"), jSONObject.getString("source"), null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.webview.DomWebView$evalSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DomWebView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.webview.DomWebView$evalSync$1", f = "DomWebView.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C09441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ int $deferredId;
        final /* synthetic */ String $source;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09441(int i, String str, Continuation<? super C09441> continuation) {
            super(2, continuation);
            this.$deferredId = i;
            this.$source = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DomWebView.this.new C09441(this.$deferredId, this.$source, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C09441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            DomWebView domWebView = DomWebView.this;
            int i2 = this.$deferredId;
            String str = this.$source;
            Intrinsics.checkNotNull(str);
            this.label = 1;
            Object objNativeJsiEvalSync = domWebView.nativeJsiEvalSync(i2, str, this);
            return objNativeJsiEvalSync == coroutine_suspended ? coroutine_suspended : objNativeJsiEvalSync;
        }
    }

    public final void scrollTo(final ScrollToParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.webView.post(new Runnable() { // from class: expo.modules.webview.DomWebView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DomWebView.scrollTo$lambda$0(param, this);
            }
        });
    }

    static final void scrollTo$lambda$0(ScrollToParam scrollToParam, DomWebView domWebView) {
        if (!scrollToParam.getAnimated()) {
            domWebView.webView.scrollTo((int) scrollToParam.getX(), (int) scrollToParam.getY());
            return;
        }
        WebView webView = domWebView.webView;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(webView, "scrollX", webView.getScrollX(), (int) scrollToParam.getX());
        objectAnimatorOfInt.setDuration(250L);
        WebView webView2 = domWebView.webView;
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(webView2, "scrollY", webView2.getScrollY(), (int) scrollToParam.getY());
        objectAnimatorOfInt2.setDuration(250L);
        objectAnimatorOfInt.start();
        objectAnimatorOfInt2.start();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        if (!this.nestedScrollEnabled) {
            return false;
        }
        requestDisallowInterceptTouchEvent(true);
        return false;
    }

    private final WebView createWebView() {
        WebView webView = new WebView(getContext());
        webView.setBackgroundColor(0);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.setWebViewClient(createWebViewClient());
        webView.addJavascriptInterface(this.rncWebViewBridge, "ReactNativeWebView");
        webView.addJavascriptInterface(new DomWebViewBridge(this), "ExpoDomWebViewBridge");
        webView.setOnTouchListener(this);
        return webView;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [expo.modules.webview.DomWebView$createWebViewClient$1] */
    private final AnonymousClass1 createWebViewClient() {
        return new WebViewClient() { // from class: expo.modules.webview.DomWebView.createWebViewClient.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (DomWebView.this.getUseExpoModulesBridge() && view != null) {
                    view.evaluateJavascript(StringsKt.replace$default(DomWebViewBrowserScriptsKt.INSTALL_GLOBALS_SCRIPT, "\"%%WEBVIEW_ID%%\"", String.valueOf(DomWebView.this.getWebViewId()), false, 4, (Object) null), null);
                }
                String str = DomWebView.this.injectedJSBeforeContentLoaded;
                if (str == null || view == null) {
                    return;
                }
                view.evaluateJavascript(str, null);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String str = DomWebView.this.injectedJS;
                if (str != null) {
                    DomWebView.this.injectJavaScript(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return false;
                }
                boolean zDidCrash = detail != null ? detail.didCrash() : false;
                if (zDidCrash) {
                    Logger.error$default(DomWebView.log, "The WebView rendering process crashed.", null, 2, null);
                } else {
                    Logger.warn$default(DomWebView.log, "The WebView rendering process was killed by the system.", null, 2, null);
                }
                if (view == null) {
                    return true;
                }
                ViewEventCallback onRenderProcessGone = DomWebView.this.getOnRenderProcessGone();
                String url = view.getUrl();
                if (url == null) {
                    url = "";
                }
                String title = view.getTitle();
                onRenderProcessGone.invoke(new OnRenderProcessGoneEvent(url, title != null ? title : "", zDidCrash));
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object nativeJsiEvalSync(final int i, final String str, Continuation<? super String> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        getAppContext().executeOnJavaScriptThread(new Runnable() { // from class: expo.modules.webview.DomWebView$nativeJsiEvalSync$2$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JavaScriptValue javaScriptValueEval = this.getAppContext().getRuntime().eval(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(DomWebViewBrowserScriptsKt.NATIVE_EVAL_WRAPPER_SCRIPT, "\"%%DEFERRED_ID%%\"", String.valueOf(i), false, 4, (Object) null), "\"%%WEBVIEW_ID%%\"", String.valueOf(this.getWebViewId()), false, 4, (Object) null), "\"%%SOURCE%%\"", str, false, 4, (Object) null));
                    Continuation<String> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m12684constructorimpl(javaScriptValueEval.getString()));
                } catch (Exception e) {
                    Continuation<String> continuation3 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(e)));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
