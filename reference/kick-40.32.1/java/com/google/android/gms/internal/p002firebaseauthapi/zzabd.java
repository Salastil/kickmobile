package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import io.ktor.http.auth.AuthScheme;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabd implements zzaga<zzahf> {
    private final /* synthetic */ zzaeu zza;
    private final /* synthetic */ zzaba zzb;

    zzabd(zzaba zzabaVar, zzaeu zzaeuVar) {
        this.zza = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
        this.zzb = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zza.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzahf zzahfVar) {
        zzahf zzahfVar2 = zzahfVar;
        if (zzahfVar2.zzf()) {
            this.zza.zza(new zzaax(zzahfVar2.zzc(), zzahfVar2.zze(), null));
        } else {
            this.zzb.zza(new zzaia(zzahfVar2.zzd(), zzahfVar2.zzb(), Long.valueOf(zzahfVar2.zza()), AuthScheme.Bearer), null, null, Boolean.valueOf(zzahfVar2.zzg()), null, this.zza, this);
        }
    }
}
