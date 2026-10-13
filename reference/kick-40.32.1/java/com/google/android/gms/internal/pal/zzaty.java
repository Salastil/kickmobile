package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaty {
    static final zzaty zza = new zzaty(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzaty zzd;
    private final Map zze;

    zzaty() {
        this.zze = new HashMap();
    }

    public static zzaty zza() {
        int i = zzata.zza;
        return zza;
    }

    public static zzaty zzb() {
        zzaty zzatyVar = zzd;
        if (zzatyVar != null) {
            return zzatyVar;
        }
        synchronized (zzaty.class) {
            zzaty zzatyVar2 = zzd;
            if (zzatyVar2 != null) {
                return zzatyVar2;
            }
            int i = zzata.zza;
            zzaty zzatyVarZzb = zzaug.zzb(zzaty.class);
            zzd = zzatyVarZzb;
            return zzatyVarZzb;
        }
    }

    public final zzaum zzc(zzavw zzavwVar, int i) {
        return (zzaum) this.zze.get(new zzatx(zzavwVar, i));
    }

    zzaty(boolean z) {
        this.zze = Collections.EMPTY_MAP;
    }
}
