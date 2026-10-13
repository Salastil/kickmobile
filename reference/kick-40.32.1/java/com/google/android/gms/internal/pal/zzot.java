package com.google.android.gms.internal.pal;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzot {
    public static boolean zza(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = zzob.zza;
            }
        } else {
            if (!(iterable instanceof zzos)) {
                return false;
            }
            comparator2 = ((zzos) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
