package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzqw extends zzqx {
    static final zzqw zza = new zzqw();

    private zzqw() {
    }

    @Override // com.google.android.gms.internal.pal.zzqx
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.pal.zzqx
    public final zzpz zzb(int i) {
        throw new IndexOutOfBoundsException("cannot read from empty metadata");
    }

    @Override // com.google.android.gms.internal.pal.zzqx
    public final Object zzc(int i) {
        throw new IndexOutOfBoundsException("cannot read from empty metadata");
    }

    @Override // com.google.android.gms.internal.pal.zzqx
    public final Object zzd(zzpz zzpzVar) {
        return null;
    }
}
