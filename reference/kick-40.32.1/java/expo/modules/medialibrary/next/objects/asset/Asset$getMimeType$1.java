package expo.modules.medialibrary.next.objects.asset;

import expo.modules.medialibrary.next.objects.wrappers.MimeType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Asset.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.Asset", f = "Asset.kt", i = {}, l = {54}, m = "getMimeType-dctPOJs", n = {}, s = {})
final class Asset$getMimeType$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Asset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Asset$getMimeType$1(Asset asset, Continuation<? super Asset$getMimeType$1> continuation) {
        super(continuation);
        this.this$0 = asset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM12012getMimeTypedctPOJs = this.this$0.m12012getMimeTypedctPOJs(this);
        return objM12012getMimeTypedctPOJs == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12012getMimeTypedctPOJs : MimeType.m12027boximpl((String) objM12012getMimeTypedctPOJs);
    }
}
