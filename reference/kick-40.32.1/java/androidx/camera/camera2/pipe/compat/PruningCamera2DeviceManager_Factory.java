package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.core.Permissions;
import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class PruningCamera2DeviceManager_Factory implements Factory<PruningCamera2DeviceManager> {
    private final Provider<Camera2DeviceCloser> camera2DeviceCloserProvider;
    private final Provider<Camera2ErrorProcessor> camera2ErrorProcessorProvider;
    private final Provider<Permissions> permissionsProvider;
    private final Provider<RetryingCameraStateOpener> retryingCameraStateOpenerProvider;
    private final Provider<Threads> threadsProvider;

    private PruningCamera2DeviceManager_Factory(Provider<Permissions> provider, Provider<RetryingCameraStateOpener> provider2, Provider<Camera2DeviceCloser> provider3, Provider<Camera2ErrorProcessor> provider4, Provider<Threads> provider5) {
        this.permissionsProvider = provider;
        this.retryingCameraStateOpenerProvider = provider2;
        this.camera2DeviceCloserProvider = provider3;
        this.camera2ErrorProcessorProvider = provider4;
        this.threadsProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PruningCamera2DeviceManager get() {
        return newInstance(this.permissionsProvider.get(), this.retryingCameraStateOpenerProvider.get(), this.camera2DeviceCloserProvider.get(), this.camera2ErrorProcessorProvider.get(), this.threadsProvider.get());
    }

    public static PruningCamera2DeviceManager_Factory create(Provider<Permissions> provider, Provider<RetryingCameraStateOpener> provider2, Provider<Camera2DeviceCloser> provider3, Provider<Camera2ErrorProcessor> provider4, Provider<Threads> provider5) {
        return new PruningCamera2DeviceManager_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PruningCamera2DeviceManager newInstance(Permissions permissions, RetryingCameraStateOpener retryingCameraStateOpener, Camera2DeviceCloser camera2DeviceCloser, Camera2ErrorProcessor camera2ErrorProcessor, Threads threads) {
        return new PruningCamera2DeviceManager(permissions, retryingCameraStateOpener, camera2DeviceCloser, camera2ErrorProcessor, threads);
    }
}
