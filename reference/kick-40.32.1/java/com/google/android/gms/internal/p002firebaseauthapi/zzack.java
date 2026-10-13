package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzack implements zzaga<zzahq> {
    private final /* synthetic */ zzaga zza;
    private final /* synthetic */ zzaeu zzb;
    private final /* synthetic */ zzaia zzc;

    zzack(zzach zzachVar, zzaga zzagaVar, zzaeu zzaeuVar, zzaia zzaiaVar) {
        this.zza = zzagaVar;
        this.zzb = zzaeuVar;
        this.zzc = zzaiaVar;
        Objects.requireNonNull(zzachVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzahq zzahqVar) {
        List<zzaht> listZza = zzahqVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzb.zza(this.zzc, listZza.get(0));
        }
    }
}
