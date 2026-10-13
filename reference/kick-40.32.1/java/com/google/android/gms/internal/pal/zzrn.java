package com.google.android.gms.internal.pal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzrn extends zzro {
    private final Map zza;

    /* synthetic */ zzrn(zzqx zzqxVar, zzqx zzqxVar2, byte[] bArr) {
        super(null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzd(linkedHashMap, zzqxVar);
        zzd(linkedHashMap, zzqxVar2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((zzpz) entry.getKey()).zzf()) {
                entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
            }
        }
        this.zza = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void zzd(Map map, zzqx zzqxVar) {
        for (int i = 0; i < zzqxVar.zza(); i++) {
            zzpz zzpzVarZzb = zzqxVar.zzb(i);
            Object obj = map.get(zzpzVarZzb);
            if (zzpzVarZzb.zzf()) {
                List arrayList = (List) obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(zzpzVarZzb, arrayList);
                }
                arrayList.add(zzpzVarZzb.zze(zzqxVar.zzc(i)));
            } else {
                map.put(zzpzVarZzb, zzpzVarZzb.zze(zzqxVar.zzc(i)));
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzro
    public final void zza(zzre zzreVar, Object obj) {
        for (Map.Entry entry : this.zza.entrySet()) {
            zzpz zzpzVar = (zzpz) entry.getKey();
            Object value = entry.getValue();
            if (zzpzVar.zzf()) {
                zzreVar.zzb(zzpzVar, ((List) value).iterator(), obj);
            } else {
                zzreVar.zza(zzpzVar, value, obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzro
    public final int zzb() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.pal.zzro
    public final Set zzc() {
        return this.zza.keySet();
    }
}
