package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabq implements zzaga<zzaia> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzaeu zze;
    private final /* synthetic */ zzaba zzf;

    zzabq(zzaba zzabaVar, String str, String str2, String str3, String str4, zzaeu zzaeuVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
        this.zzf = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zze.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzaia zzaiaVar) {
        zzaba.zza(this.zzf, this.zze, new zzaiv(this.zza, this.zzb, null, this.zzc, this.zzd, zzaiaVar.zzc()), this);
    }
}
