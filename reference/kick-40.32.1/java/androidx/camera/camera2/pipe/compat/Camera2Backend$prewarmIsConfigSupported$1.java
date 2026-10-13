package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Camera2Backend.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2Backend$prewarmIsConfigSupported$1", f = "Camera2Backend.kt", i = {}, l = {99, 100}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class Camera2Backend$prewarmIsConfigSupported$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cameraId;
    int label;
    final /* synthetic */ Camera2Backend this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Camera2Backend$prewarmIsConfigSupported$1(Camera2Backend camera2Backend, String str, Continuation<? super Camera2Backend$prewarmIsConfigSupported$1> continuation) {
        super(2, continuation);
        this.this$0 = camera2Backend;
        this.$cameraId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Camera2Backend$prewarmIsConfigSupported$1(this.this$0, this.$cameraId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Camera2Backend$prewarmIsConfigSupported$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if (r5.this$0.camera2DeviceCache.m833getOrInitializeDeviceSetupWrapper0r8Bogc(r5.$cameraId, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L35
        L1e:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.camera.camera2.pipe.compat.Camera2Backend r6 = r5.this$0
            androidx.camera.camera2.pipe.compat.Camera2DeviceCache r6 = androidx.camera.camera2.pipe.compat.Camera2Backend.access$getCamera2DeviceCache$p(r6)
            java.lang.String r1 = r5.$cameraId
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = r6.m832getOrInitializeDeviceSetupCompat0r8Bogc(r1, r4)
            if (r6 != r0) goto L35
            goto L48
        L35:
            androidx.camera.camera2.pipe.compat.Camera2Backend r6 = r5.this$0
            androidx.camera.camera2.pipe.compat.Camera2DeviceCache r6 = androidx.camera.camera2.pipe.compat.Camera2Backend.access$getCamera2DeviceCache$p(r6)
            java.lang.String r1 = r5.$cameraId
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.label = r2
            java.lang.Object r5 = r6.m833getOrInitializeDeviceSetupWrapper0r8Bogc(r1, r3)
            if (r5 != r0) goto L49
        L48:
            return r0
        L49:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2Backend$prewarmIsConfigSupported$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
