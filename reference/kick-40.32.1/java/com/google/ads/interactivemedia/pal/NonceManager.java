package com.google.ads.interactivemedia.pal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.google.android.gms.internal.pal.zzck;
import com.google.android.gms.internal.pal.zzgz;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class NonceManager {
    static final zzck zza = zzck.zza(3000);
    static final zzck zzb = zzck.zza(5000);
    private final Context zzc;
    private final ExecutorService zzd;
    private final Task zze;
    private final zzav zzf;
    private final zzat zzg;
    private final String zzh;
    private boolean zzi = false;
    private String zzj;

    NonceManager(Context context, Handler handler, ExecutorService executorService, Task task, zzav zzavVar, String str) {
        this.zzc = context;
        this.zzd = executorService;
        this.zze = task;
        this.zzf = zzavVar;
        this.zzg = new zzat(handler, zzb);
        this.zzh = str;
    }

    public String getNonce() {
        return this.zzh;
    }

    public void sendAdClick() {
        zzai zzaiVar = new zzai(this);
        Task task = this.zze;
        ExecutorService executorService = this.zzd;
        Tasks.withTimeout(task.continueWith(executorService, zzaiVar), zza.zzb(), TimeUnit.MILLISECONDS).continueWith(executorService, new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzap
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task2) {
                this.zza.zza(task2);
                return null;
            }
        });
    }

    @Deprecated
    public void sendAdImpression() {
    }

    public void sendAdTouch(final MotionEvent motionEvent) {
        Continuation continuation = new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzak
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) throws RemoteException {
                ((zzgz) task.getResult()).zzb(motionEvent);
                return null;
            }
        };
        Task task = this.zze;
        ExecutorService executorService = this.zzd;
        Tasks.withTimeout(task.continueWith(executorService, continuation), zza.zzb(), TimeUnit.MILLISECONDS).continueWith(executorService, new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzal
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task2) {
                this.zza.zzb(task2);
                return null;
            }
        });
    }

    public void sendPlaybackEnd() {
        this.zzg.zzb();
        if (this.zzi) {
            this.zzi = false;
            this.zzf.zza(8, this.zzj);
        }
    }

    public void sendPlaybackStart() {
        if (this.zzi) {
            return;
        }
        this.zzi = true;
        Task task = this.zze;
        ExecutorService executorService = this.zzd;
        Task taskWithTimeout = Tasks.withTimeout(task.continueWith(executorService, new zzaj(this)), zza.zzb(), TimeUnit.MILLISECONDS);
        taskWithTimeout.continueWith(executorService, new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzam
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task2) {
                this.zza.zzc(task2);
                return null;
            }
        });
        taskWithTimeout.continueWith(new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzan
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task2) {
                this.zza.zzd(task2);
                return null;
            }
        });
    }

    final /* synthetic */ Void zza(Task task) {
        this.zzf.zza(4, task.isSuccessful() ? (String) task.getResult() : null);
        return null;
    }

    final /* synthetic */ Void zzb(Task task) {
        this.zzf.zza(5, null);
        return null;
    }

    final /* synthetic */ Void zzc(Task task) {
        String str = task.isSuccessful() ? (String) task.getResult() : null;
        this.zzj = str;
        this.zzf.zza(6, str);
        return null;
    }

    final /* synthetic */ Void zzd(Task task) {
        if (!this.zzi) {
            return null;
        }
        this.zzg.zza(new Runnable() { // from class: com.google.ads.interactivemedia.pal.zzao
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze();
            }
        });
        return null;
    }

    final /* synthetic */ void zze() {
        this.zzf.zza(7, this.zzj);
    }

    final /* synthetic */ Activity zzf() {
        Context context = this.zzc;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    final /* synthetic */ Context zzg() {
        return this.zzc;
    }
}
