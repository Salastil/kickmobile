package com.google.android.gms.cast.internal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzu implements Runnable {
    final /* synthetic */ zzx zza;
    final /* synthetic */ zza zzb;

    zzu(zzw zzwVar, zzx zzxVar, zza zzaVar) {
        this.zza = zzxVar;
        this.zzb = zzaVar;
        Objects.requireNonNull(zzwVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzK(this.zzb);
    }
}
