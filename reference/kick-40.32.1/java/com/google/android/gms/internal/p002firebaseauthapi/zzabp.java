package com.google.android.gms.internal.p002firebaseauthapi;

import io.ktor.http.auth.AuthScheme;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabp implements zzaga<zzaiu> {
    private final /* synthetic */ zzaeu zza;
    private final /* synthetic */ zzagb zzb;
    private final /* synthetic */ zzaba zzc;

    zzabp(zzaba zzabaVar, zzaeu zzaeuVar, zzagb zzagbVar) {
        this.zza = zzaeuVar;
        this.zzb = zzagbVar;
        Objects.requireNonNull(zzabaVar);
        this.zzc = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zzb.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzaiu zzaiuVar) {
        zzaiu zzaiuVar2 = zzaiuVar;
        this.zzc.zza(new zzaia(zzaiuVar2.zzc(), zzaiuVar2.zzb(), Long.valueOf(zzaiuVar2.zza()), AuthScheme.Bearer), null, "password", false, null, this.zza, this);
    }
}
