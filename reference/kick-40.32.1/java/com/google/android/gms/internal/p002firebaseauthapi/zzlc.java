package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlc {
    private static final zzli zza = new zzli();
    private static final zzlg zzb = new zzlg();
    private static final zzbq zzc = new zzlf();

    public static zzbq zza() throws GeneralSecurityException {
        if (zzjd.zzb()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant HybridConfigurationV1 in FIPS mode");
        }
        return zzc;
    }

    static /* synthetic */ zzbs zza(zzck zzckVar) throws GeneralSecurityException {
        zzbt zzbtVarZzb = zzckVar.zzb();
        if (zzbtVarZzb instanceof zzko) {
            return zzzk.zza((zzko) zzbtVarZzb);
        }
        if (zzbtVarZzb instanceof zzks) {
            return zzmh.zza((zzks) zzbtVarZzb);
        }
        throw new GeneralSecurityException("Unknown key class: " + String.valueOf(zzbtVarZzb.getClass()));
    }

    static /* synthetic */ zzbr zzb(zzck zzckVar) throws GeneralSecurityException {
        zzbt zzbtVarZzb = zzckVar.zzb();
        if (zzbtVarZzb instanceof zzkr) {
            return zzzj.zza((zzkr) zzbtVarZzb);
        }
        if (zzbtVarZzb instanceof zzla) {
            return zzmg.zza((zzla) zzbtVarZzb);
        }
        throw new GeneralSecurityException("Unknown key class: " + String.valueOf(zzbtVarZzb.getClass()));
    }
}
