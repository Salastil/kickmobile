package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfp extends zzdm {
    private final zzfo zza;
    private final zzaau zzb;

    @Nullable
    private final Integer zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzfo) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzdo zza() {
        return this.zza;
    }

    public static zzfp zza(zzfo zzfoVar, @Nullable Integer num) throws GeneralSecurityException {
        zzaau zzaauVarZzb;
        if (zzfoVar.zzc() == zzfo.zzc.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzaauVarZzb = zzpj.zza;
        } else {
            if (zzfoVar.zzc() != zzfo.zzc.zza) {
                throw new GeneralSecurityException("Unknown Variant: " + String.valueOf(zzfoVar.zzc()));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzaauVarZzb = zzpj.zzb(num.intValue());
        }
        return new zzfp(zzfoVar, zzaauVarZzb, num);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzdm
    public final zzaau zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final Integer zzb() {
        return this.zzc;
    }

    private zzfp(zzfo zzfoVar, zzaau zzaauVar, @Nullable Integer num) {
        this.zza = zzfoVar;
        this.zzb = zzaauVar;
        this.zzc = num;
    }
}
