package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzzu {
    public static final /* synthetic */ int zza = 0;
    private static final zzaad zzb;

    static {
        int i = zzxb.zza;
        zzb = new zzaaf();
    }

    @Deprecated
    static int zzA(int i, zzzi zzziVar, zzzs zzzsVar) {
        int iZzw = zzxp.zzw(i << 3);
        return iZzw + iZzw + ((zzwz) zzziVar).zzt(zzzsVar);
    }

    public static zzaad zzB() {
        return zzb;
    }

    static boolean zzC(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static void zzD(zzxs zzxsVar, Object obj, Object obj2) {
        if (((zzyb) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzE(zzaad zzaadVar, Object obj, Object obj2) {
        zzyd zzydVar = (zzyd) obj;
        zzaae zzaaeVarZzb = zzydVar.zzc;
        zzaae zzaaeVar = ((zzyd) obj2).zzc;
        if (!zzaae.zza().equals(zzaaeVar)) {
            if (zzaae.zza().equals(zzaaeVarZzb)) {
                zzaaeVarZzb = zzaae.zzb(zzaaeVarZzb, zzaaeVar);
            } else {
                zzaaeVarZzb.zzh(zzaaeVar);
            }
        }
        zzydVar.zzc = zzaaeVarZzb;
    }

    public static void zza(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzA(i, list, z);
    }

    public static void zzb(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzz(i, list, z);
    }

    public static void zzc(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzw(i, list, z);
    }

    public static void zzd(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzx(i, list, z);
    }

    public static void zze(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzJ(i, list, z);
    }

    public static void zzf(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzy(i, list, z);
    }

    public static void zzg(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzH(i, list, z);
    }

    public static void zzh(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzu(i, list, z);
    }

    public static void zzi(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzF(i, list, z);
    }

    public static void zzj(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzI(i, list, z);
    }

    public static void zzk(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzv(i, list, z);
    }

    public static void zzl(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzG(i, list, z);
    }

    public static void zzm(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzB(i, list, z);
    }

    public static void zzn(int i, List list, zzaap zzaapVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaapVar.zzC(i, list, z);
    }

    static int zzo(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzyx)) {
            int iZzx = 0;
            while (i < size) {
                iZzx += zzxp.zzx(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzx;
        }
        zzyx zzyxVar = (zzyx) list;
        int iZzx2 = 0;
        while (i < size) {
            iZzx2 += zzxp.zzx(zzyxVar.zze(i));
            i++;
        }
        return iZzx2;
    }

    static int zzp(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzyx)) {
            int iZzx = 0;
            while (i < size) {
                iZzx += zzxp.zzx(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzx;
        }
        zzyx zzyxVar = (zzyx) list;
        int iZzx2 = 0;
        while (i < size) {
            iZzx2 += zzxp.zzx(zzyxVar.zze(i));
            i++;
        }
        return iZzx2;
    }

    static int zzq(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzyx)) {
            int iZzx = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzx += zzxp.zzx((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzx;
        }
        zzyx zzyxVar = (zzyx) list;
        int iZzx2 = 0;
        while (i < size) {
            long jZze = zzyxVar.zze(i);
            iZzx2 += zzxp.zzx((jZze >> 63) ^ (jZze + jZze));
            i++;
        }
        return iZzx2;
    }

    static int zzr(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzye)) {
            int iZzx = 0;
            while (i < size) {
                iZzx += zzxp.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzx;
        }
        zzye zzyeVar = (zzye) list;
        int iZzx2 = 0;
        while (i < size) {
            iZzx2 += zzxp.zzx(zzyeVar.zzg(i));
            i++;
        }
        return iZzx2;
    }

    static int zzs(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzye)) {
            int iZzx = 0;
            while (i < size) {
                iZzx += zzxp.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzx;
        }
        zzye zzyeVar = (zzye) list;
        int iZzx2 = 0;
        while (i < size) {
            iZzx2 += zzxp.zzx(zzyeVar.zzg(i));
            i++;
        }
        return iZzx2;
    }

    static int zzt(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzye)) {
            int iZzw = 0;
            while (i < size) {
                iZzw += zzxp.zzw(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzw;
        }
        zzye zzyeVar = (zzye) list;
        int iZzw2 = 0;
        while (i < size) {
            iZzw2 += zzxp.zzw(zzyeVar.zzg(i));
            i++;
        }
        return iZzw2;
    }

    static int zzu(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzye)) {
            int iZzw = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzw += zzxp.zzw((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzw;
        }
        zzye zzyeVar = (zzye) list;
        int iZzw2 = 0;
        while (i < size) {
            int iZzg = zzyeVar.zzg(i);
            iZzw2 += zzxp.zzw((iZzg >> 31) ^ (iZzg + iZzg));
            i++;
        }
        return iZzw2;
    }

    static int zzv(List list) {
        return list.size() * 4;
    }

    static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzxp.zzw(i << 3) + 4);
    }

    static int zzx(List list) {
        return list.size() * 8;
    }

    static int zzy(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzxp.zzw(i << 3) + 8);
    }

    static int zzz(int i, Object obj, zzzs zzzsVar) {
        int iZzw;
        int iZzt;
        int iZzw2;
        int i2 = i << 3;
        if (obj instanceof zzyt) {
            iZzw = zzxp.zzw(i2);
            iZzt = ((zzyt) obj).zzb();
            iZzw2 = zzxp.zzw(iZzt);
        } else {
            iZzw = zzxp.zzw(i2);
            iZzt = ((zzwz) obj).zzt(zzzsVar);
            iZzw2 = zzxp.zzw(iZzt);
        }
        return iZzw + iZzw2 + iZzt;
    }
}
