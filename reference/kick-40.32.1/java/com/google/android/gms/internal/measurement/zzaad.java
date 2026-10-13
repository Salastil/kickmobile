package com.google.android.gms.internal.measurement;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzaad {
    private static String zza = "com.google.android.gms.internal.measurement.zzaaj";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.gms.internal.measurement.zzaaj", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzabt.zza();
    }

    public static zzaac zzb() {
        return zzaab.zza.zzc();
    }

    public static zzzf zzd(String str) {
        return zzaab.zza.zze(str);
    }

    public static zzaat zzf() {
        return zzaab.zza.zzg();
    }

    public static boolean zzh(String str, Level level, boolean z) {
        zzf().zzb(str, level, z);
        return false;
    }

    public static zzabe zzi() {
        return zzf().zzc();
    }

    public static zzzj zzj() {
        return zzf().zzd();
    }

    public static long zzk() {
        return zzaab.zza.zzl();
    }

    public static String zzm() {
        return zzaab.zza.zzn();
    }

    protected abstract zzaac zzc();

    protected abstract zzzf zze(String str);

    protected zzaat zzg() {
        return zzaat.zze();
    }

    protected long zzl() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    protected abstract String zzn();
}
