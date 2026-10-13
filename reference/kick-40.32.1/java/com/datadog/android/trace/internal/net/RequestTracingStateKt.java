package com.datadog.android.trace.internal.net;

import com.datadog.android.trace.api.span.DatadogSpan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequestTracingState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a4\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"ALL_IN_SAMPLE_RATE", "", "ZERO_SAMPLE_RATE", "toAttributesMap", "", "", "", "Lcom/datadog/android/trace/internal/net/RequestTracingState;", "traceIdKey", "spanIdKey", "rulePsrKey", "dd-sdk-android-trace_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RequestTracingStateKt {
    public static final float ALL_IN_SAMPLE_RATE = 100.0f;
    public static final float ZERO_SAMPLE_RATE = 0.0f;

    public static final Map<String, Object> toAttributesMap(RequestTracingState requestTracingState, String traceIdKey, String spanIdKey, String rulePsrKey) {
        DatadogSpan span;
        Intrinsics.checkNotNullParameter(traceIdKey, "traceIdKey");
        Intrinsics.checkNotNullParameter(spanIdKey, "spanIdKey");
        Intrinsics.checkNotNullParameter(rulePsrKey, "rulePsrKey");
        Map<String, Object> mapBuild = null;
        if (requestTracingState != null && (span = requestTracingState.getSpan()) != null) {
            if (!requestTracingState.isSampled()) {
                span = null;
            }
            if (span != null) {
                Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                mapCreateMapBuilder.put(traceIdKey, span.context().getTraceId().toHexString());
                mapCreateMapBuilder.put(spanIdKey, String.valueOf(span.context().getSpanId()));
                Float sampleRate = requestTracingState.getSampleRate();
                mapCreateMapBuilder.put(rulePsrKey, Float.valueOf((sampleRate != null ? sampleRate.floatValue() : 0.0f) / 100.0f));
                mapBuild = MapsKt.build(mapCreateMapBuilder);
            }
        }
        return mapBuild == null ? MapsKt.emptyMap() : mapBuild;
    }
}
