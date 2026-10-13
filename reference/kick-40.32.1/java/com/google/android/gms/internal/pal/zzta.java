package com.google.android.gms.internal.pal;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzta {
    private final zzrt zza;
    private int zzb = 0;
    private int zzc = -1;

    public zzta(zzrt zzrtVar) {
        zztf.zza(zzrtVar, RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX);
        this.zza = zzrtVar;
    }

    protected abstract void zzb(int i, int i2, zzsv zzsvVar);

    protected abstract Object zzg();

    public final zztb zzh() {
        return this.zza.zza();
    }

    public final String zzi() {
        return this.zza.zzb();
    }

    public final int zzj() {
        return this.zzc + 1;
    }

    public final void zzk(int i, int i2, zzsv zzsvVar) {
        if (zzsvVar.zzc() < 32) {
            this.zzb |= 1 << zzsvVar.zzc();
        }
        this.zzc = Math.max(this.zzc, zzsvVar.zzc());
        zzb(i, i2, zzsvVar);
    }

    public final Object zzl() {
        zzrt zzrtVar = this.zza;
        zzrtVar.zza().zzc(this);
        int i = this.zzb;
        if (((i + 1) & i) != 0 || (this.zzc > 31 && i != -1)) {
            throw zztc.zzd(String.format("unreferenced arguments [first missing index=%d]", Integer.valueOf(Integer.numberOfTrailingZeros(~i))), zzrtVar.zzb());
        }
        return zzg();
    }
}
