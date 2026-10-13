package expo.modules.kickiap;

import android.util.Log;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryProductDetailsResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProductRepository.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2/\u0010\n\u001a+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\u000b¨\u0006\u0010"}, d2 = {"Lexpo/modules/kickiap/ProductRepository;", "", "<init>", "()V", "getProducts", "", "skuList", "", "", "productType", "callback", "Lkotlin/Function2;", "Lcom/android/billingclient/api/ProductDetails;", "Lkotlin/ParameterName;", "name", "errorMessage", "kick-iap_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ProductRepository {
    public static final ProductRepository INSTANCE = new ProductRepository();

    private ProductRepository() {
    }

    public final void getProducts(List<String> skuList, String productType, final Function2<? super List<ProductDetails>, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(skuList, "skuList");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!BillingClientManager.INSTANCE.getBillingClient().isReady()) {
            Log.e("KickIAP", "Billing Client not ready.");
            callback.invoke(CollectionsKt.emptyList(), "billingClientNotInitialized");
            return;
        }
        Log.d("KickIAP", "Getting products for " + skuList + " and type " + productType);
        List<String> list = skuList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId((String) it.next()).setProductType(productType).build());
        }
        QueryProductDetailsParams queryProductDetailsParamsBuild = QueryProductDetailsParams.newBuilder().setProductList(arrayList).build();
        Intrinsics.checkNotNullExpressionValue(queryProductDetailsParamsBuild, "build(...)");
        BillingClientManager.INSTANCE.getBillingClient().queryProductDetailsAsync(queryProductDetailsParamsBuild, new ProductDetailsResponseListener() { // from class: expo.modules.kickiap.ProductRepository$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void onProductDetailsResponse(BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
                ProductRepository.getProducts$lambda$1(callback, billingResult, queryProductDetailsResult);
            }
        });
    }

    static final void getProducts$lambda$1(Function2 function2, BillingResult billingResult, QueryProductDetailsResult productDetailsList) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(productDetailsList, "productDetailsList");
        if (billingResult.getResponseCode() == 0) {
            List<ProductDetails> productDetailsList2 = productDetailsList.getProductDetailsList();
            Intrinsics.checkNotNullExpressionValue(productDetailsList2, "getProductDetailsList(...)");
            if (!productDetailsList2.isEmpty()) {
                List<ProductDetails> productDetailsList3 = productDetailsList.getProductDetailsList();
                Intrinsics.checkNotNullExpressionValue(productDetailsList3, "getProductDetailsList(...)");
                function2.invoke(productDetailsList3, "");
                return;
            }
        }
        Log.e("KickIAP", "Could not retrieve products.");
        if (billingResult.getResponseCode() != 0) {
            function2.invoke(CollectionsKt.emptyList(), HelpersKt.getResponseCode(billingResult.getResponseCode()));
        } else {
            function2.invoke(CollectionsKt.emptyList(), "");
        }
    }
}
