package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzar implements Runnable {
    final /* synthetic */ zzas zza;
    private final String zzb;

    zzar(zzas zzasVar, String str) {
        Objects.requireNonNull(zzasVar);
        this.zza = zzasVar;
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseAuth firebaseAuthZza;
        FirebaseApp firebaseApp = FirebaseApp.getInstance(this.zzb);
        com.google.firebase.auth.zzat zzatVarZzb = com.google.firebase.auth.zzad.zza(firebaseApp).zzb();
        if (zzatVarZzb == null) {
            firebaseAuthZza = FirebaseAuth.getInstance(firebaseApp);
        } else {
            firebaseAuthZza = FirebaseAuth.zza(firebaseApp, zzatVarZzb);
        }
        if (firebaseAuthZza.zzi()) {
            Task<GetTokenResult> accessToken = firebaseAuthZza.getAccessToken(true);
            zzas.zzc.v("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzau(this));
        }
    }
}
