package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcb extends com.google.android.gms.internal.play_billing.zzy {
    final ExternalOfferReportingDetailsListener zza;
    final zzdd zzb;
    final int zzc;

    /* synthetic */ zzcb(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, zzdd zzddVar, int i, zzcm zzcmVar) {
        this.zza = externalOfferReportingDetailsListener;
        this.zzb = zzddVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzz
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            zzdd zzddVar = this.zzb;
            zzjs zzjsVar = zzjs.NULL_BUNDLE_FROM_CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL;
            BillingResult billingResult = zzdh.zzh;
            int i = zzdc.zza;
            zzddVar.zzb(zzdc.zzb(zzjsVar, 24, billingResult, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(billingResult, null);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        BillingResult billingResultZza = zzdh.zza(iZzb, com.google.android.gms.internal.play_billing.zzc.zzj(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", zza.zza(iZzb, "createExternalOfferReportingDetailsAsync() failed. Response code: "));
            zzdd zzddVar2 = this.zzb;
            zzjs zzjsVar2 = zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i2 = zzdc.zza;
            zzddVar2.zzb(zzdc.zzb(zzjsVar2, 24, billingResultZza, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(billingResultZza, null);
            return;
        }
        try {
            this.zza.onExternalOfferReportingDetailsResponse(billingResultZza, new ExternalOfferReportingDetails(bundle.getString("CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS")));
        } catch (JSONException e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error when parsing invalid external offer reporting details. \n Exception: ", e);
            zzdd zzddVar3 = this.zzb;
            zzjs zzjsVar3 = zzjs.ERROR_DECODING_EXTERNAL_OFFER_REPORTING_DETAILS;
            BillingResult billingResult2 = zzdh.zzh;
            int i3 = zzdc.zza;
            zzddVar3.zzb(zzdc.zzb(zzjsVar3, 24, billingResult2, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(billingResult2, null);
        }
    }
}
