package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzca extends zzci {
    private final AppSetIdClient zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzca(Handler handler, ExecutorService executorService, Context context) {
        super(handler, executorService, zzck.zza(7200000L));
        AppSetIdClient appSetIdClientZzf = zzf(context);
        this.zza = appSetIdClientZzf;
    }

    private static AppSetIdClient zzf(Context context) {
        try {
            return AppSet.getClient(context);
        } catch (NoClassDefFoundError | NoSuchMethodError e) {
            Log.e("NonceGenerator", "Failed to contact the App Set SDK.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzci
    final zzlq zza() {
        AppSetIdClient appSetIdClient = this.zza;
        if (appSetIdClient == null) {
            return zzlq.zze();
        }
        try {
            return zzlq.zzf((AppSetIdInfo) Tasks.await(appSetIdClient.getAppSetIdInfo(), com.google.ads.interactivemedia.pal.zzar.zzc.zzb(), TimeUnit.MILLISECONDS));
        } catch (InterruptedException | NoClassDefFoundError | NoSuchMethodError | ExecutionException | TimeoutException e) {
            Log.i("NonceGenerator", "Unable to fetch AppSetId info.", e);
            return zzlq.zze();
        }
    }
}
