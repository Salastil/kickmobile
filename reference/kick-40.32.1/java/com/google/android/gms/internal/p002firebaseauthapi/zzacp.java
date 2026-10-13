package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzacp implements zzaga<zzaia> {
    private final /* synthetic */ UserProfileChangeRequest zza;
    private final /* synthetic */ zzaeu zzb;
    private final /* synthetic */ zzaba zzc;

    zzacp(zzaba zzabaVar, UserProfileChangeRequest userProfileChangeRequest, zzaeu zzaeuVar) {
        this.zza = userProfileChangeRequest;
        this.zzb = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
        this.zzc = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zzb.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzaia zzaiaVar) {
        zzaia zzaiaVar2 = zzaiaVar;
        zzaiq zzaiqVar = new zzaiq();
        zzaiqVar.zzd(zzaiaVar2.zzc());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzaiqVar.zzb(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzaiqVar.zzg(this.zza.zza());
        }
        zzaba.zza(this.zzc, this.zzb, zzaiaVar2, zzaiqVar, this);
    }
}
