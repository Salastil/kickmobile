package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsx extends zzsy {
    private final zzsw zza;
    private final zzaav zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzsy, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzsw) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    @Nullable
    public final Integer zzb() {
        return null;
    }

    public static zzsx zza(zzsw zzswVar, zzaav zzaavVar) throws GeneralSecurityException {
        if (zzswVar.zzb() == zzaavVar.zza()) {
            return new zzsx(zzswVar, zzaavVar);
        }
        throw new GeneralSecurityException("Key size mismatch");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzsy
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zztb zza() {
        return this.zza;
    }

    public final zzaav zzd() {
        return this.zzb;
    }

    private zzsx(zzsw zzswVar, zzaav zzaavVar) {
        this.zza = zzswVar;
        this.zzb = zzaavVar;
    }
}
