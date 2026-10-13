package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdr implements zzjs {
    final /* synthetic */ zzdu zza;

    zzdr(zzdu zzduVar) {
        Objects.requireNonNull(zzduVar);
        this.zza = zzduVar;
    }

    @Override // com.google.android.gms.internal.pal.zzjs
    public final void zza(int i, long j) {
        this.zza.zzn().zzb(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.pal.zzjs
    public final void zzb(int i, long j, String str) {
        this.zza.zzn().zzf(i, System.currentTimeMillis() - j, str);
    }
}
