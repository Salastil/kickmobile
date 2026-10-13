package androidx.camera.camera2.config;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraConfig_ProvideCameraConfigFactory implements Factory<CameraConfig> {
    private final CameraConfig module;

    private CameraConfig_ProvideCameraConfigFactory(CameraConfig cameraConfig) {
        this.module = cameraConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraConfig get() {
        return provideCameraConfig(this.module);
    }

    public static CameraConfig_ProvideCameraConfigFactory create(CameraConfig cameraConfig) {
        return new CameraConfig_ProvideCameraConfigFactory(cameraConfig);
    }

    public static CameraConfig provideCameraConfig(CameraConfig cameraConfig) {
        return (CameraConfig) Preconditions.checkNotNullFromProvides(cameraConfig.provideCameraConfig());
    }
}
