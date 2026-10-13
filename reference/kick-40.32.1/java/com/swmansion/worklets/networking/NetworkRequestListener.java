package com.swmansion.worklets.networking;

import com.facebook.jni.HybridData;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;

/* JADX INFO: compiled from: NetworkRequestListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086 ¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0086 J\u0019\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0086 J\u0011\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0086 J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000bH\u0086 R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/swmansion/worklets/networking/NetworkRequestListener;", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "onResponse", "", "status", "", "statusText", "", "headerNames", "", "headerValues", ImagesContract.URL, "(ILjava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "onUploadProgress", "sent", "", "total", "onDownloadProgress", "received", "onComplete", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "onError", "errorCode", "message", "react-native-worklets_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NetworkRequestListener {
    private final HybridData mHybridData;

    public final native void onComplete(byte[] body);

    public final native void onDownloadProgress(long received, long total);

    public final native void onError(int errorCode, String message);

    public final native void onResponse(int status, String statusText, String[] headerNames, String[] headerValues, String url);

    public final native void onUploadProgress(long sent, long total);

    private NetworkRequestListener(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
