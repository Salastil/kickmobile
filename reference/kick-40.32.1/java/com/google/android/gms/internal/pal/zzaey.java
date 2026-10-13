package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaey {
    private static final zzahe zza = zzb();

    public static zzvt zza() throws GeneralSecurityException {
        if (zzacp.zza()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant HybridConfigurationV1 in FIPS mode");
        }
        return zza;
    }

    private static zzahe zzb() {
        try {
            zzaiy zzaiyVarZza = zzajb.zza();
            zzafg.zze(zzaiyVarZza);
            zzaiyVarZza.zza(zzaix.zzd(zzaev.zza, zzaec.class, zzvw.class));
            zzaiyVarZza.zza(zzaix.zzd(zzaex.zza, zzaes.class, zzvw.class));
            zzafc.zze(zzaiyVarZza);
            zzaiyVarZza.zza(zzaix.zzd(zzaeu.zza, zzaeb.class, zzvv.class));
            zzaiyVarZza.zza(zzaix.zzd(zzaew.zza, zzaek.class, zzvv.class));
            return zzahe.zzb(zzaiyVarZza.zzc());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
