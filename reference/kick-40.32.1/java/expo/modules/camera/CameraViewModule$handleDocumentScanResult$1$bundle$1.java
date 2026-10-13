package expo.modules.camera;

import android.content.Context;
import android.os.Bundle;
import expo.modules.camera.documentscanner.DocumentScannerActivityResult;
import expo.modules.camera.documentscanner.DocumentScannerResultParser;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CameraViewModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.camera.CameraViewModule$handleDocumentScanResult$1$bundle$1", f = "CameraViewModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CameraViewModule$handleDocumentScanResult$1$bundle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
    final /* synthetic */ DocumentScannerActivityResult $activityResult;
    final /* synthetic */ Context $reactContext;
    int label;
    final /* synthetic */ CameraViewModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraViewModule$handleDocumentScanResult$1$bundle$1(Context context, DocumentScannerActivityResult documentScannerActivityResult, CameraViewModule cameraViewModule, Continuation<? super CameraViewModule$handleDocumentScanResult$1$bundle$1> continuation) {
        super(2, continuation);
        this.$reactContext = context;
        this.$activityResult = documentScannerActivityResult;
        this.this$0 = cameraViewModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModule$handleDocumentScanResult$1$bundle$1(this.$reactContext, this.$activityResult, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bundle> continuation) {
        return ((CameraViewModule$handleDocumentScanResult$1$bundle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return DocumentScannerResultParser.INSTANCE.parse(this.$reactContext, this.$activityResult.getResult(), this.this$0.getCacheDirectory());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
