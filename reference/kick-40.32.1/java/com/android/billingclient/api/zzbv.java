package com.android.billingclient.api;

import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbv implements BillingClientStateListener {
    final /* synthetic */ com.google.android.gms.internal.play_billing.zzp zza;
    final /* synthetic */ BillingClientImpl zzb;

    zzbv(BillingClientImpl billingClientImpl, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        this.zza = zzpVar;
        Objects.requireNonNull(billingClientImpl);
        this.zzb = billingClientImpl;
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection attempt failed.");
        try {
            this.zza.zzb(zzdh.zzj);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        if (billingClientImpl.zzK != null) {
            billingClientImpl.zzax(new Runnable() { // from class: com.android.billingclient.api.zzbt
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.zza.zzb.zzK.onBillingServiceDisconnected();
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception calling onBillingServiceDisconnected.", th2);
                    }
                }
            });
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(final BillingResult billingResult) {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection finished with result: " + billingResult.getResponseCode());
        try {
            this.zza.zzb(billingResult);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        if (billingClientImpl.zzK != null) {
            billingClientImpl.zzax(new Runnable() { // from class: com.android.billingclient.api.zzbu
                @Override // java.lang.Runnable
                public final void run() {
                    zzbv zzbvVar = this.zza;
                    try {
                        zzbvVar.zzb.zzK.onBillingSetupFinished(billingResult);
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception calling onBillingSetupFinished.", th2);
                    }
                }
            });
        }
    }
}
