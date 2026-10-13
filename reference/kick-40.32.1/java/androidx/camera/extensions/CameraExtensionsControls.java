package androidx.camera.extensions;

import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.AdapterCameraControl;
import androidx.camera.core.impl.SessionProcessor;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
class CameraExtensionsControls {
    static CameraExtensionsControl from(CameraControl cameraControl) {
        Preconditions.checkArgument(cameraControl instanceof AdapterCameraControl, "The input camera control must be an instance retrieved from the camera that is returned by invoking CameraProvider#bindToLifecycle() with an extension enabled camera selector.");
        SessionProcessor sessionProcessor = ((AdapterCameraControl) cameraControl).getSessionProcessor();
        if (sessionProcessor instanceof CameraExtensionsControl) {
            return (CameraExtensionsControl) sessionProcessor;
        }
        return null;
    }

    private CameraExtensionsControls() {
    }
}
