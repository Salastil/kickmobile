package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzaem {
    protected volatile zzafc zza;
    private volatile zzacr zzb;
    private volatile boolean zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaem)) {
            return false;
        }
        zzaem zzaemVar = (zzaem) obj;
        zzafc zzafcVar = this.zza;
        zzafc zzafcVar2 = zzaemVar.zza;
        if (zzafcVar == null && zzafcVar2 == null) {
            return zzc().equals(zzaemVar.zzc());
        }
        if (zzafcVar != null && zzafcVar2 != null) {
            return zzafcVar.equals(zzafcVar2);
        }
        if (zzafcVar != null) {
            zzaemVar.zzd(zzafcVar.zzcK());
            return zzafcVar.equals(zzaemVar.zza);
        }
        zzd(zzafcVar2.zzcK());
        return this.zza.equals(zzafcVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzafc zza(zzafc zzafcVar) {
        zzafc zzafcVar2 = this.zza;
        this.zzb = null;
        this.zza = zzafcVar;
        return zzafcVar2;
    }

    public final int zzb() {
        if (this.zzb != null) {
            return this.zzb.zzb();
        }
        if (this.zza != null) {
            return this.zza.zzcq();
        }
        return 0;
    }

    public final zzacr zzc() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                return this.zzb;
            }
            if (this.zza == null) {
                this.zzb = zzacr.zza;
            } else {
                this.zzb = this.zza.zzcc();
            }
            return this.zzb;
        }
    }

    protected final void zzd(zzafc zzafcVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzafcVar;
                this.zzb = zzacr.zza;
            } catch (zzaeh unused) {
                this.zzc = true;
                this.zza = zzafcVar;
                this.zzb = zzacr.zza;
            }
        }
    }
}
