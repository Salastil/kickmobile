package com.datadog.android.webview.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpWebViewEventConsumer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/webview/internal/NoOpWebViewEventConsumer;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "()V", "consume", "", "event", "(Ljava/lang/Object;)V", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpWebViewEventConsumer<T> implements WebViewEventConsumer<T> {
    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public void consume(T event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }
}
