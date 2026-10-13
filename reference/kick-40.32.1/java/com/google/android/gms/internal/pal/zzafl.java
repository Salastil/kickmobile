package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafl implements zzafz {
    zzafl() {
    }

    @Override // com.google.android.gms.internal.pal.zzafz
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: 32");
        }
        if (zzabg.zzd()) {
            return zzabr.zza(bArr).zzb(bArr2, bArr3, i, bArr4);
        }
        byte[] bArrZzb = new zzabp(bArr).zzb(bArr2, bArr3, bArr4);
        int length = bArrZzb.length;
        if (length > Integer.MAX_VALUE - i) {
            throw new InvalidAlgorithmParameterException("Plaintext too long");
        }
        byte[] bArr5 = new byte[i + length];
        System.arraycopy(bArrZzb, 0, bArr5, i, length);
        return bArr5;
    }

    @Override // com.google.android.gms.internal.pal.zzafz
    public final byte[] zzb() {
        return zzagm.zzk;
    }

    @Override // com.google.android.gms.internal.pal.zzafz
    public final int zzc() {
        return 32;
    }
}
