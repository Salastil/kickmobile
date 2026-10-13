package androidx.camera.camera2.pipe;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CameraDevices.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"find", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/camera/camera2/pipe/CameraMetadata;", "Landroidx/camera/camera2/pipe/CameraDevices;", "cameraBackendId", "Landroidx/camera/camera2/pipe/CameraBackendId;", "includePhysicalCameraMetadata", "", "find-Ohbb9yk", "(Landroidx/camera/camera2/pipe/CameraDevices;Ljava/lang/String;Z)Lkotlinx/coroutines/flow/Flow;", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CameraDevicesKt {
    /* JADX INFO: renamed from: find-Ohbb9yk$default, reason: not valid java name */
    public static /* synthetic */ Flow m350findOhbb9yk$default(CameraDevices cameraDevices, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return m349findOhbb9yk(cameraDevices, str, z);
    }

    /* JADX INFO: renamed from: find-Ohbb9yk, reason: not valid java name */
    public static final Flow<CameraMetadata> m349findOhbb9yk(CameraDevices find, String str, boolean z) {
        Intrinsics.checkNotNullParameter(find, "$this$find");
        return FlowKt.flow(new CameraDevicesKt$find$1(find, str, z, null));
    }
}
