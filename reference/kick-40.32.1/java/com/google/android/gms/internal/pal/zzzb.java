package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzb extends zzwq {
    private final zzzf zza;
    private final zzarq zzb;

    @Nullable
    private final Integer zzc;

    private zzzb(zzzf zzzfVar, zzarq zzarqVar, @Nullable Integer num) {
        this.zza = zzzfVar;
        this.zzb = zzarqVar;
        this.zzc = num;
    }

    public static zzzb zzd(zzzf zzzfVar, @Nullable Integer num) throws GeneralSecurityException {
        zzarq zzarqVarZzb;
        if (zzzfVar.zzc() == zzze.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzarqVarZzb = zzaim.zza;
        } else {
            if (zzzfVar.zzc() != zzze.zza) {
                String strValueOf = String.valueOf(zzzfVar.zzc());
                String.valueOf(strValueOf);
                throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(strValueOf)));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzarqVarZzb = zzaim.zzb(num.intValue());
        }
        return new zzzb(zzzfVar, zzarqVarZzb, num);
    }

    @Override // com.google.android.gms.internal.pal.zzwq, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    public final Integer zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzwq
    public final zzarq zzc() {
        return this.zzb;
    }

    public final zzzf zze() {
        return this.zza;
    }
}
