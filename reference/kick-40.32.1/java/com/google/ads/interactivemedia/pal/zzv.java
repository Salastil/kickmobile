package com.google.ads.interactivemedia.pal;

import com.google.android.gms.internal.pal.zzaxs;
import com.google.android.gms.internal.pal.zzul;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzv implements zzaxs {
    private static final ExecutorService zza;

    static {
        zzul zzulVar = new zzul();
        zzulVar.zza("palsdk-%d");
        zza = Executors.newCachedThreadPool(zzulVar.zzb());
    }

    zzv() {
    }

    public static final ExecutorService zza() {
        return zza;
    }
}
