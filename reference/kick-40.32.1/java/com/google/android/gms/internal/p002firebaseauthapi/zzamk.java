package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzamk implements zzamh {
    private static <E> zzalx<E> zzc(Object obj, long j) {
        return (zzalx) zzaoc.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamh
    public final <L> List<L> zza(Object obj, long j) {
        zzalx zzalxVarZzc = zzc(obj, j);
        if (zzalxVarZzc.zzc()) {
            return zzalxVarZzc;
        }
        int size = zzalxVarZzc.size();
        zzalx zzalxVarZza = zzalxVarZzc.zza(size == 0 ? 10 : size << 1);
        zzaoc.zza(obj, j, zzalxVarZza);
        return zzalxVarZza;
    }

    zzamk() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamh
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamh
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzalx zzalxVarZzc = zzc(obj, j);
        zzalx zzalxVarZzc2 = zzc(obj2, j);
        int size = zzalxVarZzc.size();
        int size2 = zzalxVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzalxVarZzc.zzc()) {
                zzalxVarZzc = zzalxVarZzc.zza(size2 + size);
            }
            zzalxVarZzc.addAll(zzalxVarZzc2);
        }
        if (size > 0) {
            zzalxVarZzc2 = zzalxVarZzc;
        }
        zzaoc.zza(obj, j, zzalxVarZzc2);
    }
}
