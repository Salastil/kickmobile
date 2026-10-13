package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzde implements Runnable {
    final zzdk zza;
    final zzdd zzb;

    zzde(zzdk zzdkVar, zzdd zzddVar) {
        this.zza = zzdkVar;
        this.zzb = zzddVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable thZza;
        zzdk zzdkVar = this.zza;
        if ((zzdkVar instanceof zzdq) && (thZza = zzdr.zza((zzdq) zzdkVar)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            if (!zzdkVar.isDone()) {
                throw new IllegalStateException(zzbo.zzb("Future was expected to be done: %s", zzdkVar));
            }
            boolean z = false;
            Future future = zzdkVar;
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                    future = future;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this.zzb.zzb(obj);
        } catch (ExecutionException e) {
            this.zzb.zza(e.getCause());
        } catch (Throwable th2) {
            this.zzb.zza(th2);
        }
    }

    public final String toString() {
        zzbh zzbhVarZza = zzbj.zza(this);
        zzbhVarZza.zza(this.zzb);
        return zzbhVarZza.toString();
    }
}
