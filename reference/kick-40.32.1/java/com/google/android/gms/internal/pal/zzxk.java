package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxk {
    private static final zzaix zza = zzaix.zzd(zzxi.zza, zzxh.class, zzvr.class);
    private static final zzwa zzb = zzahr.zze("type.googleapis.com/google.crypto.tink.AesEaxKey", zzvr.class, 3, zzamo.zzf());
    private static final zzahi zzc = zzxj.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        int i = zzaar.zza;
        zzaar.zza(zzail.zza());
        zzaii.zza().zzb(zza);
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzzu.zzc);
        zzxl zzxlVar = new zzxl(null);
        zzxlVar.zzb(16);
        zzxlVar.zza(16);
        zzxlVar.zzc(16);
        zzxm zzxmVar = zzxm.zzc;
        zzxlVar.zzd(zzxmVar);
        map.put("AES128_EAX_RAW", zzxlVar.zze());
        map.put("AES256_EAX", zzzu.zzd);
        zzxl zzxlVar2 = new zzxl(null);
        zzxlVar2.zzb(16);
        zzxlVar2.zza(32);
        zzxlVar2.zzc(16);
        zzxlVar2.zzd(zzxmVar);
        map.put("AES256_EAX_RAW", zzxlVar2.zze());
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzaic.zza().zzb(zzc, zzxn.class);
        zzahj.zza().zzb(zzb, true);
    }
}
