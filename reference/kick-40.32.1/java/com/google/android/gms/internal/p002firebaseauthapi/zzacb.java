package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzacb implements zzaga<zzaia> {
    final /* synthetic */ zzaba zza;
    private final /* synthetic */ zzahe zzb;
    private final /* synthetic */ zzaeu zzc;

    zzacb(zzaba zzabaVar, zzahe zzaheVar, zzaeu zzaeuVar) {
        this.zzb = zzaheVar;
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
        this.zza.zza.zza(this.zzb, new zzace(this, this.zzc));
    }
}
