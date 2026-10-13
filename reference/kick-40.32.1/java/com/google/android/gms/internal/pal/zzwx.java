package com.google.android.gms.internal.pal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwx extends zzwq {
    private final zzxf zza;
    private final zzars zzb;
    private final zzars zzc;
    private final zzarq zzd;

    @Nullable
    private final Integer zze;

    /* synthetic */ zzwx(zzxf zzxfVar, zzars zzarsVar, zzars zzarsVar2, zzarq zzarqVar, Integer num, byte[] bArr) {
        this.zza = zzxfVar;
        this.zzb = zzarsVar;
        this.zzc = zzarsVar2;
        this.zzd = zzarqVar;
        this.zze = num;
    }

    public static zzww zzd() {
        return new zzww(null);
    }

    @Override // com.google.android.gms.internal.pal.zzwq, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    @Nullable
    public final Integer zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.pal.zzwq
    public final zzarq zzc() {
        return this.zzd;
    }

    public final zzars zze() {
        return this.zzb;
    }

    public final zzars zzf() {
        return this.zzc;
    }

    public final zzxf zzg() {
        return this.zza;
    }
}
