package com.google.android.gms.internal.cast;

import com.google.android.gms.common.util.DefaultClock;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzu {
    private static zzu zza;

    private zzu(zzj zzjVar, String str) {
        new ConcurrentHashMap();
        DefaultClock.getInstance();
    }

    public static synchronized void zza(zzj zzjVar, String str) {
        if (zza == null) {
            zza = new zzu(zzjVar, str);
        }
    }
}
