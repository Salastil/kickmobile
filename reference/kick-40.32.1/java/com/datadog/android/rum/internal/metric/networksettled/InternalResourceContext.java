package com.datadog.android.rum.internal.metric.networksettled;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternalResourceContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\u000e\u0010\r\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u000eJ\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/metric/networksettled/InternalResourceContext;", "", "resourceId", "", "eventCreatedAtNanos", "", "(Ljava/lang/String;J)V", "getEventCreatedAtNanos$dd_sdk_android_rum_release", "()J", "getResourceId$dd_sdk_android_rum_release", "()Ljava/lang/String;", "component1", "component1$dd_sdk_android_rum_release", "component2", "component2$dd_sdk_android_rum_release", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InternalResourceContext {
    private final long eventCreatedAtNanos;
    private final String resourceId;

    public static /* synthetic */ InternalResourceContext copy$default(InternalResourceContext internalResourceContext, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = internalResourceContext.resourceId;
        }
        if ((i & 2) != 0) {
            j = internalResourceContext.eventCreatedAtNanos;
        }
        return internalResourceContext.copy(str, j);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_rum_release, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_rum_release, reason: from getter */
    public final long getEventCreatedAtNanos() {
        return this.eventCreatedAtNanos;
    }

    public final InternalResourceContext copy(String resourceId, long eventCreatedAtNanos) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        return new InternalResourceContext(resourceId, eventCreatedAtNanos);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InternalResourceContext)) {
            return false;
        }
        InternalResourceContext internalResourceContext = (InternalResourceContext) other;
        return Intrinsics.areEqual(this.resourceId, internalResourceContext.resourceId) && this.eventCreatedAtNanos == internalResourceContext.eventCreatedAtNanos;
    }

    public int hashCode() {
        return (this.resourceId.hashCode() * 31) + Long.hashCode(this.eventCreatedAtNanos);
    }

    public String toString() {
        return "InternalResourceContext(resourceId=" + this.resourceId + ", eventCreatedAtNanos=" + this.eventCreatedAtNanos + ")";
    }

    public InternalResourceContext(String resourceId, long j) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.resourceId = resourceId;
        this.eventCreatedAtNanos = j;
    }

    public final String getResourceId$dd_sdk_android_rum_release() {
        return this.resourceId;
    }

    public final long getEventCreatedAtNanos$dd_sdk_android_rum_release() {
        return this.eventCreatedAtNanos;
    }
}
