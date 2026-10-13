package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzhz extends zzhr implements Set {
    private transient zzhv zza;

    zzhz() {
    }

    public static zzhz zzh() {
        return zzii.zza;
    }

    static int zzi(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzhz zzj(Collection collection) {
        Object[] array = collection.toArray();
        return zzm(array.length, array);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzhz) && zzk() && ((zzhz) obj).zzk() && hashCode() != obj.hashCode()) {
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
        return zzij.zza(this);
    }

    @Override // com.google.android.gms.internal.cast.zzhr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza */
    public abstract zzil iterator();

    @Override // com.google.android.gms.internal.cast.zzhr
    public zzhv zze() {
        zzhv zzhvVar = this.zza;
        if (zzhvVar != null) {
            return zzhvVar;
        }
        zzhv zzhvVarZzl = zzl();
        this.zza = zzhvVarZzl;
        return zzhvVarZzl;
    }

    boolean zzk() {
        return false;
    }

    zzhv zzl() {
        Object[] array = toArray();
        int i = zzhv.zzd;
        return zzhv.zzk(array, array.length);
    }

    private static zzhz zzm(int i, Object... objArr) {
        if (i == 0) {
            return zzii.zza;
        }
        if (i == 1) {
            return new zzik(Objects.requireNonNull(objArr[0]));
        }
        int iZzi = zzi(i);
        Object[] objArr2 = new Object[iZzi];
        int i2 = iZzi - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzib.zzb(obj, i5);
            int iHashCode = obj.hashCode();
            int iZza = zzho.zza(iHashCode);
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
            return new zzik(Objects.requireNonNull(objArr[0]));
        }
        if (zzi(i4) < iZzi / 2) {
            return zzm(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzii(objArr, i3, objArr2, i2, i4);
    }
}
