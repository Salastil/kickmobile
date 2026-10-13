package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Build;

/* JADX INFO: loaded from: classes6.dex */
public final class oN11246 {
    private static int D8871 = 1;
    private static int component5 = 1;
    private static final String component9;
    private static int setPivotYN16904;
    private static int vD14832N6715;

    public static final /* synthetic */ String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = (i2 & 77) + (i2 | 77);
        int i4 = i3 % 128;
        vD14832N6715 = i4;
        int i5 = i3 % 2;
        String str = component9;
        int i6 = i4 + 107;
        D8871 = i6 % 128;
        if (i6 % 2 == 0) {
            int i7 = 88 / 0;
        }
        return str;
    }

    static {
        String str;
        Object obj = null;
        if (Build.VERSION.SDK_INT >= 35) {
            int i = setPivotYN16904;
            int i2 = (i & 115) + (i | 115);
            component5 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            int i3 = 2 % 2;
            str = "content://com.google.android.gsf.gservices/prefix";
        } else {
            str = "content://com.google.android.gsf.gservices";
        }
        component9 = str;
        int i4 = setPivotYN16904 + 93;
        component5 = i4 % 128;
        if (i4 % 2 != 0) {
            return;
        }
        obj.hashCode();
        throw null;
    }
}
