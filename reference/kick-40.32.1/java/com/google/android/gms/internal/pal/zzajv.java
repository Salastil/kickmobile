package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajv {
    private static final zzahi zza = zzaju.zza;
    private static final zzaix zzb = zzaix.zzd(zzajs.zza, zzajr.class, zzajz.class);
    private static final zzaix zzc = zzaix.zzd(zzajt.zza, zzajr.class, zzwj.class);
    private static final zzwa zzd = zzahr.zze("type.googleapis.com/google.crypto.tink.AesCmacKey", zzwj.class, 3, zzaly.zzf());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
        }
        int i = zzale.zza;
        zzale.zza(zzail.zza());
        zzaic.zza().zzb(zza, zzajy.class);
        zzaii.zza().zzb(zzb);
        zzaii.zza().zzb(zzc);
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        zzajy zzajyVar = zzakz.zzc;
        map.put("AES_CMAC", zzajyVar);
        map.put("AES256_CMAC", zzajyVar);
        zzajw zzajwVar = new zzajw(null);
        zzajwVar.zza(32);
        zzajwVar.zzb(16);
        zzajwVar.zzc(zzajx.zzd);
        map.put("AES256_CMAC_RAW", zzajwVar.zzd());
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzahj.zza().zzb(zzd, true);
    }

    static /* synthetic */ zzajz zzb(zzajr zzajrVar) throws GeneralSecurityException {
        zzd(zzajrVar.zzf());
        return zzalh.zza(zzajrVar);
    }

    static /* synthetic */ zzwj zzc(zzajr zzajrVar) throws GeneralSecurityException {
        zzd(zzajrVar.zzf());
        return zzarm.zzb(zzajrVar);
    }

    private static void zzd(zzajy zzajyVar) throws GeneralSecurityException {
        if (zzajyVar.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
