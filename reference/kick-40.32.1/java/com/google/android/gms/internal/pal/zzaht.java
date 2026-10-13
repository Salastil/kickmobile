package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaht extends zzvz {
    private final zzaje zza;

    public zzaht(zzaje zzajeVar, @Nullable zzwm zzwmVar) throws GeneralSecurityException {
        this.zza = zzajeVar;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    public final zzwk zza() {
        zzaje zzajeVar = this.zza;
        return new zzahs(zzajeVar.zze(), zzajeVar.zzb(), null);
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    @Nullable
    public final Integer zzb() {
        return this.zza.zzc();
    }

    public final zzaje zzc(@Nullable zzwm zzwmVar) throws GeneralSecurityException {
        return this.zza;
    }

    public final zzarq zzd() throws GeneralSecurityException {
        zzaje zzajeVar = this.zza;
        if (zzajeVar.zzb().equals(zzapm.RAW)) {
            return zzarq.zza(new byte[0]);
        }
        if (zzajeVar.zzb().equals(zzapm.TINK)) {
            return zzaim.zzb(zzajeVar.zzc().intValue());
        }
        if (zzajeVar.zzb().equals(zzapm.LEGACY) || zzajeVar.zzb().equals(zzapm.CRUNCHY)) {
            return zzaim.zza(zzajeVar.zzc().intValue());
        }
        throw new GeneralSecurityException("Unknown output prefix type");
    }
}
