package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzalm<T extends zzalo<T>> {
    private static final zzalm<?> zzc = new zzalm<>(true);
    final zzann<T, Object> zza;
    boolean zzb;
    private boolean zzd;

    static int zza(zzaoj zzaojVar, int i, Object obj) {
        int iZzd = zzaky.zzd(i << 3);
        if (zzaojVar == zzaoj.zzj) {
            iZzd <<= 1;
        }
        return iZzd + zza(zzaojVar, obj);
    }

    private static int zza(zzaoj zzaojVar, Object obj) {
        int iZza;
        int iZzd;
        switch (zzall.zzb[zzaojVar.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                return 8;
            case 2:
                ((Float) obj).floatValue();
                return 4;
            case 3:
                return zzaky.zzc(((Long) obj).longValue());
            case 4:
                return zzaky.zzc(((Long) obj).longValue());
            case 5:
                return zzaky.zzc(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                return 8;
            case 7:
                ((Integer) obj).intValue();
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                return 1;
            case 9:
                return ((zzamv) obj).zzl();
            case 10:
                if (obj instanceof zzama) {
                    iZza = ((zzama) obj).zza();
                    iZzd = zzaky.zzd(iZza);
                } else {
                    return zzaky.zzb((zzamv) obj);
                }
                break;
            case 11:
                if (obj instanceof zzakb) {
                    return zzaky.zzb((zzakb) obj);
                }
                return zzaky.zzb((String) obj);
            case 12:
                if (obj instanceof zzakb) {
                    return zzaky.zzb((zzakb) obj);
                }
                iZza = ((byte[]) obj).length;
                iZzd = zzaky.zzd(iZza);
                break;
                break;
            case 13:
                return zzaky.zzd(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                return 4;
            case 15:
                ((Long) obj).longValue();
                return 8;
            case 16:
                return zzaky.zzd(zzaky.zze(((Integer) obj).intValue()));
            case 17:
                return zzaky.zzc(zzaky.zzd(((Long) obj).longValue()));
            case 18:
                if (obj instanceof zzalv) {
                    return zzaky.zzc(((zzalv) obj).zza());
                }
                return zzaky.zzc(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzd + iZza;
    }

    public static int zza(zzalo<?> zzaloVar, Object obj) {
        zzaoj zzaojVarZzb = zzaloVar.zzb();
        int iZza = zzaloVar.zza();
        if (zzaloVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzaloVar.zzd()) {
                int iZza2 = 0;
                while (i < size) {
                    iZza2 += zza(zzaojVarZzb, iZza, list.get(i));
                    i++;
                }
                return iZza2;
            }
            if (list.isEmpty()) {
                return 0;
            }
            int iZza3 = 0;
            while (i < size) {
                iZza3 += zza(zzaojVarZzb, list.get(i));
                i++;
            }
            return zzaky.zzd(iZza << 3) + iZza3 + zzaky.zzd(iZza3);
        }
        return zza(zzaojVarZzb, iZza, obj);
    }

    public final int zza() {
        zzann<T, Object> zzannVar;
        int iZza = this.zza.zza();
        int i = 0;
        int iZza2 = 0;
        while (true) {
            zzannVar = this.zza;
            if (i >= iZza) {
                break;
            }
            iZza2 += zza((Map.Entry) zzannVar.zza(i));
            i++;
        }
        Iterator it = zzannVar.zzb().iterator();
        while (it.hasNext()) {
            iZza2 += zza((Map.Entry) it.next());
        }
        return iZza2;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        int iZzd;
        int iZzd2;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzaoq.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzama) {
                iZzd = (zzaky.zzd(8) << 1) + zzaky.zzh(2, entry.getKey().zza());
                int iZzd3 = zzaky.zzd(24);
                int iZza = ((zzama) value).zza();
                iZzd2 = iZzd3 + zzaky.zzd(iZza) + iZza;
            } else {
                iZzd = (zzaky.zzd(8) << 1) + zzaky.zzh(2, entry.getKey().zza());
                iZzd2 = zzaky.zzd(24) + zzaky.zzb((zzamv) value);
            }
            return iZzd + iZzd2;
        }
        return zza((zzalo<?>) key, value);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static <T extends zzalo<T>> zzalm<T> zzb() {
        return (zzalm<T>) zzc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzann<T, Object> zzannVar;
        zzalm zzalmVar = new zzalm();
        int iZza = this.zza.zza();
        int i = 0;
        while (true) {
            zzannVar = this.zza;
            if (i >= iZza) {
                break;
            }
            Map.Entry<K, Object> entryZza = zzannVar.zza(i);
            zzalmVar.zzb((zzalo) entryZza.getKey(), entryZza.getValue());
            i++;
        }
        Iterator it = zzannVar.zzb().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzalmVar.zzb((zzalo) entry.getKey(), entry.getValue());
        }
        zzalmVar.zzd = this.zzd;
        return zzalmVar;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzane) {
            return ((zzane) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        return obj instanceof zzama ? ((zzama) obj).zzc() : obj;
    }

    public final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzamc(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    private zzalm() {
        this.zza = new zzanq();
    }

    private zzalm(zzann<T, Object> zzannVar) {
        this.zza = zzannVar;
        zzd();
    }

    private zzalm(boolean z) {
        this(new zzanq());
        zzd();
    }

    public final void zzd() {
        zzann<T, Object> zzannVar;
        if (this.zzb) {
            return;
        }
        int iZza = this.zza.zza();
        int i = 0;
        while (true) {
            zzannVar = this.zza;
            if (i >= iZza) {
                break;
            }
            Object value = zzannVar.zza(i).getValue();
            if (value instanceof zzalt) {
                ((zzalt) value).zzs();
            }
            i++;
        }
        Iterator it = zzannVar.zzb().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzalt) {
                ((zzalt) value2).zzs();
            }
        }
        this.zza.zzc();
        this.zzb = true;
    }

    public final void zza(zzalm<T> zzalmVar) {
        int iZza = zzalmVar.zza.zza();
        for (int i = 0; i < iZza; i++) {
            zzb((Map.Entry) zzalmVar.zza.zza(i));
        }
        Iterator it = zzalmVar.zza.zzb().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzama;
        if (key.zze()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objZza = zza((zzalo) key);
            List list = (List) value;
            int size = list.size();
            if (objZza == null) {
                objZza = new ArrayList(size);
            }
            List list2 = (List) objZza;
            for (int i = 0; i < size; i++) {
                list2.add(zza(list.get(i)));
            }
            this.zza.put(key, objZza);
            return;
        }
        if (key.zzc() != zzaoq.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(key, zza(value));
            return;
        }
        Object objZza2 = zza((zzalo) key);
        if (objZza2 == null) {
            this.zza.put(key, zza(value));
            if (z) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z) {
            value = ((zzama) value).zzc();
        }
        if (key.zza(objZza2)) {
            zzamy zzamyVarZzr = ((zzamv) objZza2).zzr();
            key.zza(zzamyVarZzr, value);
            this.zza.put(key, zzamyVarZzr.zze());
            return;
        }
        key.zza(objZza2, value);
    }

    private final void zzb(T t, Object obj) {
        if (t.zze()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzc(t, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzc(t, obj);
        }
        if (obj instanceof zzama) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    private static void zzc(T t, Object obj) {
        zzaoj zzaojVarZzb = t.zzb();
        zzalw.zza(obj);
        boolean z = true;
        switch (zzall.zza[zzaojVarZzb.zzb().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzakb) && !(obj instanceof byte[])) {
                    z = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzalv)) {
                    z = false;
                }
                break;
            case 9:
                if (!(obj instanceof zzamv) && !(obj instanceof zzama)) {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
        }
    }

    static void zza(zzaky zzakyVar, zzaoj zzaojVar, int i, Object obj) throws IOException {
        if (zzaojVar == zzaoj.zzj) {
            zzakyVar.zzc(i, 3);
            ((zzamv) obj).zza(zzakyVar);
            zzakyVar.zzc(i, 4);
        }
        zzakyVar.zzc(i, zzaojVar.zza());
        switch (zzall.zzb[zzaojVar.ordinal()]) {
            case 1:
                zzakyVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzakyVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzakyVar.zzb(((Long) obj).longValue());
                break;
            case 4:
                zzakyVar.zzb(((Long) obj).longValue());
                break;
            case 5:
                zzakyVar.zzb(((Integer) obj).intValue());
                break;
            case 6:
                zzakyVar.zza(((Long) obj).longValue());
                break;
            case 7:
                zzakyVar.zza(((Integer) obj).intValue());
                break;
            case 8:
                zzakyVar.zza(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzamv) obj).zza(zzakyVar);
                break;
            case 10:
                zzakyVar.zza((zzamv) obj);
                break;
            case 11:
                if (obj instanceof zzakb) {
                    zzakyVar.zza((zzakb) obj);
                } else {
                    zzakyVar.zza((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzakb) {
                    zzakyVar.zza((zzakb) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzakyVar.zzb(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzakyVar.zzc(((Integer) obj).intValue());
                break;
            case 14:
                zzakyVar.zza(((Integer) obj).intValue());
                break;
            case 15:
                zzakyVar.zza(((Long) obj).longValue());
                break;
            case 16:
                zzakyVar.zzf(((Integer) obj).intValue());
                break;
            case 17:
                zzakyVar.zze(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzalv) {
                    zzakyVar.zzb(((zzalv) obj).zza());
                } else {
                    zzakyVar.zzb(((Integer) obj).intValue());
                }
                break;
        }
    }

    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzalm)) {
            return false;
        }
        zzann<T, Object> zzannVar = this.zza;
        zzann<T, Object> zzannVar2 = ((zzalm) obj).zza;
        if (zzannVar.size() != zzannVar2.size() || !zzannVar.keySet().equals(zzannVar2.keySet())) {
            return false;
        }
        Iterator it = zzannVar.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Object obj2 = zzannVar2.get(key);
            if (value == obj2) {
                zEquals = true;
            } else if (value == null || obj2 == null) {
                zEquals = false;
            } else if (!(value instanceof zzama) && (obj2 instanceof zzama)) {
                zEquals = obj2.equals(value);
            } else {
                zEquals = value.equals(obj2);
            }
            if (!zEquals) {
                return false;
            }
        }
        return true;
    }

    public final boolean zze() {
        int iZza = this.zza.zza();
        int i = 0;
        while (true) {
            zzann<T, Object> zzannVar = this.zza;
            if (i < iZza) {
                if (!zzc(zzannVar.zza(i))) {
                    return false;
                }
                i++;
            } else {
                Iterator it = zzannVar.zzb().iterator();
                while (it.hasNext()) {
                    if (!zzc((Map.Entry) it.next())) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    private static <T extends zzalo<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() != zzaoq.MESSAGE) {
            return true;
        }
        if (key.zze()) {
            List list = (List) entry.getValue();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!zzb(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return zzb(entry.getValue());
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzamx) {
            return ((zzamx) obj).zzj();
        }
        if (obj instanceof zzama) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
