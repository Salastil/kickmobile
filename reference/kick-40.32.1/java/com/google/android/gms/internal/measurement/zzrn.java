package com.google.android.gms.internal.measurement;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrn {
    private static final Object zza = new Object();
    private static Thread zzb;
    private static volatile Handler zzc;

    public static boolean zza(Thread thread) {
        if (zzb == null) {
            zzb = Looper.getMainLooper().getThread();
        }
        return thread == zzb;
    }

    public static Handler zzb() {
        if (zzc == null) {
            synchronized (zza) {
                if (zzc == null) {
                    zzc = new Handler(Looper.getMainLooper());
                }
            }
        }
        return zzc;
    }
}
