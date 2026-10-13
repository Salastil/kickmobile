package com.datadog.android.rum.internal.monitor;

import com.datadog.android.rum.model.ActionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StorageEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "", "()V", "Action", "Error", "FrozenFrame", "LongTask", "Resource", "View", "Lcom/datadog/android/rum/internal/monitor/StorageEvent$Action;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent$Error;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent$FrozenFrame;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent$LongTask;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent$Resource;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent$View;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class StorageEvent {
    public /* synthetic */ StorageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: StorageEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/StorageEvent$View;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "()V", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class View extends StorageEvent {
        public static final View INSTANCE = new View();

        private View() {
            super(null);
        }
    }

    private StorageEvent() {
    }

    /* JADX INFO: compiled from: StorageEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/StorageEvent$Action;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "frustrationCount", "", "type", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "eventEndTimestampInNanos", "", "(ILcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;J)V", "getEventEndTimestampInNanos", "()J", "getFrustrationCount", "()I", "getType", "()Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Action extends StorageEvent {
        private final long eventEndTimestampInNanos;
        private final int frustrationCount;
        private final ActionEvent.ActionEventActionType type;

        public static /* synthetic */ Action copy$default(Action action, int i, ActionEvent.ActionEventActionType actionEventActionType, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = action.frustrationCount;
            }
            if ((i2 & 2) != 0) {
                actionEventActionType = action.type;
            }
            if ((i2 & 4) != 0) {
                j = action.eventEndTimestampInNanos;
            }
            return action.copy(i, actionEventActionType, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getFrustrationCount() {
            return this.frustrationCount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ActionEvent.ActionEventActionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getEventEndTimestampInNanos() {
            return this.eventEndTimestampInNanos;
        }

        public final Action copy(int frustrationCount, ActionEvent.ActionEventActionType type, long eventEndTimestampInNanos) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Action(frustrationCount, type, eventEndTimestampInNanos);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Action)) {
                return false;
            }
            Action action = (Action) other;
            return this.frustrationCount == action.frustrationCount && this.type == action.type && this.eventEndTimestampInNanos == action.eventEndTimestampInNanos;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.frustrationCount) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.eventEndTimestampInNanos);
        }

        public String toString() {
            return "Action(frustrationCount=" + this.frustrationCount + ", type=" + this.type + ", eventEndTimestampInNanos=" + this.eventEndTimestampInNanos + ")";
        }

        public final int getFrustrationCount() {
            return this.frustrationCount;
        }

        public final ActionEvent.ActionEventActionType getType() {
            return this.type;
        }

        public final long getEventEndTimestampInNanos() {
            return this.eventEndTimestampInNanos;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Action(int i, ActionEvent.ActionEventActionType type, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.frustrationCount = i;
            this.type = type;
            this.eventEndTimestampInNanos = j;
        }
    }

    /* JADX INFO: compiled from: StorageEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/StorageEvent$Resource;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "resourceId", "", "resourceStopTimestampInNanos", "", "(Ljava/lang/String;J)V", "getResourceId", "()Ljava/lang/String;", "getResourceStopTimestampInNanos", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Resource extends StorageEvent {
        private final String resourceId;
        private final long resourceStopTimestampInNanos;

        public static /* synthetic */ Resource copy$default(Resource resource, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resource.resourceId;
            }
            if ((i & 2) != 0) {
                j = resource.resourceStopTimestampInNanos;
            }
            return resource.copy(str, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getResourceStopTimestampInNanos() {
            return this.resourceStopTimestampInNanos;
        }

        public final Resource copy(String resourceId, long resourceStopTimestampInNanos) {
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            return new Resource(resourceId, resourceStopTimestampInNanos);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Resource)) {
                return false;
            }
            Resource resource = (Resource) other;
            return Intrinsics.areEqual(this.resourceId, resource.resourceId) && this.resourceStopTimestampInNanos == resource.resourceStopTimestampInNanos;
        }

        public int hashCode() {
            return (this.resourceId.hashCode() * 31) + Long.hashCode(this.resourceStopTimestampInNanos);
        }

        public String toString() {
            return "Resource(resourceId=" + this.resourceId + ", resourceStopTimestampInNanos=" + this.resourceStopTimestampInNanos + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Resource(String resourceId, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            this.resourceId = resourceId;
            this.resourceStopTimestampInNanos = j;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final long getResourceStopTimestampInNanos() {
            return this.resourceStopTimestampInNanos;
        }
    }

    /* JADX INFO: compiled from: StorageEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/StorageEvent$Error;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "resourceId", "", "resourceStopTimestampInNanos", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "getResourceId", "()Ljava/lang/String;", "getResourceStopTimestampInNanos", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/datadog/android/rum/internal/monitor/StorageEvent$Error;", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Error extends StorageEvent {
        private final String resourceId;
        private final Long resourceStopTimestampInNanos;

        /* JADX WARN: Multi-variable type inference failed */
        public Error() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Error copy$default(Error error, String str, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.resourceId;
            }
            if ((i & 2) != 0) {
                l = error.resourceStopTimestampInNanos;
            }
            return error.copy(str, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getResourceStopTimestampInNanos() {
            return this.resourceStopTimestampInNanos;
        }

        public final Error copy(String resourceId, Long resourceStopTimestampInNanos) {
            return new Error(resourceId, resourceStopTimestampInNanos);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.resourceId, error.resourceId) && Intrinsics.areEqual(this.resourceStopTimestampInNanos, error.resourceStopTimestampInNanos);
        }

        public int hashCode() {
            String str = this.resourceId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l = this.resourceStopTimestampInNanos;
            return iHashCode + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "Error(resourceId=" + this.resourceId + ", resourceStopTimestampInNanos=" + this.resourceStopTimestampInNanos + ")";
        }

        public Error(String str, Long l) {
            super(null);
            this.resourceId = str;
            this.resourceStopTimestampInNanos = l;
        }

        public /* synthetic */ Error(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l);
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final Long getResourceStopTimestampInNanos() {
            return this.resourceStopTimestampInNanos;
        }
    }

    /* JADX INFO: compiled from: StorageEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/StorageEvent$LongTask;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "()V", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LongTask extends StorageEvent {
        public static final LongTask INSTANCE = new LongTask();

        private LongTask() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StorageEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/StorageEvent$FrozenFrame;", "Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "()V", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FrozenFrame extends StorageEvent {
        public static final FrozenFrame INSTANCE = new FrozenFrame();

        private FrozenFrame() {
            super(null);
        }
    }
}
