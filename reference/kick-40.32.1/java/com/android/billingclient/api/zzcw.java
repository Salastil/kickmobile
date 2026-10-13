package com.android.billingclient.api;

import androidx.core.util.Consumer;
import com.google.android.gms.internal.play_billing.zzjs;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcw implements com.google.android.gms.internal.play_billing.zzdd {
    final /* synthetic */ Consumer zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzda zzc;
    final /* synthetic */ int zzd;

    zzcw(zzda zzdaVar, int i, Consumer consumer, Runnable runnable) {
        this.zzd = i;
        this.zza = consumer;
        this.zzb = runnable;
        Objects.requireNonNull(zzdaVar);
        this.zzc = zzdaVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdd
    public final void zza(Throwable th) {
        boolean z = th instanceof TimeoutException;
        zzda zzdaVar = this.zzc;
        if (z) {
            zzdaVar.zzaW(zzjs.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, zzdh.zzF);
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            zzdaVar.zzaW(zzjs.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, zzdh.zzF);
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        this.zzb.run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdd
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        zzda zzdaVar = this.zzc;
        if (!zzda.zzaT(iIntValue)) {
            this.zzb.run();
        } else {
            this.zza.accept(zzdaVar.zzaU(this.zzd, num.intValue()));
        }
    }
}
