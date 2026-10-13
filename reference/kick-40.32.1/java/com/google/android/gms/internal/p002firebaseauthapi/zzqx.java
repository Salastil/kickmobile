package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqx {
    private static final zzob<zzra> zza = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzqw
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzqx.zza((zzra) zzcsVar, num);
        }
    };
    private static final zzpx<zzqt, zzrd> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzqz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzqx.zzb((zzqt) zzbtVar);
        }
    }, zzqt.class, zzrd.class);
    private static final zzpx<zzqt, zzcp> zzc = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzqy
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzqx.zza((zzqt) zzbtVar);
        }
    }, zzqt.class, zzcp.class);
    private static final zzbw<zzcp> zzd = zzol.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", zzcp.class, zzxg.zza.SYMMETRIC, zztf.zzf());

    public static /* synthetic */ zzcp zza(zzqt zzqtVar) throws GeneralSecurityException {
        zza((zzra) ((zzro) zzqtVar.zza()));
        return zzaan.zza(zzqtVar);
    }

    public static /* synthetic */ zzqt zza(zzra zzraVar, Integer num) throws GeneralSecurityException {
        zza(zzraVar);
        return zzqt.zzc().zza(zzraVar).zza(zzaav.zza(zzraVar.zzc())).zza(num).zza();
    }

    public static /* synthetic */ zzrd zzb(zzqt zzqtVar) throws GeneralSecurityException {
        zza((zzra) ((zzro) zzqtVar.zza()));
        return zzsg.zza(zzqtVar);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
        }
        zzsb.zza();
        zzoy.zza().zza(zza, zzra.class);
        zzpg.zza().zza(zzb);
        zzpg.zza().zza(zzc);
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("AES_CMAC", zzrt.zzc);
        map.put("AES256_CMAC", zzrt.zzc);
        map.put("AES256_CMAC_RAW", zzra.zzd().zza(32).zzb(16).zza(zzra.zzb.zzd).zza());
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzoe.zza().zza((zzbw) zzd, true);
    }

    private static void zza(zzra zzraVar) throws GeneralSecurityException {
        if (zzraVar.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
