package com.datadog.android.rum.internal.domain.accessibility;

import com.datadog.android.rum.internal.domain.InfoData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessibilityInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJb\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0007\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0006\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\b\u0010\fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\n\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\t\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0004\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilityInfo;", "Lcom/datadog/android/rum/internal/domain/InfoData;", "textSize", "", "isScreenReaderEnabled", "", "isColorInversionEnabled", "isClosedCaptioningEnabled", "isReducedAnimationsEnabled", "isScreenPinningEnabled", "isRtlEnabled", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTextSize", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilityInfo;", "equals", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AccessibilityInfo implements InfoData {
    private final Boolean isClosedCaptioningEnabled;
    private final Boolean isColorInversionEnabled;
    private final Boolean isReducedAnimationsEnabled;
    private final Boolean isRtlEnabled;
    private final Boolean isScreenPinningEnabled;
    private final Boolean isScreenReaderEnabled;
    private final String textSize;

    public AccessibilityInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AccessibilityInfo copy$default(AccessibilityInfo accessibilityInfo, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accessibilityInfo.textSize;
        }
        if ((i & 2) != 0) {
            bool = accessibilityInfo.isScreenReaderEnabled;
        }
        if ((i & 4) != 0) {
            bool2 = accessibilityInfo.isColorInversionEnabled;
        }
        if ((i & 8) != 0) {
            bool3 = accessibilityInfo.isClosedCaptioningEnabled;
        }
        if ((i & 16) != 0) {
            bool4 = accessibilityInfo.isReducedAnimationsEnabled;
        }
        if ((i & 32) != 0) {
            bool5 = accessibilityInfo.isScreenPinningEnabled;
        }
        if ((i & 64) != 0) {
            bool6 = accessibilityInfo.isRtlEnabled;
        }
        Boolean bool7 = bool5;
        Boolean bool8 = bool6;
        Boolean bool9 = bool4;
        Boolean bool10 = bool2;
        return accessibilityInfo.copy(str, bool, bool10, bool3, bool9, bool7, bool8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTextSize() {
        return this.textSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getIsScreenReaderEnabled() {
        return this.isScreenReaderEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getIsColorInversionEnabled() {
        return this.isColorInversionEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsClosedCaptioningEnabled() {
        return this.isClosedCaptioningEnabled;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getIsReducedAnimationsEnabled() {
        return this.isReducedAnimationsEnabled;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsScreenPinningEnabled() {
        return this.isScreenPinningEnabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getIsRtlEnabled() {
        return this.isRtlEnabled;
    }

    public final AccessibilityInfo copy(String textSize, Boolean isScreenReaderEnabled, Boolean isColorInversionEnabled, Boolean isClosedCaptioningEnabled, Boolean isReducedAnimationsEnabled, Boolean isScreenPinningEnabled, Boolean isRtlEnabled) {
        return new AccessibilityInfo(textSize, isScreenReaderEnabled, isColorInversionEnabled, isClosedCaptioningEnabled, isReducedAnimationsEnabled, isScreenPinningEnabled, isRtlEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccessibilityInfo)) {
            return false;
        }
        AccessibilityInfo accessibilityInfo = (AccessibilityInfo) other;
        return Intrinsics.areEqual(this.textSize, accessibilityInfo.textSize) && Intrinsics.areEqual(this.isScreenReaderEnabled, accessibilityInfo.isScreenReaderEnabled) && Intrinsics.areEqual(this.isColorInversionEnabled, accessibilityInfo.isColorInversionEnabled) && Intrinsics.areEqual(this.isClosedCaptioningEnabled, accessibilityInfo.isClosedCaptioningEnabled) && Intrinsics.areEqual(this.isReducedAnimationsEnabled, accessibilityInfo.isReducedAnimationsEnabled) && Intrinsics.areEqual(this.isScreenPinningEnabled, accessibilityInfo.isScreenPinningEnabled) && Intrinsics.areEqual(this.isRtlEnabled, accessibilityInfo.isRtlEnabled);
    }

    public int hashCode() {
        String str = this.textSize;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isScreenReaderEnabled;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isColorInversionEnabled;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isClosedCaptioningEnabled;
        int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isReducedAnimationsEnabled;
        int iHashCode5 = (iHashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isScreenPinningEnabled;
        int iHashCode6 = (iHashCode5 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.isRtlEnabled;
        return iHashCode6 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        return "AccessibilityInfo(textSize=" + this.textSize + ", isScreenReaderEnabled=" + this.isScreenReaderEnabled + ", isColorInversionEnabled=" + this.isColorInversionEnabled + ", isClosedCaptioningEnabled=" + this.isClosedCaptioningEnabled + ", isReducedAnimationsEnabled=" + this.isReducedAnimationsEnabled + ", isScreenPinningEnabled=" + this.isScreenPinningEnabled + ", isRtlEnabled=" + this.isRtlEnabled + ")";
    }

    public AccessibilityInfo(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6) {
        this.textSize = str;
        this.isScreenReaderEnabled = bool;
        this.isColorInversionEnabled = bool2;
        this.isClosedCaptioningEnabled = bool3;
        this.isReducedAnimationsEnabled = bool4;
        this.isScreenPinningEnabled = bool5;
        this.isRtlEnabled = bool6;
    }

    public /* synthetic */ AccessibilityInfo(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : bool5, (i & 64) != 0 ? null : bool6);
    }

    public final String getTextSize() {
        return this.textSize;
    }

    public final Boolean isScreenReaderEnabled() {
        return this.isScreenReaderEnabled;
    }

    public final Boolean isColorInversionEnabled() {
        return this.isColorInversionEnabled;
    }

    public final Boolean isClosedCaptioningEnabled() {
        return this.isClosedCaptioningEnabled;
    }

    public final Boolean isReducedAnimationsEnabled() {
        return this.isReducedAnimationsEnabled;
    }

    public final Boolean isScreenPinningEnabled() {
        return this.isScreenPinningEnabled;
    }

    public final Boolean isRtlEnabled() {
        return this.isRtlEnabled;
    }
}
