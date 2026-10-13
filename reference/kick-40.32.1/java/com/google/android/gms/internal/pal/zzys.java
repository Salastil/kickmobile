package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzys {
    public static final /* synthetic */ int zza = 0;
    private static final zzwa zzb = zzahr.zze("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzvr.class, 3, zzapj.zze());
    private static final zzahi zzc = zzyr.zza;
    private static final zzaix zzd = zzaix.zzd(zzyq.zza, zzzb.class, zzvr.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
        }
        int i = zzzk.zza;
        zzzk.zza(zzail.zza());
        zzaic.zza().zzb(zzc, zzzf.class);
        zzaii.zza().zzb(zzd);
        zzahj.zza().zzb(zzb, true);
    }
}
