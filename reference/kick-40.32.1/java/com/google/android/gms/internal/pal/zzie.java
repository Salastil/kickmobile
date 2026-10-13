package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzie {
    public static final zzic zza;
    public static final zzic zzb;
    public static final zzic zzc;
    public static final zzic zzd;
    public static final zzic zze;

    static {
        zzic.zza("gads:flags_check_if_updating_v3:enabled", false);
        zza = zzic.zza("gads:disable_adapter_flag_shared_pref_listener_v3:enabled", false);
        zzb = zzic.zza("gads:disable_flag_shared_pref_listener_v3:enabled", false);
        zzic.zza("gads:disable_sdkcore_refresh_client:enabled", false);
        zzc = zzic.zza("gads:enable_adapter_flags:enabled", false);
        zzic.zza("gads:include_package_name_v3:enabled", false);
        zzic.zza("gads:js_flags:mf", false);
        zzic.zzb("gads:js_flags:update_interval", 14400000L);
        zzic.zza("gads:persist_js_flag:ars", true);
        zzic.zza("gads:persist_js_flag:as", true);
        zzic.zza("gads:persist_js_flag:scar", true);
        zzd = zzic.zza("gads:read_local_flags_v3:enabled", false);
        zze = zzic.zza("gads:read_local_flags_cld_v3:enabled", false);
        zzic.zza("gads:save_flags_on_background_thread:enabled", false);
        zzic.zza("gads:write_local_flags_cld_v3:enabled", false);
        zzic.zza("gads:write_local_flags_client_v3:enabled", false);
        zzic.zza("gads:write_local_flags_service_v3:enabled", false);
    }
}
