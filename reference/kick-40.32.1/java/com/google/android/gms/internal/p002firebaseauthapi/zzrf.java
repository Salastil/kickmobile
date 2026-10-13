package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrf {
    private static final zzpx<zzre, zzrd> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzri
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return new zzsj((zzre) zzbtVar);
        }
    }, zzre.class, zzrd.class);
    private static final zzpx<zzre, zzcp> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrh
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzaan.zza((zzre) zzbtVar);
        }
    }, zzre.class, zzcp.class);
    private static final zzbw<zzcp> zzc = zzol.zza("type.googleapis.com/google.crypto.tink.HmacKey", zzcp.class, zzxg.zza.SYMMETRIC, zzwg.c_());
    private static final zzoz<zzrl> zzd = new zzoz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrk
    };
    private static final zzob<zzrl> zze = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrj
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzrf.zza((zzrl) zzcsVar, num);
        }
    };
    private static final zzjd.zza zzf = zzjd.zza.zzb;

    static zzre zza(zzrl zzrlVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzre.zzc().zza(zzrlVar).zza(zzaav.zza(zzrlVar.zzc())).zza(num).zza();
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzjd.zza zzaVar = zzf;
        if (!zzaVar.zza()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzsi.zza();
        zzpg.zza().zza(zza);
        zzpg.zza().zza(zzb);
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", zzrt.zza);
        map.put("HMAC_SHA256_128BITTAG_RAW", zzrl.zzd().zza(32).zzb(16).zza(zzrl.zzb.zzd).zza(zzrl.zzc.zzc).zza());
        map.put("HMAC_SHA256_256BITTAG", zzrl.zzd().zza(32).zzb(32).zza(zzrl.zzb.zza).zza(zzrl.zzc.zzc).zza());
        map.put("HMAC_SHA256_256BITTAG_RAW", zzrl.zzd().zza(32).zzb(32).zza(zzrl.zzb.zzd).zza(zzrl.zzc.zzc).zza());
        map.put("HMAC_SHA512_128BITTAG", zzrl.zzd().zza(64).zzb(16).zza(zzrl.zzb.zza).zza(zzrl.zzc.zze).zza());
        map.put("HMAC_SHA512_128BITTAG_RAW", zzrl.zzd().zza(64).zzb(16).zza(zzrl.zzb.zzd).zza(zzrl.zzc.zze).zza());
        map.put("HMAC_SHA512_256BITTAG", zzrl.zzd().zza(64).zzb(32).zza(zzrl.zzb.zza).zza(zzrl.zzc.zze).zza());
        map.put("HMAC_SHA512_256BITTAG_RAW", zzrl.zzd().zza(64).zzb(32).zza(zzrl.zzb.zzd).zza(zzrl.zzc.zze).zza());
        map.put("HMAC_SHA512_512BITTAG", zzrt.zzb);
        map.put("HMAC_SHA512_512BITTAG_RAW", zzrl.zzd().zza(64).zzb(64).zza(zzrl.zzb.zzd).zza(zzrl.zzc.zze).zza());
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzoy.zza().zza(zze, zzrl.class);
        zzpa.zza().zza(zzd, zzrl.class);
        zzoe.zza().zza((zzbw) zzc, zzaVar, true);
    }
}
