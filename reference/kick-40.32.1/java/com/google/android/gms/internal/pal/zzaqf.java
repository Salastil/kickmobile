package com.google.android.gms.internal.pal;

import expo.modules.crypto.aes.AesConfig;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaqf implements zzvu, zzadp {
    private static final byte[] zza = new byte[16];
    private static final byte[] zzb = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private static final ThreadLocal zzf = new zzaqe();
    private final zzalr zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzaqf(byte[] bArr, zzarq zzarqVar) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        int length = bArr.length;
        if (length != 32 && length != 64) {
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 54);
            sb.append("invalid key size: ");
            sb.append(length);
            sb.append(" bytes; key must have 32 or 64 bytes");
            throw new InvalidKeyException(sb.toString());
        }
        int i = length >> 1;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i);
        this.zzd = Arrays.copyOfRange(bArr, i, length);
        this.zzc = zzarj.zzb(zzalp.zzc(zzalq.zzb(bArrCopyOfRange.length), zzars.zza(bArrCopyOfRange, zzvx.zza())));
        this.zze = zzarqVar.zzb();
    }

    public static zzadp zzb(zzacs zzacsVar) throws GeneralSecurityException {
        return new zzaqf(zzacsVar.zzd().zzb(zzvx.zza()), zzacsVar.zze());
    }

    @Override // com.google.android.gms.internal.pal.zzvu
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length;
        byte[] bArrZzd;
        byte[] bArrZza;
        byte[][] bArr3 = {bArr2};
        byte[] bArr4 = this.zze;
        if (bArr.length > 2147483631 - bArr4.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = (Cipher) zzf.get();
        byte[][] bArr5 = (byte[][]) Arrays.copyOf(bArr3, 2);
        bArr5[1] = bArr;
        int length2 = bArr5.length;
        zzalr zzalrVar = this.zzc;
        if (length2 == 0) {
            bArrZza = zzalrVar.zza(zzb, 16);
        } else {
            byte[] bArrZza2 = zzalrVar.zza(zza, 16);
            int i = 0;
            while (true) {
                length = bArr5.length - 1;
                if (i >= length) {
                    break;
                }
                byte[] bArr6 = bArr5[i];
                if (bArr6 == null) {
                    bArr6 = new byte[0];
                }
                bArrZza2 = zzaqj.zzd(zzalf.zza(bArrZza2), zzalrVar.zza(bArr6, 16));
                i++;
            }
            byte[] bArr7 = bArr5[length];
            int length3 = bArr7.length;
            if (length3 >= 16) {
                int length4 = bArrZza2.length;
                if (length3 < length4) {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                }
                bArrZzd = Arrays.copyOf(bArr7, length3);
                for (int i2 = 0; i2 < bArrZza2.length; i2++) {
                    int i3 = (length3 - length4) + i2;
                    bArrZzd[i3] = (byte) (bArrZzd[i3] ^ bArrZza2[i2]);
                }
            } else {
                bArrZzd = zzaqj.zzd(zzalf.zzb(bArr7), zzalf.zza(bArrZza2));
            }
            bArrZza = zzalrVar.zza(bArrZzd, 16);
        }
        byte[] bArr8 = (byte[]) bArrZza.clone();
        bArr8[8] = (byte) (bArr8[8] & 127);
        bArr8[12] = (byte) (bArr8[12] & 127);
        cipher.init(1, new SecretKeySpec(this.zzd, AesConfig.CRYPTO_KEY_ALGORITHM), new IvParameterSpec(bArr8));
        int length5 = bArr4.length;
        int length6 = bArrZza.length;
        int i4 = length5 + length6;
        int length7 = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr4, i4 + length7);
        System.arraycopy(bArrZza, 0, bArrCopyOf, length5, length6);
        if (cipher.doFinal(bArr, 0, length7, bArrCopyOf, i4) == length7) {
            return bArrCopyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }
}
