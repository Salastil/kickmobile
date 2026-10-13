package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends f<List<? extends pV7834>> {
    private static int D8871 = 0;
    private static int component5 = 1;
    public static int component9;
    public static int setPivotYN16904;
    private final List<pV7834> vD14832N6715;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ List<? extends pV7834> setPivotYN16904() {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = (i2 ^ 111) + ((i2 & 111) << 1);
        component5 = i3 % 128;
        if (i3 % 2 != 0) {
            return component9();
        }
        component9();
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private List<pV7834> component9() {
        int i = 2 % 2;
        int i2 = D8871 + 105;
        int i3 = i2 % 128;
        component5 = i3;
        int i4 = i2 % 2;
        List<pV7834> list = this.vD14832N6715;
        int i5 = ((i3 | 87) << 1) - (i3 ^ 87);
        D8871 = i5 % 128;
        int i6 = i5 % 2;
        return list;
    }

    public e(List<pV7834> list) {
        super(null);
        this.vD14832N6715 = list;
    }

    public static int vD14832N6715() {
        int i = component9;
        int i2 = i % 8999601;
        component9 = i + 1;
        if (i2 != 0) {
            return setPivotYN16904;
        }
        int iNextInt = new Random().nextInt(288794869);
        setPivotYN16904 = iNextInt;
        return iNextInt;
    }
}
