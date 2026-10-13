package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import io.ktor.http.auth.AuthScheme;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabr implements zzaga<zzajo> {
    private final /* synthetic */ zzaeu zza;
    private final /* synthetic */ zzaga zzb;
    private final /* synthetic */ zzabs zzc;

    zzabr(zzabs zzabsVar, zzaeu zzaeuVar, zzaga zzagaVar) {
        this.zza = zzaeuVar;
        this.zzb = zzagaVar;
        Objects.requireNonNull(zzabsVar);
        this.zzc = zzabsVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zzb.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzajo zzajoVar) {
        zzajo zzajoVar2 = zzajoVar;
        if (!TextUtils.isEmpty(zzajoVar2.zze())) {
            this.zza.zza(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zzb(zzajoVar2.zzc(), zzajoVar2.zze()));
        } else {
            this.zzc.zza.zza(new zzaia(zzajoVar2.zzd(), zzajoVar2.zzb(), Long.valueOf(zzajoVar2.zza()), AuthScheme.Bearer), null, "phone", Boolean.valueOf(zzajoVar2.zzf()), null, this.zza, this.zzb);
        }
    }
}
