package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/camera/camera2/pipe/compat/OpenCameraResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2", f = "RetryingCameraStateOpener.kt", i = {0, 0, 0, 0, 0}, l = {670}, m = "invokeSuspend", n = {"$this$supervisorScope", "cameraOpenDeferred", "resultDeferred", "timeoutJob", "cameraOpenCancelJob"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
final class CameraStateOpener$tryOpenCamera$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OpenCameraResult>, Object> {
    final /* synthetic */ String $cameraId;
    final /* synthetic */ AndroidCameraState $cameraState;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ CameraStateOpener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraStateOpener$tryOpenCamera$2(CameraStateOpener cameraStateOpener, String str, AndroidCameraState androidCameraState, Continuation<? super CameraStateOpener$tryOpenCamera$2> continuation) {
        super(2, continuation);
        this.this$0 = cameraStateOpener;
        this.$cameraId = str;
        this.$cameraState = androidCameraState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CameraStateOpener$tryOpenCamera$2 cameraStateOpener$tryOpenCamera$2 = new CameraStateOpener$tryOpenCamera$2(this.this$0, this.$cameraId, this.$cameraState, continuation);
        cameraStateOpener$tryOpenCamera$2.L$0 = obj;
        return cameraStateOpener$tryOpenCamera$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OpenCameraResult> continuation) {
        return ((CameraStateOpener$tryOpenCamera$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00a5 A[Catch: all -> 0x0027, TRY_ENTER, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x00bb A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x00cf A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00e3 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00f7 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0117 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x011c A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0124 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x013e A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0149 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0154 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x015d A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x0118, B:15:0x00a5, B:17:0x00bb, B:18:0x00c9, B:20:0x00cf, B:21:0x00dd, B:23:0x00e3, B:24:0x00f1, B:26:0x00f7, B:27:0x0105, B:32:0x011c, B:34:0x0124, B:35:0x0138, B:37:0x013e, B:38:0x0143, B:40:0x0149, B:41:0x014e, B:43:0x0154, B:44:0x0157, B:46:0x015d), top: B:54:0x0022 }] */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, kotlinx.coroutines.Deferred] */
    /* JADX WARN: Type inference failed for: r6v10, types: [T, kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, kotlinx.coroutines.Deferred] */
    /* JADX WARN: Type inference failed for: r6v7, types: [T, kotlinx.coroutines.Job] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0115 -> B:30:0x0118). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:32:0x011c
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
