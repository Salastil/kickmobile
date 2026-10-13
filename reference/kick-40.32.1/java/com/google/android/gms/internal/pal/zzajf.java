package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajf implements zzaji {
    private final zzarq zza;
    private final zzaot zzb;

    private zzajf(zzaot zzaotVar, zzarq zzarqVar) {
        this.zzb = zzaotVar;
        this.zza = zzarqVar;
    }

    public static zzajf zza(zzaot zzaotVar) {
        return new zzajf(zzaotVar, zzajp.zza(zzaotVar.zza()));
    }

    public static zzajf zzb(zzaot zzaotVar) throws GeneralSecurityException {
        return new zzajf(zzaotVar, zzajp.zzb(zzaotVar.zza()));
    }

    public final zzaot zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzaji
    public final zzarq zzd() {
        return this.zza;
    }
}
