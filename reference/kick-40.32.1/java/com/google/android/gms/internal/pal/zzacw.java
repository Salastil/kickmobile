package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzacw {
    public static final /* synthetic */ int zza = 0;
    private static final zzaix zzb = zzaix.zzd(zzacv.zza, zzacs.class, zzvu.class);
    private static final zzwa zzc = zzahr.zze("type.googleapis.com/google.crypto.tink.AesSivKey", zzvu.class, 3, zzanc.zze());
    private static final zzaid zzd = zzact.zza;
    private static final zzahi zze = zzacu.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Registering AES SIV is not supported in FIPS mode");
        }
        int i = zzadn.zza;
        zzadn.zza(zzail.zza());
        zzaii.zza().zzb(zzb);
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        map.put("AES256_SIV", zzadi.zza);
        zzacx zzacxVar = new zzacx(null);
        zzacxVar.zza(64);
        zzacxVar.zzb(zzacy.zzc);
        map.put("AES256_SIV_RAW", zzacxVar.zzc());
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzaie.zza().zzb(zzd, zzacz.class);
        zzaic.zza().zzb(zze, zzacz.class);
        zzahj.zza().zzb(zzc, true);
    }
}
