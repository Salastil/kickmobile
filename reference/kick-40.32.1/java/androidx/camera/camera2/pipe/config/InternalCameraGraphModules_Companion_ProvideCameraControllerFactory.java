package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraContext;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.SurfaceTracker;
import androidx.camera.camera2.pipe.graph.GraphProcessorImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class InternalCameraGraphModules_Companion_ProvideCameraControllerFactory implements Factory<CameraController> {
    private final Provider<CameraBackend> cameraBackendProvider;
    private final Provider<CameraContext> cameraContextProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<CameraGraphId> graphIdProvider;
    private final Provider<GraphProcessorImpl> graphProcessorProvider;
    private final Provider<StreamGraph> streamGraphProvider;
    private final Provider<SurfaceTracker> surfaceTrackerProvider;

    private InternalCameraGraphModules_Companion_ProvideCameraControllerFactory(Provider<CameraGraphId> provider, Provider<CameraGraph.Config> provider2, Provider<CameraBackend> provider3, Provider<CameraContext> provider4, Provider<GraphProcessorImpl> provider5, Provider<StreamGraph> provider6, Provider<SurfaceTracker> provider7) {
        this.graphIdProvider = provider;
        this.graphConfigProvider = provider2;
        this.cameraBackendProvider = provider3;
        this.cameraContextProvider = provider4;
        this.graphProcessorProvider = provider5;
        this.streamGraphProvider = provider6;
        this.surfaceTrackerProvider = provider7;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraController get() {
        return provideCameraController(this.graphIdProvider.get(), this.graphConfigProvider.get(), this.cameraBackendProvider.get(), this.cameraContextProvider.get(), this.graphProcessorProvider.get(), this.streamGraphProvider.get(), this.surfaceTrackerProvider.get());
    }

    public static InternalCameraGraphModules_Companion_ProvideCameraControllerFactory create(Provider<CameraGraphId> provider, Provider<CameraGraph.Config> provider2, Provider<CameraBackend> provider3, Provider<CameraContext> provider4, Provider<GraphProcessorImpl> provider5, Provider<StreamGraph> provider6, Provider<SurfaceTracker> provider7) {
        return new InternalCameraGraphModules_Companion_ProvideCameraControllerFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CameraController provideCameraController(CameraGraphId cameraGraphId, CameraGraph.Config config, CameraBackend cameraBackend, CameraContext cameraContext, GraphProcessorImpl graphProcessorImpl, StreamGraph streamGraph, SurfaceTracker surfaceTracker) {
        return (CameraController) Preconditions.checkNotNullFromProvides(InternalCameraGraphModules.INSTANCE.provideCameraController(cameraGraphId, config, cameraBackend, cameraContext, graphProcessorImpl, streamGraph, surfaceTracker));
    }
}
