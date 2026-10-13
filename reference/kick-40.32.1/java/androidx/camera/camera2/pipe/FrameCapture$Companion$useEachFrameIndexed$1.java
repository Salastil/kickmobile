package androidx.camera.camera2.pipe;

import androidx.media3.muxer.WebmConstants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Frame.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
@DebugMetadata(c = "androidx.camera.camera2.pipe.FrameCapture$Companion", f = "Frame.kt", i = {0, 0, 0, 0, 0}, l = {401}, m = "useEachFrameIndexed", n = {"action", "closeables$iv$iv", "i$iv$iv", "capture", "idx"}, s = {"L$0", "L$1", "L$2", "L$4", "I$0"}, v = 1)
final class FrameCapture$Companion$useEachFrameIndexed$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FrameCapture.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FrameCapture$Companion$useEachFrameIndexed$1(FrameCapture.Companion companion, Continuation<? super FrameCapture$Companion$useEachFrameIndexed$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.useEachFrameIndexed(null, null, this);
    }
}
