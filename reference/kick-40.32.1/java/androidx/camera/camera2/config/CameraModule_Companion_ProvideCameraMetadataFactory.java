package androidx.camera.camera2.config;

import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraPipe;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraModule_Companion_ProvideCameraMetadataFactory implements Factory<CameraMetadata> {
    private final Provider<CameraPipe> cameraPipeProvider;
    private final Provider<CameraConfig> configProvider;

    private CameraModule_Companion_ProvideCameraMetadataFactory(Provider<CameraPipe> provider, Provider<CameraConfig> provider2) {
        this.cameraPipeProvider = provider;
        this.configProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraMetadata get() {
        return provideCameraMetadata(this.cameraPipeProvider.get(), this.configProvider.get());
    }

    public static CameraModule_Companion_ProvideCameraMetadataFactory create(Provider<CameraPipe> provider, Provider<CameraConfig> provider2) {
        return new CameraModule_Companion_ProvideCameraMetadataFactory(provider, provider2);
    }

    public static CameraMetadata provideCameraMetadata(CameraPipe cameraPipe, CameraConfig cameraConfig) {
        return CameraModule.INSTANCE.provideCameraMetadata(cameraPipe, cameraConfig);
    }
}
