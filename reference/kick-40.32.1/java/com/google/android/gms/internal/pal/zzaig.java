package com.google.android.gms.internal.pal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaig {
    private static final zzaig zza = new zzaig();
    private static final zzaif zzb = new zzaif(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzaig zza() {
        return zza;
    }

    public final zzahy zzb() {
        zzahy zzahyVar = (zzahy) this.zzc.get();
        return zzahyVar == null ? zzb : zzahyVar;
    }
}
