package com.fingerprintjs.android.fpjs_pro_internal;

import com.fingerprintjs.android.fpjs_pro.Error;
import com.fingerprintjs.android.fpjs_pro.FingerprintJSProResponse;
import com.fingerprintjs.android.fpjs_pro.NetworkError;
import com.fingerprintjs.android.fpjs_pro.UnknownError;

/* JADX INFO: loaded from: classes6.dex */
public final class setTopP6481U32634 {
    private static int D8871 = 1;
    private static int setPivotYN16904;

    public static final D8871<FingerprintJSProResponse, Error> component9(C20232 c20232) {
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = (i2 & 29) + (i2 | 29);
        D8871 = i3 % 128;
        int i4 = i3 % 2;
        Object obj = null;
        if (c20232.setPivotYN16904() == null) {
            setPivotYN16904 setpivotyn16904 = new setPivotYN16904(new NetworkError(null, 1, null));
            int i5 = D8871 + 51;
            setPivotYN16904 = i5 % 128;
            if (i5 % 2 == 0) {
                return setpivotyn16904;
            }
            obj.hashCode();
            throw null;
        }
        Error errorVD14832N6715 = c20232.vD14832N6715();
        FingerprintJSProResponse fingerprintJSProResponseComponent5 = c20232.component5();
        if (errorVD14832N6715 == null) {
            int i6 = D8871 + 39;
            setPivotYN16904 = i6 % 128;
            int i7 = i6 % 2;
            if (fingerprintJSProResponseComponent5 != null) {
                return new vD14832N6715(fingerprintJSProResponseComponent5);
            }
        }
        UnknownError unknownErrorVD14832N6715 = c20232.vD14832N6715();
        if (unknownErrorVD14832N6715 == null) {
            unknownErrorVD14832N6715 = new UnknownError(null, null, 3, null);
            int i8 = setPivotYN16904;
            int i9 = ((i8 | 101) << 1) - (i8 ^ 101);
            D8871 = i9 % 128;
            int i10 = i9 % 2;
        }
        return new setPivotYN16904(unknownErrorVD14832N6715);
    }
}
