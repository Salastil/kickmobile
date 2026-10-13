package com.google.android.gms.internal.cast;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzwv extends zzwm {
    final /* synthetic */ zzww zza;
    private final Callable zzb;

    zzwv(zzww zzwwVar, Callable callable) {
        Objects.requireNonNull(zzwwVar);
        this.zza = zzwwVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.cast.zzwm
    final boolean zza() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.cast.zzwm
    final Object zzb() throws Exception {
        return this.zzb.call();
    }

    @Override // com.google.android.gms.internal.cast.zzwm
    final void zzc(Object obj) {
        this.zza.zzc(obj);
    }

    @Override // com.google.android.gms.internal.cast.zzwm
    final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.cast.zzwm
    final String zzf() {
        return this.zzb.toString();
    }
}
