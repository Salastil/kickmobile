package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzadf {
    static final zzadf zza = new zzadf(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzadf zzd;
    private final Map zze;

    zzadf() {
        this.zze = new HashMap();
    }

    public static zzadf zza() {
        int i = zzacf.zza;
        return zza;
    }

    public static zzadf zzb() {
        zzadf zzadfVar = zzd;
        if (zzadfVar != null) {
            return zzadfVar;
        }
        synchronized (zzadf.class) {
            zzadf zzadfVar2 = zzd;
            if (zzadfVar2 != null) {
                return zzadfVar2;
            }
            int i = zzacf.zza;
            zzadf zzadfVarZzb = zzadn.zzb(zzadf.class);
            zzd = zzadfVarZzb;
            return zzadfVarZzb;
        }
    }

    public final zzadt zzc(zzafc zzafcVar, int i) {
        return (zzadt) this.zze.get(new zzade(zzafcVar, i));
    }

    zzadf(boolean z) {
        this.zze = Collections.EMPTY_MAP;
    }
}
