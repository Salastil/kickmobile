package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlg implements zzqi<zzbs, zzbs> {
    private static final zzlg zza = new zzlg();
    private static final zzpx<zzon, zzbs> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlj
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzmr.zza((zzon) zzbtVar);
        }
    }, zzon.class, zzbs.class);

    public static zzbs zza(zzch zzchVar, zzqh<zzbs> zzqhVar) throws GeneralSecurityException {
        return zzmv.zza(zzchVar, zzqhVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final Class<zzbs> zza() {
        return zzbs.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final Class<zzbs> zzb() {
        return zzbs.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final /* synthetic */ zzbs zzb(zzch zzchVar, zzqh<zzbs> zzqhVar) throws GeneralSecurityException {
        return zzmv.zza(zzchVar, zzqhVar);
    }

    zzlg() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzpg.zza().zza(zza);
        zzpg.zza().zza(zzb);
    }
}
