package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzgh {
    private static final zzgh zzd = new zzgh(true);
    final zzii zza = new zzid();
    boolean zzb;
    boolean zzc;

    private zzgh() {
    }

    static int zza(zzjg zzjgVar, int i, Object obj) {
        int iZzy = zzfx.zzy(i << 3);
        if (zzjgVar == zzjg.GROUP) {
            iZzy += iZzy;
        }
        return iZzy + zzb(zzjgVar, obj);
    }

    static int zzb(zzjg zzjgVar, Object obj) {
        int iZzb;
        int iZzy;
        zzjg zzjgVar2 = zzjg.DOUBLE;
        zzjh zzjhVar = zzjh.INT;
        switch (zzjgVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                return 4;
            case INT64:
                return zzfx.zzz(((Long) obj).longValue());
            case UINT64:
                return zzfx.zzz(((Long) obj).longValue());
            case INT32:
                return zzfx.zzz(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                return 1;
            case STRING:
                if (!(obj instanceof zzfp)) {
                    int i = zzjc.zza;
                    iZzb = zziz.zzb((String) obj);
                    iZzy = zzfx.zzy(iZzb);
                } else {
                    iZzb = ((zzfp) obj).zzd();
                    iZzy = zzfx.zzy(iZzb);
                }
                break;
            case GROUP:
                return ((zzhr) obj).zzn();
            case MESSAGE:
                if (!(obj instanceof zzgz)) {
                    return zzfx.zzx((zzhr) obj);
                }
                iZzb = ((zzgz) obj).zza();
                iZzy = zzfx.zzy(iZzb);
                break;
                break;
            case BYTES:
                if (!(obj instanceof zzfp)) {
                    iZzb = ((byte[]) obj).length;
                    iZzy = zzfx.zzy(iZzb);
                } else {
                    iZzb = ((zzfp) obj).zzd();
                    iZzy = zzfx.zzy(iZzb);
                }
                break;
            case UINT32:
                return zzfx.zzy(((Integer) obj).intValue());
            case ENUM:
                return obj instanceof zzgr ? zzfx.zzz(((zzgr) obj).zza()) : zzfx.zzz(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                return 8;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                return zzfx.zzy((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                return zzfx.zzz((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzy + iZzb;
    }

    public static int zzc(zzgg zzggVar, Object obj) {
        zzjg zzjgVarZzb = zzggVar.zzb();
        int iZza = zzggVar.zza();
        if (!zzggVar.zze()) {
            return zza(zzjgVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzggVar.zzd()) {
            int iZza2 = 0;
            while (i < size) {
                iZza2 += zza(zzjgVarZzb, iZza, list.get(i));
                i++;
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzb = 0;
        while (i < size) {
            iZzb += zzb(zzjgVarZzb, list.get(i));
            i++;
        }
        return zzfx.zzy(iZza << 3) + iZzb + zzfx.zzy(iZzb);
    }

    public static zzgh zze() {
        return zzd;
    }

    static void zzi(zzfx zzfxVar, zzjg zzjgVar, int i, Object obj) throws IOException {
        if (zzjgVar == zzjg.GROUP) {
            zzfxVar.zzs(i, 3);
            ((zzhr) obj).zzD(zzfxVar);
            zzfxVar.zzs(i, 4);
            return;
        }
        zzfxVar.zzs(i, zzjgVar.zza());
        zzjh zzjhVar = zzjh.INT;
        switch (zzjgVar) {
            case DOUBLE:
                zzfxVar.zzk(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case FLOAT:
                zzfxVar.zzi(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case INT64:
                zzfxVar.zzw(((Long) obj).longValue());
                break;
            case UINT64:
                zzfxVar.zzw(((Long) obj).longValue());
                break;
            case INT32:
                zzfxVar.zzm(((Integer) obj).intValue());
                break;
            case FIXED64:
                zzfxVar.zzk(((Long) obj).longValue());
                break;
            case FIXED32:
                zzfxVar.zzi(((Integer) obj).intValue());
                break;
            case BOOL:
                zzfxVar.zzb(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case STRING:
                if (!(obj instanceof zzfp)) {
                    zzfxVar.zzr((String) obj);
                } else {
                    zzfxVar.zzg((zzfp) obj);
                }
                break;
            case GROUP:
                ((zzhr) obj).zzD(zzfxVar);
                break;
            case MESSAGE:
                zzfxVar.zzn((zzhr) obj);
                break;
            case BYTES:
                if (!(obj instanceof zzfp)) {
                    byte[] bArr = (byte[]) obj;
                    zzfxVar.zze(bArr, 0, bArr.length);
                } else {
                    zzfxVar.zzg((zzfp) obj);
                }
                break;
            case UINT32:
                zzfxVar.zzu(((Integer) obj).intValue());
                break;
            case ENUM:
                if (!(obj instanceof zzgr)) {
                    zzfxVar.zzm(((Integer) obj).intValue());
                } else {
                    zzfxVar.zzm(((zzgr) obj).zza());
                }
                break;
            case SFIXED32:
                zzfxVar.zzi(((Integer) obj).intValue());
                break;
            case SFIXED64:
                zzfxVar.zzk(((Long) obj).longValue());
                break;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                zzfxVar.zzu((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                zzfxVar.zzw((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    private static boolean zzk(Map.Entry entry) {
        zzgg zzggVar = (zzgg) entry.getKey();
        if (zzggVar.zzc() != zzjh.MESSAGE) {
            return true;
        }
        if (!zzggVar.zze()) {
            return zzl(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzl(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zzhs) {
            return ((zzhs) obj).zzo();
        }
        if (obj instanceof zzgz) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int iZzy;
        int iZzy2;
        zzgg zzggVar = (zzgg) entry.getKey();
        Object value = entry.getValue();
        if (zzggVar.zzc() != zzjh.MESSAGE || zzggVar.zze() || zzggVar.zzd()) {
            return zzc(zzggVar, value);
        }
        if (value instanceof zzgz) {
            int iZza = ((zzgg) entry.getKey()).zza();
            int iZzy3 = zzfx.zzy(8);
            i = iZzy3 + iZzy3;
            iZzy = zzfx.zzy(16) + zzfx.zzy(iZza);
            int iZzy4 = zzfx.zzy(24);
            int iZza2 = ((zzgz) value).zza();
            iZzy2 = iZzy4 + zzfx.zzy(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzgg) entry.getKey()).zza();
            int iZzy5 = zzfx.zzy(8);
            i = iZzy5 + iZzy5;
            iZzy = zzfx.zzy(16) + zzfx.zzy(iZza3);
            iZzy2 = zzfx.zzy(24) + zzfx.zzx((zzhr) value);
        }
        return i + iZzy + iZzy2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzn(zzgg zzggVar, Object obj) {
        boolean z;
        zzggVar.zzb();
        obj.getClass();
        zzjg zzjgVar = zzjg.DOUBLE;
        zzjh zzjhVar = zzjh.INT;
        switch (r0.zzb()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzfp) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzgr)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzhr) || (obj instanceof zzgz)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzggVar.zza()), zzggVar.zzb().zzb(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgh zzghVar = new zzgh();
        zzii zziiVar = this.zza;
        int iZzc = zziiVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = zziiVar.zzg(i);
            zzghVar.zzh(((zzie) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : zziiVar.zzd()) {
            zzghVar.zzh((zzgg) entry.getKey(), entry.getValue());
        }
        zzghVar.zzc = this.zzc;
        return zzghVar;
    }

    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgh)) {
            return false;
        }
        zzii zziiVar = this.zza;
        zzii zziiVar2 = ((zzgh) obj).zza;
        if (zziiVar.size() != zziiVar2.size() || !zziiVar.keySet().equals(zziiVar2.keySet())) {
            return false;
        }
        for (Map.Entry entry : zziiVar.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            Object obj2 = zziiVar2.get(key);
            if (value == obj2) {
                zEquals = true;
            } else if (value == null || obj2 == null) {
                zEquals = false;
            } else if (value instanceof zzgz) {
                zEquals = value.equals(obj2);
            } else {
                zEquals = obj2 instanceof zzgz ? obj2.equals(value) : value.equals(obj2);
            }
            if (!zEquals) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzii zziiVar = this.zza;
        int iZzc = zziiVar.zzc();
        int iZzm = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzm += zzm(zziiVar.zzg(i));
        }
        Iterator it = zziiVar.zzd().iterator();
        while (it.hasNext()) {
            iZzm += zzm((Map.Entry) it.next());
        }
        return iZzm;
    }

    public final Iterator zzf() {
        zzii zziiVar = this.zza;
        if (zziiVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzc ? new zzgx(zziiVar.entrySet().iterator()) : zziiVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzb) {
            return;
        }
        zzii zziiVar = this.zza;
        int iZzc = zziiVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zziiVar.zzg(i).getValue();
            if (value instanceof zzgp) {
                ((zzgp) value).zzz();
            }
        }
        Iterator it = zziiVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzgp) {
                ((zzgp) value2).zzz();
            }
        }
        zziiVar.zza();
        this.zzb = true;
    }

    public final void zzh(zzgg zzggVar, Object obj) {
        if (!zzggVar.zze()) {
            zzn(zzggVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzggVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzgz) {
            this.zzc = true;
        }
        this.zza.put(zzggVar, obj);
    }

    public final boolean zzj() {
        zzii zziiVar = this.zza;
        int iZzc = zziiVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzk(zziiVar.zzg(i))) {
                return false;
            }
        }
        Iterator it = zziiVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzk((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzgh(boolean z) {
        zzg();
        zzg();
    }
}
