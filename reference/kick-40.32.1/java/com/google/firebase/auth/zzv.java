package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaiw;
import com.google.android.gms.internal.p002firebaseauthapi.zzajc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.internal.zzci;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzv implements Continuation<zzaiw, Task<TotpSecret>> {
    private final /* synthetic */ FirebaseAuth zza;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<TotpSecret> then(Task<zzaiw> task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.checkNotNull(task.getException()));
        }
        zzaiw result = task.getResult();
        if (result instanceof zzajc) {
            zzajc zzajcVar = (zzajc) result;
            return Tasks.forResult(new zzci(Preconditions.checkNotEmpty(zzajcVar.zzf()), Preconditions.checkNotEmpty(zzajcVar.zze()), zzajcVar.zzc(), zzajcVar.zzb(), zzajcVar.zzd(), Preconditions.checkNotEmpty(zzajcVar.zza()), this.zza));
        }
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + result.getClass().getName() + ".");
    }

    zzv(FirebaseAuth firebaseAuth) {
        Objects.requireNonNull(firebaseAuth);
        this.zza = firebaseAuth;
    }
}
