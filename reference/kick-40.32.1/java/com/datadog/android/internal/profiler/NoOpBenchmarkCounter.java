package com.datadog.android.internal.profiler;

import com.datadog.android.rum.internal.RumFeature;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpBenchmarkCounter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, d2 = {"Lcom/datadog/android/internal/profiler/NoOpBenchmarkCounter;", "Lcom/datadog/android/internal/profiler/BenchmarkCounter;", "()V", "add", "", "value", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpBenchmarkCounter implements BenchmarkCounter {
    @Override // com.datadog.android.internal.profiler.BenchmarkCounter
    public void add(long value, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }
}
