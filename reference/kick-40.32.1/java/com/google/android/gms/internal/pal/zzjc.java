package com.google.android.gms.internal.pal;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzjc {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzjc(Context context, Executor executor, Task task, boolean z) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z;
    }

    public static zzjc zza(final Context context, Executor executor, boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.pal.zziy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzjc.zza;
                    taskCompletionSource.setResult(zzko.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.pal.zzja
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzjc.zza;
                    taskCompletionSource.setResult(zzko.zzc());
                }
            });
        }
        return new zzjc(context, executor, taskCompletionSource.getTask(), z);
    }

    static void zzg(int i) {
        zzf = i;
    }

    private final Task zzh(final int i, long j, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, zzjb.zza);
        }
        Context context = this.zzb;
        final zzn zznVarZza = zzr.zza();
        zznVarZza.zza(context.getPackageName());
        zznVarZza.zzb(j);
        zznVarZza.zzg(zzf);
        if (exc != null) {
            int i2 = zzmf.zza;
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zznVarZza.zzc(stringWriter.toString());
            zznVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zznVarZza.zze(str2);
        }
        if (str != null) {
            zznVarZza.zzf(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.pal.zziz
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                int i3 = zzjc.zza;
                if (!task.isSuccessful()) {
                    return false;
                }
                int i4 = i;
                zzkn zzknVarZza = ((zzko) task.getResult()).zza(((zzr) zznVarZza.zzal()).zzaq());
                zzknVarZza.zzc(i4);
                zzknVarZza.zza();
                return true;
            }
        });
    }

    public final Task zzb(int i, long j) {
        return zzh(i, j, null, null, null, null);
    }

    public final Task zzc(int i, long j, Exception exc) {
        return zzh(i, j, exc, null, null, null);
    }

    public final Task zzd(int i, long j, String str, Map map) {
        return zzh(i, j, null, str, null, null);
    }

    public final Task zze(int i, String str) {
        return zzh(i, 0L, null, null, null, str);
    }

    public final Task zzf(int i, long j, String str) {
        return zzh(i, j, null, null, null, str);
    }
}
