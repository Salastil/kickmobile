package com.google.android.gms.internal.pal;

import com.google.common.base.Ascii;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzagx {
    static final byte[][] zza = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, Ascii.SYN, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, 50, -79, -3, -122, 98, 5, Ascii.SYN, 95, 73, -72, 0}, new byte[]{95, -100, -107, PSSSigner.TRAILER_IMPLICIT, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, 88, Ascii.FS, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 127}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 127}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 127}};

    static void zza(long[] jArr, long[] jArr2, int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            int i3 = (int) jArr[i2];
            int i4 = (-i) & (((int) jArr2[i2]) ^ i3);
            jArr[i2] = i3 ^ i4;
            jArr2[i2] = i4 ^ ((int) jArr2[i2]);
        }
    }

    public static void zzb(long[] jArr, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        int i = 32;
        if (bArr2.length != 32) {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr2, 32);
        bArrCopyOf[31] = (byte) (bArrCopyOf[31] & 127);
        int i2 = 0;
        for (int i3 = 0; i3 < 7; i3++) {
            byte[][] bArr3 = zza;
            if (MessageDigest.isEqual(bArr3[i3], bArrCopyOf)) {
                throw new InvalidKeyException("Banned public key: ".concat(zzarg.zza(bArr3[i3])));
            }
        }
        long[] jArrZzj = zzahc.zzj(bArrCopyOf);
        long[] jArr2 = new long[19];
        long[] jArr3 = new long[19];
        jArr3[0] = 1;
        long[] jArr4 = new long[19];
        jArr4[0] = 1;
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        jArr7[0] = 1;
        long[] jArr8 = new long[19];
        long[] jArr9 = new long[19];
        jArr9[0] = 1;
        int i4 = 10;
        System.arraycopy(jArrZzj, 0, jArr2, 0, 10);
        int i5 = 0;
        while (i5 < i) {
            int i6 = bArr[31 - i5] & 255;
            while (i2 < 8) {
                int i7 = (i6 >> (7 - i2)) & 1;
                zza(jArr4, jArr2, i7);
                zza(jArr5, jArr3, i7);
                long[] jArrCopyOf = Arrays.copyOf(jArr4, i4);
                int i8 = i6;
                long[] jArr10 = new long[19];
                int i9 = i2;
                long[] jArr11 = new long[19];
                int i10 = i5;
                long[] jArr12 = new long[19];
                long[] jArr13 = new long[19];
                long[] jArr14 = new long[19];
                long[] jArr15 = jArr9;
                long[] jArr16 = new long[19];
                long[] jArr17 = new long[19];
                zzahc.zza(jArr4, jArr4, jArr5);
                zzahc.zzb(jArr5, jArrCopyOf, jArr5);
                long[] jArrCopyOf2 = Arrays.copyOf(jArr2, 10);
                zzahc.zza(jArr2, jArr2, jArr3);
                zzahc.zzb(jArr3, jArrCopyOf2, jArr3);
                zzahc.zzd(jArr13, jArr2, jArr5);
                zzahc.zzd(jArr14, jArr4, jArr3);
                zzahc.zzf(jArr13);
                zzahc.zzg(jArr13);
                zzahc.zzf(jArr14);
                zzahc.zzg(jArr14);
                long[] jArr18 = jArr2;
                System.arraycopy(jArr13, 0, jArrCopyOf2, 0, 10);
                zzahc.zza(jArr13, jArr13, jArr14);
                zzahc.zzb(jArr14, jArrCopyOf2, jArr14);
                zzahc.zzi(jArr17, jArr13);
                zzahc.zzi(jArr16, jArr14);
                zzahc.zzd(jArr14, jArr16, jArrZzj);
                zzahc.zzf(jArr14);
                zzahc.zzg(jArr14);
                System.arraycopy(jArr17, 0, jArr6, 0, 10);
                System.arraycopy(jArr14, 0, jArr7, 0, 10);
                zzahc.zzi(jArr11, jArr4);
                zzahc.zzi(jArr12, jArr5);
                zzahc.zzd(jArr8, jArr11, jArr12);
                zzahc.zzf(jArr8);
                zzahc.zzg(jArr8);
                zzahc.zzb(jArr12, jArr11, jArr12);
                Arrays.fill(jArr10, 10, 18, 0L);
                zzahc.zzc(jArr10, jArr12, 121665L);
                zzahc.zzg(jArr10);
                zzahc.zza(jArr10, jArr10, jArr11);
                zzahc.zzd(jArr15, jArr12, jArr10);
                zzahc.zzf(jArr15);
                zzahc.zzg(jArr15);
                zza(jArr8, jArr6, i7);
                zza(jArr15, jArr7, i7);
                i2 = i9 + 1;
                long[] jArr19 = jArr7;
                jArr7 = jArr3;
                jArr3 = jArr19;
                long[] jArr20 = jArr8;
                jArr8 = jArr4;
                jArr4 = jArr20;
                jArr9 = jArr5;
                jArr5 = jArr15;
                jArr2 = jArr6;
                i6 = i8;
                i5 = i10;
                jArr6 = jArr18;
                i4 = 10;
            }
            i5++;
            i = 32;
            i2 = 0;
            i4 = 10;
        }
        int i11 = i4;
        long[] jArr21 = new long[i11];
        long[] jArr22 = new long[i11];
        long[] jArr23 = new long[i11];
        long[] jArr24 = new long[i11];
        long[] jArr25 = new long[i11];
        long[] jArr26 = new long[i11];
        long[] jArr27 = new long[i11];
        long[] jArr28 = new long[i11];
        long[] jArr29 = new long[i11];
        long[] jArr30 = new long[i11];
        long[] jArr31 = jArr2;
        long[] jArr32 = new long[i11];
        zzahc.zzi(jArr22, jArr5);
        zzahc.zzi(jArr32, jArr22);
        zzahc.zzi(jArr30, jArr32);
        zzahc.zzh(jArr23, jArr30, jArr5);
        zzahc.zzh(jArr24, jArr23, jArr22);
        zzahc.zzi(jArr30, jArr24);
        zzahc.zzh(jArr25, jArr30, jArr23);
        zzahc.zzi(jArr30, jArr25);
        zzahc.zzi(jArr32, jArr30);
        zzahc.zzi(jArr30, jArr32);
        zzahc.zzi(jArr32, jArr30);
        zzahc.zzi(jArr30, jArr32);
        zzahc.zzh(jArr26, jArr30, jArr25);
        zzahc.zzi(jArr30, jArr26);
        zzahc.zzi(jArr32, jArr30);
        for (int i12 = 2; i12 < 10; i12 += 2) {
            zzahc.zzi(jArr30, jArr32);
            zzahc.zzi(jArr32, jArr30);
        }
        zzahc.zzh(jArr27, jArr32, jArr26);
        zzahc.zzi(jArr30, jArr27);
        zzahc.zzi(jArr32, jArr30);
        for (int i13 = 2; i13 < 20; i13 += 2) {
            zzahc.zzi(jArr30, jArr32);
            zzahc.zzi(jArr32, jArr30);
        }
        zzahc.zzh(jArr30, jArr32, jArr27);
        zzahc.zzi(jArr32, jArr30);
        zzahc.zzi(jArr30, jArr32);
        for (int i14 = 2; i14 < 10; i14 += 2) {
            zzahc.zzi(jArr32, jArr30);
            zzahc.zzi(jArr30, jArr32);
        }
        zzahc.zzh(jArr28, jArr30, jArr26);
        zzahc.zzi(jArr30, jArr28);
        zzahc.zzi(jArr32, jArr30);
        for (int i15 = 2; i15 < 50; i15 += 2) {
            zzahc.zzi(jArr30, jArr32);
            zzahc.zzi(jArr32, jArr30);
        }
        zzahc.zzh(jArr29, jArr32, jArr28);
        zzahc.zzi(jArr32, jArr29);
        zzahc.zzi(jArr30, jArr32);
        for (int i16 = 2; i16 < 100; i16 += 2) {
            zzahc.zzi(jArr32, jArr30);
            zzahc.zzi(jArr30, jArr32);
        }
        zzahc.zzh(jArr32, jArr30, jArr29);
        zzahc.zzi(jArr30, jArr32);
        zzahc.zzi(jArr32, jArr30);
        for (int i17 = 2; i17 < 50; i17 += 2) {
            zzahc.zzi(jArr30, jArr32);
            zzahc.zzi(jArr32, jArr30);
        }
        zzahc.zzh(jArr30, jArr32, jArr28);
        zzahc.zzi(jArr32, jArr30);
        zzahc.zzi(jArr30, jArr32);
        zzahc.zzi(jArr32, jArr30);
        zzahc.zzi(jArr30, jArr32);
        zzahc.zzi(jArr32, jArr30);
        zzahc.zzh(jArr21, jArr32, jArr24);
        zzahc.zzh(jArr, jArr4, jArr21);
        long[] jArr33 = new long[10];
        long[] jArr34 = new long[10];
        long[] jArr35 = new long[11];
        long[] jArr36 = new long[11];
        long[] jArr37 = new long[11];
        zzahc.zzh(jArr33, jArrZzj, jArr);
        zzahc.zza(jArr34, jArrZzj, jArr);
        long[] jArr38 = new long[10];
        jArr38[0] = 486662;
        zzahc.zza(jArr36, jArr34, jArr38);
        zzahc.zzh(jArr36, jArr36, jArr3);
        zzahc.zza(jArr36, jArr36, jArr31);
        zzahc.zzh(jArr36, jArr36, jArr33);
        zzahc.zzh(jArr36, jArr36, jArr31);
        zzahc.zzc(jArr35, jArr36, 4L);
        zzahc.zzg(jArr35);
        zzahc.zzh(jArr36, jArr33, jArr3);
        zzahc.zzb(jArr36, jArr36, jArr3);
        zzahc.zzh(jArr37, jArr34, jArr31);
        zzahc.zza(jArr36, jArr36, jArr37);
        zzahc.zzi(jArr36, jArr36);
        if (!MessageDigest.isEqual(zzahc.zzk(jArr35), zzahc.zzk(jArr36))) {
            throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(zzarg.zza(bArr2)));
        }
    }
}
