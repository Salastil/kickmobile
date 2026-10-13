package com.iab.omid.library.amazon2.publisher;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes8.dex */
public class a extends AdSessionStatePublisher {
    public a(String str, WebView webView) {
        super(str);
        if (webView != null) {
            com.iab.omid.library.amazon2.webviewclient.a.a(webView);
        }
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
