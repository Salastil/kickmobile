package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbf {
    private static final zzbq zza;

    static {
        zzbq zzbeVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzbeVar = new zzbd();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzbeVar = new zzbe();
        }
        zza = zzbeVar;
    }

    public static zzbq zza() {
        return zza;
    }
}
