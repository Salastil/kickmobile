package com.google.android.gms.internal.cast;

import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzac {
    final int zza;
    final long zzb = DefaultClock.getInstance().currentTimeMillis();
    private long zzc;

    public zzac(zzab zzabVar) {
        this.zza = zzabVar.zza;
    }

    public final void zza(long j) {
        this.zzc = j;
    }

    public final zzrd zzb() {
        zzrc zzrcVarZza = zzrd.zza();
        zzrcVarZza.zza((int) (this.zzb - this.zzc));
        int i = this.zza;
        int i2 = 2;
        if (i != 1) {
            if (i != 2) {
                i2 = i != 3 ? 1 : 4;
            } else {
                i2 = 3;
            }
        }
        zzrcVarZza.zzb(i2);
        return (zzrd) zzrcVarZza.zzu();
    }
}
