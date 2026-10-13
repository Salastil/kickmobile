package com.google.ads.interactivemedia.pal.utils.tcf;

import android.content.SharedPreferences;
import com.google.android.gms.internal.pal.zzvh;
import com.google.android.gms.internal.pal.zzvi;
import java.util.Optional;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public class TcfConsentSettings {
    private final boolean zza;
    private final zzc zzb;

    public TcfConsentSettings(SharedPreferences sharedPreferences) {
        String string = "";
        boolean z = false;
        try {
            if (sharedPreferences.getInt("IABTCF_gdprApplies", 0) == 1) {
                z = true;
            }
        } catch (ClassCastException unused) {
        }
        this.zza = z;
        try {
            string = sharedPreferences.getString("IABTCF_TCString", "");
        } catch (ClassCastException unused2) {
        }
        Optional optionalZza = zzvi.zza(string);
        if (UByte$$ExternalSyntheticBackport0.m(optionalZza)) {
            this.zzb = null;
        } else {
            this.zzb = zzc.zzm((zzvh) optionalZza.get(), string, Boolean.valueOf(this.zza), null);
        }
    }

    public boolean gdprApplies() {
        return this.zza;
    }

    public boolean isSpecialPurposesForGoogleAllowed() {
        zzc zzcVar;
        if (!this.zza || (zzcVar = this.zzb) == null) {
            return true;
        }
        return zzd.zzb(zzcVar);
    }

    public boolean isStorageAllowed() {
        if (!this.zza) {
            return true;
        }
        zzc zzcVar = this.zzb;
        if (zzcVar == null) {
            return false;
        }
        return zzd.zza(zzcVar, false, false);
    }
}
