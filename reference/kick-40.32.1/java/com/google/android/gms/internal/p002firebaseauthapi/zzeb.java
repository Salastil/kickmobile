package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeb {
    private static final zzpx<zzdx, zzbm> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzea
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzzb.zza((zzdx) zzbtVar);
        }
    }, zzdx.class, zzbm.class);
    private static final zzbw<zzbm> zzb = zzol.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", zzbm.class, zzxg.zza.SYMMETRIC, zzud.zzf());
    private static final zzob<zzec> zzc = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzed
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzeb.zza((zzec) zzcsVar, num);
        }
    };

    public static /* synthetic */ zzdx zza(zzec zzecVar, Integer num) throws GeneralSecurityException {
        if (zzecVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES EAX Parameters are not valid");
        }
        return zzdx.zze().zza(zzecVar).zza(num).zza(zzaav.zza(zzecVar.zzc())).zza();
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        zzgy.zza();
        zzpg.zza().zza(zza);
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzfv.zzc);
        map.put("AES128_EAX_RAW", zzec.zze().zza(16).zzb(16).zzc(16).zza(zzec.zza.zzc).zza());
        map.put("AES256_EAX", zzfv.zzd);
        map.put("AES256_EAX_RAW", zzec.zze().zza(16).zzb(32).zzc(16).zza(zzec.zza.zzc).zza());
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzoy.zza().zza(zzc, zzec.class);
        zzoe.zza().zza((zzbw) zzb, true);
    }
}
