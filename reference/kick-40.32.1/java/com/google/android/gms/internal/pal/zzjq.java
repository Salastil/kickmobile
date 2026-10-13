package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjq {
    private final Context zza;
    private final Executor zzb;
    private final zzjc zzc;
    private final zzjp zzd;
    private Task zze;

    zzjq(Context context, Executor executor, zzjc zzjcVar, zzje zzjeVar, zzjm zzjmVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzjcVar;
        this.zzd = zzjmVar;
    }

    public static zzjq zza(Context context, Executor executor, zzjc zzjcVar, zzje zzjeVar) {
        final zzjq zzjqVar = new zzjq(context, executor, zzjcVar, zzjeVar, new zzjm());
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.pal.zzjo
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        };
        Executor executor2 = zzjqVar.zzb;
        zzjqVar.zze = Tasks.call(executor2, callable).addOnFailureListener(executor2, new OnFailureListener() { // from class: com.google.android.gms.internal.pal.zzjn
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final /* synthetic */ void onFailure(Exception exc) {
                this.zza.zzd(exc);
            }
        });
        return zzjqVar;
    }

    public final zzbd zzb() {
        zzjp zzjpVar = this.zzd;
        Task task = this.zze;
        return !task.isSuccessful() ? zzjpVar.zza() : (zzbd) task.getResult();
    }

    final /* synthetic */ zzbd zzc() throws PackageManager.NameNotFoundException {
        Context context = this.zza;
        return zzjj.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    final /* synthetic */ void zzd(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1L, exc);
    }
}
