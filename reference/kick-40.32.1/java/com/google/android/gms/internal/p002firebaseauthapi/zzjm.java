package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjm {
    private static final zzpx<zzji, zzbp> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjl
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzjm.zza((zzji) zzbtVar);
        }
    }, zzji.class, zzbp.class);
    private static final zzbw<zzbp> zzb = zzol.zza("type.googleapis.com/google.crypto.tink.AesSivKey", zzbp.class, zzxg.zza.SYMMETRIC, zzuy.zze());
    private static final zzoz<zzjp> zzc = new zzoz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjo
    };
    private static final zzob<zzjp> zzd = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjn
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzjm.zza((zzjp) zzcsVar, num);
        }
    };

    public static /* synthetic */ zzbp zza(zzji zzjiVar) throws GeneralSecurityException {
        zza((zzjp) ((zzju) zzjiVar.zza()));
        return zzzg.zza(zzjiVar);
    }

    static zzji zza(zzjp zzjpVar, @Nullable Integer num) throws GeneralSecurityException {
        zza(zzjpVar);
        return zzji.zzc().zza(zzjpVar).zza(num).zza(zzaav.zza(zzjpVar.zzb())).zza();
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering AES SIV is not supported in FIPS mode");
        }
        zzjx.zza();
        zzpg.zza().zza(zza);
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("AES256_SIV", zzjv.zza);
        map.put("AES256_SIV_RAW", zzjp.zzc().zza(64).zza(zzjp.zzb.zzc).zza());
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzpa.zza().zza(zzc, zzjp.class);
        zzoy.zza().zza(zzd, zzjp.class);
        zzoe.zza().zza((zzbw) zzb, true);
    }

    private static void zza(zzjp zzjpVar) throws GeneralSecurityException {
        if (zzjpVar.zzb() == 64) {
            return;
        }
        throw new InvalidAlgorithmParameterException("invalid key size: " + zzjpVar.zzb() + ". Valid keys must have 64 bytes.");
    }
}
