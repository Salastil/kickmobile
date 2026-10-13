package expo.modules.medialibrary.next.objects.asset.delegates;

import androidx.media3.muxer.WebmConstants;
import expo.modules.medialibrary.next.objects.wrappers.MimeType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AssetModernDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate", f = "AssetModernDelegate.kt", i = {}, l = {WebmConstants.MkvEbmlElement.BLOCK_DURATION}, m = "getMimeType-dctPOJs", n = {}, s = {})
final class AssetModernDelegate$getMimeType$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AssetModernDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetModernDelegate$getMimeType$1(AssetModernDelegate assetModernDelegate, Continuation<? super AssetModernDelegate$getMimeType$1> continuation) {
        super(continuation);
        this.this$0 = assetModernDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo12015getMimeTypedctPOJs = this.this$0.mo12015getMimeTypedctPOJs(this);
        return objMo12015getMimeTypedctPOJs == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo12015getMimeTypedctPOJs : MimeType.m12027boximpl((String) objMo12015getMimeTypedctPOJs);
    }
}
