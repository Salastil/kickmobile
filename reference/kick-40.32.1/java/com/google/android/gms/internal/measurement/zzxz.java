package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzxz implements zzyi, zzzd {
    private static final String zza = new String();
    private final Level zzb;
    private final long zzc;
    private zzxy zzd;
    private zzyc zze;
    private zzyq zzf;
    private zzaaf zzg;
    private Object[] zzh;

    protected zzxz(Level level, boolean z) {
        long jZzk = zzaad.zzk();
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzh = null;
        zzabr.zza(level, FirebaseAnalytics.Param.LEVEL);
        this.zzb = level;
        this.zzc = jZzk;
    }

    protected abstract zzabn zza();

    protected boolean zzb(zzyd zzydVar) {
        zzxy zzxyVar = this.zzd;
        if (zzxyVar != null) {
            if (zzydVar != null) {
                zzyq zzyqVarZzc = zzyq.zzc(zzyq.zzc(zzxn.zza(zzxyVar, zzydVar, this.zzc), zzxk.zza(this.zzd, zzydVar)), zzyt.zza(this.zzd, zzydVar));
                this.zzf = zzyqVarZzc;
                if (zzyqVarZzc == zzyq.zzc) {
                    return false;
                }
            }
            zzxy zzxyVar2 = this.zzd;
            zzyl zzylVar = zzxx.zzi;
            zzyv zzyvVar = (zzyv) zzxyVar2.zzd(zzylVar);
            if (zzyvVar != null) {
                zzxy zzxyVar3 = this.zzd;
                if (zzxyVar3 != null) {
                    zzxyVar3.zzf(zzylVar);
                }
                zzzj zzzjVarZzl = zzl();
                zzyl zzylVar2 = zzxx.zza;
                zzm(zzylVar2, new zzyg((Throwable) zzzjVarZzl.zzd(zzylVar2), zzyvVar, zzabq.zzb(zzxz.class, zzyvVar.zza(), 1)));
            }
        }
        return true;
    }

    protected abstract zzxi zzc();

    protected abstract zzyi zzd();

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final Level zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final long zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final zzyc zzg() {
        zzyc zzycVar = this.zze;
        if (zzycVar != null) {
            return zzycVar;
        }
        throw new IllegalStateException("cannot request log site information prior to postProcess()");
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final zzaaf zzh() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final Object[] zzi() {
        zzabr.zzc(this.zzg != null, "cannot get arguments unless a template context exists");
        Object[] objArr = this.zzh;
        if (objArr != null) {
            return objArr;
        }
        throw new IllegalStateException("cannot get arguments before calling log()");
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final Object zzj() {
        zzabr.zzc(this.zzg == null, "cannot get literal argument if a template context exists");
        Object[] objArr = this.zzh;
        if (objArr != null) {
            return objArr[0];
        }
        throw new IllegalStateException("cannot get literal argument before calling log()");
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final boolean zzk() {
        return this.zzd != null && Boolean.TRUE.equals(this.zzd.zzd(zzxx.zzg));
    }

    @Override // com.google.android.gms.internal.measurement.zzzd
    public final zzzj zzl() {
        zzxy zzxyVar = this.zzd;
        return zzxyVar != null ? zzxyVar : zzzj.zzg();
    }

    protected final void zzm(zzyl zzylVar, Object obj) {
        if (this.zzd == null) {
            this.zzd = new zzxy();
        }
        this.zzd.zze(zzylVar, obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final zzyi zzn(String str, String str2, int i, String str3) {
        zzyc zzycVar = zzyc.zza;
        zzyb zzybVar = new zzyb("com/google/android/libraries/phenotype/client/Phlogger", "logInternal", 44, "Phlogger.java", null);
        if (this.zze == null) {
            this.zze = zzybVar;
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final zzyi zzo(Throwable th) {
        zzyl zzylVar = zzxx.zza;
        zzabr.zza(zzylVar, "metadata key");
        if (th != null) {
            zzm(zzylVar, th);
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final void zzp(String str, Object[] objArr) {
        zzyd zzydVarZzb;
        zzxy zzxyVar;
        if (this.zze == null) {
            this.zze = zzaad.zzb().zzb(zzxz.class, 1);
        }
        if (this.zze != zzyc.zza) {
            zzydVarZzb = this.zze;
            zzxy zzxyVar2 = this.zzd;
            if (zzxyVar2 != null && zzxyVar2.zza() > 0) {
                zzabr.zza(zzydVarZzb, "logSiteKey");
                int iZza = zzxyVar2.zza();
                for (int i = 0; i < iZza; i++) {
                    if (zzxx.zzf.equals(zzxyVar2.zzb(i))) {
                        Object objZzc = zzxyVar2.zzc(i);
                        zzydVarZzb = objZzc instanceof zzyj ? ((zzyj) objZzc).zzb() : zzyu.zza(zzydVarZzb, objZzc);
                    }
                }
            }
        } else {
            zzydVarZzb = null;
        }
        boolean zZzb = zzb(zzydVarZzb);
        zzyq zzyqVar = this.zzf;
        if (zzyqVar != null) {
            int iZza2 = zzyp.zza(zzyqVar, zzydVarZzb, this.zzd);
            if (zZzb && iZza2 > 0 && (zzxyVar = this.zzd) != null) {
                zzxyVar.zze(zzxx.zze, Integer.valueOf(iZza2));
            }
            zZzb &= iZza2 >= 0;
        }
        if (zZzb) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            this.zzh = objArrCopyOf;
            for (int i2 = 0; i2 < objArrCopyOf.length; i2++) {
                Object obj = objArrCopyOf[i2];
                if (obj instanceof zzxu) {
                    objArrCopyOf[i2] = ((zzxu) obj).zza();
                }
            }
            if (str != zza) {
                this.zzg = new zzaaf(zza(), str);
            }
            zzabe zzabeVarZzi = zzaad.zzi();
            if (!zzabeVarZzi.zzc()) {
                zzzj zzzjVarZzl = zzl();
                zzyl zzylVar = zzxx.zzh;
                zzabe zzabeVar = (zzabe) zzzjVarZzl.zzd(zzylVar);
                if (zzabeVar != null) {
                    zzabeVarZzi = zzabeVarZzi.zzd(zzabeVar);
                }
                zzm(zzylVar, zzabeVarZzi);
            }
            zzc().zzc(this);
        }
    }
}
