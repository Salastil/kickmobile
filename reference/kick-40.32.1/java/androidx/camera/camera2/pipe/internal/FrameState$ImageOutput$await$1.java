package androidx.camera.camera2.pipe.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: FrameState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.internal.FrameState$ImageOutput", f = "FrameState.kt", i = {}, l = {275}, m = "await", n = {}, s = {}, v = 1)
final class FrameState$ImageOutput$await$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FrameState.ImageOutput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FrameState$ImageOutput$await$1(FrameState.ImageOutput imageOutput, Continuation<? super FrameState$ImageOutput$await$1> continuation) {
        super(continuation);
        this.this$0 = imageOutput;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.await(this);
    }
}
