package expo.modules.kickiap;

import android.app.Activity;
import android.util.Log;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PurchaseManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u000f\u001a\u00020\f2&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0004\u0012\u00020\f0\u0005J8\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005J \u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002RN\u0010\u0004\u001aB\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lexpo/modules/kickiap/PurchaseManager;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "<init>", "()V", "sendModuleEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "", "", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "purchaseFlowCallback", "Lcom/android/billingclient/api/BillingResult;", "setEventListener", "moduleEventDispatcher", "startPurchase", "activity", "Landroid/app/Activity;", "product", "Lcom/android/billingclient/api/ProductDetails;", "backendUUID", "onPurchaseFlowResult", "onPurchasesUpdated", "billingResult", "purchases", "", "Lcom/android/billingclient/api/Purchase;", "getProductType", "productId", "kick-iap_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PurchaseManager implements PurchasesUpdatedListener {
    public static final PurchaseManager INSTANCE = new PurchaseManager();
    private static Function2<? super BillingResult, ? super String, Unit> purchaseFlowCallback;
    private static Function2<? super String, ? super Map<String, ? extends Object>, Unit> sendModuleEvent;

    private PurchaseManager() {
    }

    public final void setEventListener(Function2<? super String, ? super Map<String, ? extends Object>, Unit> moduleEventDispatcher) {
        Intrinsics.checkNotNullParameter(moduleEventDispatcher, "moduleEventDispatcher");
        sendModuleEvent = moduleEventDispatcher;
    }

    public final void startPurchase(Activity activity, ProductDetails product, String backendUUID, Function2<? super BillingResult, ? super String, Unit> onPurchaseFlowResult) {
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(backendUUID, "backendUUID");
        Intrinsics.checkNotNullParameter(onPurchaseFlowResult, "onPurchaseFlowResult");
        BillingFlowParams.Builder builderNewBuilder = BillingFlowParams.newBuilder();
        BillingFlowParams.ProductDetailsParams.Builder productDetails = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(product);
        builderNewBuilder.setObfuscatedAccountId(backendUUID);
        if (Intrinsics.areEqual(product.getProductType(), BillingClient.ProductType.SUBS)) {
            List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails2 = product.getSubscriptionOfferDetails();
            String offerToken = (subscriptionOfferDetails2 == null || (subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) CollectionsKt.firstOrNull((List) subscriptionOfferDetails2)) == null) ? null : subscriptionOfferDetails.getOfferToken();
            if (offerToken != null) {
                productDetails.setOfferToken(offerToken);
            } else {
                Log.e("KickIAP", "Could not find offer token for subscription product.");
                return;
            }
        }
        builderNewBuilder.setProductDetailsParamsList(CollectionsKt.listOf(productDetails.build()));
        BillingFlowParams billingFlowParamsBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(billingFlowParamsBuild, "build(...)");
        purchaseFlowCallback = onPurchaseFlowResult;
        BillingResult billingResultLaunchBillingFlow = BillingClientManager.INSTANCE.getBillingClient().launchBillingFlow(activity, billingFlowParamsBuild);
        Intrinsics.checkNotNullExpressionValue(billingResultLaunchBillingFlow, "launchBillingFlow(...)");
        Log.d("KickIAP", "PurchaseManager billingResult: " + billingResultLaunchBillingFlow);
        if (billingResultLaunchBillingFlow.getResponseCode() != 0) {
            Log.e("KickIAP", "Could not start purchase flow: " + billingResultLaunchBillingFlow.getDebugMessage());
            onPurchaseFlowResult.invoke(billingResultLaunchBillingFlow, HelpersKt.getResponseCode(billingResultLaunchBillingFlow.getResponseCode()));
            return;
        }
        Log.d("KickIAP", "Purchase flow started successfully.");
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> purchases) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Function2<? super BillingResult, ? super String, Unit> function2 = purchaseFlowCallback;
        if (function2 != null) {
            function2.invoke(billingResult, "");
        }
        purchaseFlowCallback = null;
        if (billingResult.getResponseCode() == 0 && purchases != null) {
            for (Purchase purchase : purchases) {
                if (purchase.getPurchaseState() == 1) {
                    List<String> products = purchase.getProducts();
                    Intrinsics.checkNotNullExpressionValue(products, "getProducts(...)");
                    String str = (String) CollectionsKt.firstOrNull((List) products);
                    if (str == null) {
                        str = "unknown_product";
                    }
                    String str2 = Intrinsics.areEqual(getProductType(str), BillingClient.ProductType.INAPP) ? "consumable" : FirebaseAnalytics.Param.SUBSCRIPTION;
                    Function2<? super String, ? super Map<String, ? extends Object>, Unit> function3 = sendModuleEvent;
                    if (function3 != null) {
                        function3.invoke("onPurchaseUpdated", MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.TRANSACTION_ID, purchase.getPurchaseToken()), TuplesKt.to(FirebaseAnalytics.Param.PRODUCT_ID, str), TuplesKt.to("product_type", str2)));
                    }
                }
            }
            return;
        }
        if (billingResult.getResponseCode() == 1) {
            Log.e("KickIAP", "Purchase update failed: User canceled the purchase.");
            Function2<? super String, ? super Map<String, ? extends Object>, Unit> function4 = sendModuleEvent;
            if (function4 != null) {
                function4.invoke("onPurchaseUpdated", MapsKt.mapOf(TuplesKt.to("error_code", Integer.valueOf(billingResult.getResponseCode())), TuplesKt.to("error_message", billingResult.getDebugMessage())));
                return;
            }
            return;
        }
        Log.e("KickIAP", "Purchase update failed: " + billingResult.getDebugMessage());
        Function2<? super String, ? super Map<String, ? extends Object>, Unit> function5 = sendModuleEvent;
        if (function5 != null) {
            function5.invoke("onPurchaseUpdated", MapsKt.mapOf(TuplesKt.to("error_code", Integer.valueOf(billingResult.getResponseCode())), TuplesKt.to("error_message", billingResult.getDebugMessage())));
        }
    }

    private final String getProductType(String productId) {
        if (StringsKt.startsWith$default(productId, "gift.", false, 2, (Object) null) || StringsKt.startsWith$default(productId, "kicks.", false, 2, (Object) null)) {
            return BillingClient.ProductType.INAPP;
        }
        return BillingClient.ProductType.SUBS;
    }
}
