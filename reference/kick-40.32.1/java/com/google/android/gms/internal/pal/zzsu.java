package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsu extends zzsv {
    private final zzst zza;

    private zzsu(zzqo zzqoVar, int i, zzst zzstVar) {
        super(zzqoVar, i);
        this.zza = zzstVar;
        StringBuilder sb = new StringBuilder("%");
        zzqoVar.zzl(sb);
        sb.append(true != zzqoVar.zzk() ? 't' : 'T');
        sb.append(zzstVar.zzb());
    }

    public static zzsv zza(zzst zzstVar, zzqo zzqoVar, int i) {
        return new zzsu(zzqoVar, i, zzstVar);
    }

    @Override // com.google.android.gms.internal.pal.zzsv
    protected final void zzb(zzsw zzswVar, Object obj) {
        zzswVar.zzd(obj, this.zza, zzd());
    }
}
