package com.datadog.android.api.feature;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.core.internal.SdkFeature;
import com.datadog.android.core.metrics.PerformanceMetric;
import com.datadog.android.core.metrics.TelemetryMetricType;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureScopeExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007\u001aC\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\b0\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"getContextFuture", "Ljava/util/concurrent/Future;", "Lcom/datadog/android/api/context/DatadogContext;", "Lcom/datadog/android/api/feature/FeatureScope;", "withFeatureContexts", "", "", "measureMethodCallPerf", "R", "Lcom/datadog/android/api/InternalLogger;", "callerClass", "Ljava/lang/Class;", "operationName", "samplingRate", "", "operation", "Lkotlin/Function0;", "(Lcom/datadog/android/api/InternalLogger;Ljava/lang/Class;Ljava/lang/String;FLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FeatureScopeExtKt {
    public static /* synthetic */ Object measureMethodCallPerf$default(InternalLogger internalLogger, Class cls, String str, float f, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 100.0f;
        }
        return measureMethodCallPerf(internalLogger, cls, str, f, function0);
    }

    public static final <R> R measureMethodCallPerf(InternalLogger internalLogger, Class<?> callerClass, String operationName, float f, Function0<? extends R> operation) {
        Intrinsics.checkNotNullParameter(internalLogger, "<this>");
        Intrinsics.checkNotNullParameter(callerClass, "callerClass");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(operation, "operation");
        String name = callerClass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "callerClass.name");
        PerformanceMetric performanceMetricStartPerformanceMeasure = internalLogger.startPerformanceMeasure(name, TelemetryMetricType.MethodCalled, f, operationName);
        R rInvoke = operation.invoke();
        boolean z = (rInvoke == null || ((rInvoke instanceof Collection) && ((Collection) rInvoke).isEmpty())) ? false : true;
        if (performanceMetricStartPerformanceMeasure != null) {
            performanceMetricStartPerformanceMeasure.stopAndSend(z);
        }
        return rInvoke;
    }

    public static /* synthetic */ Future getContextFuture$default(FeatureScope featureScope, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = SetsKt.emptySet();
        }
        return getContextFuture(featureScope, set);
    }

    public static final Future<DatadogContext> getContextFuture(FeatureScope featureScope, Set<String> withFeatureContexts) {
        Intrinsics.checkNotNullParameter(featureScope, "<this>");
        Intrinsics.checkNotNullParameter(withFeatureContexts, "withFeatureContexts");
        if (featureScope instanceof SdkFeature) {
            return ((SdkFeature) featureScope).getContextFuture$dd_sdk_android_core_release(withFeatureContexts);
        }
        return null;
    }
}
