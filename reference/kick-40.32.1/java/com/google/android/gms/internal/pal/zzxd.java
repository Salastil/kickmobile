package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxd {
    public static final zzxd zza = new zzxd("SHA1");
    public static final zzxd zzb = new zzxd("SHA224");
    public static final zzxd zzc = new zzxd("SHA256");
    public static final zzxd zzd = new zzxd("SHA384");
    public static final zzxd zze = new zzxd("SHA512");
    private final String zzf;

    private zzxd(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
