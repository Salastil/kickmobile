package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwd {
    private static final zzwc zzf = zzwc.zza;
    private final zzvz zza;
    private final zzwb zzb;
    private final int zzc;
    private final boolean zzd;
    private final boolean zze;
    private final int zzg;

    /* synthetic */ zzwd(zzvz zzvzVar, int i, int i2, boolean z, boolean z2, zzwc zzwcVar, byte[] bArr) {
        this.zza = zzvzVar;
        this.zzg = i;
        int i3 = i - 2;
        this.zzb = i3 != 1 ? i3 != 3 ? zzwb.zzb : zzwb.zzc : zzwb.zza;
        this.zzc = i2;
        this.zzd = z;
        this.zze = z2;
    }

    public final zzvz zza() {
        return this.zza;
    }

    public final zzwb zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzd;
    }

    final /* synthetic */ boolean zze() {
        return this.zze;
    }

    final /* synthetic */ int zzg() {
        return this.zzg;
    }
}
