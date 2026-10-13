package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import androidx.camera.camera2.pipe.graph.SurfaceGraph;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class SharedCameraGraphModules_Companion_ProvideSurfaceGraphFactory implements Factory<SurfaceGraph> {
    private final Provider<CameraController> cameraControllerProvider;
    private final Provider<CameraSurfaceManager> cameraSurfaceManagerProvider;
    private final Provider<StreamGraphImpl> streamGraphImplProvider;

    private SharedCameraGraphModules_Companion_ProvideSurfaceGraphFactory(Provider<StreamGraphImpl> provider, Provider<CameraController> provider2, Provider<CameraSurfaceManager> provider3) {
        this.streamGraphImplProvider = provider;
        this.cameraControllerProvider = provider2;
        this.cameraSurfaceManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SurfaceGraph get() {
        return provideSurfaceGraph(this.streamGraphImplProvider.get(), this.cameraControllerProvider, this.cameraSurfaceManagerProvider.get());
    }

    public static SharedCameraGraphModules_Companion_ProvideSurfaceGraphFactory create(Provider<StreamGraphImpl> provider, Provider<CameraController> provider2, Provider<CameraSurfaceManager> provider3) {
        return new SharedCameraGraphModules_Companion_ProvideSurfaceGraphFactory(provider, provider2, provider3);
    }

    public static SurfaceGraph provideSurfaceGraph(StreamGraphImpl streamGraphImpl, javax.inject.Provider<CameraController> provider, CameraSurfaceManager cameraSurfaceManager) {
        return (SurfaceGraph) Preconditions.checkNotNullFromProvides(SharedCameraGraphModules.INSTANCE.provideSurfaceGraph(streamGraphImpl, provider, cameraSurfaceManager));
    }
}
