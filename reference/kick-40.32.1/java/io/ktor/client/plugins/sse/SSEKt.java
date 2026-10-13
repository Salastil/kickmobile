package io.ktor.client.plugins.sse;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.slf4j.Logger;

/* JADX INFO: compiled from: SSE.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a1\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0080@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\b*\u00020\bH\u0080@¢\u0006\u0004\b\r\u0010\f\"\u001e\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\" \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \" \u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 ¨\u0006$"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/util/AttributeKey;", "attributeKey", "getAttributeValue", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "response", "", "checkResponse", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saved", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/sse/SSEConfig;", "SSE", "Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE$annotations", "()V", "Lio/ktor/client/HttpClient;", "SSEClientForReconnectionAttr", "Lio/ktor/util/AttributeKey;", "getSSEClientForReconnectionAttr", "()Lio/ktor/util/AttributeKey;", "", "SSEReconnectionRequestAttr", "getSSEReconnectionRequestAttr", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SSEKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.sse.SSE");
    private static final ClientPlugin<SSEConfig> SSE = CreatePluginUtilsKt.createClientPlugin("SSE", SSEKt$SSE$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.sse.SSEKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SSEKt.SSE$lambda$0((ClientPluginBuilder) obj);
        }
    });
    private static final AttributeKey<HttpClient> SSEClientForReconnectionAttr;
    private static final AttributeKey<Boolean> SSEReconnectionRequestAttr;

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.SSEKt$checkResponse$1, reason: invalid class name */
    /* JADX INFO: compiled from: SSE.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.SSEKt", f = "SSE.kt", i = {0, 0, 0, 1, 1, 1}, l = {202, JfifUtil.MARKER_RST0}, m = "checkResponse", n = {"response", "status", "contentType", "response", "status", "contentType"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSEKt.checkResponse(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.SSEKt$saved$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SSE.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.SSEKt", f = "SSE.kt", i = {0}, l = {215}, m = "saved", n = {"$this$saved"}, s = {"L$0"}, v = 1)
    static final class C09821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09821(Continuation<? super C09821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSEKt.saved(null, this);
        }
    }

    public static /* synthetic */ void getSSE$annotations() {
    }

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpClient.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(HttpClient.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        SSEClientForReconnectionAttr = new AttributeKey<>("SSEClientForReconnection", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused2) {
        }
        SSEReconnectionRequestAttr = new AttributeKey<>("SSEReconnectionRequestAttr", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
    }

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final ClientPlugin<SSEConfig> getSSE() {
        return SSE;
    }

    static final Unit SSE$lambda$0(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.on(AfterRender.INSTANCE, new SSEKt$SSE$2$1(createClientPlugin, ((SSEConfig) createClientPlugin.getPluginConfig()).getReconnectionTime(), ((SSEConfig) createClientPlugin.getPluginConfig()).getShowCommentEvents(), ((SSEConfig) createClientPlugin.getPluginConfig()).getShowRetryEvents(), ((SSEConfig) createClientPlugin.getPluginConfig()).getMaxReconnectionAttempts(), ((SSEConfig) createClientPlugin.getPluginConfig()).getBufferPolicy(), null));
        createClientPlugin.getClient().getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getTransform(), new SSEKt$SSE$2$2(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T getAttributeValue(HttpRequestBuilder httpRequestBuilder, AttributeKey<T> attributeKey) {
        return (T) httpRequestBuilder.getAttributes().getOrNull(attributeKey);
    }

    public static final AttributeKey<HttpClient> getSSEClientForReconnectionAttr() {
        return SSEClientForReconnectionAttr;
    }

    public static final AttributeKey<Boolean> getSSEReconnectionRequestAttr() {
        return SSEReconnectionRequestAttr;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object checkResponse(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        ContentType contentType;
        HttpStatusCode httpStatusCode;
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
        Object objSaved = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                httpStatusCode = (HttpStatusCode) anonymousClass1.L$1;
                ResultKt.throwOnFailure(objSaved);
                throw new SSEClientException((HttpResponse) objSaved, null, "Expected status code " + HttpStatusCode.INSTANCE.getOK().getValue() + " but was " + httpStatusCode.getValue(), 2, null);
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            contentType = (ContentType) anonymousClass1.L$2;
            ResultKt.throwOnFailure(objSaved);
            throw new SSEClientException((HttpResponse) objSaved, null, "Expected Content-Type " + ContentType.Text.INSTANCE.getEventStream() + " but was " + contentType, 2, null);
        }
        ResultKt.throwOnFailure(objSaved);
        HttpStatusCode status = httpResponse.getStatus();
        ContentType contentType2 = HttpMessagePropertiesKt.contentType(httpResponse);
        if (Intrinsics.areEqual(status, HttpStatusCode.INSTANCE.getNoContent())) {
            Logger logger = LOGGER;
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Receive status code NoContent for SSE request to " + HttpResponseKt.getRequest(httpResponse).getUrl());
            }
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(status, HttpStatusCode.INSTANCE.getOK())) {
            if (!Intrinsics.areEqual(contentType2 != null ? contentType2.withoutParameters() : null, ContentType.Text.INSTANCE.getEventStream())) {
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(status);
                anonymousClass1.L$2 = contentType2;
                anonymousClass1.label = 2;
                objSaved = saved(httpResponse, anonymousClass1);
                if (objSaved != coroutine_suspended) {
                    contentType = contentType2;
                    throw new SSEClientException((HttpResponse) objSaved, null, "Expected Content-Type " + ContentType.Text.INSTANCE.getEventStream() + " but was " + contentType, 2, null);
                }
            } else {
                return Unit.INSTANCE;
            }
        } else {
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
            anonymousClass1.L$1 = status;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(contentType2);
            anonymousClass1.label = 1;
            Object objSaved2 = saved(httpResponse, anonymousClass1);
            if (objSaved2 != coroutine_suspended) {
                objSaved = objSaved2;
                httpStatusCode = status;
                throw new SSEClientException((HttpResponse) objSaved, null, "Expected status code " + HttpStatusCode.INSTANCE.getOK().getValue() + " but was " + httpStatusCode.getValue(), 2, null);
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object saved(HttpResponse httpResponse, Continuation<? super HttpResponse> continuation) {
        C09821 c09821;
        if (continuation instanceof C09821) {
            c09821 = (C09821) continuation;
            if ((c09821.label & Integer.MIN_VALUE) != 0) {
                c09821.label -= Integer.MIN_VALUE;
            } else {
                c09821 = new C09821(continuation);
            }
        } else {
            c09821 = new C09821(continuation);
        }
        Object objSave = c09821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09821.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSave);
            HttpClientCall call = httpResponse.getCall();
            c09821.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
            c09821.label = 1;
            objSave = SavedCallKt.save(call, c09821);
            if (objSave == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objSave);
        }
        HttpClientCall httpClientCall = (HttpClientCall) objSave;
        httpClientCall.getRequest().getAttributes().remove(BuildersKt.getSseRequestAttr());
        return httpClientCall.getResponse();
    }
}
