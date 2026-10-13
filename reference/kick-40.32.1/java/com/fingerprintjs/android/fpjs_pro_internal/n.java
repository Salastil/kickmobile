package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class n extends f<List<? extends setOnTouchListener>> {
    private static int D8871 = 0;
    public static int component5 = 0;
    private static int setPivotYN16904 = 1;
    public static int vD14832N6715;
    private final List<setOnTouchListener> component9;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ List<? extends setOnTouchListener> setPivotYN16904() {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = (i2 & 91) + (i2 | 91);
        setPivotYN16904 = i3 % 128;
        int i4 = i3 % 2;
        List<setOnTouchListener> listComponent5 = component5();
        int i5 = D8871;
        int i6 = (i5 & 17) + (i5 | 17);
        setPivotYN16904 = i6 % 128;
        int i7 = i6 % 2;
        return listComponent5;
    }

    private List<setOnTouchListener> component5() {
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 5;
        int i3 = i2 % 128;
        D8871 = i3;
        int i4 = i2 % 2;
        List<setOnTouchListener> list = this.component9;
        int i5 = i3 + 81;
        setPivotYN16904 = i5 % 128;
        int i6 = i5 % 2;
        return list;
    }

    public n(List<setOnTouchListener> list) {
        super(null);
        this.component9 = list;
    }

    public static int vD14832N6715() {
        int i = vD14832N6715;
        int i2 = i % 7003507;
        vD14832N6715 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        component5 = elapsedCpuTime;
        return elapsedCpuTime;
    }
}
