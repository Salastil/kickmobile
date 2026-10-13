package androidx.camera.camera2.config;

import androidx.camera.core.CameraXConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraAppConfig_ProvideCameraXConfigFactory implements Factory<CameraXConfig> {
    private final CameraAppConfig module;

    private CameraAppConfig_ProvideCameraXConfigFactory(CameraAppConfig cameraAppConfig) {
        this.module = cameraAppConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraXConfig get() {
        return provideCameraXConfig(this.module);
    }

    public static CameraAppConfig_ProvideCameraXConfigFactory create(CameraAppConfig cameraAppConfig) {
        return new CameraAppConfig_ProvideCameraXConfigFactory(cameraAppConfig);
    }

    public static CameraXConfig provideCameraXConfig(CameraAppConfig cameraAppConfig) {
        return (CameraXConfig) Preconditions.checkNotNullFromProvides(cameraAppConfig.getCameraXConfig());
    }
}
