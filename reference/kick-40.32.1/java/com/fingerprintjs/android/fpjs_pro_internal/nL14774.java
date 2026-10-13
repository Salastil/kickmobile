package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.appcompat.app.AppCompatDelegate;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class nL14774 {
    private static int component9 = 0;
    private static int vD14832N6715 = 1;
    private final List<List<Float>> D8871;
    private final List<List<Float>> setPivotYN16904;

    /* JADX WARN: Multi-variable type inference failed */
    public nL14774(List<? extends List<Float>> list, List<? extends List<Float>> list2) {
        this.setPivotYN16904 = list;
        this.D8871 = list2;
    }

    public final List<List<Float>> D8871() {
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = i2 + 13;
        component9 = i3 % 128;
        int i4 = i3 % 2;
        List<List<Float>> list = this.setPivotYN16904;
        int i5 = (i2 & 5) + (i2 | 5);
        component9 = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 38 / 0;
        }
        return list;
    }

    public final List<List<Float>> setPivotYN16904() {
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = i2 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        component9 = i3 % 128;
        int i4 = i3 % 2;
        List<List<Float>> list = this.D8871;
        int i5 = ((i2 | 81) << 1) - (i2 ^ 81);
        component9 = i5 % 128;
        if (i5 % 2 == 0) {
            return list;
        }
        throw null;
    }
}
