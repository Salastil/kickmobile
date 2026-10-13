package com.facebook.drawee.drawable;

import android.graphics.Rect;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Viewport.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/facebook/drawee/drawable/Viewport;", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "scaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "sizingHint", "Lcom/facebook/drawee/drawable/SizingHint;", "<init>", "(IILcom/facebook/drawee/drawable/ScalingUtils$ScaleType;Lcom/facebook/drawee/drawable/SizingHint;)V", "getWidth", "()I", "getHeight", "getScaleType", "()Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "getSizingHint", "()Lcom/facebook/drawee/drawable/SizingHint;", "toRect", "Landroid/graphics/Rect;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Viewport {
    private final int height;
    private final ScalingUtils.ScaleType scaleType;
    private final SizingHint sizingHint;
    private final int width;

    public static /* synthetic */ Viewport copy$default(Viewport viewport, int i, int i2, ScalingUtils.ScaleType scaleType, SizingHint sizingHint, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = viewport.width;
        }
        if ((i3 & 2) != 0) {
            i2 = viewport.height;
        }
        if ((i3 & 4) != 0) {
            scaleType = viewport.scaleType;
        }
        if ((i3 & 8) != 0) {
            sizingHint = viewport.sizingHint;
        }
        return viewport.copy(i, i2, scaleType, sizingHint);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ScalingUtils.ScaleType getScaleType() {
        return this.scaleType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SizingHint getSizingHint() {
        return this.sizingHint;
    }

    public final Viewport copy(int width, int height, ScalingUtils.ScaleType scaleType, SizingHint sizingHint) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(sizingHint, "sizingHint");
        return new Viewport(width, height, scaleType, sizingHint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Viewport)) {
            return false;
        }
        Viewport viewport = (Viewport) other;
        return this.width == viewport.width && this.height == viewport.height && Intrinsics.areEqual(this.scaleType, viewport.scaleType) && this.sizingHint == viewport.sizingHint;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + this.scaleType.hashCode()) * 31) + this.sizingHint.hashCode();
    }

    public String toString() {
        return "Viewport(width=" + this.width + ", height=" + this.height + ", scaleType=" + this.scaleType + ", sizingHint=" + this.sizingHint + ")";
    }

    public Viewport(int i, int i2, ScalingUtils.ScaleType scaleType, SizingHint sizingHint) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(sizingHint, "sizingHint");
        this.width = i;
        this.height = i2;
        this.scaleType = scaleType;
        this.sizingHint = sizingHint;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final ScalingUtils.ScaleType getScaleType() {
        return this.scaleType;
    }

    public /* synthetic */ Viewport(int i, int i2, ScalingUtils.ScaleType scaleType, SizingHint sizingHint, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, scaleType, (i3 & 8) != 0 ? SizingHint.DEFAULT : sizingHint);
    }

    public final SizingHint getSizingHint() {
        return this.sizingHint;
    }

    public final Rect toRect() {
        return new Rect(0, 0, this.width, this.height);
    }
}
