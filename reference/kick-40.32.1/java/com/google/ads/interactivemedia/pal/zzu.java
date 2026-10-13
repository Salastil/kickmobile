package com.google.ads.interactivemedia.pal;

import android.os.Build;
import com.google.ads.interactivemedia.pal.utils.tcf.TcfConsentSettings;
import com.google.android.gms.internal.pal.zzno;
import com.google.android.gms.internal.pal.zznp;
import java.util.Random;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzu {
    boolean zza;
    private final zzp zzb;
    private Integer zzc;

    zzu(zzp zzpVar) {
        Random random = new Random();
        this.zzb = zzpVar;
        this.zzc = 100;
        this.zza = random.nextInt(100) == 0;
    }

    private static final String zzd(Boolean bool) {
        if (bool == null) {
            return "";
        }
        return true != bool.booleanValue() ? "0" : "1";
    }

    final void zza() {
        this.zzc = 1;
        this.zza = true;
    }

    final void zzb(zzt zztVar, NonceRequest nonceRequest, ConsentSettings consentSettings, TcfConsentSettings tcfConsentSettings, boolean z) {
        if (this.zza) {
            zzno zznoVar = new zzno();
            zznoVar.zza(zzr.LOGGING_DENOMINATOR.zza(), String.valueOf(this.zzc));
            zznoVar.zza(zzr.NONCE_LOADER_INIT_TIME.zza(), String.valueOf(zztVar.zza().zzb()));
            zznoVar.zza(zzr.NONCE_REQUESTED_TIME.zza(), String.valueOf(zztVar.zzb().zzb()));
            zznoVar.zza(zzr.NONCE_LOADED_TIME.zza(), String.valueOf(zztVar.zzc().zzb()));
            zznoVar.zza(zzr.SERVICE_START_TIME.zza(), String.valueOf(zztVar.zzd().zzb()));
            zznoVar.zza(zzr.SERVICE_END_TIME.zza(), String.valueOf(zztVar.zze().zzb()));
            zznoVar.zza(zzr.NONCE_LENGTH.zza(), String.valueOf(zztVar.zzf()));
            zznoVar.zza(zzr.FORCE_LIMITED_ADS.zza(), zzd(Boolean.valueOf(consentSettings.forceLimitedAds())));
            zznoVar.zza(zzr.CONSENT_TO_COOKIES.zza(), zzd(consentSettings.zza()));
            zznoVar.zza(zzr.IS_DIRECTED_FOR_CHILD.zza(), zzd(consentSettings.directedForChildOrUnknownAge()));
            zznoVar.zza(zzr.IS_TV.zza(), zzd(Boolean.valueOf(z)));
            zznoVar.zza(zzr.ANDROID_BUILD_VERSION.zza(), String.valueOf(Build.VERSION.SDK_INT));
            zznoVar.zza(zzr.PLATFORM_SIGNAL_COLLECTOR_INCLUDED.zza(), zzd(Boolean.valueOf(nonceRequest.zzb() != null)));
            zznoVar.zza(zzr.TCF_GDPR_APPLIES.zza(), true != tcfConsentSettings.gdprApplies() ? "0" : "1");
            zznoVar.zza(zzr.TCF_STORAGE_ALLOWED.zza(), true == tcfConsentSettings.isStorageAllowed() ? "1" : "0");
            this.zzb.zza("pal_native", zzq.NONCE_LOADED.zza(), zznoVar.zzd());
        }
    }

    public final void zzc(int i, zznp zznpVar) {
        if (this.zza) {
            zzno zznoVar = new zzno();
            zznoVar.zza(zzr.ERROR_CODE.zza(), String.valueOf(i));
            zznoVar.zzb(zznpVar);
            this.zzb.zza("pal_native", zzq.ERROR_EVENT.zza(), zznoVar.zzd());
        }
    }
}
