package expo.modules.filesystem.fsops;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Utilities.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.filesystem.fsops.UtilitiesKt$copyDirectoryParallel$3", f = "Utilities.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {WebmConstants.MkvEbmlElement.BLOCK_DURATION, WebmConstants.MkvEbmlElement.CHANNELS}, m = "invokeSuspend$walk", n = {"semaphore", "$this$coroutineScope", "$copyFile", "src", "dst", "$this$forEach$iv", "element$iv", "child", "childDest", "childName", "$i$f$forEach", "$i$a$-forEach-UtilitiesKt$copyDirectoryParallel$3$walk$2", "semaphore", "$this$coroutineScope", "$copyFile", "src", "dst", "$this$forEach$iv", "element$iv", "child", "childName", "$i$f$forEach", "$i$a$-forEach-UtilitiesKt$copyDirectoryParallel$3$walk$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "I$0", "I$1"})
final class UtilitiesKt$copyDirectoryParallel$3$walk$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;

    UtilitiesKt$copyDirectoryParallel$3$walk$1(Continuation<? super UtilitiesKt$copyDirectoryParallel$3$walk$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UtilitiesKt.AnonymousClass3.invokeSuspend$walk(null, null, null, null, null, this);
    }
}
