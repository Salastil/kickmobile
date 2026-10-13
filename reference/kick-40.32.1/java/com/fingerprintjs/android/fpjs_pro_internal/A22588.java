package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;

/* JADX INFO: loaded from: classes6.dex */
public final class A22588 extends wX26196 {
    public static int component5;
    public static int component9;

    public A22588(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.W15084.INSTANCE.component5(), str, setpivotyn16904);
    }

    public static int vD14832N6715() {
        int i = component5;
        int i2 = i % 7839815;
        component5 = i + 1;
        if (i2 != 0) {
            return component9;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        component9 = elapsedCpuTime;
        return elapsedCpuTime;
    }
}
