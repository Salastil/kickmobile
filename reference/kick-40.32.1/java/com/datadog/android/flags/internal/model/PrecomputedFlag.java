package com.datadog.android.flags.internal.model;

import com.datadog.android.flags.model.UnparsedFlag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: PrecomputedFlag.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0017J`\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006,"}, d2 = {"Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "Lcom/datadog/android/flags/model/UnparsedFlag;", "variationType", "", "variationValue", "doLog", "", "allocationKey", "variationKey", "extraLogging", "Lorg/json/JSONObject;", "reason", "serialId", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Long;)V", "getAllocationKey", "()Ljava/lang/String;", "getDoLog", "()Z", "getExtraLogging", "()Lorg/json/JSONObject;", "getReason", "getSerialId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVariationKey", "getVariationType", "getVariationValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Long;)Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "equals", "other", "", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PrecomputedFlag implements UnparsedFlag {
    private final String allocationKey;
    private final boolean doLog;
    private final JSONObject extraLogging;
    private final String reason;
    private final Long serialId;
    private final String variationKey;
    private final String variationType;
    private final String variationValue;

    public static /* synthetic */ PrecomputedFlag copy$default(PrecomputedFlag precomputedFlag, String str, String str2, boolean z, String str3, String str4, JSONObject jSONObject, String str5, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = precomputedFlag.variationType;
        }
        if ((i & 2) != 0) {
            str2 = precomputedFlag.variationValue;
        }
        if ((i & 4) != 0) {
            z = precomputedFlag.doLog;
        }
        if ((i & 8) != 0) {
            str3 = precomputedFlag.allocationKey;
        }
        if ((i & 16) != 0) {
            str4 = precomputedFlag.variationKey;
        }
        if ((i & 32) != 0) {
            jSONObject = precomputedFlag.extraLogging;
        }
        if ((i & 64) != 0) {
            str5 = precomputedFlag.reason;
        }
        if ((i & 128) != 0) {
            l = precomputedFlag.serialId;
        }
        String str6 = str5;
        Long l2 = l;
        String str7 = str4;
        JSONObject jSONObject2 = jSONObject;
        return precomputedFlag.copy(str, str2, z, str3, str7, jSONObject2, str6, l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVariationType() {
        return this.variationType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVariationValue() {
        return this.variationValue;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDoLog() {
        return this.doLog;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAllocationKey() {
        return this.allocationKey;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getVariationKey() {
        return this.variationKey;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final JSONObject getExtraLogging() {
        return this.extraLogging;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getSerialId() {
        return this.serialId;
    }

    public final PrecomputedFlag copy(String variationType, String variationValue, boolean doLog, String allocationKey, String variationKey, JSONObject extraLogging, String reason, Long serialId) {
        Intrinsics.checkNotNullParameter(variationType, "variationType");
        Intrinsics.checkNotNullParameter(variationValue, "variationValue");
        Intrinsics.checkNotNullParameter(allocationKey, "allocationKey");
        Intrinsics.checkNotNullParameter(variationKey, "variationKey");
        Intrinsics.checkNotNullParameter(extraLogging, "extraLogging");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return new PrecomputedFlag(variationType, variationValue, doLog, allocationKey, variationKey, extraLogging, reason, serialId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrecomputedFlag)) {
            return false;
        }
        PrecomputedFlag precomputedFlag = (PrecomputedFlag) other;
        return Intrinsics.areEqual(this.variationType, precomputedFlag.variationType) && Intrinsics.areEqual(this.variationValue, precomputedFlag.variationValue) && this.doLog == precomputedFlag.doLog && Intrinsics.areEqual(this.allocationKey, precomputedFlag.allocationKey) && Intrinsics.areEqual(this.variationKey, precomputedFlag.variationKey) && Intrinsics.areEqual(this.extraLogging, precomputedFlag.extraLogging) && Intrinsics.areEqual(this.reason, precomputedFlag.reason) && Intrinsics.areEqual(this.serialId, precomputedFlag.serialId);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.variationType.hashCode() * 31) + this.variationValue.hashCode()) * 31) + Boolean.hashCode(this.doLog)) * 31) + this.allocationKey.hashCode()) * 31) + this.variationKey.hashCode()) * 31) + this.extraLogging.hashCode()) * 31) + this.reason.hashCode()) * 31;
        Long l = this.serialId;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "PrecomputedFlag(variationType=" + this.variationType + ", variationValue=" + this.variationValue + ", doLog=" + this.doLog + ", allocationKey=" + this.allocationKey + ", variationKey=" + this.variationKey + ", extraLogging=" + this.extraLogging + ", reason=" + this.reason + ", serialId=" + this.serialId + ")";
    }

    public PrecomputedFlag(String variationType, String variationValue, boolean z, String allocationKey, String variationKey, JSONObject extraLogging, String reason, Long l) {
        Intrinsics.checkNotNullParameter(variationType, "variationType");
        Intrinsics.checkNotNullParameter(variationValue, "variationValue");
        Intrinsics.checkNotNullParameter(allocationKey, "allocationKey");
        Intrinsics.checkNotNullParameter(variationKey, "variationKey");
        Intrinsics.checkNotNullParameter(extraLogging, "extraLogging");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.variationType = variationType;
        this.variationValue = variationValue;
        this.doLog = z;
        this.allocationKey = allocationKey;
        this.variationKey = variationKey;
        this.extraLogging = extraLogging;
        this.reason = reason;
        this.serialId = l;
    }

    public /* synthetic */ PrecomputedFlag(String str, String str2, boolean z, String str3, String str4, JSONObject jSONObject, String str5, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, str3, str4, jSONObject, str5, (i & 128) != 0 ? null : l);
    }

    @Override // com.datadog.android.flags.model.UnparsedFlag
    public String getVariationType() {
        return this.variationType;
    }

    @Override // com.datadog.android.flags.model.UnparsedFlag
    public String getVariationValue() {
        return this.variationValue;
    }

    @Override // com.datadog.android.flags.model.UnparsedFlag
    public boolean getDoLog() {
        return this.doLog;
    }

    @Override // com.datadog.android.flags.model.UnparsedFlag
    public String getAllocationKey() {
        return this.allocationKey;
    }

    @Override // com.datadog.android.flags.model.UnparsedFlag
    public String getVariationKey() {
        return this.variationKey;
    }

    @Override // com.datadog.android.flags.model.UnparsedFlag
    public JSONObject getExtraLogging() {
        return this.extraLogging;
    }

    @Override // com.datadog.android.flags.model.UnparsedFlag
    public String getReason() {
        return this.reason;
    }

    @Override // com.datadog.android.flags.model.UnparsedFlag
    public Long getSerialId() {
        return this.serialId;
    }
}
