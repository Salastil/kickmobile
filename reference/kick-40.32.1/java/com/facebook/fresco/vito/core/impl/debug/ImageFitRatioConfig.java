package com.facebook.fresco.vito.core.impl.debug;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DebugDataProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/ImageFitRatioConfig;", "", "greenMinRatio", "", "greenMaxRatio", "yellowMaxRatio", "wastedMemoryRedThresholdBytes", "", "<init>", "(FFFJ)V", "getGreenMinRatio", "()F", "getGreenMaxRatio", "getYellowMaxRatio", "getWastedMemoryRedThresholdBytes", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core-common-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageFitRatioConfig {
    private final float greenMaxRatio;
    private final float greenMinRatio;
    private final long wastedMemoryRedThresholdBytes;
    private final float yellowMaxRatio;

    public ImageFitRatioConfig() {
        this(0.0f, 0.0f, 0.0f, 0L, 15, null);
    }

    public static /* synthetic */ ImageFitRatioConfig copy$default(ImageFitRatioConfig imageFitRatioConfig, float f, float f2, float f3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            f = imageFitRatioConfig.greenMinRatio;
        }
        if ((i & 2) != 0) {
            f2 = imageFitRatioConfig.greenMaxRatio;
        }
        if ((i & 4) != 0) {
            f3 = imageFitRatioConfig.yellowMaxRatio;
        }
        if ((i & 8) != 0) {
            j = imageFitRatioConfig.wastedMemoryRedThresholdBytes;
        }
        float f4 = f3;
        return imageFitRatioConfig.copy(f, f2, f4, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getGreenMinRatio() {
        return this.greenMinRatio;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getGreenMaxRatio() {
        return this.greenMaxRatio;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getYellowMaxRatio() {
        return this.yellowMaxRatio;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getWastedMemoryRedThresholdBytes() {
        return this.wastedMemoryRedThresholdBytes;
    }

    public final ImageFitRatioConfig copy(float greenMinRatio, float greenMaxRatio, float yellowMaxRatio, long wastedMemoryRedThresholdBytes) {
        return new ImageFitRatioConfig(greenMinRatio, greenMaxRatio, yellowMaxRatio, wastedMemoryRedThresholdBytes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageFitRatioConfig)) {
            return false;
        }
        ImageFitRatioConfig imageFitRatioConfig = (ImageFitRatioConfig) other;
        return Float.compare(this.greenMinRatio, imageFitRatioConfig.greenMinRatio) == 0 && Float.compare(this.greenMaxRatio, imageFitRatioConfig.greenMaxRatio) == 0 && Float.compare(this.yellowMaxRatio, imageFitRatioConfig.yellowMaxRatio) == 0 && this.wastedMemoryRedThresholdBytes == imageFitRatioConfig.wastedMemoryRedThresholdBytes;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.greenMinRatio) * 31) + Float.hashCode(this.greenMaxRatio)) * 31) + Float.hashCode(this.yellowMaxRatio)) * 31) + Long.hashCode(this.wastedMemoryRedThresholdBytes);
    }

    public String toString() {
        return "ImageFitRatioConfig(greenMinRatio=" + this.greenMinRatio + ", greenMaxRatio=" + this.greenMaxRatio + ", yellowMaxRatio=" + this.yellowMaxRatio + ", wastedMemoryRedThresholdBytes=" + this.wastedMemoryRedThresholdBytes + ")";
    }

    public ImageFitRatioConfig(float f, float f2, float f3, long j) {
        this.greenMinRatio = f;
        this.greenMaxRatio = f2;
        this.yellowMaxRatio = f3;
        this.wastedMemoryRedThresholdBytes = j;
    }

    public /* synthetic */ ImageFitRatioConfig(float f, float f2, float f3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.9f : f, (i & 2) != 0 ? 1.1f : f2, (i & 4) != 0 ? 1.5f : f3, (i & 8) != 0 ? 1048576L : j);
    }

    public final float getGreenMinRatio() {
        return this.greenMinRatio;
    }

    public final float getGreenMaxRatio() {
        return this.greenMaxRatio;
    }

    public final float getYellowMaxRatio() {
        return this.yellowMaxRatio;
    }

    public final long getWastedMemoryRedThresholdBytes() {
        return this.wastedMemoryRedThresholdBytes;
    }
}
