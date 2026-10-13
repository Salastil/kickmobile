package com.datadog.android.rum.internal.metric.interactiontonextview;

import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.model.ActionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternalInteractionContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0014J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/rum/internal/metric/interactiontonextview/InternalInteractionContext;", "", RumEventMeta.VIEW_ID_KEY, "", "actionType", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "eventCreatedAtNanos", "", "(Ljava/lang/String;Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;J)V", "getActionType$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "getEventCreatedAtNanos$dd_sdk_android_rum_release", "()J", "getViewId$dd_sdk_android_rum_release", "()Ljava/lang/String;", "component1", "component1$dd_sdk_android_rum_release", "component2", "component2$dd_sdk_android_rum_release", "component3", "component3$dd_sdk_android_rum_release", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InternalInteractionContext {
    private final ActionEvent.ActionEventActionType actionType;
    private final long eventCreatedAtNanos;
    private final String viewId;

    public static /* synthetic */ InternalInteractionContext copy$default(InternalInteractionContext internalInteractionContext, String str, ActionEvent.ActionEventActionType actionEventActionType, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = internalInteractionContext.viewId;
        }
        if ((i & 2) != 0) {
            actionEventActionType = internalInteractionContext.actionType;
        }
        if ((i & 4) != 0) {
            j = internalInteractionContext.eventCreatedAtNanos;
        }
        return internalInteractionContext.copy(str, actionEventActionType, j);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_rum_release, reason: from getter */
    public final String getViewId() {
        return this.viewId;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_rum_release, reason: from getter */
    public final ActionEvent.ActionEventActionType getActionType() {
        return this.actionType;
    }

    /* JADX INFO: renamed from: component3$dd_sdk_android_rum_release, reason: from getter */
    public final long getEventCreatedAtNanos() {
        return this.eventCreatedAtNanos;
    }

    public final InternalInteractionContext copy(String viewId, ActionEvent.ActionEventActionType actionType, long eventCreatedAtNanos) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        return new InternalInteractionContext(viewId, actionType, eventCreatedAtNanos);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InternalInteractionContext)) {
            return false;
        }
        InternalInteractionContext internalInteractionContext = (InternalInteractionContext) other;
        return Intrinsics.areEqual(this.viewId, internalInteractionContext.viewId) && this.actionType == internalInteractionContext.actionType && this.eventCreatedAtNanos == internalInteractionContext.eventCreatedAtNanos;
    }

    public int hashCode() {
        return (((this.viewId.hashCode() * 31) + this.actionType.hashCode()) * 31) + Long.hashCode(this.eventCreatedAtNanos);
    }

    public String toString() {
        return "InternalInteractionContext(viewId=" + this.viewId + ", actionType=" + this.actionType + ", eventCreatedAtNanos=" + this.eventCreatedAtNanos + ")";
    }

    public InternalInteractionContext(String viewId, ActionEvent.ActionEventActionType actionType, long j) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        this.viewId = viewId;
        this.actionType = actionType;
        this.eventCreatedAtNanos = j;
    }

    public final String getViewId$dd_sdk_android_rum_release() {
        return this.viewId;
    }

    public final ActionEvent.ActionEventActionType getActionType$dd_sdk_android_rum_release() {
        return this.actionType;
    }

    public final long getEventCreatedAtNanos$dd_sdk_android_rum_release() {
        return this.eventCreatedAtNanos;
    }
}
