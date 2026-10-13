package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrt {
    private final zztb zza;
    private final String zzb;

    public zzrt(zztb zztbVar, String str) {
        zztf.zza(zztbVar, "parser");
        this.zza = zztbVar;
        zztf.zza(str, "message");
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzrt) {
            zzrt zzrtVar = (zzrt) obj;
            if (this.zza.equals(zzrtVar.zza) && this.zzb.equals(zzrtVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ this.zzb.hashCode();
    }

    public final zztb zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
