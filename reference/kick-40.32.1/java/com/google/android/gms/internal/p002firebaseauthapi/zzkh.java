package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkh {
    private static final zzpx<zzko, zzbs> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkk
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzzk.zza((zzko) zzbtVar);
        }
    }, zzko.class, zzbs.class);
    private static final zzpx<zzkr, zzbr> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkj
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzzj.zza((zzkr) zzbtVar);
        }
    }, zzkr.class, zzbr.class);
    private static final zzcu<zzbs> zzc = zzol.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzbs.class, zzvs.zzf());
    private static final zzbw<zzbr> zzd = zzol.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzbr.class, zzxg.zza.ASYMMETRIC_PUBLIC, zzvv.zzh());
    private static final zzob<zzkl> zze = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkm
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzkh.zza((zzkl) zzcsVar, num);
        }
    };

    public static /* synthetic */ zzko zza(zzkl zzklVar, Integer num) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        zzkl.zzc zzcVarZzd = zzklVar.zzd();
        if (zzcVarZzd == zzkl.zzc.zza) {
            eCParameterSpec = zznv.zza;
        } else if (zzcVarZzd == zzkl.zzc.zzb) {
            eCParameterSpec = zznv.zzb;
        } else {
            if (zzcVarZzd != zzkl.zzc.zzc) {
                throw new GeneralSecurityException("Unsupported curve type: " + String.valueOf(zzcVarZzd));
            }
            eCParameterSpec = zznv.zzc;
        }
        KeyPair keyPairZza = zzzn.zza(eCParameterSpec);
        return zzko.zza(zzkr.zza(zzklVar, ((ECPublicKey) keyPairZza.getPublic()).getW(), num), zzaat.zza(((ECPrivateKey) keyPairZza.getPrivate()).getS(), zzbu.zza()));
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering ECIES Hybrid Encryption is not supported in FIPS mode");
        }
        zzlx.zza();
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzkl.zzc().zza(zzkl.zzc.zza).zza(zzkl.zzb.zzc).zza(zzkl.zze.zzb).zza(zzkl.zzd.zza).zza(zzel.zze().zza(12).zzb(16).zzc(16).zza(zzel.zzb.zzc).zza()).zza());
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzkl.zzc().zza(zzkl.zzc.zza).zza(zzkl.zzb.zzc).zza(zzkl.zze.zzb).zza(zzkl.zzd.zzc).zza(zzel.zze().zza(12).zzb(16).zzc(16).zza(zzel.zzb.zzc).zza()).zza());
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzkl.zzc().zza(zzkl.zzc.zza).zza(zzkl.zzb.zzc).zza(zzkl.zze.zza).zza(zzkl.zzd.zza).zza(zzel.zze().zza(12).zzb(16).zzc(16).zza(zzel.zzb.zzc).zza()).zza());
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzkl.zzc().zza(zzkl.zzc.zza).zza(zzkl.zzb.zzc).zza(zzkl.zze.zza).zza(zzkl.zzd.zzc).zza(zzel.zze().zza(12).zzb(16).zzc(16).zza(zzel.zzb.zzc).zza()).zza());
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzkl.zzc().zza(zzkl.zzc.zza).zza(zzkl.zzb.zzc).zza(zzkl.zze.zza).zza(zzkl.zzd.zzc).zza(zzel.zze().zza(12).zzb(16).zzc(16).zza(zzel.zzb.zzc).zza()).zza());
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzkl.zzc().zza(zzkl.zzc.zza).zza(zzkl.zzb.zzc).zza(zzkl.zze.zzb).zza(zzkl.zzd.zza).zza(zzdw.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdw.zzc.zzc).zza(zzdw.zzb.zzc).zza()).zza());
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzkl.zzc().zza(zzkl.zzc.zza).zza(zzkl.zzb.zzc).zza(zzkl.zze.zzb).zza(zzkl.zzd.zzc).zza(zzdw.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdw.zzc.zzc).zza(zzdw.zzb.zzc).zza()).zza());
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzkl.zzc().zza(zzkl.zzc.zza).zza(zzkl.zzb.zzc).zza(zzkl.zze.zza).zza(zzkl.zzd.zza).zza(zzdw.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdw.zzc.zzc).zza(zzdw.zzb.zzc).zza()).zza());
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzkl.zzc().zza(zzkl.zzc.zza).zza(zzkl.zzb.zzc).zza(zzkl.zze.zza).zza(zzkl.zzd.zzc).zza(zzdw.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdw.zzc.zzc).zza(zzdw.zzb.zzc).zza()).zza());
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzpg.zza().zza(zza);
        zzpg.zza().zza(zzb);
        zzoy.zza().zza(zze, zzkl.class);
        zzoe.zza().zza((zzbw) zzc, true);
        zzoe.zza().zza((zzbw) zzd, false);
    }
}
