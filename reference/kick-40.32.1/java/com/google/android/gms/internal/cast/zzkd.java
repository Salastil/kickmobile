package com.google.android.gms.internal.cast;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzkd implements Comparator {
    zzkd() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzkj zzkjVarZza = zzkj.zza(obj);
        zzkj zzkjVarZza2 = zzkj.zza(obj2);
        if (zzkjVarZza != zzkjVarZza2) {
            return zzkjVarZza.compareTo(zzkjVarZza2);
        }
        int iOrdinal = zzkjVarZza.ordinal();
        if (iOrdinal == 0) {
            return ((Boolean) obj).compareTo((Boolean) obj2);
        }
        if (iOrdinal == 1) {
            return ((String) obj).compareTo((String) obj2);
        }
        if (iOrdinal == 2) {
            return ((Long) obj).compareTo((Long) obj2);
        }
        if (iOrdinal == 3) {
            return ((Double) obj).compareTo((Double) obj2);
        }
        throw null;
    }
}
