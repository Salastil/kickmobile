package androidx.camera.camera2.pipe.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: FrameImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.internal.FrameImpl", f = "FrameImpl.kt", i = {0}, l = {190}, m = "awaitImages-NYG5g8E", n = {"destination$iv$iv"}, s = {"L$0"}, v = 1)
final class FrameImpl$awaitImages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FrameImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FrameImpl$awaitImages$1(FrameImpl frameImpl, Continuation<? super FrameImpl$awaitImages$1> continuation) {
        super(continuation);
        this.this$0 = frameImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo503awaitImagesNYG5g8E(0, this);
    }
}
