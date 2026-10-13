package com.google.android.gms.internal.pal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zztz extends zzub {
    public static zzuh zza(Object obj) {
        return new zzuc("");
    }

    public static zzuh zzb(Callable callable, Executor executor) {
        zzun zzunVar = new zzun(callable);
        executor.execute(zzunVar);
        return zzunVar;
    }
}
