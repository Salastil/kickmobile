package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaft implements zzafv {
    private final /* synthetic */ Status zza;

    zzaft(zzafp zzafpVar, Status status) {
        this.zza = status;
        Objects.requireNonNull(zzafpVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zzaew.zza(this.zza));
    }
}
