package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdb implements zzcy {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcy
    public final zzbt zza(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        return !zzpfVarZza.zza(zzctVar) ? new zzon(zzctVar, zzddVar) : zzpfVarZza.zza(zzctVar, zzddVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcy
    public final zzct zza(zzbt zzbtVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        return zzpf.zza().zza(zzbtVar, zzddVar);
    }

    private zzdb() {
    }
}
