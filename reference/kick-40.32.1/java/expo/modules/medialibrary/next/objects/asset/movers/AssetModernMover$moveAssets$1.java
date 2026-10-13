package expo.modules.medialibrary.next.objects.asset.movers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AssetModernMover.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.movers.AssetModernMover", f = "AssetModernMover.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {14, 15}, m = "moveAssets-qTZuolk", n = {"assets", "relativePath", "assets", "relativePath", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-AssetModernMover$moveAssets$3"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"})
final class AssetModernMover$moveAssets$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AssetModernMover this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetModernMover$moveAssets$1(AssetModernMover assetModernMover, Continuation<? super AssetModernMover$moveAssets$1> continuation) {
        super(continuation);
        this.this$0 = assetModernMover;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo12024moveAssetsqTZuolk(null, null, this);
    }
}
