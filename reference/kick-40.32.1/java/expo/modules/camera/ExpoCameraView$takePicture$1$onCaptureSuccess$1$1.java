package expo.modules.camera;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import expo.modules.camera.records.CameraType;
import expo.modules.camera.tasks.PictureSavedDelegate;
import expo.modules.camera.tasks.ResolveTakenPicture;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.runtime.Runtime;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ExpoCameraView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.camera.ExpoCameraView$takePicture$1$onCaptureSuccess$1$1", f = "ExpoCameraView.kt", i = {0}, l = {TypedValues.Attributes.TYPE_EASING}, m = "invokeSuspend", n = {"shouldMirror"}, s = {"I$0"})
final class ExpoCameraView$takePicture$1$onCaptureSuccess$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ File $it;
    final /* synthetic */ PictureOptions $options;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ Runtime $runtime;
    int I$0;
    int label;
    final /* synthetic */ ExpoCameraView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpoCameraView$takePicture$1$onCaptureSuccess$1$1(ExpoCameraView expoCameraView, byte[] bArr, Promise promise, PictureOptions pictureOptions, Runtime runtime, File file, Continuation<? super ExpoCameraView$takePicture$1$onCaptureSuccess$1$1> continuation) {
        super(2, continuation);
        this.this$0 = expoCameraView;
        this.$data = bArr;
        this.$promise = promise;
        this.$options = pictureOptions;
        this.$runtime = runtime;
        this.$it = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpoCameraView$takePicture$1$onCaptureSuccess$1$1(this.this$0, this.$data, this.$promise, this.$options, this.$runtime, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExpoCameraView$takePicture$1$onCaptureSuccess$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v2 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ?? r7 = (this.this$0.getMirror() && this.this$0.getLensFacing() == CameraType.FRONT) ? 1 : 0;
            byte[] bArr = this.$data;
            Promise promise = this.$promise;
            final PictureOptions pictureOptions = this.$options;
            Runtime runtime = this.$runtime;
            File file = this.$it;
            final ExpoCameraView expoCameraView = this.this$0;
            this.I$0 = r7;
            this.label = 1;
            if (new ResolveTakenPicture(bArr, promise, pictureOptions, r7, runtime, file, new PictureSavedDelegate() { // from class: expo.modules.camera.ExpoCameraView$takePicture$1$onCaptureSuccess$1$1$$ExternalSyntheticLambda0
                @Override // expo.modules.camera.tasks.PictureSavedDelegate
                public final void onPictureSaved(Bundle bundle) {
                    ExpoCameraView$takePicture$1$onCaptureSuccess$1$1.invokeSuspend$lambda$0(pictureOptions, expoCameraView, bundle);
                }
            }).resolve(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    static final void invokeSuspend$lambda$0(PictureOptions pictureOptions, ExpoCameraView expoCameraView, Bundle bundle) {
        if (pictureOptions.getPictureRef()) {
            return;
        }
        expoCameraView.onPictureSaved(bundle);
    }
}
