package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxx {

    @Nullable
    private zzyf zza = null;

    @Nullable
    private zzars zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzxx() {
    }

    /* synthetic */ zzxx(byte[] bArr) {
    }

    public final zzxx zza(zzyf zzyfVar) {
        this.zza = zzyfVar;
        return this;
    }

    public final zzxx zzb(zzars zzarsVar) {
        this.zzb = zzarsVar;
        return this;
    }

    public final zzxx zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzxy zzd() throws GeneralSecurityException {
        zzars zzarsVar;
        zzarq zzarqVarZzb;
        zzyf zzyfVar = this.zza;
        if (zzyfVar == null || (zzarsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzyfVar.zzc() != zzarsVar.zzc()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzyfVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzye.zzc) {
            zzarqVarZzb = zzaim.zza;
        } else if (this.zza.zzd() == zzye.zzb) {
            zzarqVarZzb = zzaim.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzye.zza) {
                String strValueOf = String.valueOf(this.zza.zzd());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzarqVarZzb = zzaim.zzb(this.zzc.intValue());
        }
        return new zzxy(this.zza, this.zzb, zzarqVarZzb, this.zzc, null);
    }
}
