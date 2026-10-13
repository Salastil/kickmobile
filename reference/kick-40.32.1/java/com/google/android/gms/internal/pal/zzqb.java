package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzqb extends zzqe {
    final /* synthetic */ zzqe zza;
    final /* synthetic */ zzqe zzb;

    zzqb(zzqe zzqeVar, zzqe zzqeVar2) {
        this.zza = zzqeVar;
        this.zzb = zzqeVar2;
    }

    @Override // com.google.android.gms.internal.pal.zzqe
    public final void zzb() {
        try {
            this.zza.zzb();
        } finally {
            this.zzb.zzb();
        }
    }
}
