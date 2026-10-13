package com.google.android.gms.cast.internal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzs implements Runnable {
    final /* synthetic */ zzx zza;
    final /* synthetic */ int zzb;

    zzs(zzw zzwVar, zzx zzxVar, int i) {
        this.zza = zzxVar;
        this.zzb = i;
        Objects.requireNonNull(zzwVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzQ().onApplicationDisconnected(this.zzb);
    }
}
