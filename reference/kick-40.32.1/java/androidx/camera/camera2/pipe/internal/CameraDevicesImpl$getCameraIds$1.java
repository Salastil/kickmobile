package androidx.camera.camera2.pipe.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CameraDevicesImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.internal.CameraDevicesImpl", f = "CameraDevicesImpl.kt", i = {0}, l = {72}, m = "getCameraIds-iAq86To", n = {"cameraBackend"}, s = {"L$0"}, v = 1)
final class CameraDevicesImpl$getCameraIds$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraDevicesImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraDevicesImpl$getCameraIds$1(CameraDevicesImpl cameraDevicesImpl, Continuation<? super CameraDevicesImpl$getCameraIds$1> continuation) {
        super(continuation);
        this.this$0 = cameraDevicesImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo332getCameraIdsiAq86To(null, this);
    }
}
