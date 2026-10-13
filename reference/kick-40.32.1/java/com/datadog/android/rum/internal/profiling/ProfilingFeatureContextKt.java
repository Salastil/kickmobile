package com.datadog.android.rum.internal.profiling;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.internal.FeatureContextKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfilingFeatureContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¨\u0006\u0006"}, d2 = {"isProfilerRunning", "", "Lcom/datadog/android/api/context/DatadogContext;", "resolveProfilingQuotaReason", "", "currentSessionId", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProfilingFeatureContextKt {
    public static final boolean isProfilerRunning(DatadogContext datadogContext) {
        Intrinsics.checkNotNullParameter(datadogContext, "<this>");
        Map<String, Object> map = datadogContext.getFeaturesContext().get("profiling");
        if (map != null) {
            return Intrinsics.areEqual(map.get(FeatureContextKeys.PROFILER_IS_RUNNING), (Object) true);
        }
        return false;
    }

    public static final String resolveProfilingQuotaReason(DatadogContext datadogContext, String str) {
        Intrinsics.checkNotNullParameter(datadogContext, "<this>");
        Map<String, Object> map = datadogContext.getFeaturesContext().get("profiling");
        if (map == null) {
            return null;
        }
        Object obj = map.get(FeatureContextKeys.PROFILING_QUOTA_REASON);
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 == null) {
            return null;
        }
        Object obj2 = map.get(FeatureContextKeys.PROFILING_QUOTA_SESSION_ID);
        String str3 = obj2 instanceof String ? (String) obj2 : null;
        if (str3 == null || !Intrinsics.areEqual(str3, str)) {
            return null;
        }
        return str2;
    }
}
