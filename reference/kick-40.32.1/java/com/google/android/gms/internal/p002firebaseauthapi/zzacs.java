package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzacs implements zzaga<zzaia> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzaeu zzb;
    private final /* synthetic */ zzaba zzc;

    zzacs(zzaba zzabaVar, String str, zzaeu zzaeuVar) {
        this.zza = str;
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
        zzaiqVar.zzd(zzaiaVar2.zzc()).zzc(this.zza);
        zzaba.zza(this.zzc, this.zzb, zzaiaVar2, zzaiqVar, this);
    }
}
