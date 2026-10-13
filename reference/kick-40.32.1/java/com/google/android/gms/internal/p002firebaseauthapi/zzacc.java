package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzacc implements zzaga<zzaiw> {
    private final /* synthetic */ zzaix zza;
    private final /* synthetic */ zzaeu zzb;

    zzacc(zzaba zzabaVar, zzaix zzaixVar, zzaeu zzaeuVar) {
        this.zza = zzaixVar;
        this.zzb = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zzb.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzaiw zzaiwVar) {
        zzaiw zzaiwVar2 = zzaiwVar;
        zzaix zzaixVar = this.zza;
        if (zzaixVar instanceof zzajb) {
            this.zzb.zzb(zzaiwVar2.zza());
            return;
        }
        if (zzaixVar instanceof zzajd) {
            this.zzb.zza(zzaiwVar2);
            return;
        }
        throw new IllegalArgumentException("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was " + this.zza.getClass().getName() + ".");
    }
}
