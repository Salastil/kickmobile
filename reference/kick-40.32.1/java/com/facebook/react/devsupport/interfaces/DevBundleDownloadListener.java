package com.facebook.react.devsupport.interfaces;

import kotlin.Metadata;

/* JADX INFO: compiled from: DevBundleDownloadListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J5\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/interfaces/DevBundleDownloadListener;", "", "onSuccess", "", "onProgress", "status", "", "done", "", "total", "percent", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onFailure", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DevBundleDownloadListener {
    void onFailure(Exception cause);

    void onProgress(String status, Integer done, Integer total, Integer percent);

    void onSuccess();
}
