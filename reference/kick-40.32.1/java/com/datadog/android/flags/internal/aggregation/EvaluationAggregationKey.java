package com.datadog.android.flags.internal.aggregation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationAggregationKey.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/flags/internal/aggregation/EvaluationAggregationKey;", "", "flagKey", "", "variantKey", "allocationKey", "targetingKey", "viewName", "errorCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllocationKey", "()Ljava/lang/String;", "getErrorCode", "getFlagKey", "getTargetingKey", "getVariantKey", "getViewName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EvaluationAggregationKey {
    private final String allocationKey;
    private final String errorCode;
    private final String flagKey;
    private final String targetingKey;
    private final String variantKey;
    private final String viewName;

    public static /* synthetic */ EvaluationAggregationKey copy$default(EvaluationAggregationKey evaluationAggregationKey, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = evaluationAggregationKey.flagKey;
        }
        if ((i & 2) != 0) {
            str2 = evaluationAggregationKey.variantKey;
        }
        if ((i & 4) != 0) {
            str3 = evaluationAggregationKey.allocationKey;
        }
        if ((i & 8) != 0) {
            str4 = evaluationAggregationKey.targetingKey;
        }
        if ((i & 16) != 0) {
            str5 = evaluationAggregationKey.viewName;
        }
        if ((i & 32) != 0) {
            str6 = evaluationAggregationKey.errorCode;
        }
        String str7 = str5;
        String str8 = str6;
        return evaluationAggregationKey.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFlagKey() {
        return this.flagKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVariantKey() {
        return this.variantKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAllocationKey() {
        return this.allocationKey;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTargetingKey() {
        return this.targetingKey;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getViewName() {
        return this.viewName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    public final EvaluationAggregationKey copy(String flagKey, String variantKey, String allocationKey, String targetingKey, String viewName, String errorCode) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        return new EvaluationAggregationKey(flagKey, variantKey, allocationKey, targetingKey, viewName, errorCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluationAggregationKey)) {
            return false;
        }
        EvaluationAggregationKey evaluationAggregationKey = (EvaluationAggregationKey) other;
        return Intrinsics.areEqual(this.flagKey, evaluationAggregationKey.flagKey) && Intrinsics.areEqual(this.variantKey, evaluationAggregationKey.variantKey) && Intrinsics.areEqual(this.allocationKey, evaluationAggregationKey.allocationKey) && Intrinsics.areEqual(this.targetingKey, evaluationAggregationKey.targetingKey) && Intrinsics.areEqual(this.viewName, evaluationAggregationKey.viewName) && Intrinsics.areEqual(this.errorCode, evaluationAggregationKey.errorCode);
    }

    public int hashCode() {
        int iHashCode = this.flagKey.hashCode() * 31;
        String str = this.variantKey;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.allocationKey;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.targetingKey;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.viewName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.errorCode;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "EvaluationAggregationKey(flagKey=" + this.flagKey + ", variantKey=" + this.variantKey + ", allocationKey=" + this.allocationKey + ", targetingKey=" + this.targetingKey + ", viewName=" + this.viewName + ", errorCode=" + this.errorCode + ")";
    }

    public EvaluationAggregationKey(String flagKey, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        this.flagKey = flagKey;
        this.variantKey = str;
        this.allocationKey = str2;
        this.targetingKey = str3;
        this.viewName = str4;
        this.errorCode = str5;
    }

    public final String getFlagKey() {
        return this.flagKey;
    }

    public final String getVariantKey() {
        return this.variantKey;
    }

    public final String getAllocationKey() {
        return this.allocationKey;
    }

    public final String getTargetingKey() {
        return this.targetingKey;
    }

    public final String getViewName() {
        return this.viewName;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }
}
