package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraBackend;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ControllerConfig_ProvideCameraBackendFactory implements Factory<CameraBackend> {
    private final Camera2ControllerConfig module;

    private Camera2ControllerConfig_ProvideCameraBackendFactory(Camera2ControllerConfig camera2ControllerConfig) {
        this.module = camera2ControllerConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraBackend get() {
        return provideCameraBackend(this.module);
    }

    public static Camera2ControllerConfig_ProvideCameraBackendFactory create(Camera2ControllerConfig camera2ControllerConfig) {
        return new Camera2ControllerConfig_ProvideCameraBackendFactory(camera2ControllerConfig);
    }

    public static CameraBackend provideCameraBackend(Camera2ControllerConfig camera2ControllerConfig) {
        return (CameraBackend) Preconditions.checkNotNullFromProvides(camera2ControllerConfig.getCameraBackend());
    }
}
