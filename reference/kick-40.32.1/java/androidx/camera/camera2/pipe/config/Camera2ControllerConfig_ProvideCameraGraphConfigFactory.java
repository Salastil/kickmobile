package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraGraph;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ControllerConfig_ProvideCameraGraphConfigFactory implements Factory<CameraGraph.Config> {
    private final Camera2ControllerConfig module;

    private Camera2ControllerConfig_ProvideCameraGraphConfigFactory(Camera2ControllerConfig camera2ControllerConfig) {
        this.module = camera2ControllerConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraGraph.Config get() {
        return provideCameraGraphConfig(this.module);
    }

    public static Camera2ControllerConfig_ProvideCameraGraphConfigFactory create(Camera2ControllerConfig camera2ControllerConfig) {
        return new Camera2ControllerConfig_ProvideCameraGraphConfigFactory(camera2ControllerConfig);
    }

    public static CameraGraph.Config provideCameraGraphConfig(Camera2ControllerConfig camera2ControllerConfig) {
        return (CameraGraph.Config) Preconditions.checkNotNullFromProvides(camera2ControllerConfig.getGraphConfig());
    }
}
