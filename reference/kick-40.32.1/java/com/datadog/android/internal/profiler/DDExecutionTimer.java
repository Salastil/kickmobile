package com.datadog.android.internal.profiler;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.internal.time.TimeProvider;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DDExecutionTimer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0016¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/internal/profiler/DDExecutionTimer;", "Lcom/datadog/android/internal/profiler/ExecutionTimer;", "track", "", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "benchmarkSdkUploads", "Lcom/datadog/android/internal/profiler/BenchmarkSdkUploads;", "(Ljava/lang/String;Lcom/datadog/android/internal/time/TimeProvider;Lcom/datadog/android/internal/profiler/BenchmarkSdkUploads;)V", "measure", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "responseLatencyReport", "", "latencySeconds", "", "Companion", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DDExecutionTimer implements ExecutionTimer {
    private static final String BENCHMARK_RESPONSE_LATENCY = "android.benchmark.response_latency";
    private static final Companion Companion = new Companion(null);
    private static final String METER_NAME = "dd-sdk-android";
    private static final double NANOSECONDS_IN_A_SECOND = 1.0E9d;
    private static final String TRACK_NAME = "track";
    private final BenchmarkSdkUploads benchmarkSdkUploads;
    private final TimeProvider timeProvider;
    private final String track;

    public DDExecutionTimer(String track, TimeProvider timeProvider, BenchmarkSdkUploads benchmarkSdkUploads) {
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(benchmarkSdkUploads, "benchmarkSdkUploads");
        this.track = track;
        this.timeProvider = timeProvider;
        this.benchmarkSdkUploads = benchmarkSdkUploads;
    }

    public /* synthetic */ DDExecutionTimer(String str, TimeProvider timeProvider, BenchmarkSdkUploads benchmarkSdkUploads, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, timeProvider, (i & 4) != 0 ? GlobalBenchmark.INSTANCE.getBenchmarkSdkUploads() : benchmarkSdkUploads);
    }

    @Override // com.datadog.android.internal.profiler.ExecutionTimer
    public <T> T measure(Function0<? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.track.length() == 0) {
            return action.invoke();
        }
        long deviceElapsedTimeNanos = this.timeProvider.getDeviceElapsedTimeNanos();
        T tInvoke = action.invoke();
        responseLatencyReport((this.timeProvider.getDeviceElapsedTimeNanos() - deviceElapsedTimeNanos) / NANOSECONDS_IN_A_SECOND, this.track);
        return tInvoke;
    }

    private final void responseLatencyReport(final double latencySeconds, String track) {
        this.benchmarkSdkUploads.getMeter("dd-sdk-android").createObservableGauge(BENCHMARK_RESPONSE_LATENCY, MapsKt.mapOf(TuplesKt.to("track", track)), new Function0<Double>() { // from class: com.datadog.android.internal.profiler.DDExecutionTimer.responseLatencyReport.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                return Double.valueOf(latencySeconds);
            }
        });
    }

    /* JADX INFO: compiled from: DDExecutionTimer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/datadog/android/internal/profiler/DDExecutionTimer$Companion;", "", "()V", "BENCHMARK_RESPONSE_LATENCY", "", "METER_NAME", "NANOSECONDS_IN_A_SECOND", "", "TRACK_NAME", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
