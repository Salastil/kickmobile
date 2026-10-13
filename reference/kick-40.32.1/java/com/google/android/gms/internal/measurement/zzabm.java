package com.google.android.gms.internal.measurement;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzabm {
    private final zzaaf zza;
    private int zzb = 0;
    private int zzc = -1;

    public zzabm(zzaaf zzaafVar) {
        zzabr.zza(zzaafVar, RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX);
        this.zza = zzaafVar;
    }

    protected abstract void zzb(int i, int i2, zzabh zzabhVar);

    protected abstract Object zzg();

    public final zzabn zzh() {
        return this.zza.zza();
    }

    public final String zzi() {
        return this.zza.zzb();
    }

    public final int zzj() {
        return this.zzc + 1;
    }

    public final void zzk(int i, int i2, zzabh zzabhVar) {
        if (zzabhVar.zzc() < 32) {
            this.zzb |= 1 << zzabhVar.zzc();
        }
        this.zzc = Math.max(this.zzc, zzabhVar.zzc());
        zzb(i, i2, zzabhVar);
    }

    public final Object zzl() {
        zzaaf zzaafVar = this.zza;
        zzaafVar.zza().zzc(this);
        int i = this.zzb;
        if (((i + 1) & i) != 0 || (this.zzc > 31 && i != -1)) {
            throw zzabo.zzd(String.format("unreferenced arguments [first missing index=%d]", Integer.valueOf(Integer.numberOfTrailingZeros(~i))), zzaafVar.zzb());
        }
        return zzg();
    }
}
