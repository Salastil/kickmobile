package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxb {
    private static final zzaix zza = zzaix.zzd(zzxa.zza, zzwx.class, zzvr.class);
    private static final zzwa zzb = zzahr.zze("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzvr.class, 3, zzame.zzf());
    private static final zzaid zzc = zzwz.zza;
    private static final zzahi zzd = zzwy.zza;
    private static final int zze = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zze;
        if (!zzaco.zza(i)) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzaam.zza;
        zzaam.zza(zzail.zza());
        zzaii.zza().zzb(zza);
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", zzzu.zze);
        zzxc zzxcVar = new zzxc(null);
        zzxcVar.zza(16);
        zzxcVar.zzb(32);
        zzxcVar.zzd(16);
        zzxcVar.zzc(16);
        zzxd zzxdVar = zzxd.zzc;
        zzxcVar.zzf(zzxdVar);
        zzxe zzxeVar = zzxe.zzc;
        zzxcVar.zze(zzxeVar);
        map.put("AES128_CTR_HMAC_SHA256_RAW", zzxcVar.zzg());
        map.put("AES256_CTR_HMAC_SHA256", zzzu.zzf);
        zzxc zzxcVar2 = new zzxc(null);
        zzxcVar2.zza(32);
        zzxcVar2.zzb(32);
        zzxcVar2.zzd(32);
        zzxcVar2.zzc(16);
        zzxcVar2.zzf(zzxdVar);
        zzxcVar2.zze(zzxeVar);
        map.put("AES256_CTR_HMAC_SHA256_RAW", zzxcVar2.zzg());
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzaie.zza().zzb(zzc, zzxf.class);
        zzaic.zza().zzb(zzd, zzxf.class);
        zzahj.zza().zzd(zzb, i, true);
    }
}
