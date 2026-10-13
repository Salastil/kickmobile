package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabv implements zzaga<zzaia> {
    final /* synthetic */ zzaba zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzaeu zzc;

    zzabv(zzaba zzabaVar, String str, zzaeu zzaeuVar) {
        this.zzb = str;
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
        zzaia zzaiaVar2 = zzaiaVar;
        this.zza.zza.zza(new zzahr(zzaiaVar2.zzc()), new zzaby(this, this, zzaiaVar2, this.zzb, this.zzc));
    }
}
