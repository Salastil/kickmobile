package com.datadog.android.flags.internal.aggregation;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.flags.model.FlagEvaluation;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationAggregationStats.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0018\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u001bJ\u000e\u0010\u001c\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u001fJ\t\u0010 \u001a\u00020\nHÂ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÂ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÀ\u0003¢\u0006\u0002\b#JS\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\t\u0010-\u001a\u00020\fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\r\u001a\u0004\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationStats;", "", "aggregationKey", "Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationKey;", "count", "", "firstEvaluation", "", "lastEvaluation", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "rumApplicationId", "", "errorMessage", "(Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationKey;IJJLcom/datadog/android/flags/model/EvaluationContext;Ljava/lang/String;Ljava/lang/String;)V", "getAggregationKey$dd_sdk_android_flags_release", "()Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationKey;", "getCount$dd_sdk_android_flags_release", "()I", "getErrorMessage$dd_sdk_android_flags_release", "()Ljava/lang/String;", "getFirstEvaluation$dd_sdk_android_flags_release", "()J", "getLastEvaluation$dd_sdk_android_flags_release", "component1", "component1$dd_sdk_android_flags_release", "component2", "component2$dd_sdk_android_flags_release", "component3", "component3$dd_sdk_android_flags_release", "component4", "component4$dd_sdk_android_flags_release", "component5", "component6", "component7", "component7$dd_sdk_android_flags_release", "copy", "equals", "", "other", "hashCode", "toEvaluationEvent", "Lcom/datadog/android/flags/model/FlagEvaluation;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EvaluationAggregationStats {
    private final EvaluationAggregationKey aggregationKey;
    private final EvaluationContext context;
    private final int count;
    private final String errorMessage;
    private final long firstEvaluation;
    private final long lastEvaluation;
    private final String rumApplicationId;

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final EvaluationContext getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final String getRumApplicationId() {
        return this.rumApplicationId;
    }

    public static /* synthetic */ EvaluationAggregationStats copy$default(EvaluationAggregationStats evaluationAggregationStats, EvaluationAggregationKey evaluationAggregationKey, int i, long j, long j2, EvaluationContext evaluationContext, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            evaluationAggregationKey = evaluationAggregationStats.aggregationKey;
        }
        if ((i2 & 2) != 0) {
            i = evaluationAggregationStats.count;
        }
        if ((i2 & 4) != 0) {
            j = evaluationAggregationStats.firstEvaluation;
        }
        if ((i2 & 8) != 0) {
            j2 = evaluationAggregationStats.lastEvaluation;
        }
        if ((i2 & 16) != 0) {
            evaluationContext = evaluationAggregationStats.context;
        }
        if ((i2 & 32) != 0) {
            str = evaluationAggregationStats.rumApplicationId;
        }
        if ((i2 & 64) != 0) {
            str2 = evaluationAggregationStats.errorMessage;
        }
        String str3 = str2;
        EvaluationContext evaluationContext2 = evaluationContext;
        long j3 = j2;
        long j4 = j;
        return evaluationAggregationStats.copy(evaluationAggregationKey, i, j4, j3, evaluationContext2, str, str3);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_flags_release, reason: from getter */
    public final EvaluationAggregationKey getAggregationKey() {
        return this.aggregationKey;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_flags_release, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component3$dd_sdk_android_flags_release, reason: from getter */
    public final long getFirstEvaluation() {
        return this.firstEvaluation;
    }

    /* JADX INFO: renamed from: component4$dd_sdk_android_flags_release, reason: from getter */
    public final long getLastEvaluation() {
        return this.lastEvaluation;
    }

    /* JADX INFO: renamed from: component7$dd_sdk_android_flags_release, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final EvaluationAggregationStats copy(EvaluationAggregationKey aggregationKey, int count, long firstEvaluation, long lastEvaluation, EvaluationContext context, String rumApplicationId, String errorMessage) {
        Intrinsics.checkNotNullParameter(aggregationKey, "aggregationKey");
        Intrinsics.checkNotNullParameter(context, "context");
        return new EvaluationAggregationStats(aggregationKey, count, firstEvaluation, lastEvaluation, context, rumApplicationId, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluationAggregationStats)) {
            return false;
        }
        EvaluationAggregationStats evaluationAggregationStats = (EvaluationAggregationStats) other;
        return Intrinsics.areEqual(this.aggregationKey, evaluationAggregationStats.aggregationKey) && this.count == evaluationAggregationStats.count && this.firstEvaluation == evaluationAggregationStats.firstEvaluation && this.lastEvaluation == evaluationAggregationStats.lastEvaluation && Intrinsics.areEqual(this.context, evaluationAggregationStats.context) && Intrinsics.areEqual(this.rumApplicationId, evaluationAggregationStats.rumApplicationId) && Intrinsics.areEqual(this.errorMessage, evaluationAggregationStats.errorMessage);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.aggregationKey.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + Long.hashCode(this.firstEvaluation)) * 31) + Long.hashCode(this.lastEvaluation)) * 31) + this.context.hashCode()) * 31;
        String str = this.rumApplicationId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorMessage;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "EvaluationAggregationStats(aggregationKey=" + this.aggregationKey + ", count=" + this.count + ", firstEvaluation=" + this.firstEvaluation + ", lastEvaluation=" + this.lastEvaluation + ", context=" + this.context + ", rumApplicationId=" + this.rumApplicationId + ", errorMessage=" + this.errorMessage + ")";
    }

    public EvaluationAggregationStats(EvaluationAggregationKey aggregationKey, int i, long j, long j2, EvaluationContext context, String str, String str2) {
        Intrinsics.checkNotNullParameter(aggregationKey, "aggregationKey");
        Intrinsics.checkNotNullParameter(context, "context");
        this.aggregationKey = aggregationKey;
        this.count = i;
        this.firstEvaluation = j;
        this.lastEvaluation = j2;
        this.context = context;
        this.rumApplicationId = str;
        this.errorMessage = str2;
    }

    public final EvaluationAggregationKey getAggregationKey$dd_sdk_android_flags_release() {
        return this.aggregationKey;
    }

    public final int getCount$dd_sdk_android_flags_release() {
        return this.count;
    }

    public final long getFirstEvaluation$dd_sdk_android_flags_release() {
        return this.firstEvaluation;
    }

    public final long getLastEvaluation$dd_sdk_android_flags_release() {
        return this.lastEvaluation;
    }

    public final String getErrorMessage$dd_sdk_android_flags_release() {
        return this.errorMessage;
    }

    public final FlagEvaluation toEvaluationEvent(DatadogContext datadogContext) {
        FlagEvaluation.Rum rum;
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        String service = datadogContext.getService();
        String str = this.rumApplicationId;
        if (str != null) {
            FlagEvaluation.Application application = new FlagEvaluation.Application(str);
            String viewName = this.aggregationKey.getViewName();
            rum = new FlagEvaluation.Rum(application, viewName != null ? new FlagEvaluation.View(viewName) : null);
        } else {
            rum = null;
        }
        FlagEvaluation.Context context = new FlagEvaluation.Context(null, new FlagEvaluation.Dd(service, rum, null, 4, null));
        long j = this.firstEvaluation;
        FlagEvaluation.Identifier identifier = new FlagEvaluation.Identifier(this.aggregationKey.getFlagKey());
        String variantKey = this.aggregationKey.getVariantKey();
        FlagEvaluation.Identifier identifier2 = variantKey != null ? new FlagEvaluation.Identifier(variantKey) : null;
        String allocationKey = this.aggregationKey.getAllocationKey();
        FlagEvaluation.Identifier identifier3 = allocationKey != null ? new FlagEvaluation.Identifier(allocationKey) : null;
        String targetingKey = this.aggregationKey.getTargetingKey();
        String str2 = this.errorMessage;
        return new FlagEvaluation(j, identifier, this.firstEvaluation, this.lastEvaluation, this.count, Boolean.valueOf(this.aggregationKey.getVariantKey() == null), targetingKey, context, identifier2, identifier3, null, str2 != null ? new FlagEvaluation.Error(str2) : null);
    }
}
