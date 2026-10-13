package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdt {
    private static final zzpx<zzdp, zzbm> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzds
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzzs.zza((zzdp) zzbtVar);
        }
    }, zzdp.class, zzbm.class);
    private static final zzbw<zzbm> zzb = zzol.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzbm.class, zzxg.zza.SYMMETRIC, zzto.zzf());
    private static final zzoz<zzdw> zzc = new zzoz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdv
    };
    private static final zzob<zzdw> zzd = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdu
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzdt.zza((zzdw) zzcsVar, num);
        }
    };
    private static final zzjd.zza zze = zzjd.zza.zzb;

    static zzdp zza(zzdw zzdwVar, @Nullable Integer num) throws GeneralSecurityException {
        if (zzdwVar.zzb() == 16 || zzdwVar.zzb() == 32) {
            return zzdp.zze().zza(zzdwVar).zza(num).zza(zzaav.zza(zzdwVar.zzb())).zzb(zzaav.zza(zzdwVar.zzc())).zza();
        }
        throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzjd.zza zzaVar = zze;
        if (!zzaVar.zza()) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzgs.zza();
        zzpg.zza().zza(zza);
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", zzfv.zze);
        map.put("AES128_CTR_HMAC_SHA256_RAW", zzdw.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdw.zzc.zzc).zza(zzdw.zzb.zzc).zza());
        map.put("AES256_CTR_HMAC_SHA256", zzfv.zzf);
        map.put("AES256_CTR_HMAC_SHA256_RAW", zzdw.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzdw.zzc.zzc).zza(zzdw.zzb.zzc).zza());
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzpa.zza().zza(zzc, zzdw.class);
        zzoy.zza().zza(zzd, zzdw.class);
        zzoe.zza().zza((zzbw) zzb, zzaVar, true);
    }
}
