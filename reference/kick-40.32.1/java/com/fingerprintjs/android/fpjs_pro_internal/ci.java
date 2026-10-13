package com.fingerprintjs.android.fpjs_pro_internal;

/* JADX INFO: loaded from: classes6.dex */
public final class ci {
    public int component5;
    public int setPivotYN16904;
    public int vD14832N6715;

    public static void setPivotYN16904(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    public static int D8871(int i) {
        bw bwVar = bw.D8871;
        return ((bwVar.component5[0][(i >>> 24) & 255] + bwVar.component5[1][(i >>> 16) & 255]) ^ bwVar.component5[2][(i >>> 8) & 255]) + bwVar.component5[3][i & 255];
    }
}
