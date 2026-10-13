package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzt implements com.google.firebase.auth.internal.zzat {
    private final /* synthetic */ FirebaseUser zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzt(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
        Objects.requireNonNull(firebaseAuth);
        this.zzb = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzat
    public final void zza() {
        if (this.zzb.zzh == null || !this.zzb.zzh.getUid().equalsIgnoreCase(this.zza.getUid())) {
            return;
        }
        this.zzb.zzg();
    }

    @Override // com.google.firebase.auth.internal.zzaw
    public final void zza(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
            this.zzb.signOut();
        }
    }
}
