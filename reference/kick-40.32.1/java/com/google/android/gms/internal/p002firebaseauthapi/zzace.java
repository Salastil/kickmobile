package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import io.ktor.http.auth.AuthScheme;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzace implements zzaga<zzahh> {
    private final /* synthetic */ zzaeu zza;
    private final /* synthetic */ zzacb zzb;

    zzace(zzacb zzacbVar, zzaeu zzaeuVar) {
        this.zza = zzaeuVar;
        Objects.requireNonNull(zzacbVar);
        this.zzb = zzacbVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zza.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzahh zzahhVar) {
        zzahh zzahhVar2 = zzahhVar;
        this.zzb.zza.zza(new zzaia(zzahhVar2.zzb(), zzahhVar2.zza(), Long.valueOf(zzaic.zza(zzahhVar2.zza())), AuthScheme.Bearer), null, null, false, null, this.zza, this);
    }
}
