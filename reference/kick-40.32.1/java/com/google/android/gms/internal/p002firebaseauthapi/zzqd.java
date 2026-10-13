package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqd {
    private final Map<zzqg, zzpx<?, ?>> zza;
    private final Map<Class<?>, zzqi<?, ?>> zzb;

    public final <KeyT extends zzbt, PrimitiveT> zzqd zza(zzpx<KeyT, PrimitiveT> zzpxVar) throws GeneralSecurityException {
        if (zzpxVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzqg zzqgVar = new zzqg(zzpxVar.zza(), zzpxVar.zzb());
        boolean zContainsKey = this.zza.containsKey(zzqgVar);
        Map<zzqg, zzpx<?, ?>> map = this.zza;
        if (!zContainsKey) {
            map.put(zzqgVar, zzpxVar);
            return this;
        }
        zzpx<?, ?> zzpxVar2 = map.get(zzqgVar);
        if (zzpxVar2.equals(zzpxVar) && zzpxVar.equals(zzpxVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + String.valueOf(zzqgVar));
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> zzqd zza(zzqi<InputPrimitiveT, WrapperPrimitiveT> zzqiVar) throws GeneralSecurityException {
        if (zzqiVar == null) {
            throw new NullPointerException("wrapper must be non-null");
        }
        Class<WrapperPrimitiveT> clsZzb = zzqiVar.zzb();
        boolean zContainsKey = this.zzb.containsKey(clsZzb);
        Map<Class<?>, zzqi<?, ?>> map = this.zzb;
        if (zContainsKey) {
            zzqi<?, ?> zzqiVar2 = map.get(clsZzb);
            if (zzqiVar2.equals(zzqiVar) && zzqiVar.equals(zzqiVar2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + String.valueOf(clsZzb));
        }
        map.put(clsZzb, zzqiVar);
        return this;
    }

    public final zzqb zza() {
        return new zzqb(this);
    }

    private zzqd() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    private zzqd(zzqb zzqbVar) {
        this.zza = new HashMap(zzqbVar.zza);
        this.zzb = new HashMap(zzqbVar.zzb);
    }
}
