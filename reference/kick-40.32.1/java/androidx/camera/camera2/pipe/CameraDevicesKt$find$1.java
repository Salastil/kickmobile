package androidx.camera.camera2.pipe;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CameraDevices.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/camera/camera2/pipe/CameraMetadata;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.CameraDevicesKt$find$1", f = "CameraDevices.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4}, l = {197, 203, 206, 215, 221}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "visited", "emitted", "$this$flow", "visited", "emitted", "$this$flow", "visited", "physicalId", "$this$flow", "visited"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$4", "L$0", "L$1"}, v = 1)
final class CameraDevicesKt$find$1 extends SuspendLambda implements Function2<FlowCollector<? super CameraMetadata>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cameraBackendId;
    final /* synthetic */ boolean $includePhysicalCameraMetadata;
    final /* synthetic */ CameraDevices $this_find;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraDevicesKt$find$1(CameraDevices cameraDevices, String str, boolean z, Continuation<? super CameraDevicesKt$find$1> continuation) {
        super(2, continuation);
        this.$this_find = cameraDevices;
        this.$cameraBackendId = str;
        this.$includePhysicalCameraMetadata = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CameraDevicesKt$find$1 cameraDevicesKt$find$1 = new CameraDevicesKt$find$1(this.$this_find, this.$cameraBackendId, this.$includePhysicalCameraMetadata, continuation);
        cameraDevicesKt$find$1.L$0 = obj;
        return cameraDevicesKt$find$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CameraMetadata> flowCollector, Continuation<? super Unit> continuation) {
        return ((CameraDevicesKt$find$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:34:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:? A[LOOP:1: B:24:0x00bc->B:71:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00f5 -> B:37:0x010f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x010b -> B:37:0x010f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0120 -> B:44:0x012e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0195 -> B:44:0x012e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.CameraDevicesKt$find$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
