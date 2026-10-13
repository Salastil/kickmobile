package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzakk {
    public static final zzakk zza = new zzakk("SHA1");
    public static final zzakk zzb = new zzakk("SHA224");
    public static final zzakk zzc = new zzakk("SHA256");
    public static final zzakk zzd = new zzakk("SHA384");
    public static final zzakk zze = new zzakk("SHA512");
    private final String zzf;

    private zzakk(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
