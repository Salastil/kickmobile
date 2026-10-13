package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public final class pC2922Q7530 extends wX26196 {
    public static int component5;
    public static int component9;

    public pC2922Q7530(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.E17257D21259.INSTANCE.component5(), str, setpivotyn16904);
    }

    public static int component5() {
        int i = component9;
        int i2 = i % 5361266;
        component9 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iNextInt = new Random().nextInt();
        component5 = iNextInt;
        return iNextInt;
    }
}
