package com.datadog.android.trace;

import com.datadog.android.api.instrumentation.network.HttpRequestInfo;
import com.datadog.android.api.instrumentation.network.HttpResponseInfo;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.trace.api.span.DatadogSpan;
import kotlin.Metadata;

/* JADX INFO: compiled from: NetworkTracedRequestListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/datadog/android/trace/NetworkTracedRequestListener;", "", "onRequestIntercepted", "", "request", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "span", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "response", "Lcom/datadog/android/api/instrumentation/network/HttpResponseInfo;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface NetworkTracedRequestListener {
    void onRequestIntercepted(HttpRequestInfo request, DatadogSpan span, HttpResponseInfo response, Throwable throwable);
}
