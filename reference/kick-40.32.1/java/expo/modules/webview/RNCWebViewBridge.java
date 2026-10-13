package expo.modules.webview;

import android.webkit.JavascriptInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNCWebViewBridge.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lexpo/modules/webview/RNCWebViewBridge;", "", "webView", "Lexpo/modules/webview/DomWebView;", "<init>", "(Lexpo/modules/webview/DomWebView;)V", "injectedObjectJson", "", "getInjectedObjectJson", "()Ljava/lang/String;", "setInjectedObjectJson", "(Ljava/lang/String;)V", "postMessage", "", "message", "expo-dom-webview_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNCWebViewBridge {
    private String injectedObjectJson;
    private final DomWebView webView;

    public RNCWebViewBridge(DomWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
        this.injectedObjectJson = "{}";
    }

    public final String getInjectedObjectJson() {
        return this.injectedObjectJson;
    }

    public final void setInjectedObjectJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.injectedObjectJson = str;
    }

    @JavascriptInterface
    public final void postMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.webView.dispatchMessageEvent(message);
    }

    @JavascriptInterface
    public final String injectedObjectJson() {
        return this.injectedObjectJson;
    }
}
