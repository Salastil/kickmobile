package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdj implements zzjs {
    final /* synthetic */ zzjc zza;

    zzdj(zzjc zzjcVar) {
        this.zza = zzjcVar;
    }

    @Override // com.google.android.gms.internal.pal.zzjs
    public final void zza(int i, long j) {
        this.zza.zzb(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.pal.zzjs
    public final void zzb(int i, long j, String str) {
        this.zza.zzf(i, System.currentTimeMillis() - j, str);
    }
}
