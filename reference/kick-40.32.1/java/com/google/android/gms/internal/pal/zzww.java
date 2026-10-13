package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzww {

    @Nullable
    private zzxf zza = null;

    @Nullable
    private zzars zzb = null;

    @Nullable
    private zzars zzc = null;

    @Nullable
    private Integer zzd = null;

    private zzww() {
    }

    /* synthetic */ zzww(byte[] bArr) {
    }

    public final zzww zza(zzxf zzxfVar) {
        this.zza = zzxfVar;
        return this;
    }

    public final zzww zzb(zzars zzarsVar) {
        this.zzb = zzarsVar;
        return this;
    }

    public final zzww zzc(zzars zzarsVar) {
        this.zzc = zzarsVar;
        return this;
    }

    public final zzww zzd(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzwx zze() throws GeneralSecurityException {
        zzarq zzarqVarZzb;
        zzxf zzxfVar = this.zza;
        if (zzxfVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        zzars zzarsVar = this.zzb;
        if (zzarsVar == null || this.zzc == null) {
            throw new GeneralSecurityException("Cannot build without key material");
        }
        if (zzxfVar.zzc() != zzarsVar.zzc()) {
            throw new GeneralSecurityException("AES key size mismatch");
        }
        if (zzxfVar.zzd() != this.zzc.zzc()) {
            throw new GeneralSecurityException("HMAC key size mismatch");
        }
        if (this.zza.zza() && this.zzd == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzd != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzg() == zzxe.zzc) {
            zzarqVarZzb = zzaim.zza;
        } else if (this.zza.zzg() == zzxe.zzb) {
            zzarqVarZzb = zzaim.zza(this.zzd.intValue());
        } else {
            if (this.zza.zzg() != zzxe.zza) {
                String strValueOf = String.valueOf(this.zza.zzg());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzarqVarZzb = zzaim.zzb(this.zzd.intValue());
        }
        return new zzwx(this.zza, this.zzb, this.zzc, zzarqVarZzb, this.zzd, null);
    }
}
