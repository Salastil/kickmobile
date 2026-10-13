package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ENTRIES {
    private static int D8871 = 1;
    private static int setPivotYN16904;

    public static final /* synthetic */ int component9(List list) {
        int i = 2 % 2;
        int i2 = D8871 + 5;
        setPivotYN16904 = i2 % 128;
        int i3 = i2 % 2;
        int iVD14832N6715 = vD14832N6715(list);
        int i4 = setPivotYN16904 + 69;
        D8871 = i4 % 128;
        if (i4 % 2 != 0) {
            return iVD14832N6715;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static final int vD14832N6715(List<? extends setOnContextClickListenerE32038> list) {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = (i2 ^ 33) + ((i2 & 33) << 1);
        setPivotYN16904 = i3 % 128;
        int i4 = i3 % 2;
        if (!list.contains(setOnContextClickListenerE32038.setPivotYN16904.INSTANCE)) {
            int i5 = setPivotYN16904 + 119;
            D8871 = i5 % 128;
            int i6 = i5 % 2;
            return 1;
        }
        int i7 = D8871 + 79;
        int i8 = i7 % 128;
        setPivotYN16904 = i8;
        int i9 = i7 % 2;
        int i10 = ((i8 | 105) << 1) - (i8 ^ 105);
        D8871 = i10 % 128;
        if (i10 % 2 != 0) {
            return 0;
        }
        throw null;
    }
}
