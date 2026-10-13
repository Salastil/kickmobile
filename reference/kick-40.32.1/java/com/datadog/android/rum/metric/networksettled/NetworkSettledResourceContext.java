package com.datadog.android.rum.metric.networksettled;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkSettledResourceContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/metric/networksettled/NetworkSettledResourceContext;", "", "resourceId", "", "eventCreatedAtNanos", "", "viewCreatedTimestamp", "(Ljava/lang/String;JLjava/lang/Long;)V", "getEventCreatedAtNanos", "()J", "getResourceId", "()Ljava/lang/String;", "getViewCreatedTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;JLjava/lang/Long;)Lcom/datadog/android/rum/metric/networksettled/NetworkSettledResourceContext;", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NetworkSettledResourceContext {
    private final long eventCreatedAtNanos;
    private final String resourceId;
    private final Long viewCreatedTimestamp;

    public static /* synthetic */ NetworkSettledResourceContext copy$default(NetworkSettledResourceContext networkSettledResourceContext, String str, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = networkSettledResourceContext.resourceId;
        }
        if ((i & 2) != 0) {
            j = networkSettledResourceContext.eventCreatedAtNanos;
        }
        if ((i & 4) != 0) {
            l = networkSettledResourceContext.viewCreatedTimestamp;
        }
        return networkSettledResourceContext.copy(str, j, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getEventCreatedAtNanos() {
        return this.eventCreatedAtNanos;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getViewCreatedTimestamp() {
        return this.viewCreatedTimestamp;
    }

    public final NetworkSettledResourceContext copy(String resourceId, long eventCreatedAtNanos, Long viewCreatedTimestamp) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        return new NetworkSettledResourceContext(resourceId, eventCreatedAtNanos, viewCreatedTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkSettledResourceContext)) {
            return false;
        }
        NetworkSettledResourceContext networkSettledResourceContext = (NetworkSettledResourceContext) other;
        return Intrinsics.areEqual(this.resourceId, networkSettledResourceContext.resourceId) && this.eventCreatedAtNanos == networkSettledResourceContext.eventCreatedAtNanos && Intrinsics.areEqual(this.viewCreatedTimestamp, networkSettledResourceContext.viewCreatedTimestamp);
    }

    public int hashCode() {
        int iHashCode = ((this.resourceId.hashCode() * 31) + Long.hashCode(this.eventCreatedAtNanos)) * 31;
        Long l = this.viewCreatedTimestamp;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "NetworkSettledResourceContext(resourceId=" + this.resourceId + ", eventCreatedAtNanos=" + this.eventCreatedAtNanos + ", viewCreatedTimestamp=" + this.viewCreatedTimestamp + ")";
    }

    public NetworkSettledResourceContext(String resourceId, long j, Long l) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.resourceId = resourceId;
        this.eventCreatedAtNanos = j;
        this.viewCreatedTimestamp = l;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final long getEventCreatedAtNanos() {
        return this.eventCreatedAtNanos;
    }

    public final Long getViewCreatedTimestamp() {
        return this.viewCreatedTimestamp;
    }
}
