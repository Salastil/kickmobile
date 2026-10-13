package expo.modules.camera;

import android.content.IntentSender;
import expo.modules.camera.documentscanner.DocumentScannerActivityResult;
import expo.modules.camera.documentscanner.DocumentScannerContract;
import expo.modules.camera.documentscanner.DocumentScannerContractInput;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.activityresult.AppContextActivityResultFallbackCallback;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraViewModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.camera.CameraViewModule$definition$1$11", f = "CameraViewModule.kt", i = {0}, l = {224}, m = "invokeSuspend", n = {"$this$RegisterActivityContracts"}, s = {"L$0"})
final class CameraViewModule$definition$1$11 extends SuspendLambda implements Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CameraViewModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraViewModule$definition$1$11(CameraViewModule cameraViewModule, Continuation<? super CameraViewModule$definition$1$11> continuation) {
        super(2, continuation);
        this.this$0 = cameraViewModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CameraViewModule$definition$1$11 cameraViewModule$definition$1$11 = new CameraViewModule$definition$1$11(this.this$0, continuation);
        cameraViewModule$definition$1$11.L$0 = obj;
        return cameraViewModule$definition$1$11;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AppContextActivityResultCaller appContextActivityResultCaller, Continuation<? super Unit> continuation) {
        return ((CameraViewModule$definition$1$11) create(appContextActivityResultCaller, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CameraViewModule cameraViewModule;
        AppContextActivityResultCaller appContextActivityResultCaller = (AppContextActivityResultCaller) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CameraViewModule cameraViewModule2 = this.this$0;
            final CameraViewModule cameraViewModule3 = this.this$0;
            DocumentScannerContract documentScannerContract = new DocumentScannerContract(new Function0<IntentSender>() { // from class: expo.modules.camera.CameraViewModule$definition$1$11.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final IntentSender invoke() {
                    return cameraViewModule3.pendingDocumentScanIntentSender;
                }
            });
            final CameraViewModule cameraViewModule4 = this.this$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(appContextActivityResultCaller);
            this.L$1 = cameraViewModule2;
            this.label = 1;
            Object objRegisterForActivityResult = appContextActivityResultCaller.registerForActivityResult(documentScannerContract, new AppContextActivityResultFallbackCallback() { // from class: expo.modules.camera.CameraViewModule$definition$1$11.2
                @Override // expo.modules.kotlin.activityresult.AppContextActivityResultFallbackCallback
                public final void onActivityResult(DocumentScannerContractInput documentScannerContractInput, DocumentScannerActivityResult documentScannerActivityResult) {
                    Intrinsics.checkNotNullParameter(documentScannerContractInput, "<unused var>");
                    Intrinsics.checkNotNullParameter(documentScannerActivityResult, "<unused var>");
                    cameraViewModule4.pendingDocumentScanIntentSender = null;
                    Promise promise = cameraViewModule4.documentScanPromise;
                    if (promise != null) {
                        promise.reject(new CameraExceptions.DocumentScanningFailedException("the document scan was interrupted because the screen was recreated"));
                    }
                    cameraViewModule4.documentScanPromise = null;
                }
            }, this);
            if (objRegisterForActivityResult == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objRegisterForActivityResult;
            cameraViewModule = cameraViewModule2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cameraViewModule = (CameraViewModule) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        cameraViewModule.documentScannerLauncher = (AppContextActivityResultLauncher) obj;
        return Unit.INSTANCE;
    }
}
