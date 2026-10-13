package com.datadog.android.flags.internal.aggregation;

import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationAggregator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000eH\u0002J`\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregator;", "", "maxAggregations", "", "(I)V", "aggregationMap", "", "Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationKey;", "Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationStats;", "mapLock", "Ljava/util/concurrent/locks/ReentrantLock;", "drain", "", "drainAggregationStats", "", "record", "timestamp", "", "flagKey", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "rumApplicationId", "rumViewName", "variantKey", "allocationKey", "errorCode", "errorMessage", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationAggregator {
    private final Map<EvaluationAggregationKey, EvaluationAggregationStats> aggregationMap = new LinkedHashMap();
    private final ReentrantLock mapLock = new ReentrantLock();
    private final int maxAggregations;

    public EvaluationAggregator(int i) {
        this.maxAggregations = i;
    }

    public final List<EvaluationAggregationStats> record(long timestamp, String flagKey, EvaluationContext context, String rumApplicationId, String rumViewName, String variantKey, String allocationKey, String errorCode, String errorMessage) {
        long j;
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(context, "context");
        EvaluationAggregationKey evaluationAggregationKey = new EvaluationAggregationKey(flagKey, variantKey, allocationKey, context.getTargetingKey(), rumViewName, errorCode);
        ReentrantLock reentrantLock = this.mapLock;
        reentrantLock.lock();
        try {
            EvaluationAggregationStats evaluationAggregationStats = this.aggregationMap.get(evaluationAggregationKey);
            if (evaluationAggregationStats == null) {
                j = timestamp;
                evaluationAggregationStats = new EvaluationAggregationStats(evaluationAggregationKey, 0, j, timestamp, context, rumApplicationId, errorMessage);
            } else {
                j = timestamp;
            }
            EvaluationAggregationStats evaluationAggregationStats2 = evaluationAggregationStats;
            this.aggregationMap.put(evaluationAggregationKey, EvaluationAggregationStats.copy$default(evaluationAggregationStats2, null, evaluationAggregationStats2.getCount$dd_sdk_android_flags_release() + 1, Math.min(evaluationAggregationStats2.getFirstEvaluation$dd_sdk_android_flags_release(), j), Math.max(evaluationAggregationStats2.getLastEvaluation$dd_sdk_android_flags_release(), j), null, null, errorMessage, 49, null));
            return CollectionsKt.toList((this.aggregationMap.size() < this.maxAggregations ? MapsKt.emptyMap() : drainAggregationStats()).values());
        } finally {
            reentrantLock.unlock();
        }
    }

    public final List<EvaluationAggregationStats> drain() {
        ReentrantLock reentrantLock = this.mapLock;
        reentrantLock.lock();
        try {
            return CollectionsKt.toList(drainAggregationStats().values());
        } finally {
            reentrantLock.unlock();
        }
    }

    private final Map<EvaluationAggregationKey, EvaluationAggregationStats> drainAggregationStats() {
        ReentrantLock reentrantLock = this.mapLock;
        reentrantLock.lock();
        try {
            Map<EvaluationAggregationKey, EvaluationAggregationStats> map = MapsKt.toMap(this.aggregationMap);
            this.aggregationMap.clear();
            return map;
        } finally {
            reentrantLock.unlock();
        }
    }
}
