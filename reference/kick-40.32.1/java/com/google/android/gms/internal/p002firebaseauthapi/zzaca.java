package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.internal.zzaq;
import io.ktor.http.auth.AuthScheme;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaca implements zzaga<zzajq> {
    private final /* synthetic */ zzaeu zza;
    private final /* synthetic */ zzabx zzb;

    zzaca(zzabx zzabxVar, zzaeu zzaeuVar) {
        this.zza = zzaeuVar;
        Objects.requireNonNull(zzabxVar);
        this.zzb = zzabxVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zza.zza(zzaq.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzajq zzajqVar) {
        zzajq zzajqVar2 = zzajqVar;
        if (TextUtils.isEmpty(zzajqVar2.zza()) || TextUtils.isEmpty(zzajqVar2.zzb())) {
            this.zza.zza(zzaq.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        this.zzb.zza.zza(new zzaia(zzajqVar2.zzb(), zzajqVar2.zza(), Long.valueOf(zzaic.zza(zzajqVar2.zza())), AuthScheme.Bearer), null, null, false, null, this.zza, this);
    }
}
