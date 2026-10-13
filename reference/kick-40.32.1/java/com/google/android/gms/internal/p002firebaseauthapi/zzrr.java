package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrr implements zzqi<zzcp, zzcp> {
    private static final zzrr zza = new zzrr();
    private static final zzpx<zzon, zzcp> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrq
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzsp.zza((zzon) zzbtVar);
        }
    }, zzon.class, zzcp.class);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final Class<zzcp> zza() {
        return zzcp.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final Class<zzcp> zzb() {
        return zzcp.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final /* synthetic */ zzcp zzb(zzch zzchVar, zzqh<zzcp> zzqhVar) throws GeneralSecurityException {
        return zzst.zza(zzchVar, zzqhVar);
    }

    zzrr() {
    }

    static void zzc() throws GeneralSecurityException {
        zzpg.zza().zza(zza);
        zzpg.zza().zza(zzb);
    }
}
