package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import io.ktor.http.auth.AuthScheme;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabm implements zzaga<zzajk> {
    private final /* synthetic */ zzaeu zza;
    private final /* synthetic */ zzaba zzb;

    zzabm(zzaba zzabaVar, zzaeu zzaeuVar) {
        this.zza = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
        this.zzb = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zza.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzajk zzajkVar) {
        zzajk zzajkVar2 = zzajkVar;
        this.zzb.zza(new zzaia(zzajkVar2.zzc(), zzajkVar2.zzb(), Long.valueOf(zzajkVar2.zza()), AuthScheme.Bearer), null, null, Boolean.valueOf(zzajkVar2.zzd()), null, this.zza, this);
    }
}
