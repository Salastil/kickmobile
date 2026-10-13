package com.datadog.android.internal.profiler;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BenchmarkMeter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/internal/profiler/BenchmarkMeter;", "", "createObservableGauge", "", "metricName", "", "tags", "", "callback", "Lkotlin/Function0;", "", "getCounter", "Lcom/datadog/android/internal/profiler/BenchmarkCounter;", "operation", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BenchmarkMeter {
    void createObservableGauge(String metricName, Map<String, String> tags, Function0<Double> callback);

    BenchmarkCounter getCounter(String operation);
}
