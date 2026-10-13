package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzgm implements Runnable {
    final /* synthetic */ zzgn zza;

    zzgm(zzgn zzgnVar) {
        Objects.requireNonNull(zzgnVar);
        this.zza = zzgnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb();
    }
}
