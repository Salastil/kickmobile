package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyc {
    private static final zzaix zza = zzaix.zzd(zzxz.zza, zzxy.class, zzvr.class);
    private static final zzahi zzb = zzyb.zza;
    private static final zzaid zzc = zzya.zza;
    private static final zzwa zzd = zzahr.zze("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzvr.class, 3, zzamy.zze());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        int i = zzabf.zza;
        zzabf.zza(zzail.zza());
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        zzyd zzydVar = new zzyd(null);
        zzydVar.zza(16);
        zzye zzyeVar = zzye.zza;
        zzydVar.zzb(zzyeVar);
        map.put("AES128_GCM_SIV", zzydVar.zzc());
        zzyd zzydVar2 = new zzyd(null);
        zzydVar2.zza(16);
        zzye zzyeVar2 = zzye.zzc;
        zzydVar2.zzb(zzyeVar2);
        map.put("AES128_GCM_SIV_RAW", zzydVar2.zzc());
        zzyd zzydVar3 = new zzyd(null);
        zzydVar3.zza(32);
        zzydVar3.zzb(zzyeVar);
        map.put("AES256_GCM_SIV", zzydVar3.zzc());
        zzyd zzydVar4 = new zzyd(null);
        zzydVar4.zza(32);
        zzydVar4.zzb(zzyeVar2);
        map.put("AES256_GCM_SIV_RAW", zzydVar4.zzc());
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzaie.zza().zzb(zzc, zzyf.class);
        zzaic.zza().zzb(zzb, zzyf.class);
        zzaii.zza().zzb(zza);
        zzahj.zza().zzb(zzd, true);
    }
}
