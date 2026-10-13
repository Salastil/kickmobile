package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzatx {
    private final Object zza;
    private final int zzb;

    zzatx(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzatx)) {
            return false;
        }
        zzatx zzatxVar = (zzatx) obj;
        return this.zza == zzatxVar.zza && this.zzb == zzatxVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
