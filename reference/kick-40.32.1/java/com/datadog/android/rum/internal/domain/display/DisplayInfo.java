package com.datadog.android.rum.internal.domain.display;

import com.datadog.android.rum.internal.domain.InfoData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "Lcom/datadog/android/rum/internal/domain/InfoData;", "screenBrightness", "", "(Ljava/lang/Number;)V", "getScreenBrightness", "()Ljava/lang/Number;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DisplayInfo implements InfoData {
    private final Number screenBrightness;

    /* JADX WARN: Multi-variable type inference failed */
    public DisplayInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DisplayInfo copy$default(DisplayInfo displayInfo, Number number, int i, Object obj) {
        if ((i & 1) != 0) {
            number = displayInfo.screenBrightness;
        }
        return displayInfo.copy(number);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Number getScreenBrightness() {
        return this.screenBrightness;
    }

    public final DisplayInfo copy(Number screenBrightness) {
        return new DisplayInfo(screenBrightness);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DisplayInfo) && Intrinsics.areEqual(this.screenBrightness, ((DisplayInfo) other).screenBrightness);
    }

    public int hashCode() {
        Number number = this.screenBrightness;
        if (number == null) {
            return 0;
        }
        return number.hashCode();
    }

    public String toString() {
        return "DisplayInfo(screenBrightness=" + this.screenBrightness + ")";
    }

    public DisplayInfo(Number number) {
        this.screenBrightness = number;
    }

    public /* synthetic */ DisplayInfo(Number number, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : number);
    }

    public final Number getScreenBrightness() {
        return this.screenBrightness;
    }
}
