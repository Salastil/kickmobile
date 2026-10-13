package io.ktor.client.plugins.sse;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: builders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt$processSession$2", f = "builders.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {1270, 1272, 1277, 1277}, m = "invokeSuspend", n = {"this_$iv", "$i$f$body", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$body$4$iv", "this_$iv", "response$iv", "$i$f$body", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$body$4$iv", "this_$iv", "response$iv", "$i$f$body", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$body$4$iv", "this_$iv", "response$iv", "$i$f$body", "$i$f$unwrapRequestTimeoutException", "$i$a$-unwrapRequestTimeoutException-HttpStatement$body$4$iv"}, s = {"L$0", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2"}, v = 1)
public final class BuildersKt$processSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<T> $sessionDeferred;
    final /* synthetic */ HttpStatement $statement;
    final /* synthetic */ HttpClient $this_processSession;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$processSession$2(HttpStatement httpStatement, CompletableDeferred<T> completableDeferred, HttpClient httpClient, Continuation<? super BuildersKt$processSession$2> continuation) {
        super(2, continuation);
        this.$statement = httpStatement;
        this.$sessionDeferred = completableDeferred;
        this.$this_processSession = httpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BuildersKt$processSession$2(this.$statement, this.$sessionDeferred, this.$this_processSession, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BuildersKt$processSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00fb  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CompletableDeferred completableDeferred;
        int i;
        HttpStatement httpStatement;
        int i2;
        int i3;
        HttpResponse httpResponse;
        int i4;
        int i5;
        HttpStatement httpStatement2;
        HttpResponse httpResponse2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        try {
            try {
                try {
                    try {
                        if (i6 == 0) {
                            ResultKt.throwOnFailure(obj);
                            HttpStatement httpStatement3 = this.$statement;
                            completableDeferred = this.$sessionDeferred;
                            this.L$0 = httpStatement3;
                            this.L$1 = completableDeferred;
                            i = 0;
                            this.I$0 = 0;
                            this.I$1 = 0;
                            this.I$2 = 0;
                            this.label = 1;
                            Object objFetchStreamingResponse = httpStatement3.fetchStreamingResponse(this);
                            if (objFetchStreamingResponse != coroutine_suspended) {
                                httpStatement = httpStatement3;
                                i2 = 0;
                                obj = objFetchStreamingResponse;
                                i3 = 0;
                            }
                            return coroutine_suspended;
                        }
                        if (i6 != 1) {
                            if (i6 == 2) {
                                i = this.I$2;
                                i4 = this.I$1;
                                i5 = this.I$0;
                                httpResponse2 = (HttpResponse) this.L$1;
                                httpStatement2 = (HttpStatement) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(httpStatement2);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                                    this.L$2 = obj;
                                    this.I$0 = i5;
                                    this.I$1 = i4;
                                    this.I$2 = i;
                                    this.label = 3;
                                    if (httpStatement2.cleanup(httpResponse2, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(httpStatement2);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                                    this.L$2 = th;
                                    this.I$0 = i5;
                                    this.I$1 = i4;
                                    this.I$2 = i;
                                    this.label = 4;
                                    if (httpStatement2.cleanup(httpResponse2, this) != coroutine_suspended) {
                                        throw th;
                                    }
                                }
                            } else {
                                if (i6 != 3) {
                                    if (i6 != 4) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    Throwable th2 = (Throwable) this.L$2;
                                    ResultKt.throwOnFailure(obj);
                                    throw th2;
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                        i = this.I$2;
                        i3 = this.I$1;
                        i2 = this.I$0;
                        completableDeferred = (CompletableDeferred) this.L$1;
                        httpStatement = (HttpStatement) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        CoroutineContext.Element element = httpResponse.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
                        Intrinsics.checkNotNull(element);
                        Intrinsics.needClassReification();
                        BuildersKt$processSession$2$invokeSuspend$$inlined$body$1 buildersKt$processSession$2$invokeSuspend$$inlined$body$1 = new BuildersKt$processSession$2$invokeSuspend$$inlined$body$1(httpResponse, null, completableDeferred);
                        this.L$0 = httpStatement;
                        this.L$1 = httpResponse;
                        this.I$0 = i2;
                        this.I$1 = i3;
                        this.I$2 = i;
                        this.label = 2;
                        Object objWithContext = kotlinx.coroutines.BuildersKt.withContext(element, buildersKt$processSession$2$invokeSuspend$$inlined$body$1, this);
                        if (objWithContext != coroutine_suspended) {
                            i4 = i3;
                            i5 = i2;
                            httpStatement2 = httpStatement;
                            httpResponse2 = httpResponse;
                            obj = objWithContext;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(httpStatement2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                            this.L$2 = obj;
                            this.I$0 = i5;
                            this.I$1 = i4;
                            this.I$2 = i;
                            this.label = 3;
                            if (httpStatement2.cleanup(httpResponse2, this) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i4 = i3;
                        i5 = i2;
                        httpStatement2 = httpStatement;
                        httpResponse2 = httpResponse;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(httpStatement2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        this.L$2 = th;
                        this.I$0 = i5;
                        this.I$1 = i4;
                        this.I$2 = i;
                        this.label = 4;
                        if (httpStatement2.cleanup(httpResponse2, this) != coroutine_suspended) {
                            throw th;
                        }
                    }
                    httpResponse = (HttpResponse) obj;
                    return coroutine_suspended;
                } catch (CancellationException e) {
                    this.$sessionDeferred.cancel(e);
                }
            } catch (Throwable th4) {
                this.$sessionDeferred.completeExceptionally(BuildersKt.mapToSSEException(this.$this_processSession, null, null, th4));
            }
        } catch (CancellationException e2) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e2);
        }
    }
}
