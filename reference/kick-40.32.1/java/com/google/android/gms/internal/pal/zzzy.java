package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzy {
    private static final zzahi zza = zzzx.zza;
    private static final zzaix zzb = zzaix.zzd(zzzw.zza, zzzv.class, zzvr.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzacb.zza;
        zzacb.zza(zzail.zza());
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        map.put("XAES_256_GCM_192_BIT_NONCE", zzzu.zzg);
        map.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzzu.zzh);
        map.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzzu.zzi);
        map.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzzu.zzj);
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzaii.zza().zzb(zzb);
        zzaic.zza().zzb(zza, zzaaa.class);
    }
}
