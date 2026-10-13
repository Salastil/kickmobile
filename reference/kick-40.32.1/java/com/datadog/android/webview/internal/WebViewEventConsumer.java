package com.datadog.android.webview.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: WebViewEventConsumer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\ba\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/webview/internal/WebViewEventConsumer;", ExifInterface.GPS_DIRECTION_TRUE, "", "consume", "", "event", "(Ljava/lang/Object;)V", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface WebViewEventConsumer<T> {
    void consume(T event);
}
