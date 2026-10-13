package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbx extends zzci {
    private final com.google.ads.interactivemedia.pal.zzu zza;
    private final Task zzb;
    private final Context zzc;

    public zzbx(Handler handler, ExecutorService executorService, Context context, Task task, com.google.ads.interactivemedia.pal.zzu zzuVar) {
        super(handler, executorService, zzck.zza(7200000L));
        this.zzc = context;
        this.zzb = task;
        this.zza = zzuVar;
    }

    @Override // com.google.android.gms.internal.pal.zzci
    final zzlq zza() {
        try {
            return zzlq.zzf(((zzgz) Tasks.await(this.zzb)).zzd(this.zzc, null));
        } catch (RemoteException | InterruptedException | ExecutionException unused) {
            Log.e("NonceGenerator", "Unexpected exception while gathering request signals.");
            this.zza.zzc(1, zznp.zza());
            return zzlq.zze();
        }
    }
}
