package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import com.google.android.gms.cast.internal.Logger;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzo {
    public String zzb;
    public String zzc;
    public String zzf;
    public int zzg;
    public boolean zzo;
    public int zzp;
    private final zzax zzr;
    private static final Logger zzq = new Logger("ApplicationAnalyticsSession");
    public static long zza = System.currentTimeMillis();
    public String zzh = "";
    public String zzi = "";
    public String zzj = "";
    public String zzk = "";
    public String zzl = "";
    public String zzm = "";
    public int zzn = 0;
    public long zzd = zza;
    public int zze = 1;

    private zzo(zzax zzaxVar) {
        this.zzr = zzaxVar;
    }

    public static zzo zza(zzax zzaxVar) {
        zzo zzoVar = new zzo(zzaxVar);
        zza++;
        return zzoVar;
    }

    public static zzo zzc(SharedPreferences sharedPreferences, zzax zzaxVar) {
        if (sharedPreferences == null) {
            return null;
        }
        zzo zzoVar = new zzo(zzaxVar);
        zzoVar.zzo = sharedPreferences.getBoolean("is_output_switcher_enabled", false);
        if (!sharedPreferences.contains("application_id")) {
            return null;
        }
        zzoVar.zzb = sharedPreferences.getString("application_id", "");
        if (!sharedPreferences.contains("receiver_metrics_id")) {
            return null;
        }
        zzoVar.zzc = sharedPreferences.getString("receiver_metrics_id", "");
        if (!sharedPreferences.contains("analytics_session_id")) {
            return null;
        }
        zzoVar.zzd = sharedPreferences.getLong("analytics_session_id", 0L);
        if (!sharedPreferences.contains("event_sequence_number")) {
            return null;
        }
        zzoVar.zze = sharedPreferences.getInt("event_sequence_number", 0);
        if (!sharedPreferences.contains("receiver_session_id")) {
            return null;
        }
        zzoVar.zzf = sharedPreferences.getString("receiver_session_id", "");
        zzoVar.zzg = sharedPreferences.getInt("device_capabilities", 0);
        zzoVar.zzh = sharedPreferences.getString("device_model_name", "");
        zzoVar.zzi = sharedPreferences.getString("manufacturer", "");
        zzoVar.zzj = sharedPreferences.getString(FirebaseAnalytics.Param.PRODUCT_NAME, "");
        zzoVar.zzk = sharedPreferences.getString("build_type", "");
        zzoVar.zzl = sharedPreferences.getString("cast_build_version", "");
        zzoVar.zzm = sharedPreferences.getString("system_build_number", "");
        zzoVar.zzn = sharedPreferences.getInt("device_category", 0);
        zzoVar.zzp = sharedPreferences.getInt("analytics_session_start_type", 0);
        return zzoVar;
    }

    public final boolean zzb() {
        return this.zzr.zze();
    }

    public final void zzd(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        zzq.d("Save the ApplicationAnalyticsSession to SharedPreferences %s", sharedPreferences);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("application_id", this.zzb);
        editorEdit.putString("receiver_metrics_id", this.zzc);
        editorEdit.putLong("analytics_session_id", this.zzd);
        editorEdit.putInt("event_sequence_number", this.zze);
        editorEdit.putString("receiver_session_id", this.zzf);
        editorEdit.putInt("device_capabilities", this.zzg);
        editorEdit.putString("device_model_name", this.zzh);
        editorEdit.putString("manufacturer", this.zzi);
        editorEdit.putString(FirebaseAnalytics.Param.PRODUCT_NAME, this.zzj);
        editorEdit.putString("build_type", this.zzk);
        editorEdit.putString("cast_build_version", this.zzl);
        editorEdit.putString("system_build_number", this.zzm);
        editorEdit.putInt("device_category", this.zzn);
        editorEdit.putInt("analytics_session_start_type", this.zzp);
        editorEdit.putBoolean("is_output_switcher_enabled", this.zzo);
        editorEdit.apply();
    }
}
