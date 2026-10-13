package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaki {
    private static final zzaix zza = zzaix.zzd(zzake.zza, zzakd.class, zzajz.class);
    private static final zzaix zzb = zzaix.zzd(zzakh.zza, zzakd.class, zzwj.class);
    private static final zzwa zzc = zzahr.zze("type.googleapis.com/google.crypto.tink.HmacKey", zzwj.class, 3, zzanz.zzg());
    private static final zzaid zzd = zzakg.zza;
    private static final zzahi zze = zzakf.zza;
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (!zzaco.zza(i)) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzaln.zza;
        zzaln.zza(zzail.zza());
        zzaii.zza().zzb(zza);
        zzaii.zza().zzb(zzb);
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", zzakz.zza);
        zzakj zzakjVar = new zzakj(null);
        zzakjVar.zza(32);
        zzakjVar.zzb(16);
        zzakl zzaklVar = zzakl.zzd;
        zzakjVar.zzc(zzaklVar);
        zzakk zzakkVar = zzakk.zzc;
        zzakjVar.zzd(zzakkVar);
        map.put("HMAC_SHA256_128BITTAG_RAW", zzakjVar.zze());
        zzakj zzakjVar2 = new zzakj(null);
        zzakjVar2.zza(32);
        zzakjVar2.zzb(32);
        zzakl zzaklVar2 = zzakl.zza;
        zzakjVar2.zzc(zzaklVar2);
        zzakjVar2.zzd(zzakkVar);
        map.put("HMAC_SHA256_256BITTAG", zzakjVar2.zze());
        zzakj zzakjVar3 = new zzakj(null);
        zzakjVar3.zza(32);
        zzakjVar3.zzb(32);
        zzakjVar3.zzc(zzaklVar);
        zzakjVar3.zzd(zzakkVar);
        map.put("HMAC_SHA256_256BITTAG_RAW", zzakjVar3.zze());
        zzakj zzakjVar4 = new zzakj(null);
        zzakjVar4.zza(64);
        zzakjVar4.zzb(16);
        zzakjVar4.zzc(zzaklVar2);
        zzakk zzakkVar2 = zzakk.zze;
        zzakjVar4.zzd(zzakkVar2);
        map.put("HMAC_SHA512_128BITTAG", zzakjVar4.zze());
        zzakj zzakjVar5 = new zzakj(null);
        zzakjVar5.zza(64);
        zzakjVar5.zzb(16);
        zzakjVar5.zzc(zzaklVar);
        zzakjVar5.zzd(zzakkVar2);
        map.put("HMAC_SHA512_128BITTAG_RAW", zzakjVar5.zze());
        zzakj zzakjVar6 = new zzakj(null);
        zzakjVar6.zza(64);
        zzakjVar6.zzb(32);
        zzakjVar6.zzc(zzaklVar2);
        zzakjVar6.zzd(zzakkVar2);
        map.put("HMAC_SHA512_256BITTAG", zzakjVar6.zze());
        zzakj zzakjVar7 = new zzakj(null);
        zzakjVar7.zza(64);
        zzakjVar7.zzb(32);
        zzakjVar7.zzc(zzaklVar);
        zzakjVar7.zzd(zzakkVar2);
        map.put("HMAC_SHA512_256BITTAG_RAW", zzakjVar7.zze());
        map.put("HMAC_SHA512_512BITTAG", zzakz.zzb);
        zzakj zzakjVar8 = new zzakj(null);
        zzakjVar8.zza(64);
        zzakjVar8.zzb(64);
        zzakjVar8.zzc(zzaklVar);
        zzakjVar8.zzd(zzakkVar2);
        map.put("HMAC_SHA512_512BITTAG_RAW", zzakjVar8.zze());
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzaic.zza().zzb(zze, zzakm.class);
        zzaie.zza().zzb(zzd, zzakm.class);
        zzahj.zza().zzd(zzc, i, true);
    }
}
