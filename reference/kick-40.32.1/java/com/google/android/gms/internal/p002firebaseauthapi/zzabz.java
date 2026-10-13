package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabz implements zzaga<zzaji> {
    private final /* synthetic */ zzaeu zza;
    private final /* synthetic */ zzaba zzb;

    zzabz(zzaba zzabaVar, zzaeu zzaeuVar) {
        this.zza = zzaeuVar;
        Objects.requireNonNull(zzabaVar);
        this.zzb = zzabaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zza.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzaji zzajiVar) {
        zzaji zzajiVar2 = zzajiVar;
        if (!zzajiVar2.zzl()) {
            zzaba.zza(this.zzb, zzajiVar2, this.zza, this);
        } else {
            this.zza.zza(new zzaax(zzajiVar2.zzf(), zzajiVar2.zzk(), zzajiVar2.zzb()));
        }
    }
}
