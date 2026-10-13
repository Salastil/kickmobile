package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdm implements Runnable {
    zzdp zza;

    zzdm(zzdp zzdpVar) {
        this.zza = zzdpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdk zzdkVar;
        zzdp zzdpVar = this.zza;
        if (zzdpVar == null || (zzdkVar = zzdpVar.zzd) == null) {
            return;
        }
        this.zza = null;
        if (zzdkVar.isDone()) {
            zzdpVar.zzj(zzdkVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzdpVar.zze;
            zzdpVar.zze = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzdpVar.zzi(new zzdn(str, null));
                    throw th;
                }
            }
            zzdpVar.zzi(new zzdn(str + ": " + zzdkVar.toString(), null));
            zzdkVar.cancel(true);
        } catch (Throwable th2) {
            zzdkVar.cancel(true);
            throw th2;
        }
    }
}
