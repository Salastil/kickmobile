package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzlr implements zzmf {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final int zzb() {
        return 12;
    }

    zzlr() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zzc() {
        return zzms.zzk;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: 32");
        }
        if (zzib.zza()) {
            return zzib.zza(bArr).zza(bArr2, bArr3, i, bArr4);
        }
        return new zzhz(bArr).zza(bArr2, Arrays.copyOfRange(bArr3, i, bArr3.length), bArr4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: 32");
        }
        if (zzib.zza()) {
            return zzib.zza(bArr).zzb(bArr2, bArr3, i, bArr4);
        }
        byte[] bArrZzb = new zzhz(bArr).zzb(bArr2, bArr3, bArr4);
        if (bArrZzb.length > Integer.MAX_VALUE - i) {
            throw new InvalidAlgorithmParameterException("Plaintext too long");
        }
        byte[] bArr5 = new byte[bArrZzb.length + i];
        System.arraycopy(bArrZzb, 0, bArr5, i, bArrZzb.length);
        return bArr5;
    }
}
