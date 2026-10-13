package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzic {
    public static final /* synthetic */ int zza = 0;
    private static final zziq zzb;

    static {
        int i = zzfc.zza;
        zzb = new zzis();
    }

    public static void zzA(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzD(i, list, z);
    }

    public static void zzB(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzF(i, list, z);
    }

    public static void zzC(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzK(i, list, z);
    }

    public static void zzD(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzM(i, list, z);
    }

    static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @Deprecated
    static int zza(int i, zzhr zzhrVar, zzib zzibVar) {
        int iZzy = zzfx.zzy(i << 3);
        return iZzy + iZzy + ((zzfa) zzhrVar).zzi(zzibVar);
    }

    static int zzb(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgq)) {
            int iZzz = 0;
            while (i < size) {
                iZzz += zzfx.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzz;
        }
        zzgq zzgqVar = (zzgq) list;
        int iZzz2 = 0;
        while (i < size) {
            iZzz2 += zzfx.zzz(zzgqVar.zze(i));
            i++;
        }
        return iZzz2;
    }

    static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfx.zzy(i << 3) + 4);
    }

    static int zzd(List list) {
        return list.size() * 4;
    }

    static int zze(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfx.zzy(i << 3) + 8);
    }

    static int zzf(List list) {
        return list.size() * 8;
    }

    static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgq)) {
            int iZzz = 0;
            while (i < size) {
                iZzz += zzfx.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzz;
        }
        zzgq zzgqVar = (zzgq) list;
        int iZzz2 = 0;
        while (i < size) {
            iZzz2 += zzfx.zzz(zzgqVar.zze(i));
            i++;
        }
        return iZzz2;
    }

    static int zzh(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhj)) {
            int iZzz = 0;
            while (i < size) {
                iZzz += zzfx.zzz(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzz;
        }
        zzhj zzhjVar = (zzhj) list;
        int iZzz2 = 0;
        while (i < size) {
            iZzz2 += zzfx.zzz(zzhjVar.zze(i));
            i++;
        }
        return iZzz2;
    }

    static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgq)) {
            int iZzy = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzy += zzfx.zzy((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzy;
        }
        zzgq zzgqVar = (zzgq) list;
        int iZzy2 = 0;
        while (i < size) {
            int iZze = zzgqVar.zze(i);
            iZzy2 += zzfx.zzy((iZze >> 31) ^ (iZze + iZze));
            i++;
        }
        return iZzy2;
    }

    static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhj)) {
            int iZzz = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzz += zzfx.zzz((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzz;
        }
        zzhj zzhjVar = (zzhj) list;
        int iZzz2 = 0;
        while (i < size) {
            long jZze = zzhjVar.zze(i);
            iZzz2 += zzfx.zzz((jZze >> 63) ^ (jZze + jZze));
            i++;
        }
        return iZzz2;
    }

    static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgq)) {
            int iZzy = 0;
            while (i < size) {
                iZzy += zzfx.zzy(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzy;
        }
        zzgq zzgqVar = (zzgq) list;
        int iZzy2 = 0;
        while (i < size) {
            iZzy2 += zzfx.zzy(zzgqVar.zze(i));
            i++;
        }
        return iZzy2;
    }

    static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhj)) {
            int iZzz = 0;
            while (i < size) {
                iZzz += zzfx.zzz(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzz;
        }
        zzhj zzhjVar = (zzhj) list;
        int iZzz2 = 0;
        while (i < size) {
            iZzz2 += zzfx.zzz(zzhjVar.zze(i));
            i++;
        }
        return iZzz2;
    }

    public static zziq zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, int i2, Object obj2, zziq zziqVar) {
        if (obj2 == null) {
            obj2 = zzis.zza(obj);
        }
        ((zzir) obj2).zzj(i << 3, Long.valueOf(i2));
        return obj2;
    }

    static void zzo(zzgd zzgdVar, Object obj, Object obj2) {
        if (((zzgm) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzp(zziq zziqVar, Object obj, Object obj2) {
        zzgp zzgpVar = (zzgp) obj;
        zzir zzirVarZze = zzgpVar.zzc;
        zzir zzirVar = ((zzgp) obj2).zzc;
        if (!zzir.zzc().equals(zzirVar)) {
            if (zzir.zzc().equals(zzirVarZze)) {
                zzirVarZze = zzir.zze(zzirVarZze, zzirVar);
            } else {
                zzirVarZze.zzd(zzirVar);
            }
        }
        zzgpVar.zzc = zzirVarZze;
    }

    public static void zzq(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzz(i, list, z);
    }

    public static void zzz(int i, List list, zzji zzjiVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjiVar.zzB(i, list, z);
    }
}
