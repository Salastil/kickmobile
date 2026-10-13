package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzak implements Continuation<GetTokenResult, Task<MultiFactorSession>> {
    private final /* synthetic */ zzah zza;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<MultiFactorSession> then(Task<GetTokenResult> task) throws Exception {
        return !task.isSuccessful() ? Tasks.forException((Exception) Preconditions.checkNotNull(task.getException())) : Tasks.forResult(zzao.zza(task.getResult().getToken(), this.zza.zza));
    }

    zzak(zzah zzahVar) {
        Objects.requireNonNull(zzahVar);
        this.zza = zzahVar;
    }
}
