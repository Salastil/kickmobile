package com.fingerprintjs.android.fpjs_pro_internal;

/* JADX INFO: loaded from: classes6.dex */
public class bo {
    private static int component9 = 1;
    private static int setPivotYN16904;
    private final byte[] component5;

    public bo(byte[] bArr) {
        this.component5 = bArr;
    }

    public final byte[] setPivotYN16904() {
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = ((i2 | 77) << 1) - (i2 ^ 77);
        component9 = i3 % 128;
        int i4 = i3 % 2;
        byte[] bArr = this.component5;
        if (i4 == 0) {
            int i5 = 57 / 0;
        }
        return bArr;
    }
}
