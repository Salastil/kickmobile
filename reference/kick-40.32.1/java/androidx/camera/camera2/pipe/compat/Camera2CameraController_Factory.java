package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.SurfaceTracker;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import androidx.camera.camera2.pipe.internal.CameraStatusMonitor;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraController_Factory implements Factory<Camera2CameraController> {
    private final Provider<Camera2DeviceManager> camera2DeviceManagerProvider;
    private final Provider<Camera2Quirks> camera2QuirksProvider;
    private final Provider<CameraGraphId> cameraGraphIdProvider;
    private final Provider<CameraStatusMonitor> cameraStatusMonitorProvider;
    private final Provider<CameraSurfaceManager> cameraSurfaceManagerProvider;
    private final Provider<Camera2CaptureSequenceProcessorFactory> captureSequenceProcessorFactoryProvider;
    private final Provider<CaptureSessionFactory> captureSessionFactoryProvider;
    private final Provider<ConcurrentSessionSequencers> concurrentSessionSequencersProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<GraphListener> graphListenerProvider;
    private final Provider<CoroutineScope> scopeProvider;
    private final Provider<Camera2CameraController.ShutdownListener> shutdownListenerProvider;
    private final Provider<StreamGraphImpl> streamGraphProvider;
    private final Provider<StrictMode> strictModeProvider;
    private final Provider<SurfaceTracker> surfaceTrackerProvider;
    private final Provider<Threads> threadsProvider;
    private final Provider<TimeSource> timeSourceProvider;

    private Camera2CameraController_Factory(Provider<CoroutineScope> provider, Provider<Threads> provider2, Provider<StrictMode> provider3, Provider<CameraGraph.Config> provider4, Provider<GraphListener> provider5, Provider<SurfaceTracker> provider6, Provider<CameraStatusMonitor> provider7, Provider<CaptureSessionFactory> provider8, Provider<Camera2CaptureSequenceProcessorFactory> provider9, Provider<Camera2DeviceManager> provider10, Provider<CameraSurfaceManager> provider11, Provider<Camera2Quirks> provider12, Provider<TimeSource> provider13, Provider<CameraGraphId> provider14, Provider<Camera2CameraController.ShutdownListener> provider15, Provider<StreamGraphImpl> provider16, Provider<ConcurrentSessionSequencers> provider17) {
        this.scopeProvider = provider;
        this.threadsProvider = provider2;
        this.strictModeProvider = provider3;
        this.graphConfigProvider = provider4;
        this.graphListenerProvider = provider5;
        this.surfaceTrackerProvider = provider6;
        this.cameraStatusMonitorProvider = provider7;
        this.captureSessionFactoryProvider = provider8;
        this.captureSequenceProcessorFactoryProvider = provider9;
        this.camera2DeviceManagerProvider = provider10;
        this.cameraSurfaceManagerProvider = provider11;
        this.camera2QuirksProvider = provider12;
        this.timeSourceProvider = provider13;
        this.cameraGraphIdProvider = provider14;
        this.shutdownListenerProvider = provider15;
        this.streamGraphProvider = provider16;
        this.concurrentSessionSequencersProvider = provider17;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2CameraController get() {
        return newInstance(this.scopeProvider.get(), this.threadsProvider.get(), this.strictModeProvider.get(), this.graphConfigProvider.get(), this.graphListenerProvider.get(), this.surfaceTrackerProvider.get(), this.cameraStatusMonitorProvider.get(), this.captureSessionFactoryProvider.get(), this.captureSequenceProcessorFactoryProvider.get(), this.camera2DeviceManagerProvider.get(), this.cameraSurfaceManagerProvider.get(), this.camera2QuirksProvider.get(), this.timeSourceProvider.get(), this.cameraGraphIdProvider.get(), this.shutdownListenerProvider.get(), this.streamGraphProvider.get(), this.concurrentSessionSequencersProvider.get());
    }

    public static Camera2CameraController_Factory create(Provider<CoroutineScope> provider, Provider<Threads> provider2, Provider<StrictMode> provider3, Provider<CameraGraph.Config> provider4, Provider<GraphListener> provider5, Provider<SurfaceTracker> provider6, Provider<CameraStatusMonitor> provider7, Provider<CaptureSessionFactory> provider8, Provider<Camera2CaptureSequenceProcessorFactory> provider9, Provider<Camera2DeviceManager> provider10, Provider<CameraSurfaceManager> provider11, Provider<Camera2Quirks> provider12, Provider<TimeSource> provider13, Provider<CameraGraphId> provider14, Provider<Camera2CameraController.ShutdownListener> provider15, Provider<StreamGraphImpl> provider16, Provider<ConcurrentSessionSequencers> provider17) {
        return new Camera2CameraController_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public static Camera2CameraController newInstance(CoroutineScope coroutineScope, Threads threads, StrictMode strictMode, CameraGraph.Config config, GraphListener graphListener, SurfaceTracker surfaceTracker, CameraStatusMonitor cameraStatusMonitor, CaptureSessionFactory captureSessionFactory, Camera2CaptureSequenceProcessorFactory camera2CaptureSequenceProcessorFactory, Camera2DeviceManager camera2DeviceManager, CameraSurfaceManager cameraSurfaceManager, Camera2Quirks camera2Quirks, TimeSource timeSource, CameraGraphId cameraGraphId, Camera2CameraController.ShutdownListener shutdownListener, StreamGraphImpl streamGraphImpl, ConcurrentSessionSequencers concurrentSessionSequencers) {
        return new Camera2CameraController(coroutineScope, threads, strictMode, config, graphListener, surfaceTracker, cameraStatusMonitor, captureSessionFactory, camera2CaptureSequenceProcessorFactory, camera2DeviceManager, cameraSurfaceManager, camera2Quirks, timeSource, cameraGraphId, shutdownListener, streamGraphImpl, concurrentSessionSequencers);
    }
}
