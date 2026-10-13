package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzyt {
    protected volatile zzzi zza;
    private volatile zzxk zzb;
    private volatile boolean zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzyt)) {
            return false;
        }
        zzyt zzytVar = (zzyt) obj;
        zzzi zzziVar = this.zza;
        zzzi zzziVar2 = zzytVar.zza;
        if (zzziVar == null && zzziVar2 == null) {
            return zzc().equals(zzytVar.zzc());
        }
        if (zzziVar != null && zzziVar2 != null) {
            return zzziVar.equals(zzziVar2);
        }
        if (zzziVar != null) {
            zzytVar.zzd(zzziVar.zzx());
            return zzziVar.equals(zzytVar.zza);
        }
        zzd(zzziVar2.zzx());
        return this.zza.equals(zzziVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzzi zza(zzzi zzziVar) {
        zzzi zzziVar2 = this.zza;
        this.zzb = null;
        this.zza = zzziVar;
        return zzziVar2;
    }

    public final int zzb() {
        if (this.zzb != null) {
            return ((zzxj) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzE();
        }
        return 0;
    }

    public final zzxk zzc() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                return this.zzb;
            }
            if (this.zza == null) {
                this.zzb = zzxk.zzb;
            } else {
                this.zzb = this.zza.zzQ();
            }
            return this.zzb;
        }
    }

    protected final void zzd(zzzi zzziVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzziVar;
                this.zzb = zzxk.zzb;
            } catch (zzyo unused) {
                this.zzc = true;
                this.zza = zzziVar;
                this.zzb = zzxk.zzb;
            }
        }
    }
}
