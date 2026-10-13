package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraMetadata;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class InternalCameraGraphModules_Companion_ProvideCameraMetadataFactory implements Factory<CameraMetadata> {
    private final Provider<CameraBackend> cameraBackendProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;

    private InternalCameraGraphModules_Companion_ProvideCameraMetadataFactory(Provider<CameraGraph.Config> provider, Provider<CameraBackend> provider2) {
        this.graphConfigProvider = provider;
        this.cameraBackendProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraMetadata get() {
        return provideCameraMetadata(this.graphConfigProvider.get(), this.cameraBackendProvider.get());
    }

    public static InternalCameraGraphModules_Companion_ProvideCameraMetadataFactory create(Provider<CameraGraph.Config> provider, Provider<CameraBackend> provider2) {
        return new InternalCameraGraphModules_Companion_ProvideCameraMetadataFactory(provider, provider2);
    }

    public static CameraMetadata provideCameraMetadata(CameraGraph.Config config, CameraBackend cameraBackend) {
        return (CameraMetadata) Preconditions.checkNotNullFromProvides(InternalCameraGraphModules.INSTANCE.provideCameraMetadata(config, cameraBackend));
    }
}
