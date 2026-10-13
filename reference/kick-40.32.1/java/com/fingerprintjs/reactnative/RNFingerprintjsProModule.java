package com.fingerprintjs.reactnative;

import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.fingerprintjs.android.fpjs_pro.ApiKeyExpired;
import com.fingerprintjs.android.fpjs_pro.ApiKeyNotFound;
import com.fingerprintjs.android.fpjs_pro.ApiKeyRequired;
import com.fingerprintjs.android.fpjs_pro.ClientTimeout;
import com.fingerprintjs.android.fpjs_pro.Configuration;
import com.fingerprintjs.android.fpjs_pro.Error;
import com.fingerprintjs.android.fpjs_pro.Failed;
import com.fingerprintjs.android.fpjs_pro.FingerprintJS;
import com.fingerprintjs.android.fpjs_pro.FingerprintJSFactory;
import com.fingerprintjs.android.fpjs_pro.FingerprintJSProResponse;
import com.fingerprintjs.android.fpjs_pro.HeaderRestricted;
import com.fingerprintjs.android.fpjs_pro.InstallationMethodRestricted;
import com.fingerprintjs.android.fpjs_pro.InvalidProxyIntegrationHeaders;
import com.fingerprintjs.android.fpjs_pro.InvalidProxyIntegrationSecret;
import com.fingerprintjs.android.fpjs_pro.NetworkError;
import com.fingerprintjs.android.fpjs_pro.NotAvailableForCrawlBots;
import com.fingerprintjs.android.fpjs_pro.NotAvailableWithoutUA;
import com.fingerprintjs.android.fpjs_pro.OriginNotAvailable;
import com.fingerprintjs.android.fpjs_pro.ProxyIntegrationSecretEnvironmentMismatch;
import com.fingerprintjs.android.fpjs_pro.RequestCannotBeParsed;
import com.fingerprintjs.android.fpjs_pro.RequestTimeout;
import com.fingerprintjs.android.fpjs_pro.ResponseCannotBeParsed;
import com.fingerprintjs.android.fpjs_pro.SubscriptionNotActive;
import com.fingerprintjs.android.fpjs_pro.TooManyRequest;
import com.fingerprintjs.android.fpjs_pro.UnknownError;
import com.fingerprintjs.android.fpjs_pro.UnsupportedVersion;
import com.fingerprintjs.android.fpjs_pro.WrongRegion;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNFingerprintjsProModule.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016JL\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J$\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J3\u0010\u001d\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J3\u0010\"\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010 J\u001e\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020%0$2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/fingerprintjs/reactnative/RNFingerprintjsProModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "fpjsClient", "Lcom/fingerprintjs/android/fpjs_pro/FingerprintJS;", "getName", "", "configure", "", "apiToken", "regionKey", "endpointUrl", "fallbackEndpointUrls", "Lcom/facebook/react/bridge/ReadableArray;", "extendedResponseFormat", "", "pluginVersion", "allowUseOfLocationData", "locationTimeoutMillis", "", "getVisitorId", "tags", "Lcom/facebook/react/bridge/ReadableMap;", "linkedId", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "getVisitorIdWithTimeout", InstrumentationTags.TIMEOUT, "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;Ljava/lang/Integer;Lcom/facebook/react/bridge/Promise;)V", "getVisitorData", "getVisitorDataWithTimeout", "getTags", "", "", "getErrorDescription", "error", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "fingerprintjs_fingerprintjs-pro-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNFingerprintjsProModule extends ReactContextBaseJavaModule {
    private FingerprintJS fpjsClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNFingerprintjsProModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNFingerprintjsPro";
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005a A[REMOVE] */
    @ReactMethod
    public final void configure(String apiToken, String regionKey, String endpointUrl, ReadableArray fallbackEndpointUrls, boolean extendedResponseFormat, String pluginVersion, boolean allowUseOfLocationData, double locationTimeoutMillis) {
        Configuration.Region region;
        Intrinsics.checkNotNullParameter(apiToken, "apiToken");
        Intrinsics.checkNotNullParameter(fallbackEndpointUrls, "fallbackEndpointUrls");
        Intrinsics.checkNotNullParameter(pluginVersion, "pluginVersion");
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        FingerprintJSFactory fingerprintJSFactory = new FingerprintJSFactory(reactApplicationContext);
        if (regionKey != null) {
            int iHashCode = regionKey.hashCode();
            if (iHashCode != 3119) {
                if (iHashCode != 3248) {
                    if (iHashCode == 3742 && regionKey.equals("us")) {
                        region = Configuration.Region.US;
                    } else {
                        region = Configuration.Region.US;
                    }
                } else if (regionKey.equals("eu")) {
                    region = Configuration.Region.EU;
                } else {
                    region = Configuration.Region.US;
                }
            } else if (regionKey.equals("ap")) {
                region = Configuration.Region.AP;
            } else {
                region = Configuration.Region.US;
            }
        } else {
            region = Configuration.Region.US;
        }
        Configuration.Region region2 = region;
        List listListOf = CollectionsKt.listOf(new Pair("fingerprint-pro-react-native", pluginVersion));
        String endpointUrl2 = endpointUrl == null ? region2.getEndpointUrl() : endpointUrl;
        ArrayList<Object> arrayList = fallbackEndpointUrls.toArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof String) {
                arrayList2.add(obj);
            }
        }
        this.fpjsClient = fingerprintJSFactory.createInstance(new Configuration(apiToken, region2, endpointUrl2, extendedResponseFormat, arrayList2, listListOf, allowUseOfLocationData, (long) locationTimeoutMillis));
    }

    @ReactMethod
    public final void getVisitorId(ReadableMap tags, String linkedId, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        getVisitorIdWithTimeout(tags, linkedId, null, promise);
    }

    static final Unit getVisitorIdWithTimeout$lambda$0(Promise promise, FingerprintJSProResponse result) {
        Intrinsics.checkNotNullParameter(result, "result");
        promise.resolve(result.getVisitorId());
        return Unit.INSTANCE;
    }

    static final Unit getVisitorIdWithTimeout$lambda$1(Promise promise, RNFingerprintjsProModule rNFingerprintjsProModule, Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        promise.reject("Error: ", rNFingerprintjsProModule.getErrorDescription(error));
        return Unit.INSTANCE;
    }

    @ReactMethod
    public final void getVisitorIdWithTimeout(ReadableMap tags, String linkedId, Integer timeout, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        FingerprintJS fingerprintJS = this.fpjsClient;
        try {
            if (timeout != null) {
                if (fingerprintJS != null) {
                    fingerprintJS.getVisitorId(timeout.intValue(), getTags(tags), linkedId == null ? "" : linkedId, new Function1() { // from class: com.fingerprintjs.reactnative.RNFingerprintjsProModule$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RNFingerprintjsProModule.getVisitorIdWithTimeout$lambda$0(promise, (FingerprintJSProResponse) obj);
                        }
                    }, new Function1() { // from class: com.fingerprintjs.reactnative.RNFingerprintjsProModule$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RNFingerprintjsProModule.getVisitorIdWithTimeout$lambda$1(promise, this, (Error) obj);
                        }
                    });
                }
            } else if (fingerprintJS != null) {
                Map<String, ? extends Object> tags2 = getTags(tags);
                if (linkedId == null) {
                    linkedId = "";
                }
                fingerprintJS.getVisitorId(tags2, linkedId, new Function1() { // from class: com.fingerprintjs.reactnative.RNFingerprintjsProModule$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RNFingerprintjsProModule.getVisitorIdWithTimeout$lambda$2(promise, (FingerprintJSProResponse) obj);
                    }
                }, new Function1() { // from class: com.fingerprintjs.reactnative.RNFingerprintjsProModule$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RNFingerprintjsProModule.getVisitorIdWithTimeout$lambda$3(promise, this, (Error) obj);
                    }
                });
            }
        } catch (Exception e) {
            promise.reject("Error: ", e);
        }
    }

    static final Unit getVisitorIdWithTimeout$lambda$2(Promise promise, FingerprintJSProResponse result) {
        Intrinsics.checkNotNullParameter(result, "result");
        promise.resolve(result.getVisitorId());
        return Unit.INSTANCE;
    }

    static final Unit getVisitorIdWithTimeout$lambda$3(Promise promise, RNFingerprintjsProModule rNFingerprintjsProModule, Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        promise.reject("Error: ", rNFingerprintjsProModule.getErrorDescription(error));
        return Unit.INSTANCE;
    }

    @ReactMethod
    public final void getVisitorData(ReadableMap tags, String linkedId, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        getVisitorDataWithTimeout(tags, linkedId, null, promise);
    }

    @ReactMethod
    public final void getVisitorDataWithTimeout(ReadableMap tags, String linkedId, Integer timeout, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Function1<? super FingerprintJSProResponse, Unit> function1 = new Function1() { // from class: com.fingerprintjs.reactnative.RNFingerprintjsProModule$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RNFingerprintjsProModule.getVisitorDataWithTimeout$lambda$0(promise, (FingerprintJSProResponse) obj);
                }
            };
            FingerprintJS fingerprintJS = this.fpjsClient;
            if (timeout != null) {
                if (fingerprintJS != null) {
                    fingerprintJS.getVisitorId(timeout.intValue(), getTags(tags), linkedId == null ? "" : linkedId, function1, new Function1() { // from class: com.fingerprintjs.reactnative.RNFingerprintjsProModule$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RNFingerprintjsProModule.getVisitorDataWithTimeout$lambda$1(promise, this, (Error) obj);
                        }
                    });
                }
            } else if (fingerprintJS != null) {
                Map<String, ? extends Object> tags2 = getTags(tags);
                if (linkedId == null) {
                    linkedId = "";
                }
                fingerprintJS.getVisitorId(tags2, linkedId, function1, new Function1() { // from class: com.fingerprintjs.reactnative.RNFingerprintjsProModule$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RNFingerprintjsProModule.getVisitorDataWithTimeout$lambda$2(promise, this, (Error) obj);
                    }
                });
            }
        } catch (Exception e) {
            promise.reject("Error: ", e);
        }
    }

    static final Unit getVisitorDataWithTimeout$lambda$0(Promise promise, FingerprintJSProResponse result) {
        Intrinsics.checkNotNullParameter(result, "result");
        String requestId = result.getRequestId();
        Double dValueOf = Double.valueOf(result.getConfidenceScore().getScore());
        String asJson = result.getAsJson();
        String sealedResult = result.getSealedResult();
        if (sealedResult == null) {
            sealedResult = "";
        }
        promise.resolve(Arguments.fromList(CollectionsKt.listOf(requestId, dValueOf, asJson, sealedResult)));
        return Unit.INSTANCE;
    }

    static final Unit getVisitorDataWithTimeout$lambda$1(Promise promise, RNFingerprintjsProModule rNFingerprintjsProModule, Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        promise.reject("Error: ", rNFingerprintjsProModule.getErrorDescription(error));
        return Unit.INSTANCE;
    }

    static final Unit getVisitorDataWithTimeout$lambda$2(Promise promise, RNFingerprintjsProModule rNFingerprintjsProModule, Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        promise.reject("Error: ", rNFingerprintjsProModule.getErrorDescription(error));
        return Unit.INSTANCE;
    }

    private final Map<String, Object> getTags(ReadableMap tags) {
        HashMap<String, Object> hashMap;
        if (tags == null || (hashMap = tags.toHashMap()) == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            Intrinsics.checkNotNull(value);
            linkedHashMap3.put(key, value);
        }
        return linkedHashMap3;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x008d  */
    private final String getErrorDescription(Error error) {
        String str;
        if (error instanceof ApiKeyRequired) {
            str = "ApiKeyRequired";
        } else if (error instanceof ApiKeyNotFound) {
            str = "ApiKeyNotFound";
        } else if (error instanceof ApiKeyExpired) {
            str = "ApiKeyExpired";
        } else if (error instanceof RequestCannotBeParsed) {
            str = "RequestCannotBeParsed";
        } else if (error instanceof Failed) {
            str = "Failed";
        } else if (error instanceof RequestTimeout) {
            str = "RequestTimeout";
        } else if (error instanceof TooManyRequest) {
            str = "TooManyRequest";
        } else if (error instanceof OriginNotAvailable) {
            str = "OriginNotAvailable";
        } else if (error instanceof HeaderRestricted) {
            str = "HeaderRestricted";
        } else if (error instanceof NotAvailableForCrawlBots) {
            str = "NotAvailableForCrawlBots";
        } else if (error instanceof NotAvailableWithoutUA) {
            str = "NotAvailableWithoutUA";
        } else if (error instanceof WrongRegion) {
            str = "WrongRegion";
        } else if (error instanceof SubscriptionNotActive) {
            str = "SubscriptionNotActive";
        } else if (error instanceof UnsupportedVersion) {
            str = "UnsupportedVersion";
        } else if (error instanceof InstallationMethodRestricted) {
            str = "InstallationMethodRestricted";
        } else if (error instanceof ResponseCannotBeParsed) {
            str = "ResponseCannotBeParsed";
        } else if (error instanceof NetworkError) {
            str = "NetworkError";
        } else if (error instanceof ClientTimeout) {
            str = "ClientTimeout";
        } else if (error instanceof UnknownError) {
            str = "UnknownError";
        } else if (error instanceof InvalidProxyIntegrationHeaders) {
            str = "InvalidProxyIntegrationHeaders";
        } else if (error instanceof InvalidProxyIntegrationSecret) {
            str = "InvalidProxyIntegrationSecret";
        } else if (error instanceof ProxyIntegrationSecretEnvironmentMismatch) {
            str = "ProxyIntegrationSecretEnvironmentMismatch";
        } else {
            str = "UnknownError";
        }
        return str + ServerSentEventKt.COLON + error.getDescription();
    }
}
