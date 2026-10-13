package io.ktor.client.statement;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannelKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: HttpStatement.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JI\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b21\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0010\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0010\u0010\u0012J\u0018\u0010\u0013\u001a\u00028\u0000\"\u0006\b\u0000\u0010\b\u0018\u0001H\u0086H¢\u0006\u0004\b\u0013\u0010\u0012JS\u0010\u0013\u001a\u00028\u0001\"\u0006\b\u0000\u0010\b\u0018\u0001\"\u0004\b\u0001\u0010\u001423\b\u0004\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086H¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0015\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0016\u0010\u0012J\u0014\u0010\u0018\u001a\u00020\u0017*\u00020\nH\u0081@¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u00020\u001aH\u0096\u0080\u0004¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR \u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "block", "execute", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "R", "fetchStreamingResponse", "fetchResponse", "", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "getClient$annotations", "()V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$cleanup$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {0, 0, 0, 0}, l = {200}, m = "cleanup", n = {"$this$cleanup", "job", "$this$cleanup_u24lambda_u240", "$i$a$-apply-HttpStatement$cleanup$2"}, s = {"L$0", "L$1", "L$3", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.cleanup(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION, 62, 66, 66}, m = "execute", n = {"block", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$execute$2", "block", "response", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$execute$2", "block", "response", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$execute$2", "block", "response", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$execute$2"}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C10201<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10201(Continuation<? super C10201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$fetchResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {173, WebmConstants.MkvEbmlElement.PIXEL_WIDTH, 177}, m = "fetchResponse", n = {"builder", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$fetchResponse$2", "builder", NotificationCompat.CATEGORY_CALL, "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$fetchResponse$2", "builder", NotificationCompat.CATEGORY_CALL, "result", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$fetchResponse$2"}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C10211 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10211(Continuation<? super C10211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchResponse(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {0, 0, 0}, l = {WebmConstants.MkvEbmlElement.BLOCK}, m = "fetchStreamingResponse", n = {"builder", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$fetchStreamingResponse$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C10221 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10221(Continuation<? super C10221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchStreamingResponse(this);
        }
    }

    public static /* synthetic */ void getClient$annotations() {
    }

    public HttpStatement(HttpRequestBuilder builder, HttpClient client) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(client, "client");
        this.builder = builder;
        this.client = client;
    }

    public final HttpClient getClient() {
        return this.client;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x010a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <T> Object execute(Function2<? super HttpResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        C10201 c10201;
        int i;
        Object objFetchStreamingResponse;
        int i2;
        HttpResponse httpResponse;
        HttpResponse httpResponse2;
        int i3;
        Function2<? super HttpResponse, ? super Continuation<? super T>, ? extends Object> function3;
        int i4;
        if (continuation instanceof C10201) {
            c10201 = (C10201) continuation;
            if ((c10201.label & Integer.MIN_VALUE) != 0) {
                c10201.label -= Integer.MIN_VALUE;
            } else {
                c10201 = new C10201(continuation);
            }
        } else {
            c10201 = new C10201(continuation);
        }
        Object obj = c10201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c10201.label;
        try {
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    c10201.L$0 = function2;
                    i = 0;
                    c10201.I$0 = 0;
                    c10201.I$1 = 0;
                    c10201.label = 1;
                    objFetchStreamingResponse = fetchStreamingResponse(c10201);
                    if (objFetchStreamingResponse != coroutine_suspended) {
                        i2 = 0;
                    }
                    return coroutine_suspended;
                }
                if (i5 == 1) {
                    int i6 = c10201.I$1;
                    int i7 = c10201.I$0;
                    Function2<? super HttpResponse, ? super Continuation<? super T>, ? extends Object> function4 = (Function2) c10201.L$0;
                    ResultKt.throwOnFailure(obj);
                    i = i6;
                    function2 = function4;
                    i2 = i7;
                    objFetchStreamingResponse = obj;
                } else {
                    if (i5 != 2) {
                        if (i5 == 3) {
                            int i8 = c10201.I$1;
                            int i9 = c10201.I$0;
                            Object obj2 = c10201.L$2;
                            ResultKt.throwOnFailure(obj);
                            return obj2;
                        }
                        if (i5 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i10 = c10201.I$1;
                        int i11 = c10201.I$0;
                        Throwable th = (Throwable) c10201.L$2;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    }
                    i4 = c10201.I$1;
                    i3 = c10201.I$0;
                    httpResponse2 = (HttpResponse) c10201.L$1;
                    function3 = (Function2) c10201.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        c10201.L$0 = SpillingKt.nullOutSpilledVariable(function3);
                        c10201.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        c10201.L$2 = obj;
                        c10201.I$0 = i3;
                        c10201.I$1 = i4;
                        c10201.label = 3;
                        if (cleanup(httpResponse2, c10201) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        c10201.L$0 = SpillingKt.nullOutSpilledVariable(function3);
                        c10201.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        c10201.L$2 = th;
                        c10201.I$0 = i3;
                        c10201.I$1 = i4;
                        c10201.label = 4;
                        if (cleanup(httpResponse2, c10201) != coroutine_suspended) {
                            throw th;
                        }
                    }
                }
                CoroutineContext.Element element = httpResponse.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
                Intrinsics.checkNotNull(element);
                HttpStatement$execute$2$1 httpStatement$execute$2$1 = new HttpStatement$execute$2$1(function2, httpResponse, null);
                c10201.L$0 = SpillingKt.nullOutSpilledVariable(function2);
                c10201.L$1 = httpResponse;
                c10201.I$0 = i2;
                c10201.I$1 = i;
                c10201.label = 2;
                Object objWithContext = BuildersKt.withContext(element, httpStatement$execute$2$1, c10201);
                if (objWithContext != coroutine_suspended) {
                    httpResponse2 = httpResponse;
                    i3 = i2;
                    function3 = function2;
                    i4 = i;
                    obj = objWithContext;
                    c10201.L$0 = SpillingKt.nullOutSpilledVariable(function3);
                    c10201.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                    c10201.L$2 = obj;
                    c10201.I$0 = i3;
                    c10201.I$1 = i4;
                    c10201.label = 3;
                    if (cleanup(httpResponse2, c10201) != coroutine_suspended) {
                        return obj;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                httpResponse2 = httpResponse;
                i3 = i2;
                function3 = function2;
                i4 = i;
                c10201.L$0 = SpillingKt.nullOutSpilledVariable(function3);
                c10201.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                c10201.L$2 = th;
                c10201.I$0 = i3;
                c10201.I$1 = i4;
                c10201.label = 4;
                if (cleanup(httpResponse2, c10201) != coroutine_suspended) {
                    throw th;
                }
            }
            httpResponse = (HttpResponse) objFetchStreamingResponse;
            return coroutine_suspended;
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    public final Object execute(Continuation<? super HttpResponse> continuation) {
        return fetchResponse(continuation);
    }

    public final /* synthetic */ <T> Object body(Continuation<? super T> continuation) throws Throwable {
        try {
            HttpResponse httpResponse = (HttpResponse) fetchStreamingResponse(null);
            try {
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                } catch (Throwable unused) {
                }
                Object objBodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass, null), null);
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                Object obj = objBodyNullable;
                HttpResponseKt.complete(httpResponse);
                return objBodyNullable;
            } catch (Throwable th) {
                HttpResponseKt.complete(httpResponse);
                throw th;
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    public final /* synthetic */ <T, R> Object body(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws Throwable {
        try {
            HttpResponse httpResponse = (HttpResponse) fetchStreamingResponse(null);
            try {
                CoroutineContext.Element element = httpResponse.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
                Intrinsics.checkNotNull(element);
                Intrinsics.needClassReification();
                return BuildersKt.withContext(element, new HttpStatement$body$4$1(httpResponse, function2, null), null);
            } finally {
                cleanup(httpResponse, null);
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchStreamingResponse(Continuation<? super HttpResponse> continuation) throws Throwable {
        C10221 c10221;
        if (continuation instanceof C10221) {
            c10221 = (C10221) continuation;
            if ((c10221.label & Integer.MIN_VALUE) != 0) {
                c10221.label -= Integer.MIN_VALUE;
            } else {
                c10221 = new C10221(continuation);
            }
        } else {
            c10221 = new C10221(continuation);
        }
        Object objExecute$ktor_client_core = c10221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10221.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
                HttpRequestBuilder httpRequestBuilderTakeFromWithExecutionContext = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                DoubleReceivePluginKt.skipSaveBody(httpRequestBuilderTakeFromWithExecutionContext);
                HttpClient httpClient = this.client;
                c10221.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilderTakeFromWithExecutionContext);
                c10221.I$0 = 0;
                c10221.I$1 = 0;
                c10221.label = 1;
                objExecute$ktor_client_core = httpClient.execute$ktor_client_core(httpRequestBuilderTakeFromWithExecutionContext, c10221);
                if (objExecute$ktor_client_core == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c10221.I$1;
                int i3 = c10221.I$0;
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
            }
            return ((HttpClientCall) objExecute$ktor_client_core).getResponse();
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00cc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchResponse(Continuation<? super HttpResponse> continuation) throws Throwable {
        C10211 c10211;
        int i;
        HttpRequestBuilder httpRequestBuilder;
        int i2;
        HttpClientCall httpClientCall;
        int i3;
        HttpResponse response;
        HttpResponse response2;
        if (continuation instanceof C10211) {
            c10211 = (C10211) continuation;
            if ((c10211.label & Integer.MIN_VALUE) != 0) {
                c10211.label -= Integer.MIN_VALUE;
            } else {
                c10211 = new C10211(continuation);
            }
        } else {
            c10211 = new C10211(continuation);
        }
        Object obj = c10211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c10211.label;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                HttpRequestBuilder httpRequestBuilderTakeFromWithExecutionContext = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                HttpClient httpClient = this.client;
                c10211.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilderTakeFromWithExecutionContext);
                c10211.I$0 = 0;
                c10211.I$1 = 0;
                c10211.label = 1;
                Object objExecute$ktor_client_core = httpClient.execute$ktor_client_core(httpRequestBuilderTakeFromWithExecutionContext, c10211);
                if (objExecute$ktor_client_core != coroutine_suspended) {
                    i = 0;
                    httpRequestBuilder = httpRequestBuilderTakeFromWithExecutionContext;
                    obj = objExecute$ktor_client_core;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i4 == 1) {
                i2 = c10211.I$1;
                i = c10211.I$0;
                httpRequestBuilder = (HttpRequestBuilder) c10211.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i4 != 2) {
                    if (i4 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i5 = c10211.I$1;
                    int i6 = c10211.I$0;
                    HttpResponse httpResponse = (HttpResponse) c10211.L$2;
                    ResultKt.throwOnFailure(obj);
                    return httpResponse;
                }
                i2 = c10211.I$1;
                i3 = c10211.I$0;
                httpClientCall = (HttpClientCall) c10211.L$1;
                httpRequestBuilder = (HttpRequestBuilder) c10211.L$0;
                ResultKt.throwOnFailure(obj);
            }
            response = ((HttpClientCall) obj).getResponse();
            response2 = httpClientCall.getResponse();
            c10211.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
            c10211.L$1 = SpillingKt.nullOutSpilledVariable(httpClientCall);
            c10211.L$2 = response;
            c10211.I$0 = i3;
            c10211.I$1 = i2;
            c10211.label = 3;
            if (cleanup(response2, c10211) != coroutine_suspended) {
                return coroutine_suspended;
            }
            return response;
            HttpClientCall httpClientCall2 = (HttpClientCall) obj;
            c10211.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
            c10211.L$1 = httpClientCall2;
            c10211.I$0 = i;
            c10211.I$1 = i2;
            c10211.label = 2;
            Object objSave = SavedCallKt.save(httpClientCall2, c10211);
            if (objSave != coroutine_suspended) {
                int i7 = i;
                httpClientCall = httpClientCall2;
                obj = objSave;
                i3 = i7;
                response = ((HttpClientCall) obj).getResponse();
                response2 = httpClientCall.getResponse();
                c10211.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                c10211.L$1 = SpillingKt.nullOutSpilledVariable(httpClientCall);
                c10211.L$2 = response;
                c10211.I$0 = i3;
                c10211.I$1 = i2;
                c10211.label = 3;
                if (cleanup(response2, c10211) != coroutine_suspended) {
                    return response;
                }
            }
            return coroutine_suspended;
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object cleanup(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
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
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = JobKt.getJob(httpResponse.getCoroutineContext());
            Intrinsics.checkNotNull(job, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
            CompletableJob completableJob = (CompletableJob) job;
            completableJob.complete();
            if (!DoubleReceivePluginKt.isSaved(httpResponse)) {
                try {
                    ByteReadChannelKt.cancel(httpResponse.getRawContent());
                } catch (Throwable unused) {
                }
            }
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(completableJob);
            anonymousClass1.L$2 = completableJob;
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(completableJob);
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            if (completableJob.join(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl() + AbstractJsonLexerKt.END_LIST;
    }
}
