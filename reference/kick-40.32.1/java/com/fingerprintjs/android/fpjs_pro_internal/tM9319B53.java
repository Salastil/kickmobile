package com.fingerprintjs.android.fpjs_pro_internal;

import com.fingerprintjs.android.fpjs_pro.TooManyRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class tM9319B53 {
    private static int D8871 = 1;
    private static int setPivotYN16904;
    private final String component5;
    private final String component9;

    public static /* synthetic */ Object D8871(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
        int i7 = ~i5;
        int i8 = (~(i7 | i3)) | (~(i7 | i2));
        int i9 = (~i3) | i5;
        int i10 = ~(i9 | i2);
        int i11 = (~(i3 | (~i2))) | (~i9);
        int i12 = i5 + i2 + i6 + (243328196 * i4) + (549715570 * i);
        int i13 = i12 * i12;
        int i14 = ((-90835549) * i5) + 1264254976 + ((-1099560353) * i2) + (i8 * 1643121246) + (1643121246 * i10) + ((-1643121246) * i11) + (1552285696 * i6) + (781713408 * i4) + (665583616 * i) + (1005256704 * i13);
        int i15 = (i5 * 1467389705) + 421362043 + (i2 * 1467387837) + (i8 * (-934)) + (i10 * (-934)) + (i11 * 934) + (i6 * 1467388771) + (i4 * (-1383267380)) + (i * 1030937622) + (i13 * 484507648);
        return i14 + ((i15 * i15) * 1164771328) != 1 ? component9(objArr) : setPivotYN16904(objArr);
    }

    public tM9319B53(String str, String str2) {
        this.component9 = str;
        this.component5 = str2;
    }

    public final String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = D8871 + 7;
        int i3 = i2 % 128;
        setPivotYN16904 = i3;
        int i4 = i2 % 2;
        String str = this.component9;
        int i5 = i3 + 79;
        D8871 = i5 % 128;
        if (i5 % 2 != 0) {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final String vD14832N6715() {
        int i = 2 % 2;
        int i2 = D8871 + 33;
        int i3 = i2 % 128;
        setPivotYN16904 = i3;
        int i4 = i2 % 2;
        String str = this.component5;
        if (i4 != 0) {
            int i5 = 20 / 0;
        }
        int i6 = (i3 & 35) + (i3 | 35);
        D8871 = i6 % 128;
        if (i6 % 2 != 0) {
            return str;
        }
        throw null;
    }

    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) {
        tM9319B53 tm9319b53 = (tM9319B53) objArr[0];
        Object obj = objArr[1];
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = ((i2 | 47) << 1) - (i2 ^ 47);
        int i4 = i3 % 128;
        D8871 = i4;
        if (i3 % 2 == 0) {
            Object obj2 = null;
            obj2.hashCode();
            throw null;
        }
        if (tm9319b53 == obj) {
            int i5 = ((i2 | 19) << 1) - (i2 ^ 19);
            D8871 = i5 % 128;
            int i6 = i5 % 2;
            return true;
        }
        if (!(obj instanceof tM9319B53)) {
            int i7 = (i4 & 57) + (i4 | 57);
            setPivotYN16904 = i7 % 128;
            int i8 = i7 % 2;
            return false;
        }
        tM9319B53 tm9319b54 = (tM9319B53) obj;
        if (!Intrinsics.areEqual(tm9319b53.component9, tm9319b54.component9)) {
            int i9 = D8871 + 17;
            setPivotYN16904 = i9 % 128;
            return i9 % 2 != 0;
        }
        if (Intrinsics.areEqual(tm9319b53.component5, tm9319b54.component5)) {
            int i10 = D8871;
            int i11 = (i10 ^ 57) + ((i10 & 57) << 1);
            setPivotYN16904 = i11 % 128;
            int i12 = i11 % 2;
            return true;
        }
        int i13 = setPivotYN16904;
        int i14 = (i13 ^ 39) + ((i13 & 39) << 1);
        D8871 = i14 % 128;
        int i15 = i14 % 2;
        return false;
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        int iHashCode;
        tM9319B53 tm9319b53 = (tM9319B53) objArr[0];
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 51;
        D8871 = i2 % 128;
        if (i2 % 2 == 0) {
            iHashCode = (tm9319b53.component9.hashCode() % 68) + tm9319b53.component5.hashCode();
        } else {
            int iHashCode2 = tm9319b53.component9.hashCode() * 31;
            int i3 = -(-tm9319b53.component5.hashCode());
            iHashCode = (iHashCode2 ^ i3) + ((i3 & iHashCode2) << 1);
        }
        int i4 = setPivotYN16904;
        int i5 = (i4 & 45) + (i4 | 45);
        D8871 = i5 % 128;
        if (i5 % 2 != 0) {
            return Integer.valueOf(iHashCode);
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        int iVD14832N6715 = TooManyRequest.vD14832N6715();
        int iVD14832N6716 = TooManyRequest.vD14832N6715();
        int iVD14832N6717 = TooManyRequest.vD14832N6715();
        return ((Boolean) D8871(TooManyRequest.vD14832N6715(), -1657538540, iVD14832N6715, iVD14832N6717, new Object[]{this, obj}, 1657538541, iVD14832N6716)).booleanValue();
    }

    public final int hashCode() {
        int iVD14832N6715 = TooManyRequest.vD14832N6715();
        int iVD14832N6716 = TooManyRequest.vD14832N6715();
        int iVD14832N6717 = TooManyRequest.vD14832N6715();
        return ((Integer) D8871(TooManyRequest.vD14832N6715(), -979634982, iVD14832N6715, iVD14832N6717, new Object[]{this}, 979634982, iVD14832N6716)).intValue();
    }

    public final String toString() {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = (i2 & 123) + (i2 | 123);
        setPivotYN16904 = i3 % 128;
        int i4 = i3 % 2;
        String str = this.component9;
        String str2 = this.component5;
        if (i4 != 0) {
            StringBuilder sb = new StringBuilder("InputDeviceData(name=");
            sb.append(str);
            sb.append(", vendor=");
            sb.append(str2);
            sb.append(")");
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        String str3 = "InputDeviceData(name=" + str + ", vendor=" + str2 + ")";
        int i5 = D8871 + 41;
        setPivotYN16904 = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 36 / 0;
        }
        return str3;
    }
}
