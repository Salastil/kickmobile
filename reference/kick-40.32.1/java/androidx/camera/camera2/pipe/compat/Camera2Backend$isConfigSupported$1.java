package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Camera2Backend.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2Backend", f = "Camera2Backend.kt", i = {0, 1, 1, 1}, l = {111, 129}, m = "isConfigSupported-NpXggIU", n = {"graphConfig", "graphConfig", "cameraDeviceSetupCompat", "sessionConfig"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
final class Camera2Backend$isConfigSupported$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Camera2Backend this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Camera2Backend$isConfigSupported$1(Camera2Backend camera2Backend, Continuation<? super Camera2Backend$isConfigSupported$1> continuation) {
        super(continuation);
        this.this$0 = camera2Backend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo227isConfigSupportedNpXggIU(null, this);
    }
}
