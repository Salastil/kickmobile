package com.google.ads.interactivemedia.pal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.pal.zzkx;
import com.google.android.gms.internal.pal.zzld;
import com.google.android.gms.internal.pal.zzno;
import com.google.android.gms.internal.pal.zznp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzp {
    private final String zza;
    private final String zzb;
    private final String zzc;

    zzp(zzn zznVar) {
        this.zza = zznVar.zza();
        this.zzb = zznVar.zzb();
        this.zzc = zznVar.zzc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(String str) {
        try {
            zzld zzldVarZza = zzkx.zza();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) zzldVarZza.zzb(new URL(str), 26624);
                httpURLConnection.setConnectTimeout((int) zzar.zza.zzb());
                httpURLConnection.setReadTimeout((int) zzar.zzb.zzb());
                httpURLConnection.setDoInput(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.getResponseCode();
                zzldVarZza.close();
            } catch (Throwable th) {
                try {
                    zzldVarZza.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        } catch (ArrayIndexOutOfBoundsException e) {
            String.valueOf(str);
            Log.e("NonceGenerator", "Beacon URL was too long: ".concat(String.valueOf(str)), e);
            throw e;
        }
    }

    final void zza(String str, String str2, Map map) {
        zzno zznoVar = new zzno();
        zznoVar.zzb(map);
        zznoVar.zza(zzo.SDKV.zza(), this.zzb);
        zznoVar.zza(zzo.PALV.zza(), this.zza);
        zznoVar.zza(zzo.CORRELATOR.zza(), this.zzc);
        zznoVar.zza(zzo.EVENT_ID.zza(), str2);
        zznoVar.zza(zzo.LOGGER_ID.zza(), str);
        zznp zznpVarZzd = zznoVar.zzd();
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
        for (String str3 : zznpVarZzd.keySet()) {
            builderBuildUpon.appendQueryParameter(str3, (String) zznpVarZzd.get(str3));
        }
        new zzl(this, builderBuildUpon.build().toString()).start();
    }
}
