package com.google.android.gms.cast.framework;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzo {
    private int zza = 0;
    private int zzb = -1;

    public final zzo zza(int i) {
        this.zza = i;
        return this;
    }

    public final zzo zzb(int i) {
        this.zzb = i;
        return this;
    }

    public final zzp zzc() {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = CastContext.zzb(this.zzb);
            this.zza = iZzb;
        }
        return new zzp(iZzb, this.zzb, null);
    }
}
