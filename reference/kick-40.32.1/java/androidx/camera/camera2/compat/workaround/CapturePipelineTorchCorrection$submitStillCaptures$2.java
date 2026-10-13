package androidx.camera.camera2.compat.workaround;

import com.swmansion.gesturehandler.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: CapturePipelineTorchCorrection.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$2", f = "CapturePipelineTorchCorrection.kt", i = {}, l = {86, BuildConfig.REACT_NATIVE_MINOR_VERSION, 89}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CapturePipelineTorchCorrection$submitStillCaptures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Deferred<Void>> $deferredResults;
    int label;
    final /* synthetic */ CapturePipelineTorchCorrection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CapturePipelineTorchCorrection$submitStillCaptures$2(List<? extends Deferred<Void>> list, CapturePipelineTorchCorrection capturePipelineTorchCorrection, Continuation<? super CapturePipelineTorchCorrection$submitStillCaptures$2> continuation) {
        super(2, continuation);
        this.$deferredResults = list;
        this.this$0 = capturePipelineTorchCorrection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CapturePipelineTorchCorrection$submitStillCaptures$2(this.$deferredResults, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CapturePipelineTorchCorrection$submitStillCaptures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0089, code lost:
    
        if (androidx.camera.camera2.impl.TorchControl.m120setTorchAsyncOup_wC0$camera_camera2$default(r11.this$0.torchControl, androidx.camera.camera2.impl.TorchControl.TorchMode.INSTANCE.m134getUSED_AS_FLASHIRs_R8(), false, false, 6, null).join(r11) == r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            java.lang.String r2 = "CXCP"
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L28
            if (r1 == r5) goto L24
            if (r1 == r4) goto L20
            if (r1 != r3) goto L18
            kotlin.ResultKt.throwOnFailure(r12)
            goto L8c
        L18:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L20:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L6c
        L24:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L3b
        L28:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.List<kotlinx.coroutines.Deferred<java.lang.Void>> r12 = r11.$deferredResults
            java.util.Collection r12 = (java.util.Collection) r12
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.label = r5
            java.lang.Object r12 = kotlinx.coroutines.AwaitKt.joinAll(r12, r1)
            if (r12 != r0) goto L3b
            goto L8b
        L3b:
            androidx.camera.camera2.impl.Camera2Logger r12 = androidx.camera.camera2.impl.Camera2Logger.INSTANCE
            boolean r12 = androidx.camera.core.Logger.isDebugEnabled(r2)
            if (r12 == 0) goto L4c
            java.lang.String r12 = androidx.camera.camera2.impl.Camera2Logger.access$getTRUNCATED_TAG$p()
            java.lang.String r1 = "Re-enable Torch to correct the Torch state"
            android.util.Log.d(r12, r1)
        L4c:
            androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection r12 = r11.this$0
            androidx.camera.camera2.impl.TorchControl r5 = androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection.access$getTorchControl$p(r12)
            androidx.camera.camera2.impl.TorchControl$TorchMode$Companion r12 = androidx.camera.camera2.impl.TorchControl.TorchMode.INSTANCE
            int r6 = r12.m132getOFFIRs_R8()
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.Deferred r12 = androidx.camera.camera2.impl.TorchControl.m120setTorchAsyncOup_wC0$camera_camera2$default(r5, r6, r7, r8, r9, r10)
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.label = r4
            java.lang.Object r12 = r12.join(r1)
            if (r12 != r0) goto L6c
            goto L8b
        L6c:
            androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection r12 = r11.this$0
            androidx.camera.camera2.impl.TorchControl r4 = androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection.access$getTorchControl$p(r12)
            androidx.camera.camera2.impl.TorchControl$TorchMode$Companion r12 = androidx.camera.camera2.impl.TorchControl.TorchMode.INSTANCE
            int r5 = r12.m134getUSED_AS_FLASHIRs_R8()
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.Deferred r12 = androidx.camera.camera2.impl.TorchControl.m120setTorchAsyncOup_wC0$camera_camera2$default(r4, r5, r6, r7, r8, r9)
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.label = r3
            java.lang.Object r11 = r12.join(r1)
            if (r11 != r0) goto L8c
        L8b:
            return r0
        L8c:
            androidx.camera.camera2.impl.Camera2Logger r11 = androidx.camera.camera2.impl.Camera2Logger.INSTANCE
            boolean r11 = androidx.camera.core.Logger.isDebugEnabled(r2)
            if (r11 == 0) goto L9d
            java.lang.String r11 = androidx.camera.camera2.impl.Camera2Logger.access$getTRUNCATED_TAG$p()
            java.lang.String r12 = "Re-enable Torch to correct the Torch state, done"
            android.util.Log.d(r11, r12)
        L9d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
