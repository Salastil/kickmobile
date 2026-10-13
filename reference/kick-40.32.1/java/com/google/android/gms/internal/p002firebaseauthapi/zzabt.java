package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabt implements zzaga<zzaji> {
    private final /* synthetic */ zzaeu zza;
    private final /* synthetic */ zzaga zzb;
    private final /* synthetic */ zzabu zzc;

    zzabt(zzabu zzabuVar, zzaeu zzaeuVar, zzaga zzagaVar) {
        this.zza = zzaeuVar;
        this.zzb = zzagaVar;
        Objects.requireNonNull(zzabuVar);
        this.zzc = zzabuVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zzb.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzaji zzajiVar) {
        zzaba.zza(this.zzc.zza, zzajiVar, this.zza, this);
    }
}
