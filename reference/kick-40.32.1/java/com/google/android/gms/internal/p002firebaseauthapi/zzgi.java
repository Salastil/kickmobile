package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgi {
    private static final zzob<zzgj> zza = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgh
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzgf.zza((zzgj) zzcsVar, zzaav.zza(32), num);
        }
    };
    private static final zzpx<zzgf, zzbm> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgk
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzim.zza((zzgf) zzbtVar);
        }
    }, zzgf.class, zzbm.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        zzil.zza();
        zzpd zzpdVarZza = zzpd.zza();
        HashMap map = new HashMap();
        map.put("XAES_256_GCM_192_BIT_NONCE", zzfv.zzg);
        map.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzfv.zzh);
        map.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzfv.zzi);
        map.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzfv.zzj);
        zzpdVarZza.zza(Collections.unmodifiableMap(map));
        zzpg.zza().zza(zzb);
        zzoy.zza().zza(zza, zzgj.class);
    }
}
