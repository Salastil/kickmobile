package com.google.android.gms.internal.pal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzrb extends zzre {
    private final Map zza;
    private final Map zzb;
    private final zzrd zzc;
    private final zzrc zzd;

    /* synthetic */ zzrb(zzra zzraVar, byte[] bArr) {
        HashMap map = new HashMap();
        this.zza = map;
        HashMap map2 = new HashMap();
        this.zzb = map2;
        map.putAll(zzraVar.zzd());
        map2.putAll(zzraVar.zze());
        this.zzc = zzraVar.zzf();
        this.zzd = zzraVar.zzg();
    }

    @Override // com.google.android.gms.internal.pal.zzre
    protected final void zza(zzpz zzpzVar, Object obj, Object obj2) {
        zzrd zzrdVar = (zzrd) this.zza.get(zzpzVar);
        if (zzrdVar != null) {
            zzrdVar.zza(zzpzVar, obj, obj2);
        } else {
            this.zzc.zza(zzpzVar, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzre
    protected final void zzb(zzpz zzpzVar, Iterator it, Object obj) {
        zzrc zzrcVar = (zzrc) this.zzb.get(zzpzVar);
        if (zzrcVar != null) {
            zzrcVar.zza(zzpzVar, it, obj);
            return;
        }
        zzrc zzrcVar2 = this.zzd;
        if (zzrcVar2 != null && !this.zza.containsKey(zzpzVar)) {
            zzrcVar2.zza(zzpzVar, it, obj);
        } else {
            while (it.hasNext()) {
                zza(zzpzVar, it.next(), obj);
            }
        }
    }
}
