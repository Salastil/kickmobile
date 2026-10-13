package com.google.android.gms.internal.pal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzra {
    private static final zzrd zza = new zzqy();
    private static final zzrc zzb = new zzqz();
    private final zzrd zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzrc zzf = null;

    public final zzra zza(zzrc zzrcVar) {
        this.zzf = zzrcVar;
        return this;
    }

    final void zzb(zzpz zzpzVar) {
        zztf.zza(zzpzVar, "key");
        if (!zzpzVar.zzf()) {
            zzrd zzrdVar = zza;
            zztf.zza(zzpzVar, "key");
            this.zzd.remove(zzpzVar);
            this.zzc.put(zzpzVar, zzrdVar);
            return;
        }
        zzrc zzrcVar = zzb;
        zztf.zza(zzpzVar, "key");
        zztf.zzb(zzpzVar.zzf(), "key must be repeating");
        this.zzc.remove(zzpzVar);
        this.zzd.put(zzpzVar, zzrcVar);
    }

    public final zzre zzc() {
        return new zzrb(this, null);
    }

    final /* synthetic */ Map zzd() {
        return this.zzc;
    }

    final /* synthetic */ Map zze() {
        return this.zzd;
    }

    final /* synthetic */ zzrd zzf() {
        return this.zze;
    }

    final /* synthetic */ zzrc zzg() {
        return this.zzf;
    }
}
