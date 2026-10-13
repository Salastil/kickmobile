package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzlt implements zzlu {
    private final zzdw zza;
    private final int zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlu
    public final int zza() {
        return this.zzb;
    }

    private final zzbm zza(byte[] bArr) throws GeneralSecurityException {
        return zzzs.zza(zzdp.zze().zza(this.zza).zza(zzaav.zza(Arrays.copyOf(bArr, this.zza.zzb()), zzbu.zza())).zzb(zzaav.zza(Arrays.copyOfRange(bArr, this.zza.zzb(), this.zza.zzb() + this.zza.zzc()), zzbu.zza())).zza());
    }

    zzlt(zzdw zzdwVar) {
        this.zza = zzdwVar;
        this.zzb = zzdwVar.zzb() + zzdwVar.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlu
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return zza(bArr).zza(Arrays.copyOfRange(bArr2, i, bArr2.length), zzlq.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlu
    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        return zzzi.zza(bArr2, bArr3, zza(bArr).zzb(bArr4, zzlq.zza));
    }
}
