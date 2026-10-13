package com.facebook.fresco.vito.core.impl.debug;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LightweightDebugOverlayFactory2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayConfig;", "", "showOrigin", "", "showDimensions", "showImageDimensions", "showFormat", "showUri", "showScaleType", "<init>", "(ZZZZZZ)V", "getShowOrigin", "()Z", "getShowDimensions", "getShowImageDimensions", "getShowFormat", "getShowUri", "getShowScaleType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LightweightDebugOverlayConfig {
    private final boolean showDimensions;
    private final boolean showFormat;
    private final boolean showImageDimensions;
    private final boolean showOrigin;
    private final boolean showScaleType;
    private final boolean showUri;

    public LightweightDebugOverlayConfig() {
        this(false, false, false, false, false, false, 63, null);
    }

    public static /* synthetic */ LightweightDebugOverlayConfig copy$default(LightweightDebugOverlayConfig lightweightDebugOverlayConfig, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 1) != 0) {
            z = lightweightDebugOverlayConfig.showOrigin;
        }
        if ((i & 2) != 0) {
            z2 = lightweightDebugOverlayConfig.showDimensions;
        }
        if ((i & 4) != 0) {
            z3 = lightweightDebugOverlayConfig.showImageDimensions;
        }
        if ((i & 8) != 0) {
            z4 = lightweightDebugOverlayConfig.showFormat;
        }
        if ((i & 16) != 0) {
            z5 = lightweightDebugOverlayConfig.showUri;
        }
        if ((i & 32) != 0) {
            z6 = lightweightDebugOverlayConfig.showScaleType;
        }
        boolean z7 = z5;
        boolean z8 = z6;
        return lightweightDebugOverlayConfig.copy(z, z2, z3, z4, z7, z8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowOrigin() {
        return this.showOrigin;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowDimensions() {
        return this.showDimensions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowImageDimensions() {
        return this.showImageDimensions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowFormat() {
        return this.showFormat;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowUri() {
        return this.showUri;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShowScaleType() {
        return this.showScaleType;
    }

    public final LightweightDebugOverlayConfig copy(boolean showOrigin, boolean showDimensions, boolean showImageDimensions, boolean showFormat, boolean showUri, boolean showScaleType) {
        return new LightweightDebugOverlayConfig(showOrigin, showDimensions, showImageDimensions, showFormat, showUri, showScaleType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LightweightDebugOverlayConfig)) {
            return false;
        }
        LightweightDebugOverlayConfig lightweightDebugOverlayConfig = (LightweightDebugOverlayConfig) other;
        return this.showOrigin == lightweightDebugOverlayConfig.showOrigin && this.showDimensions == lightweightDebugOverlayConfig.showDimensions && this.showImageDimensions == lightweightDebugOverlayConfig.showImageDimensions && this.showFormat == lightweightDebugOverlayConfig.showFormat && this.showUri == lightweightDebugOverlayConfig.showUri && this.showScaleType == lightweightDebugOverlayConfig.showScaleType;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.showOrigin) * 31) + Boolean.hashCode(this.showDimensions)) * 31) + Boolean.hashCode(this.showImageDimensions)) * 31) + Boolean.hashCode(this.showFormat)) * 31) + Boolean.hashCode(this.showUri)) * 31) + Boolean.hashCode(this.showScaleType);
    }

    public String toString() {
        return "LightweightDebugOverlayConfig(showOrigin=" + this.showOrigin + ", showDimensions=" + this.showDimensions + ", showImageDimensions=" + this.showImageDimensions + ", showFormat=" + this.showFormat + ", showUri=" + this.showUri + ", showScaleType=" + this.showScaleType + ")";
    }

    public LightweightDebugOverlayConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.showOrigin = z;
        this.showDimensions = z2;
        this.showImageDimensions = z3;
        this.showFormat = z4;
        this.showUri = z5;
        this.showScaleType = z6;
    }

    public /* synthetic */ LightweightDebugOverlayConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z6);
    }

    public final boolean getShowOrigin() {
        return this.showOrigin;
    }

    public final boolean getShowDimensions() {
        return this.showDimensions;
    }

    public final boolean getShowImageDimensions() {
        return this.showImageDimensions;
    }

    public final boolean getShowFormat() {
        return this.showFormat;
    }

    public final boolean getShowUri() {
        return this.showUri;
    }

    public final boolean getShowScaleType() {
        return this.showScaleType;
    }
}
