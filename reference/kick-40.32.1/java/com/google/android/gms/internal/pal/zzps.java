package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzps implements Runnable {
    final /* synthetic */ zzpr zza;
    final /* synthetic */ zzpt zzb;

    zzps(zzpt zzptVar, zzpr zzprVar) {
        this.zza = zzprVar;
        Objects.requireNonNull(zzptVar);
        this.zzb = zzptVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().remove(this.zza);
    }
}
