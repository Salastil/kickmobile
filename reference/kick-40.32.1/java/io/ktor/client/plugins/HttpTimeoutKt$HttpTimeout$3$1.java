package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: HttpTimeout.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeoutKt$HttpTimeout$3$1", f = "HttpTimeout.kt", i = {0, 0, 0, 0}, l = {168}, m = "invokeSuspend", n = {"$this$on", "request", "configuration", "supportsRequestTimeout"}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 1)
final class HttpTimeoutKt$HttpTimeout$3$1 extends SuspendLambda implements Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ Long $connectTimeoutMillis;
    final /* synthetic */ Long $requestTimeoutMillis;
    final /* synthetic */ Long $socketTimeoutMillis;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpTimeoutKt$HttpTimeout$3$1(Long l, Long l2, Long l3, Continuation<? super HttpTimeoutKt$HttpTimeout$3$1> continuation) {
        super(3, continuation);
        this.$requestTimeoutMillis = l;
        this.$connectTimeoutMillis = l2;
        this.$socketTimeoutMillis = l3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpTimeoutKt$HttpTimeout$3$1 httpTimeoutKt$HttpTimeout$3$1 = new HttpTimeoutKt$HttpTimeout$3$1(this.$requestTimeoutMillis, this.$connectTimeoutMillis, this.$socketTimeoutMillis, continuation);
        httpTimeoutKt$HttpTimeout$3$1.L$0 = sender;
        httpTimeoutKt$HttpTimeout$3$1.L$1 = httpRequestBuilder;
        return httpTimeoutKt$HttpTimeout$3$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Send.Sender sender = (Send.Sender) this.L$0;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        boolean supportsRequestTimeout = HttpTimeoutKt.getSupportsRequestTimeout(httpRequestBuilder);
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) httpRequestBuilder.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        if (httpTimeoutConfig == null && HttpTimeoutKt.HttpTimeout$lambda$1$hasNotNullTimeouts(this.$requestTimeoutMillis, this.$connectTimeoutMillis, this.$socketTimeoutMillis, supportsRequestTimeout)) {
            HttpTimeoutConfig httpTimeoutConfig2 = new HttpTimeoutConfig(null, null, null, 7, null);
            httpRequestBuilder.setCapability(HttpTimeoutCapability.INSTANCE, httpTimeoutConfig2);
            httpTimeoutConfig = httpTimeoutConfig2;
        }
        if (httpTimeoutConfig != null) {
            Long l = this.$connectTimeoutMillis;
            Long l2 = this.$socketTimeoutMillis;
            Long l3 = this.$requestTimeoutMillis;
            Long l4 = httpTimeoutConfig.get_connectTimeoutMillis();
            if (l4 != null) {
                l = l4;
            }
            httpTimeoutConfig.setConnectTimeoutMillis(l);
            Long l5 = httpTimeoutConfig.get_socketTimeoutMillis();
            if (l5 != null) {
                l2 = l5;
            }
            httpTimeoutConfig.setSocketTimeoutMillis(l2);
            if (supportsRequestTimeout) {
                Long l6 = httpTimeoutConfig.get_requestTimeoutMillis();
                if (l6 != null) {
                    l3 = l6;
                }
                httpTimeoutConfig.setRequestTimeoutMillis(l3);
                HttpTimeoutKt.applyRequestTimeout(sender, httpRequestBuilder, httpTimeoutConfig.get_requestTimeoutMillis());
            }
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(sender);
        this.L$1 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
        this.L$2 = SpillingKt.nullOutSpilledVariable(httpTimeoutConfig);
        this.Z$0 = supportsRequestTimeout;
        this.label = 1;
        Object objProceed = sender.proceed(httpRequestBuilder, this);
        return objProceed == coroutine_suspended ? coroutine_suspended : objProceed;
    }
}
