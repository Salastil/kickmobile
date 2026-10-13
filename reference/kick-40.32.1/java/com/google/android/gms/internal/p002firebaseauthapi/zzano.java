package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzano {
    private static final zzaob<?, ?> zza = new zzaod();

    @Deprecated
    static int zza(int i, zzamv zzamvVar, zzanl zzanlVar) {
        return (zzaky.zzd(i << 3) << 1) + ((zzaju) zzamvVar).zza(zzanlVar);
    }

    private static int zza(zzaju zzajuVar, zzanl zzanlVar) {
        int iZza = zzajuVar.zza(zzanlVar);
        return zzaky.zzd(iZza) + iZza;
    }

    static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzaky.zzd(i << 3) + 1);
    }

    static int zza(List<?> list) {
        return list.size();
    }

    static int zza(int i, List<zzakb> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzd = size * zzaky.zzd(i << 3);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzd += zzaky.zzb(list.get(i2));
        }
        return iZzd;
    }

    static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzaky.zzd(i << 3));
    }

    static int zzb(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalu)) {
            int iZzc = 0;
            while (i < size) {
                iZzc += zzaky.zzc(list.get(i).intValue());
                i++;
            }
            return iZzc;
        }
        zzalu zzaluVar = (zzalu) list;
        int iZzc2 = 0;
        while (i < size) {
            iZzc2 += zzaky.zzc(zzaluVar.zzb(i));
            i++;
        }
        return iZzc2;
    }

    static int zzc(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzaky.zzd(i << 3) + 4);
    }

    static int zzc(List<?> list) {
        return list.size() << 2;
    }

    static int zzd(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzaky.zzd(i << 3) + 8);
    }

    static int zzd(List<?> list) {
        return list.size() << 3;
    }

    static int zza(int i, List<zzamv> list, zzanl<?> zzanlVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZza = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZza += zza(i, list.get(i2), (zzanl) zzanlVar);
        }
        return iZza;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzaky.zzd(i << 3));
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalu)) {
            int iZzc = 0;
            while (i < size) {
                iZzc += zzaky.zzc(list.get(i).intValue());
                i++;
            }
            return iZzc;
        }
        zzalu zzaluVar = (zzalu) list;
        int iZzc2 = 0;
        while (i < size) {
            iZzc2 += zzaky.zzc(zzaluVar.zzb(i));
            i++;
        }
        return iZzc2;
    }

    static int zzf(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzaky.zzd(i << 3));
    }

    static int zzf(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzamm)) {
            int iZzc = 0;
            while (i < size) {
                iZzc += zzaky.zzc(list.get(i).longValue());
                i++;
            }
            return iZzc;
        }
        zzamm zzammVar = (zzamm) list;
        int iZzc2 = 0;
        while (i < size) {
            iZzc2 += zzaky.zzc(zzammVar.zzb(i));
            i++;
        }
        return iZzc2;
    }

    static int zza(int i, Object obj, zzanl<?> zzanlVar) {
        return zzaky.zzd(i << 3) + zza((zzaju) obj, (zzanl) zzanlVar);
    }

    static int zzb(int i, List<?> list, zzanl<?> zzanlVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzd = zzaky.zzd(i << 3) * size;
        for (int i2 = 0; i2 < size; i2++) {
            iZzd += zza((zzaju) list.get(i2), (zzanl) zzanlVar);
        }
        return iZzd;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzaky.zzd(i << 3));
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalu)) {
            int iZzd = 0;
            while (i < size) {
                iZzd += zzaky.zzd(zzaky.zze(list.get(i).intValue()));
                i++;
            }
            return iZzd;
        }
        zzalu zzaluVar = (zzalu) list;
        int iZzd2 = 0;
        while (i < size) {
            iZzd2 += zzaky.zzd(zzaky.zze(zzaluVar.zzb(i)));
            i++;
        }
        return iZzd2;
    }

    static int zzh(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzaky.zzd(i << 3));
    }

    static int zzh(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzamm)) {
            int iZzc = 0;
            while (i < size) {
                iZzc += zzaky.zzc(zzaky.zzd(list.get(i).longValue()));
                i++;
            }
            return iZzc;
        }
        zzamm zzammVar = (zzamm) list;
        int iZzc2 = 0;
        while (i < size) {
            iZzc2 += zzaky.zzc(zzaky.zzd(zzammVar.zzb(i)));
            i++;
        }
        return iZzc2;
    }

    static int zzb(int i, List<?> list) {
        int iZzb;
        int iZzb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzd = zzaky.zzd(i << 3) * size;
        if (!(list instanceof zzami)) {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzakb) {
                    iZzb = zzaky.zzb((zzakb) obj);
                } else {
                    iZzb = zzaky.zzb((String) obj);
                }
                iZzd += iZzb;
                i2++;
            }
            return iZzd;
        }
        zzami zzamiVar = (zzami) list;
        while (i2 < size) {
            Object objZza = zzamiVar.zza(i2);
            if (objZza instanceof zzakb) {
                iZzb2 = zzaky.zzb((zzakb) objZza);
            } else {
                iZzb2 = zzaky.zzb((String) objZza);
            }
            iZzd += iZzb2;
            i2++;
        }
        return iZzd;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzaky.zzd(i << 3));
    }

    static int zzi(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzalu)) {
            int iZzd = 0;
            while (i < size) {
                iZzd += zzaky.zzd(list.get(i).intValue());
                i++;
            }
            return iZzd;
        }
        zzalu zzaluVar = (zzalu) list;
        int iZzd2 = 0;
        while (i < size) {
            iZzd2 += zzaky.zzd(zzaluVar.zzb(i));
            i++;
        }
        return iZzd2;
    }

    static int zzj(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzaky.zzd(i << 3));
    }

    static int zzj(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzamm)) {
            int iZzc = 0;
            while (i < size) {
                iZzc += zzaky.zzc(list.get(i).longValue());
                i++;
            }
            return iZzc;
        }
        zzamm zzammVar = (zzamm) list;
        int iZzc2 = 0;
        while (i < size) {
            iZzc2 += zzaky.zzc(zzammVar.zzb(i));
            i++;
        }
        return iZzc2;
    }

    public static zzaob<?, ?> zza() {
        return zza;
    }

    static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzaly zzalyVar, UB ub, zzaob<UT, UB> zzaobVar) {
        if (zzalyVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = list.get(i3);
                int iIntValue = num.intValue();
                if (zzalyVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    ub = (UB) zza(obj, i, iIntValue, ub, zzaobVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!zzalyVar.zza(iIntValue2)) {
                ub = (UB) zza(obj, i, iIntValue2, ub, zzaobVar);
                it.remove();
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzaob<UT, UB> zzaobVar) {
        if (ub == null) {
            ub = zzaobVar.zzc(obj);
        }
        zzaobVar.zzb(ub, i, i2);
        return ub;
    }

    static <T, FT extends zzalo<FT>> void zza(zzalh<FT> zzalhVar, T t, T t2) {
        zzalm<T> zzalmVarZza = zzalhVar.zza(t2);
        if (zzalmVarZza.zza.isEmpty()) {
            return;
        }
        zzalhVar.zzb(t).zza((zzalm) zzalmVarZza);
    }

    static <T> void zza(zzams zzamsVar, T t, T t2, long j) {
        zzaoc.zza(t, j, zzamsVar.zza(zzaoc.zze(t, j), zzaoc.zze(t2, j)));
    }

    static <T, UT, UB> void zza(zzaob<UT, UB> zzaobVar, T t, T t2) {
        zzaobVar.zzc(t, zzaobVar.zza(zzaobVar.zzd(t), zzaobVar.zzd(t2)));
    }

    public static void zza(Class<?> cls) {
        zzalt.class.isAssignableFrom(cls);
    }

    public static void zza(int i, List<Boolean> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zza(i, list, z);
    }

    public static void zza(int i, List<zzakb> list, zzale zzaleVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zza(i, list);
    }

    public static void zzb(int i, List<Double> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzb(i, list, z);
    }

    public static void zzc(int i, List<Integer> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Integer> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zze(i, list, z);
    }

    public static void zzf(int i, List<Float> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzf(i, list, z);
    }

    public static void zza(int i, List<?> list, zzale zzaleVar, zzanl<?> zzanlVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zza(i, list, (zzanl) zzanlVar);
    }

    public static void zzg(int i, List<Integer> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzg(i, list, z);
    }

    public static void zzh(int i, List<Long> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzh(i, list, z);
    }

    public static void zzb(int i, List<?> list, zzale zzaleVar, zzanl<?> zzanlVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzb(i, list, (zzanl) zzanlVar);
    }

    public static void zzi(int i, List<Integer> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzi(i, list, z);
    }

    public static void zzj(int i, List<Long> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzj(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzk(i, list, z);
    }

    public static void zzl(int i, List<Long> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzl(i, list, z);
    }

    public static void zzb(int i, List<String> list, zzale zzaleVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzb(i, list);
    }

    public static void zzm(int i, List<Integer> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzm(i, list, z);
    }

    public static void zzn(int i, List<Long> list, zzale zzaleVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaleVar.zzn(i, list, z);
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
