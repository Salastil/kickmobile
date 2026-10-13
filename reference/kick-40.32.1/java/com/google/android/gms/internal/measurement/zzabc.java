package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabc extends AbstractMap {
    private static final Comparator zza = new zzaaz();
    private final Object[] zzb;
    private final int[] zzc;
    private final Set zzd;
    private Integer zze;
    private String zzf;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzabc, java.util.AbstractMap] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.measurement.zzabc] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    zzabc(zzabc zzabcVar, zzabc zzabcVar2) {
        int i;
        Object objZza;
        Object[] objArr;
        ?? abstractMap = new AbstractMap();
        abstractMap.zzd = new zzabb(abstractMap, -1);
        abstractMap.zze = null;
        abstractMap.zzf = null;
        int size = zzabcVar.size() + zzabcVar2.size();
        int i2 = zzabcVar.zzc[zzabcVar.size()] + zzabcVar2.zzc[zzabcVar2.size()];
        int i3 = size + 1;
        Object[] objArr2 = new Object[i2];
        int[] iArr = new int[i3];
        int i4 = 0;
        iArr[0] = size;
        Map.Entry entryZzg = zzabcVar.zzg(0);
        Map.Entry entryZzg2 = zzabcVar2.zzg(0);
        int i5 = 0;
        int i6 = 0;
        int iZzd = size;
        Map.Entry entryZzg3 = entryZzg;
        int i7 = 0;
        while (true) {
            int i8 = 1;
            if (entryZzg3 == null && entryZzg2 == null) {
                break;
            }
            i7++;
            if (entryZzg3 != null) {
                if (entryZzg2 != null) {
                    int iCompareTo = ((String) entryZzg3.getKey()).compareTo((String) entryZzg2.getKey());
                    if (iCompareTo == 0) {
                        int i9 = i5 + 1;
                        int i10 = i6 + 1;
                        objArr2[i7] = abstractMap.zzf((String) entryZzg3.getKey(), i7);
                        zzabb zzabbVar = (zzabb) entryZzg3.getValue();
                        zzabb zzabbVar2 = (zzabb) entryZzg2.getValue();
                        int i11 = 0;
                        int i12 = 0;
                        abstractMap = abstractMap;
                        while (true) {
                            if (i11 >= zzabbVar.zzc() - zzabbVar.zzb() && i12 >= zzabbVar2.zzc() - zzabbVar2.zzb()) {
                                break;
                            }
                            int iCompare = i11 == zzabbVar.zzc() - zzabbVar.zzb() ? i8 : i12 == zzabbVar2.zzc() - zzabbVar2.zzb() ? -1 : 0;
                            if (iCompare == 0) {
                                int i13 = zzabe.zza;
                                iCompare = zzabe.zzb.compare(zzabbVar.zza(i11), zzabbVar2.zza(i12));
                            }
                            if (iCompare < 0) {
                                i = i11 + 1;
                                objZza = zzabbVar.zza(i11);
                            } else {
                                int i14 = i12 + 1;
                                Object objZza2 = zzabbVar2.zza(i12);
                                i12 = i14;
                                i = iCompare == 0 ? i11 + 1 : i11;
                                objZza = objZza2;
                            }
                            objArr2[iZzd] = objZza;
                            i11 = i;
                            iZzd++;
                            i8 = 1;
                            abstractMap = this;
                        }
                        iArr[i7] = iZzd;
                        entryZzg3 = zzabcVar.zzg(i10);
                        entryZzg2 = zzabcVar2.zzg(i9);
                        i6 = i10;
                        i5 = i9;
                        i4 = 0;
                    } else {
                        if (iCompareTo < 0) {
                        }
                        i4 = 0;
                        abstractMap = this;
                    }
                }
                i6++;
                iZzd = zzd(entryZzg3, i7, iZzd, objArr2, iArr);
                entryZzg3 = zzabcVar.zzg(i6);
                i4 = 0;
                abstractMap = this;
            }
            Map.Entry entry = entryZzg3;
            i5++;
            int iZzd2 = zzd(entryZzg2, i7, iZzd, objArr2, iArr);
            entryZzg2 = zzabcVar2.zzg(i5);
            iZzd = iZzd2;
            entryZzg3 = entry;
            i4 = 0;
            abstractMap = this;
        }
        int i15 = iArr[i4];
        int i16 = i15 - i7;
        if (i16 != 0) {
            for (int i17 = i4; i17 <= i7; i17++) {
                iArr[i17] = iArr[i17] - i16;
            }
            int i18 = iArr[i7];
            int i19 = i18 - i7;
            if (zze(i2, i18)) {
                objArr = new Object[i18];
                System.arraycopy(objArr2, i4, objArr, i4, i7);
            } else {
                objArr = objArr2;
            }
            System.arraycopy(objArr2, i15, objArr, i7, i19);
            objArr2 = objArr;
        }
        abstractMap.zzb = objArr2;
        int i20 = iArr[i4] + 1;
        abstractMap.zzc = zze(i3, i20) ? Arrays.copyOf(iArr, i20) : iArr;
    }

    private final int zzd(Map.Entry entry, int i, int i2, Object[] objArr, int[] iArr) {
        zzabb zzabbVar = (zzabb) entry.getValue();
        int iZzc = zzabbVar.zzc() - zzabbVar.zzb();
        System.arraycopy(zzabbVar.zzb.zzb, zzabbVar.zzb(), objArr, i2, iZzc);
        objArr[i] = zzf((String) entry.getKey(), i);
        int i3 = i2 + iZzc;
        iArr[i + 1] = i3;
        return i3;
    }

    private static boolean zze(int i, int i2) {
        return i > 16 && i * 9 > i2 * 10;
    }

    private final Map.Entry zzf(String str, int i) {
        return new AbstractMap.SimpleImmutableEntry(str, new zzabb(this, i));
    }

    private final Map.Entry zzg(int i) {
        if (i < this.zzc[0]) {
            return (Map.Entry) this.zzb[i];
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(super.hashCode());
        }
        return this.zze.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        if (this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }

    final /* synthetic */ Object[] zzb() {
        return this.zzb;
    }

    final /* synthetic */ int[] zzc() {
        return this.zzc;
    }

    zzabc(List list) {
        this.zzd = new zzabb(this, -1);
        this.zze = null;
        this.zzf = null;
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw null;
        }
        int size = list.size();
        Object[] objArr = new Object[size];
        Iterator it2 = list.iterator();
        if (it2.hasNext()) {
            throw null;
        }
        int[] iArr = {0};
        this.zzb = zze(size, 0) ? Arrays.copyOf(objArr, 0) : objArr;
        this.zzc = iArr;
    }
}
