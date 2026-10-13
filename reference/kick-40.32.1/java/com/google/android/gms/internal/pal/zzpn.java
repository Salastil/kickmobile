package com.google.android.gms.internal.pal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzpn implements zzpw, zzqr {
    private static final String zza = new String();
    private final Level zzb;
    private final long zzc;
    private zzpm zzd;
    private zzpq zze;
    private zzqe zzf;
    private zzrt zzg;
    private Object[] zzh;

    protected zzpn(Level level, boolean z) {
        long jZzk = zzrr.zzk();
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzh = null;
        zztf.zza(level, FirebaseAnalytics.Param.LEVEL);
        this.zzb = level;
        this.zzc = jZzk;
    }

    private final boolean zzr() {
        zzpr zzprVarZzb;
        zzpm zzpmVar;
        if (this.zze == null) {
            this.zze = zzrr.zzb().zzb(zzpn.class, 1);
        }
        if (this.zze != zzpq.zza) {
            zzprVarZzb = this.zze;
            zzpm zzpmVar2 = this.zzd;
            if (zzpmVar2 != null && zzpmVar2.zza() > 0) {
                zztf.zza(zzprVarZzb, "logSiteKey");
                int iZza = zzpmVar2.zza();
                for (int i = 0; i < iZza; i++) {
                    if (zzpl.zzf.equals(zzpmVar2.zzb(i))) {
                        Object objZzc = zzpmVar2.zzc(i);
                        zzprVarZzb = objZzc instanceof zzpx ? ((zzpx) objZzc).zzb() : zzqi.zza(zzprVarZzb, objZzc);
                    }
                }
            }
        } else {
            zzprVarZzb = null;
        }
        boolean zZzb = zzb(zzprVarZzb);
        zzqe zzqeVar = this.zzf;
        if (zzqeVar == null) {
            return zZzb;
        }
        int iZza2 = zzqd.zza(zzqeVar, zzprVarZzb, this.zzd);
        if (zZzb && iZza2 > 0 && (zzpmVar = this.zzd) != null) {
            zzpmVar.zze(zzpl.zze, Integer.valueOf(iZza2));
        }
        return zZzb & (iZza2 >= 0);
    }

    private final void zzs(String str, Object... objArr) {
        this.zzh = objArr;
        Object obj = objArr[0];
        if (obj instanceof zzpi) {
            objArr[0] = ((zzpi) obj).zza();
        }
        if (str != zza) {
            this.zzg = new zzrt(zza(), str);
        }
        zzss zzssVarZzi = zzrr.zzi();
        if (!zzssVarZzi.zzc()) {
            zzqx zzqxVarZzl = zzl();
            zzpz zzpzVar = zzpl.zzh;
            zzss zzssVar = (zzss) zzqxVarZzl.zzd(zzpzVar);
            if (zzssVar != null) {
                zzssVarZzi = zzssVarZzi.zzd(zzssVar);
            }
            zzm(zzpzVar, zzssVarZzi);
        }
        zzc().zze(this);
    }

    protected abstract zztb zza();

    protected boolean zzb(zzpr zzprVar) {
        zzpm zzpmVar = this.zzd;
        if (zzpmVar != null) {
            if (zzprVar != null) {
                zzqe zzqeVarZzc = zzqe.zzc(zzqe.zzc(zzpb.zza(zzpmVar, zzprVar, this.zzc), zzoy.zza(this.zzd, zzprVar)), zzqh.zza(this.zzd, zzprVar));
                this.zzf = zzqeVarZzc;
                if (zzqeVarZzc == zzqe.zzc) {
                    return false;
                }
            }
            zzpm zzpmVar2 = this.zzd;
            zzpz zzpzVar = zzpl.zzi;
            zzqj zzqjVar = (zzqj) zzpmVar2.zzd(zzpzVar);
            if (zzqjVar != null) {
                zzpm zzpmVar3 = this.zzd;
                if (zzpmVar3 != null) {
                    zzpmVar3.zzf(zzpzVar);
                }
                zzqx zzqxVarZzl = zzl();
                zzpz zzpzVar2 = zzpl.zza;
                zzm(zzpzVar2, new zzpu((Throwable) zzqxVarZzl.zzd(zzpzVar2), zzqjVar, zzte.zzb(zzpn.class, zzqjVar.zza(), 1)));
            }
        }
        return true;
    }

    protected abstract zzow zzc();

    protected abstract zzpw zzd();

    @Override // com.google.android.gms.internal.pal.zzqr
    public final Level zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzqr
    public final long zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzqr
    public final zzpq zzg() {
        zzpq zzpqVar = this.zze;
        if (zzpqVar != null) {
            return zzpqVar;
        }
        throw new IllegalStateException("cannot request log site information prior to postProcess()");
    }

    @Override // com.google.android.gms.internal.pal.zzqr
    public final zzrt zzh() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.pal.zzqr
    public final Object[] zzi() {
        zztf.zzc(this.zzg != null, "cannot get arguments unless a template context exists");
        Object[] objArr = this.zzh;
        if (objArr != null) {
            return objArr;
        }
        throw new IllegalStateException("cannot get arguments before calling log()");
    }

    @Override // com.google.android.gms.internal.pal.zzqr
    public final Object zzj() {
        zztf.zzc(this.zzg == null, "cannot get literal argument if a template context exists");
        Object[] objArr = this.zzh;
        if (objArr != null) {
            return objArr[0];
        }
        throw new IllegalStateException("cannot get literal argument before calling log()");
    }

    @Override // com.google.android.gms.internal.pal.zzqr
    public final boolean zzk() {
        return this.zzd != null && Boolean.TRUE.equals(this.zzd.zzd(zzpl.zzg));
    }

    @Override // com.google.android.gms.internal.pal.zzqr
    public final zzqx zzl() {
        zzpm zzpmVar = this.zzd;
        return zzpmVar != null ? zzpmVar : zzqx.zzg();
    }

    protected final void zzm(zzpz zzpzVar, Object obj) {
        if (this.zzd == null) {
            this.zzd = new zzpm();
        }
        this.zzd.zze(zzpzVar, obj);
    }

    @Override // com.google.android.gms.internal.pal.zzpw
    public final zzpw zzn(String str, String str2, int i, String str3) {
        zzpq zzpqVar = zzpq.zza;
        zzpp zzppVar = new zzpp(str, "decode", i, str3, null);
        if (this.zze == null) {
            this.zze = zzppVar;
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.pal.zzpw
    public final zzpw zzo(Throwable th) {
        zzpz zzpzVar = zzpl.zza;
        zztf.zza(zzpzVar, "metadata key");
        zzm(zzpzVar, th);
        return zzd();
    }

    @Override // com.google.android.gms.internal.pal.zzpw
    public final void zzp(String str) {
        if (zzr()) {
            zzs(zza, str);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzpw
    public final void zzq(String str, Object obj) {
        if (zzr()) {
            zzs("Error decoding DisclosedVendors segment: %s", obj);
        }
    }
}
