package expo.modules.ui;

import expo.modules.kotlin.jni.worklets.Worklet;
import expo.modules.ui.state.WorkletCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ExpoUIModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.ExpoUIModule$definition$1$3$2$1", f = "ExpoUIModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ExpoUIModule$definition$1$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WorkletCallback $callback;
    final /* synthetic */ Worklet $worklet;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpoUIModule$definition$1$3$2$1(WorkletCallback workletCallback, Worklet worklet, Continuation<? super ExpoUIModule$definition$1$3$2$1> continuation) {
        super(2, continuation);
        this.$callback = workletCallback;
        this.$worklet = worklet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpoUIModule$definition$1$3$2$1(this.$callback, this.$worklet, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExpoUIModule$definition$1$3$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$callback.setWorklet(this.$worklet);
        return Unit.INSTANCE;
    }
}
