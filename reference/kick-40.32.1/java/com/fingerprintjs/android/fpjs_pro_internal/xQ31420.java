package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public final class xQ31420 extends wX26196 {
    public static int D8871;
    public static int vD14832N6715;

    public xQ31420(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.ENTRIES.INSTANCE.component5(), str, setpivotyn16904);
    }

    public static int component5() {
        int i = vD14832N6715;
        int i2 = i % 6829855;
        vD14832N6715 = i + 1;
        if (i2 != 0) {
            return D8871;
        }
        int iNextInt = new Random().nextInt(452309902);
        D8871 = iNextInt;
        return iNextInt;
    }
}
