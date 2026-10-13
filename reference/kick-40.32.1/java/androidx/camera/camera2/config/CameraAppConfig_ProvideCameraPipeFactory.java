package androidx.camera.camera2.config;

import androidx.camera.camera2.pipe.CameraPipe;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraAppConfig_ProvideCameraPipeFactory implements Factory<CameraPipe> {
    private final CameraAppConfig module;

    private CameraAppConfig_ProvideCameraPipeFactory(CameraAppConfig cameraAppConfig) {
        this.module = cameraAppConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraPipe get() {
        return provideCameraPipe(this.module);
    }

    public static CameraAppConfig_ProvideCameraPipeFactory create(CameraAppConfig cameraAppConfig) {
        return new CameraAppConfig_ProvideCameraPipeFactory(cameraAppConfig);
    }

    public static CameraPipe provideCameraPipe(CameraAppConfig cameraAppConfig) {
        return (CameraPipe) Preconditions.checkNotNullFromProvides(cameraAppConfig.getCameraPipe());
    }
}
