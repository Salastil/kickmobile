package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.compose.runtime.GapComposerKt;
import com.fingerprintjs.android.fpjs_pro.ProxyIntegrationSecretEnvironmentMismatch;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    private static int component13 = 0;
    private static int component8 = 1;
    public static int component9;
    public static int setPivotYN16904;
    private final pC2922 D8871;
    private final H16981 component5;
    private final X26477 vD14832N6715;

    public a(H16981 h16981, pC2922 pc2922, X26477 x26477) {
        this.component5 = h16981;
        this.D8871 = pc2922;
        this.vD14832N6715 = x26477;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:12:0x0037  */
    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    public final String D8871() {
        int i;
        int i2;
        int i3;
        int i4 = 2 % 2;
        int i5 = component13 + 111;
        component8 = i5 % 128;
        int i6 = i5 % 2;
        Object obj = null;
        String strComponent5 = this.component5.component5();
        if (i6 == 0) {
            int i7 = 48 / 0;
            if (strComponent5 == null) {
                i = component13 + 81;
                i2 = i % 128;
                component8 = i2;
                if (i % 2 != 0) {
                    obj.hashCode();
                    throw null;
                }
                i3 = (i2 ^ 77) + ((i2 & 77) << 1);
                component13 = i3 % 128;
                if (i3 % 2 != 0) {
                    int i8 = 5 % 4;
                }
                strComponent5 = "";
            }
        } else if (strComponent5 == null) {
            i = component13 + 81;
            i2 = i % 128;
            component8 = i2;
            if (i % 2 != 0) {
                obj.hashCode();
                throw null;
            }
            i3 = (i2 ^ 77) + ((i2 & 77) << 1);
            component13 = i3 % 128;
            if (i3 % 2 != 0) {
                int i9 = 5 % 4;
            }
            strComponent5 = "";
        }
        int i10 = component13;
        int i11 = (i10 ^ 77) + ((i10 & 77) << 1);
        component8 = i11 % 128;
        if (i11 % 2 != 0) {
            return strComponent5;
        }
        throw null;
    }

    public final String vD14832N6715() {
        int i = 2 % 2;
        int i2 = component8;
        int i3 = (i2 & 83) + (i2 | 83);
        component13 = i3 % 128;
        int i4 = i3 % 2;
        pC2922 pc2922 = this.D8871;
        if (i4 != 0) {
            pc2922.vD14832N6715();
            throw null;
        }
        String strVD14832N6715 = pc2922.vD14832N6715();
        int i5 = component13;
        int i6 = (i5 & 47) + (i5 | 47);
        component8 = i6 % 128;
        int i7 = i6 % 2;
        return strVD14832N6715;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003f  */
    public final String component9() {
        String str;
        int i = 2 % 2;
        int i2 = component13 + 25;
        component8 = i2 % 128;
        int i3 = i2 % 2;
        Object[] objArr = {this.vD14832N6715};
        int iD8871 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        int iD8872 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        int iD8873 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        int iD8874 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        if (i3 == 0) {
            str = (String) X26477.setPivotYN16904(iD8872, iD8871, iD8874, 495862354, objArr, iD8873, -495862353);
            int i4 = 92 / 0;
            if (str == null) {
                int i5 = component13;
                int i6 = (i5 & 45) + (i5 | 45);
                int i7 = i6 % 128;
                component8 = i7;
                int i8 = i6 % 2;
                int i9 = (i7 ^ 51) + ((i7 & 51) << 1);
                component13 = i9 % 128;
                int i10 = i9 % 2;
                str = "";
            }
        } else {
            str = (String) X26477.setPivotYN16904(iD8872, iD8871, iD8874, 495862354, objArr, iD8873, -495862353);
            if (str == null) {
                int i11 = component13;
                int i12 = (i11 & 45) + (i11 | 45);
                int i13 = i12 % 128;
                component8 = i13;
                int i14 = i12 % 2;
                int i15 = (i13 ^ 51) + ((i13 & 51) << 1);
                component13 = i15 % 128;
                int i16 = i15 % 2;
                str = "";
            }
        }
        int i17 = component8;
        int i18 = (i17 & GapComposerKt.nodeKey) + (i17 | GapComposerKt.nodeKey);
        component13 = i18 % 128;
        int i19 = i18 % 2;
        return str;
    }

    public static int component5() {
        int i = setPivotYN16904;
        int i2 = i % 7771269;
        setPivotYN16904 = i + 1;
        if (i2 != 0) {
            return component9;
        }
        int iNextInt = new Random().nextInt(1398453825);
        component9 = iNextInt;
        return iNextInt;
    }
}
