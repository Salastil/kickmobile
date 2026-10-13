package com.amazon.mediatailorsdk;

import androidx.compose.runtime.GapComposerKt;
import com.amazon.mediatailorsdk.network.NetworkClient;
import com.amazon.mediatailorsdk.network.NetworkClientKt;
import com.amazon.mediatailorsdk.network.Resource;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
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
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AdBeaconManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.amazon.mediatailorsdk.AdBeaconManager$sendBeacon$1$1", f = "AdBeaconManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {121, GapComposerKt.nodeKey}, m = "invokeSuspend", n = {"$this$safeGet_u2dMLW3aMY_u24default$iv", "url$iv", "params$iv", "userAgent$iv", "$this$get$iv$iv", "urlString$iv$iv", "$this$get$iv$iv$iv", "$this$get$iv$iv$iv$iv", "builder$iv$iv$iv$iv", "$this$request$iv$iv$iv$iv$iv", "builder$iv$iv$iv$iv$iv", "timeout$iv", "maxRetry$iv", "$i$f$safeGet-MLW3aMY", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "$this$safeGet_u2dMLW3aMY_u24default$iv", "url$iv", "params$iv", "userAgent$iv", "$this$toResponse$iv$iv", "$this$body$iv$iv$iv", "timeout$iv", "maxRetry$iv", "$i$f$safeGet-MLW3aMY", "$i$f$toResponse", "$i$f$body"}, nl = {TimeseriesConfiguration.DEFAULT_BUFFER_SIZE, 135}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0", "I$1", "I$2", "I$3"}, v = 2)
final class AdBeaconManager$sendBeacon$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdData $adData;
    final /* synthetic */ AdData.TrackingEvent $beacon;
    final /* synthetic */ String $url;
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
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ AdBeaconManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdBeaconManager$sendBeacon$1$1(String str, AdBeaconManager adBeaconManager, AdData adData, AdData.TrackingEvent trackingEvent, Continuation<? super AdBeaconManager$sendBeacon$1$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.this$0 = adBeaconManager;
        this.$adData = adData;
        this.$beacon = trackingEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdBeaconManager$sendBeacon$1$1(this.$url, this.this$0, this.$adData, this.$beacon, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdBeaconManager$sendBeacon$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objExecute;
        HttpClient httpClient;
        String str;
        HashMap map;
        String str2;
        long j;
        int i;
        int i2;
        HttpResponse httpResponse;
        KType kTypeNullableTypeOf;
        Object objBodyNullable;
        Resource.Companion companion;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                HttpClient httpClient2 = MediaTailorKt.getNetwork().getHttpClient();
                String str3 = this.$url;
                HashMap map2 = new HashMap();
                String userAgent = NetworkClient.INSTANCE.getUserAgent();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str3);
                for (Map.Entry entry : map2.entrySet()) {
                    UtilsKt.parameter(httpRequestBuilder, (String) entry.getKey(), entry.getValue());
                }
                NetworkClientKt.timeout(httpRequestBuilder, 30000L);
                NetworkClientKt.retry(httpRequestBuilder, 7);
                HttpMessagePropertiesKt.userAgent(httpRequestBuilder, userAgent);
                httpRequestBuilder.setMethod(HttpMethod.Get);
                this.L$0 = SpillingKt.nullOutSpilledVariable(httpClient2);
                this.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                this.L$2 = SpillingKt.nullOutSpilledVariable(map2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(userAgent);
                this.L$4 = SpillingKt.nullOutSpilledVariable(httpClient2);
                this.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                this.L$6 = SpillingKt.nullOutSpilledVariable(httpClient2);
                this.L$7 = SpillingKt.nullOutSpilledVariable(httpClient2);
                this.L$8 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                this.L$9 = SpillingKt.nullOutSpilledVariable(httpClient2);
                this.L$10 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                this.J$0 = 30000L;
                this.I$0 = 7;
                this.I$1 = 0;
                this.I$2 = 0;
                this.I$3 = 0;
                this.I$4 = 0;
                this.I$5 = 0;
                this.label = 1;
                objExecute = new HttpStatement(httpRequestBuilder, httpClient2).execute(this);
                if (objExecute != coroutine_suspended) {
                    httpClient = httpClient2;
                    str = str3;
                    map = map2;
                    str2 = userAgent;
                    j = 30000;
                    i = 7;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i3 == 1) {
                int i4 = this.I$1;
                int i5 = this.I$0;
                long j2 = this.J$0;
                String str4 = (String) this.L$3;
                HashMap map3 = (HashMap) this.L$2;
                String str5 = (String) this.L$1;
                HttpClient httpClient3 = (HttpClient) this.L$0;
                ResultKt.throwOnFailure(obj);
                httpClient = httpClient3;
                str = str5;
                map = map3;
                str2 = str4;
                j = j2;
                i = i5;
                i2 = i4;
                objExecute = obj;
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Resource.Companion companion2 = (Resource.Companion) this.L$6;
                httpResponse = (HttpResponse) this.L$4;
                ResultKt.throwOnFailure(obj);
                objBodyNullable = obj;
                companion = companion2;
            }
            companion.success((String) objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
            this.this$0.onAdBeaconResponse(this.$adData, this.$beacon, this.$url, 200);
            return Unit.INSTANCE;
            httpResponse = (HttpResponse) objExecute;
            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                Resource.Companion companion3 = Resource.INSTANCE;
                HttpClientCall call = httpResponse.getCall();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                try {
                    kTypeNullableTypeOf = Reflection.nullableTypeOf(String.class);
                } catch (Throwable unused) {
                    kTypeNullableTypeOf = null;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(httpClient);
                this.L$1 = SpillingKt.nullOutSpilledVariable(str);
                this.L$2 = SpillingKt.nullOutSpilledVariable(map);
                this.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                this.L$4 = httpResponse;
                this.L$5 = SpillingKt.nullOutSpilledVariable(httpResponse);
                this.L$6 = companion3;
                this.L$7 = null;
                this.L$8 = null;
                this.L$9 = null;
                this.L$10 = null;
                this.J$0 = j;
                this.I$0 = i;
                this.I$1 = i2;
                this.I$2 = 0;
                this.I$3 = 0;
                this.label = 2;
                objBodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass, kTypeNullableTypeOf), this);
                if (objBodyNullable != coroutine_suspended) {
                    companion = companion3;
                    companion.success((String) objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
                }
                return coroutine_suspended;
            }
            Resource.INSTANCE.error(new Throwable("Something went wrong"));
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                Resource.INSTANCE.error(new Throwable("Unreachable Server"));
            } else {
                Resource.INSTANCE.error(th);
            }
        }
        this.this$0.onAdBeaconResponse(this.$adData, this.$beacon, this.$url, 200);
        return Unit.INSTANCE;
    }
}
