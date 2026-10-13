package io.datazoom.sdk.network.timeSync;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import io.datazoom.sdk.data.memory.FlagsPersistence;
import io.datazoom.sdk.data.memory.ServerTimeOffsetPersistence;
import io.datazoom.sdk.model.PendingFlag;
import io.datazoom.sdk.network.NetworkClient;
import io.datazoom.sdk.network.NetworkClientKt;
import io.datazoom.sdk.network.Resource;
import io.datazoom.sdk.network.ResponseHeadersKt;
import io.datazoom.sdk.network.timeSync.model.TimeSyncResponse;
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
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: ServerTimeSyncUseCase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0086B¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/datazoom/sdk/network/timeSync/ServerTimeSyncUseCase;", "", "network", "Lio/datazoom/sdk/network/NetworkClient;", "flagsPersistence", "Lio/datazoom/sdk/data/memory/FlagsPersistence;", "<init>", "(Lio/datazoom/sdk/network/NetworkClient;Lio/datazoom/sdk/data/memory/FlagsPersistence;)V", "invoke", "Lio/datazoom/sdk/network/Resource;", "Lio/datazoom/sdk/network/timeSync/model/TimeSyncResponse;", ImagesContract.URL, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ServerTimeSyncUseCase {
    private final FlagsPersistence flagsPersistence;
    private final NetworkClient network;

    /* JADX INFO: renamed from: io.datazoom.sdk.network.timeSync.ServerTimeSyncUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerTimeSyncUseCase.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.network.timeSync.ServerTimeSyncUseCase", f = "ServerTimeSyncUseCase.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {17, 53, EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION}, m = "invoke", n = {ImagesContract.URL, ImagesContract.URL, "$this$safeGet_u24default$iv", "url$iv", "params$iv", "$this$get$iv$iv", "urlString$iv$iv", "$this$get$iv$iv$iv", "$this$get$iv$iv$iv$iv", "builder$iv$iv$iv$iv", "$this$request$iv$iv$iv$iv$iv", "builder$iv$iv$iv$iv$iv", "$i$f$safeGet", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", ImagesContract.URL, "$this$safeGet_u24default$iv", "url$iv", "params$iv", "$this$toResponse$iv$iv", "responseHeaders$iv$iv", "$this$body$iv$iv$iv", "$i$f$safeGet", "$i$f$toResponse", "$i$f$body"}, nl = {19, 52, EACTags.DISPLAY_IMAGE}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ServerTimeSyncUseCase.this.invoke(null, this);
        }
    }

    public ServerTimeSyncUseCase(NetworkClient network, FlagsPersistence flagsPersistence) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(flagsPersistence, "flagsPersistence");
        this.network = network;
        this.flagsPersistence = flagsPersistence;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x017d A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #1 {all -> 0x00a2, blocks: (B:14:0x0058, B:47:0x01d7, B:19:0x009d, B:37:0x0169, B:39:0x017d, B:43:0x0193, B:48:0x01f4, B:29:0x00d0, B:30:0x00e3, B:32:0x00e9, B:33:0x00fd), top: B:66:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:48:0x01f4 A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #1 {all -> 0x00a2, blocks: (B:14:0x0058, B:47:0x01d7, B:19:0x009d, B:37:0x0169, B:39:0x017d, B:43:0x0193, B:48:0x01f4, B:29:0x00d0, B:30:0x00e3, B:32:0x00e9, B:33:0x00fd), top: B:66:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0231  */
    /* JADX WARN: Code duplicated, block: B:60:0x0243  */
    /* JADX WARN: Code duplicated, block: B:61:0x0248  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object invoke(String str, Continuation<? super Resource<TimeSyncResponse>> continuation) {
        AnonymousClass1 anonymousClass1;
        Resource resourceError$default;
        TimeSyncResponse timeSyncResponse;
        long serverTime;
        String str2;
        HttpClient httpClient;
        HashMap map;
        String str3;
        String str4;
        int i;
        HttpResponse httpResponse;
        Map<String, List<String>> mapAsResponseHeaders;
        Resource.Companion companion;
        KType kTypeNullableTypeOf;
        Object objBodyNullable;
        HttpResponse httpResponse2;
        Map<String, List<String>> map2;
        Resource.Companion companion2;
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
        Object objExecute = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                FlagsPersistence flagsPersistence = this.flagsPersistence;
                PendingFlag.TIME_SYNC time_sync = PendingFlag.TIME_SYNC.INSTANCE;
                anonymousClass1.L$0 = str;
                anonymousClass1.label = 1;
                if (flagsPersistence.addFlag(time_sync, anonymousClass1) != coroutine_suspended) {
                    str2 = str;
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                str2 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objExecute);
            } else {
                if (i2 == 2) {
                    int i3 = anonymousClass1.I$4;
                    int i4 = anonymousClass1.I$3;
                    int i5 = anonymousClass1.I$2;
                    int i6 = anonymousClass1.I$1;
                    i = anonymousClass1.I$0;
                    map = (HashMap) anonymousClass1.L$3;
                    str3 = (String) anonymousClass1.L$2;
                    httpClient = (HttpClient) anonymousClass1.L$1;
                    str4 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objExecute);
                    httpResponse = (HttpResponse) objExecute;
                    mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
                    if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                        companion = Resource.INSTANCE;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TimeSyncResponse.class);
                        try {
                            kTypeNullableTypeOf = Reflection.nullableTypeOf(TimeSyncResponse.class);
                        } catch (Throwable unused) {
                            kTypeNullableTypeOf = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeNullableTypeOf);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(httpClient);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(map);
                        anonymousClass1.L$4 = httpResponse;
                        anonymousClass1.L$5 = mapAsResponseHeaders;
                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        anonymousClass1.L$7 = companion;
                        anonymousClass1.L$8 = null;
                        anonymousClass1.L$9 = null;
                        anonymousClass1.L$10 = null;
                        anonymousClass1.I$0 = i;
                        anonymousClass1.I$1 = 0;
                        anonymousClass1.I$2 = 0;
                        anonymousClass1.label = 3;
                        objBodyNullable = call.bodyNullable(typeInfo, anonymousClass1);
                        if (objBodyNullable != coroutine_suspended) {
                            httpResponse2 = httpResponse;
                            objExecute = objBodyNullable;
                            map2 = mapAsResponseHeaders;
                            companion2 = companion;
                        }
                        return coroutine_suspended;
                    }
                    resourceError$default = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
                    if (resourceError$default.isSuccess()) {
                        ServerTimeOffsetPersistence serverTimeOffsetPersistence = ServerTimeOffsetPersistence.INSTANCE;
                        long requestTime = resourceError$default.getRequestTime();
                        long responseTime = resourceError$default.getResponseTime();
                        timeSyncResponse = (TimeSyncResponse) resourceError$default.getData();
                        if (timeSyncResponse != null) {
                            serverTime = timeSyncResponse.getServerTime();
                        } else {
                            serverTime = 0;
                        }
                        serverTimeOffsetPersistence.setServerTimeOffset(requestTime, responseTime, serverTime);
                        this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                    }
                    return resourceError$default;
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i7 = anonymousClass1.I$2;
                int i8 = anonymousClass1.I$1;
                int i9 = anonymousClass1.I$0;
                Resource.Companion companion3 = (Resource.Companion) anonymousClass1.L$7;
                Map<String, List<String>> map3 = (Map) anonymousClass1.L$5;
                httpResponse2 = (HttpResponse) anonymousClass1.L$4;
                ResultKt.throwOnFailure(objExecute);
                companion2 = companion3;
                map2 = map3;
            }
            resourceError$default = companion2.success((TimeSyncResponse) objExecute, httpResponse2.getRequestTime().getTimestamp(), httpResponse2.getResponseTime().getTimestamp(), map2);
            if (resourceError$default.isSuccess()) {
                ServerTimeOffsetPersistence serverTimeOffsetPersistence2 = ServerTimeOffsetPersistence.INSTANCE;
                long requestTime2 = resourceError$default.getRequestTime();
                long responseTime2 = resourceError$default.getResponseTime();
                timeSyncResponse = (TimeSyncResponse) resourceError$default.getData();
                if (timeSyncResponse != null) {
                    serverTime = timeSyncResponse.getServerTime();
                } else {
                    serverTime = 0;
                }
                serverTimeOffsetPersistence2.setServerTimeOffset(requestTime2, responseTime2, serverTime);
                this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
            }
            return resourceError$default;
            httpClient = this.network.getHttpClient();
            map = new HashMap();
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, str2);
            for (Map.Entry entry : map.entrySet()) {
                UtilsKt.parameter(httpRequestBuilder, (String) entry.getKey(), entry.getValue());
            }
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, NetworkClientKt.getUserAgent());
            httpRequestBuilder.setMethod(HttpMethod.Get);
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(httpClient);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(map);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(httpClient);
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(httpClient);
            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpClient);
            anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
            anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(httpClient);
            anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.I$2 = 0;
            anonymousClass1.I$3 = 0;
            anonymousClass1.I$4 = 0;
            anonymousClass1.label = 2;
            objExecute = httpStatement.execute(anonymousClass1);
            if (objExecute != coroutine_suspended) {
                str3 = str2;
                str4 = str3;
                i = 0;
                httpResponse = (HttpResponse) objExecute;
                mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
                if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                    companion = Resource.INSTANCE;
                    HttpClientCall call2 = httpResponse.getCall();
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(TimeSyncResponse.class);
                    kTypeNullableTypeOf = Reflection.nullableTypeOf(TimeSyncResponse.class);
                    TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kTypeNullableTypeOf);
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(httpClient);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(map);
                    anonymousClass1.L$4 = httpResponse;
                    anonymousClass1.L$5 = mapAsResponseHeaders;
                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(httpResponse);
                    anonymousClass1.L$7 = companion;
                    anonymousClass1.L$8 = null;
                    anonymousClass1.L$9 = null;
                    anonymousClass1.L$10 = null;
                    anonymousClass1.I$0 = i;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.label = 3;
                    objBodyNullable = call2.bodyNullable(typeInfo2, anonymousClass1);
                    if (objBodyNullable != coroutine_suspended) {
                        httpResponse2 = httpResponse;
                        objExecute = objBodyNullable;
                        map2 = mapAsResponseHeaders;
                        companion2 = companion;
                        resourceError$default = companion2.success((TimeSyncResponse) objExecute, httpResponse2.getRequestTime().getTimestamp(), httpResponse2.getResponseTime().getTimestamp(), map2);
                    }
                } else {
                    resourceError$default = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
                }
                if (resourceError$default.isSuccess()) {
                    ServerTimeOffsetPersistence serverTimeOffsetPersistence3 = ServerTimeOffsetPersistence.INSTANCE;
                    long requestTime3 = resourceError$default.getRequestTime();
                    long responseTime3 = resourceError$default.getResponseTime();
                    timeSyncResponse = (TimeSyncResponse) resourceError$default.getData();
                    if (timeSyncResponse != null) {
                        serverTime = timeSyncResponse.getServerTime();
                    } else {
                        serverTime = 0;
                    }
                    serverTimeOffsetPersistence3.setServerTimeOffset(requestTime3, responseTime3, serverTime);
                    this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                }
                return resourceError$default;
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, new Throwable("Unreachable Server"), null, 2, null);
            } else {
                resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, th, null, 2, null);
            }
        }
    }
}
