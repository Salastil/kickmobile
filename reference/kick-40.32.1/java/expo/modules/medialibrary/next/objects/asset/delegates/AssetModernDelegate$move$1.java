package expo.modules.medialibrary.next.objects.asset.delegates;

import com.google.mlkit.common.MlKitException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AssetModernDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {0, 1, 1}, l = {199, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR}, m = "move-dXLngQ8", n = {"relativePath", "relativePath", "e"}, s = {"L$0", "L$0", "L$1"})
final class AssetModernDelegate$move$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AssetModernDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetModernDelegate$move$1(AssetModernDelegate assetModernDelegate, Continuation<? super AssetModernDelegate$move$1> continuation) {
        super(continuation);
        this.this$0 = assetModernDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo12016movedXLngQ8(null, this);
    }
}
