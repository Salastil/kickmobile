package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxg {

    @Nullable
    private zzxn zza = null;

    @Nullable
    private zzars zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzxg() {
    }

    /* synthetic */ zzxg(byte[] bArr) {
    }

    public final zzxg zza(zzxn zzxnVar) {
        this.zza = zzxnVar;
        return this;
    }

    public final zzxg zzb(zzars zzarsVar) {
        this.zzb = zzarsVar;
        return this;
    }

    public final zzxg zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzxh zzd() throws GeneralSecurityException {
        zzars zzarsVar;
        zzarq zzarqVarZzb;
        zzxn zzxnVar = this.zza;
        if (zzxnVar == null || (zzarsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzxnVar.zzc() != zzarsVar.zzc()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzxnVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zze() == zzxm.zzc) {
            zzarqVarZzb = zzaim.zza;
        } else if (this.zza.zze() == zzxm.zzb) {
            zzarqVarZzb = zzaim.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzxm.zza) {
                String strValueOf = String.valueOf(this.zza.zze());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzarqVarZzb = zzaim.zzb(this.zzc.intValue());
        }
        return new zzxh(this.zza, this.zzb, zzarqVarZzb, this.zzc, null);
    }
}
