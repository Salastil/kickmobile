package com.fingerprintjs.android.fpjs_pro_internal;

/* JADX INFO: loaded from: classes6.dex */
public final class h extends f<String> {
    private static int D8871 = 0;
    private static int component9 = 1;
    private final String vD14832N6715;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = (i2 & 31) + (i2 | 31);
        component9 = i3 % 128;
        int i4 = i3 % 2;
        String strComponent5 = component5();
        if (i4 == 0) {
            int i5 = 62 / 0;
        }
        return strComponent5;
    }

    private String component5() {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = i2 + 51;
        component9 = i3 % 128;
        int i4 = i3 % 2;
        String str = this.vD14832N6715;
        int i5 = i2 + 15;
        component9 = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 24 / 0;
        }
        return str;
    }

    public h(String str) {
        super(null);
        this.vD14832N6715 = str;
    }
}
