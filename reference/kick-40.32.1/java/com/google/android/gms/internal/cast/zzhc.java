package com.google.android.gms.internal.cast;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzhc implements Serializable {
    zzhc() {
    }

    public static zzhc zzb() {
        return zzha.zza;
    }

    public static zzhc zzc(Object obj) {
        return obj == null ? zzha.zza : new zzhe(obj);
    }

    public abstract Object zza(Object obj);
}
