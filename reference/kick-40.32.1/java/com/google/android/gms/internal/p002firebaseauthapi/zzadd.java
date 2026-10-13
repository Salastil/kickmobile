package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzad;
import com.google.firebase.auth.internal.zzj;
import com.google.firebase.auth.internal.zzx;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzadd extends zzafn<AuthResult, zzj> {
    private final MultiFactorAssertion zzv;
    private final String zzw;
    private final String zzx;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafz
    public final String zza() {
        return "finalizeMfaSignIn";
    }

    public zzadd(MultiFactorAssertion multiFactorAssertion, String str, String str2) {
        super(2);
        this.zzv = (MultiFactorAssertion) Preconditions.checkNotNull(multiFactorAssertion);
        this.zzw = Preconditions.checkNotEmpty(str);
        this.zzx = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final void zzb() {
        zzad zzadVarZza = zzacv.zza(this.zzc, this.zzk);
        if (this.zzd == null || this.zzd.getUid().equalsIgnoreCase(zzadVarZza.getUid())) {
            ((zzj) this.zze).zza(this.zzj, zzadVarZza);
            zzb(new zzx(zzadVarZza));
        } else {
            zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafz
    public final void zza(TaskCompletionSource taskCompletionSource, zzaet zzaetVar) {
        this.zzg = new zzafu(this, taskCompletionSource);
        zzaetVar.zza(this.zzw, this.zzv, this.zzx, this.zzb);
    }
}
