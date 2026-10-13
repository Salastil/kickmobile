package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcj extends zzci {
    private final zziq zza;
    private final com.google.ads.interactivemedia.pal.zzu zzb;
    private final Bundle zzc;

    public zzcj(Handler handler, ExecutorService executorService, Context context, com.google.ads.interactivemedia.pal.zzu zzuVar, com.google.ads.interactivemedia.pal.zzaq zzaqVar) {
        zziv zzivVar = new zziv(context);
        super(handler, executorService, zzck.zza(7200000L));
        Bundle bundle = new Bundle();
        bundle.putString("x-afma-token-requester-type", zzaqVar.toString());
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("extra_headers", bundle);
        this.zzc = bundle2;
        this.zza = zzivVar;
        this.zzb = zzuVar;
    }

    @Override // com.google.android.gms.internal.pal.zzci
    final zzlq zza() {
        try {
            String str = (String) Tasks.await(this.zza.zza(this.zzc), 5L, TimeUnit.SECONDS);
            if (str == null) {
                this.zzb.zzc(5, zznp.zza());
            } else if (str.isEmpty()) {
                this.zzb.zzc(6, zznp.zza());
            }
            return zzlq.zzg(str);
        } catch (InterruptedException | TimeoutException unused) {
            this.zzb.zzc(2, zznp.zza());
            return zzlq.zze();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof zzir) {
                int iZza = ((zzir) cause).zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 32);
                sb.append("Unable to fetch SignalSdk info: ");
                sb.append(iZza);
                Log.i("NonceGenerator", sb.toString());
                this.zzb.zzc(3, zznp.zzb(com.google.ads.interactivemedia.pal.zzr.SIGNAL_SDK_ERROR_CODE.zza(), String.valueOf(iZza)));
            } else {
                this.zzb.zzc(4, zznp.zza());
            }
            return zzlq.zze();
        }
    }
}
