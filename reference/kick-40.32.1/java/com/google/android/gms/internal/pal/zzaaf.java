package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaaf {
    public static final /* synthetic */ int zza = 0;
    private static final zzaix zzb = zzaix.zzd(zzaae.zza, zzaab.class, zzvr.class);
    private static final zzwa zzc = zzahr.zze("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzvr.class, 3, zzapw.zze());
    private static final zzaid zzd = zzaac.zza;
    private static final zzahi zze = zzaad.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzaco.zza(1)) {
            throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i = zzach.zza;
        zzach.zza(zzail.zza());
        zzaii.zza().zzb(zzb);
        zzaih zzaihVarZza = zzaih.zza();
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", zzaah.zzc(zzaag.zza));
        map.put("XCHACHA20_POLY1305_RAW", zzaah.zzc(zzaag.zzc));
        zzaihVarZza.zzc(Collections.unmodifiableMap(map));
        zzaic.zza().zzb(zze, zzaah.class);
        zzaie.zza().zzb(zzd, zzaah.class);
        zzahj.zza().zzb(zzc, true);
    }
}
