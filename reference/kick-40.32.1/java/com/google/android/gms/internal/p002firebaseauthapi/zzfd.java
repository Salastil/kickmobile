package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfd {
    private static final zzbw<zzbm> zza = zzol.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzbm.class, zzxg.zza.SYMMETRIC, zzyc.zze());
    private static final zzob<zzfo> zzb = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfg
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzfp.zza((zzfo) zzcsVar, num);
        }
    };
    private static final zzpx<zzfp, zzbm> zzc = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzff
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzfd.zza((zzfp) zzbtVar);
        }
    }, zzfp.class, zzbm.class);

    public static /* synthetic */ zzbm zza(zzfp zzfpVar) {
        String strZzd = ((zzfo) ((zzdo) zzfpVar.zza())).zzd();
        return zzig.zza(zzfe.zza(((zzfo) ((zzdo) zzfpVar.zza())).zzb(), zzcn.zza(strZzd).zza(strZzd)), zzfpVar.zzd());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
        }
        zzfs.zza();
        zzoy.zza().zza(zzb, zzfo.class);
        zzpg.zza().zza(zzc);
        zzoe.zza().zza((zzbw) zza, true);
    }
}
