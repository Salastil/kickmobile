package com.google.android.gms.internal.pal;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zznt extends zznh implements Set {
    private transient zznm zza;

    zznt() {
    }

    static int zzf(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzls.zzb(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zznt) && zzg() && ((zznt) obj).zzg() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                return size() == set.size() && containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzoq.zza(this);
    }

    @Override // com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza */
    public abstract zzou iterator();

    boolean zzg() {
        return false;
    }

    public zznm zzh() {
        zznm zznmVar = this.zza;
        if (zznmVar != null) {
            return zznmVar;
        }
        zznm zznmVarZzi = zzi();
        this.zza = zznmVarZzi;
        return zznmVarZzi;
    }

    zznm zzi() {
        Object[] array = toArray();
        int i = zznm.zzd;
        return zznm.zzk(array, array.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zznt zzk(int i, Object... objArr) {
        if (i == 0) {
            return zzoo.zza;
        }
        if (i == 1) {
            return new zzor(Objects.requireNonNull(objArr[0]));
        }
        int iZzf = zzf(i);
        Object[] objArr2 = new Object[iZzf];
        int i2 = iZzf - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzoc.zzb(obj, i5);
            int iHashCode = obj.hashCode();
            int iZza = zzne.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                iZza++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzor(Objects.requireNonNull(objArr[0]));
        }
        if (zzf(i4) < iZzf / 2) {
            return zzk(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzoo(objArr, i3, objArr2, i2, i4);
    }
}
