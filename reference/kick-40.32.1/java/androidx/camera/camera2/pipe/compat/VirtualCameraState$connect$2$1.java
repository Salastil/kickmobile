package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: VirtualCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.compat.VirtualCameraState$connect$2$1", f = "VirtualCamera.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class VirtualCameraState$connect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<CameraState> $state;
    int label;
    final /* synthetic */ VirtualCameraState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    VirtualCameraState$connect$2$1(Flow<? extends CameraState> flow, VirtualCameraState virtualCameraState, Continuation<? super VirtualCameraState$connect$2$1> continuation) {
        super(2, continuation);
        this.$state = flow;
        this.this$0 = virtualCameraState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VirtualCameraState$connect$2$1(this.$state, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VirtualCameraState$connect$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<CameraState> flow = this.$state;
            final VirtualCameraState virtualCameraState = this.this$0;
            this.label = 1;
            if (flow.collect(new FlowCollector() { // from class: androidx.camera.camera2.pipe.compat.VirtualCameraState$connect$2$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((CameraState) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(CameraState cameraState, Continuation<? super Unit> continuation) {
                    Object obj2 = virtualCameraState.lock;
                    VirtualCameraState virtualCameraState2 = virtualCameraState;
                    synchronized (obj2) {
                        if (!(cameraState instanceof CameraStateOpen)) {
                            virtualCameraState2.emitState(cameraState);
                        } else {
                            CameraDeviceWrapper cameraDevice = ((CameraStateOpen) cameraState).getCameraDevice();
                            Intrinsics.checkNotNull(cameraDevice, "null cannot be cast to non-null type androidx.camera.camera2.pipe.compat.AndroidCameraDevice");
                            VirtualAndroidCameraDevice virtualAndroidCameraDevice = new VirtualAndroidCameraDevice((AndroidCameraDevice) cameraDevice);
                            virtualCameraState2.currentVirtualAndroidCamera = virtualAndroidCameraDevice;
                            virtualCameraState2.emitState(new CameraStateOpen(virtualAndroidCameraDevice));
                        }
                        Unit unit = Unit.INSTANCE;
                    }
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
