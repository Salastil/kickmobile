package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public final class N10124 extends wX26196 {
    public static int component5;
    public static int setPivotYN16904;

    public N10124(Integer num, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.kC4266.INSTANCE.component5(), num, setpivotyn16904);
    }

    public static int vD14832N6715() {
        int i = setPivotYN16904;
        int i2 = i % 7828748;
        setPivotYN16904 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iUptimeMillis = (int) SystemClock.uptimeMillis();
        component5 = iUptimeMillis;
        return iUptimeMillis;
    }
}
