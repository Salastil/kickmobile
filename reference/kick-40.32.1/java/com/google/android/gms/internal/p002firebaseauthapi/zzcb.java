package com.google.android.gms.internal.p002firebaseauthapi;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcb {
    private boolean zza;
    private zzbv zzb;

    @Nullable
    private final zzcs zzc;
    private zzce zzd;

    @Nullable
    private zzcc zze;

    public final zzcb zza() {
        zzcc zzccVar = this.zze;
        if (zzccVar != null) {
            zzccVar.zzb();
        }
        this.zza = true;
        return this;
    }

    public final zzcb zzb() {
        this.zzd = zzce.zza;
        return this;
    }

    private zzcb(zzcs zzcsVar) {
        this.zzb = zzbv.zza;
        this.zzd = null;
        this.zze = null;
        this.zzc = zzcsVar;
    }
}
