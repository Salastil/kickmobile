package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzjs;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbp implements Callable {
    final /* synthetic */ PurchasesResponseListener zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ BillingClientImpl zzd;

    zzbp(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener, String str, boolean z) {
        this.zza = purchasesResponseListener;
        this.zzb = str;
        this.zzc = z;
        Objects.requireNonNull(billingClientImpl);
        this.zzd = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        BillingClientImpl billingClientImpl = this.zzd;
        if (!billingClientImpl.zzbx(zzdq.zzb())) {
            zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdh.zzj;
            billingClientImpl.zzbE(zzjsVar, 9, billingResult);
            this.zza.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzca.zzk());
            return null;
        }
        String str = this.zzb;
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Please provide a valid product type.");
            zzjs zzjsVar2 = zzjs.EMPTY_PRODUCT_TYPE;
            BillingResult billingResult2 = zzdh.zze;
            billingClientImpl.zzbE(zzjsVar2, 9, billingResult2);
            this.zza.onQueryPurchasesResponse(billingResult2, com.google.android.gms.internal.play_billing.zzca.zzk());
            return null;
        }
        zzek zzekVarZzbC = billingClientImpl.zzbC(str, this.zzc, 9);
        List listZzb = zzekVarZzbC.zzb();
        PurchasesResponseListener purchasesResponseListener = this.zza;
        if (listZzb != null) {
            purchasesResponseListener.onQueryPurchasesResponse(zzekVarZzbC.zza(), zzekVarZzbC.zzb());
            return null;
        }
        purchasesResponseListener.onQueryPurchasesResponse(zzekVarZzbC.zza(), com.google.android.gms.internal.play_billing.zzca.zzk());
        return null;
    }
}
