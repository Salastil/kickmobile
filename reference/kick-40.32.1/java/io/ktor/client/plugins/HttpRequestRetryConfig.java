package io.ktor.client.plugins;

import com.facebook.hermes.intl.Constants;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.utils.io.KtorDsl;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: HttpRequestRetry.kt */
/* JADX INFO: loaded from: classes9.dex */
@KtorDsl
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J,\u0010\u000b\u001a\u00020\u00042\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\u000b\u0010\fJ<\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2#\u0010\n\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0002\b\t¢\u0006\u0004\b\u0014\u0010\u0015J<\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2#\u0010\n\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0002\b\t¢\u0006\u0004\b\u0017\u0010\u0015J!\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001cJE\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00132,\u0010\n\u001a(\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b$\u0010%J+\u0010(\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b(\u0010)J?\u0010.\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020#2\b\b\u0002\u0010-\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b.\u0010/J1\u00101\u001a\u00020\u00042\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000400\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b1\u0010\fJ\u0017\u00102\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0002¢\u0006\u0004\b2\u00103R?\u00104\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0002\b\t8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R?\u0010:\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0002\b\t8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b:\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R9\u0010$\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020#0\u0006¢\u0006\u0002\b\t8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b$\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\fR>\u00101\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000400\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u0010=\u001a\u0004\bA\u0010?\"\u0004\bB\u0010\fR0\u0010\u0014\u001a!\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f¢\u0006\u0002\b\t8F¢\u0006\u0006\u001a\u0004\bC\u00107R0\u0010\u0017\u001a!\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f¢\u0006\u0002\b\t8F¢\u0006\u0006\u001a\u0004\bD\u00107RR\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\t2\u001d\u0010E\u001a\u0019\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010=\u001a\u0004\bF\u0010?R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010\u001c¨\u0006K"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetryConfig;", "", "<init>", "()V", "", "noRetry", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRetryModifyRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/ExtensionFunctionType;", "block", "modifyRequest", "(Lkotlin/jvm/functions/Function2;)V", "", "maxRetries", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRetryShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "", "retryIf", "(ILkotlin/jvm/functions/Function3;)V", "", "retryOnExceptionIf", "retryOnTimeout", "retryOnException", "(IZ)V", "retryOnServerErrors", "(I)V", "retryOnExceptionOrServerErrors", "respectRetryAfterHeader", "Lio/ktor/client/plugins/HttpRetryDelayContext;", "Lkotlin/ParameterName;", "name", "retry", "", "delayMillis", "(ZLkotlin/jvm/functions/Function2;)V", "millis", "randomizationMs", "constantDelay", "(JJZ)V", "", Constants.SENSITIVITY_BASE, "baseDelayMs", "maxDelayMs", "exponentialDelay", "(DJJJZ)V", "Lkotlin/coroutines/Continuation;", "delay", "randomMs", "(J)J", "shouldRetry", "Lkotlin/jvm/functions/Function3;", "getShouldRetry$ktor_client_core", "()Lkotlin/jvm/functions/Function3;", "setShouldRetry$ktor_client_core", "(Lkotlin/jvm/functions/Function3;)V", "shouldRetryOnException", "getShouldRetryOnException$ktor_client_core", "setShouldRetryOnException$ktor_client_core", "Lkotlin/jvm/functions/Function2;", "getDelayMillis$ktor_client_core", "()Lkotlin/jvm/functions/Function2;", "setDelayMillis$ktor_client_core", "getDelay$ktor_client_core", "setDelay$ktor_client_core", "getRetryIf", "getRetryOnExceptionIf", "value", "getModifyRequest", "I", "getMaxRetries", "()I", "setMaxRetries", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpRequestRetryConfig {
    public Function2<? super HttpRetryDelayContext, ? super Integer, Long> delayMillis;
    private int maxRetries;
    public Function3<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> shouldRetry;
    public Function3<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> shouldRetryOnException;
    private Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> delay = new AnonymousClass1(null);
    private Function2<? super HttpRetryModifyRequestContext, ? super HttpRequestBuilder, Unit> modifyRequest = new Function2() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return HttpRequestRetryConfig.modifyRequest$lambda$0((HttpRetryModifyRequestContext) obj, (HttpRequestBuilder) obj2);
        }
    };

    static final boolean noRetry$lambda$0(HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequest httpRequest, HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpRetryShouldRetryContext, "<this>");
        Intrinsics.checkNotNullParameter(httpRequest, "<unused var>");
        Intrinsics.checkNotNullParameter(httpResponse, "<unused var>");
        return false;
    }

    static final boolean noRetry$lambda$1(HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        Intrinsics.checkNotNullParameter(httpRetryShouldRetryContext, "<this>");
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<unused var>");
        Intrinsics.checkNotNullParameter(th, "<unused var>");
        return false;
    }

    public HttpRequestRetryConfig() {
        retryOnExceptionOrServerErrors(3);
        exponentialDelay$default(this, 0.0d, 0L, 0L, 0L, false, 31, null);
    }

    public final Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> getShouldRetry$ktor_client_core() {
        Function3 function3 = this.shouldRetry;
        if (function3 != null) {
            return function3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shouldRetry");
        return null;
    }

    public final void setShouldRetry$ktor_client_core(Function3<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.shouldRetry = function3;
    }

    public final Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> getShouldRetryOnException$ktor_client_core() {
        Function3 function3 = this.shouldRetryOnException;
        if (function3 != null) {
            return function3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shouldRetryOnException");
        return null;
    }

    public final void setShouldRetryOnException$ktor_client_core(Function3<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.shouldRetryOnException = function3;
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.HttpRequestRetryConfig$delay$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpRequestRetry.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetryConfig$delay$1", f = "HttpRequestRetry.kt", i = {0}, l = {42}, m = "invokeSuspend", n = {"it"}, s = {"J$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.J$0 = ((Number) obj).longValue();
            return anonymousClass1;
        }

        public final Object invoke(long j, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(Long.valueOf(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Long l, Continuation<? super Unit> continuation) {
            return invoke(l.longValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long j = this.J$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.J$0 = j;
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final Function2<HttpRetryDelayContext, Integer, Long> getDelayMillis$ktor_client_core() {
        Function2 function2 = this.delayMillis;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delayMillis");
        return null;
    }

    public final void setDelayMillis$ktor_client_core(Function2<? super HttpRetryDelayContext, ? super Integer, Long> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.delayMillis = function2;
    }

    public final Function2<Long, Continuation<? super Unit>, Object> getDelay$ktor_client_core() {
        return this.delay;
    }

    public final void setDelay$ktor_client_core(Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.delay = function2;
    }

    public final Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> getRetryIf() {
        if (this.shouldRetry != null) {
            return getShouldRetry$ktor_client_core();
        }
        return null;
    }

    public final Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> getRetryOnExceptionIf() {
        if (this.shouldRetryOnException != null) {
            return getShouldRetryOnException$ktor_client_core();
        }
        return null;
    }

    static final Unit modifyRequest$lambda$0(HttpRetryModifyRequestContext httpRetryModifyRequestContext, HttpRequestBuilder it) {
        Intrinsics.checkNotNullParameter(httpRetryModifyRequestContext, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function2<HttpRetryModifyRequestContext, HttpRequestBuilder, Unit> getModifyRequest() {
        return this.modifyRequest;
    }

    public final int getMaxRetries() {
        return this.maxRetries;
    }

    public final void setMaxRetries(int i) {
        this.maxRetries = i;
    }

    public final void noRetry() {
        this.maxRetries = 0;
        setShouldRetry$ktor_client_core(new Function3() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(HttpRequestRetryConfig.noRetry$lambda$0((HttpRetryShouldRetryContext) obj, (HttpRequest) obj2, (HttpResponse) obj3));
            }
        });
        setShouldRetryOnException$ktor_client_core(new Function3() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(HttpRequestRetryConfig.noRetry$lambda$1((HttpRetryShouldRetryContext) obj, (HttpRequestBuilder) obj2, (Throwable) obj3));
            }
        });
    }

    public final void modifyRequest(Function2<? super HttpRetryModifyRequestContext, ? super HttpRequestBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.modifyRequest = block;
    }

    public static /* synthetic */ void retryIf$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, Function3 function3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        httpRequestRetryConfig.retryIf(i, function3);
    }

    public final void retryIf(int maxRetries, Function3<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (maxRetries != -1) {
            this.maxRetries = maxRetries;
        }
        setShouldRetry$ktor_client_core(block);
    }

    public static /* synthetic */ void retryOnExceptionIf$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, Function3 function3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        httpRequestRetryConfig.retryOnExceptionIf(i, function3);
    }

    public final void retryOnExceptionIf(int maxRetries, Function3<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (maxRetries != -1) {
            this.maxRetries = maxRetries;
        }
        setShouldRetryOnException$ktor_client_core(block);
    }

    public static /* synthetic */ void retryOnException$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        httpRequestRetryConfig.retryOnException(i, z);
    }

    public final void retryOnException(int maxRetries, final boolean retryOnTimeout) {
        retryOnExceptionIf(maxRetries, new Function3() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(HttpRequestRetryConfig.retryOnException$lambda$0(retryOnTimeout, (HttpRetryShouldRetryContext) obj, (HttpRequestBuilder) obj2, (Throwable) obj3));
            }
        });
    }

    static final boolean retryOnException$lambda$0(boolean z, HttpRetryShouldRetryContext retryOnExceptionIf, HttpRequestBuilder httpRequestBuilder, Throwable cause) {
        Intrinsics.checkNotNullParameter(retryOnExceptionIf, "$this$retryOnExceptionIf");
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<unused var>");
        Intrinsics.checkNotNullParameter(cause, "cause");
        if (HttpRequestRetryKt.isTimeoutException(cause)) {
            return z;
        }
        return !(cause instanceof CancellationException);
    }

    public static /* synthetic */ void retryOnServerErrors$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        httpRequestRetryConfig.retryOnServerErrors(i);
    }

    public final void retryOnServerErrors(int maxRetries) {
        retryIf(maxRetries, new Function3() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(HttpRequestRetryConfig.retryOnServerErrors$lambda$0((HttpRetryShouldRetryContext) obj, (HttpRequest) obj2, (HttpResponse) obj3));
            }
        });
    }

    static final boolean retryOnServerErrors$lambda$0(HttpRetryShouldRetryContext retryIf, HttpRequest httpRequest, HttpResponse response) {
        Intrinsics.checkNotNullParameter(retryIf, "$this$retryIf");
        Intrinsics.checkNotNullParameter(httpRequest, "<unused var>");
        Intrinsics.checkNotNullParameter(response, "response");
        int value = response.getStatus().getValue();
        return 500 <= value && value < 600;
    }

    public static /* synthetic */ void retryOnExceptionOrServerErrors$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        httpRequestRetryConfig.retryOnExceptionOrServerErrors(i);
    }

    public final void retryOnExceptionOrServerErrors(int maxRetries) {
        retryOnServerErrors(maxRetries);
        retryOnException$default(this, maxRetries, false, 2, null);
    }

    public static /* synthetic */ void delayMillis$default(HttpRequestRetryConfig httpRequestRetryConfig, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        httpRequestRetryConfig.delayMillis(z, function2);
    }

    public final void delayMillis(final boolean respectRetryAfterHeader, final Function2<? super HttpRetryDelayContext, ? super Integer, Long> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        setDelayMillis$ktor_client_core(new Function2() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(HttpRequestRetryConfig.delayMillis$lambda$0(respectRetryAfterHeader, block, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue()));
            }
        });
    }

    static final long delayMillis$lambda$0(boolean z, Function2 function2, HttpRetryDelayContext httpRetryDelayContext, int i) {
        Headers headers;
        String str;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(httpRetryDelayContext, "<this>");
        if (z) {
            HttpResponse response = httpRetryDelayContext.getResponse();
            Long lValueOf = (response == null || (headers = response.getHeaders()) == null || (str = headers.get("Retry-After")) == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? null : Long.valueOf(longOrNull.longValue() * 1000);
            return Math.max(((Number) function2.invoke(httpRetryDelayContext, Integer.valueOf(i))).longValue(), lValueOf != null ? lValueOf.longValue() : 0L);
        }
        return ((Number) function2.invoke(httpRetryDelayContext, Integer.valueOf(i))).longValue();
    }

    public static /* synthetic */ void constantDelay$default(HttpRequestRetryConfig httpRequestRetryConfig, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        if ((i & 2) != 0) {
            j2 = 1000;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        httpRequestRetryConfig.constantDelay(j, j2, z);
    }

    public final void constantDelay(final long millis, final long randomizationMs, boolean respectRetryAfterHeader) {
        if (millis <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (randomizationMs < 0) {
            throw new IllegalStateException("Check failed.");
        }
        delayMillis(respectRetryAfterHeader, new Function2() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(HttpRequestRetryConfig.constantDelay$lambda$0(millis, this, randomizationMs, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue()));
            }
        });
    }

    static final long constantDelay$lambda$0(long j, HttpRequestRetryConfig httpRequestRetryConfig, long j2, HttpRetryDelayContext delayMillis, int i) {
        Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
        return j + httpRequestRetryConfig.randomMs(j2);
    }

    public static /* synthetic */ void exponentialDelay$default(HttpRequestRetryConfig httpRequestRetryConfig, double d, long j, long j2, long j3, boolean z, int i, Object obj) {
        httpRequestRetryConfig.exponentialDelay((i & 1) != 0 ? 2.0d : d, (i & 2) != 0 ? 1000L : j, (i & 4) != 0 ? DurationKt.MILLIS_IN_MINUTE : j2, (i & 8) == 0 ? j3 : 1000L, (i & 16) != 0 ? true : z);
    }

    public final void exponentialDelay(final double base, final long baseDelayMs, final long maxDelayMs, final long randomizationMs, boolean respectRetryAfterHeader) {
        if (base <= 0.0d) {
            throw new IllegalStateException("Check failed.");
        }
        if (baseDelayMs <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (maxDelayMs <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (randomizationMs < 0) {
            throw new IllegalStateException("Check failed.");
        }
        delayMillis(respectRetryAfterHeader, new Function2() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(HttpRequestRetryConfig.exponentialDelay$lambda$0(base, baseDelayMs, maxDelayMs, this, randomizationMs, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue()));
            }
        });
    }

    static final long exponentialDelay$lambda$0(double d, long j, long j2, HttpRequestRetryConfig httpRequestRetryConfig, long j3, HttpRetryDelayContext delayMillis, int i) {
        Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
        return Math.min((long) (Math.pow(d, i - 1) * j), j2) + httpRequestRetryConfig.randomMs(j3);
    }

    public final void delay(Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.delay = block;
    }

    private final long randomMs(long randomizationMs) {
        if (randomizationMs == 0) {
            return 0L;
        }
        return Random.INSTANCE.nextLong(randomizationMs);
    }
}
