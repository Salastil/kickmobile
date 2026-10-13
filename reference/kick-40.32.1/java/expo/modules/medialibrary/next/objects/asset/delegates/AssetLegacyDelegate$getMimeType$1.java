package expo.modules.medialibrary.next.objects.asset.delegates;

import expo.modules.medialibrary.next.objects.wrappers.MimeType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AssetLegacyDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate", f = "AssetLegacyDelegate.kt", i = {}, l = {144}, m = "getMimeType-dctPOJs", n = {}, s = {})
final class AssetLegacyDelegate$getMimeType$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AssetLegacyDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetLegacyDelegate$getMimeType$1(AssetLegacyDelegate assetLegacyDelegate, Continuation<? super AssetLegacyDelegate$getMimeType$1> continuation) {
        super(continuation);
        this.this$0 = assetLegacyDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo12015getMimeTypedctPOJs = this.this$0.mo12015getMimeTypedctPOJs(this);
        return objMo12015getMimeTypedctPOJs == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo12015getMimeTypedctPOJs : MimeType.m12027boximpl((String) objMo12015getMimeTypedctPOJs);
    }
}
