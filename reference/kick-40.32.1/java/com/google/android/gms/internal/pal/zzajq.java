package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajq {

    @Nullable
    private zzajy zza = null;

    @Nullable
    private zzars zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzajq() {
    }

    /* synthetic */ zzajq(byte[] bArr) {
    }

    public final zzajq zza(zzajy zzajyVar) {
        this.zza = zzajyVar;
        return this;
    }

    public final zzajq zzb(zzars zzarsVar) throws GeneralSecurityException {
        this.zzb = zzarsVar;
        return this;
    }

    public final zzajq zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzajr zzd() throws GeneralSecurityException {
        zzars zzarsVar;
        zzarq zzarqVarZza;
        zzajy zzajyVar = this.zza;
        if (zzajyVar == null || (zzarsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzajyVar.zzc() != zzarsVar.zzc()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzajyVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzajx.zzd) {
            zzarqVarZza = zzaim.zza;
        } else if (this.zza.zzf() == zzajx.zzc || this.zza.zzf() == zzajx.zzb) {
            zzarqVarZza = zzaim.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzajx.zza) {
                String strValueOf = String.valueOf(this.zza.zzf());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzarqVarZza = zzaim.zzb(this.zzc.intValue());
        }
        return new zzajr(this.zza, this.zzb, zzarqVarZza, this.zzc, null);
    }
}
