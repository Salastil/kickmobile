package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdh {
    private static final zzdn zza = new zzdn();
    private static final zzbq zzb = new zzdk();

    static zzbm zza(zzck zzckVar) throws GeneralSecurityException {
        zzbt zzbtVarZzb = zzckVar.zzb();
        if (zzbtVarZzb instanceof zzdp) {
            return zzzs.zza((zzdp) zzbtVarZzb);
        }
        if (zzbtVarZzb instanceof zzee) {
            return zzzd.zza((zzee) zzbtVarZzb);
        }
        if (zzbtVarZzb instanceof zzen) {
            return zziy.zza((zzen) zzbtVarZzb);
        }
        if (zzbtVarZzb instanceof zzdx) {
            return zzzb.zza((zzdx) zzbtVarZzb);
        }
        if (zzbtVarZzb instanceof zzeu) {
            zzeu zzeuVar = (zzeu) zzbtVarZzb;
            return zzhp.zzb() ? zzhp.zza(zzeuVar) : zzzh.zza(zzeuVar);
        }
        if (zzbtVarZzb instanceof zzgl) {
            zzgl zzglVar = (zzgl) zzbtVarZzb;
            return zzis.zza() ? zzis.zza(zzglVar) : zzaar.zza(zzglVar);
        }
        if (zzbtVarZzb instanceof zzgf) {
            return zzim.zza((zzgf) zzbtVarZzb);
        }
        throw new GeneralSecurityException("Unknown key class: " + String.valueOf(zzbtVarZzb.getClass()));
    }

    public static zzbq zza() throws GeneralSecurityException {
        if (zzjd.zzb()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant AeadConfigurationV1 in FIPS mode");
        }
        return zzb;
    }
}
