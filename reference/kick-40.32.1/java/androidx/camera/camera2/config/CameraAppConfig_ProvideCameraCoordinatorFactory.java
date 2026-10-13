package androidx.camera.camera2.config;

import androidx.camera.core.concurrent.CameraCoordinator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraAppConfig_ProvideCameraCoordinatorFactory implements Factory<CameraCoordinator> {
    private final CameraAppConfig module;

    private CameraAppConfig_ProvideCameraCoordinatorFactory(CameraAppConfig cameraAppConfig) {
        this.module = cameraAppConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraCoordinator get() {
        return provideCameraCoordinator(this.module);
    }

    public static CameraAppConfig_ProvideCameraCoordinatorFactory create(CameraAppConfig cameraAppConfig) {
        return new CameraAppConfig_ProvideCameraCoordinatorFactory(cameraAppConfig);
    }

    public static CameraCoordinator provideCameraCoordinator(CameraAppConfig cameraAppConfig) {
        return (CameraCoordinator) Preconditions.checkNotNullFromProvides(cameraAppConfig.getCameraCoordinator());
    }
}
