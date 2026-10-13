package com.datadog.android.internal.profiler;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpBenchmarkMeter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/internal/profiler/NoOpBenchmarkMeter;", "Lcom/datadog/android/internal/profiler/BenchmarkMeter;", "()V", "createObservableGauge", "", "metricName", "", "tags", "", "callback", "Lkotlin/Function0;", "", "getCounter", "Lcom/datadog/android/internal/profiler/BenchmarkCounter;", "operation", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpBenchmarkMeter implements BenchmarkMeter {
    @Override // com.datadog.android.internal.profiler.BenchmarkMeter
    public void createObservableGauge(String metricName, Map<String, String> tags, Function0<Double> callback) {
        Intrinsics.checkNotNullParameter(metricName, "metricName");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.datadog.android.internal.profiler.BenchmarkMeter
    public BenchmarkCounter getCounter(String operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new NoOpBenchmarkCounter();
    }
}
