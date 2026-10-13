package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmn {
    public static zzmf zza(zzkq.zzb zzbVar) throws GeneralSecurityException {
        if (zzbVar == zzkq.zzb.zza) {
            return new zzlo(16);
        }
        if (zzbVar == zzkq.zzb.zzb) {
            return new zzlo(32);
        }
        if (zzbVar == zzkq.zzb.zzc) {
            return new zzlr();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static zzmj zza(zzkq.zzc zzcVar) {
        if (zzcVar == zzkq.zzc.zza) {
            return new zzmc("HmacSha256");
        }
        if (zzcVar == zzkq.zzc.zzb) {
            return new zzmc("HmacSha384");
        }
        if (zzcVar == zzkq.zzc.zzc) {
            return new zzmc("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }

    public static zzmi zza(zzkq.zzf zzfVar) throws GeneralSecurityException {
        if (zzfVar == zzkq.zzf.zzd) {
            return new zzng(new zzmc("HmacSha256"));
        }
        if (zzfVar == zzkq.zzf.zza) {
            return zzmt.zza(zzzq.NIST_P256);
        }
        if (zzfVar == zzkq.zzf.zzb) {
            return zzmt.zza(zzzq.NIST_P384);
        }
        if (zzfVar == zzkq.zzf.zzc) {
            return zzmt.zza(zzzq.NIST_P521);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }
}
