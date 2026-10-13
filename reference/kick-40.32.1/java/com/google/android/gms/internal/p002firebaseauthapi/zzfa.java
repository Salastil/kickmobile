package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfa {
    private static final zzpx<zzfi, zzbm> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfc
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            zzfi zzfiVar = (zzfi) zzbtVar;
            return zzig.zza(zzcn.zza(((zzfh) ((zzdo) zzfiVar.zza())).zzc()).zza(((zzfh) ((zzdo) zzfiVar.zza())).zzc()), zzfiVar.zzd());
        }
    }, zzfi.class, zzbm.class);
    private static final zzbw<zzbm> zzb = zzol.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzbm.class, zzxg.zza.REMOTE, zzxw.zze());
    private static final zzob<zzfh> zzc = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfb
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzfi.zza((zzfh) zzcsVar, num);
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
        }
        zzfj.zza();
        zzpg.zza().zza(zza);
        zzoy.zza().zza(zzc, zzfh.class);
        zzoe.zza().zza((zzbw) zzb, true);
    }
}
