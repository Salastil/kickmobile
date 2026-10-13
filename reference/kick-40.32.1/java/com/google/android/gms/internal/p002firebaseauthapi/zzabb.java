package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import io.ktor.http.auth.AuthScheme;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabb implements zzaga<zzajm> {
    private final /* synthetic */ zzaeu zza;
    private final /* synthetic */ zzaba zzb;

    zzabb(zzaba zzabaVar, zzaeu zzaeuVar) {
        this.zza = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
        this.zzb = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zza.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzajm zzajmVar) {
        zzajm zzajmVar2 = zzajmVar;
        if (zzajmVar2.zzf()) {
            this.zza.zza(new zzaax(zzajmVar2.zzc(), zzajmVar2.zze(), null));
        } else {
            this.zzb.zza(new zzaia(zzajmVar2.zzd(), zzajmVar2.zzb(), Long.valueOf(zzajmVar2.zza()), AuthScheme.Bearer), null, null, false, null, this.zza, this);
        }
    }
}
