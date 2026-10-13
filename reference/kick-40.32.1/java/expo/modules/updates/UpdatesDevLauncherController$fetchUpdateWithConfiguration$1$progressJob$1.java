package expo.modules.updates;

import com.google.mlkit.common.MlKitException;
import expo.modules.updates.loader.Loader;
import expo.modules.updates.loader.RemoteLoader;
import expo.modules.updatesinterface.UpdatesDevLauncherInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: UpdatesDevLauncherController.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.UpdatesDevLauncherController$fetchUpdateWithConfiguration$1$progressJob$1", f = "UpdatesDevLauncherController.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, nl = {MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR}, s = {}, v = 2)
final class UpdatesDevLauncherController$fetchUpdateWithConfiguration$1$progressJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UpdatesDevLauncherInterface.UpdateCallback $callback;
    final /* synthetic */ RemoteLoader $loader;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdatesDevLauncherController$fetchUpdateWithConfiguration$1$progressJob$1(RemoteLoader remoteLoader, UpdatesDevLauncherInterface.UpdateCallback updateCallback, Continuation<? super UpdatesDevLauncherController$fetchUpdateWithConfiguration$1$progressJob$1> continuation) {
        super(2, continuation);
        this.$loader = remoteLoader;
        this.$callback = updateCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdatesDevLauncherController$fetchUpdateWithConfiguration$1$progressJob$1(this.$loader, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdatesDevLauncherController$fetchUpdateWithConfiguration$1$progressJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Loader.AssetLoadProgress> progressFlow = this.$loader.getProgressFlow();
            final UpdatesDevLauncherInterface.UpdateCallback updateCallback = this.$callback;
            this.label = 1;
            if (progressFlow.collect(new FlowCollector() { // from class: expo.modules.updates.UpdatesDevLauncherController$fetchUpdateWithConfiguration$1$progressJob$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Loader.AssetLoadProgress) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Loader.AssetLoadProgress assetLoadProgress, Continuation<? super Unit> continuation) {
                    updateCallback.onProgress(assetLoadProgress.getSuccessfulAssetCount(), assetLoadProgress.getFailedAssetCount(), assetLoadProgress.getTotalAssetCount());
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
