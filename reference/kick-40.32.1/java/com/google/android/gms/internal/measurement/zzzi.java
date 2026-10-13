package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzzi extends zzzj {
    static final zzzi zza = new zzzi();

    private zzzi() {
    }

    @Override // com.google.android.gms.internal.measurement.zzzj
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzzj
    public final zzyl zzb(int i) {
        throw new IndexOutOfBoundsException("cannot read from empty metadata");
    }

    @Override // com.google.android.gms.internal.measurement.zzzj
    public final Object zzc(int i) {
        throw new IndexOutOfBoundsException("cannot read from empty metadata");
    }

    @Override // com.google.android.gms.internal.measurement.zzzj
    public final Object zzd(zzyl zzylVar) {
        return null;
    }
}
