package expo.modules.medialibrary.next.objects.asset;

import android.graphics.BitmapFactory;
import expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreImage;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AssetDimensionsResolver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "", "<init>", "()V", "resolveDimensions", "Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem;", "mediaStoreItem", "(Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveImageDimensions", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImage;", "image", "(Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetDimensionsResolver {

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver$resolveDimensions$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssetDimensionsResolver.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver", f = "AssetDimensionsResolver.kt", i = {0}, l = {13}, m = "resolveDimensions", n = {"mediaStoreItem"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetDimensionsResolver.this.resolveDimensions(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object resolveDimensions(AssetMediaStoreItem assetMediaStoreItem, Continuation<? super AssetMediaStoreItem> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objResolveImageDimensions = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolveImageDimensions);
            if (assetMediaStoreItem instanceof AssetMediaStoreItem.Image) {
                MediaStoreImage asset = ((AssetMediaStoreItem.Image) assetMediaStoreItem).getAsset();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(assetMediaStoreItem);
                anonymousClass1.label = 1;
                objResolveImageDimensions = resolveImageDimensions(asset, anonymousClass1);
                if (objResolveImageDimensions == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if ((assetMediaStoreItem instanceof AssetMediaStoreItem.Video) || (assetMediaStoreItem instanceof AssetMediaStoreItem.Audio)) {
                    return assetMediaStoreItem;
                }
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objResolveImageDimensions);
        }
        return new AssetMediaStoreItem.Image((MediaStoreImage) objResolveImageDimensions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object resolveImageDimensions(MediaStoreImage mediaStoreImage, Continuation<? super MediaStoreImage> continuation) {
        String data;
        Integer width = mediaStoreImage.getWidth();
        Integer num = (width == null || width.intValue() <= 0) ? null : width;
        Integer height = mediaStoreImage.getHeight();
        Integer num2 = (height == null || height.intValue() <= 0) ? null : height;
        return ((num == null || num2 == null) && (data = mediaStoreImage.getData()) != null) ? BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(data, mediaStoreImage, num, num2, null), continuation) : mediaStoreImage;
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver$resolveImageDimensions$2, reason: invalid class name */
    /* JADX INFO: compiled from: AssetDimensionsResolver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver$resolveImageDimensions$2", f = "AssetDimensionsResolver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MediaStoreImage>, Object> {
        final /* synthetic */ Integer $height;
        final /* synthetic */ MediaStoreImage $image;
        final /* synthetic */ String $path;
        final /* synthetic */ Integer $width;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, MediaStoreImage mediaStoreImage, Integer num, Integer num2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$path = str;
            this.$image = mediaStoreImage;
            this.$width = num;
            this.$height = num2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$path, this.$image, this.$width, this.$height, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MediaStoreImage> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.$path, options);
            MediaStoreImage mediaStoreImage = this.$image;
            Integer num = this.$width;
            Integer numBoxInt = Boxing.boxInt(num != null ? num.intValue() : options.outWidth);
            Integer num2 = this.$height;
            return MediaStoreImage.copy$default(mediaStoreImage, 0L, null, null, null, numBoxInt, Boxing.boxInt(num2 != null ? num2.intValue() : options.outHeight), null, null, null, 463, null);
        }
    }
}
