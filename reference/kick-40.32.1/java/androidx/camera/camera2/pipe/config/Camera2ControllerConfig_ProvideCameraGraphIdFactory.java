package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraGraphId;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ControllerConfig_ProvideCameraGraphIdFactory implements Factory<CameraGraphId> {
    private final Camera2ControllerConfig module;

    private Camera2ControllerConfig_ProvideCameraGraphIdFactory(Camera2ControllerConfig camera2ControllerConfig) {
        this.module = camera2ControllerConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraGraphId get() {
        return provideCameraGraphId(this.module);
    }

    public static Camera2ControllerConfig_ProvideCameraGraphIdFactory create(Camera2ControllerConfig camera2ControllerConfig) {
        return new Camera2ControllerConfig_ProvideCameraGraphIdFactory(camera2ControllerConfig);
    }

    public static CameraGraphId provideCameraGraphId(Camera2ControllerConfig camera2ControllerConfig) {
        return (CameraGraphId) Preconditions.checkNotNullFromProvides(camera2ControllerConfig.getGraphId());
    }
}
