package com.datadog.android.core.internal.metrics;

import com.datadog.android.internal.profiler.BenchmarkSdkUploads;
import com.datadog.android.internal.profiler.GlobalBenchmark;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BenchmarkUploads.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0011J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/core/internal/metrics/BenchmarkUploads;", "", "benchmarkSdkUploads", "Lcom/datadog/android/internal/profiler/BenchmarkSdkUploads;", "(Lcom/datadog/android/internal/profiler/BenchmarkSdkUploads;)V", "incrementBenchmarkUploadsCount", "", "featureName", "", "incrementBenchmarkUploadsCount$dd_sdk_android_core_release", "sendBenchmarkBytesDeleted", "value", "", "sendBenchmarkBytesDeleted$dd_sdk_android_core_release", "sendBenchmarkBytesUploaded", "sendBenchmarkBytesUploaded$dd_sdk_android_core_release", "sendBenchmarkBytesWritten", "sendBenchmarkBytesWritten$dd_sdk_android_core_release", "sendBenchmarkUploads", "metricName", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BenchmarkUploads {
    public static final String BENCHMARK_BYTES_DELETED = "android.benchmark.bytes_deleted";
    public static final String BENCHMARK_BYTES_UPLOADED = "android.benchmark.bytes_uploaded";
    public static final String BENCHMARK_BYTES_WRITTEN = "android.benchmark.bytes_written";
    public static final String BENCHMARK_UPLOAD_COUNT = "android.benchmark.upload_count";
    private static final String METER_NAME = "dd-sdk-android";
    private static final String TRACK_NAME = "track";
    private final BenchmarkSdkUploads benchmarkSdkUploads;

    /* JADX WARN: Multi-variable type inference failed */
    public BenchmarkUploads() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BenchmarkUploads(BenchmarkSdkUploads benchmarkSdkUploads) {
        Intrinsics.checkNotNullParameter(benchmarkSdkUploads, "benchmarkSdkUploads");
        this.benchmarkSdkUploads = benchmarkSdkUploads;
    }

    public /* synthetic */ BenchmarkUploads(BenchmarkSdkUploads benchmarkSdkUploads, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalBenchmark.INSTANCE.getBenchmarkSdkUploads() : benchmarkSdkUploads);
    }

    public final void sendBenchmarkBytesUploaded$dd_sdk_android_core_release(String featureName, long value) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        sendBenchmarkUploads(featureName, BENCHMARK_BYTES_UPLOADED, value);
    }

    public final void sendBenchmarkBytesDeleted$dd_sdk_android_core_release(String featureName, long value) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        sendBenchmarkUploads(featureName, BENCHMARK_BYTES_DELETED, value);
    }

    public final void sendBenchmarkBytesWritten$dd_sdk_android_core_release(String featureName, long value) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        sendBenchmarkUploads(featureName, BENCHMARK_BYTES_WRITTEN, value);
    }

    public final void incrementBenchmarkUploadsCount$dd_sdk_android_core_release(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        sendBenchmarkUploads(featureName, BENCHMARK_UPLOAD_COUNT, 1L);
    }

    private final void sendBenchmarkUploads(String featureName, String metricName, long value) {
        this.benchmarkSdkUploads.getMeter("dd-sdk-android").getCounter(metricName).add(value, MapsKt.mapOf(TuplesKt.to("track", featureName)));
    }
}
