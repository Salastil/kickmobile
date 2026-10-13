package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzqr {
    private final boolean zza;
    private final int zzb;
    private final int zzc;

    zzqr() {
        this.zzb = 2;
        this.zzc = 2;
        this.zza = true;
    }

    zzqr(int i) {
        this.zzb = 2;
        this.zzc = i;
        this.zza = false;
    }

    zzqr(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zza = false;
    }

    final zzmd zza() {
        if (this.zza) {
            return zzmd.zzb();
        }
        int i = this.zzb;
        zzmc zzmcVarZza = zzmd.zza();
        zzmcVarZza.zza(i);
        zzmcVarZza.zzb(this.zzc);
        return (zzmd) zzmcVarZza.zzbd();
    }

    final int zzb() {
        return this.zzc;
    }

    final /* synthetic */ int zzc() {
        return this.zzb;
    }
}
