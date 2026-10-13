package com.google.ads.interactivemedia.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzl extends Thread {
    final /* synthetic */ String zza;

    zzl(zzp zzpVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzpVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        zzp.zzc(this.zza);
    }
}
