package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraOpener_Factory implements Factory<Camera2CameraOpener> {
    private final Provider<CameraManager> cameraManagerProvider;
    private final Provider<Threads> threadsProvider;

    private Camera2CameraOpener_Factory(Provider<CameraManager> provider, Provider<Threads> provider2) {
        this.cameraManagerProvider = provider;
        this.threadsProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2CameraOpener get() {
        return newInstance(this.cameraManagerProvider, this.threadsProvider.get());
    }

    public static Camera2CameraOpener_Factory create(Provider<CameraManager> provider, Provider<Threads> provider2) {
        return new Camera2CameraOpener_Factory(provider, provider2);
    }

    public static Camera2CameraOpener newInstance(javax.inject.Provider<CameraManager> provider, Threads threads) {
        return new Camera2CameraOpener(provider, threads);
    }
}
