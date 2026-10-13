package androidx.camera.camera2.pipe.compat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompatFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2DeviceCache_Factory implements Factory<Camera2DeviceCache> {
    private final Provider<CameraDeviceSetupCompatFactory> cameraDeviceSetupCompatFactoryProvider;
    private final Provider<CameraErrorListener> cameraErrorListenerProvider;
    private final Provider<CameraManager> cameraManagerProvider;
    private final Provider<Job> cameraPipeJobProvider;
    private final Provider<CameraPipeLifetime> cameraPipeLifetimeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<PackageManager> packageManagerProvider;
    private final Provider<Threads> threadsProvider;

    private Camera2DeviceCache_Factory(Provider<CameraManager> provider, Provider<Threads> provider2, Provider<Context> provider3, Provider<PackageManager> provider4, Provider<CameraErrorListener> provider5, Provider<CameraDeviceSetupCompatFactory> provider6, Provider<CameraPipeLifetime> provider7, Provider<Job> provider8) {
        this.cameraManagerProvider = provider;
        this.threadsProvider = provider2;
        this.contextProvider = provider3;
        this.packageManagerProvider = provider4;
        this.cameraErrorListenerProvider = provider5;
        this.cameraDeviceSetupCompatFactoryProvider = provider6;
        this.cameraPipeLifetimeProvider = provider7;
        this.cameraPipeJobProvider = provider8;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2DeviceCache get() {
        return newInstance(this.cameraManagerProvider, this.threadsProvider.get(), this.contextProvider.get(), this.packageManagerProvider.get(), this.cameraErrorListenerProvider.get(), this.cameraDeviceSetupCompatFactoryProvider, this.cameraPipeLifetimeProvider.get(), this.cameraPipeJobProvider.get());
    }

    public static Camera2DeviceCache_Factory create(Provider<CameraManager> provider, Provider<Threads> provider2, Provider<Context> provider3, Provider<PackageManager> provider4, Provider<CameraErrorListener> provider5, Provider<CameraDeviceSetupCompatFactory> provider6, Provider<CameraPipeLifetime> provider7, Provider<Job> provider8) {
        return new Camera2DeviceCache_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static Camera2DeviceCache newInstance(javax.inject.Provider<CameraManager> provider, Threads threads, Context context, PackageManager packageManager, CameraErrorListener cameraErrorListener, javax.inject.Provider<CameraDeviceSetupCompatFactory> provider2, CameraPipeLifetime cameraPipeLifetime, Job job) {
        return new Camera2DeviceCache(provider, threads, context, packageManager, cameraErrorListener, provider2, cameraPipeLifetime, job);
    }
}
