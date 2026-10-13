package com.datadog.android.internal.profiler;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpBenchmarkTracer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0016¨\u0006\t"}, d2 = {"Lcom/datadog/android/internal/profiler/NoOpBenchmarkTracer;", "Lcom/datadog/android/internal/profiler/BenchmarkTracer;", "()V", "spanBuilder", "Lcom/datadog/android/internal/profiler/BenchmarkSpanBuilder;", "spanName", "", "additionalProperties", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpBenchmarkTracer implements BenchmarkTracer {
    @Override // com.datadog.android.internal.profiler.BenchmarkTracer
    public BenchmarkSpanBuilder spanBuilder(String spanName, Map<String, String> additionalProperties) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
        return new NoOpBenchmarkSpanBuilder();
    }
}
