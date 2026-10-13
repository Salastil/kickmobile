package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdv extends com.google.android.gms.internal.play_billing.zzab {
    private final BillingChoiceInfoResponseListener zza;
    private final zzdd zzb;
    private final int zzc;

    zzdv(BillingChoiceInfoResponseListener billingChoiceInfoResponseListener, zzdd zzddVar, int i) {
        this.zza = billingChoiceInfoResponseListener;
        this.zzb = zzddVar;
        this.zzc = i;
    }

    private final void zza(BillingResult billingResult) {
        this.zza.onBillingChoiceInfoResponse(billingResult, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public final void onDelegateToBackendResponse(Bundle bundle) {
        if (bundle == null) {
            zzdd zzddVar = this.zzb;
            zzjs zzjsVar = zzjs.NULL_BUNDLE_FROM_DELEGATE_TO_BACKEND_SERVICE_CALL;
            BillingResult billingResult = zzdh.zzh;
            zzdj.zza(zzjsVar, billingResult, zzddVar, zzdk.GET_BILLING_CHOICE_INFO_ASYNC.zzb(), this.zzc);
            zza(billingResult);
            return;
        }
        BillingResult billingResultZza = zzdm.zza(bundle, "GetBillingChoiceInfoDelegateToBackendCallback", zzdk.GET_BILLING_CHOICE_INFO_ASYNC.zzb(), this.zzb, this.zzc);
        if (billingResultZza.getResponseCode() != 0) {
            zza(billingResultZza);
            return;
        }
        try {
            byte[] byteArray = bundle.getByteArray("RESPONSE_DATA");
            if (byteArray == null) {
                throw new IllegalArgumentException("Response data is null");
            }
            com.google.android.gms.internal.play_billing.zzea zzeaVarZzb = com.google.android.gms.internal.play_billing.zzea.zzb(byteArray);
            this.zza.onBillingChoiceInfoResponse(billingResultZza, new BillingChoiceInfo(zzeaVarZzb.zzc(), zzeaVarZzb.zze()));
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("GetBillingChoiceInfoDelegateToBackendCallback", "Got an exception trying to decode BillingChoiceInfo. \n Exception: ", e);
            zzdd zzddVar2 = this.zzb;
            zzjs zzjsVar2 = zzjs.ERROR_DECODING_DELEGATE_TO_BACKEND_RESPONSE_DATA;
            BillingResult billingResult2 = zzdh.zzh;
            zzdj.zzb(zzjsVar2, billingResult2, zzddVar2, zzdk.GET_BILLING_CHOICE_INFO_ASYNC.zzb(), this.zzc, zzdc.zza(e));
            zza(billingResult2);
        }
    }
}
