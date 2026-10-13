package com.datadog.android.heatmaps;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CrossPlatformHeatmapActionData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012JT\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", "", "elementPath", "", "", "viewUrl", "positionX", "", "positionY", "targetWidth", "targetHeight", "(Ljava/util/List;Ljava/lang/String;JJLjava/lang/Long;Ljava/lang/Long;)V", "getElementPath", "()Ljava/util/List;", "getPositionX", "()J", "getPositionY", "getTargetHeight", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTargetWidth", "getViewUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/lang/String;JJLjava/lang/Long;Ljava/lang/Long;)Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CrossPlatformHeatmapActionData {
    private final List<String> elementPath;
    private final long positionX;
    private final long positionY;
    private final Long targetHeight;
    private final Long targetWidth;
    private final String viewUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CrossPlatformHeatmapActionData copy$default(CrossPlatformHeatmapActionData crossPlatformHeatmapActionData, List list, String str, long j, long j2, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = crossPlatformHeatmapActionData.elementPath;
        }
        if ((i & 2) != 0) {
            str = crossPlatformHeatmapActionData.viewUrl;
        }
        if ((i & 4) != 0) {
            j = crossPlatformHeatmapActionData.positionX;
        }
        if ((i & 8) != 0) {
            j2 = crossPlatformHeatmapActionData.positionY;
        }
        if ((i & 16) != 0) {
            l = crossPlatformHeatmapActionData.targetWidth;
        }
        if ((i & 32) != 0) {
            l2 = crossPlatformHeatmapActionData.targetHeight;
        }
        long j3 = j2;
        long j4 = j;
        return crossPlatformHeatmapActionData.copy(list, str, j4, j3, l, l2);
    }

    public final List<String> component1() {
        return this.elementPath;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getViewUrl() {
        return this.viewUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getPositionX() {
        return this.positionX;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getPositionY() {
        return this.positionY;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getTargetWidth() {
        return this.targetWidth;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getTargetHeight() {
        return this.targetHeight;
    }

    public final CrossPlatformHeatmapActionData copy(List<String> elementPath, String viewUrl, long positionX, long positionY, Long targetWidth, Long targetHeight) {
        Intrinsics.checkNotNullParameter(elementPath, "elementPath");
        Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
        return new CrossPlatformHeatmapActionData(elementPath, viewUrl, positionX, positionY, targetWidth, targetHeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CrossPlatformHeatmapActionData)) {
            return false;
        }
        CrossPlatformHeatmapActionData crossPlatformHeatmapActionData = (CrossPlatformHeatmapActionData) other;
        return Intrinsics.areEqual(this.elementPath, crossPlatformHeatmapActionData.elementPath) && Intrinsics.areEqual(this.viewUrl, crossPlatformHeatmapActionData.viewUrl) && this.positionX == crossPlatformHeatmapActionData.positionX && this.positionY == crossPlatformHeatmapActionData.positionY && Intrinsics.areEqual(this.targetWidth, crossPlatformHeatmapActionData.targetWidth) && Intrinsics.areEqual(this.targetHeight, crossPlatformHeatmapActionData.targetHeight);
    }

    public int hashCode() {
        int iHashCode = ((((((this.elementPath.hashCode() * 31) + this.viewUrl.hashCode()) * 31) + Long.hashCode(this.positionX)) * 31) + Long.hashCode(this.positionY)) * 31;
        Long l = this.targetWidth;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.targetHeight;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "CrossPlatformHeatmapActionData(elementPath=" + this.elementPath + ", viewUrl=" + this.viewUrl + ", positionX=" + this.positionX + ", positionY=" + this.positionY + ", targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ")";
    }

    public CrossPlatformHeatmapActionData(List<String> elementPath, String viewUrl, long j, long j2, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(elementPath, "elementPath");
        Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
        this.elementPath = elementPath;
        this.viewUrl = viewUrl;
        this.positionX = j;
        this.positionY = j2;
        this.targetWidth = l;
        this.targetHeight = l2;
    }

    public final List<String> getElementPath() {
        return this.elementPath;
    }

    public final String getViewUrl() {
        return this.viewUrl;
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
