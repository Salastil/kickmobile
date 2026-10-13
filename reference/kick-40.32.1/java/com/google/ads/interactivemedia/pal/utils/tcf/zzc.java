package com.google.ads.interactivemedia.pal.utils.tcf;

import com.google.android.gms.internal.pal.zznp;
import com.google.android.gms.internal.pal.zzup;
import com.google.android.gms.internal.pal.zzux;
import com.google.android.gms.internal.pal.zzvh;
import com.google.android.gms.internal.pal.zzvm;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzc {
    zzc() {
    }

    static zzc zzm(zzvh zzvhVar, String str, @Nullable Boolean bool, @Nullable List list) {
        zzvm zzvmVarZza = zzvhVar.zza();
        int iZza = zzvmVarZza.zza();
        int iZzb = zzvmVarZza.zzb();
        String strZzf = zzvmVarZza.zzf();
        boolean zZze = zzvmVarZza.zze();
        Map mapZzn = zzn(zzvmVarZza.zzc(), null);
        Map mapZzn2 = zzn(zzvmVarZza.zzd(), null);
        Map mapZzn3 = zzn(zzvmVarZza.zzg(), null);
        Map mapZzn4 = zzn(zzvmVarZza.zzh(), null);
        List<zzux> listZzi = zzvmVarZza.zzi();
        EnumMap enumMap = new EnumMap(zzup.class);
        for (zzux zzuxVar : listZzi) {
            zzup zzupVarZza = zzuxVar.zza();
            if (!enumMap.containsKey(zzupVarZza)) {
                enumMap.put(zzupVarZza, new HashMap());
            }
            Iterator it = zzuxVar.zzc().iterator();
            while (it.hasNext()) {
                ((Map) enumMap.get(zzupVarZza)).put((Integer) it.next(), zzuxVar.zzb());
            }
        }
        return new zza(str, bool, iZza, iZzb, strZzf, zZze, zznp.zze(mapZzn), zznp.zze(mapZzn2), zznp.zze(mapZzn3), zznp.zze(mapZzn4), zzvhVar.zzb() ? zznp.zze(zzn(zzvhVar.zzc().zza(), null)) : null, zznp.zze(enumMap));
    }

    private static Map zzn(List list, @Nullable List list2) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), true);
        }
        map.remove(0);
        return map;
    }

    abstract String zza();

    @Nullable
    abstract Boolean zzb();

    abstract int zzc();

    abstract int zzd();

    abstract String zze();

    abstract boolean zzf();

    abstract zznp zzg();

    abstract zznp zzh();

    abstract zznp zzi();

    abstract zznp zzj();

    @Nullable
    abstract zznp zzk();

    abstract zznp zzl();
}
