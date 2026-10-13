package com.google.android.gms.internal.pal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbz extends zzci {
    private final Context zza;

    public zzbz(Handler handler, ExecutorService executorService, Context context) {
        super(handler, executorService, zzck.zza(7200000L));
        this.zza = context;
    }

    private final zzlq zzf() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zza);
            String id = advertisingIdInfo.getId();
            if (id == null) {
                id = "";
            }
            return zzlq.zzf(new zzcb(id, "adid", advertisingIdInfo.isLimitAdTrackingEnabled()));
        } catch (GooglePlayServicesNotAvailableException e) {
            Log.e("NonceGenerator", "Google Play services is not available entirely.", e);
            return zzlq.zze();
        } catch (GooglePlayServicesRepairableException e2) {
            Log.e("NonceGenerator", "Obsolete or disabled version of Google Play Services", e2);
            return zzlq.zze();
        } catch (IOException e3) {
            Log.e("NonceGenerator", "Unrecoverable error connecting to Google Play services.", e3);
            return zzlq.zze();
        } catch (IllegalStateException e4) {
            Log.e("NonceGenerator", "IllegalStateException, can't access android advertising info.", e4);
            return zzlq.zze();
        }
    }

    private final zzlq zzg() {
        Context context = this.zza;
        if (context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv")) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                boolean z = true;
                if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 1) {
                    z = false;
                }
                return zzlq.zzf(new zzcb(string, "afai", z));
            } catch (Settings.SettingNotFoundException e) {
                Log.i("NonceGenerator", "Unable to fetch Advertising Id info.", e);
            }
        }
        return zzlq.zze();
    }

    @Override // com.google.android.gms.internal.pal.zzci
    final zzlq zza() {
        zzlq zzlqVarZzg = zzg();
        return !zzlqVarZzg.zza() ? zzf() : zzlqVarZzg;
    }
}
