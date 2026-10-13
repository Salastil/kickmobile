package com.google.android.gms.internal.pal;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzrr {
    private static String zza = "com.google.android.gms.internal.pal.zzrx";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.gms.internal.pal.zzrx", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzth.zza();
    }

    public static zzrq zzb() {
        return zzrp.zza.zzc();
    }

    public static zzqt zzd(String str) {
        return zzrp.zza.zze(str);
    }

    public static zzsh zzf() {
        return zzrp.zza.zzg();
    }

    public static boolean zzh(String str, Level level, boolean z) {
        zzf().zzb(str, level, z);
        return false;
    }

    public static zzss zzi() {
        return zzf().zzc();
    }

    public static zzqx zzj() {
        return zzf().zzd();
    }

    public static long zzk() {
        return zzrp.zza.zzl();
    }

    public static String zzm() {
        return zzrp.zza.zzn();
    }

    protected abstract zzrq zzc();

    protected abstract zzqt zze(String str);

    protected zzsh zzg() {
        return zzsh.zze();
    }

    protected long zzl() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    protected abstract String zzn();
}
