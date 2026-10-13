package com.google.android.gms.internal.pal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaud {
    private static final zzaud zzd = new zzaud(true);
    final zzawu zza = new zzawq();
    boolean zzb;
    boolean zzc;

    private zzaud() {
    }

    public static zzaud zza() {
        return zzd;
    }

    public static int zzg(zzauc zzaucVar, Object obj) {
        zzaucVar.zzb();
        int iZza = zzaucVar.zza();
        if (!zzaucVar.zzd()) {
            zzatt.zzu(iZza << 3);
            zzaxn zzaxnVar = zzaxn.DOUBLE;
            zzaxo zzaxoVar = zzaxo.INT;
            throw null;
        }
        List list = (List) obj;
        int size = list.size();
        if (zzaucVar.zze()) {
            if (!list.isEmpty()) {
                if (size <= 0) {
                    return zzatt.zzu(iZza << 3) + zzatt.zzu(0);
                }
                list.get(0);
                zzaxn zzaxnVar2 = zzaxn.DOUBLE;
                zzaxo zzaxoVar2 = zzaxo.INT;
                throw null;
            }
        } else if (size > 0) {
            list.get(0);
            zzatt.zzu(iZza << 3);
            zzaxn zzaxnVar3 = zzaxn.DOUBLE;
            zzaxo zzaxoVar3 = zzaxo.INT;
            throw null;
        }
        return 0;
    }

    private static boolean zzh(Map.Entry entry) {
        zzauc zzaucVar = (zzauc) entry.getKey();
        if (zzaucVar.zzc() != zzaxo.MESSAGE) {
            return true;
        }
        if (!zzaucVar.zzd()) {
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
        if (obj instanceof zzavx) {
            return ((zzavx) obj).zzaR();
        }
        if (obj instanceof zzavg) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzj(Map.Entry entry) {
        int i;
        int iZzu;
        int iZzu2;
        int iZzaB;
        int iZzu3;
        zzauc zzaucVar = (zzauc) entry.getKey();
        Object value = entry.getValue();
        if (zzaucVar.zzc() != zzaxo.MESSAGE || zzaucVar.zzd() || zzaucVar.zze()) {
            return zzg(zzaucVar, value);
        }
        if (value instanceof zzavg) {
            int iZza = ((zzauc) entry.getKey()).zza();
            int iZzu4 = zzatt.zzu(8);
            i = iZzu4 + iZzu4;
            iZzu = zzatt.zzu(16) + zzatt.zzu(iZza);
            iZzu2 = zzatt.zzu(24);
            iZzaB = ((zzavg) value).zzb();
            iZzu3 = zzatt.zzu(iZzaB);
        } else {
            int iZza2 = ((zzauc) entry.getKey()).zza();
            int iZzu5 = zzatt.zzu(8);
            i = iZzu5 + iZzu5;
            iZzu = zzatt.zzu(16) + zzatt.zzu(iZza2);
            iZzu2 = zzatt.zzu(24);
            iZzaB = ((zzavw) value).zzaB();
            iZzu3 = zzatt.zzu(iZzaB);
        }
        return i + iZzu + iZzu2 + iZzu3 + iZzaB;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzk(zzauc zzaucVar, Object obj) {
        boolean z;
        zzaucVar.zzb();
        byte[] bArr = zzauz.zzb;
        obj.getClass();
        zzaxn zzaxnVar = zzaxn.DOUBLE;
        zzaxo zzaxoVar = zzaxo.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzatl) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzaur)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzavw) || (obj instanceof zzavg)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzaucVar.zza()), zzaucVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzaud zzaudVar = new zzaud();
        zzawu zzawuVar = this.zza;
        int iZzc = zzawuVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzd = zzawuVar.zzd(i);
            zzaudVar.zzd((zzauc) ((zzawr) entryZzd).zza(), entryZzd.getValue());
        }
        for (Map.Entry entry : zzawuVar.zze()) {
            zzaudVar.zzd((zzauc) entry.getKey(), entry.getValue());
        }
        zzaudVar.zzc = this.zzc;
        return zzaudVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzaud) {
            return this.zza.equals(((zzaud) obj).zza);
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
        zzawu zzawuVar = this.zza;
        int iZzc = zzawuVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzawuVar.zzd(i).getValue();
            if (value instanceof zzaun) {
                ((zzaun) value).zzax();
            }
        }
        Iterator it = zzawuVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzaun) {
                ((zzaun) value2).zzax();
            }
        }
        zzawuVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzawu zzawuVar = this.zza;
        if (zzawuVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzc ? new zzavf(zzawuVar.entrySet().iterator()) : zzawuVar.entrySet().iterator();
    }

    public final void zzd(zzauc zzaucVar, Object obj) {
        if (!zzaucVar.zzd()) {
            zzk(zzaucVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzk(zzaucVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzavg) {
            this.zzc = true;
        }
        this.zza.put(zzaucVar, obj);
    }

    public final boolean zze() {
        zzawu zzawuVar = this.zza;
        int iZzc = zzawuVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzh(zzawuVar.zzd(i))) {
                return false;
            }
        }
        Iterator it = zzawuVar.zze().iterator();
        while (it.hasNext()) {
            if (!zzh((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzf() {
        zzawu zzawuVar = this.zza;
        int iZzc = zzawuVar.zzc();
        int iZzj = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzj += zzj(zzawuVar.zzd(i));
        }
        Iterator it = zzawuVar.zze().iterator();
        while (it.hasNext()) {
            iZzj += zzj((Map.Entry) it.next());
        }
        return iZzj;
    }

    private zzaud(boolean z) {
        zzb();
        zzb();
    }
}
