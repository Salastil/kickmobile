package com.google.ads.interactivemedia.pal;

import com.google.android.gms.internal.pal.zzgz;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzaj implements Continuation {
    final /* synthetic */ NonceManager zza;

    zzaj(NonceManager nonceManager) {
        Objects.requireNonNull(nonceManager);
        this.zza = nonceManager;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        NonceManager nonceManager = this.zza;
        return ((zzgz) task.getResult()).zza(nonceManager.zzg(), null, nonceManager.zzf());
    }
}
