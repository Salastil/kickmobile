package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzos extends zzol {
    private boolean zza;

    zzos(zzpg zzpgVar) {
        super(zzpgVar);
        this.zzg.zzaf();
    }

    final boolean zzax() {
        return this.zza;
    }

    protected final void zzay() {
        if (!zzax()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzaz() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzbc();
        this.zzg.zzag();
        this.zza = true;
    }

    protected abstract boolean zzbc();
}
