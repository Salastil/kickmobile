package com.google.android.gms.internal.measurement;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlb {
    public static ListenableFuture zza(Task task, CancellationTokenSource cancellationTokenSource) {
        final zzkz zzkzVar = new zzkz(task, null);
        task.addOnCompleteListener(MoreExecutors.directExecutor(), new OnCompleteListener() { // from class: com.google.android.gms.internal.measurement.zzla
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task2) {
                zzkz zzkzVar2 = zzkzVar;
                if (task2.isCanceled()) {
                    zzkzVar2.cancel(false);
                    return;
                }
                if (task2.isSuccessful()) {
                    zzkzVar2.set(task2.getResult());
                    return;
                }
                Exception exception = task2.getException();
                if (exception == null) {
                    throw new IllegalStateException();
                }
                zzkzVar2.setException(exception);
            }
        });
        return zzkzVar;
    }
}
