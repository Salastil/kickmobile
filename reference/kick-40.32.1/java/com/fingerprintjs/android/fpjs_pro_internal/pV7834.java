package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class pV7834 {
    private static int component5 = 0;
    private static int vD14832N6715 = 1;
    private final String D8871;
    private final String component9;
    private final String setPivotYN16904;

    public static /* synthetic */ Object component5(int i, int i2, int i3, int i4, int i5, int i6, Object[] objArr) {
        int i7 = ~i;
        int i8 = (~(i7 | i2)) | (~(i7 | i3));
        int i9 = (~i2) | i;
        int i10 = ~(i9 | i3);
        int i11 = (~(i2 | (~i3))) | (~i9);
        int i12 = i + i3 + i5 + (243328196 * i4) + (549715570 * i6);
        int i13 = i12 * i12;
        int i14 = ((-90835549) * i) + 1264254976 + ((-1099560353) * i3) + (i8 * 1643121246) + (1643121246 * i10) + ((-1643121246) * i11) + (1552285696 * i5) + (781713408 * i4) + (665583616 * i6) + (1005256704 * i13);
        int i15 = (i * 1467389705) + 421362043 + (i3 * 1467387837) + (i8 * (-934)) + (i10 * (-934)) + (i11 * 934) + (i5 * 1467388771) + (i4 * (-1383267380)) + (i6 * 1030937622) + (i13 * 484507648);
        int i16 = i14 + (i15 * i15 * 1164771328);
        if (i16 == 1) {
            return component9(objArr);
        }
        if (i16 != 2) {
            return D8871(objArr);
        }
        pV7834 pv7834 = (pV7834) objArr[0];
        int i17 = 2 % 2;
        int i18 = component5;
        int i19 = (i18 & 15) + (i18 | 15);
        vD14832N6715 = i19 % 128;
        int i20 = i19 % 2;
        String str = pv7834.setPivotYN16904;
        int i21 = (i18 & 87) + (i18 | 87);
        vD14832N6715 = i21 % 128;
        int i22 = i21 % 2;
        return str;
    }

    public pV7834(String str, String str2, String str3) {
        this.setPivotYN16904 = str;
        this.component9 = str2;
        this.D8871 = str3;
    }

    private static /* synthetic */ Object D8871(Object[] objArr) {
        pV7834 pv7834 = (pV7834) objArr[0];
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = ((i2 | 75) << 1) - (i2 ^ 75);
        int i4 = i3 % 128;
        component5 = i4;
        int i5 = i3 % 2;
        String str = pv7834.component9;
        int i6 = i4 + 47;
        vD14832N6715 = i6 % 128;
        if (i6 % 2 != 0) {
            return str;
        }
        throw null;
    }

    public final String component5() {
        int i = 2 % 2;
        int i2 = vD14832N6715 + 41;
        component5 = i2 % 128;
        int i3 = i2 % 2;
        String str = this.D8871;
        if (i3 == 0) {
            return str;
        }
        throw null;
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        pV7834 pv7834 = (pV7834) objArr[0];
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = (i2 ^ 79) + ((i2 & 79) << 1);
        component5 = i3 % 128;
        if (i3 % 2 == 0) {
            return "CameraInfo(cameraName=" + pv7834.setPivotYN16904 + ", cameraType=" + pv7834.component9 + ", cameraOrientation=" + pv7834.D8871 + ")";
        }
        String str = pv7834.setPivotYN16904;
        String str2 = pv7834.component9;
        String str3 = pv7834.D8871;
        StringBuilder sb = new StringBuilder("CameraInfo(cameraName=");
        sb.append(str);
        sb.append(", cameraType=");
        sb.append(str2);
        sb.append(", cameraOrientation=");
        sb.append(str3);
        sb.append(")");
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final boolean equals(Object obj) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 2 % 2;
        int i6 = vD14832N6715;
        boolean z = true;
        int i7 = ((i6 | 81) << 1) - (i6 ^ 81);
        int i8 = i7 % 128;
        component5 = i8;
        int i9 = i7 % 2;
        if (this != obj) {
            if (!(obj instanceof pV7834)) {
                int i10 = (i6 & 17) + (i6 | 17);
                component5 = i10 % 128;
                return i10 % 2 != 0;
            }
            pV7834 pv7834 = (pV7834) obj;
            if (!Intrinsics.areEqual(this.setPivotYN16904, pv7834.setPivotYN16904)) {
                i4 = component5 + 77;
            } else {
                if (Intrinsics.areEqual(this.component9, pv7834.component9)) {
                    if (Intrinsics.areEqual(this.D8871, pv7834.D8871)) {
                        i = component5 + 81;
                    } else {
                        int i11 = vD14832N6715 + 49;
                        int i12 = i11 % 128;
                        component5 = i12;
                        z = i11 % 2 != 0;
                        i2 = i12 & 63;
                        i3 = i12 | 63;
                    }
                    vD14832N6715 = i % 128;
                    int i13 = i % 2;
                    return z;
                }
                i4 = component5 + 31;
            }
            vD14832N6715 = i4 % 128;
            int i14 = i4 % 2;
            return false;
        }
        i2 = i8 ^ 87;
        i3 = (i8 & 87) << 1;
        i = i2 + i3;
        vD14832N6715 = i % 128;
        int i15 = i % 2;
        return z;
    }

    public final int hashCode() {
        int i = 2 % 2;
        System.identityHashCode(this);
        aw.D8871();
        int iHashCode = this.setPivotYN16904.hashCode();
        int i2 = iHashCode * 31;
        int iHashCode2 = this.component9.hashCode();
        int iIdentityHashCode = System.identityHashCode(this);
        int i3 = ((iHashCode2 * (-419)) - (~(iHashCode * 13051))) - 1;
        int i4 = (~((i2 ^ iIdentityHashCode) | (i2 & iIdentityHashCode))) * 420;
        int i5 = ((i3 | i4) << 1) - (i4 ^ i3);
        int i6 = -(-(((~iHashCode2) | i2) * (-420)));
        int i7 = ((i5 | i6) << 1) - (i6 ^ i5);
        int i8 = ~iHashCode2;
        int i9 = ~i2;
        int i10 = ~((i8 & i9) | (i8 ^ i9));
        int i11 = ~iIdentityHashCode;
        int i12 = ~((i2 & i11) | (i11 ^ i2));
        int i13 = ((i10 & i12) | (i10 ^ i12)) * 420;
        int i14 = ((((i7 ^ i13) + ((i13 & i7) << 1)) * 31) - (~this.D8871.hashCode())) - 1;
        int i15 = vD14832N6715;
        int i16 = ((i15 | 71) << 1) - (i15 ^ 71);
        component5 = i16 % 128;
        if (i16 % 2 != 0) {
            int i17 = 96 / 0;
        }
        return i14;
    }

    public final String toString() {
        int iD8871 = aw.D8871();
        int iD8872 = aw.D8871();
        return (String) component5(169728598, iD8871, -169728597, aw.D8871(), iD8872, aw.D8871(), new Object[]{this});
    }

    public final String vD14832N6715() {
        int iD8871 = aw.D8871();
        int iD8872 = aw.D8871();
        return (String) component5(-779318097, iD8871, 779318097, aw.D8871(), iD8872, aw.D8871(), new Object[]{this});
    }

    public final String D8871() {
        int iD8871 = aw.D8871();
        int iD8872 = aw.D8871();
        return (String) component5(-1386182991, iD8871, 1386182993, aw.D8871(), iD8872, aw.D8871(), new Object[]{this});
    }
}
