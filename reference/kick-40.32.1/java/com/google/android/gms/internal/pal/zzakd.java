package com.google.android.gms.internal.pal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzakd extends zzako {
    private final zzakm zza;
    private final zzars zzb;
    private final zzarq zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzakd(zzakm zzakmVar, zzars zzarsVar, zzarq zzarqVar, Integer num, byte[] bArr) {
        this.zza = zzakmVar;
        this.zzb = zzarsVar;
        this.zzc = zzarqVar;
        this.zzd = num;
    }

    public static zzakc zzc() {
        return new zzakc(null);
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

    public final zzakm zzf() {
        return this.zza;
    }
}
