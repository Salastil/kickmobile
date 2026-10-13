package com.datadog.android.internal.flags;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumFlagEvaluationMessage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/internal/flags/RumFlagEvaluationMessage;", "", "flagKey", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "getFlagKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RumFlagEvaluationMessage {
    private final String flagKey;
    private final Object value;

    public static /* synthetic */ RumFlagEvaluationMessage copy$default(RumFlagEvaluationMessage rumFlagEvaluationMessage, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = rumFlagEvaluationMessage.flagKey;
        }
        if ((i & 2) != 0) {
            obj = rumFlagEvaluationMessage.value;
        }
        return rumFlagEvaluationMessage.copy(str, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFlagKey() {
        return this.flagKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    public final RumFlagEvaluationMessage copy(String flagKey, Object value) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(value, "value");
        return new RumFlagEvaluationMessage(flagKey, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RumFlagEvaluationMessage)) {
            return false;
        }
        RumFlagEvaluationMessage rumFlagEvaluationMessage = (RumFlagEvaluationMessage) other;
        return Intrinsics.areEqual(this.flagKey, rumFlagEvaluationMessage.flagKey) && Intrinsics.areEqual(this.value, rumFlagEvaluationMessage.value);
    }

    public int hashCode() {
        return (this.flagKey.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "RumFlagEvaluationMessage(flagKey=" + this.flagKey + ", value=" + this.value + ")";
    }

    public RumFlagEvaluationMessage(String flagKey, Object value) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(value, "value");
        this.flagKey = flagKey;
        this.value = value;
    }

    public final String getFlagKey() {
        return this.flagKey;
    }

    public final Object getValue() {
        return this.value;
    }
}
