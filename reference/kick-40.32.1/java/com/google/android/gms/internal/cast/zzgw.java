package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzgw {
    private static final ThreadLocal zza = new zzgq();

    public static zzgw zzb() {
        return (zzgw) zza.get();
    }

    public abstract void zza(zzgt zzgtVar);
}
