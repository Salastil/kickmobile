package androidx.camera.camera2.pipe.config;

import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraStatusMonitor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ControllerModule_Companion_ProvideCameraStatusMonitorFactory implements Factory<CameraStatusMonitor> {
    private final Provider<CameraManager> cameraManagerProvider;
    private final Provider<Job> cameraPipeJobProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<Threads> threadsProvider;

    private Camera2ControllerModule_Companion_ProvideCameraStatusMonitorFactory(Provider<CameraManager> provider, Provider<Threads> provider2, Provider<CameraGraph.Config> provider3, Provider<Job> provider4) {
        this.cameraManagerProvider = provider;
        this.threadsProvider = provider2;
        this.graphConfigProvider = provider3;
        this.cameraPipeJobProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraStatusMonitor get() {
        return provideCameraStatusMonitor(this.cameraManagerProvider, this.threadsProvider.get(), this.graphConfigProvider.get(), this.cameraPipeJobProvider.get());
    }

    public static Camera2ControllerModule_Companion_ProvideCameraStatusMonitorFactory create(Provider<CameraManager> provider, Provider<Threads> provider2, Provider<CameraGraph.Config> provider3, Provider<Job> provider4) {
        return new Camera2ControllerModule_Companion_ProvideCameraStatusMonitorFactory(provider, provider2, provider3, provider4);
    }

    public static CameraStatusMonitor provideCameraStatusMonitor(javax.inject.Provider<CameraManager> provider, Threads threads, CameraGraph.Config config, Job job) {
        return (CameraStatusMonitor) Preconditions.checkNotNullFromProvides(Camera2ControllerModule.INSTANCE.provideCameraStatusMonitor(provider, threads, config, job));
    }
}
