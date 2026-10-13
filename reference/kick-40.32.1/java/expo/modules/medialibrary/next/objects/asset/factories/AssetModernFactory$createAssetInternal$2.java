package expo.modules.medialibrary.next.objects.asset.factories;

import android.net.Uri;
import expo.modules.medialibrary.next.objects.asset.Asset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AssetModernFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.factories.AssetModernFactory$createAssetInternal$2", f = "AssetModernFactory.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {79, 92}, m = "invokeSuspend", n = {"$this$withContext", "mimeType", "displayName", "path", "$this$withContext", "mimeType", "displayName", "path", "pendingUri", "e", "isCollisionError"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
final class AssetModernFactory$createAssetInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Asset>, Object> {
    final /* synthetic */ Uri $filePath;
    final /* synthetic */ boolean $forceUniqueName;
    final /* synthetic */ String $relativePath;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ AssetModernFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetModernFactory$createAssetInternal$2(AssetModernFactory assetModernFactory, Uri uri, boolean z, String str, Continuation<? super AssetModernFactory$createAssetInternal$2> continuation) {
        super(2, continuation);
        this.this$0 = assetModernFactory;
        this.$filePath = uri;
        this.$forceUniqueName = z;
        this.$relativePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AssetModernFactory$createAssetInternal$2 assetModernFactory$createAssetInternal$2 = new AssetModernFactory$createAssetInternal$2(this.this$0, this.$filePath, this.$forceUniqueName, this.$relativePath, continuation);
        assetModernFactory$createAssetInternal$2.L$0 = obj;
        return assetModernFactory$createAssetInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Asset> continuation) {
        return ((AssetModernFactory$createAssetInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0125, code lost:
    
        if (r14 == r1) goto L40;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.io.FileNotFoundException {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.factories.AssetModernFactory$createAssetInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
