package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.EncodedKeySpec;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmm {
    private static final zzpx<zzks, zzbs> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmp
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzmh.zza((zzks) zzbtVar);
        }
    }, zzks.class, zzbs.class);
    private static final zzpx<zzla, zzbr> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmo
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzmg.zza((zzla) zzbtVar);
        }
    }, zzla.class, zzbr.class);
    private static final zzcu<zzbs> zzc = zzol.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", zzbs.class, zzxa.zzf());
    private static final zzbw<zzbr> zzd = zzol.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzbr.class, zzxg.zza.ASYMMETRIC_PUBLIC, zzxd.d_());
    private static final zzob<zzkq> zze = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmq
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzmm.zzb((zzkq) zzcsVar, num);
        }
    };

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza extends EncodedKeySpec {
        @Override // java.security.spec.EncodedKeySpec
        public final String getFormat() {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzks zzb(zzkq zzkqVar, @Nullable Integer num) throws GeneralSecurityException {
        zzaau zzaauVarZza;
        zzaav zzaavVarZza;
        if (zzkqVar.zze().equals(zzkq.zzf.zzd)) {
            byte[] bArrZza = zzaas.zza();
            zzaavVarZza = zzaav.zza(bArrZza, zzbu.zza());
            zzaauVarZza = zzaau.zza(zzaas.zza(bArrZza));
        } else if (zzkqVar.zze().equals(zzkq.zzf.zza) || zzkqVar.zze().equals(zzkq.zzf.zzb) || zzkqVar.zze().equals(zzkq.zzf.zzc)) {
            zzzq zzzqVarZzd = zzms.zzd(zzkqVar.zze());
            KeyPair keyPairZza = zzzn.zza(zzzn.zza(zzzqVarZzd));
            zzaauVarZza = zzaau.zza(zzzn.zza(zzzqVarZzd, zzzp.UNCOMPRESSED, ((ECPublicKey) keyPairZza.getPublic()).getW()));
            zzaavVarZza = zzaav.zza(zznu.zza(((ECPrivateKey) keyPairZza.getPrivate()).getS(), zzms.zzb(zzkqVar.zze())), zzbu.zza());
        } else {
            if (!zzkqVar.zze().equals(zzkq.zzf.zze)) {
                throw new GeneralSecurityException("Unknown KEM ID");
            }
            Provider providerZza = zznt.zza();
            if (providerZza == null) {
                throw new GeneralSecurityException("Can't generate X-Wing key as Conscrypt is not available");
            }
            try {
                KeyPair keyPairGenerateKeyPair = KeyPairGenerator.getInstance("XWING", providerZza).generateKeyPair();
                KeyFactory keyFactory = KeyFactory.getInstance("XWING", providerZza);
                zzaau zzaauVarZza2 = zzaau.zza(((zza) keyFactory.getKeySpec(keyPairGenerateKeyPair.getPublic(), zza.class)).getEncoded());
                zzaavVarZza = zzaav.zza(((zza) keyFactory.getKeySpec(keyPairGenerateKeyPair.getPrivate(), zza.class)).getEncoded(), zzbu.zza());
                zzaauVarZza = zzaauVarZza2;
            } catch (Exception e) {
                throw new GeneralSecurityException("Can't generate X-Wing key", e);
            }
        }
        return zzks.zza(zzla.zza(zzkqVar, zzaauVarZza, num), zzaavVarZza);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering HPKE Hybrid Encryption is not supported in FIPS mode");
        }
        zzkv.zza();
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzkq.zzc().zza(zzkq.zze.zza).zza(zzkq.zzf.zzd).zza(zzkq.zzc.zza).zza(zzkq.zzb.zza).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzkq.zzc().zza(zzkq.zze.zzc).zza(zzkq.zzf.zzd).zza(zzkq.zzc.zza).zza(zzkq.zzb.zza).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzkq.zzc().zza(zzkq.zze.zza).zza(zzkq.zzf.zzd).zza(zzkq.zzc.zza).zza(zzkq.zzb.zzb).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzkq.zzc().zza(zzkq.zze.zzc).zza(zzkq.zzf.zzd).zza(zzkq.zzc.zza).zza(zzkq.zzb.zzb).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzkq.zzc().zza(zzkq.zze.zza).zza(zzkq.zzf.zzd).zza(zzkq.zzc.zza).zza(zzkq.zzb.zzc).zza());
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzkq.zzc().zza(zzkq.zze.zzc).zza(zzkq.zzf.zzd).zza(zzkq.zzc.zza).zza(zzkq.zzb.zzc).zza());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzkq.zzc().zza(zzkq.zze.zza).zza(zzkq.zzf.zza).zza(zzkq.zzc.zza).zza(zzkq.zzb.zza).zza());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzkq.zzc().zza(zzkq.zze.zzc).zza(zzkq.zzf.zza).zza(zzkq.zzc.zza).zza(zzkq.zzb.zza).zza());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzkq.zzc().zza(zzkq.zze.zza).zza(zzkq.zzf.zza).zza(zzkq.zzc.zza).zza(zzkq.zzb.zzb).zza());
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzkq.zzc().zza(zzkq.zze.zzc).zza(zzkq.zzf.zza).zza(zzkq.zzc.zza).zza(zzkq.zzb.zzb).zza());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzkq.zzc().zza(zzkq.zze.zza).zza(zzkq.zzf.zzb).zza(zzkq.zzc.zzb).zza(zzkq.zzb.zza).zza());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzkq.zzc().zza(zzkq.zze.zzc).zza(zzkq.zzf.zzb).zza(zzkq.zzc.zzb).zza(zzkq.zzb.zza).zza());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzkq.zzc().zza(zzkq.zze.zza).zza(zzkq.zzf.zzb).zza(zzkq.zzc.zzb).zza(zzkq.zzb.zzb).zza());
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzkq.zzc().zza(zzkq.zze.zzc).zza(zzkq.zzf.zzb).zza(zzkq.zzc.zzb).zza(zzkq.zzb.zzb).zza());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzkq.zzc().zza(zzkq.zze.zza).zza(zzkq.zzf.zzc).zza(zzkq.zzc.zzc).zza(zzkq.zzb.zza).zza());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzkq.zzc().zza(zzkq.zze.zzc).zza(zzkq.zzf.zzc).zza(zzkq.zzc.zzc).zza(zzkq.zzb.zza).zza());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzkq.zzc().zza(zzkq.zze.zza).zza(zzkq.zzf.zzc).zza(zzkq.zzc.zzc).zza(zzkq.zzb.zzb).zza());
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzkq.zzc().zza(zzkq.zze.zzc).zza(zzkq.zzf.zzc).zza(zzkq.zzc.zzc).zza(zzkq.zzb.zzb).zza());
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzpg.zza().zza(zza);
        zzpg.zza().zza(zzb);
        zzoy.zza().zza(zze, zzkq.class);
        zzoe.zza().zza((zzbw) zzc, true);
        zzoe.zza().zza((zzbw) zzd, false);
    }
}
