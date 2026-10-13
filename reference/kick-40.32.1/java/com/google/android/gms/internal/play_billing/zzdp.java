package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdp extends zzdb {
    private zzdk zzd;
    private ScheduledFuture zze;

    private zzdp(zzdk zzdkVar) {
        this.zzd = zzdkVar;
    }

    static zzdk zzs(zzdk zzdkVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzdp zzdpVar = new zzdp(zzdkVar);
        zzdm zzdmVar = new zzdm(zzdpVar);
        zzdpVar.zze = scheduledExecutorService.schedule(zzdmVar, 28500L, timeUnit);
        zzdkVar.zzb(zzdmVar, zzda.INSTANCE);
        return zzdpVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcu
    protected final String zzd() {
        zzdk zzdkVar = this.zzd;
        ScheduledFuture scheduledFuture = this.zze;
        if (zzdkVar == null) {
            return null;
        }
        String str = "inputFuture=[" + zzdkVar.toString() + "]";
        if (scheduledFuture != null) {
            long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
            if (delay > 0) {
                return str + ", remaining delay=[" + delay + " ms]";
            }
        }
        return str;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcu
    protected final void zzg() {
        zzdk zzdkVar = this.zzd;
        if ((this.valueField instanceof zzcu.zza) & (zzdkVar != null)) {
            Object obj = this.valueField;
            zzdkVar.cancel((obj instanceof zzcu.zza) && ((zzcu.zza) obj).zzc);
        }
        ScheduledFuture scheduledFuture = this.zze;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzd = null;
        this.zze = null;
    }
}
