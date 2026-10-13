package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirtualCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraStateOpen;", "Landroidx/camera/camera2/pipe/compat/CameraState;", "cameraDevice", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;)V", "getCameraDevice", "()Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CameraStateOpen extends CameraState {
    private final CameraDeviceWrapper cameraDevice;

    public static /* synthetic */ CameraStateOpen copy$default(CameraStateOpen cameraStateOpen, CameraDeviceWrapper cameraDeviceWrapper, int i, Object obj) {
        if ((i & 1) != 0) {
            cameraDeviceWrapper = cameraStateOpen.cameraDevice;
        }
        return cameraStateOpen.copy(cameraDeviceWrapper);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CameraDeviceWrapper getCameraDevice() {
        return this.cameraDevice;
    }

    public final CameraStateOpen copy(CameraDeviceWrapper cameraDevice) {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        return new CameraStateOpen(cameraDevice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CameraStateOpen) && Intrinsics.areEqual(this.cameraDevice, ((CameraStateOpen) other).cameraDevice);
    }

    public int hashCode() {
        return this.cameraDevice.hashCode();
    }

    public String toString() {
        return "CameraStateOpen(cameraDevice=" + this.cameraDevice + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateOpen(CameraDeviceWrapper cameraDevice) {
        super(null);
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        this.cameraDevice = cameraDevice;
    }

    public final CameraDeviceWrapper getCameraDevice() {
        return this.cameraDevice;
    }
}
