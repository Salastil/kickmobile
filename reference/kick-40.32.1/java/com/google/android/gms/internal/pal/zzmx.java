package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzmx extends zzmz {
    zzmx() {
        super(null);
    }

    @Override // com.google.android.gms.internal.pal.zzmz
    public final zzmz zza(Comparable comparable, Comparable comparable2) {
        int iCompareTo = comparable.compareTo(comparable2);
        if (iCompareTo < 0) {
            return zzmz.zzb;
        }
        return iCompareTo > 0 ? zzmz.zzc : zzmz.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzmz
    public final int zzb() {
        return 0;
    }
}
