package com.datadog.android.flags.internal;

import com.datadog.android.flags.internal.aggregation.EvaluationAggregationStats;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: EvaluationEventWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/flags/internal/EvaluationEventWriter;", "", "writeAll", "", "events", "", "Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationStats;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface EvaluationEventWriter {
    void writeAll(List<EvaluationAggregationStats> events);
}
