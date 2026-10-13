package org.bouncycastle.util;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes11.dex */
public class GF16 {
    private static final byte[] F_STAR = {1, 2, 4, 8, 3, 6, Ascii.FF, Ascii.VT, 5, 10, 7, Ascii.SO, Ascii.SI, Ascii.CR, 9};
    private static final byte[] MT4B = new byte[256];
    private static final byte[] INV4B = new byte[16];

    static {
        for (int i = 0; i < 15; i++) {
            for (int i2 = 0; i2 < 15; i2++) {
                byte[] bArr = MT4B;
                byte[] bArr2 = F_STAR;
                bArr[(bArr2[i] << 4) ^ bArr2[i2]] = bArr2[(i + i2) % 15];
            }
        }
        byte[] bArr3 = F_STAR;
        byte bMt = 1;
        byte b = bArr3[1];
        byte b2 = bArr3[14];
        INV4B[1] = 1;
        byte bMt2 = 1;
        for (int i3 = 0; i3 < 14; i3++) {
            bMt = mt(bMt, b);
            bMt2 = mt(bMt2, b2);
            INV4B[bMt] = bMt2;
        }
    }

    public static void decode(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i3 >> 1;
        int i5 = 0;
        while (i5 < i4) {
            int i6 = i2 + 1;
            bArr2[i2] = (byte) (bArr[i] & Ascii.SI);
            i2 += 2;
            bArr2[i6] = (byte) ((bArr[i] >>> 4) & 15);
            i5++;
            i++;
        }
        if ((i3 & 1) == 1) {
            bArr2[i2] = (byte) (bArr[i] & Ascii.SI);
        }
    }

    public static void decode(byte[] bArr, byte[] bArr2, int i) {
        int i2 = i >> 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i4 + 1;
            bArr2[i4] = (byte) (bArr[i3] & Ascii.SI);
            i4 += 2;
            bArr2[i5] = (byte) ((bArr[i3] >>> 4) & 15);
            i3++;
        }
        if ((i & 1) == 1) {
            bArr2[i4] = (byte) (bArr[i3] & Ascii.SI);
        }
    }

    public static void encode(byte[] bArr, byte[] bArr2, int i) {
        int i2 = i >> 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i4 + 1;
            int i6 = bArr[i4] & Ascii.SI;
            i4 += 2;
            bArr2[i3] = (byte) (((bArr[i5] & Ascii.SI) << 4) | i6);
            i3++;
        }
        if ((i & 1) == 1) {
            bArr2[i3] = (byte) (bArr[i4] & Ascii.SI);
        }
    }

    public static void encode(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = i2 >> 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 1;
            int i7 = bArr[i5] & Ascii.SI;
            i5 += 2;
            bArr2[i] = (byte) (((bArr[i6] & Ascii.SI) << 4) | i7);
            i4++;
            i++;
        }
        if ((i2 & 1) == 1) {
            bArr2[i] = (byte) (bArr[i5] & Ascii.SI);
        }
    }

    public static byte innerProduct(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = 0;
        byte bMul = 0;
        while (i4 < i3) {
            bMul = (byte) (mul(bArr[i], bArr2[i2]) ^ bMul);
            i4++;
            i2 += i3;
            i++;
        }
        return bMul;
    }

    public static byte inv(byte b) {
        return INV4B[b & Ascii.SI];
    }

    static byte mt(int i, int i2) {
        return MT4B[(i << 4) ^ i2];
    }

    public static byte mul(byte b, byte b2) {
        return MT4B[(b << 4) | b2];
    }

    public static int mul(int i, int i2) {
        return MT4B[(i << 4) | i2];
    }
}
