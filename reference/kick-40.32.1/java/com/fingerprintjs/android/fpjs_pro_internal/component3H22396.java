package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;

/* JADX INFO: loaded from: classes6.dex */
public final class component3H22396 extends wX26196 {
    public static int D8871;
    public static int setPivotYN16904;

    public component3H22396(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.iA15411.INSTANCE.component5(), str, setpivotyn16904);
    }

    public static int component5() {
        int i = setPivotYN16904;
        int i2 = i % 5117088;
        setPivotYN16904 = i + 1;
        if (i2 != 0) {
            return D8871;
        }
        int iMyTid = Process.myTid();
        D8871 = iMyTid;
        return iMyTid;
    }
}
