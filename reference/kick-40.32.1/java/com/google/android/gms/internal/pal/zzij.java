package com.google.android.gms.internal.pal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzij {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicReference zzb = new AtomicReference();

    static {
        new AtomicBoolean();
    }

    static zzih zza() {
        return (zzih) zza.get();
    }

    static zzii zzb() {
        return (zzii) zzb.get();
    }

    public static void zzc(zzih zzihVar) {
        zza.set(zzihVar);
    }
}
