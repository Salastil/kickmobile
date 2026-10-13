package com.google.android.gms.internal.pal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznu extends zzns {
    private final Comparator zzd;

    public zznu(Comparator comparator) {
        this.zzd = comparator;
    }

    @Override // com.google.android.gms.internal.pal.zzns
    public final /* synthetic */ zzns zzd(Object obj) {
        super.zzd(obj);
        return this;
    }

    @Override // com.google.android.gms.internal.pal.zzns
    final /* synthetic */ zzns zze(zzns zznsVar) {
        super.zze(zznsVar);
        return this;
    }

    public final zznu zzg(Object obj) {
        super.zzd(obj);
        return this;
    }

    public final zznu zzh(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            super.zzd(it.next());
        }
        return this;
    }

    @Override // com.google.android.gms.internal.pal.zzns
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zznv zzf() {
        zzop zzopVar;
        Object[] objArrCopyOf = this.zza;
        int i = this.zzb;
        Comparator comparator = this.zzd;
        if (i == 0) {
            zzopVar = zznv.zzk(comparator);
        } else {
            zzoc.zza(objArrCopyOf, i);
            Arrays.sort(objArrCopyOf, 0, i, comparator);
            int i2 = 1;
            for (int i3 = 1; i3 < i; i3++) {
                Object obj = objArrCopyOf[i3];
                if (comparator.compare(obj, objArrCopyOf[i2 - 1]) != 0) {
                    objArrCopyOf[i2] = obj;
                    i2++;
                }
            }
            Arrays.fill(objArrCopyOf, i2, i, (Object) null);
            if (i2 < (objArrCopyOf.length >> 1)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            zzopVar = new zzop(zznm.zzk(objArrCopyOf, i2), comparator);
        }
        this.zzb = zzopVar.zzd.size();
        this.zzc = true;
        return zzopVar;
    }
}
