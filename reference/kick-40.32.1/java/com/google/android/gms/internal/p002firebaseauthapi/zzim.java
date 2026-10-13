package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzim implements zzbm {
    private final byte[] zza;
    private final int zzb;
    private final zzsz zzc;

    public static zzbm zza(zzgf zzgfVar) throws GeneralSecurityException {
        if (((zzgj) ((zzdo) zzgfVar.zza())).zzb() < 8 || ((zzgj) ((zzdo) zzgfVar.zza())).zzb() > 12) {
            throw new GeneralSecurityException("invalid salt size");
        }
        return new zzim(zzgfVar.zze().zza(zzbu.zza()), zzgfVar.zzd(), ((zzgj) ((zzdo) zzgfVar.zza())).zzb());
    }

    private zzim(byte[] bArr, zzaau zzaauVar, int i) throws GeneralSecurityException {
        this.zzc = zzaak.zza(zzsx.zza(zzsw.zza(bArr.length), zzaav.zza(bArr, zzbu.zza())));
        this.zza = zzaauVar.zzb();
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        int length = bArr.length;
        byte[] bArr3 = this.zza;
        if (length < bArr3.length + this.zzb + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzqu.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        int length2 = this.zza.length + this.zzb;
        zzhy zzhyVar = new zzhy(zza(Arrays.copyOfRange(bArr, this.zza.length, length2)));
        int i = length2 + 12;
        return zzhyVar.zza(Arrays.copyOfRange(bArr, length2, i), bArr, i, bArr2);
    }

    private final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = {0, 1, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bArr3 = {0, 2, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (bArr.length > 12 || bArr.length < 8) {
            throw new GeneralSecurityException("invalid salt size");
        }
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        byte[] bArr4 = new byte[32];
        System.arraycopy(this.zzc.zza(bArr2, 16), 0, bArr4, 0, 16);
        System.arraycopy(this.zzc.zza(bArr3, 16), 0, bArr4, 16, 16);
        return bArr4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("plaintext is null");
        }
        byte[] bArrZza = zzqm.zza(this.zzb + 12);
        byte[] bArrCopyOf = Arrays.copyOf(bArrZza, this.zzb);
        int i = this.zzb;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrZza, i, i + 12);
        byte[] bArrZzb = new zzhy(zza(bArrCopyOf)).zzb(bArrCopyOfRange, bArr, this.zza.length + this.zzb + bArrCopyOfRange.length, bArr2);
        byte[] bArr3 = this.zza;
        System.arraycopy(bArr3, 0, bArrZzb, 0, bArr3.length);
        System.arraycopy(bArrZza, 0, bArrZzb, this.zza.length, bArrZza.length);
        return bArrZzb;
    }
}
