package androidx.camera.extensions;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
class CameraExtensionsInfos {
    private static final CameraExtensionsInfo NORMAL_MODE_CAMERA_EXTENSIONS_INFO = new CameraExtensionsInfo() { // from class: androidx.camera.extensions.CameraExtensionsInfos.1
    };

    static CameraExtensionsInfo from(CameraInfo cameraInfo) {
        Preconditions.checkArgument(cameraInfo instanceof AdapterCameraInfo, "The input camera info must be an instance retrieved from the camera that is returned by invoking CameraProvider#bindToLifecycle() with an extension enabled camera selector.");
        SessionProcessor sessionProcessor = ((AdapterCameraInfo) cameraInfo).getSessionProcessor();
        if (sessionProcessor instanceof CameraExtensionsInfo) {
            return (CameraExtensionsInfo) sessionProcessor;
        }
        return NORMAL_MODE_CAMERA_EXTENSIONS_INFO;
    }

    private CameraExtensionsInfos() {
    }
}
