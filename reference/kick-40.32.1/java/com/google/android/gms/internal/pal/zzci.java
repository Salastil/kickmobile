package com.google.android.gms.internal.pal;

import android.os.Handler;
import com.google.ads.interactivemedia.pal.NonceLoaderException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzci {
    private final ExecutorService zza;
    private final zzck zzb;
    private final Handler zzc;
    private Task zzd = Tasks.forResult(zzlq.zze());

    zzci(Handler handler, ExecutorService executorService, zzck zzckVar) {
        this.zza = executorService;
        this.zzc = handler;
        this.zzb = zzckVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final void zze() {
        Handler handler = this.zzc;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.pal.zzch
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze();
            }
        }, this.zzb.zzb());
        this.zzd = Tasks.call(this.zza, new Callable() { // from class: com.google.android.gms.internal.pal.zzcg
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zza();
            }
        });
    }

    abstract zzlq zza() throws NonceLoaderException;

    public final Task zzb() {
        if (this.zzd.isComplete() && !this.zzd.isSuccessful()) {
            zze();
        }
        return this.zzd;
    }

    public final void zzc() {
        zze();
    }

    public final void zzd() {
        this.zzc.removeCallbacksAndMessages(null);
    }
}
