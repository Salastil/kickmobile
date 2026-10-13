package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;

/* JADX INFO: loaded from: classes6.dex */
public final class g extends f<Integer> {
    public static int D8871 = 0;
    private static int component9 = 1;
    public static int setPivotYN16904;
    private static int vD14832N6715;
    private final int component5;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ Integer setPivotYN16904() {
        int i = 2 % 2;
        int i2 = component9;
        int i3 = ((i2 | 43) << 1) - (i2 ^ 43);
        vD14832N6715 = i3 % 128;
        int i4 = i3 % 2;
        Integer numVD14832N6715 = vD14832N6715();
        int i5 = vD14832N6715;
        int i6 = (i5 & 79) + (i5 | 79);
        component9 = i6 % 128;
        if (i6 % 2 != 0) {
            return numVD14832N6715;
        }
        throw null;
    }

    private Integer vD14832N6715() {
        int i = 2 % 2;
        int i2 = component9 + 67;
        vD14832N6715 = i2 % 128;
        int i3 = i2 % 2;
        Integer numValueOf = Integer.valueOf(this.component5);
        int i4 = vD14832N6715 + 13;
        component9 = i4 % 128;
        if (i4 % 2 != 0) {
            return numValueOf;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public g(int i) {
        super(null);
        this.component5 = i;
    }

    public static int component5() {
        int i = D8871;
        int i2 = i % 5945561;
        D8871 = i + 1;
        if (i2 != 0) {
            return setPivotYN16904;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        setPivotYN16904 = elapsedCpuTime;
        return elapsedCpuTime;
    }
}
