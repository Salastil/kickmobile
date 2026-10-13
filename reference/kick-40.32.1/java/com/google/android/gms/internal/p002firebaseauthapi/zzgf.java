package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgf extends zzdm {
    private final zzgj zza;
    private final zzaav zzb;
    private final zzaau zzc;

    @Nullable
    private final Integer zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzgj) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzdo zza() {
        return this.zza;
    }

    public static zzgf zza(zzgj zzgjVar, zzaav zzaavVar, @Nullable Integer num) throws GeneralSecurityException {
        zzaau zzaauVarZzb;
        if (zzgjVar.zzc() != zzgj.zza.zzb && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzgjVar.zzc()) + " the value of idRequirement must be non-null");
        }
        if (zzgjVar.zzc() == zzgj.zza.zzb && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzaavVar.zza() != 32) {
            throw new GeneralSecurityException("XAesGcmKey key must be constructed with key of length 32 bytes, not " + zzaavVar.zza());
        }
        if (zzgjVar.zzc() == zzgj.zza.zzb) {
            zzaauVarZzb = zzpj.zza;
        } else if (zzgjVar.zzc() == zzgj.zza.zza) {
            zzaauVarZzb = zzpj.zzb(num.intValue());
        } else {
            throw new IllegalStateException("Unknown Variant: " + String.valueOf(zzgjVar.zzc()));
        }
        return new zzgf(zzgjVar, zzaavVar, zzaauVarZzb, num);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm
    public final zzaau zzd() {
        return this.zzc;
    }

    public final zzaav zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    private zzgf(zzgj zzgjVar, zzaav zzaavVar, zzaau zzaauVar, @Nullable Integer num) {
        this.zza = zzgjVar;
        this.zzb = zzaavVar;
        this.zzc = zzaauVar;
        this.zzd = num;
    }
}
