package com.datadog.android.internal.profiler;

import com.datadog.android.internal.time.TimeProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlobalBenchmark.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/internal/profiler/GlobalBenchmark;", "", "()V", "benchmarkProfiler", "Lcom/datadog/android/internal/profiler/BenchmarkProfiler;", "benchmarkSdkUploads", "Lcom/datadog/android/internal/profiler/BenchmarkSdkUploads;", "createExecutionTimer", "Lcom/datadog/android/internal/profiler/ExecutionTimer;", "track", "", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "getBenchmarkSdkUploads", "getProfiler", "register", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlobalBenchmark {
    public static final GlobalBenchmark INSTANCE = new GlobalBenchmark();
    private static BenchmarkProfiler benchmarkProfiler = new NoOpBenchmarkProfiler();
    private static BenchmarkSdkUploads benchmarkSdkUploads = new NoOpBenchmarkSdkUploads();

    private GlobalBenchmark() {
    }

    public final void register(BenchmarkProfiler benchmarkProfiler2) {
        Intrinsics.checkNotNullParameter(benchmarkProfiler2, "benchmarkProfiler");
        benchmarkProfiler = benchmarkProfiler2;
    }

    public final void register(BenchmarkSdkUploads benchmarkSdkUploads2) {
        Intrinsics.checkNotNullParameter(benchmarkSdkUploads2, "benchmarkSdkUploads");
        benchmarkSdkUploads = benchmarkSdkUploads2;
    }

    public final BenchmarkProfiler getProfiler() {
        return benchmarkProfiler;
    }

    public final BenchmarkSdkUploads getBenchmarkSdkUploads() {
        return benchmarkSdkUploads;
    }

    public final ExecutionTimer createExecutionTimer(String track, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        if (benchmarkSdkUploads instanceof NoOpBenchmarkSdkUploads) {
            return new NoOpExecutionTimer();
        }
        return new DDExecutionTimer(track, timeProvider, null, 4, null);
    }
}
