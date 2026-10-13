package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzawp {
    public static final /* synthetic */ int zza = 0;
    private static final zzaxa zzb;

    static {
        int i = zzata.zza;
        zzb = new zzaxc();
    }

    @Deprecated
    static int zzA(int i, zzavw zzavwVar, zzawn zzawnVar) {
        int iZzu = zzatt.zzu(i << 3);
        return iZzu + iZzu + ((zzasx) zzavwVar).zzar(zzawnVar);
    }

    public static zzaxa zzB() {
        return zzb;
    }

    static boolean zzC(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static void zzD(zzatz zzatzVar, Object obj, Object obj2) {
        if (((zzauk) obj2).zza.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzE(zzaxa zzaxaVar, Object obj, Object obj2) {
        zzaun zzaunVar = (zzaun) obj;
        zzaxb zzaxbVarZzc = zzaunVar.zzc;
        zzaxb zzaxbVar = ((zzaun) obj2).zzc;
        if (!zzaxb.zza().equals(zzaxbVar)) {
            if (zzaxb.zza().equals(zzaxbVarZzc)) {
                zzaxbVarZzc = zzaxb.zzc(zzaxbVarZzc, zzaxbVar);
            } else {
                zzaxbVarZzc.zzl(zzaxbVar);
            }
        }
        zzaunVar.zzc = zzaxbVarZzc;
    }

    static Object zzF(Object obj, int i, List list, zzaus zzausVar, Object obj2, zzaxa zzaxaVar) {
        if (zzausVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzausVar.zza(iIntValue)) {
                    obj2 = zzG(obj, i, iIntValue, obj2, zzaxaVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = (Integer) list.get(i3);
            int iIntValue2 = num.intValue();
            if (zzausVar.zza(iIntValue2)) {
                if (i3 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj2 = zzG(obj, i, iIntValue2, obj2, zzaxaVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    static Object zzG(Object obj, int i, int i2, Object obj2, zzaxa zzaxaVar) {
        if (obj2 == null) {
            obj2 = zzaxaVar.zzh(obj);
        }
        zzaxaVar.zza(obj2, i, i2);
        return obj2;
    }

    public static void zza(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzC(i, list, z);
    }

    public static void zzb(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzB(i, list, z);
    }

    public static void zzc(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzy(i, list, z);
    }

    public static void zzd(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzz(i, list, z);
    }

    public static void zze(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzL(i, list, z);
    }

    public static void zzf(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzA(i, list, z);
    }

    public static void zzg(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzJ(i, list, z);
    }

    public static void zzh(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzw(i, list, z);
    }

    public static void zzi(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzH(i, list, z);
    }

    public static void zzj(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzK(i, list, z);
    }

    public static void zzk(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzx(i, list, z);
    }

    public static void zzl(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzI(i, list, z);
    }

    public static void zzm(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzD(i, list, z);
    }

    public static void zzn(int i, List list, zzaxp zzaxpVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaxpVar.zzE(i, list, z);
    }

    static int zzo(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzavl)) {
            int iZzv = 0;
            while (i < size) {
                iZzv += zzatt.zzv(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzv;
        }
        zzavl zzavlVar = (zzavl) list;
        int iZzv2 = 0;
        while (i < size) {
            iZzv2 += zzatt.zzv(zzavlVar.zze(i));
            i++;
        }
        return iZzv2;
    }

    static int zzp(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzavl)) {
            int iZzv = 0;
            while (i < size) {
                iZzv += zzatt.zzv(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzv;
        }
        zzavl zzavlVar = (zzavl) list;
        int iZzv2 = 0;
        while (i < size) {
            iZzv2 += zzatt.zzv(zzavlVar.zze(i));
            i++;
        }
        return iZzv2;
    }

    static int zzq(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzavl)) {
            int iZzv = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzv += zzatt.zzv((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzv;
        }
        zzavl zzavlVar = (zzavl) list;
        int iZzv2 = 0;
        while (i < size) {
            long jZze = zzavlVar.zze(i);
            iZzv2 += zzatt.zzv((jZze >> 63) ^ (jZze + jZze));
            i++;
        }
        return iZzv2;
    }

    static int zzr(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzauo)) {
            int iZzv = 0;
            while (i < size) {
                iZzv += zzatt.zzv(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzv;
        }
        zzauo zzauoVar = (zzauo) list;
        int iZzv2 = 0;
        while (i < size) {
            iZzv2 += zzatt.zzv(zzauoVar.zzf(i));
            i++;
        }
        return iZzv2;
    }

    static int zzs(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzauo)) {
            int iZzv = 0;
            while (i < size) {
                iZzv += zzatt.zzv(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzv;
        }
        zzauo zzauoVar = (zzauo) list;
        int iZzv2 = 0;
        while (i < size) {
            iZzv2 += zzatt.zzv(zzauoVar.zzf(i));
            i++;
        }
        return iZzv2;
    }

    static int zzt(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzauo)) {
            int iZzu = 0;
            while (i < size) {
                iZzu += zzatt.zzu(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzu;
        }
        zzauo zzauoVar = (zzauo) list;
        int iZzu2 = 0;
        while (i < size) {
            iZzu2 += zzatt.zzu(zzauoVar.zzf(i));
            i++;
        }
        return iZzu2;
    }

    static int zzu(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzauo)) {
            int iZzu = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzu += zzatt.zzu((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzu;
        }
        zzauo zzauoVar = (zzauo) list;
        int iZzu2 = 0;
        while (i < size) {
            int iZzf = zzauoVar.zzf(i);
            iZzu2 += zzatt.zzu((iZzf >> 31) ^ (iZzf + iZzf));
            i++;
        }
        return iZzu2;
    }

    static int zzv(List list) {
        return list.size() * 4;
    }

    static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzatt.zzu(i << 3) + 4);
    }

    static int zzx(List list) {
        return list.size() * 8;
    }

    static int zzy(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzatt.zzu(i << 3) + 8);
    }

    static int zzz(int i, Object obj, zzawn zzawnVar) {
        int iZzu;
        int iZzar;
        int iZzu2;
        int i2 = i << 3;
        if (obj instanceof zzavh) {
            iZzu = zzatt.zzu(i2);
            iZzar = ((zzavh) obj).zzb();
            iZzu2 = zzatt.zzu(iZzar);
        } else {
            iZzu = zzatt.zzu(i2);
            iZzar = ((zzasx) obj).zzar(zzawnVar);
            iZzu2 = zzatt.zzu(iZzar);
        }
        return iZzu + iZzu2 + iZzar;
    }
}
