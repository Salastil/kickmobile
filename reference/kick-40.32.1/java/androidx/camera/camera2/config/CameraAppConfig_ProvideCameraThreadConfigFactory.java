package androidx.camera.camera2.config;

import androidx.camera.core.impl.CameraThreadConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraAppConfig_ProvideCameraThreadConfigFactory implements Factory<CameraThreadConfig> {
    private final CameraAppConfig module;

    private CameraAppConfig_ProvideCameraThreadConfigFactory(CameraAppConfig cameraAppConfig) {
        this.module = cameraAppConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraThreadConfig get() {
        return provideCameraThreadConfig(this.module);
    }

    public static CameraAppConfig_ProvideCameraThreadConfigFactory create(CameraAppConfig cameraAppConfig) {
        return new CameraAppConfig_ProvideCameraThreadConfigFactory(cameraAppConfig);
    }

    public static CameraThreadConfig provideCameraThreadConfig(CameraAppConfig cameraAppConfig) {
        return (CameraThreadConfig) Preconditions.checkNotNullFromProvides(cameraAppConfig.getCameraThreadConfig());
    }
}
