package com.google.android.gms.internal.pal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznq {
    private final List zza = new ArrayList();

    public final zznq zza(zzog zzogVar) {
        zzls.zzd(!zzogVar.zzb(), "range must not be empty, but was %s", zzogVar);
        this.zza.add(zzogVar);
        return this;
    }

    final zznq zzb(zznq zznqVar) {
        Iterator it = zznqVar.zza.iterator();
        while (it.hasNext()) {
            zza((zzog) it.next());
        }
        return this;
    }

    public final zznr zzc() {
        List list = this.zza;
        zzni zzniVar = new zzni(list.size());
        int i = zzog.zzc;
        Collections.sort(list, zzof.zza);
        Iterator it = list.iterator();
        zznx zznxVar = it instanceof zznx ? (zznx) it : new zznx(it);
        while (zznxVar.hasNext()) {
            zzog zzogVarZzd = (zzog) zznxVar.next();
            while (zznxVar.hasNext()) {
                zzog zzogVar = (zzog) zznxVar.zza();
                if (zzogVarZzd.zza.compareTo(zzogVar.zzb) > 0 || zzogVar.zza.compareTo(zzogVarZzd.zzb) > 0) {
                    break;
                }
                zzls.zze(zzogVarZzd.zzc(zzogVar).zzb(), "Overlapping ranges not permitted but found %s overlapping %s", zzogVarZzd, zzogVar);
                zzogVarZzd = zzogVarZzd.zzd((zzog) zznxVar.next());
            }
            zzniVar.zzd(zzogVarZzd);
        }
        zznm zznmVarZzf = zzniVar.zzf();
        if (zznmVarZzf.isEmpty()) {
            return zznr.zza();
        }
        if (zznmVarZzf.size() == 1) {
            zzov zzovVarListIterator = zznmVarZzf.listIterator(0);
            Object next = zzovVarListIterator.next();
            if (zzovVarListIterator.hasNext()) {
                StringBuilder sb = new StringBuilder("expected one element but was: <");
                sb.append(next);
                for (int i2 = 0; i2 < 4 && zzovVarListIterator.hasNext(); i2++) {
                    sb.append(", ");
                    sb.append(zzovVarListIterator.next());
                }
                if (zzovVarListIterator.hasNext()) {
                    sb.append(", ...");
                }
                sb.append(Typography.greater);
                throw new IllegalArgumentException(sb.toString());
            }
            if (((zzog) next).equals(zzog.zza())) {
                return zznr.zzb();
            }
        }
        return new zznr(zznmVarZzf);
    }
}
