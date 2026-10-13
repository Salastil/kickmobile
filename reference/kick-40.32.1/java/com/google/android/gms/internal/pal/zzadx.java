package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzadx {
    public static final zzadx zza = new zzadx("SHA1");
    public static final zzadx zzb = new zzadx("SHA224");
    public static final zzadx zzc = new zzadx("SHA256");
    public static final zzadx zzd = new zzadx("SHA384");
    public static final zzadx zze = new zzadx("SHA512");
    private final String zzf;

    private zzadx(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
