package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
public final class cM3232 {
    private static int component5 = 0;
    private static int vD14832N6715 = 1;

    public static final /* synthetic */ String component5(byte[] bArr) {
        int i = 2 % 2;
        int i2 = vD14832N6715 + 95;
        component5 = i2 % 128;
        int i3 = i2 % 2;
        String strComponent9 = component9(bArr);
        if (i3 != 0) {
            int i4 = 43 / 0;
        }
        int iComponent5 = xQ31420.component5();
        int i5 = ~iComponent5;
        int i6 = ~((i5 & 1555302784) | (1555302784 ^ i5));
        int i7 = 259306082 + (((i6 & (-493174920)) | ((-493174920) ^ i6)) * (-90));
        int i8 = ~(1555302784 | iComponent5);
        int i9 = (i7 - (~(((i8 & 472121472) | (i8 ^ 472121472)) * (-45)))) - 1;
        int i10 = ~(493174919 | iComponent5);
        int i11 = (i10 & 1555302784) | (1555302784 ^ i10);
        int i12 = ~iComponent5;
        int i13 = ~((i12 & (-493174920)) | (i12 ^ (-493174920)));
        int i14 = -(-(((i13 & i11) | (i11 ^ i13)) * 45));
        int i15 = (i9 & i14) + (i14 | i9);
        int iComponent6 = xQ31420.component5();
        int i16 = ~iComponent6;
        int i17 = ((~((i16 & (-1311867015)) | ((-1311867015) ^ i16))) | (-1910834204)) * 226;
        int i18 = ((-1635151456) & i17) + (i17 | (-1635151456));
        int i19 = ~((1910834203 & iComponent6) | (1910834203 ^ iComponent6));
        int i20 = (i19 & (-2146796704)) | ((-2146796704) ^ i19);
        int i21 = ~iComponent6;
        int i22 = (i21 & (-1311867015)) | ((-1311867015) ^ i21);
        int i23 = ~(((-1910834204) & i22) | (i22 ^ (-1910834204)));
        int i24 = ((i20 & i23) | (i20 ^ i23)) * (-113);
        if (i15 > (((i18 | i24) << 1) - (i24 ^ i18)) + ((~((iComponent6 & (-1311867015)) | ((-1311867015) ^ iComponent6))) * 113)) {
            int i25 = 24 / 0;
        }
        return strComponent9;
    }

    private static final String component9(byte[] bArr) {
        int i = 2 % 2;
        int i2 = component5;
        int i3 = (i2 & 47) + (i2 | 47);
        vD14832N6715 = i3 % 128;
        return i3 % 2 == 0 ? ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 1, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.cM3232.4
            private static int $D8871 = 1;
            private static int $component5 = 1;
            private static int $setPivotYN16904;
            private static int $vD14832N6715;

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ CharSequence invoke(Byte b) {
                int i4 = 2 % 2;
                int i5 = $component5;
                int i6 = (i5 & 87) + (i5 | 87);
                $vD14832N6715 = i6 % 128;
                int i7 = i6 % 2;
                CharSequence charSequenceVD14832N6715 = vD14832N6715(b.byteValue());
                if (i7 != 0) {
                    int i8 = 43 / 0;
                }
                int i9 = $component5 + 97;
                $vD14832N6715 = i9 % 128;
                int i10 = i9 % 2;
                return charSequenceVD14832N6715;
            }

            public final CharSequence vD14832N6715(byte b) {
                int i4 = 2 % 2;
                int i5 = $vD14832N6715;
                int i6 = ((i5 | 89) << 1) - (i5 ^ 89);
                $component5 = i6 % 128;
                int i7 = i6 % 2;
                String str = String.format("%02x", Byte.valueOf(b));
                int i8 = $component5;
                int i9 = (i8 & 57) + (i8 | 57);
                $vD14832N6715 = i9 % 128;
                int i10 = i9 % 2;
                return str;
            }

            static {
                int i4 = $setPivotYN16904 + 65;
                $D8871 = i4 % 128;
                if (i4 % 2 == 0) {
                    throw null;
                }
            }
        }, 42, (Object) null) : ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.cM3232.4
            private static int $D8871 = 1;
            private static int $component5 = 1;
            private static int $setPivotYN16904;
            private static int $vD14832N6715;

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ CharSequence invoke(Byte b) {
                int i4 = 2 % 2;
                int i5 = $component5;
                int i6 = (i5 & 87) + (i5 | 87);
                $vD14832N6715 = i6 % 128;
                int i7 = i6 % 2;
                CharSequence charSequenceVD14832N6715 = vD14832N6715(b.byteValue());
                if (i7 != 0) {
                    int i8 = 43 / 0;
                }
                int i9 = $component5 + 97;
                $vD14832N6715 = i9 % 128;
                int i10 = i9 % 2;
                return charSequenceVD14832N6715;
            }

            public final CharSequence vD14832N6715(byte b) {
                int i4 = 2 % 2;
                int i5 = $vD14832N6715;
                int i6 = ((i5 | 89) << 1) - (i5 ^ 89);
                $component5 = i6 % 128;
                int i7 = i6 % 2;
                String str = String.format("%02x", Byte.valueOf(b));
                int i8 = $component5;
                int i9 = (i8 & 57) + (i8 | 57);
                $vD14832N6715 = i9 % 128;
                int i10 = i9 % 2;
                return str;
            }

            static {
                int i4 = $setPivotYN16904 + 65;
                $D8871 = i4 % 128;
                if (i4 % 2 == 0) {
                    throw null;
                }
            }
        }, 30, (Object) null);
    }
}
