package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.QueryProductDetailsParams;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzc {
    public static final int zza = Runtime.getRuntime().availableProcessors();

    public static int zza(Bundle bundle, String str) {
        if (bundle != null) {
            return bundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
        }
        zzn(str, "Unexpected null bundle received!");
        return 0;
    }

    public static int zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzn(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzm(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        zzn(str, "Unexpected type for bundle response code: ".concat(String.valueOf(obj.getClass().getName())));
        return 6;
    }

    public static Bundle zzc(Bundle bundle, String str, String str2, long j) {
        bundle.putString("playBillingLibraryVersion", BuildConfig.VERSION_NAME);
        if (str2 != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str2);
        }
        bundle.putLong("billingClientSessionId", j);
        return bundle;
    }

    public static Bundle zzd(BillingResult billingResult, zzjs zzjsVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("RESPONSE_CODE", billingResult.getResponseCode());
        bundle.putString("DEBUG_MESSAGE", billingResult.getDebugMessage());
        bundle.putInt("LOG_REASON", zzjsVar.zza());
        return bundle;
    }

    public static Bundle zze(BillingResult billingResult, zzjs zzjsVar, String str) {
        Bundle bundleZzd = zzd(billingResult, zzjsVar);
        if (str != null) {
            bundleZzd.putString("ADDITIONAL_LOG_DETAILS", str);
        }
        return bundleZzd;
    }

    public static Bundle zzf(BillingFlowParams billingFlowParams, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, long j, String str3, long j2) {
        int i;
        Bundle bundle = new Bundle();
        zzc(bundle, BuildConfig.VERSION_NAME, str2, j);
        bundle.putLong("billingClientTransactionId", j2);
        if (billingFlowParams.zzb() != 0) {
            bundle.putInt("prorationMode", billingFlowParams.zzb());
        }
        if (!TextUtils.isEmpty(billingFlowParams.zze())) {
            bundle.putString("accountId", billingFlowParams.zze());
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzf())) {
            bundle.putString("obfuscatedProfileId", billingFlowParams.zzf());
        }
        if (billingFlowParams.zzt()) {
            bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzh())) {
            bundle.putString("oldSkuPurchaseToken", billingFlowParams.zzh());
        }
        billingFlowParams.zzg();
        if (!TextUtils.isEmpty(null)) {
            billingFlowParams.zzg();
            bundle.putString("oldSkuPurchaseId", null);
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzi())) {
            bundle.putString("originalExternalTransactionId", billingFlowParams.zzi());
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("paymentsPurchaseParams", null);
        }
        if (z && z3) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z2 && z4) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        if (z5 || billingFlowParams.getDeveloperBillingOptionParams() != null) {
            bundle.putBoolean("enableAlternativeBilling", true);
        }
        billingFlowParams.zzc();
        billingFlowParams.zza();
        if (billingFlowParams.getDeveloperBillingOptionParams() != null) {
            if (billingFlowParams.getDeveloperBillingOptionParams().getLinkUri() != null) {
                bundle.putString("developerBillingLinkUri", billingFlowParams.getDeveloperBillingOptionParams().getLinkUri().toString());
            }
            if (billingFlowParams.getDeveloperBillingOptionParams().getLaunchMode() != 0) {
                bundle.putInt("developerBillingLaunchMode", billingFlowParams.getDeveloperBillingOptionParams().getLaunchMode());
            }
            bundle.putInt("developerBillingProgram", billingFlowParams.getDeveloperBillingOptionParams().getBillingProgram());
            if (billingFlowParams.getDeveloperBillingOptionParams().getExternalTransactionToken() != null) {
                bundle.putString("externalTransactionToken", billingFlowParams.getDeveloperBillingOptionParams().getExternalTransactionToken());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (BillingFlowParams.ProductDetailsParams productDetailsParams : billingFlowParams.zzk()) {
            if (productDetailsParams.getSubscriptionProductReplacementParams() != null) {
                String productId = productDetailsParams.zza().getProductId();
                BillingFlowParams.ProductDetailsParams.SubscriptionProductReplacementParams subscriptionProductReplacementParams = productDetailsParams.getSubscriptionProductReplacementParams();
                zzek zzekVarZza = zzel.zza();
                zzeu zzeuVarZza = zzev.zza();
                zzeuVarZza.zza(zzq(productId, BillingClient.ProductType.SUBS, str3));
                zzekVarZza.zza(zzeuVarZza);
                zzeu zzeuVarZza2 = zzev.zza();
                zzeuVarZza2.zza(zzq(subscriptionProductReplacementParams.getOldProductId(), BillingClient.ProductType.SUBS, str3));
                zzekVarZza.zzb(zzeuVarZza2);
                switch (subscriptionProductReplacementParams.getReplacementMode()) {
                    case 1:
                        i = 2;
                        break;
                    case 2:
                        i = 3;
                        break;
                    case 3:
                        i = 4;
                        break;
                    case 4:
                        i = 6;
                        break;
                    case 5:
                        i = 7;
                        break;
                    case 6:
                        i = 8;
                        break;
                    case 7:
                        i = 9;
                        break;
                    default:
                        i = 1;
                        break;
                }
                zzekVarZza.zzc(i);
                arrayList.add((zzel) zzekVarZza.zzi());
            }
        }
        if (!arrayList.isEmpty()) {
            zzem zzemVarZza = zzen.zza();
            zzemVarZza.zza(arrayList);
            bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzen) zzemVarZza.zzi()).zzQ());
        }
        return bundle;
    }

    public static Bundle zzg(String str, String str2, ArrayList arrayList, String str3, String str4, zza zzaVar, long j) {
        Bundle bundle = new Bundle();
        zzc(bundle, BuildConfig.VERSION_NAME, str2, j);
        bundle.putBoolean("enablePendingPurchases", true);
        bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_MULTIPLE_OFFERS", new ArrayList<>(zzca.zzm(BillingClient.ProductType.SUBS, BillingClient.ProductType.INAPP)));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_PREORDER_OFFERS", new ArrayList<>(zzca.zzl(BillingClient.ProductType.INAPP)));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_RENT_OFFERS", new ArrayList<>(zzca.zzl(BillingClient.ProductType.INAPP)));
        bundle.putBoolean("SHOULD_RETURN_UNFETCHED_PRODUCTS", true);
        if (zzaVar.zza) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        int size = arrayList.size();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) arrayList.get(i);
            arrayList2.add(null);
            z |= !TextUtils.isEmpty(null);
            arrayList4.add(product.getDynamicProductToken());
            z2 |= !TextUtils.isEmpty(product.getDynamicProductToken());
            if (product.zzb().equals("first_party")) {
                zzbl.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                arrayList3.add(null);
            }
        }
        if (z) {
            bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList3);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("accountName", null);
        }
        if (z2) {
            bundle.putStringArrayList("SKU_DYNAMIC_PRODUCT_TOKEN_LIST", arrayList4);
        }
        return bundle;
    }

    public static Bundle zzh(String str, String str2, long j) {
        Bundle bundle = new Bundle();
        zzc(bundle, BuildConfig.VERSION_NAME, str2, j);
        return bundle;
    }

    public static BillingResult zzi(Intent intent, String str) {
        if (intent != null) {
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(zzb(intent.getExtras(), str));
            builderNewBuilder.setDebugMessage(zzj(intent.getExtras(), str));
            return builderNewBuilder.build();
        }
        zzn("BillingHelper", "Got null intent!");
        BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
        builderNewBuilder2.setResponseCode(6);
        builderNewBuilder2.setDebugMessage("An internal error occurred.");
        return builderNewBuilder2.build();
    }

    public static String zzj(Bundle bundle, String str) {
        if (bundle == null) {
            zzn(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zzm(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        zzn(str, "Unexpected type for debug message: ".concat(String.valueOf(obj.getClass().getName())));
        return "";
    }

    public static String zzk(int i) {
        return zzb.zza(i).toString();
    }

    public static List zzl(Bundle bundle, Set set) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            Purchase purchaseZzp = zzp(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"), set);
            if (purchaseZzp == null) {
                zzm("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(purchaseZzp);
            return arrayList;
        }
        zzm("BillingHelper", "Found purchase list of " + stringArrayList.size() + " items");
        for (int i = 0; i < stringArrayList.size() && i < stringArrayList2.size(); i++) {
            Purchase purchaseZzp2 = zzp(stringArrayList.get(i), stringArrayList2.get(i), set);
            if (purchaseZzp2 != null) {
                arrayList.add(purchaseZzp2);
            }
        }
        return arrayList;
    }

    public static void zzm(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            if (str2.isEmpty()) {
                Log.v(str, str2);
                return;
            }
            int i = 40000;
            while (!str2.isEmpty() && i > 0) {
                int iMin = Math.min(str2.length(), Math.min(4000, i));
                Log.v(str, str2.substring(0, iMin));
                str2 = str2.substring(iMin);
                i -= iMin;
            }
        }
    }

    public static void zzn(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void zzo(String str, String str2, Throwable th) {
        try {
            if (Log.isLoggable(str, 5)) {
                if (th == null) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, th);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static Purchase zzp(String str, String str2, Set set) {
        Purchase purchase = null;
        if (str == null || str2 == null) {
            zzm("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            Purchase purchase2 = new Purchase(str, str2);
            try {
                set.isEmpty();
                return purchase2;
            } catch (JSONException e) {
                e = e;
                purchase = purchase2;
                zzn("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e.toString()));
                return purchase;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    private static String zzq(String str, String str2, String str3) {
        return "subs:" + str3 + ServerSentEventKt.COLON + str;
    }
}
