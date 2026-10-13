package com.fingerprintjs.android.fpjs_pro_internal;

import android.hardware.SensorManager;
import androidx.appcompat.app.AppCompatDelegate;

/* JADX INFO: loaded from: classes6.dex */
public final class getContextMenuInfoA21117 {
    private static int D8871 = 0;
    private static int component9 = 1;
    private final SensorManager component5;
    private rV4669 setPivotYN16904;
    private final rV4669 vD14832N6715;

    public getContextMenuInfoA21117(SensorManager sensorManager, rV4669 rv4669) {
        this.component5 = sensorManager;
        this.vD14832N6715 = rv4669;
    }

    public final getContextMenuInfoA21117 setPivotYN16904(rV4669 rv4669) {
        int i = 2 % 2;
        int i2 = component9;
        int i3 = (i2 ^ 19) + ((i2 & 19) << 1);
        D8871 = i3 % 128;
        if (i3 % 2 != 0) {
            this.setPivotYN16904 = rv4669;
            int i4 = 70 / 0;
        } else {
            this.setPivotYN16904 = rv4669;
        }
        int i5 = i2 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        D8871 = i5 % 128;
        int i6 = i5 % 2;
        return this;
    }

    public final W16671 vD14832N6715() {
        SensorManager sensorManager = this.component5;
        rV4669 rv4669 = this.setPivotYN16904;
        if (rv4669 == null) {
            rv4669 = this.vD14832N6715;
        }
        return new P28427(sensorManager, rv4669);
    }
}
