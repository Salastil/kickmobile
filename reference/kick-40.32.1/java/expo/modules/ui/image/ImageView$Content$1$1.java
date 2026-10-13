package expo.modules.ui.image;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.MutableState;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.ui.graphics.ImageLoader;
import expo.modules.ui.graphics.ImageSource;
import expo.modules.ui.graphics.ImageSourceKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ImageView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.image.ImageView$Content$1$1", f = "ImageView.kt", i = {0}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", n = {"resolvedUri"}, s = {"L$0"})
final class ImageView$Content$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<ImageLoader.ImageResult> $loadedImage$delegate;
    final /* synthetic */ ImageSource $source;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ImageView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageView$Content$1$1(ImageSource imageSource, ImageView imageView, MutableState<ImageLoader.ImageResult> mutableState, Continuation<? super ImageView$Content$1$1> continuation) {
        super(2, continuation);
        this.$source = imageSource;
        this.this$0 = imageView;
        this.$loadedImage$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageView$Content$1$1(this.$source, this.this$0, this.$loadedImage$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ImageView$Content$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String strResolveUri;
        MutableState<ImageLoader.ImageResult> mutableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageSource imageSource = this.$source;
            if (imageSource != null) {
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                strResolveUri = ImageSourceKt.resolveUri(imageSource, context);
            } else {
                strResolveUri = null;
            }
            MutableState<ImageLoader.ImageResult> mutableState2 = this.$loadedImage$delegate;
            if (strResolveUri != null) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(strResolveUri);
                this.L$1 = mutableState2;
                this.label = 1;
                obj = this.this$0.getImageLoader().loadFromUri(strResolveUri, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState = mutableState2;
            } else {
                mutableState2.setValue(new ImageLoader.ImageResult(null, null, "Unable to resolve image source", 3, null));
                this.this$0.getOnError().invoke(new ImageErrorEvent("Unable to resolve image source"));
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState = (MutableState) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        ImageView imageView = this.this$0;
        ImageLoader.ImageResult imageResult = (ImageLoader.ImageResult) obj;
        if (imageResult.isSuccess()) {
            imageView.getOnLoad().invoke(Unit.INSTANCE);
        } else {
            ViewEventCallback onError = imageView.getOnError();
            String error = imageResult.getError();
            if (error == null) {
                error = "Failed to load image";
            }
            onError.invoke(new ImageErrorEvent(error));
        }
        mutableState.setValue(imageResult);
        return Unit.INSTANCE;
    }
}
