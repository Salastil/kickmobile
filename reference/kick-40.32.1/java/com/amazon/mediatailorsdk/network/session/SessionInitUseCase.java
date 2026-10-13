package com.amazon.mediatailorsdk.network.session;

import com.amazon.mediatailorsdk.network.NetworkClient;
import com.amazon.mediatailorsdk.network.NetworkClientKt;
import com.amazon.mediatailorsdk.network.Resource;
import com.amazon.mediatailorsdk.network.session.model.SessionInitRequest;
import com.amazon.mediatailorsdk.network.session.model.SessionInitResponse;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
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
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SessionInitUseCase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JL\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/amazon/mediatailorsdk/network/session/SessionInitUseCase;", "", "network", "Lcom/amazon/mediatailorsdk/network/NetworkClient;", "<init>", "(Lcom/amazon/mediatailorsdk/network/NetworkClient;)V", "invoke", "Lcom/amazon/mediatailorsdk/network/Resource;", "Lcom/amazon/mediatailorsdk/network/session/model/SessionInitResponse;", "sessionInitUrl", "", "data", "Lcom/amazon/mediatailorsdk/network/session/model/SessionInitRequest;", "extraHeaders", "", InstrumentationTags.TIMEOUT, "", "maxRetry", "Lkotlin/UInt;", "invoke-bPJOTnY", "(Ljava/lang/String;Lcom/amazon/mediatailorsdk/network/session/model/SessionInitRequest;Ljava/util/Map;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SessionInitUseCase {
    private final NetworkClient network;

    public SessionInitUseCase(NetworkClient network) {
        Intrinsics.checkNotNullParameter(network, "network");
        this.network = network;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX INFO: renamed from: invoke-bPJOTnY, reason: not valid java name */
    public final Object m10987invokebPJOTnY(String str, SessionInitRequest sessionInitRequest, Map<String, String> map, long j, int i, Continuation<? super Resource<SessionInitResponse>> continuation) {
        SessionInitUseCase$invoke$1 sessionInitUseCase$invoke$1;
        KType kTypeTypeOf;
        Map<String, String> map2;
        Object obj;
        SessionInitRequest sessionInitRequest2;
        long j2;
        String str2;
        String str3;
        String str4;
        HttpClient httpClient;
        int i2;
        Map<String, String> map3;
        int i3;
        int i4;
        long j3;
        KType kTypeTypeOf2;
        KType kTypeNullableTypeOf;
        HttpResponse httpResponse;
        Resource.Companion companion;
        SessionInitRequest sessionInitRequest3 = sessionInitRequest;
        if (continuation instanceof SessionInitUseCase$invoke$1) {
            sessionInitUseCase$invoke$1 = (SessionInitUseCase$invoke$1) continuation;
            if ((sessionInitUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                sessionInitUseCase$invoke$1.label -= Integer.MIN_VALUE;
            } else {
                sessionInitUseCase$invoke$1 = new SessionInitUseCase$invoke$1(this, continuation);
            }
        } else {
            sessionInitUseCase$invoke$1 = new SessionInitUseCase$invoke$1(this, continuation);
        }
        Object objBodyNullable = sessionInitUseCase$invoke$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = sessionInitUseCase$invoke$1.label;
        try {
            if (i5 != 0) {
                if (i5 == 1) {
                    int i6 = sessionInitUseCase$invoke$1.I$5;
                    int i7 = sessionInitUseCase$invoke$1.I$4;
                    int i8 = sessionInitUseCase$invoke$1.I$3;
                    int i9 = sessionInitUseCase$invoke$1.I$2;
                    int i10 = sessionInitUseCase$invoke$1.I$1;
                    long j4 = sessionInitUseCase$invoke$1.J$1;
                    int i11 = sessionInitUseCase$invoke$1.I$0;
                    j2 = sessionInitUseCase$invoke$1.J$0;
                    String str5 = (String) sessionInitUseCase$invoke$1.L$7;
                    map2 = (Map) sessionInitUseCase$invoke$1.L$6;
                    sessionInitRequest2 = (SessionInitRequest) sessionInitUseCase$invoke$1.L$5;
                    str3 = (String) sessionInitUseCase$invoke$1.L$4;
                    HttpClient httpClient2 = (HttpClient) sessionInitUseCase$invoke$1.L$3;
                    Map<String, String> map4 = (Map) sessionInitUseCase$invoke$1.L$2;
                    SessionInitRequest sessionInitRequest4 = (SessionInitRequest) sessionInitUseCase$invoke$1.L$1;
                    String str6 = (String) sessionInitUseCase$invoke$1.L$0;
                    ResultKt.throwOnFailure(objBodyNullable);
                    obj = objBodyNullable;
                    str4 = str5;
                    httpClient = httpClient2;
                    i2 = i9;
                    str2 = str6;
                    i4 = i10;
                    i3 = i11;
                    sessionInitRequest3 = sessionInitRequest4;
                    j3 = j4;
                    map3 = map4;
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i12 = sessionInitUseCase$invoke$1.I$4;
                    int i13 = sessionInitUseCase$invoke$1.I$3;
                    int i14 = sessionInitUseCase$invoke$1.I$2;
                    int i15 = sessionInitUseCase$invoke$1.I$1;
                    long j5 = sessionInitUseCase$invoke$1.J$1;
                    int i16 = sessionInitUseCase$invoke$1.I$0;
                    long j6 = sessionInitUseCase$invoke$1.J$0;
                    companion = (Resource.Companion) sessionInitUseCase$invoke$1.L$10;
                    httpResponse = (HttpResponse) sessionInitUseCase$invoke$1.L$8;
                    ResultKt.throwOnFailure(objBodyNullable);
                }
                return companion.success((SessionInitResponse) objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
            }
            ResultKt.throwOnFailure(objBodyNullable);
            HttpClient httpClient3 = this.network.getHttpClient();
            String userAgent = NetworkClient.INSTANCE.getUserAgent();
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpRequestKt.url(httpRequestBuilder, str);
            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
            if (sessionInitRequest3 == null) {
                httpRequestBuilder.setBody(NullBody.INSTANCE);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SessionInitRequest.class);
                try {
                    kTypeTypeOf2 = Reflection.typeOf(SessionInitRequest.class);
                } catch (Throwable unused) {
                    kTypeTypeOf2 = null;
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf2));
            } else if (sessionInitRequest3 instanceof OutgoingContent) {
                httpRequestBuilder.setBody(sessionInitRequest3);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(sessionInitRequest3);
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(SessionInitRequest.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(SessionInitRequest.class);
                } catch (Throwable unused2) {
                    kTypeTypeOf = null;
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kTypeTypeOf));
            }
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpRequestBuilder.getHeaders().append(entry.getKey(), entry.getValue());
                }
            }
            NetworkClientKt.timeout(httpRequestBuilder, j);
            NetworkClientKt.retry(httpRequestBuilder, i);
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, userAgent);
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient3);
            sessionInitUseCase$invoke$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            sessionInitUseCase$invoke$1.L$1 = SpillingKt.nullOutSpilledVariable(sessionInitRequest3);
            sessionInitUseCase$invoke$1.L$2 = SpillingKt.nullOutSpilledVariable(map);
            sessionInitUseCase$invoke$1.L$3 = SpillingKt.nullOutSpilledVariable(httpClient3);
            sessionInitUseCase$invoke$1.L$4 = SpillingKt.nullOutSpilledVariable(str);
            sessionInitUseCase$invoke$1.L$5 = SpillingKt.nullOutSpilledVariable(sessionInitRequest3);
            sessionInitUseCase$invoke$1.L$6 = SpillingKt.nullOutSpilledVariable(map);
            sessionInitUseCase$invoke$1.L$7 = SpillingKt.nullOutSpilledVariable(userAgent);
            sessionInitUseCase$invoke$1.L$8 = SpillingKt.nullOutSpilledVariable(httpClient3);
            sessionInitUseCase$invoke$1.L$9 = SpillingKt.nullOutSpilledVariable(str);
            sessionInitUseCase$invoke$1.L$10 = SpillingKt.nullOutSpilledVariable(httpClient3);
            sessionInitUseCase$invoke$1.L$11 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
            sessionInitUseCase$invoke$1.L$12 = SpillingKt.nullOutSpilledVariable(httpClient3);
            sessionInitUseCase$invoke$1.L$13 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
            sessionInitUseCase$invoke$1.J$0 = j;
            sessionInitUseCase$invoke$1.I$0 = i;
            sessionInitUseCase$invoke$1.J$1 = j;
            sessionInitUseCase$invoke$1.I$1 = i;
            sessionInitUseCase$invoke$1.I$2 = 0;
            sessionInitUseCase$invoke$1.I$3 = 0;
            sessionInitUseCase$invoke$1.I$4 = 0;
            sessionInitUseCase$invoke$1.I$5 = 0;
            sessionInitUseCase$invoke$1.label = 1;
            Object objExecute = httpStatement.execute(sessionInitUseCase$invoke$1);
            if (objExecute != coroutine_suspended) {
                map2 = map;
                obj = objExecute;
                sessionInitRequest2 = sessionInitRequest3;
                j2 = j;
                str2 = str;
                str3 = str2;
                str4 = userAgent;
                httpClient = httpClient3;
                i2 = 0;
                map3 = map2;
                i3 = i;
                i4 = i3;
                j3 = j2;
            }
            return coroutine_suspended;
            HttpResponse httpResponse2 = (HttpResponse) obj;
            if (!HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                return Resource.INSTANCE.error(new Throwable("Something went wrong"));
            }
            SessionInitRequest sessionInitRequest5 = sessionInitRequest3;
            Resource.Companion companion2 = Resource.INSTANCE;
            Map<String, String> map5 = map3;
            HttpClientCall call = httpResponse2.getCall();
            Map<String, String> map6 = map2;
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(SessionInitResponse.class);
            try {
                kTypeNullableTypeOf = Reflection.nullableTypeOf(SessionInitResponse.class);
            } catch (Throwable unused3) {
                kTypeNullableTypeOf = null;
            }
            String str7 = str3;
            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kTypeNullableTypeOf);
            sessionInitUseCase$invoke$1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
            sessionInitUseCase$invoke$1.L$1 = SpillingKt.nullOutSpilledVariable(sessionInitRequest5);
            sessionInitUseCase$invoke$1.L$2 = SpillingKt.nullOutSpilledVariable(map5);
            sessionInitUseCase$invoke$1.L$3 = SpillingKt.nullOutSpilledVariable(httpClient);
            sessionInitUseCase$invoke$1.L$4 = SpillingKt.nullOutSpilledVariable(str7);
            sessionInitUseCase$invoke$1.L$5 = SpillingKt.nullOutSpilledVariable(sessionInitRequest2);
            sessionInitUseCase$invoke$1.L$6 = SpillingKt.nullOutSpilledVariable(map6);
            sessionInitUseCase$invoke$1.L$7 = SpillingKt.nullOutSpilledVariable(str4);
            sessionInitUseCase$invoke$1.L$8 = httpResponse2;
            sessionInitUseCase$invoke$1.L$9 = SpillingKt.nullOutSpilledVariable(httpResponse2);
            sessionInitUseCase$invoke$1.L$10 = companion2;
            sessionInitUseCase$invoke$1.L$11 = null;
            sessionInitUseCase$invoke$1.L$12 = null;
            sessionInitUseCase$invoke$1.L$13 = null;
            sessionInitUseCase$invoke$1.J$0 = j2;
            sessionInitUseCase$invoke$1.I$0 = i3;
            sessionInitUseCase$invoke$1.J$1 = j3;
            sessionInitUseCase$invoke$1.I$1 = i4;
            sessionInitUseCase$invoke$1.I$2 = i2;
            sessionInitUseCase$invoke$1.I$3 = 0;
            sessionInitUseCase$invoke$1.I$4 = 0;
            sessionInitUseCase$invoke$1.label = 2;
            objBodyNullable = call.bodyNullable(typeInfo, sessionInitUseCase$invoke$1);
            if (objBodyNullable != coroutine_suspended) {
                httpResponse = httpResponse2;
                companion = companion2;
                return companion.success((SessionInitResponse) objBodyNullable, httpResponse.getRequestTime().getTimestamp(), httpResponse.getResponseTime().getTimestamp());
            }
            return coroutine_suspended;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                return Resource.INSTANCE.error(new Throwable("Unreachable Server"));
            }
            Resource.Companion companion3 = Resource.INSTANCE;
            String message2 = e.getMessage();
            return companion3.error(new Throwable(message2 != null ? message2 : "Something went wrong"));
        } catch (Throwable th) {
            return Resource.INSTANCE.error(th);
        }
    }
}
