package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzj;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzade extends zzafn<Void, zzj> {
    private final MultiFactorAssertion zzv;
    private final String zzw;
    private final String zzx;
    private final String zzy;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafz
    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    public zzade(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3) {
        super(2);
        this.zzv = (MultiFactorAssertion) Preconditions.checkNotNull(multiFactorAssertion);
        this.zzw = Preconditions.checkNotEmpty(str);
        this.zzx = str2;
        this.zzy = str3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final void zzb() {
        ((zzj) this.zze).zza(this.zzj, zzacv.zza(this.zzc, this.zzk));
        zzb(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafz
    public final void zza(TaskCompletionSource taskCompletionSource, zzaet zzaetVar) {
        this.zzg = new zzafu(this, taskCompletionSource);
        zzaetVar.zza(this.zzv, this.zzw, this.zzx, this.zzy, this.zzb);
    }
}
