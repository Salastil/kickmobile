package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafq {
    public static final /* synthetic */ int zza = 0;
    private static final zzafz zzb;

    static {
        int i = zzacf.zza;
        zzb = new zzagb();
    }

    @Deprecated
    static int zzA(int i, zzafc zzafcVar, zzafp zzafpVar) {
        int iZzE = zzada.zzE(i << 3);
        return iZzE + iZzE + ((zzacb) zzafcVar).zzcf(zzafpVar);
    }

    public static zzafz zzB() {
        return zzb;
    }

    static boolean zzC(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static void zzD(zzadg zzadgVar, Object obj, Object obj2) {
        if (((zzadr) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzE(zzafz zzafzVar, Object obj, Object obj2) {
        zzadu zzaduVar = (zzadu) obj;
        zzaga zzagaVarZzc = zzaduVar.zzc;
        zzaga zzagaVar = ((zzadu) obj2).zzc;
        if (!zzaga.zza().equals(zzagaVar)) {
            if (zzaga.zza().equals(zzagaVarZzc)) {
                zzagaVarZzc = zzaga.zzc(zzagaVarZzc, zzagaVar);
            } else {
                zzagaVarZzc.zzl(zzagaVar);
            }
        }
        zzaduVar.zzc = zzagaVarZzc;
    }

    static Object zzF(Object obj, int i, List list, zzadz zzadzVar, Object obj2, zzafz zzafzVar) {
        if (zzadzVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzadzVar.zza(iIntValue)) {
                    obj2 = zzG(obj, i, iIntValue, obj2, zzafzVar);
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
            if (zzadzVar.zza(iIntValue2)) {
                if (i3 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj2 = zzG(obj, i, iIntValue2, obj2, zzafzVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    static Object zzG(Object obj, int i, int i2, Object obj2, zzafz zzafzVar) {
        if (obj2 == null) {
            obj2 = zzafzVar.zzh(obj);
        }
        zzafzVar.zza(obj2, i, i2);
        return obj2;
    }

    public static void zza(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzC(i, list, z);
    }

    public static void zzb(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzB(i, list, z);
    }

    public static void zzc(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzy(i, list, z);
    }

    public static void zzd(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzz(i, list, z);
    }

    public static void zze(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzL(i, list, z);
    }

    public static void zzf(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzA(i, list, z);
    }

    public static void zzg(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzJ(i, list, z);
    }

    public static void zzh(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzw(i, list, z);
    }

    public static void zzi(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzH(i, list, z);
    }

    public static void zzj(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzK(i, list, z);
    }

    public static void zzk(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzx(i, list, z);
    }

    public static void zzl(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzI(i, list, z);
    }

    public static void zzm(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzD(i, list, z);
    }

    public static void zzn(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzE(i, list, z);
    }

    static int zzo(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzaeq)) {
            int iZzF = 0;
            while (i < size) {
                iZzF += zzada.zzF(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzF;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        int iZzF2 = 0;
        while (i < size) {
            iZzF2 += zzada.zzF(zzaeqVar.zzc(i));
            i++;
        }
        return iZzF2;
    }

    static int zzp(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzaeq)) {
            int iZzF = 0;
            while (i < size) {
                iZzF += zzada.zzF(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzF;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        int iZzF2 = 0;
        while (i < size) {
            iZzF2 += zzada.zzF(zzaeqVar.zzc(i));
            i++;
        }
        return iZzF2;
    }

    static int zzq(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzaeq)) {
            int iZzF = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzF += zzada.zzF((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzF;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        int iZzF2 = 0;
        while (i < size) {
            long jZzc = zzaeqVar.zzc(i);
            iZzF2 += zzada.zzF((jZzc >> 63) ^ (jZzc + jZzc));
            i++;
        }
        return iZzF2;
    }

    static int zzr(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzadv)) {
            int iZzF = 0;
            while (i < size) {
                iZzF += zzada.zzF(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzF;
        }
        zzadv zzadvVar = (zzadv) list;
        int iZzF2 = 0;
        while (i < size) {
            iZzF2 += zzada.zzF(zzadvVar.zzf(i));
            i++;
        }
        return iZzF2;
    }

    static int zzs(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzadv)) {
            int iZzF = 0;
            while (i < size) {
                iZzF += zzada.zzF(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzF;
        }
        zzadv zzadvVar = (zzadv) list;
        int iZzF2 = 0;
        while (i < size) {
            iZzF2 += zzada.zzF(zzadvVar.zzf(i));
            i++;
        }
        return iZzF2;
    }

    static int zzt(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzadv)) {
            int iZzE = 0;
            while (i < size) {
                iZzE += zzada.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzE;
        }
        zzadv zzadvVar = (zzadv) list;
        int iZzE2 = 0;
        while (i < size) {
            iZzE2 += zzada.zzE(zzadvVar.zzf(i));
            i++;
        }
        return iZzE2;
    }

    static int zzu(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzadv)) {
            int iZzE = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzE += zzada.zzE((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzE;
        }
        zzadv zzadvVar = (zzadv) list;
        int iZzE2 = 0;
        while (i < size) {
            int iZzf = zzadvVar.zzf(i);
            iZzE2 += zzada.zzE((iZzf >> 31) ^ (iZzf + iZzf));
            i++;
        }
        return iZzE2;
    }

    static int zzv(List list) {
        return list.size() * 4;
    }

    static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzada.zzE(i << 3) + 4);
    }

    static int zzx(List list) {
        return list.size() * 8;
    }

    static int zzy(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzada.zzE(i << 3) + 8);
    }

    static int zzz(int i, Object obj, zzafp zzafpVar) {
        int iZzE;
        int iZzcf;
        int iZzE2;
        int i2 = i << 3;
        if (obj instanceof zzaem) {
            iZzE = zzada.zzE(i2);
            iZzcf = ((zzaem) obj).zzb();
            iZzE2 = zzada.zzE(iZzcf);
        } else {
            iZzE = zzada.zzE(i2);
            iZzcf = ((zzacb) obj).zzcf(zzafpVar);
            iZzE2 = zzada.zzE(iZzcf);
        }
        return iZzE + iZzE2 + iZzcf;
    }
}
