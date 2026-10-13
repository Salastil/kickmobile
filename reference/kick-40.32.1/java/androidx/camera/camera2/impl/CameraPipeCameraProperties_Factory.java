package androidx.camera.camera2.impl;

import androidx.camera.camera2.config.CameraConfig;
import androidx.camera.camera2.pipe.CameraMetadata;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeCameraProperties_Factory implements Factory<CameraPipeCameraProperties> {
    private final Provider<CameraConfig> cameraConfigProvider;
    private final Provider<CameraMetadata> cameraMetadataProvider;

    private CameraPipeCameraProperties_Factory(Provider<CameraConfig> provider, Provider<CameraMetadata> provider2) {
        this.cameraConfigProvider = provider;
        this.cameraMetadataProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraPipeCameraProperties get() {
        return newInstance(this.cameraConfigProvider.get(), this.cameraMetadataProvider.get());
    }

    public static CameraPipeCameraProperties_Factory create(Provider<CameraConfig> provider, Provider<CameraMetadata> provider2) {
        return new CameraPipeCameraProperties_Factory(provider, provider2);
    }

    public static CameraPipeCameraProperties newInstance(CameraConfig cameraConfig, CameraMetadata cameraMetadata) {
        return new CameraPipeCameraProperties(cameraConfig, cameraMetadata);
    }
}
