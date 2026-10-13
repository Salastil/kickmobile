package expo.modules.updates.procedures;

import expo.modules.updates.db.entity.UpdateEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StartupProcedure.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.procedures.StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1", f = "StartupProcedure.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StartupProcedure this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1(StartupProcedure startupProcedure, Continuation<? super StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = startupProcedure;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        UpdateEntity launchedUpdate = this.this$0.getLaunchedUpdate();
        if (launchedUpdate == null) {
            return Unit.INSTANCE;
        }
        this.this$0.database.updateDao().incrementFailedLaunchCount(launchedUpdate);
        return Unit.INSTANCE;
    }
}
