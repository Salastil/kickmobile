package com.datadog.android.rum.internal.heatmaps;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeHeatmapActionData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJD\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;", "", "viewKey", "", "positionX", "positionY", "targetWidth", "targetHeight", "(JJJLjava/lang/Long;Ljava/lang/Long;)V", "getPositionX", "()J", "getPositionY", "getTargetHeight", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTargetWidth", "getViewKey", "component1", "component2", "component3", "component4", "component5", "copy", "(JJJLjava/lang/Long;Ljava/lang/Long;)Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NativeHeatmapActionData {
    private final long positionX;
    private final long positionY;
    private final Long targetHeight;
    private final Long targetWidth;
    private final long viewKey;

    public static /* synthetic */ NativeHeatmapActionData copy$default(NativeHeatmapActionData nativeHeatmapActionData, long j, long j2, long j3, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = nativeHeatmapActionData.viewKey;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = nativeHeatmapActionData.positionX;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = nativeHeatmapActionData.positionY;
        }
        return nativeHeatmapActionData.copy(j4, j5, j3, (i & 8) != 0 ? nativeHeatmapActionData.targetWidth : l, (i & 16) != 0 ? nativeHeatmapActionData.targetHeight : l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getViewKey() {
        return this.viewKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPositionX() {
        return this.positionX;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getPositionY() {
        return this.positionY;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getTargetWidth() {
        return this.targetWidth;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getTargetHeight() {
        return this.targetHeight;
    }

    public final NativeHeatmapActionData copy(long viewKey, long positionX, long positionY, Long targetWidth, Long targetHeight) {
        return new NativeHeatmapActionData(viewKey, positionX, positionY, targetWidth, targetHeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeHeatmapActionData)) {
            return false;
        }
        NativeHeatmapActionData nativeHeatmapActionData = (NativeHeatmapActionData) other;
        return this.viewKey == nativeHeatmapActionData.viewKey && this.positionX == nativeHeatmapActionData.positionX && this.positionY == nativeHeatmapActionData.positionY && Intrinsics.areEqual(this.targetWidth, nativeHeatmapActionData.targetWidth) && Intrinsics.areEqual(this.targetHeight, nativeHeatmapActionData.targetHeight);
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.viewKey) * 31) + Long.hashCode(this.positionX)) * 31) + Long.hashCode(this.positionY)) * 31;
        Long l = this.targetWidth;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.targetHeight;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "NativeHeatmapActionData(viewKey=" + this.viewKey + ", positionX=" + this.positionX + ", positionY=" + this.positionY + ", targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ")";
    }

    public NativeHeatmapActionData(long j, long j2, long j3, Long l, Long l2) {
        this.viewKey = j;
        this.positionX = j2;
        this.positionY = j3;
        this.targetWidth = l;
        this.targetHeight = l2;
    }

    public final long getViewKey() {
        return this.viewKey;
    }

    public final long getPositionX() {
        return this.positionX;
    }

    public final long getPositionY() {
        return this.positionY;
    }

    public final Long getTargetWidth() {
        return this.targetWidth;
    }

    public final Long getTargetHeight() {
        return this.targetHeight;
    }
}
