package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;

/* JADX INFO: loaded from: classes6.dex */
public final class av {
    public static int component5;
    public static int component9;

    public static final wX26196.setPivotYN16904 vD14832N6715(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return wX26196.setPivotYN16904.vD14832N6715.INSTANCE;
        }
        return wX26196.setPivotYN16904.component13.INSTANCE;
    }

    public static int component5() {
        int i = component9;
        int i2 = i % 5307071;
        component9 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iMyUid = Process.myUid();
        component5 = iMyUid;
        return iMyUid;
    }
}
