package com.google.android.gms.internal.cast;

import android.animation.Animator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzgo extends zzgt {
    final /* synthetic */ zzgp zza;

    zzgo(zzgp zzgpVar) {
        Objects.requireNonNull(zzgpVar);
        this.zza = zzgpVar;
    }

    @Override // com.google.android.gms.internal.cast.zzgt
    public final void zza(long j) {
        zzgp zzgpVar = this.zza;
        zzgpVar.zze(zzgpVar.zzd() + 1);
        Animator animator = zzgpVar.zza;
        if (zzgpVar.zza(animator) || animator.isStarted() || zzgpVar.zzc()) {
            return;
        }
        animator.start();
    }
}
