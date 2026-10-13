package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdm {
    public static BillingResult zza(Bundle bundle, String str, int i, zzdd zzddVar, int i2) {
        if (!bundle.containsKey("BILLING_RESULT")) {
            com.google.android.gms.internal.play_billing.zzc.zzn(str, "delegateToBackendAsync does not contain a billing result in the response");
            zzjs zzjsVar = zzjs.MISSING_BILLING_RESULT_IN_DELEGATE_TO_BACKEND_RESPONSE;
            BillingResult billingResult = zzdh.zzh;
            zzdj.zza(zzjsVar, billingResult, zzddVar, i, i2);
            return billingResult;
        }
        try {
            byte[] byteArray = bundle.getByteArray("BILLING_RESULT");
            if (byteArray == null) {
                throw new Exception("Billing result is null");
            }
            com.google.android.gms.internal.play_billing.zzeq zzeqVarZzc = com.google.android.gms.internal.play_billing.zzeq.zzc(byteArray);
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(zzeqVarZzc.zza());
            builderNewBuilder.setDebugMessage(zzeqVarZzc.zze());
            BillingResult billingResultBuild = builderNewBuilder.build();
            if (billingResultBuild.getResponseCode() != 0) {
                zzdj.zza(zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY, billingResultBuild, zzddVar, i, i2);
                return billingResultBuild;
            }
            if (bundle.containsKey("RESPONSE_DATA")) {
                return billingResultBuild;
            }
            com.google.android.gms.internal.play_billing.zzc.zzn(str, "delegateToBackendAsync returned a bundle with neither an error nor response data");
            zzjs zzjsVar2 = zzjs.MISSING_RESPONSE_DATA_IN_DELEGATE_TO_BACKEND_RESPONSE;
            BillingResult billingResult2 = zzdh.zzh;
            zzdj.zza(zzjsVar2, billingResult2, zzddVar, i, i2);
            return billingResult2;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzo(str, "Failed parsing BillingResult.", e);
            zzjs zzjsVar3 = zzjs.ERROR_DECODING_DELEGATE_TO_BACKEND_BILLING_RESULT;
            BillingResult billingResult3 = zzdh.zzh;
            zzdj.zzb(zzjsVar3, billingResult3, zzddVar, i, i2, zzdc.zza(e));
            return billingResult3;
        }
    }
}
