package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzsv {
    private final int zza;
    private final zzqo zzb;

    protected zzsv(zzqo zzqoVar, int i) {
        if (zzqoVar == null) {
            throw new IllegalArgumentException("format options cannot be null");
        }
        if (i >= 0) {
            this.zza = i;
            this.zzb = zzqoVar;
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 15);
            sb.append("invalid index: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    protected abstract void zzb(zzsw zzswVar, Object obj);

    public final int zzc() {
        return this.zza;
    }

    protected final zzqo zzd() {
        return this.zzb;
    }

    public final void zze(zzsw zzswVar, Object[] objArr) {
        if (this.zza > 0) {
            zzswVar.zze();
            return;
        }
        Object obj = objArr[0];
        if (obj != null) {
            zzb(zzswVar, obj);
        } else {
            zzswVar.zzf();
        }
    }
}
