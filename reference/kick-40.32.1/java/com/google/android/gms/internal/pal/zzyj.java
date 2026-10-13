package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyj {
    public static final /* synthetic */ int zza = 0;
    private static final zzaix zzb = zzaix.zzd(zzyi.zza, zzyg.class, zzvr.class);
    private static final zzahi zzc = zzyh.zza;
    private static final zzwa zzd = zzahr.zze("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzvr.class, 3, zzang.zze());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i = zzabl.zza;
        zzabl.zza(zzail.zza());
        zzaii.zza().zzb(zzb);
        zzaic.zza().zzb(zzc, zzyl.class);
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", zzyl.zzb(zzyk.zza));
        map.put("CHACHA20_POLY1305_RAW", zzyl.zzb(zzyk.zzc));
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzahj.zza().zzb(zzd, true);
    }
}
