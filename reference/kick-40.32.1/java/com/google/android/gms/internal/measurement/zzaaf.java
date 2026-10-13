package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaaf {
    private final zzabn zza;
    private final String zzb;

    public zzaaf(zzabn zzabnVar, String str) {
        zzabr.zza(zzabnVar, "parser");
        this.zza = zzabnVar;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaaf) {
            zzaaf zzaafVar = (zzaaf) obj;
            if (this.zza.equals(zzaafVar.zza) && this.zzb.equals(zzaafVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ this.zzb.hashCode();
    }

    public final zzabn zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
