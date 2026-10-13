package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraBackends;
import androidx.camera.camera2.pipe.CameraContext;
import androidx.camera.camera2.pipe.CameraGraph;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class InternalCameraGraphModules_Companion_ProvideCameraBackendFactory implements Factory<CameraBackend> {
    private final Provider<CameraBackends> cameraBackendsProvider;
    private final Provider<CameraContext> cameraContextProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;

    private InternalCameraGraphModules_Companion_ProvideCameraBackendFactory(Provider<CameraBackends> provider, Provider<CameraGraph.Config> provider2, Provider<CameraContext> provider3) {
        this.cameraBackendsProvider = provider;
        this.graphConfigProvider = provider2;
        this.cameraContextProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraBackend get() {
        return provideCameraBackend(this.cameraBackendsProvider.get(), this.graphConfigProvider.get(), this.cameraContextProvider.get());
    }

    public static InternalCameraGraphModules_Companion_ProvideCameraBackendFactory create(Provider<CameraBackends> provider, Provider<CameraGraph.Config> provider2, Provider<CameraContext> provider3) {
        return new InternalCameraGraphModules_Companion_ProvideCameraBackendFactory(provider, provider2, provider3);
    }

    public static CameraBackend provideCameraBackend(CameraBackends cameraBackends, CameraGraph.Config config, CameraContext cameraContext) {
        return (CameraBackend) Preconditions.checkNotNullFromProvides(InternalCameraGraphModules.INSTANCE.provideCameraBackend(cameraBackends, config, cameraContext));
    }
}
