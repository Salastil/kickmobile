package com.datadog.android.internal.profiler;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BenchmarkSpanExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00010\u0007¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"withinBenchmarkSpan", ExifInterface.GPS_DIRECTION_TRUE, "operationName", "", "additionalProperties", "", "block", "Lkotlin/Function1;", "Lcom/datadog/android/internal/profiler/BenchmarkSpan;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "dd-sdk-android-internal_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BenchmarkSpanExtKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object withinBenchmarkSpan$default(String operationName, Map additionalProperties, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            additionalProperties = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
        Intrinsics.checkNotNullParameter(block, "block");
        BenchmarkSpan benchmarkSpanStartSpan = GlobalBenchmark.INSTANCE.getProfiler().getTracer("dd-sdk-android").spanBuilder(operationName, additionalProperties).startSpan();
        try {
            return block.invoke(benchmarkSpanStartSpan);
        } finally {
            benchmarkSpanStartSpan.stop();
        }
    }

    public static final <T> T withinBenchmarkSpan(String operationName, Map<String, String> additionalProperties, Function1<? super BenchmarkSpan, ? extends T> block) {
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
        Intrinsics.checkNotNullParameter(block, "block");
        BenchmarkSpan benchmarkSpanStartSpan = GlobalBenchmark.INSTANCE.getProfiler().getTracer("dd-sdk-android").spanBuilder(operationName, additionalProperties).startSpan();
        try {
            return block.invoke(benchmarkSpanStartSpan);
        } finally {
            benchmarkSpanStartSpan.stop();
        }
    }
}
