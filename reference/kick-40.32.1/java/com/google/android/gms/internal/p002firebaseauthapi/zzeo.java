package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeo {
    private static final zzpx<zzen, zzbm> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzer
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zziy.zza((zzen) zzbtVar);
        }
    }, zzen.class, zzbm.class);
    private static final zzob<zzes> zzb = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeq
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            zzes zzesVar = (zzes) zzcsVar;
            return zzen.zze().zza(zzesVar).zza(num).zza(zzaav.zza(zzesVar.zzb())).zza();
        }
    };
    private static final zzoz<zzes> zzc = new zzoz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzet
    };
    private static final zzbw<zzbm> zzd = zzol.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzbm.class, zzxg.zza.SYMMETRIC, zzus.zze());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        zzhm.zza();
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("AES128_GCM_SIV", zzes.zzc().zza(16).zza(zzes.zza.zza).zza());
        map.put("AES128_GCM_SIV_RAW", zzes.zzc().zza(16).zza(zzes.zza.zzc).zza());
        map.put("AES256_GCM_SIV", zzes.zzc().zza(32).zza(zzes.zza.zza).zza());
        map.put("AES256_GCM_SIV_RAW", zzes.zzc().zza(32).zza(zzes.zza.zzc).zza());
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzpa.zza().zza(zzc, zzes.class);
        zzoy.zza().zza(zzb, zzes.class);
        zzpg.zza().zza(zza);
        zzoe.zza().zza((zzbw) zzd, true);
    }
}
