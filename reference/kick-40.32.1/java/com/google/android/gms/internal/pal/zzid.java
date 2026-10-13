package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzid {
    public static final zzic zza;
    public static final zzic zzb;

    static {
        zzic.zza("gads:always_enable_crash_loop_counter_v3:enabled", false);
        zzic.zza("gads:crash_loop_stats_signal_v3:enabled", false);
        zzic.zza("gads:crash_without_flag_write_count_v3:enabled", false);
        zza = zzic.zzb("gads:crash_without_write_reset_v3:count", -1L);
        zzic.zza("gads:init_without_flag_write_count_v3:enabled", false);
        zzb = zzic.zzb("gads:init_without_write_reset_v3:count", -1L);
        zzic.zza("gads:reset_app_settings_v3:enabled", false);
        zzic.zza("gads:reset_counts_on_failure_service_v3:enabled", false);
        zzic.zza("gads:reset_counts_on_local_flag_save_v3:enabled", false);
        zzic.zza("gads:reset_counts_on_successful_service_v3:enabled", false);
    }
}
