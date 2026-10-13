package com.google.android.gms.internal.pal;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzum extends zzuf {
    final /* synthetic */ zzun zza;
    private final Callable zzb;

    zzum(zzun zzunVar, Callable callable) {
        Objects.requireNonNull(zzunVar);
        this.zza = zzunVar;
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.pal.zzuf
    final boolean zza() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.pal.zzuf
    final Object zzb() throws Exception {
        return this.zzb.call();
    }

    @Override // com.google.android.gms.internal.pal.zzuf
    final void zzc(Object obj) {
        this.zza.zzc(obj);
    }

    @Override // com.google.android.gms.internal.pal.zzuf
    final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.pal.zzuf
    final String zzf() {
        return this.zzb.toString();
    }
}
