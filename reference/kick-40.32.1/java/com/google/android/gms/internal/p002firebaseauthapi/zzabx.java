package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabx implements zzaga<zzaia> {
    final /* synthetic */ zzaba zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzaeu zzd;

    zzabx(zzaba zzabaVar, String str, String str2, zzaeu zzaeuVar) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
        this.zza = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zzd.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzaia zzaiaVar) {
        this.zza.zza.zza(new zzajr(zzaiaVar.zzc(), this.zzb, this.zzc), new zzaca(this, this.zzd));
    }
}
