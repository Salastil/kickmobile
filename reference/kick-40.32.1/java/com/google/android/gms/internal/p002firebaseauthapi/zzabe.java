package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabe implements zzaga<zzaia> {
    private final /* synthetic */ EmailAuthCredential zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzaeu zzc;
    private final /* synthetic */ zzaba zzd;

    zzabe(zzaba zzabaVar, EmailAuthCredential emailAuthCredential, String str, zzaeu zzaeuVar) {
        this.zza = emailAuthCredential;
        this.zzb = str;
        this.zzc = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
        this.zzd = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zzc.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzaia zzaiaVar) {
        this.zzd.zza(new zzahc(this.zza, zzaiaVar.zzc(), this.zzb), this.zzc);
    }
}
