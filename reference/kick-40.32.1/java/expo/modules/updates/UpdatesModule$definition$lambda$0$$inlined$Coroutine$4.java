package expo.modules.updates;

import android.os.Bundle;
import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.core.logging.LoggerUtilsKt;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$1"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Coroutine$4", f = "UpdatesModule.kt", i = {0, 0}, l = {RotationOptions.ROTATE_270}, m = "invokeSuspend", n = {"$completion", "$i$a$-Coroutine-UpdatesModule$definition$1$7"}, nl = {271}, s = {"L$0", "I$0"}, v = 2)
public final class UpdatesModule$definition$lambda$0$$inlined$Coroutine$4 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    Object L$0;
    int label;

    public UpdatesModule$definition$lambda$0$$inlined$Coroutine$4(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        return new UpdatesModule$definition$lambda$0$$inlined$Coroutine$4(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws CodedException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IUpdatesController updatesController = UpdatesController.getInstance();
            this.L$0 = SpillingKt.nullOutSpilledVariable(this);
            this.I$0 = 0;
            this.label = 1;
            obj = updatesController.fetchUpdate(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        IUpdatesController.FetchUpdateResult fetchUpdateResult = (IUpdatesController.FetchUpdateResult) obj;
        if (fetchUpdateResult instanceof IUpdatesController.FetchUpdateResult.ErrorResult) {
            IUpdatesController.FetchUpdateResult.ErrorResult errorResult = (IUpdatesController.FetchUpdateResult.ErrorResult) fetchUpdateResult;
            throw new CodedException("ERR_UPDATES_FETCH", "Failed to download new update: " + LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(errorResult.getError()), errorResult.getError());
        }
        if (fetchUpdateResult instanceof IUpdatesController.FetchUpdateResult.Failure) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRollBackToEmbedded", false);
            bundle.putBoolean("isNew", false);
            return bundle;
        }
        if (fetchUpdateResult instanceof IUpdatesController.FetchUpdateResult.RollBackToEmbedded) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("isRollBackToEmbedded", true);
            bundle2.putBoolean("isNew", false);
            return bundle2;
        }
        if (!(fetchUpdateResult instanceof IUpdatesController.FetchUpdateResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("isRollBackToEmbedded", false);
        bundle3.putBoolean("isNew", true);
        bundle3.putString("manifestString", ((IUpdatesController.FetchUpdateResult.Success) fetchUpdateResult).getUpdate().getManifest().toString());
        return bundle3;
    }
}
