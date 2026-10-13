package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgl extends zzdm {
    private final zzgq zza;
    private final zzaav zzb;
    private final zzaau zzc;

    @Nullable
    private final Integer zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzgq) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzdo zza() {
        return this.zza;
    }

    public static zzgl zza(zzgq.zza zzaVar, zzaav zzaavVar, @Nullable Integer num) throws GeneralSecurityException {
        zzaau zzaauVarZzb;
        if (zzaVar != zzgq.zza.zzc && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzaVar) + " the value of idRequirement must be non-null");
        }
        if (zzaVar == zzgq.zza.zzc && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzaavVar.zza() != 32) {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzaavVar.zza());
        }
        zzgq zzgqVarZza = zzgq.zza(zzaVar);
        if (zzgqVarZza.zzb() == zzgq.zza.zzc) {
            zzaauVarZzb = zzpj.zza;
        } else if (zzgqVarZza.zzb() == zzgq.zza.zzb) {
            zzaauVarZzb = zzpj.zza(num.intValue());
        } else if (zzgqVarZza.zzb() == zzgq.zza.zza) {
            zzaauVarZzb = zzpj.zzb(num.intValue());
        } else {
            throw new IllegalStateException("Unknown Variant: " + String.valueOf(zzgqVarZza.zzb()));
        }
        return new zzgl(zzgqVarZza, zzaavVar, zzaauVarZzb, num);
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

    private zzgl(zzgq zzgqVar, zzaav zzaavVar, zzaau zzaauVar, @Nullable Integer num) {
        this.zza = zzgqVar;
        this.zzb = zzaavVar;
        this.zzc = zzaauVar;
        this.zzd = num;
    }
}
