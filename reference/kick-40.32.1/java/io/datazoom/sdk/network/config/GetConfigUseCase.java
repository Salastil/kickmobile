package io.datazoom.sdk.network.config;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import io.datazoom.sdk.data.memory.ConfigId;
import io.datazoom.sdk.data.memory.ConfigStore;
import io.datazoom.sdk.data.memory.FlagsPersistence;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.domain.EventManager;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.model.PendingFlag;
import io.datazoom.sdk.network.NetworkClient;
import io.datazoom.sdk.network.NetworkClientKt;
import io.datazoom.sdk.network.Resource;
import io.datazoom.sdk.network.ResponseHeadersKt;
import io.datazoom.sdk.network.config.model.ConfigDto;
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
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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

/* JADX INFO: compiled from: GetConfigUseCase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0086B¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/datazoom/sdk/network/config/GetConfigUseCase;", "", "network", "Lio/datazoom/sdk/network/NetworkClient;", "eventManager", "Lio/datazoom/sdk/domain/EventManager;", "configStore", "Lio/datazoom/sdk/data/memory/ConfigStore;", "flagsPersistence", "Lio/datazoom/sdk/data/memory/FlagsPersistence;", "metaDataStore", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "<init>", "(Lio/datazoom/sdk/network/NetworkClient;Lio/datazoom/sdk/domain/EventManager;Lio/datazoom/sdk/data/memory/ConfigStore;Lio/datazoom/sdk/data/memory/FlagsPersistence;Lio/datazoom/sdk/data/memory/MetaDataStore;)V", "invoke", "Lio/datazoom/sdk/network/Resource;", "Lio/datazoom/sdk/network/config/model/ConfigDto;", "configId", "", ImagesContract.URL, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetConfigUseCase {
    private final ConfigStore configStore;
    private final EventManager eventManager;
    private final FlagsPersistence flagsPersistence;
    private final MetaDataStore metaDataStore;
    private final NetworkClient network;

    /* JADX INFO: renamed from: io.datazoom.sdk.network.config.GetConfigUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetConfigUseCase.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.network.config.GetConfigUseCase", f = "GetConfigUseCase.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5}, l = {25, 26, 27, 67, 73, 44}, m = "invoke", n = {"configId", ImagesContract.URL, "configId", ImagesContract.URL, "configId", ImagesContract.URL, "configId", ImagesContract.URL, "$this$safeGet$iv", "url$iv", "params$iv", "$this$get$iv$iv", "urlString$iv$iv", "$this$get$iv$iv$iv", "$this$get$iv$iv$iv$iv", "builder$iv$iv$iv$iv", "$this$request$iv$iv$iv$iv$iv", "builder$iv$iv$iv$iv$iv", "$i$f$safeGet", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "configId", ImagesContract.URL, "$this$safeGet$iv", "url$iv", "params$iv", "$this$toResponse$iv$iv", "responseHeaders$iv$iv", "$this$body$iv$iv$iv", "$i$f$safeGet", "$i$f$toResponse", "$i$f$body", "configId", ImagesContract.URL, "result", "$this$ifSuccess$iv", "$this$invoke_u24lambda_u240", "$i$f$ifSuccess", "$i$a$-ifSuccess-GetConfigUseCase$invoke$2"}, nl = {26, 27, 29, 66, 83, 45}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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
            return GetConfigUseCase.this.invoke(null, null, this);
        }
    }

    public GetConfigUseCase(NetworkClient network, EventManager eventManager, ConfigStore configStore, FlagsPersistence flagsPersistence, MetaDataStore metaDataStore) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(eventManager, "eventManager");
        Intrinsics.checkNotNullParameter(configStore, "configStore");
        Intrinsics.checkNotNullParameter(flagsPersistence, "flagsPersistence");
        Intrinsics.checkNotNullParameter(metaDataStore, "metaDataStore");
        this.network = network;
        this.eventManager = eventManager;
        this.configStore = configStore;
        this.flagsPersistence = flagsPersistence;
        this.metaDataStore = metaDataStore;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00d8 A[PHI: r4 r9
      0x00d8: PHI (r4v21 java.lang.String) = (r4v18 java.lang.String), (r4v30 java.lang.String) binds: [B:36:0x0134, B:24:0x00cd] A[DONT_GENERATE, DONT_INLINE]
      0x00d8: PHI (r9v7 java.lang.String) = (r9v4 java.lang.String), (r9v14 java.lang.String) binds: [B:36:0x0134, B:24:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x0123 A[PHI: r4 r9
      0x0123: PHI (r4v18 java.lang.String) = (r4v15 java.lang.String), (r4v20 java.lang.String) binds: [B:33:0x011f, B:26:0x00db] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r9v4 java.lang.String) = (r9v1 java.lang.String), (r9v6 java.lang.String) binds: [B:33:0x011f, B:26:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:42:0x017a A[Catch: all -> 0x0081, LOOP:0: B:40:0x0174->B:42:0x017a, LOOP_END, TryCatch #1 {all -> 0x0081, blocks: (B:14:0x007a, B:57:0x027a, B:39:0x0161, B:40:0x0174, B:42:0x017a, B:43:0x018e), top: B:88:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:49:0x0217 A[Catch: all -> 0x02a0, TRY_LEAVE, TryCatch #0 {all -> 0x02a0, blocks: (B:47:0x0203, B:49:0x0217, B:53:0x022d, B:59:0x0292), top: B:87:0x0203 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0275  */
    /* JADX WARN: Code duplicated, block: B:59:0x0292 A[Catch: all -> 0x02a0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x02a0, blocks: (B:47:0x0203, B:49:0x0217, B:53:0x022d, B:59:0x0292), top: B:87:0x0203 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:74:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:75:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:77:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:84:0x0355  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    public final Object invoke(String str, String str2, Continuation<? super Resource<ConfigDto>> continuation) {
        AnonymousClass1 anonymousClass1;
        String str3;
        String str4;
        String message;
        Resource resourceError$default;
        String str5;
        ConfigDto.Endpoints endpoints;
        String eventUrl;
        EventManager eventManager;
        Resource resource;
        String str6;
        String str7;
        FlagsPersistence flagsPersistence;
        PendingFlag.GEO geo;
        FlagsPersistence flagsPersistence2;
        PendingFlag.TIME_SYNC time_sync;
        String str8;
        HttpClient httpClient;
        String str9;
        HashMap mapHashMapOf;
        HttpRequestBuilder httpRequestBuilder;
        Object objExecute;
        HttpClient httpClient2;
        int i;
        HttpResponse httpResponse;
        Map<String, List<String>> mapAsResponseHeaders;
        Resource.Companion companion;
        KType kTypeNullableTypeOf;
        Object objBodyNullable;
        HttpResponse httpResponse2;
        Map<String, List<String>> map;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (anonymousClass1.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    FlagsPersistence flagsPersistence3 = this.flagsPersistence;
                    PendingFlag.CONFIG config = PendingFlag.CONFIG.INSTANCE;
                    str6 = str;
                    anonymousClass1.L$0 = str6;
                    anonymousClass1.L$1 = str2;
                    anonymousClass1.label = 1;
                    if (flagsPersistence3.addFlag(config, anonymousClass1) != coroutine_suspended) {
                        str7 = str2;
                        flagsPersistence = this.flagsPersistence;
                        geo = PendingFlag.GEO.INSTANCE;
                        anonymousClass1.L$0 = str6;
                        anonymousClass1.L$1 = str7;
                        anonymousClass1.label = 2;
                        if (flagsPersistence.addFlag(geo, anonymousClass1) != coroutine_suspended) {
                            flagsPersistence2 = this.flagsPersistence;
                            time_sync = PendingFlag.TIME_SYNC.INSTANCE;
                            anonymousClass1.L$0 = str6;
                            anonymousClass1.L$1 = str7;
                            anonymousClass1.label = 3;
                            if (flagsPersistence2.addFlag(time_sync, anonymousClass1) != coroutine_suspended) {
                                str4 = str7;
                                str8 = str6;
                                httpClient = this.network.getHttpClient();
                                str9 = str4 + "/beacon/v2/config";
                                mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.CONFIGURATION_ID.getValue(), str8));
                                httpRequestBuilder = new HttpRequestBuilder();
                                HttpRequestKt.url(httpRequestBuilder, str9);
                                for (Map.Entry entry : mapHashMapOf.entrySet()) {
                                    UtilsKt.parameter(httpRequestBuilder, (String) entry.getKey(), entry.getValue());
                                }
                                HttpMessagePropertiesKt.userAgent(httpRequestBuilder, NetworkClientKt.getUserAgent());
                                httpRequestBuilder.setMethod(HttpMethod.Get);
                                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str8);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(mapHashMapOf);
                                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(httpClient);
                                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(str9);
                                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpClient);
                                anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(httpClient);
                                anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(httpClient);
                                anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.I$1 = 0;
                                anonymousClass1.I$2 = 0;
                                anonymousClass1.I$3 = 0;
                                anonymousClass1.I$4 = 0;
                                anonymousClass1.label = 4;
                                objExecute = httpStatement.execute(anonymousClass1);
                                if (objExecute != coroutine_suspended) {
                                    str5 = str8;
                                    httpClient2 = httpClient;
                                    obj = objExecute;
                                    i = 0;
                                    try {
                                        httpResponse = (HttpResponse) obj;
                                        mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
                                        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                            companion = Resource.INSTANCE;
                                            HttpClientCall call = httpResponse.getCall();
                                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ConfigDto.class);
                                            try {
                                                kTypeNullableTypeOf = Reflection.nullableTypeOf(ConfigDto.class);
                                            } catch (Throwable unused) {
                                                kTypeNullableTypeOf = null;
                                            }
                                            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeNullableTypeOf);
                                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient2);
                                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(mapHashMapOf);
                                            anonymousClass1.L$5 = httpResponse;
                                            anonymousClass1.L$6 = mapAsResponseHeaders;
                                            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                            anonymousClass1.L$8 = companion;
                                            anonymousClass1.L$9 = null;
                                            anonymousClass1.L$10 = null;
                                            anonymousClass1.L$11 = null;
                                            anonymousClass1.I$0 = i;
                                            anonymousClass1.I$1 = 0;
                                            anonymousClass1.I$2 = 0;
                                            anonymousClass1.label = 5;
                                            objBodyNullable = call.bodyNullable(typeInfo, anonymousClass1);
                                            if (objBodyNullable != coroutine_suspended) {
                                                httpResponse2 = httpResponse;
                                                obj = objBodyNullable;
                                                str3 = str5;
                                                map = mapAsResponseHeaders;
                                                companion2 = companion;
                                                resourceError$default = companion2.success((ConfigDto) obj, httpResponse2.getRequestTime().getTimestamp(), httpResponse2.getResponseTime().getTimestamp(), map);
                                                str5 = str3;
                                                if (resourceError$default.isSuccess()) {
                                                    return resourceError$default;
                                                }
                                                Object data = resourceError$default.getData();
                                                Intrinsics.checkNotNull(data);
                                                ConfigDto configDto = (ConfigDto) data;
                                                NetworkClient networkClient = this.network;
                                                endpoints = configDto.getEndpoints();
                                                if (endpoints != null) {
                                                    eventUrl = endpoints.getEventUrl();
                                                } else {
                                                    eventUrl = null;
                                                }
                                                if (eventUrl == null) {
                                                    eventUrl = "";
                                                }
                                                networkClient.setBrokerUrl(eventUrl);
                                                if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                                    this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                                    this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                                                }
                                                this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                                                this.configStore.save(ConfigId.Main.INSTANCE, configDto);
                                                eventManager = this.eventManager;
                                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                                anonymousClass1.L$2 = resourceError$default;
                                                anonymousClass1.L$3 = resourceError$default;
                                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto);
                                                anonymousClass1.L$5 = null;
                                                anonymousClass1.L$6 = null;
                                                anonymousClass1.L$7 = null;
                                                anonymousClass1.L$8 = null;
                                                anonymousClass1.L$9 = null;
                                                anonymousClass1.L$10 = null;
                                                anonymousClass1.L$11 = null;
                                                anonymousClass1.I$0 = 0;
                                                anonymousClass1.I$1 = 0;
                                                anonymousClass1.label = 6;
                                                if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                                    resource = resourceError$default;
                                                    return resource;
                                                }
                                            }
                                        } else {
                                            resourceError$default = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
                                            if (resourceError$default.isSuccess()) {
                                                return resourceError$default;
                                            }
                                            Object data2 = resourceError$default.getData();
                                            Intrinsics.checkNotNull(data2);
                                            ConfigDto configDto2 = (ConfigDto) data2;
                                            NetworkClient networkClient2 = this.network;
                                            endpoints = configDto2.getEndpoints();
                                            if (endpoints != null) {
                                                eventUrl = endpoints.getEventUrl();
                                            } else {
                                                eventUrl = null;
                                            }
                                            if (eventUrl == null) {
                                                eventUrl = "";
                                            }
                                            networkClient2.setBrokerUrl(eventUrl);
                                            if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                                this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                                this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                                            }
                                            this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                                            this.configStore.save(ConfigId.Main.INSTANCE, configDto2);
                                            eventManager = this.eventManager;
                                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                            anonymousClass1.L$2 = resourceError$default;
                                            anonymousClass1.L$3 = resourceError$default;
                                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto2);
                                            anonymousClass1.L$5 = null;
                                            anonymousClass1.L$6 = null;
                                            anonymousClass1.L$7 = null;
                                            anonymousClass1.L$8 = null;
                                            anonymousClass1.L$9 = null;
                                            anonymousClass1.L$10 = null;
                                            anonymousClass1.L$11 = null;
                                            anonymousClass1.I$0 = 0;
                                            anonymousClass1.I$1 = 0;
                                            anonymousClass1.label = 6;
                                            if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                                resource = resourceError$default;
                                                return resource;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        str3 = str5;
                                        message = th.getMessage();
                                        if (message == null && StringsKt.contains((CharSequence) message, (CharSequence) "unable to resolve host", true)) {
                                            resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, new Throwable("Unreachable Server"), null, 2, null);
                                        } else {
                                            resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, th, null, 2, null);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    str7 = (String) anonymousClass1.L$1;
                    str6 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    flagsPersistence = this.flagsPersistence;
                    geo = PendingFlag.GEO.INSTANCE;
                    anonymousClass1.L$0 = str6;
                    anonymousClass1.L$1 = str7;
                    anonymousClass1.label = 2;
                    if (flagsPersistence.addFlag(geo, anonymousClass1) != coroutine_suspended) {
                        flagsPersistence2 = this.flagsPersistence;
                        time_sync = PendingFlag.TIME_SYNC.INSTANCE;
                        anonymousClass1.L$0 = str6;
                        anonymousClass1.L$1 = str7;
                        anonymousClass1.label = 3;
                        if (flagsPersistence2.addFlag(time_sync, anonymousClass1) != coroutine_suspended) {
                            str4 = str7;
                            str8 = str6;
                            httpClient = this.network.getHttpClient();
                            str9 = str4 + "/beacon/v2/config";
                            mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.CONFIGURATION_ID.getValue(), str8));
                            httpRequestBuilder = new HttpRequestBuilder();
                            HttpRequestKt.url(httpRequestBuilder, str9);
                            while (r13.hasNext()) {
                                UtilsKt.parameter(httpRequestBuilder, (String) entry.getKey(), entry.getValue());
                            }
                            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, NetworkClientKt.getUserAgent());
                            httpRequestBuilder.setMethod(HttpMethod.Get);
                            HttpStatement httpStatement2 = new HttpStatement(httpRequestBuilder, httpClient);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str8);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(mapHashMapOf);
                            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(httpClient);
                            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(str9);
                            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpClient);
                            anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(httpClient);
                            anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                            anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(httpClient);
                            anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.I$1 = 0;
                            anonymousClass1.I$2 = 0;
                            anonymousClass1.I$3 = 0;
                            anonymousClass1.I$4 = 0;
                            anonymousClass1.label = 4;
                            objExecute = httpStatement2.execute(anonymousClass1);
                            if (objExecute != coroutine_suspended) {
                                str5 = str8;
                                httpClient2 = httpClient;
                                obj = objExecute;
                                i = 0;
                                httpResponse = (HttpResponse) obj;
                                mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
                                if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                    companion = Resource.INSTANCE;
                                    HttpClientCall call2 = httpResponse.getCall();
                                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ConfigDto.class);
                                    kTypeNullableTypeOf = Reflection.nullableTypeOf(ConfigDto.class);
                                    TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kTypeNullableTypeOf);
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient2);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(mapHashMapOf);
                                    anonymousClass1.L$5 = httpResponse;
                                    anonymousClass1.L$6 = mapAsResponseHeaders;
                                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                    anonymousClass1.L$8 = companion;
                                    anonymousClass1.L$9 = null;
                                    anonymousClass1.L$10 = null;
                                    anonymousClass1.L$11 = null;
                                    anonymousClass1.I$0 = i;
                                    anonymousClass1.I$1 = 0;
                                    anonymousClass1.I$2 = 0;
                                    anonymousClass1.label = 5;
                                    objBodyNullable = call2.bodyNullable(typeInfo2, anonymousClass1);
                                    if (objBodyNullable != coroutine_suspended) {
                                        httpResponse2 = httpResponse;
                                        obj = objBodyNullable;
                                        str3 = str5;
                                        map = mapAsResponseHeaders;
                                        companion2 = companion;
                                        resourceError$default = companion2.success((ConfigDto) obj, httpResponse2.getRequestTime().getTimestamp(), httpResponse2.getResponseTime().getTimestamp(), map);
                                        str5 = str3;
                                        if (resourceError$default.isSuccess()) {
                                            return resourceError$default;
                                        }
                                        Object data3 = resourceError$default.getData();
                                        Intrinsics.checkNotNull(data3);
                                        ConfigDto configDto3 = (ConfigDto) data3;
                                        NetworkClient networkClient3 = this.network;
                                        endpoints = configDto3.getEndpoints();
                                        if (endpoints != null) {
                                            eventUrl = endpoints.getEventUrl();
                                        } else {
                                            eventUrl = null;
                                        }
                                        if (eventUrl == null) {
                                            eventUrl = "";
                                        }
                                        networkClient3.setBrokerUrl(eventUrl);
                                        if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                            this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                            this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                                        }
                                        this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                                        this.configStore.save(ConfigId.Main.INSTANCE, configDto3);
                                        eventManager = this.eventManager;
                                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                        anonymousClass1.L$2 = resourceError$default;
                                        anonymousClass1.L$3 = resourceError$default;
                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto3);
                                        anonymousClass1.L$5 = null;
                                        anonymousClass1.L$6 = null;
                                        anonymousClass1.L$7 = null;
                                        anonymousClass1.L$8 = null;
                                        anonymousClass1.L$9 = null;
                                        anonymousClass1.L$10 = null;
                                        anonymousClass1.L$11 = null;
                                        anonymousClass1.I$0 = 0;
                                        anonymousClass1.I$1 = 0;
                                        anonymousClass1.label = 6;
                                        if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                            resource = resourceError$default;
                                            return resource;
                                        }
                                    }
                                } else {
                                    resourceError$default = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
                                    if (resourceError$default.isSuccess()) {
                                        return resourceError$default;
                                    }
                                    Object data4 = resourceError$default.getData();
                                    Intrinsics.checkNotNull(data4);
                                    ConfigDto configDto4 = (ConfigDto) data4;
                                    NetworkClient networkClient4 = this.network;
                                    endpoints = configDto4.getEndpoints();
                                    if (endpoints != null) {
                                        eventUrl = endpoints.getEventUrl();
                                    } else {
                                        eventUrl = null;
                                    }
                                    if (eventUrl == null) {
                                        eventUrl = "";
                                    }
                                    networkClient4.setBrokerUrl(eventUrl);
                                    if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                        this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                        this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                                    }
                                    this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                                    this.configStore.save(ConfigId.Main.INSTANCE, configDto4);
                                    eventManager = this.eventManager;
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                    anonymousClass1.L$2 = resourceError$default;
                                    anonymousClass1.L$3 = resourceError$default;
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto4);
                                    anonymousClass1.L$5 = null;
                                    anonymousClass1.L$6 = null;
                                    anonymousClass1.L$7 = null;
                                    anonymousClass1.L$8 = null;
                                    anonymousClass1.L$9 = null;
                                    anonymousClass1.L$10 = null;
                                    anonymousClass1.L$11 = null;
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.I$1 = 0;
                                    anonymousClass1.label = 6;
                                    if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                        resource = resourceError$default;
                                        return resource;
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 2:
                    str7 = (String) anonymousClass1.L$1;
                    str6 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    flagsPersistence2 = this.flagsPersistence;
                    time_sync = PendingFlag.TIME_SYNC.INSTANCE;
                    anonymousClass1.L$0 = str6;
                    anonymousClass1.L$1 = str7;
                    anonymousClass1.label = 3;
                    if (flagsPersistence2.addFlag(time_sync, anonymousClass1) != coroutine_suspended) {
                        str4 = str7;
                        str8 = str6;
                        httpClient = this.network.getHttpClient();
                        str9 = str4 + "/beacon/v2/config";
                        mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.CONFIGURATION_ID.getValue(), str8));
                        httpRequestBuilder = new HttpRequestBuilder();
                        HttpRequestKt.url(httpRequestBuilder, str9);
                        while (r13.hasNext()) {
                            UtilsKt.parameter(httpRequestBuilder, (String) entry.getKey(), entry.getValue());
                        }
                        HttpMessagePropertiesKt.userAgent(httpRequestBuilder, NetworkClientKt.getUserAgent());
                        httpRequestBuilder.setMethod(HttpMethod.Get);
                        HttpStatement httpStatement3 = new HttpStatement(httpRequestBuilder, httpClient);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str8);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(mapHashMapOf);
                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(httpClient);
                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(str9);
                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpClient);
                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(httpClient);
                        anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(httpClient);
                        anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.I$1 = 0;
                        anonymousClass1.I$2 = 0;
                        anonymousClass1.I$3 = 0;
                        anonymousClass1.I$4 = 0;
                        anonymousClass1.label = 4;
                        objExecute = httpStatement3.execute(anonymousClass1);
                        if (objExecute != coroutine_suspended) {
                            str5 = str8;
                            httpClient2 = httpClient;
                            obj = objExecute;
                            i = 0;
                            httpResponse = (HttpResponse) obj;
                            mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
                            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                companion = Resource.INSTANCE;
                                HttpClientCall call3 = httpResponse.getCall();
                                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(ConfigDto.class);
                                kTypeNullableTypeOf = Reflection.nullableTypeOf(ConfigDto.class);
                                TypeInfo typeInfo3 = new TypeInfo(orCreateKotlinClass3, kTypeNullableTypeOf);
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient2);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(mapHashMapOf);
                                anonymousClass1.L$5 = httpResponse;
                                anonymousClass1.L$6 = mapAsResponseHeaders;
                                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                anonymousClass1.L$8 = companion;
                                anonymousClass1.L$9 = null;
                                anonymousClass1.L$10 = null;
                                anonymousClass1.L$11 = null;
                                anonymousClass1.I$0 = i;
                                anonymousClass1.I$1 = 0;
                                anonymousClass1.I$2 = 0;
                                anonymousClass1.label = 5;
                                objBodyNullable = call3.bodyNullable(typeInfo3, anonymousClass1);
                                if (objBodyNullable != coroutine_suspended) {
                                    httpResponse2 = httpResponse;
                                    obj = objBodyNullable;
                                    str3 = str5;
                                    map = mapAsResponseHeaders;
                                    companion2 = companion;
                                    resourceError$default = companion2.success((ConfigDto) obj, httpResponse2.getRequestTime().getTimestamp(), httpResponse2.getResponseTime().getTimestamp(), map);
                                    str5 = str3;
                                    if (resourceError$default.isSuccess()) {
                                        return resourceError$default;
                                    }
                                    Object data5 = resourceError$default.getData();
                                    Intrinsics.checkNotNull(data5);
                                    ConfigDto configDto5 = (ConfigDto) data5;
                                    NetworkClient networkClient5 = this.network;
                                    endpoints = configDto5.getEndpoints();
                                    if (endpoints != null) {
                                        eventUrl = endpoints.getEventUrl();
                                    } else {
                                        eventUrl = null;
                                    }
                                    if (eventUrl == null) {
                                        eventUrl = "";
                                    }
                                    networkClient5.setBrokerUrl(eventUrl);
                                    if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                        this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                        this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                                    }
                                    this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                                    this.configStore.save(ConfigId.Main.INSTANCE, configDto5);
                                    eventManager = this.eventManager;
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                    anonymousClass1.L$2 = resourceError$default;
                                    anonymousClass1.L$3 = resourceError$default;
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto5);
                                    anonymousClass1.L$5 = null;
                                    anonymousClass1.L$6 = null;
                                    anonymousClass1.L$7 = null;
                                    anonymousClass1.L$8 = null;
                                    anonymousClass1.L$9 = null;
                                    anonymousClass1.L$10 = null;
                                    anonymousClass1.L$11 = null;
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.I$1 = 0;
                                    anonymousClass1.label = 6;
                                    if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                        resource = resourceError$default;
                                        return resource;
                                    }
                                }
                            } else {
                                resourceError$default = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
                                if (resourceError$default.isSuccess()) {
                                    return resourceError$default;
                                }
                                Object data6 = resourceError$default.getData();
                                Intrinsics.checkNotNull(data6);
                                ConfigDto configDto6 = (ConfigDto) data6;
                                NetworkClient networkClient6 = this.network;
                                endpoints = configDto6.getEndpoints();
                                if (endpoints != null) {
                                    eventUrl = endpoints.getEventUrl();
                                } else {
                                    eventUrl = null;
                                }
                                if (eventUrl == null) {
                                    eventUrl = "";
                                }
                                networkClient6.setBrokerUrl(eventUrl);
                                if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                    this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                    this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                                }
                                this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                                this.configStore.save(ConfigId.Main.INSTANCE, configDto6);
                                eventManager = this.eventManager;
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                anonymousClass1.L$2 = resourceError$default;
                                anonymousClass1.L$3 = resourceError$default;
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto6);
                                anonymousClass1.L$5 = null;
                                anonymousClass1.L$6 = null;
                                anonymousClass1.L$7 = null;
                                anonymousClass1.L$8 = null;
                                anonymousClass1.L$9 = null;
                                anonymousClass1.L$10 = null;
                                anonymousClass1.L$11 = null;
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.I$1 = 0;
                                anonymousClass1.label = 6;
                                if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                    resource = resourceError$default;
                                    return resource;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 3:
                    str7 = (String) anonymousClass1.L$1;
                    str6 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str4 = str7;
                    str8 = str6;
                    httpClient = this.network.getHttpClient();
                    str9 = str4 + "/beacon/v2/config";
                    mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to(MetaData.Type.CONFIGURATION_ID.getValue(), str8));
                    httpRequestBuilder = new HttpRequestBuilder();
                    HttpRequestKt.url(httpRequestBuilder, str9);
                    while (r13.hasNext()) {
                        UtilsKt.parameter(httpRequestBuilder, (String) entry.getKey(), entry.getValue());
                    }
                    HttpMessagePropertiesKt.userAgent(httpRequestBuilder, NetworkClientKt.getUserAgent());
                    httpRequestBuilder.setMethod(HttpMethod.Get);
                    HttpStatement httpStatement4 = new HttpStatement(httpRequestBuilder, httpClient);
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str8);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(mapHashMapOf);
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(httpClient);
                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(str9);
                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpClient);
                    anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(httpClient);
                    anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                    anonymousClass1.L$10 = SpillingKt.nullOutSpilledVariable(httpClient);
                    anonymousClass1.L$11 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.I$3 = 0;
                    anonymousClass1.I$4 = 0;
                    anonymousClass1.label = 4;
                    objExecute = httpStatement4.execute(anonymousClass1);
                    if (objExecute != coroutine_suspended) {
                        str5 = str8;
                        httpClient2 = httpClient;
                        obj = objExecute;
                        i = 0;
                        httpResponse = (HttpResponse) obj;
                        mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
                        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                            companion = Resource.INSTANCE;
                            HttpClientCall call4 = httpResponse.getCall();
                            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(ConfigDto.class);
                            kTypeNullableTypeOf = Reflection.nullableTypeOf(ConfigDto.class);
                            TypeInfo typeInfo4 = new TypeInfo(orCreateKotlinClass4, kTypeNullableTypeOf);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient2);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(mapHashMapOf);
                            anonymousClass1.L$5 = httpResponse;
                            anonymousClass1.L$6 = mapAsResponseHeaders;
                            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpResponse);
                            anonymousClass1.L$8 = companion;
                            anonymousClass1.L$9 = null;
                            anonymousClass1.L$10 = null;
                            anonymousClass1.L$11 = null;
                            anonymousClass1.I$0 = i;
                            anonymousClass1.I$1 = 0;
                            anonymousClass1.I$2 = 0;
                            anonymousClass1.label = 5;
                            objBodyNullable = call4.bodyNullable(typeInfo4, anonymousClass1);
                            if (objBodyNullable != coroutine_suspended) {
                                httpResponse2 = httpResponse;
                                obj = objBodyNullable;
                                str3 = str5;
                                map = mapAsResponseHeaders;
                                companion2 = companion;
                                resourceError$default = companion2.success((ConfigDto) obj, httpResponse2.getRequestTime().getTimestamp(), httpResponse2.getResponseTime().getTimestamp(), map);
                                str5 = str3;
                                if (resourceError$default.isSuccess()) {
                                    return resourceError$default;
                                }
                                Object data7 = resourceError$default.getData();
                                Intrinsics.checkNotNull(data7);
                                ConfigDto configDto7 = (ConfigDto) data7;
                                NetworkClient networkClient7 = this.network;
                                endpoints = configDto7.getEndpoints();
                                if (endpoints != null) {
                                    eventUrl = endpoints.getEventUrl();
                                } else {
                                    eventUrl = null;
                                }
                                if (eventUrl == null) {
                                    eventUrl = "";
                                }
                                networkClient7.setBrokerUrl(eventUrl);
                                if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                    this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                    this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                                }
                                this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                                this.configStore.save(ConfigId.Main.INSTANCE, configDto7);
                                eventManager = this.eventManager;
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                anonymousClass1.L$2 = resourceError$default;
                                anonymousClass1.L$3 = resourceError$default;
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto7);
                                anonymousClass1.L$5 = null;
                                anonymousClass1.L$6 = null;
                                anonymousClass1.L$7 = null;
                                anonymousClass1.L$8 = null;
                                anonymousClass1.L$9 = null;
                                anonymousClass1.L$10 = null;
                                anonymousClass1.L$11 = null;
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.I$1 = 0;
                                anonymousClass1.label = 6;
                                if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                    resource = resourceError$default;
                                    return resource;
                                }
                            }
                        } else {
                            resourceError$default = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
                            if (resourceError$default.isSuccess()) {
                                return resourceError$default;
                            }
                            Object data8 = resourceError$default.getData();
                            Intrinsics.checkNotNull(data8);
                            ConfigDto configDto8 = (ConfigDto) data8;
                            NetworkClient networkClient8 = this.network;
                            endpoints = configDto8.getEndpoints();
                            if (endpoints != null) {
                                eventUrl = endpoints.getEventUrl();
                            } else {
                                eventUrl = null;
                            }
                            if (eventUrl == null) {
                                eventUrl = "";
                            }
                            networkClient8.setBrokerUrl(eventUrl);
                            if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                            }
                            this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                            this.configStore.save(ConfigId.Main.INSTANCE, configDto8);
                            eventManager = this.eventManager;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                            anonymousClass1.L$2 = resourceError$default;
                            anonymousClass1.L$3 = resourceError$default;
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto8);
                            anonymousClass1.L$5 = null;
                            anonymousClass1.L$6 = null;
                            anonymousClass1.L$7 = null;
                            anonymousClass1.L$8 = null;
                            anonymousClass1.L$9 = null;
                            anonymousClass1.L$10 = null;
                            anonymousClass1.L$11 = null;
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.I$1 = 0;
                            anonymousClass1.label = 6;
                            if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                resource = resourceError$default;
                                return resource;
                            }
                        }
                    }
                    return coroutine_suspended;
                case 4:
                    int i2 = anonymousClass1.I$4;
                    int i3 = anonymousClass1.I$3;
                    int i4 = anonymousClass1.I$2;
                    int i5 = anonymousClass1.I$1;
                    i = anonymousClass1.I$0;
                    mapHashMapOf = (HashMap) anonymousClass1.L$4;
                    str9 = (String) anonymousClass1.L$3;
                    HttpClient httpClient3 = (HttpClient) anonymousClass1.L$2;
                    String str10 = (String) anonymousClass1.L$1;
                    str5 = (String) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        httpClient2 = httpClient3;
                        str4 = str10;
                        httpResponse = (HttpResponse) obj;
                        mapAsResponseHeaders = ResponseHeadersKt.asResponseHeaders(httpResponse.getHeaders());
                        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                            companion = Resource.INSTANCE;
                            HttpClientCall call5 = httpResponse.getCall();
                            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(ConfigDto.class);
                            kTypeNullableTypeOf = Reflection.nullableTypeOf(ConfigDto.class);
                            TypeInfo typeInfo5 = new TypeInfo(orCreateKotlinClass5, kTypeNullableTypeOf);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(httpClient2);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(mapHashMapOf);
                            anonymousClass1.L$5 = httpResponse;
                            anonymousClass1.L$6 = mapAsResponseHeaders;
                            anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(httpResponse);
                            anonymousClass1.L$8 = companion;
                            anonymousClass1.L$9 = null;
                            anonymousClass1.L$10 = null;
                            anonymousClass1.L$11 = null;
                            anonymousClass1.I$0 = i;
                            anonymousClass1.I$1 = 0;
                            anonymousClass1.I$2 = 0;
                            anonymousClass1.label = 5;
                            objBodyNullable = call5.bodyNullable(typeInfo5, anonymousClass1);
                            if (objBodyNullable != coroutine_suspended) {
                                httpResponse2 = httpResponse;
                                obj = objBodyNullable;
                                str3 = str5;
                                map = mapAsResponseHeaders;
                                companion2 = companion;
                                resourceError$default = companion2.success((ConfigDto) obj, httpResponse2.getRequestTime().getTimestamp(), httpResponse2.getResponseTime().getTimestamp(), map);
                                str5 = str3;
                                if (resourceError$default.isSuccess()) {
                                    return resourceError$default;
                                }
                                Object data9 = resourceError$default.getData();
                                Intrinsics.checkNotNull(data9);
                                ConfigDto configDto9 = (ConfigDto) data9;
                                NetworkClient networkClient9 = this.network;
                                endpoints = configDto9.getEndpoints();
                                if (endpoints != null) {
                                    eventUrl = endpoints.getEventUrl();
                                } else {
                                    eventUrl = null;
                                }
                                if (eventUrl == null) {
                                    eventUrl = "";
                                }
                                networkClient9.setBrokerUrl(eventUrl);
                                if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                    this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                    this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                                }
                                this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                                this.configStore.save(ConfigId.Main.INSTANCE, configDto9);
                                eventManager = this.eventManager;
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                                anonymousClass1.L$2 = resourceError$default;
                                anonymousClass1.L$3 = resourceError$default;
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto9);
                                anonymousClass1.L$5 = null;
                                anonymousClass1.L$6 = null;
                                anonymousClass1.L$7 = null;
                                anonymousClass1.L$8 = null;
                                anonymousClass1.L$9 = null;
                                anonymousClass1.L$10 = null;
                                anonymousClass1.L$11 = null;
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.I$1 = 0;
                                anonymousClass1.label = 6;
                                if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                    resource = resourceError$default;
                                    return resource;
                                }
                            }
                        } else {
                            resourceError$default = Resource.INSTANCE.error(new Throwable("Something went wrong"), mapAsResponseHeaders);
                            if (resourceError$default.isSuccess()) {
                                return resourceError$default;
                            }
                            Object data10 = resourceError$default.getData();
                            Intrinsics.checkNotNull(data10);
                            ConfigDto configDto10 = (ConfigDto) data10;
                            NetworkClient networkClient10 = this.network;
                            endpoints = configDto10.getEndpoints();
                            if (endpoints != null) {
                                eventUrl = endpoints.getEventUrl();
                            } else {
                                eventUrl = null;
                            }
                            if (eventUrl == null) {
                                eventUrl = "";
                            }
                            networkClient10.setBrokerUrl(eventUrl);
                            if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                                this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                                this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                            }
                            this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                            this.configStore.save(ConfigId.Main.INSTANCE, configDto10);
                            eventManager = this.eventManager;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                            anonymousClass1.L$2 = resourceError$default;
                            anonymousClass1.L$3 = resourceError$default;
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto10);
                            anonymousClass1.L$5 = null;
                            anonymousClass1.L$6 = null;
                            anonymousClass1.L$7 = null;
                            anonymousClass1.L$8 = null;
                            anonymousClass1.L$9 = null;
                            anonymousClass1.L$10 = null;
                            anonymousClass1.L$11 = null;
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.I$1 = 0;
                            anonymousClass1.label = 6;
                            if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                                resource = resourceError$default;
                                return resource;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str4 = str10;
                        str3 = str5;
                        message = th.getMessage();
                        if (message == null) {
                            resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, th, null, 2, null);
                        } else {
                            resourceError$default = Resource.Companion.error$default(Resource.INSTANCE, th, null, 2, null);
                        }
                        str5 = str3;
                        if (resourceError$default.isSuccess()) {
                            return resourceError$default;
                        }
                        Object data11 = resourceError$default.getData();
                        Intrinsics.checkNotNull(data11);
                        ConfigDto configDto11 = (ConfigDto) data11;
                        NetworkClient networkClient11 = this.network;
                        endpoints = configDto11.getEndpoints();
                        if (endpoints != null) {
                            eventUrl = endpoints.getEventUrl();
                        } else {
                            eventUrl = null;
                        }
                        if (eventUrl == null) {
                            eventUrl = "";
                        }
                        networkClient11.setBrokerUrl(eventUrl);
                        if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                            this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                            this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                        }
                        this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                        this.configStore.save(ConfigId.Main.INSTANCE, configDto11);
                        eventManager = this.eventManager;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                        anonymousClass1.L$2 = resourceError$default;
                        anonymousClass1.L$3 = resourceError$default;
                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto11);
                        anonymousClass1.L$5 = null;
                        anonymousClass1.L$6 = null;
                        anonymousClass1.L$7 = null;
                        anonymousClass1.L$8 = null;
                        anonymousClass1.L$9 = null;
                        anonymousClass1.L$10 = null;
                        anonymousClass1.L$11 = null;
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.I$1 = 0;
                        anonymousClass1.label = 6;
                        if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                            resource = resourceError$default;
                            return resource;
                        }
                        return coroutine_suspended;
                    }
                    return coroutine_suspended;
                case 5:
                    int i6 = anonymousClass1.I$2;
                    int i7 = anonymousClass1.I$1;
                    int i8 = anonymousClass1.I$0;
                    companion2 = (Resource.Companion) anonymousClass1.L$8;
                    Map<String, List<String>> map2 = (Map) anonymousClass1.L$6;
                    HttpResponse httpResponse3 = (HttpResponse) anonymousClass1.L$5;
                    str4 = (String) anonymousClass1.L$1;
                    str3 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    httpResponse2 = httpResponse3;
                    map = map2;
                    resourceError$default = companion2.success((ConfigDto) obj, httpResponse2.getRequestTime().getTimestamp(), httpResponse2.getResponseTime().getTimestamp(), map);
                    str5 = str3;
                    if (resourceError$default.isSuccess()) {
                        return resourceError$default;
                    }
                    Object data12 = resourceError$default.getData();
                    Intrinsics.checkNotNull(data12);
                    ConfigDto configDto12 = (ConfigDto) data12;
                    NetworkClient networkClient12 = this.network;
                    endpoints = configDto12.getEndpoints();
                    if (endpoints != null) {
                        eventUrl = endpoints.getEventUrl();
                    } else {
                        eventUrl = null;
                    }
                    if (eventUrl == null) {
                        eventUrl = "";
                    }
                    networkClient12.setBrokerUrl(eventUrl);
                    if (ConfigResponseExtrasKt.applyDzExtra(resourceError$default, this.metaDataStore)) {
                        this.flagsPersistence.removeFlag(PendingFlag.GEO.INSTANCE);
                        this.flagsPersistence.removeFlag(PendingFlag.TIME_SYNC.INSTANCE);
                    }
                    this.flagsPersistence.removeFlag(PendingFlag.CONFIG.INSTANCE);
                    this.configStore.save(ConfigId.Main.INSTANCE, configDto12);
                    eventManager = this.eventManager;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                    anonymousClass1.L$2 = resourceError$default;
                    anonymousClass1.L$3 = resourceError$default;
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(configDto12);
                    anonymousClass1.L$5 = null;
                    anonymousClass1.L$6 = null;
                    anonymousClass1.L$7 = null;
                    anonymousClass1.L$8 = null;
                    anonymousClass1.L$9 = null;
                    anonymousClass1.L$10 = null;
                    anonymousClass1.L$11 = null;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.label = 6;
                    if (eventManager.configArrived(anonymousClass1) != coroutine_suspended) {
                        resource = resourceError$default;
                        return resource;
                    }
                    return coroutine_suspended;
                case 6:
                    int i9 = anonymousClass1.I$1;
                    int i10 = anonymousClass1.I$0;
                    resource = (Resource) anonymousClass1.L$2;
                    ResultKt.throwOnFailure(obj);
                    return resource;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
