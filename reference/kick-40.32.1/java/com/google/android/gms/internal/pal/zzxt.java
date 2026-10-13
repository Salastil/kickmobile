package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxt {
    private static final zzaix zza = zzaix.zzd(zzxq.zza, zzxp.class, zzvr.class);
    private static final zzwa zzb = zzahr.zze("type.googleapis.com/google.crypto.tink.AesGcmKey", zzvr.class, 3, zzamu.zze());
    private static final zzaid zzc = zzxs.zza;
    private static final zzahi zzd = zzxr.zza;
    private static final int zze = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zze;
        if (!zzaco.zza(i)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzaay.zza;
        zzaay.zza(zzail.zza());
        zzaii.zza().zzb(zza);
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        map.put("AES128_GCM", zzzu.zza);
        zzxu zzxuVar = new zzxu(null);
        zzxuVar.zzb(12);
        zzxuVar.zza(16);
        zzxuVar.zzc(16);
        zzxv zzxvVar = zzxv.zzc;
        zzxuVar.zzd(zzxvVar);
        map.put("AES128_GCM_RAW", zzxuVar.zze());
        map.put("AES256_GCM", zzzu.zzb);
        zzxu zzxuVar2 = new zzxu(null);
        zzxuVar2.zzb(12);
        zzxuVar2.zza(32);
        zzxuVar2.zzc(16);
        zzxuVar2.zzd(zzxvVar);
        map.put("AES256_GCM_RAW", zzxuVar2.zze());
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzaie.zza().zzb(zzc, zzxw.class);
        zzaic.zza().zzb(zzd, zzxw.class);
        zzahj.zza().zzd(zzb, i, true);
    }
}
