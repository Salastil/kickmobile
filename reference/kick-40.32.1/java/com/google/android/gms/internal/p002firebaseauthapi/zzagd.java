package com.google.android.gms.internal.p002firebaseauthapi;

import com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider;
import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzagd {
    private static void zza(HttpURLConnection httpURLConnection, zzaga<?> zzagaVar, zzafi<?> zzafiVar) {
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InputStream inputStream = zza(responseCode) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                String string = sb.toString();
                if (zza(responseCode)) {
                    zzagaVar.zza(zzafg.zza(string, zzafiVar));
                } else {
                    zzagaVar.zza(zzafg.zza(string));
                }
                httpURLConnection.disconnect();
            } catch (Throwable th3) {
                httpURLConnection.disconnect();
                throw th3;
            }
        } catch (zzacw e) {
            e = e;
            zzagaVar.zza(e.getMessage());
            httpURLConnection.disconnect();
        } catch (SocketTimeoutException unused) {
            zzagaVar.zza("TIMEOUT");
            httpURLConnection.disconnect();
        } catch (IOException e2) {
            e = e2;
            zzagaVar.zza(e.getMessage());
            httpURLConnection.disconnect();
        }
    }

    private static final boolean zza(int i) {
        return i >= 200 && i < 300;
    }

    public static void zza(String str, zzaga<?> zzagaVar, zzafi<?> zzafiVar, zzafj zzafjVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(DefaultBatteryInfoProvider.BATTERY_POLL_INTERVAL_MS);
            zzafjVar.zza(httpURLConnection);
            zza(httpURLConnection, zzagaVar, zzafiVar);
        } catch (SocketTimeoutException unused) {
            zzagaVar.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzagaVar.zza("<<Network Error>>");
        } catch (IOException e) {
            zzagaVar.zza(e.getMessage());
        }
    }

    public static void zza(String str, zzaff zzaffVar, zzaga<?> zzagaVar, zzafi<?> zzafiVar, zzafj zzafjVar) {
        try {
            Preconditions.checkNotNull(zzaffVar);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzaffVar.zza().getBytes(Charset.defaultCharset());
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(DefaultBatteryInfoProvider.BATTERY_POLL_INTERVAL_MS);
            zzafjVar.zza(httpURLConnection);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), bytes.length);
            try {
                bufferedOutputStream.write(bytes, 0, bytes.length);
                bufferedOutputStream.close();
                zza(httpURLConnection, zzagaVar, zzafiVar);
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (NullPointerException e) {
            e = e;
            zzagaVar.zza(e.getMessage());
        } catch (SocketTimeoutException unused) {
            zzagaVar.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzagaVar.zza("<<Network Error>>");
        } catch (IOException e2) {
            e = e2;
            zzagaVar.zza(e.getMessage());
        } catch (JSONException e3) {
            e = e3;
            zzagaVar.zza(e.getMessage());
        }
    }
}
