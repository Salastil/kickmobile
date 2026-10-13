package com.google.ads.interactivemedia.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzas implements Runnable {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzat zzb;

    zzas(zzat zzatVar, Runnable runnable) {
        this.zza = runnable;
        Objects.requireNonNull(zzatVar);
        this.zzb = zzatVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.run();
        zzat zzatVar = this.zzb;
        zzatVar.zzc().postDelayed(this, zzatVar.zzd().zzb());
    }
}
