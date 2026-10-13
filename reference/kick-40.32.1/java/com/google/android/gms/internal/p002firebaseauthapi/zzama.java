package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzama {
    protected volatile zzamv zza;
    private final zzamv zzb;
    private final zzalf zzc;
    private volatile zzakb zzd;
    private volatile boolean zze;

    final int zza() {
        return this.zzd != null ? this.zzd.zza() : this.zza.zzl();
    }

    public final int hashCode() {
        return zzc().hashCode();
    }

    final zzakb zzb() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            this.zzd = this.zza.a_();
            return this.zzd;
        }
    }

    final zzamv zzc() {
        try {
            return this.zza;
        } catch (zzamd e) {
            if (zzalf.zzb()) {
                throw new zzame(e);
            }
            return this.zzb;
        }
    }

    public final String toString() {
        return zzc().toString();
    }

    zzama(zzamv zzamvVar) {
        if (zzamvVar == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        this.zza = zzamvVar;
        this.zzb = zzamvVar.zzg();
        this.zzc = zzalf.zza;
        this.zzd = null;
        this.zze = false;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzama) {
            zzama zzamaVar = (zzama) obj;
            if (this.zzd == null || zzamaVar.zzd == null || this.zzc != zzamaVar.zzc || !this.zzd.equals(zzamaVar.zzd)) {
                return zzc().equals(zzamaVar.zzc());
            }
            return true;
        }
        return zzc().equals(obj);
    }
}
