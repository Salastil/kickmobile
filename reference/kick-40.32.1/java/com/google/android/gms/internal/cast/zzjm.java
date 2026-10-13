package com.google.android.gms.internal.cast;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzjm {
    private static String zza = "com.google.android.gms.internal.cast.zzjq";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.gms.internal.cast.zzjq", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzko.zza();
    }

    public static zzjl zzb() {
        return zzjk.zza.zzc();
    }

    public static zzix zzd(String str) {
        return zzjk.zza.zze(str);
    }

    public static zzjz zzf() {
        return zzjk.zza.zzg();
    }

    public static boolean zzh(String str, Level level, boolean z) {
        zzf().zzb(str, level, z);
        return false;
    }

    public static zzkk zzi() {
        return zzf().zzc();
    }

    public static zziz zzj() {
        return zzf().zzd();
    }

    public static long zzk() {
        return zzjk.zza.zzl();
    }

    public static String zzm() {
        return zzjk.zza.zzn();
    }

    protected abstract zzjl zzc();

    protected abstract zzix zze(String str);

    protected zzjz zzg() {
        return zzjz.zze();
    }

    protected long zzl() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    protected abstract String zzn();
}
