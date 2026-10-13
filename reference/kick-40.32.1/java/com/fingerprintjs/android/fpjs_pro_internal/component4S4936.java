package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public final class component4S4936 extends wX26196 {
    public static int D8871;
    public static int component5;

    public component4S4936(Boolean bool, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.rP23717.INSTANCE.component5(), bool, setpivotyn16904);
    }

    public static int D8871() {
        int i = component5;
        int i2 = i % 9699550;
        component5 = i + 1;
        if (i2 != 0) {
            return D8871;
        }
        int iNextInt = new Random().nextInt();
        D8871 = iNextInt;
        return iNextInt;
    }
}
