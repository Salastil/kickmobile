package com.datadog.android.rum.metric.interactiontonextview;

import com.datadog.android.rum.model.ActionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousViewLastInteractionContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/metric/interactiontonextview/PreviousViewLastInteractionContext;", "", "actionType", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "eventCreatedAtNanos", "", "currentViewCreationTimestamp", "(Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;JLjava/lang/Long;)V", "getActionType", "()Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "getCurrentViewCreationTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEventCreatedAtNanos", "()J", "component1", "component2", "component3", "copy", "(Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;JLjava/lang/Long;)Lcom/datadog/android/rum/metric/interactiontonextview/PreviousViewLastInteractionContext;", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PreviousViewLastInteractionContext {
    private final ActionEvent.ActionEventActionType actionType;
    private final Long currentViewCreationTimestamp;
    private final long eventCreatedAtNanos;

    public static /* synthetic */ PreviousViewLastInteractionContext copy$default(PreviousViewLastInteractionContext previousViewLastInteractionContext, ActionEvent.ActionEventActionType actionEventActionType, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            actionEventActionType = previousViewLastInteractionContext.actionType;
        }
        if ((i & 2) != 0) {
            j = previousViewLastInteractionContext.eventCreatedAtNanos;
        }
        if ((i & 4) != 0) {
            l = previousViewLastInteractionContext.currentViewCreationTimestamp;
        }
        return previousViewLastInteractionContext.copy(actionEventActionType, j, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ActionEvent.ActionEventActionType getActionType() {
        return this.actionType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getEventCreatedAtNanos() {
        return this.eventCreatedAtNanos;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getCurrentViewCreationTimestamp() {
        return this.currentViewCreationTimestamp;
    }

    public final PreviousViewLastInteractionContext copy(ActionEvent.ActionEventActionType actionType, long eventCreatedAtNanos, Long currentViewCreationTimestamp) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        return new PreviousViewLastInteractionContext(actionType, eventCreatedAtNanos, currentViewCreationTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviousViewLastInteractionContext)) {
            return false;
        }
        PreviousViewLastInteractionContext previousViewLastInteractionContext = (PreviousViewLastInteractionContext) other;
        return this.actionType == previousViewLastInteractionContext.actionType && this.eventCreatedAtNanos == previousViewLastInteractionContext.eventCreatedAtNanos && Intrinsics.areEqual(this.currentViewCreationTimestamp, previousViewLastInteractionContext.currentViewCreationTimestamp);
    }

    public int hashCode() {
        int iHashCode = ((this.actionType.hashCode() * 31) + Long.hashCode(this.eventCreatedAtNanos)) * 31;
        Long l = this.currentViewCreationTimestamp;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "PreviousViewLastInteractionContext(actionType=" + this.actionType + ", eventCreatedAtNanos=" + this.eventCreatedAtNanos + ", currentViewCreationTimestamp=" + this.currentViewCreationTimestamp + ")";
    }

    public PreviousViewLastInteractionContext(ActionEvent.ActionEventActionType actionType, long j, Long l) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        this.actionType = actionType;
        this.eventCreatedAtNanos = j;
        this.currentViewCreationTimestamp = l;
    }

    public final ActionEvent.ActionEventActionType getActionType() {
        return this.actionType;
    }

    public final long getEventCreatedAtNanos() {
        return this.eventCreatedAtNanos;
    }

    public final Long getCurrentViewCreationTimestamp() {
        return this.currentViewCreationTimestamp;
    }
}
