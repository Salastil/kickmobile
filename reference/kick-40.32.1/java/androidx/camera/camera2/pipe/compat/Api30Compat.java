package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Api30Compat;", "", "<init>", "()V", "getConcurrentCameraIds", "", "", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "getCameraAudioRestriction", "", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "setCameraAudioRestriction", "", "mode", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Api30Compat {
    public static final Api30Compat INSTANCE = new Api30Compat();

    private Api30Compat() {
    }

    @JvmStatic
    public static final Set<Set<String>> getConcurrentCameraIds(CameraManager cameraManager) throws CameraAccessException {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Set<Set<String>> concurrentCameraIds = cameraManager.getConcurrentCameraIds();
        Intrinsics.checkNotNullExpressionValue(concurrentCameraIds, "getConcurrentCameraIds(...)");
        return concurrentCameraIds;
    }

    @JvmStatic
    public static final int getCameraAudioRestriction(CameraDevice cameraDevice) {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        return cameraDevice.getCameraAudioRestriction();
    }

    @JvmStatic
    public static final void setCameraAudioRestriction(CameraDevice cameraDevice, int mode) throws CameraAccessException {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        cameraDevice.setCameraAudioRestriction(mode);
    }
}
