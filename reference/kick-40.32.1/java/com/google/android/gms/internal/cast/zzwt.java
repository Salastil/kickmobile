package com.google.android.gms.internal.cast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwt {
    public static zzwo zza(ExecutorService executorService) {
        if (executorService instanceof zzwo) {
            return (zzwo) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new zzws((ScheduledExecutorService) executorService) : new zzwp(executorService);
    }
}
