package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends f<String> {
    private static int D8871 = 1;
    public static int component5;
    private static int component9;
    public static int vD14832N6715;
    private final String setPivotYN16904;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = component9 + 21;
        D8871 = i2 % 128;
        Object obj = null;
        if (i2 % 2 == 0) {
            component9();
            obj.hashCode();
            throw null;
        }
        String strComponent9 = component9();
        int i3 = D8871;
        int i4 = ((i3 | 3) << 1) - (i3 ^ 3);
        component9 = i4 % 128;
        if (i4 % 2 == 0) {
            return strComponent9;
        }
        obj.hashCode();
        throw null;
    }

    private String component9() {
        int i = 2 % 2;
        System.identityHashCode(this);
        System.identityHashCode(this);
        String str = this.setPivotYN16904;
        int i2 = component9 + 103;
        D8871 = i2 % 128;
        int i3 = i2 % 2;
        return str;
    }

    public d(String str) {
        super(null);
        this.setPivotYN16904 = str;
    }

    public static int component5() {
        int i = vD14832N6715;
        int i2 = i % 9928775;
        vD14832N6715 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iMyUid = Process.myUid();
        component5 = iMyUid;
        return iMyUid;
    }
}
