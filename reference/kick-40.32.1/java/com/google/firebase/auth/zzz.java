package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaia;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzz implements com.google.firebase.auth.internal.zzaw, com.google.firebase.auth.internal.zzj {
    private final /* synthetic */ FirebaseAuth zza;

    zzz(FirebaseAuth firebaseAuth) {
        Objects.requireNonNull(firebaseAuth);
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzj
    public final void zza(zzaia zzaiaVar, FirebaseUser firebaseUser) {
        this.zza.zza(firebaseUser, zzaiaVar, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzaw
    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
