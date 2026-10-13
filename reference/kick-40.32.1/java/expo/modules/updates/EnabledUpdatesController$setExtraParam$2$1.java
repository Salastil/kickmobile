package expo.modules.updates;

import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.updates.manifest.ManifestMetadata;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EnabledUpdatesController.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.EnabledUpdatesController$setExtraParam$2$1", f = "EnabledUpdatesController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class EnabledUpdatesController$setExtraParam$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<Unit> $continuation;
    final /* synthetic */ String $key;
    final /* synthetic */ String $value;
    int label;
    final /* synthetic */ EnabledUpdatesController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    EnabledUpdatesController$setExtraParam$2$1(EnabledUpdatesController enabledUpdatesController, String str, String str2, CancellableContinuation<? super Unit> cancellableContinuation, Continuation<? super EnabledUpdatesController$setExtraParam$2$1> continuation) {
        super(2, continuation);
        this.this$0 = enabledUpdatesController;
        this.$key = str;
        this.$value = str2;
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EnabledUpdatesController$setExtraParam$2$1(this.this$0, this.$key, this.$value, this.$continuation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EnabledUpdatesController$setExtraParam$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UnexpectedException unexpectedException;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            ManifestMetadata.INSTANCE.setExtraParam(this.this$0.database, this.this$0.updatesConfiguration, this.$key, this.$value);
            CancellableContinuation<Unit> cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m12684constructorimpl(Unit.INSTANCE));
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            CancellableContinuation<Unit> cancellableContinuation2 = this.$continuation;
            Exception exc = e2;
            if (exc instanceof CodedException) {
                unexpectedException = (CodedException) exc;
            } else if (exc instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) exc;
                unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(exc);
            }
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(unexpectedException)));
        }
        return Unit.INSTANCE;
    }
}
