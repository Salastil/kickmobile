package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzz {
    private final Context zza;
    private final PurchasesUpdatedListener zzb;
    private final UserChoiceBillingListener zzc;
    private final DeveloperProvidedBillingListener zzd;
    private final zzdd zze;
    private boolean zzh;
    private com.google.android.gms.internal.play_billing.zzcf zzi = com.google.android.gms.internal.play_billing.zzcf.zzk();
    private final zzy zzf = new zzy(this, true);
    private final zzy zzg = new zzy(this, false);

    zzz(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzdu zzduVar, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, zzdd zzddVar) {
        this.zza = context;
        this.zzb = purchasesUpdatedListener;
        this.zzc = userChoiceBillingListener;
        this.zzd = developerProvidedBillingListener;
        this.zze = zzddVar;
    }

    final DeveloperProvidedBillingListener zzc() {
        return this.zzd;
    }

    final PurchasesUpdatedListener zze() {
        return this.zzb;
    }

    final void zzh() {
        zzy zzyVar = this.zzf;
        Context context = this.zza;
        zzyVar.zzc(context);
        this.zzg.zzc(context);
    }

    final void zzi(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzh = z;
        zzy zzyVar = this.zzg;
        Context context = this.zza;
        zzyVar.zza(context, intentFilter2);
        boolean z2 = this.zzh;
        zzy zzyVar2 = this.zzf;
        if (z2) {
            zzyVar2.zzb(context, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            zzyVar2.zza(context, intentFilter);
        }
    }

    final void zzj(com.google.android.gms.internal.play_billing.zzcf zzcfVar) {
        this.zzi = zzcfVar;
    }
}
