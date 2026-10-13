package expo.modules.medialibrary.next.objects.asset.delegates;

import com.google.mlkit.common.MlKitException;
import expo.modules.medialibrary.next.objects.asset.Asset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AssetLegacyDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$copy$2", f = "AssetLegacyDelegate.kt", i = {1, 1}, l = {202, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR}, m = "invokeSuspend", n = {"path", "newFile"}, s = {"L$0", "L$1"})
final class AssetLegacyDelegate$copy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Asset>, Object> {
    final /* synthetic */ String $relativePath;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AssetLegacyDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetLegacyDelegate$copy$2(AssetLegacyDelegate assetLegacyDelegate, String str, Continuation<? super AssetLegacyDelegate$copy$2> continuation) {
        super(2, continuation);
        this.this$0 = assetLegacyDelegate;
        this.$relativePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssetLegacyDelegate$copy$2(this.this$0, this.$relativePath, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Asset> continuation) {
        return ((AssetLegacyDelegate$copy$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0082, code lost:
    
        if (r8 == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException, java.io.IOException, expo.modules.medialibrary.next.exceptions.AssetCouldNotBeCreated, expo.modules.kotlin.exception.Exceptions.ReactContextLost {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L27
            if (r1 == r2) goto L23
            if (r1 != r3) goto L1b
            java.lang.Object r0 = r7.L$1
            java.io.File r0 = (java.io.File) r0
            java.lang.Object r0 = r7.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L85
        L1b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L42
        L27:
            kotlin.ResultKt.throwOnFailure(r8)
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate r8 = r7.this$0
            android.content.ContentResolver r8 = expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.access$getContentResolver(r8)
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate r1 = r7.this$0
            android.net.Uri r1 = r1.getContentUri()
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.label = r2
            java.lang.Object r8 = expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt.queryAssetData(r8, r1, r5)
            if (r8 != r0) goto L42
            goto L84
        L42:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto La2
            java.io.File r1 = new java.io.File
            r1.<init>(r8)
            java.io.File r2 = new java.io.File
            java.lang.String r5 = r7.$relativePath
            java.lang.String r5 = expo.modules.medialibrary.next.objects.wrappers.RelativePath.m12047toFilePathimpl(r5)
            r2.<init>(r5)
            java.io.File r1 = expo.modules.medialibrary.next.extensions.FileExtensionsKt.safeCopy(r1, r2)
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate r2 = r7.this$0
            java.lang.ref.WeakReference r2 = expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate.access$getContextRef$p(r2)
            android.content.Context r2 = expo.modules.medialibrary.next.extensions.WeakReferenceExtensionsKt.getOrThrow(r2)
            java.lang.String r5 = r1.getPath()
            java.lang.String r6 = "getPath(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r7.L$1 = r8
            r7.label = r3
            java.lang.Object r8 = expo.modules.medialibrary.next.extensions.ContextExtensionsKt.scanFile(r2, r5, r4, r6)
            if (r8 != r0) goto L85
        L84:
            return r0
        L85:
            kotlin.Pair r8 = (kotlin.Pair) r8
            java.lang.Object r8 = r8.component2()
            android.net.Uri r8 = (android.net.Uri) r8
            if (r8 == 0) goto L9a
            expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate r7 = r7.this$0
            expo.modules.medialibrary.next.objects.asset.factories.AssetFactory r7 = r7.getAssetFactory()
            expo.modules.medialibrary.next.objects.asset.Asset r7 = r7.create(r8)
            return r7
        L9a:
            expo.modules.medialibrary.next.exceptions.AssetCouldNotBeCreated r7 = new expo.modules.medialibrary.next.exceptions.AssetCouldNotBeCreated
            java.lang.String r8 = "Could not create a new asset while copying the old one"
            r7.<init>(r8, r4, r3, r4)
            throw r7
        La2:
            expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException r7 = new expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException
            java.lang.String r8 = "Asset path"
            r7.<init>(r8, r4, r3, r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.delegates.AssetLegacyDelegate$copy$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
