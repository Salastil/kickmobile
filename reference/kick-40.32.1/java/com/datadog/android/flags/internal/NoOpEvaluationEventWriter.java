package com.datadog.android.flags.internal;

import com.datadog.android.flags.internal.aggregation.EvaluationAggregationStats;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpEvaluationEventWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/datadog/android/flags/internal/NoOpEvaluationEventWriter;", "Lcom/datadog/android/flags/internal/EvaluationEventWriter;", "()V", "writeAll", "", "events", "", "Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationStats;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpEvaluationEventWriter implements EvaluationEventWriter {
    @Override // com.datadog.android.flags.internal.EvaluationEventWriter
    public void writeAll(List<EvaluationAggregationStats> events) {
        Intrinsics.checkNotNullParameter(events, "events");
    }
}
