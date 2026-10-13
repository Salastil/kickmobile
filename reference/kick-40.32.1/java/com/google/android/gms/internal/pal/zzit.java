package com.google.android.gms.internal.pal;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzit extends zzil {
    final /* synthetic */ TaskCompletionSource zza;

    zzit(zziv zzivVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzivVar);
    }

    @Override // com.google.android.gms.internal.pal.zzim
    public final void zzb(Bundle bundle) {
        this.zza.trySetResult(bundle.getString("newToken"));
    }

    @Override // com.google.android.gms.internal.pal.zzim
    public final void zzc(int i) {
        this.zza.trySetException(new zzir(i));
    }
}
