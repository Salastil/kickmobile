package com.google.android.gms.internal.pal;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzsl implements Comparator {
    zzsl() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzsr zzsrVarZza = zzsr.zza(obj);
        zzsr zzsrVarZza2 = zzsr.zza(obj2);
        if (zzsrVarZza != zzsrVarZza2) {
            return zzsrVarZza.compareTo(zzsrVarZza2);
        }
        int iOrdinal = zzsrVarZza.ordinal();
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
