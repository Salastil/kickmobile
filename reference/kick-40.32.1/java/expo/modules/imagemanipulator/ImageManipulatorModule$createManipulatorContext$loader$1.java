package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.media3.muxer.WebmConstants;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.services.Service;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: ImageManipulatorModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagemanipulator.ImageManipulatorModule$createManipulatorContext$loader$1", f = "ImageManipulatorModule.kt", i = {0, 0, 0, 0}, l = {WebmConstants.MkvEbmlElement.FLAG_INTERLACED}, m = "invokeSuspend", n = {"imageLoader", ViewProps.MAX_WIDTH, ViewProps.MAX_HEIGHT, "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "L$1", "L$2", "I$0"})
final class ImageManipulatorModule$createManipulatorContext$loader$1 extends SuspendLambda implements Function1<Continuation<? super Bitmap>, Object> {
    final /* synthetic */ ImageLoadOptions $options;
    final /* synthetic */ Uri $url;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ImageManipulatorModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageManipulatorModule$createManipulatorContext$loader$1(ImageManipulatorModule imageManipulatorModule, ImageLoadOptions imageLoadOptions, Uri uri, Continuation<? super ImageManipulatorModule$createManipulatorContext$loader$1> continuation) {
        super(1, continuation);
        this.this$0 = imageManipulatorModule;
        this.$options = imageLoadOptions;
        this.$url = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ImageManipulatorModule$createManipulatorContext$loader$1(this.this$0, this.$options, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Bitmap> continuation) {
        return ((ImageManipulatorModule$createManipulatorContext$loader$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws ImageLoaderNotFoundException {
        Integer maxWidth;
        Integer num;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Service service = this.this$0.getAppContext().getServices().getRegistry().get(ImageLoaderInterface.class);
            if (!(service instanceof ImageLoaderInterface)) {
                service = null;
            }
            ImageLoaderInterface imageLoaderInterface = (ImageLoaderInterface) service;
            if (imageLoaderInterface == null) {
                throw new ImageLoaderNotFoundException();
            }
            ImageLoadOptions imageLoadOptions = this.$options;
            maxWidth = imageLoadOptions != null ? imageLoadOptions.getMaxWidth() : null;
            ImageLoadOptions imageLoadOptions2 = this.$options;
            Integer maxHeight = imageLoadOptions2 != null ? imageLoadOptions2.getMaxHeight() : null;
            final Uri uri = this.$url;
            this.L$0 = imageLoaderInterface;
            this.L$1 = maxWidth;
            this.L$2 = maxHeight;
            this.L$3 = uri;
            this.I$0 = 0;
            this.label = 1;
            ImageManipulatorModule$createManipulatorContext$loader$1 imageManipulatorModule$createManipulatorContext$loader$1 = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(imageManipulatorModule$createManipulatorContext$loader$1), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ImageLoaderInterface.ResultListener resultListener = new ImageLoaderInterface.ResultListener() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$createManipulatorContext$loader$1$bitmap$1$resultListener$1
                @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                public void onSuccess(Bitmap bitmap) {
                    Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                    CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m12684constructorimpl(bitmap));
                }

                @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                public void onFailure(Throwable cause) {
                    UnexpectedException unexpectedException;
                    CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl2;
                    String string = uri.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    if (cause == null) {
                        unexpectedException = new UnexpectedException("Unknown error");
                    } else if (cause instanceof CodedException) {
                        unexpectedException = (CodedException) cause;
                    } else if (cause instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) cause;
                        unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(cause);
                    }
                    ImageLoadingFailedException imageLoadingFailedException = new ImageLoadingFailedException(string, unexpectedException);
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(imageLoadingFailedException)));
                }
            };
            if (maxWidth != null || maxHeight != null) {
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                imageLoaderInterface.loadImageForManipulationFromURL(string, maxWidth, maxHeight, resultListener);
            } else {
                String string2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                imageLoaderInterface.loadImageForManipulationFromURL(string2, resultListener);
            }
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(imageManipulatorModule$createManipulatorContext$loader$1);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            num = maxHeight;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            num = (Integer) this.L$2;
            maxWidth = (Integer) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        return ImageDownsamplingKt.downscaleIfExceedsBounds((Bitmap) obj, maxWidth, num);
    }
}
