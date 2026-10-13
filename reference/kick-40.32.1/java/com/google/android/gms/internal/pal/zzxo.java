package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxo {

    @Nullable
    private zzxw zza = null;

    @Nullable
    private zzars zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzxo() {
    }

    /* synthetic */ zzxo(byte[] bArr) {
    }

    public final zzxo zza(zzxw zzxwVar) {
        this.zza = zzxwVar;
        return this;
    }

    public final zzxo zzb(zzars zzarsVar) {
        this.zzb = zzarsVar;
        return this;
    }

    public final zzxo zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzxp zzd() throws GeneralSecurityException {
        zzars zzarsVar;
        zzarq zzarqVarZzb;
        zzxw zzxwVar = this.zza;
        if (zzxwVar == null || (zzarsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzxwVar.zzc() != zzarsVar.zzc()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzxwVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzxv.zzc) {
            zzarqVarZzb = zzaim.zza;
        } else if (this.zza.zzd() == zzxv.zzb) {
            zzarqVarZzb = zzaim.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzxv.zza) {
                String strValueOf = String.valueOf(this.zza.zzd());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzarqVarZzb = zzaim.zzb(this.zzc.intValue());
        }
        return new zzxp(this.zza, this.zzb, zzarqVarZzb, this.zzc, null);
    }
}
