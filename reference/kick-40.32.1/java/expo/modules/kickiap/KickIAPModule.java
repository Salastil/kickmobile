package expo.modules.kickiap;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.tracing.Trace;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: KickIAPModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lexpo/modules/kickiap/KickIAPModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "getRealProductType", "", "productType", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "kick-iap_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickIAPModule extends Module {
    /* JADX INFO: Access modifiers changed from: private */
    public final String getRealProductType(String productType) {
        String lowerCase = productType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, FirebaseAnalytics.Param.SUBSCRIPTION)) {
            return BillingClient.ProductType.SUBS;
        }
        return BillingClient.ProductType.INAPP;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        KickIAPModule kickIAPModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (kickIAPModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(kickIAPModule);
            moduleDefinitionBuilder.Name("KickIAP");
            moduleDefinitionBuilder.Events("onPurchaseUpdated");
            moduleDefinitionBuilder.OnStartObserving("onPurchaseUpdated", new Function0<Unit>() { // from class: expo.modules.kickiap.KickIAPModule$definition$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PurchaseManager purchaseManager = PurchaseManager.INSTANCE;
                    final KickIAPModule kickIAPModule2 = this.this$0;
                    purchaseManager.setEventListener(new Function2<String, Map<String, ? extends Object>, Unit>() { // from class: expo.modules.kickiap.KickIAPModule$definition$1$1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, Map<String, ? extends Object> map) {
                            invoke2(str, map);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String name, Map<String, ? extends Object> body) {
                            Intrinsics.checkNotNullParameter(name, "name");
                            Intrinsics.checkNotNullParameter(body, "body");
                            kickIAPModule2.sendEvent(name, body);
                        }
                    });
                    Log.d("KickIAP", "Started observing onPurchaseUpdated");
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext != null) {
                        BillingClientManager.INSTANCE.initBillingClient(reactContext, PurchaseManager.INSTANCE);
                    } else {
                        Log.e("KickIAP", "Could not initialize Billing Client: Context is not an instance of Android Context.");
                    }
                }
            });
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError), new Function0<KType>() { // from class: expo.modules.kickiap.KickIAPModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                        }
                    }));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2), new Function0<KType>() { // from class: expo.modules.kickiap.KickIAPModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getProductsAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kickiap.KickIAPModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    final String realProductType = this.this$0.getRealProductType((String) objArr[1]);
                    ProductRepository.INSTANCE.getProducts((List) obj, realProductType, new Function2<List<? extends ProductDetails>, String, Unit>() { // from class: expo.modules.kickiap.KickIAPModule$definition$1$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ProductDetails> list, String str) {
                            invoke2((List<ProductDetails>) list, str);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(List<ProductDetails> products, String str) {
                            Map mapEmptyMap;
                            String formattedPrice;
                            ProductDetails.PricingPhases pricingPhases;
                            List<ProductDetails.PricingPhase> pricingPhaseList;
                            String formattedPrice2;
                            Intrinsics.checkNotNullParameter(products, "products");
                            List<ProductDetails> list = products;
                            String str2 = realProductType;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            for (ProductDetails productDetails : list) {
                                String str3 = "N/A";
                                if (Intrinsics.areEqual(str2, BillingClient.ProductType.INAPP)) {
                                    ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                                    Pair[] pairArr = new Pair[3];
                                    pairArr[0] = TuplesKt.to("id", productDetails.getProductId());
                                    if (oneTimePurchaseOfferDetails != null && (formattedPrice2 = oneTimePurchaseOfferDetails.getFormattedPrice()) != null) {
                                        str3 = formattedPrice2;
                                    }
                                    pairArr[1] = TuplesKt.to("displayPrice", str3);
                                    pairArr[2] = TuplesKt.to(FirebaseAnalytics.Param.PRICE, Double.valueOf(oneTimePurchaseOfferDetails != null ? oneTimePurchaseOfferDetails.getPriceAmountMicros() / 1000000.0d : 0.0d));
                                    mapEmptyMap = MapsKt.mapOf(pairArr);
                                } else if (Intrinsics.areEqual(str2, BillingClient.ProductType.SUBS)) {
                                    List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails();
                                    ProductDetails.PricingPhase pricingPhase = null;
                                    ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails2 = subscriptionOfferDetails != null ? (ProductDetails.SubscriptionOfferDetails) CollectionsKt.firstOrNull((List) subscriptionOfferDetails) : null;
                                    if (subscriptionOfferDetails2 != null && (pricingPhases = subscriptionOfferDetails2.getPricingPhases()) != null && (pricingPhaseList = pricingPhases.getPricingPhaseList()) != null) {
                                        pricingPhase = (ProductDetails.PricingPhase) CollectionsKt.firstOrNull((List) pricingPhaseList);
                                    }
                                    Pair[] pairArr2 = new Pair[3];
                                    pairArr2[0] = TuplesKt.to("id", productDetails.getProductId());
                                    if (pricingPhase != null && (formattedPrice = pricingPhase.getFormattedPrice()) != null) {
                                        str3 = formattedPrice;
                                    }
                                    pairArr2[1] = TuplesKt.to("displayPrice", str3);
                                    pairArr2[2] = TuplesKt.to(FirebaseAnalytics.Param.PRICE, Double.valueOf(pricingPhase != null ? pricingPhase.getPriceAmountMicros() / 1000000.0d : 0.0d));
                                    mapEmptyMap = MapsKt.mapOf(pairArr2);
                                } else {
                                    mapEmptyMap = MapsKt.emptyMap();
                                }
                                arrayList.add(mapEmptyMap);
                            }
                            promise.resolve(MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.SUCCESS, true), TuplesKt.to(InsiderHybridMethods.PRODUCTS, arrayList)));
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("getProductsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[3];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3), new Function0<KType>() { // from class: expo.modules.kickiap.KickIAPModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType3 = new AnyType(typeDescriptor3, converters2);
            }
            anyTypeArr2[0] = anyType3;
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4), new Function0<KType>() { // from class: expo.modules.kickiap.KickIAPModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType4 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr2[1] = anyType4;
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5), new Function0<KType>() { // from class: expo.modules.kickiap.KickIAPModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType5 = new AnyType(typeDescriptor5, converters2);
            }
            anyTypeArr2[2] = anyType5;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("purchaseAsync", anyTypeArr2, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kickiap.KickIAPModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$7
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    String str = (String) objArr[2];
                    String str2 = (String) obj2;
                    final String str3 = (String) obj;
                    final Activity currentActivity = this.this$0.getAppContext().getCurrentActivity();
                    if (currentActivity == null) {
                        MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.SUCCESS, false), TuplesKt.to("error", "purchaseManagerNotInitialized"));
                    } else {
                        ProductRepository.INSTANCE.getProducts(CollectionsKt.listOf(str2), this.this$0.getRealProductType(str), new Function2<List<? extends ProductDetails>, String, Unit>() { // from class: expo.modules.kickiap.KickIAPModule$definition$1$3$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ProductDetails> list, String str4) {
                                invoke2((List<ProductDetails>) list, str4);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(List<ProductDetails> products, String str4) {
                                Intrinsics.checkNotNullParameter(products, "products");
                                ProductDetails productDetails = (ProductDetails) CollectionsKt.firstOrNull((List) products);
                                if (productDetails == null || (!Intrinsics.areEqual(str4, "") && str4 != null)) {
                                    promise.resolve(MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.SUCCESS, false), TuplesKt.to("error", str4)));
                                    return;
                                }
                                PurchaseManager purchaseManager = PurchaseManager.INSTANCE;
                                Activity activity = currentActivity;
                                String str5 = str3;
                                final Promise promise2 = promise;
                                purchaseManager.startPurchase(activity, productDetails, str5, new Function2<BillingResult, String, Unit>() { // from class: expo.modules.kickiap.KickIAPModule$definition$1$3$1.1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(BillingResult billingResult, String str6) {
                                        invoke2(billingResult, str6);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(BillingResult billingResult, String purchaseErrorMessage) {
                                        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                                        Intrinsics.checkNotNullParameter(purchaseErrorMessage, "purchaseErrorMessage");
                                        int responseCode = billingResult.getResponseCode();
                                        if (responseCode == 0) {
                                            promise2.resolve(MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.SUCCESS, true), TuplesKt.to("transactionId", "no_implemented_yet")));
                                            return;
                                        }
                                        Promise promise3 = promise2;
                                        if (responseCode != 1) {
                                            promise3.resolve(MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.SUCCESS, false), TuplesKt.to("error", purchaseErrorMessage)));
                                        } else {
                                            promise3.resolve(MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.SUCCESS, false), TuplesKt.to("error", "userCancelled")));
                                        }
                                    }
                                });
                            }
                        });
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder3.getAsyncFunctions().put("purchaseAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            TypeConverterProvider converters3 = moduleDefinitionBuilder4.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6), new Function0<KType>() { // from class: expo.modules.kickiap.KickIAPModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th6) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                }
                TypeDescriptor typeDescriptor6 = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl6) ? null : objM12684constructorimpl6);
                if (typeDescriptor6 == null) {
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType6 = new AnyType(typeDescriptor6, converters3);
            }
            anyTypeArr3[0] = anyType6;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("finalizePurchaseAsync", anyTypeArr3, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kickiap.KickIAPModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$9
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    promise.resolve(MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.SUCCESS, false), TuplesKt.to("error", "Not implemented.")));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder4.getAsyncFunctions().put("finalizePurchaseAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th7) {
            Trace.endSection();
            throw th7;
        }
    }
}
