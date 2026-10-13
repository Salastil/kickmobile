package io.ktor.client.engine.okhttp;

import androidx.compose.foundation.style.ResolvedStyleKt;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.io.PlatformStaticConfig_jvmKt;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.sse.SSECapability;
import io.ktor.client.plugins.websocket.WebSocketCapability;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.client.plugins.websocket.WebSocketsKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.ResponseAdapter;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.CacheKt;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import java.net.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: OkHttpEngine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ0\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J0\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0017\u0010\u0016J7\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R$\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u0010.\u001a\u0004\b0\u00101R1\u00105\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u000e028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "config", "<init>", "(Lio/ktor/client/engine/okhttp/OkHttpConfig;)V", "Lio/ktor/client/request/HttpRequestData;", "data", "Lio/ktor/client/request/HttpResponseData;", "execute", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "close", "()V", "Lokhttp3/OkHttpClient;", "engine", "Lokhttp3/Request;", "engineRequest", "Lkotlin/coroutines/CoroutineContext;", "callContext", "requestData", "executeWebSocketRequest", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeHttpRequest", "Lokhttp3/Response;", "response", "Lio/ktor/util/date/GMTDate;", "requestTime", "", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "buildResponseData", "(Lokhttp3/Response;Lio/ktor/util/date/GMTDate;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;)Lio/ktor/client/request/HttpResponseData;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "timeoutExtension", "createOkHttpClient", "(Lio/ktor/client/plugins/HttpTimeoutConfig;)Lokhttp3/OkHttpClient;", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "getConfig", "()Lio/ktor/client/engine/okhttp/OkHttpConfig;", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "supportedCapabilities", "Ljava/util/Set;", "getSupportedCapabilities", "()Ljava/util/Set;", "requestsJob", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "", "Lkotlin/ParameterName;", "name", "clientCache", "Ljava/util/Map;", "Companion", "ktor-client-okhttp"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OkHttpEngine extends HttpClientEngineBase {
    private static final Companion Companion = new Companion(null);
    private static final Lazy<OkHttpClient> okHttpClientPrototype$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return new OkHttpClient.Builder().build();
        }
    });
    private final Map<HttpTimeoutConfig, OkHttpClient> clientCache;
    private final OkHttpConfig config;
    private final CoroutineContext coroutineContext;
    private final CoroutineContext requestsJob;
    private final Set<HttpClientEngineCapability<?>> supportedCapabilities;

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OkHttpEngine.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {63, 70, EACTags.MESSAGE_REFERENCE}, m = "execute", n = {"data", "data", "callContext", "engineRequest", "requestEngine", "data", "callContext", "engineRequest", "requestEngine"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C09541 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09541(Continuation<? super C09541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OkHttpEngine.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", i = {0, 0, 0, 0, 0}, l = {107}, m = "executeHttpRequest", n = {"engine", "engineRequest", "callContext", "requestData", "requestTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C09551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C09551(Continuation<? super C09551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.executeHttpRequest(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OkHttpEngine.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {ResolvedStyleKt.InheritedFlags}, m = "executeWebSocketRequest", n = {"engine", "engineRequest", "callContext", "requestData", "requestTime", "wsConfig", "session"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 1)
    static final class C09561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C09561(Continuation<? super C09561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.executeWebSocketRequest(null, null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine(OkHttpConfig config) {
        super("ktor-okhttp");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.supportedCapabilities = SetsKt.setOf((Object[]) new HttpClientEngineCapability[]{HttpTimeoutCapability.INSTANCE, WebSocketCapability.INSTANCE, SSECapability.INSTANCE});
        this.clientCache = CacheKt.createLRUCache(new OkHttpEngine$clientCache$1(this), new Function1() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OkHttpEngine.clientCache$lambda$0((OkHttpClient) obj);
            }
        }, getConfig().getClientCacheSize());
        PlatformStaticConfig_jvmKt.configurePlatform();
        CoroutineContext coroutineContextSilentSupervisor = CoroutinesUtilsKt.SilentSupervisor(JobKt.getJob(super.getCoroutineContext()));
        this.requestsJob = coroutineContextSilentSupervisor;
        this.coroutineContext = super.getCoroutineContext().plus(coroutineContextSilentSupervisor);
        BuildersKt.launch(GlobalScope.INSTANCE, super.getCoroutineContext(), CoroutineStart.ATOMIC, new AnonymousClass1(null));
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public OkHttpConfig getConfig() {
        return this.config;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    static final Unit clientCache$lambda$0(OkHttpClient it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$1, reason: invalid class name */
    /* JADX INFO: compiled from: OkHttpEngine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine$1", f = "OkHttpEngine.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OkHttpEngine.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.util.Iterator] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (JobKt.getJob(OkHttpEngine.this.requestsJob).join(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this = OkHttpEngine.this.clientCache.entrySet().iterator();
                while (this.hasNext()) {
                    OkHttpClient okHttpClient = (OkHttpClient) ((Map.Entry) this.next()).getValue();
                    okHttpClient.connectionPool().evictAll();
                    okHttpClient.dispatcher().executorService().shutdown();
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                Iterator it = OkHttpEngine.this.clientCache.entrySet().iterator();
                while (it.hasNext()) {
                    OkHttpClient okHttpClient2 = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient2.connectionPool().evictAll();
                    okHttpClient2.dispatcher().executorService().shutdown();
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.client.engine.HttpClientEngine
    public Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) {
        C09541 c09541;
        if (continuation instanceof C09541) {
            c09541 = (C09541) continuation;
            if ((c09541.label & Integer.MIN_VALUE) != 0) {
                c09541.label -= Integer.MIN_VALUE;
            } else {
                c09541 = new C09541(continuation);
            }
        } else {
            c09541 = new C09541(continuation);
        }
        C09541 c09542 = c09541;
        Object objCallContext = c09542.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09542.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCallContext);
            c09542.L$0 = httpRequestData;
            c09542.label = 1;
            objCallContext = UtilsKt.callContext(c09542);
            if (objCallContext != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2 && i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCallContext);
            return objCallContext;
        }
        httpRequestData = (HttpRequestData) c09542.L$0;
        ResultKt.throwOnFailure(objCallContext);
        HttpRequestData httpRequestData2 = httpRequestData;
        CoroutineContext coroutineContext = (CoroutineContext) objCallContext;
        Request requestConvertToOkHttpRequest = OkHttpEngineKt.convertToOkHttpRequest(httpRequestData2, coroutineContext, getConfig());
        OkHttpClient okHttpClient = this.clientCache.get(httpRequestData2.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE));
        if (okHttpClient == null) {
            throw new IllegalStateException("OkHttpClient can't be constructed because HttpTimeout plugin is not installed".toString());
        }
        if (HttpRequestKt.isUpgradeRequest(httpRequestData2)) {
            c09542.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestData2);
            c09542.L$1 = SpillingKt.nullOutSpilledVariable(coroutineContext);
            c09542.L$2 = SpillingKt.nullOutSpilledVariable(requestConvertToOkHttpRequest);
            c09542.L$3 = SpillingKt.nullOutSpilledVariable(okHttpClient);
            c09542.label = 2;
            Object objExecuteWebSocketRequest = executeWebSocketRequest(okHttpClient, requestConvertToOkHttpRequest, coroutineContext, httpRequestData2, c09542);
            if (objExecuteWebSocketRequest != coroutine_suspended) {
                return objExecuteWebSocketRequest;
            }
        } else {
            c09542.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestData2);
            c09542.L$1 = SpillingKt.nullOutSpilledVariable(coroutineContext);
            c09542.L$2 = SpillingKt.nullOutSpilledVariable(requestConvertToOkHttpRequest);
            c09542.L$3 = SpillingKt.nullOutSpilledVariable(okHttpClient);
            c09542.label = 3;
            Object objExecuteHttpRequest = executeHttpRequest(okHttpClient, requestConvertToOkHttpRequest, coroutineContext, httpRequestData2, c09542);
            if (objExecuteHttpRequest != coroutine_suspended) {
                return objExecuteHttpRequest;
            }
        }
        return coroutine_suspended;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        CoroutineContext.Element element = this.requestsJob.get(Job.INSTANCE);
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        ((CompletableJob) element).complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object executeWebSocketRequest(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) {
        C09561 c09561;
        HttpRequestData httpRequestData2;
        CoroutineContext coroutineContext2;
        GMTDate gMTDate;
        Object obj;
        if (continuation instanceof C09561) {
            c09561 = (C09561) continuation;
            if ((c09561.label & Integer.MIN_VALUE) != 0) {
                c09561.label -= Integer.MIN_VALUE;
            } else {
                c09561 = new C09561(continuation);
            }
        } else {
            c09561 = new C09561(continuation);
        }
        Object obj2 = c09561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09561.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            GMTDate gMTDateGMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
            WebSockets webSockets = (WebSockets) httpRequestData.getAttributes().get(WebSocketsKt.getWEBSOCKETS_KEY());
            OkHttpClient webSocketFactory = getConfig().getWebSocketFactory();
            if (webSocketFactory == null) {
                webSocketFactory = okHttpClient;
            }
            OkHttpWebsocketSession okHttpWebsocketSession = new OkHttpWebsocketSession(okHttpClient, webSocketFactory, request, coroutineContext, webSockets.getChannelsConfig());
            okHttpWebsocketSession.start();
            CompletableDeferred<Response> originResponse$ktor_client_okhttp = okHttpWebsocketSession.getOriginResponse$ktor_client_okhttp();
            c09561.L$0 = SpillingKt.nullOutSpilledVariable(okHttpClient);
            c09561.L$1 = SpillingKt.nullOutSpilledVariable(request);
            c09561.L$2 = coroutineContext;
            c09561.L$3 = httpRequestData;
            c09561.L$4 = gMTDateGMTDate$default;
            c09561.L$5 = SpillingKt.nullOutSpilledVariable(webSockets);
            c09561.L$6 = okHttpWebsocketSession;
            c09561.label = 1;
            Object objAwait = originResponse$ktor_client_okhttp.await(c09561);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpRequestData2 = httpRequestData;
            coroutineContext2 = coroutineContext;
            gMTDate = gMTDateGMTDate$default;
            obj = okHttpWebsocketSession;
            obj2 = objAwait;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj3 = (OkHttpWebsocketSession) c09561.L$6;
            GMTDate gMTDate2 = (GMTDate) c09561.L$4;
            HttpRequestData httpRequestData3 = (HttpRequestData) c09561.L$3;
            CoroutineContext coroutineContext3 = (CoroutineContext) c09561.L$2;
            ResultKt.throwOnFailure(obj2);
            obj = obj3;
            gMTDate = gMTDate2;
            httpRequestData2 = httpRequestData3;
            coroutineContext2 = coroutineContext3;
        }
        return buildResponseData((Response) obj2, gMTDate, obj, coroutineContext2, httpRequestData2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object executeHttpRequest(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) {
        C09551 c09551;
        GMTDate gMTDate;
        if (continuation instanceof C09551) {
            c09551 = (C09551) continuation;
            if ((c09551.label & Integer.MIN_VALUE) != 0) {
                c09551.label -= Integer.MIN_VALUE;
            } else {
                c09551 = new C09551(continuation);
            }
        } else {
            c09551 = new C09551(continuation);
        }
        Object obj = c09551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09551.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GMTDate gMTDateGMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
            c09551.L$0 = SpillingKt.nullOutSpilledVariable(okHttpClient);
            c09551.L$1 = SpillingKt.nullOutSpilledVariable(request);
            c09551.L$2 = coroutineContext;
            c09551.L$3 = httpRequestData;
            c09551.L$4 = gMTDateGMTDate$default;
            c09551.label = 1;
            Object objExecute = OkUtilsKt.execute(okHttpClient, request, httpRequestData, coroutineContext, c09551);
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
            gMTDate = gMTDateGMTDate$default;
            obj = objExecute;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            GMTDate gMTDate2 = (GMTDate) c09551.L$4;
            httpRequestData = (HttpRequestData) c09551.L$3;
            coroutineContext = (CoroutineContext) c09551.L$2;
            ResultKt.throwOnFailure(obj);
            gMTDate = gMTDate2;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        HttpRequestData httpRequestData2 = httpRequestData;
        Response response = (Response) obj;
        final ResponseBody responseBodyBody = response.body();
        JobKt.getJob(coroutineContext2).invokeOnCompletion(new Function1() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return OkHttpEngine.executeHttpRequest$lambda$0(responseBodyBody, (Throwable) obj2);
            }
        });
        return buildResponseData(response, gMTDate, OkHttpEngineKt.toChannel(responseBodyBody.getSource(), coroutineContext2, httpRequestData2), coroutineContext2, httpRequestData2);
    }

    static final Unit executeHttpRequest$lambda$0(ResponseBody responseBody, Throwable th) {
        responseBody.close();
        return Unit.INSTANCE;
    }

    private final HttpResponseData buildResponseData(Response response, GMTDate requestTime, Object body, CoroutineContext callContext, HttpRequestData requestData) {
        CoroutineContext coroutineContext;
        Object obj;
        ResponseAdapter responseAdapter;
        HttpStatusCode httpStatusCode = new HttpStatusCode(response.code(), response.message());
        HttpProtocolVersion httpProtocolVersionFromOkHttp = OkUtilsKt.fromOkHttp(response.protocol());
        Headers headersFromOkHttp = OkUtilsKt.fromOkHttp(response.headers());
        if ((body instanceof ByteReadChannel) && (responseAdapter = (ResponseAdapter) requestData.getAttributes().getOrNull(HttpRequestKt.getResponseAdapterAttributeKey())) != null) {
            coroutineContext = callContext;
            Object objAdapt = responseAdapter.adapt(requestData, httpStatusCode, headersFromOkHttp, (ByteReadChannel) body, requestData.getBody(), coroutineContext);
            if (objAdapt != null) {
                httpStatusCode = httpStatusCode;
                obj = objAdapt;
            }
            return new HttpResponseData(httpStatusCode, requestTime, headersFromOkHttp, httpProtocolVersionFromOkHttp, obj, coroutineContext);
        }
        coroutineContext = callContext;
        httpStatusCode = httpStatusCode;
        obj = body;
        return new HttpResponseData(httpStatusCode, requestTime, headersFromOkHttp, httpProtocolVersionFromOkHttp, obj, coroutineContext);
    }

    /* JADX INFO: compiled from: OkHttpEngine.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine$Companion;", "", "<init>", "()V", "Lokhttp3/OkHttpClient;", "okHttpClientPrototype$delegate", "Lkotlin/Lazy;", "getOkHttpClientPrototype", "()Lokhttp3/OkHttpClient;", "okHttpClientPrototype", "ktor-client-okhttp"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OkHttpClient getOkHttpClientPrototype() {
            return (OkHttpClient) OkHttpEngine.okHttpClientPrototype$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient createOkHttpClient(HttpTimeoutConfig timeoutExtension) {
        OkHttpClient preconfigured = getConfig().getPreconfigured();
        if (preconfigured == null) {
            preconfigured = Companion.getOkHttpClientPrototype();
        }
        OkHttpClient.Builder builderNewBuilder = preconfigured.newBuilder();
        builderNewBuilder.dispatcher(new Dispatcher());
        getConfig().getConfig$ktor_client_okhttp().invoke(builderNewBuilder);
        Proxy proxy = getConfig().getProxy();
        if (proxy != null) {
            builderNewBuilder.proxy(proxy);
        }
        if (timeoutExtension != null) {
            OkHttpEngineKt.setupTimeoutAttributes(builderNewBuilder, timeoutExtension);
        }
        return builderNewBuilder.build();
    }
}
