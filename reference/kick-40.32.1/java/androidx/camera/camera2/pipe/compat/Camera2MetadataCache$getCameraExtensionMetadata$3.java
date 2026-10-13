package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraExtensionMetadata;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Camera2MetadataCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/camera/camera2/pipe/CameraExtensionMetadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2MetadataCache$getCameraExtensionMetadata$3", f = "Camera2MetadataCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class Camera2MetadataCache$getCameraExtensionMetadata$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CameraExtensionMetadata>, Object> {
    final /* synthetic */ String $cameraId;
    final /* synthetic */ int $extension;
    int label;
    final /* synthetic */ Camera2MetadataCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Camera2MetadataCache$getCameraExtensionMetadata$3(Camera2MetadataCache camera2MetadataCache, String str, int i, Continuation<? super Camera2MetadataCache$getCameraExtensionMetadata$3> continuation) {
        super(2, continuation);
        this.this$0 = camera2MetadataCache;
        this.$cameraId = str;
        this.$extension = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Camera2MetadataCache$getCameraExtensionMetadata$3(this.this$0, this.$cameraId, this.$extension, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CameraExtensionMetadata> continuation) {
        return ((Camera2MetadataCache$getCameraExtensionMetadata$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.this$0.mo845awaitCameraExtensionMetadata0r8Bogc(this.$cameraId, this.$extension);
    }
}
