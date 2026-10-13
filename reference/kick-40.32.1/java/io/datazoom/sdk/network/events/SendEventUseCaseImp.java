package io.datazoom.sdk.network.events;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.network.NetworkClient;
import io.datazoom.sdk.network.NetworkClientKt;
import io.datazoom.sdk.network.Resource;
import io.datazoom.sdk.network.ResponseHeadersKt;
import io.datazoom.sdk.network.events.model.EventDto;
import io.datazoom.sdk.network.events.model.EventResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
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
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: SendEventUseCase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/datazoom/sdk/network/events/SendEventUseCaseImp;", "Lio/datazoom/sdk/network/events/SendEventUseCase;", "network", "Lio/datazoom/sdk/network/NetworkClient;", "<init>", "(Lio/datazoom/sdk/network/NetworkClient;)V", "invoke", "Lio/datazoom/sdk/network/Resource;", "Lio/datazoom/sdk/network/events/model/EventResponse;", "list", "", "Lio/datazoom/sdk/network/events/model/EventDto;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SendEventUseCaseImp implements SendEventUseCase {
    private final NetworkClient network;

    /* JADX INFO: renamed from: io.datazoom.sdk.network.events.SendEventUseCaseImp$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SendEventUseCase.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.network.events.SendEventUseCaseImp", f = "SendEventUseCase.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION, 65}, m = "invoke", n = {"list", "$this$safePost$iv", "url$iv", "data$iv", "$this$post$iv$iv", "urlString$iv$iv", "$this$post$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "builder$iv$iv$iv$iv", "$i$f$safePost", "$i$f$post", "$i$f$post", "$i$f$request", "list", "$this$safePost$iv", "url$iv", "data$iv", "$this$toResponse$iv$iv", "responseHeaders$iv$iv", "$this$body$iv$iv$iv", "$i$f$safePost", "$i$f$toResponse", "$i$f$body"}, nl = {58, 66}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
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
            return SendEventUseCaseImp.this.invoke(null, this);
        }
    }

    public SendEventUseCaseImp(NetworkClient network) {
        Intrinsics.checkNotNullParameter(network, "network");
        this.network = network;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // io.datazoom.sdk.network.events.SendEventUseCase
    public Object invoke(List<EventDto> list, Continuation<? super Resource<EventResponse>> continuation) {
        AnonymousClass1 anonymousClass1;
        KType kTypeTypeOf;
        List<EventDto> list2;
        HttpClient httpClient;
        String str;
        Object obj;
        int i;
        KType kTypeTypeOf2;
        KType kTypeNullableTypeOf;
        HttpResponse httpResponse;
        Map<String, List<String>> map;
        Resource.Companion companion;
        List<EventDto> list3 = list;
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
        Object objBodyNullable = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    int i3 = anonymousClass1.I$3;
                    int i4 = anonymousClass1.I$2;
                    int i5 = anonymousClass1.I$1;
                    int i6 = anonymousClass1.I$0;
                    List<EventDto> list4 = (List) anonymousClass1.L$3;
                    String str2 = (String) anonymousClass1.L$2;
                    HttpClient httpClient2 = (HttpClient) anonymousClass1.L$1;
                    List<EventDto> list5 = (List) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objBodyNullable);
                    i = i6;
                    list2 = list4;
                    list3 = list5;
                    httpClient = httpClient2;
                    str = str2;
                    obj = objBodyNullable;
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i7 = anonymousClass1.I$2;
                    int i8 = anonymousClass1.I$1;
                    int i9 = anonymousClass1.I$0;
                    Resource.Companion companion2 = (Resource.Companion) anonymousClass1.L$7;
                    Map<String, List<String>> map2 = (Map) anonymousClass1.L$5;
                    httpResponse = (HttpResponse) anonymousClass1.L$4;
                    ResultKt.throwOnFailure(objBodyNullable);
                    companion = companion2;
                    map = map2;
                }
                return companion.success((EventResponse) objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp(), map);
            }
            ResultKt.throwOnFailure(objBodyNullable);
            HttpClient httpClient3 = this.network.getHttpClient();
            String brokerUrl = this.network.getBrokerUrl();
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpRequestKt.url(httpRequestBuilder, brokerUrl);
            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
            if (list3 == null) {
                httpRequestBuilder.setBody(NullBody.INSTANCE);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
                try {
                    kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(EventDto.class)));
                } catch (Throwable unused) {
                    kTypeTypeOf2 = null;
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf2));
            } else if (list3 instanceof OutgoingContent) {
                httpRequestBuilder.setBody(list3);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(list3);
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(List.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(EventDto.class)));
                } catch (Throwable unused2) {
                    kTypeTypeOf = null;
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kTypeTypeOf));
            }
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, NetworkClientKt.getUserAgent());
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient3);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list3);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(httpClient3);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(brokerUrl);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list3);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(httpClient3);
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(brokerUrl);
            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(httpClient3);
            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
            anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(httpClient3);
            anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.I$2 = 0;
            anonymousClass1.I$3 = 0;
            anonymousClass1.label = 1;
            Object objExecute = httpStatement.execute(anonymousClass1);
            if (objExecute != coroutine_suspended) {
                list2 = list3;
                httpClient = httpClient3;
                str = brokerUrl;
                obj = objExecute;
                i = 0;
            }
            return coroutine_suspended;
            HttpResponse httpResponse2 = (HttpResponse) obj;
            Map<String, List<String>> mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse2.getHeaders());
            if (!HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                return Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
            }
            Resource.Companion companion3 = Resource.INSTANCE;
            HttpClientCall call = httpResponse2.getCall();
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(EventResponse.class);
            try {
                kTypeNullableTypeOf = Reflection.nullableTypeOf(EventResponse.class);
            } catch (Throwable unused3) {
                kTypeNullableTypeOf = null;
            }
            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kTypeNullableTypeOf);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list3);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(httpClient);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list2);
            anonymousClass1.L$4 = httpResponse2;
            anonymousClass1.L$5 = mapAsResponseHeaders;
            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(httpResponse2);
            anonymousClass1.L$7 = companion3;
            anonymousClass1.L$8 = null;
            anonymousClass1.L$9 = null;
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = 0;
            anonymousClass1.I$2 = 0;
            anonymousClass1.label = 2;
            objBodyNullable = call.bodyNullable(typeInfo, anonymousClass1);
            if (objBodyNullable != coroutine_suspended) {
                httpResponse = httpResponse2;
                map = mapAsResponseHeaders;
                companion = companion3;
                return companion.success((EventResponse) objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp(), map);
            }
            return coroutine_suspended;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                return Resource.Companion.error$default(Resource.INSTANCE, new Throwable("Unreachable Server"), null, 2, null);
            }
            Resource.Companion companion4 = Resource.INSTANCE;
            String message2 = e.getMessage();
            return Resource.Companion.error$default(companion4, new Throwable(message2 != null ? message2 : "Something went wrong"), null, 2, null);
        } catch (Throwable th) {
            return Resource.Companion.error$default(Resource.INSTANCE, th, null, 2, null);
        }
    }
}
