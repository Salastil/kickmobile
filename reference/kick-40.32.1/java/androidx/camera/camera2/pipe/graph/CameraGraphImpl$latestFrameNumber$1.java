package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.FrameNumber;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: CameraGraphImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/camera/camera2/pipe/FrameNumber;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$latestFrameNumber$1", f = "CameraGraphImpl.kt", i = {}, l = {WebmConstants.MkvEbmlElement.FLAG_DEFAULT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CameraGraphImpl$latestFrameNumber$1 extends SuspendLambda implements Function2<ProducerScope<? super FrameNumber>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CameraGraphImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraGraphImpl$latestFrameNumber$1(CameraGraphImpl cameraGraphImpl, Continuation<? super CameraGraphImpl$latestFrameNumber$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraGraphImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CameraGraphImpl$latestFrameNumber$1 cameraGraphImpl$latestFrameNumber$1 = new CameraGraphImpl$latestFrameNumber$1(this.this$0, continuation);
        cameraGraphImpl$latestFrameNumber$1.L$0 = obj;
        return cameraGraphImpl$latestFrameNumber$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super FrameNumber> producerScope, Continuation<? super Unit> continuation) {
        return ((CameraGraphImpl$latestFrameNumber$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final LatestFrameNumberListener latestFrameNumberListener = new LatestFrameNumberListener(new Function1() { // from class: androidx.camera.camera2.pipe.graph.CameraGraphImpl$latestFrameNumber$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return CameraGraphImpl$latestFrameNumber$1.invokeSuspend$lambda$0(producerScope, (FrameNumber) obj2);
                }
            });
            this.this$0.getListeners().add(latestFrameNumberListener);
            final CameraGraphImpl cameraGraphImpl = this.this$0;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: androidx.camera.camera2.pipe.graph.CameraGraphImpl$latestFrameNumber$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CameraGraphImpl$latestFrameNumber$1.invokeSuspend$lambda$1(cameraGraphImpl, latestFrameNumberListener);
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

    static final Unit invokeSuspend$lambda$0(ProducerScope producerScope, FrameNumber frameNumber) {
        producerScope.mo12563trySendJP2dKIU(frameNumber);
        return Unit.INSTANCE;
    }

    static final Unit invokeSuspend$lambda$1(CameraGraphImpl cameraGraphImpl, LatestFrameNumberListener latestFrameNumberListener) {
        cameraGraphImpl.getListeners().remove(latestFrameNumberListener);
        return Unit.INSTANCE;
    }
}
