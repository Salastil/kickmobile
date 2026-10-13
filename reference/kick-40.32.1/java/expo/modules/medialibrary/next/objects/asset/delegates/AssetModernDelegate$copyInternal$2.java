package expo.modules.medialibrary.next.objects.asset.delegates;

import com.facebook.imageutils.JfifUtil;
import expo.modules.medialibrary.next.objects.asset.Asset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AssetModernDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$copyInternal$2", f = "AssetModernDelegate.kt", i = {0, 1, 2, 2, 3, 3, 4, 4, 4, 4, 4}, l = {JfifUtil.MARKER_SOS, 220, 224, 222, 239}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "$this$withContext", "displayName", "$this$withContext", "displayName", "$this$withContext", "displayName", "newAssetUri", "e", "isCollisionError"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0"})
final class AssetModernDelegate$copyInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Asset>, Object> {
    final /* synthetic */ boolean $forceUniqueName;
    final /* synthetic */ String $relativePath;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AssetModernDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetModernDelegate$copyInternal$2(boolean z, AssetModernDelegate assetModernDelegate, String str, Continuation<? super AssetModernDelegate$copyInternal$2> continuation) {
        super(2, continuation);
        this.$forceUniqueName = z;
        this.this$0 = assetModernDelegate;
        this.$relativePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AssetModernDelegate$copyInternal$2 assetModernDelegate$copyInternal$2 = new AssetModernDelegate$copyInternal$2(this.$forceUniqueName, this.this$0, this.$relativePath, continuation);
        assetModernDelegate$copyInternal$2.L$0 = obj;
        return assetModernDelegate$copyInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Asset> continuation) {
        return ((AssetModernDelegate$copyInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00d0  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
    
        if (r13 == r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0087, code lost:
    
        if (r13 == r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0147, code lost:
    
        if (r13 == r1) goto L49;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException, expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException, java.io.FileNotFoundException {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate$copyInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
