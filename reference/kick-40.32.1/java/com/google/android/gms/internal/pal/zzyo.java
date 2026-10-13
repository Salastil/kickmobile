package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyo {
    public static final /* synthetic */ int zza = 0;
    private static final zzaix zzb = zzaix.zzd(zzyn.zza, zzyt.class, zzvr.class);
    private static final zzwa zzc = zzahr.zze("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzvr.class, 6, zzapf.zze());
    private static final zzahi zzd = zzym.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
        }
        int i = zzza.zza;
        zzza.zza(zzail.zza());
        zzaii.zza().zzb(zzb);
        zzaic.zza().zzb(zzd, zzyv.class);
        zzahj.zza().zzb(zzc, true);
    }
}
