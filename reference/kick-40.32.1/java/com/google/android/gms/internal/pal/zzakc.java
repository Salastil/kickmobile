package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzakc {

    @Nullable
    private zzakm zza = null;

    @Nullable
    private zzars zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzakc() {
    }

    /* synthetic */ zzakc(byte[] bArr) {
    }

    public final zzakc zza(zzakm zzakmVar) {
        this.zza = zzakmVar;
        return this;
    }

    public final zzakc zzb(zzars zzarsVar) {
        this.zzb = zzarsVar;
        return this;
    }

    public final zzakc zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzakd zzd() throws GeneralSecurityException {
        zzars zzarsVar;
        zzarq zzarqVarZza;
        zzakm zzakmVar = this.zza;
        if (zzakmVar == null || (zzarsVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzakmVar.zzc() != zzarsVar.zzc()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzakmVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzakl.zzd) {
            zzarqVarZza = zzaim.zza;
        } else if (this.zza.zzf() == zzakl.zzc || this.zza.zzf() == zzakl.zzb) {
            zzarqVarZza = zzaim.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzakl.zza) {
                String strValueOf = String.valueOf(this.zza.zzf());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzarqVarZza = zzaim.zzb(this.zzc.intValue());
        }
        return new zzakd(this.zza, this.zzb, zzarqVarZza, this.zzc, null);
    }
}
