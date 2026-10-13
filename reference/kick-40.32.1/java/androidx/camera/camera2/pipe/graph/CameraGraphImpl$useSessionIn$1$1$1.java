package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: CameraGraphImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$useSessionIn$1$1$1", f = "CameraGraphImpl.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CameraGraphImpl$useSessionIn$1$1$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function3<CoroutineScope, CameraGraph.Session, Continuation<? super T>, Object> $action;
    final /* synthetic */ CameraGraphSessionImpl $session;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CameraGraphImpl$useSessionIn$1$1$1(Function3<? super CoroutineScope, ? super CameraGraph.Session, ? super Continuation<? super T>, ? extends Object> function3, CameraGraphSessionImpl cameraGraphSessionImpl, Continuation<? super CameraGraphImpl$useSessionIn$1$1$1> continuation) {
        super(2, continuation);
        this.$action = function3;
        this.$session = cameraGraphSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CameraGraphImpl$useSessionIn$1$1$1 cameraGraphImpl$useSessionIn$1$1$1 = new CameraGraphImpl$useSessionIn$1$1$1(this.$action, this.$session, continuation);
        cameraGraphImpl$useSessionIn$1$1$1.L$0 = obj;
        return cameraGraphImpl$useSessionIn$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((CameraGraphImpl$useSessionIn$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Function3<CoroutineScope, CameraGraph.Session, Continuation<? super T>, Object> function3 = this.$action;
        CameraGraphSessionImpl cameraGraphSessionImpl = this.$session;
        this.label = 1;
        Object objInvoke = function3.invoke(coroutineScope, cameraGraphSessionImpl, this);
        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
    }
}
