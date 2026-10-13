package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class qU20128 {
    public static int component5 = 0;
    private static int component8 = 0;
    public static int setPivotYN16904 = 0;
    private static int setTopP6481 = 1;
    private final boolean D8871;
    private final long N14263A23323;
    private final List<String> component9;
    private final String vD14832N6715;

    public static /* synthetic */ Object vD14832N6715(int i, int i2, int i3, Object[] objArr, int i4, int i5, int i6) {
        int i7 = ~i6;
        int i8 = ~((~i4) | i7);
        int i9 = ~i3;
        int i10 = i8 | (~(i9 | i4)) | (~(i6 | i4));
        int i11 = i7 | i4;
        int i12 = i9 | i11;
        int i13 = i6 + i4 + i + ((-1542968645) * i5) + (1789173782 * i2);
        int i14 = i13 * i13;
        int i15 = (1553370224 * i6) + 752877568 + ((-368479342) * i4) + (i10 * 1186558865) + (1921849566 * i11) + (1186558865 * i12) + ((-1555038208) * i) + (1802502144 * i5) + (148897792 * i2) + (289275904 * i14);
        int i16 = (i6 * (-930071408)) + 1959937684 + (i4 * (-930070194)) + (i10 * TypedValues.Motion.TYPE_PATHMOTION_ARC) + (i11 * (-1214)) + (i12 * TypedValues.Motion.TYPE_PATHMOTION_ARC) + (i * (-930070801)) + (i5 * 1059663509) + (i2 * (-1428764534)) + (i14 * 484573184);
        if (i15 + (i16 * i16 * 411172864) == 1) {
            return D8871(objArr);
        }
        qU20128 qu20128 = (qU20128) objArr[0];
        int i17 = 2 % 2;
        int i18 = setTopP6481 + 17;
        int i19 = i18 % 128;
        component8 = i19;
        int i20 = i18 % 2;
        List<String> list = qu20128.component9;
        int i21 = (i19 ^ 69) + ((i19 & 69) << 1);
        setTopP6481 = i21 % 128;
        int i22 = i21 % 2;
        return list;
    }

    public qU20128(List<String> list, boolean z, String str, long j) {
        this.component9 = list;
        this.D8871 = z;
        this.vD14832N6715 = str;
        this.N14263A23323 = j;
    }

    public final boolean setPivotYN16904() {
        int i = 2 % 2;
        int i2 = component8;
        int i3 = (i2 & 1) + (i2 | 1);
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        boolean z = this.D8871;
        if (i4 == 0) {
            int i5 = 78 / 0;
        }
        return z;
    }

    private static /* synthetic */ Object D8871(Object[] objArr) {
        qU20128 qu20128 = (qU20128) objArr[0];
        int i = 2 % 2;
        int i2 = component8;
        int i3 = ((i2 | 1) << 1) - (i2 ^ 1);
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        String str = qu20128.vD14832N6715;
        if (i4 != 0) {
            return str;
        }
        throw null;
    }

    public final long component5() {
        int i = 2 % 2;
        int i2 = setTopP6481 + 81;
        int i3 = i2 % 128;
        component8 = i3;
        int i4 = i2 % 2;
        long j = this.N14263A23323;
        if (i4 != 0) {
            int i5 = 64 / 0;
        }
        int i6 = ((i3 | 103) << 1) - (i3 ^ 103);
        setTopP6481 = i6 % 128;
        int i7 = i6 % 2;
        return j;
    }

    public static int vD14832N6715() {
        int i = component5;
        int i2 = i % 6826473;
        component5 = i + 1;
        if (i2 != 0) {
            return setPivotYN16904;
        }
        int i3 = (int) Runtime.getRuntime().totalMemory();
        setPivotYN16904 = i3;
        return i3;
    }

    public final String component9() {
        int iComponent5 = pC2922Q7530.component5();
        int iComponent6 = pC2922Q7530.component5();
        int iComponent7 = pC2922Q7530.component5();
        return (String) vD14832N6715(iComponent6, pC2922Q7530.component5(), iComponent5, new Object[]{this}, -736406098, iComponent7, 736406099);
    }

    public final List<String> D8871() {
        int iComponent5 = pC2922Q7530.component5();
        int iComponent6 = pC2922Q7530.component5();
        int iComponent7 = pC2922Q7530.component5();
        return (List) vD14832N6715(iComponent6, pC2922Q7530.component5(), iComponent5, new Object[]{this}, -433918051, iComponent7, 433918051);
    }
}
