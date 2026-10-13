package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzyn extends zzyq {
    final /* synthetic */ zzyq zza;
    final /* synthetic */ zzyq zzb;

    zzyn(zzyq zzyqVar, zzyq zzyqVar2) {
        this.zza = zzyqVar;
        this.zzb = zzyqVar2;
    }

    @Override // com.google.android.gms.internal.measurement.zzyq
    public final void zzb() {
        try {
            this.zza.zzb();
        } finally {
            this.zzb.zzb();
        }
    }
}
