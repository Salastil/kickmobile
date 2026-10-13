package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraAvailabilityMonitor_Factory implements Factory<Camera2CameraAvailabilityMonitor> {
    private final Provider<CameraManager> cameraManagerProvider;
    private final Provider<Job> cameraPipeJobProvider;
    private final Provider<Threads> threadsProvider;

    private Camera2CameraAvailabilityMonitor_Factory(Provider<CameraManager> provider, Provider<Threads> provider2, Provider<Job> provider3) {
        this.cameraManagerProvider = provider;
        this.threadsProvider = provider2;
        this.cameraPipeJobProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2CameraAvailabilityMonitor get() {
        return newInstance(this.cameraManagerProvider, this.threadsProvider.get(), this.cameraPipeJobProvider.get());
    }

    public static Camera2CameraAvailabilityMonitor_Factory create(Provider<CameraManager> provider, Provider<Threads> provider2, Provider<Job> provider3) {
        return new Camera2CameraAvailabilityMonitor_Factory(provider, provider2, provider3);
    }

    public static Camera2CameraAvailabilityMonitor newInstance(javax.inject.Provider<CameraManager> provider, Threads threads, Job job) {
        return new Camera2CameraAvailabilityMonitor(provider, threads, job);
    }
}
