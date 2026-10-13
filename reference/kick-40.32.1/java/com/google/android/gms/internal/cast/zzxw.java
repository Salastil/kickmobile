package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzxw {
    private static final zzxw zzd = new zzxw(true);
    final zzzz zza = new zzzv();
    boolean zzb;
    boolean zzc;

    private zzxw() {
    }

    public static zzxw zza() {
        return zzd;
    }

    public static int zzg(zzxv zzxvVar, Object obj) {
        zzxvVar.zzb();
        int iZza = zzxvVar.zza();
        if (!zzxvVar.zzd()) {
            zzxp.zzw(iZza << 3);
            zzaan zzaanVar = zzaan.DOUBLE;
            zzaao zzaaoVar = zzaao.INT;
            throw null;
        }
        List list = (List) obj;
        int size = list.size();
        if (zzxvVar.zze()) {
            if (!list.isEmpty()) {
                if (size <= 0) {
                    return zzxp.zzw(iZza << 3) + zzxp.zzw(0);
                }
                list.get(0);
                zzaan zzaanVar2 = zzaan.DOUBLE;
                zzaao zzaaoVar2 = zzaao.INT;
                throw null;
            }
        } else if (size > 0) {
            list.get(0);
            zzxp.zzw(iZza << 3);
            zzaan zzaanVar3 = zzaan.DOUBLE;
            zzaao zzaaoVar3 = zzaao.INT;
            throw null;
        }
        return 0;
    }

    private static boolean zzh(Map.Entry entry) {
        zzxv zzxvVar = (zzxv) entry.getKey();
        if (zzxvVar.zzc() != zzaao.MESSAGE) {
            return true;
        }
        if (!zzxvVar.zzd()) {
            return zzi(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzi(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzi(Object obj) {
        if (obj instanceof zzzj) {
            return ((zzzj) obj).zzr();
        }
        if (obj instanceof zzys) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzj(Map.Entry entry) {
        int i;
        int iZzw;
        int iZzw2;
        int iZzE;
        int iZzw3;
        zzxv zzxvVar = (zzxv) entry.getKey();
        Object value = entry.getValue();
        if (zzxvVar.zzc() != zzaao.MESSAGE || zzxvVar.zzd() || zzxvVar.zze()) {
            return zzg(zzxvVar, value);
        }
        if (value instanceof zzys) {
            int iZza = ((zzxv) entry.getKey()).zza();
            int iZzw4 = zzxp.zzw(8);
            i = iZzw4 + iZzw4;
            iZzw = zzxp.zzw(16) + zzxp.zzw(iZza);
            iZzw2 = zzxp.zzw(24);
            iZzE = ((zzys) value).zzb();
            iZzw3 = zzxp.zzw(iZzE);
        } else {
            int iZza2 = ((zzxv) entry.getKey()).zza();
            int iZzw5 = zzxp.zzw(8);
            i = iZzw5 + iZzw5;
            iZzw = zzxp.zzw(16) + zzxp.zzw(iZza2);
            iZzw2 = zzxp.zzw(24);
            iZzE = ((zzzi) value).zzE();
            iZzw3 = zzxp.zzw(iZzE);
        }
        return i + iZzw + iZzw2 + iZzw3 + iZzE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzk(zzxv zzxvVar, Object obj) {
        boolean z;
        zzxvVar.zzb();
        byte[] bArr = zzym.zzb;
        obj.getClass();
        zzaan zzaanVar = zzaan.DOUBLE;
        zzaao zzaaoVar = zzaao.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzxk) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzpm)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzzi) || (obj instanceof zzys)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzxvVar.zza()), zzxvVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzxw zzxwVar = new zzxw();
        zzzz zzzzVar = this.zza;
        int iZzc = zzzzVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzd = zzzzVar.zzd(i);
            zzxwVar.zzd((zzxv) ((zzzw) entryZzd).zza(), entryZzd.getValue());
        }
        for (Map.Entry entry : zzzzVar.zze()) {
            zzxwVar.zzd((zzxv) entry.getKey(), entry.getValue());
        }
        zzxwVar.zzc = this.zzc;
        return zzxwVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzxw) {
            return this.zza.equals(((zzxw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzzz zzzzVar = this.zza;
        int iZzc = zzzzVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzzzVar.zzd(i).getValue();
            if (value instanceof zzyd) {
                ((zzyd) value).zzA();
            }
        }
        Iterator it = zzzzVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzyd) {
                ((zzyd) value2).zzA();
            }
        }
        zzzzVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzzz zzzzVar = this.zza;
        if (zzzzVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzc ? new zzyr(zzzzVar.entrySet().iterator()) : zzzzVar.entrySet().iterator();
    }

    public final void zzd(zzxv zzxvVar, Object obj) {
        if (!zzxvVar.zzd()) {
            zzk(zzxvVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzk(zzxvVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzys) {
            this.zzc = true;
        }
        this.zza.put(zzxvVar, obj);
    }

    public final boolean zze() {
        zzzz zzzzVar = this.zza;
        int iZzc = zzzzVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzh(zzzzVar.zzd(i))) {
                return false;
            }
        }
        Iterator it = zzzzVar.zze().iterator();
        while (it.hasNext()) {
            if (!zzh((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzf() {
        zzzz zzzzVar = this.zza;
        int iZzc = zzzzVar.zzc();
        int iZzj = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzj += zzj(zzzzVar.zzd(i));
        }
        Iterator it = zzzzVar.zze().iterator();
        while (it.hasNext()) {
            iZzj += zzj((Map.Entry) it.next());
        }
        return iZzj;
    }

    private zzxw(boolean z) {
        zzb();
        zzb();
    }
}
