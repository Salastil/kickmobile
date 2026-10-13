package com.amazon.mediatailorsdk.network.tracking;

import com.amazon.mediatailorsdk.network.NetworkClient;
import com.amazon.mediatailorsdk.network.NetworkClientKt;
import com.amazon.mediatailorsdk.network.Resource;
import com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AdTrackingUseCase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J@\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001`\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/AdTrackingUseCase;", "", "network", "Lcom/amazon/mediatailorsdk/network/NetworkClient;", "<init>", "(Lcom/amazon/mediatailorsdk/network/NetworkClient;)V", "invoke", "Lcom/amazon/mediatailorsdk/network/Resource;", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse;", "trackingUrl", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AdTrackingUseCase {
    private final NetworkClient network;

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.network.tracking.AdTrackingUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: AdTrackingUseCase.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.network.tracking.AdTrackingUseCase", f = "AdTrackingUseCase.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {37, 41}, m = "invoke", n = {"trackingUrl", "params", "$this$safeGet_u2dMLW3aMY_u24default$iv", "url$iv", "params$iv", "userAgent$iv", "$this$get$iv$iv", "urlString$iv$iv", "$this$get$iv$iv$iv", "$this$get$iv$iv$iv$iv", "builder$iv$iv$iv$iv", "$this$request$iv$iv$iv$iv$iv", "builder$iv$iv$iv$iv$iv", "timeout$iv", "maxRetry$iv", "$i$f$safeGet-MLW3aMY", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "trackingUrl", "params", "$this$safeGet_u2dMLW3aMY_u24default$iv", "url$iv", "params$iv", "userAgent$iv", "$this$toResponse$iv$iv", "$this$body$iv$iv$iv", "timeout$iv", "maxRetry$iv", "$i$f$safeGet-MLW3aMY", "$i$f$toResponse", "$i$f$body"}, nl = {36, 51}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "J$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0", "I$1", "I$2", "I$3"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AdTrackingUseCase.this.invoke(null, null, this);
        }
    }

    public AdTrackingUseCase(NetworkClient network) {
        Intrinsics.checkNotNullParameter(network, "network");
        this.network = network;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object invoke(String str, HashMap<String, Object> map, Continuation<? super Resource<AdTrackingResponse>> continuation) {
        AnonymousClass1 anonymousClass1;
        HttpClient httpClient;
        String userAgent;
        long j;
        int i;
        HashMap<String, Object> map2;
        HashMap<String, Object> map3;
        String str2;
        String str3;
        int i2;
        KType kTypeNullableTypeOf;
        HttpResponse httpResponse;
        Resource.Companion companion;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                httpClient = this.network.getHttpClient();
                userAgent = NetworkClient.INSTANCE.getUserAgent();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str);
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    UtilsKt.parameter(httpRequestBuilder, entry.getKey(), entry.getValue());
                }
                j = 30000;
                NetworkClientKt.timeout(httpRequestBuilder, 30000L);
                i = 7;
                NetworkClientKt.retry(httpRequestBuilder, 7);
                HttpMessagePropertiesKt.userAgent(httpRequestBuilder, userAgent);
                httpRequestBuilder.setMethod(HttpMethod.Get);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(map);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(map);
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(userAgent);
                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(httpClient);
                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(httpClient);
                anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(httpClient);
                anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(httpClient);
                anonymousClass1.L$12 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                anonymousClass1.J$0 = 30000L;
                anonymousClass1.I$0 = 7;
                anonymousClass1.I$1 = 0;
                anonymousClass1.I$2 = 0;
                anonymousClass1.I$3 = 0;
                anonymousClass1.I$4 = 0;
                anonymousClass1.I$5 = 0;
                anonymousClass1.label = 1;
                Object objExecute = httpStatement.execute(anonymousClass1);
                if (objExecute != coroutine_suspended) {
                    map2 = map;
                    map3 = map2;
                    str2 = str;
                    str3 = str2;
                    obj = objExecute;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i3 == 1) {
                int i4 = anonymousClass1.I$5;
                int i5 = anonymousClass1.I$4;
                int i6 = anonymousClass1.I$3;
                int i7 = anonymousClass1.I$2;
                i2 = anonymousClass1.I$1;
                i = anonymousClass1.I$0;
                j = anonymousClass1.J$0;
                userAgent = (String) anonymousClass1.L$5;
                map2 = (HashMap) anonymousClass1.L$4;
                str2 = (String) anonymousClass1.L$3;
                httpClient = (HttpClient) anonymousClass1.L$2;
                map3 = (HashMap) anonymousClass1.L$1;
                str3 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i8 = anonymousClass1.I$3;
                int i9 = anonymousClass1.I$2;
                int i10 = anonymousClass1.I$1;
                int i11 = anonymousClass1.I$0;
                long j2 = anonymousClass1.J$0;
                Resource.Companion companion2 = (Resource.Companion) anonymousClass1.L$8;
                httpResponse = (HttpResponse) anonymousClass1.L$6;
                ResultKt.throwOnFailure(obj);
                companion = companion2;
            }
            return companion.success((AdTrackingResponse) obj, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
            HttpResponse httpResponse2 = (HttpResponse) obj;
            if (HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                Resource.Companion companion3 = Resource.INSTANCE;
                HttpClientCall call = httpResponse2.getCall();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AdTrackingResponse.class);
                String str4 = userAgent;
                try {
                    kTypeNullableTypeOf = Reflection.nullableTypeOf(AdTrackingResponse.class);
                } catch (Throwable unused) {
                    kTypeNullableTypeOf = null;
                }
                HashMap<String, Object> map4 = map2;
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeNullableTypeOf);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(map4);
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                anonymousClass1.L$6 = httpResponse2;
                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                anonymousClass1.L$8 = companion3;
                anonymousClass1.L$9 = null;
                anonymousClass1.L$10 = null;
                anonymousClass1.L$11 = null;
                anonymousClass1.L$12 = null;
                anonymousClass1.J$0 = j;
                anonymousClass1.I$0 = i;
                anonymousClass1.I$1 = i2;
                anonymousClass1.I$2 = 0;
                anonymousClass1.I$3 = 0;
                anonymousClass1.label = 2;
                Object objBodyNullable = call.bodyNullable(typeInfo, anonymousClass1);
                if (objBodyNullable != coroutine_suspended) {
                    httpResponse = httpResponse2;
                    companion = companion3;
                    obj = objBodyNullable;
                    return companion.success((AdTrackingResponse) obj, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
                }
                return coroutine_suspended;
            }
            return Resource.INSTANCE.error(new Throwable("Something went wrong"));
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                return Resource.INSTANCE.error(new Throwable("Unreachable Server"));
            }
            return Resource.INSTANCE.error(th);
        }
    }
}
