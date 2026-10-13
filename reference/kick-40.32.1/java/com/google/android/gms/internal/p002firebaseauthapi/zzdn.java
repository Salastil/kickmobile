package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdn implements zzqi<zzbm, zzbm> {
    private static final zzdn zza = new zzdn();
    private static final zzpx<zzon, zzbm> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdq
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzig.zza((zzon) zzbtVar);
        }
    }, zzon.class, zzbm.class);

    public static zzbm zza(zzch zzchVar, zzqh<zzbm> zzqhVar) throws GeneralSecurityException {
        return zzii.zza(zzchVar, zzqhVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final Class<zzbm> zza() {
        return zzbm.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final Class<zzbm> zzb() {
        return zzbm.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final /* synthetic */ zzbm zzb(zzch zzchVar, zzqh<zzbm> zzqhVar) throws GeneralSecurityException {
        return zzii.zza(zzchVar, zzqhVar);
    }

    zzdn() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzpg.zza().zza(zza);
        zzpg.zza().zza(zzb);
    }
}
