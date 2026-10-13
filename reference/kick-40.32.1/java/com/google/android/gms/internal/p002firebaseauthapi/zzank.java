package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzank {
    private static final zzank zza = new zzank();
    private final ConcurrentMap<Class<?>, zzanl<?>> zzc = new ConcurrentHashMap();
    private final zzaml zzb = new zzaml();

    static zzank zza() {
        return zza;
    }

    private final <T extends zzalt<?, ?>> zzanl<T> zzb(Class<T> cls) {
        zzanl<T> zzanlVarZza = this.zzb.zza(cls);
        zzalw.zza(zzanlVarZza, "schema");
        zzanl<T> zzanlVar = (zzanl) this.zzc.putIfAbsent(cls, zzanlVarZza);
        return zzanlVar != null ? zzanlVar : zzanlVarZza;
    }

    final <T extends zzalt<?, ?>> zzanl<T> zza(T t) {
        return zza(t.getClass());
    }

    final <T extends zzalt<?, ?>> zzanl<T> zza(Class<T> cls) {
        Object obj = this.zzc.get(cls);
        if (obj == null) {
            return zzb(cls);
        }
        return (zzanl) obj;
    }

    private zzank() {
    }
}
