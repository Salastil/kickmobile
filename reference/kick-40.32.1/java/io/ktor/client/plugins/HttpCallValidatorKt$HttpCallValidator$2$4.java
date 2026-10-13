package io.ktor.client.plugins;

import androidx.media3.muxer.WebmConstants;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: HttpCallValidator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "request", "Lio/ktor/client/request/HttpRequest;", "cause"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$4", f = "HttpCallValidator.kt", i = {0, 0, 0}, l = {WebmConstants.MkvEbmlElement.FLAG_LACING}, m = "invokeSuspend", n = {"request", "cause", "unwrappedCause"}, s = {"L$0", "L$1", "L$2"}, v = 1)
final class HttpCallValidatorKt$HttpCallValidator$2$4 extends SuspendLambda implements Function3<HttpRequest, Throwable, Continuation<? super Throwable>, Object> {
    final /* synthetic */ List<HandlerWrapper> $callExceptionHandlers;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HttpCallValidatorKt$HttpCallValidator$2$4(List<? extends HandlerWrapper> list, Continuation<? super HttpCallValidatorKt$HttpCallValidator$2$4> continuation) {
        super(3, continuation);
        this.$callExceptionHandlers = list;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(HttpRequest httpRequest, Throwable th, Continuation<? super Throwable> continuation) {
        HttpCallValidatorKt$HttpCallValidator$2$4 httpCallValidatorKt$HttpCallValidator$2$4 = new HttpCallValidatorKt$HttpCallValidator$2$4(this.$callExceptionHandlers, continuation);
        httpCallValidatorKt$HttpCallValidator$2$4.L$0 = httpRequest;
        httpCallValidatorKt$HttpCallValidator$2$4.L$1 = th;
        return httpCallValidatorKt$HttpCallValidator$2$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpRequest httpRequest = (HttpRequest) this.L$0;
        Throwable th = (Throwable) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Throwable th2 = (Throwable) this.L$2;
            ResultKt.throwOnFailure(obj);
            return th2;
        }
        ResultKt.throwOnFailure(obj);
        Throwable thUnwrapCancellationException = ExceptionUtilsJvmKt.unwrapCancellationException(th);
        this.L$0 = SpillingKt.nullOutSpilledVariable(httpRequest);
        this.L$1 = SpillingKt.nullOutSpilledVariable(th);
        this.L$2 = thUnwrapCancellationException;
        this.label = 1;
        return HttpCallValidatorKt.HttpCallValidator$lambda$0$processException(this.$callExceptionHandlers, thUnwrapCancellationException, httpRequest, this) == coroutine_suspended ? coroutine_suspended : thUnwrapCancellationException;
    }
}
