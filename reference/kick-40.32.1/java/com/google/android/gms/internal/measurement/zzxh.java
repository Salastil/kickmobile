package com.google.android.gms.internal.measurement;

import android.os.SystemClock;
import com.google.common.base.Ticker;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxh {
    private static final Ticker zza;

    static {
        Ticker zzxgVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzxgVar = new zzxf();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzxgVar = new zzxg();
        }
        zza = zzxgVar;
    }

    public static Ticker zza() {
        return zza;
    }
}
