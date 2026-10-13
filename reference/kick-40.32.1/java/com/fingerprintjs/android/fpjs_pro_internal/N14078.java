package com.fingerprintjs.android.fpjs_pro_internal;

import android.location.Location;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.GapComposerKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class N14078 {
    private static int N14263A23323 = 0;
    private static int setTopP6481 = 1;
    private final long D8871;
    private final component1H27181 component5;
    private final Location component9;
    private final boolean setPivotYN16904;
    private final List<setOnContextClickListenerE32038> vD14832N6715;

    public static /* synthetic */ Object vD14832N6715(Object[] objArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = ~((~i6) | i3);
        int i8 = ~i2;
        int i9 = i7 | (~(i8 | i3));
        int i10 = ~i3;
        int i11 = ~(i10 | i8);
        int i12 = ~(i10 | i6);
        int i13 = (~(i8 | i6)) | i11 | i12;
        int i14 = (~(i2 | i10)) | i12;
        int i15 = i6 + i3 + i4 + (1039959776 * i) + ((-2046201414) * i5);
        int i16 = i15 * i15;
        int i17 = ((357140864 * i6) - 8388608) + ((-1785926397) * i3) + ((-2146011519) * i9) + (i13 * 2146011519) + (2146011519 * i14) + ((-1788870656) * i4) + ((-201326592) * i) + ((-406847488) * i5) + (529399808 * i16);
        int i18 = ((i6 * 868240256) - 1765242424) + (i3 * 868238279) + (i9 * (-659)) + (i13 * 659) + (i14 * 659) + (i4 * 868239597) + (i * 817356128) + (i5 * 406493490) + (i16 * 645267456);
        int i19 = i17 + (i18 * i18 * 681705472);
        if (i19 == 1) {
            return component5(objArr);
        }
        if (i19 != 2) {
            return i19 != 3 ? D8871(objArr) : component9(objArr);
        }
        return setPivotYN16904(objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public N14078(Location location, boolean z, List<? extends setOnContextClickListenerE32038> list, long j, component1H27181 component1h27181) {
        this.component9 = location;
        this.setPivotYN16904 = z;
        this.vD14832N6715 = list;
        this.D8871 = j;
        this.component5 = component1h27181;
    }

    public final List<setOnContextClickListenerE32038> component9() {
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = (i2 ^ 93) + ((i2 & 93) << 1);
        N14263A23323 = i3 % 128;
        int i4 = i3 % 2;
        List<setOnContextClickListenerE32038> list = this.vD14832N6715;
        if (i4 == 0) {
            return list;
        }
        throw null;
    }

    private static /* synthetic */ Object D8871(Object[] objArr) {
        int i = 2 % 2;
        int i2 = N14263A23323 + 111;
        int i3 = i2 % 128;
        setTopP6481 = i3;
        if (i2 % 2 == 0) {
            int i4 = 79 / 0;
        }
        int i5 = i3 + GapComposerKt.nodeKey;
        N14263A23323 = i5 % 128;
        if (i5 % 2 == 0) {
            return "";
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        N14078 n14078 = (N14078) objArr[0];
        Object obj = objArr[1];
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = (i2 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i2 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
        int i4 = i3 % 128;
        N14263A23323 = i4;
        int i5 = i3 % 2;
        if (n14078 == obj) {
            int i6 = (i4 ^ 85) + ((i4 & 85) << 1);
            setTopP6481 = i6 % 128;
            int i7 = i6 % 2;
            return true;
        }
        if (!(obj instanceof N14078)) {
            int i8 = (i4 & 7) + (i4 | 7);
            int i9 = i8 % 128;
            setTopP6481 = i9;
            int i10 = i8 % 2;
            int i11 = i9 + 37;
            N14263A23323 = i11 % 128;
            if (i11 % 2 == 0) {
                return false;
            }
            throw null;
        }
        N14078 n14079 = (N14078) obj;
        if (!Intrinsics.areEqual(n14078.component9, n14079.component9)) {
            int i12 = N14263A23323 + 19;
            setTopP6481 = i12 % 128;
            int i13 = i12 % 2;
            return false;
        }
        if (n14078.setPivotYN16904 != n14079.setPivotYN16904) {
            return false;
        }
        if (!Intrinsics.areEqual(n14078.vD14832N6715, n14079.vD14832N6715)) {
            int i14 = N14263A23323;
            int i15 = (i14 & 19) + (i14 | 19);
            int i16 = i15 % 128;
            setTopP6481 = i16;
            int i17 = i15 % 2;
            int i18 = (i16 ^ 29) + ((i16 & 29) << 1);
            N14263A23323 = i18 % 128;
            int i19 = i18 % 2;
            return false;
        }
        if (n14078.D8871 != n14079.D8871) {
            return false;
        }
        if (Intrinsics.areEqual(n14078.component5, n14079.component5)) {
            int i20 = N14263A23323;
            int i21 = (i20 & 107) + (i20 | 107);
            setTopP6481 = i21 % 128;
            int i22 = i21 % 2;
            return true;
        }
        int i23 = setTopP6481;
        int i24 = ((i23 | 61) << 1) - (i23 ^ 61);
        N14263A23323 = i24 % 128;
        int i25 = i24 % 2;
        return false;
    }

    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) {
        N14078 n14078 = (N14078) objArr[0];
        int i = 2 % 2;
        int i2 = N14263A23323 + 21;
        int i3 = i2 % 128;
        setTopP6481 = i3;
        int i4 = i2 % 2;
        Location location = n14078.component9;
        int i5 = (i3 & 55) + (i3 | 55);
        N14263A23323 = i5 % 128;
        if (i5 % 2 == 0) {
            return location;
        }
        throw null;
    }

    private static /* synthetic */ Object component5(Object[] objArr) {
        N14078 n14078 = (N14078) objArr[0];
        int i = 2 % 2;
        int i2 = N14263A23323;
        int i3 = ((i2 | 9) << 1) - (i2 ^ 9);
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        List<setOnContextClickListenerE32038> list = n14078.vD14832N6715;
        if (i4 == 0) {
            int i5 = 3 / 0;
        }
        return list;
    }

    public final boolean equals(Object obj) {
        return ((Boolean) vD14832N6715(new Object[]{this, obj}, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), -1552097840, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), 1552097843)).booleanValue();
    }

    public final int hashCode() {
        int iHashCode;
        int i = 2 % 2;
        int i2 = N14263A23323;
        int i3 = (i2 ^ 29) + ((i2 & 29) << 1);
        int i4 = i3 % 128;
        setTopP6481 = i4;
        int i5 = i3 % 2;
        Location location = this.component9;
        if (location == null) {
            int i6 = i4 + 85;
            N14263A23323 = i6 % 128;
            iHashCode = i6 % 2 != 0 ? 1 : 0;
        } else {
            iHashCode = location.hashCode();
            int i7 = setTopP6481 + 5;
            N14263A23323 = i7 % 128;
            int i8 = i7 % 2;
        }
        int i9 = iHashCode * 31;
        int iHashCode2 = Boolean.hashCode(this.setPivotYN16904);
        int iComponent9 = getContentSensitivity.Companion.component9();
        int i10 = (iHashCode2 * (-300)) + (iHashCode * 9362);
        int i11 = iHashCode2 | i9;
        int i12 = (i10 - (~((~((i11 & iComponent9) | (i11 ^ iComponent9))) * (-301)))) - 1;
        int i13 = ~i9;
        int i14 = ~((i13 ^ iComponent9) | (i13 & iComponent9));
        int i15 = ~((~iComponent9) | iHashCode2);
        int i16 = i12 + (((i14 & i15) | (i14 ^ i15)) * (-301));
        int i17 = ~((~iHashCode2) | iComponent9);
        int i18 = ((i16 - (~(-(-(((i13 & i17) | (i13 ^ i17)) * 301))))) - 1) * 31;
        int iHashCode3 = this.vD14832N6715.hashCode();
        int i19 = (i18 ^ iHashCode3) + ((iHashCode3 & i18) << 1);
        int i20 = i19 * 31;
        int iHashCode4 = Long.hashCode(this.D8871);
        int iComponent10 = getContentSensitivity.Companion.component9();
        int i21 = iHashCode4 * (-947);
        int i22 = -(-(i19 * 29419));
        int i23 = (i21 ^ i22) + ((i22 & i21) << 1);
        int i24 = ~iHashCode4;
        int i25 = ~i20;
        int i26 = ~((i25 ^ iComponent10) | (i25 & iComponent10));
        int i27 = ((i26 & i24) | (i24 ^ i26)) * (-948);
        int i28 = ((i23 | i27) << 1) - (i23 ^ i27);
        int i29 = ~i20;
        int i30 = (i29 & i24) | (i24 ^ i29);
        int i31 = ~iComponent10;
        int i32 = (~((i30 & i31) | (i30 ^ i31))) * (-948);
        int i33 = (i28 & i32) + (i32 | i28);
        int i34 = -(-(((iHashCode4 ^ i25) | (iHashCode4 & i25)) * 948));
        int i35 = ((i33 ^ i34) + ((i34 & i33) << 1)) * 31;
        int i36 = -(-this.component5.hashCode());
        int i37 = (i35 & i36) + (i36 | i35);
        int i38 = setTopP6481 + 77;
        N14263A23323 = i38 % 128;
        int i39 = i38 % 2;
        return i37;
    }

    public final component1H27181 component8() {
        int i = 2 % 2;
        int i2 = N14263A23323;
        int i3 = ((i2 | 13) << 1) - (i2 ^ 13);
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        component1H27181 component1h27181 = this.component5;
        int i5 = i2 + 15;
        setTopP6481 = i5 % 128;
        int i6 = i5 % 2;
        return component1h27181;
    }

    public final long setPivotYN16904() {
        int i = 2 % 2;
        int i2 = N14263A23323;
        int i3 = i2 + 49;
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        long j = this.D8871;
        if (i4 == 0) {
            int i5 = 47 / 0;
        }
        int i6 = ((i2 | 47) << 1) - (i2 ^ 47);
        setTopP6481 = i6 % 128;
        if (i6 % 2 == 0) {
            int i7 = 55 / 0;
        }
        return j;
    }

    public final List<setOnContextClickListenerE32038> component5() {
        return (List) vD14832N6715(new Object[]{this}, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), -1787409004, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), 1787409005);
    }

    public final boolean D8871() {
        int i = 2 % 2;
        int i2 = N14263A23323 + 95;
        int i3 = i2 % 128;
        setTopP6481 = i3;
        int i4 = i2 % 2;
        boolean z = this.setPivotYN16904;
        int i5 = ((i3 | 43) << 1) - (i3 ^ 43);
        N14263A23323 = i5 % 128;
        int i6 = i5 % 2;
        return z;
    }

    public final Location vD14832N6715() {
        return (Location) vD14832N6715(new Object[]{this}, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), -1342293912, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), 1342293914);
    }

    public final String toString() {
        return (String) vD14832N6715(new Object[]{this}, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), 1603853211, getContentSensitivity.Companion.component9(), getContentSensitivity.Companion.component9(), -1603853211);
    }
}
