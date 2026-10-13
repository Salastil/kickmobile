package com.datadog.android.trace.internal;

import com.datadog.android.trace.api.trace.DatadogTraceId;
import com.datadog.trace.api.DDTraceId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogTraceExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"fromHex", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "Lcom/datadog/android/trace/api/trace/DatadogTraceId$Companion;", "traceId", "", "dd-sdk-android-trace_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DatadogTraceExtKt {
    public static final DatadogTraceId fromHex(DatadogTraceId.Companion companion, String traceId) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        DDTraceId dDTraceIdFromHex = DDTraceId.fromHex(traceId);
        Intrinsics.checkNotNullExpressionValue(dDTraceIdFromHex, "fromHex(traceId)");
        return new DatadogTraceIdAdapter(dDTraceIdFromHex);
    }
}
