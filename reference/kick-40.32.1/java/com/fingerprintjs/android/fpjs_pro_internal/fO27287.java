package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;

/* JADX INFO: loaded from: classes6.dex */
public final class fO27287 {
    private static int D8871 = 0;
    public static int component5 = 0;
    public static int component9 = 0;
    private static int setPivotYN16904 = 1;

    public static final String component5() {
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 117;
        D8871 = i2 % 128;
        if (i2 % 2 == 0) {
            return "";
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public static int component9() {
        int i = component5;
        int i2 = i % 8098742;
        component5 = i + 1;
        if (i2 != 0) {
            return component9;
        }
        int iMyUid = Process.myUid();
        component9 = iMyUid;
        return iMyUid;
    }
}
