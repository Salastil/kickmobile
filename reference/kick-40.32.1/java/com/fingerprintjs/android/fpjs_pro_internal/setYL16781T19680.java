package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class setYL16781T19680 {
    private static int D8871 = 1;
    private static int component5;
    public static int component9;
    public static int setPivotYN16904;

    public static final /* synthetic */ int vD14832N6715(af afVar) {
        int i = 2 % 2;
        int i2 = component5;
        int i3 = (i2 & 51) + (i2 | 51);
        D8871 = i3 % 128;
        int i4 = i3 % 2;
        int iComponent9 = component9(afVar);
        int i5 = D8871;
        int i6 = ((i5 | 73) << 1) - (i5 ^ 73);
        component5 = i6 % 128;
        int i7 = i6 % 2;
        return iComponent9;
    }

    private static final int component9(af afVar) {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = (i2 ^ 33) + ((i2 & 33) << 1);
        component5 = i3 % 128;
        int i4 = i3 % 2;
        if (Intrinsics.areEqual(afVar, af.component9.INSTANCE)) {
            int iVD14832N6715 = getContextMenuInfo.AnonymousClass3.vD14832N6715();
            int i5 = (~((802902923 ^ iVD14832N6715) | (802902923 & iVD14832N6715))) | 2400304;
            int i6 = ~(((-57454779) & iVD14832N6715) | ((-57454779) ^ iVD14832N6715));
            int i7 = 390179662 + (((i5 & i6) | (i5 ^ i6)) * (-880));
            int i8 = ~(802902923 | (~iVD14832N6715));
            int i9 = (i8 & 57454778) | (57454778 ^ i8);
            int i10 = ~((-802902924) | iVD14832N6715);
            int i11 = ((i9 & i10) | (i9 ^ i10)) * (-880);
            int i12 = (i7 & i11) + (i11 | i7) + ((~((iVD14832N6715 & (-802902924)) | ((-802902924) ^ iVD14832N6715))) * 880);
            int iVD14832N6716 = getContextMenuInfo.AnonymousClass3.vD14832N6715();
            int i13 = ~(((-1285254859) & iVD14832N6716) | ((-1285254859) ^ iVD14832N6716));
            int i14 = ((i13 & 135801858) | (135801858 ^ i13)) * (-566);
            int i15 = ((-1659109890) ^ i14) + ((i14 & (-1659109890)) << 1);
            return i12 > ((i15 ^ 2073559040) + ((2073559040 & i15) << 1)) + ((~((iVD14832N6716 & (-1149453001)) | ((-1149453001) ^ iVD14832N6716))) * 566) ? 1 : 0;
        }
        if (Intrinsics.areEqual(afVar, af.setPivotYN16904.INSTANCE)) {
            int i16 = D8871 + 115;
            int i17 = i16 % 128;
            component5 = i17;
            int i18 = i16 % 2;
            int i19 = i17 + 51;
            D8871 = i19 % 128;
            int i20 = i19 % 2;
            return 1;
        }
        if (!Intrinsics.areEqual(afVar, af.D8871.INSTANCE)) {
            if (!Intrinsics.areEqual(afVar, af.component5.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            int i21 = component5 + 79;
            D8871 = i21 % 128;
            return i21 % 2 == 0 ? 2 : 3;
        }
        int i22 = component5;
        int i23 = (i22 & 65) + (i22 | 65);
        int i24 = i23 % 128;
        D8871 = i24;
        int i25 = i23 % 2;
        int i26 = (i24 ^ 79) + ((i24 & 79) << 1);
        component5 = i26 % 128;
        if (i26 % 2 == 0) {
            return 2;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public static int vD14832N6715() {
        int i = component9;
        int i2 = i % 8527177;
        component9 = i + 1;
        if (i2 != 0) {
            return setPivotYN16904;
        }
        int iMyUid = Process.myUid();
        setPivotYN16904 = iMyUid;
        return iMyUid;
    }
}
