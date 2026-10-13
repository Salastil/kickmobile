package androidx.camera.camera2.pipe.internal;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: FrameImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.internal.FrameImpl", f = "FrameImpl.kt", i = {}, l = {WebmConstants.MkvEbmlElement.FLAG_INTERLACED}, m = "awaitImage-NYG5g8E", n = {}, s = {}, v = 1)
final class FrameImpl$awaitImage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FrameImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FrameImpl$awaitImage$1(FrameImpl frameImpl, Continuation<? super FrameImpl$awaitImage$1> continuation) {
        super(continuation);
        this.this$0 = frameImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo502awaitImageNYG5g8E(0, this);
    }
}
