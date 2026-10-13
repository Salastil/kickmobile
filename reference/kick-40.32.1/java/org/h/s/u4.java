package org.h.s;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u4 extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView window) {
        Intrinsics.checkNotNullParameter(window, "window");
        LocalLogger.log(16, 22508L, null);
        super.onCloseWindow(window);
    }

    @Override // android.webkit.WebChromeClient
    public final void onConsoleMessage(String message, int i, String sourceID) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sourceID, "sourceID");
        LocalLogger.log(16, 22520L, null);
        super.onConsoleMessage(message, i, sourceID);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView view, boolean z, boolean z2, Message resultMsg) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        LocalLogger.log(16, 22506L, null);
        return super.onCreateWindow(view, z, z2, resultMsg);
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String url, String databaseIdentifier, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(databaseIdentifier, "databaseIdentifier");
        Intrinsics.checkNotNullParameter(quotaUpdater, "quotaUpdater");
        LocalLogger.log(16, 22513L, null);
        super.onExceededDatabaseQuota(url, databaseIdentifier, j, j2, j3, quotaUpdater);
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        LocalLogger.log(16, 22516L, null);
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LocalLogger.log(16, 22515L, null);
        super.onGeolocationPermissionsShowPrompt(origin, callback);
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        LocalLogger.log(16, 22505L, null);
        super.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        LocalLogger.log(16, 22509L, null);
        return super.onJsAlert(view, url, message, result);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        LocalLogger.log(16, 22512L, null);
        return super.onJsBeforeUnload(view, url, message, result);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        LocalLogger.log(16, 22510L, null);
        return super.onJsConfirm(view, url, message, result);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(result, "result");
        LocalLogger.log(16, 22511L, null);
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsTimeout() {
        LocalLogger.log(16, 22519L, null);
        return super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LocalLogger.log(16, 22517L, null);
        super.onPermissionRequest(request);
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LocalLogger.log(16, 22518L, null);
        super.onPermissionRequestCanceled(request);
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onProgressChanged(view, i);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedIcon(WebView view, Bitmap icon) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(icon, "icon");
        LocalLogger.log(16, 22501L, null);
        super.onReceivedIcon(view, icon);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView view, String title) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(title, "title");
        LocalLogger.log(16, 22500L, null);
        super.onReceivedTitle(view, title);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTouchIconUrl(WebView view, String url, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        LocalLogger.log(16, 22502L, null);
        super.onReceivedTouchIconUrl(view, url, z);
    }

    @Override // android.webkit.WebChromeClient
    public final void onRequestFocus(WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LocalLogger.log(16, 22507L, null);
        super.onRequestFocus(view);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LocalLogger.log(16, 22503L, null);
        super.onShowCustomView(view, callback);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Intrinsics.checkNotNullParameter(consoleMessage, "consoleMessage");
        LocalLogger.log(16, 22521L, t4.a(consoleMessage.message()) + "- " + consoleMessage.lineNumber() + " of " + t4.a(consoleMessage.sourceId()));
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LocalLogger.log(16, 22504L, null);
        super.onShowCustomView(view, i, callback);
    }
}
