package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhk implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Object zza = new Object();
    private SharedPreferences zzb = null;

    public zzhk() {
        new JSONObject();
    }

    private static final void zzb(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                new JSONObject((String) zzib.zza(new zzme() { // from class: com.google.android.gms.internal.pal.zzhj
                    @Override // com.google.android.gms.internal.pal.zzme
                    public final /* synthetic */ Object zza() {
                        return sharedPreferences.getString("flag_configuration", "{}");
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzb(sharedPreferences);
        }
    }

    public final void zza(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        synchronized (this.zza) {
            if (this.zzb != null) {
                return;
            }
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            zzhi.zza();
            try {
                sharedPreferences = context.getSharedPreferences("google_adapter_flags", 0);
            } catch (IllegalStateException e) {
                zzik.zza("", e);
                sharedPreferences = null;
            }
            this.zzb = sharedPreferences;
            zzb(sharedPreferences);
            if (!((Boolean) zzie.zza.zzc()).booleanValue() && (sharedPreferences2 = this.zzb) != null) {
                sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
            }
        }
    }
}
