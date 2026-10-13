package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzavh {
    protected volatile zzavw zza;
    private volatile zzatl zzb;
    private volatile boolean zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzavh)) {
            return false;
        }
        zzavh zzavhVar = (zzavh) obj;
        zzavw zzavwVar = this.zza;
        zzavw zzavwVar2 = zzavhVar.zza;
        if (zzavwVar == null && zzavwVar2 == null) {
            return zzc().equals(zzavhVar.zzc());
        }
        if (zzavwVar != null && zzavwVar2 != null) {
            return zzavwVar.equals(zzavwVar2);
        }
        if (zzavwVar != null) {
            zzavhVar.zzd(zzavwVar.zzap());
            return zzavwVar.equals(zzavhVar.zza);
        }
        zzd(zzavwVar2.zzap());
        return this.zza.equals(zzavwVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzavw zza(zzavw zzavwVar) {
        zzavw zzavwVar2 = this.zza;
        this.zzb = null;
        this.zza = zzavwVar;
        return zzavwVar2;
    }

    public final int zzb() {
        if (this.zzb != null) {
            return this.zzb.zzb();
        }
        if (this.zza != null) {
            return this.zza.zzaB();
        }
        return 0;
    }

    public final zzatl zzc() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                return this.zzb;
            }
            if (this.zza == null) {
                this.zzb = zzatl.zza;
            } else {
                this.zzb = this.zza.zzaQ();
            }
            return this.zzb;
        }
    }

    protected final void zzd(zzavw zzavwVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzavwVar;
                this.zzb = zzatl.zza;
            } catch (zzavb unused) {
                this.zzc = true;
                this.zza = zzavwVar;
                this.zzb = zzatl.zza;
            }
        }
    }
}
