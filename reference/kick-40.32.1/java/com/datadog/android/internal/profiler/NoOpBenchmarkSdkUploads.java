package com.datadog.android.internal.profiler;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpBenchmarkSdkUploads.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/internal/profiler/NoOpBenchmarkSdkUploads;", "Lcom/datadog/android/internal/profiler/BenchmarkSdkUploads;", "()V", "getMeter", "Lcom/datadog/android/internal/profiler/BenchmarkMeter;", "operation", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpBenchmarkSdkUploads implements BenchmarkSdkUploads {
    @Override // com.datadog.android.internal.profiler.BenchmarkSdkUploads
    public BenchmarkMeter getMeter(String operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new NoOpBenchmarkMeter();
    }
}
