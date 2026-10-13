package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcd implements zzck {
    private static final zzcf zza = new zzcf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzcg
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcf
        public final void zza(zzcd zzcdVar) {
            zzcd.zzd(zzcdVar);
        }
    };
    private final zzbt zzb;
    private final zzxh zzc;
    private final zzbv zzd;
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final zzcf zzh;

    static /* synthetic */ void zzd(zzcd zzcdVar) {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzck
    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzck
    public final zzbt zzb() {
        this.zzh.zza(this);
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzck
    public final zzbv zzc() {
        return this.zzd;
    }

    private zzcd(zzbt zzbtVar, zzxh zzxhVar, int i, boolean z, boolean z2, zzcf zzcfVar) {
        zzbv zzbvVar;
        this.zzb = zzbtVar;
        this.zzc = zzxhVar;
        int i2 = zzbz.zza[zzxhVar.ordinal()];
        if (i2 == 1) {
            zzbvVar = zzbv.zza;
        } else if (i2 == 2) {
            zzbvVar = zzbv.zzc;
        } else {
            zzbvVar = zzbv.zzb;
        }
        this.zzd = zzbvVar;
        this.zze = i;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = zzcfVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzck
    public final boolean zze() {
        return this.zzf;
    }
}
