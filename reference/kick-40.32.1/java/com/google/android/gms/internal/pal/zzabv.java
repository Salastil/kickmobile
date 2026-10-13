package com.google.android.gms.internal.pal;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabv {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        long jZzc = zzc(bArr, 0, 0);
        long jZzc2 = zzc(bArr, 3, 2) & 67108611;
        long jZzc3 = zzc(bArr, 6, 4) & 67092735;
        long jZzc4 = zzc(bArr, 9, 6) & 66076671;
        long jZzc5 = zzc(bArr, 12, 8) & 1048575;
        int i = 17;
        byte[] bArr3 = new byte[17];
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (true) {
            int length = bArr2.length;
            if (i2 >= length) {
                long j6 = j + (j2 >> 26);
                long j7 = j6 & 67108863;
                long j8 = j3 + (j6 >> 26);
                long j9 = j8 & 67108863;
                long j10 = j4 + (j8 >> 26);
                long j11 = j10 & 67108863;
                long j12 = j5 + ((j10 >> 26) * 5);
                long j13 = j12 & 67108863;
                long j14 = j13 + 5;
                long j15 = (j2 & 67108863) + (j12 >> 26);
                long j16 = j15 + (j14 >> 26);
                long j17 = (j16 >> 26) + j7;
                long j18 = j9 + (j17 >> 26);
                long j19 = (j11 + (j18 >> 26)) - 67108864;
                long j20 = j19 >> 63;
                long j21 = ~j20;
                long j22 = (j15 & j20) | (j16 & 67108863 & j21);
                long j23 = (j7 & j20) | (j17 & 67108863 & j21);
                long j24 = (j9 & j20) | (j18 & 67108863 & j21);
                long j25 = (j11 & j20) | (j19 & j21);
                long jZzb = (((j20 & j13) | (j14 & 67108863 & j21) | (j22 << 26)) & 4294967295L) + zzb(bArr, 16);
                long jZzb2 = (((j22 >> 6) | (j23 << 20)) & 4294967295L) + zzb(bArr, 20);
                long jZzb3 = (((j23 >> 12) | (j24 << 14)) & 4294967295L) + zzb(bArr, 24);
                long jZzb4 = (((j24 >> 18) | (j25 << 8)) & 4294967295L) + zzb(bArr, 28);
                byte[] bArr4 = new byte[16];
                zzd(bArr4, jZzb & 4294967295L, 0);
                long j26 = jZzb2 + (jZzb >> 32);
                zzd(bArr4, j26 & 4294967295L, 4);
                long j27 = jZzb3 + (j26 >> 32);
                zzd(bArr4, j27 & 4294967295L, 8);
                zzd(bArr4, (jZzb4 + (j27 >> 32)) & 4294967295L, 12);
                return bArr4;
            }
            int iMin = Math.min(16, length - i2);
            System.arraycopy(bArr2, i2, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, i, (byte) 0);
            }
            long j28 = jZzc5 * 5;
            long j29 = jZzc4 * 5;
            long j30 = jZzc3 * 5;
            long jZzc6 = j5 + zzc(bArr3, 0, 0);
            long jZzc7 = j2 + zzc(bArr3, 3, 2);
            long jZzc8 = j + zzc(bArr3, 6, 4);
            long jZzc9 = j3 + zzc(bArr3, 9, 6);
            long jZzc10 = j4 + (zzc(bArr3, 12, 8) | ((long) (bArr3[16] << Ascii.CAN)));
            long j31 = jZzc7 * jZzc;
            long j32 = jZzc7 * jZzc2;
            long j33 = jZzc7 * jZzc3;
            long j34 = jZzc9 * jZzc;
            long j35 = jZzc7 * jZzc4;
            long j36 = jZzc10 * jZzc;
            long j37 = (jZzc6 * jZzc) + (jZzc7 * j28) + (jZzc8 * j29) + (jZzc9 * j30) + (jZzc2 * 5 * jZzc10);
            long j38 = (jZzc6 * jZzc2) + j31 + (jZzc8 * j28) + (jZzc9 * j29) + (j30 * jZzc10) + (j37 >> 26);
            long j39 = (jZzc6 * jZzc3) + j32 + (jZzc8 * jZzc) + (jZzc9 * j28) + (j29 * jZzc10) + (j38 >> 26);
            long j40 = (jZzc6 * jZzc4) + j33 + (jZzc8 * jZzc2) + j34 + (jZzc10 * j28) + (j39 >> 26);
            long j41 = (jZzc6 * jZzc5) + j35 + (jZzc8 * jZzc3) + (jZzc9 * jZzc2) + j36 + (j40 >> 26);
            long j42 = (j37 & 67108863) + ((j41 >> 26) * 5);
            j2 = (j38 & 67108863) + (j42 >> 26);
            i2 += 16;
            j = j39 & 67108863;
            j3 = j40 & 67108863;
            j4 = j41 & 67108863;
            i = 17;
            j5 = j42 & 67108863;
        }
    }

    private static long zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((long) (((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16))) & 4294967295L;
    }

    private static long zzc(byte[] bArr, int i, int i2) {
        return (zzb(bArr, i) >> i2) & 67108863;
    }

    private static void zzd(byte[] bArr, long j, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i + i2] = (byte) (255 & j);
            j >>= 8;
        }
    }
}
