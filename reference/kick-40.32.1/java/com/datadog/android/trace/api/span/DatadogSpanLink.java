package com.datadog.android.trace.api.span;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.trace.api.trace.DatadogTraceId;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatadogSpanLink.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R \u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/trace/api/span/DatadogSpanLink;", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "getAttributes", "()Ljava/util/Map;", "sampled", "", "getSampled", "()Z", "spanId", "", "getSpanId", "()J", "traceId", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "getTraceId", "()Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "traceStrace", "getTraceStrace", "()Ljava/lang/String;", "dd-sdk-android-trace-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DatadogSpanLink {
    Map<String, String> getAttributes();

    boolean getSampled();

    long getSpanId();

    DatadogTraceId getTraceId();

    String getTraceStrace();
}
