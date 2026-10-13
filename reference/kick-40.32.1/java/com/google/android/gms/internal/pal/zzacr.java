package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzacr {

    @Nullable
    private zzacz zza = null;

    @Nullable
    private zzars zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzacr() {
    }

    /* synthetic */ zzacr(byte[] bArr) {
    }

    public final zzacr zza(zzacz zzaczVar) {
        this.zza = zzaczVar;
        return this;
    }

    public final zzacr zzb(zzars zzarsVar) {
        this.zzb = zzarsVar;
        return this;
    }

    public final zzacr zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzacs zzd() throws GeneralSecurityException {
        zzars zzarsVar;
        zzarq zzarqVarZzb;
        zzacz zzaczVar = this.zza;
        if (zzaczVar == null || (zzarsVar = this.zzb) == null) {
            throw new IllegalArgumentException("Cannot build without parameters and/or key material");
        }
        if (zzaczVar.zzc() != zzarsVar.zzc()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzaczVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzacy.zzc) {
            zzarqVarZzb = zzaim.zza;
        } else if (this.zza.zzd() == zzacy.zzb) {
            zzarqVarZzb = zzaim.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzacy.zza) {
                String strValueOf = String.valueOf(this.zza.zzd());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesSivParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzarqVarZzb = zzaim.zzb(this.zzc.intValue());
        }
        return new zzacs(this.zza, this.zzb, zzarqVarZzb, this.zzc, null);
    }
}
