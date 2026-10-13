package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjt implements zzqi<zzbp, zzbp> {
    private static final zzjt zza = new zzjt();
    private static final zzpx<zzon, zzbp> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjw
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzke.zza((zzon) zzbtVar);
        }
    }, zzon.class, zzbp.class);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final Class<zzbp> zza() {
        return zzbp.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final Class<zzbp> zzb() {
        return zzbp.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final /* synthetic */ zzbp zzb(zzch zzchVar, zzqh<zzbp> zzqhVar) throws GeneralSecurityException {
        return zzkd.zza(zzchVar, zzqhVar);
    }

    zzjt() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzpg.zza().zza(zza);
        zzpg.zza().zza(zzb);
    }
}
