package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.appcompat.app.AppCompatDelegate;

/* JADX INFO: loaded from: classes6.dex */
public final class j extends f<String> {
    private static int component9 = 1;
    private static int setPivotYN16904;
    private final String D8871;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = ((i2 | 45) << 1) - (i2 ^ 45);
        component9 = i3 % 128;
        int i4 = i3 % 2;
        String strComponent5 = component5();
        int i5 = setPivotYN16904;
        int i6 = (i5 ^ 67) + ((i5 & 67) << 1);
        component9 = i6 % 128;
        if (i6 % 2 != 0) {
            return strComponent5;
        }
        throw null;
    }

    private String component5() {
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 79;
        int i3 = i2 % 128;
        component9 = i3;
        int i4 = i2 % 2;
        String str = this.D8871;
        int i5 = i3 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        setPivotYN16904 = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 28 / 0;
        }
        return str;
    }

    public j(String str) {
        super(null);
        this.D8871 = str;
    }
}
