package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjn;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzju;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzka;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzko;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzkw;
import com.google.android.gms.internal.play_billing.zzld;
import com.google.android.gms.internal.play_billing.zzlg;
import com.google.android.gms.internal.play_billing.zzlk;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdr implements zzdd {
    private zzkg zzb;
    private final zzdt zzc;

    zzdr(Context context, zzkg zzkgVar) {
        this.zzc = new zzdt(context);
        this.zzb = zzkgVar;
    }

    private final void zzo(zzjl zzjlVar, zzkg zzkgVar) {
        if (zzjlVar == null) {
            return;
        }
        try {
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(zzkgVar);
            zzkuVarZza.zza(zzjlVar);
            this.zzc.zza((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    private final void zzp(zzjp zzjpVar, zzkg zzkgVar) {
        if (zzjpVar == null) {
            return;
        }
        try {
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(zzkgVar);
            zzkuVarZza.zzb(zzjpVar);
            this.zzc.zza((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zza(zzjl zzjlVar) {
        try {
            zzo(zzjlVar, this.zzb);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzb(zzjl zzjlVar, int i) {
        try {
            zzke zzkeVar = (zzke) this.zzb.zzq();
            zzkeVar.zzc(i);
            this.zzb = (zzkg) zzkeVar.zzi();
            zza(zzjlVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzc(zzjl zzjlVar, int i, long j) {
        try {
            zzke zzkeVar = (zzke) this.zzb.zzq();
            zzkeVar.zzc(i);
            zzkg zzkgVar = (zzkg) zzkeVar.zzi();
            this.zzb = zzkgVar;
            if (j != 0) {
                zzke zzkeVar2 = (zzke) zzkgVar.zzq();
                zzkeVar2.zze(j);
                zzkgVar = (zzkg) zzkeVar2.zzi();
            }
            zzo(zzjlVar, zzkgVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzd(zzjl zzjlVar, long j, boolean z) {
        try {
            zzjj zzjjVar = (zzjj) zzjlVar.zzq();
            zzko zzkoVar = (zzko) zzjlVar.zze().zzq();
            zzkoVar.zza(z);
            zzjjVar.zzd(zzkoVar);
            zzjl zzjlVar2 = (zzjl) zzjjVar.zzi();
            zzkg zzkgVar = this.zzb;
            if (j != 0) {
                zzke zzkeVar = (zzke) zzkgVar.zzq();
                zzkeVar.zze(j);
                zzkgVar = (zzkg) zzkeVar.zzi();
            }
            zzo(zzjlVar2, zzkgVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zze(zzjl zzjlVar, int i, long j, boolean z) {
        try {
            zzke zzkeVar = (zzke) this.zzb.zzq();
            zzkeVar.zzc(i);
            this.zzb = (zzkg) zzkeVar.zzi();
            zzjj zzjjVar = (zzjj) zzjlVar.zzq();
            zzko zzkoVar = (zzko) zzjlVar.zze().zzq();
            zzkoVar.zza(z);
            zzjjVar.zzd(zzkoVar);
            zzjl zzjlVar2 = (zzjl) zzjjVar.zzi();
            zzkg zzkgVar = this.zzb;
            if (j != 0) {
                zzke zzkeVar2 = (zzke) zzkgVar.zzq();
                zzkeVar2.zze(j);
                zzkgVar = (zzkg) zzkeVar2.zzi();
            }
            zzo(zzjlVar2, zzkgVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzf(zzjp zzjpVar) {
        try {
            zzp(zzjpVar, this.zzb);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzg(zzjp zzjpVar, int i) {
        try {
            zzke zzkeVar = (zzke) this.zzb.zzq();
            zzkeVar.zzc(i);
            this.zzb = (zzkg) zzkeVar.zzi();
            zzf(zzjpVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzh(zzjp zzjpVar, long j, boolean z) {
        try {
            zzjn zzjnVar = (zzjn) zzjpVar.zzq();
            zzko zzkoVar = (zzko) zzjpVar.zzc().zzq();
            zzkoVar.zza(z);
            zzjnVar.zzc(zzkoVar);
            zzjp zzjpVar2 = (zzjp) zzjnVar.zzi();
            zzkg zzkgVar = this.zzb;
            if (j != 0) {
                zzke zzkeVar = (zzke) zzkgVar.zzq();
                zzkeVar.zze(j);
                zzkgVar = (zzkg) zzkeVar.zzi();
            }
            zzp(zzjpVar2, zzkgVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzi(zzjx zzjxVar) {
        try {
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(this.zzb);
            zzkuVarZza.zzc(zzjxVar);
            this.zzc.zza((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzj(BillingResult billingResult, long j) {
        try {
            zzka zzkaVarZza = zzkd.zza();
            zzkaVarZza.zze(4);
            zzkaVarZza.zza(zzjz.IN_APP_BILLING_RESULT_UPDATE_ACTION);
            if (billingResult != null) {
                zzjq zzjqVarZza = zzju.zza();
                zzjqVarZza.zzp(billingResult.getResponseCode());
                zzjqVarZza.zzb(billingResult.getDebugMessage());
                zzkaVarZza.zzb(zzjqVarZza);
            }
            zzku zzkuVarZza = zzkw.zza();
            zzkg zzkgVar = this.zzb;
            if (j != 0) {
                zzke zzkeVar = (zzke) zzkgVar.zzq();
                zzkeVar.zze(j);
                zzkgVar = (zzkg) zzkeVar.zzi();
            }
            zzkuVarZza.zzp(zzkgVar);
            zzkuVarZza.zzd(zzkaVarZza);
            this.zzc.zza((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzk(long j) {
        try {
            zzka zzkaVarZza = zzkd.zza();
            zzkaVarZza.zze(4);
            zzkaVarZza.zza(zzjz.PLAY_BILLING_ACTIVITY_CREATED_ACTION);
            zzkd zzkdVar = (zzkd) zzkaVarZza.zzi();
            zzku zzkuVarZza = zzkw.zza();
            zzkg zzkgVar = this.zzb;
            if (j != 0) {
                zzke zzkeVar = (zzke) zzkgVar.zzq();
                zzkeVar.zze(j);
                zzkgVar = (zzkg) zzkeVar.zzi();
            }
            zzkuVarZza.zzp(zzkgVar);
            zzkuVarZza.zze(zzkdVar);
            this.zzc.zza((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzl(zzld zzldVar) {
        try {
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(this.zzb);
            zzka zzkaVarZza = zzkd.zza();
            zzkaVarZza.zzc("ProxyBillingBroadcastReceiver");
            zzkaVarZza.zze(2);
            zzkaVarZza.zzd(zzldVar);
            zzkuVarZza.zzd(zzkaVarZza);
            this.zzc.zza((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzm(zzlg zzlgVar) {
        try {
            zzdt zzdtVar = this.zzc;
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(this.zzb);
            zzkuVarZza.zzq(zzlgVar);
            zzdtVar.zza((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzdd
    public final void zzn(zzlk zzlkVar) {
        if (zzlkVar == null) {
            return;
        }
        try {
            zzku zzkuVarZza = zzkw.zza();
            zzkuVarZza.zzp(this.zzb);
            zzkuVarZza.zzr(zzlkVar);
            this.zzc.zza((zzkw) zzkuVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }
}
