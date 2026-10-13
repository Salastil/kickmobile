package com.google.android.gms.internal.pal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxp extends zzwq {
    private final zzxw zza;
    private final zzars zzb;
    private final zzarq zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzxp(zzxw zzxwVar, zzars zzarsVar, zzarq zzarqVar, Integer num, byte[] bArr) {
        this.zza = zzxwVar;
        this.zzb = zzarsVar;
        this.zzc = zzarqVar;
        this.zzd = num;
    }

    public static zzxo zzd() {
        return new zzxo(null);
    }

    @Override // com.google.android.gms.internal.pal.zzwq, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzvz
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.pal.zzwq
    public final zzarq zzc() {
        return this.zzc;
    }

    public final zzars zze() {
        return this.zzb;
    }

    public final zzxw zzf() {
        return this.zza;
    }
}
