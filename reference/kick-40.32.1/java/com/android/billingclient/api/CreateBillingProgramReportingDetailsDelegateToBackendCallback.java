package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.internal.play_billing.zzjs;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class CreateBillingProgramReportingDetailsDelegateToBackendCallback extends com.google.android.gms.internal.play_billing.zzab {
    private static final String DELEGATE_TO_BACKEND_RESPONSE_DATA_KEY = "RESPONSE_DATA";
    private static final String TAG = "CreateBillingProgramReportingDetailsDelegateToBackendCallback";
    final int billingApiVersion;
    final zzdd billingLogger;
    final int billingProgram;
    final ExecutorService executorService;
    final Handler handler;
    final BillingProgramReportingDetailsListener listener;

    CreateBillingProgramReportingDetailsDelegateToBackendCallback(BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, int i, zzdd zzddVar, int i2, Handler handler, ExecutorService executorService) {
        billingProgramReportingDetailsListener.getClass();
        this.listener = billingProgramReportingDetailsListener;
        this.billingProgram = i;
        this.billingLogger = zzddVar;
        this.billingApiVersion = i2;
        this.handler = handler;
        this.executorService = executorService;
    }

    private BillingProgramReportingDetails parseReportingDetails(Bundle bundle) throws Exception {
        byte[] byteArray = bundle.getByteArray(DELEGATE_TO_BACKEND_RESPONSE_DATA_KEY);
        if (byteArray != null) {
            return new BillingProgramReportingDetails(com.google.android.gms.internal.play_billing.zzdx.zzb(byteArray).zzc().zzc(), this.billingProgram);
        }
        throw new Exception("Response data is null");
    }

    private void returnListenerResponseOnSuccess(BillingResult billingResult, Bundle bundle) {
        try {
            this.listener.onCreateBillingProgramReportingDetailsResponse(billingResult, parseReportingDetails(bundle));
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzn(TAG, "Got a JSON exception trying to decode billing program reporting details.");
            zzdd zzddVar = this.billingLogger;
            zzjs zzjsVar = zzjs.ERROR_DECODING_DELEGATE_TO_BACKEND_RESPONSE_DATA;
            BillingResult billingResult2 = zzdh.zzh;
            zzdj.zzb(zzjsVar, billingResult2, zzddVar, zzdk.CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC.zzb(), this.billingApiVersion, zzdc.zza(e));
            this.listener.onCreateBillingProgramReportingDetailsResponse(billingResult2, null);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public void onDelegateToBackendResponse(Bundle bundle) {
        if (bundle == null) {
            zzdd zzddVar = this.billingLogger;
            zzjs zzjsVar = zzjs.NULL_BUNDLE_FROM_DELEGATE_TO_BACKEND_SERVICE_CALL;
            BillingResult billingResult = zzdh.zzh;
            zzdj.zza(zzjsVar, billingResult, zzddVar, zzdk.CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC.zzb(), this.billingApiVersion);
            this.listener.onCreateBillingProgramReportingDetailsResponse(billingResult, null);
            return;
        }
        zzdk zzdkVar = zzdk.CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC;
        BillingResult billingResultZza = zzdm.zza(bundle, TAG, zzdkVar.zzb(), this.billingLogger, this.billingApiVersion);
        BillingProgramReportingDetailsListener billingProgramReportingDetailsListener = this.listener;
        if (billingProgramReportingDetailsListener == null) {
            zzdj.zza(zzjs.NULL_LISTENER_IN_DELEGATE_TO_BACKEND_CALLBACK, billingResultZza, this.billingLogger, zzdkVar.zzb(), this.billingApiVersion);
        } else if (billingResultZza.getResponseCode() != 0) {
            billingProgramReportingDetailsListener.onCreateBillingProgramReportingDetailsResponse(billingResultZza, null);
        } else {
            returnListenerResponseOnSuccess(billingResultZza, bundle);
        }
    }
}
