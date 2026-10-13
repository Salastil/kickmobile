package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsx extends zzsv {
    private static final Map zza;
    private final zzqn zzb;

    static {
        EnumMap enumMap = new EnumMap(zzqn.class);
        for (zzqn zzqnVar : zzqn.values()) {
            zzsx[] zzsxVarArr = new zzsx[10];
            for (int i = 0; i < 10; i++) {
                zzsxVarArr[i] = new zzsx(i, zzqnVar, zzqo.zza());
            }
            enumMap.put(zzqnVar, zzsxVarArr);
        }
        zza = Collections.unmodifiableMap(enumMap);
    }

    private zzsx(int i, zzqn zzqnVar, zzqo zzqoVar) {
        super(zzqoVar, i);
        zztf.zza(zzqnVar, "format char");
        this.zzb = zzqnVar;
        if (zzqoVar.zze()) {
            zzqnVar.zze();
            return;
        }
        int iZzb = zzqnVar.zzb();
        iZzb = zzqoVar.zzk() ? iZzb & 65503 : iZzb;
        StringBuilder sb = new StringBuilder("%");
        zzqoVar.zzl(sb);
        sb.append((char) iZzb);
    }

    public static zzsx zza(int i, zzqn zzqnVar, zzqo zzqoVar) {
        if (i >= 10 || !zzqoVar.zze()) {
            return new zzsx(i, zzqnVar, zzqoVar);
        }
        zzsx[] zzsxVarArr = (zzsx[]) zza.get(zzqnVar);
        zztf.zza(zzsxVarArr, "default parameter");
        return zzsxVarArr[i];
    }

    @Override // com.google.android.gms.internal.pal.zzsv
    protected final void zzb(zzsw zzswVar, Object obj) {
        zzswVar.zzc(obj, this.zzb, zzd());
    }
}
