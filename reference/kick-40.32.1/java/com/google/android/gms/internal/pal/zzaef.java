package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaef {
    private zzaeh zza = null;
    private zzaeg zzb = null;
    private zzaed zzc = null;
    private zzaei zzd = zzaei.zzc;

    private zzaef() {
    }

    /* synthetic */ zzaef(byte[] bArr) {
    }

    public final zzaef zza(zzaeh zzaehVar) {
        this.zza = zzaehVar;
        return this;
    }

    public final zzaef zzb(zzaeg zzaegVar) {
        this.zzb = zzaegVar;
        return this;
    }

    public final zzaef zzc(zzaed zzaedVar) {
        this.zzc = zzaedVar;
        return this;
    }

    public final zzaef zzd(zzaei zzaeiVar) {
        this.zzd = zzaeiVar;
        return this;
    }

    public final zzaej zze() throws GeneralSecurityException {
        zzaeh zzaehVar = this.zza;
        if (zzaehVar == null) {
            throw new GeneralSecurityException("HPKE KEM parameter is not set");
        }
        zzaeg zzaegVar = this.zzb;
        if (zzaegVar == null) {
            throw new GeneralSecurityException("HPKE KDF parameter is not set");
        }
        zzaed zzaedVar = this.zzc;
        if (zzaedVar == null) {
            throw new GeneralSecurityException("HPKE AEAD parameter is not set");
        }
        zzaei zzaeiVar = this.zzd;
        if (zzaeiVar != null) {
            return new zzaej(zzaehVar, zzaegVar, zzaedVar, zzaeiVar, null);
        }
        throw new GeneralSecurityException("HPKE variant is not set");
    }
}
