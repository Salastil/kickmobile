package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzhy {
    private static final zzhy zza = new zzhy();
    private final ConcurrentMap zzb = new ConcurrentHashMap();

    private zzhy() {
        zzgk.zza();
    }

    static zzhy zza() {
        return zza;
    }

    private <T> zzib<T> zzc(Class<T> cls) {
        Class<T> cls2;
        zzib<T> zzibVarZzl;
        int i = zzic.zza;
        if (!zzgp.class.isAssignableFrom(cls)) {
            int i2 = zzfc.zza;
        }
        int i3 = zzfc.zza;
        if (!zzgp.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            zzhp zzhpVar = (zzhp) zzgp.zzr(cls.asSubclass(zzgp.class)).zzd(3, null, null);
            if (zzhpVar.zzb()) {
                zzibVarZzl = zzhv.zzc(zzic.zzm(), zzgf.zza(), zzhpVar.zza());
                cls2 = cls;
            } else {
                cls2 = cls;
                zzibVarZzl = zzhu.zzl(cls2, zzhpVar, zzhx.zza(), zzhf.zza(), zzic.zzm(), zzhpVar.zzc() + (-1) != 1 ? zzgf.zza() : null, zzho.zza());
            }
            zzib<T> zzibVar = (zzib) this.zzb.putIfAbsent(cls2, zzibVarZzl);
            return zzibVar != null ? zzibVar : zzibVarZzl;
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    final zzib zzb(Class cls) {
        Object obj = this.zzb.get(cls);
        return obj == null ? zzc(cls) : (zzib) obj;
    }
}
