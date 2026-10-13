package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzhr {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    /* synthetic */ zzhr(int i, String str, Object obj, Object obj2, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        zzhi.zzb().zza(this);
    }

    public static zzhr zzf(int i, String str, int i2, int i3) {
        return new zzhn(1, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static zzhr zzg(int i, String str, long j, long j2) {
        return new zzho(1, str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static zzhr zzh(int i, String str, float f, float f2) {
        return new zzhp(1, str, Float.valueOf(f), Float.valueOf(f2));
    }

    public static zzhr zzi(int i, String str) {
        zzhq zzhqVar = new zzhq(1, "gads:sdk_core_constants:experiment_id", null, null);
        zzhi.zzb().zzb(zzhqVar);
        return zzhqVar;
    }

    public static zzhr zzj(int i, String str) {
        zzhq zzhqVar = new zzhq(1, "gads:sdk_core_constants_service:experiment_id", null, null);
        zzhi.zzb().zzc(zzhqVar);
        return zzhqVar;
    }

    public abstract Object zza(Bundle bundle);

    protected abstract Object zzb(JSONObject jSONObject);

    protected abstract Object zzc(SharedPreferences sharedPreferences);

    public final String zzd() {
        return this.zzb;
    }

    public final Object zze() {
        return zzhi.zzc().zzb() ? this.zzd : this.zzc;
    }

    public final int zzk() {
        return this.zza;
    }
}
