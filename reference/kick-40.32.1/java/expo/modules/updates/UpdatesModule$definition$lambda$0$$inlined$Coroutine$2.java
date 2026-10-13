package expo.modules.updates;

import expo.modules.updates.reloadscreen.ReloadScreenManager;
import expo.modules.updates.reloadscreen.ReloadScreenOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$3"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Coroutine$2", f = "UpdatesModule.kt", i = {0, 0, 0, 0, 0}, l = {272}, m = "invokeSuspend", n = {"<destruct>", "p0", "$completion", "options", "$i$a$-Coroutine-UpdatesModule$definition$1$5"}, nl = {273}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
public final class UpdatesModule$definition$lambda$0$$inlined$Coroutine$2 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public UpdatesModule$definition$lambda$0$$inlined$Coroutine$2(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        UpdatesModule$definition$lambda$0$$inlined$Coroutine$2 updatesModule$definition$lambda$0$$inlined$Coroutine$2 = new UpdatesModule$definition$lambda$0$$inlined$Coroutine$2(continuation);
        updatesModule$definition$lambda$0$$inlined$Coroutine$2.L$0 = objArr;
        return updatesModule$definition$lambda$0$$inlined$Coroutine$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = objArr[0];
            UpdatesModule$definition$lambda$0$$inlined$Coroutine$2 updatesModule$definition$lambda$0$$inlined$Coroutine$2 = this;
            ReloadScreenOptions reloadScreenOptions = (ReloadScreenOptions) obj2;
            ReloadScreenManager reloadScreenManager = UpdatesController.getInstance().getReloadScreenManager();
            if (reloadScreenManager != null) {
                reloadScreenManager.setConfiguration(reloadScreenOptions);
            }
            IUpdatesController updatesController = UpdatesController.getInstance();
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(updatesModule$definition$lambda$0$$inlined$Coroutine$2);
            this.L$3 = SpillingKt.nullOutSpilledVariable(reloadScreenOptions);
            this.I$0 = 0;
            this.label = 1;
            if (updatesController.relaunchReactApplicationForModule(this) == coroutine_suspended) {
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
