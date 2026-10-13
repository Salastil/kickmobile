package com.datadog.android.internal.profiler;

import kotlin.Metadata;

/* JADX INFO: compiled from: NoOpBenchmarkSpanBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/internal/profiler/NoOpBenchmarkSpanBuilder;", "Lcom/datadog/android/internal/profiler/BenchmarkSpanBuilder;", "()V", "startSpan", "Lcom/datadog/android/internal/profiler/BenchmarkSpan;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpBenchmarkSpanBuilder implements BenchmarkSpanBuilder {
    @Override // com.datadog.android.internal.profiler.BenchmarkSpanBuilder
    public BenchmarkSpan startSpan() {
        return new NoOpBenchmarkSpan();
    }
}
