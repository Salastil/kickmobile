package com.datadog.android.trace.internal;

import com.datadog.android.trace.api.span.DatadogSpanLink;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.bootstrap.instrumentation.api.SpanLink;
import com.datadog.trace.bootstrap.instrumentation.api.SpanLinkAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogSpanLinkAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogSpanLinkAdapter;", "Lcom/datadog/trace/bootstrap/instrumentation/api/SpanLink;", "delegate", "Lcom/datadog/android/trace/api/span/DatadogSpanLink;", "(Lcom/datadog/android/trace/api/span/DatadogSpanLink;)V", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogSpanLinkAdapter extends SpanLink {
    /* JADX WARN: Illegal instructions before constructor call */
    public DatadogSpanLinkAdapter(DatadogSpanLink delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        DDTraceId dDTraceIdFromHex = DDTraceId.fromHex(delegate.getTraceId().toHexString());
        long spanId = delegate.getSpanId();
        boolean sampled = delegate.getSampled();
        super(dDTraceIdFromHex, spanId, sampled ? (byte) 1 : (byte) 0, delegate.getTraceStrace(), SpanLinkAttributes.fromMap(delegate.getAttributes()));
    }
}
