package com.datadog.android.trace;

import com.datadog.android.api.instrumentation.network.HttpRequestInfo;
import com.datadog.android.api.instrumentation.network.HttpResponseInfo;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.trace.api.span.DatadogSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpNetworkTracedRequestListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/datadog/android/trace/NoOpNetworkTracedRequestListener;", "Lcom/datadog/android/trace/NetworkTracedRequestListener;", "()V", "onRequestIntercepted", "", "request", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "response", "Lcom/datadog/android/api/instrumentation/network/HttpResponseInfo;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpNetworkTracedRequestListener implements NetworkTracedRequestListener {
    @Override // com.datadog.android.trace.NetworkTracedRequestListener
    public void onRequestIntercepted(HttpRequestInfo request, DatadogSpan span, HttpResponseInfo response, Throwable throwable) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(span, "span");
    }
}
