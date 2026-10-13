package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2DeviceCloserImpl_Factory implements Factory<Camera2DeviceCloserImpl> {
    private final Provider<Camera2Quirks> camera2QuirksProvider;
    private final Provider<RetryingCameraStateOpener> retryingCameraStateOpenerProvider;
    private final Provider<Threads> threadsProvider;

    private Camera2DeviceCloserImpl_Factory(Provider<Threads> provider, Provider<Camera2Quirks> provider2, Provider<RetryingCameraStateOpener> provider3) {
        this.threadsProvider = provider;
        this.camera2QuirksProvider = provider2;
        this.retryingCameraStateOpenerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2DeviceCloserImpl get() {
        return newInstance(this.threadsProvider.get(), this.camera2QuirksProvider.get(), this.retryingCameraStateOpenerProvider.get());
    }

    public static Camera2DeviceCloserImpl_Factory create(Provider<Threads> provider, Provider<Camera2Quirks> provider2, Provider<RetryingCameraStateOpener> provider3) {
        return new Camera2DeviceCloserImpl_Factory(provider, provider2, provider3);
    }

    public static Camera2DeviceCloserImpl newInstance(Threads threads, Camera2Quirks camera2Quirks, RetryingCameraStateOpener retryingCameraStateOpener) {
        return new Camera2DeviceCloserImpl(threads, camera2Quirks, retryingCameraStateOpener);
    }
}
