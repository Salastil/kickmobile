package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzamn<K, V> {
    static <K, V> int zza(zzamq<K, V> zzamqVar, K k, V v) {
        return zzalm.zza(zzamqVar.zza, 1, k) + zzalm.zza(zzamqVar.zzc, 2, v);
    }

    static <K, V> void zza(zzaky zzakyVar, zzamq<K, V> zzamqVar, K k, V v) throws IOException {
        zzalm.zza(zzakyVar, zzamqVar.zza, 1, k);
        zzalm.zza(zzakyVar, zzamqVar.zzc, 2, v);
    }
}
