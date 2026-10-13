package com.fingerprintjs.android.fpjs_pro_internal;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends f<String> {
    private static int D8871 = 0;
    private static int vD14832N6715 = 1;
    private final String component5;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = D8871 + 83;
        vD14832N6715 = i2 % 128;
        int i3 = i2 % 2;
        String strVD14832N6715 = vD14832N6715();
        int i4 = D8871;
        int i5 = (i4 & 89) + (i4 | 89);
        vD14832N6715 = i5 % 128;
        int i6 = i5 % 2;
        return strVD14832N6715;
    }

    private String vD14832N6715() {
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = (i2 ^ 115) + ((i2 & 115) << 1);
        D8871 = i3 % 128;
        int i4 = i3 % 2;
        String str = this.component5;
        if (i4 != 0) {
            throw null;
        }
        int i5 = i2 + 87;
        D8871 = i5 % 128;
        int i6 = i5 % 2;
        return str;
    }

    public b(String str) {
        super(null);
        this.component5 = str;
    }
}
