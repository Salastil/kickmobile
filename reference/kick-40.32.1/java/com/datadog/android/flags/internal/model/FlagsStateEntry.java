package com.datadog.android.flags.internal.model;

import com.datadog.android.flags.model.EvaluationContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlagsStateEntry.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/flags/internal/model/FlagsStateEntry;", "", "evaluationContext", "Lcom/datadog/android/flags/model/EvaluationContext;", "flags", "", "", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "lastUpdateTimestamp", "", "(Lcom/datadog/android/flags/model/EvaluationContext;Ljava/util/Map;J)V", "getEvaluationContext", "()Lcom/datadog/android/flags/model/EvaluationContext;", "getFlags", "()Ljava/util/Map;", "getLastUpdateTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FlagsStateEntry {
    private final EvaluationContext evaluationContext;
    private final Map<String, PrecomputedFlag> flags;
    private final long lastUpdateTimestamp;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FlagsStateEntry copy$default(FlagsStateEntry flagsStateEntry, EvaluationContext evaluationContext, Map map, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            evaluationContext = flagsStateEntry.evaluationContext;
        }
        if ((i & 2) != 0) {
            map = flagsStateEntry.flags;
        }
        if ((i & 4) != 0) {
            j = flagsStateEntry.lastUpdateTimestamp;
        }
        return flagsStateEntry.copy(evaluationContext, map, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EvaluationContext getEvaluationContext() {
        return this.evaluationContext;
    }

    public final Map<String, PrecomputedFlag> component2() {
        return this.flags;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    public final FlagsStateEntry copy(EvaluationContext evaluationContext, Map<String, PrecomputedFlag> flags, long lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(evaluationContext, "evaluationContext");
        Intrinsics.checkNotNullParameter(flags, "flags");
        return new FlagsStateEntry(evaluationContext, flags, lastUpdateTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlagsStateEntry)) {
            return false;
        }
        FlagsStateEntry flagsStateEntry = (FlagsStateEntry) other;
        return Intrinsics.areEqual(this.evaluationContext, flagsStateEntry.evaluationContext) && Intrinsics.areEqual(this.flags, flagsStateEntry.flags) && this.lastUpdateTimestamp == flagsStateEntry.lastUpdateTimestamp;
    }

    public int hashCode() {
        return (((this.evaluationContext.hashCode() * 31) + this.flags.hashCode()) * 31) + Long.hashCode(this.lastUpdateTimestamp);
    }

    public String toString() {
        return "FlagsStateEntry(evaluationContext=" + this.evaluationContext + ", flags=" + this.flags + ", lastUpdateTimestamp=" + this.lastUpdateTimestamp + ")";
    }

    public FlagsStateEntry(EvaluationContext evaluationContext, Map<String, PrecomputedFlag> flags, long j) {
        Intrinsics.checkNotNullParameter(evaluationContext, "evaluationContext");
        Intrinsics.checkNotNullParameter(flags, "flags");
        this.evaluationContext = evaluationContext;
        this.flags = flags;
        this.lastUpdateTimestamp = j;
    }

    public final EvaluationContext getEvaluationContext() {
        return this.evaluationContext;
    }

    public final Map<String, PrecomputedFlag> getFlags() {
        return this.flags;
    }

    public final long getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }
}
