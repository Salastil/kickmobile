package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzei {
    private static final zzpx<zzee, zzbm> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeh
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzzd.zza((zzee) zzbtVar);
        }
    }, zzee.class, zzbm.class);
    private static final zzbw<zzbm> zzb = zzol.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", zzbm.class, zzxg.zza.SYMMETRIC, zzum.zze());
    private static final zzoz<zzel> zzc = new zzoz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzek
    };
    private static final zzob<zzel> zzd = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzej
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzei.zza((zzel) zzcsVar, num);
        }
    };
    private static final zzjd.zza zze = zzjd.zza.zzb;

    public static /* synthetic */ zzee zza(zzel zzelVar, Integer num) throws GeneralSecurityException {
        if (zzelVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
        return zzee.zze().zza(zzelVar).zza(num).zza(zzaav.zza(zzelVar.zzc())).zza();
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzjd.zza zzaVar = zze;
        if (!zzaVar.zza()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhd.zza();
        zzpg.zza().zza(zza);
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("AES128_GCM", zzfv.zza);
        map.put("AES128_GCM_RAW", zzel.zze().zza(12).zzb(16).zzc(16).zza(zzel.zzb.zzc).zza());
        map.put("AES256_GCM", zzfv.zzb);
        map.put("AES256_GCM_RAW", zzel.zze().zza(12).zzb(32).zzc(16).zza(zzel.zzb.zzc).zza());
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzpa.zza().zza(zzc, zzel.class);
        zzoy.zza().zza(zzd, zzel.class);
        zzoe.zza().zza((zzbw) zzb, zzaVar, true);
    }
}
