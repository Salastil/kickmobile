package com.swmansion.rnscreens.gamma.modals.formsheet;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 '2\u00020\u0001:\u0001'BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018JR\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\tHÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetConfig;", "", "isOpen", "", "detents", "", "", "prefersGrabberVisible", "initialDetentIndex", "", "preferredCornerRadius", "", "nativeContainerBackgroundColor", "<init>", "(ZLjava/util/List;ZIFLjava/lang/Integer;)V", "()Z", "getDetents", "()Ljava/util/List;", "getPrefersGrabberVisible", "getInitialDetentIndex", "()I", "getPreferredCornerRadius", "()F", "getNativeContainerBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/util/List;ZIFLjava/lang/Integer;)Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetConfig;", "equals", "other", "hashCode", "toString", "", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FormSheetConfig {
    public static final float SYSTEM_DEFAULT_CORNER_RADIUS = -1.0f;
    private final List<Double> detents;
    private final int initialDetentIndex;
    private final boolean isOpen;
    private final Integer nativeContainerBackgroundColor;
    private final float preferredCornerRadius;
    private final boolean prefersGrabberVisible;

    public FormSheetConfig() {
        this(false, null, false, 0, 0.0f, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FormSheetConfig copy$default(FormSheetConfig formSheetConfig, boolean z, List list, boolean z2, int i, float f, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = formSheetConfig.isOpen;
        }
        if ((i2 & 2) != 0) {
            list = formSheetConfig.detents;
        }
        if ((i2 & 4) != 0) {
            z2 = formSheetConfig.prefersGrabberVisible;
        }
        if ((i2 & 8) != 0) {
            i = formSheetConfig.initialDetentIndex;
        }
        if ((i2 & 16) != 0) {
            f = formSheetConfig.preferredCornerRadius;
        }
        if ((i2 & 32) != 0) {
            num = formSheetConfig.nativeContainerBackgroundColor;
        }
        float f2 = f;
        Integer num2 = num;
        return formSheetConfig.copy(z, list, z2, i, f2, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsOpen() {
        return this.isOpen;
    }

    public final List<Double> component2() {
        return this.detents;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getPrefersGrabberVisible() {
        return this.prefersGrabberVisible;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getInitialDetentIndex() {
        return this.initialDetentIndex;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getPreferredCornerRadius() {
        return this.preferredCornerRadius;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getNativeContainerBackgroundColor() {
        return this.nativeContainerBackgroundColor;
    }

    public final FormSheetConfig copy(boolean isOpen, List<Double> detents, boolean prefersGrabberVisible, int initialDetentIndex, float preferredCornerRadius, Integer nativeContainerBackgroundColor) {
        Intrinsics.checkNotNullParameter(detents, "detents");
        return new FormSheetConfig(isOpen, detents, prefersGrabberVisible, initialDetentIndex, preferredCornerRadius, nativeContainerBackgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormSheetConfig)) {
            return false;
        }
        FormSheetConfig formSheetConfig = (FormSheetConfig) other;
        return this.isOpen == formSheetConfig.isOpen && Intrinsics.areEqual(this.detents, formSheetConfig.detents) && this.prefersGrabberVisible == formSheetConfig.prefersGrabberVisible && this.initialDetentIndex == formSheetConfig.initialDetentIndex && Float.compare(this.preferredCornerRadius, formSheetConfig.preferredCornerRadius) == 0 && Intrinsics.areEqual(this.nativeContainerBackgroundColor, formSheetConfig.nativeContainerBackgroundColor);
    }

    public int hashCode() {
        int iHashCode = ((((((((Boolean.hashCode(this.isOpen) * 31) + this.detents.hashCode()) * 31) + Boolean.hashCode(this.prefersGrabberVisible)) * 31) + Integer.hashCode(this.initialDetentIndex)) * 31) + Float.hashCode(this.preferredCornerRadius)) * 31;
        Integer num = this.nativeContainerBackgroundColor;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "FormSheetConfig(isOpen=" + this.isOpen + ", detents=" + this.detents + ", prefersGrabberVisible=" + this.prefersGrabberVisible + ", initialDetentIndex=" + this.initialDetentIndex + ", preferredCornerRadius=" + this.preferredCornerRadius + ", nativeContainerBackgroundColor=" + this.nativeContainerBackgroundColor + ")";
    }

    public FormSheetConfig(boolean z, List<Double> detents, boolean z2, int i, float f, Integer num) {
        Intrinsics.checkNotNullParameter(detents, "detents");
        this.isOpen = z;
        this.detents = detents;
        this.prefersGrabberVisible = z2;
        this.initialDetentIndex = i;
        this.preferredCornerRadius = f;
        this.nativeContainerBackgroundColor = num;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public /* synthetic */ FormSheetConfig(boolean z, List list, boolean z2, int i, float f, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? -1.0f : f, (i2 & 32) != 0 ? null : num);
    }

    public final List<Double> getDetents() {
        return this.detents;
    }

    public final boolean getPrefersGrabberVisible() {
        return this.prefersGrabberVisible;
    }

    public final int getInitialDetentIndex() {
        return this.initialDetentIndex;
    }

    public final float getPreferredCornerRadius() {
        return this.preferredCornerRadius;
    }

    public final Integer getNativeContainerBackgroundColor() {
        return this.nativeContainerBackgroundColor;
    }
}
