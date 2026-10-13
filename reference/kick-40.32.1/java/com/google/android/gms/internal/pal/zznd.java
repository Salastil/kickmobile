package com.google.android.gms.internal.pal;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zznd implements Comparable, Serializable {
    final Comparable zza = "";

    zznd(Comparable comparable) {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zznd) {
            try {
                if (compareTo((zznd) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();

    abstract void zza(StringBuilder sb);

    abstract void zzb(StringBuilder sb);

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public int compareTo(zznd zzndVar) {
        if (zzndVar == zznc.zzb) {
            return 1;
        }
        if (zzndVar == zzna.zzb) {
            return -1;
        }
        Comparable comparable = zzndVar.zza;
        int i = zzog.zzc;
        int iCompareTo = "".compareTo("");
        return iCompareTo != 0 ? iCompareTo : Boolean.compare(this instanceof zznb, zzndVar instanceof zznb);
    }
}
