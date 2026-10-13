package com.google.android.gms.internal.pal;

import android.os.Handler;
import android.util.Log;
import com.google.ads.interactivemedia.pal.NonceLoaderException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzce extends zzci {
    public zzce(Handler handler, ExecutorService executorService) {
        super(handler, executorService, zzck.zza(7200000L));
    }

    private static zzwe zzf() throws Throwable {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL("https://imasdk.googleapis.com/pal/key/public.json");
                int i = zzku.zzb;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout((int) com.google.ads.interactivemedia.pal.zzar.zza.zzb());
                    httpURLConnection2.setReadTimeout((int) com.google.ads.interactivemedia.pal.zzar.zzb.zzb());
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.connect();
                    if (httpURLConnection2.getResponseCode() != 200) {
                        int responseCode = httpURLConnection2.getResponseCode();
                        StringBuilder sb = new StringBuilder(String.valueOf(responseCode).length() + 26);
                        sb.append("Failed keystore response: ");
                        sb.append(responseCode);
                        Log.w("NonceGenerator", sb.toString());
                        throw NonceLoaderException.zza(202);
                    }
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    try {
                        zzwe zzweVarZzf = zzwe.zzf(zzvy.zza(inputStream));
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return zzweVarZzf;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    String string = e.toString();
                    StringBuilder sb2 = new StringBuilder(string.length() + 30);
                    sb2.append("Failed to read keyset handle: ");
                    sb2.append(string);
                    Log.e("NonceGenerator", sb2.toString());
                    throw new NonceLoaderException(203, e);
                } catch (GeneralSecurityException e2) {
                    e = e2;
                    String string2 = e.toString();
                    StringBuilder sb3 = new StringBuilder(string2.length() + 30);
                    sb3.append("Failed to read keyset handle: ");
                    sb3.append(string2);
                    Log.e("NonceGenerator", sb3.toString());
                    throw new NonceLoaderException(203, e);
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (GeneralSecurityException e4) {
            e = e4;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzci
    final zzlq zza() throws NonceLoaderException {
        try {
            zzaet.zza();
            return zzlq.zzf(new zzcd((zzvw) zzf().zzg(zzacq.zza(), zzvw.class)));
        } catch (GeneralSecurityException e) {
            Log.e("NonceGenerator", "Can't access the cryptography library.", e);
            throw new NonceLoaderException(201, e);
        }
    }
}
