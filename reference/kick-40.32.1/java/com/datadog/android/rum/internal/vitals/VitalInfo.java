package com.datadog.android.rum.internal.vitals;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VitalInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "", "sampleCount", "", "minValue", "", "maxValue", "meanValue", "(IDDD)V", "getMaxValue", "()D", "getMeanValue", "getMinValue", "getSampleCount", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VitalInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final VitalInfo EMPTY = new VitalInfo(0, Double.MAX_VALUE, -1.7976931348623157E308d, 0.0d);
    private final double maxValue;
    private final double meanValue;
    private final double minValue;
    private final int sampleCount;

    public static /* synthetic */ VitalInfo copy$default(VitalInfo vitalInfo, int i, double d, double d2, double d3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = vitalInfo.sampleCount;
        }
        if ((i2 & 2) != 0) {
            d = vitalInfo.minValue;
        }
        if ((i2 & 4) != 0) {
            d2 = vitalInfo.maxValue;
        }
        if ((i2 & 8) != 0) {
            d3 = vitalInfo.meanValue;
        }
        double d4 = d3;
        return vitalInfo.copy(i, d, d2, d4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSampleCount() {
        return this.sampleCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getMinValue() {
        return this.minValue;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getMaxValue() {
        return this.maxValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getMeanValue() {
        return this.meanValue;
    }

    public final VitalInfo copy(int sampleCount, double minValue, double maxValue, double meanValue) {
        return new VitalInfo(sampleCount, minValue, maxValue, meanValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VitalInfo)) {
            return false;
        }
        VitalInfo vitalInfo = (VitalInfo) other;
        return this.sampleCount == vitalInfo.sampleCount && Double.compare(this.minValue, vitalInfo.minValue) == 0 && Double.compare(this.maxValue, vitalInfo.maxValue) == 0 && Double.compare(this.meanValue, vitalInfo.meanValue) == 0;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.sampleCount) * 31) + Double.hashCode(this.minValue)) * 31) + Double.hashCode(this.maxValue)) * 31) + Double.hashCode(this.meanValue);
    }

    public String toString() {
        return "VitalInfo(sampleCount=" + this.sampleCount + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", meanValue=" + this.meanValue + ")";
    }

    public VitalInfo(int i, double d, double d2, double d3) {
        this.sampleCount = i;
        this.minValue = d;
        this.maxValue = d2;
        this.meanValue = d3;
    }

    public final int getSampleCount() {
        return this.sampleCount;
    }

    public final double getMinValue() {
        return this.minValue;
    }

    public final double getMaxValue() {
        return this.maxValue;
    }

    public final double getMeanValue() {
        return this.meanValue;
    }

    /* JADX INFO: compiled from: VitalInfo.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/VitalInfo$Companion;", "", "()V", "EMPTY", "Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "getEMPTY", "()Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VitalInfo getEMPTY() {
            return VitalInfo.EMPTY;
        }
    }
}
