package com.datadog.android.trace.internal;

import com.datadog.android.api.feature.FeatureSdkCore;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureSdkCoreExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\f\u0010\t\u001a\u00020\u0005*\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"SPAN_ID_KEY", "", "TRACE_ID_KEY", "resolveActiveTraceContextName", "addActiveTraceToContext", "", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "traceId", "spanId", "removeActiveTraceFromContext", "dd-sdk-android-trace_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FeatureSdkCoreExtKt {
    private static final String SPAN_ID_KEY = "span_id";
    private static final String TRACE_ID_KEY = "trace_id";

    public static final void addActiveTraceToContext(FeatureSdkCore featureSdkCore, final String traceId, final String spanId) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "<this>");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        final String strResolveActiveTraceContextName = resolveActiveTraceContextName();
        FeatureSdkCore.DefaultImpls.updateFeatureContext$default(featureSdkCore, "tracing", false, new Function1<Map<String, Object>, Unit>() { // from class: com.datadog.android.trace.internal.FeatureSdkCoreExtKt.addActiveTraceToContext.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.put(strResolveActiveTraceContextName, MapsKt.mapOf(TuplesKt.to(FeatureSdkCoreExtKt.SPAN_ID_KEY, spanId), TuplesKt.to(FeatureSdkCoreExtKt.TRACE_ID_KEY, traceId)));
            }
        }, 2, null);
    }

    public static final void removeActiveTraceFromContext(FeatureSdkCore featureSdkCore) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "<this>");
        final String strResolveActiveTraceContextName = resolveActiveTraceContextName();
        FeatureSdkCore.DefaultImpls.updateFeatureContext$default(featureSdkCore, "tracing", false, new Function1<Map<String, Object>, Unit>() { // from class: com.datadog.android.trace.internal.FeatureSdkCoreExtKt.removeActiveTraceFromContext.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.remove(strResolveActiveTraceContextName);
            }
        }, 2, null);
    }

    private static final String resolveActiveTraceContextName() {
        return "context@" + Thread.currentThread().getName();
    }
}
