package com.google.ads.interactivemedia.pal;

import android.content.SharedPreferences;
import com.google.ads.interactivemedia.pal.utils.tcf.TcfConsentSettings;
import com.google.android.gms.internal.pal.zzlq;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzk {
    private final SharedPreferences zza;
    private final GoogleAdManagerSettings zzb;
    private final ConsentSettings zzc;
    private final TcfConsentSettings zzd;

    public zzk(SharedPreferences sharedPreferences, GoogleAdManagerSettings googleAdManagerSettings, ConsentSettings consentSettings, TcfConsentSettings tcfConsentSettings) {
        this.zza = sharedPreferences;
        this.zzb = googleAdManagerSettings;
        this.zzc = consentSettings;
        this.zzd = tcfConsentSettings;
    }

    public final zzlq zza() {
        SharedPreferences sharedPreferences = this.zza;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        long j = sharedPreferences.getLong("google_eoid_ts", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (j != 0 && jCurrentTimeMillis - j > 15552000) {
            editorEdit.remove("google_eoid").remove("google_eoid_ts").commit();
        }
        TcfConsentSettings tcfConsentSettings = this.zzd;
        if (!tcfConsentSettings.isSpecialPurposesForGoogleAllowed() || ((this.zzc.forceLimitedAds() || !tcfConsentSettings.isStorageAllowed()) && this.zzb.disableLimitedAdsStorage())) {
            return zzlq.zze();
        }
        String string = sharedPreferences.getString("google_eoid", "");
        if (string.isEmpty() || j == 0) {
            string = UUID.randomUUID().toString();
            editorEdit.putString("google_eoid", string).putLong("google_eoid_ts", jCurrentTimeMillis).commit();
            j = jCurrentTimeMillis;
        }
        return zzlq.zzf(new zzj(string, j));
    }
}
