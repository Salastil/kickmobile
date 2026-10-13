package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabs implements zzaga<zzaia> {
    final /* synthetic */ zzaba zza;
    private final /* synthetic */ zzajp zzb;
    private final /* synthetic */ zzaeu zzc;

    zzabs(zzaba zzabaVar, zzajp zzajpVar, zzaeu zzaeuVar) {
        this.zzb = zzajpVar;
        this.zzc = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
        this.zza = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zzc.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzaia zzaiaVar) {
        this.zzb.zza(zzaiaVar.zzc());
        this.zza.zza.zza(this.zzb, new zzabr(this, this.zzc, this));
    }
}
