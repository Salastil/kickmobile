package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabg implements zzaga<zzahq> {
    private final /* synthetic */ zzagb zza;
    private final /* synthetic */ zzaeu zzb;
    private final /* synthetic */ zzaia zzc;
    private final /* synthetic */ zzaiq zzd;
    private final /* synthetic */ zzaba zze;

    zzabg(zzaba zzabaVar, zzagb zzagbVar, zzaeu zzaeuVar, zzaia zzaiaVar, zzaiq zzaiqVar) {
        this.zza = zzagbVar;
        this.zzb = zzaeuVar;
        this.zzc = zzaiaVar;
        this.zzd = zzaiqVar;
        Objects.requireNonNull(zzabaVar);
        this.zze = zzabaVar;
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
            zzaba.zza(this.zze, this.zzb, this.zzc, listZza.get(0), this.zzd, this.zza);
        }
    }
}
