package com.google.android.gms.internal.pal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajr extends zzako {
    private final zzajy zza;
    private final zzars zzb;
    private final zzarq zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzajr(zzajy zzajyVar, zzars zzarsVar, zzarq zzarqVar, Integer num, byte[] bArr) {
        this.zza = zzajyVar;
        this.zzb = zzarsVar;
        this.zzc = zzarqVar;
        this.zzd = num;
    }

    public static zzajq zzc() {
        return new zzajq(null);
    }

    @Override // com.google.android.gms.internal.pal.zzako, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    public final zzars zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzako
    public final zzarq zze() {
        return this.zzc;
    }

    public final zzajy zzf() {
        return this.zza;
    }
}
